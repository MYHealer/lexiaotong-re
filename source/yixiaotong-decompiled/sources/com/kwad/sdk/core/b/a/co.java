package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class co implements com.kwad.sdk.core.d<com.kwad.sdk.core.report.n.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.core.report.n.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.core.report.n.a) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.core.report.n.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.aWB = jSONObject.optInt("posIdWidth");
        aVar.aWC = jSONObject.optInt("posIdHeight");
    }

    private static JSONObject b(com.kwad.sdk.core.report.n.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (aVar.aWB != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "posIdWidth", aVar.aWB);
        }
        if (aVar.aWC != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "posIdHeight", aVar.aWC);
        }
        return jSONObject;
    }
}
