package com.kwad.sdk.core.b.a;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class nz implements com.kwad.sdk.core.d<com.kwad.components.core.webview.tachikoma.c.y> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.webview.tachikoma.c.y) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.webview.tachikoma.c.y) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.webview.tachikoma.c.y yVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        yVar.auA = jSONObject.optString("status");
        if (JSONObject.NULL.toString().equals(yVar.auA)) {
            yVar.auA = "";
        }
        yVar.errorCode = jSONObject.optInt("errorCode");
        yVar.errorReason = jSONObject.optString(HiAnalyticsConstant.HaKey.BI_KEY_ERRORREASON);
        if (JSONObject.NULL.toString().equals(yVar.errorReason)) {
            yVar.errorReason = "";
        }
        yVar.rq = jSONObject.optInt("currentTime");
    }

    private static JSONObject b(com.kwad.components.core.webview.tachikoma.c.y yVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (yVar.auA != null && !yVar.auA.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "status", yVar.auA);
        }
        if (yVar.errorCode != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "errorCode", yVar.errorCode);
        }
        if (yVar.errorReason != null && !yVar.errorReason.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, HiAnalyticsConstant.HaKey.BI_KEY_ERRORREASON, yVar.errorReason);
        }
        if (yVar.rq != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "currentTime", yVar.rq);
        }
        return jSONObject;
    }
}
