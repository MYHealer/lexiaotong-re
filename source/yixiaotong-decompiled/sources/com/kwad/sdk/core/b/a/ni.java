package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class ni implements com.kwad.sdk.core.d<com.kwad.sdk.core.threads.d> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.core.threads.d) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.core.threads.d) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.core.threads.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        dVar.aYJ = jSONObject.optInt("rate_reciprocal");
        dVar.aYP = jSONObject.optInt("threshold");
        dVar.interval = jSONObject.optLong(com.umeng.analytics.pro.am.aT);
    }

    private static JSONObject b(com.kwad.sdk.core.threads.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (dVar.aYJ != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "rate_reciprocal", dVar.aYJ);
        }
        if (dVar.aYP != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "threshold", dVar.aYP);
        }
        if (dVar.interval != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, com.umeng.analytics.pro.am.aT, dVar.interval);
        }
        return jSONObject;
    }
}
