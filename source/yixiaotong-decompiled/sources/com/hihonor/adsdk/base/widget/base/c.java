package com.hihonor.adsdk.base.widget.base;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.motion.widget.Key;
import com.hihonor.adsdk.base.R;
import com.hihonor.adsdk.base.api.BaseAd;
import com.hihonor.adsdk.common.f.u;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public abstract class c extends com.hihonor.adsdk.base.widget.base.b {
    private static final String h = "BaseAdWebActivity";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected ImageView f3513a;
    protected ImageView b;
    protected ProgressBar c;
    protected ScrollView d;
    protected FrameLayout e;
    protected FrameLayout f;
    protected FrameLayout g;

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
            c.this.hnadsd(this.hnadsb);
        }
    }

    /* JADX INFO: renamed from: com.hihonor.adsdk.base.widget.base.c$c, reason: collision with other inner class name */
    public static class C0452c extends f.b {
        public C0452c(c cVar) {
            super(cVar);
        }

        @Override // com.hihonor.adsdk.base.widget.base.f.b, android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            c cVar = (c) hnadsa(this.hnadsa);
            if (cVar != null) {
                cVar.c.setVisibility(8);
                cVar.c.setProgress(0);
            }
        }

        @Override // com.hihonor.adsdk.base.widget.base.f.b, android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            c cVar = (c) hnadsa(this.hnadsa);
            if (cVar != null) {
                cVar.c.setVisibility(0);
            }
        }
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

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void hnadsc(View view) {
        hnadse(this.hnadsf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hnadsd(int i) {
        this.e.setVisibility(0);
        ImageView imageView = (ImageView) findViewById(R.id.ad_ad_common_retry_image_wlan);
        TextView textView = (TextView) findViewById(R.id.ad_ad_common_retry_text);
        if (i == 31005) {
            this.e.setClickable(false);
            imageView.setVisibility(8);
            textView.setText(getText(R.string.ads_web_unable_open));
        } else {
            this.e.setClickable(true);
            imageView.setVisibility(0);
            textView.setText(getText(R.string.ads_web_unable_get_info));
        }
        this.c.setVisibility(8);
        this.b.setVisibility(8);
    }

    public void hnadse(int i) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, ((u.hnadsd() - u.hnadsa(56.0f)) - i) + u.hnadsa(22.0f));
        FrameLayout frameLayout = this.e;
        if (frameLayout != null) {
            frameLayout.setLayoutParams(layoutParams);
        }
        FrameLayout frameLayout2 = this.f;
        if (frameLayout2 != null) {
            frameLayout2.setLayoutParams(layoutParams);
        }
    }

    @Override // com.hihonor.adsdk.base.widget.base.f
    protected String hnadsg() {
        T t = this.hnadsg;
        return t != 0 ? ((BaseAd) t).getLandingPageUrl() : "";
    }

    @Override // com.hihonor.adsdk.base.widget.base.f
    protected int hnadsh() {
        return R.layout.activity_honor_ads_web_common;
    }

    @Override // com.hihonor.adsdk.base.widget.base.f
    protected FrameLayout hnadsi() {
        return this.f;
    }

    @Override // com.hihonor.adsdk.base.widget.base.f
    protected void hnadsp() {
        com.hihonor.adsdk.common.b.b.hnadsc(h, "initWidget", new Object[0]);
        ImageView imageView = (ImageView) findViewById(R.id.ad_common_web_close);
        this.f3513a = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.hihonor.adsdk.base.widget.base.c$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.hnadsa(view);
            }
        });
        ImageView imageView2 = (ImageView) findViewById(R.id.ad_common_refresh);
        this.b = imageView2;
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.hihonor.adsdk.base.widget.base.c$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.hnadsb(view);
            }
        });
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.ad_common_web_progress_bar);
        this.c = progressBar;
        progressBar.setProgress(10);
        hnadsu();
        FrameLayout frameLayout = this.e;
        if (frameLayout != null) {
            frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.hihonor.adsdk.base.widget.base.c$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.hnadsc(view);
                }
            });
        }
        this.g = (FrameLayout) findViewById(R.id.ad_common_web_bottom_layout);
        hnadsv();
    }

    protected abstract void hnadsu();

    protected abstract void hnadsv();

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void hnadsa(View view) {
        finish();
    }

    @Override // com.hihonor.adsdk.base.widget.base.f
    protected void hnadsc(int i) {
        super.hnadsc(i);
        this.c.setProgress(i);
        if (i == 100) {
            this.c.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void hnadsa(ValueAnimator valueAnimator) {
        this.c.setProgress(((Integer) valueAnimator.getAnimatedValue()).intValue());
    }

    @Override // com.hihonor.adsdk.base.widget.base.f
    protected void hnadsb(int i) {
        com.hihonor.adsdk.common.b.b.hnadsc(h, "setLoadLayoutVisibility isVisibility = " + (i != 0), new Object[0]);
        this.e.setVisibility(8);
        this.b.setVisibility(0);
        this.c.setVisibility(0);
        if (i != 0) {
            ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, 95);
            valueAnimatorOfInt.setDuration(400L);
            valueAnimatorOfInt.setInterpolator(new AccelerateDecelerateInterpolator());
            valueAnimatorOfInt.addListener(new b(valueAnimatorOfInt, i));
            valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.hihonor.adsdk.base.widget.base.c$$ExternalSyntheticLambda3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    this.f$0.hnadsa(valueAnimator);
                }
            });
            valueAnimatorOfInt.start();
        }
    }

    @Override // com.hihonor.adsdk.base.widget.base.f
    protected f.b hnadse() {
        return new C0452c(this);
    }
}
