package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class an implements com.kwad.sdk.core.d<com.kwad.components.core.webview.jshandler.a.C0695a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.webview.jshandler.a.C0695a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.webview.jshandler.a.C0695a) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.webview.jshandler.a.C0695a c0695a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0695a.PC = jSONObject.optString("creativeId");
        if (JSONObject.NULL.toString().equals(c0695a.PC)) {
            c0695a.PC = "";
        }
        c0695a.aps = jSONObject.optString("targetMethod");
        if (JSONObject.NULL.toString().equals(c0695a.aps)) {
            c0695a.aps = "";
        }
        c0695a.apt = jSONObject.optString("methodParams");
        if (JSONObject.NULL.toString().equals(c0695a.apt)) {
            c0695a.apt = "";
        }
    }

    private static JSONObject b(com.kwad.components.core.webview.jshandler.a.C0695a c0695a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (c0695a.PC != null && !c0695a.PC.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "creativeId", c0695a.PC);
        }
        if (c0695a.aps != null && !c0695a.aps.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "targetMethod", c0695a.aps);
        }
        if (c0695a.apt != null && !c0695a.apt.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "methodParams", c0695a.apt);
        }
        return jSONObject;
    }
}
