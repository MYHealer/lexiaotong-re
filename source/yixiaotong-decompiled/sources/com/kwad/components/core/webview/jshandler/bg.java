package com.kwad.components.core.webview.jshandler;

import com.kwad.sdk.utils.by;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class bg implements com.kwad.sdk.core.webview.c.a {
    private com.kwad.sdk.core.webview.c.c aqe;
    private b arJ;

    public static final class a extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {
        public int visibility;
    }

    public interface b {
        void a(a aVar);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "setHeaderBar";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.arJ = null;
        this.aqe = null;
    }

    public bg(b bVar) {
        this.arJ = bVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        this.aqe = cVar;
        final a aVar = new a();
        try {
            aVar.parseJson(new JSONObject(str));
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
        }
        by.postOnUiThread(new com.kwad.sdk.utils.bi() { // from class: com.kwad.components.core.webview.jshandler.bg.1
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                bg.this.b(aVar);
                if (bg.this.aqe != null) {
                    bg.this.aqe.b(null);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a aVar) {
        b bVar = this.arJ;
        if (bVar != null) {
            bVar.a(aVar);
        }
    }
}
