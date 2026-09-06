package com.kwad.components.core.webview.tachikoma.b;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class r implements com.kwad.sdk.core.webview.c.a {
    public void a(com.kwad.components.core.webview.tachikoma.c.s sVar) {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "showTKDialog";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        com.kwad.components.core.webview.tachikoma.c.s sVar = new com.kwad.components.core.webview.tachikoma.c.s();
        try {
            sVar.parseJson(new JSONObject(str));
            a(sVar);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
