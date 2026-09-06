package com.fancy.mpsdk.component.videoplayer2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import android.widget.FrameLayout;
import com.fancy._i5;
import com.fancy._ie;
import com.fancy._iu;
import com.fancy._iv;
import com.fancy._ix;
import com.fancy._j5;
import com.fancy._j6;
import com.fancy._j7;
import com.fancy._ja;
import com.fancy._jb;
import com.fancy._jy;
import com.fancy.adsdk.lib.utils.Logger;
import com.fancy.mpsdk.component.videoplayer.NiceVideoPlayer;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public class PtgCoreVideo extends FrameLayout implements TextureView.SurfaceTextureListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnVideoSizeChangedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnBufferingUpdateListener {
    public static final Object _v = new Object();
    public static HandlerThread _w;
    public static Handler _x;
    public int _a;
    public int _b;
    public _jb _c;
    public FrameLayout _d;
    public _iu _e;
    public MediaPlayer _f;
    public Surface _g;
    public SurfaceTexture _h;
    public final Handler _i;
    public FrameLayout _j;
    public volatile int _k;
    public volatile int _l;
    public float _m;
    public float _n;
    public boolean _o;
    public boolean _p;
    public final _b _q;
    public Bitmap _r;
    public NiceVideoPlayer._i _s;
    public _jy _t;
    public boolean _u;

    public class _a implements Runnable {
        public _a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            PtgCoreVideo ptgCoreVideo = PtgCoreVideo.this;
            MediaPlayer mediaPlayer = ptgCoreVideo._f;
            if (mediaPlayer != null) {
                mediaPlayer.setVolume(ptgCoreVideo._m, ptgCoreVideo._n);
            }
        }
    }

    public class _b implements MediaPlayer.OnSeekCompleteListener {
        public _b() {
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public final void onSeekComplete(MediaPlayer mediaPlayer) {
            PtgCoreVideo.this._c._a();
        }
    }

    public class _c implements Runnable {
        public final /* synthetic */ int _a;

        public _c(int i) {
            this._a = i;
        }

        @Override // java.lang.Runnable
        public final void run() {
            PtgCoreVideo ptgCoreVideo = PtgCoreVideo.this;
            if (ptgCoreVideo._c != null) {
                ptgCoreVideo.getClass();
                PtgCoreVideo.this._c._a(this._a);
            }
        }
    }

    public class _d implements Runnable {
        public final /* synthetic */ MediaPlayer _a;
        public final /* synthetic */ int _b;
        public final /* synthetic */ int _c;

        public _d(MediaPlayer mediaPlayer, int i, int i2) {
            this._a = mediaPlayer;
            this._b = i;
            this._c = i2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            NiceVideoPlayer._i _iVar = PtgCoreVideo.this._s;
            if (_iVar != null) {
                _iVar.onError(this._a, this._b, this._c);
            }
        }
    }

    public class _e implements Runnable {
        public final /* synthetic */ MediaPlayer _a;

        public _e(MediaPlayer mediaPlayer) {
            this._a = mediaPlayer;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this._a.start();
        }
    }

    public class _f implements Runnable {
        public final /* synthetic */ Runnable _a;

        public _f(Runnable runnable) {
            this._a = runnable;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                this._a.run();
            } catch (Throwable unused) {
            }
        }
    }

    public class _g implements Runnable {
        public final /* synthetic */ MediaPlayer _a;

        public _g(MediaPlayer mediaPlayer) {
            this._a = mediaPlayer;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                this._a.release();
            } catch (Throwable unused) {
            }
        }
    }

    public class _h implements Callable<Integer> {
        public _h() {
        }

        @Override // java.util.concurrent.Callable
        public final Integer call() {
            MediaPlayer mediaPlayer = PtgCoreVideo.this._f;
            int duration = mediaPlayer != null ? mediaPlayer.getDuration() : 0;
            PtgCoreVideo.this._l = duration;
            return Integer.valueOf(duration);
        }
    }

    public class _i implements Callable<Integer> {
        public _i() {
        }

        @Override // java.util.concurrent.Callable
        public final Integer call() {
            MediaPlayer mediaPlayer = PtgCoreVideo.this._f;
            int currentPosition = mediaPlayer != null ? mediaPlayer.getCurrentPosition() : 0;
            PtgCoreVideo.this._k = currentPosition;
            return Integer.valueOf(currentPosition);
        }
    }

    public PtgCoreVideo(Context context) {
        this(context, null, 0);
    }

    public PtgCoreVideo(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PtgCoreVideo(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this._a = 0;
        this._b = 8;
        this._i = new Handler(Looper.getMainLooper());
        this._k = 0;
        this._l = 0;
        this._m = 0.0f;
        this._n = 0.0f;
        this._q = new _b();
        _b();
    }

    public static Object _a(Callable callable, Object obj) {
        FutureTask futureTask;
        try {
            try {
                _a();
                if (Looper.myLooper() == _w.getLooper()) {
                    return callable.call();
                }
                futureTask = new FutureTask(callable);
                try {
                    _x.post(futureTask);
                    return futureTask.get(200L, TimeUnit.MILLISECONDS);
                } catch (TimeoutException unused) {
                    if (futureTask != null) {
                        futureTask.cancel(false);
                    }
                    return obj;
                }
            } catch (TimeoutException unused2) {
                futureTask = null;
            }
        } catch (Throwable unused3) {
            return obj;
        }
    }

    public static void _a() {
        HandlerThread handlerThread = _w;
        if (handlerThread == null || _x == null || handlerThread == null || !handlerThread.isAlive()) {
            synchronized (_v) {
                HandlerThread handlerThread2 = _w;
                if (handlerThread2 == null || _x == null || handlerThread2 == null || !handlerThread2.isAlive()) {
                    HandlerThread handlerThread3 = new HandlerThread("ptg-media-worker");
                    _w = handlerThread3;
                    handlerThread3.start();
                    _x = new Handler(_w.getLooper());
                }
            }
        }
    }

    public static void _a(Runnable runnable) {
        _a();
        _f _fVar = new _f(runnable);
        if (Looper.myLooper() == _w.getLooper()) {
            _fVar.run();
        } else {
            _x.post(_fVar);
        }
    }

    public final void _a(int i) {
        this._i.post(new _c(i));
    }

    public final void _b() {
        this._d = new FrameLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        addView(this._d, layoutParams);
        FrameLayout frameLayout = new FrameLayout(getContext());
        this._j = frameLayout;
        this._d.addView(frameLayout, layoutParams);
        _a();
    }

    public final void _c() {
        if (this._a == 0) {
            if (_ja._b == null) {
                _ja._b = new _ja();
            }
            _ja _jaVar = _ja._b;
            synchronized (_jaVar._a) {
                if (!_jaVar._a.isEmpty() && _jaVar._a.size() > 8) {
                    PtgCoreVideo ptgCoreVideo = _jaVar._a.get(0);
                    ptgCoreVideo.getClass();
                    _a(new _ix(ptgCoreVideo));
                    ptgCoreVideo._a(true);
                    _jaVar._a.remove(ptgCoreVideo);
                }
            }
            if (_ja._b == null) {
                _ja._b = new _ja();
            }
            _ja _jaVar2 = _ja._b;
            synchronized (_jaVar2._a) {
                _jaVar2._a.remove(this);
                _jaVar2._a.add(this);
            }
            _a(new _j5(this), Boolean.FALSE);
            if (this._e == null) {
                _iu _iuVar = new _iu(getContext());
                this._e = _iuVar;
                _iuVar.setSurfaceTextureListener(this);
            }
            this._j.removeView(this._e);
            this._j.addView(this._e, new FrameLayout.LayoutParams(-1, -1, 17));
        }
    }

    public int getCurrModeStatus() {
        return this._b;
    }

    public int getCurrStatus() {
        return this._a;
    }

    public int getCurrentPosition() {
        return ((Integer) _a(new _i(), Integer.valueOf(this._k))).intValue();
    }

    public int getDuration() {
        return ((Integer) _a(new _h(), Integer.valueOf(this._l))).intValue();
    }

    public int getVolume() {
        return 0;
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public final void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public final void onCompletion(MediaPlayer mediaPlayer) {
        this._a = 7;
        _a(7);
        this._d.setKeepScreenOn(false);
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        if (this._a != 11) {
            this._a = -1;
            _a(-1);
        }
        if (this._s == null) {
            return true;
        }
        this._i.post(new _d(mediaPlayer, i, i2));
        return true;
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public final boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        int i3 = 3;
        if (i == 3) {
            if (this._a == 3) {
                return true;
            }
            this._a = 3;
        } else {
            if (i != 701) {
                if (i != 702) {
                    return true;
                }
                if (this._a == 5) {
                    this._a = 3;
                    _a(3);
                }
                if (this._a != 6) {
                    return true;
                }
                this._a = 4;
                _a(4);
                return true;
            }
            int i4 = this._a;
            if (i4 == 4 || i4 == 6) {
                this._a = 6;
            } else {
                this._a = 5;
            }
            i3 = this._a;
        }
        _a(i3);
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0065  */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x006d, code lost:
    
        if (r7 < r8) goto L30;
     */
    @Override // android.media.MediaPlayer.OnPreparedListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onPrepared(MediaPlayer mediaPlayer) {
        int[] iArr;
        float f;
        float f2;
        float f3;
        float f4;
        if (mediaPlayer != null) {
            if (this._e != null && (iArr = (int[]) _a(new _iv(this), null)) != null) {
                int i = iArr[0];
                int i2 = iArr[1];
                int width = this._e.getWidth();
                int height = this._e.getHeight();
                float f5 = 1.0f;
                if (i > width && i2 > height) {
                    f = i / width;
                    f2 = i2 / height;
                } else if (i < width && i2 < height) {
                    f2 = width / i;
                    f = height / i2;
                } else if (width > i) {
                    f2 = (width / i) / (height / i2);
                    f = 1.0f;
                } else if (height > i2) {
                    f = (height / i2) / (width / i);
                    f2 = 1.0f;
                } else {
                    f = 1.0f;
                    f2 = 1.0f;
                }
                if (i2 > i) {
                    if (f > f2) {
                        f3 = height;
                        f4 = f3 * f2;
                    } else {
                        f3 = width;
                        f4 = f3 * f;
                    }
                    f5 = f3 / f4;
                } else if (f > f2) {
                    f3 = height;
                    f4 = f3 * f2;
                    f5 = f3 / f4;
                }
                Matrix matrix = new Matrix();
                matrix.setScale(f * f5, f5 * f2, width / 2.0f, height / 2.0f);
                this._e.setTransform(matrix);
            }
            this._o = true;
            if (this._p) {
                this._p = false;
                return;
            }
            this._a = 2;
            _a(2);
            _a(new _e(mediaPlayer));
            if (this._c.getInfo()._c) {
                int i3 = (int) getContext().getSharedPreferences("progress", 0).getLong(com.fancy.adsdk.lib.utils._a._c(_ie._a(this._c.getInfo()._a).append(hashCode()).toString()), 0L);
                _jb _jbVar = this._c;
                if (_jbVar != null) {
                    _jbVar._a();
                }
                _a(new _j7(this, i3));
            }
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        SurfaceTexture surfaceTexture2 = this._h;
        if (surfaceTexture2 != null) {
            this._e.setSurfaceTexture(surfaceTexture2);
        } else {
            this._h = surfaceTexture;
            _a(new _j6(this, surfaceTexture));
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
    }

    public void setFrameListener(_jy _jyVar) {
        this._t = _jyVar;
    }

    public void setHeartVideoContent(_jb _jbVar) {
        this._d.removeView(this._c);
        this._c = _jbVar;
        _jbVar._b();
        _jbVar.setVideoPlayer(this);
        this._d.addView(this._c, new FrameLayout.LayoutParams(-1, -1));
    }

    public void setInScrollView(boolean z) {
        this._u = z;
    }

    public void setOnErrorListener(NiceVideoPlayer._i _iVar) {
        this._s = _iVar;
    }

    public void setVolume(int i) {
        if (i < 0) {
            i = 0;
        }
        if (i > 10) {
            i = 7;
        }
        float f = i / 10.0f;
        this._m = f;
        this._n = f;
        Logger.d("PtgCoreVideo", _ie._a("mMediaPlayer setVolume: ").append(this._f != null).append(" volume:").append(i).append(" leftVolume:").append(this._m).append(" rightVolume:").append(this._n).toString());
        _a(new _a());
    }

    public final void _a(boolean z) {
        FrameLayout frameLayout;
        _iu _iuVar;
        int currentPosition;
        com.fancy.mpsdk.component.videoplayer2._c _cVar;
        int currentPosition2;
        _jb _jbVar = this._c;
        if (_jbVar != null && _jbVar.getInfo()._c && (currentPosition2 = getCurrentPosition()) > 0) {
            getContext().getSharedPreferences("progress", 0).edit().putLong(com.fancy.adsdk.lib.utils._a._c(_ie._a(this._c.getInfo()._a).append(hashCode()).toString()), currentPosition2).apply();
        }
        if (!z) {
            if (_ja._b == null) {
                _ja._b = new _ja();
            }
            _ja _jaVar = _ja._b;
            synchronized (_jaVar._a) {
                _jaVar._a.remove(this);
            }
        } else if (this._c != null && (currentPosition = getCurrentPosition()) > 0) {
            String str_a = _i5._a(getContext())._a(this._c.getInfo()._b, false);
            synchronized (com.fancy.mpsdk.component.videoplayer2._c.class) {
                if (com.fancy.mpsdk.component.videoplayer2._c._a == null) {
                    com.fancy.mpsdk.component.videoplayer2._c._a = new com.fancy.mpsdk.component.videoplayer2._c();
                }
                _cVar = com.fancy.mpsdk.component.videoplayer2._c._a;
            }
            long j = currentPosition;
            com.fancy.mpsdk.component.videoplayer2._a _aVar = new com.fancy.mpsdk.component.videoplayer2._a(this);
            _cVar.getClass();
            com.fancy.adsdk.lib.utils._d._b(new com.fancy.mpsdk.component.videoplayer2._b(str_a, j, _aVar));
        }
        this._o = false;
        MediaPlayer mediaPlayer = this._f;
        this._f = null;
        if (mediaPlayer != null) {
            _a(new _g(mediaPlayer));
        }
        if ((this._u || z) && (frameLayout = this._j) != null && (_iuVar = this._e) != null) {
            frameLayout.removeView(_iuVar);
        }
        Surface surface = this._g;
        if (surface != null) {
            surface.release();
            this._g = null;
        }
        SurfaceTexture surfaceTexture = this._h;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this._h = null;
        }
        if (!z || this._a != 7) {
            this._a = 0;
        }
        this._b = 8;
        this._k = 0;
        _jb _jbVar2 = this._c;
        if (_jbVar2 != null) {
            _jbVar2._b();
        }
        try {
            Bitmap bitmap = this._r;
            if (bitmap != null) {
                bitmap.recycle();
                this._r = null;
            }
        } catch (Exception unused) {
        }
    }
}
