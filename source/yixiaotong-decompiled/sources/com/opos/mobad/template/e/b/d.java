package com.opos.mobad.template.e.b;

import android.text.TextUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class d extends a {
    public final int k;
    public final int l;
    public final int m;

    public d(com.opos.mobad.template.d.b bVar) {
        super(bVar);
        int i = 3000;
        int i2 = 15000;
        int i3 = 116;
        try {
            String strA = a(bVar, "EXT_PARAM_KEY_SHAKE_UP_SLIDE_SENSOR_TIME");
            i = TextUtils.isEmpty(strA) ? 3000 : Integer.parseInt(strA);
            String strA2 = a(bVar, "EXT_PARAM_KEY_SHAKE_UP_SLIDE_SENSOR_DIFF");
            i2 = TextUtils.isEmpty(strA2) ? 15000 : Integer.parseInt(strA2);
            String strA3 = a(bVar, "EXT_PARAM_KEY_SHAKE_UP_SLIDE_DISTANCE");
            if (!TextUtils.isEmpty(strA3)) {
                i3 = Integer.parseInt(strA3);
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.d("ShakeAndUpSlideInteractiveInfo", "ShakeAndUpSlideInteractiveInfo", e);
        }
        this.k = Math.max(i, e);
        this.l = Math.max(i2, f);
        this.m = Math.max(i3, c);
        com.opos.cmn.an.f.a.b("ShakeAndUpSlideInteractiveInfo", "shakeAndUpSlideSensorTime: " + i + ",shakeAndUpSlideSensorDiff: " + i2 + ",shakeAndUpSlideDistance: " + i3);
    }
}
