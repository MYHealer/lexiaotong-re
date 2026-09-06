package com.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ;

import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.msdk.adapter.gdt.base.MediationAdLoaderBaseFunction;
import com.bytedance.msdk.adapter.gdt.base.config.MApiIMediationViewBinderReversal;
import com.bytedance.msdk.adapter.gdt.base.config.MediationAdSlotValueSet;
import com.bytedance.msdk.adapter.gdt.base.config.MediationInitConfig;
import com.bytedance.msdk.adapter.gdt.base.config.MediationViewBinder;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.qq.e.comm.managers.setting.GlobalSetting;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class a {
    public static int a(int i) {
        if (i <= 0) {
            return 10001;
        }
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (i == 2) {
                return 101;
            }
            if (i != 3) {
                return 10001;
            }
        }
        return i2;
    }

    public static int a(Object obj) {
        int lossReason;
        if (obj instanceof Integer) {
            lossReason = ((Integer) obj).intValue();
        } else {
            if (!(obj instanceof MediationConstant.BiddingLossReason)) {
                return -1;
            }
            lossReason = ((MediationConstant.BiddingLossReason) obj).getLossReason();
        }
        return a(lossReason);
    }

    public static MediationViewBinder a(Function<SparseArray<Object>, Object> function) {
        if (function == null) {
            return null;
        }
        MApiIMediationViewBinderReversal mApiIMediationViewBinderReversal = new MApiIMediationViewBinderReversal(function);
        return new MediationViewBinder.Builder(mApiIMediationViewBinderReversal.getLayoutId()).callToActionId(mApiIMediationViewBinderReversal.getCallToActionId()).addExtras(mApiIMediationViewBinderReversal.getExtras()).descriptionTextId(mApiIMediationViewBinderReversal.getDecriptionTextId()).groupImage1Id(mApiIMediationViewBinderReversal.getGroupImage1Id()).groupImage1Id(mApiIMediationViewBinderReversal.getGroupImage2Id()).groupImage1Id(mApiIMediationViewBinderReversal.getGroupImage3Id()).iconImageId(mApiIMediationViewBinderReversal.getIconImageId()).mainImageId(mApiIMediationViewBinderReversal.getMainImageId()).mediaViewIdId(mApiIMediationViewBinderReversal.getMediaViewId()).logoLayoutId(mApiIMediationViewBinderReversal.getLogoLayoutId()).shakeViewContainerId(mApiIMediationViewBinderReversal.getShakeViewContainerId()).titleId(mApiIMediationViewBinderReversal.getTitleId()).sourceId(mApiIMediationViewBinderReversal.getSourceId()).build();
    }

    public static void a(MediationInitConfig mediationInitConfig) {
    }

    public static void a(Map map) {
        a(map, true);
    }

    public static void a(Map map, boolean z) {
        if (map != null) {
            HashMap map2 = new HashMap();
            Object obj = map.get(com.umeng.analytics.pro.d.D);
            if ((obj instanceof Double) && ((Double) obj).doubleValue() != -1.0d) {
                map2.put(com.umeng.analytics.pro.d.D, obj.toString());
            }
            Object obj2 = map.get(com.umeng.analytics.pro.d.C);
            if ((obj2 instanceof Double) && ((Double) obj2).doubleValue() != -1.0d) {
                map2.put(com.umeng.analytics.pro.d.C, obj2.toString());
            }
            Object obj3 = map.get("loc_time");
            if ((obj3 instanceof Long) && ((Long) obj3).longValue() != -1) {
                map2.put("loc_time", obj3.toString());
            }
            if (!z) {
                map2.put("shakable", "0");
            }
            GlobalSetting.setExtraUserData(map2);
        }
    }

    public static boolean a(MediationAdLoaderBaseFunction mediationAdLoaderBaseFunction, MediationAdSlotValueSet mediationAdSlotValueSet) {
        boolean z;
        if (mediationAdLoaderBaseFunction != null && mediationAdSlotValueSet != null) {
            boolean zB = b(mediationAdSlotValueSet);
            boolean zIsClientBidding = mediationAdLoaderBaseFunction.isClientBidding();
            boolean zC = c(mediationAdSlotValueSet);
            try {
                z = mediationAdLoaderBaseFunction.getBiddingType() == 0;
            } catch (Throwable unused) {
            }
            if ((zB && zIsClientBidding) || (zC && z)) {
                return true;
            }
        }
        return false;
    }

    public static boolean a(MediationAdSlotValueSet mediationAdSlotValueSet) {
        Map<String, Object> params = mediationAdSlotValueSet.getParams();
        if (params == null) {
            return false;
        }
        Object obj = params.get(MediationConstant.BANNER_AUTO_HEIGHT);
        try {
            if (obj instanceof Boolean) {
                return ((Boolean) obj).booleanValue();
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static boolean a(MediationInitConfig mediationInitConfig, String str, boolean z) {
        if (!TextUtils.isEmpty(str) && mediationInitConfig != null) {
            try {
                Map<String, Object> mapUserPrivacyConfig = mediationInitConfig.userPrivacyConfig();
                if (mapUserPrivacyConfig == null) {
                    return z;
                }
                Object obj = mapUserPrivacyConfig.get(str);
                if (obj instanceof Boolean) {
                    return ((Boolean) obj).booleanValue();
                }
                if (obj instanceof Integer) {
                    return ((Integer) obj).intValue() != 0;
                }
                return ((obj instanceof String) && "0".equals(obj)) ? false : true;
            } catch (Throwable unused) {
            }
        }
        return z;
    }

    private static boolean b(MediationAdSlotValueSet mediationAdSlotValueSet) {
        if (mediationAdSlotValueSet.getExtraObject() == null) {
            return false;
        }
        Object obj = mediationAdSlotValueSet.getExtraObject().get("dynamic_adapter_type");
        return (obj instanceof Integer) && ((Integer) obj).intValue() == 1;
    }

    public static boolean b(MediationInitConfig mediationInitConfig) {
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

    private static boolean c(MediationAdSlotValueSet mediationAdSlotValueSet) {
        if (mediationAdSlotValueSet.getExtraObject() == null) {
            return false;
        }
        Object obj = mediationAdSlotValueSet.getExtraObject().get("wf_dynamic_adapter_type");
        return (obj instanceof Integer) && ((Integer) obj).intValue() == 1;
    }
}
