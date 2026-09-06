package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class ag implements com.kwad.sdk.core.d<AdInfo.AdLiveTypeInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdInfo.AdLiveTypeInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdInfo.AdLiveTypeInfo) bVar, jSONObject);
    }

    private static void a(AdInfo.AdLiveTypeInfo adLiveTypeInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adLiveTypeInfo.actionbarCardType = jSONObject.optInt("actionbarCardType");
    }

    private static JSONObject b(AdInfo.AdLiveTypeInfo adLiveTypeInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (adLiveTypeInfo.actionbarCardType != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "actionbarCardType", adLiveTypeInfo.actionbarCardType);
        }
        return jSONObject;
    }
}
