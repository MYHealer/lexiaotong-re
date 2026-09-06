package com.opos.mobad.template.e.b;

import android.text.TextUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class g extends a {
    public final int k;
    public final int l;
    public final boolean m;

    public g(com.opos.mobad.template.d.b bVar) {
        super(bVar);
        int i = 30;
        int i2 = 2000;
        boolean z = true;
        try {
            String strA = a(bVar, "EXT_PARAM_KEY_TILT_DEGREE");
            i = TextUtils.isEmpty(strA) ? 30 : Integer.parseInt(strA);
            String strA2 = a(bVar, "EXT_PARAM_KEY_TILT_TIME");
            i2 = TextUtils.isEmpty(strA2) ? 2000 : Integer.parseInt(strA2);
            String strA3 = a(bVar, "EXT_PARAM_KEY_TILT_TWOWAY");
            if (!TextUtils.isEmpty(strA3)) {
                z = Boolean.parseBoolean(strA3);
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.d("TiltInteractiveInfo", "TiltInteractiveInfo", e);
        }
        this.l = Math.max(i, g);
        this.k = Math.max(i2, h);
        this.m = z;
        com.opos.cmn.an.f.a.b("TiltInteractiveInfo", "tiltDegree: " + i + ",tiltTime: " + i2);
    }
}
