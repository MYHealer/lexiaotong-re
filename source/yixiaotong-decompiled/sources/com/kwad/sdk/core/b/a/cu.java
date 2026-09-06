package com.kwad.sdk.core.b.a;

import com.opos.mobad.activity.VideoActivity;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class cu implements com.kwad.sdk.core.d<com.kwad.components.core.webview.tachikoma.c.g> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.webview.tachikoma.c.g) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.webview.tachikoma.c.g) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.webview.tachikoma.c.g gVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        gVar.QY = jSONObject.optString("payload");
        if (JSONObject.NULL.toString().equals(gVar.QY)) {
            gVar.QY = "";
        }
        gVar.actionType = jSONObject.optInt(VideoActivity.EXTRA_KEY_ACTION_TYPE);
        gVar.apo = jSONObject.optInt("adCacheId");
        gVar.PC = jSONObject.optString("creativeId");
        if (JSONObject.NULL.toString().equals(gVar.PC)) {
            gVar.PC = "";
        }
    }

    private static JSONObject b(com.kwad.components.core.webview.tachikoma.c.g gVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (gVar.QY != null && !gVar.QY.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "payload", gVar.QY);
        }
        if (gVar.actionType != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, VideoActivity.EXTRA_KEY_ACTION_TYPE, gVar.actionType);
        }
        if (gVar.apo != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "adCacheId", gVar.apo);
        }
        if (gVar.PC != null && !gVar.PC.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "creativeId", gVar.PC);
        }
        return jSONObject;
    }
}
