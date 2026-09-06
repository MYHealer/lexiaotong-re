package com.kwad.sdk.core.adlog.b;

import com.hihonor.adsdk.base.ErrorCode;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.commercial.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class c {
    private static void a(AdTemplate adTemplate, com.kwad.sdk.core.adlog.a.a aVar, d dVar) {
        a(adTemplate, aVar, false, dVar);
    }

    private static void a(AdTemplate adTemplate, com.kwad.sdk.core.adlog.a.a aVar, boolean z, d dVar) {
        if (aVar != null) {
            dVar.dS(1).dT(aVar.retryCount);
        }
        com.kwad.sdk.commercial.c.d(com.kwad.sdk.commercial.d.In().m983do(z ? ILoggerReporter.Category.ERROR_LOG : ILoggerReporter.Category.APM_LOG).g(z ? 0.01d : 1.0E-4d).h(z ? 1.0d : 0.01d).b(e.bA(adTemplate)).Q("ad_sdk_adlog_performance", "status").A(dVar));
    }

    public static void a(AdTemplate adTemplate, int i, com.kwad.sdk.core.adlog.a.a aVar) {
        try {
            a(adTemplate, aVar, d.Je().dQ(1).dR(i).setAdTemplate(adTemplate));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void b(AdTemplate adTemplate, int i, com.kwad.sdk.core.adlog.a.a aVar) {
        try {
            a(adTemplate, aVar, d.Je().dQ(2).dR(i).setAdTemplate(adTemplate));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(AdTemplate adTemplate, int i, String str, int i2, String str2, com.kwad.sdk.core.adlog.a.a aVar) {
        try {
            a(adTemplate, aVar, d.Je().dQ(5).dR(i).dZ(str).setErrorCode(ErrorCode.d.hnadsg).setErrorMsg(str2).setAdTemplate(adTemplate));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void b(AdTemplate adTemplate, int i, String str, int i2, String str2, com.kwad.sdk.core.adlog.a.a aVar) {
        try {
            a(adTemplate, aVar, true, d.Je().dQ(5).dR(i).dZ(str).setErrorCode(i2).setErrorMsg(str2).setAdTemplate(adTemplate));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void c(AdTemplate adTemplate, int i, String str, int i2, String str2, com.kwad.sdk.core.adlog.a.a aVar) {
        try {
            a(adTemplate, aVar, true, d.Je().dQ(4).dR(i).dZ(str).setErrorCode(i2).setErrorMsg(str2).setAdTemplate(adTemplate));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void d(AdTemplate adTemplate, int i, String str, int i2, String str2, com.kwad.sdk.core.adlog.a.a aVar) {
        try {
            a(adTemplate, aVar, true, d.Je().dQ(3).dR(i).dZ(str).setErrorCode(i2).setErrorMsg(str2).setAdTemplate(adTemplate));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
