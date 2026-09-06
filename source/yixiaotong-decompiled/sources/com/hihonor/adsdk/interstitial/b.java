package com.hihonor.adsdk.interstitial;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.hihonor.adsdk.base.ErrorCode;
import com.hihonor.adsdk.base.api.BaseAd;
import com.hihonor.adsdk.base.g.j.d.x;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f3531a = "InterstitialAdViewFactory";
    private static final String b = "401030001";
    private static final String c = "401010002";
    private static final String d = "401030003";
    private static final String e = "401010004";
    private static final String f = "411030001";
    private static final String g = "411010002";
    private static final String h = "411030003";
    private static final String i = "411010004";

    public static View a(Context context, BaseAd baseAd, boolean z, com.hihonor.adsdk.interstitial.g.a aVar) {
        if (Objects.isNull(baseAd)) {
            com.hihonor.adsdk.common.b.b.hnadsc(f3531a, "createBottomFloatView baseAd is null", new Object[0]);
            return null;
        }
        if (Objects.isNull(context)) {
            com.hihonor.adsdk.common.b.b.hnadsc(f3531a, "createBottomFloatView context is null", new Object[0]);
            return null;
        }
        if (!Objects.nonNull(aVar)) {
            return null;
        }
        View viewInflate = LayoutInflater.from(context).inflate(aVar.a(baseAd), (ViewGroup) null);
        aVar.a(context, baseAd, z, viewInflate);
        return viewInflate;
    }

    public static int b(BaseAd baseAd) {
        String strB = e.b(baseAd);
        strB.hashCode();
        strB.hashCode();
        switch (strB) {
            case "401010002":
            case "401030003":
            case "411010002":
            case "411030003":
                return R.layout.activity_honor_ads_interstitial_template_two_or_three;
            case "401010004":
            case "411010004":
                return R.layout.activity_honor_ads_interstitial_template_four;
            case "401030001":
            case "411030001":
                return R.layout.activity_honor_ads_interstitial_template_one;
            default:
                com.hihonor.adsdk.common.b.b.hnadsb(f3531a, "createContentView default", new Object[0]);
                return d(baseAd);
        }
    }

    public static com.hihonor.adsdk.interstitial.g.a c(BaseAd baseAd) {
        String strB = e.b(baseAd);
        strB.hashCode();
        strB.hashCode();
        switch (strB) {
            case "401010002":
            case "411010002":
                return new com.hihonor.adsdk.interstitial.g.e();
            case "401010004":
            case "411010004":
                return new com.hihonor.adsdk.interstitial.g.b();
            case "401030001":
            case "411030001":
                return new com.hihonor.adsdk.interstitial.g.c();
            case "401030003":
            case "411030003":
                return new com.hihonor.adsdk.interstitial.g.d();
            default:
                com.hihonor.adsdk.common.b.b.hnadsb(f3531a, "createTextArea default", new Object[0]);
                return g(baseAd);
        }
    }

    private static int d(BaseAd baseAd) {
        if (e.h(baseAd)) {
            return R.layout.activity_honor_ads_interstitial_template_two_or_three;
        }
        return i(baseAd) ? R.layout.activity_honor_ads_interstitial_template_one : R.layout.activity_honor_ads_interstitial_template_four;
    }

    private static com.hihonor.adsdk.interstitial.adapter.a e(BaseAd baseAd) {
        return e.g(baseAd) ? f(baseAd) : h(baseAd);
    }

    private static com.hihonor.adsdk.interstitial.adapter.a f(BaseAd baseAd) {
        if (e.h(baseAd)) {
            return e.c(baseAd) < 1.0f ? new com.hihonor.adsdk.interstitial.adapter.b.d() : new com.hihonor.adsdk.interstitial.adapter.b.e();
        }
        return e.c(baseAd) < 1.0f ? new com.hihonor.adsdk.interstitial.adapter.b.c() : new com.hihonor.adsdk.interstitial.adapter.b.b();
    }

    private static com.hihonor.adsdk.interstitial.g.a g(BaseAd baseAd) {
        boolean zI = i(baseAd);
        if (e.h(baseAd)) {
            return zI ? new com.hihonor.adsdk.interstitial.g.d() : new com.hihonor.adsdk.interstitial.g.e();
        }
        return zI ? new com.hihonor.adsdk.interstitial.g.c() : new com.hihonor.adsdk.interstitial.g.b();
    }

    private static com.hihonor.adsdk.interstitial.adapter.a h(BaseAd baseAd) {
        if (e.h(baseAd)) {
            return e.e(baseAd) < 1.0f ? new com.hihonor.adsdk.interstitial.adapter.c.d() : new com.hihonor.adsdk.interstitial.adapter.c.e();
        }
        return e.e(baseAd) < 1.0f ? new com.hihonor.adsdk.interstitial.adapter.c.c() : new com.hihonor.adsdk.interstitial.adapter.c.b();
    }

    private static boolean i(BaseAd baseAd) {
        if (e.g(baseAd)) {
            return e.c(baseAd) < 1.0f;
        }
        return e.e(baseAd) < 1.0f;
    }

    public static com.hihonor.adsdk.interstitial.adapter.a a(BaseAd baseAd) {
        String strB = e.b(baseAd);
        strB.hashCode();
        strB.hashCode();
        switch (strB) {
            case "401010002":
                return new com.hihonor.adsdk.interstitial.adapter.b.e();
            case "401010004":
                return new com.hihonor.adsdk.interstitial.adapter.b.b();
            case "401030001":
                return new com.hihonor.adsdk.interstitial.adapter.b.c();
            case "401030003":
                return new com.hihonor.adsdk.interstitial.adapter.b.d();
            case "411010002":
                return new com.hihonor.adsdk.interstitial.adapter.c.e();
            case "411010004":
                return new com.hihonor.adsdk.interstitial.adapter.c.b();
            case "411030001":
                return new com.hihonor.adsdk.interstitial.adapter.c.c();
            case "411030003":
                return new com.hihonor.adsdk.interstitial.adapter.c.d();
            default:
                com.hihonor.adsdk.common.b.b.hnadsb(f3531a, "createAdapter default", new Object[0]);
                new x(baseAd.getAdUnitId(), com.hihonor.adsdk.base.g.j.g.b.hnadsa(baseAd), ErrorCode.AD_TEMPLATE_BEYOND_ERR_CODE, "ad template beyond or null,template: " + baseAd.getTemplateId()).hnadse();
                return e(baseAd);
        }
    }
}
