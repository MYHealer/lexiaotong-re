package com.opos.mobad.template.e.b;

import android.text.TextUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class c extends a {
    public final int k;

    public c(com.opos.mobad.template.d.b bVar) {
        super(bVar);
        int i = 116;
        try {
            String strA = a(bVar, "EXT_PARAM_KEY_FULL_SCREEN_SLIDE_DISTANCE");
            if (!TextUtils.isEmpty(strA)) {
                i = Integer.parseInt(strA);
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.d("FullSlideInteractiveInfo", "FullSlideInteractiveInfo", e);
        }
        this.k = Math.max(i, c);
        com.opos.cmn.an.f.a.b("FullSlideInteractiveInfo", "fullScreenSlideDistance: " + i);
    }
}
