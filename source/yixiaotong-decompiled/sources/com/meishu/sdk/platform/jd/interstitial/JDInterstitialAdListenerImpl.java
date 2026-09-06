package com.meishu.sdk.platform.jd.interstitial;

import android.text.TextUtils;
import android.view.View;
import com.jd.ad.sdk.interstitial.JADInterstitial;
import com.jd.ad.sdk.interstitial.JADInterstitialListener;
import com.meishu.sdk.core.ad.interstitial.b;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.f;
import com.meishu.sdk.core.utils.h0;
import com.meishu.sdk.core.utils.i;
import com.meishu.sdk.core.utils.z;
import com.meishu.sdk.platform.jd.JDPlatformError;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class JDInterstitialAdListenerImpl implements JADInterstitialListener {
    private static final String TAG = "JDInterstitialAdListene";
    private JDIntersititialAd jdIntersititialAd;
    private JDInterstitialAdWrapper jdInterstitialAdWrapper;
    private b loadListener;

    public JDInterstitialAdListenerImpl(JDInterstitialAdWrapper jDInterstitialAdWrapper, b bVar, JDIntersititialAd jDIntersititialAd) {
        this.jdInterstitialAdWrapper = jDInterstitialAdWrapper;
        this.loadListener = bVar;
        this.jdIntersititialAd = jDIntersititialAd;
    }

    @Override // com.jd.ad.sdk.interstitial.JADInterstitialListener
    public void onClick() {
        try {
            if (this.jdInterstitialAdWrapper.getSdkAdInfo() != null && !TextUtils.isEmpty(this.jdInterstitialAdWrapper.getSdkAdInfo().getClk())) {
                LogUtil.d(TAG, "send onADClicked");
                z.a(this.jdInterstitialAdWrapper.getContext(), f.a(this.jdInterstitialAdWrapper.getSdkAdInfo().getClk(), this.jdIntersititialAd), new i());
            }
            JDIntersititialAd jDIntersititialAd = this.jdIntersititialAd;
            if (jDIntersititialAd == null || jDIntersititialAd.getInteractionListener() == null) {
                return;
            }
            this.jdIntersititialAd.getInteractionListener().onAdClicked();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.jd.ad.sdk.interstitial.JADInterstitialListener
    public void onExposure() {
        try {
            h0.a(this.jdInterstitialAdWrapper.getSdkAdInfo(), this.jdIntersititialAd.getAdView());
            b bVar = this.loadListener;
            if (bVar != null) {
                bVar.onAdExposure();
            }
            JDIntersititialAd jDIntersititialAd = this.jdIntersititialAd;
            if (jDIntersititialAd == null || jDIntersititialAd.getInteractionListener() == null) {
                return;
            }
            this.jdIntersititialAd.getInteractionListener().onAdExposure();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.jd.ad.sdk.interstitial.JADInterstitialListener
    public void onLoadFailure(int i, String str) {
        new JDPlatformError(str, Integer.valueOf(i), this.jdInterstitialAdWrapper.getSdkAdInfo()).post(this.loadListener);
    }

    @Override // com.jd.ad.sdk.interstitial.JADInterstitialListener
    public void onLoadSuccess() {
        try {
            JDIntersititialAd jDIntersititialAd = this.jdIntersititialAd;
            if (jDIntersititialAd != null && jDIntersititialAd.getInterstitialAd() != null) {
                this.jdInterstitialAdWrapper.getSdkAdInfo().getRsp();
                this.jdInterstitialAdWrapper.getSdkAdInfo().getImp();
                JADInterstitial interstitialAd = this.jdIntersititialAd.getInterstitialAd();
                if (interstitialAd.getExtra() != null) {
                    this.jdInterstitialAdWrapper.getSdkAdInfo().setEcpm(String.valueOf(interstitialAd.getExtra().getPrice()));
                }
            }
            b bVar = this.loadListener;
            if (bVar != null) {
                bVar.onAdLoaded(this.jdIntersititialAd);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.jd.ad.sdk.interstitial.JADInterstitialListener
    public void onRenderSuccess(View view) {
        try {
            this.jdIntersititialAd.setAdView(view);
            b bVar = this.loadListener;
            if (bVar != null) {
                bVar.onAdReady(this.jdIntersititialAd);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.jd.ad.sdk.interstitial.JADInterstitialListener
    public void onClose() {
        try {
            b bVar = this.loadListener;
            if (bVar != null) {
                bVar.onAdClosed();
            }
            JDIntersititialAd jDIntersititialAd = this.jdIntersititialAd;
            if (jDIntersititialAd == null || jDIntersititialAd.getInteractionListener() == null) {
                return;
            }
            this.jdIntersititialAd.getInteractionListener().onAdClosed();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.jd.ad.sdk.interstitial.JADInterstitialListener
    public void onRenderFailure(int i, String str) {
        try {
            b bVar = this.loadListener;
            if (bVar != null) {
                bVar.onAdRenderFail(str, i);
            }
            new JDPlatformError(str, Integer.valueOf(i), this.jdInterstitialAdWrapper.getSdkAdInfo()).post(this.loadListener);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
