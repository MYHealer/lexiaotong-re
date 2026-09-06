package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class hp implements com.kwad.sdk.core.d<com.kwad.components.core.innerEc.live.config.net.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.innerEc.live.config.net.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.innerEc.live.config.net.b) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.innerEc.live.config.net.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.Ug = new com.kwad.components.core.innerEc.live.config.net.i();
        bVar.Ug.parseJson(jSONObject.optJSONObject("webSocketLiveServer"));
        bVar.Uh = new com.kwad.components.core.innerEc.live.config.net.d();
        bVar.Uh.parseJson(jSONObject.optJSONObject("commonData"));
        bVar.Ui = new com.kwad.components.core.innerEc.live.config.net.e();
        bVar.Ui.parseJson(jSONObject.optJSONObject("livePlayData"));
    }

    private static JSONObject b(com.kwad.components.core.innerEc.live.config.net.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.ac.a(jSONObject, "webSocketLiveServer", bVar.Ug);
        com.kwad.sdk.utils.ac.a(jSONObject, "commonData", bVar.Uh);
        com.kwad.sdk.utils.ac.a(jSONObject, "livePlayData", bVar.Ui);
        return jSONObject;
    }
}
