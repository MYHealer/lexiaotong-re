package com.opos.mobad.template.e.b;

import android.text.TextUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class b extends a {
    public final int k;
    public final int l;

    public b(com.opos.mobad.template.d.b bVar) {
        super(bVar);
        int i = 1000;
        int i2 = 30;
        try {
            String strA = a(bVar, "EXT_PARAM_KEY_FORWARD_TIME");
            i = TextUtils.isEmpty(strA) ? 1000 : Integer.parseInt(strA);
            String strA2 = a(bVar, "EXT_PARAM_KEY_FORWARD_DEGREE");
            if (!TextUtils.isEmpty(strA2)) {
                i2 = Integer.parseInt(strA2);
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.d("ForwardInteractiveInfo", "ForwardInteractiveInfo", e);
        }
        this.k = Math.max(i, j);
        this.l = Math.max(i2, i);
        com.opos.cmn.an.f.a.b("ForwardInteractiveInfo", "forwardTime: " + i + ",forwardDegree: " + i2);
    }
}
