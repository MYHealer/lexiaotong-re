package com.meishu.sdk.platform.gdt.interstitial;

import android.app.Activity;
import com.meishu.sdk.core.AdSdk;
import com.meishu.sdk.core.MSAdConfig;
import com.meishu.sdk.core.ad.interstitial.InterstitialAd;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.meishu_ad.lifecycle.c;
import com.meishu.sdk.meishu_ad.lifecycle.d;
import com.qq.e.ads.interstitial2.UnifiedInterstitialAD;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class GDTInterstitialAd extends InterstitialAd {
    private static final String TAG = "GDTInterstitialAd";
    private GDTInterstitialAdWrapper adWrapper;
    private boolean isClick;
    private c lifecycleHelper;
    private d lifecycleListener;
    private UnifiedInterstitialAD unifiedInterstitialAD;

    public GDTInterstitialAd(UnifiedInterstitialAD unifiedInterstitialAD, GDTInterstitialAdWrapper gDTInterstitialAdWrapper) {
        super(gDTInterstitialAdWrapper, MSAdConfig.PLATFORM_GDT);
        this.lifecycleListener = new d() { // from class: com.meishu.sdk.platform.gdt.interstitial.GDTInterstitialAd.1
            @Override // com.meishu.sdk.meishu_ad.lifecycle.d
            public void onDestroy() {
                LogUtil.e(GDTInterstitialAd.TAG, "onDestroy");
            }

            @Override // com.meishu.sdk.meishu_ad.lifecycle.d
            public void onPause() {
                LogUtil.e(GDTInterstitialAd.TAG, "onPause");
                if (GDTInterstitialAd.this.unifiedInterstitialAD == null || GDTInterstitialAd.this.isClick) {
                    return;
                }
                GDTInterstitialAd.this.unifiedInterstitialAD.close();
            }

            @Override // com.meishu.sdk.meishu_ad.lifecycle.d
            public void onResume() {
            }

            @Override // com.meishu.sdk.meishu_ad.lifecycle.d
            public void onStart() {
            }

            @Override // com.meishu.sdk.meishu_ad.lifecycle.d
            public void onStop() {
                LogUtil.e(GDTInterstitialAd.TAG, "onStop");
            }
        };
        this.unifiedInterstitialAD = unifiedInterstitialAD;
        this.adWrapper = gDTInterstitialAdWrapper;
    }

    @Override // com.meishu.sdk.core.ad.a
    public Object getSdkAd() {
        return this.unifiedInterstitialAD;
    }

    public void setClick() {
        this.isClick = true;
    }

    @Override // com.meishu.sdk.core.ad.interstitial.InterstitialAd
    public void showAd() {
        try {
            if (AdSdk.adConfig().getEnableInterstitialAutoClose()) {
                if (this.lifecycleHelper == null) {
                    this.lifecycleHelper = new c();
                }
                if (this.adWrapper.getContext() != null) {
                    this.lifecycleHelper.b = (Activity) this.adWrapper.getContext();
                    this.lifecycleHelper.a(this.lifecycleListener);
                }
            }
            this.unifiedInterstitialAD.show();
            super.showAd();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.meishu.sdk.core.ad.interstitial.InterstitialAd
    public void showAd(Activity activity) {
        try {
            if (AdSdk.adConfig().getEnableInterstitialAutoClose()) {
                if (this.lifecycleHelper == null) {
                    this.lifecycleHelper = new c();
                }
                if (activity != null) {
                    c cVar = this.lifecycleHelper;
                    cVar.b = activity;
                    cVar.a(this.lifecycleListener);
                }
            }
            this.unifiedInterstitialAD.show(activity);
            super.showAd(activity);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
