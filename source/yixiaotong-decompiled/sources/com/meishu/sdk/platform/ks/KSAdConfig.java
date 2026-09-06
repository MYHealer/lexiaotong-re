package com.meishu.sdk.platform.ks;

import android.content.Context;
import android.location.Location;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsCustomController;
import com.kwad.sdk.api.SdkConfig;
import com.meishu.sdk.core.AdSdk;
import com.meishu.sdk.core.b;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class KSAdConfig extends b {
    private boolean initOK = false;

    @Override // com.meishu.sdk.core.b
    public void onInit(Context context, String str, String str2) {
        if (AdSdk.adConfig().getCanUseSdkPersonalRecommend()) {
            KsAdSDK.setPersonalRecommend(true);
        } else {
            KsAdSDK.setPersonalRecommend(false);
        }
        SdkConfig.Builder builder = new SdkConfig.Builder();
        builder.appId(str).showNotification(AdSdk.adConfig().enableNotify()).customController(new KsCustomController() { // from class: com.meishu.sdk.platform.ks.KSAdConfig.1
            @Override // com.kwad.sdk.api.KsCustomController
            public boolean canReadInstalledPackages() {
                return AdSdk.adConfig().customController() != null ? AdSdk.adConfig().customController().canReadInstalledPackages() : super.canReadInstalledPackages();
            }

            @Override // com.kwad.sdk.api.KsCustomController
            public boolean canReadLocation() {
                return AdSdk.adConfig().customController() != null ? AdSdk.adConfig().customController().isCanUseLocation() : super.canReadLocation();
            }

            @Override // com.kwad.sdk.api.KsCustomController
            public boolean canUseMacAddress() {
                return AdSdk.adConfig().customController() != null ? AdSdk.adConfig().customController().canUseMacAddress() : super.canUseMacAddress();
            }

            @Override // com.kwad.sdk.api.KsCustomController
            public boolean canUseNetworkState() {
                return AdSdk.adConfig().customController() != null ? AdSdk.adConfig().customController().canUseNetworkState() : super.canUseNetworkState();
            }

            @Override // com.kwad.sdk.api.KsCustomController
            public boolean canUsePhoneState() {
                return AdSdk.adConfig().customController() != null ? AdSdk.adConfig().customController().isCanUsePhoneState() : super.canUsePhoneState();
            }

            @Override // com.kwad.sdk.api.KsCustomController
            public boolean canUseStoragePermission() {
                return AdSdk.adConfig().customController() != null ? AdSdk.adConfig().customController().canUseStoragePermission() : super.canUseStoragePermission();
            }

            @Override // com.kwad.sdk.api.KsCustomController
            public String getAndroidId() {
                return AdSdk.adConfig().customController() != null ? AdSdk.adConfig().customController().getAndroidId() : super.getAndroidId();
            }

            @Override // com.kwad.sdk.api.KsCustomController
            public String getImei() {
                return AdSdk.adConfig().customController() != null ? AdSdk.adConfig().customController().getDevImei() : super.getImei();
            }

            @Override // com.kwad.sdk.api.KsCustomController
            public Location getLocation() {
                return AdSdk.adConfig().customController() != null ? AdSdk.adConfig().customController().getLocation() : super.getLocation();
            }

            @Override // com.kwad.sdk.api.KsCustomController
            public String getMacAddress() {
                return AdSdk.adConfig().customController() != null ? AdSdk.adConfig().customController().getMacAddress() : super.getMacAddress();
            }

            @Override // com.kwad.sdk.api.KsCustomController
            public String getOaid() {
                return AdSdk.getLocalOaid();
            }
        }).debug(AdSdk.adConfig().enableDebug());
        try {
            KsAdSDK.init(StubApp.getOrigApplicationContext(context.getApplicationContext()), builder.build());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            KsAdSDK.start();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
