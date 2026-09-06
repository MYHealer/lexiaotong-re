package com.jd.ad.sdk.jad_bm;

import com.jd.ad.sdk.jad_ju.jad_ly;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_er {
    public final List<String> jad_an = new ArrayList();
    public final Map<String, List<jad_an<?, ?>>> jad_bo = new HashMap();

    public static class jad_an<T, R> {
        public final Class<T> jad_an;
        public final Class<R> jad_bo;
        public final jad_ly<T, R> jad_cp;

        public jad_an(Class<T> cls, Class<R> cls2, jad_ly<T, R> jad_lyVar) {
            this.jad_an = cls;
            this.jad_bo = cls2;
            this.jad_cp = jad_lyVar;
        }
    }

    public synchronized <T, R> List<Class<R>> jad_an(Class<T> cls, Class<R> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator<String> it = this.jad_an.iterator();
        while (it.hasNext()) {
            List<jad_an<?, ?>> list = this.jad_bo.get(it.next());
            if (list != null) {
                for (jad_an<?, ?> jad_anVar : list) {
                    if (jad_anVar.jad_an.isAssignableFrom(cls) && cls2.isAssignableFrom(jad_anVar.jad_bo) && !arrayList.contains(jad_anVar.jad_bo)) {
                        arrayList.add(jad_anVar.jad_bo);
                    }
                }
            }
        }
        return arrayList;
    }
}
