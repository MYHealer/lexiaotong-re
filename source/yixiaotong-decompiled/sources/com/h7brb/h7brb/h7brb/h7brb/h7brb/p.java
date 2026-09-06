package com.h7brb.h7brb.h7brb.h7brb.h7brb;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.msdk.adapter.ks.base.MediationAdLoaderBaseFunction;
import com.bytedance.msdk.adapter.ks.base.config.MApiIMediationViewBinderReversal;
import com.bytedance.msdk.adapter.ks.base.config.MediationAdSlotValueSet;
import com.bytedance.msdk.adapter.ks.base.config.MediationInitConfig;
import com.bytedance.msdk.adapter.ks.base.config.MediationViewBinder;
import com.bytedance.msdk.adapter.ks.base.utils.MediationApiLog;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.stub.StubApp;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class p {
    public static float a(Context context, float f) {
        if (context == null) {
            return 0.0f;
        }
        return (f * context.getResources().getDisplayMetrics().density) + 0.5f;
    }

    public static int a(int i) {
        if (i != 1) {
            return i != 2 ? -1 : 3;
        }
        return 4;
    }

    public static int a(Context context) {
        return StubApp.getOrigApplicationContext(context.getApplicationContext()).getResources().getDisplayMetrics().widthPixels;
    }

    public static int a(String str, String str2) {
        if (str == null && str2 == null) {
            return 0;
        }
        if (str == null) {
            return -1;
        }
        if (str2 == null) {
            return 1;
        }
        String[] strArrSplit = str.split("\\.");
        String[] strArrSplit2 = str2.split("\\.");
        int iMax = Math.max(strArrSplit.length, strArrSplit2.length);
        int i = 0;
        while (i < iMax) {
            int iB = i < strArrSplit.length ? b(strArrSplit[i]) : 0;
            int iB2 = i < strArrSplit2.length ? b(strArrSplit2[i]) : 0;
            if (iB != iB2) {
                return Integer.compare(iB, iB2);
            }
            i++;
        }
        return 0;
    }

    public static long a(Map<String, Object> map) {
        if (map != null) {
            Object obj = map.get("bidEcpm");
            if (obj instanceof Double) {
                return ((Double) obj).longValue();
            }
        }
        return 0L;
    }

    public static MediationViewBinder a(Function<SparseArray<Object>, Object> function) {
        if (function == null) {
            return null;
        }
        MApiIMediationViewBinderReversal mApiIMediationViewBinderReversal = new MApiIMediationViewBinderReversal(function);
        return new MediationViewBinder.Builder(mApiIMediationViewBinderReversal.getLayoutId()).callToActionId(mApiIMediationViewBinderReversal.getCallToActionId()).addExtras(mApiIMediationViewBinderReversal.getExtras()).descriptionTextId(mApiIMediationViewBinderReversal.getDecriptionTextId()).groupImage1Id(mApiIMediationViewBinderReversal.getGroupImage1Id()).groupImage1Id(mApiIMediationViewBinderReversal.getGroupImage2Id()).groupImage1Id(mApiIMediationViewBinderReversal.getGroupImage3Id()).iconImageId(mApiIMediationViewBinderReversal.getIconImageId()).mainImageId(mApiIMediationViewBinderReversal.getMainImageId()).mediaViewIdId(mApiIMediationViewBinderReversal.getMediaViewId()).logoLayoutId(mApiIMediationViewBinderReversal.getLogoLayoutId()).shakeViewContainerId(mApiIMediationViewBinderReversal.getShakeViewContainerId()).titleId(mApiIMediationViewBinderReversal.getTitleId()).sourceId(mApiIMediationViewBinderReversal.getSourceId()).build();
    }

    public static String a() {
        try {
            return KsAdSDK.getSDKVersion();
        } catch (Throwable unused) {
            return "0.0";
        }
    }

    public static boolean a(MediationAdLoaderBaseFunction mediationAdLoaderBaseFunction, MediationAdSlotValueSet mediationAdSlotValueSet) {
        boolean z;
        if (mediationAdLoaderBaseFunction != null && mediationAdSlotValueSet != null) {
            boolean zA = a(mediationAdSlotValueSet);
            boolean zIsClientBidding = mediationAdLoaderBaseFunction.isClientBidding();
            boolean zB = b(mediationAdSlotValueSet);
            try {
                z = mediationAdLoaderBaseFunction.getBiddingType() == 0;
            } catch (Throwable unused) {
            }
            if ((zA && zIsClientBidding) || (zB && z)) {
                return true;
            }
        }
        return false;
    }

    private static boolean a(MediationAdSlotValueSet mediationAdSlotValueSet) {
        if (mediationAdSlotValueSet.getExtraObject() == null) {
            return false;
        }
        Object obj = mediationAdSlotValueSet.getExtraObject().get("dynamic_adapter_type");
        return (obj instanceof Integer) && ((Integer) obj).intValue() == 1;
    }

    public static boolean a(MediationInitConfig mediationInitConfig) {
        if (mediationInitConfig == null) {
            return false;
        }
        try {
            Map initAdnMap = mediationInitConfig.getInitAdnMap();
            if (initAdnMap == null) {
                return false;
            }
            Object obj = initAdnMap.get("q_x_c");
            if ((obj instanceof Integer) && ((Integer) obj).intValue() == 1) {
                return true;
            }
            Object obj2 = initAdnMap.get("wf_q_x_c");
            if ((obj2 instanceof Integer) && ((Integer) obj2).intValue() == 1) {
                return true;
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static boolean a(Object obj) {
        return a(obj, "setBidEcpm", Long.TYPE, Long.TYPE);
    }

    private static boolean a(Object obj, String str, Class<?>... clsArr) {
        if (obj != null && !TextUtils.isEmpty(str)) {
            try {
                obj.getClass().getMethod(str, clsArr);
                return true;
            } catch (NoSuchMethodException e) {
                MediationApiLog.i("-------ks_no_method --------- " + e.getMessage());
            }
        }
        return false;
    }

    public static boolean a(String str) {
        String strA = a();
        return (TextUtils.isEmpty(strA) || TextUtils.isEmpty(str) || a(strA, str) < 0) ? false : true;
    }

    private static int b(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    public static long b(Map<String, Object> map) {
        if (map != null) {
            Object obj = map.get("lossBidEcpm");
            if (obj instanceof Double) {
                return ((Double) obj).longValue();
            }
        }
        return 0L;
    }

    private static boolean b(MediationAdSlotValueSet mediationAdSlotValueSet) {
        if (mediationAdSlotValueSet.getExtraObject() == null) {
            return false;
        }
        Object obj = mediationAdSlotValueSet.getExtraObject().get("wf_dynamic_adapter_type");
        return (obj instanceof Integer) && ((Integer) obj).intValue() == 1;
    }

    public static boolean b(Object obj) {
        return a(obj, "reportAdExposureFailed", Integer.TYPE, AdExposureFailedReason.class);
    }

    public static int c(Map<String, Object> map) {
        if (map != null) {
            Object obj = map.get("failureCode");
            if (obj instanceof Integer) {
                return ((Integer) obj).intValue();
            }
        }
        return 0;
    }

    public static int d(Map<String, Object> map) {
        if (map != null) {
            Object obj = map.get("bidEcpm");
            if (obj instanceof Double) {
                return ((Double) obj).intValue();
            }
        }
        return 0;
    }

    public static int e(Map<String, Object> map) {
        if (map != null) {
            Object obj = map.get("adType");
            if (obj instanceof Integer) {
                return ((Integer) obj).intValue();
            }
        }
        return 2;
    }

    public static String f(Map<String, Object> map) {
        if (map != null) {
            Object obj = map.get(MediationConstant.KEY_ADN_NAME);
            if (obj instanceof String) {
                return (String) obj;
            }
        }
        return "other";
    }
}
