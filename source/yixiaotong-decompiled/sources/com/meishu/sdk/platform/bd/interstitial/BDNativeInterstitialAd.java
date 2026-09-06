package com.meishu.sdk.platform.bd.interstitial;

import android.app.Activity;
import android.content.Intent;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.meishu.sdk.activity.SdkInterstitialActivity;
import com.meishu.sdk.core.MSAdConfig;
import com.meishu.sdk.core.ad.interstitial.InterstitialAd;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class BDNativeInterstitialAd extends InterstitialAd {
    private BDInterstitialAdLoader adWrapper;
    private NativeResponse nativeResponse;

    public BDNativeInterstitialAd(BDInterstitialAdLoader bDInterstitialAdLoader, NativeResponse nativeResponse) {
        super(bDInterstitialAdLoader, MSAdConfig.PLATFORM_BD);
        this.adWrapper = bDInterstitialAdLoader;
        this.nativeResponse = nativeResponse;
    }

    @Override // com.meishu.sdk.core.ad.interstitial.InterstitialAd
    public void showAd() {
        try {
            BDInterstitialAdLoader bDInterstitialAdLoader = this.adWrapper;
            if (bDInterstitialAdLoader != null && bDInterstitialAdLoader.getContext() != null) {
                int mainPicWidth = this.nativeResponse.getMainPicWidth();
                int mainPicHeight = this.nativeResponse.getMainPicHeight();
                int i = mainPicHeight > mainPicWidth ? 2 : 1;
                SdkInterstitialActivity.setSdkAd(this.nativeResponse);
                SdkInterstitialActivity.setAdWrapper(this.adWrapper);
                SdkInterstitialActivity.setMsAd(this);
                Intent intent = new Intent(this.adWrapper.getContext(), (Class<?>) SdkInterstitialActivity.class);
                intent.putExtra("isVideoAutoPlay", this.adWrapper.getAdLoader().getIsVideoAutoPlay());
                intent.putExtra("act_type", this.adWrapper.getSdkAdInfo().getAct_type());
                intent.putExtra("layout_type", i);
                intent.putExtra("layout_width", mainPicWidth);
                intent.putExtra("layout_height", mainPicHeight);
                this.adWrapper.getContext().startActivity(intent);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        super.showAd();
    }

    @Override // com.meishu.sdk.core.ad.interstitial.InterstitialAd
    public void showAd(Activity activity) {
        if (activity != null) {
            int mainPicWidth = this.nativeResponse.getMainPicWidth();
            int mainPicHeight = this.nativeResponse.getMainPicHeight();
            int i = mainPicHeight > mainPicWidth ? 2 : 1;
            SdkInterstitialActivity.setSdkAd(this.nativeResponse);
            SdkInterstitialActivity.setAdWrapper(this.adWrapper);
            SdkInterstitialActivity.setMsAd(this);
            Intent intent = new Intent(activity, (Class<?>) SdkInterstitialActivity.class);
            intent.putExtra("isVideoAutoPlay", this.adWrapper.getAdLoader().getIsVideoAutoPlay());
            intent.putExtra("layout_type", i);
            intent.putExtra("act_type", this.adWrapper.getSdkAdInfo().getAct_type());
            intent.putExtra("layout_width", mainPicWidth);
            intent.putExtra("layout_height", mainPicHeight);
            activity.startActivity(intent);
        }
        super.showAd(activity);
    }
}
