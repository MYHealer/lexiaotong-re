package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class hr implements com.kwad.sdk.core.d<com.kwad.components.core.b.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.b.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.b.b) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.b.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.title = jSONObject.optString("title");
        if (JSONObject.NULL.toString().equals(bVar.title)) {
            bVar.title = "";
        }
        bVar.Pc = jSONObject.optString("titleTextColor");
        if (JSONObject.NULL.toString().equals(bVar.Pc)) {
            bVar.Pc = "";
        }
        bVar.Pd = jSONObject.optString("titleBackgroundColor");
        if (JSONObject.NULL.toString().equals(bVar.Pd)) {
            bVar.Pd = "";
        }
    }

    private static JSONObject b(com.kwad.components.core.b.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (bVar.title != null && !bVar.title.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "title", bVar.title);
        }
        if (bVar.Pc != null && !bVar.Pc.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "titleTextColor", bVar.Pc);
        }
        if (bVar.Pd != null && !bVar.Pd.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "titleBackgroundColor", bVar.Pd);
        }
        return jSONObject;
    }
}
