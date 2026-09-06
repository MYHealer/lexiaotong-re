package com.hihonor.adsdk.splash;

import android.content.Context;
import com.hihonor.adsdk.base.ErrorCode;
import com.hihonor.adsdk.base.api.BaseAd;
import com.hihonor.adsdk.base.g.j.d.x;
import com.hihonor.adsdk.splash.view.BaseSplashAdView;
import com.hihonor.adsdk.splash.view.LandSpVideoAdView;
import com.hihonor.adsdk.splash.view.VerticalSpImageAdView;
import com.hihonor.adsdk.splash.view.VerticalSpSmallImageAdView;
import com.hihonor.adsdk.splash.view.VerticalSpVideoAdView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f3582a = "SplashViewFactory";
    public static final int b = 0;
    private static final String c = "101040002";
    private static final String d = "101050001";
    private static final String e = "111030001";
    private static final String f = "111010002";

    public static BaseSplashAdView a(Context context, BaseAd baseAd, BaseSplashAdView.a aVar) {
        BaseSplashAdView landSpVideoAdView;
        BaseSplashAdView baseSplashAdViewA;
        String templateId = baseAd.getTemplateId();
        com.hihonor.adsdk.common.b.b.hnadsc(f3582a, "createSplashView#templateId is " + templateId, new Object[0]);
        if (templateId == null) {
            templateId = "";
        }
        templateId.hashCode();
        switch (templateId) {
            case "111010002":
                landSpVideoAdView = new LandSpVideoAdView(context);
                baseSplashAdViewA = landSpVideoAdView;
                break;
            case "111030001":
                landSpVideoAdView = new VerticalSpVideoAdView(context);
                baseSplashAdViewA = landSpVideoAdView;
                break;
            case "101040002":
                landSpVideoAdView = new VerticalSpImageAdView(context);
                baseSplashAdViewA = landSpVideoAdView;
                break;
            case "101050001":
                landSpVideoAdView = new VerticalSpSmallImageAdView(context);
                baseSplashAdViewA = landSpVideoAdView;
                break;
            default:
                com.hihonor.adsdk.common.b.b.hnadsb(f3582a, "createSplashView#Use a fallback plan", new Object[0]);
                baseSplashAdViewA = a(context, baseAd);
                a(baseAd);
                break;
        }
        baseSplashAdViewA.setBaseAd(baseAd);
        baseSplashAdViewA.setActionEventListener(aVar);
        return baseSplashAdViewA;
    }

    private static BaseSplashAdView a(Context context, BaseAd baseAd) {
        if (baseAd.getSubType() == 9 && baseAd.getAdSpecTemplateType() == 4) {
            return new VerticalSpSmallImageAdView(context);
        }
        if (baseAd.getSubType() == 9) {
            return new VerticalSpImageAdView(context);
        }
        if (baseAd.getOrientation() == 0) {
            return new VerticalSpVideoAdView(context);
        }
        return new LandSpVideoAdView(context);
    }

    private static void a(BaseAd baseAd) {
        new x(baseAd.getAdUnitId(), com.hihonor.adsdk.base.g.j.g.b.hnadsa(baseAd), ErrorCode.AD_TEMPLATE_BEYOND_ERR_CODE, "ad template beyond or null,template: " + baseAd.getTemplateId()).hnadse();
    }
}
