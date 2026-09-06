package com.meishu.sdk.platform.custom.fullscreen;

import com.meishu.sdk.core.ad.fullscreenvideo.IFullScreenMediaListener;
import com.meishu.sdk.core.ad.fullscreenvideo.b;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public abstract class MsCustomFullScreenAd extends b {
    private IFullScreenMediaListener fullscreenAdMediaListener;

    public MsCustomFullScreenAd(MsCustomFullScreenAdapter msCustomFullScreenAdapter) {
        this(msCustomFullScreenAdapter, "CUSTOM");
    }

    public IFullScreenMediaListener getMediaListener() {
        return this.fullscreenAdMediaListener;
    }

    @Override // com.meishu.sdk.core.ad.fullscreenvideo.IFullScreenVideoAd
    public void setMediaListener(IFullScreenMediaListener iFullScreenMediaListener) {
        this.fullscreenAdMediaListener = iFullScreenMediaListener;
    }

    @Override // com.meishu.sdk.core.ad.fullscreenvideo.b, com.meishu.sdk.core.ad.fullscreenvideo.IFullScreenVideoAd
    public void showAd() {
        super.showAd();
    }

    public MsCustomFullScreenAd(MsCustomFullScreenAdapter msCustomFullScreenAdapter, String str) {
        super(msCustomFullScreenAdapter, str);
    }
}
