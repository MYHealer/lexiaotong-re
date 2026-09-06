package com.hihonor.adsdk.base.g.k.c;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class q extends j0 {
    private static final String hnadsd = "AdTrackReserveResult";

    public q(int i, String str, String str2, String str3) {
        String string;
        try {
            string = new JSONObject().put("code", str2).put("msg", str3).toString();
        } catch (JSONException e) {
            com.hihonor.adsdk.common.b.b.hnadse(hnadsd, "AdTrackReserveResult, Set ext error, Exception: " + e.getMessage(), new Object[0]);
            string = "";
        }
        hnadsa(14, i, str, string);
    }

    @Override // com.hihonor.adsdk.base.g.k.c.k0
    public int hnadsb() {
        return 38;
    }
}
