package com.jd.ad.sdk.jad_qb;

import java.util.Collections;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_vi<Model> implements jad_na<Model, Model> {
    public static final jad_vi<?> jad_an = new jad_vi<>();

    public static class jad_an<Model> implements jad_ob<Model, Model> {
        public static final jad_an<?> jad_an = new jad_an<>();

        @Deprecated
        public jad_an() {
        }

        @Override // com.jd.ad.sdk.jad_qb.jad_ob
        public jad_na<Model, Model> jad_an(jad_re jad_reVar) {
            return jad_vi.jad_an;
        }
    }

    public static class jad_bo<Model> implements com.jd.ad.sdk.jad_kv.jad_dq<Model> {
        public final Model jad_an;

        public jad_bo(Model model) {
            this.jad_an = model;
        }

        @Override // com.jd.ad.sdk.jad_kv.jad_dq
        public Class<Model> jad_an() {
            return (Class<Model>) this.jad_an.getClass();
        }

        @Override // com.jd.ad.sdk.jad_kv.jad_dq
        public void jad_an(com.jd.ad.sdk.jad_gr.jad_jt jad_jtVar, com.jd.ad.sdk.jad_kv.jad_dq.jad_an<? super Model> jad_anVar) {
            jad_anVar.jad_an(this.jad_an);
        }

        @Override // com.jd.ad.sdk.jad_kv.jad_dq
        public void jad_bo() {
        }

        @Override // com.jd.ad.sdk.jad_kv.jad_dq
        public void jad_cp() {
        }

        @Override // com.jd.ad.sdk.jad_kv.jad_dq
        public com.jd.ad.sdk.jad_ju.jad_an jad_dq() {
            return com.jd.ad.sdk.jad_ju.jad_an.LOCAL;
        }
    }

    @Deprecated
    public jad_vi() {
    }

    @Override // com.jd.ad.sdk.jad_qb.jad_na
    public jad_na.jad_an<Model> jad_an(Model model, int i, int i2, com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar) {
        return new jad_na.jad_an<>(new com.jd.ad.sdk.jad_hq.jad_bo(model), Collections.emptyList(), new jad_bo(model));
    }

    @Override // com.jd.ad.sdk.jad_qb.jad_na
    public boolean jad_an(Model model) {
        return true;
    }
}
