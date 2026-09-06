package com.jd.ad.sdk.jad_mx;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class jad_jt<Transcode> {
    public final List<com.jd.ad.sdk.jad_qb.jad_na.jad_an<?>> jad_an = new ArrayList();
    public final List<com.jd.ad.sdk.jad_ju.jad_hu> jad_bo = new ArrayList();
    public com.jd.ad.sdk.jad_gr.jad_er jad_cp;
    public Object jad_dq;
    public int jad_er;
    public int jad_fs;
    public jad_hu.jad_er jad_hu;
    public com.jd.ad.sdk.jad_ju.jad_jw jad_iv;
    public Class<?> jad_jt;
    public Map<Class<?>, com.jd.ad.sdk.jad_ju.jad_na<?>> jad_jw;
    public Class<Transcode> jad_kx;
    public boolean jad_ly;
    public boolean jad_mz;
    public com.jd.ad.sdk.jad_ju.jad_hu jad_na;
    public com.jd.ad.sdk.jad_gr.jad_jt jad_ob;
    public jad_ly jad_pc;
    public boolean jad_qd;
    public boolean jad_re;

    /* JADX WARN: Multi-variable type inference failed */
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
    public <Data> jad_vi<Data, ?, Transcode> jad_an(Class<Data> cls) {
        jad_vi<Data, ?, Transcode> jad_viVar;
        ArrayList arrayList;
        com.jd.ad.sdk.jad_yj.jad_er jad_erVar;
        com.jd.ad.sdk.jad_yj.jad_er jad_erVar2;
        com.jd.ad.sdk.jad_gr.jad_hu jad_huVar = this.jad_cp.jad_bo;
        Class<?> cls2 = this.jad_jt;
        Class<Transcode> cls3 = this.jad_kx;
        com.jd.ad.sdk.jad_bm.jad_cp jad_cpVar = jad_huVar.jad_iv;
        com.jd.ad.sdk.jad_ir.jad_jw andSet = jad_cpVar.jad_bo.getAndSet(null);
        if (andSet == null) {
            andSet = new com.jd.ad.sdk.jad_ir.jad_jw();
        }
        andSet.jad_an = cls;
        andSet.jad_bo = cls2;
        andSet.jad_cp = cls3;
        synchronized (jad_cpVar.jad_an) {
            jad_viVar = (jad_vi) jad_cpVar.jad_an.get(andSet);
        }
        jad_cpVar.jad_bo.set(andSet);
        jad_huVar.jad_iv.getClass();
        if (com.jd.ad.sdk.jad_bm.jad_cp.jad_cp.equals(jad_viVar)) {
            return null;
        }
        if (jad_viVar != null) {
            return jad_viVar;
        }
        ArrayList arrayList2 = new ArrayList();
        for (Class<?> cls4 : (ArrayList) jad_huVar.jad_cp.jad_an(cls, cls2)) {
            for (Class cls5 : (ArrayList) jad_huVar.jad_fs.jad_an(cls4, cls3)) {
                com.jd.ad.sdk.jad_bm.jad_er jad_erVar3 = jad_huVar.jad_cp;
                synchronized (jad_erVar3) {
                    arrayList = new ArrayList();
                    Iterator<String> it = jad_erVar3.jad_an.iterator();
                    while (it.hasNext()) {
                        List<com.jd.ad.sdk.jad_bm.jad_er.jad_an<?, ?>> list = jad_erVar3.jad_bo.get(it.next());
                        if (list != null) {
                            for (com.jd.ad.sdk.jad_bm.jad_er.jad_an<?, ?> jad_anVar : list) {
                                if (jad_anVar.jad_an.isAssignableFrom(cls) && cls4.isAssignableFrom(jad_anVar.jad_bo)) {
                                    arrayList.add(jad_anVar.jad_cp);
                                }
                            }
                        }
                    }
                }
                com.jd.ad.sdk.jad_yj.jad_fs jad_fsVar = jad_huVar.jad_fs;
                synchronized (jad_fsVar) {
                    if (!cls5.isAssignableFrom(cls4)) {
                        Iterator<com.jd.ad.sdk.jad_yj.jad_fs.jad_an<?, ?>> it2 = jad_fsVar.jad_an.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                throw new IllegalArgumentException("No transcoder registered to transcode from " + cls4 + " to " + cls5);
                            }
                            com.jd.ad.sdk.jad_yj.jad_fs.jad_an<?, ?> next = it2.next();
                            if (next.jad_an.isAssignableFrom(cls4) && cls5.isAssignableFrom(next.jad_bo)) {
                                jad_erVar = next.jad_cp;
                                break;
                            }
                        }
                    } else {
                        jad_erVar = com.jd.ad.sdk.jad_yj.jad_jt.jad_an;
                    }
                    jad_erVar2 = jad_erVar;
                }
                arrayList2.add(new jad_kx(cls, cls4, cls5, arrayList, jad_erVar2, jad_huVar.jad_jw));
            }
        }
        jad_vi<Data, ?, Transcode> jad_viVar2 = arrayList2.isEmpty() ? null : new jad_vi<>(cls, cls2, cls3, arrayList2, jad_huVar.jad_jw);
        com.jd.ad.sdk.jad_bm.jad_cp jad_cpVar2 = jad_huVar.jad_iv;
        synchronized (jad_cpVar2.jad_an) {
            jad_cpVar2.jad_an.put(new com.jd.ad.sdk.jad_ir.jad_jw(cls, cls2, cls3), jad_viVar2 != null ? jad_viVar2 : com.jd.ad.sdk.jad_bm.jad_cp.jad_cp);
        }
        return jad_viVar2;
    }

    public List<com.jd.ad.sdk.jad_ju.jad_hu> jad_an() {
        if (!this.jad_mz) {
            this.jad_mz = true;
            this.jad_bo.clear();
            List<com.jd.ad.sdk.jad_qb.jad_na.jad_an<?>> listJad_cp = jad_cp();
            int size = listJad_cp.size();
            for (int i = 0; i < size; i++) {
                com.jd.ad.sdk.jad_qb.jad_na.jad_an<?> jad_anVar = listJad_cp.get(i);
                if (!this.jad_bo.contains(jad_anVar.jad_an)) {
                    this.jad_bo.add(jad_anVar.jad_an);
                }
                for (int i2 = 0; i2 < jad_anVar.jad_bo.size(); i2++) {
                    if (!this.jad_bo.contains(jad_anVar.jad_bo.get(i2))) {
                        this.jad_bo.add(jad_anVar.jad_bo.get(i2));
                    }
                }
            }
        }
        return this.jad_bo;
    }

    public <Z> com.jd.ad.sdk.jad_ju.jad_na<Z> jad_bo(Class<Z> cls) {
        com.jd.ad.sdk.jad_ju.jad_na<Z> jad_naVar = (com.jd.ad.sdk.jad_ju.jad_na) this.jad_jw.get(cls);
        if (jad_naVar == null) {
            for (Map.Entry<Class<?>, com.jd.ad.sdk.jad_ju.jad_na<?>> entry : this.jad_jw.entrySet()) {
                if (entry.getKey().isAssignableFrom(cls)) {
                    jad_naVar = (com.jd.ad.sdk.jad_ju.jad_na) entry.getValue();
                    break;
                }
            }
        }
        if (jad_naVar != null) {
            return jad_naVar;
        }
        if (this.jad_jw.isEmpty() && this.jad_qd) {
            throw new IllegalArgumentException("Missing transformation for " + cls + ". If you wish to ignore unknown resource types, use the optional transformation methods.");
        }
        return (com.jd.ad.sdk.jad_sd.jad_bo) com.jd.ad.sdk.jad_sd.jad_bo.jad_bo;
    }

    public com.jd.ad.sdk.jad_oz.jad_an jad_bo() {
        return ((jad_mz.jad_cp) this.jad_hu).jad_an();
    }

    public List<com.jd.ad.sdk.jad_qb.jad_na.jad_an<?>> jad_cp() {
        if (!this.jad_ly) {
            this.jad_ly = true;
            this.jad_an.clear();
            List listJad_an = this.jad_cp.jad_bo.jad_an(this.jad_dq);
            int size = listJad_an.size();
            for (int i = 0; i < size; i++) {
                com.jd.ad.sdk.jad_qb.jad_na.jad_an<?> jad_anVarJad_an = ((com.jd.ad.sdk.jad_qb.jad_na) listJad_an.get(i)).jad_an(this.jad_dq, this.jad_er, this.jad_fs, this.jad_iv);
                if (jad_anVarJad_an != null) {
                    this.jad_an.add(jad_anVarJad_an);
                }
            }
        }
        return this.jad_an;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean jad_cp(Class<?> cls) {
        return jad_an((Class) cls) != null;
    }

    public List<Class<?>> jad_dq() {
        List<Class<?>> list;
        ArrayList arrayList;
        com.jd.ad.sdk.jad_gr.jad_hu jad_huVar = this.jad_cp.jad_bo;
        Class<?> cls = this.jad_dq.getClass();
        Class<?> cls2 = this.jad_jt;
        Class<Transcode> cls3 = this.jad_kx;
        com.jd.ad.sdk.jad_bm.jad_dq jad_dqVar = jad_huVar.jad_hu;
        com.jd.ad.sdk.jad_ir.jad_jw andSet = jad_dqVar.jad_an.getAndSet(null);
        if (andSet == null) {
            andSet = new com.jd.ad.sdk.jad_ir.jad_jw(cls, cls2, cls3);
        } else {
            andSet.jad_an = cls;
            andSet.jad_bo = cls2;
            andSet.jad_cp = cls3;
        }
        synchronized (jad_dqVar.jad_bo) {
            list = jad_dqVar.jad_bo.get(andSet);
        }
        jad_dqVar.jad_an.set(andSet);
        List<Class<?>> list2 = list;
        if (list == null) {
            ArrayList arrayList2 = new ArrayList();
            com.jd.ad.sdk.jad_qb.jad_pc jad_pcVar = jad_huVar.jad_an;
            synchronized (jad_pcVar) {
                com.jd.ad.sdk.jad_qb.jad_re jad_reVar = jad_pcVar.jad_an;
                synchronized (jad_reVar) {
                    arrayList = new ArrayList();
                    for (com.jd.ad.sdk.jad_qb.jad_re.jad_bo<?, ?> jad_boVar : jad_reVar.jad_an) {
                        if (!arrayList.contains(jad_boVar.jad_bo) && jad_boVar.jad_an.isAssignableFrom(cls)) {
                            arrayList.add(jad_boVar.jad_bo);
                        }
                    }
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                for (Class cls4 : (ArrayList) jad_huVar.jad_cp.jad_an((Class) it.next(), cls2)) {
                    if (!((ArrayList) jad_huVar.jad_fs.jad_an(cls4, cls3)).isEmpty() && !arrayList2.contains(cls4)) {
                        arrayList2.add(cls4);
                    }
                }
            }
            com.jd.ad.sdk.jad_bm.jad_dq jad_dqVar2 = jad_huVar.jad_hu;
            List<Class<?>> listUnmodifiableList = Collections.unmodifiableList(arrayList2);
            synchronized (jad_dqVar2.jad_bo) {
                jad_dqVar2.jad_bo.put(new com.jd.ad.sdk.jad_ir.jad_jw(cls, cls2, cls3), listUnmodifiableList);
            }
            list2 = arrayList2;
        }
        return list2;
    }

    public <X> com.jd.ad.sdk.jad_ju.jad_dq<X> jad_an(X x) {
        com.jd.ad.sdk.jad_ju.jad_dq<X> jad_dqVar;
        com.jd.ad.sdk.jad_bm.jad_an jad_anVar = this.jad_cp.jad_bo.jad_bo;
        Class<?> cls = x.getClass();
        synchronized (jad_anVar) {
            for (com.jd.ad.sdk.jad_bm.jad_an.C0549jad_an<?> c0549jad_an : jad_anVar.jad_an) {
                if (c0549jad_an.jad_an.isAssignableFrom(cls)) {
                    jad_dqVar = (com.jd.ad.sdk.jad_ju.jad_dq<X>) c0549jad_an.jad_bo;
                }
            }
            jad_dqVar = null;
        }
        if (jad_dqVar != null) {
            return jad_dqVar;
        }
        throw new com.jd.ad.sdk.jad_gr.jad_hu.jad_er(x.getClass());
    }

    public boolean jad_an(jad_xk<?> jad_xkVar) {
        return this.jad_cp.jad_bo.jad_dq.jad_an(jad_xkVar.jad_cp()) != null;
    }
}
