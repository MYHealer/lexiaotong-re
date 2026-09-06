package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class er implements com.kwad.sdk.core.d<com.kwad.sdk.crash.model.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.crash.model.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.crash.model.b) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.crash.model.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.beD = jSONObject.optInt("funcSwitch");
        bVar.beE = jSONObject.optString("minSdkVersion");
        if (JSONObject.NULL.toString().equals(bVar.beE)) {
            bVar.beE = "";
        }
        bVar.beF = jSONObject.optString("maxSdkVersionExclude");
        if (JSONObject.NULL.toString().equals(bVar.beF)) {
            bVar.beF = "";
        }
        bVar.sdkType = jSONObject.optInt("sdkType");
        bVar.beG = jSONObject.optString("md5V7");
        if (JSONObject.NULL.toString().equals(bVar.beG)) {
            bVar.beG = "";
        }
        bVar.beH = jSONObject.optString("md5V8");
        if (JSONObject.NULL.toString().equals(bVar.beH)) {
            bVar.beH = "";
        }
        bVar.version = jSONObject.optString("version");
        if (JSONObject.NULL.toString().equals(bVar.version)) {
            bVar.version = "";
        }
        bVar.beI = jSONObject.optString("v7Url");
        if (JSONObject.NULL.toString().equals(bVar.beI)) {
            bVar.beI = "";
        }
        bVar.beJ = jSONObject.optString("v8Url");
        if (JSONObject.NULL.toString().equals(bVar.beJ)) {
            bVar.beJ = "";
        }
    }

    private static JSONObject b(com.kwad.sdk.crash.model.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (bVar.beD != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "funcSwitch", bVar.beD);
        }
        if (bVar.beE != null && !bVar.beE.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "minSdkVersion", bVar.beE);
        }
        if (bVar.beF != null && !bVar.beF.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "maxSdkVersionExclude", bVar.beF);
        }
        if (bVar.sdkType != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "sdkType", bVar.sdkType);
        }
        if (bVar.beG != null && !bVar.beG.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "md5V7", bVar.beG);
        }
        if (bVar.beH != null && !bVar.beH.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "md5V8", bVar.beH);
        }
        if (bVar.version != null && !bVar.version.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "version", bVar.version);
        }
        if (bVar.beI != null && !bVar.beI.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "v7Url", bVar.beI);
        }
        if (bVar.beJ != null && !bVar.beJ.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "v8Url", bVar.beJ);
        }
        return jSONObject;
    }
}
