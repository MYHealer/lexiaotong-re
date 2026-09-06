package com.jd.ad.sdk.jad_pc;

import com.jd.ad.sdk.logger.Logger;
import com.kuaishou.weapon.p0.t;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: ANPlacement.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_er {
    public String jad_an;
    public int jad_bo;
    public int jad_cp;
    public int jad_dq;
    public int jad_er;
    public List<Integer> jad_fs;
    public int jad_hu;
    public int jad_jt;

    public JSONObject jad_an() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("ak", this.jad_an);
            jSONObject.putOpt("t", Integer.valueOf(this.jad_bo));
            jSONObject.putOpt("m", Integer.valueOf(this.jad_cp));
            jSONObject.putOpt("bs", Integer.valueOf(this.jad_dq));
            jSONObject.putOpt("st", Integer.valueOf(this.jad_er));
            JSONArray jSONArray = new JSONArray();
            List<Integer> list = this.jad_fs;
            if (list != null && list.size() > 0) {
                for (int i = 0; i < this.jad_fs.size(); i++) {
                    jSONArray.put(this.jad_fs.get(i));
                }
            }
            jSONObject.putOpt("tmp", jSONArray);
            jSONObject.putOpt("ds", Integer.valueOf(this.jad_jt));
            jSONObject.putOpt(t.k, Integer.valueOf(this.jad_hu));
        } catch (Exception e) {
            Logger.d(com.jd.ad.sdk.jad_bo.jad_bo.jad_an("an placement ").append(e.getMessage()).toString());
        }
        return jSONObject;
    }

    public String toString() {
        return com.jd.ad.sdk.jad_bo.jad_bo.jad_an("ANPlacement{ak='").append(this.jad_an).append('\'').append(", t=").append(this.jad_bo).append(", m=").append(this.jad_cp).append(", bs=").append(this.jad_dq).append(", st=").append(this.jad_er).append(", tmp=").append(this.jad_fs).append(", ds=").append(this.jad_jt).append(", r=").append(this.jad_hu).append('}').toString();
    }
}
