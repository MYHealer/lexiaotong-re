package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class gz implements com.kwad.sdk.core.d<com.kwad.components.ad.interstitial.c.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.ad.interstitial.c.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.ad.interstitial.c.a) bVar, jSONObject);
    }

    private static void a(com.kwad.components.ad.interstitial.c.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.kd = jSONObject.optLong("lastShowTimestamp");
        aVar.mz = jSONObject.optInt("aggregateAdShowCount");
    }

    private static JSONObject b(com.kwad.components.ad.interstitial.c.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (aVar.kd != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "lastShowTimestamp", aVar.kd);
        }
        if (aVar.mz != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "aggregateAdShowCount", aVar.mz);
        }
        return jSONObject;
    }
}
