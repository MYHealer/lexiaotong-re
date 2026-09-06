package com.yfanads.ads.chanel.xm.utils;

import android.content.Context;
import android.text.TextUtils;
import com.miui.zeus.mimo.sdk.MimoCustomController;
import com.miui.zeus.mimo.sdk.MimoLocation;
import com.miui.zeus.mimo.sdk.MimoSdk;
import com.miui.zeus.mimo.sdk.base.BaseAd;
import com.yfanads.android.YFAdsConfig;
import com.yfanads.android.YFAdsManager;
import com.yfanads.android.model.InitBean;
import com.yfanads.android.model.SdkSupplier;
import com.yfanads.android.model.YFAdError;
import com.yfanads.android.model.YFLocation;
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFLog;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class XmUtil extends InitUtils {
    private static final String[] METHODS = {YFAdsConst.CUL, YFAdsConst.CWE, YFAdsConst.CUA, YFAdsConst.LP};
    protected static boolean lastLimitPersonal;

    public static void initXm(String str, Context context, InitBean initBean, InitUtils.InitListener initListener) {
        initXm(str, null, context, initBean, initListener);
    }

    public static void initXm(String str, SdkSupplier sdkSupplier, Context context, InitBean initBean, InitUtils.InitListener initListener) {
        if (initBean == null || TextUtils.isEmpty(initBean.appId)) {
            String str2 = str + " init failed AppID empty xm";
            if (initListener != null) {
                initListener.fail(YFAdError.ERROR_DATA_NULL, str2);
            }
            YFLog.error(str2);
            return;
        }
        String str3 = initBean.appId;
        YFAdsConfig yFAdsConfig = YFAdsManager.getInstance().getYFAdsConfig();
        try {
            if (isInitSuc(str3, initListener)) {
                boolean limitPersonal = getLimitPersonal(YFAdsConst.ReportAdnIdValue.XM, yFAdsConfig);
                if (lastLimitPersonal != limitPersonal) {
                    lastLimitPersonal = limitPersonal;
                    YFLog.high(str + " init " + limitPersonal);
                    MimoSdk.setPersonalizedAdEnabled(!lastLimitPersonal);
                    return;
                }
                return;
            }
            if (isInQueue(str, initListener, str3)) {
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            YFLog.high(str + " init asy start xm：" + str3);
            if (sdkSupplier != null) {
                initReport(sdkSupplier, YFAdsConst.ReportETypeValue.ADS_INIT_START.getValue());
            }
            doInit(str, sdkSupplier, context, str3, jCurrentTimeMillis);
        } catch (Exception e) {
            YFLog.error(str + e.getMessage());
            queueFail(e.getMessage(), str3);
        }
    }

    private static void doInit(final String str, final SdkSupplier sdkSupplier, Context context, final String str2, final long j) {
        final YFAdsConfig yFAdsConfig = YFAdsManager.getInstance().getYFAdsConfig();
        boolean[] permissionValues = getPermissionValues(YFAdsConst.ReportAdnIdValue.XM, yFAdsConfig, true);
        final boolean permissionValue = getPermissionValue(permissionValues, YFAdsConst.CUA, true);
        final boolean permissionValue2 = getPermissionValue(permissionValues, YFAdsConst.CUL, true);
        final boolean permissionValue3 = getPermissionValue(permissionValues, YFAdsConst.CWE, true);
        lastLimitPersonal = getPermissionValue(permissionValues, YFAdsConst.LP, false);
        printLog(YFAdsConst.ReportAdnIdValue.XM, METHODS, permissionValue2, permissionValue3, permissionValue, lastLimitPersonal);
        MimoSdk.init(context, new MimoCustomController() { // from class: com.yfanads.ads.chanel.xm.utils.XmUtil.1
            @Override // com.miui.zeus.mimo.sdk.MimoCustomController
            public boolean alist() {
                return permissionValue;
            }

            @Override // com.miui.zeus.mimo.sdk.MimoCustomController
            public boolean isCanUseLocation() {
                return permissionValue2;
            }

            @Override // com.miui.zeus.mimo.sdk.MimoCustomController
            public boolean isCanUseWifiState() {
                return permissionValue3;
            }

            @Override // com.miui.zeus.mimo.sdk.MimoCustomController
            public MimoLocation getMimoLocation() {
                YFLocation location = yFAdsConfig.getLocation();
                if (location != null) {
                    return new MimoLocation(location.getLatitude(), location.getLongitude());
                }
                return super.getMimoLocation();
            }
        }, new MimoSdk.InitCallback() { // from class: com.yfanads.ads.chanel.xm.utils.XmUtil.2
            @Override // com.miui.zeus.mimo.sdk.MimoSdk.InitCallback
            public void success() {
                YFLog.high(str + " init asy success xm:" + str2 + "|t_" + (System.currentTimeMillis() - j));
                SdkSupplier sdkSupplier2 = sdkSupplier;
                if (sdkSupplier2 != null) {
                    InitUtils.initReport(sdkSupplier2, YFAdsConst.ReportETypeValue.ADS_INIT_SUCCESS.getValue());
                }
                InitUtils.queueSuccess(str, str2);
            }

            @Override // com.miui.zeus.mimo.sdk.MimoSdk.InitCallback
            public void fail(int i, String str3) {
                YFLog.error(str + "init fail xm: code = " + i + " msg = " + str3);
                SdkSupplier sdkSupplier2 = sdkSupplier;
                if (sdkSupplier2 != null) {
                    InitUtils.initReport(sdkSupplier2, YFAdsConst.ReportETypeValue.ADS_INIT_FAIL.getValue());
                }
                InitUtils.queueFail(str, str3, str2);
            }
        });
        MimoSdk.setPersonalizedAdEnabled(!lastLimitPersonal);
        MimoSdk.setDebugOn(yFAdsConfig.isDebug());
    }

    public static Map<String, Long> getWinParams(SdkSupplier sdkSupplier, SdkSupplier sdkSupplier2) {
        HashMap map = new HashMap();
        map.put(BaseAd.IBidding.EXPECT_COST_PRICE, Long.valueOf(sdkSupplier.ecpm));
        if (sdkSupplier2 != null) {
            map.put(BaseAd.IBidding.HIGHEST_LOSS_PRICE, Long.valueOf(sdkSupplier2.ecpm));
        }
        return map;
    }

    public static Map<String, Object> getLossParams(SdkSupplier sdkSupplier) {
        HashMap map = new HashMap();
        if (sdkSupplier != null) {
            map.put(BaseAd.IBidding.WIN_PRICE, Long.valueOf(sdkSupplier.ecpm));
            map.put(BaseAd.IBidding.LOSS_REASON, BaseAd.LossReason.TYPE_LOWER_OTHER_BIDDER_PRICE);
            map.put(BaseAd.IBidding.ADN_ID, Integer.valueOf(sdkSupplier.getChannel() == 12 ? 2 : 1));
        }
        return map;
    }
}
