package com.kwad.components.ad.splashscreen.monitor;

import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.commercial.d;
import com.kwad.sdk.core.response.helper.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.o;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class a {

    /* JADX INFO: renamed from: com.kwad.components.ad.splashscreen.monitor.a$a, reason: collision with other inner class name */
    static class C0637a {
        private static final a Hp = new a();
    }

    public static a mt() {
        return C0637a.Hp;
    }

    private static void d(com.kwad.sdk.commercial.c.a aVar) {
        if (o.Gs().Fx()) {
            com.kwad.sdk.commercial.c.d(d.In().m983do(ILoggerReporter.Category.APM_LOG).g(0.01d).Q("ad_sdk_splash_callback", "callback_type").b(BusinessType.AD_SPLASH).A(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.buA));
        }
    }

    private static void e(com.kwad.sdk.commercial.c.a aVar) {
        if (o.Gs().Fx()) {
            com.kwad.sdk.commercial.c.d(d.In().m983do(ILoggerReporter.Category.APM_LOG).g(0.01d).Q("ad_sdk_splash_action", "action_type").b(BusinessType.AD_SPLASH).A(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.buA));
        }
    }

    private static SplashMonitorInfo ak(AdTemplate adTemplate) {
        AdInfo adInfoEO = e.eO(adTemplate);
        return new SplashMonitorInfo().setPreloadId(com.kwad.sdk.core.response.helper.a.bf(adInfoEO)).setCreativeId(com.kwad.sdk.core.response.helper.a.L(adInfoEO)).setMaterialType(com.kwad.sdk.core.response.helper.a.bi(adInfoEO) ? 1 : 2).setAdTemplate(adTemplate);
    }

    public final void z(AdTemplate adTemplate) {
        d(ak(adTemplate).setCallbackType(1));
    }

    public final void al(AdTemplate adTemplate) {
        d(ak(adTemplate).setCallbackType(2));
    }

    public final void A(AdTemplate adTemplate) {
        d(ak(adTemplate).setCallbackType(3));
    }

    public final void w(long j) {
        d(new SplashMonitorInfo().setCallbackType(4).setPosId(j));
    }

    public final void am(AdTemplate adTemplate) {
        d(ak(adTemplate).setCallbackType(5));
    }

    public final void an(AdTemplate adTemplate) {
        e(ak(adTemplate).setActionType(1));
    }

    public final void ao(AdTemplate adTemplate) {
        e(ak(adTemplate).setActionType(2));
    }
}
