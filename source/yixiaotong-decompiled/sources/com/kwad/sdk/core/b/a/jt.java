package com.kwad.sdk.core.b.a;

import cz.msebera.android.httpclient.client.cache.HeaderConstants;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class jt implements com.kwad.sdk.core.d<com.kwad.sdk.h.a.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.h.a.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.h.a.b) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.h.a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.bgG = jSONObject.optString("packageId");
        if (JSONObject.NULL.toString().equals(bVar.bgG)) {
            bVar.bgG = "";
        }
        bVar.bgH = jSONObject.optString("zipFileName");
        if (JSONObject.NULL.toString().equals(bVar.bgH)) {
            bVar.bgH = "";
        }
        bVar.bgI = jSONObject.optString("zipPath");
        if (JSONObject.NULL.toString().equals(bVar.bgI)) {
            bVar.bgI = "";
        }
        bVar.packageUrl = jSONObject.optString("packageUrl");
        if (JSONObject.NULL.toString().equals(bVar.packageUrl)) {
            bVar.packageUrl = "";
        }
        bVar.version = jSONObject.optString("version");
        if (JSONObject.NULL.toString().equals(bVar.version)) {
            bVar.version = "";
        }
        bVar.aEX = jSONObject.optString("checksum");
        if (JSONObject.NULL.toString().equals(bVar.aEX)) {
            bVar.aEX = "";
        }
        bVar.loadType = jSONObject.optInt("loadType");
        bVar.packageType = jSONObject.optInt("packageType");
        bVar.bgK = jSONObject.optBoolean(HeaderConstants.PUBLIC);
    }

    private static JSONObject b(com.kwad.sdk.h.a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (bVar.bgG != null && !bVar.bgG.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "packageId", bVar.bgG);
        }
        if (bVar.bgH != null && !bVar.bgH.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "zipFileName", bVar.bgH);
        }
        if (bVar.bgI != null && !bVar.bgI.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "zipPath", bVar.bgI);
        }
        if (bVar.packageUrl != null && !bVar.packageUrl.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "packageUrl", bVar.packageUrl);
        }
        if (bVar.version != null && !bVar.version.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "version", bVar.version);
        }
        if (bVar.aEX != null && !bVar.aEX.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "checksum", bVar.aEX);
        }
        if (bVar.loadType != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "loadType", bVar.loadType);
        }
        if (bVar.packageType != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "packageType", bVar.packageType);
        }
        if (bVar.bgK) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, HeaderConstants.PUBLIC, bVar.bgK);
        }
        return jSONObject;
    }
}
