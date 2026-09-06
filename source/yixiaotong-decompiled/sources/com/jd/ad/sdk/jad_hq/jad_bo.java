package com.jd.ad.sdk.jad_hq;

import com.jd.ad.sdk.jad_gr.jad_ly;
import com.jd.ad.sdk.jad_ir.jad_kx;
import com.jd.ad.sdk.jad_ju.jad_hu;
import java.security.MessageDigest;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class jad_bo implements jad_hu {
    public final Object jad_bo;

    public jad_bo(Object obj) {
        this.jad_bo = jad_kx.jad_an(obj);
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_hu
    public boolean equals(Object obj) {
        if (obj instanceof jad_bo) {
            return this.jad_bo.equals(((jad_bo) obj).jad_bo);
        }
        return false;
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_hu
    public int hashCode() {
        return this.jad_bo.hashCode();
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_hu
    public void jad_an(MessageDigest messageDigest) {
        messageDigest.update(this.jad_bo.toString().getBytes(jad_hu.jad_an));
    }

    public String toString() {
        return jad_ly.jad_an("ObjectKey{object=").append(this.jad_bo).append('}').toString();
    }
}
