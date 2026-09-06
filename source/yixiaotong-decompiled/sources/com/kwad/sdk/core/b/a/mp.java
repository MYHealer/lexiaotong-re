package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class mp implements com.kwad.sdk.core.d<com.kwad.sdk.wrapper.l.a.C0772a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.wrapper.l.a.C0772a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.wrapper.l.a.C0772a) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.wrapper.l.a.C0772a c0772a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0772a.buh = jSONObject.optString("s_cn");
        if (JSONObject.NULL.toString().equals(c0772a.buh)) {
            c0772a.buh = "";
        }
        c0772a.bui = jSONObject.optString("s_mn");
        if (JSONObject.NULL.toString().equals(c0772a.bui)) {
            c0772a.bui = "";
        }
    }

    private static JSONObject b(com.kwad.sdk.wrapper.l.a.C0772a c0772a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (c0772a.buh != null && !c0772a.buh.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "s_cn", c0772a.buh);
        }
        if (c0772a.bui != null && !c0772a.bui.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "s_mn", c0772a.bui);
        }
        return jSONObject;
    }
}
