package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class by implements com.kwad.sdk.core.d<com.kwad.components.ad.c.c.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.ad.c.c.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.ad.c.c.a) bVar, jSONObject);
    }

    private static void a(com.kwad.components.ad.c.c.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.cO = jSONObject.optInt("call_back_type");
        aVar.renderType = jSONObject.optInt(com.hihonor.adsdk.base.g.j.e.a.S0);
        aVar.cP = jSONObject.optInt("expect_render_type");
    }

    private static JSONObject b(com.kwad.components.ad.c.c.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (aVar.cO != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "call_back_type", aVar.cO);
        }
        if (aVar.renderType != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, com.hihonor.adsdk.base.g.j.e.a.S0, aVar.renderType);
        }
        if (aVar.cP != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "expect_render_type", aVar.cP);
        }
        return jSONObject;
    }
}
