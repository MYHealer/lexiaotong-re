package com.adprof.sdk;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.stub.StubApp;
import java.util.Timer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class z5 extends RelativeLayout implements ro {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1550a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Bitmap f892a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Handler f893a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ImageView f894a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public d f895a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ep f896a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public fo f897a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public fp f898a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public gp f899a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public qo f900a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public y5 f901a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f902a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Timer f903a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f904a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f905b;
    public int c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f906c;
    public int d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public boolean f907d;

    public z5(Context context) {
        super(context);
        this.f897a = fo.STATE_IDLE;
        this.d = 0;
        this.f907d = false;
        this.f893a = new w5(this, Looper.getMainLooper());
    }

    @Override // com.adprof.sdk.ro
    public void a() {
        pk.a("onPrepared  [" + hashCode() + "] ");
        setState(fo.STATE_PREPARED);
        setMute(this.f906c);
        pk.a("mediaInterface start");
        f();
        this.f896a.d();
        if (m735a()) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = this.d;
                layoutParams.height = (int) (((double) h8.m641a()) * 0.65d);
            }
            setLayoutParams(layoutParams);
            a(this.f892a);
            hp.m656a((View) this.f899a);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams2.addRule(13);
            addView(this.f899a, layoutParams2);
            requestLayout();
        }
    }

    @Override // com.adprof.sdk.ro
    public void a(int i, int i2) {
        this.c = i;
        this.f902a = "" + i2;
        setState(fo.STATE_ERROR);
    }

    public void a(Bitmap bitmap) {
        if (bitmap != null) {
            this.f892a = bitmap;
        }
        if (bitmap == null || !m735a()) {
            return;
        }
        if (this.f894a == null) {
            this.f894a = new ImageView(getContext());
        }
        hp.m656a((View) this.f894a);
        addView(this.f894a, new RelativeLayout.LayoutParams(-1, -1));
        this.f894a.setScaleType(ImageView.ScaleType.FIT_XY);
        this.f899a.bringToFront();
        invalidate();
        this.f894a.setImageBitmap(bitmap);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public final boolean m735a() {
        d dVar = this.f895a;
        return dVar != null && dVar.m602c() && this.b > this.f1550a;
    }

    @Override // com.adprof.sdk.ro
    public void b() {
        setState(fo.STATE_AUTO_COMPLETE);
        this.f907d = true;
    }

    @Override // com.adprof.sdk.ro
    public void b(int i, int i2) {
        fo foVar;
        pk.a("onInfo() called with: what = [" + i + "], extra = [" + i2 + "]");
        if (i != 3) {
            if (i == 701) {
                foVar = fo.STATE_BUFFERING_START;
            } else if (i != 702) {
                return;
            }
            setState(foVar);
        }
        if (!this.f905b) {
            this.f905b = true;
            this.f893a.removeMessages(6000);
        }
        if (!this.f904a) {
            return;
        } else {
            this.f904a = false;
        }
        foVar = fo.STATE_BUFFERING_END;
        setState(foVar);
    }

    public void c() {
        fo foVar = this.f897a;
        if (foVar == fo.STATE_NORMAL || foVar == fo.STATE_PREPARING || foVar == fo.STATE_ERROR) {
            g();
            return;
        }
        fo foVar2 = fo.STATE_PAUSE;
        if (foVar == foVar2 || this.f896a == null) {
            return;
        }
        pk.c("onStatePause  [" + hashCode() + "] ");
        setState(foVar2);
        h();
        this.f896a.a();
    }

    public void d() {
        fo foVar;
        ep epVar;
        pk.a("------goOnPlayOnResume:state " + this.f897a);
        if (this.f907d || (foVar = this.f897a) == fo.STATE_NORMAL || (epVar = this.f896a) == null) {
            i();
        } else if (foVar == fo.STATE_PAUSE || foVar == fo.STATE_BUFFERING_END || foVar == fo.STATE_PREPARED) {
            epVar.d();
            f();
        }
    }

    public void e() {
        pk.a("onStateNormal stat" + this.f897a + " [" + hashCode() + "] ");
        setState(fo.STATE_NORMAL);
        ep epVar = this.f896a;
        if (epVar != null) {
            epVar.c();
        }
    }

    public void f() {
        pk.a("onStateStartPlaying  [" + hashCode() + "] ");
        if (this.f897a == fo.STATE_PREPARED && !this.f905b) {
            this.f893a.sendEmptyMessageDelayed(6000, 1500L);
        }
        setState(fo.STATE_START_PLAYING);
        h();
    }

    public void g() {
        pk.a("reset  [" + hashCode() + "] ");
        Timer timer = this.f903a;
        if (timer != null) {
            timer.cancel();
        }
        y5 y5Var = this.f901a;
        if (y5Var != null) {
            y5Var.cancel();
        }
        e();
        removeAllViews();
        Window windowM681a = md.m681a(getContext());
        if (windowM681a != null) {
            windowM681a.clearFlags(128);
        }
        ep epVar = this.f896a;
        if (epVar != null) {
            epVar.c();
        }
    }

    public long getCurrentPositionWhenPlaying() {
        fo foVar = this.f897a;
        if (foVar != fo.STATE_START_PLAYING && foVar != fo.STATE_PAUSE) {
            return 0L;
        }
        try {
            MediaPlayer mediaPlayer = this.f896a.f263a;
            if (mediaPlayer != null) {
                return mediaPlayer.getCurrentPosition();
            }
            return 0L;
        } catch (IllegalStateException e) {
            pk.b("BaseVideoAdView getCurrentPositionWhenPlaying error: ", e);
            return 0L;
        }
    }

    public long getDuration() {
        MediaPlayer mediaPlayer;
        try {
            ep epVar = this.f896a;
            if (epVar == null || (mediaPlayer = epVar.f263a) == null) {
                return 0L;
            }
            return mediaPlayer.getDuration();
        } catch (Throwable th) {
            pk.b("BaseVideoAdView getDuration error: ", th);
            return 0L;
        }
    }

    public int getErrorCode() {
        return this.c;
    }

    public String getErrorMessage() {
        return this.f902a;
    }

    public int getVideoHeight() {
        return this.f1550a;
    }

    @Override // com.adprof.sdk.ro
    public qo getVideoPlayerDataSource() {
        return this.f900a;
    }

    public int getVideoWidth() {
        return this.b;
    }

    public void h() {
        pk.a("startProgressTimer:  [" + hashCode() + "] ");
        Timer timer = this.f903a;
        if (timer != null) {
            timer.cancel();
        }
        y5 y5Var = this.f901a;
        if (y5Var != null) {
            y5Var.cancel();
        }
        this.f903a = new Timer();
        y5 y5Var2 = new y5(this);
        this.f901a = y5Var2;
        this.f903a.schedule(y5Var2, 0L, 300L);
    }

    public void i() {
        pk.a("startVideo [" + hashCode() + "] ");
        if (this.f907d) {
            return;
        }
        try {
            ep epVar = this.f896a;
            if (epVar != null) {
                epVar.c();
            }
            this.f896a = new ep(this);
        } catch (Throwable th) {
            try {
                pk.b("BaseVideoAdView initPlayerInterface error: ", th);
            } catch (Throwable th2) {
                pk.b("BaseVideoAdView startVideo error [" + hashCode() + "] ", th2);
            }
        }
        Window windowM681a = md.m681a(getContext());
        if (windowM681a != null) {
            windowM681a.setFlags(16777216, 16777216);
            windowM681a.addFlags(128);
        }
        pk.a("addTextureView [" + hashCode() + "] ");
        View view = this.f899a;
        if (view != null) {
            removeView(view);
        }
        gp gpVar = new gp(StubApp.getOrigApplicationContext(getContext().getApplicationContext()));
        this.f899a = gpVar;
        gpVar.setSurfaceTextureListener(this.f896a);
        this.f899a.setTargetWidth(this.d);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(10);
        addView(this.f899a, layoutParams);
        this.f899a.bringToFront();
        pk.a("---base onStatePreparing  [" + hashCode() + "] ");
        setState(fo.STATE_PREPARING);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        pk.a("onAttachedToWindow");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public void setAdUnit(d dVar) {
        this.f895a = dVar;
    }

    @Override // com.adprof.sdk.ro
    public void setBufferProgress(int i) {
    }

    public void setLooping(boolean z) {
        MediaPlayer mediaPlayer;
        try {
            ep epVar = this.f896a;
            if (epVar != null && (mediaPlayer = epVar.f263a) != null) {
                mediaPlayer.setLooping(z);
            }
        } catch (IllegalStateException e) {
            pk.b("BaseVideoAdView setLooping error: ", e);
        }
    }

    public void setMute(boolean z) {
        ep epVar;
        float f;
        this.f906c = z;
        if (z) {
            epVar = this.f896a;
            if (epVar == null) {
                return;
            } else {
                f = 0.0f;
            }
        } else {
            epVar = this.f896a;
            if (epVar == null) {
                return;
            } else {
                f = 1.0f;
            }
        }
        epVar.b(f);
    }

    public void setState(fo foVar) {
        this.f897a = foVar;
        fp fpVar = this.f898a;
        if (fpVar != null) {
            fpVar.a(foVar);
        }
    }

    @Override // com.adprof.sdk.ro
    public void setSurfaceTexture(SurfaceTexture surfaceTexture) {
        gp gpVar = this.f899a;
        if (gpVar != null) {
            gpVar.setSurfaceTexture(surfaceTexture);
        }
    }

    public void setTargetWidth(int i) {
        if (i > 0) {
            this.d = i;
        }
    }

    public void setUp(String str) {
        this.f900a = new qo(str, null);
        e();
    }

    public void setVideoImageDisplayType(int i) {
        gp gpVar = this.f899a;
        if (gpVar != null) {
            gpVar.requestLayout();
        }
    }

    public void setVideoPlayerStatusListener(fp fpVar) {
        this.f898a = fpVar;
    }

    @Override // com.adprof.sdk.ro
    public void c(int i, int i2) {
        this.f1550a = i2;
        this.b = i;
        pk.a(" BaseVideoView onVideoSizeChanged  hashCode = " + hashCode() + "   width =  " + i + "  height = " + i2);
        gp gpVar = this.f899a;
        if (gpVar != null) {
            gpVar.setAdUnit(this.f895a);
            gp gpVar2 = this.f899a;
            if (gpVar2.f1198a == i && gpVar2.b == i2) {
                return;
            }
            gpVar2.f1198a = i;
            gpVar2.b = i2;
            gpVar2.requestLayout();
        }
    }
}
