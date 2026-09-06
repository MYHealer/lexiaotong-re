package com.kwad.sdk.core.b.a;

import com.ubixnow.ooooo.oOOOoo00;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class mu implements com.kwad.sdk.core.d<com.kwad.components.core.webview.jshandler.u.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.webview.jshandler.u.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.webview.jshandler.u.a) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.webview.jshandler.u.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.key = jSONObject.optString("key");
        if (JSONObject.NULL.toString().equals(aVar.key)) {
            aVar.key = "";
        }
        aVar.value = jSONObject.optString(oOOOoo00.OooOo0o);
        if (JSONObject.NULL.toString().equals(aVar.value)) {
            aVar.value = "";
        }
    }

    private static JSONObject b(com.kwad.components.core.webview.jshandler.u.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (aVar.key != null && !aVar.key.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "key", aVar.key);
        }
        if (aVar.value != null && !aVar.value.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, oOOOoo00.OooOo0o, aVar.value);
        }
        return jSONObject;
    }
}
