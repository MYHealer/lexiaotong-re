package com.meishu.sdk.platform.gdt.fullscreenvideo;

import android.app.Activity;
import com.meishu.sdk.core.MSAdConfig;
import com.meishu.sdk.core.ad.fullscreenvideo.IFullScreenMediaListener;
import com.meishu.sdk.core.ad.fullscreenvideo.b;
import com.qq.e.ads.interstitial2.UnifiedInterstitialAD;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class GDTFullScreenVideoAd extends b {
    private GDTFullScreenVideoAdWrapper adWrapper;
    private IFullScreenMediaListener mFullScreenMediaListener;
    private UnifiedInterstitialAD unifiedInterstitialAD;

    public GDTFullScreenVideoAd(GDTFullScreenVideoAdWrapper gDTFullScreenVideoAdWrapper) {
        super(gDTFullScreenVideoAdWrapper, MSAdConfig.PLATFORM_GDT);
        this.adWrapper = gDTFullScreenVideoAdWrapper;
    }

    public IFullScreenMediaListener getMediaListener() {
        return this.mFullScreenMediaListener;
    }

    @Override // com.meishu.sdk.core.ad.a
    public Object getSdkAd() {
        return this.unifiedInterstitialAD;
    }

    public UnifiedInterstitialAD getUnifiedInterstitialAD() {
        return this.unifiedInterstitialAD;
    }

    @Override // com.meishu.sdk.core.ad.fullscreenvideo.IFullScreenVideoAd
    public void setMediaListener(IFullScreenMediaListener iFullScreenMediaListener) {
        this.mFullScreenMediaListener = iFullScreenMediaListener;
    }

    public void setUnifiedInterstitialAD(UnifiedInterstitialAD unifiedInterstitialAD) {
        this.unifiedInterstitialAD = unifiedInterstitialAD;
    }

    @Override // com.meishu.sdk.core.ad.fullscreenvideo.b, com.meishu.sdk.core.ad.fullscreenvideo.IFullScreenVideoAd
    public void showAd() {
        GDTFullScreenVideoAdWrapper gDTFullScreenVideoAdWrapper;
        try {
            UnifiedInterstitialAD unifiedInterstitialAD = this.unifiedInterstitialAD;
            if (unifiedInterstitialAD != null && (gDTFullScreenVideoAdWrapper = this.adWrapper) != null) {
                unifiedInterstitialAD.showFullScreenAD((Activity) gDTFullScreenVideoAdWrapper.getContext());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        super.showAd();
    }

    @Override // com.meishu.sdk.core.ad.fullscreenvideo.b, com.meishu.sdk.core.ad.fullscreenvideo.IFullScreenVideoAd
    public void showAd(Activity activity) {
        try {
            UnifiedInterstitialAD unifiedInterstitialAD = this.unifiedInterstitialAD;
            if (unifiedInterstitialAD != null) {
                unifiedInterstitialAD.showFullScreenAD(activity);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        super.showAd(activity);
    }
}
