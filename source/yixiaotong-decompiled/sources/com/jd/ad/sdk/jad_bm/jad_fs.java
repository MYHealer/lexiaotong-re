package com.jd.ad.sdk.jad_bm;

import com.jd.ad.sdk.jad_ju.jad_mz;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_fs {
    public final List<jad_an<?>> jad_an = new ArrayList();

    public static final class jad_an<T> {
        public final Class<T> jad_an;
        public final jad_mz<T> jad_bo;

        public jad_an(Class<T> cls, jad_mz<T> jad_mzVar) {
            this.jad_an = cls;
            this.jad_bo = jad_mzVar;
        }
    }

    public synchronized <Z> jad_mz<Z> jad_an(Class<Z> cls) {
        int size = this.jad_an.size();
        for (int i = 0; i < size; i++) {
            jad_an<?> jad_anVar = this.jad_an.get(i);
            if (jad_anVar.jad_an.isAssignableFrom(cls)) {
                return (jad_mz<Z>) jad_anVar.jad_bo;
            }
        }
        return null;
    }
}
