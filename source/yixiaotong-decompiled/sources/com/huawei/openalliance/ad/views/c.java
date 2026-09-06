package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import com.huawei.hms.ads.fh;
import com.huawei.hms.ads.nativead.R;
import com.huawei.openalliance.ad.utils.z;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class c extends a {
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
    public c(Context context) {
        super(context);
        this.V.Code(context.getResources().getDrawable(R.drawable.hiad_app_down_btn_normal_hm));
        this.V.Code(context.getResources().getColor(R.color.hiad_down_btn_white));
        LayerDrawable layerDrawable = (LayerDrawable) Code(context, R.drawable.hiad_app_down_btn_processing_hm);
        Drawable drawableFindDrawableByLayerId = layerDrawable.findDrawableByLayerId(android.R.id.progress);
        if (drawableFindDrawableByLayerId instanceof ClipDrawable) {
            h hVar = new h(drawableFindDrawableByLayerId, 17, 1);
            layerDrawable.mutate();
            layerDrawable.setDrawableByLayerId(android.R.id.progress, hVar);
            this.I.Code(layerDrawable);
        } else {
            fh.I("ExtandAppDownloadButtonStyleHm", "not clipDrawable");
            this.I.Code(Code(context, R.drawable.hiad_app_down_btn_processing));
        }
        this.I.Code(context.getResources().getColor(R.color.hiad_emui_black));
        LayerDrawable layerDrawable2 = (LayerDrawable) Code(context, R.drawable.hiad_app_down_btn_installing_hm);
        if (layerDrawable2.findDrawableByLayerId(android.R.id.progress) instanceof ClipDrawable) {
            f fVar = new f(z.V(context, 18.0f));
            layerDrawable2.mutate();
            layerDrawable2.setDrawableByLayerId(android.R.id.progress, fVar);
            this.Z.Code(layerDrawable2);
            fVar.Code();
        } else {
            fh.I("ExtandAppDownloadButtonStyleHm", "not clipDrawable");
            this.Z.Code(Code(context, R.drawable.hiad_app_down_btn_installing));
        }
        this.Z.Code(context.getResources().getColor(R.color.hiad_down_btn_white));
    }
}
