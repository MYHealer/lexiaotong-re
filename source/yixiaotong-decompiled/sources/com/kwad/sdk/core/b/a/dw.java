package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdStyleInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class dw implements com.kwad.sdk.core.d<AdStyleInfo.PlayDetailInfo.DetailTopToolBarInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdStyleInfo.PlayDetailInfo.DetailTopToolBarInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdStyleInfo.PlayDetailInfo.DetailTopToolBarInfo) bVar, jSONObject);
    }

    private static void a(AdStyleInfo.PlayDetailInfo.DetailTopToolBarInfo detailTopToolBarInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        detailTopToolBarInfo.callButtonShowTime = jSONObject.optLong("callButtonShowTime");
        detailTopToolBarInfo.callButtonDescription = jSONObject.optString("callButtonDescription");
        if (JSONObject.NULL.toString().equals(detailTopToolBarInfo.callButtonDescription)) {
            detailTopToolBarInfo.callButtonDescription = "";
        }
        detailTopToolBarInfo.rewardIconUrl = jSONObject.optString("rewardIconUrl");
        if (JSONObject.NULL.toString().equals(detailTopToolBarInfo.rewardIconUrl)) {
            detailTopToolBarInfo.rewardIconUrl = "";
        }
        detailTopToolBarInfo.rewardCallDescription = jSONObject.optString("rewardCallDescription");
        if (JSONObject.NULL.toString().equals(detailTopToolBarInfo.rewardCallDescription)) {
            detailTopToolBarInfo.rewardCallDescription = "";
        }
        detailTopToolBarInfo.style = jSONObject.optInt("style");
        detailTopToolBarInfo.maxTimeOut = jSONObject.optLong("maxTimeOut");
    }

    private static JSONObject b(AdStyleInfo.PlayDetailInfo.DetailTopToolBarInfo detailTopToolBarInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (detailTopToolBarInfo.callButtonShowTime != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "callButtonShowTime", detailTopToolBarInfo.callButtonShowTime);
        }
        if (detailTopToolBarInfo.callButtonDescription != null && !detailTopToolBarInfo.callButtonDescription.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "callButtonDescription", detailTopToolBarInfo.callButtonDescription);
        }
        if (detailTopToolBarInfo.rewardIconUrl != null && !detailTopToolBarInfo.rewardIconUrl.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "rewardIconUrl", detailTopToolBarInfo.rewardIconUrl);
        }
        if (detailTopToolBarInfo.rewardCallDescription != null && !detailTopToolBarInfo.rewardCallDescription.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "rewardCallDescription", detailTopToolBarInfo.rewardCallDescription);
        }
        if (detailTopToolBarInfo.style != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "style", detailTopToolBarInfo.style);
        }
        if (detailTopToolBarInfo.maxTimeOut != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "maxTimeOut", detailTopToolBarInfo.maxTimeOut);
        }
        return jSONObject;
    }
}
