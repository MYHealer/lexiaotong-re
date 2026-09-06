package com.ubix.ssp.ad.e.b0;

import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.ubix.ssp.ad.e.a0.u;
import java.lang.reflect.Method;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class c extends com.ubix.ssp.ad.e.b0.b implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnVideoSizeChangedListener {
    private MediaPlayer g;
    private boolean h;

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f8756a;

        a(int i) {
            this.f8756a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.f() == null || c.this.f().getMediaPlayerCallback() == null) {
                return;
            }
            c.this.f().getMediaPlayerCallback().a(this.f8756a);
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.f() == null || c.this.f().getMediaPlayerCallback() == null) {
                return;
            }
            c.this.f().getMediaPlayerCallback().b();
            c.this.f().getMediaPlayerCallback().b(9090, 9090);
        }
    }

    /* JADX INFO: renamed from: com.ubix.ssp.ad.e.b0.c$c, reason: collision with other inner class name */
    class RunnableC1091c implements Runnable {
        RunnableC1091c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.f() == null || c.this.f().getMediaPlayerCallback() == null) {
                return;
            }
            c.this.f().getMediaPlayerCallback().a(false);
        }
    }

    class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f8759a;
        final /* synthetic */ int b;

        d(int i, int i2) {
            this.f8759a = i;
            this.b = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.f() != null) {
                c.this.f().getMediaPlayerCallback().b(this.f8759a, this.b);
            }
        }
    }

    class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.ubix.ssp.ad.e.b0.a f8760a;

        e(com.ubix.ssp.ad.e.b0.a aVar) {
            this.f8760a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (c.this.g == null) {
                    return;
                }
                Method declaredMethod = MediaPlayer.class.getDeclaredMethod("setDataSource", String.class, Map.class);
                declaredMethod.setAccessible(true);
                c.this.g.reset();
                declaredMethod.invoke(c.this.g, this.f8760a.a().toString(), this.f8760a.d);
                c.this.g.prepareAsync();
                c.this.h = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ SurfaceTexture f8761a;

        f(SurfaceTexture surfaceTexture) {
            this.f8761a = surfaceTexture;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                c cVar = c.this;
                SurfaceTexture surfaceTexture = this.f8761a;
                cVar.f8755a = surfaceTexture;
                if (surfaceTexture != null) {
                    cVar.a(new Surface(c.this.f8755a));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class g implements Runnable {
        g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c cVar = c.this;
            cVar.onError(cVar.g, -1, -1);
        }
    }

    class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ SurfaceHolder f8763a;

        h(SurfaceHolder surfaceHolder) {
            this.f8763a = surfaceHolder;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (c.this.g != null) {
                    c.this.g.setDisplay(this.f8763a);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class i implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f8764a;
        final /* synthetic */ int b;

        i(int i, int i2) {
            this.f8764a = i;
            this.b = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            c cVar = c.this;
            cVar.onVideoSizeChanged(cVar.g, this.f8764a, this.b);
        }
    }

    class j implements Runnable {
        j() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c cVar = c.this;
            cVar.onError(cVar.g, -1, -1);
        }
    }

    class k implements Runnable {
        k() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                c.this.g = new MediaPlayer();
                c.this.g.setAudioStreamType(3);
                c.this.g.setVolume(0.0f, 0.0f);
                c.this.g.setOnPreparedListener(c.this);
                c.this.g.setOnCompletionListener(c.this);
                c.this.g.setOnBufferingUpdateListener(c.this);
                c.this.g.setScreenOnWhilePlaying(true);
                c.this.g.setOnSeekCompleteListener(c.this);
                c.this.g.setOnErrorListener(c.this);
                c.this.g.setOnInfoListener(c.this);
                c.this.g.setOnVideoSizeChangedListener(c.this);
                if (c.this.f().h == null || c.this.f().h.a() == null || c.this.g == null || c.this.h) {
                    return;
                }
                c cVar = c.this;
                cVar.a(cVar.f().h);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class l implements Runnable {
        l() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.g == null || c.this.f() == null || !c.this.f().f()) {
                return;
            }
            try {
                c.this.g.start();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    class m implements Runnable {
        m() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.f() != null) {
                c.this.f().k();
            }
        }
    }

    class n implements Runnable {
        n() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (c.this.g != null) {
                    c.this.g.pause();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class o implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f8770a;

        o(long j) {
            this.f8770a = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (c.this.g != null) {
                    c.this.g.seekTo((int) this.f8770a, 2);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class p implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ float f8771a;
        final /* synthetic */ float b;

        p(float f, float f2) {
            this.f8771a = f;
            this.b = f2;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            try {
                if (c.this.g != null) {
                    c.this.g.setVolume(this.f8771a, this.b);
                    str = "---setVolume";
                } else {
                    str = "--mediaPlayer---null";
                }
                u.b(str);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    class q implements Runnable {
        q() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.f() == null || c.this.f().getMediaPlayerCallback() == null) {
                return;
            }
            c.this.f().getMediaPlayerCallback().a();
        }
    }

    class r implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f8773a;
        final /* synthetic */ int b;

        r(int i, int i2) {
            this.f8773a = i;
            this.b = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.f() == null || c.this.f().getMediaPlayerCallback() == null) {
                return;
            }
            c.this.f().getMediaPlayerCallback().a(this.f8773a, this.b);
        }
    }

    class s implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f8774a;
        final /* synthetic */ int b;

        s(int i, int i2) {
            this.f8774a = i;
            this.b = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.f() == null || c.this.f().getMediaPlayerCallback() == null) {
                return;
            }
            c.this.f().getMediaPlayerCallback().c(this.f8774a, this.b);
        }
    }

    public c(com.ubix.ssp.ad.e.b0.e eVar) {
        super(eVar);
        this.h = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.ubix.ssp.ad.e.b0.e f() {
        return this.f.get();
    }

    @Override // com.ubix.ssp.ad.e.b0.b
    protected long a() {
        MediaPlayer mediaPlayer = this.g;
        if (mediaPlayer != null) {
            try {
                return mediaPlayer.getCurrentPosition();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return -1L;
    }

    @Override // com.ubix.ssp.ad.e.b0.b
    protected void a(float f2, float f3) {
        if (this.d == null) {
            u.b("---mMediaHandler null");
        } else {
            this.e.post(new p(f2, f3));
        }
    }

    @Override // com.ubix.ssp.ad.e.b0.b
    protected void a(long j2) {
        Handler handler = this.d;
        if (handler != null) {
            handler.post(new o(j2));
        }
    }

    public void a(Surface surface) {
        try {
            this.g.setSurface(surface);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ubix.ssp.ad.e.b0.b
    protected synchronized void a(com.ubix.ssp.ad.e.b0.a aVar) {
        Handler handler = this.d;
        if (handler == null) {
            return;
        }
        handler.post(new e(aVar));
    }

    @Override // com.ubix.ssp.ad.e.b0.b
    protected void a(boolean z) {
        if (z) {
            try {
                a(0.0f, 0.0f);
            } catch (Exception e2) {
                e2.printStackTrace();
                Handler handler = this.e;
                if (handler != null) {
                    handler.post(new m());
                    return;
                }
                return;
            }
        }
        this.d.post(new l());
    }

    @Override // com.ubix.ssp.ad.e.b0.b
    protected long b() {
        MediaPlayer mediaPlayer = this.g;
        if (mediaPlayer != null) {
            return mediaPlayer.getDuration();
        }
        return 0L;
    }

    @Override // com.ubix.ssp.ad.e.b0.b
    protected boolean c() {
        return this.h;
    }

    @Override // com.ubix.ssp.ad.e.b0.b
    protected void d() {
        try {
            Handler handler = this.d;
            if (handler != null) {
                handler.post(new n());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ubix.ssp.ad.e.b0.b
    protected void e() {
        MediaPlayer mediaPlayer;
        u.b("notifyVideoRelease " + hashCode());
        try {
            if (this.d == null || this.c == null || (mediaPlayer = this.g) == null) {
                return;
            }
            this.f8755a = null;
            this.b = null;
            mediaPlayer.reset();
            mediaPlayer.release();
            HandlerThread handlerThread = this.c;
            if (handlerThread != null) {
                handlerThread.quitSafely();
                this.c = null;
            }
            this.d = null;
            this.g = null;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    protected void g() {
        e();
        HandlerThread handlerThread = new HandlerThread("UbiXVideo");
        this.c = handlerThread;
        handlerThread.start();
        this.d = new Handler(this.c.getLooper());
        this.e = new Handler();
        this.d.post(new k());
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public void onBufferingUpdate(MediaPlayer mediaPlayer, int i2) {
        this.e.post(new a(i2));
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        this.e.post(new RunnableC1091c());
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
        this.e.post(new r(i2, i3));
        return true;
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public boolean onInfo(MediaPlayer mediaPlayer, int i2, int i3) {
        u.a("onInfo what= " + i2 + ";extra= " + i3);
        this.e.post(new d(i2, i3));
        return false;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        this.e.post(new q());
    }

    @Override // android.media.MediaPlayer.OnSeekCompleteListener
    public void onSeekComplete(MediaPlayer mediaPlayer) {
        this.e.post(new b());
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        SurfaceTexture surfaceTexture2 = this.f8755a;
        if (surfaceTexture2 == null) {
            this.f8755a = surfaceTexture;
            g();
            Handler handler = this.d;
            if (handler != null) {
                handler.post(new f(surfaceTexture));
                return;
            }
            return;
        }
        try {
            if (surfaceTexture2.isReleased()) {
                this.f8755a = surfaceTexture;
            }
            if (this.f8755a != null) {
                a(new Surface(this.f8755a));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.f8755a = null;
        this.h = false;
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i2, int i3) {
        this.e.post(new s(i2, i3));
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        this.d.post(new i(i3, i4));
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        SurfaceHolder surfaceHolder2 = this.b;
        if (surfaceHolder2 == null) {
            this.b = surfaceHolder;
            g();
            Handler handler = this.d;
            if (handler != null) {
                handler.post(new h(surfaceHolder));
                return;
            }
            return;
        }
        if (surfaceHolder2 != surfaceHolder) {
            this.b = surfaceHolder;
            MediaPlayer mediaPlayer = this.g;
            if (mediaPlayer != null) {
                mediaPlayer.setDisplay(surfaceHolder);
            }
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        u.b("surfaceDestroyed");
        this.b = null;
        this.h = false;
    }
}
