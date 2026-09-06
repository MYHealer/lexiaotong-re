package com.kwad.sdk.core.adlog.b;

import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.commercial.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class a {
    private static void a(com.kwad.sdk.core.adlog.a.a aVar, com.kwad.sdk.core.adlog.a.c cVar, b bVar) {
        a(aVar, cVar, false, bVar);
    }

    private static void a(com.kwad.sdk.core.adlog.a.a aVar, com.kwad.sdk.core.adlog.a.c cVar, boolean z, b bVar) {
        AdTemplate adTemplate = aVar.aLN.adTemplate;
        bVar.dL(aVar.aLN.aKI).dM(aVar.retryCount).dN(aVar.aLP).dY(aVar.aLQ).dO(cVar.aLY).bE(cVar.aLZ).setAdTemplate(adTemplate);
        com.kwad.sdk.commercial.c.d(com.kwad.sdk.commercial.d.In().m983do(ILoggerReporter.Category.APM_LOG).g(z ? 1.0d : 0.1d).b(e.bA(adTemplate)).Q("ad_sdk_adlog_retry", "status").A(bVar));
    }

    public static void a(com.kwad.sdk.core.adlog.a.a aVar, com.kwad.sdk.core.adlog.a.c cVar, int i) {
        try {
            a(aVar, cVar, b.Jd().dK(1).dP(i));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void b(com.kwad.sdk.core.adlog.a.a aVar, com.kwad.sdk.core.adlog.a.c cVar, int i) {
        try {
            a(aVar, cVar, b.Jd().dK(2).dP(i));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void c(com.kwad.sdk.core.adlog.a.a aVar, com.kwad.sdk.core.adlog.a.c cVar, int i) {
        try {
            a(aVar, cVar, true, b.Jd().dK(3).dP(i));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void d(com.kwad.sdk.core.adlog.a.a aVar, com.kwad.sdk.core.adlog.a.c cVar, int i) {
        try {
            a(aVar, cVar, b.Jd().dK(4).dP(i));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(com.kwad.sdk.core.adlog.a.a aVar, com.kwad.sdk.core.adlog.a.c cVar, int i, long j) {
        try {
            a(aVar, cVar, b.Jd().dK(5).dP(i).az(j));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void b(com.kwad.sdk.core.adlog.a.a aVar, com.kwad.sdk.core.adlog.a.c cVar, int i, long j) {
        try {
            a(aVar, cVar, true, b.Jd().dK(6).dP(i).az(j));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void e(com.kwad.sdk.core.adlog.a.a aVar, com.kwad.sdk.core.adlog.a.c cVar, int i) {
        try {
            a(aVar, cVar, true, b.Jd().dK(7).dP(i));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
