package com.kwad.components.core.webview.tachikoma.b;

import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.by;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class k extends w {
    b atO = new b() { // from class: com.kwad.components.core.webview.tachikoma.b.k.1
        @Override // com.kwad.components.core.webview.tachikoma.b.k.b
        public final void Y(final long j) {
            if (k.this.re != null) {
                by.runOnUiThread(new bi() { // from class: com.kwad.components.core.webview.tachikoma.b.k.1.1
                    @Override // com.kwad.sdk.utils.bi
                    public final void doTask() {
                        a aVar = new a((byte) 0);
                        aVar.creativeId = j;
                        k.this.re.b(aVar);
                    }
                });
            }
        }
    };
    private com.kwad.sdk.core.webview.c.c re;

    public interface b {
        void Y(long j);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "registerAdConvertListener";
    }

    @Override // com.kwad.components.core.webview.tachikoma.b.w, com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        this.re = cVar;
        com.kwad.components.core.e.d.a.a(this.atO);
    }

    @Override // com.kwad.components.core.webview.tachikoma.b.w, com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        com.kwad.components.core.e.d.a.b(this.atO);
    }

    static class a implements com.kwad.sdk.core.b {
        public long creativeId;

        @Override // com.kwad.sdk.core.b
        public final void parseJson(JSONObject jSONObject) {
        }

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            ac.putValue(jSONObject, "creativeId", this.creativeId);
            return jSONObject;
        }
    }
}
