package com.hihonor.adsdk.splash;

import android.graphics.Bitmap;
import android.view.View;
import com.hihonor.adsdk.base.HnAds;
import com.hihonor.adsdk.base.api.BaseExpressAdImpl;
import com.hihonor.adsdk.base.api.splash.SplashExpressAd;
import com.hihonor.adsdk.base.bean.BaseAdInfo;
import com.hihonor.adsdk.base.widget.base.BaseAdView;
import com.hihonor.adsdk.splash.view.SplashAdView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class SplashExpressAdImpl extends BaseExpressAdImpl implements SplashExpressAd {
    private static final String TAG = "SplashExpressAdImpl";
    private boolean isCachedData;
    private int mLoadType;
    private SplashAdView mSplashAdView;

    public SplashExpressAdImpl(BaseAdInfo baseAdInfo, boolean z, int i) {
        this(null, baseAdInfo);
        this.isCachedData = z;
        this.mLoadType = i;
    }

    @Override // com.hihonor.adsdk.base.api.BaseExpressAdImpl, com.hihonor.adsdk.base.api.BaseExpressAd
    public View getExpressAdView() {
        com.hihonor.adsdk.common.b.b.hnadsc(TAG, "media get splash express view. mAdView=null " + (this.hnadsg == null), new Object[0]);
        if (this.hnadsg == null && this.hnadsl == 0) {
            SplashAdView splashAdView = new SplashAdView(HnAds.get().getContext());
            this.mSplashAdView = splashAdView;
            splashAdView.setLoadType(this.mLoadType);
            this.mSplashAdView.bindAd(this);
            this.hnadsg = this.mSplashAdView;
        }
        return super.getExpressAdView();
    }

    @Override // com.hihonor.adsdk.base.api.splash.SplashExpressAd
    public boolean isCachedData() {
        return this.isCachedData;
    }

    @Override // com.hihonor.adsdk.base.api.splash.SplashExpressAd
    public void setLogoArea(View view) {
        SplashAdView splashAdView = this.mSplashAdView;
        if (splashAdView != null) {
            splashAdView.setLogoArea(view);
        }
    }

    @Override // com.hihonor.adsdk.base.api.splash.SplashExpressAd
    public void setLogoResId(int i) {
        SplashAdView splashAdView = this.mSplashAdView;
        if (splashAdView != null) {
            splashAdView.setLogoResId(i);
        }
    }

    @Override // com.hihonor.adsdk.base.api.splash.SplashExpressAd
    public void setLogoView(Bitmap bitmap) {
        SplashAdView splashAdView = this.mSplashAdView;
        if (splashAdView != null) {
            splashAdView.setLogoView(bitmap);
        }
    }

    @Override // com.hihonor.adsdk.base.api.splash.SplashExpressAd
    public void setMediaCopyrightResId(int i) {
        SplashAdView splashAdView = this.mSplashAdView;
        if (splashAdView != null) {
            splashAdView.setMediaCopyrightResId(i);
        }
    }

    @Override // com.hihonor.adsdk.base.api.splash.SplashExpressAd
    public void setMediaCopyrightString(String str) {
        SplashAdView splashAdView = this.mSplashAdView;
        if (splashAdView != null) {
            splashAdView.setMediaCopyrightString(str);
        }
    }

    @Override // com.hihonor.adsdk.base.api.splash.SplashExpressAd
    public void setMediaNameResId(int i) {
        SplashAdView splashAdView = this.mSplashAdView;
        if (splashAdView != null) {
            splashAdView.setMediaNameResId(i);
        }
    }

    @Override // com.hihonor.adsdk.base.api.splash.SplashExpressAd
    public void setMediaNameString(String str) {
        SplashAdView splashAdView = this.mSplashAdView;
        if (splashAdView != null) {
            splashAdView.setMediaNameString(str);
        }
    }

    public SplashExpressAdImpl(BaseAdView baseAdView, BaseAdInfo baseAdInfo) {
        super(baseAdView, baseAdInfo);
        this.mLoadType = -1;
        if (baseAdView instanceof SplashAdView) {
            this.mSplashAdView = (SplashAdView) baseAdView;
        }
    }

    @Override // com.hihonor.adsdk.base.api.splash.SplashExpressAd
    public void setLogoArea(View view, int i) {
        SplashAdView splashAdView = this.mSplashAdView;
        if (splashAdView != null) {
            splashAdView.a(view, i);
        }
    }
}
