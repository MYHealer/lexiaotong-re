package com.kwad.sdk.core.b.a;

import com.kwad.components.ad.adbit.AdBid;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class k implements com.kwad.sdk.core.d<AdBid> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdBid) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdBid) bVar, jSONObject);
    }

    private static void a(AdBid adBid, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adBid.creativeId = jSONObject.optLong("creativeId");
        adBid.ecpm = jSONObject.optLong("ecpm");
        adBid.bidEcpm = jSONObject.optInt("bidEcpm");
        adBid.winNoticeUrl = jSONObject.optString("winNoticeUrl");
        if (JSONObject.NULL.toString().equals(adBid.winNoticeUrl)) {
            adBid.winNoticeUrl = "";
        }
        adBid.materialId = jSONObject.optString("materialId");
        if (JSONObject.NULL.toString().equals(adBid.materialId)) {
            adBid.materialId = "";
        }
    }

    private static JSONObject b(AdBid adBid, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (adBid.creativeId != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "creativeId", adBid.creativeId);
        }
        if (adBid.ecpm != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "ecpm", adBid.ecpm);
        }
        if (adBid.bidEcpm != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "bidEcpm", adBid.bidEcpm);
        }
        if (adBid.winNoticeUrl != null && !adBid.winNoticeUrl.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "winNoticeUrl", adBid.winNoticeUrl);
        }
        if (adBid.materialId != null && !adBid.materialId.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "materialId", adBid.materialId);
        }
        return jSONObject;
    }
}
