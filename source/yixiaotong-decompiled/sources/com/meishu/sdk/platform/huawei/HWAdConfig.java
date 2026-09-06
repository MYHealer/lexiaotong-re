package com.meishu.sdk.platform.huawei;

import android.content.Context;
import com.huawei.hms.ads.HwAds;
import com.huawei.openalliance.ad.inter.HiAd;
import com.meishu.sdk.core.b;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class HWAdConfig extends b {
    @Override // com.meishu.sdk.core.b
    public void onInit(Context context, String str, String str2) {
        HwAds.init(context);
        HiAd.getInstance(context).enableUserInfo(true);
        HiAd.getInstance(context).initLog(true, 4);
    }
}
