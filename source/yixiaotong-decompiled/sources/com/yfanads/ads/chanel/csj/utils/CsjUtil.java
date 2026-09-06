package com.yfanads.ads.chanel.csj.utils;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.ComplianceInfo;
import com.bytedance.sdk.openadsdk.LocationProvider;
import com.bytedance.sdk.openadsdk.TTAdConfig;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.TTLocation;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.mediation.init.IMediationPrivacyConfig;
import com.bytedance.sdk.openadsdk.mediation.init.MediationConfig;
import com.bytedance.sdk.openadsdk.mediation.init.MediationPrivacyConfig;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationAdEcpmInfo;
import com.hihonor.adsdk.base.mediation.adn.AdnConfig;
import com.ubixnow.ooooo.oOOOoo00;
import com.yfanads.android.YFAdsConfig;
import com.yfanads.android.YFAdsManager;
import com.yfanads.android.model.AdInfo;
import com.yfanads.android.model.InitBean;
import com.yfanads.android.model.SdkSupplier;
import com.yfanads.android.model.YFAdError;
import com.yfanads.android.model.YFLocation;
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFConfigUtils;
import com.yfanads.android.utils.YFListUtils;
import com.yfanads.android.utils.YFLog;
import com.yfanads.android.utils.YFUtil;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class CsjUtil extends InitUtils {
    private static final String[] METHODS = {YFAdsConst.CUA, YFAdsConst.CUL, YFAdsConst.CUP, YFAdsConst.CUW, YFAdsConst.CWE, YFAdsConst.CUAID, YFAdsConst.LP};
    private static final String TAG_ID = "tag_id";
    public static boolean isSupportBidding = true;
    protected static boolean lastCanUseAndroidId;
    protected static boolean lastCanUseAppList;
    protected static boolean lastCanUseLocation;
    protected static boolean lastCanUseOaid;
    protected static boolean lastCanUsePhoneState;
    protected static boolean lastCanUseWifi;
    protected static boolean lastCanUseWriteExternal;
    protected static boolean lastLimitPersonal;

    private static boolean isPermissionChange(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8) {
        return (lastCanUseWifi == z && lastCanUseLocation == z2 && lastCanUsePhoneState == z3 && lastCanUseWriteExternal == z4 && lastCanUseAppList == z5 && lastCanUseOaid == z6 && lastLimitPersonal == z7 && lastCanUseAndroidId == z8) ? false : true;
    }

    public static TTAdManager getADManger() {
        try {
            return TTAdSdk.getAdManager();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static String getSdkVersion() {
        return getADManger() != null ? getADManger().getSDKVersion() : "";
    }

    public static void initCsj(String str, SdkSupplier sdkSupplier, Context context, InitBean initBean, InitUtils.InitListener initListener) {
        initCsj(str, sdkSupplier, context, initBean, false, initListener);
    }

    public static void initCsj(String str, Context context, InitBean initBean, InitUtils.InitListener initListener) {
        initCsj(str, null, context, initBean, false, initListener);
    }

    public static void initGroMore(String str, SdkSupplier sdkSupplier, Context context, InitBean initBean, InitUtils.InitListener initListener) {
        initCsj(str, sdkSupplier, context, initBean, true, initListener);
    }

    public static void initGroMore(String str, Context context, InitBean initBean, InitUtils.InitListener initListener) {
        initCsj(str, null, context, initBean, true, initListener);
    }

    private static void initCsj(String str, SdkSupplier sdkSupplier, Context context, InitBean initBean, boolean z, InitUtils.InitListener initListener) {
        YFAdsConst.ReportAdnIdValue reportAdnIdValue;
        if (initBean == null || TextUtils.isEmpty(initBean.appId)) {
            String str2 = str + " init failed AppID empty csj";
            if (initListener != null) {
                initListener.fail(YFAdError.ERROR_DATA_NULL, str2);
            }
            YFLog.error(str2);
            return;
        }
        String str3 = initBean.appId;
        try {
            YFAdsConfig yFAdsConfig = YFAdsManager.getInstance().getYFAdsConfig();
            if (isInitSuc(str, str3, initListener)) {
                YFLog.high(str + " init asy csj has init to updateConfig.");
                updateConfig(z, yFAdsConfig);
                return;
            }
            boolean zIsInQueue = isInQueue(str, initListener, str3);
            boolean zIsSdkReady = TTAdSdk.isSdkReady();
            YFLog.high(str + " init asy csj resultAppId " + str3 + " posid " + (sdkSupplier != null ? sdkSupplier.getPotId() : "") + " sdkIsReady " + zIsSdkReady + " inQueue " + zIsInQueue);
            if (!zIsInQueue && !zIsSdkReady) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (sdkSupplier != null) {
                    initReport(sdkSupplier, YFAdsConst.ReportETypeValue.ADS_INIT_START.getValue());
                }
                if (z) {
                    reportAdnIdValue = YFAdsConst.ReportAdnIdValue.CSJ_GROMORE;
                } else {
                    reportAdnIdValue = YFAdsConst.ReportAdnIdValue.CSJ;
                }
                boolean zIsUserGM = InitUtils.isUserGM() ? InitUtils.isUserGM() : z;
                YFLog.high(str + " init asy start csj " + str3 + " useMediation " + z + " isUG " + zIsUserGM);
                TTAdConfig.Builder builderCustomController = new TTAdConfig.Builder().appId(str3).appName(yFAdsConfig.getAppName()).titleBarTheme(0).allowShowNotify(true).debug(yFAdsConfig.isDebug()).useMediation(zIsUserGM).supportMultiProcess(false).customController(getTtCustomController(reportAdnIdValue, yFAdsConfig));
                if (z) {
                    builderCustomController.setMediationConfig(new MediationConfig.Builder().setWxAppId(initBean.wxAppId).build());
                }
                doInit(str, sdkSupplier, context, builderCustomController.build(), str3, jCurrentTimeMillis);
                return;
            }
            if (zIsSdkReady) {
                YFLog.high(str + " init asy csj has other sdk init.");
                queueSuccess(str, str3);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            queueFail(th.getMessage(), str3);
        }
    }

    private static void updateConfig(boolean z, YFAdsConfig yFAdsConfig) {
        YFAdsConst.ReportAdnIdValue reportAdnIdValue;
        if (z) {
            reportAdnIdValue = YFAdsConst.ReportAdnIdValue.CSJ_GROMORE;
        } else {
            reportAdnIdValue = YFAdsConst.ReportAdnIdValue.CSJ;
        }
        boolean[] permissionValues = getPermissionValues(reportAdnIdValue, yFAdsConfig, true);
        boolean permissionValue = getPermissionValue(permissionValues, YFAdsConst.CUW, true);
        boolean permissionValue2 = getPermissionValue(permissionValues, YFAdsConst.CUAID, true);
        boolean permissionValue3 = getPermissionValue(permissionValues, YFAdsConst.CUP, true);
        boolean permissionValue4 = getPermissionValue(permissionValues, YFAdsConst.CUL, true);
        boolean permissionValue5 = getPermissionValue(permissionValues, YFAdsConst.CWE, true);
        boolean permissionValue6 = getPermissionValue(permissionValues, YFAdsConst.CUA, true);
        boolean permissionValue7 = getPermissionValue(permissionValues, YFAdsConst.CUO, true);
        boolean permissionValue8 = getPermissionValue(permissionValues, YFAdsConst.LP, false);
        if (isPermissionChange(permissionValue, permissionValue4, permissionValue3, permissionValue5, permissionValue6, permissionValue7, permissionValue8, permissionValue2)) {
            TTAdSdk.updateAdConfig(new TTAdConfig.Builder().customController(getTtCustomController(yFAdsConfig, permissionValue, permissionValue4, permissionValue3, permissionValue5, permissionValue6, permissionValue7, permissionValue8, permissionValue2)).build());
        }
    }

    @Deprecated
    private static String getData(String str) {
        try {
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("name", "personal_ads_type");
            jSONObject.put(oOOOoo00.OooOo0o, str);
            jSONArray.put(jSONObject);
            return jSONArray.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private static TTCustomController getTtCustomController(final YFAdsConfig yFAdsConfig, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8) {
        lastCanUseWifi = z;
        lastCanUseAndroidId = z8;
        lastCanUsePhoneState = z3;
        lastCanUseLocation = z2;
        lastCanUseWriteExternal = z4;
        lastCanUseAppList = z5;
        lastCanUseOaid = z6;
        lastLimitPersonal = z7;
        return new TTCustomController() { // from class: com.yfanads.ads.chanel.csj.utils.CsjUtil.1
            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public boolean alist() {
                return CsjUtil.lastCanUseAppList;
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public boolean isCanUseLocation() {
                return CsjUtil.lastCanUseLocation;
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public boolean isCanUsePhoneState() {
                return CsjUtil.lastCanUsePhoneState;
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public String getDevImei() {
                return yFAdsConfig.getDevImei();
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public boolean isCanUseWifiState() {
                return CsjUtil.lastCanUseWifi;
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public boolean isCanUseWriteExternal() {
                return CsjUtil.lastCanUseWriteExternal;
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public String getDevOaid() {
                return InitUtils.getOaID(yFAdsConfig);
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public boolean isCanUseAndroidId() {
                return CsjUtil.lastCanUseAndroidId;
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public LocationProvider getTTLocation() {
                YFLocation location = yFAdsConfig.getLocation();
                if (location != null) {
                    return new TTLocation(location.getLatitude(), location.getLongitude());
                }
                return super.getTTLocation();
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public IMediationPrivacyConfig getMediationPrivacyConfig() {
                return new MediationPrivacyConfig() { // from class: com.yfanads.ads.chanel.csj.utils.CsjUtil.1.1
                    @Override // com.bytedance.sdk.openadsdk.mediation.init.MediationPrivacyConfig, com.bytedance.sdk.openadsdk.mediation.init.IMediationPrivacyConfig
                    public boolean isLimitPersonalAds() {
                        return CsjUtil.lastLimitPersonal;
                    }

                    @Override // com.bytedance.sdk.openadsdk.mediation.init.MediationPrivacyConfig, com.bytedance.sdk.openadsdk.mediation.init.IMediationPrivacyConfig
                    public boolean isCanUseOaid() {
                        return CsjUtil.lastCanUseOaid;
                    }

                    @Override // com.bytedance.sdk.openadsdk.mediation.init.MediationPrivacyConfig, com.bytedance.sdk.openadsdk.mediation.init.IMediationPrivacyConfig
                    public boolean isProgrammaticRecommend() {
                        return super.isProgrammaticRecommend();
                    }
                };
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public Map<String, Object> userPrivacyConfig() {
                HashMap map = new HashMap();
                if (!CsjUtil.lastCanUseOaid) {
                    map.put("mcod", "0");
                } else {
                    map.put("mcod", "1");
                }
                if (!YFConfigUtils.getBooleanValue(YFConfigUtils.ConfigType.EXT, "is_shake_action", true)) {
                    map.put("motion_info", "0");
                } else {
                    map.put("motion_info", "1");
                }
                if (!CsjUtil.lastCanUseWifi) {
                    map.put("uip", "0");
                }
                return map;
            }
        };
    }

    private static TTCustomController getTtCustomController(YFAdsConst.ReportAdnIdValue reportAdnIdValue, final YFAdsConfig yFAdsConfig) {
        boolean[] permissionValues = getPermissionValues(reportAdnIdValue, yFAdsConfig, true);
        lastCanUseWifi = getPermissionValue(permissionValues, YFAdsConst.CUW, true);
        lastCanUseAndroidId = getPermissionValue(permissionValues, YFAdsConst.CUAID, true);
        lastCanUsePhoneState = getPermissionValue(permissionValues, YFAdsConst.CUP, true);
        lastCanUseLocation = getPermissionValue(permissionValues, YFAdsConst.CUL, true);
        lastCanUseWriteExternal = getPermissionValue(permissionValues, YFAdsConst.CWE, true);
        lastCanUseAppList = getPermissionValue(permissionValues, YFAdsConst.CUA, true);
        lastCanUseOaid = getPermissionValue(permissionValues, YFAdsConst.CUO, true);
        boolean permissionValue = getPermissionValue(permissionValues, YFAdsConst.LP, false);
        lastLimitPersonal = permissionValue;
        printLog(reportAdnIdValue, METHODS, lastCanUseAppList, lastCanUseLocation, lastCanUsePhoneState, lastCanUseWifi, lastCanUseWriteExternal, lastCanUseAndroidId, permissionValue);
        return new TTCustomController() { // from class: com.yfanads.ads.chanel.csj.utils.CsjUtil.2
            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public boolean alist() {
                return CsjUtil.lastCanUseAppList;
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public boolean isCanUseLocation() {
                return CsjUtil.lastCanUseLocation;
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public boolean isCanUsePhoneState() {
                return CsjUtil.lastCanUsePhoneState;
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public String getDevImei() {
                return yFAdsConfig.getDevImei();
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public boolean isCanUseWifiState() {
                return CsjUtil.lastCanUseWifi;
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public boolean isCanUseWriteExternal() {
                return CsjUtil.lastCanUseWriteExternal;
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public String getDevOaid() {
                return InitUtils.getOaID(yFAdsConfig);
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public boolean isCanUseAndroidId() {
                return CsjUtil.lastCanUseAndroidId;
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public LocationProvider getTTLocation() {
                YFLocation location = yFAdsConfig.getLocation();
                if (location != null) {
                    return new TTLocation(location.getLatitude(), location.getLongitude());
                }
                return super.getTTLocation();
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public IMediationPrivacyConfig getMediationPrivacyConfig() {
                return new MediationPrivacyConfig() { // from class: com.yfanads.ads.chanel.csj.utils.CsjUtil.2.1
                    @Override // com.bytedance.sdk.openadsdk.mediation.init.MediationPrivacyConfig, com.bytedance.sdk.openadsdk.mediation.init.IMediationPrivacyConfig
                    public boolean isLimitPersonalAds() {
                        return CsjUtil.lastLimitPersonal;
                    }

                    @Override // com.bytedance.sdk.openadsdk.mediation.init.MediationPrivacyConfig, com.bytedance.sdk.openadsdk.mediation.init.IMediationPrivacyConfig
                    public boolean isCanUseOaid() {
                        return CsjUtil.lastCanUseOaid;
                    }

                    @Override // com.bytedance.sdk.openadsdk.mediation.init.MediationPrivacyConfig, com.bytedance.sdk.openadsdk.mediation.init.IMediationPrivacyConfig
                    public boolean isProgrammaticRecommend() {
                        return super.isProgrammaticRecommend();
                    }
                };
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public Map<String, Object> userPrivacyConfig() {
                HashMap map = new HashMap();
                if (!CsjUtil.lastCanUseOaid) {
                    map.put("mcod", "0");
                } else {
                    map.put("mcod", "1");
                }
                if (!YFConfigUtils.getBooleanValue(YFConfigUtils.ConfigType.EXT, "is_shake_action", true)) {
                    map.put("motion_info", "0");
                } else {
                    map.put("motion_info", "1");
                }
                if (!CsjUtil.lastCanUseWifi) {
                    map.put("uip", "0");
                }
                return map;
            }
        };
    }

    private static void doInit(final String str, final SdkSupplier sdkSupplier, Context context, TTAdConfig tTAdConfig, final String str2, final long j) {
        TTAdSdk.init(context, tTAdConfig);
        TTAdSdk.start(new TTAdSdk.Callback() { // from class: com.yfanads.ads.chanel.csj.utils.CsjUtil.3
            @Override // com.bytedance.sdk.openadsdk.TTAdSdk.InitCallback
            public void success() {
                YFLog.high(str + " init asy success csj:" + str2 + "|t_" + (System.currentTimeMillis() - j) + "|r_" + TTAdSdk.isSdkReady());
                SdkSupplier sdkSupplier2 = sdkSupplier;
                if (sdkSupplier2 != null) {
                    InitUtils.initReport(sdkSupplier2, YFAdsConst.ReportETypeValue.ADS_INIT_SUCCESS.getValue());
                }
                InitUtils.queueSuccess(str, str2);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdSdk.InitCallback
            public void fail(int i, String str3) {
                YFLog.error(str + " init fail csj: code = " + i + " msg = " + str3);
                SdkSupplier sdkSupplier2 = sdkSupplier;
                if (sdkSupplier2 != null) {
                    InitUtils.initReport(sdkSupplier2, YFAdsConst.ReportETypeValue.ADS_INIT_FAIL.getValue());
                }
                InitUtils.queueFail(str, str3, str2);
            }
        });
    }

    public static String getAdnName(String str) {
        int i = YFUtil.toInt(str, 0);
        if (i == 2) {
            return AdnConfig.a.hnadsc;
        }
        if (i != 3) {
            return i != 4 ? "" : "kuai";
        }
        return "bqt";
    }

    public static AdInfo getAdInfo(TTFeedAd tTFeedAd, String str) {
        String source;
        if (tTFeedAd == null) {
            return null;
        }
        String description = TextUtils.isEmpty(tTFeedAd.getTitle()) ? tTFeedAd.getDescription() : tTFeedAd.getTitle();
        ComplianceInfo complianceInfo = tTFeedAd.getComplianceInfo();
        if (TextUtils.isEmpty(tTFeedAd.getSource())) {
            source = complianceInfo != null ? complianceInfo.getDeveloperName() : "";
        } else {
            source = tTFeedAd.getSource();
        }
        return new AdInfo(description, source, str);
    }

    public static String getReqId(Map<String, Object> map) {
        if (YFListUtils.isMapEmpty(map)) {
            return "";
        }
        try {
            return map.get("request_id") + "_" + map.get(TAG_ID);
        } catch (Exception e) {
            YFLog.error("getReqId " + e.getMessage());
            return "";
        }
    }

    public static String getMReqId(MediationAdEcpmInfo mediationAdEcpmInfo) {
        try {
            String requestId = mediationAdEcpmInfo.getRequestId();
            YFLog.debug("getMReqId " + requestId);
            return requestId;
        } catch (Exception e) {
            YFLog.error("getMReqId " + e.getMessage());
            return "";
        }
    }

    public static int getMAdnId(TTFeedAd tTFeedAd) {
        if (tTFeedAd != null && tTFeedAd.getMediationManager() != null && tTFeedAd.getMediationManager().getBestEcpm() != null) {
            String sdkName = tTFeedAd.getMediationManager().getBestEcpm().getSdkName();
            if (TextUtils.equals(sdkName, MediationConstant.ADN_KS)) {
                return 4;
            }
            if (TextUtils.equals(sdkName, "baidu")) {
                return 3;
            }
            if (TextUtils.equals(sdkName, MediationConstant.ADN_GDT)) {
                return 2;
            }
        }
        return 1;
    }

    public static String getMShowEcpm(MediationAdEcpmInfo mediationAdEcpmInfo) {
        if (mediationAdEcpmInfo != null) {
            String ecpm = mediationAdEcpmInfo.getEcpm();
            if (!TextUtils.isEmpty(ecpm)) {
                return ((long) Double.parseDouble(ecpm)) + "";
            }
        }
        return "";
    }
}
