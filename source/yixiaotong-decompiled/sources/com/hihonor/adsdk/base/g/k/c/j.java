package com.hihonor.adsdk.base.g.k.c;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class j extends k0 {
    private static final String hnadsd = "AdTrackDpStartSuccess";

    public j(int i, int i2, long j, int i3) {
        String string;
        try {
            string = new JSONObject().put(com.hihonor.adsdk.base.g.j.e.a.InterfaceC0437a.hnadsc, i).put(com.hihonor.adsdk.base.g.j.e.a.InterfaceC0437a.hnadsd, i2).put(com.hihonor.adsdk.base.g.j.e.a.InterfaceC0437a.hnadse, j).put(com.hihonor.adsdk.base.g.j.e.a.InterfaceC0437a.hnadsf, i3).toString();
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
        return 32;
    }
}
