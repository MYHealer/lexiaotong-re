package com.jd.ad.sdk.jad_ju;

import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;
import java.security.MessageDigest;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class jad_jw implements jad_hu {
    public final ArrayMap<jad_iv<?>, Object> jad_bo = new com.jd.ad.sdk.jad_ir.jad_bo();

    @Override // com.jd.ad.sdk.jad_ju.jad_hu
    public boolean equals(Object obj) {
        if (obj instanceof jad_jw) {
            return this.jad_bo.equals(((jad_jw) obj).jad_bo);
        }
        return false;
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_hu
    public int hashCode() {
        return this.jad_bo.hashCode();
    }

    public <T> T jad_an(jad_iv<T> jad_ivVar) {
        return this.jad_bo.containsKey(jad_ivVar) ? (T) this.jad_bo.get(jad_ivVar) : jad_ivVar.jad_an;
    }

    public void jad_an(jad_jw jad_jwVar) {
        this.jad_bo.putAll((SimpleArrayMap<? extends jad_iv<?>, ? extends Object>) jad_jwVar.jad_bo);
    }

    public String toString() {
        return com.jd.ad.sdk.jad_gr.jad_ly.jad_an("Options{values=").append(this.jad_bo).append('}').toString();
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_hu
    public void jad_an(MessageDigest messageDigest) {
        for (int i = 0; i < this.jad_bo.size(); i++) {
            jad_iv<?> jad_ivVarKeyAt = this.jad_bo.keyAt(i);
            Object objValueAt = this.jad_bo.valueAt(i);
            jad_iv.jad_bo<?> jad_boVar = jad_ivVarKeyAt.jad_bo;
            if (jad_ivVarKeyAt.jad_dq == null) {
                jad_ivVarKeyAt.jad_dq = jad_ivVarKeyAt.jad_cp.getBytes(jad_hu.jad_an);
            }
            jad_boVar.jad_an(jad_ivVarKeyAt.jad_dq, objValueAt, messageDigest);
        }
    }
}
