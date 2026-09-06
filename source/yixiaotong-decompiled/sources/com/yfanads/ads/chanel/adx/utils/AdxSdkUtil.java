package com.yfanads.ads.chanel.adx.utils;

import android.content.Context;
import android.text.TextUtils;
import com.yfanads.android.YFAdsConfig;
import com.yfanads.android.YFAdsManager;
import com.yfanads.android.adx.AdxSDK;
import com.yfanads.android.adx.AdxSdkConfig;
import com.yfanads.android.adx.CustomController;
import com.yfanads.android.adx.core.model.AdxNativeAd;
import com.yfanads.android.core.render.api.YFNativeAd;
import com.yfanads.android.model.AdInfo;
import com.yfanads.android.model.InitBean;
import com.yfanads.android.model.SdkSupplier;
import com.yfanads.android.model.YFAdError;
import com.yfanads.android.model.YFLocation;
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFListUtils;
import com.yfanads.android.utils.YFLog;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class AdxSdkUtil extends InitUtils {
    private static final String[] METHODS = {YFAdsConst.CUA, YFAdsConst.CUL, YFAdsConst.CUP, YFAdsConst.CUW, YFAdsConst.CWE, YFAdsConst.CUAID, YFAdsConst.CUO, YFAdsConst.CAR, YFAdsConst.LP};

    public static String getAdId(SdkSupplier sdkSupplier) {
        try {
            return sdkSupplier.network.param.potId;
        } catch (Throwable th) {
            YFLog.error("getAdId is error " + th.getMessage());
            return "";
        }
    }

    public static AdInfo getAdInfo(AdxNativeAd adxNativeAd, String str) {
        String appName;
        if (adxNativeAd == null) {
            return null;
        }
        String adDescription = TextUtils.isEmpty(adxNativeAd.getProductName()) ? adxNativeAd.getAdDescription() : adxNativeAd.getProductName();
        if (TextUtils.isEmpty(adxNativeAd.getAppName())) {
            appName = TextUtils.isEmpty(adxNativeAd.getCorporationName()) ? adxNativeAd.getAdMerchant() : adxNativeAd.getCorporationName();
        } else {
            appName = adxNativeAd.getAppName();
        }
        return new AdInfo(adDescription, appName, str);
    }

    private static CustomController getAdxCustomController(final YFAdsConfig yFAdsConfig) {
        YFAdsConst.ReportAdnIdValue reportAdnIdValue = YFAdsConst.ReportAdnIdValue.ADX;
        boolean[] permissionValues = InitUtils.getPermissionValues(reportAdnIdValue, yFAdsConfig, true);
        final boolean permissionValue = InitUtils.getPermissionValue(permissionValues, YFAdsConst.CUA, true);
        final boolean permissionValue2 = InitUtils.getPermissionValue(permissionValues, YFAdsConst.CUL, true);
        final boolean permissionValue3 = InitUtils.getPermissionValue(permissionValues, YFAdsConst.CUP, true);
        final boolean permissionValue4 = InitUtils.getPermissionValue(permissionValues, YFAdsConst.CUW, true);
        final boolean permissionValue5 = InitUtils.getPermissionValue(permissionValues, YFAdsConst.CWE, true);
        final boolean permissionValue6 = InitUtils.getPermissionValue(permissionValues, YFAdsConst.CUAID, true);
        final boolean permissionValue7 = InitUtils.getPermissionValue(permissionValues, YFAdsConst.CUO, true);
        final boolean permissionValue8 = InitUtils.getPermissionValue(permissionValues, YFAdsConst.CAR, true);
        final boolean permissionValue9 = InitUtils.getPermissionValue(permissionValues, YFAdsConst.LP, false);
        InitUtils.printLog(reportAdnIdValue, METHODS, permissionValue, permissionValue2, permissionValue3, permissionValue4, permissionValue5, permissionValue6, permissionValue7, permissionValue8, permissionValue9);
        return new CustomController() { // from class: com.yfanads.ads.chanel.adx.utils.AdxSdkUtil.1
            @Override // com.yfanads.android.adx.CustomController
            public boolean canBootMark() {
                Map<String, Object> extDefine = yFAdsConfig.getExtDefine();
                if (!YFListUtils.isMapEmpty(extDefine)) {
                    try {
                        Object obj = extDefine.get("bootMark");
                        if (obj != null && (obj instanceof Boolean)) {
                            return ((Boolean) obj).booleanValue();
                        }
                    } catch (Exception e) {
                        YFLog.error("canBootMark: " + e.getMessage());
                    }
                }
                return true;
            }

            @Override // com.yfanads.android.adx.CustomController
            public boolean canCloseAppReceiver() {
                return permissionValue8;
            }

            @Override // com.yfanads.android.adx.CustomController
            public boolean canUseAndroidId() {
                return permissionValue6;
            }

            @Override // com.yfanads.android.adx.CustomController
            public boolean canUseAppList() {
                return permissionValue;
            }

            @Override // com.yfanads.android.adx.CustomController
            public boolean canUseLocation() {
                return permissionValue2;
            }

            @Override // com.yfanads.android.adx.CustomController
            public boolean canUseMacAddress() {
                return permissionValue4;
            }

            @Override // com.yfanads.android.adx.CustomController
            public boolean canUseOaid() {
                return permissionValue7;
            }

            @Override // com.yfanads.android.adx.CustomController
            public boolean canUsePhoneState() {
                return permissionValue3;
            }

            @Override // com.yfanads.android.adx.CustomController
            public boolean canUseStoragePermission() {
                return permissionValue5;
            }

            @Override // com.yfanads.android.adx.CustomController
            public boolean canUseWriteExternal() {
                return permissionValue5;
            }

            @Override // com.yfanads.android.adx.CustomController
            public String devImei() {
                return yFAdsConfig.getDevImei();
            }

            @Override // com.yfanads.android.adx.CustomController
            public String devOaid() {
                return InitUtils.getOaID(yFAdsConfig);
            }

            @Override // com.yfanads.android.adx.CustomController
            public boolean limitPersonal() {
                return permissionValue9;
            }

            @Override // com.yfanads.android.adx.CustomController
            public CustomController.a location() {
                CustomController.a aVar = new CustomController.a();
                YFLocation location = yFAdsConfig.getLocation();
                if (location != null) {
                    aVar.f9563a = (long) location.getLatitude();
                    aVar.b = (long) location.getLongitude();
                }
                return aVar;
            }
        };
    }

    public static String getReqAdId(SdkSupplier sdkSupplier) {
        try {
            return sdkSupplier.getAdId();
        } catch (Throwable th) {
            YFLog.error("getAdId is error " + th.getMessage());
            return "";
        }
    }

    public static void initAD(String str, Context context, InitBean initBean, InitUtils.InitListener initListener) {
        initAD(str, context, initBean, true, initListener);
    }

    public static void initAD(String str, Context context, InitBean initBean, boolean z, InitUtils.InitListener initListener) {
        if (initBean == null || TextUtils.isEmpty(initBean.appId)) {
            String str2 = str + " init failed AppID empty adx";
            if (initListener != null) {
                initListener.fail(YFAdError.ERROR_DATA_NULL, str2);
            }
            YFLog.error(str2);
            return;
        }
        String str3 = initBean.appId;
        try {
            if (InitUtils.isInitSuc(str3, initListener)) {
                YFLog.high(str + " init has do");
                return;
            }
            if (InitUtils.isInQueue(str, initListener, str3)) {
                YFLog.high(str + " init add to queue");
                return;
            }
            YFAdsConfig yFAdsConfig = YFAdsManager.getInstance().getYFAdsConfig();
            long jCurrentTimeMillis = System.currentTimeMillis();
            YFLog.high(str + " init syn start adx:" + initBean);
            AdxSDK.init(context, new AdxSdkConfig.Builder().setAppId(str3).setAppID(yFAdsConfig.getAppId()).setShowNotification(true).setIp(yFAdsConfig.getIp()).setWxAppId(initBean.wxAppId).setAppPageName(yFAdsConfig.getAppPackage()).setAppVersion(yFAdsConfig.getAppVer()).setAutoListPackage(z).setEnableDebug(yFAdsConfig.isDebug()).setVideoType(InitUtils.getVideoType()).setExtDefine(yFAdsConfig.getExtDefine()).setCustomController(getAdxCustomController(yFAdsConfig)).setAppName(yFAdsConfig.getAppName()).build());
            YFLog.high(str + " init syn success adx:" + str3 + "|t_" + (System.currentTimeMillis() - jCurrentTimeMillis));
            InitUtils.queueSuccess(str, str3);
        } catch (Exception e) {
            YFLog.error(str + e.getMessage());
            InitUtils.queueFail(str, e.getMessage(), str3);
        }
    }

    public static AdInfo getAdInfo(YFNativeAd yFNativeAd, String str) {
        String appName;
        if (yFNativeAd == null) {
            return null;
        }
        String adDescription = TextUtils.isEmpty(yFNativeAd.getAdTitle()) ? yFNativeAd.getAdDescription() : yFNativeAd.getAdTitle();
        if (TextUtils.isEmpty(yFNativeAd.getAppName())) {
            appName = TextUtils.isEmpty(yFNativeAd.getCorporationName()) ? "" : yFNativeAd.getCorporationName();
        } else {
            appName = yFNativeAd.getAppName();
        }
        return new AdInfo(adDescription, appName, str);
    }
}
