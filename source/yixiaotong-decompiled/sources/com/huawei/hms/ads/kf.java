package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.inter.data.AdContentData;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class kf extends kr {
    private static final String Code = "FeatureAbilityAction";

    public kf(Context context, AdContentData adContentData) {
        super(context, adContentData);
    }

    @Override // com.huawei.hms.ads.kr
    public boolean Code() {
        fh.V(Code, "The current SDK does not support opening HARMONY SERVICE");
        return I();
    }
}
