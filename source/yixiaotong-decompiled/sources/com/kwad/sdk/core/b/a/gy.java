package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class gy implements com.kwad.sdk.core.d<com.kwad.components.ad.j.b.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.ad.j.b.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.ad.j.b.a) bVar, jSONObject);
    }

    private static void a(com.kwad.components.ad.j.b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.Np = jSONObject.optString("device_model");
        if (JSONObject.NULL.toString().equals(aVar.Np)) {
            aVar.Np = "";
        }
        aVar.Nq = jSONObject.optString(com.umeng.analytics.pro.am.F);
        if (JSONObject.NULL.toString().equals(aVar.Nq)) {
            aVar.Nq = "";
        }
        aVar.Nr = jSONObject.optString("os_version");
        if (JSONObject.NULL.toString().equals(aVar.Nr)) {
            aVar.Nr = "";
        }
        aVar.Ns = jSONObject.optString("rom_name");
        if (JSONObject.NULL.toString().equals(aVar.Ns)) {
            aVar.Ns = "";
        }
        aVar.Nt = jSONObject.optString("device_id");
        if (JSONObject.NULL.toString().equals(aVar.Nt)) {
            aVar.Nt = "";
        }
        aVar.status = jSONObject.optInt("status");
        aVar.Nu = jSONObject.optString("install_check_record");
        if (JSONObject.NULL.toString().equals(aVar.Nu)) {
            aVar.Nu = "";
        }
        aVar.Nv = jSONObject.optString("local_installer_pkgs");
        if (JSONObject.NULL.toString().equals(aVar.Nv)) {
            aVar.Nv = "";
        }
    }

    private static JSONObject b(com.kwad.components.ad.j.b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (aVar.Np != null && !aVar.Np.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "device_model", aVar.Np);
        }
        if (aVar.Nq != null && !aVar.Nq.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, com.umeng.analytics.pro.am.F, aVar.Nq);
        }
        if (aVar.Nr != null && !aVar.Nr.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "os_version", aVar.Nr);
        }
        if (aVar.Ns != null && !aVar.Ns.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "rom_name", aVar.Ns);
        }
        if (aVar.Nt != null && !aVar.Nt.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "device_id", aVar.Nt);
        }
        if (aVar.status != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "status", aVar.status);
        }
        if (aVar.Nu != null && !aVar.Nu.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "install_check_record", aVar.Nu);
        }
        if (aVar.Nv != null && !aVar.Nv.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "local_installer_pkgs", aVar.Nv);
        }
        return jSONObject;
    }
}
