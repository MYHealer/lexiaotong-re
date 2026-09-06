package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class jn implements com.kwad.sdk.core.d<com.kwad.sdk.core.network.j> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.core.network.j) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.core.network.j) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.core.network.j jVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        jVar.aTx = jSONObject.optLong("request_prepare_cost");
        jVar.aTy = jSONObject.optLong("request_add_params_cost");
        jVar.aTz = jSONObject.optLong("request_create_cost");
        jVar.aTA = jSONObject.optInt("keep_alive");
        jVar.aTB = jSONObject.optLong("dns_start");
        jVar.aTC = jSONObject.optLong("dns_cost");
        jVar.aTD = jSONObject.optLong("connect_establish_start");
        jVar.aTE = jSONObject.optLong("connect_establish_cost");
        jVar.aTF = jSONObject.optLong("request_start");
        jVar.aTG = jSONObject.optLong("request_cost");
        jVar.aTH = jSONObject.optLong("request_size");
        jVar.aTI = jSONObject.optLong("response_start");
        jVar.aTJ = jSONObject.optLong("response_cost");
        jVar.aTK = jSONObject.optLong("response_parse_cost");
        jVar.aTL = jSONObject.optLong("response_size");
        jVar.aTM = jSONObject.optLong("waiting_response_cost");
        jVar.aTN = jSONObject.optLong("total_cost");
        jVar.aTO = jSONObject.optInt("proxy_used");
        jVar.aTP = jSONObject.optString("request_id");
        if (JSONObject.NULL.toString().equals(jVar.aTP)) {
            jVar.aTP = "";
        }
        jVar.aTQ = jSONObject.optInt("has_data_v2");
        jVar.result = jSONObject.optInt("result");
        jVar.aTR = jSONObject.optLong("response_done_cost");
        jVar.aTS = jSONObject.optString("host_ip");
        if (JSONObject.NULL.toString().equals(jVar.aTS)) {
            jVar.aTS = "";
        }
        jVar.aTT = jSONObject.optInt("ip_type");
        jVar.aTU = jSONObject.optInt("recommend_ping_time");
        jVar.aTV = jSONObject.optInt("backup_ping_time");
        jVar.aTW = jSONObject.optInt("other_ping_time");
    }

    private static JSONObject b(com.kwad.sdk.core.network.j jVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (jVar.aTx != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "request_prepare_cost", jVar.aTx);
        }
        if (jVar.aTy != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "request_add_params_cost", jVar.aTy);
        }
        if (jVar.aTz != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "request_create_cost", jVar.aTz);
        }
        if (jVar.aTA != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "keep_alive", jVar.aTA);
        }
        if (jVar.aTB != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "dns_start", jVar.aTB);
        }
        if (jVar.aTC != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "dns_cost", jVar.aTC);
        }
        if (jVar.aTD != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "connect_establish_start", jVar.aTD);
        }
        if (jVar.aTE != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "connect_establish_cost", jVar.aTE);
        }
        if (jVar.aTF != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "request_start", jVar.aTF);
        }
        if (jVar.aTG != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "request_cost", jVar.aTG);
        }
        if (jVar.aTH != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "request_size", jVar.aTH);
        }
        if (jVar.aTI != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "response_start", jVar.aTI);
        }
        if (jVar.aTJ != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "response_cost", jVar.aTJ);
        }
        if (jVar.aTK != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "response_parse_cost", jVar.aTK);
        }
        if (jVar.aTL != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "response_size", jVar.aTL);
        }
        if (jVar.aTM != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "waiting_response_cost", jVar.aTM);
        }
        if (jVar.aTN != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "total_cost", jVar.aTN);
        }
        if (jVar.aTO != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "proxy_used", jVar.aTO);
        }
        if (jVar.aTP != null && !jVar.aTP.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "request_id", jVar.aTP);
        }
        if (jVar.aTQ != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "has_data_v2", jVar.aTQ);
        }
        if (jVar.result != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "result", jVar.result);
        }
        if (jVar.aTR != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "response_done_cost", jVar.aTR);
        }
        if (jVar.aTS != null && !jVar.aTS.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "host_ip", jVar.aTS);
        }
        if (jVar.aTT != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "ip_type", jVar.aTT);
        }
        if (jVar.aTU != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "recommend_ping_time", jVar.aTU);
        }
        if (jVar.aTV != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "backup_ping_time", jVar.aTV);
        }
        if (jVar.aTW != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "other_ping_time", jVar.aTW);
        }
        return jSONObject;
    }
}
