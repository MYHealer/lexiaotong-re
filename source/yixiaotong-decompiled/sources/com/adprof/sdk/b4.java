package com.adprof.sdk;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class b4 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c4 f1065a;

    public b4(c4 c4Var) {
        this.f1065a = c4Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            c4 c4Var = this.f1065a;
            n4 n4Var = c4Var.f169a;
            if (n4Var.f500a != null) {
                ViewGroup.LayoutParams layoutParamsA = n4Var.a(c4Var.f1100a);
                hp.m656a((View) this.f1065a.f169a.f500a);
                n4 n4Var2 = this.f1065a.f169a;
                n4Var2.f498a.addView(n4Var2.f500a, layoutParamsA);
            }
            n4 n4Var3 = this.f1065a.f169a;
            n4.a(n4Var3, n4Var3.f498a);
            this.f1065a.f169a.c();
            n4 n4Var4 = this.f1065a.f169a;
            n4Var4.a(n4Var4.f498a);
            this.f1065a.f169a.d();
            if (this.f1065a.f169a.f503a.size() > 1) {
                this.f1065a.f169a.h();
                if (this.f1065a.f169a.f498a.getParent() != null) {
                    this.f1065a.f169a.e();
                }
            }
        } catch (Exception e) {
            oh.b(e);
            pk.d("switchRunnable = " + Log.getStackTraceString(e));
        }
    }
}
