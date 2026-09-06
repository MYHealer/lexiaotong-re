package com.jd.ad.sdk.jad_qb;

import androidx.core.util.Pools;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_pc {
    public final jad_re jad_an;
    public final jad_an jad_bo;

    public static class jad_an {
        public final Map<Class<?>, C0579jad_an<?>> jad_an = new HashMap();

        /* JADX INFO: renamed from: com.jd.ad.sdk.jad_qb.jad_pc$jad_an$jad_an, reason: collision with other inner class name */
        public static class C0579jad_an<Model> {
            public final List<jad_na<Model, ?>> jad_an;

            public C0579jad_an(List<jad_na<Model, ?>> list) {
                this.jad_an = list;
            }
        }
    }

    public jad_pc(Pools.Pool<List<Throwable>> pool) {
        this(new jad_re(pool));
    }

    public jad_pc(jad_re jad_reVar) {
        this.jad_bo = new jad_an();
        this.jad_an = jad_reVar;
    }
}
