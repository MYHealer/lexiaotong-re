package com.kwad.sdk.crash.report.request;

import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.crash.report.ReportEvent;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class b {

    public interface a {
        void onError(int i, String str);

        void onSuccess();
    }

    public static void a(final List<ReportEvent> list, final CountDownLatch countDownLatch, final a aVar) {
        com.kwad.sdk.core.d.c.d("AnrAndNativeAdExceptionCollector", "CrashReportRequestManager request");
        if (list == null || list.size() <= 0) {
            return;
        }
        new l<com.kwad.sdk.crash.report.request.a, CrashReportResult>() { // from class: com.kwad.sdk.crash.report.request.b.1
            @Override // com.kwad.sdk.core.network.l
            public final boolean enableCrashReport() {
                return false;
            }

            @Override // com.kwad.sdk.core.network.l
            public final boolean enableMonitorReport() {
                return false;
            }

            @Override // com.kwad.sdk.core.network.l
            public final /* synthetic */ BaseResultData parseData(String str) {
                return gF(str);
            }

            private static CrashReportResult gF(String str) {
                JSONObject jSONObject = new JSONObject(str);
                CrashReportResult crashReportResult = new CrashReportResult();
                crashReportResult.parseJson(jSONObject);
                return crashReportResult;
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            /* JADX INFO: renamed from: QH, reason: merged with bridge method [inline-methods] */
            public com.kwad.sdk.crash.report.request.a createRequest() {
                return new com.kwad.sdk.crash.report.request.a(list) { // from class: com.kwad.sdk.crash.report.request.b.1.1
                    @Override // com.kwad.sdk.core.network.b
                    public final boolean enableCrashReport() {
                        return false;
                    }
                };
            }
        }.request(new o<com.kwad.sdk.crash.report.request.a, CrashReportResult>() { // from class: com.kwad.sdk.crash.report.request.b.2
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onError(f fVar, int i, String str) {
                A(i, str);
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onSuccess(f fVar, BaseResultData baseResultData) {
                QI();
            }

            private void QI() {
                CountDownLatch countDownLatch2 = countDownLatch;
                if (countDownLatch2 != null) {
                    countDownLatch2.countDown();
                }
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.onSuccess();
                }
            }

            private void A(int i, String str) {
                CountDownLatch countDownLatch2 = countDownLatch;
                if (countDownLatch2 != null) {
                    countDownLatch2.countDown();
                }
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.onError(i, str);
                }
            }
        });
    }

    public static void a(List<ReportEvent> list, CountDownLatch countDownLatch) {
        a(list, countDownLatch, null);
    }
}
