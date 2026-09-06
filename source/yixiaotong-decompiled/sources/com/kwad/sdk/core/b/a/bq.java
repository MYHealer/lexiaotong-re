package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class bq implements com.kwad.sdk.core.d<com.kwad.components.core.request.model.b.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.request.model.b.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.request.model.b.a) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.request.model.b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.streamType = jSONObject.optInt("streamType");
        aVar.ako = jSONObject.optInt("maxVolume");
        aVar.akp = jSONObject.optInt("minVolume");
        aVar.akq = jSONObject.optInt("currentVolume");
    }

    private static JSONObject b(com.kwad.components.core.request.model.b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (aVar.streamType != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "streamType", aVar.streamType);
        }
        if (aVar.ako != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "maxVolume", aVar.ako);
        }
        if (aVar.akp != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "minVolume", aVar.akp);
        }
        if (aVar.akq != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "currentVolume", aVar.akq);
        }
        return jSONObject;
    }
}
