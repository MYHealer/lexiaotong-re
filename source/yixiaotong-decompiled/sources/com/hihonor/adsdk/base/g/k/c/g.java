package com.hihonor.adsdk.base.g.k.c;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class g extends k0 {
    private static final String hnadsd = "AdTrackDeeplinkSuccess";

    public g(int i, int i2) {
        try {
            this.hnadsa.put(com.hihonor.adsdk.base.g.j.e.c.hnadsp, com.hihonor.adsdk.common.f.z.hnadsa(new JSONObject().put(com.hihonor.adsdk.base.g.j.e.a.InterfaceC0437a.hnadsc, i).put(com.hihonor.adsdk.base.g.j.e.a.InterfaceC0437a.hnadsf, i2).toString()));
        } catch (JSONException e) {
            com.hihonor.adsdk.common.b.b.hnadse(hnadsd, "AdTrackDeeplinkSuccess, Set ext error, Exception: " + e.getMessage(), new Object[0]);
        }
    }

    @Override // com.hihonor.adsdk.base.g.k.c.k0
    public int hnadsb() {
        return 9;
    }
}
