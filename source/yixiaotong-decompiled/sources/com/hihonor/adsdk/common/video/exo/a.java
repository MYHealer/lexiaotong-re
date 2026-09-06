package com.hihonor.adsdk.common.video.exo;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import com.hihonor.adsdk.common.b.b;
import com.hihonor.adsdk.common.video.AdVideoSize;
import com.hihonor.adsdk.common.video.VideoPlayState;
import com.hihonor.adsdk.common.video.e;
import java.util.Locale;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public abstract class a extends com.hihonor.adsdk.common.video.a implements TextureView.SurfaceTextureListener {
    private static final String e = "BaseExoPlayer";
    private static final String f = "key_playback_state";
    private static final int g = 1;
    private static final int h = 2;
    private static final int i = 3;
    private static final int j = 4;
    private static final HandlerThread k = new HandlerThread("ads-exo");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Handler f3521a;
    protected boolean b;
    private boolean c;
    protected boolean d;
    private Surface hnadsn;
    private SurfaceTexture hnadso;
    private TextureView hnadsp;
    private VideoPlayState hnadsq;
    private long hnadsr;
    private long hnadss;
    private long hnadst;
    private int hnadsu;
    protected long hnadsv;
    protected long hnadsw;
    private int hnadsx;
    private Runnable hnadsy;
    private Handler hnadsz;

    /* JADX INFO: renamed from: com.hihonor.adsdk.common.video.exo.a$a, reason: collision with other inner class name */
    class HandlerC0462a extends Handler {
        HandlerC0462a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (a.this.hnadsc(message.what)) {
                b.hnadsc(a.this.hnadsu(), "AdThreadExoPlayer handleMessage msg.what = " + message.what + "mTargetState = " + a.this.hnadsx + " getState = " + a.this.getState(), new Object[0]);
            }
            switch (message.what) {
                case 0:
                    a.this.hnadsz();
                    break;
                case 1:
                    a.this.b();
                    break;
                case 2:
                    a.this.a();
                    break;
                case 3:
                    a.this.e();
                    break;
                case 4:
                    a.this.r();
                    break;
                case 5:
                    a.this.d();
                    break;
                case 6:
                    a.this.z();
                    break;
                case 7:
                    a.this.hnadsa(message.getData().getInt(a.f));
                    break;
                case 8:
                    a.this.f();
                    break;
                case 9:
                    a aVar = a.this;
                    aVar.hnadst = aVar.hnadsh();
                    a aVar2 = a.this;
                    aVar2.hnadsu = aVar2.hnadsg();
                    a.this.y();
                    break;
            }
        }
    }

    public a(Context context) {
        super(context);
        this.hnadsx = 0;
        this.hnadsz = new Handler(Looper.getMainLooper());
        this.b = false;
        HandlerThread handlerThread = k;
        if (!handlerThread.isAlive()) {
            b.hnadsb(hnadsu(), "BaseExoPlayer mHandlerThread is dead", new Object[0]);
            handlerThread.start();
        }
        A();
        h();
        hnadsd(0);
    }

    private void A() {
        this.f3521a = new HandlerC0462a(k.getLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        if (!this.hnadsd || this.hnadsp.getVisibility() != 0) {
            b.hnadse(hnadsu(), "updatePlayProgress view is invisible", new Object[0]);
            return;
        }
        try {
            if (hnadsi()) {
                final long jHnadsx = hnadsx();
                final long jHnadsy = hnadsy();
                final long jHnadsv = hnadsv();
                this.f3521a.postDelayed(this.hnadsy, 1000L);
                hnadse(4);
                this.hnadsr = jHnadsy;
                this.hnadss = jHnadsx;
                this.hnadsz.post(new Runnable() { // from class: com.hihonor.adsdk.common.video.exo.a$$ExternalSyntheticLambda12
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.hnadsb(jHnadsx, jHnadsv, jHnadsy);
                    }
                });
            }
        } catch (Exception e2) {
            b.hnadse(hnadsu(), "updatePlayProgress error msg: " + e2.getMessage(), new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (!i() || !this.b) {
            if (this.hnadsx != 5) {
                b.hnadsc(hnadsu(), "handlePauseAction pause fail", new Object[0]);
                this.hnadsx = 5;
                return;
            }
            return;
        }
        b.hnadsc(hnadsu(), "handlePauseAction pause success", new Object[0]);
        hnadsj();
        hnadse(5);
        this.hnadsz.post(new Runnable() { // from class: com.hihonor.adsdk.common.video.exo.a$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.k();
            }
        });
        this.f3521a.removeCallbacks(this.hnadsy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        b.hnadsc(hnadsu(), "handlePlayAction", new Object[0]);
        if (hnadsf()) {
            return;
        }
        try {
            hnadsm();
            hnadsq();
            hnadse(1);
            hnadsk();
            this.hnadsv = SystemClock.elapsedRealtime();
            this.hnadsz.post(new Runnable() { // from class: com.hihonor.adsdk.common.video.exo.a$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.hnadsc();
                }
            });
            this.hnadsx = 4;
        } catch (Exception e2) {
            b.hnadsb(hnadsu(), "handlePlayAction error msg: " + e2.getMessage(), new Object[0]);
            hnadse(-1);
            x();
            this.hnadsz.post(new Runnable() { // from class: com.hihonor.adsdk.common.video.exo.a$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.l();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (getState() != 8) {
            b.hnadsc(hnadsu(), "handleReplayAction replay fail", new Object[0]);
            return;
        }
        b.hnadsc(hnadsu(), "handleReplayAction replay success", new Object[0]);
        hnadsl();
        hnadse(1);
        this.hnadsx = 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (!i()) {
            if (this.hnadsx != 4) {
                b.hnadsc(hnadsu(), "handleResumeAction set target state STATE_PLAYING", new Object[0]);
                this.hnadsx = 4;
                return;
            }
            return;
        }
        if (getState() == 5) {
            b.hnadsc(hnadsu(), "handleResumeAction is pause and play", new Object[0]);
            hnadse(4);
            this.hnadsz.post(new Runnable() { // from class: com.hihonor.adsdk.common.video.exo.a$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.p();
                }
            });
            hnadsk();
            B();
            return;
        }
        if (getState() != 2) {
            b.hnadsa(hnadsu(), (Object) "handleResumeAction is error state");
            return;
        }
        b.hnadsc(hnadsu(), "handleResumeAction is prepared and play", new Object[0]);
        hnadse(3);
        this.hnadsz.post(new Runnable() { // from class: com.hihonor.adsdk.common.video.exo.a$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.q();
            }
        });
        hnadsk();
        B();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (hnadsf()) {
            return;
        }
        try {
            if (this.hnadso != null) {
                b.hnadsc(hnadsu(), "handleSetSurfaceAction process", new Object[0]);
                if (this.hnadsn == null) {
                    this.hnadsn = new Surface(this.hnadso);
                }
                hnadsa(this.hnadsn);
            }
        } catch (Exception e2) {
            b.hnadsc(hnadsu(), "handleSetSurfaceAction error msg : " + e2.getMessage(), new Object[0]);
        }
    }

    private void h() {
        if (this.hnadsm == null) {
            b.hnadsb(hnadsu(), "initTextureView mContext is null", new Object[0]);
            return;
        }
        TextureView textureView = new TextureView(this.hnadsm);
        this.hnadsp = textureView;
        textureView.setSurfaceTextureListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hnadsc(int i2) {
        return (i2 == 9 || i2 == 2 || i2 == 3) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hnadsz() {
        if (this.hnadsm == null) {
            b.hnadsb(hnadsu(), "handleInitAction mContext is null", new Object[0]);
            return;
        }
        g();
        this.hnadsq = new VideoPlayState();
        this.hnadsy = new Runnable() { // from class: com.hihonor.adsdk.common.video.exo.a$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.B();
            }
        };
    }

    private boolean i() {
        int state = getState();
        return (j() || state == -1 || state == 0 || state == 1 || state == 8) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k() {
        hnadsb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l() {
        hnadsa(e.hnadsc, "set data source error.", 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m() {
        hnadsa(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n() {
        hnadsa(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o() {
        hnadsa(this.hnadsw, SystemClock.elapsedRealtime() - this.hnadsv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p() {
        hnadsd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q() {
        hnadse();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        hnadse(0);
        t();
        v();
        u();
        s();
    }

    private void t() {
        if (hnadsf()) {
            return;
        }
        try {
            hnadsr();
            b.hnadsc(hnadsu(), "releasePlayer", new Object[0]);
        } catch (Exception e2) {
            b.hnadsb(hnadsu(), "releasePlayer error msg: " + e2.getMessage(), new Object[0]);
        }
    }

    private void w() {
        b.hnadsc(hnadsu(), "releaseWorkHandlerMessage", new Object[0]);
        Handler handler = this.f3521a;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    private void x() {
        b.hnadsc(hnadsu(), "removeGetBufferAction", new Object[0]);
        Handler handler = this.f3521a;
        if (handler != null) {
            handler.removeMessages(9);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        b.hnadsc(hnadsu(), "setVolume  isMuted = " + this.hnadsf, new Object[0]);
        if (hnadsf()) {
            return;
        }
        try {
            hnadst();
            hnadsb(this.hnadsf);
        } catch (Exception e2) {
            b.hnadsb(hnadsu(), "setVolume error: " + e2.getMessage(), new Object[0]);
        }
    }

    public void c() {
        b.hnadsc(hnadsu(), "onRenderedFirstFrame", new Object[0]);
        this.hnadsw = SystemClock.elapsedRealtime() - this.hnadsv;
    }

    public abstract void g();

    @Override // com.hihonor.adsdk.common.video.IPlayer
    public int getBufferedPercentage() {
        return this.hnadsu;
    }

    @Override // com.hihonor.adsdk.common.video.IPlayer
    public long getBufferedPosition() {
        return this.hnadst;
    }

    @Override // com.hihonor.adsdk.common.video.IPlayer
    public long getCurrentPosition() {
        return this.hnadss;
    }

    @Override // com.hihonor.adsdk.common.video.IPlayer
    public long getDuration() {
        return this.hnadsr;
    }

    @Override // com.hihonor.adsdk.common.video.IPlayer
    public View getPlayerView() {
        b.hnadsc(hnadsu(), "getPlayerView", new Object[0]);
        TextureView textureView = this.hnadsp;
        if (textureView != null && !textureView.isAvailable() && this.hnadso != null) {
            b.hnadsc(hnadsu(), "getPlayerView TextureView recreate", new Object[0]);
            h();
        }
        return this.hnadsp;
    }

    public abstract void hnadsa(Surface surface);

    public abstract void hnadsm();

    public abstract boolean hnadsn();

    public abstract void hnadso();

    public abstract void hnadsp();

    public abstract void hnadsq();

    public abstract void hnadsr();

    public abstract void hnadss();

    public abstract void hnadst();

    public String hnadsu() {
        return e + hashCode();
    }

    public abstract int hnadsv();

    public abstract long hnadsw();

    public abstract long hnadsx();

    public abstract long hnadsy();

    @Override // com.hihonor.adsdk.common.video.IPlayer
    public boolean isPlaying() {
        b.hnadsc(hnadsu(), "isPlaying isPlaying = " + this.b, new Object[0]);
        return this.b;
    }

    public abstract boolean j();

    @Override // com.hihonor.adsdk.common.video.IPlayer
    public void notifyVisibilityChange(boolean z) {
        this.hnadsd = z;
        if (z) {
            if (!this.hnadsi) {
                resume();
            }
            b.hnadsa(hnadsu(), (Object) "notifyVisibilityChange isVisibility");
        } else {
            if (this.hnadsi) {
                return;
            }
            pause();
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        b.hnadsc(hnadsu(), "onSurfaceTextureAvailable width = " + i2 + " height = " + i3, new Object[0]);
        if (this.hnadso == null) {
            b.hnadsc(hnadsu(), "onSurfaceTextureAvailable first create SurfaceTexture", new Object[0]);
            this.hnadso = surfaceTexture;
        } else {
            TextureView textureView = this.hnadsp;
            if (textureView != null && textureView.getSurfaceTexture() != this.hnadso) {
                b.hnadsc(hnadsu(), "onSurfaceTextureAvailable reset SurfaceTexture", new Object[0]);
                try {
                    this.hnadsp.setSurfaceTexture(this.hnadso);
                } catch (Exception e2) {
                    b.hnadsb(hnadsu(), "onSurfaceTextureAvailable error msg: " + e2.getMessage(), new Object[0]);
                }
            }
        }
        hnadsd(8);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        b.hnadsc(hnadsu(), "onSurfaceTextureDestroyed", new Object[0]);
        return this.hnadso == null;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    @Override // com.hihonor.adsdk.common.video.IPlayer
    public void pause() {
        hnadsd(2);
    }

    @Override // com.hihonor.adsdk.common.video.IPlayer
    public void release() {
        w();
        hnadsd(4);
    }

    @Override // com.hihonor.adsdk.common.video.IPlayer
    public void replay() {
        b.hnadsa(hnadsu(), (Object) "replay");
        hnadsd(5);
    }

    @Override // com.hihonor.adsdk.common.video.IPlayer
    public void resume() {
        hnadsd(3);
    }

    @Override // com.hihonor.adsdk.common.video.IPlayer
    public void seekTo(long j2) {
    }

    @Override // com.hihonor.adsdk.common.video.IPlayer
    public void setCacheEnable(boolean z) {
        this.d = z;
    }

    @Override // com.hihonor.adsdk.common.video.a, com.hihonor.adsdk.common.video.IPlayer
    public void setMuted(boolean z) {
        super.setMuted(z);
        hnadsd(6);
    }

    @Override // com.hihonor.adsdk.common.video.IPlayer
    public void setVideoViewSize(AdVideoSize adVideoSize, int i2, int i3) {
        this.hnadsl = adVideoSize;
        this.hnadsj = i3;
        this.hnadsk = i2;
    }

    @Override // com.hihonor.adsdk.common.video.IPlayer
    public void startUri(String str) {
        b.hnadsc(hnadsu(), "startUri", new Object[0]);
        hnadsa(str);
    }

    private boolean hnadsf() {
        if (!j()) {
            return false;
        }
        b.hnadsb(hnadsu(), "checkExoPlayerNull mExoPlayer is null", new Object[0]);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int hnadsg() {
        if (hnadsf()) {
            return 0;
        }
        try {
            return hnadsv();
        } catch (Exception e2) {
            b.hnadsb(hnadsu(), "exoBufferedPercentage error: " + e2.getMessage(), new Object[0]);
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long hnadsh() {
        if (hnadsf()) {
            return 0L;
        }
        try {
            return hnadsw();
        } catch (Exception e2) {
            b.hnadsb(hnadsu(), "exoBufferedPosition error: " + e2.getMessage(), new Object[0]);
            return 0L;
        }
    }

    private boolean hnadsi() {
        if (hnadsf()) {
            return false;
        }
        try {
            return hnadsn();
        } catch (Exception e2) {
            b.hnadsb(hnadsu(), "exoIsPlaying error: " + e2.getMessage(), new Object[0]);
            return false;
        }
    }

    private void hnadsj() {
        if (hnadsf()) {
            return;
        }
        try {
            hnadso();
        } catch (Exception e2) {
            b.hnadsb(hnadsu(), "exoPause error: " + e2.getMessage(), new Object[0]);
        }
    }

    private void hnadsk() {
        if (hnadsf()) {
            return;
        }
        try {
            hnadsp();
        } catch (Exception e2) {
            b.hnadsb(hnadsu(), "exoPlay error: " + e2.getMessage(), new Object[0]);
        }
    }

    private void hnadsl() {
        if (hnadsf()) {
            return;
        }
        try {
            hnadss();
        } catch (Exception e2) {
            b.hnadsb(hnadsu(), "exoRePlay error: " + e2.getMessage(), new Object[0]);
        }
    }

    private void s() {
        Handler handler = this.hnadsz;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.hnadsz = null;
        }
        w();
        this.f3521a = null;
        this.hnadsx = 0;
        this.hnadsr = 0L;
        this.hnadss = 0L;
        this.hnadsw = 0L;
        this.c = false;
        this.b = false;
        this.hnadsg = "";
    }

    private void u() {
        try {
            Surface surface = this.hnadsn;
            if (surface != null) {
                surface.release();
                this.hnadsn = null;
            }
        } catch (Exception e2) {
            b.hnadsb(hnadsu(), "releaseSurface error msg: " + e2.getMessage(), new Object[0]);
        }
    }

    private void v() {
        try {
            SurfaceTexture surfaceTexture = this.hnadso;
            if (surfaceTexture != null) {
                surfaceTexture.release();
                this.hnadso = null;
            }
        } catch (Exception e2) {
            b.hnadsb(hnadsu(), "releaseSurfaceTexture error msg: " + e2.getMessage(), new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        if (this.f3521a == null) {
            b.hnadsb(hnadsu(), "sendGetBufferAction workHandler is null", new Object[0]);
        } else if (getState() >= 2) {
            b.hnadsb(hnadsu(), "sendGetBufferAction video is prepared", new Object[0]);
        } else {
            this.f3521a.sendEmptyMessageDelayed(9, 100L);
        }
    }

    private void hnadsd(int i2) {
        Handler handler = this.f3521a;
        if (handler == null) {
            b.hnadsb(hnadsu(), "sendVideoAction workHandler is null", new Object[0]);
        } else {
            handler.sendEmptyMessage(i2);
        }
    }

    private void hnadse(int i2) {
        VideoPlayState videoPlayState = this.hnadsq;
        if (videoPlayState == null) {
            b.hnadsc(hnadsu(), "setState mVideoPlayState is null", new Object[0]);
        } else {
            videoPlayState.setState(i2);
        }
    }

    public void hnadsb(int i2) {
        hnadsa(hnadsa(7, f, Integer.valueOf(i2)));
    }

    public void hnadsc(boolean z) {
        b.hnadsc(hnadsu(), "onIsPlayingChanged isPlaying = " + z, new Object[0]);
        this.b = z;
    }

    private void hnadsa(String str) {
        if (TextUtils.isEmpty(str)) {
            b.hnadsc(hnadsu(), "handleVideoUrl path is null", new Object[0]);
        } else {
            this.hnadsg = str;
            hnadsd(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void hnadsb(int i2, String str, int i3) {
        hnadsa(i2, str, i3);
    }

    @Override // com.hihonor.adsdk.common.video.a, com.hihonor.adsdk.common.video.IPlayer
    public int getState() {
        VideoPlayState videoPlayState = this.hnadsq;
        if (videoPlayState == null) {
            return 0;
        }
        return videoPlayState.getState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void hnadsb(long j2, long j3, long j4) {
        hnadsa(j2, j3, j4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hnadsa(Throwable th, final int i2) {
        final int i3 = (j() || getState() <= 2 || getState() == 8) ? 0 : 1;
        Locale locale = Locale.ROOT;
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(i2);
        objArr[1] = th == null ? "" : th.getMessage();
        final String str = String.format(locale, "onError.what=%s, extra=%s", objArr);
        b.hnadsc(hnadsu(), str, new Object[0]);
        hnadse(-1);
        x();
        this.hnadsz.post(new Runnable() { // from class: com.hihonor.adsdk.common.video.exo.a$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.hnadsb(i2, str, i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hnadsa(int i2) {
        b.hnadsc(hnadsu(), "handlePlayChangedAction isBuffering = " + this.c + " mPlayBackState=" + i2, new Object[0]);
        if (2 == i2) {
            y();
            if (getState() == 4) {
                b.hnadsc(hnadsu(), "handlePlayChangedAction start Buffering", new Object[0]);
                this.c = true;
                this.hnadsz.post(new Runnable() { // from class: com.hihonor.adsdk.common.video.exo.a$$ExternalSyntheticLambda7
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.m();
                    }
                });
                return;
            }
            return;
        }
        if (3 != i2) {
            if (4 != i2) {
                if (1 == i2) {
                    b.hnadsc(hnadsu(), "handlePlayChangedAction play idle", new Object[0]);
                    this.hnadss = 0L;
                    this.c = false;
                    return;
                }
                b.hnadsc(hnadsu(), "handlePlayChangedAction no match mPlayBackState", new Object[0]);
                return;
            }
            if (getState() == -1) {
                b.hnadse(hnadsu(), "handlePlayChangedAction STATE_ENDED current state is error", new Object[0]);
                return;
            }
            b.hnadsc(hnadsu(), "handlePlayChangedAction play complete", new Object[0]);
            hnadse(8);
            this.hnadsi = true;
            this.hnadsz.post(new Runnable() { // from class: com.hihonor.adsdk.common.video.exo.a$$ExternalSyntheticLambda11
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.hnadsa();
                }
            });
            return;
        }
        if (this.c) {
            b.hnadsc(hnadsu(), "handlePlayChangedAction end Buffering", new Object[0]);
            this.c = false;
            this.hnadsz.post(new Runnable() { // from class: com.hihonor.adsdk.common.video.exo.a$$ExternalSyntheticLambda8
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.n();
                }
            });
            B();
            return;
        }
        if (getState() == 1) {
            b.hnadsc(hnadsu(), "handlePlayChangedAction STATE_PREPARING", new Object[0]);
            hnadse(2);
            x();
            if (this.hnadss == 0) {
                b.hnadsc(hnadsu(), "handlePlayChangedAction STATE_PREPARING first play", new Object[0]);
                this.hnadsz.post(new Runnable() { // from class: com.hihonor.adsdk.common.video.exo.a$$ExternalSyntheticLambda9
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.o();
                    }
                });
            }
            z();
            int i3 = this.hnadsx;
            if (i3 == 4) {
                hnadse(3);
                this.hnadsz.post(new Runnable() { // from class: com.hihonor.adsdk.common.video.exo.a$$ExternalSyntheticLambda10
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.hnadse();
                    }
                });
                B();
            } else if (5 == i3) {
                hnadsj();
            }
        }
    }

    private void hnadsa(Message message) {
        Handler handler = this.f3521a;
        if (handler == null) {
            b.hnadsb(hnadsu(), "sendVideoAction workHandler is null", new Object[0]);
        } else {
            handler.sendMessage(message);
        }
    }

    private Message hnadsa(int i2, String str, Object obj) {
        Message messageObtain = Message.obtain();
        Bundle bundle = new Bundle();
        if (obj instanceof Integer) {
            bundle.putInt(str, ((Integer) obj).intValue());
        } else if (obj instanceof String) {
            bundle.putString(str, (String) obj);
        }
        messageObtain.setData(bundle);
        messageObtain.what = i2;
        return messageObtain;
    }
}
