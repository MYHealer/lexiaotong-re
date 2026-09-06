package com.hihonor.adsdk.base.g.k.c;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class i extends j0 {
    private static final String hnadsd = "AdTrackDownloadFail";

    public i(int i, String str, int i2) {
        String string;
        try {
            string = new JSONObject().put(com.hihonor.adsdk.base.g.j.e.a.InterfaceC0437a.hnadsd, i2).toString();
        } catch (JSONException e) {
            com.hihonor.adsdk.common.b.b.hnadse(hnadsd, "AdTrackDownloadFail, Set ext error, Exception: " + e.getMessage(), new Object[0]);
            string = "";
        }
        hnadsa(2, i, str, string);
    }

    @Override // com.hihonor.adsdk.base.g.k.c.k0
    public int hnadsb() {
        return 5;
    }
}
