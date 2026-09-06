package com.ubix.ssp.open.interstitial;

import android.content.Context;
import com.ubix.ssp.open.ParamsReview;
import com.ubix.ssp.open.UBiXAdLossInfo;
import java.io.Serializable;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public interface UBiXInterstitialManager extends Serializable {
    void destroy();

    String getBiddingToken();

    ParamsReview getParamsReview();

    long getPrice();

    boolean isValid();

    boolean isVideoAd();

    void loadAd();

    void loadBiddingAd(String str);

    void loadInterstitialAd(Context context, String str, UBiXInterstitialAdListener uBiXInterstitialAdListener);

    void lossNotice(UBiXAdLossInfo uBiXAdLossInfo);

    void setExtraInfo(HashMap<String, String> map);

    void showAd(Context context);

    void winNotice(long j);
}
