package com.kwad.sdk.core.b.a;

import com.yfanads.android.libs.net.UrlConst;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class ep implements com.kwad.sdk.core.d<com.kwad.sdk.core.report.j> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.core.report.j) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.core.report.j) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.core.report.j jVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        jVar.aVq = jSONObject.optString(UrlConst.LOG);
        if (JSONObject.NULL.toString().equals(jVar.aVq)) {
            jVar.aVq = "";
        }
    }

    private static JSONObject b(com.kwad.sdk.core.report.j jVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (jVar.aVq != null && !jVar.aVq.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, UrlConst.LOG, jVar.aVq);
        }
        return jSONObject;
    }
}
