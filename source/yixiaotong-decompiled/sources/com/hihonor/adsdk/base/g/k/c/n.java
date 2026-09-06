package com.hihonor.adsdk.base.g.k.c;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class n extends j0 {
    private static final String hnadsd = "AdTrackMobileDialogCancel";

    public n(int i) {
        String string;
        try {
            string = new JSONObject().put(com.hihonor.adsdk.base.g.j.e.a.InterfaceC0437a.hnadsd, i).toString();
        } catch (JSONException e) {
            com.hihonor.adsdk.common.b.b.hnadse(hnadsd, "AdTrackMobileDialogCancel, Set ext error, Exception: " + e.getMessage(), new Object[0]);
            string = "";
        }
        hnadsa(109, 0, "Click ad close mobile dialog", string);
    }

    @Override // com.hihonor.adsdk.base.g.k.c.k0
    public int hnadsb() {
        return 19;
    }
}
