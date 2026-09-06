package com.yfanads.ads.chanel.hw;

import android.app.Activity;
import android.content.Context;
import com.huawei.hms.ads.AdListener;
import com.huawei.hms.ads.AdParam;
import com.huawei.hms.ads.InterstitialAd;
import com.yfanads.ads.chanel.hw.utls.HwUtil;
import com.yfanads.android.core.full.YFFullScreenVideoSetting;
import com.yfanads.android.custom.FullScreenCustomAdapter;
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFLog;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class HwFullScreenVideoAdapter extends FullScreenCustomAdapter {
    private InterstitialAd interstitialAd;

    @Override // com.yfanads.android.custom.FullScreenCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public void doDestroy() {
    }

    public HwFullScreenVideoAdapter(YFFullScreenVideoSetting yFFullScreenVideoSetting) {
        super(yFFullScreenVideoSetting);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doLoadAD */
    public void m1208x201b9c1d(final Context context) {
        HwUtil.initHw(this.tag, this.sdkSupplier, context, getInitBean(), new InitUtils.InitListener() { // from class: com.yfanads.ads.chanel.hw.HwFullScreenVideoAdapter.1
            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void success() {
                HwFullScreenVideoAdapter.this.loadInterstitialAd(context);
            }

            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void fail(String str, String str2) {
                HwFullScreenVideoAdapter.this.handleFailed(str, str2);
            }
        });
        sendInterruptMsg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadInterstitialAd(Context context) {
        if (this.isDestroy || this.mFullSetting == null) {
            YFLog.error(this.tag + " isDestroy or setting null");
            return;
        }
        InterstitialAd interstitialAd = new InterstitialAd(context);
        this.interstitialAd = interstitialAd;
        interstitialAd.setAdId(this.sdkSupplier.network.param.potId);
        this.interstitialAd.setAdListener(new AdListener() { // from class: com.yfanads.ads.chanel.hw.HwFullScreenVideoAdapter.2
            @Override // com.huawei.hms.ads.AdListener
            public void onAdLeave() {
            }

            @Override // com.huawei.hms.ads.AdListener
            public void onAdLoaded() {
                HwFullScreenVideoAdapter.this.handleSucceed();
            }

            @Override // com.huawei.hms.ads.AdListener
            public void onAdFailed(int i) {
                HwFullScreenVideoAdapter.this.handleFailed(i, "onAdFailed");
            }

            @Override // com.huawei.hms.ads.AdListener
            public void onAdClosed() {
                if (HwFullScreenVideoAdapter.this.isStartShow() || HwFullScreenVideoAdapter.this.isExposure()) {
                    HwFullScreenVideoAdapter.this.handleClose();
                }
            }

            @Override // com.huawei.hms.ads.AdListener
            public void onAdClicked() {
                HwFullScreenVideoAdapter.this.handleClick();
            }

            @Override // com.huawei.hms.ads.AdListener
            public void onAdOpened() {
                YFLog.high(HwFullScreenVideoAdapter.this.tag + " onAdOpened");
                if (HwFullScreenVideoAdapter.this.isStartShow()) {
                    HwFullScreenVideoAdapter.this.handleExposure();
                }
            }
        });
        this.interstitialAd.loadAd(new AdParam.Builder().build());
    }

    @Override // com.yfanads.android.custom.FullScreenCustomAdapter
    public void doShowAD(Activity activity) {
        InterstitialAd interstitialAd = this.interstitialAd;
        if (interstitialAd != null && interstitialAd.isLoaded()) {
            this.interstitialAd.show(activity);
        } else {
            handleShowFailed(this.tag + " interstitialAd is null, return. ");
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public int getAdnId() {
        return YFAdsConst.ReportAdnIdValue.HW.getValue();
    }
}
