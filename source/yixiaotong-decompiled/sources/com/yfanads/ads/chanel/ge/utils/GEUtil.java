package com.yfanads.ads.chanel.ge.utils;

import android.content.Context;
import android.text.TextUtils;
import com.fancy.adsdk.lib.PtgAdSdk;
import com.fancy.adsdk.lib.PtgSDKConfig;
import com.fancy.adsdk.lib.interf.PtgCustomController;
import com.fancy.adsdk.lib.model.AdLocation;
import com.yfanads.android.YFAdsManager;
import com.yfanads.android.libs.utils.DeviceUtils;
import com.yfanads.android.model.InitBean;
import com.yfanads.android.model.SdkSupplier;
import com.yfanads.android.model.YFAdError;
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFConfigUtils;
import com.yfanads.android.utils.YFLog;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class GEUtil extends InitUtils {
    private static final String[] METHODS = {YFAdsConst.CUP, YFAdsConst.CUL, YFAdsConst.CUO, YFAdsConst.CUW, YFAdsConst.LP};

    public static void initGE(String str, Context context, InitBean initBean, InitUtils.InitListener initListener) {
        initGE(str, null, context, initBean, initListener);
    }

    public static void initGE(final String str, final SdkSupplier sdkSupplier, Context context, final InitBean initBean, InitUtils.InitListener initListener) {
        if (initBean == null || TextUtils.isEmpty(initBean.appId)) {
            String str2 = str + " init failed InitBean empty ay ";
            initListener.fail(YFAdError.ERROR_INIT_FAILED, str2);
            YFLog.error(str2);
            return;
        }
        final String str3 = initBean.appId;
        try {
            if (isInitSuc(str, str3, initListener) || isInQueue(str, initListener, str3)) {
                return;
            }
            final long jCurrentTimeMillis = System.currentTimeMillis();
            YFLog.high(str + " init syn start ge appId:" + str3 + "|key_" + initBean.appSecret);
            if (sdkSupplier != null) {
                initReport(sdkSupplier, YFAdsConst.ReportETypeValue.ADS_INIT_START.getValue());
            }
            boolean booleanValue = YFConfigUtils.getBooleanValue(YFConfigUtils.ConfigType.EXT, "is_shake_action", true);
            PtgAdSdk.init(context, new PtgSDKConfig.Builder().setAppName(YFAdsManager.getInstance().getYFAdsConfig().getAppName()).setMediaId(str3).setMediaSecret(initBean.appSecret).setDebug(false).setPtgCustomController(buildCustomController(context)).build(), new PtgAdSdk.Callback() { // from class: com.yfanads.ads.chanel.ge.utils.GEUtil.1
                @Override // com.fancy.adsdk.lib.PtgAdSdk.Callback
                public void success() {
                    YFLog.high(str + " init syn success ge:" + initBean.appId + "|t_" + (System.currentTimeMillis() - jCurrentTimeMillis));
                    SdkSupplier sdkSupplier2 = sdkSupplier;
                    if (sdkSupplier2 != null) {
                        InitUtils.initReport(sdkSupplier2, YFAdsConst.ReportETypeValue.ADS_INIT_SUCCESS.getValue());
                    }
                    InitUtils.queueSuccess(str, str3);
                }

                @Override // com.fancy.adsdk.lib.PtgAdSdk.Callback
                public void fail(int i, String str4) {
                    InitUtils.queueFail(str, str4, i + "");
                }
            });
            PtgAdSdk.setSensorStatus(booleanValue);
        } catch (Exception e) {
            e.printStackTrace();
            queueFail(str, e.getMessage(), str3);
        }
    }

    private static PtgCustomController buildCustomController(final Context context) {
        boolean[] permissionValues = getPermissionValues(YFAdsConst.ReportAdnIdValue.GE, YFAdsManager.getInstance().getYFAdsConfig(), true);
        final boolean permissionValue = getPermissionValue(permissionValues, YFAdsConst.CUL, true);
        getPermissionValue(permissionValues, YFAdsConst.CUP, true);
        getPermissionValue(permissionValues, YFAdsConst.CUW, true);
        final boolean permissionValue2 = getPermissionValue(permissionValues, YFAdsConst.CUA, false);
        return new PtgCustomController() { // from class: com.yfanads.ads.chanel.ge.utils.GEUtil.2
            AdLocation tempLocation;
            List<String> tempPackageList;

            @Override // com.fancy.adsdk.lib.interf.PtgCustomController
            public List<String> getMediaInstalledPackages() {
                return this.tempPackageList;
            }

            @Override // com.fancy.adsdk.lib.interf.PtgCustomController
            public boolean isAllowSDKInstallList() {
                return false;
            }

            @Override // com.fancy.adsdk.lib.interf.PtgCustomController
            public boolean isAllowSDKObtainAndroidId() {
                return permissionValue2;
            }

            @Override // com.fancy.adsdk.lib.interf.PtgCustomController
            public boolean isAllowSDKObtainLocation() {
                return permissionValue;
            }

            @Override // com.fancy.adsdk.lib.interf.PtgCustomController
            public boolean isAllowSDKObtainOaId() {
                return false;
            }

            @Override // com.fancy.adsdk.lib.interf.PtgCustomController
            public String getMediaDeviceImei() {
                return YFAdsManager.getInstance().getYFAdsConfig().getDevImei();
            }

            @Override // com.fancy.adsdk.lib.interf.PtgCustomController
            public String getMediaAndroidId() {
                return YFAdsManager.getInstance().getYFAdsConfig().getDevAndroidId();
            }

            @Override // com.fancy.adsdk.lib.interf.PtgCustomController
            public String getMediaDeviceOaId() {
                return DeviceUtils.getDeviceId(context);
            }

            @Override // com.fancy.adsdk.lib.interf.PtgCustomController
            public String getMediaMacAddress() {
                return YFAdsManager.getInstance().getYFAdsConfig().getDevMacAddress();
            }

            @Override // com.fancy.adsdk.lib.interf.PtgCustomController
            public AdLocation getMediaLocation() {
                AdLocation adLocation = new AdLocation();
                adLocation.setLatitude(YFAdsManager.getInstance().getYFAdsConfig().getLocation().getLatitude());
                adLocation.setLongitude(YFAdsManager.getInstance().getYFAdsConfig().getLocation().getLongitude());
                this.tempLocation = adLocation;
                return adLocation;
            }

            @Override // com.fancy.adsdk.lib.interf.PtgCustomController
            public String getAliBoot() {
                return super.getAliBoot();
            }

            @Override // com.fancy.adsdk.lib.interf.PtgCustomController
            public String getAliUpdate() {
                return super.getAliUpdate();
            }
        };
    }

    public static String getSdkVersion() {
        return PtgAdSdk.getConfig().getSdkVersionName();
    }
}
