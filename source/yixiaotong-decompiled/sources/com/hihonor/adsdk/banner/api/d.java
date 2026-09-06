package com.hihonor.adsdk.banner.api;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.hihonor.adsdk.banner.R;
import com.hihonor.adsdk.base.ErrorCode;
import com.hihonor.adsdk.base.HnAds;
import com.hihonor.adsdk.base.api.BaseAd;
import com.hihonor.adsdk.base.g.j.d.x;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f3502a = "BannerViewFactory";
    public static final String b = "501060001";
    public static final String c = "501010002";
    public static final String d = "501020003";

    public static e a(BaseAd baseAd) {
        boolean zHnadsb = com.hihonor.adsdk.base.j.c.hnadsb(baseAd);
        String strB = b(baseAd);
        strB.hashCode();
        strB.hashCode();
        switch (strB) {
            case "501010002":
            case "501020003":
                View viewInflate = LayoutInflater.from(HnAds.get().getContext()).inflate(zHnadsb ? R.layout.honor_ads_banner_picture_download : R.layout.honor_ads_banner_picture, (ViewGroup) null);
                return zHnadsb ? new h(viewInflate) : new g(viewInflate);
            case "501060001":
                View viewInflate2 = LayoutInflater.from(HnAds.get().getContext()).inflate(zHnadsb ? R.layout.honor_ads_banner_picturetext_download : R.layout.honor_ads_banner_picturetext, (ViewGroup) null);
                return zHnadsb ? new j(viewInflate2) : new i(viewInflate2);
            default:
                com.hihonor.adsdk.common.b.b.hnadsc(f3502a, "banner templateId error", new Object[0]);
                new x(baseAd.getAdUnitId(), com.hihonor.adsdk.base.g.j.g.b.hnadsa(baseAd), ErrorCode.AD_TEMPLATE_BEYOND_ERR_CODE, "ad template beyond or null,template: " + baseAd.getTemplateId()).hnadse();
                return c(baseAd);
        }
    }

    private static String b(BaseAd baseAd) {
        String templateId = baseAd.getTemplateId();
        com.hihonor.adsdk.common.b.b.hnadsc(f3502a, "templateId is " + templateId, new Object[0]);
        return templateId == null ? "" : templateId;
    }

    private static e c(BaseAd baseAd) {
        int adSpecTemplateType = baseAd.getAdSpecTemplateType();
        boolean zHnadsb = com.hihonor.adsdk.base.j.c.hnadsb(baseAd);
        if (adSpecTemplateType == 5) {
            View viewInflate = LayoutInflater.from(HnAds.get().getContext()).inflate(zHnadsb ? R.layout.honor_ads_banner_picturetext_download : R.layout.honor_ads_banner_picturetext, (ViewGroup) null);
            return zHnadsb ? new j(viewInflate) : new i(viewInflate);
        }
        View viewInflate2 = LayoutInflater.from(HnAds.get().getContext()).inflate(zHnadsb ? R.layout.honor_ads_banner_picture_download : R.layout.honor_ads_banner_picture, (ViewGroup) null);
        return zHnadsb ? new h(viewInflate2) : new g(viewInflate2);
    }
}
