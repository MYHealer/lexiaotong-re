package com.ubix.ssp.open.nativee;

import com.ubix.ssp.open.AdError;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public interface UBiXNativeAdListener {
    void onAdLoadFailed(AdError adError);

    void onAdLoadSucceed(List<NativeAd> list);
}
