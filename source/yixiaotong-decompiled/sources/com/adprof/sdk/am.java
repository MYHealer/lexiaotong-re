package com.adprof.sdk;

import android.graphics.Bitmap;
import android.view.ViewGroup;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class am implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Bitmap f1036a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ bm f24a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ d f25a;

    public am(bm bmVar, Bitmap bitmap, d dVar) {
        this.f24a = bmVar;
        this.f1036a = bitmap;
        this.f25a = dVar;
    }

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
    @Override // java.lang.Runnable
    public void run() {
        ViewGroup.LayoutParams layoutParams;
        int height;
        int width;
        ViewGroup viewGroup = ((zl) this.f24a).f921a;
        if (viewGroup == null) {
            return;
        }
        try {
            int i = viewGroup.getContext().getResources().getConfiguration().orientation;
            int measuredHeight = ((zl) this.f24a).f921a.getMeasuredHeight();
            int measuredWidth = ((zl) this.f24a).f921a.getMeasuredWidth();
            if (i == 2) {
                if (this.f1036a.getWidth() < this.f1036a.getHeight()) {
                    this.f24a.f1094a.getLayoutParams().height = measuredHeight;
                    this.f24a.f1094a.getLayoutParams().width = (measuredHeight * this.f1036a.getWidth()) / this.f1036a.getHeight();
                } else {
                    this.f24a.f1094a.getLayoutParams().width = measuredWidth;
                    layoutParams = this.f24a.f1094a.getLayoutParams();
                    height = measuredHeight * this.f1036a.getWidth();
                    width = this.f1036a.getHeight();
                    layoutParams.height = height / width;
                }
            } else if (this.f1036a.getWidth() < this.f1036a.getHeight()) {
                this.f24a.f1094a.getLayoutParams().width = measuredWidth;
                this.f24a.f1094a.getLayoutParams().height = measuredHeight;
            } else {
                this.f24a.f1094a.getLayoutParams().width = measuredWidth;
                layoutParams = this.f24a.f1094a.getLayoutParams();
                height = this.f1036a.getHeight() * measuredWidth;
                width = this.f1036a.getWidth();
                layoutParams.height = height / width;
            }
            this.f24a.f1094a.setImageBitmap(this.f1036a);
            this.f24a.f1094a.invalidate();
            bm bmVar = this.f24a;
            bmVar.a(this.f25a, bmVar);
        } catch (Exception e) {
            pk.a(e);
            oh.b(e);
        }
    }
}
