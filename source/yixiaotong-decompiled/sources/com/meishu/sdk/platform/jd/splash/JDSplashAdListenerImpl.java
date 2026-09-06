package com.meishu.sdk.platform.jd.splash;

import android.text.TextUtils;
import android.view.View;
import com.jd.ad.sdk.splash.JADSplash;
import com.jd.ad.sdk.splash.JADSplashListener;
import com.meishu.sdk.core.ad.splash.d;
import com.meishu.sdk.core.loader.a;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.f;
import com.meishu.sdk.core.utils.h0;
import com.meishu.sdk.platform.jd.JDPlatformError;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class JDSplashAdListenerImpl implements JADSplashListener {
    private static final String TAG = "JDSplashAdListenerImpl";
    private boolean autoShow;
    private JDSplashAdWrapper jdSplashAdWrapper;
    private boolean loadSuccess;
    private d splashADListener;
    private JDSplashAd splashAd;

    public JDSplashAdListenerImpl(JDSplashAdWrapper jDSplashAdWrapper, d dVar, JDSplashAd jDSplashAd, boolean z) {
        this.jdSplashAdWrapper = jDSplashAdWrapper;
        this.splashADListener = dVar;
        this.splashAd = jDSplashAd;
        this.autoShow = z;
    }

    @Override // com.jd.ad.sdk.splash.JADSplashListener
    public void onClick() {
        if (this.jdSplashAdWrapper.getSdkAdInfo() != null && !TextUtils.isEmpty(this.jdSplashAdWrapper.getSdkAdInfo().getClk())) {
            LogUtil.d(TAG, "send onADClicked");
            a.a(this.jdSplashAdWrapper.getContext(), f.a(this.jdSplashAdWrapper.getSdkAdInfo().getClk(), this.splashAd));
        }
        JDSplashAd jDSplashAd = this.splashAd;
        if (jDSplashAd == null || jDSplashAd.getInteractionListener() == null) {
            return;
        }
        this.splashAd.getInteractionListener().onAdClicked();
    }

    @Override // com.jd.ad.sdk.splash.JADSplashListener
    public void onClose() {
        LogUtil.d(TAG, "onADDismissed: ");
        d dVar = this.splashADListener;
        if (dVar != null && this.loadSuccess) {
            dVar.onAdClosed();
        }
        JDSplashAd jDSplashAd = this.splashAd;
        if (jDSplashAd == null || jDSplashAd.getInteractionListener() == null) {
            return;
        }
        this.splashAd.getInteractionListener().onAdClosed();
    }

    @Override // com.jd.ad.sdk.splash.JADSplashListener
    public void onExposure() {
        h0.a(this.jdSplashAdWrapper.getSdkAdInfo(), this.splashAd.getAdView());
        d dVar = this.splashADListener;
        if (dVar != null) {
            dVar.onAdExposure();
        }
        JDSplashAd jDSplashAd = this.splashAd;
        if (jDSplashAd == null || jDSplashAd.getInteractionListener() == null) {
            return;
        }
        this.splashAd.getInteractionListener().onAdExposure();
    }

    @Override // com.jd.ad.sdk.splash.JADSplashListener
    public void onLoadFailure(int i, String str) {
        new JDPlatformError(str, Integer.valueOf(i), this.jdSplashAdWrapper.getSdkAdInfo()).post(this.splashADListener);
    }

    @Override // com.jd.ad.sdk.splash.JADSplashListener
    public void onLoadSuccess() {
        JDSplashAd jDSplashAd = this.splashAd;
        if (jDSplashAd == null || jDSplashAd.getSplashAd() == null) {
            return;
        }
        this.loadSuccess = true;
        JADSplash splashAd = this.splashAd.getSplashAd();
        if (splashAd.getJADExtra() != null) {
            this.jdSplashAdWrapper.getSdkAdInfo().setEcpm(String.valueOf(splashAd.getJADExtra().getPrice()));
        }
    }

    @Override // com.jd.ad.sdk.splash.JADSplashListener
    public void onRenderSuccess(View view) {
        this.splashAd.setAdView(view);
        d dVar = this.splashADListener;
        if (dVar != null) {
            dVar.onAdLoaded(this.splashAd);
            this.splashADListener.onAdReady(this.splashAd);
            this.splashADListener.onAdPresent(this.splashAd);
        }
    }

    @Override // com.jd.ad.sdk.splash.JADSplashListener
    public void onRenderFailure(int i, String str) {
        d dVar = this.splashADListener;
        if (dVar != null) {
            dVar.onAdRenderFail(str, i);
        }
        new JDPlatformError(str, Integer.valueOf(i), this.jdSplashAdWrapper.getSdkAdInfo()).post(this.splashADListener);
    }
}
