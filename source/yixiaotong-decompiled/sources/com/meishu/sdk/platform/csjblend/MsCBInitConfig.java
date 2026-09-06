package com.meishu.sdk.platform.csjblend;

import android.content.Context;
import com.bytedance.sdk.openadsdk.mediation.bridge.custom.MediationCustomInitLoader;
import com.bytedance.sdk.openadsdk.mediation.custom.MediationCustomInitConfig;
import com.meishu.sdk.core.AdSdk;
import com.meishu.sdk.core.MSAdConfig;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class MsCBInitConfig extends MediationCustomInitLoader {
    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.MediationCustomInitLoader
    public String getNetworkSdkVersion() {
        return AdSdk.getVersionName();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.MediationCustomInitLoader
    public void initializeADN(Context context, MediationCustomInitConfig mediationCustomInitConfig, Map<String, Object> map) {
        AdSdk.init(context, new MSAdConfig.Builder().appId(mediationCustomInitConfig.getAppId()).enableDebug(true).downloadConfirm(1).build());
    }
}
