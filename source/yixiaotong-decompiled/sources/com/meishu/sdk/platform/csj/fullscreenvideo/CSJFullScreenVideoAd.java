package com.meishu.sdk.platform.csj.fullscreenvideo;

import android.app.Activity;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import com.meishu.sdk.core.MSAdConfig;
import com.meishu.sdk.core.ad.fullscreenvideo.IFullScreenMediaListener;
import com.meishu.sdk.core.ad.fullscreenvideo.b;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class CSJFullScreenVideoAd extends b {
    private CSJFullScreenVideoAdWrapper adWrapper;
    private IFullScreenMediaListener mFullScreenMediaListener;
    private TTFullScreenVideoAd ttFullScreenVideoAd;

    public CSJFullScreenVideoAd(CSJFullScreenVideoAdWrapper cSJFullScreenVideoAdWrapper) {
        super(cSJFullScreenVideoAdWrapper, MSAdConfig.PLATFORM_CSJ);
        this.adWrapper = cSJFullScreenVideoAdWrapper;
    }

    public IFullScreenMediaListener getMediaListener() {
        return this.mFullScreenMediaListener;
    }

    @Override // com.meishu.sdk.core.ad.fullscreenvideo.IFullScreenVideoAd
    public void setMediaListener(IFullScreenMediaListener iFullScreenMediaListener) {
        this.mFullScreenMediaListener = iFullScreenMediaListener;
    }

    public void setTTFullScreenVideoAd(TTFullScreenVideoAd tTFullScreenVideoAd) {
        this.ttFullScreenVideoAd = tTFullScreenVideoAd;
    }

    @Override // com.meishu.sdk.core.ad.fullscreenvideo.b, com.meishu.sdk.core.ad.fullscreenvideo.IFullScreenVideoAd
    public void showAd() {
        CSJFullScreenVideoAdWrapper cSJFullScreenVideoAdWrapper;
        try {
            if (this.ttFullScreenVideoAd != null && (cSJFullScreenVideoAdWrapper = this.adWrapper) != null && (cSJFullScreenVideoAdWrapper.getContext() instanceof Activity)) {
                this.ttFullScreenVideoAd.showFullScreenVideoAd((Activity) this.adWrapper.getContext());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        super.showAd();
    }

    @Override // com.meishu.sdk.core.ad.fullscreenvideo.b, com.meishu.sdk.core.ad.fullscreenvideo.IFullScreenVideoAd
    public void showAd(Activity activity) {
        try {
            TTFullScreenVideoAd tTFullScreenVideoAd = this.ttFullScreenVideoAd;
            if (tTFullScreenVideoAd != null) {
                tTFullScreenVideoAd.showFullScreenVideoAd(activity);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        super.showAd(activity);
    }
}
