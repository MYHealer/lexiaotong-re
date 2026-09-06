package com.kwad.sdk.core.b.a;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class fu implements com.kwad.sdk.core.d<com.kwad.components.core.webview.jshandler.j.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.webview.jshandler.j.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.webview.jshandler.j.a) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.webview.jshandler.j.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.apC = jSONObject.optString(TypedValues.AttributesType.S_TARGET);
        if (JSONObject.NULL.toString().equals(aVar.apC)) {
            aVar.apC = "";
        }
    }

    private static JSONObject b(com.kwad.components.core.webview.jshandler.j.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (aVar.apC != null && !aVar.apC.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, TypedValues.AttributesType.S_TARGET, aVar.apC);
        }
        return jSONObject;
    }
}
