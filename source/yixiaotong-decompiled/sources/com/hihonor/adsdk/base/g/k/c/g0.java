package com.hihonor.adsdk.base.g.k.c;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class g0 extends k0 {
    private static final String hnadsd = "AdTrackVideoBreak";

    public g0(long j, long j2) {
        String string;
        try {
            string = new JSONObject().put(com.hihonor.adsdk.base.g.j.e.a.InterfaceC0437a.hnadsa, j).put(com.hihonor.adsdk.base.g.j.e.a.InterfaceC0437a.hnadsb, j2).toString();
        } catch (JSONException e) {
            com.hihonor.adsdk.common.b.b.hnadse(hnadsd, "AdTrackVideoBreak, Set ext error, Exception: " + e.getMessage(), new Object[0]);
            string = "";
        }
        if (TextUtils.isEmpty(string)) {
            return;
        }
        this.hnadsa.put(com.hihonor.adsdk.base.g.j.e.c.hnadsp, com.hihonor.adsdk.common.f.z.hnadsa(string));
    }

    @Override // com.hihonor.adsdk.base.g.k.c.k0
    public int hnadsb() {
        return 30;
    }
}
