package com.jd.ad.sdk.jad_ox;

import android.graphics.PointF;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_fs extends jad_jt<Integer> {
    public jad_fs(List<com.jd.ad.sdk.jad_yh.jad_an<Integer>> list) {
        super(list);
    }

    @Override // com.jd.ad.sdk.jad_ox.jad_an
    public Object jad_an(com.jd.ad.sdk.jad_yh.jad_an jad_anVar, float f) {
        return Integer.valueOf(jad_bo(jad_anVar, f));
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
    public int jad_bo(com.jd.ad.sdk.jad_yh.jad_an<Integer> jad_anVar, float f) {
        Integer num;
        if (jad_anVar.jad_bo == null || jad_anVar.jad_cp == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        com.jd.ad.sdk.jad_yh.jad_cp<A> jad_cpVar = this.jad_er;
        if (jad_cpVar != 0 && (num = (Integer) jad_cpVar.jad_an(jad_anVar.jad_jt, jad_anVar.jad_hu.floatValue(), jad_anVar.jad_bo, jad_anVar.jad_cp, f, jad_dq(), this.jad_dq)) != null) {
            return num.intValue();
        }
        if (jad_anVar.jad_kx == 784923401) {
            jad_anVar.jad_kx = jad_anVar.jad_bo.intValue();
        }
        int i = jad_anVar.jad_kx;
        if (jad_anVar.jad_ly == 784923401) {
            jad_anVar.jad_ly = jad_anVar.jad_cp.intValue();
        }
        int i2 = jad_anVar.jad_ly;
        PointF pointF = com.jd.ad.sdk.jad_xg.jad_jt.jad_an;
        return (int) ((f * (i2 - i)) + i);
    }
}
