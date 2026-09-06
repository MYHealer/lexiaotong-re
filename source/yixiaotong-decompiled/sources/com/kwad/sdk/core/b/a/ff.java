package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class ff implements com.kwad.sdk.core.d<com.kwad.components.core.innerEc.followuser.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.innerEc.followuser.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.innerEc.followuser.b) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.innerEc.followuser.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.Ti = jSONObject.optString(com.huawei.openalliance.ad.constant.ba.r);
        if (JSONObject.NULL.toString().equals(bVar.Ti)) {
            bVar.Ti = "";
        }
        bVar.Tj = jSONObject.optBoolean("following");
    }

    private static JSONObject b(com.kwad.components.core.innerEc.followuser.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (bVar.Ti != null && !bVar.Ti.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, com.huawei.openalliance.ad.constant.ba.r, bVar.Ti);
        }
        if (bVar.Tj) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "following", bVar.Tj);
        }
        return jSONObject;
    }
}
