package com.jd.ad.sdk.jad_gr;

import androidx.core.util.Pools;
import com.bumptech.glide.Registry;
import com.jd.ad.sdk.jad_ju.jad_mz;
import com.jd.ad.sdk.jad_qb.jad_na;
import com.jd.ad.sdk.jad_qb.jad_ob;
import com.jd.ad.sdk.jad_qb.jad_pc;
import com.jd.ad.sdk.jad_qb.jad_re;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_hu {
    public final jad_pc jad_an;
    public final com.jd.ad.sdk.jad_bm.jad_an jad_bo;
    public final com.jd.ad.sdk.jad_bm.jad_er jad_cp;
    public final com.jd.ad.sdk.jad_bm.jad_fs jad_dq;
    public final com.jd.ad.sdk.jad_kv.jad_fs jad_er;
    public final com.jd.ad.sdk.jad_yj.jad_fs jad_fs;
    public final com.jd.ad.sdk.jad_bm.jad_dq jad_hu = new com.jd.ad.sdk.jad_bm.jad_dq();
    public final com.jd.ad.sdk.jad_bm.jad_cp jad_iv = new com.jd.ad.sdk.jad_bm.jad_cp();
    public final com.jd.ad.sdk.jad_bm.jad_bo jad_jt;
    public final Pools.Pool<List<Throwable>> jad_jw;

    public static class jad_an extends RuntimeException {
        public jad_an(String str) {
            super(str);
        }
    }

    public static final class jad_bo extends jad_an {
        public jad_bo() {
            super("Failed to find image header parser.");
        }
    }

    public static class jad_cp extends jad_an {
        public jad_cp(Class<?> cls, Class<?> cls2) {
            super("Failed to find any ModelLoaders for model: " + cls + " and data: " + cls2);
        }

        public jad_cp(Object obj) {
            super(jad_ly.jad_an("Failed to find any ModelLoaders registered for model class: ").append(obj.getClass()).toString());
        }

        public <M> jad_cp(M m, List<jad_na<M, ?>> list) {
            super("Found ModelLoaders for model class: " + list + ", but none that handle this specific model instance: " + m);
        }
    }

    public static class jad_dq extends jad_an {
        public jad_dq(Class<?> cls) {
            super("Failed to find result encoder for resource class: " + cls + ", you may need to consider registering a new Encoder for the requested type or DiskCacheStrategy.DATA/DiskCacheStrategy.NONE if caching your transformed resource is unnecessary.");
        }
    }

    public static class jad_er extends jad_an {
        public jad_er(Class<?> cls) {
            super("Failed to find source encoder for data class: " + cls);
        }
    }

    public jad_hu() {
        Pools.Pool<List<Throwable>> poolJad_an = com.jd.ad.sdk.jad_js.jad_an.jad_an();
        this.jad_jw = poolJad_an;
        this.jad_an = new jad_pc(poolJad_an);
        this.jad_bo = new com.jd.ad.sdk.jad_bm.jad_an();
        this.jad_cp = new com.jd.ad.sdk.jad_bm.jad_er();
        this.jad_dq = new com.jd.ad.sdk.jad_bm.jad_fs();
        this.jad_er = new com.jd.ad.sdk.jad_kv.jad_fs();
        this.jad_fs = new com.jd.ad.sdk.jad_yj.jad_fs();
        this.jad_jt = new com.jd.ad.sdk.jad_bm.jad_bo();
        jad_an(Arrays.asList("Animation", Registry.BUCKET_BITMAP, Registry.BUCKET_BITMAP_DRAWABLE));
    }

    public <Data> jad_hu jad_an(Class<Data> cls, com.jd.ad.sdk.jad_ju.jad_dq<Data> jad_dqVar) {
        com.jd.ad.sdk.jad_bm.jad_an jad_anVar = this.jad_bo;
        synchronized (jad_anVar) {
            jad_anVar.jad_an.add(new com.jd.ad.sdk.jad_bm.jad_an.C0549jad_an<>(cls, jad_dqVar));
        }
        return this;
    }

    public <Data, TResource> jad_hu jad_an(Class<Data> cls, Class<TResource> cls2, com.jd.ad.sdk.jad_ju.jad_ly<Data, TResource> jad_lyVar) {
        jad_an("legacy_append", cls, cls2, jad_lyVar);
        return this;
    }

    public <TResource> jad_hu jad_an(Class<TResource> cls, jad_mz<TResource> jad_mzVar) {
        com.jd.ad.sdk.jad_bm.jad_fs jad_fsVar = this.jad_dq;
        synchronized (jad_fsVar) {
            jad_fsVar.jad_an.add(new com.jd.ad.sdk.jad_bm.jad_fs.jad_an<>(cls, jad_mzVar));
        }
        return this;
    }

    public <X> com.jd.ad.sdk.jad_kv.jad_er<X> jad_bo(X x) {
        com.jd.ad.sdk.jad_kv.jad_er<X> jad_erVar;
        com.jd.ad.sdk.jad_kv.jad_fs jad_fsVar = this.jad_er;
        synchronized (jad_fsVar) {
            try {
                if (x == null) {
                    throw new NullPointerException("Argument must not be null");
                }
                com.jd.ad.sdk.jad_kv.jad_er.jad_an<?> jad_anVar = jad_fsVar.jad_an.get(x.getClass());
                if (jad_anVar == null) {
                    for (com.jd.ad.sdk.jad_kv.jad_er.jad_an<?> jad_anVar2 : jad_fsVar.jad_an.values()) {
                        if (jad_anVar2.jad_an().isAssignableFrom(x.getClass())) {
                            jad_anVar = jad_anVar2;
                            break;
                        }
                    }
                }
                if (jad_anVar == null) {
                    jad_anVar = com.jd.ad.sdk.jad_kv.jad_fs.jad_bo;
                }
                jad_erVar = (com.jd.ad.sdk.jad_kv.jad_er<X>) jad_anVar.jad_an(x);
            } catch (Throwable th) {
                throw th;
            }
        }
        return jad_erVar;
    }

    public <Model, Data> jad_hu jad_an(Class<Model> cls, Class<Data> cls2, jad_ob<Model, Data> jad_obVar) {
        jad_pc jad_pcVar = this.jad_an;
        synchronized (jad_pcVar) {
            jad_re jad_reVar = jad_pcVar.jad_an;
            synchronized (jad_reVar) {
                jad_re.jad_bo<?, ?> jad_boVar = new jad_re.jad_bo<>(cls, cls2, jad_obVar);
                List<jad_re.jad_bo<?, ?>> list = jad_reVar.jad_an;
                list.add(list.size(), jad_boVar);
            }
            jad_pcVar.jad_bo.jad_an.clear();
        }
        return this;
    }

    public <Data, TResource> jad_hu jad_an(String str, Class<Data> cls, Class<TResource> cls2, com.jd.ad.sdk.jad_ju.jad_ly<Data, TResource> jad_lyVar) {
        List<com.jd.ad.sdk.jad_bm.jad_er.jad_an<?, ?>> arrayList;
        com.jd.ad.sdk.jad_bm.jad_er jad_erVar = this.jad_cp;
        synchronized (jad_erVar) {
            synchronized (jad_erVar) {
                if (!jad_erVar.jad_an.contains(str)) {
                    jad_erVar.jad_an.add(str);
                }
                arrayList = jad_erVar.jad_bo.get(str);
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                    jad_erVar.jad_bo.put(str, arrayList);
                }
            }
            return this;
        }
        arrayList.add(new com.jd.ad.sdk.jad_bm.jad_er.jad_an<>(cls, cls2, jad_lyVar));
        return this;
    }

    public List<com.jd.ad.sdk.jad_ju.jad_fs> jad_an() {
        List<com.jd.ad.sdk.jad_ju.jad_fs> list;
        com.jd.ad.sdk.jad_bm.jad_bo jad_boVar = this.jad_jt;
        synchronized (jad_boVar) {
            list = jad_boVar.jad_an;
        }
        if (list.isEmpty()) {
            throw new jad_bo();
        }
        return list;
    }

    public <Model> List<jad_na<Model, ?>> jad_an(Model model) {
        List<jad_na<?, ?>> listUnmodifiableList;
        ArrayList arrayList;
        jad_pc jad_pcVar = this.jad_an;
        jad_pcVar.getClass();
        Class<?> cls = model.getClass();
        synchronized (jad_pcVar) {
            jad_pc.jad_an.C0579jad_an<?> c0579jad_an = jad_pcVar.jad_bo.jad_an.get(cls);
            listUnmodifiableList = c0579jad_an == null ? null : c0579jad_an.jad_an;
            if (listUnmodifiableList == null) {
                jad_re jad_reVar = jad_pcVar.jad_an;
                synchronized (jad_reVar) {
                    try {
                        arrayList = new ArrayList();
                        for (jad_re.jad_bo<?, ?> jad_boVar : jad_reVar.jad_an) {
                            if (!jad_reVar.jad_cp.contains(jad_boVar) && jad_boVar.jad_an.isAssignableFrom(cls)) {
                                jad_reVar.jad_cp.add(jad_boVar);
                                arrayList.add((jad_na) com.jd.ad.sdk.jad_ir.jad_kx.jad_an(jad_boVar.jad_cp.jad_an(jad_reVar)));
                                jad_reVar.jad_cp.remove(jad_boVar);
                            }
                        }
                    } catch (Throwable th) {
                        jad_reVar.jad_cp.clear();
                        throw th;
                    }
                }
                listUnmodifiableList = Collections.unmodifiableList(arrayList);
                if (jad_pcVar.jad_bo.jad_an.put(cls, new jad_pc.jad_an.C0579jad_an<>(listUnmodifiableList)) != null) {
                    throw new IllegalStateException("Already cached loaders for model: " + cls);
                }
            }
        }
        if (listUnmodifiableList.isEmpty()) {
            throw new jad_cp(model);
        }
        int size = listUnmodifiableList.size();
        List<jad_na<Model, ?>> listEmptyList = Collections.emptyList();
        boolean z = true;
        for (int i = 0; i < size; i++) {
            jad_na<?, ?> jad_naVar = listUnmodifiableList.get(i);
            if (jad_naVar.jad_an(model)) {
                if (z) {
                    listEmptyList = new ArrayList<>(size - i);
                    z = false;
                }
                listEmptyList.add(jad_naVar);
            }
        }
        if (listEmptyList.isEmpty()) {
            throw new jad_cp(model, (List<jad_na<Model, ?>>) listUnmodifiableList);
        }
        return listEmptyList;
    }

    public jad_hu jad_an(com.jd.ad.sdk.jad_ju.jad_fs jad_fsVar) {
        com.jd.ad.sdk.jad_bm.jad_bo jad_boVar = this.jad_jt;
        synchronized (jad_boVar) {
            jad_boVar.jad_an.add(jad_fsVar);
        }
        return this;
    }

    public jad_hu jad_an(com.jd.ad.sdk.jad_kv.jad_er.jad_an<?> jad_anVar) {
        com.jd.ad.sdk.jad_kv.jad_fs jad_fsVar = this.jad_er;
        synchronized (jad_fsVar) {
            jad_fsVar.jad_an.put(jad_anVar.jad_an(), jad_anVar);
        }
        return this;
    }

    public <TResource, Transcode> jad_hu jad_an(Class<TResource> cls, Class<Transcode> cls2, com.jd.ad.sdk.jad_yj.jad_er<TResource, Transcode> jad_erVar) {
        com.jd.ad.sdk.jad_yj.jad_fs jad_fsVar = this.jad_fs;
        synchronized (jad_fsVar) {
            jad_fsVar.jad_an.add(new com.jd.ad.sdk.jad_yj.jad_fs.jad_an<>(cls, cls2, jad_erVar));
        }
        return this;
    }

    public final jad_hu jad_an(List<String> list) {
        ArrayList arrayList = new ArrayList(list.size());
        arrayList.add("legacy_prepend_all");
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        arrayList.add("legacy_append");
        com.jd.ad.sdk.jad_bm.jad_er jad_erVar = this.jad_cp;
        synchronized (jad_erVar) {
            ArrayList<String> arrayList2 = new ArrayList(jad_erVar.jad_an);
            jad_erVar.jad_an.clear();
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                jad_erVar.jad_an.add((String) it2.next());
            }
            for (String str : arrayList2) {
                if (!arrayList.contains(str)) {
                    jad_erVar.jad_an.add(str);
                }
            }
        }
        return this;
    }
}
