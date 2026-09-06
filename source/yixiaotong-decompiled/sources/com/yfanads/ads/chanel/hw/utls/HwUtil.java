package com.yfanads.ads.chanel.hw.utls;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.ads.HwAds;
import com.huawei.hms.ads.InformationController;
import com.huawei.hms.ads.nativead.NativeAd;
import com.unionpay.tsmservice.data.Constant;
import com.yfanads.android.YFAdsManager;
import com.yfanads.android.libs.net.NetCallBack;
import com.yfanads.android.libs.net.UrlHttpUtil;
import com.yfanads.android.model.AdInfo;
import com.yfanads.android.model.InitBean;
import com.yfanads.android.model.SdkSupplier;
import com.yfanads.android.model.YFAdError;
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFLog;
import com.yfanads.android.utils.YFUtil;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class HwUtil extends InitUtils {
    private static final String[] METHODS = {YFAdsConst.CUAID, YFAdsConst.CUW};

    public static void initHw(String str, Context context, InitBean initBean, InitUtils.InitListener initListener) {
        initHw(str, null, context, initBean, initListener);
    }

    public static void initHw(String str, SdkSupplier sdkSupplier, Context context, InitBean initBean, InitUtils.InitListener initListener) {
        if (initBean == null || TextUtils.isEmpty(initBean.appId)) {
            String str2 = str + " init failed AppID empty hw";
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
            YFLog.high(str + " init syn start hw:" + str3);
            if (sdkSupplier != null) {
                initReport(sdkSupplier, YFAdsConst.ReportETypeValue.ADS_INIT_START.getValue());
            }
            HwAds.init(context);
            boolean[] permissionValues = getPermissionValues(YFAdsConst.ReportAdnIdValue.HW, YFAdsManager.getInstance().getYFAdsConfig(), true);
            boolean permissionValue = getPermissionValue(permissionValues, YFAdsConst.CUAID, true);
            boolean permissionValue2 = getPermissionValue(permissionValues, YFAdsConst.CUW, true);
            printLog(YFAdsConst.ReportAdnIdValue.HW, METHODS, permissionValue, permissionValue2);
            HwAds.setInfoController(new InformationController.Builder().setUseAndroidId(Boolean.valueOf(permissionValue)).setUseWifi(Boolean.valueOf(permissionValue2)).build());
            HwAds.setAppInstalledNotify(true);
            HwAds.setAppActivateStyle(1);
            YFLog.high(str + " init syn success hw:" + str3 + "|t_" + (System.currentTimeMillis() - jCurrentTimeMillis));
            if (sdkSupplier != null) {
                initReport(sdkSupplier, YFAdsConst.ReportETypeValue.ADS_INIT_SUCCESS.getValue());
            }
            queueSuccess(str, str3);
        } catch (Exception e) {
            e.printStackTrace();
            queueFail(str, e.getMessage(), str3);
        }
    }

    public static boolean isExistDownload(NativeAd nativeAd) {
        return nativeAd.getCreativeType() == 101 || nativeAd.getCreativeType() == 102 || nativeAd.getCreativeType() == 103 || nativeAd.getCreativeType() == 106 || nativeAd.getCreativeType() == 107 || nativeAd.getCreativeType() == 108;
    }

    public static Map<String, Object> getWinBiddingInfo(SdkSupplier sdkSupplier) {
        HashMap map = new HashMap();
        if (sdkSupplier != null) {
            map.put("SECOND_PRICE", penny2Price(Long.valueOf(sdkSupplier.ecpm)));
        }
        map.put("AUCTION_CURRENCY", Constant.KEY_CURRENCYTYPE_CNY);
        return map;
    }

    public static Map<String, Object> getLossBiddingInfo(SdkSupplier sdkSupplier) {
        HashMap map = new HashMap();
        if (sdkSupplier != null) {
            map.put("AUCTION_PRICE", penny2Price(Long.valueOf(sdkSupplier.ecpm)));
            map.put("AUCTION_LOSS", 102);
            map.put("AUCTION_CP_ID", getAdnName(sdkSupplier.getAdnId()));
        }
        return map;
    }

    public static void win(String str, long j) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        UrlHttpUtil.get(str.replace("SECOND_PRICE", penny2Price(Long.valueOf(j))).replace("AUCTION_CURRENCY", Constant.KEY_CURRENCYTYPE_CNY), new NetCallBack.NetCallBackString(false) { // from class: com.yfanads.ads.chanel.hw.utls.HwUtil.1
            @Override // com.yfanads.android.libs.net.NetCallBack
            /* JADX INFO: renamed from: onResponse, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public void m1262lambda$onSuccess$3$comyfanadsandroidlibsnetNetCallBack(String str2) {
            }

            @Override // com.yfanads.android.libs.net.NetCallBack
            /* JADX INFO: renamed from: onFailure */
            public void m1259lambda$onError$0$comyfanadsandroidlibsnetNetCallBack(int i, String str2) {
                YFLog.error("code = " + i + " , msg = " + str2);
            }
        });
    }

    public static void loss(String str, long j, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        UrlHttpUtil.get(str.replace("AUCTION_PRICE", penny2Price(Long.valueOf(j))).replace("AUCTION_LOSS", "102").replace("AUCTION_CURRENCY", Constant.KEY_CURRENCYTYPE_CNY).replace("AUCTION_CP_ID", getAdnName(str2)), new NetCallBack.NetCallBackString(false) { // from class: com.yfanads.ads.chanel.hw.utls.HwUtil.2
            @Override // com.yfanads.android.libs.net.NetCallBack
            /* JADX INFO: renamed from: onResponse, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public void m1262lambda$onSuccess$3$comyfanadsandroidlibsnetNetCallBack(String str3) {
            }

            @Override // com.yfanads.android.libs.net.NetCallBack
            /* JADX INFO: renamed from: onFailure */
            public void m1259lambda$onError$0$comyfanadsandroidlibsnetNetCallBack(int i, String str3) {
                YFLog.error("code = " + i + " , msg = " + str3);
            }
        });
    }

    public static String getAdnName(String str) {
        int i = YFUtil.toInt(str, 0);
        if (i == 1) {
            return "2";
        }
        if (i == 2) {
            return "1";
        }
        if (i == 3) {
            return "3";
        }
        if (i == 4) {
            return "4";
        }
        if (i == 14) {
            return "6";
        }
        switch (i) {
            case 7:
                return "9";
            case 8:
                return "8";
            case 9:
                return "10";
            case 10:
                return "7";
            case 11:
                return "2";
            default:
                return "100";
        }
    }

    public static String price2penny(Float f) {
        try {
            return BigDecimal.valueOf(new BigDecimal(f.floatValue()).setScale(2, RoundingMode.HALF_UP).doubleValue()).multiply(new BigDecimal(100)).stripTrailingZeros().toString();
        } catch (Exception unused) {
            return ((long) (Double.parseDouble(new DecimalFormat("#.00").format(f.floatValue())) * 100.0d)) + "";
        }
    }

    public static String penny2Price(Long l) {
        try {
            return new BigDecimal(l.doubleValue()).divide(new BigDecimal(100), 2, RoundingMode.HALF_UP).stripTrailingZeros().toString();
        } catch (Exception unused) {
            return new DecimalFormat("#.00").format(l.doubleValue() / 100.0d);
        }
    }

    public static AdInfo getAdInfo(NativeAd nativeAd, String str) {
        if (nativeAd == null) {
            return null;
        }
        return new AdInfo(TextUtils.isEmpty(nativeAd.getTitle()) ? nativeAd.getDescription() : nativeAd.getTitle(), nativeAd.getDspName(), str);
    }
}
