package com.jd.ad.sdk.jad_yl;

import org.json.JSONObject;

/* JADX INFO: compiled from: JADResponse.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class jad_jt {
    public int jad_an;
    public String jad_bo;
    public jad_hu jad_cp;

    public int jad_an() {
        return this.jad_an;
    }

    public String jad_bo() {
        return this.jad_bo;
    }

    public jad_hu jad_cp() {
        return this.jad_cp;
    }

    public static jad_jt jad_an(String str) {
        jad_jt jad_jtVar = new jad_jt();
        JSONObject jSONObject = new JSONObject(str);
        jad_jtVar.jad_an = jSONObject.optInt("statuscode");
        jad_jtVar.jad_bo = jSONObject.optString("msg");
        jSONObject.optString("id");
        jSONObject.optString("bidid");
        jad_jtVar.jad_cp = jad_hu.jad_an(jSONObject.optJSONObject("seatbid"));
        return jad_jtVar;
    }
}
