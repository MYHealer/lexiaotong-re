package com.yfanads.ads.chanel.nal.utils;

import android.content.Context;
import android.location.Location;
import android.text.TextUtils;
import com.adprof.sdk.AdprofSdk;
import com.adprof.sdk.api.AdprofSdkConfig;
import com.adprof.sdk.api.CustomController;
import com.adprof.sdk.api.InitCallback;
import com.yfanads.android.YFAdsConfig;
import com.yfanads.android.YFAdsManager;
import com.yfanads.android.model.InitBean;
import com.yfanads.android.model.SdkSupplier;
import com.yfanads.android.model.YFAdError;
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFLog;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class NalUtil extends InitUtils {
    private static final String[] METHODS = {YFAdsConst.CUA, YFAdsConst.CUL, YFAdsConst.CUP, YFAdsConst.CUO, YFAdsConst.CUW, YFAdsConst.CWE, YFAdsConst.LP, YFAdsConst.CUAID};

    public static void initNal(String str, Context context, InitBean initBean, InitUtils.InitListener initListener) {
        initNal(str, null, context, initBean, initListener);
    }

    public static void initNal(final String str, final SdkSupplier sdkSupplier, Context context, final InitBean initBean, InitUtils.InitListener initListener) {
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
            YFLog.high(str + " init syn start nal:" + str3);
            if (sdkSupplier != null) {
                initReport(sdkSupplier, YFAdsConst.ReportETypeValue.ADS_INIT_START.getValue());
            }
            boolean[] permissionValues = getPermissionValues(YFAdsConst.ReportAdnIdValue.NAL, yFAdsConfig, true);
            boolean permissionValue = getPermissionValue(permissionValues, YFAdsConst.CUA, true);
            boolean permissionValue2 = getPermissionValue(permissionValues, YFAdsConst.CUL, true);
            boolean permissionValue3 = getPermissionValue(permissionValues, YFAdsConst.CUP, true);
            boolean permissionValue4 = getPermissionValue(permissionValues, YFAdsConst.CUO, true);
            boolean permissionValue5 = getPermissionValue(permissionValues, YFAdsConst.CUW, true);
            boolean permissionValue6 = getPermissionValue(permissionValues, YFAdsConst.CWE, true);
            boolean permissionValue7 = getPermissionValue(permissionValues, YFAdsConst.LP, false);
            printLog(YFAdsConst.ReportAdnIdValue.NAL, METHODS, permissionValue, permissionValue2, permissionValue3, permissionValue4, permissionValue5, permissionValue6, permissionValue7, getPermissionValue(permissionValues, YFAdsConst.CUAID, true));
            AdprofSdk.getInstance().setPersonalRecommend(!permissionValue7);
            AdprofSdk.getInstance().init(context, new AdprofSdkConfig.Builder().appId(str3).appSecret(initBean.appSecret).showLog(isDebug).useHttps(true).customController(new CustomController() { // from class: com.yfanads.ads.chanel.nal.utils.NalUtil.2
                @Override // com.adprof.sdk.api.CustomController
                public Location getLocation() {
                    return super.getLocation();
                }

                @Override // com.adprof.sdk.api.CustomController
                public String getImei() {
                    return yFAdsConfig.getDevImei();
                }

                @Override // com.adprof.sdk.api.CustomController
                public String getAndroidId() {
                    return yFAdsConfig.getDevAndroidId();
                }

                @Override // com.adprof.sdk.api.CustomController
                public String getOaid() {
                    return InitUtils.getOaID(yFAdsConfig);
                }
            }).setInitCallback(new InitCallback() { // from class: com.yfanads.ads.chanel.nal.utils.NalUtil.1
                @Override // com.adprof.sdk.api.InitCallback
                public void onSuccess() {
                    SdkSupplier sdkSupplier2 = sdkSupplier;
                    if (sdkSupplier2 != null) {
                        InitUtils.initReport(sdkSupplier2, YFAdsConst.ReportETypeValue.ADS_INIT_SUCCESS.getValue());
                    }
                    InitUtils.queueSuccess(str, str3);
                    YFLog.high(str + " init asy success nal:" + initBean.appId + "|t_" + (System.currentTimeMillis() - jCurrentTimeMillis));
                }

                @Override // com.adprof.sdk.api.InitCallback
                public void onFail(int i, String str4) {
                    YFLog.warn(str + " init asy fail nal:" + i + "|s_" + str4);
                    SdkSupplier sdkSupplier2 = sdkSupplier;
                    if (sdkSupplier2 != null) {
                        InitUtils.initReport(sdkSupplier2, YFAdsConst.ReportETypeValue.ADS_INIT_FAIL.getValue());
                    }
                    InitUtils.queueFail(str, "nal init fail", str3);
                }
            }).build());
        } catch (Exception e) {
            e.printStackTrace();
            queueFail(str, e.getMessage(), str3);
        }
    }
}
