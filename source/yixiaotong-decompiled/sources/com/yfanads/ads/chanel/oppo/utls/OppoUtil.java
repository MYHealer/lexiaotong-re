package com.yfanads.ads.chanel.oppo.utls;

import android.content.Context;
import android.text.TextUtils;
import com.heytap.msp.mobad.api.InitParams;
import com.heytap.msp.mobad.api.MobAdManager;
import com.heytap.msp.mobad.api.MobCustomController;
import com.heytap.msp.mobad.api.params.INativeAdvanceData;
import com.yfanads.android.YFAdsConfig;
import com.yfanads.android.YFAdsManager;
import com.yfanads.android.model.AdInfo;
import com.yfanads.android.model.InitBean;
import com.yfanads.android.model.SdkSupplier;
import com.yfanads.android.model.YFAdError;
import com.yfanads.android.model.YFLocation;
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFLog;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class OppoUtil extends InitUtils {
    private static final String[] METHODS = {YFAdsConst.CUL, YFAdsConst.CUP, YFAdsConst.CUAID, YFAdsConst.CUW, YFAdsConst.CWE, YFAdsConst.CUA};

    public static void initOppo(String str, Context context, InitBean initBean, InitUtils.InitListener initListener) {
        initOppo(str, null, context, initBean, initListener);
    }

    public static void initOppo(String str, SdkSupplier sdkSupplier, Context context, InitBean initBean, InitUtils.InitListener initListener) {
        if (initBean == null || TextUtils.isEmpty(initBean.appId)) {
            String str2 = str + " init failed AppID empty oppo";
            YFLog.error(str2);
            initListener.fail(YFAdError.ERROR_DATA_NULL, str2);
            return;
        }
        String str3 = initBean.appId;
        try {
            if (isInitSuc(str, str3, initListener) || isInQueue(str, initListener, str3)) {
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            YFLog.high(str + " init syn start oppo:" + str3);
            if (sdkSupplier != null) {
                initReport(sdkSupplier, YFAdsConst.ReportETypeValue.ADS_INIT_START.getValue());
            }
            doInit(str, sdkSupplier, jCurrentTimeMillis, context, str3, new InitParams.Builder().setDebug(YFAdsManager.getInstance().getYFAdsConfig().isDebug()).setMobCustomController(getCustomController(YFAdsManager.getInstance().getYFAdsConfig())).build());
        } catch (Exception e) {
            e.printStackTrace();
            queueFail(e.getMessage(), str3);
        }
    }

    private static void doInit(String str, SdkSupplier sdkSupplier, long j, Context context, String str2, InitParams initParams) {
        MobAdManager.getInstance().init(context, str2, initParams);
        YFLog.high(str + " init syn success oppo:" + str2 + "|t_" + (System.currentTimeMillis() - j));
        callBackSuccess(sdkSupplier, str2);
    }

    private static void callBackSuccess(SdkSupplier sdkSupplier, String str) {
        if (sdkSupplier != null) {
            initReport(sdkSupplier, YFAdsConst.ReportETypeValue.ADS_INIT_SUCCESS.getValue());
        }
        queueSuccess(str);
    }

    private static MobCustomController getCustomController(final YFAdsConfig yFAdsConfig) {
        boolean[] permissionValues = getPermissionValues(YFAdsConst.ReportAdnIdValue.OPPO, yFAdsConfig, true);
        final boolean permissionValue = getPermissionValue(permissionValues, YFAdsConst.CUA, true);
        final boolean permissionValue2 = getPermissionValue(permissionValues, YFAdsConst.CUL, true);
        final boolean permissionValue3 = getPermissionValue(permissionValues, YFAdsConst.CUP, true);
        final boolean permissionValue4 = getPermissionValue(permissionValues, YFAdsConst.CUW, true);
        final boolean permissionValue5 = getPermissionValue(permissionValues, YFAdsConst.CWE, true);
        final boolean permissionValue6 = getPermissionValue(permissionValues, YFAdsConst.CUAID, true);
        printLog(YFAdsConst.ReportAdnIdValue.OPPO, METHODS, permissionValue2, permissionValue3, permissionValue6, permissionValue4, permissionValue5, permissionValue);
        return new MobCustomController() { // from class: com.yfanads.ads.chanel.oppo.utls.OppoUtil.1
            @Override // com.heytap.msp.mobad.api.MobCustomController
            public boolean alist() {
                return permissionValue;
            }

            @Override // com.heytap.msp.mobad.api.MobCustomController
            public String getAndroidId() {
                return "";
            }

            @Override // com.heytap.msp.mobad.api.MobCustomController
            public String getMacAddress() {
                return "";
            }

            @Override // com.heytap.msp.mobad.api.MobCustomController
            public boolean isCanUseAndroidId() {
                return permissionValue6;
            }

            @Override // com.heytap.msp.mobad.api.MobCustomController
            public boolean isCanUseLocation() {
                return permissionValue2;
            }

            @Override // com.heytap.msp.mobad.api.MobCustomController
            public boolean isCanUsePhoneState() {
                return permissionValue3;
            }

            @Override // com.heytap.msp.mobad.api.MobCustomController
            public boolean isCanUseWifiState() {
                return permissionValue4;
            }

            @Override // com.heytap.msp.mobad.api.MobCustomController
            public boolean isCanUseWriteExternal() {
                return permissionValue5;
            }

            @Override // com.heytap.msp.mobad.api.MobCustomController
            public String getDevImei() {
                return yFAdsConfig.getDevImei();
            }

            @Override // com.heytap.msp.mobad.api.MobCustomController
            public MobCustomController.LocationProvider getLocation() {
                final YFLocation location = yFAdsConfig.getLocation();
                return new MobCustomController.LocationProvider() { // from class: com.yfanads.ads.chanel.oppo.utls.OppoUtil.1.1
                    @Override // com.heytap.msp.mobad.api.MobCustomController.LocationProvider
                    public double getLatitude() {
                        YFLocation yFLocation = location;
                        if (yFLocation != null) {
                            return yFLocation.getLatitude();
                        }
                        return 0.0d;
                    }

                    @Override // com.heytap.msp.mobad.api.MobCustomController.LocationProvider
                    public double getLongitude() {
                        YFLocation yFLocation = location;
                        if (yFLocation != null) {
                            return yFLocation.getLongitude();
                        }
                        return 0.0d;
                    }
                };
            }
        };
    }

    public static AdInfo getAdInfo(INativeAdvanceData iNativeAdvanceData, String str) {
        if (iNativeAdvanceData == null) {
            return null;
        }
        return new AdInfo(TextUtils.isEmpty(iNativeAdvanceData.getTitle()) ? iNativeAdvanceData.getDesc() : iNativeAdvanceData.getTitle(), iNativeAdvanceData.getComplianceInfo() != null ? iNativeAdvanceData.getComplianceInfo().getDeveloperName() : "", str);
    }
}
