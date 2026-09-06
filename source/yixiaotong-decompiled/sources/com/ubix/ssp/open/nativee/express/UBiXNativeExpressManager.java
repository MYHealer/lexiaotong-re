package com.ubix.ssp.open.nativee.express;

import android.content.Context;
import com.ubix.ssp.open.AdSize;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public interface UBiXNativeExpressManager {
    String getBiddingToken();

    void loadAd();

    void loadAd(int i);

    void loadBiddingAd(String str);

    void loadNativeExpressAd(Context context, String str, AdSize adSize, UBiXNativeExpressAdListener uBiXNativeExpressAdListener);

    void loadNativeExpressAd(Context context, String str, UBiXNativeExpressAdListener uBiXNativeExpressAdListener);

    void setExtraInfo(HashMap<String, String> map);
}
