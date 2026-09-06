package com.ubix.ssp.open.nativee.express;

import com.ubix.ssp.open.AdError;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public interface UBiXNativeExpressAdListener {
    void onAdLoadFailed(AdError adError);

    void onAdLoadSucceed(List<NativeExpressAd> list);
}
