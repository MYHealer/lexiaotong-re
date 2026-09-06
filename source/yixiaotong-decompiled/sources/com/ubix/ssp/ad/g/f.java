package com.ubix.ssp.ad.g;

import com.ubix.ssp.open.AdError;
import com.ubix.ssp.open.nativee.express.NativeExpressAd;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public interface f {
    void onAdLoadFailed(AdError adError);

    void onAdLoadSucceed(List<NativeExpressAd> list);
}
