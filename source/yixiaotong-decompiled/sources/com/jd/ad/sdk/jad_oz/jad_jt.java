package com.jd.ad.sdk.jad_oz;

import com.jd.ad.sdk.jad_mx.jad_mz;
import com.jd.ad.sdk.jad_mx.jad_xk;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_jt extends com.jd.ad.sdk.jad_ir.jad_hu<com.jd.ad.sdk.jad_ju.jad_hu, jad_xk<?>> implements jad_hu {
    public jad_hu.jad_an jad_dq;

    public jad_jt(long j) {
        super(j);
    }

    public void jad_an(jad_hu.jad_an jad_anVar) {
        this.jad_dq = jad_anVar;
    }

    @Override // com.jd.ad.sdk.jad_ir.jad_hu
    public void jad_an(com.jd.ad.sdk.jad_ju.jad_hu jad_huVar, jad_xk<?> jad_xkVar) {
        jad_xk<?> jad_xkVar2 = jad_xkVar;
        jad_hu.jad_an jad_anVar = this.jad_dq;
        if (jad_anVar == null || jad_xkVar2 == null) {
            return;
        }
        ((jad_mz) jad_anVar).jad_er.jad_an(jad_xkVar2, true);
    }

    @Override // com.jd.ad.sdk.jad_ir.jad_hu
    public int jad_bo(jad_xk<?> jad_xkVar) {
        jad_xk<?> jad_xkVar2 = jad_xkVar;
        if (jad_xkVar2 == null) {
            return 1;
        }
        return jad_xkVar2.jad_bo();
    }
}
