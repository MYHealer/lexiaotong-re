package com.jd.ad.sdk.jad_pc;

import com.huawei.hms.ml.camera.CountryCodeBean;
import com.jd.ad.sdk.logger.Logger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: ANApi.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_bo {
    public String jad_an;
    public String jad_bo;
    public String jad_cp;

    public JSONObject jad_an() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(CountryCodeBean.SPECIAL_COUNTRYCODE_EU, this.jad_cp);
            jSONObject.putOpt("ou", this.jad_an);
            jSONObject.putOpt("tu", this.jad_bo);
        } catch (JSONException e) {
            Logger.d(com.jd.ad.sdk.jad_bo.jad_bo.jad_an("an api ").append(e.getMessage()).toString());
        }
        return jSONObject;
    }

    public String toString() {
        return com.jd.ad.sdk.jad_bo.jad_bo.jad_an("ANApi{ou='").append(this.jad_an).append('\'').append(", tu='").append(this.jad_bo).append('\'').append(", eu='").append(this.jad_cp).append('\'').append('}').toString();
    }
}
