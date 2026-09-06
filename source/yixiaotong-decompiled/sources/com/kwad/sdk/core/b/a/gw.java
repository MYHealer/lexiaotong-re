package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class gw implements com.kwad.sdk.core.d<com.kwad.sdk.a.a.a.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.a.a.a.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.a.a.a.a) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.a.a.a.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.kd = jSONObject.optLong("lastShowTimestamp");
        aVar.auj = jSONObject.optInt("showCount");
    }

    private static JSONObject b(com.kwad.sdk.a.a.a.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (aVar.kd != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "lastShowTimestamp", aVar.kd);
        }
        if (aVar.auj != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "showCount", aVar.auj);
        }
        return jSONObject;
    }
}
