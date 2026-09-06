package com.meishu.sdk.platform.bd.splash;

import android.text.TextUtils;
import com.baidu.mobads.sdk.api.SplashInteractionListener;
import com.meishu.sdk.core.ad.splash.d;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.f;
import com.meishu.sdk.core.utils.h0;
import com.meishu.sdk.core.utils.i;
import com.meishu.sdk.core.utils.z;
import com.meishu.sdk.platform.bd.BDPlatformError;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class BDSplashListener implements SplashInteractionListener {
    private static final String TAG = "BDSplashListener";
    private boolean isAdLoaded;
    private boolean isExposed = false;
    public BDSplashAdLoader loader;
    public d meishuListener;
    public BDSplashAd splashAd;

    public BDSplashListener(BDSplashAdLoader bDSplashAdLoader, d dVar, BDSplashAd bDSplashAd) {
        this.loader = bDSplashAdLoader;
        this.meishuListener = dVar;
        this.splashAd = bDSplashAd;
    }

    @Override // com.baidu.mobads.sdk.api.SplashAdListener
    public void onADLoaded() {
        LogUtil.e(TAG, "bd onADLoaded------------------------");
        LogUtil.e(TAG, "currentThread=" + Thread.currentThread().getName());
        try {
            if (this.meishuListener != null) {
                try {
                    this.loader.getSdkAdInfo().setEcpm(this.splashAd.getSplashAd().getECPMLevel());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                this.isAdLoaded = true;
                this.meishuListener.onAdLoaded(this.splashAd);
                this.meishuListener.onAdReady(this.splashAd);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
    public void onAdCacheFailed() {
    }

    @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
    public void onAdCacheSuccess() {
    }

    @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
    public void onAdClick() {
        try {
            if (this.loader.getSdkAdInfo() != null && !TextUtils.isEmpty(this.loader.getSdkAdInfo().getClk())) {
                LogUtil.d(TAG, "send onAdClick");
                z.a(this.loader.getContext(), f.a(this.loader.getSdkAdInfo().getClk(), this.splashAd), new i());
                this.loader.getSdkAdInfo().getMsLoadedTime();
                this.loader.getAdLoader().getPosId();
            }
            BDSplashAd bDSplashAd = this.splashAd;
            if (bDSplashAd == null || bDSplashAd.getInteractionListener() == null) {
                return;
            }
            this.splashAd.getInteractionListener().onAdClicked();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
    public void onAdExposed() {
        try {
            h0.a(this.loader.getSdkAdInfo(), this.loader.getAdLoader().getAdContainer());
            if (this.isExposed) {
                return;
            }
            d dVar = this.meishuListener;
            if (dVar != null) {
                dVar.onAdPresent(this.splashAd);
                this.meishuListener.onAdExposure();
            }
            BDSplashAd bDSplashAd = this.splashAd;
            if (bDSplashAd != null && bDSplashAd.getInteractionListener() != null) {
                this.splashAd.getInteractionListener().onAdExposure();
            }
            this.isExposed = true;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.baidu.mobads.sdk.api.SplashAdListener
    public void onAdFailed(String str) {
        try {
            LogUtil.e(TAG, "onAdFailed, msg: " + str);
            if (this.isAdLoaded) {
                d dVar = this.meishuListener;
                if (dVar != null) {
                    dVar.onAdRenderFail(str, -1);
                }
            } else if (str != null && !str.startsWith("exception")) {
                new BDPlatformError(str, this.loader.getSdkAdInfo()).post(this.meishuListener);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
    public void onAdPresent() {
        try {
            h0.a(this.loader.getSdkAdInfo(), this.loader.getAdLoader().getAdContainer());
            if (this.isExposed) {
                return;
            }
            d dVar = this.meishuListener;
            if (dVar != null) {
                dVar.onAdPresent(this.splashAd);
                this.meishuListener.onAdExposure();
            }
            BDSplashAd bDSplashAd = this.splashAd;
            if (bDSplashAd != null && bDSplashAd.getInteractionListener() != null) {
                this.splashAd.getInteractionListener().onAdExposure();
            }
            this.isExposed = true;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
    public void onAdSkip() {
    }

    @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
    public void onLpClosed() {
    }

    @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
    public void onAdDismissed() {
        try {
            d dVar = this.meishuListener;
            if (dVar != null) {
                dVar.onAdClosed();
            }
            BDSplashAd bDSplashAd = this.splashAd;
            if (bDSplashAd == null || bDSplashAd.getInteractionListener() == null) {
                return;
            }
            this.splashAd.getInteractionListener().onAdClosed();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
