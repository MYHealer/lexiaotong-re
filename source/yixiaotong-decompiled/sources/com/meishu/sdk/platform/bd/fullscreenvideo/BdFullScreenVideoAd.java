package com.meishu.sdk.platform.bd.fullscreenvideo;

import android.app.Activity;
import com.baidu.mobads.sdk.api.FullScreenVideoAd;
import com.meishu.sdk.core.MSAdConfig;
import com.meishu.sdk.core.ad.fullscreenvideo.IFullScreenMediaListener;
import com.meishu.sdk.core.ad.fullscreenvideo.b;
import com.meishu.sdk.core.loader.d;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class BdFullScreenVideoAd extends b {
    private IFullScreenMediaListener mFullScreenMediaListener;
    private FullScreenVideoAd mFullScreenVideoAd;

    public BdFullScreenVideoAd(d dVar, FullScreenVideoAd fullScreenVideoAd) {
        super(dVar, MSAdConfig.PLATFORM_BD);
        this.mFullScreenVideoAd = fullScreenVideoAd;
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
        FullScreenVideoAd fullScreenVideoAd = this.mFullScreenVideoAd;
        if (fullScreenVideoAd != null) {
            fullScreenVideoAd.show();
        }
        super.showAd();
    }

    @Override // com.meishu.sdk.core.ad.fullscreenvideo.b, com.meishu.sdk.core.ad.fullscreenvideo.IFullScreenVideoAd
    public void showAd(Activity activity) {
        FullScreenVideoAd fullScreenVideoAd = this.mFullScreenVideoAd;
        if (fullScreenVideoAd != null) {
            fullScreenVideoAd.show();
        }
        super.showAd(activity);
    }
}
