package com.jd.ad.sdk.jad_ny;

import android.util.Log;
import com.jd.ad.sdk.logger.Logger;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class jad_jw implements com.jd.ad.sdk.jad_ny.jad_bo {
    public final jad_hu<jad_an, Object> jad_an = new jad_hu<>();
    public final jad_bo jad_bo = new jad_bo();
    public final Map<Class<?>, NavigableMap<Integer, Integer>> jad_cp = new HashMap();
    public final Map<Class<?>, com.jd.ad.sdk.jad_ny.jad_an<?>> jad_dq = new HashMap();
    public final int jad_er;
    public int jad_fs;

    public static final class jad_an implements jad_mz {
        public final jad_bo jad_an;
        public int jad_bo;
        public Class<?> jad_cp;

        public jad_an(jad_bo jad_boVar) {
            this.jad_an = jad_boVar;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof jad_an)) {
                return false;
            }
            jad_an jad_anVar = (jad_an) obj;
            return this.jad_bo == jad_anVar.jad_bo && this.jad_cp == jad_anVar.jad_cp;
        }

        public int hashCode() {
            int i = this.jad_bo * 31;
            Class<?> cls = this.jad_cp;
            return i + (cls != null ? cls.hashCode() : 0);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to com.jd.ad.sdk.jad_ny.jad_jw$jad_an for r3v1 'this'  java.lang.Object
            	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
            	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
            	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
            	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
            	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
            */
        @Override // com.jd.ad.sdk.jad_ny.jad_mz
        public void jad_an() {
            /*
                r3 = this;
                com.jd.ad.sdk.jad_ny.jad_jw$jad_bo r0 = r3.jad_an
                java.util.Queue<T extends com.jd.ad.sdk.jad_ny.jad_mz> r1 = r0.jad_an
                int r1 = r1.size()
                r2 = 20
                if (r1 >= r2) goto L11
                java.util.Queue<T extends com.jd.ad.sdk.jad_ny.jad_mz> r0 = r0.jad_an
                r0.offer(r3)
            L11:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.jad_ny.jad_jw.jad_an.jad_an():void");
        }

        public String toString() {
            return com.jd.ad.sdk.jad_gr.jad_ly.jad_an("Key{size=").append(this.jad_bo).append("array=").append(this.jad_cp).append('}').toString();
        }
    }

    public static final class jad_bo extends jad_dq<jad_an> {
        @Override // com.jd.ad.sdk.jad_ny.jad_dq
        public jad_mz jad_an() {
            return new jad_an(this);
        }

        public jad_an jad_an(int i, Class<?> cls) {
            jad_an jad_anVarJad_bo = jad_bo();
            jad_anVarJad_bo.jad_bo = i;
            jad_anVarJad_bo.jad_cp = cls;
            return jad_anVarJad_bo;
        }
    }

    public jad_jw(int i) {
        this.jad_er = i;
    }

    public final <T> com.jd.ad.sdk.jad_ny.jad_an<T> jad_an(Class<T> cls) {
        com.jd.ad.sdk.jad_ny.jad_an<T> jad_jtVar = (com.jd.ad.sdk.jad_ny.jad_an) this.jad_dq.get(cls);
        if (jad_jtVar == null) {
            if (cls.equals(int[].class)) {
                jad_jtVar = new jad_iv();
            } else {
                if (!cls.equals(byte[].class)) {
                    throw new IllegalArgumentException(com.jd.ad.sdk.jad_gr.jad_ly.jad_an("No array pool found for: ").append(cls.getSimpleName()).toString());
                }
                jad_jtVar = new jad_jt();
            }
            this.jad_dq.put(cls, jad_jtVar);
        }
        return jad_jtVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.jd.ad.sdk.jad_ny.jad_bo
    public synchronized <T> T jad_an(int i, Class<T> cls) {
        jad_an jad_anVarJad_an;
        int i2;
        Integer numCeilingKey = jad_bo((Class<?>) cls).ceilingKey(Integer.valueOf(i));
        if (numCeilingKey == null || ((i2 = this.jad_fs) != 0 && this.jad_er / i2 < 2 && numCeilingKey.intValue() > i * 8)) {
            jad_an jad_anVarJad_bo = this.jad_bo.jad_bo();
            jad_anVarJad_bo.jad_bo = i;
            jad_anVarJad_bo.jad_cp = cls;
            jad_anVarJad_an = jad_anVarJad_bo;
        } else {
            jad_anVarJad_an = this.jad_bo.jad_an(numCeilingKey.intValue(), cls);
        }
        return (T) jad_an(jad_anVarJad_an, cls);
    }

    @Override // com.jd.ad.sdk.jad_ny.jad_bo
    public synchronized void jad_an() {
        jad_bo(0);
    }

    public final NavigableMap<Integer, Integer> jad_bo(Class<?> cls) {
        NavigableMap<Integer, Integer> navigableMap = this.jad_cp.get(cls);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.jad_cp.put(cls, treeMap);
        return treeMap;
    }

    public final void jad_bo(int i) {
        while (this.jad_fs > i) {
            Object objJad_an = this.jad_an.jad_an();
            com.jd.ad.sdk.jad_ir.jad_kx.jad_an(objJad_an);
            com.jd.ad.sdk.jad_ny.jad_an jad_anVarJad_an = jad_an((Class) objJad_an.getClass());
            this.jad_fs -= jad_anVarJad_an.jad_bo() * jad_anVarJad_an.jad_an(objJad_an);
            jad_cp(jad_anVarJad_an.jad_an(objJad_an), objJad_an.getClass());
            if (Log.isLoggable(jad_anVarJad_an.jad_an(), 2)) {
                Logger.v(jad_anVarJad_an.jad_an(), com.jd.ad.sdk.jad_gr.jad_ly.jad_an("evicted: ").append(jad_anVarJad_an.jad_an(objJad_an)).toString());
            }
        }
    }

    public final void jad_cp(int i, Class<?> cls) {
        NavigableMap<Integer, Integer> navigableMapJad_bo = jad_bo(cls);
        Integer num = (Integer) navigableMapJad_bo.get(Integer.valueOf(i));
        if (num == null) {
            throw new NullPointerException("Tried to decrement empty size, size: " + i + ", this: " + this);
        }
        int iIntValue = num.intValue();
        Integer numValueOf = Integer.valueOf(i);
        if (iIntValue == 1) {
            navigableMapJad_bo.remove(numValueOf);
        } else {
            navigableMapJad_bo.put(numValueOf, Integer.valueOf(num.intValue() - 1));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.jd.ad.sdk.jad_ny.jad_bo
    public synchronized <T> T jad_bo(int i, Class<T> cls) {
        jad_an jad_anVarJad_bo;
        jad_anVarJad_bo = this.jad_bo.jad_bo();
        jad_anVarJad_bo.jad_bo = i;
        jad_anVarJad_bo.jad_cp = cls;
        return (T) jad_an(jad_anVarJad_bo, cls);
    }

    public final <T> T jad_an(jad_an jad_anVar, Class<T> cls) {
        com.jd.ad.sdk.jad_ny.jad_an<T> jad_anVarJad_an = jad_an((Class) cls);
        T t = (T) this.jad_an.jad_an(jad_anVar);
        if (t != null) {
            this.jad_fs -= jad_anVarJad_an.jad_bo() * jad_anVarJad_an.jad_an(t);
            jad_cp(jad_anVarJad_an.jad_an(t), cls);
        }
        if (t != null) {
            return t;
        }
        if (Log.isLoggable(jad_anVarJad_an.jad_an(), 2)) {
            Logger.v(jad_anVarJad_an.jad_an(), com.jd.ad.sdk.jad_gr.jad_ly.jad_an("Allocated ").append(jad_anVar.jad_bo).append(" bytes").toString());
        }
        return jad_anVarJad_an.newArray(jad_anVar.jad_bo);
    }

    @Override // com.jd.ad.sdk.jad_ny.jad_bo
    public synchronized <T> void jad_an(T t) {
        Class<?> cls = t.getClass();
        com.jd.ad.sdk.jad_ny.jad_an<T> jad_anVarJad_an = jad_an((Class) cls);
        int iJad_an = jad_anVarJad_an.jad_an(t);
        int iJad_bo = jad_anVarJad_an.jad_bo() * iJad_an;
        if (iJad_bo <= this.jad_er / 2) {
            jad_an jad_anVarJad_an2 = this.jad_bo.jad_an(iJad_an, cls);
            this.jad_an.jad_an(jad_anVarJad_an2, t);
            NavigableMap<Integer, Integer> navigableMapJad_bo = jad_bo(cls);
            Integer num = (Integer) navigableMapJad_bo.get(Integer.valueOf(jad_anVarJad_an2.jad_bo));
            Integer numValueOf = Integer.valueOf(jad_anVarJad_an2.jad_bo);
            int iIntValue = 1;
            if (num != null) {
                iIntValue = 1 + num.intValue();
            }
            navigableMapJad_bo.put(numValueOf, Integer.valueOf(iIntValue));
            this.jad_fs += iJad_bo;
            jad_bo(this.jad_er);
        }
    }

    @Override // com.jd.ad.sdk.jad_ny.jad_bo
    public synchronized void jad_an(int i) {
        try {
            if (i >= 40) {
                synchronized (this) {
                    jad_bo(0);
                }
            } else if (i >= 20 || i == 15) {
                jad_bo(this.jad_er / 2);
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
