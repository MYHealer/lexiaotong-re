package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class hb implements com.kwad.sdk.core.d<AdMatrixInfo.InterstitialCardInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdMatrixInfo.InterstitialCardInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdMatrixInfo.InterstitialCardInfo) bVar, jSONObject);
    }

    private static void a(AdMatrixInfo.InterstitialCardInfo interstitialCardInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        interstitialCardInfo.interactionInfo = new AdMatrixInfo.AdInteractionInfo();
        interstitialCardInfo.interactionInfo.parseJson(jSONObject.optJSONObject("interactionInfo"));
        interstitialCardInfo.cycleAggregateInfo = new AdMatrixInfo.CycleAggregateInfo();
        interstitialCardInfo.cycleAggregateInfo.parseJson(jSONObject.optJSONObject("cycleAggregateInfo"));
        interstitialCardInfo.closeAfterClick = jSONObject.optBoolean("closeAfterClick", new Boolean(com.huawei.hms.ads.ez.V).booleanValue());
    }

    private static JSONObject b(AdMatrixInfo.InterstitialCardInfo interstitialCardInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.ac.a(jSONObject, "interactionInfo", interstitialCardInfo.interactionInfo);
        com.kwad.sdk.utils.ac.a(jSONObject, "cycleAggregateInfo", interstitialCardInfo.cycleAggregateInfo);
        com.kwad.sdk.utils.ac.putValue(jSONObject, "closeAfterClick", interstitialCardInfo.closeAfterClick);
        return jSONObject;
    }
}
