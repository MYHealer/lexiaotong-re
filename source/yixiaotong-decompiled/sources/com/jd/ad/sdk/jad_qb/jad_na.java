package com.jd.ad.sdk.jad_qb;

import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public interface jad_na<Model, Data> {

    public static class jad_an<Data> {
        public final com.jd.ad.sdk.jad_ju.jad_hu jad_an;
        public final List<com.jd.ad.sdk.jad_ju.jad_hu> jad_bo;
        public final com.jd.ad.sdk.jad_kv.jad_dq<Data> jad_cp;

        public jad_an(com.jd.ad.sdk.jad_ju.jad_hu jad_huVar, List<com.jd.ad.sdk.jad_ju.jad_hu> list, com.jd.ad.sdk.jad_kv.jad_dq<Data> jad_dqVar) {
            this.jad_an = (com.jd.ad.sdk.jad_ju.jad_hu) com.jd.ad.sdk.jad_ir.jad_kx.jad_an(jad_huVar);
            this.jad_bo = (List) com.jd.ad.sdk.jad_ir.jad_kx.jad_an(list);
            this.jad_cp = (com.jd.ad.sdk.jad_kv.jad_dq) com.jd.ad.sdk.jad_ir.jad_kx.jad_an(jad_dqVar);
        }
    }

    jad_an<Data> jad_an(Model model, int i, int i2, com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar);

    boolean jad_an(Model model);
}
