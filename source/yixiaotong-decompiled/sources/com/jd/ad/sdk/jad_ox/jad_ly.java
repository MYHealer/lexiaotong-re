package com.jd.ad.sdk.jad_ox;

import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_ly extends jad_jt<com.jd.ad.sdk.jad_yh.jad_dq> {
    public final com.jd.ad.sdk.jad_yh.jad_dq jad_iv;

    public jad_ly(List<com.jd.ad.sdk.jad_yh.jad_an<com.jd.ad.sdk.jad_yh.jad_dq>> list) {
        super(list);
        this.jad_iv = new com.jd.ad.sdk.jad_yh.jad_dq();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.jd.ad.sdk.jad_ox.jad_an
    public Object jad_an(com.jd.ad.sdk.jad_yh.jad_an jad_anVar, float f) {
        T t;
        com.jd.ad.sdk.jad_yh.jad_dq jad_dqVar;
        T t2 = jad_anVar.jad_bo;
        if (t2 == 0 || (t = jad_anVar.jad_cp) == 0) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        com.jd.ad.sdk.jad_yh.jad_dq jad_dqVar2 = (com.jd.ad.sdk.jad_yh.jad_dq) t2;
        com.jd.ad.sdk.jad_yh.jad_dq jad_dqVar3 = (com.jd.ad.sdk.jad_yh.jad_dq) t;
        com.jd.ad.sdk.jad_yh.jad_cp<A> jad_cpVar = this.jad_er;
        if (jad_cpVar != 0 && (jad_dqVar = (com.jd.ad.sdk.jad_yh.jad_dq) jad_cpVar.jad_an(jad_anVar.jad_jt, jad_anVar.jad_hu.floatValue(), jad_dqVar2, jad_dqVar3, f, jad_dq(), this.jad_dq)) != null) {
            return jad_dqVar;
        }
        com.jd.ad.sdk.jad_yh.jad_dq jad_dqVar4 = this.jad_iv;
        float fJad_an = com.jd.ad.sdk.jad_xg.jad_jt.jad_an(jad_dqVar2.jad_an, jad_dqVar3.jad_an, f);
        float fJad_an2 = com.jd.ad.sdk.jad_xg.jad_jt.jad_an(jad_dqVar2.jad_bo, jad_dqVar3.jad_bo, f);
        jad_dqVar4.jad_an = fJad_an;
        jad_dqVar4.jad_bo = fJad_an2;
        return this.jad_iv;
    }
}
