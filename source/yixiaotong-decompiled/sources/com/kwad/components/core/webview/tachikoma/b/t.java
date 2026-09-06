package com.kwad.components.core.webview.tachikoma.b;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class t implements com.kwad.sdk.core.webview.c.a {
    private a atU;

    public interface a {
        void b(com.kwad.components.core.webview.tachikoma.c.u uVar);
    }

    public final void a(a aVar) {
        this.atU = aVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "skipVideo";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.atU = null;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        if (this.atU != null) {
            com.kwad.components.core.webview.tachikoma.c.u uVar = new com.kwad.components.core.webview.tachikoma.c.u();
            try {
                try {
                    uVar.parseJson(new JSONObject(str));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } finally {
                this.atU.b(uVar);
            }
        }
    }
}
