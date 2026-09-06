package com.ubix.ssp.open.video;

import android.app.Activity;
import android.content.Context;
import com.ubix.ssp.open.ParamsReview;
import com.ubix.ssp.open.UBiXAdLossInfo;
import java.io.Serializable;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public interface UBiXRewardVideoManager extends Serializable {
    void destroy();

    String getBiddingToken();

    ParamsReview getParamsReview();

    long getPrice();

    String getTransId();

    boolean isValid();

    boolean isVideoAd();

    void loadAd();

    void loadBiddingAd(String str);

    void loadRewardVideoAd(Context context, String str, UBiXRewardVideoAdListener uBiXRewardVideoAdListener);

    void loadRewardVideoAd(Context context, String str, UBiXRewardVideoExtra uBiXRewardVideoExtra, UBiXRewardVideoAdListener uBiXRewardVideoAdListener);

    void lossNotice(UBiXAdLossInfo uBiXAdLossInfo);

    void setExtraInfo(HashMap<String, String> map);

    void showRewardVideo(Activity activity);

    void winNotice(long j);
}
