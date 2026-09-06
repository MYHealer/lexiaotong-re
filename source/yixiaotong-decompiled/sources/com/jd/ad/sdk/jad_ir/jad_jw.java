package com.jd.ad.sdk.jad_ir;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_jw {
    public Class<?> jad_an;
    public Class<?> jad_bo;
    public Class<?> jad_cp;

    public jad_jw() {
    }

    public jad_jw(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        jad_an(cls, cls2, cls3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || jad_jw.class != obj.getClass()) {
            return false;
        }
        jad_jw jad_jwVar = (jad_jw) obj;
        return this.jad_an.equals(jad_jwVar.jad_an) && this.jad_bo.equals(jad_jwVar.jad_bo) && jad_ly.jad_an(this.jad_cp, jad_jwVar.jad_cp);
    }

    public int hashCode() {
        int iHashCode = (this.jad_bo.hashCode() + (this.jad_an.hashCode() * 31)) * 31;
        Class<?> cls = this.jad_cp;
        return iHashCode + (cls != null ? cls.hashCode() : 0);
    }

    public void jad_an(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        this.jad_an = cls;
        this.jad_bo = cls2;
        this.jad_cp = cls3;
    }

    public String toString() {
        return com.jd.ad.sdk.jad_gr.jad_ly.jad_an("MultiClassKey{first=").append(this.jad_an).append(", second=").append(this.jad_bo).append('}').toString();
    }
}
