package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class bg implements com.kwad.sdk.core.d<com.kwad.sdk.m.b.a.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.m.b.a.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.m.b.a.a) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.m.b.a.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.bnv = jSONObject.optInt("aggregation_sdk_type");
        aVar.bnw = jSONObject.optString("aggregation_version");
        if (JSONObject.NULL.toString().equals(aVar.bnw)) {
            aVar.bnw = "";
        }
        aVar.bnx = jSONObject.optInt("crash_times");
        aVar.bny = jSONObject.optInt("call_ks_union_times");
        aVar.bnz = jSONObject.optLong("ks_launch_delay");
        aVar.bnA = jSONObject.optLong("aggregation_launch_delay");
    }

    private static JSONObject b(com.kwad.sdk.m.b.a.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (aVar.bnv != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "aggregation_sdk_type", aVar.bnv);
        }
        if (aVar.bnw != null && !aVar.bnw.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "aggregation_version", aVar.bnw);
        }
        if (aVar.bnx != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "crash_times", aVar.bnx);
        }
        if (aVar.bny != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "call_ks_union_times", aVar.bny);
        }
        if (aVar.bnz != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "ks_launch_delay", aVar.bnz);
        }
        if (aVar.bnA != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "aggregation_launch_delay", aVar.bnA);
        }
        return jSONObject;
    }
}
