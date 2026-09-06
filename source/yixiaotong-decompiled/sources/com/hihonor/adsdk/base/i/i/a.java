package com.hihonor.adsdk.base.i.i;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class a {
    private static final String hnadsb = "RemoteJson";
    private final JSONObject hnadsa = new JSONObject();

    public a hnadsa(String str, Object obj) {
        try {
            this.hnadsa.put(str, obj);
        } catch (JSONException e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsb, "put param error. " + e.getMessage(), new Object[0]);
        }
        return this;
    }

    public String toString() {
        return this.hnadsa.toString();
    }
}
