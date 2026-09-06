package com.yfanads.ads.chanel.in.utils;

import android.content.Context;
import android.location.Location;
import android.text.TextUtils;
import com.ubixnow.core.api.UMNAdConfig;
import com.ubixnow.core.api.UMNAdManager;
import com.ubixnow.core.api.UMNInitCallBack;
import com.ubixnow.core.api.UMNPrivacyConfig;
import com.yfanads.android.YFAdsConfig;
import com.yfanads.android.YFAdsManager;
import com.yfanads.android.libs.utils.DeviceUtils;
import com.yfanads.android.model.InitBean;
import com.yfanads.android.model.SdkSupplier;
import com.yfanads.android.model.YFAdError;
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFConfigUtils;
import com.yfanads.android.utils.YFLog;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class INUtil extends InitUtils {
    private static final String[] METHODS = {YFAdsConst.CUA, YFAdsConst.CUL, YFAdsConst.CUP, YFAdsConst.CUO, YFAdsConst.CUW, YFAdsConst.CWE, YFAdsConst.LP, YFAdsConst.CUAID};

    public static void initIN(String str, Context context, InitBean initBean, InitUtils.InitListener initListener) {
        initIN(str, null, context, initBean, initListener);
    }

    public static void initIN(final String str, final SdkSupplier sdkSupplier, Context context, final InitBean initBean, InitUtils.InitListener initListener) {
        if (initBean == null || TextUtils.isEmpty(initBean.appId)) {
            String str2 = str + " init failed InitBean empty ay ";
            initListener.fail(YFAdError.ERROR_INIT_FAILED, str2);
            YFLog.error(str2);
            return;
        }
        final String str3 = initBean.appId;
        try {
            final YFAdsConfig yFAdsConfig = YFAdsManager.getInstance().getYFAdsConfig();
            if (isInitSuc(str, str3, initListener) || isInQueue(str, initListener, str3)) {
                return;
            }
            final long jCurrentTimeMillis = System.currentTimeMillis();
            YFLog.high(str + " init syn start in:" + str3);
            if (sdkSupplier != null) {
                initReport(sdkSupplier, YFAdsConst.ReportETypeValue.ADS_INIT_START.getValue());
            }
            boolean[] permissionValues = getPermissionValues(YFAdsConst.ReportAdnIdValue.IN, yFAdsConfig, true);
            final boolean permissionValue = getPermissionValue(permissionValues, YFAdsConst.CUA, true);
            final boolean permissionValue2 = getPermissionValue(permissionValues, YFAdsConst.CUL, true);
            final boolean permissionValue3 = getPermissionValue(permissionValues, YFAdsConst.CUP, true);
            final boolean permissionValue4 = getPermissionValue(permissionValues, YFAdsConst.CUO, true);
            final boolean permissionValue5 = getPermissionValue(permissionValues, YFAdsConst.CUW, true);
            final boolean permissionValue6 = getPermissionValue(permissionValues, YFAdsConst.CWE, true);
            final boolean permissionValue7 = getPermissionValue(permissionValues, YFAdsConst.LP, false);
            final boolean permissionValue8 = getPermissionValue(permissionValues, YFAdsConst.CUAID, true);
            printLog(YFAdsConst.ReportAdnIdValue.IN, METHODS, permissionValue, permissionValue2, permissionValue3, permissionValue4, permissionValue5, permissionValue6, permissionValue7, permissionValue8);
            boolean booleanValue = YFConfigUtils.getBooleanValue(YFConfigUtils.ConfigType.EXT, "is_shake_action", true);
            HashMap<String, String> map = new HashMap<>();
            if (booleanValue) {
                map.put("sensor_enabled", "1");
            } else {
                map.put("sensor_enabled", "0");
            }
            YFLog.debug("isSupportShake:" + booleanValue);
            UMNAdManager.getInstance().asyncInit(context, new UMNAdConfig.Builder().setPrivacyConfig(new UMNPrivacyConfig() { // from class: com.yfanads.ads.chanel.in.utils.INUtil.1
                @Override // com.ubixnow.core.api.UMNPrivacyConfig
                public boolean appList() {
                    return permissionValue;
                }

                @Override // com.ubixnow.core.api.UMNPrivacyConfig
                public Location getLocation() {
                    return null;
                }

                @Override // com.ubixnow.core.api.UMNPrivacyConfig
                public boolean isA() {
                    return permissionValue8;
                }

                @Override // com.ubixnow.core.api.UMNPrivacyConfig
                public boolean isCanUseLocation() {
                    return permissionValue2;
                }

                @Override // com.ubixnow.core.api.UMNPrivacyConfig
                public boolean isCanUseMacAddress() {
                    return permissionValue5;
                }

                @Override // com.ubixnow.core.api.UMNPrivacyConfig
                public boolean isCanUsePhoneState() {
                    return permissionValue3;
                }

                @Override // com.ubixnow.core.api.UMNPrivacyConfig
                public boolean isCanUseWriteExternal() {
                    return permissionValue6;
                }

                @Override // com.ubixnow.core.api.UMNPrivacyConfig
                public boolean isLimitPersonalAds() {
                    return permissionValue7;
                }

                @Override // com.ubixnow.core.api.UMNPrivacyConfig
                public boolean isO() {
                    return permissionValue4;
                }

                @Override // com.ubixnow.core.api.UMNPrivacyConfig
                public boolean isProgrammaticRecommend() {
                    return permissionValue7;
                }

                @Override // com.ubixnow.core.api.UMNPrivacyConfig
                public boolean isW() {
                    return permissionValue5;
                }

                @Override // com.ubixnow.core.api.UMNPrivacyConfig
                public List<String> getAppList() {
                    return super.getAppList();
                }

                @Override // com.ubixnow.core.api.UMNPrivacyConfig
                public String getDevImei() {
                    return yFAdsConfig.getDevImei();
                }

                @Override // com.ubixnow.core.api.UMNPrivacyConfig
                public String getMacAddress() {
                    return yFAdsConfig.getDevMacAddress();
                }

                @Override // com.ubixnow.core.api.UMNPrivacyConfig
                public String getO() {
                    return DeviceUtils.getCacheOAID();
                }

                @Override // com.ubixnow.core.api.UMNPrivacyConfig
                public String getA() {
                    return yFAdsConfig.getDevAndroidId();
                }
            }).setAppId(initBean.appId).setExtraMap(map).build());
            UMNAdManager.getInstance().start(new UMNInitCallBack() { // from class: com.yfanads.ads.chanel.in.utils.INUtil.2
                @Override // com.ubixnow.core.api.UMNInitCallBack
                public void onSucc() {
                    SdkSupplier sdkSupplier2 = sdkSupplier;
                    if (sdkSupplier2 != null) {
                        InitUtils.initReport(sdkSupplier2, YFAdsConst.ReportETypeValue.ADS_INIT_SUCCESS.getValue());
                    }
                    InitUtils.queueSuccess(str, str3);
                    YFLog.high(str + " init asy success in:" + initBean.appId + "|t_" + (System.currentTimeMillis() - jCurrentTimeMillis));
                }

                @Override // com.ubixnow.core.api.UMNInitCallBack
                public void onFail(int i, String str4) {
                    SdkSupplier sdkSupplier2 = sdkSupplier;
                    if (sdkSupplier2 != null) {
                        InitUtils.initReport(sdkSupplier2, YFAdsConst.ReportETypeValue.ADS_INIT_FAIL.getValue());
                    }
                    InitUtils.queueFail(str, str4, str3);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            queueFail(str, e.getMessage(), str3);
        }
    }

    public static String getSdkVersion() {
        return UMNAdManager.getSdkVersion();
    }
}
