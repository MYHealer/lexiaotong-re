package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdStyleInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class l implements com.kwad.sdk.core.d<AdStyleInfo.AdBrowseInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdStyleInfo.AdBrowseInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdStyleInfo.AdBrowseInfo) bVar, jSONObject);
    }

    private static void a(AdStyleInfo.AdBrowseInfo adBrowseInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adBrowseInfo.enableAdBrowse = jSONObject.optInt("enableAdBrowse");
        adBrowseInfo.adBrowseDuration = jSONObject.optInt("adBrowseDuration");
        adBrowseInfo.rewardDescription = jSONObject.optString("rewardDescription");
        if (JSONObject.NULL.toString().equals(adBrowseInfo.rewardDescription)) {
            adBrowseInfo.rewardDescription = "";
        }
    }

    private static JSONObject b(AdStyleInfo.AdBrowseInfo adBrowseInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (adBrowseInfo.enableAdBrowse != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "enableAdBrowse", adBrowseInfo.enableAdBrowse);
        }
        if (adBrowseInfo.adBrowseDuration != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "adBrowseDuration", adBrowseInfo.adBrowseDuration);
        }
        if (adBrowseInfo.rewardDescription != null && !adBrowseInfo.rewardDescription.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "rewardDescription", adBrowseInfo.rewardDescription);
        }
        return jSONObject;
    }
}
