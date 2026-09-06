package com.kwad.sdk.core.b.a;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class nl implements com.kwad.sdk.core.d<com.kwad.sdk.commercial.i.a.C0731a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.commercial.i.a.C0731a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.commercial.i.a.C0731a) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.commercial.i.a.C0731a c0731a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0731a.aKH = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("blackList");
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                c0731a.aKH.add((String) jSONArrayOptJSONArray.opt(i));
            }
        }
    }

    private static JSONObject b(com.kwad.sdk.commercial.i.a.C0731a c0731a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.ac.putValue(jSONObject, "blackList", c0731a.aKH);
        return jSONObject;
    }
}
