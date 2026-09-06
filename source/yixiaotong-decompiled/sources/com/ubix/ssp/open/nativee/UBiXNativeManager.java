package com.ubix.ssp.open.nativee;

import android.content.Context;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public interface UBiXNativeManager {
    String getBiddingToken();

    void loadAd();

    void loadAd(int i);

    void loadBiddingAd(String str);

    void loadNativeAd(Context context, String str, int i, UBiXNativeAdListener uBiXNativeAdListener);

    void loadNativeAd(Context context, String str, UBiXNativeAdListener uBiXNativeAdListener);

    void setExtraInfo(HashMap<String, String> map);
}
