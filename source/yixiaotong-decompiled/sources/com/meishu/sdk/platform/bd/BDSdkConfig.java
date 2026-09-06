package com.meishu.sdk.platform.bd;

import android.content.Context;
import com.baidu.mobads.sdk.api.BDAdConfig;
import com.baidu.mobads.sdk.api.BDDialogParams;
import com.baidu.mobads.sdk.api.MobadsPermissionSettings;
import com.huawei.hms.ads.ez;
import com.meishu.sdk.core.AdSdk;
import com.meishu.sdk.core.MSAdConfig;
import com.meishu.sdk.core.b;
import com.meishu.sdk.core.utils.LogUtil;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class BDSdkConfig extends b {
    private static final String TAG = "BDSdkConfig";

    @Override // com.meishu.sdk.core.b
    public void onInit(Context context, String str, String str2) {
        try {
            LogUtil.d(TAG, "bd init---------------");
            try {
                if (AdSdk.adConfig().getCanUseSdkPersonalRecommend()) {
                    MobadsPermissionSettings.setLimitPersonalAds(false);
                } else {
                    MobadsPermissionSettings.setLimitPersonalAds(true);
                }
                MSAdConfig.CustomController customController = AdSdk.adConfig().customController();
                if (customController != null) {
                    MobadsPermissionSettings.setPermissionReadDeviceID(customController.isCanUsePhoneState());
                    MobadsPermissionSettings.setPermissionLocation(customController.isCanUseLocation());
                    MobadsPermissionSettings.setPermissionStorage(customController.canUseStoragePermission());
                    MobadsPermissionSettings.setPermissionAppList(customController.canReadInstalledPackages());
                } else {
                    MobadsPermissionSettings.setPermissionReadDeviceID(true);
                    MobadsPermissionSettings.setPermissionLocation(true);
                    MobadsPermissionSettings.setPermissionStorage(true);
                    MobadsPermissionSettings.setPermissionAppList(true);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            BDAdConfig.Builder dialogParams = new BDAdConfig.Builder().setAppsid(str).setDialogParams(new BDDialogParams.Builder().setDlDialogType(0).setDlDialogAnimStyle(0).build());
            try {
                if (!AdSdk.adConfig().enableInstallBroadcast()) {
                    dialogParams.putExtraParam("pk_change_rc", ez.V).putExtraParam("mi market rc", ez.V);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            dialogParams.build(context).init();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
