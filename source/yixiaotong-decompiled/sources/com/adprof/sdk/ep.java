package com.adprof.sdk;

import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.os.Handler;
import android.view.Surface;
import android.view.TextureView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class ep implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnVideoSizeChangedListener, TextureView.SurfaceTextureListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SurfaceTexture f1158a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public MediaPlayer f263a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Handler f264a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ro f265a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f266a;
    public Handler b;

    public ep(ro roVar) {
        this.f265a = roVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(float f) {
        MediaPlayer mediaPlayer = this.f263a;
        if (mediaPlayer == null) {
            return;
        }
        mediaPlayer.setVolume(f, f);
    }

    public void a() {
        Handler handler = this.f264a;
        if (handler == null || this.f263a == null) {
            return;
        }
        handler.post(new xo(this));
    }

    public void a(long j) {
        Handler handler = this.f264a;
        if (handler == null) {
            return;
        }
        handler.post(new yo(this, j));
    }

    public void b() {
        MediaPlayer mediaPlayer;
        if (this.f266a && (mediaPlayer = this.f263a) != null && this.f1158a != null) {
            this.f266a = false;
            mediaPlayer.setSurface(new Surface(this.f1158a));
            return;
        }
        c();
        this.b = new Handler();
        in.a().getClass();
        Handler handler = jn.f1253a;
        this.f264a = handler;
        handler.post(new vo(this));
    }

    public void b(final float f) {
        Handler handler = this.f264a;
        if (handler == null) {
            return;
        }
        handler.post(new Runnable() { // from class: com.adprof.sdk.ep$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(f);
            }
        });
    }

    public void c() {
        MediaPlayer mediaPlayer;
        Handler handler = this.f264a;
        if (handler == null || (mediaPlayer = this.f263a) == null) {
            return;
        }
        handler.post(new zo(this, mediaPlayer));
        this.f263a = null;
    }

    public void d() {
        Handler handler = this.f264a;
        if (handler == null) {
            return;
        }
        handler.post(new wo(this));
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
        Handler handler = this.b;
        if (handler == null) {
            return;
        }
        handler.post(new cp(this, i));
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        Handler handler = this.b;
        if (handler == null) {
            return;
        }
        handler.post(new bp(this));
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        Handler handler = this.b;
        if (handler == null) {
            return false;
        }
        handler.post(new dp(this, i, i2));
        return true;
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        Handler handler = this.b;
        if (handler != null && this.f265a != null) {
            handler.post(new to(this, i, i2));
        }
        return false;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        Handler handler = this.b;
        if (handler == null) {
            return;
        }
        handler.post(new ap(this));
    }

    @Override // android.media.MediaPlayer.OnSeekCompleteListener
    public void onSeekComplete(MediaPlayer mediaPlayer) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        ro roVar = this.f265a;
        if (roVar == null) {
            return;
        }
        SurfaceTexture surfaceTexture2 = this.f1158a;
        if (surfaceTexture2 != null) {
            roVar.setSurfaceTexture(surfaceTexture2);
        } else {
            this.f1158a = surfaceTexture;
            b();
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        Handler handler = this.b;
        if (handler == null) {
            return;
        }
        handler.post(new uo(this, i, i2));
    }
}
