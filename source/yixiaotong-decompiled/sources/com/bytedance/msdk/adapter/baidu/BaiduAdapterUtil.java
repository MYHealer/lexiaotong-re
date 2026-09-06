package com.bytedance.msdk.adapter.baidu;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.mobads.sdk.api.AdSettings;
import com.baidu.mobads.sdk.api.BiddingListener;
import com.baidu.mobads.sdk.api.ExpressResponse;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.bytedance.msdk.adapter.baidu.base.config.MApiIMediationViewBinderReversal;
import com.bytedance.msdk.adapter.baidu.base.config.MediationAdSlotValueSet;
import com.bytedance.msdk.adapter.baidu.base.config.MediationInitConfig;
import com.bytedance.msdk.adapter.baidu.base.config.MediationViewBinder;
import com.bytedance.msdk.adapter.baidu.base.utils.MediationApiLog;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
class BaiduAdapterUtil {
    public static final String VERSION_9_35 = "9.35";
    public static final String VERSION_9_37 = "9.37";
    public static final String VERSION_9_42 = "9.42";
    public static final String VERSION_9_43 = "9.43";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static Map<String, Integer> f2979a;

    static {
        HashMap map = new HashMap();
        f2979a = map;
        map.put("0", 0);
        f2979a.put("0103010", 1);
        f2979a.put("0103011", 1);
        f2979a.put("0103012", 1);
        f2979a.put("0103060", 2);
        f2979a.put("0107001", 3);
        f2979a.put("0107002", 3);
        f2979a.put("0107003", 4);
        f2979a.put("1020001", 5);
        f2979a.put("1040001", 6);
        f2979a.put("1040003", 7);
        f2979a.put("3030002", 8);
    }

    BaiduAdapterUtil() {
    }

    private static boolean a(Object obj, String str, Class<?>... clsArr) {
        if (obj != null && !TextUtils.isEmpty(str)) {
            try {
                obj.getClass().getMethod(str, clsArr);
                return true;
            } catch (NoSuchMethodException e) {
                MediationApiLog.i("-------baidu_no_method --------- " + e.getMessage());
            }
        }
        return false;
    }

    public static MediationViewBinder buildViewBinder(Function<SparseArray<Object>, Object> function) {
        if (function == null) {
            return null;
        }
        MApiIMediationViewBinderReversal mApiIMediationViewBinderReversal = new MApiIMediationViewBinderReversal(function);
        return new MediationViewBinder.Builder(mApiIMediationViewBinderReversal.getLayoutId()).callToActionId(mApiIMediationViewBinderReversal.getCallToActionId()).addExtras(mApiIMediationViewBinderReversal.getExtras()).descriptionTextId(mApiIMediationViewBinderReversal.getDecriptionTextId()).groupImage1Id(mApiIMediationViewBinderReversal.getGroupImage1Id()).groupImage1Id(mApiIMediationViewBinderReversal.getGroupImage2Id()).groupImage1Id(mApiIMediationViewBinderReversal.getGroupImage3Id()).iconImageId(mApiIMediationViewBinderReversal.getIconImageId()).mainImageId(mApiIMediationViewBinderReversal.getMainImageId()).mediaViewIdId(mApiIMediationViewBinderReversal.getMediaViewId()).logoLayoutId(mApiIMediationViewBinderReversal.getLogoLayoutId()).shakeViewContainerId(mApiIMediationViewBinderReversal.getShakeViewContainerId()).titleId(mApiIMediationViewBinderReversal.getTitleId()).sourceId(mApiIMediationViewBinderReversal.getSourceId()).build();
    }

    public static boolean currentSdkVerGreaterThanOrEqual(String str) {
        String sdkVersion = getSdkVersion();
        return (TextUtils.isEmpty(sdkVersion) || TextUtils.isEmpty(str) || sdkVersion.compareTo(str) < 0) ? false : true;
    }

    public static int dp2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    /* JADX WARN: Code duplicated, block: B:6:0x0013  */
    public static String getEcpm(Map<String, Object> map) {
        double dDoubleValue;
        if (map != null) {
            Object obj = map.get("ecpm");
            if (obj instanceof Double) {
                dDoubleValue = ((Double) obj).doubleValue();
            } else {
                dDoubleValue = 0.0d;
            }
        } else {
            dDoubleValue = 0.0d;
        }
        return String.valueOf(dDoubleValue);
    }

    public static RequestParameters getRequestParameters(MediationAdSlotValueSet mediationAdSlotValueSet) {
        RequestParameters requestParameters;
        Map<String, String> extras;
        RequestParameters.Builder builder = new RequestParameters.Builder();
        if ((mediationAdSlotValueSet.getBaiduRequestParameters() instanceof RequestParameters) && (requestParameters = (RequestParameters) mediationAdSlotValueSet.getBaiduRequestParameters()) != null && (extras = requestParameters.getExtras()) != null) {
            try {
                for (Map.Entry<String, String> entry : extras.entrySet()) {
                    if (entry != null) {
                        builder.addExtra(entry.getKey(), entry.getValue());
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        int width = mediationAdSlotValueSet.getWidth() > 0 ? mediationAdSlotValueSet.getWidth() : 0;
        int height = mediationAdSlotValueSet.getHeight() > 0 ? mediationAdSlotValueSet.getHeight() : 0;
        if (width > 0 && height > 0) {
            builder.setWidth(width).setHeight(height);
        }
        return builder.build();
    }

    public static String getSdkVersion() {
        try {
            return AdSettings.getSDKVersion();
        } catch (Throwable th) {
            th.printStackTrace();
            return "0.0";
        }
    }

    public static int getinteractionType(int i) {
        if (i != 1) {
            return i != 2 ? -1 : 4;
        }
        return 3;
    }

    public static boolean hasMethodBiddingFail(Object obj) {
        return a(obj, "biddingFail", LinkedHashMap.class, BiddingListener.class);
    }

    public static boolean hasMethodBiddingSuccess(Object obj) {
        return a(obj, "biddingSuccess", LinkedHashMap.class, BiddingListener.class);
    }

    public static boolean isDownloadAd(ExpressResponse expressResponse) {
        return expressResponse != null && expressResponse.getAdActionType() == 2;
    }

    public static boolean isDownloadAd(NativeResponse nativeResponse) {
        return nativeResponse != null && nativeResponse.getAdActionType() == 2;
    }

    public static void printPrivacyLog(MediationInitConfig mediationInitConfig) {
    }

    public static boolean privacyEnableByName(MediationInitConfig mediationInitConfig, String str, boolean z) {
        if (!TextUtils.isEmpty(str) && mediationInitConfig != null) {
            try {
                Map<String, Object> mapUserPrivacyConfig = mediationInitConfig.userPrivacyConfig();
                if (mapUserPrivacyConfig == null) {
                    return z;
                }
                Object obj = mapUserPrivacyConfig.get(str);
                return ((obj instanceof String) && "0".equals(obj)) ? false : true;
            } catch (Throwable unused) {
            }
        }
        return z;
    }
}
