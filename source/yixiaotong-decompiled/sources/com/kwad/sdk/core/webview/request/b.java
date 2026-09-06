package com.kwad.sdk.core.webview.request;

import android.os.Handler;
import android.os.Looper;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.utils.bi;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class b {
    private static final Handler jk = new Handler(Looper.getMainLooper());

    public interface a {
        void a(WebCardGetDataResponse webCardGetDataResponse);

        void onError(int i, String str);
    }

    public final void a(final com.kwad.sdk.core.webview.d.b.a aVar, final a aVar2) {
        new l<com.kwad.sdk.core.webview.request.a, WebCardGetDataResponse>() { // from class: com.kwad.sdk.core.webview.request.b.1
            @Override // com.kwad.sdk.core.network.l
            public final /* synthetic */ BaseResultData parseData(String str) {
                return fV(str);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            /* JADX INFO: renamed from: PN, reason: merged with bridge method [inline-methods] */
            public com.kwad.sdk.core.webview.request.a createRequest() {
                return new com.kwad.sdk.core.webview.request.a(aVar.url, aVar.method, aVar.params) { // from class: com.kwad.sdk.core.webview.request.b.1.1
                    @Override // com.kwad.sdk.core.webview.request.a, com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
                    public final String getUrl() {
                        return aVar.url;
                    }
                };
            }

            private static WebCardGetDataResponse fV(String str) {
                JSONObject jSONObject = new JSONObject(str);
                WebCardGetDataResponse webCardGetDataResponse = new WebCardGetDataResponse();
                webCardGetDataResponse.parseJson(jSONObject);
                return webCardGetDataResponse;
            }
        }.request(new o<com.kwad.sdk.core.webview.request.a, WebCardGetDataResponse>() { // from class: com.kwad.sdk.core.webview.request.b.2
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onError(f fVar, int i, String str) {
                z(i, str);
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onSuccess(f fVar, BaseResultData baseResultData) {
                b((WebCardGetDataResponse) baseResultData);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onStartRequest(com.kwad.sdk.core.webview.request.a aVar3) {
                super.onStartRequest(aVar3);
                c.d("WebCardGetDataRequestManager", "onStartRequest");
                b.jk.post(new bi() { // from class: com.kwad.sdk.core.webview.request.b.2.1
                    @Override // com.kwad.sdk.utils.bi
                    public final void doTask() {
                    }
                });
            }

            private void b(final WebCardGetDataResponse webCardGetDataResponse) {
                c.d("WebCardGetDataRequestManager", "onSuccess");
                b.jk.post(new bi() { // from class: com.kwad.sdk.core.webview.request.b.2.2
                    @Override // com.kwad.sdk.utils.bi
                    public final void doTask() {
                        aVar2.a(webCardGetDataResponse);
                    }
                });
            }

            private void z(final int i, final String str) {
                c.d("WebCardGetDataRequestManager", "onError errorCode=" + i + " errorMsg=" + str);
                b.jk.post(new bi() { // from class: com.kwad.sdk.core.webview.request.b.2.3
                    @Override // com.kwad.sdk.utils.bi
                    public final void doTask() {
                        aVar2.onError(i, str);
                    }
                });
            }
        });
    }
}
