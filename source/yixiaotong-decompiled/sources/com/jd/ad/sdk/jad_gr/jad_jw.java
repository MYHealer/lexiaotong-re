package com.jd.ad.sdk.jad_gr;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.alipay.sdk.util.i;
import com.jd.ad.sdk.jad_zk.jad_mz;
import com.jd.ad.sdk.jad_zk.jad_qd;
import com.jd.ad.sdk.jad_zk.jad_re;
import com.jd.ad.sdk.jad_zk.jad_vi;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_jw implements ComponentCallbacks2, jad_mz {
    public static final com.jd.ad.sdk.jad_en.jad_hu jad_kx;
    public final jad_cp jad_an;
    public final Context jad_bo;
    public final com.jd.ad.sdk.jad_zk.jad_ly jad_cp;
    public final jad_re jad_dq;
    public final jad_qd jad_er;
    public final jad_vi jad_fs = new jad_vi();
    public final com.jd.ad.sdk.jad_zk.jad_cp jad_hu;
    public final CopyOnWriteArrayList<com.jd.ad.sdk.jad_en.jad_jt<Object>> jad_iv;
    public final Runnable jad_jt;
    public com.jd.ad.sdk.jad_en.jad_hu jad_jw;

    public class jad_an implements Runnable {
        public jad_an() {
        }

        @Override // java.lang.Runnable
        public void run() {
            jad_jw jad_jwVar = jad_jw.this;
            jad_jwVar.jad_cp.jad_bo(jad_jwVar);
        }
    }

    public class jad_bo implements com.jd.ad.sdk.jad_zk.jad_cp.jad_an {
        public final jad_re jad_an;

        public jad_bo(jad_re jad_reVar) {
            this.jad_an = jad_reVar;
        }

        @Override // com.jd.ad.sdk.jad_zk.jad_cp.jad_an
        public void jad_an(boolean z) {
            if (z) {
                synchronized (jad_jw.this) {
                    jad_re jad_reVar = this.jad_an;
                    for (com.jd.ad.sdk.jad_en.jad_dq jad_dqVar : (ArrayList) com.jd.ad.sdk.jad_ir.jad_ly.jad_an(jad_reVar.jad_an)) {
                        if (!jad_dqVar.jad_cp() && !jad_dqVar.jad_er()) {
                            jad_dqVar.clear();
                            if (jad_reVar.jad_cp) {
                                jad_reVar.jad_bo.add(jad_dqVar);
                            } else {
                                jad_dqVar.jad_fs();
                            }
                        }
                    }
                }
            }
        }
    }

    static {
        com.jd.ad.sdk.jad_en.jad_hu jad_huVarJad_an = new com.jd.ad.sdk.jad_en.jad_hu().jad_an(Bitmap.class);
        jad_huVarJad_an.jad_tg = true;
        jad_kx = jad_huVarJad_an;
        new com.jd.ad.sdk.jad_en.jad_hu().jad_an(com.jd.ad.sdk.jad_xi.jad_cp.class).jad_tg = true;
        new com.jd.ad.sdk.jad_en.jad_hu().jad_an(com.jd.ad.sdk.jad_mx.jad_ly.jad_bo).jad_an(jad_jt.LOW).jad_an(true);
    }

    public jad_jw(jad_cp jad_cpVar, com.jd.ad.sdk.jad_zk.jad_ly jad_lyVar, jad_qd jad_qdVar, jad_re jad_reVar, com.jd.ad.sdk.jad_zk.jad_dq jad_dqVar, Context context) {
        jad_an jad_anVar = new jad_an();
        this.jad_jt = jad_anVar;
        this.jad_an = jad_cpVar;
        this.jad_cp = jad_lyVar;
        this.jad_er = jad_qdVar;
        this.jad_dq = jad_reVar;
        this.jad_bo = context;
        com.jd.ad.sdk.jad_zk.jad_cp jad_cpVarJad_an = ((com.jd.ad.sdk.jad_zk.jad_fs) jad_dqVar).jad_an(StubApp.getOrigApplicationContext(context.getApplicationContext()), new jad_bo(jad_reVar));
        this.jad_hu = jad_cpVarJad_an;
        if (com.jd.ad.sdk.jad_ir.jad_ly.jad_cp()) {
            com.jd.ad.sdk.jad_ir.jad_ly.jad_an(jad_anVar);
        } else {
            jad_lyVar.jad_bo(this);
        }
        jad_lyVar.jad_bo(jad_cpVarJad_an);
        this.jad_iv = new CopyOnWriteArrayList<>(jad_cpVar.jad_dq().jad_an());
        jad_an(jad_cpVar.jad_dq().jad_bo());
        jad_cpVar.jad_an(this);
    }

    public void jad_an(com.jd.ad.sdk.jad_fo.jad_er<?> jad_erVar) {
        if (jad_erVar == null) {
            return;
        }
        boolean zJad_bo = jad_bo(jad_erVar);
        com.jd.ad.sdk.jad_en.jad_dq jad_dqVarJad_bo = jad_erVar.jad_bo();
        if (zJad_bo) {
            return;
        }
        jad_cp jad_cpVar = this.jad_an;
        synchronized (jad_cpVar.jad_hu) {
            Iterator<jad_jw> it = jad_cpVar.jad_hu.iterator();
            while (it.hasNext()) {
                if (it.next().jad_bo(jad_erVar)) {
                }
            }
            if (jad_dqVarJad_bo != null) {
                jad_erVar.jad_an((com.jd.ad.sdk.jad_en.jad_dq) null);
                jad_dqVarJad_bo.clear();
            }
        }
    }

    public synchronized boolean jad_bo(com.jd.ad.sdk.jad_fo.jad_er<?> jad_erVar) {
        com.jd.ad.sdk.jad_en.jad_dq jad_dqVarJad_bo = jad_erVar.jad_bo();
        if (jad_dqVarJad_bo == null) {
            return true;
        }
        if (!this.jad_dq.jad_an(jad_dqVarJad_bo)) {
            return false;
        }
        this.jad_fs.jad_an.remove(jad_erVar);
        jad_erVar.jad_an((com.jd.ad.sdk.jad_en.jad_dq) null);
        return true;
    }

    @Override // com.jd.ad.sdk.jad_zk.jad_mz
    public synchronized void jad_dq() {
        this.jad_fs.jad_dq();
        Iterator it = ((ArrayList) com.jd.ad.sdk.jad_ir.jad_ly.jad_an(this.jad_fs.jad_an)).iterator();
        while (it.hasNext()) {
            jad_an((com.jd.ad.sdk.jad_fo.jad_er<?>) it.next());
        }
        this.jad_fs.jad_an.clear();
        jad_re jad_reVar = this.jad_dq;
        Iterator it2 = ((ArrayList) com.jd.ad.sdk.jad_ir.jad_ly.jad_an(jad_reVar.jad_an)).iterator();
        while (it2.hasNext()) {
            jad_reVar.jad_an((com.jd.ad.sdk.jad_en.jad_dq) it2.next());
        }
        jad_reVar.jad_bo.clear();
        this.jad_cp.jad_an(this);
        this.jad_cp.jad_an(this.jad_hu);
        com.jd.ad.sdk.jad_ir.jad_ly.jad_bo().removeCallbacks(this.jad_jt);
        jad_cp jad_cpVar = this.jad_an;
        synchronized (jad_cpVar.jad_hu) {
            if (!jad_cpVar.jad_hu.contains(this)) {
                throw new IllegalStateException("Cannot unregister not yet registered manager");
            }
            jad_cpVar.jad_hu.remove(this);
        }
    }

    public jad_iv<Bitmap> jad_er() {
        return new jad_iv(this.jad_an, this, Bitmap.class, this.jad_bo).jad_bo(jad_kx);
    }

    public List<com.jd.ad.sdk.jad_en.jad_jt<Object>> jad_fs() {
        return this.jad_iv;
    }

    public synchronized com.jd.ad.sdk.jad_en.jad_hu jad_jt() {
        return this.jad_jw;
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
    }

    public synchronized String toString() {
        return super.toString() + "{tracker=" + this.jad_dq + ", treeNode=" + this.jad_er + i.d;
    }

    @Override // com.jd.ad.sdk.jad_zk.jad_mz
    public synchronized void jad_cp() {
        synchronized (this) {
            jad_re jad_reVar = this.jad_dq;
            jad_reVar.jad_cp = false;
            for (com.jd.ad.sdk.jad_en.jad_dq jad_dqVar : (ArrayList) com.jd.ad.sdk.jad_ir.jad_ly.jad_an(jad_reVar.jad_an)) {
                if (!jad_dqVar.jad_cp() && !jad_dqVar.isRunning()) {
                    jad_dqVar.jad_fs();
                }
            }
            jad_reVar.jad_bo.clear();
        }
        this.jad_fs.jad_cp();
    }

    public <T> jad_kx<?, T> jad_an(Class<T> cls) {
        jad_er jad_erVar = this.jad_an.jad_cp;
        jad_kx<?, T> jad_kxVar = (jad_kx) jad_erVar.jad_er.get(cls);
        if (jad_kxVar == null) {
            for (Map.Entry<Class<?>, jad_kx<?, ?>> entry : jad_erVar.jad_er.entrySet()) {
                if (entry.getKey().isAssignableFrom(cls)) {
                    jad_kxVar = (jad_kx) entry.getValue();
                }
            }
        }
        return jad_kxVar == null ? (jad_kx<?, T>) jad_er.jad_jw : jad_kxVar;
    }

    public jad_iv<Drawable> jad_an(String str) {
        return new jad_iv(this.jad_an, this, Drawable.class, this.jad_bo).jad_an(str);
    }

    @Override // com.jd.ad.sdk.jad_zk.jad_mz
    public synchronized void jad_an() {
        synchronized (this) {
            jad_re jad_reVar = this.jad_dq;
            jad_reVar.jad_cp = true;
            for (com.jd.ad.sdk.jad_en.jad_dq jad_dqVar : (ArrayList) com.jd.ad.sdk.jad_ir.jad_ly.jad_an(jad_reVar.jad_an)) {
                if (jad_dqVar.isRunning()) {
                    jad_dqVar.jad_dq();
                    jad_reVar.jad_bo.add(jad_dqVar);
                }
            }
        }
        this.jad_fs.jad_an();
    }

    public synchronized void jad_an(com.jd.ad.sdk.jad_en.jad_hu jad_huVar) {
        com.jd.ad.sdk.jad_en.jad_hu jad_huVarClone = jad_huVar.clone();
        if (jad_huVarClone.jad_tg && !jad_huVarClone.jad_vi) {
            throw new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
        }
        jad_huVarClone.jad_vi = true;
        jad_huVarClone.jad_tg = true;
        this.jad_jw = jad_huVarClone;
    }
}
