package com.kwad.sdk.core.b.a;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class nb implements com.kwad.sdk.core.d<com.kwad.sdk.m.a.b.C0762b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.m.a.b.C0762b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.m.a.b.C0762b) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.m.a.b.C0762b c0762b, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0762b.name = jSONObject.optString("name");
        if (JSONObject.NULL.toString().equals(c0762b.name)) {
            c0762b.name = "";
        }
        c0762b.bns = jSONObject.optBoolean("isStatic");
        c0762b.bnt = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("paramList");
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                com.kwad.sdk.m.a.b.a aVar = new com.kwad.sdk.m.a.b.a();
                aVar.parseJson(jSONArrayOptJSONArray.optJSONObject(i));
                c0762b.bnt.add(aVar);
            }
        }
    }

    private static JSONObject b(com.kwad.sdk.m.a.b.C0762b c0762b, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (c0762b.name != null && !c0762b.name.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "name", c0762b.name);
        }
        if (c0762b.bns) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "isStatic", c0762b.bns);
        }
        com.kwad.sdk.utils.ac.putValue(jSONObject, "paramList", c0762b.bnt);
        return jSONObject;
    }
}
