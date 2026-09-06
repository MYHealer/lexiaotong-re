package com.jd.ad.sdk.jad_mx;

import java.security.MessageDigest;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_pc implements com.jd.ad.sdk.jad_ju.jad_hu {
    public final Object jad_bo;
    public final int jad_cp;
    public final int jad_dq;
    public final Class<?> jad_er;
    public final Class<?> jad_fs;
    public final Map<Class<?>, com.jd.ad.sdk.jad_ju.jad_na<?>> jad_hu;
    public final com.jd.ad.sdk.jad_ju.jad_jw jad_iv;
    public final com.jd.ad.sdk.jad_ju.jad_hu jad_jt;
    public int jad_jw;

    public jad_pc(Object obj, com.jd.ad.sdk.jad_ju.jad_hu jad_huVar, int i, int i2, Map<Class<?>, com.jd.ad.sdk.jad_ju.jad_na<?>> map, Class<?> cls, Class<?> cls2, com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar) {
        this.jad_bo = com.jd.ad.sdk.jad_ir.jad_kx.jad_an(obj);
        this.jad_jt = (com.jd.ad.sdk.jad_ju.jad_hu) com.jd.ad.sdk.jad_ir.jad_kx.jad_an(jad_huVar, "Signature must not be null");
        this.jad_cp = i;
        this.jad_dq = i2;
        this.jad_hu = (Map) com.jd.ad.sdk.jad_ir.jad_kx.jad_an(map);
        this.jad_er = (Class) com.jd.ad.sdk.jad_ir.jad_kx.jad_an(cls, "Resource class must not be null");
        this.jad_fs = (Class) com.jd.ad.sdk.jad_ir.jad_kx.jad_an(cls2, "Transcode class must not be null");
        this.jad_iv = (com.jd.ad.sdk.jad_ju.jad_jw) com.jd.ad.sdk.jad_ir.jad_kx.jad_an(jad_jwVar);
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_hu
    public boolean equals(Object obj) {
        if (!(obj instanceof jad_pc)) {
            return false;
        }
        jad_pc jad_pcVar = (jad_pc) obj;
        return this.jad_bo.equals(jad_pcVar.jad_bo) && this.jad_jt.equals(jad_pcVar.jad_jt) && this.jad_dq == jad_pcVar.jad_dq && this.jad_cp == jad_pcVar.jad_cp && this.jad_hu.equals(jad_pcVar.jad_hu) && this.jad_er.equals(jad_pcVar.jad_er) && this.jad_fs.equals(jad_pcVar.jad_fs) && this.jad_iv.equals(jad_pcVar.jad_iv);
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_hu
    public int hashCode() {
        if (this.jad_jw == 0) {
            int iHashCode = this.jad_bo.hashCode();
            this.jad_jw = iHashCode;
            int iHashCode2 = ((((this.jad_jt.hashCode() + (iHashCode * 31)) * 31) + this.jad_cp) * 31) + this.jad_dq;
            this.jad_jw = iHashCode2;
            int iHashCode3 = this.jad_hu.hashCode() + (iHashCode2 * 31);
            this.jad_jw = iHashCode3;
            int iHashCode4 = this.jad_er.hashCode() + (iHashCode3 * 31);
            this.jad_jw = iHashCode4;
            int iHashCode5 = this.jad_fs.hashCode() + (iHashCode4 * 31);
            this.jad_jw = iHashCode5;
            this.jad_jw = this.jad_iv.jad_bo.hashCode() + (iHashCode5 * 31);
        }
        return this.jad_jw;
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_hu
    public void jad_an(MessageDigest messageDigest) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        return com.jd.ad.sdk.jad_gr.jad_ly.jad_an("EngineKey{model=").append(this.jad_bo).append(", width=").append(this.jad_cp).append(", height=").append(this.jad_dq).append(", resourceClass=").append(this.jad_er).append(", transcodeClass=").append(this.jad_fs).append(", signature=").append(this.jad_jt).append(", hashCode=").append(this.jad_jw).append(", transformations=").append(this.jad_hu).append(", options=").append(this.jad_iv).append('}').toString();
    }
}
