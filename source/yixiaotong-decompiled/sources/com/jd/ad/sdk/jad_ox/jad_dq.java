package com.jd.ad.sdk.jad_ox;

import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_dq extends jad_jt<Float> {
    public jad_dq(List<com.jd.ad.sdk.jad_yh.jad_an<Float>> list) {
        super(list);
    }

    @Override // com.jd.ad.sdk.jad_ox.jad_an
    public Object jad_an(com.jd.ad.sdk.jad_yh.jad_an jad_anVar, float f) {
        return Float.valueOf(jad_bo(jad_anVar, f));
    }

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
    public float jad_bo(com.jd.ad.sdk.jad_yh.jad_an<Float> jad_anVar, float f) {
        Float f2;
        if (jad_anVar.jad_bo == null || jad_anVar.jad_cp == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        com.jd.ad.sdk.jad_yh.jad_cp<A> jad_cpVar = this.jad_er;
        if (jad_cpVar != 0 && (f2 = (Float) jad_cpVar.jad_an(jad_anVar.jad_jt, jad_anVar.jad_hu.floatValue(), jad_anVar.jad_bo, jad_anVar.jad_cp, f, jad_dq(), this.jad_dq)) != null) {
            return f2.floatValue();
        }
        if (jad_anVar.jad_iv == -3987645.8f) {
            jad_anVar.jad_iv = jad_anVar.jad_bo.floatValue();
        }
        float f3 = jad_anVar.jad_iv;
        if (jad_anVar.jad_jw == -3987645.8f) {
            jad_anVar.jad_jw = jad_anVar.jad_cp.floatValue();
        }
        return com.jd.ad.sdk.jad_xg.jad_jt.jad_an(f3, jad_anVar.jad_jw, f);
    }

    public float jad_hu() {
        return jad_bo(jad_an(), jad_cp());
    }
}
