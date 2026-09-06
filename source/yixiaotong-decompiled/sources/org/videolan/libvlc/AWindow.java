package org.videolan.libvlc;

import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import ijiami_1011.s.s.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import org.videolan.libvlc.util.AndroidUtil;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class AWindow implements IVLCVout {
    private static final int AWINDOW_REGISTER_ERROR = 0;
    private static final int AWINDOW_REGISTER_FLAGS_HAS_VIDEO_LAYOUT_LISTENER = 2;
    private static final int AWINDOW_REGISTER_FLAGS_SUCCESS = 1;
    private static final int ID_MAX = 2;
    private static final int ID_SUBTITLES = 1;
    private static final int ID_VIDEO = 0;
    private static final int SURFACE_STATE_ATTACHED = 1;
    private static final int SURFACE_STATE_INIT = 0;
    private static final int SURFACE_STATE_READY = 2;
    private static final String TAG = s.d(new byte[]{39, 53, 92, 10, 0, 87, Ascii.SYN}, "fb5dd8");
    private final NativeLock mNativeLock;
    private SurfaceCallback mSurfaceCallback;
    private final SurfaceHelper[] mSurfaceHelpers;
    private SurfaceTextureThread mSurfaceTextureThread;
    private final Surface[] mSurfaces;
    private final AtomicInteger mSurfacesState = new AtomicInteger(0);
    private IVLCVout.OnNewVideoLayoutListener mOnNewVideoLayoutListener = null;
    private ArrayList<IVLCVout.Callback> mIVLCVoutCallbacks = new ArrayList<>();
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private long mCallbackNativeHandle = 0;
    private int mMouseAction = -1;
    private int mMouseButton = -1;
    private int mMouseX = -1;
    private int mMouseY = -1;
    private int mWindowWidth = -1;
    private int mWindowHeight = -1;

    public class NamelessClass_1 implements SurfaceHolder.Callback {
        private SurfaceHelper surfaceHelper;

        public NamelessClass_1(SurfaceHelper surfaceHelper) {
            this.surfaceHelper = surfaceHelper;
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            if (surfaceHolder != this.surfaceHelper.mSurfaceHolder) {
                Log.e(s.d(new byte[]{121, 101, 10, 90, 85, 89, Ascii.SYN}, "82c416"), s.d(new byte[]{Ascii.NAK, 69, SignedBytes.MAX_POWER_OF_TWO, 86, 7, 85, 4, 39, Ascii.DC4, 7, 80, 17, 3, 84, 8, 16, 47, 90, 13, 1, 1, 3, 93, 54, Ascii.DC2, 81, 70, 85, 35, 78, 2, 1, Ascii.SYN, Ascii.SYN, 88, 10, 8, 10, Ascii.DC2, 88, 9, 90, 5, 1, Ascii.DC4, 17, 17, 4, Ascii.DC4, 85, Ascii.DC2, 84, 15, 80, 7, 1, Ascii.DC4, 7, 95, 17}, "f020f6"));
            } else {
                this.surfaceHelper.setSurface(surfaceHolder.getSurface());
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            Log.d(s.d(new byte[]{116, 101, 92, 91, 84, 14, Ascii.SYN}, "52550a"), s.d(new byte[]{75, Ascii.DC4, SignedBytes.MAX_POWER_OF_TWO, 4, 85, 0, 4, 32, 3, 17, 69, Ascii.ETB, 87, Ascii.CAN, 87, 6, Ascii.DC4, 0, 0, 8, 10, 7, 85}, "8a2b4c"));
            AWindow.this.onSurfaceDestroyed();
        }
    }

    public static class NativeLock {
        private boolean buffersGeometryAbort;
        private boolean buffersGeometryConfigured;

        private NativeLock() {
            this.buffersGeometryConfigured = false;
            this.buffersGeometryAbort = false;
        }
    }

    public interface SurfaceCallback {
        void onSurfacesCreated(AWindow aWindow);

        void onSurfacesDestroyed(AWindow aWindow);
    }

    public class SurfaceHelper {
        private final int mId;
        private Surface mSurface;
        private final SurfaceHolder mSurfaceHolder;
        private final SurfaceHolder.Callback mSurfaceHolderCallback;
        private final TextureView.SurfaceTextureListener mSurfaceTextureListener;
        private final SurfaceView mSurfaceView;
        private final TextureView mTextureView;

        private SurfaceHelper(int i, Surface surface, SurfaceHolder surfaceHolder) {
            this.mSurfaceHolderCallback = AWindow.this.new NamelessClass_1(this);
            this.mSurfaceTextureListener = createSurfaceTextureListener();
            this.mId = i;
            this.mSurfaceView = null;
            this.mTextureView = null;
            this.mSurfaceHolder = surfaceHolder;
            this.mSurface = surface;
        }

        private SurfaceHelper(int i, SurfaceView surfaceView) {
            this.mSurfaceHolderCallback = AWindow.this.new NamelessClass_1(this);
            this.mSurfaceTextureListener = createSurfaceTextureListener();
            this.mId = i;
            this.mTextureView = null;
            this.mSurfaceView = surfaceView;
            this.mSurfaceHolder = surfaceView.getHolder();
        }

        private SurfaceHelper(int i, TextureView textureView) {
            this.mSurfaceHolderCallback = AWindow.this.new NamelessClass_1(this);
            this.mSurfaceTextureListener = createSurfaceTextureListener();
            this.mId = i;
            this.mSurfaceView = null;
            this.mSurfaceHolder = null;
            this.mTextureView = textureView;
        }

        private void attachSurface() {
            SurfaceHolder surfaceHolder = this.mSurfaceHolder;
            if (surfaceHolder != null) {
                surfaceHolder.addCallback(this.mSurfaceHolderCallback);
            }
            setSurface(this.mSurface);
        }

        private void attachSurfaceView() {
            this.mSurfaceHolder.addCallback(this.mSurfaceHolderCallback);
            setSurface(this.mSurfaceHolder.getSurface());
        }

        private void attachTextureView() {
            this.mTextureView.setSurfaceTextureListener(this.mSurfaceTextureListener);
            setSurface(new Surface(this.mTextureView.getSurfaceTexture()));
        }

        private TextureView.SurfaceTextureListener createSurfaceTextureListener() {
            return new TextureView.SurfaceTextureListener() { // from class: org.videolan.libvlc.AWindow.SurfaceHelper.1
                @Override // android.view.TextureView.SurfaceTextureListener
                public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                    SurfaceHelper.this.setSurface(new Surface(surfaceTexture));
                }

                @Override // android.view.TextureView.SurfaceTextureListener
                public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                    AWindow.this.onSurfaceDestroyed();
                    return true;
                }

                @Override // android.view.TextureView.SurfaceTextureListener
                public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
                }

                @Override // android.view.TextureView.SurfaceTextureListener
                public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
                }
            };
        }

        private void releaseTextureView() {
            TextureView textureView = this.mTextureView;
            if (textureView != null) {
                textureView.setSurfaceTextureListener(null);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSurface(Surface surface) {
            if (surface.isValid() && AWindow.this.getNativeSurface(this.mId) == null) {
                this.mSurface = surface;
                AWindow.this.setNativeSurface(this.mId, surface);
                AWindow.this.onSurfaceCreated();
            }
        }

        public void attach() {
            if (this.mSurfaceView != null) {
                attachSurfaceView();
                return;
            }
            if (this.mTextureView != null) {
                attachTextureView();
            } else if (this.mSurface == null) {
                Log.e(s.d(new byte[]{35, 110, 94, 11, 5, 93, Ascii.SYN}, "b97ea2"), s.d(new byte[]{80, Ascii.DC2, Ascii.DC2, 86, 5, 80, 91, 68, 47, 14, 93, 0, 86, 7, 10, 100, Ascii.DC2, 89, Ascii.NAK, 1, 35, 26, 82, 0, 65, Ascii.DC2, 15, 88, 8, 2, 65, 11, 4, 8, 84, 6, 69, 70, 15, 68, 70, 86, Ascii.DC4, 8, 10}, "1ff7f8"));
            } else {
                attachSurface();
            }
        }

        public Surface getSurface() {
            return this.mSurface;
        }

        public SurfaceHolder getSurfaceHolder() {
            return this.mSurfaceHolder;
        }

        public boolean isReady() {
            return this.mSurfaceView == null || this.mSurface != null;
        }

        public void release() {
            this.mSurface = null;
            AWindow.this.setNativeSurface(this.mId, null);
            SurfaceHolder surfaceHolder = this.mSurfaceHolder;
            if (surfaceHolder != null) {
                surfaceHolder.removeCallback(this.mSurfaceHolderCallback);
            }
            releaseTextureView();
        }
    }

    public static class SurfaceTextureThread implements Runnable, SurfaceTexture.OnFrameAvailableListener {
        private boolean mDoRelease;
        private boolean mFrameAvailable;
        private boolean mIsAttached;
        private Looper mLooper;
        private Surface mSurface;
        private SurfaceTexture mSurfaceTexture;
        private Thread mThread;

        private SurfaceTextureThread() {
            this.mSurfaceTexture = null;
            this.mSurface = null;
            this.mFrameAvailable = false;
            this.mLooper = null;
            this.mThread = null;
            this.mIsAttached = false;
            this.mDoRelease = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized boolean attachToGLContext(int i) {
            if (this.mSurfaceTexture == null) {
                Thread thread = new Thread(this);
                this.mThread = thread;
                thread.start();
                while (this.mSurfaceTexture == null) {
                    try {
                        wait();
                    } catch (InterruptedException unused) {
                        return false;
                    }
                }
                this.mSurface = new Surface(this.mSurfaceTexture);
            }
            this.mSurfaceTexture.attachToGLContext(i);
            this.mFrameAvailable = false;
            this.mIsAttached = true;
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized void detachFromGLContext() {
            if (this.mDoRelease) {
                this.mLooper.quit();
                this.mLooper = null;
                try {
                    this.mThread.join();
                } catch (InterruptedException unused) {
                }
                this.mThread = null;
                Surface surface = this.mSurface;
                if (surface != null) {
                    surface.release();
                    this.mSurface = null;
                }
                SurfaceTexture surfaceTexture = this.mSurfaceTexture;
                if (surfaceTexture != null) {
                    surfaceTexture.release();
                    this.mSurfaceTexture = null;
                }
                this.mDoRelease = false;
            } else {
                this.mSurfaceTexture.detachFromGLContext();
            }
            this.mIsAttached = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized Surface getSurface() {
            return this.mSurface;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized void release() {
            if (this.mSurfaceTexture != null) {
                if (this.mIsAttached) {
                    this.mDoRelease = true;
                } else {
                    Surface surface = this.mSurface;
                    if (surface != null) {
                        surface.release();
                        this.mSurface = null;
                    }
                    this.mSurfaceTexture.release();
                    this.mSurfaceTexture = null;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean waitAndUpdateTexImage(float[] fArr) {
            synchronized (this) {
                while (!this.mFrameAvailable) {
                    try {
                        wait(500L);
                        if (!this.mFrameAvailable) {
                            return false;
                        }
                    } catch (InterruptedException unused) {
                    }
                }
                this.mFrameAvailable = false;
                this.mSurfaceTexture.updateTexImage();
                this.mSurfaceTexture.getTransformMatrix(fArr);
                return true;
            }
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public synchronized void onFrameAvailable(SurfaceTexture surfaceTexture) {
            if (surfaceTexture == this.mSurfaceTexture) {
                if (this.mFrameAvailable) {
                    Log.e(s.d(new byte[]{39, 99, 12, 93, 81, 14, Ascii.SYN}, "f4e35a"), s.d(new byte[]{94, 91, 36, 19, 3, 94, 4, 37, 16, 3, 88, 9, 80, 87, 14, 4, 88, 19, 40, 8, 10, 7, 86, 4, 93, 102, Ascii.SYN, 0, Ascii.SYN, 86, 36, Ascii.FS, 5, 7, 65, 17, 88, 90, 12, 91, 66, 114, 15, 68, 7, Ascii.DC4, 80, 12, 93, 84, 0, 13, 7, 19, 7, Ascii.SYN, 7, 15, 84, 69, 70, 84, 17, 65, 12, 92, Ascii.NAK, 68, 19, Ascii.DC2, 85, 4, 69, 80, 6}, "15bab3"));
                } else {
                    this.mFrameAvailable = true;
                    notify();
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Looper.prepare();
            synchronized (this) {
                this.mLooper = Looper.myLooper();
                SurfaceTexture surfaceTexture = new SurfaceTexture(0);
                this.mSurfaceTexture = surfaceTexture;
                surfaceTexture.detachFromGLContext();
                this.mSurfaceTexture.setOnFrameAvailableListener(this);
                notify();
            }
            Looper.loop();
        }
    }

    public AWindow(SurfaceCallback surfaceCallback) {
        this.mSurfaceCallback = null;
        this.mSurfaceTextureThread = AndroidUtil.isJellyBeanOrLater ? new SurfaceTextureThread() : null;
        this.mNativeLock = new NativeLock();
        this.mSurfaceCallback = surfaceCallback;
        this.mSurfaceHelpers = new SurfaceHelper[]{null, null};
        this.mSurfaces = new Surface[]{null, null};
    }

    private void SurfaceTexture_detachFromGLContext() {
        this.mSurfaceTextureThread.detachFromGLContext();
    }

    private Surface SurfaceTexture_getSurface() {
        return this.mSurfaceTextureThread.getSurface();
    }

    private boolean SurfaceTexture_waitAndUpdateTexImage(float[] fArr) {
        return this.mSurfaceTextureThread.waitAndUpdateTexImage(fArr);
    }

    private void ensureInitState() {
        if (this.mSurfacesState.get() != 0) {
            Log.e(TAG, s.d(new byte[]{4, 86, 69, 71, 75, 7, 40, 10, 15, Ascii.SYN, 98, 17, 0, 76, 83, 8, Ascii.EM, 43, 13, 8, 3, 5, 80, 9, 50, 76, 87, 70, 92, 39, Ascii.EM, 7, 3, Ascii.DC2, 69, 12, 14, 86, 12, Ascii.DC2, 74, Ascii.SYN, 0, 16, 3, 66, 88, Ascii.SYN, 65, 79, 68, 93, 87, 5}, "a8629b"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Surface getNativeSurface(int i) {
        Surface surface;
        synchronized (this.mNativeLock) {
            surface = this.mSurfaces[i];
        }
        return surface;
    }

    private Surface getSubtitlesSurface() {
        return getNativeSurface(1);
    }

    private Surface getVideoSurface() {
        return getNativeSurface(0);
    }

    private static native void nativeOnMouseEvent(long j, int i, int i2, int i3, int i4);

    private static native void nativeOnWindowSize(long j, int i, int i2);

    /* JADX INFO: Access modifiers changed from: private */
    public void onSurfaceCreated() {
        String str;
        String strD;
        if (this.mSurfacesState.get() != 1) {
            str = TAG;
            strD = s.d(new byte[]{9, 13, 100, 16, SignedBytes.MAX_POWER_OF_TWO, 83, 0, 7, 3, 33, 67, 0, 7, Ascii.ETB, 82, 1, 8, Ascii.NAK, 40, 8, 10, 7, 86, 4, 10, 34, 69, 2, 71, 88, 4, 10, Ascii.DC2, 39, 73, 6, 3, 19, 67, 12, 93, 91, 91, 68, 15, 12, 71, 4, 10, 10, 83, 69, 65, 65, 0, 16, 3}, "fc7e25");
        } else {
            SurfaceHelper[] surfaceHelperArr = this.mSurfaceHelpers;
            SurfaceHelper surfaceHelper = surfaceHelperArr[0];
            SurfaceHelper surfaceHelper2 = surfaceHelperArr[1];
            if (surfaceHelper != null) {
                if (surfaceHelper.isReady()) {
                    if (surfaceHelper2 == null || surfaceHelper2.isReady()) {
                        this.mSurfacesState.set(2);
                        synchronized (this.mIVLCVoutCallbacks) {
                            Iterator<IVLCVout.Callback> it = this.mIVLCVoutCallbacks.iterator();
                            while (it.hasNext()) {
                                it.next().onSurfacesCreated(this);
                            }
                        }
                        SurfaceCallback surfaceCallback = this.mSurfaceCallback;
                        if (surfaceCallback != null) {
                            surfaceCallback.onSurfacesCreated(this);
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            str = TAG;
            strD = s.d(new byte[]{9, 15, 54, 66, Ascii.SYN, 82, 0, 7, 3, 33, 67, 0, 7, Ascii.NAK, 0, 83, 94, Ascii.DC4, 47, 17, 10, 14, 97, 10, 15, 15, 17, 82, Ascii.SYN, 113, Ascii.EM, 7, 3, Ascii.DC2, 69, 12, 9, 15, 95, Ascii.ETB, Ascii.DC2, 93, 5, 1, 9, 42, 84, 9, Ascii.SYN, 4, Ascii.ETB, Ascii.ETB, Ascii.ETB, 92, 14, 17, 10, 6, 95, 66, Ascii.DC2, 65, 7, 82, 68, 90, Ascii.DC4, 8, 10, 66, 89, 0, Ascii.DC4, 4}, "fae7d4");
        }
        Log.e(str, strD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSurfaceDestroyed() {
        detachViews();
    }

    private int registerNative(long j) {
        int i;
        if (j == 0) {
            Log.e(TAG, s.d(new byte[]{19, 87, 86, 91, 17, SignedBytes.MAX_POWER_OF_TWO, 4, Ascii.SYN, 40, 3, 69, 12, Ascii.ETB, 87, 11, Ascii.DC2, 43, 88, 13, 1, 1, 3, 93, 36, 19, 85, 68, 95, 7, 90, Ascii.NAK, 33, Ascii.RS, 1, 84, Ascii.NAK, Ascii.NAK, 91, 94, 92, 88, Ascii.DC4, 15, 5, Ascii.DC2, 11, 71, 0, 41, 83, 95, 86, 14, 81, 65, 13, Ascii.NAK, 66, 95, 16, 13, 94}, "a212b4"));
            return 0;
        }
        synchronized (this.mNativeLock) {
            if (this.mCallbackNativeHandle != 0) {
                return 0;
            }
            this.mCallbackNativeHandle = j;
            int i2 = this.mMouseAction;
            if (i2 != -1) {
                nativeOnMouseEvent(j, i2, this.mMouseButton, this.mMouseX, this.mMouseY);
            }
            int i3 = this.mWindowWidth;
            if (i3 != -1 && (i = this.mWindowHeight) != -1) {
                nativeOnWindowSize(this.mCallbackNativeHandle, i3, i);
            }
            return this.mOnNewVideoLayoutListener != null ? 3 : 1;
        }
    }

    private boolean setBuffersGeometry(Surface surface, int i, int i2, int i3) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNativeSurface(int i, Surface surface) {
        synchronized (this.mNativeLock) {
            this.mSurfaces[i] = surface;
        }
    }

    private void setSurface(int i, Surface surface, SurfaceHolder surfaceHolder) {
        ensureInitState();
        if (!surface.isValid() && surfaceHolder == null) {
            Log.e(TAG, s.d(new byte[]{17, 0, 69, 54, 16, 67, 7, 5, 5, 7, 11, 69, 43, 9, 93, 0, 2, 80, 13, 55, Ascii.DC2, 3, 69, 0, 39, Ascii.GS, 82, 0, Ascii.NAK, 69, 8, 11, 8, 88, 17, Ascii.SYN, Ascii.ETB, Ascii.ETB, 87, 4, 6, 84, 65, 13, Ascii.NAK, 66, 95, 10, Ascii.SYN, 69, 80, 17, 17, 80, 2, 12, 3, 6, 17, 4, 12, 1, 17, 13, 10, 93, 5, 1, Ascii.DC4, 66, 88, Ascii.SYN, 66, 11, 68, 9, 9}, "be1ee1"));
            return;
        }
        SurfaceHelper surfaceHelper = this.mSurfaceHelpers[i];
        if (surfaceHelper != null) {
            surfaceHelper.release();
        }
        this.mSurfaceHelpers[i] = new SurfaceHelper(i, surface, surfaceHolder);
    }

    private void setVideoLayout(final int i, final int i2, final int i3, final int i4, final int i5, final int i6) {
        this.mHandler.post(new Runnable() { // from class: org.videolan.libvlc.AWindow.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (AWindow.this.mNativeLock) {
                    if (AWindow.this.mOnNewVideoLayoutListener != null) {
                        AWindow.this.mOnNewVideoLayoutListener.onNewVideoLayout(AWindow.this, i, i2, i3, i4, i5, i6);
                    }
                }
            }
        });
    }

    private void setView(int i, SurfaceView surfaceView) {
        ensureInitState();
        if (surfaceView == null) {
            Log.e(TAG, s.d(new byte[]{Ascii.SYN, 92, 76, 53, 94, 7, Ascii.SYN, 94, 70, 44, 68, 9, 9, 105, 87, 10, 89, Ascii.SYN, 4, Ascii.SYN, 35, 26, 82, 0, Ascii.NAK, 77, 81, 12, 89, 88, 65, Ascii.DC2, 15, 7, 70, 69, 12, 74, Ascii.CAN, 13, 66, 14, 13}, "e98c7b"));
            return;
        }
        SurfaceHelper surfaceHelper = this.mSurfaceHelpers[i];
        if (surfaceHelper != null) {
            surfaceHelper.release();
        }
        this.mSurfaceHelpers[i] = new SurfaceHelper(i, surfaceView);
    }

    private void setView(int i, TextureView textureView) {
        ensureInitState();
        if (textureView == null) {
            Log.e(TAG, s.d(new byte[]{66, 80, 65, 111, 92, 80, Ascii.SYN, 94, 70, 44, 68, 9, 93, 101, 90, 80, 91, 65, 4, Ascii.SYN, 35, 26, 82, 0, 65, 65, 92, 86, 91, 15, 65, Ascii.DC2, 15, 7, 70, 69, 88, 70, Ascii.NAK, 87, SignedBytes.MAX_POWER_OF_TWO, 89, 13}, "155955"));
            return;
        }
        SurfaceHelper surfaceHelper = this.mSurfaceHelpers[i];
        if (surfaceHelper != null) {
            surfaceHelper.release();
        }
        this.mSurfaceHelpers[i] = new SurfaceHelper(i, textureView);
    }

    private void unregisterNative() {
        synchronized (this.mNativeLock) {
            if (this.mCallbackNativeHandle == 0) {
                Log.e(TAG, s.d(new byte[]{67, 91, 16, 85, 6, 80, Ascii.DC2, 16, 3, 16, 127, 4, 66, 92, Ascii.DC4, 85, 91, Ascii.EM, 40, 8, 10, 7, 86, 4, 90, 116, 16, 87, Ascii.DC4, 84, 4, 10, Ascii.DC2, 39, 73, 6, 83, 69, Ascii.SYN, 89, 14, 87, 91, 68, 19, 12, 67, 0, 81, 92, 17, 68, 4, 75, 65, 7, 7, 14, 93, 0, 82, Ascii.NAK, Ascii.NAK, 88, 4, 87, 65, 10, 9, Ascii.SYN, 17, Ascii.ETB, 83, 82, 11, 67, Ascii.NAK, 92, 19, 1, 2}, "65b0a9"));
            } else {
                this.mCallbackNativeHandle = 0L;
            }
        }
    }

    public boolean SurfaceTexture_attachToGLContext(int i) {
        return AndroidUtil.isJellyBeanOrLater && this.mSurfaceTextureThread.attachToGLContext(i);
    }

    @Override // org.videolan.libvlc.IVLCVout
    public void addCallback(IVLCVout.Callback callback) {
        synchronized (this.mIVLCVoutCallbacks) {
            if (!this.mIVLCVoutCallbacks.contains(callback)) {
                this.mIVLCVoutCallbacks.add(callback);
            }
        }
    }

    public boolean areSurfacesWaiting() {
        return this.mSurfacesState.get() == 1;
    }

    @Override // org.videolan.libvlc.IVLCVout
    public boolean areViewsAttached() {
        return this.mSurfacesState.get() != 0;
    }

    @Override // org.videolan.libvlc.IVLCVout
    public void attachViews() {
        attachViews(null);
    }

    @Override // org.videolan.libvlc.IVLCVout
    public void attachViews(IVLCVout.OnNewVideoLayoutListener onNewVideoLayoutListener) {
        if (this.mSurfacesState.get() == 0) {
            if (this.mSurfaceHelpers[0] != null) {
                this.mSurfacesState.set(1);
                synchronized (this.mNativeLock) {
                    this.mOnNewVideoLayoutListener = onNewVideoLayoutListener;
                    this.mNativeLock.buffersGeometryConfigured = false;
                    this.mNativeLock.buffersGeometryAbort = false;
                }
                for (int i = 0; i < 2; i++) {
                    SurfaceHelper surfaceHelper = this.mSurfaceHelpers[i];
                    if (surfaceHelper != null) {
                        surfaceHelper.attach();
                    }
                }
                return;
            }
        }
        Log.e(TAG, s.d(new byte[]{5, 70, 65, 0, 1, 91, 55, 13, 3, Ascii.NAK, 66, 95, 68, 123, 89, 13, 7, 84, 0, 8, 53, Ascii.SYN, 80, 17, 1, 119, 77, 2, 7, 67, Ascii.NAK, 13, 9, 12, 11, 69, 5, 94, 71, 4, 3, 87, Ascii.CAN, 68, 7, Ascii.SYN, 69, 4, 7, 90, 80, 5, 66, 92, 19, 68, 16, 11, 85, 0, 11, Ascii.DC2, 67, 8, 7, 68, 65, 10, 9, Ascii.SYN, 17, 6, 11, 92, 83, 8, 5, 70, 19, 1, 2}, "d25ab3"));
    }

    @Override // org.videolan.libvlc.IVLCVout
    public synchronized void detachViews() {
        if (this.mSurfacesState.get() != 0) {
            this.mSurfacesState.set(0);
            this.mHandler.removeCallbacksAndMessages(null);
            synchronized (this.mNativeLock) {
                this.mOnNewVideoLayoutListener = null;
                this.mNativeLock.buffersGeometryAbort = true;
                this.mNativeLock.notifyAll();
            }
            for (int i = 0; i < 2; i++) {
                SurfaceHelper surfaceHelper = this.mSurfaceHelpers[i];
                if (surfaceHelper != null) {
                    surfaceHelper.release();
                }
                this.mSurfaceHelpers[i] = null;
            }
            Log.d(TAG, s.d(new byte[]{82, 80, 67, 88, 1, 94, 55, 13, 3, Ascii.NAK, 66, 95, Ascii.SYN, 88, 126, 111, 46, 117, 55, 11, 19, Ascii.SYN, 114, 4, 90, 89, 85, 88, 1, 93, Ascii.DC2, 74, Ascii.NAK, 11, 75, 0, 12}, "6579b6") + this.mIVLCVoutCallbacks.size() + s.d(new byte[]{78, 70, 93, 96, 17, 16, 7, 5, 5, 7, 114, 4, 14, 10, 82, 82, 7, 9, 91}, "bf03db") + this.mSurfaceCallback);
            synchronized (this.mIVLCVoutCallbacks) {
                Iterator<IVLCVout.Callback> it = this.mIVLCVoutCallbacks.iterator();
                while (it.hasNext()) {
                    it.next().onSurfacesDestroyed(this);
                }
            }
            SurfaceCallback surfaceCallback = this.mSurfaceCallback;
            if (surfaceCallback != null) {
                surfaceCallback.onSurfacesDestroyed(this);
                this.mSurfaceCallback = null;
            }
            if (AndroidUtil.isJellyBeanOrLater) {
                this.mSurfaceTextureThread.release();
            }
        }
    }

    @Override // org.videolan.libvlc.IVLCVout
    public void removeCallback(IVLCVout.Callback callback) {
        synchronized (this.mIVLCVoutCallbacks) {
            this.mIVLCVoutCallbacks.remove(callback);
        }
    }

    @Override // org.videolan.libvlc.IVLCVout
    public void sendMouseEvent(int i, int i2, int i3, int i4) {
        synchronized (this.mNativeLock) {
            long j = this.mCallbackNativeHandle;
            if (j != 0 && (this.mMouseAction != i || this.mMouseButton != i2 || this.mMouseX != i3 || this.mMouseY != i4)) {
                nativeOnMouseEvent(j, i, i2, i3, i4);
            }
            this.mMouseAction = i;
            this.mMouseButton = i2;
            this.mMouseX = i3;
            this.mMouseY = i4;
        }
    }

    @Override // org.videolan.libvlc.IVLCVout
    public void setSubtitlesSurface(SurfaceTexture surfaceTexture) {
        setSurface(1, new Surface(surfaceTexture), null);
    }

    @Override // org.videolan.libvlc.IVLCVout
    public void setSubtitlesSurface(Surface surface, SurfaceHolder surfaceHolder) {
        setSurface(1, surface, surfaceHolder);
    }

    @Override // org.videolan.libvlc.IVLCVout
    public void setSubtitlesView(SurfaceView surfaceView) {
        setView(1, surfaceView);
    }

    @Override // org.videolan.libvlc.IVLCVout
    public void setSubtitlesView(TextureView textureView) {
        setView(1, textureView);
    }

    @Override // org.videolan.libvlc.IVLCVout
    public void setVideoSurface(SurfaceTexture surfaceTexture) {
        setSurface(0, new Surface(surfaceTexture), null);
    }

    @Override // org.videolan.libvlc.IVLCVout
    public void setVideoSurface(Surface surface, SurfaceHolder surfaceHolder) {
        setSurface(0, surface, surfaceHolder);
    }

    @Override // org.videolan.libvlc.IVLCVout
    public void setVideoView(SurfaceView surfaceView) {
        setView(0, surfaceView);
    }

    @Override // org.videolan.libvlc.IVLCVout
    public void setVideoView(TextureView textureView) {
        setView(0, textureView);
    }

    @Override // org.videolan.libvlc.IVLCVout
    public void setWindowSize(int i, int i2) {
        synchronized (this.mNativeLock) {
            long j = this.mCallbackNativeHandle;
            if (j != 0 && (this.mWindowWidth != i || this.mWindowHeight != i2)) {
                nativeOnWindowSize(j, i, i2);
            }
            this.mWindowWidth = i;
            this.mWindowHeight = i2;
        }
    }
}
