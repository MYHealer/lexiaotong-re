package com.jd.ad.sdk.jad_ve;

import android.graphics.Color;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_jt implements jad_mx<Integer> {
    public static final jad_jt jad_an = new jad_jt();

    @Override // com.jd.ad.sdk.jad_ve.jad_mx
    public Integer jad_an(com.jd.ad.sdk.jad_wf.jad_cp jad_cpVar, float f) {
        boolean z = jad_cpVar.jad_mz() == 1;
        if (z) {
            jad_cpVar.jad_bo();
        }
        double dJad_iv = jad_cpVar.jad_iv();
        double dJad_iv2 = jad_cpVar.jad_iv();
        double dJad_iv3 = jad_cpVar.jad_iv();
        double dJad_iv4 = jad_cpVar.jad_mz() == 7 ? jad_cpVar.jad_iv() : 1.0d;
        if (z) {
            jad_cpVar.jad_dq();
        }
        if (dJad_iv <= 1.0d && dJad_iv2 <= 1.0d && dJad_iv3 <= 1.0d) {
            dJad_iv *= 255.0d;
            dJad_iv2 *= 255.0d;
            dJad_iv3 *= 255.0d;
            if (dJad_iv4 <= 1.0d) {
                dJad_iv4 *= 255.0d;
            }
        }
        return Integer.valueOf(Color.argb((int) dJad_iv4, (int) dJad_iv, (int) dJad_iv2, (int) dJad_iv3));
    }
}
