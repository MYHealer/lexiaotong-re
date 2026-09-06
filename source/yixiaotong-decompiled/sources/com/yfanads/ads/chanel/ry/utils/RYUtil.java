package com.yfanads.ads.chanel.ry.utils;

import android.content.Context;
import android.location.Location;
import android.text.TextUtils;
import com.hihonor.adsdk.base.HnAds;
import com.hihonor.adsdk.base.api.feed.PictureTextExpressAd;
import com.hihonor.adsdk.base.init.ActivateStyle;
import com.hihonor.adsdk.base.init.HnAdConfig;
import com.hihonor.adsdk.base.init.HnCustomController;
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
import com.yfanads.android.utils.YFUtil;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class RYUtil extends InitUtils {
    private static final int DIS_MISS_TIME = 10;
    private static final String[] METHODS = {YFAdsConst.CUAID, YFAdsConst.CUP, YFAdsConst.CUW, YFAdsConst.CWE, YFAdsConst.CUL, YFAdsConst.CUA};

    public static void initRY(String str, Context context, InitBean initBean, InitUtils.InitListener initListener) {
        initRY(str, null, context, initBean, initListener);
    }

    public static void initRY(String str, SdkSupplier sdkSupplier, Context context, InitBean initBean, InitUtils.InitListener initListener) {
        if (initBean == null || TextUtils.isEmpty(initBean.appId)) {
            String str2 = str + " init failed AppID empty ry";
            initListener.fail(YFAdError.ERROR_INIT_FAILED, str2);
            YFLog.error(str2);
            return;
        }
        String str3 = initBean.appId;
        try {
            if (isInitSuc(str, str3, initListener) || isInQueue(str, initListener, str3)) {
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            YFLog.high(str + " init syn start ry:" + str3);
            if (sdkSupplier != null) {
                initReport(sdkSupplier, YFAdsConst.ReportETypeValue.ADS_INIT_START.getValue());
            }
            YFAdsConfig yFAdsConfig = YFAdsManager.getInstance().getYFAdsConfig();
            if (YFUtil.getCurrentProcessName(context).equals(context.getPackageName())) {
                HnAds.get().init(context, buildConfig(str, initBean, yFAdsConfig));
                HnAds.get().getAdManager().setAppActivateStrategy(ActivateStyle.BOTTOM_BANNER, 10);
            }
            if (sdkSupplier != null) {
                initReport(sdkSupplier, YFAdsConst.ReportETypeValue.ADS_INIT_SUCCESS.getValue());
            }
            YFLog.high(str + " init syn success ry:" + str3 + "|t_" + (System.currentTimeMillis() - jCurrentTimeMillis));
            queueSuccess(str, str3);
        } catch (Exception e) {
            e.printStackTrace();
            queueFail(str, e.getMessage(), str3);
        }
    }

    private static HnAdConfig buildConfig(String str, InitBean initBean, final YFAdsConfig yFAdsConfig) {
        boolean[] permissionValues = getPermissionValues(YFAdsConst.ReportAdnIdValue.RY, yFAdsConfig, true);
        final boolean permissionValue = getPermissionValue(permissionValues, YFAdsConst.CUA, true);
        final boolean permissionValue2 = getPermissionValue(permissionValues, YFAdsConst.CUL, true);
        final boolean permissionValue3 = getPermissionValue(permissionValues, YFAdsConst.CUP, true);
        final boolean permissionValue4 = getPermissionValue(permissionValues, YFAdsConst.CUW, true);
        final boolean permissionValue5 = getPermissionValue(permissionValues, YFAdsConst.CWE, true);
        final boolean permissionValue6 = getPermissionValue(permissionValues, YFAdsConst.CUAID, true);
        printLog(YFAdsConst.ReportAdnIdValue.RY, METHODS, permissionValue6, permissionValue3, permissionValue4, permissionValue5, permissionValue2, permissionValue);
        return new HnAdConfig.Builder().setAppId(initBean.appId).setAppKey(initBean.addKey).setAllowShowNotify(true).setSupportMultiProcess(false).setWxOpenAppId(initBean.wxAppId).setCustomController(new HnCustomController() { // from class: com.yfanads.ads.chanel.ry.utils.RYUtil.1
            @Override // com.hihonor.adsdk.base.init.HnCustomController
            public boolean isCanGetAllPackages() {
                return permissionValue;
            }

            @Override // com.hihonor.adsdk.base.init.HnCustomController
            public boolean isCanUseAndroidId() {
                return permissionValue6;
            }

            @Override // com.hihonor.adsdk.base.init.HnCustomController
            public boolean isCanUseLocation() {
                return permissionValue2;
            }

            @Override // com.hihonor.adsdk.base.init.HnCustomController
            public boolean isCanUsePhoneState() {
                return permissionValue3;
            }

            @Override // com.hihonor.adsdk.base.init.HnCustomController
            public boolean isCanUseWifiState() {
                return permissionValue4;
            }

            @Override // com.hihonor.adsdk.base.init.HnCustomController
            public boolean isCanUseWriteExternal() {
                return permissionValue5;
            }

            @Override // com.hihonor.adsdk.base.init.HnCustomController
            public String getDevOaid() {
                return InitUtils.getOaID(yFAdsConfig);
            }

            @Override // com.hihonor.adsdk.base.init.HnCustomController
            public Location getLocation() {
                YFLocation location = yFAdsConfig.getLocation();
                if (location != null) {
                    Location location2 = new Location("network");
                    location2.setLatitude(location.getLatitude());
                    location2.setLongitude(location.getLongitude());
                    return location2;
                }
                return super.getLocation();
            }

            @Override // com.hihonor.adsdk.base.init.HnCustomController
            public String getDevImei() {
                return yFAdsConfig.getDevImei();
            }
        }).build();
    }

    public static AdInfo getAdInfo(PictureTextExpressAd pictureTextExpressAd, String str) {
        if (pictureTextExpressAd == null) {
            return null;
        }
        return new AdInfo(pictureTextExpressAd.getTitle(), TextUtils.isEmpty(pictureTextExpressAd.getBrand()) ? pictureTextExpressAd.getDeveloperName() : pictureTextExpressAd.getBrand(), str);
    }
}
