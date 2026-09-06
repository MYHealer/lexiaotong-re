package com.kwad.sdk.commercial.convert;

import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class c {
    private static void a(AdTemplate adTemplate, com.kwad.sdk.commercial.c.a aVar) {
        aVar.setAdTemplate(adTemplate);
        com.kwad.sdk.commercial.c.d(com.kwad.sdk.commercial.d.In().m983do(ILoggerReporter.Category.APM_LOG).g(0.001d).b(com.kwad.sdk.commercial.e.bA(adTemplate)).Q("ad_convert_method_call", "method_name").A(aVar));
    }

    public static void cg(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.Iq().dt("callShow"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void ch(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.Iq().dt("adShowSuccess"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
