package com.fancy.mpsdk.component.videoplayer;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.fancy._eo;
import com.fancy._h0;
import com.fancy._h1;
import com.fancy._h2;
import com.fancy._h3;
import com.fancy._hb;
import com.fancy._hd;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public class NiceVideoPlayer extends FrameLayout implements _eo, TextureView.SurfaceTextureListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnVideoSizeChangedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnInfoListener {
    public static final Object _B = new Object();
    public static HandlerThread _C;
    public static Handler _D;
    public FrameLayout.LayoutParams _A;
    public _h1 _a;
    public FrameLayout _b;
    public SurfaceTexture _c;
    public MediaPlayer _d;
    public Surface _e;
    public AudioManager _f;
    public TextureView _g;
    public final Handler _h;
    public volatile long _i;
    public volatile long _j;
    public volatile boolean _k;
    public int _l;
    public int _m;
    public String _n;
    public Map<String, String> _o;
    public int _p;
    public MediaPlayer.OnPreparedListener _q;
    public MediaPlayer.OnCompletionListener _r;
    public _i _s;
    public final Handler _t;
    public final _e _u;
    public boolean _v;
    public boolean _w;
    public int _x;
    public int _y;
    public int _z;

    public class _a implements Callable<Long> {
        public _a() {
        }

        @Override // java.util.concurrent.Callable
        public final Long call() {
            MediaPlayer mediaPlayer = NiceVideoPlayer.this._d;
            long currentPosition = mediaPlayer != null ? mediaPlayer.getCurrentPosition() : 0L;
            NiceVideoPlayer.this._i = currentPosition;
            return Long.valueOf(currentPosition);
        }
    }

    public class _b implements Runnable {
        public final /* synthetic */ int _a;

        public _b(int i) {
            this._a = i;
        }

        @Override // java.lang.Runnable
        public final void run() {
            MediaPlayer mediaPlayer = NiceVideoPlayer.this._d;
            if (mediaPlayer != null) {
                float f = this._a / 10.0f;
                mediaPlayer.setVolume(f, f);
            }
        }
    }

    public class _c implements Callable<Long> {
        public _c() {
        }

        @Override // java.util.concurrent.Callable
        public final Long call() {
            MediaPlayer mediaPlayer = NiceVideoPlayer.this._d;
            long duration = mediaPlayer != null ? mediaPlayer.getDuration() : 0L;
            NiceVideoPlayer.this._j = duration;
            return Long.valueOf(duration);
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
            _i _iVar = NiceVideoPlayer.this._s;
            if (_iVar != null) {
                _iVar.onError(this._a, this._b, this._c);
            }
        }
    }

    public class _e implements Runnable {
        public _e() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            NiceVideoPlayer.this._c();
            _i _iVar = NiceVideoPlayer.this._s;
            if (_iVar != null) {
                _iVar.onTimeout();
            }
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
        public final /* synthetic */ int _a;

        public _g(int i) {
            this._a = i;
        }

        @Override // java.lang.Runnable
        public final void run() {
            _h1 _h1Var = NiceVideoPlayer.this._a;
            if (_h1Var != null) {
                _h1Var._a(this._a);
            }
        }
    }

    public class _h implements Runnable {
        public final /* synthetic */ MediaPlayer _a;

        public _h(MediaPlayer mediaPlayer) {
            this._a = mediaPlayer;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this._a.start();
            this._a.setLooping(false);
            NiceVideoPlayer niceVideoPlayer = NiceVideoPlayer.this;
            Object obj = NiceVideoPlayer._B;
            niceVideoPlayer.getClass();
        }
    }

    public interface _i extends MediaPlayer.OnErrorListener {
        void onTimeout();
    }

    public NiceVideoPlayer(Context context) {
        super(context);
        this._h = new Handler(Looper.getMainLooper());
        this._i = 0L;
        this._j = 0L;
        this._k = false;
        this._l = 0;
        this._m = 10;
        this._t = new Handler();
        this._u = new _e();
        _b();
    }

    public NiceVideoPlayer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this._h = new Handler(Looper.getMainLooper());
        this._i = 0L;
        this._j = 0L;
        this._k = false;
        this._l = 0;
        this._m = 10;
        this._t = new Handler();
        this._u = new _e();
        _b();
    }

    public static Object _a(Callable callable, Object obj) {
        FutureTask futureTask;
        try {
            try {
                _a();
                if (Looper.myLooper() == _C.getLooper()) {
                    return callable.call();
                }
                futureTask = new FutureTask(callable);
                try {
                    _D.post(futureTask);
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
        HandlerThread handlerThread = _C;
        if (handlerThread == null || _D == null || handlerThread == null || !handlerThread.isAlive()) {
            synchronized (_B) {
                HandlerThread handlerThread2 = _C;
                if (handlerThread2 == null || _D == null || handlerThread2 == null || !handlerThread2.isAlive()) {
                    HandlerThread handlerThread3 = new HandlerThread("nice-video-media-worker");
                    _C = handlerThread3;
                    handlerThread3.start();
                    _D = new Handler(_C.getLooper());
                }
            }
        }
    }

    public static void _a(Runnable runnable) {
        _a();
        _f _fVar = new _f(runnable);
        if (Looper.myLooper() == _C.getLooper()) {
            _fVar.run();
        } else {
            _D.post(_fVar);
        }
    }

    public final void _a(int i) {
        this._h.post(new _g(i));
    }

    public final void _b() {
        FrameLayout frameLayout = new FrameLayout(getContext());
        this._b = frameLayout;
        frameLayout.setBackgroundColor(0);
        addView(this._b, new FrameLayout.LayoutParams(-1, -1));
        _a();
    }

    public final void _d() {
        TextureView textureView;
        int i;
        int i2;
        hasWindowFocus();
        if (this._l == 0) {
            if (this._f == null) {
                this._f = (AudioManager) getContext().getSystemService("audio");
            }
            this._f.requestAudioFocus(null, 3, 1);
            _a(new _hb(this), Boolean.FALSE);
            if (this._g == null) {
                TextureView textureView2 = new TextureView(getContext());
                this._g = textureView2;
                textureView2.setLayerType(1, null);
                this._g.setSurfaceTextureListener(this);
            }
            FrameLayout frameLayout = this._b;
            if (frameLayout == null || (textureView = this._g) == null) {
                return;
            }
            frameLayout.removeView(textureView);
            FrameLayout.LayoutParams layoutParams = this._A;
            if (layoutParams != null) {
                this._b.addView(this._g, 0, layoutParams);
                return;
            }
            Context context = getContext();
            int i3 = this._x;
            int i4 = this._y;
            int i5 = this._z;
            if (i4 <= 0 || i5 <= 0) {
                i = -1;
                i2 = -1;
            } else if (i3 == 1) {
                i = context.getResources().getDisplayMetrics().heightPixels;
                i2 = (int) (((double) i) * (((double) i4) / ((double) i5)));
            } else {
                i2 = context.getResources().getDisplayMetrics().widthPixels;
                i = (int) (((double) i2) * (((double) i5) / ((double) i4)));
            }
            int[] iArr = {i2, i};
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(iArr[0], iArr[1]);
            layoutParams2.gravity = 17;
            this._b.addView(this._g, 0, layoutParams2);
        }
    }

    public int getBufferPercentage() {
        return this._p;
    }

    @Override // com.fancy._eo
    public long getCurrentPosition() {
        return ((Long) _a(new _a(), Long.valueOf(this._i))).longValue();
    }

    @Override // com.fancy._eo
    public long getDuration() {
        return ((Long) _a(new _c(), Long.valueOf(this._j))).longValue();
    }

    public int getMaxVolume() {
        AudioManager audioManager = this._f;
        if (audioManager != null) {
            return audioManager.getStreamMaxVolume(3);
        }
        return 0;
    }

    @Override // com.fancy._eo
    public int getVolume() {
        AudioManager audioManager = this._f;
        if (audioManager != null) {
            return audioManager.getStreamVolume(3);
        }
        return 0;
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public final void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
        this._p = i;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public final void onCompletion(MediaPlayer mediaPlayer) {
        this._l = 7;
        _a(7);
        this._b.setKeepScreenOn(false);
        MediaPlayer.OnCompletionListener onCompletionListener = this._r;
        if (onCompletionListener != null) {
            onCompletionListener.onCompletion(mediaPlayer);
        }
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        if (i == -38 || i == Integer.MIN_VALUE || i2 == -38 || i2 == Integer.MIN_VALUE) {
            return true;
        }
        this._l = -1;
        _a(-1);
        this._t.removeCallbacks(this._u);
        if (this._s == null) {
            return true;
        }
        this._h.post(new _d(mediaPlayer, i, i2));
        return true;
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public final boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        int i3 = 3;
        if (i == 3) {
            this._l = 3;
        } else {
            if (701 != i) {
                if (i != 702) {
                    return true;
                }
                if (this._l == 5) {
                    this._l = 3;
                    _a(3);
                }
                if (this._l != 6) {
                    return true;
                }
                this._l = 4;
                _a(4);
                return true;
            }
            int i4 = this._l;
            if (i4 == 4 || i4 == 6) {
                this._l = 6;
            } else {
                this._l = 5;
            }
            i3 = this._l;
        }
        _a(i3);
        return true;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public final void onPrepared(MediaPlayer mediaPlayer) {
        this._v = true;
        hasWindowFocus();
        this._t.removeCallbacks(this._u);
        MediaPlayer.OnPreparedListener onPreparedListener = this._q;
        if (onPreparedListener != null) {
            onPreparedListener.onPrepared(mediaPlayer);
        }
        if (this._w) {
            this._w = false;
            return;
        }
        this._l = 2;
        _a(2);
        _a(new _h(mediaPlayer));
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        SurfaceTexture surfaceTexture2 = this._c;
        if (surfaceTexture2 != null) {
            this._g.setSurfaceTexture(surfaceTexture2);
        } else {
            this._c = surfaceTexture;
            _a(new _hd(this));
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

    public void setController(_h1 _h1Var) {
        this._b.removeView(this._a);
        this._a = _h1Var;
        _h1Var._c();
        this._a.setNiceVideoPlayer(this);
        this._b.addView(this._a, new FrameLayout.LayoutParams(-1, -1));
    }

    public void setMediaVolume(int i) {
        _a(new _b(i));
    }

    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        this._r = onCompletionListener;
    }

    public void setOnErrorListener(_i _iVar) {
        this._s = _iVar;
    }

    public void setOnPreparedListener(MediaPlayer.OnPreparedListener onPreparedListener) {
        this._q = onPreparedListener;
    }

    public void setVideoLayoutParams(FrameLayout.LayoutParams layoutParams) {
        this._A = layoutParams;
        TextureView textureView = this._g;
        if (textureView != null) {
            textureView.setLayoutParams(layoutParams);
        }
    }

    public void setVolume(int i) {
        AudioManager audioManager = this._f;
        if (audioManager != null) {
            audioManager.setStreamVolume(3, i, 0);
        }
    }

    public final void _c() {
        _e _eVar;
        Activity activity_b;
        int i = this._m;
        if (i == 11 && i == 11) {
            _h0._c(getContext());
            Activity activity_b2 = _h0._b(getContext());
            if (activity_b2 != null) {
                activity_b2.setRequestedOrientation(1);
                ((ViewGroup) activity_b2.findViewById(R.id.content)).removeView(this._b);
                addView(this._b, new FrameLayout.LayoutParams(-1, -1));
                this._m = 10;
                this._a._b();
            }
        }
        int i2 = this._m;
        if (i2 == 12 && i2 == 12 && (activity_b = _h0._b(getContext())) != null) {
            ((ViewGroup) activity_b.findViewById(R.id.content)).removeView(this._b);
            addView(this._b, (FrameLayout.LayoutParams) new ViewGroup.LayoutParams(-1, -1));
            this._m = 10;
            this._a._b();
        }
        this._m = 10;
        AudioManager audioManager = this._f;
        if (audioManager != null) {
            audioManager.abandonAudioFocus(null);
            this._f = null;
        }
        MediaPlayer mediaPlayer = this._d;
        this._d = null;
        if (mediaPlayer != null) {
            _a(new _h2(mediaPlayer));
        }
        Surface surface = this._e;
        this._e = null;
        if (surface != null) {
            _a(new _h3(surface));
        }
        SurfaceTexture surfaceTexture = this._c;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this._c = null;
        }
        this._l = 0;
        this._i = 0L;
        this._k = false;
        _h1 _h1Var = this._a;
        if (_h1Var != null) {
            _h1Var._c();
        }
        Handler handler = this._t;
        if (handler == null || (_eVar = this._u) == null) {
            return;
        }
        handler.removeCallbacks(_eVar);
    }
}
