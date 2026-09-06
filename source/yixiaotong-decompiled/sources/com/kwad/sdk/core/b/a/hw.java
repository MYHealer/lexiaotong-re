package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class hw implements com.kwad.sdk.core.d<com.kwad.components.core.innerEc.live.config.net.c> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.innerEc.live.config.net.c) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.innerEc.live.config.net.c) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.innerEc.live.config.net.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        cVar.name = jSONObject.optString("name");
        if (JSONObject.NULL.toString().equals(cVar.name)) {
            cVar.name = "";
        }
        cVar.Uj = jSONObject.optString("hearIcon");
        if (JSONObject.NULL.toString().equals(cVar.Uj)) {
            cVar.Uj = "";
        }
    }

    private static JSONObject b(com.kwad.components.core.innerEc.live.config.net.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (cVar.name != null && !cVar.name.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "name", cVar.name);
        }
        if (cVar.Uj != null && !cVar.Uj.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "hearIcon", cVar.Uj);
        }
        return jSONObject;
    }
}
