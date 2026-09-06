package com.adprof.sdk;

import android.view.View;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class p implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q f1352a;

    public p(q qVar) {
        this.f1352a = qVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1352a.getClass();
        ne neVar = this.f1352a.f629a;
        if (neVar != null) {
            neVar.a();
        }
        q qVar = this.f1352a;
        if (ll.m678a(qVar.f628a)) {
            try {
                c2 c2Var = qVar.f627a;
                if (c2Var != null) {
                    c2Var.b();
                }
            } catch (Throwable th) {
                pk.b("AFMotionView disableShakeFeature release detector error", th);
            }
            try {
                pe peVar = qVar.f630a;
                if (peVar != null) {
                    peVar.c();
                    qVar.f630a.setVisibility(4);
                }
                hp.m656a((View) qVar.f626a);
            } catch (Throwable th2) {
                pk.b("AFMotionView disableShakeFeature remove view error", th2);
            }
        }
    }
}
