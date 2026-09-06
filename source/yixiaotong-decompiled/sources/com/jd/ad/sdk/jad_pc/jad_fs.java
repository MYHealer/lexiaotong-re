package com.jd.ad.sdk.jad_pc;

import com.jd.ad.sdk.logger.Logger;
import org.json.JSONObject;

/* JADX INFO: compiled from: ANThirdPlatformInfo.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_fs {
    public int jad_an;
    public String jad_bo;
    public String jad_cp;

    public JSONObject jad_an() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("id", Integer.valueOf(this.jad_an));
            jSONObject.putOpt("sn", this.jad_bo);
            jSONObject.putOpt("sa", this.jad_cp);
        } catch (Exception e) {
            Logger.d(com.jd.ad.sdk.jad_bo.jad_bo.jad_an("an third info ").append(e.getMessage()).toString());
        }
        return jSONObject;
    }

    public String toString() {
        return com.jd.ad.sdk.jad_bo.jad_bo.jad_an("ANThirdPlatformInfo{id=").append(this.jad_an).append(", sn='").append(this.jad_bo).append('\'').append(", sa='").append(this.jad_cp).append('\'').append('}').toString();
    }
}
