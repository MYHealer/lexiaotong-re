package com.byazt.dg;

import android.graphics.PointF;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEODECODER_FPS, 158})
public class sl extends sp<PointF> {
    public final PointF uj;

    public sl(List<com.byazt.vc.c<PointF>> list) {
        super(list);
        this.uj = new PointF();
    }

    @Override // com.byazt.dg.c
    /* JADX INFO: renamed from: tt, reason: merged with bridge method [inline-methods] */
    public PointF c(com.byazt.vc.c<PointF> cVar, float f) {
        return c(cVar, f, f, f);
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
    public PointF c(com.byazt.vc.c<PointF> cVar, float f, float f2, float f3) {
        PointF pointF;
        if (cVar.c == null || cVar.tt == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        PointF pointF2 = cVar.c;
        PointF pointF3 = cVar.tt;
        if (this.ve != null && (pointF = (PointF) this.ve.c(cVar.f2810a, cVar.sp.floatValue(), pointF2, pointF3, f, uj(), x())) != null) {
            return pointF;
        }
        this.uj.set(pointF2.x + (f2 * (pointF3.x - pointF2.x)), pointF2.y + (f3 * (pointF3.y - pointF2.y)));
        return this.uj;
    }
}
