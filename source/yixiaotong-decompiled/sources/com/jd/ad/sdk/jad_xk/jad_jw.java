package com.jd.ad.sdk.jad_xk;

import com.jd.ad.sdk.fdt.utils.JsonUtils;
import com.jd.ad.sdk.logger.Logger;
import com.umeng.analytics.pro.d;
import java.io.Serializable;
import org.json.JSONObject;

/* JADX INFO: compiled from: Event.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_jw implements Serializable {
    public Double jad_an;
    public Double jad_bo;

    public jad_jw(JSONObject jSONObject) {
        Double dValueOf = Double.valueOf(-1.0d);
        this.jad_an = dValueOf;
        this.jad_bo = dValueOf;
        if (jSONObject == null) {
            return;
        }
        jad_an(jSONObject);
    }

    public final void jad_an(JSONObject jSONObject) {
        try {
            this.jad_an = Double.valueOf(jSONObject.optDouble("lon", -1.0d));
            this.jad_bo = Double.valueOf(jSONObject.optDouble(d.C, -1.0d));
        } catch (Exception e) {
            this.jad_an = Double.valueOf(-1.0d);
            this.jad_bo = Double.valueOf(-1.0d);
            Logger.w("parse geo from json ", e.getMessage());
        }
    }

    public String toString() {
        return jad_an().toString();
    }

    public JSONObject jad_an() {
        JSONObject jSONObject = new JSONObject();
        try {
            JsonUtils.put(jSONObject, "lon", this.jad_an);
            JsonUtils.put(jSONObject, d.C, this.jad_bo);
        } catch (Exception unused) {
            this.jad_an = Double.valueOf(-1.0d);
            this.jad_bo = Double.valueOf(-1.0d);
        }
        return jSONObject;
    }
}
