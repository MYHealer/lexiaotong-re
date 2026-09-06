package com.adprof.sdk;

import android.view.ViewGroup;
import android.view.animation.Animation;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class o4 implements Animation.AnimationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f1336a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ g5 f533a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ j4 f534a;
    public final /* synthetic */ g5 b;

    public o4(ViewGroup viewGroup, g5 g5Var, j4 j4Var, g5 g5Var2) {
        this.f1336a = viewGroup;
        this.f533a = g5Var;
        this.f534a = j4Var;
        this.b = g5Var2;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.f1336a.removeView(this.f533a);
        j4 j4Var = this.f534a;
        if (j4Var != null) {
            g5 g5Var = this.b;
            n4 n4Var = j4Var.f1242a;
            n4Var.f500a = g5Var;
            n4Var.a(n4Var.f498a);
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
