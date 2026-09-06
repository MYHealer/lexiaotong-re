package com.kwad.sdk.core.b.a;

import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class nj implements com.kwad.sdk.core.d<com.kwad.components.ad.h.a.a.b.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.ad.h.a.a.b.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.ad.h.a.a.b.a) bVar, jSONObject);
    }

    private static void a(com.kwad.components.ad.h.a.a.b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.rn = jSONObject.optInt("timerName");
        aVar.ro = jSONObject.optInt(CrashHianalyticsData.TIME);
    }

    private static JSONObject b(com.kwad.components.ad.h.a.a.b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (aVar.rn != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "timerName", aVar.rn);
        }
        if (aVar.ro != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, CrashHianalyticsData.TIME, aVar.ro);
        }
        return jSONObject;
    }
}
