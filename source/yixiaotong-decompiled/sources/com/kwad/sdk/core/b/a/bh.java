package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class bh implements com.kwad.sdk.core.d<com.kwad.sdk.m.a.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.m.a.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.m.a.b) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.m.a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.bnf = jSONObject.optString("nodeClassName");
        if (JSONObject.NULL.toString().equals(bVar.bnf)) {
            bVar.bnf = "";
        }
        bVar.bng = jSONObject.optString("childFieldName");
        if (JSONObject.NULL.toString().equals(bVar.bng)) {
            bVar.bng = "";
        }
        bVar.bnh = jSONObject.optBoolean("childFieldIsStatic");
        bVar.bni = jSONObject.optString("reportKey");
        if (JSONObject.NULL.toString().equals(bVar.bni)) {
            bVar.bni = "";
        }
        bVar.bnj = new com.kwad.sdk.m.a.b.C0762b();
        bVar.bnj.parseJson(jSONObject.optJSONObject("childMethod"));
        bVar.bnk = new com.kwad.sdk.m.a.b();
        bVar.bnk.parseJson(jSONObject.optJSONObject("deepNode"));
    }

    private static JSONObject b(com.kwad.sdk.m.a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (bVar.bnf != null && !bVar.bnf.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "nodeClassName", bVar.bnf);
        }
        if (bVar.bng != null && !bVar.bng.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "childFieldName", bVar.bng);
        }
        if (bVar.bnh) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "childFieldIsStatic", bVar.bnh);
        }
        if (bVar.bni != null && !bVar.bni.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "reportKey", bVar.bni);
        }
        com.kwad.sdk.utils.ac.a(jSONObject, "childMethod", bVar.bnj);
        com.kwad.sdk.utils.ac.a(jSONObject, "deepNode", bVar.bnk);
        return jSONObject;
    }
}
