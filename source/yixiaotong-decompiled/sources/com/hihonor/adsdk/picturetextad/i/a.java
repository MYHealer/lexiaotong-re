package com.hihonor.adsdk.picturetextad.i;

import com.hihonor.adsdk.base.ErrorCode;
import com.hihonor.adsdk.base.api.BaseAd;
import com.hihonor.adsdk.base.g.j.d.x;
import com.hihonor.adsdk.base.g.j.g.b;
import com.hihonor.adsdk.base.j.c;
import com.hihonor.adsdk.picturetextad.R;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<String, C0468a> f3551a = new HashMap(32);
    private static final String b = "201010001";
    private static final String c = "201010002";
    private static final String d = "201010003";
    private static final String e = "201010004";
    private static final String f = "201010005";
    private static final String g = "201060001";
    private static final String h = "201060002";
    private static final String i = "203060001";
    private static final String j = "203060002";
    private static final String k = "203060003";
    private static final String l = "211010001";
    private static final String m = "211010002";
    private static final String n = "211010003";
    private static final String o = "211010004";
    private static final String p = "211010005";
    private static final String q = "211030001";
    private static final String r = "211030002";
    private static final String s = "211030003";
    private static final String t = "201070001";

    /* JADX INFO: renamed from: com.hihonor.adsdk.picturetextad.i.a$a, reason: collision with other inner class name */
    private static class C0468a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f3552a;
        private final int b;

        public C0468a(int i, int i2) {
            this.f3552a = i;
            this.b = i2;
        }

        int a(BaseAd baseAd) {
            return c.hnadsb(baseAd) ? this.b : this.f3552a;
        }
    }

    static {
        a(b, R.layout.honor_ads_picture_big_001, R.layout.honor_ads_picture_big_001_download);
        a(c, R.layout.honor_ads_picture_big_002, R.layout.honor_ads_picture_big_002_download);
        a(d, R.layout.honor_ads_picture_big_003, R.layout.honor_ads_picture_big_003_download);
        a(e, R.layout.honor_ads_picture_big_004, R.layout.honor_ads_picture_big_004_download);
        a(f, R.layout.honor_ads_picture_big_005, R.layout.honor_ads_picture_big_005_download);
        a(g, R.layout.honor_ads_picture_small_001, R.layout.honor_ads_picture_small_001_download);
        a(h, R.layout.honor_ads_picture_small_002, R.layout.honor_ads_picture_small_002_download);
        a(i, R.layout.honor_ads_picture_three_001, R.layout.honor_ads_picture_three_001_download);
        a(j, R.layout.honor_ads_picture_three_002, R.layout.honor_ads_picture_three_002_download);
        a(k, R.layout.honor_ads_picture_three_003, R.layout.honor_ads_picture_three_003_download);
        a(l, R.layout.honor_ads_video_horizontal_001, R.layout.honor_ads_video_horizontal_001_download);
        a(m, R.layout.honor_ads_video_horizontal_002, R.layout.honor_ads_video_horizontal_002_download);
        a(n, R.layout.honor_ads_video_horizontal_003, R.layout.honor_ads_video_horizontal_003_download);
        a(o, R.layout.honor_ads_video_horizontal_004, R.layout.honor_ads_video_horizontal_004_download);
        a(p, R.layout.honor_ads_video_horizontal_005, R.layout.honor_ads_video_horizontal_005_download);
        a(q, R.layout.honor_ads_video_vertical_001, R.layout.honor_ads_video_vertical_001_download);
        a(r, R.layout.honor_ads_video_vertical_002, R.layout.honor_ads_video_vertical_002_download);
        a(s, R.layout.honor_ads_video_vertical_003, R.layout.honor_ads_video_vertical_003_download);
        a(t, R.layout.honor_ads_picture_app_001, R.layout.honor_ads_picture_app_001_download);
    }

    private a() {
    }

    private static void a(String str, int i2, int i3) {
        f3551a.put(str, new C0468a(i2, i3));
    }

    private static void b(BaseAd baseAd) {
        new x(baseAd.getAdUnitId(), b.hnadsa(baseAd), ErrorCode.AD_TEMPLATE_BEYOND_ERR_CODE, "ad template beyond or null,template: " + baseAd.getTemplateId()).hnadse();
    }

    private static C0468a a(String str) {
        return f3551a.get(str);
    }

    public static int a(BaseAd baseAd) {
        if (baseAd == null) {
            return -1;
        }
        C0468a c0468aA = a(baseAd.getTemplateId());
        if (c0468aA == null) {
            b(baseAd);
            return -1;
        }
        return c0468aA.a(baseAd);
    }
}
