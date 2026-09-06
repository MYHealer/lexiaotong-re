package com.meishu.sdk.platform.gdt.interstitial;

import android.app.Activity;
import android.content.Intent;
import com.meishu.sdk.activity.SdkInterstitialActivity;
import com.meishu.sdk.core.MSAdConfig;
import com.meishu.sdk.core.ad.interstitial.InterstitialAd;
import com.qq.e.ads.nativ.NativeUnifiedADData;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class GDTNativeInterstitialAd extends InterstitialAd {
    private GDTInterstitialAdWrapper adWrapper;
    private NativeUnifiedADData interstitialAd;

    public GDTNativeInterstitialAd(GDTInterstitialAdWrapper gDTInterstitialAdWrapper, NativeUnifiedADData nativeUnifiedADData) {
        super(gDTInterstitialAdWrapper, MSAdConfig.PLATFORM_GDT);
        this.adWrapper = gDTInterstitialAdWrapper;
        this.interstitialAd = nativeUnifiedADData;
    }

    @Override // com.meishu.sdk.core.ad.interstitial.InterstitialAd
    public void showAd() {
        try {
            GDTInterstitialAdWrapper gDTInterstitialAdWrapper = this.adWrapper;
            if (gDTInterstitialAdWrapper != null && gDTInterstitialAdWrapper.getContext() != null) {
                int pictureWidth = this.interstitialAd.getPictureWidth();
                int pictureHeight = this.interstitialAd.getPictureHeight();
                int i = pictureHeight > pictureWidth ? 2 : 1;
                SdkInterstitialActivity.setSdkAd(this.interstitialAd);
                SdkInterstitialActivity.setAdWrapper(this.adWrapper);
                SdkInterstitialActivity.setMsAd(this);
                Intent intent = new Intent(this.adWrapper.getContext(), (Class<?>) SdkInterstitialActivity.class);
                intent.putExtra("isVideoAutoPlay", this.adWrapper.getAdLoader().getIsVideoAutoPlay());
                intent.putExtra("act_type", this.adWrapper.getSdkAdInfo().getAct_type());
                intent.putExtra("layout_type", i);
                intent.putExtra("layout_width", pictureWidth);
                intent.putExtra("layout_height", pictureHeight);
                this.adWrapper.getContext().startActivity(intent);
            }
            super.showAd();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.meishu.sdk.core.ad.interstitial.InterstitialAd
    public void showAd(Activity activity) {
        if (activity != null) {
            try {
                int pictureWidth = this.interstitialAd.getPictureWidth();
                int pictureHeight = this.interstitialAd.getPictureHeight();
                int i = pictureHeight > pictureWidth ? 2 : 1;
                SdkInterstitialActivity.setSdkAd(this.interstitialAd);
                SdkInterstitialActivity.setAdWrapper(this.adWrapper);
                SdkInterstitialActivity.setMsAd(this);
                Intent intent = new Intent(activity, (Class<?>) SdkInterstitialActivity.class);
                intent.putExtra("isVideoAutoPlay", this.adWrapper.getAdLoader().getIsVideoAutoPlay());
                intent.putExtra("act_type", this.adWrapper.getSdkAdInfo().getAct_type());
                intent.putExtra("layout_type", i);
                intent.putExtra("layout_width", pictureWidth);
                intent.putExtra("layout_height", pictureHeight);
                activity.startActivity(intent);
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        super.showAd(activity);
    }
}
