package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class en implements com.kwad.sdk.core.d<AdMatrixInfo.EndCardInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdMatrixInfo.EndCardInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdMatrixInfo.EndCardInfo) bVar, jSONObject);
    }

    private static void a(AdMatrixInfo.EndCardInfo endCardInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        endCardInfo.cardShowPlayCount = jSONObject.optInt("cardShowPlayCount");
        endCardInfo.cardType = jSONObject.optInt("cardType");
    }

    private static JSONObject b(AdMatrixInfo.EndCardInfo endCardInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (endCardInfo.cardShowPlayCount != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "cardShowPlayCount", endCardInfo.cardShowPlayCount);
        }
        if (endCardInfo.cardType != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "cardType", endCardInfo.cardType);
        }
        return jSONObject;
    }
}
