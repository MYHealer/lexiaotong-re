package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class jf implements com.kwad.sdk.core.d<AdMatrixInfo.NativeMatrixAdInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdMatrixInfo.NativeMatrixAdInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdMatrixInfo.NativeMatrixAdInfo) bVar, jSONObject);
    }

    private static void a(AdMatrixInfo.NativeMatrixAdInfo nativeMatrixAdInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        nativeMatrixAdInfo.interactionInfo = new AdMatrixInfo.AdInteractionInfo();
        nativeMatrixAdInfo.interactionInfo.parseJson(jSONObject.optJSONObject("interactionInfo"));
    }

    private static JSONObject b(AdMatrixInfo.NativeMatrixAdInfo nativeMatrixAdInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.ac.a(jSONObject, "interactionInfo", nativeMatrixAdInfo.interactionInfo);
        return jSONObject;
    }
}
