package com.jd.ad.sdk.jad_yh;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_cp<T> {
    public final jad_bo<T> jad_an;
    public T jad_bo;

    public jad_cp() {
        this.jad_an = new jad_bo<>();
        this.jad_bo = null;
    }

    public jad_cp(T t) {
        this.jad_an = new jad_bo<>();
        this.jad_bo = t;
    }

    public final T jad_an(float f, float f2, T t, T t2, float f3, float f4, float f5) {
        jad_bo<T> jad_boVar = this.jad_an;
        jad_boVar.jad_an = t;
        jad_boVar.jad_bo = t2;
        return jad_an(jad_boVar);
    }

    public T jad_an(jad_bo<T> jad_boVar) {
        return this.jad_bo;
    }
}
