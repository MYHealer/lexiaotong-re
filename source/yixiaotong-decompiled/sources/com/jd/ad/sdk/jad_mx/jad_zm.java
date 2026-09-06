package com.jd.ad.sdk.jad_mx;

import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class jad_zm implements com.jd.ad.sdk.jad_ju.jad_hu {
    public static final com.jd.ad.sdk.jad_ir.jad_hu<Class<?>, byte[]> jad_jw = new com.jd.ad.sdk.jad_ir.jad_hu<>(50);
    public final com.jd.ad.sdk.jad_ny.jad_bo jad_bo;
    public final com.jd.ad.sdk.jad_ju.jad_hu jad_cp;
    public final com.jd.ad.sdk.jad_ju.jad_hu jad_dq;
    public final int jad_er;
    public final int jad_fs;
    public final com.jd.ad.sdk.jad_ju.jad_jw jad_hu;
    public final com.jd.ad.sdk.jad_ju.jad_na<?> jad_iv;
    public final Class<?> jad_jt;

    public jad_zm(com.jd.ad.sdk.jad_ny.jad_bo jad_boVar, com.jd.ad.sdk.jad_ju.jad_hu jad_huVar, com.jd.ad.sdk.jad_ju.jad_hu jad_huVar2, int i, int i2, com.jd.ad.sdk.jad_ju.jad_na<?> jad_naVar, Class<?> cls, com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar) {
        this.jad_bo = jad_boVar;
        this.jad_cp = jad_huVar;
        this.jad_dq = jad_huVar2;
        this.jad_er = i;
        this.jad_fs = i2;
        this.jad_iv = jad_naVar;
        this.jad_jt = cls;
        this.jad_hu = jad_jwVar;
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_hu
    public boolean equals(Object obj) {
        if (!(obj instanceof jad_zm)) {
            return false;
        }
        jad_zm jad_zmVar = (jad_zm) obj;
        return this.jad_fs == jad_zmVar.jad_fs && this.jad_er == jad_zmVar.jad_er && com.jd.ad.sdk.jad_ir.jad_ly.jad_an(this.jad_iv, jad_zmVar.jad_iv) && this.jad_jt.equals(jad_zmVar.jad_jt) && this.jad_cp.equals(jad_zmVar.jad_cp) && this.jad_dq.equals(jad_zmVar.jad_dq) && this.jad_hu.equals(jad_zmVar.jad_hu);
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_hu
    public int hashCode() {
        int iHashCode = ((((this.jad_dq.hashCode() + (this.jad_cp.hashCode() * 31)) * 31) + this.jad_er) * 31) + this.jad_fs;
        com.jd.ad.sdk.jad_ju.jad_na<?> jad_naVar = this.jad_iv;
        if (jad_naVar != null) {
            iHashCode = (iHashCode * 31) + jad_naVar.hashCode();
        }
        return this.jad_hu.jad_bo.hashCode() + ((this.jad_jt.hashCode() + (iHashCode * 31)) * 31);
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_hu
    public void jad_an(MessageDigest messageDigest) {
        byte[] bArr = (byte[]) this.jad_bo.jad_bo(8, byte[].class);
        ByteBuffer.wrap(bArr).putInt(this.jad_er).putInt(this.jad_fs).array();
        this.jad_dq.jad_an(messageDigest);
        this.jad_cp.jad_an(messageDigest);
        messageDigest.update(bArr);
        com.jd.ad.sdk.jad_ju.jad_na<?> jad_naVar = this.jad_iv;
        if (jad_naVar != null) {
            jad_naVar.jad_an(messageDigest);
        }
        this.jad_hu.jad_an(messageDigest);
        com.jd.ad.sdk.jad_ir.jad_hu<Class<?>, byte[]> jad_huVar = jad_jw;
        byte[] bArrJad_an = jad_huVar.jad_an(this.jad_jt);
        if (bArrJad_an == null) {
            bArrJad_an = this.jad_jt.getName().getBytes(com.jd.ad.sdk.jad_ju.jad_hu.jad_an);
            jad_huVar.jad_bo(this.jad_jt, bArrJad_an);
        }
        messageDigest.update(bArrJad_an);
        this.jad_bo.jad_an(bArr);
    }

    public String toString() {
        return com.jd.ad.sdk.jad_gr.jad_ly.jad_an("ResourceCacheKey{sourceKey=").append(this.jad_cp).append(", signature=").append(this.jad_dq).append(", width=").append(this.jad_er).append(", height=").append(this.jad_fs).append(", decodedResourceClass=").append(this.jad_jt).append(", transformation='").append(this.jad_iv).append('\'').append(", options=").append(this.jad_hu).append('}').toString();
    }
}
