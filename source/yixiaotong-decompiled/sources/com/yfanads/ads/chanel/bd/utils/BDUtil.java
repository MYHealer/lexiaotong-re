package com.yfanads.ads.chanel.bd.utils;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.BDAdConfig;
import com.baidu.mobads.sdk.api.BDDialogParams;
import com.baidu.mobads.sdk.api.MobadsPermissionSettings;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.mobads.sdk.api.SplashAd;
import com.huawei.hms.ads.ez;
import com.yfanads.android.YFAdsConfig;
import com.yfanads.android.YFAdsManager;
import com.yfanads.android.model.AdInfo;
import com.yfanads.android.model.InitBean;
import com.yfanads.android.model.SdkSupplier;
import com.yfanads.android.model.YFAdError;
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFLog;
import com.yfanads.android.utils.YFUtil;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class BDUtil extends InitUtils {
    private static final String[] METHODS = {YFAdsConst.CUP, YFAdsConst.CUL, YFAdsConst.CWE, YFAdsConst.CUA, YFAdsConst.CUO, YFAdsConst.LP, YFAdsConst.CAR};
    protected static boolean lastCanUseAppList;
    protected static boolean lastCanUseLocation;
    protected static boolean lastCanUseOaid;
    protected static boolean lastCanUsePhoneState;
    protected static boolean lastCanUseWriteExternal;
    protected static boolean lastLimitPersonal;

    private static int getAdnId(int i) {
        if (i != 1) {
            int i2 = 2;
            if (i != 2) {
                i2 = 9;
                if (i != 3) {
                    if (i == 4) {
                        return 3;
                    }
                    if (i == 9) {
                        return 8;
                    }
                    if (i != 11) {
                        return 10;
                    }
                }
            }
            return i2;
        }
        return 1;
    }

    public static void initBDAccount(String str, Context context, InitBean initBean, InitUtils.InitListener initListener) {
        initBDAccount(str, null, context, initBean, initListener);
    }

    public static void initBDAccount(String str, SdkSupplier sdkSupplier, Context context, InitBean initBean, InitUtils.InitListener initListener) {
        if (initBean == null || TextUtils.isEmpty(initBean.appId)) {
            String str2 = str + " init failed InitBean empty bd ";
            initListener.fail(YFAdError.ERROR_INIT_FAILED, str2);
            YFLog.error(str2);
            return;
        }
        String str3 = initBean.appId;
        try {
            YFAdsConfig yFAdsConfig = YFAdsManager.getInstance().getYFAdsConfig();
            if (isInitSuc(str, str3, initListener)) {
                updateConfig(false, getPermissionValues(YFAdsConst.ReportAdnIdValue.BAIDU, yFAdsConfig, false));
                return;
            }
            if (isInQueue(str, initListener, str3)) {
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            YFLog.high(str + " init syn start bd:" + str3);
            if (sdkSupplier != null) {
                initReport(sdkSupplier, YFAdsConst.ReportETypeValue.ADS_INIT_START.getValue());
            }
            boolean[] permissionValues = getPermissionValues(YFAdsConst.ReportAdnIdValue.BAIDU, yFAdsConfig, true);
            String str4 = getPermissionValue(permissionValues, YFAdsConst.CAR, false) ? ez.V : ez.Code;
            updateConfig(true, permissionValues);
            printLog(str4);
            new BDAdConfig.Builder().setAppName(yFAdsConfig.getAppName()).setDebug(yFAdsConfig.isDebug()).setAppsid(initBean.appId).setWXAppid(initBean.wxAppId).setDialogParams(new BDDialogParams.Builder().setDlDialogType(0).setDlDialogAnimStyle(0).build()).putExtraParam("pk_change_rc", str4).putExtraParam("mi_market_rc", str4).build(context).init();
            YFLog.high(str + " init syn success bd:" + initBean.appId + "|t_" + (System.currentTimeMillis() - jCurrentTimeMillis));
            if (sdkSupplier != null) {
                initReport(sdkSupplier, YFAdsConst.ReportETypeValue.ADS_INIT_SUCCESS.getValue());
            }
            queueSuccess(str, str3);
        } catch (Exception e) {
            e.printStackTrace();
            queueFail(str, e.getMessage(), str3);
        }
    }

    private static void printLog(String str) {
        printLog(YFAdsConst.ReportAdnIdValue.BAIDU, METHODS, lastCanUsePhoneState, lastCanUseLocation, lastCanUseWriteExternal, lastCanUseAppList, lastCanUseOaid, lastLimitPersonal, ez.Code.equals(str));
    }

    private static void updateConfig(boolean z, boolean[] zArr) {
        int value = YFAdsConst.ReportAdnIdValue.BAIDU.getValue();
        if (z) {
            lastCanUsePhoneState = getPermissionValue(zArr, YFAdsConst.CUP, true);
            lastCanUseLocation = getPermissionValue(zArr, YFAdsConst.CUL, true);
            lastCanUseWriteExternal = getPermissionValue(zArr, YFAdsConst.CWE, true);
            lastCanUseAppList = getPermissionValue(zArr, YFAdsConst.CUA, true);
            lastCanUseOaid = getPermissionValue(zArr, YFAdsConst.CUO, true);
            lastLimitPersonal = getPermissionValue(zArr, YFAdsConst.LP, false);
            MobadsPermissionSettings.setPermissionReadDeviceID(lastCanUsePhoneState);
            MobadsPermissionSettings.setPermissionLocation(lastCanUseLocation);
            MobadsPermissionSettings.setPermissionStorage(lastCanUseWriteExternal);
            MobadsPermissionSettings.setPermissionAppList(lastCanUseAppList);
            MobadsPermissionSettings.setPermissionOAID(lastCanUseOaid);
            MobadsPermissionSettings.setLimitPersonalAds(lastLimitPersonal);
            return;
        }
        boolean permissionValue = getPermissionValue(zArr, YFAdsConst.CUP, true);
        boolean permissionValue2 = getPermissionValue(zArr, YFAdsConst.CUL, true);
        boolean permissionValue3 = getPermissionValue(zArr, YFAdsConst.CWE, true);
        boolean permissionValue4 = getPermissionValue(zArr, YFAdsConst.CUA, true);
        boolean permissionValue5 = getPermissionValue(zArr, YFAdsConst.CUO, true);
        boolean permissionValue6 = getPermissionValue(zArr, YFAdsConst.LP, false);
        if (lastCanUsePhoneState != permissionValue) {
            lastCanUsePhoneState = permissionValue;
            MobadsPermissionSettings.setPermissionReadDeviceID(permissionValue);
            printLog(value, "setPermissionReadDeviceID", lastCanUsePhoneState);
        }
        if (lastCanUseLocation != permissionValue2) {
            lastCanUseLocation = permissionValue2;
            MobadsPermissionSettings.setPermissionLocation(permissionValue2);
            printLog(value, "setPermissionLocation", lastCanUseLocation);
        }
        if (lastCanUseWriteExternal != permissionValue3) {
            lastCanUseWriteExternal = permissionValue3;
            MobadsPermissionSettings.setPermissionStorage(permissionValue3);
            printLog(value, "setPermissionStorage", lastCanUseWriteExternal);
        }
        if (lastCanUseAppList != permissionValue4) {
            lastCanUseAppList = permissionValue4;
            MobadsPermissionSettings.setPermissionAppList(permissionValue4);
            printLog(value, "setPermissionAppList", lastCanUseAppList);
        }
        if (lastCanUseOaid != permissionValue5) {
            lastCanUseOaid = permissionValue5;
            MobadsPermissionSettings.setPermissionOAID(permissionValue5);
            printLog(value, "setPermissionOAID", lastCanUseOaid);
        }
        if (lastLimitPersonal != permissionValue6) {
            lastLimitPersonal = permissionValue6;
            MobadsPermissionSettings.setLimitPersonalAds(permissionValue6);
            printLog(value, "setLimitPersonalAds", lastLimitPersonal);
        }
    }

    public static AdInfo getAdInfo(NativeResponse nativeResponse, String str) {
        if (nativeResponse == null) {
            return null;
        }
        return new AdInfo(TextUtils.isEmpty(nativeResponse.getTitle()) ? nativeResponse.getDesc() : nativeResponse.getTitle(), TextUtils.isEmpty(nativeResponse.getBrandName()) ? nativeResponse.getPublisher() : nativeResponse.getBrandName(), str);
    }

    public static String getReqId(Object obj) {
        if (obj == null) {
            return "";
        }
        try {
            return String.valueOf(obj);
        } catch (Exception e) {
            YFLog.error("getReqId exception " + e.getMessage());
            return "";
        }
    }

    public static LinkedHashMap<String, Object> getWindBiddingMap(SdkSupplier sdkSupplier) {
        LinkedHashMap<String, Object> linkedHashMap = new LinkedHashMap<>();
        if (sdkSupplier == null) {
            linkedHashMap.put(SplashAd.KEY_BIDFAIL_ADN, Integer.valueOf(getAdnId(10)));
            linkedHashMap.put("bid_t", 4);
        } else {
            linkedHashMap.put("ecpm", Long.valueOf(sdkSupplier.ecpm));
            linkedHashMap.put(SplashAd.KEY_BIDFAIL_ADN, Integer.valueOf(getAdnId(YFUtil.toInt(sdkSupplier.getAdnId(), 10))));
            linkedHashMap.put("bid_t", Integer.valueOf(sdkSupplier.isBidding() ? 3 : 4));
        }
        linkedHashMap.put("ad_t", 7);
        linkedHashMap.put("ad_n", "");
        linkedHashMap.put("ad_time", Long.valueOf(System.currentTimeMillis() / 1000));
        return linkedHashMap;
    }

    public static LinkedHashMap<String, Object> getLossBiddingMap(SdkSupplier sdkSupplier) {
        LinkedHashMap<String, Object> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("ecpm", Long.valueOf(sdkSupplier.ecpm));
        linkedHashMap.put(SplashAd.KEY_BIDFAIL_ADN, Integer.valueOf(getAdnId(YFUtil.toInt(sdkSupplier.getAdnId(), 10))));
        linkedHashMap.put("ad_t", 7);
        linkedHashMap.put("ad_time", Long.valueOf(System.currentTimeMillis() / 1000));
        linkedHashMap.put("bid_t", Integer.valueOf(sdkSupplier.isBidding() ? 3 : 4));
        linkedHashMap.put("reason", "203");
        return linkedHashMap;
    }
}
