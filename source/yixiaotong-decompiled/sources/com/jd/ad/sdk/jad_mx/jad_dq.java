package com.jd.ad.sdk.jad_mx;

import java.security.MessageDigest;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class jad_dq implements com.jd.ad.sdk.jad_ju.jad_hu {
    public final com.jd.ad.sdk.jad_ju.jad_hu jad_bo;
    public final com.jd.ad.sdk.jad_ju.jad_hu jad_cp;

    public jad_dq(com.jd.ad.sdk.jad_ju.jad_hu jad_huVar, com.jd.ad.sdk.jad_ju.jad_hu jad_huVar2) {
        this.jad_bo = jad_huVar;
        this.jad_cp = jad_huVar2;
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_hu
    public boolean equals(Object obj) {
        if (!(obj instanceof jad_dq)) {
            return false;
        }
        jad_dq jad_dqVar = (jad_dq) obj;
        return this.jad_bo.equals(jad_dqVar.jad_bo) && this.jad_cp.equals(jad_dqVar.jad_cp);
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_hu
    public int hashCode() {
        return this.jad_cp.hashCode() + (this.jad_bo.hashCode() * 31);
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_hu
    public void jad_an(MessageDigest messageDigest) {
        this.jad_bo.jad_an(messageDigest);
        this.jad_cp.jad_an(messageDigest);
    }

    public String toString() {
        return com.jd.ad.sdk.jad_gr.jad_ly.jad_an("DataCacheKey{sourceKey=").append(this.jad_bo).append(", signature=").append(this.jad_cp).append('}').toString();
    }
}
