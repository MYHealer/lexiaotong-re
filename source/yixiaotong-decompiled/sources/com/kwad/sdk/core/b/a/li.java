package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class li implements com.kwad.sdk.core.d<com.kwad.components.core.innerEc.live.base.e> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.innerEc.live.base.e) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.innerEc.live.base.e) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.innerEc.live.base.e eVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        eVar.Tz = jSONObject.optBoolean("showYellowCart");
        eVar.TA = jSONObject.optInt("onSaleCount");
    }

    private static JSONObject b(com.kwad.components.core.innerEc.live.base.e eVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (eVar.Tz) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "showYellowCart", eVar.Tz);
        }
        if (eVar.TA != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "onSaleCount", eVar.TA);
        }
        return jSONObject;
    }
}
