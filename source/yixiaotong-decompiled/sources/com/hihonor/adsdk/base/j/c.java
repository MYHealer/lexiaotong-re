package com.hihonor.adsdk.base.j;

import android.text.TextUtils;
import com.hihonor.adsdk.base.api.BaseAd;
import com.hihonor.adsdk.base.bean.BaseAdInfo;
import com.hihonor.adsdk.base.bean.BaseAdInfoResp;
import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class c {
    public static String hnadsa(BaseAdInfoResp baseAdInfoResp) {
        BaseAdInfo baseAdInfo;
        if (baseAdInfoResp == null) {
            return "";
        }
        String adUnitId = baseAdInfoResp.getAdUnitId();
        if (!TextUtils.isEmpty(adUnitId)) {
            return adUnitId;
        }
        List<BaseAdInfo> list = baseAdInfoResp.getList();
        return (com.hihonor.adsdk.common.f.f.hnadsa((Collection<?>) list) || (baseAdInfo = list.get(0)) == null) ? "" : baseAdInfo.getAdUnitId();
    }

    public static String hnadsb(BaseAdInfoResp baseAdInfoResp) {
        BaseAdInfo baseAdInfo;
        if (baseAdInfoResp == null) {
            return "";
        }
        String requestId = baseAdInfoResp.getRequestId();
        if (!TextUtils.isEmpty(requestId)) {
            return requestId;
        }
        List<BaseAdInfo> list = baseAdInfoResp.getList();
        return (com.hihonor.adsdk.common.f.f.hnadsa((Collection<?>) list) || (baseAdInfo = list.get(0)) == null) ? "" : baseAdInfo.getAdRequestId();
    }

    public static boolean hnadsc(BaseAd baseAd) {
        return baseAd != null && baseAd.getPromotionPurpose() == 4;
    }

    public static String hnadsa(BaseAd baseAd) {
        if (baseAd == null) {
            return null;
        }
        return baseAd.getAppPackage();
    }

    public static boolean hnadsb(BaseAd baseAd) {
        if (baseAd == null) {
            return false;
        }
        return baseAd.getPromotionPurpose() == 0 || baseAd.getPromotionPurpose() == 4;
    }
}
