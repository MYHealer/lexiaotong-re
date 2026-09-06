package com.meishu.sdk.platform.ks.fullscreenvideo;

import android.app.Activity;
import com.kwad.sdk.api.KsFullScreenVideoAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.meishu.sdk.core.ad.fullscreenvideo.IFullScreenMediaListener;
import com.meishu.sdk.core.ad.fullscreenvideo.b;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class KsFullScreenAd extends b {
    public KSFullScreenAdWrapper adWrapper;
    private IFullScreenMediaListener mFullScreenMediaListener;
    public KsFullScreenVideoAd mFullScreenVideoAd;

    public KsFullScreenAd(KsFullScreenVideoAd ksFullScreenVideoAd, KSFullScreenAdWrapper kSFullScreenAdWrapper) {
        super(kSFullScreenAdWrapper, "KS");
        this.mFullScreenVideoAd = ksFullScreenVideoAd;
        this.adWrapper = kSFullScreenAdWrapper;
    }

    public KSFullScreenAdWrapper getAdWrapper() {
        return this.adWrapper;
    }

    public IFullScreenMediaListener getMediaListener() {
        return this.mFullScreenMediaListener;
    }

    @Override // com.meishu.sdk.core.ad.fullscreenvideo.IFullScreenVideoAd
    public void setMediaListener(IFullScreenMediaListener iFullScreenMediaListener) {
        this.mFullScreenMediaListener = iFullScreenMediaListener;
    }

    @Override // com.meishu.sdk.core.ad.fullscreenvideo.b, com.meishu.sdk.core.ad.fullscreenvideo.IFullScreenVideoAd
    public void showAd() {
        try {
            this.mFullScreenVideoAd.showFullScreenVideoAd((Activity) this.adWrapper.getContext(), new KsVideoPlayConfig.Builder().videoSoundEnable(true).build());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        super.showAd();
    }

    @Override // com.meishu.sdk.core.ad.fullscreenvideo.b, com.meishu.sdk.core.ad.fullscreenvideo.IFullScreenVideoAd
    public void showAd(Activity activity) {
        try {
            this.mFullScreenVideoAd.showFullScreenVideoAd(activity, new KsVideoPlayConfig.Builder().videoSoundEnable(true).build());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        super.showAd(activity);
    }
}
