package com.hihonor.adsdk.base.g.k.c;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class p extends j0 {
    private static final String hnadsd = "AdTrackMobileDialogShow";

    public p(int i) {
        String string;
        try {
            string = new JSONObject().put(com.hihonor.adsdk.base.g.j.e.a.InterfaceC0437a.hnadsd, i).toString();
        } catch (JSONException e) {
            com.hihonor.adsdk.common.b.b.hnadse(hnadsd, "AdTrackMobileDialogShow, Set ext error, Exception: " + e.getMessage(), new Object[0]);
            string = "";
        }
        hnadsa(108, 0, "Mobile network dialog is show", string);
    }

    @Override // com.hihonor.adsdk.base.g.k.c.k0
    public int hnadsb() {
        return 17;
    }
}
