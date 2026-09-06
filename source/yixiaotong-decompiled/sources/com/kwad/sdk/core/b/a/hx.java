package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class hx implements com.kwad.sdk.core.d<com.kwad.components.core.innerEc.live.config.net.d> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.innerEc.live.config.net.d) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.innerEc.live.config.net.d) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.innerEc.live.config.net.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        dVar.Uk = jSONObject.optString("serverExpTag");
        if (JSONObject.NULL.toString().equals(dVar.Uk)) {
            dVar.Uk = "";
        }
        dVar.streamType = jSONObject.optInt("streamType");
        dVar.liveStreamId = jSONObject.optString("liveStreamId");
        if (JSONObject.NULL.toString().equals(dVar.liveStreamId)) {
            dVar.liveStreamId = "";
        }
        dVar.Ul = jSONObject.optBoolean("multiTabLive");
        dVar.Um = jSONObject.optString("attach");
        if (JSONObject.NULL.toString().equals(dVar.Um)) {
            dVar.Um = "";
        }
        dVar.Un = jSONObject.optString("locale");
        if (JSONObject.NULL.toString().equals(dVar.Un)) {
            dVar.Un = "";
        }
        dVar.Uo = jSONObject.optBoolean("isAnonymousLive");
    }

    private static JSONObject b(com.kwad.components.core.innerEc.live.config.net.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (dVar.Uk != null && !dVar.Uk.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "serverExpTag", dVar.Uk);
        }
        if (dVar.streamType != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "streamType", dVar.streamType);
        }
        if (dVar.liveStreamId != null && !dVar.liveStreamId.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "liveStreamId", dVar.liveStreamId);
        }
        if (dVar.Ul) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "multiTabLive", dVar.Ul);
        }
        if (dVar.Um != null && !dVar.Um.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "attach", dVar.Um);
        }
        if (dVar.Un != null && !dVar.Un.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "locale", dVar.Un);
        }
        if (dVar.Uo) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "isAnonymousLive", dVar.Uo);
        }
        return jSONObject;
    }
}
