package com.byazt.dg;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEODECODER_FPS, 66})
public class t extends sp<com.byazt.vc.uj> {
    public final com.byazt.vc.uj uj;

    public t(List<com.byazt.vc.c<com.byazt.vc.uj>> list) {
        super(list);
        this.uj = new com.byazt.vc.uj();
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
    @Override // com.byazt.dg.c
    /* JADX INFO: renamed from: tt, reason: merged with bridge method [inline-methods] */
    public com.byazt.vc.uj c(com.byazt.vc.c<com.byazt.vc.uj> cVar, float f) {
        com.byazt.vc.uj ujVar;
        if (cVar.c == null || cVar.tt == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        com.byazt.vc.uj ujVar2 = cVar.c;
        com.byazt.vc.uj ujVar3 = cVar.tt;
        if (this.ve != null && (ujVar = (com.byazt.vc.uj) this.ve.c(cVar.f2810a, cVar.sp.floatValue(), ujVar2, ujVar3, f, uj(), x())) != null) {
            return ujVar;
        }
        this.uj.c(com.byazt.kk.i.c(ujVar2.c(), ujVar3.c(), f), com.byazt.kk.i.c(ujVar2.tt(), ujVar3.tt(), f));
        return this.uj;
    }
}
