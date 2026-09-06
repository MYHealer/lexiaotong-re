package com.kwad.components.ad.interstitial.report;

import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.core.response.helper.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class b {

    static class a {
        private static final b or = new b();
    }

    public static b eX() {
        return a.or;
    }

    private static void a(boolean z, com.kwad.sdk.commercial.c.a aVar) {
        try {
            com.kwad.sdk.commercial.c.d(com.kwad.sdk.commercial.d.In().m983do(ILoggerReporter.Category.APM_LOG).g(z ? 1.0d : 0.01d).Q("ad_sdk_interstitial_download_error", "status").b(BusinessType.AD_INTERSTITIAL).A(aVar).a(com.kwai.adclient.kscommerciallogger.model.b.buT));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public final void B(AdTemplate adTemplate) {
        a(false, new InterstitialReportInfo().setDownloadType(adTemplate.getDownloadType()).setStatus(1).setAdTemplate(adTemplate));
    }

    public final void b(AdTemplate adTemplate, String str) {
        AdInfo adInfoEO = e.eO(adTemplate);
        a(true, new InterstitialReportInfo().setCreativeId(com.kwad.sdk.core.response.helper.a.L(adInfoEO)).setVideoUrl(com.kwad.sdk.core.response.helper.a.M(adInfoEO)).setDownloadSize(adTemplate.getDownloadSize()).setDownloadType(adTemplate.getDownloadType()).setVideoDuration(com.kwad.sdk.core.response.helper.a.N(adInfoEO) * 1000).setStatus(2).setErrorMsg(str).setAdTemplate(adTemplate));
    }
}
