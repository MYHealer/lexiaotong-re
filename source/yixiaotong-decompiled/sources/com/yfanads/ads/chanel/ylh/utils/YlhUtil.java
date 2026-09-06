package com.yfanads.ads.chanel.ylh.utils;

import android.content.Context;
import android.text.TextUtils;
import com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.comm.managers.GDTAdSdk;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.ubixnow.ooooo.o0OO000o;
import com.yfanads.android.YFAdsConfig;
import com.yfanads.android.YFAdsManager;
import com.yfanads.android.model.AdInfo;
import com.yfanads.android.model.InitBean;
import com.yfanads.android.model.SdkSupplier;
import com.yfanads.android.model.YFAdError;
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFConfigUtils;
import com.yfanads.android.utils.YFLog;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class YlhUtil extends InitUtils {
    private static final String[] METHODS = {YFAdsConst.CUW, YFAdsConst.CUAID, YFAdsConst.CUP, YFAdsConst.CUO, YFAdsConst.LP, YFAdsConst.CUA, YFAdsConst.CAR};

    public static void initAD(String str, Context context, InitBean initBean, InitUtils.InitListener initListener) {
        initAD(str, null, context, initBean, initListener);
    }

    public static void initAD(String str, SdkSupplier sdkSupplier, Context context, InitBean initBean, InitUtils.InitListener initListener) {
        if (initBean == null || TextUtils.isEmpty(initBean.appId)) {
            String str2 = str + " init failed AppID empty ylh";
            initListener.fail(YFAdError.ERROR_DATA_NULL, str2);
            YFLog.error(str2);
            return;
        }
        String str3 = initBean.appId;
        try {
            YFAdsConfig yFAdsConfig = YFAdsManager.getInstance().getYFAdsConfig();
            if (isInitSuc(str, str3, initListener) || isInQueue(str, initListener, str3)) {
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            YFLog.high(str + " init asy start ylh:" + str3);
            if (sdkSupplier != null) {
                initReport(sdkSupplier, YFAdsConst.ReportETypeValue.ADS_INIT_START.getValue());
            }
            YFLog.info(" close app receiver " + yFAdsConfig.isCloseAppReceiver());
            updateConfig(yFAdsConfig);
            doInit(str, sdkSupplier, context, str3, jCurrentTimeMillis);
        } catch (Exception e) {
            YFLog.error(str + e.getMessage());
            queueFail(e.getMessage(), str3);
        }
    }

    private static void doInit(final String str, final SdkSupplier sdkSupplier, Context context, final String str2, final long j) {
        GDTAdSdk.initWithoutStart(context, str2);
        GDTAdSdk.start(new GDTAdSdk.OnStartListener() { // from class: com.yfanads.ads.chanel.ylh.utils.YlhUtil.1
            @Override // com.qq.e.comm.managers.GDTAdSdk.OnStartListener
            public void onStartSuccess() {
                YFLog.high(str + " init asy success ylh:" + str2 + "|t_" + (System.currentTimeMillis() - j));
                SdkSupplier sdkSupplier2 = sdkSupplier;
                if (sdkSupplier2 != null) {
                    InitUtils.initReport(sdkSupplier2, YFAdsConst.ReportETypeValue.ADS_INIT_SUCCESS.getValue());
                }
                InitUtils.queueSuccess(str2);
            }

            @Override // com.qq.e.comm.managers.GDTAdSdk.OnStartListener
            public void onStartFailed(Exception exc) {
                YFLog.error(str + " init fail ylh: msg = " + exc.getMessage());
                SdkSupplier sdkSupplier2 = sdkSupplier;
                if (sdkSupplier2 != null) {
                    InitUtils.initReport(sdkSupplier2, YFAdsConst.ReportETypeValue.ADS_INIT_FAIL.getValue());
                }
                InitUtils.queueFail(exc.getMessage(), str2);
            }
        });
    }

    private static void updateConfig(YFAdsConfig yFAdsConfig) {
        boolean[] permissionValues = getPermissionValues(YFAdsConst.ReportAdnIdValue.YLH, yFAdsConfig, true);
        boolean permissionValue = getPermissionValue(permissionValues, YFAdsConst.CUA, true);
        boolean permissionValue2 = getPermissionValue(permissionValues, YFAdsConst.CUP, true);
        boolean permissionValue3 = getPermissionValue(permissionValues, YFAdsConst.CUO, true);
        boolean permissionValue4 = getPermissionValue(permissionValues, YFAdsConst.CUW, true);
        boolean permissionValue5 = getPermissionValue(permissionValues, YFAdsConst.CUAID, true);
        boolean permissionValue6 = getPermissionValue(permissionValues, YFAdsConst.LP, false);
        boolean z = !getPermissionValue(permissionValues, YFAdsConst.CAR, true);
        printLog(YFAdsConst.ReportAdnIdValue.YLH, METHODS, permissionValue4, permissionValue5, permissionValue2, permissionValue3, permissionValue6, permissionValue, z);
        HashMap map = new HashMap();
        map.put(o0OO000o.o00OoOo, Boolean.valueOf(permissionValue4));
        map.put("ssid", Boolean.valueOf(permissionValue4));
        map.put("bssid", Boolean.valueOf(permissionValue4));
        map.put("wipaddr", Boolean.valueOf(permissionValue4));
        map.put("netop", Boolean.valueOf(permissionValue4));
        map.put("cell_id", Boolean.valueOf(permissionValue4));
        map.put("mipaddr", Boolean.valueOf(permissionValue4));
        map.put("android_id", Boolean.valueOf(permissionValue5));
        map.put("device_id", Boolean.valueOf(permissionValue2));
        map.put("oaid", Boolean.valueOf(permissionValue3));
        GlobalSetting.setAgreeReadPrivacyInfo(map);
        GlobalSetting.setEnableCollectAppInstallStatus(permissionValue);
        GlobalSetting.setAgreePrivacyStrategy(true);
        HashMap map2 = new HashMap();
        map2.put("hieib", Boolean.valueOf(z));
        GlobalSetting.setConvOptimizeInfo(map2);
        GlobalSetting.setPersonalizedState(permissionValue6 ? 1 : 0);
        if (YFConfigUtils.getBooleanValue(YFConfigUtils.ConfigType.EXT, "is_shake_action", true)) {
            return;
        }
        YFLog.debug("YlhUtil isShakeAction false");
        HashMap map3 = new HashMap();
        map3.put("shakable", "0");
        map3.put("sensor_ts", "0");
        GlobalSetting.setExtraUserData(map3);
    }

    public static Map<String, Object> getWindBiddingMap(int i, int i2) {
        HashMap map = new HashMap();
        map.put("expectCostPrice", Integer.valueOf(i));
        map.put("highestLossPrice", Integer.valueOf(i2));
        return map;
    }

    public static Map<String, Object> getLossBiddingMap(int i, int i2) {
        HashMap map = new HashMap();
        map.put("winPrice", Integer.valueOf(i));
        map.put("lossReason", 1);
        map.put("adnId", Integer.valueOf(i2));
        return map;
    }

    public static int getAdnId(boolean z, SdkSupplier sdkSupplier, SdkSupplier sdkSupplier2) {
        String adnId = sdkSupplier.getAdnId();
        if (sdkSupplier2 == null || !sdkSupplier2.getAdnId().equals(adnId)) {
            return adnId.equals(String.valueOf(12)) ? 3 : 2;
        }
        return z ? 4 : 1;
    }

    public static AdInfo getAdInfo(NativeUnifiedADData nativeUnifiedADData, String str) {
        if (nativeUnifiedADData == null) {
            return null;
        }
        String desc = TextUtils.isEmpty(nativeUnifiedADData.getTitle()) ? nativeUnifiedADData.getDesc() : nativeUnifiedADData.getTitle();
        NativeUnifiedADAppMiitInfo appMiitInfo = nativeUnifiedADData.getAppMiitInfo();
        return new AdInfo(desc, appMiitInfo != null ? appMiitInfo.getAuthorName() : "", str);
    }
}
