package com.facebook.imagepipeline.animated.impl;

import android.app.ActivityManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import androidx.collection.SparseArrayCompat;
import bolts.Continuation;
import bolts.Task;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoaderConfigure;
import com.facebook.common.executors.SerialExecutorService;
import com.facebook.common.logging.FLog;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.ResourceReleaser;
import com.facebook.common.time.MonotonicClock;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableCachingBackend;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableOptions;
import com.facebook.imagepipeline.animated.base.DelegatingAnimatedDrawableBackend;
import com.facebook.imagepipeline.animated.util.AnimatedDrawableUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class AnimatedDrawableCachingBackendImpl extends DelegatingAnimatedDrawableBackend implements AnimatedDrawableCachingBackend {
    private static final int PREFETCH_FRAMES = 3;
    private static final Class<?> TAG = AnimatedDrawableCachingBackendImpl.class;
    private static final AtomicInteger sTotalBitmaps = new AtomicInteger();
    private final ActivityManager mActivityManager;
    private final AnimatedDrawableBackend mAnimatedDrawableBackend;
    private final AnimatedDrawableOptions mAnimatedDrawableOptions;
    private final AnimatedDrawableUtil mAnimatedDrawableUtil;
    private final AnimatedImageCompositor mAnimatedImageCompositor;
    private final double mApproxKiloBytesToHoldAllFrames;
    private final WhatToKeepCachedArray mBitmapsToKeepCached;
    private final SparseArrayCompat<CloseableReference<Bitmap>> mCachedBitmaps;
    private int mCurrentFrameIndex;
    private final SparseArrayCompat<Task<Object>> mDecodesInFlight;
    private final SerialExecutorService mExecutorService;
    private final List<Bitmap> mFreeBitmaps;
    private final double mMaximumKiloBytes;
    private final MonotonicClock mMonotonicClock;
    private final ResourceReleaser<Bitmap> mResourceReleaserForBitmaps;

    public AnimatedDrawableCachingBackendImpl(SerialExecutorService serialExecutorService, ActivityManager activityManager, AnimatedDrawableUtil animatedDrawableUtil, MonotonicClock monotonicClock, AnimatedDrawableBackend animatedDrawableBackend, AnimatedDrawableOptions animatedDrawableOptions) {
        super(animatedDrawableBackend);
        this.mExecutorService = serialExecutorService;
        this.mActivityManager = activityManager;
        this.mAnimatedDrawableUtil = animatedDrawableUtil;
        this.mMonotonicClock = monotonicClock;
        this.mAnimatedDrawableBackend = animatedDrawableBackend;
        this.mAnimatedDrawableOptions = animatedDrawableOptions;
        this.mMaximumKiloBytes = (animatedDrawableOptions.maximumBytes >= 0 ? animatedDrawableOptions.maximumBytes : getDefaultMaxBytes(activityManager)) / 1024;
        this.mAnimatedImageCompositor = new AnimatedImageCompositor(animatedDrawableBackend, new AnimatedImageCompositor.Callback() { // from class: com.facebook.imagepipeline.animated.impl.AnimatedDrawableCachingBackendImpl.1
            @Override // com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.Callback
            public void onIntermediateResult(int i, Bitmap bitmap) {
                AnimatedDrawableCachingBackendImpl.this.maybeCacheBitmapDuringRender(i, bitmap);
            }

            @Override // com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.Callback
            public CloseableReference<Bitmap> getCachedBitmap(int i) {
                return AnimatedDrawableCachingBackendImpl.this.getCachedOrPredecodedFrame(i);
            }
        });
        this.mResourceReleaserForBitmaps = new ResourceReleaser<Bitmap>() { // from class: com.facebook.imagepipeline.animated.impl.AnimatedDrawableCachingBackendImpl.2
            @Override // com.facebook.common.references.ResourceReleaser
            public void release(Bitmap bitmap) {
                AnimatedDrawableCachingBackendImpl.this.releaseBitmapInternal(bitmap);
            }
        };
        this.mFreeBitmaps = new ArrayList();
        this.mDecodesInFlight = new SparseArrayCompat<>(10);
        this.mCachedBitmaps = new SparseArrayCompat<>(10);
        this.mBitmapsToKeepCached = new WhatToKeepCachedArray(animatedDrawableBackend.getFrameCount());
        this.mApproxKiloBytesToHoldAllFrames = ((animatedDrawableBackend.getRenderedWidth() * animatedDrawableBackend.getRenderedHeight()) / 1024) * animatedDrawableBackend.getFrameCount() * 4;
    }

    protected synchronized void finalize() throws Throwable {
        super.finalize();
        if (this.mCachedBitmaps.size() > 0) {
            FLog.d(TAG, "Finalizing with rendered bitmaps");
        }
        sTotalBitmaps.addAndGet(-this.mFreeBitmaps.size());
        this.mFreeBitmaps.clear();
    }

    private Bitmap createNewBitmap() {
        Class<?> cls = TAG;
        FLog.v(cls, "Creating new bitmap");
        AtomicInteger atomicInteger = sTotalBitmaps;
        atomicInteger.incrementAndGet();
        FLog.v(cls, "Total bitmaps: %d", Integer.valueOf(atomicInteger.get()));
        return Bitmap.createBitmap(this.mAnimatedDrawableBackend.getRenderedWidth(), this.mAnimatedDrawableBackend.getRenderedHeight(), Bitmap.Config.ARGB_8888);
    }

    @Override // com.facebook.imagepipeline.animated.base.DelegatingAnimatedDrawableBackend, com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public void renderFrame(int i, Canvas canvas) {
        throw new IllegalStateException();
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableCachingBackend
    public CloseableReference<Bitmap> getBitmapForFrame(int i) throws Throwable {
        this.mCurrentFrameIndex = i;
        CloseableReference<Bitmap> bitmapForFrameInternal = getBitmapForFrameInternal(i, false);
        schedulePrefetches();
        return bitmapForFrameInternal;
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableCachingBackend
    public CloseableReference<Bitmap> getPreviewBitmap() {
        return getAnimatedImageResult().getPreviewBitmap();
    }

    CloseableReference<Bitmap> getBitmapForFrameBlocking(int i) throws Throwable {
        this.mCurrentFrameIndex = i;
        CloseableReference<Bitmap> bitmapForFrameInternal = getBitmapForFrameInternal(i, true);
        schedulePrefetches();
        return bitmapForFrameInternal;
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public AnimatedDrawableCachingBackend forNewBounds(Rect rect) {
        AnimatedDrawableBackend animatedDrawableBackendForNewBounds = this.mAnimatedDrawableBackend.forNewBounds(rect);
        return animatedDrawableBackendForNewBounds == this.mAnimatedDrawableBackend ? this : new AnimatedDrawableCachingBackendImpl(this.mExecutorService, this.mActivityManager, this.mAnimatedDrawableUtil, this.mMonotonicClock, animatedDrawableBackendForNewBounds, this.mAnimatedDrawableOptions);
    }

    @Override // com.facebook.imagepipeline.animated.base.DelegatingAnimatedDrawableBackend, com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public synchronized void dropCaches() {
        this.mBitmapsToKeepCached.setAll(false);
        dropBitmapsThatShouldNotBeCached();
        Iterator<Bitmap> it = this.mFreeBitmaps.iterator();
        while (it.hasNext()) {
            it.next().recycle();
            sTotalBitmaps.decrementAndGet();
        }
        this.mFreeBitmaps.clear();
        this.mAnimatedDrawableBackend.dropCaches();
        FLog.v(TAG, "Total bitmaps: %d", Integer.valueOf(sTotalBitmaps.get()));
    }

    @Override // com.facebook.imagepipeline.animated.base.DelegatingAnimatedDrawableBackend, com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public int getMemoryUsage() {
        int sizeOfBitmap;
        synchronized (this) {
            Iterator<Bitmap> it = this.mFreeBitmaps.iterator();
            sizeOfBitmap = 0;
            while (it.hasNext()) {
                sizeOfBitmap += this.mAnimatedDrawableUtil.getSizeOfBitmap(it.next());
            }
            for (int i = 0; i < this.mCachedBitmaps.size(); i++) {
                sizeOfBitmap += this.mAnimatedDrawableUtil.getSizeOfBitmap(this.mCachedBitmaps.valueAt(i).get());
            }
        }
        return sizeOfBitmap + this.mAnimatedDrawableBackend.getMemoryUsage();
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableCachingBackend
    public void appendDebugOptionString(StringBuilder sb) {
        if (this.mAnimatedDrawableOptions.forceKeepAllFramesInMemory) {
            sb.append("Pinned To Memory");
        } else {
            if (this.mApproxKiloBytesToHoldAllFrames < this.mMaximumKiloBytes) {
                sb.append("within ");
            } else {
                sb.append("exceeds ");
            }
            this.mAnimatedDrawableUtil.appendMemoryString(sb, (int) this.mMaximumKiloBytes);
        }
        if (shouldKeepAllFramesInMemory() && this.mAnimatedDrawableOptions.allowPrefetching) {
            sb.append(" MT");
        }
    }

    private CloseableReference<Bitmap> getBitmapForFrameInternal(int i, boolean z) throws Throwable {
        long jNow = this.mMonotonicClock.now();
        boolean z2 = false;
        try {
            synchronized (this) {
                this.mBitmapsToKeepCached.set(i, true);
                CloseableReference<Bitmap> cachedOrPredecodedFrame = getCachedOrPredecodedFrame(i);
                if (cachedOrPredecodedFrame != null) {
                    long jNow2 = this.mMonotonicClock.now() - jNow;
                    if (jNow2 > 10) {
                        FLog.v(TAG, "obtainBitmap for frame %d took %d ms (%s)", Integer.valueOf(i), Long.valueOf(jNow2), "ok");
                    }
                    return cachedOrPredecodedFrame;
                }
                if (!z) {
                    long jNow3 = this.mMonotonicClock.now() - jNow;
                    if (jNow3 <= 10) {
                        return null;
                    }
                    FLog.v(TAG, "obtainBitmap for frame %d took %d ms (%s)", Integer.valueOf(i), Long.valueOf(jNow3), "deferred");
                    return null;
                }
                try {
                    CloseableReference<Bitmap> closeableReferenceObtainBitmapInternal = obtainBitmapInternal();
                    try {
                        this.mAnimatedImageCompositor.renderFrame(i, closeableReferenceObtainBitmapInternal.get());
                        maybeCacheRenderedBitmap(i, closeableReferenceObtainBitmapInternal);
                        CloseableReference<Bitmap> closeableReferenceM777clone = closeableReferenceObtainBitmapInternal.m777clone();
                        closeableReferenceObtainBitmapInternal.close();
                        long jNow4 = this.mMonotonicClock.now() - jNow;
                        if (jNow4 > 10) {
                            FLog.v(TAG, "obtainBitmap for frame %d took %d ms (%s)", Integer.valueOf(i), Long.valueOf(jNow4), "renderedOnCallingThread");
                        }
                        return closeableReferenceM777clone;
                    } catch (Throwable th) {
                        closeableReferenceObtainBitmapInternal.close();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    z2 = true;
                    long jNow5 = this.mMonotonicClock.now() - jNow;
                    if (jNow5 > 10) {
                        FLog.v(TAG, "obtainBitmap for frame %d took %d ms (%s)", Integer.valueOf(i), Long.valueOf(jNow5), !z2 ? "ok" : "renderedOnCallingThread");
                    }
                    throw th;
                }
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void maybeCacheBitmapDuringRender(int i, Bitmap bitmap) {
        boolean z;
        synchronized (this) {
            z = false;
            if (this.mBitmapsToKeepCached.get(i) && this.mCachedBitmaps.get(i) == null) {
                z = true;
            }
        }
        if (z) {
            copyAndCacheBitmapDuringRendering(i, bitmap);
        }
    }

    private void copyAndCacheBitmapDuringRendering(int i, Bitmap bitmap) {
        CloseableReference<Bitmap> closeableReferenceObtainBitmapInternal = obtainBitmapInternal();
        try {
            Canvas canvas = new Canvas(closeableReferenceObtainBitmapInternal.get());
            canvas.drawColor(0, PorterDuff.Mode.SRC);
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
            maybeCacheRenderedBitmap(i, closeableReferenceObtainBitmapInternal);
        } finally {
            closeableReferenceObtainBitmapInternal.close();
        }
    }

    private CloseableReference<Bitmap> obtainBitmapInternal() {
        Bitmap bitmapRemove;
        synchronized (this) {
            long jNanoTime = System.nanoTime();
            long jConvert = TimeUnit.NANOSECONDS.convert(20L, TimeUnit.MILLISECONDS) + jNanoTime;
            while (this.mFreeBitmaps.isEmpty() && jNanoTime < jConvert) {
                try {
                    TimeUnit.NANOSECONDS.timedWait(this, jConvert - jNanoTime);
                    jNanoTime = System.nanoTime();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException(e);
                }
            }
            if (this.mFreeBitmaps.isEmpty()) {
                bitmapRemove = createNewBitmap();
            } else {
                List<Bitmap> list = this.mFreeBitmaps;
                bitmapRemove = list.remove(list.size() - 1);
            }
        }
        return CloseableReference.of(bitmapRemove, this.mResourceReleaserForBitmaps);
    }

    synchronized void releaseBitmapInternal(Bitmap bitmap) {
        this.mFreeBitmaps.add(bitmap);
    }

    private synchronized void schedulePrefetches() {
        int i = this.mAnimatedDrawableBackend.getFrameInfo(this.mCurrentFrameIndex).disposalMethod == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_PREVIOUS ? 1 : 0;
        int iMax = Math.max(0, this.mCurrentFrameIndex - i);
        int iMax2 = Math.max(this.mAnimatedDrawableOptions.allowPrefetching ? 3 : 0, i);
        int frameCount = (iMax + iMax2) % this.mAnimatedDrawableBackend.getFrameCount();
        cancelFuturesOutsideOfRange(iMax, frameCount);
        if (!shouldKeepAllFramesInMemory()) {
            this.mBitmapsToKeepCached.setAll(true);
            this.mBitmapsToKeepCached.removeOutsideRange(iMax, frameCount);
            for (int i2 = iMax; i2 >= 0; i2--) {
                if (this.mCachedBitmaps.get(i2) != null) {
                    this.mBitmapsToKeepCached.set(i2, true);
                    break;
                }
            }
            dropBitmapsThatShouldNotBeCached();
        }
        if (this.mAnimatedDrawableOptions.allowPrefetching) {
            doPrefetch(iMax, iMax2);
        } else {
            int i3 = this.mCurrentFrameIndex;
            cancelFuturesOutsideOfRange(i3, i3);
        }
    }

    private static int getDefaultMaxBytes(ActivityManager activityManager) {
        if (activityManager.getMemoryClass() > 32) {
            return AVMDLDataLoaderConfigure.DEFAULT_MAX_FACTORY_MEMORY_SIZE;
        }
        return 3145728;
    }

    private boolean shouldKeepAllFramesInMemory() {
        return this.mAnimatedDrawableOptions.forceKeepAllFramesInMemory || this.mApproxKiloBytesToHoldAllFrames < this.mMaximumKiloBytes;
    }

    private synchronized void doPrefetch(int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            final int frameCount = (i + i3) % this.mAnimatedDrawableBackend.getFrameCount();
            boolean zHasCachedOrPredecodedFrame = hasCachedOrPredecodedFrame(frameCount);
            Task<Object> task = this.mDecodesInFlight.get(frameCount);
            if (!zHasCachedOrPredecodedFrame && task == null) {
                final Task<Object> taskCall = Task.call(new Callable<Object>() { // from class: com.facebook.imagepipeline.animated.impl.AnimatedDrawableCachingBackendImpl.3
                    @Override // java.util.concurrent.Callable
                    public Object call() {
                        AnimatedDrawableCachingBackendImpl.this.runPrefetch(frameCount);
                        return null;
                    }
                }, this.mExecutorService);
                this.mDecodesInFlight.put(frameCount, taskCall);
                taskCall.continueWith(new Continuation<Object, Object>() { // from class: com.facebook.imagepipeline.animated.impl.AnimatedDrawableCachingBackendImpl.4
                    @Override // bolts.Continuation
                    public Object then(Task<Object> task2) throws Exception {
                        AnimatedDrawableCachingBackendImpl.this.onFutureFinished(taskCall, frameCount);
                        return null;
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runPrefetch(int i) {
        synchronized (this) {
            if (this.mBitmapsToKeepCached.get(i)) {
                if (hasCachedOrPredecodedFrame(i)) {
                    return;
                }
                CloseableReference<Bitmap> preDecodedFrame = this.mAnimatedDrawableBackend.getPreDecodedFrame(i);
                try {
                    if (preDecodedFrame != null) {
                        maybeCacheRenderedBitmap(i, preDecodedFrame);
                    } else {
                        CloseableReference<Bitmap> closeableReferenceObtainBitmapInternal = obtainBitmapInternal();
                        try {
                            this.mAnimatedImageCompositor.renderFrame(i, closeableReferenceObtainBitmapInternal.get());
                            maybeCacheRenderedBitmap(i, closeableReferenceObtainBitmapInternal);
                            FLog.v(TAG, "Prefetch rendered frame %d", Integer.valueOf(i));
                            closeableReferenceObtainBitmapInternal.close();
                        } catch (Throwable th) {
                            closeableReferenceObtainBitmapInternal.close();
                            throw th;
                        }
                    }
                    CloseableReference.closeSafely(preDecodedFrame);
                } catch (Throwable th2) {
                    CloseableReference.closeSafely(preDecodedFrame);
                    throw th2;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void onFutureFinished(Task<?> task, int i) {
        int iIndexOfKey = this.mDecodesInFlight.indexOfKey(i);
        if (iIndexOfKey >= 0 && ((Task) this.mDecodesInFlight.valueAt(iIndexOfKey)) == task) {
            this.mDecodesInFlight.removeAt(iIndexOfKey);
            if (task.getError() != null) {
                FLog.v(TAG, task.getError(), "Failed to render frame %d", Integer.valueOf(i));
            }
        }
    }

    private synchronized void cancelFuturesOutsideOfRange(int i, int i2) {
        int i3 = 0;
        while (i3 < this.mDecodesInFlight.size()) {
            if (AnimatedDrawableUtil.isOutsideRange(i, i2, this.mDecodesInFlight.keyAt(i3))) {
                this.mDecodesInFlight.valueAt(i3);
                this.mDecodesInFlight.removeAt(i3);
            } else {
                i3++;
            }
        }
    }

    private synchronized void dropBitmapsThatShouldNotBeCached() {
        int i = 0;
        while (i < this.mCachedBitmaps.size()) {
            if (this.mBitmapsToKeepCached.get(this.mCachedBitmaps.keyAt(i))) {
                i++;
            } else {
                CloseableReference<Bitmap> closeableReferenceValueAt = this.mCachedBitmaps.valueAt(i);
                this.mCachedBitmaps.removeAt(i);
                closeableReferenceValueAt.close();
            }
        }
    }

    private synchronized void maybeCacheRenderedBitmap(int i, CloseableReference<Bitmap> closeableReference) {
        if (this.mBitmapsToKeepCached.get(i)) {
            int iIndexOfKey = this.mCachedBitmaps.indexOfKey(i);
            if (iIndexOfKey >= 0) {
                this.mCachedBitmaps.valueAt(iIndexOfKey).close();
                this.mCachedBitmaps.removeAt(iIndexOfKey);
            }
            this.mCachedBitmaps.put(i, closeableReference.m777clone());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized CloseableReference<Bitmap> getCachedOrPredecodedFrame(int i) {
        CloseableReference<Bitmap> closeableReferenceCloneOrNull;
        closeableReferenceCloneOrNull = CloseableReference.cloneOrNull(this.mCachedBitmaps.get(i));
        if (closeableReferenceCloneOrNull == null) {
            closeableReferenceCloneOrNull = this.mAnimatedDrawableBackend.getPreDecodedFrame(i);
        }
        return closeableReferenceCloneOrNull;
    }

    private synchronized boolean hasCachedOrPredecodedFrame(int i) {
        return this.mCachedBitmaps.get(i) != null || this.mAnimatedDrawableBackend.hasPreDecodedFrame(i);
    }

    synchronized Map<Integer, Task<?>> getDecodesInFlight() {
        HashMap map;
        map = new HashMap();
        for (int i = 0; i < this.mDecodesInFlight.size(); i++) {
            map.put(Integer.valueOf(this.mDecodesInFlight.keyAt(i)), this.mDecodesInFlight.valueAt(i));
        }
        return map;
    }

    synchronized Set<Integer> getFramesCached() {
        HashSet hashSet;
        hashSet = new HashSet();
        for (int i = 0; i < this.mCachedBitmaps.size(); i++) {
            hashSet.add(Integer.valueOf(this.mCachedBitmaps.keyAt(i)));
        }
        return hashSet;
    }
}
