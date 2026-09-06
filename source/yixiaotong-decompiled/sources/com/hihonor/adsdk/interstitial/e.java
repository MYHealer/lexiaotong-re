package com.hihonor.adsdk.interstitial;

import com.hihonor.adsdk.base.api.BaseAd;
import com.hihonor.adsdk.base.bean.Video;
import com.hihonor.adsdk.common.f.u;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f3534a = 0;
    private static final String b = "InterstitialUtils";
    private static final String c = "00";
    private static final String d = ":";

    public static String a(long j, long j2) {
        long j3 = j2 - j;
        if (j3 < 60000) {
            long j4 = j3 / 1000;
            return "00:" + (j4 < 10 ? "0" + j4 : Long.valueOf(j4));
        }
        long j5 = j3 / 60000;
        long j6 = (j3 - (60000 * j5)) / 1000;
        return (j5 < 10 ? "0" + j5 : Long.valueOf(j5)) + ":" + (j6 < 10 ? "0" + j6 : Long.valueOf(j6));
    }

    public static boolean a(int i) {
        return i == 14 || i == 15;
    }

    public static int b() {
        return u.hnadsf();
    }

    public static float c(BaseAd baseAd) {
        if (Objects.isNull(baseAd)) {
            com.hihonor.adsdk.common.b.b.hnadsc(b, "getPicProportion mBaseAd is null", new Object[0]);
            return 0.0f;
        }
        if (baseAd.getProportion() <= 0.0f) {
            return 1.7777778f;
        }
        return baseAd.getProportion();
    }

    public static float d(BaseAd baseAd) {
        if (!Objects.isNull(baseAd)) {
            return i(baseAd) ? e(baseAd) : c(baseAd);
        }
        com.hihonor.adsdk.common.b.b.hnadsc(b, "getVideoOrPicProportion mBaseAd is null", new Object[0]);
        return 0.0f;
    }

    public static float e(BaseAd baseAd) {
        float fA = a(baseAd);
        if (fA <= 0.0f) {
            return 1.7777778f;
        }
        return fA;
    }

    public static boolean f(BaseAd baseAd) {
        if (!Objects.isNull(baseAd)) {
            return baseAd.getPromotionPurpose() == 0 || baseAd.getPromotionPurpose() == 4;
        }
        com.hihonor.adsdk.common.b.b.hnadsc(b, "isDownloadPromotionPurpose baseAd is null", new Object[0]);
        return false;
    }

    public static boolean g(BaseAd baseAd) {
        if (!Objects.isNull(baseAd)) {
            return baseAd.getSubType() == 15;
        }
        com.hihonor.adsdk.common.b.b.hnadsc(b, "isImage mBaseAd is null", new Object[0]);
        return false;
    }

    public static boolean h(BaseAd baseAd) {
        if (baseAd != null) {
            return baseAd.getOrientation() != 0;
        }
        com.hihonor.adsdk.common.b.b.hnadsc(b, "baseAd is null", new Object[0]);
        return false;
    }

    public static boolean i(BaseAd baseAd) {
        if (!Objects.isNull(baseAd)) {
            return baseAd.getSubType() == 14;
        }
        com.hihonor.adsdk.common.b.b.hnadsc(b, "isVideo mBaseAd is null", new Object[0]);
        return false;
    }

    public static String b(BaseAd baseAd) {
        if (Objects.isNull(baseAd)) {
            com.hihonor.adsdk.common.b.b.hnadsc(b, "isImage mBaseAd is null", new Object[0]);
            return "";
        }
        String templateId = baseAd.getTemplateId();
        return templateId == null ? "" : templateId;
    }

    public static int a() {
        return u.hnadse();
    }

    private static float a(BaseAd baseAd) {
        if (Objects.isNull(baseAd)) {
            com.hihonor.adsdk.common.b.b.hnadsc(b, "calculateProportion mBaseAd is null", new Object[0]);
            return 0.0f;
        }
        Video video = baseAd.getVideo();
        if (Objects.isNull(video)) {
            com.hihonor.adsdk.common.b.b.hnadsc(b, "calculateProportion video is null", new Object[0]);
            return 0.0f;
        }
        int videoWidth = video.getVideoWidth();
        int videoHeight = video.getVideoHeight();
        if (videoWidth == 0 || videoHeight == 0) {
            return 0.0f;
        }
        return (videoWidth * 1.0f) / videoHeight;
    }
}
