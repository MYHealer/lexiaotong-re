package com.jd.ad.sdk.jad_qb;

import android.util.Base64;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class jad_er<Model, Data> implements jad_na<Model, Data> {
    public final jad_an<Data> jad_an;

    public interface jad_an<Data> {
    }

    public static final class jad_bo<Data> implements com.jd.ad.sdk.jad_kv.jad_dq<Data> {
        public final String jad_an;
        public final jad_an<Data> jad_bo;
        public Data jad_cp;

        public jad_bo(String str, jad_an<Data> jad_anVar) {
            this.jad_an = str;
            this.jad_bo = jad_anVar;
        }

        @Override // com.jd.ad.sdk.jad_kv.jad_dq
        public Class<Data> jad_an() {
            ((jad_cp.jad_an) this.jad_bo).getClass();
            return InputStream.class;
        }

        /* JADX WARN: Type inference failed for: r2v4, types: [Data, java.lang.Object] */
        @Override // com.jd.ad.sdk.jad_kv.jad_dq
        public void jad_an(com.jd.ad.sdk.jad_gr.jad_jt jad_jtVar, com.jd.ad.sdk.jad_kv.jad_dq.jad_an<? super Data> jad_anVar) {
            try {
                ?? r2 = (Data) ((jad_cp.jad_an) this.jad_bo).jad_an(this.jad_an);
                this.jad_cp = r2;
                jad_anVar.jad_an(r2);
            } catch (IllegalArgumentException e) {
                jad_anVar.jad_an((Exception) e);
            }
        }

        @Override // com.jd.ad.sdk.jad_kv.jad_dq
        public void jad_bo() {
            try {
                jad_an<Data> jad_anVar = this.jad_bo;
                Data data = this.jad_cp;
                ((jad_cp.jad_an) jad_anVar).getClass();
                ((InputStream) data).close();
            } catch (IOException unused) {
            }
        }

        @Override // com.jd.ad.sdk.jad_kv.jad_dq
        public void jad_cp() {
        }

        @Override // com.jd.ad.sdk.jad_kv.jad_dq
        public com.jd.ad.sdk.jad_ju.jad_an jad_dq() {
            return com.jd.ad.sdk.jad_ju.jad_an.LOCAL;
        }
    }

    public static final class jad_cp<Model> implements jad_ob<Model, InputStream> {
        public final jad_an<InputStream> jad_an = new jad_an(this);

        public class jad_an implements jad_an<InputStream> {
            public jad_an(jad_cp jad_cpVar) {
            }

            public Object jad_an(String str) {
                if (!str.startsWith("data:image")) {
                    throw new IllegalArgumentException("Not a valid image data URL.");
                }
                int iIndexOf = str.indexOf(44);
                if (iIndexOf == -1) {
                    throw new IllegalArgumentException("Missing comma in data URL.");
                }
                if (str.substring(0, iIndexOf).endsWith(";base64")) {
                    return new ByteArrayInputStream(Base64.decode(str.substring(iIndexOf + 1), 0));
                }
                throw new IllegalArgumentException("Not a base64 image data URL.");
            }
        }

        @Override // com.jd.ad.sdk.jad_qb.jad_ob
        public jad_na<Model, InputStream> jad_an(jad_re jad_reVar) {
            return new jad_er(this.jad_an);
        }
    }

    public jad_er(jad_an<Data> jad_anVar) {
        this.jad_an = jad_anVar;
    }

    @Override // com.jd.ad.sdk.jad_qb.jad_na
    public jad_na.jad_an<Data> jad_an(Model model, int i, int i2, com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar) {
        return new jad_na.jad_an<>(new com.jd.ad.sdk.jad_hq.jad_bo(model), Collections.emptyList(), new jad_bo(model.toString(), this.jad_an));
    }

    @Override // com.jd.ad.sdk.jad_qb.jad_na
    public boolean jad_an(Model model) {
        return model.toString().startsWith("data:image");
    }
}
