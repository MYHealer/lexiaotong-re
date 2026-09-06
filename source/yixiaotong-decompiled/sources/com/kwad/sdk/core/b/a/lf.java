package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class lf implements com.kwad.sdk.core.d<AdMatrixInfo.RotateInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdMatrixInfo.RotateInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdMatrixInfo.RotateInfo) bVar, jSONObject);
    }

    private static void a(AdMatrixInfo.RotateInfo rotateInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        rotateInfo.title = jSONObject.optString("title");
        if (JSONObject.NULL.toString().equals(rotateInfo.title)) {
            rotateInfo.title = "";
        }
        rotateInfo.subTitle = jSONObject.optString("subTitle");
        if (JSONObject.NULL.toString().equals(rotateInfo.subTitle)) {
            rotateInfo.subTitle = "";
        }
        rotateInfo.downloadTexts = new AdMatrixInfo.DownloadTexts();
        rotateInfo.downloadTexts.parseJson(jSONObject.optJSONObject("downloadTexts"));
        rotateInfo.x = new AdMatrixInfo.RotateDegreeInfo();
        rotateInfo.x.parseJson(jSONObject.optJSONObject("x"));
        rotateInfo.y = new AdMatrixInfo.RotateDegreeInfo();
        rotateInfo.y.parseJson(jSONObject.optJSONObject("y"));
        rotateInfo.z = new AdMatrixInfo.RotateDegreeInfo();
        rotateInfo.z.parseJson(jSONObject.optJSONObject(com.umeng.analytics.pro.am.aD));
        rotateInfo.enable = jSONObject.optBoolean("enable");
        rotateInfo.bidirectionalSwitch = jSONObject.optBoolean("bidirectionalSwitch");
    }

    private static JSONObject b(AdMatrixInfo.RotateInfo rotateInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (rotateInfo.title != null && !rotateInfo.title.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "title", rotateInfo.title);
        }
        if (rotateInfo.subTitle != null && !rotateInfo.subTitle.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "subTitle", rotateInfo.subTitle);
        }
        com.kwad.sdk.utils.ac.a(jSONObject, "downloadTexts", rotateInfo.downloadTexts);
        com.kwad.sdk.utils.ac.a(jSONObject, "x", rotateInfo.x);
        com.kwad.sdk.utils.ac.a(jSONObject, "y", rotateInfo.y);
        com.kwad.sdk.utils.ac.a(jSONObject, com.umeng.analytics.pro.am.aD, rotateInfo.z);
        if (rotateInfo.enable) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "enable", rotateInfo.enable);
        }
        if (rotateInfo.bidirectionalSwitch) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "bidirectionalSwitch", rotateInfo.bidirectionalSwitch);
        }
        return jSONObject;
    }
}
