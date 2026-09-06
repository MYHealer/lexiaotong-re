package com.byazt.dg;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEODECODER_FPS, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class z extends sp<com.byazt.nb.tt> {
    public z(List<com.byazt.vc.c<com.byazt.nb.tt>> list) {
        super(list);
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
    public com.byazt.nb.tt c(com.byazt.vc.c<com.byazt.nb.tt> cVar, float f) {
        if (this.ve != null) {
            return (com.byazt.nb.tt) this.ve.c(cVar.f2810a, cVar.sp == null ? Float.MAX_VALUE : cVar.sp.floatValue(), cVar.c, cVar.tt == null ? cVar.c : cVar.tt, f, n(), x());
        }
        if (f != 1.0f || cVar.tt == null) {
            return cVar.c;
        }
        return cVar.tt;
    }
}
