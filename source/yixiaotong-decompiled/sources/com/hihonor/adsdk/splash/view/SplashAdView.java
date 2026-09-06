package com.hihonor.adsdk.splash.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import com.hihonor.adsdk.base.api.BaseAd;
import com.hihonor.adsdk.base.d.a;
import com.hihonor.adsdk.base.widget.base.BaseAdView;
import com.hihonor.adsdk.common.b.b;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class SplashAdView extends BaseAdView<BaseAd> {
    private static final String c = "SplashAdView";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private BaseSplashAdView f3588a;
    private int b;

    public SplashAdView(Context context) {
        this(context, null);
    }

    @Override // com.hihonor.adsdk.base.widget.base.BaseAdView
    public void bindAd(BaseAd baseAd) throws IllegalArgumentException {
        super.bindAd(baseAd);
        if (baseAd == null) {
            b.hnadsc(c, "ad is null", new Object[0]);
            return;
        }
        BaseSplashAdView baseSplashAdViewA = com.hihonor.adsdk.splash.b.a(this.context, baseAd, new BaseSplashAdView.a() { // from class: com.hihonor.adsdk.splash.view.SplashAdView$$ExternalSyntheticLambda0
            @Override // com.hihonor.adsdk.splash.view.BaseSplashAdView.a
            public final void a(View view, int i) {
                this.f$0.triggerClick(view, i);
            }
        });
        this.f3588a = baseSplashAdViewA;
        addView(baseSplashAdViewA);
    }

    @Override // com.hihonor.adsdk.base.widget.base.BaseAdView
    protected void initView() {
        this.isClickable = false;
    }

    @Override // com.hihonor.adsdk.base.widget.base.BaseAdView
    protected void onImpression() {
        super.onImpression();
        b.hnadsc(c, "onImpression", new Object[0]);
        a.hnadsb().hnadsa(this.mAd, this.b);
    }

    @Override // com.hihonor.adsdk.base.widget.base.BaseAdView, com.hihonor.adsdk.base.widget.base.IAdView
    public void release() {
        super.release();
        BaseSplashAdView baseSplashAdView = this.f3588a;
        if (baseSplashAdView != null) {
            baseSplashAdView.k();
        }
    }

    public void setLoadType(int i) {
        this.b = i;
    }

    public SplashAdView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public void a(View view, int i) {
        BaseSplashAdView baseSplashAdView = this.f3588a;
        if (baseSplashAdView != null) {
            baseSplashAdView.a(view, i);
        }
    }

    public void setLogoArea(View view) {
        BaseSplashAdView baseSplashAdView = this.f3588a;
        if (baseSplashAdView != null) {
            baseSplashAdView.setLogoArea(view);
        }
    }

    public void setLogoResId(int i) {
        BaseSplashAdView baseSplashAdView = this.f3588a;
        if (baseSplashAdView != null) {
            baseSplashAdView.setLogoResId(i);
        }
    }

    public void setLogoView(Bitmap bitmap) {
        BaseSplashAdView baseSplashAdView = this.f3588a;
        if (baseSplashAdView != null) {
            baseSplashAdView.setLogoView(bitmap);
        }
    }

    public void setMediaCopyrightResId(int i) {
        BaseSplashAdView baseSplashAdView = this.f3588a;
        if (baseSplashAdView != null) {
            baseSplashAdView.setMediaCopyrightResId(i);
        }
    }

    public void setMediaCopyrightString(String str) {
        BaseSplashAdView baseSplashAdView = this.f3588a;
        if (baseSplashAdView != null) {
            baseSplashAdView.setMediaCopyrightString(str);
        }
    }

    public void setMediaNameResId(int i) {
        BaseSplashAdView baseSplashAdView = this.f3588a;
        if (baseSplashAdView != null) {
            baseSplashAdView.setMediaNameResId(i);
        }
    }

    public void setMediaNameString(String str) {
        BaseSplashAdView baseSplashAdView = this.f3588a;
        if (baseSplashAdView != null) {
            baseSplashAdView.setMediaNameString(str);
        }
    }

    public SplashAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = -1;
    }
}
