package com.adprof.sdk;

import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class z3 implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a4 f1549a;

    public z3(a4 a4Var) {
        this.f1549a = a4Var;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        this.f1549a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        this.f1549a.a();
    }
}
