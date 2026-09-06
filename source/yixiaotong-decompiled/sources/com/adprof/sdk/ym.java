package com.adprof.sdk;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.adprof.sdk.base.fb.FBView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class ym implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ an f1542a;

    public ym(an anVar) {
        this.f1542a = anVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a() {
        try {
            an anVar = this.f1542a;
            w6.a(anVar, ((x0) anVar).f821a, new xm(this));
        } catch (Throwable th) {
            oh.b(th);
        }
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
        q0 q0Var;
        o1 o1Var;
        q0 q0Var2;
        ImageView imageView;
        String str;
        this.f1542a.f();
        an anVar = this.f1542a;
        anVar.getClass();
        boolean z = true;
        try {
            ((qm) anVar).f685a.getClass();
            int i = ((x0) anVar).f821a.d;
            ViewGroup.LayoutParams layoutParams = ((qm) anVar).f686b.getLayoutParams();
            if (i == 1) {
                layoutParams.width = h8.a(35.0f);
                layoutParams.height = h8.a(35.0f);
                ((qm) anVar).f686b.setLayoutParams(layoutParams);
                ((qm) anVar).f690d.setTextSize(2, 16.0f);
            } else if (i != 2) {
                layoutParams.width = h8.a(30.0f);
                layoutParams.height = h8.a(30.0f);
                ((qm) anVar).f686b.setLayoutParams(layoutParams);
                ((qm) anVar).f690d.setTextSize(2, 13.0f);
            } else {
                layoutParams.width = h8.a(25.0f);
                layoutParams.height = h8.a(25.0f);
                ((qm) anVar).f686b.setLayoutParams(layoutParams);
                ((qm) anVar).f690d.setTextSize(2, 8.0f);
            }
            if (((x0) anVar).f821a.m605f()) {
                int iA = ((qm) anVar).f685a.a();
                ((qm) anVar).f686b.setOnClickListener(new tm(anVar));
                if (iA == 0) {
                    zl zlVar = anVar.f31a;
                    if (zlVar != null) {
                        zlVar.setVideoMute(true);
                    }
                    ((qm) anVar).f686b.setImageResource(R.drawable.adprof_sound_off);
                    imageView = ((qm) anVar).f686b;
                    str = "sound_off";
                } else {
                    zl zlVar2 = anVar.f31a;
                    if (zlVar2 != null) {
                        zlVar2.setVideoMute(false);
                    }
                    ((qm) anVar).f686b.setImageResource(R.drawable.adprof_sound_on);
                    imageView = ((qm) anVar).f686b;
                    str = "sound_on";
                }
                imageView.setTag(str);
            } else {
                ((qm) anVar).f686b.setVisibility(8);
            }
        } catch (Throwable th) {
            pk.b("Splash layout skip error: ", th);
            oh.b(th);
        }
        this.f1542a.e();
        an anVar2 = this.f1542a;
        d dVar = ((x0) anVar2).f821a;
        int i2 = (dVar == null || (q0Var2 = dVar.f188a) == null) ? 0 : q0Var2.c;
        if (i2 == 4) {
            anVar2.getClass();
            try {
                if (((n5) ((qm) anVar2).f685a).f510a == 1) {
                    z = false;
                }
                bo.a(anVar2.f26a, anVar2.getContext(), ((x0) anVar2).f821a, z, new zm(anVar2));
            } catch (Exception e) {
                pk.a("SplashView_one", "twistStart error", e);
            }
        } else if (i2 == 3) {
            if (((n5) ((qm) anVar2).f685a).f510a == 1) {
                anVar2.f26a.setVisibility(8);
                TextView textView = anVar2.g;
                if (textView != null) {
                    textView.setVisibility(8);
                }
            } else {
                if (anVar2.f30a == null) {
                    anVar2.f30a = new rl(anVar2.getContext());
                }
                int iA2 = h8.a(100.0f);
                anVar2.f30a.setLayoutParams(new ViewGroup.LayoutParams(iA2, iA2));
                try {
                    c2 c2Var = new c2(((x0) anVar2).f817a);
                    anVar2.f28a = c2Var;
                    d dVar2 = ((x0) anVar2).f821a;
                    c2Var.a(ml.a(dVar2), ml.b(((x0) anVar2).f821a), ml.m687a(((x0) anVar2).f821a), ml.m688a(((x0) anVar2).f821a), dVar2 != null ? dVar2.f190a.f1499a : 0);
                    ml.a(anVar2.f28a, ((x0) anVar2).f821a);
                    anVar2.f28a.f157a = new vm(anVar2);
                } catch (Throwable th2) {
                    pk.a(th2);
                }
                anVar2.f28a.d();
                anVar2.f32b.removeAllViews();
                anVar2.f32b.addView(anVar2.f30a);
                anVar2.f30a.b();
                TextView textView2 = anVar2.g;
                if (textView2 != null) {
                    textView2.setVisibility(0);
                }
            }
        }
        if (z8.a(((x0) this.f1542a).f821a)) {
            an anVar3 = this.f1542a;
            anVar3.setOnTouchListener(anVar3);
        }
        an anVar4 = this.f1542a;
        anVar4.getClass();
        try {
            ul ulVarA = vl.a(((x0) anVar4).f821a);
            if (ulVarA == null || "1".equals(ulVarA.m)) {
                FBView fBView = anVar4.f27a;
                if (fBView != null) {
                    fBView.setVisibility(0);
                    anVar4.f27a.setAdUnit(((x0) anVar4).f821a);
                }
            } else {
                FBView fBView2 = anVar4.f27a;
                if (fBView2 != null) {
                    fBView2.setVisibility(4);
                }
            }
        } catch (Exception e2) {
            pk.c("SplashView setupFeedbackView check feedbackEnable error", e2);
        }
        an anVar5 = this.f1542a;
        d dVar3 = ((x0) anVar5).f821a;
        if (dVar3 == null || (q0Var = dVar3.f188a) == null || (o1Var = q0Var.f639a) == null || !o1Var.f525b) {
            return;
        }
        k9 k9Var = new k9(anVar5);
        anVar5.f29a = k9Var;
        k9Var.a(dVar3, new Runnable() { // from class: com.adprof.sdk.ym$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a();
            }
        });
    }
}
