package com.jd.ad.sdk.jad_pc;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: ABConfig.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_an {
    public String jad_an;
    public float jad_cp;
    public float jad_dq;
    public float jad_er;
    public float jad_fs;
    public float jad_hu;
    public float jad_iv;
    public float jad_jt;
    public float jad_jw;
    public int jad_kx;
    public int jad_ly;
    public String jad_na;
    public int jad_ob;
    public int jad_pc;
    public String jad_qd;
    public int jad_re;
    public String jad_sf;
    public String jad_tg;
    public int jad_uh;
    public String jad_bo = "0";
    public int jad_mz = 3;
    public int jad_vi = 100;
    public int jad_wj = 10;

    public JSONObject jad_an() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("crt", this.jad_an);
            jSONObject.putOpt("fbdr", this.jad_na);
            jSONObject.putOpt("enpe", this.jad_bo);
            jSONObject.putOpt("ssvl", Float.valueOf(this.jad_cp));
            jSONObject.putOpt("slng", Float.valueOf(this.jad_dq));
            jSONObject.putOpt("savl", Float.valueOf(this.jad_er));
            jSONObject.putOpt("stvl", Float.valueOf(this.jad_fs));
            jSONObject.putOpt("fsvl", Float.valueOf(this.jad_jt));
            jSONObject.putOpt("favl", Float.valueOf(this.jad_hu));
            jSONObject.putOpt("ftvl", Float.valueOf(this.jad_iv));
            jSONObject.putOpt("sang", Float.valueOf(this.jad_jw));
            jSONObject.putOpt("pcit", Integer.valueOf(this.jad_kx));
            jSONObject.putOpt("pcdc", Integer.valueOf(this.jad_ly));
            jSONObject.putOpt("pdut", Integer.valueOf(this.jad_mz));
            jSONObject.putOpt("fpif", Integer.valueOf(this.jad_pc));
            jSONObject.putOpt("fikc", this.jad_qd);
            jSONObject.putOpt("opro", Integer.valueOf(this.jad_ob));
            jSONObject.putOpt("vcdc", Integer.valueOf(this.jad_re));
            jSONObject.putOpt("fbvl", this.jad_sf);
            jSONObject.putOpt("ftsv", this.jad_tg);
            jSONObject.putOpt("eaih", Integer.valueOf(this.jad_uh));
            jSONObject.putOpt("abdt", Integer.valueOf(this.jad_vi));
            jSONObject.putOpt("icet", Integer.valueOf(this.jad_wj));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public String toString() {
        return com.jd.ad.sdk.jad_bo.jad_bo.jad_an("ABConfig{crt=").append(this.jad_an).append(", fbdr=").append(this.jad_na).append(", enpe=").append(this.jad_bo).append(", ssvl=").append(this.jad_cp).append(", slng=").append(this.jad_dq).append(", savl=").append(this.jad_er).append(", stvl=").append(this.jad_fs).append(", fsvl=").append(this.jad_jt).append(", favl=").append(this.jad_hu).append(", ftvl=").append(this.jad_iv).append(", sang=").append(this.jad_jw).append(", pcit=").append(this.jad_kx).append(", pcdc=").append(this.jad_ly).append(", pdut=").append(this.jad_mz).append(", fpif=").append(this.jad_pc).append(", fikc=").append(this.jad_qd).append(", opro=").append(this.jad_ob).append(", vcdc=").append(this.jad_re).append(", vlft=").append(this.jad_sf).append(", ftsv=").append(this.jad_tg).append(", eaih=").append(this.jad_uh).append(", abdt=").append(this.jad_vi).append(", icet=").append(this.jad_wj).append('}').toString();
    }
}
