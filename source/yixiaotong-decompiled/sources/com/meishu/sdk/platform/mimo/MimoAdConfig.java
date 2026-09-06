package com.meishu.sdk.platform.mimo;

import android.content.Context;
import com.meishu.sdk.core.AdSdk;
import com.meishu.sdk.core.b;
import com.miui.zeus.mimo.sdk.MimoSdk;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class MimoAdConfig extends b {
    @Override // com.meishu.sdk.core.b
    public void onInit(Context context, String str, String str2) {
        MimoSdk.init(StubApp.getOrigApplicationContext(context.getApplicationContext()), new MimoSdk.InitCallback() { // from class: com.meishu.sdk.platform.mimo.MimoAdConfig.1
            @Override // com.miui.zeus.mimo.sdk.MimoSdk.InitCallback
            public void fail(int i, String str3) {
            }

            @Override // com.miui.zeus.mimo.sdk.MimoSdk.InitCallback
            public void success() {
            }
        });
        MimoSdk.setDebugOn(AdSdk.adConfig().enableDebug());
    }
}
