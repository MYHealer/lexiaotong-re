package com.jd.ad.sdk.jad_gr;

import android.content.Context;
import android.util.Log;
import com.jd.ad.sdk.jad_mx.jad_mz;
import com.jd.ad.sdk.jad_zk.jad_re;
import com.jd.ad.sdk.logger.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_iv<TranscodeType> extends com.jd.ad.sdk.jad_en.jad_an<jad_iv<TranscodeType>> {
    public final Context jad_cn;
    public final jad_jw jad_do;
    public final Class<TranscodeType> jad_ep;
    public final jad_er jad_fq;
    public jad_kx<?, ? super TranscodeType> jad_gr;
    public Object jad_hs;
    public List<com.jd.ad.sdk.jad_en.jad_jt<TranscodeType>> jad_it;
    public jad_iv<TranscodeType> jad_ju;
    public jad_iv<TranscodeType> jad_kv;
    public boolean jad_lw = true;
    public boolean jad_mx;
    public boolean jad_ny;

    static {
        new com.jd.ad.sdk.jad_en.jad_hu().jad_an(com.jd.ad.sdk.jad_mx.jad_ly.jad_bo).jad_an(jad_jt.LOW).jad_an(true);
    }

    public jad_iv(jad_cp jad_cpVar, jad_jw jad_jwVar, Class<TranscodeType> cls, Context context) {
        this.jad_do = jad_jwVar;
        this.jad_ep = cls;
        this.jad_cn = context;
        this.jad_gr = jad_jwVar.jad_an(cls);
        this.jad_fq = jad_cpVar.jad_dq();
        jad_an(jad_jwVar.jad_fs());
        jad_bo(jad_jwVar.jad_jt());
    }

    @Override // com.jd.ad.sdk.jad_en.jad_an
    public /* bridge */ /* synthetic */ com.jd.ad.sdk.jad_en.jad_an jad_an(com.jd.ad.sdk.jad_en.jad_an jad_anVar) {
        return jad_bo((com.jd.ad.sdk.jad_en.jad_an<?>) jad_anVar);
    }

    public jad_iv<TranscodeType> jad_an(com.jd.ad.sdk.jad_en.jad_jt<TranscodeType> jad_jtVar) {
        if (this.jad_vi) {
            return clone().jad_an((com.jd.ad.sdk.jad_en.jad_jt) jad_jtVar);
        }
        if (jad_jtVar != null) {
            if (this.jad_it == null) {
                this.jad_it = new ArrayList();
            }
            this.jad_it.add(jad_jtVar);
        }
        return jad_bo();
    }

    public final void jad_an(List<com.jd.ad.sdk.jad_en.jad_jt<Object>> list) {
        Iterator<com.jd.ad.sdk.jad_en.jad_jt<Object>> it = list.iterator();
        while (it.hasNext()) {
            jad_an((com.jd.ad.sdk.jad_en.jad_jt) it.next());
        }
    }

    @Override // com.jd.ad.sdk.jad_en.jad_an
    /* JADX INFO: renamed from: jad_cp, reason: merged with bridge method [inline-methods] */
    public jad_iv<TranscodeType> clone() {
        jad_iv<TranscodeType> jad_ivVar = (jad_iv) super.clone();
        jad_ivVar.jad_gr = jad_ivVar.jad_gr.jad_an();
        if (jad_ivVar.jad_it != null) {
            jad_ivVar.jad_it = new ArrayList(jad_ivVar.jad_it);
        }
        jad_iv<TranscodeType> jad_ivVar2 = jad_ivVar.jad_ju;
        if (jad_ivVar2 != null) {
            jad_ivVar.jad_ju = jad_ivVar2.clone();
        }
        jad_iv<TranscodeType> jad_ivVar3 = jad_ivVar.jad_kv;
        if (jad_ivVar3 != null) {
            jad_ivVar.jad_kv = jad_ivVar3.clone();
        }
        return jad_ivVar;
    }

    public jad_iv<TranscodeType> jad_bo(com.jd.ad.sdk.jad_en.jad_an<?> jad_anVar) {
        if (jad_anVar != null) {
            return (jad_iv) super.jad_an(jad_anVar);
        }
        throw new NullPointerException("Argument must not be null");
    }

    public com.jd.ad.sdk.jad_fo.jad_er<TranscodeType> jad_dq() {
        return jad_an(new com.jd.ad.sdk.jad_fo.jad_cp(this.jad_do, Integer.MIN_VALUE, Integer.MIN_VALUE));
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0065  */
    /* JADX WARN: Code duplicated, block: B:35:0x00ed  */
    /* JADX WARN: Multi-variable type inference failed */
    public final com.jd.ad.sdk.jad_en.jad_dq jad_an(Object obj, com.jd.ad.sdk.jad_fo.jad_er<TranscodeType> jad_erVar, com.jd.ad.sdk.jad_en.jad_jt<TranscodeType> jad_jtVar, com.jd.ad.sdk.jad_en.jad_fs jad_fsVar, jad_kx<?, ? super TranscodeType> jad_kxVar, jad_jt jad_jtVar2, int i, int i2, com.jd.ad.sdk.jad_en.jad_an<?> jad_anVar, Executor executor) {
        com.jd.ad.sdk.jad_en.jad_bo jad_boVar;
        com.jd.ad.sdk.jad_en.jad_fs jad_boVar2;
        com.jd.ad.sdk.jad_en.jad_dq jad_dqVarJad_an;
        int i3;
        int i4;
        jad_jt jad_jtVarJad_bo;
        int i5;
        int i6;
        if (this.jad_kv != null) {
            jad_boVar2 = new com.jd.ad.sdk.jad_en.jad_bo(obj, jad_fsVar);
            jad_boVar = jad_boVar2;
        } else {
            jad_boVar = 0;
            jad_boVar2 = jad_fsVar;
        }
        jad_iv<TranscodeType> jad_ivVar = this.jad_ju;
        if (jad_ivVar == null) {
            jad_dqVarJad_an = jad_an(obj, jad_erVar, jad_jtVar, jad_anVar, jad_boVar2, jad_kxVar, jad_jtVar2, i, i2, executor);
        } else if (!this.jad_ny) {
            jad_kx<?, ? super TranscodeType> jad_kxVar2 = jad_ivVar.jad_lw ? jad_kxVar : jad_ivVar.jad_gr;
            if (com.jd.ad.sdk.jad_en.jad_an.jad_an(jad_ivVar.jad_an, 8)) {
                jad_jtVarJad_bo = this.jad_ju.jad_dq;
            } else {
                jad_jtVarJad_bo = jad_bo(jad_jtVar2);
            }
            jad_jt jad_jtVar3 = jad_jtVarJad_bo;
            jad_iv<TranscodeType> jad_ivVar2 = this.jad_ju;
            int i7 = jad_ivVar2.jad_kx;
            int i8 = jad_ivVar2.jad_jw;
            if (com.jd.ad.sdk.jad_ir.jad_ly.jad_bo(i, i2)) {
                jad_iv<TranscodeType> jad_ivVar3 = this.jad_ju;
                if (com.jd.ad.sdk.jad_ir.jad_ly.jad_bo(jad_ivVar3.jad_kx, jad_ivVar3.jad_jw)) {
                    i5 = i8;
                    i6 = i7;
                } else {
                    i6 = jad_anVar.jad_kx;
                    i5 = jad_anVar.jad_jw;
                }
            } else {
                i5 = i8;
                i6 = i7;
            }
            com.jd.ad.sdk.jad_en.jad_kx jad_kxVar3 = new com.jd.ad.sdk.jad_en.jad_kx(obj, jad_boVar2);
            com.jd.ad.sdk.jad_en.jad_dq jad_dqVarJad_an2 = jad_an(obj, jad_erVar, jad_jtVar, jad_anVar, jad_kxVar3, jad_kxVar, jad_jtVar2, i, i2, executor);
            this.jad_ny = true;
            jad_iv<TranscodeType> jad_ivVar4 = this.jad_ju;
            com.jd.ad.sdk.jad_en.jad_dq jad_dqVarJad_an3 = jad_ivVar4.jad_an(obj, jad_erVar, jad_jtVar, jad_kxVar3, jad_kxVar2, jad_jtVar3, i6, i5, jad_ivVar4, executor);
            this.jad_ny = false;
            jad_kxVar3.jad_cp = jad_dqVarJad_an2;
            jad_kxVar3.jad_dq = jad_dqVarJad_an3;
            jad_dqVarJad_an = jad_kxVar3;
        } else {
            throw new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
        }
        if (jad_boVar == 0) {
            return jad_dqVarJad_an;
        }
        jad_iv<TranscodeType> jad_ivVar5 = this.jad_kv;
        int i9 = jad_ivVar5.jad_kx;
        int i10 = jad_ivVar5.jad_jw;
        if (com.jd.ad.sdk.jad_ir.jad_ly.jad_bo(i, i2)) {
            jad_iv<TranscodeType> jad_ivVar6 = this.jad_kv;
            if (com.jd.ad.sdk.jad_ir.jad_ly.jad_bo(jad_ivVar6.jad_kx, jad_ivVar6.jad_jw)) {
                i3 = i10;
                i4 = i9;
            } else {
                i4 = jad_anVar.jad_kx;
                i3 = jad_anVar.jad_jw;
            }
        } else {
            i3 = i10;
            i4 = i9;
        }
        jad_iv<TranscodeType> jad_ivVar7 = this.jad_kv;
        com.jd.ad.sdk.jad_en.jad_dq jad_dqVarJad_an4 = jad_ivVar7.jad_an(obj, jad_erVar, jad_jtVar, jad_boVar, jad_ivVar7.jad_gr, jad_ivVar7.jad_dq, i4, i3, jad_ivVar7, executor);
        jad_boVar.jad_cp = jad_dqVarJad_an;
        jad_boVar.jad_dq = jad_dqVarJad_an4;
        return jad_boVar;
    }

    public final jad_jt jad_bo(jad_jt jad_jtVar) {
        int iOrdinal = jad_jtVar.ordinal();
        if (iOrdinal == 0 || iOrdinal == 1) {
            return jad_jt.IMMEDIATE;
        }
        if (iOrdinal == 2) {
            return jad_jt.HIGH;
        }
        if (iOrdinal == 3) {
            return jad_jt.NORMAL;
        }
        throw new IllegalArgumentException(jad_ly.jad_an("unknown priority: ").append(this.jad_dq).toString());
    }

    public jad_iv<TranscodeType> jad_bo(com.jd.ad.sdk.jad_en.jad_jt<TranscodeType> jad_jtVar) {
        if (this.jad_vi) {
            return clone().jad_bo(jad_jtVar);
        }
        this.jad_it = null;
        return jad_an((com.jd.ad.sdk.jad_en.jad_jt) jad_jtVar);
    }

    public <Y extends com.jd.ad.sdk.jad_fo.jad_er<TranscodeType>> Y jad_an(Y y) {
        Executor executor = com.jd.ad.sdk.jad_ir.jad_er.jad_an;
        if (y == null) {
            throw new NullPointerException("Argument must not be null");
        }
        if (this.jad_mx) {
            com.jd.ad.sdk.jad_en.jad_dq jad_dqVarJad_an = jad_an(new Object(), y, (com.jd.ad.sdk.jad_en.jad_jt) null, (com.jd.ad.sdk.jad_en.jad_fs) null, this.jad_gr, this.jad_dq, this.jad_kx, this.jad_jw, this, executor);
            com.jd.ad.sdk.jad_fo.jad_an jad_anVar = (com.jd.ad.sdk.jad_fo.jad_an) y;
            com.jd.ad.sdk.jad_en.jad_dq jad_dqVar = jad_anVar.jad_cp;
            if (jad_dqVarJad_an.jad_er(jad_dqVar) && (this.jad_iv || !jad_dqVar.jad_cp())) {
                if (!((com.jd.ad.sdk.jad_en.jad_dq) com.jd.ad.sdk.jad_ir.jad_kx.jad_an(jad_dqVar)).isRunning()) {
                    jad_dqVar.jad_fs();
                }
            } else {
                this.jad_do.jad_an((com.jd.ad.sdk.jad_fo.jad_er<?>) y);
                jad_anVar.jad_cp = jad_dqVarJad_an;
                jad_jw jad_jwVar = this.jad_do;
                synchronized (jad_jwVar) {
                    jad_jwVar.jad_fs.jad_an.add(y);
                    jad_re jad_reVar = jad_jwVar.jad_dq;
                    jad_reVar.jad_an.add(jad_dqVarJad_an);
                    if (jad_reVar.jad_cp) {
                        jad_dqVarJad_an.clear();
                        if (Log.isLoggable("RequestTracker", 2)) {
                            Logger.v("RequestTracker", "Paused, delaying request");
                        }
                        jad_reVar.jad_bo.add(jad_dqVarJad_an);
                    } else {
                        jad_dqVarJad_an.jad_fs();
                    }
                }
            }
            return y;
        }
        throw new IllegalArgumentException("You must call #load() before calling #into()");
    }

    public final jad_iv<TranscodeType> jad_an(Object obj) {
        if (this.jad_vi) {
            return clone().jad_an(obj);
        }
        this.jad_hs = obj;
        this.jad_mx = true;
        return jad_bo();
    }

    public final com.jd.ad.sdk.jad_en.jad_dq jad_an(Object obj, com.jd.ad.sdk.jad_fo.jad_er<TranscodeType> jad_erVar, com.jd.ad.sdk.jad_en.jad_jt<TranscodeType> jad_jtVar, com.jd.ad.sdk.jad_en.jad_an<?> jad_anVar, com.jd.ad.sdk.jad_en.jad_fs jad_fsVar, jad_kx<?, ? super TranscodeType> jad_kxVar, jad_jt jad_jtVar2, int i, int i2, Executor executor) {
        Context context = this.jad_cn;
        jad_er jad_erVar2 = this.jad_fq;
        Object obj2 = this.jad_hs;
        Class<TranscodeType> cls = this.jad_ep;
        List<com.jd.ad.sdk.jad_en.jad_jt<TranscodeType>> list = this.jad_it;
        jad_mz jad_mzVar = jad_erVar2.jad_fs;
        jad_kxVar.getClass();
        return new com.jd.ad.sdk.jad_en.jad_jw(context, jad_erVar2, obj, obj2, cls, jad_anVar, i, i2, jad_jtVar2, jad_erVar, jad_jtVar, list, jad_fsVar, jad_mzVar, com.jd.ad.sdk.jad_gp.jad_an.jad_bo, executor);
    }
}
