package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class ew implements com.kwad.sdk.core.d<com.kwad.sdk.crash.online.monitor.a.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.crash.online.monitor.a.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.crash.online.monitor.a.b) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.crash.online.monitor.a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.appId = jSONObject.optString("appId");
        if (JSONObject.NULL.toString().equals(bVar.appId)) {
            bVar.appId = "";
        }
        bVar.bfw = jSONObject.optString("pluginListenerName");
        if (JSONObject.NULL.toString().equals(bVar.bfw)) {
            bVar.bfw = "";
        }
        bVar.bfx = jSONObject.optString("reportMethodName");
        if (JSONObject.NULL.toString().equals(bVar.bfx)) {
            bVar.bfx = "";
        }
        bVar.bfy = jSONObject.optString("otherProxyClassName");
        if (JSONObject.NULL.toString().equals(bVar.bfy)) {
            bVar.bfy = "";
        }
        bVar.bfz = jSONObject.optString("otherFieldName");
        if (JSONObject.NULL.toString().equals(bVar.bfz)) {
            bVar.bfz = "";
        }
        bVar.bfA = jSONObject.optString("otherLevelFieldName");
        if (JSONObject.NULL.toString().equals(bVar.bfA)) {
            bVar.bfA = "";
        }
        bVar.bfB = jSONObject.optString("blockTag");
        if (JSONObject.NULL.toString().equals(bVar.bfB)) {
            bVar.bfB = "";
        }
    }

    private static JSONObject b(com.kwad.sdk.crash.online.monitor.a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (bVar.appId != null && !bVar.appId.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "appId", bVar.appId);
        }
        if (bVar.bfw != null && !bVar.bfw.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "pluginListenerName", bVar.bfw);
        }
        if (bVar.bfx != null && !bVar.bfx.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "reportMethodName", bVar.bfx);
        }
        if (bVar.bfy != null && !bVar.bfy.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "otherProxyClassName", bVar.bfy);
        }
        if (bVar.bfz != null && !bVar.bfz.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "otherFieldName", bVar.bfz);
        }
        if (bVar.bfA != null && !bVar.bfA.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "otherLevelFieldName", bVar.bfA);
        }
        if (bVar.bfB != null && !bVar.bfB.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "blockTag", bVar.bfB);
        }
        return jSONObject;
    }
}
