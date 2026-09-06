package com.jd.ad.sdk.jad_qb;

import androidx.core.util.Pools;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_re {
    public static final jad_cp jad_er = new jad_cp();
    public static final jad_na<Object, Object> jad_fs = new jad_an();
    public final List<jad_bo<?, ?>> jad_an;
    public final jad_cp jad_bo;
    public final Set<jad_bo<?, ?>> jad_cp;
    public final Pools.Pool<List<Throwable>> jad_dq;

    public static class jad_an implements jad_na<Object, Object> {
        @Override // com.jd.ad.sdk.jad_qb.jad_na
        public jad_na.jad_an<Object> jad_an(Object obj, int i, int i2, com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar) {
            return null;
        }

        @Override // com.jd.ad.sdk.jad_qb.jad_na
        public boolean jad_an(Object obj) {
            return false;
        }
    }

    public static class jad_bo<Model, Data> {
        public final Class<Model> jad_an;
        public final Class<Data> jad_bo;
        public final jad_ob<? extends Model, ? extends Data> jad_cp;

        public jad_bo(Class<Model> cls, Class<Data> cls2, jad_ob<? extends Model, ? extends Data> jad_obVar) {
            this.jad_an = cls;
            this.jad_bo = cls2;
            this.jad_cp = jad_obVar;
        }
    }

    public static class jad_cp {
    }

    public jad_re(Pools.Pool<List<Throwable>> pool) {
        this(pool, jad_er);
    }

    public jad_re(Pools.Pool<List<Throwable>> pool, jad_cp jad_cpVar) {
        this.jad_an = new ArrayList();
        this.jad_cp = new HashSet();
        this.jad_dq = pool;
        this.jad_bo = jad_cpVar;
    }

    public final <Model, Data> jad_na<Model, Data> jad_an(jad_bo<?, ?> jad_boVar) {
        return (jad_na) com.jd.ad.sdk.jad_ir.jad_kx.jad_an(jad_boVar.jad_cp.jad_an(this));
    }

    public synchronized <Model, Data> jad_na<Model, Data> jad_an(Class<Model> cls, Class<Data> cls2) {
        try {
            ArrayList arrayList = new ArrayList();
            boolean z = false;
            for (jad_bo<?, ?> jad_boVar : this.jad_an) {
                if (this.jad_cp.contains(jad_boVar)) {
                    z = true;
                } else if (jad_boVar.jad_an.isAssignableFrom(cls) && jad_boVar.jad_bo.isAssignableFrom(cls2)) {
                    this.jad_cp.add(jad_boVar);
                    arrayList.add(jad_an(jad_boVar));
                    this.jad_cp.remove(jad_boVar);
                }
            }
            if (arrayList.size() > 1) {
                jad_cp jad_cpVar = this.jad_bo;
                Pools.Pool<List<Throwable>> pool = this.jad_dq;
                jad_cpVar.getClass();
                return new jad_qd(arrayList, pool);
            }
            if (arrayList.size() == 1) {
                return (jad_na) arrayList.get(0);
            }
            if (!z) {
                throw new com.jd.ad.sdk.jad_gr.jad_hu.jad_cp((Class<?>) cls, (Class<?>) cls2);
            }
            return (jad_na<Model, Data>) jad_fs;
        } catch (Throwable th) {
            this.jad_cp.clear();
            throw th;
        }
    }
}
