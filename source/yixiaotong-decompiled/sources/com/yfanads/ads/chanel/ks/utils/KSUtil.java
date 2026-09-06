package com.yfanads.ads.chanel.ks.utils;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsCustomController;
import com.kwad.sdk.api.KsInitCallback;
import com.kwad.sdk.api.KsLocation;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.api.SdkConfig;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.kwad.sdk.api.model.AdnName;
import com.stub.StubApp;
import com.yfanads.android.YFAdsConfig;
import com.yfanads.android.YFAdsManager;
import com.yfanads.android.libs.utils.Util;
import com.yfanads.android.model.AdInfo;
import com.yfanads.android.model.InitBean;
import com.yfanads.android.model.SdkSupplier;
import com.yfanads.android.model.YFAdError;
import com.yfanads.android.model.YFLocation;
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFListUtils;
import com.yfanads.android.utils.YFLog;
import com.yfanads.android.utils.YFUtil;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class KSUtil extends InitUtils {
    private static final String[] METHODS = {YFAdsConst.CUW, YFAdsConst.CUL, YFAdsConst.CUP, YFAdsConst.CUO, YFAdsConst.CWE, YFAdsConst.CUA, YFAdsConst.LP};
    public static final String REQUEST_ID = "llsid";

    private static String getAdnName(int i) {
        if (i == 1) {
            return "chuanshanjia";
        }
        if (i == 2) {
            return AdnName.GUANGDIANTONG;
        }
        if (i != 3) {
            return i != 11 ? "other" : "chuanshanjia";
        }
        return "baidu";
    }

    public static void initAD(String str, Context context, InitBean initBean, InitUtils.InitListener initListener) {
        initAD(str, null, context, initBean, initListener);
    }

    public static String getReqId(Map<String, Object> map) {
        if (YFListUtils.isMapEmpty(map)) {
            return "";
        }
        try {
            Object obj = map.get(REQUEST_ID);
            if (obj != null) {
                return String.valueOf(obj);
            }
        } catch (Exception e) {
            YFLog.error("getReqId " + e.getMessage());
        }
        return "";
    }

    public static void initAD(final String str, SdkSupplier sdkSupplier, Context context, InitBean initBean, InitUtils.InitListener initListener) {
        if (initBean == null || TextUtils.isEmpty(initBean.appId)) {
            String str2 = str + " init failed AppID empty ks";
            initListener.fail(YFAdError.ERROR_DATA_NULL, str2);
            YFLog.error(str2);
            return;
        }
        final String str3 = initBean.appId;
        try {
            YFAdsConfig yFAdsConfig = YFAdsManager.getInstance().getYFAdsConfig();
            String appId = KsAdSDK.getAppId();
            if (KsAdSDK.haseInit() && !TextUtils.isEmpty(str3) && !TextUtils.isEmpty(appId) && !TextUtils.equals(str3, appId)) {
                YFLog.high(str + " init asy ks has other sdk init. oldAppId:" + appId + " , newAppId:" + str3);
                if (isInQueue(str, initListener, str3)) {
                    YFLog.debug(str + " init asy ks restart isInQueue, return ");
                    if (KsAdSDK.haseInit()) {
                        YFLog.high(str + " init asy ks has other sdk init-1.");
                        KsAdSDK.start();
                        Util.MAIN_HANDLER.postDelayed(new Runnable() { // from class: com.yfanads.ads.chanel.ks.utils.KSUtil$$ExternalSyntheticLambda0
                            @Override // java.lang.Runnable
                            public final void run() {
                                KSUtil.queueSuccess(str, str3);
                            }
                        }, 200L);
                        return;
                    }
                    return;
                }
                YFLog.debug(str + " init asy ks restart , newAppId:" + str3);
                KsAdSDK.setPersonalRecommend(!getLimitPersonal(YFAdsConst.ReportAdnIdValue.KS, yFAdsConfig));
                KsAdSDK.init(StubApp.getOrigApplicationContext(context.getApplicationContext()), new SdkConfig.Builder().appId(str3).appName(yFAdsConfig.getAppName()).customController(getKsCustomController(yFAdsConfig)).build());
                KsAdSDK.start();
                Util.MAIN_HANDLER.postDelayed(new Runnable() { // from class: com.yfanads.ads.chanel.ks.utils.KSUtil$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        KSUtil.queueSuccess(str, str3);
                    }
                }, 300L);
                return;
            }
            if (isInitSuc(str, str3, initListener)) {
                YFLog.high(str + " init asy start ks isInitSuc true, " + str3);
                return;
            }
            if (isInQueue(str, initListener, str3)) {
                YFLog.high(str + " init asy start ks isInQueue true," + str3);
                if (KsAdSDK.haseInit()) {
                    YFLog.high(str + " init asy ks has other sdk init-2.");
                    KsAdSDK.start();
                    Util.MAIN_HANDLER.postDelayed(new Runnable() { // from class: com.yfanads.ads.chanel.ks.utils.KSUtil$$ExternalSyntheticLambda2
                        @Override // java.lang.Runnable
                        public final void run() {
                            KSUtil.queueSuccess(str, str3);
                        }
                    }, 200L);
                    return;
                }
                return;
            }
            if (KsAdSDK.haseInit()) {
                YFLog.high(str + " init asy start ks haseInit true," + str3);
                KsAdSDK.start();
                Util.MAIN_HANDLER.postDelayed(new Runnable() { // from class: com.yfanads.ads.chanel.ks.utils.KSUtil$$ExternalSyntheticLambda3
                    @Override // java.lang.Runnable
                    public final void run() {
                        KSUtil.queueSuccess(str, str3);
                    }
                }, 200L);
            } else {
                long jCurrentTimeMillis = System.currentTimeMillis();
                YFLog.high(str + " init asy start ks:" + str3);
                if (sdkSupplier != null) {
                    initReport(sdkSupplier, YFAdsConst.ReportETypeValue.ADS_INIT_START.getValue());
                }
                doInit(str, sdkSupplier, context, str3, yFAdsConfig, jCurrentTimeMillis);
            }
        } catch (Exception e) {
            e.printStackTrace();
            queueFail(e.getMessage(), str3);
        }
    }

    private static void doInit(final String str, final SdkSupplier sdkSupplier, Context context, final String str2, YFAdsConfig yFAdsConfig, final long j) {
        KsAdSDK.setPersonalRecommend(!getLimitPersonal(YFAdsConst.ReportAdnIdValue.KS, yFAdsConfig));
        KsAdSDK.init(context, new SdkConfig.Builder().appId(str2).appName(yFAdsConfig.getAppName()).showNotification(true).debug(yFAdsConfig.isDebug()).customController(getKsCustomController(yFAdsConfig)).setInitCallback(new KsInitCallback() { // from class: com.yfanads.ads.chanel.ks.utils.KSUtil.2
            @Override // com.kwad.sdk.api.KsInitCallback
            public void onSuccess() {
                YFLog.high(str + " init first success ks:|t_" + (System.currentTimeMillis() - j));
                KsAdSDK.start();
            }

            @Override // com.kwad.sdk.api.KsInitCallback
            public void onFail(int i, String str3) {
                YFLog.error(str + " init fail ks: code = " + i + " msg = " + str3);
                SdkSupplier sdkSupplier2 = sdkSupplier;
                if (sdkSupplier2 != null) {
                    InitUtils.initReport(sdkSupplier2, YFAdsConst.ReportETypeValue.ADS_INIT_FAIL.getValue());
                }
                InitUtils.queueFail(str, str3, str2);
            }
        }).setStartCallback(new KsInitCallback() { // from class: com.yfanads.ads.chanel.ks.utils.KSUtil.1
            @Override // com.kwad.sdk.api.KsInitCallback
            public void onSuccess() {
                YFLog.high(str + " init asy success ks:" + str2 + "|t_" + (System.currentTimeMillis() - j));
                SdkSupplier sdkSupplier2 = sdkSupplier;
                if (sdkSupplier2 != null) {
                    InitUtils.initReport(sdkSupplier2, YFAdsConst.ReportETypeValue.ADS_INIT_SUCCESS.getValue());
                }
                InitUtils.queueSuccess(str, str2);
            }

            @Override // com.kwad.sdk.api.KsInitCallback
            public void onFail(int i, String str3) {
                YFLog.error(str + " init ks fail ks: code = " + i + "  msg = " + str3);
                SdkSupplier sdkSupplier2 = sdkSupplier;
                if (sdkSupplier2 != null) {
                    InitUtils.initReport(sdkSupplier2, YFAdsConst.ReportETypeValue.ADS_INIT_FAIL.getValue());
                }
                InitUtils.queueFail(str, str3, str2);
            }
        }).build());
    }

    public static AdExposureFailedReason getAdExposureFailedReason(SdkSupplier sdkSupplier, SdkSupplier sdkSupplier2) {
        AdExposureFailedReason adExposureFailedReason = new AdExposureFailedReason();
        adExposureFailedReason.winEcpm = (int) sdkSupplier.ecpm;
        String adnId = sdkSupplier.getAdnId();
        if (sdkSupplier2 != null && sdkSupplier2.getAdnId().equals(adnId)) {
            adExposureFailedReason.adnType = 1;
        } else if (adnId.equals(String.valueOf(12))) {
            adExposureFailedReason.adnType = 3;
        } else {
            adExposureFailedReason.adnType = 2;
        }
        adExposureFailedReason.adnName = getAdnName(YFUtil.toInt(sdkSupplier.getAdnId(), 0));
        AdInfo adInfo = sdkSupplier.getAdInfo();
        if (adInfo != null) {
            adExposureFailedReason.adTitle = adInfo.getAdTitle();
            adExposureFailedReason.adUserName = adInfo.getAdOwner();
            adExposureFailedReason.adRequestId = adInfo.getAdRequestId();
        }
        return adExposureFailedReason;
    }

    private static KsCustomController getKsCustomController(final YFAdsConfig yFAdsConfig) {
        boolean[] permissionValues = getPermissionValues(YFAdsConst.ReportAdnIdValue.KS, yFAdsConfig, true);
        final boolean permissionValue = getPermissionValue(permissionValues, YFAdsConst.CUA, true);
        final boolean permissionValue2 = getPermissionValue(permissionValues, YFAdsConst.CUL, true);
        final boolean permissionValue3 = getPermissionValue(permissionValues, YFAdsConst.CUP, true);
        final boolean permissionValue4 = getPermissionValue(permissionValues, YFAdsConst.CUO, true);
        final boolean permissionValue5 = getPermissionValue(permissionValues, YFAdsConst.CUW, true);
        final boolean permissionValue6 = getPermissionValue(permissionValues, YFAdsConst.CWE, true);
        printLog(YFAdsConst.ReportAdnIdValue.KS, METHODS, permissionValue5, permissionValue2, permissionValue3, permissionValue4, permissionValue6, permissionValue, getPermissionValue(permissionValues, YFAdsConst.LP, false));
        return new KsCustomController() { // from class: com.yfanads.ads.chanel.ks.utils.KSUtil.3
            @Override // com.kwad.sdk.api.KsCustomController
            public boolean canReadInstalledPackages() {
                return permissionValue;
            }

            @Override // com.kwad.sdk.api.KsCustomController
            public boolean canReadLocation() {
                return permissionValue2;
            }

            @Override // com.kwad.sdk.api.KsCustomController
            public boolean canUseMacAddress() {
                return permissionValue5;
            }

            @Override // com.kwad.sdk.api.KsCustomController
            public boolean canUseNetworkState() {
                return permissionValue5;
            }

            @Override // com.kwad.sdk.api.KsCustomController
            public boolean canUseOaid() {
                return permissionValue4;
            }

            @Override // com.kwad.sdk.api.KsCustomController
            public boolean canUsePhoneState() {
                return permissionValue3;
            }

            @Override // com.kwad.sdk.api.KsCustomController
            public boolean canUseStoragePermission() {
                return permissionValue6;
            }

            @Override // com.kwad.sdk.api.KsCustomController
            public String getImei() {
                return yFAdsConfig.getDevImei();
            }

            @Override // com.kwad.sdk.api.KsCustomController
            public String getOaid() {
                return InitUtils.getOaID(yFAdsConfig);
            }

            @Override // com.kwad.sdk.api.KsCustomController
            public KsLocation getKsLocation() {
                YFLocation location = yFAdsConfig.getLocation();
                if (location != null) {
                    return new KsLocation(location.getLatitude(), location.getLongitude());
                }
                return super.getKsLocation();
            }
        };
    }

    public static long getAdId(SdkSupplier sdkSupplier) {
        try {
            return Long.parseLong(sdkSupplier.network.param.potId);
        } catch (Throwable th) {
            YFLog.error("getAdId is error " + th.getMessage());
            return -1L;
        }
    }

    public static AdInfo getAdInfo(KsNativeAd ksNativeAd, String str) {
        if (ksNativeAd == null) {
            return null;
        }
        return new AdInfo(TextUtils.isEmpty(ksNativeAd.getProductName()) ? ksNativeAd.getAdDescription() : ksNativeAd.getProductName(), TextUtils.isEmpty(ksNativeAd.getAdSource()) ? ksNativeAd.getCorporationName() : ksNativeAd.getAdSource(), str);
    }

    public static void checkAppID(Context context, String str, String str2) {
        if (!KsAdSDK.haseInit() || TextUtils.isEmpty(str) || Objects.equals(KsAdSDK.getAppId(), str)) {
            return;
        }
        YFLog.debug(str2 + "reInit  current appId " + KsAdSDK.getAppId() + " correct appId " + str);
        KsAdSDK.init(context, new SdkConfig.Builder().appId(str).build());
    }
}
