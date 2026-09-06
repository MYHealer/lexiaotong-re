package com.hihonor.adsdk.interstitial;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.hihonor.adsdk.base.ErrorCode;
import com.hihonor.adsdk.base.api.BaseAd;
import com.hihonor.adsdk.base.bean.f;
import com.hihonor.adsdk.base.callback.AdListener;
import com.hihonor.adsdk.base.g.j.d.s0;
import com.hihonor.adsdk.base.g.j.d.x;
import com.hihonor.adsdk.base.j.h;
import com.hihonor.adsdk.base.j.j;
import com.hihonor.adsdk.common.safe.SafeIntent;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class InterstitialActivity extends com.hihonor.adsdk.base.widget.base.a {
    private static final String h = "InterstitialActivityTAG";
    private static final String i = "info";
    private static AdListener j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private BaseAd f3523a;
    private InterstitialAdView b;
    private FrameLayout c;
    private com.hihonor.adsdk.interstitial.adapter.a d;
    private int e;
    private com.hihonor.adsdk.interstitial.g.a f;
    private View g;

    public static void a(Activity activity, BaseAd baseAd) {
        com.hihonor.adsdk.common.b.b.hnadsc(h, "startInterstitialActivity", new Object[0]);
        Bundle bundle = new Bundle();
        bundle.putParcelable("info", baseAd);
        f fVarHnadsa = h.hnadsa(activity, InterstitialActivity.class, bundle);
        com.hihonor.adsdk.common.b.b.hnadsc(h, "startInterstitialActivity,result:" + fVarHnadsa, new Object[0]);
        if (fVarHnadsa.hnadsa() != 0) {
            new x(baseAd != null ? baseAd.getAdUnitId() : "", com.hihonor.adsdk.base.g.j.g.b.hnadsb(), ErrorCode.AD_CODE_START_ACTIVITY_FAILED, fVarHnadsa.hnadsb()).hnadsa("code", String.valueOf(fVarHnadsa.hnadsa())).hnadse();
        }
    }

    public static void a(AdListener adListener) {
        j = adListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(InterstitialAdView interstitialAdView, View view) {
        if (Objects.nonNull(interstitialAdView)) {
            interstitialAdView.a(0);
        }
    }

    private void c() {
        com.hihonor.adsdk.common.b.b.hnadsc(h, "handleAfterCreateTextAreaView", new Object[0]);
        if (Objects.isNull(this.c)) {
            com.hihonor.adsdk.common.b.b.hnadsc(h, "handleAfterCreateTextAreaView adPictureTextLayout is null", new Object[0]);
        } else {
            this.c.post(new Runnable() { // from class: com.hihonor.adsdk.interstitial.InterstitialActivity$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.e();
                }
            });
        }
    }

    private void d() {
        if (Objects.isNull(this.f3523a)) {
            com.hihonor.adsdk.common.b.b.hnadsc(h, "initView mBaseAd is null", new Object[0]);
            return;
        }
        this.f3523a.setAdListener(j);
        InterstitialAdView interstitialAdView = (InterstitialAdView) findViewById(R.id.interstitial_ad_view);
        this.b = interstitialAdView;
        interstitialAdView.setAd(this.f3523a);
        this.c = (FrameLayout) findViewById(R.id.ad_picture_text_view);
        com.hihonor.adsdk.base.g.j.d.h1.a aVarHnadsa = com.hihonor.adsdk.base.g.j.g.b.hnadsa(this.f3523a);
        if (!e.a(this.f3523a.getSubType())) {
            com.hihonor.adsdk.common.b.b.hnadsc(h, "onCreate, but ad subType not support", new Object[0]);
            new x(this.f3523a.getAdUnitId(), aVarHnadsa, ErrorCode.AD_SUB_TYPE_DEFAULT, "ad subType not support and subType is:" + this.f3523a.getSubType()).hnadse();
            a(ErrorCode.AD_SUB_TYPE_DEFAULT, "ad subType not support and subType is:" + this.f3523a.getSubType());
        } else {
            a(this.b, this.f3523a, aVarHnadsa);
            this.d = b.a(this.f3523a);
            this.f = b.c(this.f3523a);
            b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e() {
        if (Objects.isNull(this.c)) {
            com.hihonor.adsdk.common.b.b.hnadsc(h, "handleAfterCreateTextAreaView post adPictureTextLayout is null", new Object[0]);
            return;
        }
        if (Objects.isNull(this.f)) {
            com.hihonor.adsdk.common.b.b.hnadsc(h, "handleAfterCreateTextAreaView mTextArea is null", new Object[0]);
            return;
        }
        g();
        if (Objects.nonNull(this.c)) {
            this.c.setVisibility(0);
        }
        if (Objects.nonNull(this.d)) {
            this.d.b(this.c.getHeight());
            this.d.a(this.f3523a, this);
        }
    }

    private void f() {
        com.hihonor.adsdk.common.b.b.hnadsc(h, "refreshView adapter:" + this.d, new Object[0]);
        g();
        if (Objects.nonNull(this.d)) {
            this.d.f();
        }
    }

    private void g() {
        if (Objects.nonNull(this.f)) {
            this.f.a(this.c, this.g);
        }
    }

    @Override // com.hihonor.adsdk.base.widget.base.a
    protected void hnadsb(Bundle bundle) {
        com.hihonor.adsdk.common.b.b.hnadsc(h, "onAdsCreate", new Object[0]);
        BaseAd baseAd = (BaseAd) new SafeIntent(getIntent()).getParcelableExtra("info");
        this.f3523a = baseAd;
        if (baseAd == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(h, "onCreate, but mBaseAd is null", new Object[0]);
            new s0(ErrorCode.EX_INTERSTITIAL_AD_NULL, ErrorCode.STR_EX_INTERSTITIAL_AD_NULL, "", com.hihonor.adsdk.base.g.j.g.b.hnadsb()).hnadse();
            a(ErrorCode.EX_INTERSTITIAL_AD_NULL, ErrorCode.STR_EX_INTERSTITIAL_AD_NULL);
            return;
        }
        com.hihonor.adsdk.base.g.j.d.h1.a aVarHnadsa = com.hihonor.adsdk.base.g.j.g.b.hnadsa(baseAd);
        new com.hihonor.adsdk.base.g.j.d.i1.a(this.f3523a.getAdUnitId(), aVarHnadsa).hnadsa("type", "3").hnadsa(com.hihonor.adsdk.base.g.j.e.a.R0, "1").hnadse();
        if (Objects.nonNull(j)) {
            this.f3523a.setAdListener(j);
        } else {
            com.hihonor.adsdk.common.b.b.hnadsc(h, "onCreate, but mAdListener is null", new Object[0]);
            new x(this.f3523a.getAdUnitId(), aVarHnadsa, ErrorCode.EX_INTERSTITIAL_AD_NULL, ErrorCode.STR_EX_INTERSTITIAL_AD_LISTENER_NULL).hnadse();
        }
        requestWindowFeature(1);
        h();
        setContentView(a());
        this.e = getResources().getConfiguration().screenLayout;
        getTheme().applyStyle(R.style.ActivityTransparent, true);
        try {
            d();
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadsb(h, "onCreate, initView error, Exception: " + e.getMessage(), new Object[0]);
            new x(this.f3523a.getAdUnitId(), aVarHnadsa, ErrorCode.HI_AD_INTERSTITIAL_VIEW_INVALID, "ViewStub is nll, Exception :" + e.getMessage()).hnadse();
            a(ErrorCode.HI_AD_INTERSTITIAL_VIEW_INVALID, "ViewStub is nll, Exception :" + e.getMessage());
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        com.hihonor.adsdk.common.b.b.hnadsc(h, "onBackPressed", new Object[0]);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        com.hihonor.adsdk.common.b.b.hnadsc(h, "onConfigurationChanged newConfig screenLayout = %d, mScreenLayout = %d", Integer.valueOf(configuration.screenLayout), Integer.valueOf(this.e));
        if (this.e == configuration.screenLayout || !j.hnadsk()) {
            return;
        }
        f();
        this.e = configuration.screenLayout;
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        com.hihonor.adsdk.common.b.b.hnadsc(h, "onDestroy", new Object[0]);
        AdListener adListener = j;
        if (adListener != null) {
            adListener.onAdClosed();
            j = null;
        }
        com.hihonor.adsdk.interstitial.adapter.a aVar = this.d;
        if (aVar != null) {
            aVar.g();
        }
        InterstitialAdView interstitialAdView = this.b;
        if (interstitialAdView != null) {
            interstitialAdView.release();
            this.b.removeAllViews();
        }
        BaseAd baseAd = this.f3523a;
        if (baseAd != null) {
            baseAd.setAdListener(null);
            this.f3523a = null;
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        com.hihonor.adsdk.common.b.b.hnadsc(h, "onPause", new Object[0]);
        com.hihonor.adsdk.interstitial.adapter.a aVar = this.d;
        if (aVar != null) {
            aVar.e();
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        com.hihonor.adsdk.common.b.b.hnadsc(h, "onResume", new Object[0]);
        com.hihonor.adsdk.interstitial.adapter.a aVar = this.d;
        if (aVar != null) {
            aVar.h();
        }
    }

    private void h() {
        getWindow().clearFlags(67108864);
        getWindow().getDecorView().setSystemUiVisibility(1792);
        getWindow().addFlags(Integer.MIN_VALUE);
        getWindow().setStatusBarColor(0);
    }

    private void b() {
        if (Objects.isNull(this.f3523a)) {
            com.hihonor.adsdk.common.b.b.hnadsc(h, "handleAdPictureTextLayout mBaseAd is null", new Object[0]);
            return;
        }
        View viewA = b.a(this, this.f3523a, false, this.f);
        this.g = viewA;
        if (Objects.isNull(viewA)) {
            com.hihonor.adsdk.common.b.b.hnadsc(h, "handleAdPictureTextLayout textAreaView is null", new Object[0]);
            return;
        }
        if (Objects.isNull(this.c)) {
            com.hihonor.adsdk.common.b.b.hnadsc(h, "handleAdPictureTextLayout adPictureTextLayout is null", new Object[0]);
            return;
        }
        if (Objects.isNull(this.f)) {
            com.hihonor.adsdk.common.b.b.hnadsc(h, "handleAdPictureTextLayout mTextArea is null", new Object[0]);
            return;
        }
        this.c.addView(this.g, this.f.a());
        com.hihonor.adsdk.common.b.b.hnadsc(h, "displayPictureTextView#call method", new Object[0]);
        d(this.g);
        this.c.setVisibility(4);
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        if (Objects.nonNull(this.b)) {
            this.b.a(2);
        }
    }

    private void a(final InterstitialAdView interstitialAdView, BaseAd baseAd, com.hihonor.adsdk.base.g.j.d.h1.a aVar) {
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.media_container_layout);
        if (e.i(baseAd)) {
            ViewStub viewStub = (ViewStub) findViewById(R.id.ad_interstitial_video);
            if (viewStub == null) {
                new x(baseAd.getAdUnitId(), aVar, ErrorCode.HI_AD_INTERSTITIAL_VIEW_INVALID, ErrorCode.REPORT_AD_INTERSTITIAL_VIEW_INVALID).hnadse();
                a(ErrorCode.HI_AD_INTERSTITIAL_VIEW_INVALID, ErrorCode.REPORT_AD_INTERSTITIAL_VIEW_INVALID);
                return;
            } else {
                viewStub.inflate();
                frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.hihonor.adsdk.interstitial.InterstitialActivity$$ExternalSyntheticLambda4
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        InterstitialActivity.a(interstitialAdView, view);
                    }
                });
                return;
            }
        }
        if (e.g(baseAd)) {
            ViewStub viewStub2 = (ViewStub) findViewById(R.id.ad_interstitial_image);
            if (viewStub2 == null) {
                new x(baseAd.getAdUnitId(), aVar, ErrorCode.HI_AD_INTERSTITIAL_VIEW_INVALID, ErrorCode.REPORT_AD_INTERSTITIAL_VIEW_INVALID).hnadse();
                a(ErrorCode.HI_AD_INTERSTITIAL_VIEW_INVALID, ErrorCode.REPORT_AD_INTERSTITIAL_VIEW_INVALID);
            } else {
                viewStub2.inflate();
                frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.hihonor.adsdk.interstitial.InterstitialActivity$$ExternalSyntheticLambda5
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        InterstitialActivity.b(interstitialAdView, view);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        if (Objects.nonNull(this.b)) {
            this.b.a(0);
        }
    }

    private void d(View view) {
        if (Objects.isNull(view)) {
            com.hihonor.adsdk.common.b.b.hnadsc(h, "webClickListener view is null", new Object[0]);
            return;
        }
        TextView textView = (TextView) view.findViewById(R.id.ad_brand);
        ImageView imageView = (ImageView) view.findViewById(R.id.ad_image);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.hihonor.adsdk.interstitial.InterstitialActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.a(view2);
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.hihonor.adsdk.interstitial.InterstitialActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.b(view2);
            }
        });
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.hihonor.adsdk.interstitial.InterstitialActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.c(view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(InterstitialAdView interstitialAdView, View view) {
        if (Objects.nonNull(interstitialAdView)) {
            interstitialAdView.a(5);
        }
    }

    private void a(int i2, String str) {
        if (j != null) {
            com.hihonor.adsdk.common.b.b.hnadsc(h, "fail code is %d and msg is %s", Integer.valueOf(i2), str);
            j.onAdImpressionFailed(i2, str);
            j = null;
        }
        finish();
    }

    private int a() {
        int iB = b.b(this.f3523a);
        if (e.h(this.f3523a)) {
            setRequestedOrientation(0);
            if (Build.VERSION.SDK_INT >= 28) {
                WindowManager.LayoutParams attributes = getWindow().getAttributes();
                attributes.layoutInDisplayCutoutMode = 1;
                getWindow().setAttributes(attributes);
            }
        } else {
            setRequestedOrientation(1);
        }
        return iB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        if (Objects.nonNull(this.b)) {
            this.b.a(9);
        }
    }
}
