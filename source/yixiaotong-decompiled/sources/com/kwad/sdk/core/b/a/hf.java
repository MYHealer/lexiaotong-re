package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.HttpDnsInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class hf implements com.kwad.sdk.core.d<HttpDnsInfo.IpInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((HttpDnsInfo.IpInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((HttpDnsInfo.IpInfo) bVar, jSONObject);
    }

    private static void a(HttpDnsInfo.IpInfo ipInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        ipInfo.ip = jSONObject.optString("ip");
        if (JSONObject.NULL.toString().equals(ipInfo.ip)) {
            ipInfo.ip = "";
        }
        ipInfo.weight = jSONObject.optInt("weight");
    }

    private static JSONObject b(HttpDnsInfo.IpInfo ipInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (ipInfo.ip != null && !ipInfo.ip.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "ip", ipInfo.ip);
        }
        if (ipInfo.weight != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "weight", ipInfo.weight);
        }
        return jSONObject;
    }
}
