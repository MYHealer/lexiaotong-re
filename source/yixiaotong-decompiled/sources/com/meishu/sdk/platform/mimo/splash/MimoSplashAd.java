package com.meishu.sdk.platform.mimo.splash;

import android.view.ViewGroup;
import com.meishu.sdk.core.ad.splash.c;
import com.meishu.sdk.core.domain.SdkAdInfo;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class MimoSplashAd extends c {
    private static final String TAG = "MimoSplashAd";
    private MimoSplashAdWrapper adWrapper;

    public MimoSplashAd(MimoSplashAdWrapper mimoSplashAdWrapper) {
        super(mimoSplashAdWrapper, "MIMO");
        this.adWrapper = mimoSplashAdWrapper;
    }

    public SdkAdInfo getSdkAdInfo() {
        return this.adWrapper.getSdkAdInfo();
    }

    @Override // com.meishu.sdk.core.ad.splash.c, com.meishu.sdk.core.ad.splash.ISplashAd
    public void showAd(ViewGroup viewGroup) {
    }
}
