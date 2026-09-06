package com.meishu.sdk.core.view.gif;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import androidx.appcompat.widget.AppCompatImageView;
import com.meishu.sdk.core.safe.l;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class GifImageView extends AppCompatImageView implements Runnable {
    private static final String TAG = "GifDecoderView";
    private boolean animating;
    private OnAnimationStart animationStartCallback;
    private OnAnimationStop animationStopCallback;
    private Thread animationThread;
    private boolean canClear;
    private final Runnable cleanupRunnable;
    private OnFrameAvailable frameCallback;
    private long framesDisplayDuration;
    private GifDecoder gifDecoder;
    private final Handler handler;
    private boolean renderFrame;
    private boolean shouldClear;
    private Bitmap tmpBitmap;
    private final Runnable updateResults;

    public interface OnAnimationStart {
        void onAnimationStart();
    }

    public interface OnAnimationStop {
        void onAnimationStop();
    }

    public interface OnFrameAvailable {
        Bitmap onFrameAvailable(Bitmap bitmap);
    }

    public GifImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.handler = new Handler(Looper.getMainLooper());
        this.frameCallback = null;
        this.framesDisplayDuration = -1L;
        this.animationStopCallback = null;
        this.animationStartCallback = null;
        this.updateResults = new l() { // from class: com.meishu.sdk.core.view.gif.GifImageView.1
            @Override // com.meishu.sdk.core.safe.l
            public void safeRun() {
                if (GifImageView.this.tmpBitmap == null || GifImageView.this.tmpBitmap.isRecycled()) {
                    return;
                }
                GifImageView gifImageView = GifImageView.this;
                gifImageView.setImageBitmap(gifImageView.tmpBitmap);
            }
        };
        this.cleanupRunnable = new l() { // from class: com.meishu.sdk.core.view.gif.GifImageView.2
            @Override // com.meishu.sdk.core.safe.l
            public void safeRun() {
                GifImageView.this.tmpBitmap = null;
                GifImageView.this.gifDecoder = null;
                GifImageView.this.animationThread = null;
                GifImageView.this.shouldClear = false;
            }
        };
        this.canClear = true;
    }

    private boolean canStart() {
        return (this.animating || this.renderFrame) && this.gifDecoder != null && this.animationThread == null;
    }

    private void startAnimationThread() {
        if (canStart()) {
            Thread thread = new Thread(this);
            this.animationThread = thread;
            thread.start();
        }
    }

    public int getFrameCount() {
        return this.gifDecoder.getFrameCount();
    }

    public long getFramesDisplayDuration() {
        return this.framesDisplayDuration;
    }

    public int getGifHeight() {
        return this.gifDecoder.getHeight();
    }

    public int getGifWidth() {
        return this.gifDecoder.getWidth();
    }

    public OnAnimationStop getOnAnimationStop() {
        return this.animationStopCallback;
    }

    public OnFrameAvailable getOnFrameAvailable() {
        return this.frameCallback;
    }

    public void gotoFrame(int i) {
        if (this.gifDecoder.getCurrentFrameIndex() == i || !this.gifDecoder.setFrameIndex(i - 1) || this.animating) {
            return;
        }
        this.renderFrame = true;
        startAnimationThread();
    }

    public boolean isAnimating() {
        return this.animating;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.canClear) {
            clear();
        }
    }

    public void resetAnimation() {
        this.gifDecoder.resetLoopIndex();
        gotoFrame(0);
    }

    public void setBytes(byte[] bArr) {
        try {
            GifDecoder gifDecoder = new GifDecoder();
            this.gifDecoder = gifDecoder;
            try {
                gifDecoder.read(4, bArr);
                if (this.animating) {
                    startAnimationThread();
                } else {
                    gotoFrame(0);
                }
            } catch (Throwable unused) {
                this.gifDecoder = null;
            }
        } catch (Throwable unused2) {
        }
    }

    public void setCanClear(boolean z) {
        this.canClear = z;
    }

    public void setFramesDisplayDuration(long j) {
        this.framesDisplayDuration = j;
    }

    public void setOnAnimationStart(OnAnimationStart onAnimationStart) {
        this.animationStartCallback = onAnimationStart;
    }

    public void setOnAnimationStop(OnAnimationStop onAnimationStop) {
        this.animationStopCallback = onAnimationStop;
    }

    public void setOnFrameAvailable(OnFrameAvailable onFrameAvailable) {
        this.frameCallback = onFrameAvailable;
    }

    @Override // java.lang.Runnable
    public void run() {
        long jNanoTime;
        try {
            OnAnimationStart onAnimationStart = this.animationStartCallback;
            if (onAnimationStart != null) {
                onAnimationStart.onAnimationStart();
            }
            do {
                if (!this.animating && !this.renderFrame) {
                    break;
                }
                boolean zAdvance = this.gifDecoder.advance();
                try {
                    long jNanoTime2 = System.nanoTime();
                    Bitmap nextFrame = this.gifDecoder.getNextFrame();
                    this.tmpBitmap = nextFrame;
                    OnFrameAvailable onFrameAvailable = this.frameCallback;
                    if (onFrameAvailable != null) {
                        this.tmpBitmap = onFrameAvailable.onFrameAvailable(nextFrame);
                    }
                    jNanoTime = (System.nanoTime() - jNanoTime2) / 1000000;
                    try {
                        this.handler.post(this.updateResults);
                    } catch (Throwable th) {
                        th = th;
                        Log.w(TAG, th);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    jNanoTime = 0;
                }
                this.renderFrame = false;
                if (!this.animating || !zAdvance) {
                    this.animating = false;
                    break;
                }
                try {
                    int nextDelay = (int) (((long) this.gifDecoder.getNextDelay()) - jNanoTime);
                    if (nextDelay > 0) {
                        long j = this.framesDisplayDuration;
                        if (j <= 0) {
                            j = nextDelay;
                        }
                        Thread.sleep(j);
                    }
                } catch (Exception unused) {
                }
            } while (this.animating);
            if (this.shouldClear) {
                this.handler.post(this.cleanupRunnable);
            }
            this.animationThread = null;
            OnAnimationStop onAnimationStop = this.animationStopCallback;
            if (onAnimationStop != null) {
                onAnimationStop.onAnimationStop();
            }
        } catch (Throwable th3) {
            th3.printStackTrace();
        }
    }

    public void startAnimation() {
        this.animating = true;
        startAnimationThread();
    }

    public void clear() {
        this.animating = false;
        this.renderFrame = false;
        this.shouldClear = true;
        stopAnimation();
        this.handler.post(this.cleanupRunnable);
    }

    public void stopAnimation() {
        this.animating = false;
        Thread thread = this.animationThread;
        if (thread != null) {
            thread.interrupt();
            this.animationThread = null;
        }
    }

    public void setBytes(byte[] bArr, int i) {
        try {
            GifDecoder gifDecoder = new GifDecoder();
            this.gifDecoder = gifDecoder;
            try {
                gifDecoder.read(i, bArr);
                if (this.animating) {
                    startAnimationThread();
                } else {
                    gotoFrame(0);
                }
            } catch (Throwable unused) {
                this.gifDecoder = null;
            }
        } catch (Throwable unused2) {
        }
    }

    public GifImageView(Context context) {
        super(context);
        this.handler = new Handler(Looper.getMainLooper());
        this.frameCallback = null;
        this.framesDisplayDuration = -1L;
        this.animationStopCallback = null;
        this.animationStartCallback = null;
        this.updateResults = new l() { // from class: com.meishu.sdk.core.view.gif.GifImageView.1
            @Override // com.meishu.sdk.core.safe.l
            public void safeRun() {
                if (GifImageView.this.tmpBitmap == null || GifImageView.this.tmpBitmap.isRecycled()) {
                    return;
                }
                GifImageView gifImageView = GifImageView.this;
                gifImageView.setImageBitmap(gifImageView.tmpBitmap);
            }
        };
        this.cleanupRunnable = new l() { // from class: com.meishu.sdk.core.view.gif.GifImageView.2
            @Override // com.meishu.sdk.core.safe.l
            public void safeRun() {
                GifImageView.this.tmpBitmap = null;
                GifImageView.this.gifDecoder = null;
                GifImageView.this.animationThread = null;
                GifImageView.this.shouldClear = false;
            }
        };
        this.canClear = true;
    }
}
