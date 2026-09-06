package com.jd.ad.sdk.jad_mx;

import androidx.core.util.Pools;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_na<R> implements jad_hu.jad_bo<R>, com.jd.ad.sdk.jad_js.jad_an.jad_dq {
    public static final jad_cp jad_zm = new jad_cp();
    public final jad_re.jad_an jad_cp;
    public final Pools.Pool<jad_na<?>> jad_dq;
    public final jad_cp jad_er;
    public final jad_ob jad_fs;
    public final com.jd.ad.sdk.jad_pa.jad_an jad_hu;
    public final com.jd.ad.sdk.jad_pa.jad_an jad_iv;
    public final com.jd.ad.sdk.jad_pa.jad_an jad_jt;
    public final com.jd.ad.sdk.jad_pa.jad_an jad_jw;
    public com.jd.ad.sdk.jad_ju.jad_hu jad_ly;
    public boolean jad_mz;
    public boolean jad_na;
    public boolean jad_ob;
    public boolean jad_pc;
    public jad_xk<?> jad_qd;
    public com.jd.ad.sdk.jad_ju.jad_an jad_re;
    public boolean jad_sf;
    public jad_sf jad_tg;
    public boolean jad_uh;
    public jad_re<?> jad_vi;
    public jad_hu<R> jad_wj;
    public volatile boolean jad_xk;
    public boolean jad_yl;
    public final jad_er jad_an = new jad_er();
    public final com.jd.ad.sdk.jad_js.jad_dq jad_bo = com.jd.ad.sdk.jad_js.jad_dq.jad_an();
    public final AtomicInteger jad_kx = new AtomicInteger();

    public class jad_an implements Runnable {
        public final com.jd.ad.sdk.jad_en.jad_iv jad_an;

        public jad_an(com.jd.ad.sdk.jad_en.jad_iv jad_ivVar) {
            this.jad_an = jad_ivVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.jd.ad.sdk.jad_en.jad_jw jad_jwVar = (com.jd.ad.sdk.jad_en.jad_jw) this.jad_an;
            jad_jwVar.jad_bo.jad_bo();
            synchronized (jad_jwVar.jad_cp) {
                synchronized (jad_na.this) {
                    if (jad_na.this.jad_an.jad_an.contains(new jad_dq(this.jad_an, com.jd.ad.sdk.jad_ir.jad_er.jad_bo))) {
                        jad_na jad_naVar = jad_na.this;
                        com.jd.ad.sdk.jad_en.jad_iv jad_ivVar = this.jad_an;
                        jad_naVar.getClass();
                        try {
                            ((com.jd.ad.sdk.jad_en.jad_jw) jad_ivVar).jad_an(jad_naVar.jad_tg, 5);
                        } catch (Throwable th) {
                            throw new com.jd.ad.sdk.jad_mx.jad_bo(th);
                        }
                    }
                    jad_na.this.jad_bo();
                }
            }
        }
    }

    public class jad_bo implements Runnable {
        public final com.jd.ad.sdk.jad_en.jad_iv jad_an;

        public jad_bo(com.jd.ad.sdk.jad_en.jad_iv jad_ivVar) {
            this.jad_an = jad_ivVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.jd.ad.sdk.jad_en.jad_jw jad_jwVar = (com.jd.ad.sdk.jad_en.jad_jw) this.jad_an;
            jad_jwVar.jad_bo.jad_bo();
            synchronized (jad_jwVar.jad_cp) {
                synchronized (jad_na.this) {
                    if (jad_na.this.jad_an.jad_an.contains(new jad_dq(this.jad_an, com.jd.ad.sdk.jad_ir.jad_er.jad_bo))) {
                        jad_na.this.jad_vi.jad_an();
                        jad_na jad_naVar = jad_na.this;
                        com.jd.ad.sdk.jad_en.jad_iv jad_ivVar = this.jad_an;
                        jad_naVar.getClass();
                        try {
                            ((com.jd.ad.sdk.jad_en.jad_jw) jad_ivVar).jad_an(jad_naVar.jad_vi, jad_naVar.jad_re, jad_naVar.jad_yl);
                            jad_na.this.jad_an(this.jad_an);
                        } catch (Throwable th) {
                            throw new com.jd.ad.sdk.jad_mx.jad_bo(th);
                        }
                    }
                    jad_na.this.jad_bo();
                }
            }
        }
    }

    public static class jad_cp {
    }

    public static final class jad_dq {
        public final com.jd.ad.sdk.jad_en.jad_iv jad_an;
        public final Executor jad_bo;

        public jad_dq(com.jd.ad.sdk.jad_en.jad_iv jad_ivVar, Executor executor) {
            this.jad_an = jad_ivVar;
            this.jad_bo = executor;
        }

        public boolean equals(Object obj) {
            if (obj instanceof jad_dq) {
                return this.jad_an.equals(((jad_dq) obj).jad_an);
            }
            return false;
        }

        public int hashCode() {
            return this.jad_an.hashCode();
        }
    }

    public static final class jad_er implements Iterable<jad_dq> {
        public final List<jad_dq> jad_an;

        public jad_er() {
            this(new ArrayList(2));
        }

        public jad_er(List<jad_dq> list) {
            this.jad_an = list;
        }

        @Override // java.lang.Iterable
        public Iterator<jad_dq> iterator() {
            return this.jad_an.iterator();
        }
    }

    public jad_na(com.jd.ad.sdk.jad_pa.jad_an jad_anVar, com.jd.ad.sdk.jad_pa.jad_an jad_anVar2, com.jd.ad.sdk.jad_pa.jad_an jad_anVar3, com.jd.ad.sdk.jad_pa.jad_an jad_anVar4, jad_ob jad_obVar, jad_re.jad_an jad_anVar5, Pools.Pool<jad_na<?>> pool, jad_cp jad_cpVar) {
        this.jad_jt = jad_anVar;
        this.jad_hu = jad_anVar2;
        this.jad_iv = jad_anVar3;
        this.jad_jw = jad_anVar4;
        this.jad_fs = jad_obVar;
        this.jad_cp = jad_anVar5;
        this.jad_dq = pool;
        this.jad_er = jad_cpVar;
    }

    @Override // com.jd.ad.sdk.jad_js.jad_an.jad_dq
    public com.jd.ad.sdk.jad_js.jad_dq jad_an() {
        return this.jad_bo;
    }

    public synchronized void jad_an(int i) {
        jad_re<?> jad_reVar;
        com.jd.ad.sdk.jad_ir.jad_kx.jad_an(jad_cp(), "Not yet complete!");
        if (this.jad_kx.getAndAdd(i) == 0 && (jad_reVar = this.jad_vi) != null) {
            jad_reVar.jad_an();
        }
    }

    public synchronized void jad_an(com.jd.ad.sdk.jad_en.jad_iv jad_ivVar, Executor executor) {
        Runnable jad_anVar;
        this.jad_bo.jad_bo();
        this.jad_an.jad_an.add(new jad_dq(jad_ivVar, executor));
        if (this.jad_sf) {
            jad_an(1);
            jad_anVar = new jad_bo(jad_ivVar);
        } else if (this.jad_uh) {
            jad_an(1);
            jad_anVar = new jad_an(jad_ivVar);
        } else {
            com.jd.ad.sdk.jad_ir.jad_kx.jad_an(!this.jad_xk, "Cannot add callbacks to a cancelled EngineJob");
        }
        executor.execute(jad_anVar);
    }

    public void jad_bo() {
        jad_re<?> jad_reVar;
        synchronized (this) {
            this.jad_bo.jad_bo();
            com.jd.ad.sdk.jad_ir.jad_kx.jad_an(jad_cp(), "Not yet complete!");
            int iDecrementAndGet = this.jad_kx.decrementAndGet();
            com.jd.ad.sdk.jad_ir.jad_kx.jad_an(iDecrementAndGet >= 0, "Can't decrement below 0");
            if (iDecrementAndGet == 0) {
                jad_reVar = this.jad_vi;
                jad_dq();
            } else {
                jad_reVar = null;
            }
        }
        if (jad_reVar != null) {
            jad_reVar.jad_jt();
        }
    }

    public final boolean jad_cp() {
        return this.jad_uh || this.jad_sf || this.jad_xk;
    }

    public final synchronized void jad_dq() {
        boolean zJad_an;
        if (this.jad_ly == null) {
            throw new IllegalArgumentException();
        }
        this.jad_an.jad_an.clear();
        this.jad_ly = null;
        this.jad_vi = null;
        this.jad_qd = null;
        this.jad_uh = false;
        this.jad_xk = false;
        this.jad_sf = false;
        this.jad_yl = false;
        jad_hu<R> jad_huVar = this.jad_wj;
        jad_hu.jad_fs jad_fsVar = jad_huVar.jad_jt;
        synchronized (jad_fsVar) {
            jad_fsVar.jad_an = true;
            zJad_an = jad_fsVar.jad_an(false);
        }
        if (zJad_an) {
            jad_huVar.jad_fs();
        }
        this.jad_wj = null;
        this.jad_tg = null;
        this.jad_re = null;
        this.jad_dq.release(this);
    }

    public synchronized void jad_an(com.jd.ad.sdk.jad_en.jad_iv jad_ivVar) {
        this.jad_bo.jad_bo();
        this.jad_an.jad_an.remove(new jad_dq(jad_ivVar, com.jd.ad.sdk.jad_ir.jad_er.jad_bo));
        if (this.jad_an.jad_an.isEmpty()) {
            if (!jad_cp()) {
                this.jad_xk = true;
                jad_hu<R> jad_huVar = this.jad_wj;
                jad_huVar.jad_gr = true;
                jad_fs jad_fsVar = jad_huVar.jad_ep;
                if (jad_fsVar != null) {
                    jad_fsVar.jad_cp();
                }
                jad_ob jad_obVar = this.jad_fs;
                com.jd.ad.sdk.jad_ju.jad_hu jad_huVar2 = this.jad_ly;
                jad_mz jad_mzVar = (jad_mz) jad_obVar;
                synchronized (jad_mzVar) {
                    jad_uh jad_uhVar = jad_mzVar.jad_an;
                    jad_uhVar.getClass();
                    Map<com.jd.ad.sdk.jad_ju.jad_hu, jad_na<?>> mapJad_an = jad_uhVar.jad_an(this.jad_pc);
                    if (equals(mapJad_an.get(jad_huVar2))) {
                        mapJad_an.remove(jad_huVar2);
                    }
                }
            }
            if ((this.jad_sf || this.jad_uh) && this.jad_kx.get() == 0) {
                jad_dq();
            }
        }
    }

    public void jad_an(jad_hu<?> jad_huVar) {
        com.jd.ad.sdk.jad_pa.jad_an jad_anVar;
        if (this.jad_na) {
            jad_anVar = this.jad_iv;
        } else {
            jad_anVar = this.jad_ob ? this.jad_jw : this.jad_hu;
        }
        jad_anVar.jad_an.execute(jad_huVar);
    }
}
