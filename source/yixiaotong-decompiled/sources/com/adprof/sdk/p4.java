package com.adprof.sdk;

import android.view.animation.Animation;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class p4 implements Animation.AnimationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g5 f1356a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ j4 f545a;

    public p4(j4 j4Var, g5 g5Var) {
        this.f545a = j4Var;
        this.f1356a = g5Var;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        j4 j4Var = this.f545a;
        if (j4Var != null) {
            g5 g5Var = this.f1356a;
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
