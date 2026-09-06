package com.kwad.components.ad.interstitial.report;

import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.core.response.helper.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class d {

    static class a {
        private static final d ot = new d();
    }

    public static d fb() {
        return a.ot;
    }

    private static void a(boolean z, com.kwad.sdk.commercial.c.a aVar) {
        try {
            com.kwad.sdk.commercial.c.d(com.kwad.sdk.commercial.d.In().m983do(ILoggerReporter.Category.APM_LOG).g(z ? 1.0d : 0.01d).Q("ad_sdk_interstitial_play", "status").b(BusinessType.AD_INTERSTITIAL).A(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.buA));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public final void I(AdTemplate adTemplate) {
        a(false, new InterstitialReportInfo(adTemplate).setStatus(1).setAdTemplate(adTemplate));
    }

    public final void b(AdTemplate adTemplate, long j) {
        AdInfo adInfoEO = e.eO(adTemplate);
        a(false, new InterstitialReportInfo(adTemplate).setStatus(3).setCreativeId(e.eY(adTemplate)).setVideoUrl(com.kwad.sdk.core.response.helper.a.M(adInfoEO)).setVideoDuration(((long) com.kwad.sdk.core.response.helper.a.N(adInfoEO)) * 1000).setPlayStartedDuration(j).setAdTemplate(adTemplate));
    }

    public final void b(AdTemplate adTemplate, int i, String str) {
        AdInfo adInfoEO = e.eO(adTemplate);
        a(true, new InterstitialReportInfo(adTemplate).setCreativeId(com.kwad.sdk.core.response.helper.a.L(adInfoEO)).setVideoUrl(com.kwad.sdk.core.response.helper.a.M(adInfoEO)).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setVideoDuration(com.kwad.sdk.core.response.helper.a.N(adInfoEO) * 1000).setStatus(2).setErrorMsg(str).setErrorCode(i).setAdTemplate(adTemplate));
    }
}
