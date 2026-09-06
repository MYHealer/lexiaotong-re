package com.jd.ad.sdk.jad_en;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.jd.ad.sdk.jad_ir.jad_ly;
import com.jd.ad.sdk.jad_mx.jad_mz;
import com.jd.ad.sdk.jad_mx.jad_sf;
import com.jd.ad.sdk.jad_mx.jad_xk;
import com.jd.ad.sdk.logger.Logger;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class jad_jw<R> implements jad_dq, com.jd.ad.sdk.jad_fo.jad_dq, jad_iv {
    public static final boolean jad_fq = Log.isLoggable("GlideRequest", 2);
    public final String jad_an;
    public final com.jd.ad.sdk.jad_js.jad_dq jad_bo;
    public int jad_cn;
    public final Object jad_cp;
    public boolean jad_do;
    public final jad_jt<R> jad_dq;
    public RuntimeException jad_ep;
    public final jad_fs jad_er;
    public final Context jad_fs;
    public final Object jad_hu;
    public final Class<R> jad_iv;
    public final com.jd.ad.sdk.jad_gr.jad_er jad_jt;
    public final jad_an<?> jad_jw;
    public final int jad_kx;
    public final int jad_ly;
    public final com.jd.ad.sdk.jad_gr.jad_jt jad_mz;
    public final com.jd.ad.sdk.jad_fo.jad_er<R> jad_na;
    public final List<jad_jt<R>> jad_ob;
    public final com.jd.ad.sdk.jad_gp.jad_cp<? super R> jad_pc;
    public final Executor jad_qd;
    public jad_xk<R> jad_re;
    public jad_mz.jad_dq jad_sf;
    public long jad_tg;
    public volatile jad_mz jad_uh;
    public int jad_vi;
    public Drawable jad_wj;
    public Drawable jad_xk;
    public Drawable jad_yl;
    public int jad_zm;

    public jad_jw(Context context, com.jd.ad.sdk.jad_gr.jad_er jad_erVar, Object obj, Object obj2, Class<R> cls, jad_an<?> jad_anVar, int i, int i2, com.jd.ad.sdk.jad_gr.jad_jt jad_jtVar, com.jd.ad.sdk.jad_fo.jad_er<R> jad_erVar2, jad_jt<R> jad_jtVar2, List<jad_jt<R>> list, jad_fs jad_fsVar, jad_mz jad_mzVar, com.jd.ad.sdk.jad_gp.jad_cp<? super R> jad_cpVar, Executor executor) {
        this.jad_an = jad_fq ? String.valueOf(hashCode()) : null;
        this.jad_bo = com.jd.ad.sdk.jad_js.jad_dq.jad_an();
        this.jad_cp = obj;
        this.jad_fs = context;
        this.jad_jt = jad_erVar;
        this.jad_hu = obj2;
        this.jad_iv = cls;
        this.jad_jw = jad_anVar;
        this.jad_kx = i;
        this.jad_ly = i2;
        this.jad_mz = jad_jtVar;
        this.jad_na = jad_erVar2;
        this.jad_dq = jad_jtVar2;
        this.jad_ob = list;
        this.jad_er = jad_fsVar;
        this.jad_uh = jad_mzVar;
        this.jad_pc = jad_cpVar;
        this.jad_qd = executor;
        this.jad_vi = 1;
        if (this.jad_ep == null && jad_erVar.jad_cp().jad_an(com.jd.ad.sdk.jad_gr.jad_dq.C0552jad_dq.class)) {
            this.jad_ep = new RuntimeException("Glide request origin trace");
        }
    }

    @Override // com.jd.ad.sdk.jad_en.jad_dq
    public void clear() {
        synchronized (this.jad_cp) {
            jad_bo();
            this.jad_bo.jad_bo();
            if (this.jad_vi == 6) {
                return;
            }
            jad_jt();
            jad_xk<R> jad_xkVar = this.jad_re;
            if (jad_xkVar != null) {
                this.jad_re = null;
            } else {
                jad_xkVar = null;
            }
            jad_fs jad_fsVar = this.jad_er;
            if (jad_fsVar == null || jad_fsVar.jad_cp(this)) {
                this.jad_na.jad_an(jad_iv());
            }
            this.jad_vi = 6;
            if (jad_xkVar != null) {
                this.jad_uh.jad_an(jad_xkVar);
            }
        }
    }

    @Override // com.jd.ad.sdk.jad_en.jad_dq
    public boolean isRunning() {
        boolean z;
        synchronized (this.jad_cp) {
            int i = this.jad_vi;
            z = i == 2 || i == 3;
        }
        return z;
    }

    public final Drawable jad_an(int i) {
        Resources.Theme theme = this.jad_jw.jad_uh;
        if (theme == null) {
            theme = this.jad_fs.getTheme();
        }
        com.jd.ad.sdk.jad_gr.jad_er jad_erVar = this.jad_jt;
        return com.jd.ad.sdk.jad_vg.jad_bo.jad_an(jad_erVar, jad_erVar, i, theme);
    }

    public final void jad_an(String str) {
        Logger.v("GlideRequest", str + " this: " + this.jad_an);
    }

    @Override // com.jd.ad.sdk.jad_en.jad_dq
    public boolean jad_an() {
        boolean z;
        synchronized (this.jad_cp) {
            z = this.jad_vi == 4;
        }
        return z;
    }

    public final void jad_bo() {
        if (this.jad_do) {
            throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
        }
    }

    @Override // com.jd.ad.sdk.jad_en.jad_dq
    public boolean jad_cp() {
        boolean z;
        synchronized (this.jad_cp) {
            z = this.jad_vi == 4;
        }
        return z;
    }

    @Override // com.jd.ad.sdk.jad_en.jad_dq
    public void jad_dq() {
        synchronized (this.jad_cp) {
            if (isRunning()) {
                clear();
            }
        }
    }

    @Override // com.jd.ad.sdk.jad_en.jad_dq
    public boolean jad_er() {
        boolean z;
        synchronized (this.jad_cp) {
            z = this.jad_vi == 6;
        }
        return z;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x005c  */
    @Override // com.jd.ad.sdk.jad_en.jad_dq
    public boolean jad_er(jad_dq jad_dqVar) {
        int i;
        int i2;
        Object obj;
        Class<R> cls;
        jad_an<?> jad_anVar;
        com.jd.ad.sdk.jad_gr.jad_jt jad_jtVar;
        int size;
        int i3;
        int i4;
        Object obj2;
        Class<R> cls2;
        jad_an<?> jad_anVar2;
        com.jd.ad.sdk.jad_gr.jad_jt jad_jtVar2;
        int size2;
        if (!(jad_dqVar instanceof jad_jw)) {
            return false;
        }
        synchronized (this.jad_cp) {
            i = this.jad_kx;
            i2 = this.jad_ly;
            obj = this.jad_hu;
            cls = this.jad_iv;
            jad_anVar = this.jad_jw;
            jad_jtVar = this.jad_mz;
            List<jad_jt<R>> list = this.jad_ob;
            size = list != null ? list.size() : 0;
        }
        jad_jw jad_jwVar = (jad_jw) jad_dqVar;
        synchronized (jad_jwVar.jad_cp) {
            i3 = jad_jwVar.jad_kx;
            i4 = jad_jwVar.jad_ly;
            obj2 = jad_jwVar.jad_hu;
            cls2 = jad_jwVar.jad_iv;
            jad_anVar2 = jad_jwVar.jad_jw;
            jad_jtVar2 = jad_jwVar.jad_mz;
            List<jad_jt<R>> list2 = jad_jwVar.jad_ob;
            size2 = list2 != null ? list2.size() : 0;
        }
        if (i == i3 && i2 == i4) {
            char[] cArr = jad_ly.jad_an;
            if (obj != null) {
                if (obj instanceof com.jd.ad.sdk.jad_qb.jad_ly ? ((com.jd.ad.sdk.jad_qb.jad_ly) obj).jad_an(obj2) : obj.equals(obj2)) {
                    if (!cls.equals(cls2)) {
                    }
                }
            } else if (obj2 == null) {
                if (!cls.equals(cls2) && jad_anVar.equals(jad_anVar2) && jad_jtVar == jad_jtVar2 && size == size2) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.jd.ad.sdk.jad_en.jad_dq
    public void jad_fs() {
        jad_fs jad_fsVar;
        synchronized (this.jad_cp) {
            jad_bo();
            this.jad_bo.jad_bo();
            this.jad_tg = com.jd.ad.sdk.jad_ir.jad_jt.jad_an();
            if (this.jad_hu == null) {
                if (jad_ly.jad_bo(this.jad_kx, this.jad_ly)) {
                    this.jad_zm = this.jad_kx;
                    this.jad_cn = this.jad_ly;
                }
                jad_an(new jad_sf("Received null model", Collections.emptyList()), jad_hu() == null ? 5 : 3);
                return;
            }
            int i = this.jad_vi;
            if (i == 2) {
                throw new IllegalArgumentException("Cannot restart a running request");
            }
            if (i == 4) {
                jad_an(this.jad_re, com.jd.ad.sdk.jad_ju.jad_an.MEMORY_CACHE, false);
                return;
            }
            List<jad_jt<R>> list = this.jad_ob;
            if (list != null) {
                for (jad_jt<R> jad_jtVar : list) {
                    if (jad_jtVar instanceof jad_cp) {
                        ((jad_cp) jad_jtVar).getClass();
                    }
                }
            }
            this.jad_vi = 3;
            if (jad_ly.jad_bo(this.jad_kx, this.jad_ly)) {
                jad_an(this.jad_kx, this.jad_ly);
            } else {
                this.jad_na.jad_bo(this);
            }
            int i2 = this.jad_vi;
            if ((i2 == 2 || i2 == 3) && ((jad_fsVar = this.jad_er) == null || jad_fsVar.jad_bo(this))) {
                this.jad_na.jad_bo(jad_iv());
            }
            if (jad_fq) {
                jad_an("finished run method in " + com.jd.ad.sdk.jad_ir.jad_jt.jad_an(this.jad_tg));
            }
        }
    }

    public final Drawable jad_hu() {
        int i;
        if (this.jad_yl == null) {
            jad_an<?> jad_anVar = this.jad_jw;
            Drawable drawable = jad_anVar.jad_ob;
            this.jad_yl = drawable;
            if (drawable == null && (i = jad_anVar.jad_pc) > 0) {
                this.jad_yl = jad_an(i);
            }
        }
        return this.jad_yl;
    }

    public final Drawable jad_iv() {
        int i;
        if (this.jad_xk == null) {
            jad_an<?> jad_anVar = this.jad_jw;
            Drawable drawable = jad_anVar.jad_jt;
            this.jad_xk = drawable;
            if (drawable == null && (i = jad_anVar.jad_hu) > 0) {
                this.jad_xk = jad_an(i);
            }
        }
        return this.jad_xk;
    }

    public final void jad_jt() {
        jad_bo();
        this.jad_bo.jad_bo();
        this.jad_na.jad_an((com.jd.ad.sdk.jad_fo.jad_dq) this);
        jad_mz.jad_dq jad_dqVar = this.jad_sf;
        if (jad_dqVar != null) {
            synchronized (jad_mz.this) {
                jad_dqVar.jad_an.jad_an(jad_dqVar.jad_bo);
            }
            this.jad_sf = null;
        }
    }

    public final boolean jad_jw() {
        jad_fs jad_fsVar = this.jad_er;
        return jad_fsVar == null || !jad_fsVar.jad_bo().jad_an();
    }

    public final void jad_kx() {
        int i;
        jad_fs jad_fsVar = this.jad_er;
        if (jad_fsVar == null || jad_fsVar.jad_bo(this)) {
            Drawable drawableJad_hu = this.jad_hu == null ? jad_hu() : null;
            if (drawableJad_hu == null) {
                if (this.jad_wj == null) {
                    jad_an<?> jad_anVar = this.jad_jw;
                    Drawable drawable = jad_anVar.jad_er;
                    this.jad_wj = drawable;
                    if (drawable == null && (i = jad_anVar.jad_fs) > 0) {
                        this.jad_wj = jad_an(i);
                    }
                }
                drawableJad_hu = this.jad_wj;
            }
            if (drawableJad_hu == null) {
                drawableJad_hu = jad_iv();
            }
            this.jad_na.jad_cp(drawableJad_hu);
        }
    }

    public String toString() {
        Object obj;
        Class<R> cls;
        synchronized (this.jad_cp) {
            obj = this.jad_hu;
            cls = this.jad_iv;
        }
        return super.toString() + "[model=" + obj + ", transcodeClass=" + cls + "]";
    }

    public final void jad_an(jad_sf jad_sfVar, int i) {
        boolean zJad_an;
        this.jad_bo.jad_bo();
        synchronized (this.jad_cp) {
            jad_sfVar.getClass();
            int i2 = this.jad_jt.jad_hu;
            boolean z = true;
            if (i2 <= i) {
                Logger.w("Glide", "Load failed for " + this.jad_hu + " with size [" + this.jad_zm + "x" + this.jad_cn + "]", jad_sfVar);
                if (i2 <= 4) {
                    jad_sfVar.jad_an("Glide");
                }
            }
            this.jad_sf = null;
            this.jad_vi = 5;
            this.jad_do = true;
            try {
                List<jad_jt<R>> list = this.jad_ob;
                if (list != null) {
                    Iterator<jad_jt<R>> it = list.iterator();
                    zJad_an = false;
                    while (it.hasNext()) {
                        zJad_an |= it.next().jad_an(jad_sfVar, this.jad_hu, this.jad_na, jad_jw());
                    }
                } else {
                    zJad_an = false;
                }
                jad_jt<R> jad_jtVar = this.jad_dq;
                if (jad_jtVar == null || !jad_jtVar.jad_an(jad_sfVar, this.jad_hu, this.jad_na, jad_jw())) {
                    z = false;
                }
                if (!(zJad_an | z)) {
                    jad_kx();
                }
                this.jad_do = false;
                jad_fs jad_fsVar = this.jad_er;
                if (jad_fsVar != null) {
                    jad_fsVar.jad_fs(this);
                }
            } catch (Throwable th) {
                this.jad_do = false;
                throw th;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r8v0, types: [com.jd.ad.sdk.jad_en.jad_dq, com.jd.ad.sdk.jad_en.jad_jw, com.jd.ad.sdk.jad_en.jad_jw<R>] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v2, types: [com.jd.ad.sdk.jad_en.jad_jw] */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v9 */
    public void jad_an(jad_xk<?> jad_xkVar, com.jd.ad.sdk.jad_ju.jad_an jad_anVar, boolean z) throws Throwable {
        ?? r9;
        Throwable th;
        this.jad_bo.jad_bo();
        jad_xk<?> jad_xkVar2 = null;
        try {
            synchronized (this.jad_cp) {
                try {
                    this.jad_sf = null;
                    if (jad_xkVar == null) {
                        jad_an(new jad_sf("Expected to receive a Resource<R> with an object of " + this.jad_iv + " inside, but instead got null.", Collections.emptyList()), 5);
                        return;
                    }
                    Object obj = jad_xkVar.get();
                    try {
                        if (obj != null && this.jad_iv.isAssignableFrom(obj.getClass())) {
                            jad_fs jad_fsVar = this.jad_er;
                            if (jad_fsVar == null || jad_fsVar.jad_an(this)) {
                                jad_an(jad_xkVar, obj, jad_anVar, z);
                                return;
                            }
                            this.jad_re = null;
                            this.jad_vi = 4;
                            this.jad_uh.jad_an(jad_xkVar);
                            return;
                        }
                        this.jad_re = null;
                        jad_an(new jad_sf("Expected to receive an object of " + this.jad_iv + " but instead got " + (obj != null ? obj.getClass() : "") + "{" + obj + "} inside Resource{" + jad_xkVar + "}." + (obj != null ? "" : " To indicate failure return a null Resource object, rather than a Resource object containing null data."), Collections.emptyList()), 5);
                        this.jad_uh.jad_an(jad_xkVar);
                    } catch (Throwable th2) {
                        th = th2;
                        jad_xkVar2 = jad_xkVar;
                        r9 = this;
                        while (true) {
                            try {
                                try {
                                    throw th;
                                } catch (Throwable th3) {
                                    th = th3;
                                    if (jad_xkVar2 != null) {
                                        r9.jad_uh.jad_an(jad_xkVar2);
                                    }
                                    throw th;
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                r9 = r9;
                            }
                            th = th4;
                            r9 = r9;
                        }
                    }
                } catch (Throwable th5) {
                    th = th5;
                    r9 = this;
                }
            }
        } catch (Throwable th6) {
            th = th6;
            r9 = this;
        }
    }

    public final void jad_an(jad_xk<R> jad_xkVar, R r, com.jd.ad.sdk.jad_ju.jad_an jad_anVar, boolean z) {
        boolean zJad_an;
        boolean zJad_jw = jad_jw();
        this.jad_vi = 4;
        this.jad_re = jad_xkVar;
        if (this.jad_jt.jad_hu <= 3) {
            Logger.d("Glide", com.jd.ad.sdk.jad_gr.jad_ly.jad_an("Finished loading ").append(r.getClass().getSimpleName()).append(" from ").append(jad_anVar).append(" for ").append(this.jad_hu).append(" with size [").append(this.jad_zm).append("x").append(this.jad_cn).append("] in ").append(com.jd.ad.sdk.jad_ir.jad_jt.jad_an(this.jad_tg)).append(" ms").toString());
        }
        boolean z2 = true;
        this.jad_do = true;
        try {
            List<jad_jt<R>> list = this.jad_ob;
            if (list != null) {
                Iterator<jad_jt<R>> it = list.iterator();
                zJad_an = false;
                while (it.hasNext()) {
                    zJad_an |= it.next().jad_an(r, this.jad_hu, this.jad_na, jad_anVar, zJad_jw);
                }
            } else {
                zJad_an = false;
            }
            jad_jt<R> jad_jtVar = this.jad_dq;
            if (jad_jtVar == null || !jad_jtVar.jad_an(r, this.jad_hu, this.jad_na, jad_anVar, zJad_jw)) {
                z2 = false;
            }
            if (!(z2 | zJad_an)) {
                this.jad_pc.getClass();
                this.jad_na.jad_an(r, com.jd.ad.sdk.jad_gp.jad_an.jad_an);
            }
            this.jad_do = false;
            jad_fs jad_fsVar = this.jad_er;
            if (jad_fsVar != null) {
                jad_fsVar.jad_dq(this);
            }
        } catch (Throwable th) {
            this.jad_do = false;
            throw th;
        }
    }

    public void jad_an(int i, int i2) throws Throwable {
        Object obj;
        int iRound = i;
        this.jad_bo.jad_bo();
        Object obj2 = this.jad_cp;
        synchronized (obj2) {
            try {
                try {
                    boolean z = jad_fq;
                    if (z) {
                        jad_an("Got onSizeReady in " + com.jd.ad.sdk.jad_ir.jad_jt.jad_an(this.jad_tg));
                    }
                    if (this.jad_vi == 3) {
                        this.jad_vi = 2;
                        float f = this.jad_jw.jad_bo;
                        if (iRound != Integer.MIN_VALUE) {
                            iRound = Math.round(iRound * f);
                        }
                        this.jad_zm = iRound;
                        this.jad_cn = i2 == Integer.MIN_VALUE ? i2 : Math.round(f * i2);
                        if (z) {
                            jad_an("finished setup for calling load in " + com.jd.ad.sdk.jad_ir.jad_jt.jad_an(this.jad_tg));
                        }
                        jad_mz jad_mzVar = this.jad_uh;
                        com.jd.ad.sdk.jad_gr.jad_er jad_erVar = this.jad_jt;
                        Object obj3 = this.jad_hu;
                        jad_an<?> jad_anVar = this.jad_jw;
                        try {
                            obj = obj2;
                            try {
                                this.jad_sf = jad_mzVar.jad_an(jad_erVar, obj3, jad_anVar.jad_ly, this.jad_zm, this.jad_cn, jad_anVar.jad_sf, this.jad_iv, this.jad_mz, jad_anVar.jad_cp, jad_anVar.jad_re, jad_anVar.jad_mz, jad_anVar.jad_yl, jad_anVar.jad_qd, jad_anVar.jad_iv, jad_anVar.jad_wj, jad_anVar.jad_zm, jad_anVar.jad_xk, this, this.jad_qd);
                                if (this.jad_vi != 2) {
                                    this.jad_sf = null;
                                }
                                if (z) {
                                    jad_an("finished onSizeReady in " + com.jd.ad.sdk.jad_ir.jad_jt.jad_an(this.jad_tg));
                                }
                            } catch (Throwable th) {
                                th = th;
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            obj = obj2;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    obj = obj2;
                }
            } catch (Throwable th4) {
                th = th4;
            }
        }
    }
}
