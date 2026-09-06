package com.meishu.sdk.platform.oppo.fullscreenvideo;

import android.app.Activity;
import com.byazt.bv.BaseConstants;
import com.heytap.msp.mobad.api.ad.InterstitialVideoAd;
import com.meishu.sdk.core.ad.fullscreenvideo.IFullScreenMediaListener;
import com.meishu.sdk.core.ad.fullscreenvideo.b;
import com.meishu.sdk.core.loader.d;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class OPPOFullScreenVideoAd extends b {
    private static final String TAG = "OPPOInterstitialAdLoader";
    private InterstitialVideoAd interstitialVideoAd;
    private IFullScreenMediaListener mFullScreenMediaListener;

    public OPPOFullScreenVideoAd(d dVar) {
        super(dVar, BaseConstants.ROM_OPPO_UPPER_CONSTANT);
    }

    public InterstitialVideoAd getInterstitialVideoAd() {
        return this.interstitialVideoAd;
    }

    public IFullScreenMediaListener getMediaListener() {
        return this.mFullScreenMediaListener;
    }

    public void setInterstitialVideoAd(InterstitialVideoAd interstitialVideoAd) {
        this.interstitialVideoAd = interstitialVideoAd;
    }

    @Override // com.meishu.sdk.core.ad.fullscreenvideo.IFullScreenVideoAd
    public void setMediaListener(IFullScreenMediaListener iFullScreenMediaListener) {
        this.mFullScreenMediaListener = iFullScreenMediaListener;
    }

    @Override // com.meishu.sdk.core.ad.fullscreenvideo.b, com.meishu.sdk.core.ad.fullscreenvideo.IFullScreenVideoAd
    public void showAd() {
        this.interstitialVideoAd.showAd();
    }

    @Override // com.meishu.sdk.core.ad.fullscreenvideo.b, com.meishu.sdk.core.ad.fullscreenvideo.IFullScreenVideoAd
    public void showAd(Activity activity) {
        this.interstitialVideoAd.showAd();
    }
}
