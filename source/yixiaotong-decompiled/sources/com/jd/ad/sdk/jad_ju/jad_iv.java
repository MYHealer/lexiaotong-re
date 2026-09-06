package com.jd.ad.sdk.jad_ju;

import java.security.MessageDigest;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class jad_iv<T> {
    public static final jad_bo<Object> jad_er = new jad_an();
    public final T jad_an;
    public final jad_bo<T> jad_bo;
    public final String jad_cp;
    public volatile byte[] jad_dq;

    public class jad_an implements jad_bo<Object> {
        @Override // com.jd.ad.sdk.jad_ju.jad_iv.jad_bo
        public void jad_an(byte[] bArr, Object obj, MessageDigest messageDigest) {
        }
    }

    public interface jad_bo<T> {
        void jad_an(byte[] bArr, T t, MessageDigest messageDigest);
    }

    public jad_iv(String str, T t, jad_bo<T> jad_boVar) {
        this.jad_cp = com.jd.ad.sdk.jad_ir.jad_kx.jad_an(str);
        this.jad_an = t;
        this.jad_bo = (jad_bo) com.jd.ad.sdk.jad_ir.jad_kx.jad_an(jad_boVar);
    }

    public static <T> jad_iv<T> jad_an(String str, T t) {
        return new jad_iv<>(str, t, jad_er);
    }

    public boolean equals(Object obj) {
        if (obj instanceof jad_iv) {
            return this.jad_cp.equals(((jad_iv) obj).jad_cp);
        }
        return false;
    }

    public int hashCode() {
        return this.jad_cp.hashCode();
    }

    public String toString() {
        return com.jd.ad.sdk.jad_gr.jad_ly.jad_an("Option{key='").append(this.jad_cp).append('\'').append('}').toString();
    }
}
