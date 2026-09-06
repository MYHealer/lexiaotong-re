package com.kwad.components.core.webview.jshandler;

import com.kwad.sdk.utils.by;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class a implements com.kwad.sdk.core.webview.c.a {
    private b app;

    /* JADX INFO: renamed from: com.kwad.components.core.webview.jshandler.a$a, reason: collision with other inner class name */
    public static class C0695a extends com.kwad.sdk.core.response.a.a {
        public String PC;
        public String aps;
        public String apt;
    }

    public interface b {
        void c(C0695a c0695a);
    }

    public static class c extends com.kwad.sdk.core.response.a.a {
        public int apu;
        public long apv;
        public boolean apw;
        public int errorCode;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "adOutCallback";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    public a(b bVar) {
        this.app = bVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        try {
            C0695a c0695a = new C0695a();
            c0695a.parseJson(new JSONObject(str));
            b(c0695a);
        } catch (Throwable unused) {
        }
    }

    private void b(final C0695a c0695a) {
        by.postOnUiThread(new com.kwad.sdk.utils.bi() { // from class: com.kwad.components.core.webview.jshandler.a.1
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                if (a.this.app != null) {
                    a.this.app.c(c0695a);
                }
            }
        });
    }
}
