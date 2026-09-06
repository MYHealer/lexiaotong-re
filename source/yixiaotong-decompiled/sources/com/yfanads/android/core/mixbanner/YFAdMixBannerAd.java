package com.yfanads.android.core.mixbanner;

import android.content.Context;
import com.yfanads.android.core.nat.YFAdNativeExpressAds;
import com.yfanads.android.core.nat.YFNativeExpressListener;
import com.yfanads.android.model.YFAdType;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class YFAdMixBannerAd extends YFAdNativeExpressAds {
    public YFAdMixBannerAd(Context context, YFNativeExpressListener yFNativeExpressListener) {
        super(context, yFNativeExpressListener);
        setAdType(YFAdType.MIXBANNER);
    }

    @Override // com.yfanads.android.core.nat.YFAdNativeExpressAds, com.yfanads.android.core.i
    public int getAType() {
        return 9;
    }
}
