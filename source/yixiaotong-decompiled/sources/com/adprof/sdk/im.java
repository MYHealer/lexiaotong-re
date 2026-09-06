package com.adprof.sdk;

import android.media.MediaPlayer;
import android.view.ViewGroup;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class im implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MediaPlayer f1236a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ jm f388a;

    public im(jm jmVar, MediaPlayer mediaPlayer) {
        this.f388a = jmVar;
        this.f1236a = mediaPlayer;
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
        if (((zl) this.f388a.f403a).f921a == null) {
            return;
        }
        try {
            this.f1236a.start();
            pk.c("--loadResource video onPrepared   video_width = " + this.f388a.f403a.f1292a.getVideoWidth() + "   video_height = " + this.f388a.f403a.f1292a.getVideoHeight());
            int i = ((zl) this.f388a.f403a).f921a.getContext().getResources().getConfiguration().orientation;
            int measuredHeight = ((zl) this.f388a.f403a).f921a.getMeasuredHeight();
            int measuredWidth = ((zl) this.f388a.f403a).f921a.getMeasuredWidth();
            int videoWidth = this.f1236a.getVideoWidth();
            int videoHeight = this.f1236a.getVideoHeight();
            ViewGroup.LayoutParams layoutParams = this.f388a.f403a.f1292a.getLayoutParams();
            if (i == 2) {
                if (videoWidth < videoHeight) {
                    layoutParams.height = measuredHeight;
                    layoutParams.width = (measuredHeight * videoWidth) / videoHeight;
                } else {
                    layoutParams.height = videoHeight;
                    layoutParams.width = videoWidth;
                }
            } else if (videoWidth < videoHeight) {
                layoutParams.width = measuredWidth;
                layoutParams.height = measuredHeight;
            } else {
                layoutParams.width = measuredWidth;
                layoutParams.height = (measuredWidth * videoHeight) / videoWidth;
            }
            this.f388a.f403a.f1292a.setLayoutParams(layoutParams);
            this.f388a.f403a.f1292a.invalidate();
            jm jmVar = this.f388a;
            lm lmVar = jmVar.f403a;
            lmVar.a(jmVar.f1252a, lmVar);
        } catch (Throwable th) {
            pk.a(th);
            oh.b(th);
        }
    }
}
