package com.meishu.sdk.platform.ks.interstitial;

import android.app.Activity;
import android.content.Intent;
import com.kwad.sdk.api.KsImage;
import com.kwad.sdk.api.KsNativeAd;
import com.meishu.sdk.activity.SdkInterstitialActivity;
import com.meishu.sdk.core.ad.interstitial.InterstitialAd;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class KsNativeIntersititialAd extends InterstitialAd {
    private KSIntersititialAdWrapper adWrapper;
    private KsNativeAd ksNativeAd;

    public KsNativeIntersititialAd(KSIntersititialAdWrapper kSIntersititialAdWrapper, KsNativeAd ksNativeAd) {
        super(kSIntersititialAdWrapper, "KS");
        this.adWrapper = kSIntersititialAdWrapper;
        this.ksNativeAd = ksNativeAd;
    }

    @Override // com.meishu.sdk.core.ad.interstitial.InterstitialAd
    public void showAd() {
        int videoHeight;
        int videoWidth;
        try {
            KSIntersititialAdWrapper kSIntersititialAdWrapper = this.adWrapper;
            if (kSIntersititialAdWrapper != null && kSIntersititialAdWrapper.getContext() != null) {
                SdkInterstitialActivity.setSdkAd(this.ksNativeAd);
                SdkInterstitialActivity.setAdWrapper(this.adWrapper);
                SdkInterstitialActivity.setMsAd(this);
                int i = 2;
                if (this.ksNativeAd.getMaterialType() == 1) {
                    videoWidth = this.ksNativeAd.getVideoWidth();
                    videoHeight = this.ksNativeAd.getVideoHeight();
                    if (videoHeight <= videoWidth) {
                        i = 1;
                    }
                } else {
                    List<KsImage> imageList = this.ksNativeAd.getImageList();
                    videoHeight = 0;
                    if (imageList == null || imageList.size() <= 0) {
                        i = 1;
                        videoWidth = 0;
                    } else {
                        KsImage ksImage = imageList.get(0);
                        int width = ksImage.getWidth();
                        int height = ksImage.getHeight();
                        if (ksImage.getHeight() <= ksImage.getWidth()) {
                            i = 1;
                        }
                        videoWidth = width;
                        videoHeight = height;
                    }
                }
                Intent intent = new Intent(this.adWrapper.getContext(), (Class<?>) SdkInterstitialActivity.class);
                intent.putExtra("isVideoAutoPlay", this.adWrapper.getAdLoader().getIsVideoAutoPlay());
                intent.putExtra("act_type", this.adWrapper.getSdkAdInfo().getAct_type());
                intent.putExtra("layout_type", i);
                intent.putExtra("layout_width", videoWidth);
                intent.putExtra("layout_height", videoHeight);
                this.adWrapper.getContext().startActivity(intent);
            }
            super.showAd();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.meishu.sdk.core.ad.interstitial.InterstitialAd
    public void showAd(Activity activity) {
        int videoHeight;
        int videoWidth;
        if (activity != null) {
            try {
                SdkInterstitialActivity.setSdkAd(this.ksNativeAd);
                SdkInterstitialActivity.setAdWrapper(this.adWrapper);
                SdkInterstitialActivity.setMsAd(this);
                int i = 2;
                if (this.ksNativeAd.getMaterialType() == 1) {
                    videoWidth = this.ksNativeAd.getVideoWidth();
                    videoHeight = this.ksNativeAd.getVideoHeight();
                    if (videoHeight <= videoWidth) {
                        i = 1;
                    }
                } else {
                    List<KsImage> imageList = this.ksNativeAd.getImageList();
                    videoHeight = 0;
                    if (imageList == null || imageList.size() <= 0) {
                        i = 1;
                        videoWidth = 0;
                    } else {
                        KsImage ksImage = imageList.get(0);
                        int width = ksImage.getWidth();
                        int height = ksImage.getHeight();
                        if (ksImage.getHeight() <= ksImage.getWidth()) {
                            i = 1;
                        }
                        videoWidth = width;
                        videoHeight = height;
                    }
                }
                Intent intent = new Intent(activity, (Class<?>) SdkInterstitialActivity.class);
                intent.putExtra("isVideoAutoPlay", this.adWrapper.getAdLoader().getIsVideoAutoPlay());
                intent.putExtra("act_type", this.adWrapper.getSdkAdInfo().getAct_type());
                intent.putExtra("layout_type", i);
                intent.putExtra("layout_width", videoWidth);
                intent.putExtra("layout_height", videoHeight);
                activity.startActivity(intent);
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        super.showAd(activity);
    }
}
