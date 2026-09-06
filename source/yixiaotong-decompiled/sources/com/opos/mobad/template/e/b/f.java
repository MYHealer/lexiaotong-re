package com.opos.mobad.template.e.b;

import android.text.TextUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class f extends a {
    public final int k;

    public f(com.opos.mobad.template.d.b bVar) {
        super(bVar);
        int i = 3;
        try {
            String strA = a(bVar, "EXT_PARAM_KEY_SLIDE_LAYER_DISTANCE");
            if (!TextUtils.isEmpty(strA)) {
                i = Integer.parseInt(strA);
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.d("SlideLayerInteractiveInfo", "SlideLayerInteractiveInfo", e);
        }
        this.k = Math.max(i, d);
        com.opos.cmn.an.f.a.b("SlideLayerInteractiveInfo", "slideLayerDistance: " + i);
    }
}
