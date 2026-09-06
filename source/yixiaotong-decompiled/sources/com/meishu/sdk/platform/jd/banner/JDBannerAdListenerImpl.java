package com.meishu.sdk.platform.jd.banner;

import android.text.TextUtils;
import android.view.View;
import com.jd.ad.sdk.banner.JADBanner;
import com.jd.ad.sdk.banner.JADBannerListener;
import com.meishu.sdk.core.ad.banner.b;
import com.meishu.sdk.core.loader.a;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.f;
import com.meishu.sdk.core.utils.h0;
import com.meishu.sdk.platform.jd.JDPlatformError;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class JDBannerAdListenerImpl implements JADBannerListener {
    private static final String TAG = "JDBannerAdListenerImpl";
    private JDBannerAd jdBannerAd;
    private JDBannerAdWrapper jdBannerAdWrapper;
    private b loadListener;

    public JDBannerAdListenerImpl(JDBannerAdWrapper jDBannerAdWrapper, b bVar, JDBannerAd jDBannerAd) {
        this.jdBannerAdWrapper = jDBannerAdWrapper;
        this.loadListener = bVar;
        this.jdBannerAd = jDBannerAd;
    }

    @Override // com.jd.ad.sdk.banner.JADBannerListener
    public void onClick() {
        if (this.jdBannerAdWrapper.getSdkAdInfo() != null && !TextUtils.isEmpty(this.jdBannerAdWrapper.getSdkAdInfo().getClk())) {
            LogUtil.d(TAG, "send onADClicked");
            a.a(this.jdBannerAdWrapper.getContext(), f.a(this.jdBannerAdWrapper.getSdkAdInfo().getClk(), this.jdBannerAd));
        }
        JDBannerAd jDBannerAd = this.jdBannerAd;
        if (jDBannerAd == null || jDBannerAd.getInteractionListener() == null) {
            return;
        }
        this.jdBannerAd.getInteractionListener().onAdClicked();
    }

    @Override // com.jd.ad.sdk.banner.JADBannerListener
    public void onExposure() {
        h0.a(this.jdBannerAdWrapper.getSdkAdInfo(), this.jdBannerAd.getAdView());
        b bVar = this.loadListener;
        if (bVar != null) {
            bVar.onAdExposure();
        }
        JDBannerAd jDBannerAd = this.jdBannerAd;
        if (jDBannerAd == null || jDBannerAd.getInteractionListener() == null) {
            return;
        }
        this.jdBannerAd.getInteractionListener().onAdExposure();
    }

    @Override // com.jd.ad.sdk.banner.JADBannerListener
    public void onLoadFailure(int i, String str) {
        new JDPlatformError(str, Integer.valueOf(i), this.jdBannerAdWrapper.getSdkAdInfo()).post(this.loadListener);
    }

    @Override // com.jd.ad.sdk.banner.JADBannerListener
    public void onLoadSuccess() {
        try {
            JDBannerAd jDBannerAd = this.jdBannerAd;
            if (jDBannerAd != null && jDBannerAd.getBannerAd() != null) {
                this.jdBannerAdWrapper.getSdkAdInfo().getRsp();
                this.jdBannerAdWrapper.getSdkAdInfo().getImp();
                JADBanner bannerAd = this.jdBannerAd.getBannerAd();
                if (bannerAd.getExtra() != null) {
                    this.jdBannerAdWrapper.getSdkAdInfo().setEcpm(bannerAd.getExtra().getPrice() + "");
                }
            }
            b bVar = this.loadListener;
            if (bVar != null) {
                bVar.onAdLoaded(this.jdBannerAd);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.jd.ad.sdk.banner.JADBannerListener
    public void onRenderSuccess(View view) {
        this.jdBannerAd.setAdView(view);
        b bVar = this.loadListener;
        if (bVar != null) {
            bVar.onAdReady(this.jdBannerAd);
        }
    }

    @Override // com.jd.ad.sdk.banner.JADBannerListener
    public void onClose() {
        b bVar = this.loadListener;
        if (bVar != null) {
            bVar.onAdClosed();
        }
        JDBannerAd jDBannerAd = this.jdBannerAd;
        if (jDBannerAd == null || jDBannerAd.getInteractionListener() == null) {
            return;
        }
        this.jdBannerAd.getInteractionListener().onAdClosed();
    }

    @Override // com.jd.ad.sdk.banner.JADBannerListener
    public void onRenderFailure(int i, String str) {
        b bVar = this.loadListener;
        if (bVar != null) {
            bVar.onAdRenderFail(str, i);
        }
        new JDPlatformError(str, Integer.valueOf(i), this.jdBannerAdWrapper.getSdkAdInfo()).post(this.loadListener);
    }
}
