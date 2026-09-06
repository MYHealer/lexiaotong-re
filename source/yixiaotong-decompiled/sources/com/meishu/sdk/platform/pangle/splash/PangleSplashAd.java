package com.meishu.sdk.platform.pangle.splash;

import android.app.Activity;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.api.open.PAGAppOpenAd;
import com.meishu.sdk.platform.custom.splash.MsCustomSplashAd;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class PangleSplashAd extends MsCustomSplashAd {
    private PAGAppOpenAd appOpenAd;
    private boolean showed;

    public PangleSplashAd(PangleSplashAdapter pangleSplashAdapter, PAGAppOpenAd pAGAppOpenAd) {
        super(pangleSplashAdapter);
        this.appOpenAd = pAGAppOpenAd;
    }

    @Override // com.meishu.sdk.core.ad.splash.c, com.meishu.sdk.core.ad.splash.ISplashAd
    public void showAd(ViewGroup viewGroup) {
        PAGAppOpenAd pAGAppOpenAd;
        if (viewGroup != null) {
            try {
                if (!(viewGroup.getContext() instanceof Activity) || (pAGAppOpenAd = this.appOpenAd) == null) {
                    return;
                }
                pAGAppOpenAd.show((Activity) viewGroup.getContext());
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
