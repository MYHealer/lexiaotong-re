package com.hihonor.adsdk.base.widget.web;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.constraintlayout.motion.widget.Key;
import com.hihonor.adsdk.base.ErrorCode;
import com.hihonor.adsdk.base.R;
import com.hihonor.adsdk.base.api.BaseAd;
import com.hihonor.adsdk.base.bean.f;
import com.hihonor.adsdk.base.g.j.d.x;
import com.hihonor.adsdk.base.j.h;
import com.hihonor.adsdk.base.widget.base.d;
import com.hihonor.adsdk.common.safe.SafeIntent;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class WebPermissionsActivity extends d {
    private static final String hnadst = "WebPermissionsActivity";
    private static final String hnadsu = "info_page_type";
    protected ImageView hnadso;
    protected ImageView hnadsp;
    protected ProgressBar hnadsq;
    protected FrameLayout hnadsr;
    protected FrameLayout hnadss;

    class a extends AnimatorListenerAdapter {
        final /* synthetic */ ObjectAnimator hnadsa;

        a(ObjectAnimator objectAnimator) {
            this.hnadsa = objectAnimator;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator, boolean z) {
            this.hnadsa.cancel();
        }
    }

    class b extends AnimatorListenerAdapter {
        final /* synthetic */ ValueAnimator hnadsa;
        final /* synthetic */ int hnadsb;

        b(ValueAnimator valueAnimator, int i) {
            this.hnadsa = valueAnimator;
            this.hnadsb = i;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator, boolean z) {
            this.hnadsa.cancel();
            WebPermissionsActivity.this.hnadsd(this.hnadsb);
        }
    }

    public static void hnadsb(BaseAd baseAd, int i) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadst, "startWebTargetPage by ad", new Object[0]);
        Bundle bundle = new Bundle();
        bundle.putInt(hnadsu, i);
        bundle.putParcelable("info", baseAd);
        f fVarHnadsa = h.hnadsa(WebPermissionsActivity.class, bundle);
        if (Objects.isNull(fVarHnadsa)) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadst, "startPermissionsPage resultBean is null", new Object[0]);
            return;
        }
        com.hihonor.adsdk.common.b.b.hnadsc(hnadst, "startPermissionsPage code = %s, msg = %s", Integer.valueOf(fVarHnadsa.hnadsa()), fVarHnadsa.hnadsb());
        if (fVarHnadsa.hnadsa() != 0) {
            new x(Objects.nonNull(baseAd) ? baseAd.getAdUnitId() : "", com.hihonor.adsdk.base.g.j.g.b.hnadsb(), ErrorCode.AD_CODE_START_ACTIVITY_FAILED, fVarHnadsa.hnadsb()).hnadsa("code", String.valueOf(fVarHnadsa.hnadsa())).hnadse();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void hnadsc(View view) {
        hnadse(this.hnadsf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hnadsd(int i) {
        if (i == 31005) {
            this.hnadsr.setVisibility(8);
        } else {
            this.hnadsr.setVisibility(0);
        }
        this.hnadsq.setVisibility(8);
        this.hnadsp.setVisibility(8);
    }

    @Override // com.hihonor.adsdk.base.widget.base.f
    protected void hnadsf() {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadst, "destroy", new Object[0]);
        this.hnadse.hnadsa(this.hnadsf, 0, 0);
    }

    @Override // com.hihonor.adsdk.base.widget.base.f
    protected String hnadsg() {
        SafeIntent safeIntent = new SafeIntent(getIntent());
        safeIntent.setExtrasClassLoader(getClassLoader());
        int intExtra = safeIntent.getIntExtra(hnadsu, 0);
        this.hnadse.hnadsb(intExtra);
        return hnadsa((BaseAd) this.hnadsg, intExtra);
    }

    @Override // com.hihonor.adsdk.base.widget.base.f
    protected int hnadsh() {
        return R.layout.activity_honor_ads_web_permissions;
    }

    @Override // com.hihonor.adsdk.base.widget.base.f
    protected FrameLayout hnadsi() {
        return this.hnadss;
    }

    @Override // com.hihonor.adsdk.base.widget.base.f
    protected int hnadsk() {
        return 1;
    }

    @Override // com.hihonor.adsdk.base.widget.base.f
    protected void hnadsp() {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadst, "initWidget", new Object[0]);
        ImageView imageView = (ImageView) findViewById(R.id.ad_common_web_close);
        this.hnadso = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.hihonor.adsdk.base.widget.web.WebPermissionsActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.hnadsa(view);
            }
        });
        ImageView imageView2 = (ImageView) findViewById(R.id.ad_common_refresh);
        this.hnadsp = imageView2;
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.hihonor.adsdk.base.widget.web.WebPermissionsActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.hnadsb(view);
            }
        });
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.ad_common_web_progress_bar);
        this.hnadsq = progressBar;
        progressBar.setProgress(10);
        findViewById(R.id.fra_web).setVisibility(0);
        this.hnadsr = (FrameLayout) findViewById(R.id.ad_common_retry_layout);
        this.hnadss = (FrameLayout) findViewById(R.id.ad_common_web_view_layout);
        FrameLayout frameLayout = this.hnadsr;
        if (frameLayout != null) {
            frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.hihonor.adsdk.base.widget.web.WebPermissionsActivity$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.hnadsc(view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void hnadsa(View view) {
        finish();
    }

    @Override // com.hihonor.adsdk.base.widget.base.f
    protected void hnadsc(int i) {
        super.hnadsc(i);
        this.hnadsq.setProgress(i);
        if (i == 100) {
            this.hnadsq.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void hnadsa(ValueAnimator valueAnimator) {
        this.hnadsq.setProgress(((Integer) valueAnimator.getAnimatedValue()).intValue());
    }

    private String hnadsa(BaseAd baseAd, int i) {
        if (baseAd == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadst, "getLoadUrl#BaseAd is null", new Object[0]);
            return "";
        }
        com.hihonor.adsdk.common.b.b.hnadsc(hnadst, "getLoadUrl#BaseAd pageType: " + i, new Object[0]);
        if (i == 1) {
            return baseAd.getPrivacyAgreementUrl();
        }
        if (i == 2) {
            return baseAd.getPermissionsUrl();
        }
        if (i != 3) {
            return i != 4 ? "" : baseAd.getIntroUrl();
        }
        return baseAd.getHomePage();
    }

    @Override // com.hihonor.adsdk.base.widget.base.f
    protected void hnadsc(String str) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadst, "loadStart", new Object[0]);
        this.hnadsf = str;
        this.hnadse.hnadsa(str);
    }

    @Override // com.hihonor.adsdk.base.widget.base.f
    protected void hnadsd(String str) {
        this.hnadsf = str;
        com.hihonor.adsdk.common.b.b.hnadsc(hnadst, "loadSuccess", new Object[0]);
        this.hnadse.hnadsb(this.hnadsf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void hnadsb(View view) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, Key.ROTATION, 360.0f, 0.0f);
        objectAnimatorOfFloat.setDuration(300L);
        objectAnimatorOfFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        objectAnimatorOfFloat.addListener(new a(objectAnimatorOfFloat));
        objectAnimatorOfFloat.start();
        hnadse(this.hnadsf);
    }

    @Override // com.hihonor.adsdk.base.widget.base.f
    protected void hnadsa(int i, String str, String str2) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadst, "loadFail, code : " + i + ",description " + str, new Object[0]);
        this.hnadsf = str2;
        this.hnadse.hnadsa(str2, Integer.valueOf(i), str);
    }

    @Override // com.hihonor.adsdk.base.widget.base.f
    protected void hnadsb(int i) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadst, "setLoadLayoutVisibility isVisibility = " + (i != 0), new Object[0]);
        this.hnadsr.setVisibility(8);
        this.hnadsp.setVisibility(0);
        this.hnadsq.setVisibility(0);
        if (i != 0) {
            ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, 95);
            valueAnimatorOfInt.setDuration(400L);
            valueAnimatorOfInt.setInterpolator(new AccelerateDecelerateInterpolator());
            valueAnimatorOfInt.addListener(new b(valueAnimatorOfInt, i));
            valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.hihonor.adsdk.base.widget.web.WebPermissionsActivity$$ExternalSyntheticLambda0
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    this.f$0.hnadsa(valueAnimator);
                }
            });
            valueAnimatorOfInt.start();
        }
    }
}
