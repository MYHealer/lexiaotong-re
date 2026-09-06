package com.kwad.sdk.core.b.a;

import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class ls implements com.kwad.sdk.core.d<com.kwad.components.core.webview.tachikoma.c.t> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.webview.tachikoma.c.t) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.webview.tachikoma.c.t) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.webview.tachikoma.c.t tVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        tVar.message = jSONObject.optString(CrashHianalyticsData.MESSAGE);
        if (JSONObject.NULL.toString().equals(tVar.message)) {
            tVar.message = "";
        }
    }

    private static JSONObject b(com.kwad.components.core.webview.tachikoma.c.t tVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (tVar.message != null && !tVar.message.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, CrashHianalyticsData.MESSAGE, tVar.message);
        }
        return jSONObject;
    }
}
