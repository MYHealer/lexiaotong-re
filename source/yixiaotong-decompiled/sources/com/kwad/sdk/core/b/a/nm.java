package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.scene.URLPackage;
import cz.msebera.android.httpclient.protocol.HTTP;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class nm implements com.kwad.sdk.core.d<URLPackage> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((URLPackage) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((URLPackage) bVar, jSONObject);
    }

    private static void a(URLPackage uRLPackage, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        uRLPackage.page = jSONObject.optInt("page");
        uRLPackage.identity = jSONObject.optString(HTTP.IDENTITY_CODING);
        if (JSONObject.NULL.toString().equals(uRLPackage.identity)) {
            uRLPackage.identity = "";
        }
    }

    private static JSONObject b(URLPackage uRLPackage, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (uRLPackage.page != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "page", uRLPackage.page);
        }
        if (uRLPackage.identity != null && !uRLPackage.identity.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, HTTP.IDENTITY_CODING, uRLPackage.identity);
        }
        return jSONObject;
    }
}
