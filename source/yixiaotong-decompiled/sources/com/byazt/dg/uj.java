package com.byazt.dg;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEODECODER_FPS, 15})
public class uj extends sp<Float> {
    public uj(List<com.byazt.vc.c<Float>> list) {
        super(list);
    }

    @Override // com.byazt.dg.c
    /* JADX INFO: renamed from: tt, reason: merged with bridge method [inline-methods] */
    public Float c(com.byazt.vc.c<Float> cVar, float f) {
        return Float.valueOf(ve(cVar, f));
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
    public float ve(com.byazt.vc.c<Float> cVar, float f) {
        Float f2;
        if (cVar.c == null || cVar.tt == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        if (this.ve != null && (f2 = (Float) this.ve.c(cVar.f2810a, cVar.sp.floatValue(), cVar.c, cVar.tt, f, uj(), x())) != null) {
            return f2.floatValue();
        }
        return com.byazt.kk.i.c(cVar.a(), cVar.sp(), f);
    }

    public float i() {
        return ve(ve(), n());
    }
}
