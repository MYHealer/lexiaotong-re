package com.jd.ad.sdk.jad_ox;

import android.graphics.PointF;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_kx extends jad_jt<PointF> {
    public final PointF jad_iv;

    public jad_kx(List<com.jd.ad.sdk.jad_yh.jad_an<PointF>> list) {
        super(list);
        this.jad_iv = new PointF();
    }

    @Override // com.jd.ad.sdk.jad_ox.jad_an
    public Object jad_an(com.jd.ad.sdk.jad_yh.jad_an jad_anVar, float f) {
        return jad_an(jad_anVar, f, f, f);
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
    @Override // com.jd.ad.sdk.jad_ox.jad_an
    /* JADX INFO: renamed from: jad_bo, reason: merged with bridge method [inline-methods] */
    public PointF jad_an(com.jd.ad.sdk.jad_yh.jad_an<PointF> jad_anVar, float f, float f2, float f3) {
        PointF pointF;
        PointF pointF2;
        PointF pointF3 = jad_anVar.jad_bo;
        if (pointF3 == null || (pointF = jad_anVar.jad_cp) == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        PointF pointF4 = pointF3;
        PointF pointF5 = pointF;
        com.jd.ad.sdk.jad_yh.jad_cp<A> jad_cpVar = this.jad_er;
        if (jad_cpVar != 0 && (pointF2 = (PointF) jad_cpVar.jad_an(jad_anVar.jad_jt, jad_anVar.jad_hu.floatValue(), pointF4, pointF5, f, jad_dq(), this.jad_dq)) != null) {
            return pointF2;
        }
        PointF pointF6 = this.jad_iv;
        float f4 = pointF4.x;
        float f5 = ((pointF5.x - f4) * f2) + f4;
        float f6 = pointF4.y;
        pointF6.set(f5, ((pointF5.y - f6) * f3) + f6);
        return this.jad_iv;
    }
}
