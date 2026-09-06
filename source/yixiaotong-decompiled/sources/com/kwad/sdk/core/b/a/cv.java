package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class cv implements com.kwad.sdk.core.d<AdInfo.ComplianceInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdInfo.ComplianceInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdInfo.ComplianceInfo) bVar, jSONObject);
    }

    private static void a(AdInfo.ComplianceInfo complianceInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        complianceInfo.materialJumpType = jSONObject.optInt("materialJumpType");
        complianceInfo.actionBarType = jSONObject.optInt("actionBarType");
        complianceInfo.describeBarType = jSONObject.optInt("describeBarType");
        complianceInfo.titleBarTextSwitch = jSONObject.optInt("titleBarTextSwitch");
    }

    private static JSONObject b(AdInfo.ComplianceInfo complianceInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (complianceInfo.materialJumpType != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "materialJumpType", complianceInfo.materialJumpType);
        }
        if (complianceInfo.actionBarType != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "actionBarType", complianceInfo.actionBarType);
        }
        if (complianceInfo.describeBarType != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "describeBarType", complianceInfo.describeBarType);
        }
        if (complianceInfo.titleBarTextSwitch != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "titleBarTextSwitch", complianceInfo.titleBarTextSwitch);
        }
        return jSONObject;
    }
}
