package com.kwad.sdk.core.b.a;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class ch implements com.kwad.sdk.core.d<com.kwad.sdk.crash.online.monitor.block.d> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.crash.online.monitor.block.d) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.crash.online.monitor.block.d) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.crash.online.monitor.block.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        dVar.bff = jSONObject.optString("printerName");
        if (JSONObject.NULL.toString().equals(dVar.bff)) {
            dVar.bff = "";
        }
        dVar.errorMsg = jSONObject.optString(MediationConstant.KEY_ERROR_MSG);
        if (JSONObject.NULL.toString().equals(dVar.errorMsg)) {
            dVar.errorMsg = "";
        }
        dVar.bfg = jSONObject.optBoolean("isDisable");
        dVar.bfh = jSONObject.optBoolean("hasMatrix");
    }

    private static JSONObject b(com.kwad.sdk.crash.online.monitor.block.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (dVar.bff != null && !dVar.bff.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "printerName", dVar.bff);
        }
        if (dVar.errorMsg != null && !dVar.errorMsg.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, MediationConstant.KEY_ERROR_MSG, dVar.errorMsg);
        }
        if (dVar.bfg) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "isDisable", dVar.bfg);
        }
        if (dVar.bfh) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "hasMatrix", dVar.bfh);
        }
        return jSONObject;
    }
}
