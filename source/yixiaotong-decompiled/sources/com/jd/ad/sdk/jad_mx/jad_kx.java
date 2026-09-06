package com.jd.ad.sdk.jad_mx;

import android.util.Log;
import androidx.core.util.Pools;
import com.alipay.sdk.util.i;
import com.jd.ad.sdk.logger.Logger;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_kx<DataType, ResourceType, Transcode> {
    public final Class<DataType> jad_an;
    public final List<? extends com.jd.ad.sdk.jad_ju.jad_ly<DataType, ResourceType>> jad_bo;
    public final com.jd.ad.sdk.jad_yj.jad_er<ResourceType, Transcode> jad_cp;
    public final Pools.Pool<List<Throwable>> jad_dq;
    public final String jad_er;

    public interface jad_an<ResourceType> {
    }

    public jad_kx(Class<DataType> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<? extends com.jd.ad.sdk.jad_ju.jad_ly<DataType, ResourceType>> list, com.jd.ad.sdk.jad_yj.jad_er<ResourceType, Transcode> jad_erVar, Pools.Pool<List<Throwable>> pool) {
        this.jad_an = cls;
        this.jad_bo = list;
        this.jad_cp = jad_erVar;
        this.jad_dq = pool;
        this.jad_er = com.jd.ad.sdk.jad_gr.jad_ly.jad_an("Failed DecodePath{").append(cls.getSimpleName()).append("->").append(cls2.getSimpleName()).append("->").append(cls3.getSimpleName()).append(i.d).toString();
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public jad_xk<Transcode> jad_an(com.jd.ad.sdk.jad_kv.jad_er<DataType> jad_erVar, int i, int i2, com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar, jad_an<ResourceType> jad_anVar) {
        jad_xk<ResourceType> jad_xkVarJad_an;
        com.jd.ad.sdk.jad_ju.jad_na jad_naVar;
        com.jd.ad.sdk.jad_ju.jad_cp jad_cpVarJad_an;
        com.jd.ad.sdk.jad_ju.jad_hu jad_dqVar;
        List<Throwable> list = (List) com.jd.ad.sdk.jad_ir.jad_kx.jad_an(this.jad_dq.acquire());
        try {
            jad_xk<ResourceType> jad_xkVarJad_an2 = jad_an(jad_erVar, i, i2, jad_jwVar, list);
            this.jad_dq.release(list);
            jad_hu.jad_cp jad_cpVar = (jad_hu.jad_cp) jad_anVar;
            jad_hu jad_huVar = jad_hu.this;
            com.jd.ad.sdk.jad_ju.jad_an jad_anVar2 = jad_cpVar.jad_an;
            jad_huVar.getClass();
            Class<?> cls = jad_xkVarJad_an2.get().getClass();
            com.jd.ad.sdk.jad_ju.jad_mz jad_mzVarJad_an = null;
            if (jad_anVar2 != com.jd.ad.sdk.jad_ju.jad_an.RESOURCE_DISK_CACHE) {
                com.jd.ad.sdk.jad_ju.jad_na jad_naVarJad_bo = jad_huVar.jad_an.jad_bo(cls);
                jad_naVar = jad_naVarJad_bo;
                jad_xkVarJad_an = jad_naVarJad_bo.jad_an(jad_huVar.jad_hu, jad_xkVarJad_an2, jad_huVar.jad_ly, jad_huVar.jad_mz);
            } else {
                jad_xkVarJad_an = jad_xkVarJad_an2;
                jad_naVar = null;
            }
            if (!jad_xkVarJad_an2.equals(jad_xkVarJad_an)) {
                jad_xkVarJad_an2.jad_dq();
            }
            if (jad_huVar.jad_an.jad_an((jad_xk<?>) jad_xkVarJad_an)) {
                jad_mzVarJad_an = jad_huVar.jad_an.jad_cp.jad_bo.jad_dq.jad_an(jad_xkVarJad_an.jad_cp());
                if (jad_mzVarJad_an == null) {
                    throw new com.jd.ad.sdk.jad_gr.jad_hu.jad_dq(jad_xkVarJad_an.jad_cp());
                }
                jad_cpVarJad_an = jad_mzVarJad_an.jad_an(jad_huVar.jad_ob);
            } else {
                jad_cpVarJad_an = com.jd.ad.sdk.jad_ju.jad_cp.NONE;
            }
            com.jd.ad.sdk.jad_ju.jad_mz jad_mzVar = jad_mzVarJad_an;
            jad_jt<R> jad_jtVar = jad_huVar.jad_an;
            com.jd.ad.sdk.jad_ju.jad_hu jad_huVar2 = jad_huVar.jad_xk;
            List<com.jd.ad.sdk.jad_qb.jad_na.jad_an<?>> listJad_cp = jad_jtVar.jad_cp();
            int size = listJad_cp.size();
            boolean z = false;
            for (int i3 = 0; i3 < size; i3++) {
                if (listJad_cp.get(i3).jad_an.equals(jad_huVar2)) {
                    z = true;
                    break;
                }
            }
            Object obj = jad_xkVarJad_an;
            if (jad_huVar.jad_na.jad_an(!z, jad_anVar2, jad_cpVarJad_an)) {
                if (jad_mzVar == null) {
                    throw new com.jd.ad.sdk.jad_gr.jad_hu.jad_dq(jad_xkVarJad_an.get().getClass());
                }
                int i4 = jad_hu.jad_an.jad_cp[jad_cpVarJad_an.ordinal()];
                if (i4 == 1) {
                    jad_dqVar = new jad_dq(jad_huVar.jad_xk, jad_huVar.jad_iv);
                } else {
                    if (i4 != 2) {
                        throw new IllegalArgumentException("Unknown strategy: " + jad_cpVarJad_an);
                    }
                    jad_dqVar = new jad_zm(jad_huVar.jad_an.jad_cp.jad_an, jad_huVar.jad_xk, jad_huVar.jad_iv, jad_huVar.jad_ly, jad_huVar.jad_mz, jad_naVar, cls, jad_huVar.jad_ob);
                }
                jad_wj<Z> jad_wjVarJad_an = jad_wj.jad_an(jad_xkVarJad_an);
                jad_hu.jad_dq<?> jad_dqVar2 = jad_huVar.jad_fs;
                jad_dqVar2.jad_an = jad_dqVar;
                jad_dqVar2.jad_bo = jad_mzVar;
                jad_dqVar2.jad_cp = jad_wjVarJad_an;
                obj = jad_wjVarJad_an;
            }
            return this.jad_cp.jad_an(obj, jad_jwVar);
        } catch (Throwable th) {
            this.jad_dq.release(list);
            throw th;
        }
    }

    public final jad_xk<ResourceType> jad_an(com.jd.ad.sdk.jad_kv.jad_er<DataType> jad_erVar, int i, int i2, com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar, List<Throwable> list) throws jad_sf {
        int size = this.jad_bo.size();
        jad_xk<ResourceType> jad_xkVarJad_an = null;
        for (int i3 = 0; i3 < size; i3++) {
            com.jd.ad.sdk.jad_ju.jad_ly<DataType, ResourceType> jad_lyVar = this.jad_bo.get(i3);
            try {
                if (jad_lyVar.jad_an(jad_erVar.jad_an(), jad_jwVar)) {
                    jad_xkVarJad_an = jad_lyVar.jad_an(jad_erVar.jad_an(), i, i2, jad_jwVar);
                }
            } catch (IOException | OutOfMemoryError | RuntimeException e) {
                if (Log.isLoggable("DecodePath", 2)) {
                    Logger.v("DecodePath", "Failed to decode data for " + jad_lyVar, e);
                }
                list.add(e);
            }
            if (jad_xkVarJad_an != null) {
                break;
            }
        }
        if (jad_xkVarJad_an != null) {
            return jad_xkVarJad_an;
        }
        throw new jad_sf(this.jad_er, new ArrayList(list));
    }

    public String toString() {
        return com.jd.ad.sdk.jad_gr.jad_ly.jad_an("DecodePath{ dataClass=").append(this.jad_an).append(", decoders=").append(this.jad_bo).append(", transcoder=").append(this.jad_cp).append('}').toString();
    }
}
