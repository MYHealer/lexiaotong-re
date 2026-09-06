package com.jd.ad.sdk.jad_yj;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_fs {
    public final List<jad_an<?, ?>> jad_an = new ArrayList();

    public static final class jad_an<Z, R> {
        public final Class<Z> jad_an;
        public final Class<R> jad_bo;
        public final jad_er<Z, R> jad_cp;

        public jad_an(Class<Z> cls, Class<R> cls2, jad_er<Z, R> jad_erVar) {
            this.jad_an = cls;
            this.jad_bo = cls2;
            this.jad_cp = jad_erVar;
        }
    }

    public synchronized <Z, R> List<Class<R>> jad_an(Class<Z> cls, Class<R> cls2) {
        ArrayList arrayList = new ArrayList();
        if (cls2.isAssignableFrom(cls)) {
            arrayList.add(cls2);
            return arrayList;
        }
        for (jad_an<?, ?> jad_anVar : this.jad_an) {
            if (jad_anVar.jad_an.isAssignableFrom(cls) && cls2.isAssignableFrom(jad_anVar.jad_bo) && !arrayList.contains(jad_anVar.jad_bo)) {
                arrayList.add(jad_anVar.jad_bo);
            }
        }
        return arrayList;
    }
}
