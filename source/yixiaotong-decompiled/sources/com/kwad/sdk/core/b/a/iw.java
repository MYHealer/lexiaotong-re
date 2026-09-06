package com.kwad.sdk.core.b.a;

import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class iw implements com.kwad.sdk.core.d<com.kwad.components.core.webview.jshandler.q.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.webview.jshandler.q.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.webview.jshandler.q.a) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.webview.jshandler.q.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.message = jSONObject.optString(CrashHianalyticsData.MESSAGE);
        if (JSONObject.NULL.toString().equals(aVar.message)) {
            aVar.message = "";
        }
    }

    private static JSONObject b(com.kwad.components.core.webview.jshandler.q.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (aVar.message != null && !aVar.message.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, CrashHianalyticsData.MESSAGE, aVar.message);
        }
        return jSONObject;
    }
}
