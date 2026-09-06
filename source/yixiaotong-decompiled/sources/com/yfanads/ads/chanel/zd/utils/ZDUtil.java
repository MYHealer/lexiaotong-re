package com.yfanads.ads.chanel.zd.utils;

import android.content.Context;
import android.location.Location;
import android.text.TextUtils;
import com.meishu.sdk.core.AdSdk;
import com.meishu.sdk.core.MSAdConfig;
import com.yfanads.android.YFAdsConfig;
import com.yfanads.android.YFAdsManager;
import com.yfanads.android.model.InitBean;
import com.yfanads.android.model.SdkSupplier;
import com.yfanads.android.model.YFAdError;
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFListUtils;
import com.yfanads.android.utils.YFLog;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class ZDUtil extends InitUtils {
    private static final String[] METHODS = {YFAdsConst.CUA, YFAdsConst.CUL, YFAdsConst.CUP, YFAdsConst.CUO, YFAdsConst.CUW, YFAdsConst.CWE, YFAdsConst.LP, YFAdsConst.CUAID};

    public static void initZD(String str, Context context, InitBean initBean, InitUtils.InitListener initListener) {
        initZD(str, null, context, initBean, initListener);
    }

    /* JADX WARN: Code duplicated, block: B:25:0x00ea  */
    public static void initZD(String str, SdkSupplier sdkSupplier, Context context, InitBean initBean, InitUtils.InitListener initListener) {
        boolean zBooleanValue;
        if (initBean == null || TextUtils.isEmpty(initBean.appId)) {
            String str2 = str + " init failed InitBean empty ay ";
            initListener.fail(YFAdError.ERROR_INIT_FAILED, str2);
            YFLog.error(str2);
            return;
        }
        String str3 = initBean.appId;
        try {
            final YFAdsConfig yFAdsConfig = YFAdsManager.getInstance().getYFAdsConfig();
            if (isInitSuc(str, str3, initListener) || isInQueue(str, initListener, str3)) {
                return;
            }
            YFLog.high(str + " init start ZD:" + str3);
            if (sdkSupplier != null) {
                initReport(sdkSupplier, YFAdsConst.ReportETypeValue.ADS_INIT_START.getValue());
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            boolean[] permissionValues = getPermissionValues(YFAdsConst.ReportAdnIdValue.ZD, yFAdsConfig, true);
            final boolean permissionValue = getPermissionValue(permissionValues, YFAdsConst.CUA, true);
            final boolean permissionValue2 = getPermissionValue(permissionValues, YFAdsConst.CUL, true);
            final boolean permissionValue3 = getPermissionValue(permissionValues, YFAdsConst.CUP, true);
            boolean permissionValue4 = getPermissionValue(permissionValues, YFAdsConst.CUO, true);
            final boolean permissionValue5 = getPermissionValue(permissionValues, YFAdsConst.CUW, true);
            boolean permissionValue6 = getPermissionValue(permissionValues, YFAdsConst.CWE, true);
            boolean permissionValue7 = getPermissionValue(permissionValues, YFAdsConst.LP, false);
            final boolean permissionValue8 = getPermissionValue(permissionValues, YFAdsConst.CUAID, true);
            printLog(YFAdsConst.ReportAdnIdValue.ZD, METHODS, permissionValue, permissionValue2, permissionValue3, permissionValue4, permissionValue5, permissionValue6, permissionValue7, permissionValue8);
            Map<String, Object> extDefine = yFAdsConfig.getExtDefine();
            if (YFListUtils.isMapEmpty(extDefine)) {
                zBooleanValue = true;
            } else {
                try {
                    Object obj = extDefine.get("bootMark");
                    if (obj instanceof Boolean) {
                        zBooleanValue = ((Boolean) obj).booleanValue();
                    } else {
                        zBooleanValue = true;
                    }
                } catch (Exception e) {
                    YFLog.error("canBootMark: " + e.getMessage());
                }
            }
            MSAdConfig.Builder builderCustomController = new MSAdConfig.Builder().appId(str3).enableDebug(yFAdsConfig.isDebug()).enableSdkPersonalRecommend(!permissionValue7).enableBootId(zBooleanValue).enableInstallBroadcast(!yFAdsConfig.isCloseAppReceiver()).downloadConfirm(1).customController(new MSAdConfig.CustomController() { // from class: com.yfanads.ads.chanel.zd.utils.ZDUtil.1
                @Override // com.meishu.sdk.core.MSAdConfig.CustomController
                public boolean canReadInstalledPackages() {
                    return permissionValue;
                }

                @Override // com.meishu.sdk.core.MSAdConfig.CustomController
                public boolean canUseMacAddress() {
                    return permissionValue5;
                }

                @Override // com.meishu.sdk.core.MSAdConfig.CustomController
                public boolean canUseNetworkState() {
                    return permissionValue5;
                }

                @Override // com.meishu.sdk.core.MSAdConfig.CustomController
                public boolean isCanUseAndroidId() {
                    return permissionValue8;
                }

                @Override // com.meishu.sdk.core.MSAdConfig.CustomController
                public boolean isCanUseImsi() {
                    return false;
                }

                @Override // com.meishu.sdk.core.MSAdConfig.CustomController
                public boolean isCanUseLocation() {
                    return permissionValue2;
                }

                @Override // com.meishu.sdk.core.MSAdConfig.CustomController
                public boolean isCanUsePhoneState() {
                    return permissionValue3;
                }

                @Override // com.meishu.sdk.core.MSAdConfig.CustomController
                public boolean isCanUseWifiState() {
                    return permissionValue5;
                }

                @Override // com.meishu.sdk.core.MSAdConfig.CustomController
                public String getOaid() {
                    return InitUtils.getOaID(yFAdsConfig);
                }

                @Override // com.meishu.sdk.core.MSAdConfig.CustomController
                public Location getLocation() {
                    return super.getLocation();
                }

                @Override // com.meishu.sdk.core.MSAdConfig.CustomController
                public String getDevImei() {
                    return yFAdsConfig.getDevImei();
                }

                @Override // com.meishu.sdk.core.MSAdConfig.CustomController
                public String getMacAddress() {
                    return yFAdsConfig.getDevMacAddress();
                }

                @Override // com.meishu.sdk.core.MSAdConfig.CustomController
                public String getAndroidId() {
                    return yFAdsConfig.getDevAndroidId();
                }

                @Override // com.meishu.sdk.core.MSAdConfig.CustomController
                public boolean canUseStoragePermission() {
                    return super.canUseStoragePermission();
                }
            });
            if (!isShake()) {
                builderCustomController.disableSensorType(1);
                builderCustomController.disableSensorType(9);
                builderCustomController.disableSensorType(4);
            }
            AdSdk.init(context, builderCustomController.build());
            if (sdkSupplier != null) {
                initReport(sdkSupplier, YFAdsConst.ReportETypeValue.ADS_INIT_SUCCESS.getValue());
            }
            queueSuccess(str, str3);
            YFLog.high(str + " init success ZD:" + initBean.appId + "|t_" + (System.currentTimeMillis() - jCurrentTimeMillis));
        } catch (Exception e2) {
            e2.printStackTrace();
            queueFail(e2.getMessage(), str3);
        }
    }

    public static String getSdkVersion() {
        return AdSdk.getVersionName();
    }
}
