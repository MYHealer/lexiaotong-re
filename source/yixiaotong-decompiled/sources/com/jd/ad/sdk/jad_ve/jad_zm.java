package com.jd.ad.sdk.jad_ve;

import android.graphics.PointF;
import com.jd.ad.sdk.a.a;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_zm implements jad_mx<PointF> {
    public static final jad_zm jad_an = new jad_zm();

    @Override // com.jd.ad.sdk.jad_ve.jad_mx
    public PointF jad_an(com.jd.ad.sdk.jad_wf.jad_cp jad_cpVar, float f) {
        int iJad_mz = jad_cpVar.jad_mz();
        if (iJad_mz == 1 || iJad_mz == 3) {
            return jad_sf.jad_an(jad_cpVar, f);
        }
        if (iJad_mz != 7) {
            throw new IllegalArgumentException(a.a("Cannot convert json to point. Next token is ").append(com.jd.ad.sdk.jad_wf.jad_dq.jad_an(iJad_mz)).toString());
        }
        PointF pointF = new PointF(((float) jad_cpVar.jad_iv()) * f, ((float) jad_cpVar.jad_iv()) * f);
        while (jad_cpVar.jad_jt()) {
            jad_cpVar.jad_ob();
        }
        return pointF;
    }
}
