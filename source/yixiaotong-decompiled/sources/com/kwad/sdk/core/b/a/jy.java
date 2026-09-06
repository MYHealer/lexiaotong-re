package com.kwad.sdk.core.b.a;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class jy implements com.kwad.sdk.core.d<com.kwad.sdk.m.a.b.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.m.a.b.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.m.a.b.a) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.m.a.b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.bnl = jSONObject.optString("typeStr");
        if (JSONObject.NULL.toString().equals(aVar.bnl)) {
            aVar.bnl = "";
        }
        aVar.bnm = jSONObject.optString("valueStr");
        if (JSONObject.NULL.toString().equals(aVar.bnm)) {
            aVar.bnm = "";
        }
        aVar.bnn = jSONObject.optString("listValueType");
        if (JSONObject.NULL.toString().equals(aVar.bnn)) {
            aVar.bnn = "";
        }
        aVar.bno = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("valueStrList");
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                aVar.bno.add((String) jSONArrayOptJSONArray.opt(i));
            }
        }
        aVar.fieldName = jSONObject.optString("fieldName");
        if (JSONObject.NULL.toString().equals(aVar.fieldName)) {
            aVar.fieldName = "";
        }
        aVar.className = jSONObject.optString("className");
        if (JSONObject.NULL.toString().equals(aVar.className)) {
            aVar.className = "";
        }
        aVar.bnp = new ArrayList();
        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("childParamList");
        if (jSONArrayOptJSONArray2 != null) {
            for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                com.kwad.sdk.m.a.b.a aVar2 = new com.kwad.sdk.m.a.b.a();
                aVar2.parseJson(jSONArrayOptJSONArray2.optJSONObject(i2));
                aVar.bnp.add(aVar2);
            }
        }
    }

    private static JSONObject b(com.kwad.sdk.m.a.b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (aVar.bnl != null && !aVar.bnl.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "typeStr", aVar.bnl);
        }
        if (aVar.bnm != null && !aVar.bnm.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "valueStr", aVar.bnm);
        }
        if (aVar.bnn != null && !aVar.bnn.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "listValueType", aVar.bnn);
        }
        com.kwad.sdk.utils.ac.putValue(jSONObject, "valueStrList", aVar.bno);
        if (aVar.fieldName != null && !aVar.fieldName.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "fieldName", aVar.fieldName);
        }
        if (aVar.className != null && !aVar.className.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "className", aVar.className);
        }
        com.kwad.sdk.utils.ac.putValue(jSONObject, "childParamList", aVar.bnp);
        return jSONObject;
    }
}
