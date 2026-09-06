package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class cs implements com.kwad.sdk.core.d<com.kwad.components.ad.reward.h.c> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.ad.reward.h.c) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.ad.reward.h.c) bVar, jSONObject);
    }

    private static void a(com.kwad.components.ad.reward.h.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        cVar.style = jSONObject.optInt("style");
        cVar.title = jSONObject.optString("title");
        if (JSONObject.NULL.toString().equals(cVar.title)) {
            cVar.title = "";
        }
        cVar.tP = jSONObject.optString("closeBtnText");
        if (JSONObject.NULL.toString().equals(cVar.tP)) {
            cVar.tP = "";
        }
        cVar.tQ = jSONObject.optString("continueBtnText");
        if (JSONObject.NULL.toString().equals(cVar.tQ)) {
            cVar.tQ = "";
        }
        cVar.tR = jSONObject.optString("viewDetailText");
        if (JSONObject.NULL.toString().equals(cVar.tR)) {
            cVar.tR = "";
        }
        cVar.tS = jSONObject.optString("unWatchedVideoTime");
        if (JSONObject.NULL.toString().equals(cVar.tS)) {
            cVar.tS = "";
        }
        cVar.tT = jSONObject.optString("iconUrl");
        if (JSONObject.NULL.toString().equals(cVar.tT)) {
            cVar.tT = "";
        }
        cVar.tU = jSONObject.optString("desc");
        if (JSONObject.NULL.toString().equals(cVar.tU)) {
            cVar.tU = "";
        }
        cVar.tV = jSONObject.optString("descTxt");
        if (JSONObject.NULL.toString().equals(cVar.tV)) {
            cVar.tV = "";
        }
        cVar.tW = jSONObject.optString("currentPlayTime");
        if (JSONObject.NULL.toString().equals(cVar.tW)) {
            cVar.tW = "";
        }
    }

    private static JSONObject b(com.kwad.components.ad.reward.h.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (cVar.style != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "style", cVar.style);
        }
        if (cVar.title != null && !cVar.title.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "title", cVar.title);
        }
        if (cVar.tP != null && !cVar.tP.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "closeBtnText", cVar.tP);
        }
        if (cVar.tQ != null && !cVar.tQ.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "continueBtnText", cVar.tQ);
        }
        if (cVar.tR != null && !cVar.tR.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "viewDetailText", cVar.tR);
        }
        if (cVar.tS != null && !cVar.tS.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "unWatchedVideoTime", cVar.tS);
        }
        if (cVar.tT != null && !cVar.tT.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "iconUrl", cVar.tT);
        }
        if (cVar.tU != null && !cVar.tU.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "desc", cVar.tU);
        }
        if (cVar.tV != null && !cVar.tV.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "descTxt", cVar.tV);
        }
        if (cVar.tW != null && !cVar.tW.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "currentPlayTime", cVar.tW);
        }
        return jSONObject;
    }
}
