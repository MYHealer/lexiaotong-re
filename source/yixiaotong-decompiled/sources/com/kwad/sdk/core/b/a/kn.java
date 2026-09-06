package com.kwad.sdk.core.b.a;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class kn implements com.kwad.sdk.core.d<com.kwad.sdk.m.b.a.c> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.m.b.a.c) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.m.b.a.c) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.m.b.a.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        cVar.aYH = jSONObject.optInt("func_ratio_count");
        cVar.bnB = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("func_values");
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                com.kwad.sdk.m.b.a.b bVar = new com.kwad.sdk.m.b.a.b();
                bVar.parseJson(jSONArrayOptJSONArray.optJSONObject(i));
                cVar.bnB.add(bVar);
            }
        }
    }

    private static JSONObject b(com.kwad.sdk.m.b.a.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (cVar.aYH != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "func_ratio_count", cVar.aYH);
        }
        com.kwad.sdk.utils.ac.putValue(jSONObject, "func_values", cVar.bnB);
        return jSONObject;
    }
}
