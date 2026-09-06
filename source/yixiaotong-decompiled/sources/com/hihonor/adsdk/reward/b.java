package com.hihonor.adsdk.reward;

import com.hihonor.adsdk.base.ErrorCode;
import com.hihonor.adsdk.base.api.BaseAd;
import com.hihonor.adsdk.base.g.j.d.x;
import com.hihonor.adsdk.reward.e.f;
import com.hihonor.adsdk.reward.e.g;
import com.hihonor.adsdk.reward.e.h;
import com.hihonor.adsdk.reward.e.i;
import com.hihonor.adsdk.reward.e.j;
import com.hihonor.adsdk.reward.e.k;
import com.hihonor.adsdk.reward.e.l;
import com.hihonor.adsdk.reward.e.m;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f3558a = "RewardAdViewFactory";
    private static final String b = "311010001";
    private static final String c = "311030002";
    private static final String d = "311030003";
    private static final String e = "311010004";
    private static final String f = "311030005";
    private static final String g = "311010006";
    private static final String h = "311010007";
    private static final String i = "311030008";

    public static com.hihonor.adsdk.reward.e.a a(BaseAd baseAd) {
        String strC = c(baseAd);
        strC.hashCode();
        strC.hashCode();
        switch (strC) {
            case "311010001":
                return new f(baseAd);
            case "311010004":
                return new i(baseAd);
            case "311010006":
                return new k(baseAd);
            case "311010007":
                return new l(baseAd);
            case "311030002":
                return new g(baseAd);
            case "311030003":
                return new h(baseAd);
            case "311030005":
                return new j(baseAd);
            case "311030008":
                return new m(baseAd);
            default:
                new x(baseAd.getAdUnitId(), com.hihonor.adsdk.base.g.j.g.b.hnadsa(baseAd), ErrorCode.AD_TEMPLATE_BEYOND_ERR_CODE, "ad template beyond or null,template: " + baseAd.getTemplateId()).hnadse();
                return b(baseAd);
        }
    }

    private static com.hihonor.adsdk.reward.e.a b(BaseAd baseAd) {
        if (baseAd.getVideo() == null) {
            com.hihonor.adsdk.common.b.b.hnadse(f3558a, "reward video is empty", new Object[0]);
            return new h(baseAd);
        }
        int orientation = baseAd.getOrientation();
        int videoHeight = baseAd.getVideo().getVideoHeight();
        int videoWidth = baseAd.getVideo().getVideoWidth();
        com.hihonor.adsdk.common.b.b.hnadsc(f3558a, "orientation is %d, videoHeight is %d, videoWidth is %d", Integer.valueOf(orientation), Integer.valueOf(videoHeight), Integer.valueOf(videoWidth));
        if (orientation == 1) {
            return videoWidth >= videoHeight ? new f(baseAd) : new g(baseAd);
        }
        return videoWidth >= videoHeight ? new i(baseAd) : new h(baseAd);
    }

    private static String c(BaseAd baseAd) {
        String templateId = baseAd.getTemplateId();
        com.hihonor.adsdk.common.b.b.hnadsc(f3558a, "templateId is " + templateId, new Object[0]);
        return templateId == null ? "" : templateId;
    }
}
