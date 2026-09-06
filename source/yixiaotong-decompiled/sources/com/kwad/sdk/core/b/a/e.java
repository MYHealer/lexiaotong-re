package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class e implements com.kwad.sdk.core.d<com.kwad.sdk.core.webview.d.b.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.core.webview.d.b.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.core.webview.d.b.a) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.core.webview.d.b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.aqY = jSONObject.optBoolean("clickActionButton");
        aVar.ara = jSONObject.optInt("area");
        aVar.nm = jSONObject.optInt("itemClickType");
        aVar.bdg = jSONObject.optInt("convertPageType", new Integer("-1").intValue());
        aVar.arb = new com.kwad.sdk.core.webview.d.b.d();
        aVar.arb.parseJson(jSONObject.optJSONObject("logParam"));
        aVar.needReport = jSONObject.optBoolean("needReport", new Boolean(com.huawei.hms.ads.ez.Code).booleanValue());
        aVar.creativeId = jSONObject.optLong("creativeId", new Long("-1").longValue());
        aVar.Rk = jSONObject.optString("liveItemId");
        if (JSONObject.NULL.toString().equals(aVar.Rk)) {
            aVar.Rk = "";
        }
        aVar.bdh = jSONObject.optInt("sceneType");
        aVar.adStyle = jSONObject.optInt("adStyle", new Integer("-1").intValue());
        aVar.bdi = jSONObject.optBoolean("isCallbackOnly");
        aVar.bdj = jSONObject.optBoolean("disableCallback");
    }

    private static JSONObject b(com.kwad.sdk.core.webview.d.b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (aVar.aqY) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "clickActionButton", aVar.aqY);
        }
        if (aVar.ara != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "area", aVar.ara);
        }
        if (aVar.nm != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "itemClickType", aVar.nm);
        }
        com.kwad.sdk.utils.ac.putValue(jSONObject, "convertPageType", aVar.bdg);
        com.kwad.sdk.utils.ac.a(jSONObject, "logParam", aVar.arb);
        com.kwad.sdk.utils.ac.putValue(jSONObject, "needReport", aVar.needReport);
        com.kwad.sdk.utils.ac.putValue(jSONObject, "creativeId", aVar.creativeId);
        if (aVar.Rk != null && !aVar.Rk.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "liveItemId", aVar.Rk);
        }
        if (aVar.bdh != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "sceneType", aVar.bdh);
        }
        com.kwad.sdk.utils.ac.putValue(jSONObject, "adStyle", aVar.adStyle);
        if (aVar.bdi) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "isCallbackOnly", aVar.bdi);
        }
        if (aVar.bdj) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "disableCallback", aVar.bdj);
        }
        return jSONObject;
    }
}
