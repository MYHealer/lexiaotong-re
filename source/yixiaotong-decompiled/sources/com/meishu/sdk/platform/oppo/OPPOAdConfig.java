package com.meishu.sdk.platform.oppo;

import android.content.Context;
import com.heytap.msp.mobad.api.InitParams;
import com.heytap.msp.mobad.api.MobAdManager;
import com.meishu.sdk.core.AdSdk;
import com.meishu.sdk.core.b;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class OPPOAdConfig extends b {
    @Override // com.meishu.sdk.core.b
    public void onInit(Context context, String str, String str2) {
        super.onInit(context, str, str2);
        MobAdManager.getInstance().init(context, str, new InitParams.Builder().setDebug(AdSdk.adConfig().enableDebug()).build());
    }
}
