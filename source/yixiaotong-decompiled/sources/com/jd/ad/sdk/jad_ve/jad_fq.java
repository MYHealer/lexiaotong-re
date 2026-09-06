package com.jd.ad.sdk.jad_ve;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_fq implements jad_mx<com.jd.ad.sdk.jad_yh.jad_dq> {
    public static final jad_fq jad_an = new jad_fq();

    @Override // com.jd.ad.sdk.jad_ve.jad_mx
    public com.jd.ad.sdk.jad_yh.jad_dq jad_an(com.jd.ad.sdk.jad_wf.jad_cp jad_cpVar, float f) {
        boolean z = jad_cpVar.jad_mz() == 1;
        if (z) {
            jad_cpVar.jad_bo();
        }
        float fJad_iv = (float) jad_cpVar.jad_iv();
        float fJad_iv2 = (float) jad_cpVar.jad_iv();
        while (jad_cpVar.jad_jt()) {
            jad_cpVar.jad_ob();
        }
        if (z) {
            jad_cpVar.jad_dq();
        }
        return new com.jd.ad.sdk.jad_yh.jad_dq((fJad_iv / 100.0f) * f, (fJad_iv2 / 100.0f) * f);
    }
}
