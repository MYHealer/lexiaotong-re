package com.hihonor.adsdk.splash.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Outline;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.hihonor.adsdk.base.ErrorCode;
import com.hihonor.adsdk.base.api.BaseAd;
import com.hihonor.adsdk.base.bean.Video;
import com.hihonor.adsdk.base.j.j;
import com.hihonor.adsdk.base.net.glide.GlideLoadBuild;
import com.hihonor.adsdk.base.player.HnSplashPlayerView;
import com.hihonor.adsdk.base.widget.base.CountdownView;
import com.hihonor.adsdk.common.f.e0.e;
import com.hihonor.adsdk.common.f.f;
import com.hihonor.adsdk.common.f.u;
import com.hihonor.adsdk.common.f.x;
import com.hihonor.adsdk.common.video.AdVideoSize;
import com.hihonor.adsdk.splash.R;
import com.hihonor.adsdk.splash.SplashActionType;
import java.util.Collection;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public abstract class BaseSplashAdView extends RelativeLayout implements x.a {
    private static final String v = "BaseSplashAdView";
    private static final int w = 400;
    private static final int x = 300;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected BaseAd f3585a;
    protected HnSplashPlayerView b;
    protected FrameLayout c;
    protected ImageView d;
    protected TextView e;
    protected final Context f;
    private ImageView g;
    private FrameLayout h;
    private LottieAnimationView i;
    private TextView j;
    private TextView k;
    private CountdownView l;
    private TextView m;
    private TextView n;
    private View o;
    private x p;
    private boolean q;
    private float r;
    private com.hihonor.adsdk.splash.a s;
    private a t;
    private LightingAnimationView u;

    public interface a {
        void a(View view, int i);
    }

    protected static class b extends ViewOutlineProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final float f3586a;

        public b(float f) {
            this.f3586a = f;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(new Rect(0, 0, view.getWidth(), view.getHeight()), this.f3586a);
        }
    }

    public BaseSplashAdView(Context context) {
        super(context);
        this.q = false;
        this.f = context;
        com.hihonor.adsdk.common.b.b.hnadsc(v, "BaseSplashAdView1", new Object[0]);
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d() {
        this.u.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e() {
        this.o.post(new Runnable() { // from class: com.hihonor.adsdk.splash.view.BaseSplashAdView$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.d();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f() {
        this.u.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g() {
        this.o.post(new Runnable() { // from class: com.hihonor.adsdk.splash.view.BaseSplashAdView$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.f();
            }
        });
    }

    private void j() {
        com.hihonor.adsdk.common.b.b.hnadsc(v, "openSlideUpListener", new Object[0]);
        LottieAnimationView lottieAnimationView = this.i;
        if (lottieAnimationView != null) {
            lottieAnimationView.setAnimation("slide_up.json");
        }
        this.q = true;
    }

    private void n() {
        if (c()) {
            this.g.setScaleType(ImageView.ScaleType.FIT_XY);
        } else {
            this.g.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
    }

    private void p() {
        this.b.setVideoCut(!c());
    }

    private void setActionEvent(String str) {
        byte b2 = 0;
        com.hihonor.adsdk.common.b.b.hnadsc(v, "actionType: " + str, new Object[0]);
        if (str == null) {
        }
        str.hashCode();
        switch (str.hashCode()) {
            case 49:
                if (!str.equals("1")) {
                    b2 = -1;
                }
                break;
            case 50:
                b2 = !str.equals("2") ? (byte) -1 : (byte) 1;
                break;
            case 51:
                b2 = !str.equals("3") ? (byte) -1 : (byte) 2;
                break;
            case 48503:
                b2 = !str.equals(SplashActionType.CLICK_OR_SLIDE_UP) ? (byte) -1 : (byte) 3;
                break;
            case 48504:
                b2 = !str.equals(SplashActionType.CLICK_OR_SHAKE) ? (byte) -1 : (byte) 4;
                break;
            default:
                b2 = -1;
                break;
        }
        switch (b2) {
            case 0:
                h();
                break;
            case 1:
                j();
                break;
            case 2:
                i();
                break;
            case 3:
                j();
                l();
                break;
            case 4:
                i();
                l();
                break;
        }
    }

    public void a(View view, int i) {
        com.hihonor.adsdk.common.b.b.hnadsc(v, "setLogoArea areaView,visible", new Object[0]);
        this.h.addView(view);
        this.h.setVisibility(i);
        this.d.setVisibility(8);
    }

    protected void b() {
        RelativeLayout.inflate(this.f, getContentView(), this);
        this.c = (FrameLayout) findViewById(R.id.ads_splash_layout);
        this.b = (HnSplashPlayerView) findViewById(R.id.ad_splash_video_player);
        this.g = (ImageView) findViewById(R.id.ads_splash_ad_img);
        this.l = (CountdownView) findViewById(R.id.ad_countdown);
        this.i = (LottieAnimationView) findViewById(R.id.ad_animation_view);
        this.u = (LightingAnimationView) findViewById(R.id.ad_action_animation);
        this.j = (TextView) findViewById(R.id.ad_flag);
        this.k = (TextView) findViewById(R.id.ad_action_prompt);
        this.m = (TextView) findViewById(R.id.ad_action_result);
        this.o = findViewById(R.id.ads_click_layout);
        this.n = (TextView) findViewById(R.id.ad_action_click_result);
        this.m = (TextView) findViewById(R.id.ad_action_result);
        a();
        o();
        setClickable(true);
    }

    protected boolean c() {
        return (!j.hnadsj() && j.hnadsl()) || j.hnadsf(this.f);
    }

    protected abstract int getContentView();

    @Override // com.hihonor.adsdk.common.f.x.a
    public void hnadsa() {
        com.hihonor.adsdk.common.b.b.hnadsc(v, "action Shake", new Object[0]);
        b(this, 2);
    }

    public void k() {
        com.hihonor.adsdk.common.b.b.hnadsc(v, "release ----", new Object[0]);
        x xVar = this.p;
        if (xVar != null) {
            xVar.hnadse();
            this.p = null;
        }
        LottieAnimationView lottieAnimationView = this.i;
        if (lottieAnimationView != null) {
            lottieAnimationView.cancelAnimation();
            this.i = null;
        }
        com.hihonor.adsdk.splash.a aVar = this.s;
        if (aVar != null) {
            aVar.a();
            this.s = null;
        }
        CountdownView countdownView = this.l;
        if (countdownView != null) {
            countdownView.release();
            this.l = null;
        }
        this.f3585a = null;
    }

    protected abstract void m();

    protected void o() {
        ViewGroup.LayoutParams layoutParams = this.c.getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            layoutParams2.topMargin = u.hnadsh();
            com.hihonor.adsdk.common.b.b.hnadsc(v, "topMargin: " + layoutParams2.topMargin, new Object[0]);
            this.c.setLayoutParams(layoutParams2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!hasWindowFocus() || this.p == null) {
            return;
        }
        com.hihonor.adsdk.common.b.b.hnadsc(v, "onAttachedToWindow register", new Object[0]);
        this.p.hnadsd();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.hihonor.adsdk.common.b.b.hnadsc(v, "onDetachedFromWindow", new Object[0]);
        k();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        com.hihonor.adsdk.common.b.b.hnadsc(v, "onWindowFocusChanged", new Object[0]);
        a(z);
        x xVar = this.p;
        if (xVar == null) {
            return;
        }
        if (z) {
            com.hihonor.adsdk.common.b.b.hnadsc(v, "onWindowFocusChanged register", new Object[0]);
            this.p.hnadsd();
        } else {
            xVar.hnadse();
        }
        this.p.hnadsa(z);
    }

    public void setActionEventListener(a aVar) {
        this.t = aVar;
    }

    public void setBaseAd(BaseAd baseAd) {
        com.hihonor.adsdk.common.b.b.hnadsc(v, "setBaseAd", new Object[0]);
        if (baseAd == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(v, "ad is null", new Object[0]);
            return;
        }
        this.f3585a = baseAd;
        m();
        setActionEvent(baseAd.getActionType());
        CountdownView countdownView = this.l;
        if (countdownView != null) {
            countdownView.setBaseAd(baseAd);
            this.l.setCountdown(baseAd.getImpDuration());
            this.l.setTextSize(1, baseAd.getSkipFontSize());
        }
        this.j.setTextSize(1, baseAd.getAdFlagFontSize());
        this.k.setText(baseAd.getActionTips());
        this.m.setText(baseAd.getTargetTips());
        this.j.setVisibility(baseAd.getAdFlag() != 1 ? 8 : 0);
    }

    protected void setImageView(BaseAd baseAd) {
        com.hihonor.adsdk.common.b.b.hnadsc(v, "setImageView", new Object[0]);
        this.g.setVisibility(0);
        n();
        if (f.hnadsa((Collection<?>) baseAd.getImages())) {
            com.hihonor.adsdk.common.b.b.hnadsc(v, "setImageView: image is null", new Object[0]);
            return;
        }
        GlideLoadBuild.Builder imageView = new GlideLoadBuild.Builder().setContext(this.f).setNeedReport(true).setUrl(baseAd.getImages().get(0)).setBaseEventBean(com.hihonor.adsdk.base.g.j.g.b.hnadsa(baseAd)).setAdUnitId(baseAd.getAdUnitId()).setImageView(this.g);
        if (baseAd.getTrackUrl() != null) {
            imageView.setCommonTrackUrls(baseAd.getTrackUrl().getCommons());
        }
        imageView.build().loadImage();
    }

    public void setLogoArea(View view) {
        com.hihonor.adsdk.common.b.b.hnadsc(v, "setLogoArea areaView", new Object[0]);
        this.h.addView(view);
        this.d.setVisibility(8);
    }

    public void setLogoResId(int i) {
        com.hihonor.adsdk.common.b.b.hnadsc(v, "setLogoResId", new Object[0]);
        this.d.setImageResource(i);
    }

    public void setLogoView(Bitmap bitmap) {
        com.hihonor.adsdk.common.b.b.hnadsc(v, "setLogoView", new Object[0]);
        this.d.setImageBitmap(bitmap);
    }

    public void setMediaCopyrightResId(int i) {
        com.hihonor.adsdk.common.b.b.hnadsc(v, "setMediaCopyrightResId", new Object[0]);
    }

    public void setMediaCopyrightString(String str) {
        com.hihonor.adsdk.common.b.b.hnadsc(v, "setMediaCopyrightString", new Object[0]);
    }

    public void setMediaNameResId(int i) {
        com.hihonor.adsdk.common.b.b.hnadsc(v, "setMediaNameResId", new Object[0]);
        this.e.setText(i);
    }

    public void setMediaNameString(String str) {
        com.hihonor.adsdk.common.b.b.hnadsc(v, "setMediaNameString", new Object[0]);
        this.e.setText(str);
    }

    protected void setVideoView(final int i) {
        com.hihonor.adsdk.common.b.b.hnadsc(v, "setVideoView", new Object[0]);
        BaseAd baseAd = this.f3585a;
        if (baseAd == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(v, "setVideoView: baseAd is null", new Object[0]);
            return;
        }
        if (baseAd.getVideo() == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(v, "setVideoView: video is null", new Object[0]);
            return;
        }
        HnSplashPlayerView hnSplashPlayerView = this.b;
        if (hnSplashPlayerView == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(v, "setVideoView: mAdPlayerView is null", new Object[0]);
            return;
        }
        hnSplashPlayerView.setVisibility(0);
        p();
        com.hihonor.adsdk.splash.a aVar = new com.hihonor.adsdk.splash.a(this.b);
        this.s = aVar;
        aVar.a(this.f3585a);
        post(new Runnable() { // from class: com.hihonor.adsdk.splash.view.BaseSplashAdView$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(i);
            }
        });
    }

    private void h() {
        if (this.f3585a == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(v, "openClickListener#baseAd is null", new Object[0]);
            return;
        }
        com.hihonor.adsdk.common.b.b.hnadsc(v, "openClickListener", new Object[0]);
        LottieAnimationView lottieAnimationView = this.i;
        if (lottieAnimationView != null) {
            lottieAnimationView.setVisibility(8);
        }
        this.k.setVisibility(8);
        this.m.setVisibility(8);
        this.o.setVisibility(0);
        this.o.setOnClickListener(new BaseSplashAdView$$ExternalSyntheticLambda0(this));
        this.n.setText(this.f3585a.getActionTips() + this.f3585a.getTargetTips());
        com.hihonor.adsdk.common.f.b.hnadsa(this.o, 300, new com.hihonor.adsdk.common.f.b.c() { // from class: com.hihonor.adsdk.splash.view.BaseSplashAdView$$ExternalSyntheticLambda5
            @Override // com.hihonor.adsdk.common.f.b.c
            public final void hnadsa() {
                this.f$0.e();
            }
        });
    }

    private void i() {
        if (this.f3585a == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(v, "openShakeListener#baseAd is null", new Object[0]);
            return;
        }
        com.hihonor.adsdk.common.b.b.hnadsc(v, "openShakeListener#shakeAngke= " + this.f3585a.getShakeAngle() + ", shakeAcc= " + this.f3585a.getShakeAcc() + ", shakeDuration= " + this.f3585a.getShakeDuration(), new Object[0]);
        LottieAnimationView lottieAnimationView = this.i;
        if (lottieAnimationView != null) {
            lottieAnimationView.setAnimation("shake.json");
        }
        x xVar = new x();
        this.p = xVar;
        xVar.hnadsa(this);
        this.p.hnadsb(this.f3585a.getShakeAngle());
        this.p.hnadsa(this.f3585a.getShakeAcc());
        this.p.hnadsc(this.f3585a.getShakeDuration());
    }

    private void l() {
        if (this.f3585a == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(v, "setAnimationClickListener#baseAd is null", new Object[0]);
            return;
        }
        com.hihonor.adsdk.common.b.b.hnadsc(v, "setAnimationClickListener", new Object[0]);
        this.k.setVisibility(8);
        this.m.setVisibility(8);
        this.o.setVisibility(0);
        this.o.setOnClickListener(new BaseSplashAdView$$ExternalSyntheticLambda0(this));
        this.n.setText(this.f3585a.getActionTips() + e.hnadsa() + this.f3585a.getTargetTips());
        com.hihonor.adsdk.common.f.b.hnadsa(this.o, 300, new com.hihonor.adsdk.common.f.b.c() { // from class: com.hihonor.adsdk.splash.view.BaseSplashAdView$$ExternalSyntheticLambda1
            @Override // com.hihonor.adsdk.common.f.b.c
            public final void hnadsa() {
                this.f$0.g();
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!this.q) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.r = motionEvent.getY();
        } else if (action == 1 && this.r - motionEvent.getY() > 400.0f) {
            com.hihonor.adsdk.common.b.b.hnadsc(v, "action slide up: " + (this.r - motionEvent.getY()), new Object[0]);
            b(this, 1);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: setVideoPlayParam, reason: merged with bridge method [inline-methods] */
    public void a(int i) {
        BaseAd baseAd = this.f3585a;
        if (baseAd == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(v, "setVideoPlayParam#mBaseAd is null", new Object[0]);
            return;
        }
        Video video = baseAd.getVideo();
        if (video == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(v, "setVideoPlayParam#mVideo is null", new Object[0]);
            return;
        }
        if (this.b == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(v, "setVideoPlayParam#mAdPlayerView is null", new Object[0]);
            return;
        }
        AdVideoSize adVideoSize = new AdVideoSize(video.getVideoWidth(), video.getVideoHeight());
        int width = getWidth();
        int height = getHeight();
        if (c()) {
            adVideoSize = new AdVideoSize(width, height);
        }
        com.hihonor.adsdk.common.b.b.hnadsc(v, "screenWidth: " + width + "screenHeight:" + height, new Object[0]);
        this.b.setVideoViewSize(adVideoSize, i, Math.max(width, height));
    }

    @Override // com.hihonor.adsdk.common.f.x.a
    public void hnadsa(String str) {
        com.hihonor.adsdk.common.b.b.hnadsb(v, "onRegisterError.", new Object[0]);
        new com.hihonor.adsdk.base.g.j.d.x(Objects.isNull(this.f3585a) ? "" : this.f3585a.getAdUnitId(), com.hihonor.adsdk.base.g.j.g.b.hnadsa(this.f3585a), ErrorCode.AD_REGISTER_SENSOR_ERR, ErrorCode.MSG_REGISTER_SENSOR_ERR + str).hnadsa(com.hihonor.adsdk.base.g.j.e.a.b1, "1").hnadse();
    }

    protected void a() {
        this.h = (FrameLayout) findViewById(R.id.ads_icon_ima_layout);
        this.e = (TextView) findViewById(R.id.ads_media_name);
        ImageView imageView = (ImageView) findViewById(R.id.ads_splash_icon_img);
        this.d = imageView;
        imageView.setOutlineProvider(new b(com.hihonor.adsdk.common.f.j.hnadsa(getContext(), 4.0f)));
        this.d.setClipToOutline(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view) {
        com.hihonor.adsdk.common.b.b.hnadsc(v, "action click", new Object[0]);
        b(view, 0);
    }

    private void a(boolean z) {
        LottieAnimationView lottieAnimationView = this.i;
        if (lottieAnimationView == null) {
            return;
        }
        if (z) {
            lottieAnimationView.resumeAnimation();
        } else if (lottieAnimationView.isAnimating()) {
            this.i.pauseAnimation();
        }
    }

    public void b(View view, int i) {
        a aVar = this.t;
        if (aVar != null) {
            aVar.a(view, i);
        }
    }

    public BaseSplashAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.q = false;
        this.f = context;
        com.hihonor.adsdk.common.b.b.hnadsc(v, "BaseSplashAdView2", new Object[0]);
        b();
    }

    public BaseSplashAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.q = false;
        this.f = context;
        com.hihonor.adsdk.common.b.b.hnadsc(v, "BaseSplashAdView3", new Object[0]);
        b();
    }
}
