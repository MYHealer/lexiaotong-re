package com.meishu.sdk.platform.jd;

import android.app.Application;
import android.content.Context;
import com.jd.ad.sdk.bl.initsdk.JADPrivateController;
import com.jd.ad.sdk.bl.initsdk.JADYunSdk;
import com.jd.ad.sdk.bl.initsdk.JADYunSdkConfig;
import com.jd.ad.sdk.dl.baseinfo.JADLocation;
import com.meishu.sdk.core.AdSdk;
import com.meishu.sdk.core.b;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class JDAdConfig extends b {
    @Override // com.meishu.sdk.core.b
    public void onInit(Context context, String str, String str2) {
        if (StubApp.getOrigApplicationContext(context.getApplicationContext()) instanceof Application) {
            JADYunSdk.init((Application) StubApp.getOrigApplicationContext(context.getApplicationContext()), new JADYunSdkConfig.Builder().setAppId(str).setEnableLog(true).setPrivateController(new JADPrivateController() { // from class: com.meishu.sdk.platform.jd.JDAdConfig.1
                public String getImei() {
                    return AdSdk.adConfig().customController() != null ? AdSdk.adConfig().customController().getDevImei() : super.getImei();
                }

                @Override // com.jd.ad.sdk.bl.initsdk.JADPrivateController
                public JADLocation getLocation() {
                    return super.getLocation();
                }

                @Override // com.jd.ad.sdk.bl.initsdk.JADPrivateController
                public String getOaid() {
                    return AdSdk.getLocalOaid();
                }

                @Override // com.jd.ad.sdk.bl.initsdk.JADPrivateController
                public boolean isCanUseIP() {
                    return AdSdk.adConfig().customController() != null ? AdSdk.adConfig().customController().isCanUsePhoneState() : super.isCanUseIP();
                }

                @Override // com.jd.ad.sdk.bl.initsdk.JADPrivateController
                public boolean isCanUseLocation() {
                    return AdSdk.adConfig().customController() != null ? AdSdk.adConfig().customController().isCanUseLocation() : super.isCanUseLocation();
                }

                public boolean isCanUsePhoneState() {
                    return AdSdk.adConfig().customController() != null ? AdSdk.adConfig().customController().isCanUsePhoneState() : super.isCanUsePhoneState();
                }
            }).build());
        }
    }
}
