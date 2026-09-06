package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class dp implements com.kwad.sdk.core.d<AdInfo.CutRuleInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdInfo.CutRuleInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdInfo.CutRuleInfo) bVar, jSONObject);
    }

    private static void a(AdInfo.CutRuleInfo cutRuleInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        cutRuleInfo.picHeight = jSONObject.optInt("picHeight");
        cutRuleInfo.viewTopMargin = jSONObject.optInt("viewTopMargin");
        cutRuleInfo.safeAreaHeight = jSONObject.optInt("safeAreaHeight");
    }

    private static JSONObject b(AdInfo.CutRuleInfo cutRuleInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (cutRuleInfo.picHeight != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "picHeight", cutRuleInfo.picHeight);
        }
        if (cutRuleInfo.viewTopMargin != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "viewTopMargin", cutRuleInfo.viewTopMargin);
        }
        if (cutRuleInfo.safeAreaHeight != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "safeAreaHeight", cutRuleInfo.safeAreaHeight);
        }
        return jSONObject;
    }
}
