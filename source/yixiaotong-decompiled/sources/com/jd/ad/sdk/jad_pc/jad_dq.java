package com.jd.ad.sdk.jad_pc;

import com.jd.ad.sdk.logger.Logger;
import org.json.JSONObject;

/* JADX INFO: compiled from: ANEvents.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_dq {
    public String jad_an;
    public int jad_bo;
    public int jad_cp;

    public JSONObject jad_an() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("url", this.jad_an);
            jSONObject.putOpt("mn", Integer.valueOf(this.jad_bo));
            jSONObject.putOpt("ci", Integer.valueOf(this.jad_cp));
        } catch (Exception e) {
            Logger.d(com.jd.ad.sdk.jad_bo.jad_bo.jad_an("an events to json ").append(e.getMessage()).toString());
        }
        return jSONObject;
    }

    public String toString() {
        return com.jd.ad.sdk.jad_bo.jad_bo.jad_an("ANEvents{url='").append(this.jad_an).append('\'').append(", mn=").append(this.jad_bo).append(", ci=").append(this.jad_cp).append('}').toString();
    }
}
