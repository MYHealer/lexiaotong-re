package com.opos.mobad.template.e.b;

import android.text.TextUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class h extends a {
    public final String k;
    public final int l;

    public h(com.opos.mobad.template.d.b bVar) {
        super(bVar);
        this.k = !TextUtils.isEmpty(bVar.j) ? bVar.j : null;
        int i = 116;
        try {
            String strA = a(bVar, "EXT_PARAM_KEY_UP_SLIDE_DISTANCE");
            if (!TextUtils.isEmpty(strA)) {
                i = Integer.parseInt(strA);
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.d("UpSlideInteractiveInfo", "UpSlideInteractiveInfo", e);
        }
        this.l = Math.max(i, c);
        com.opos.cmn.an.f.a.b("UpSlideInteractiveInfo", "upSlideDistance: " + i);
    }
}
