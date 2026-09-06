package com.adprof.sdk;

import java.lang.ref.WeakReference;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class k5 implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n5 f1260a;

    public k5(n5 n5Var) {
        this.f1260a = n5Var;
    }

    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        pk.d("download dialog click invoke ");
        try {
            d dVar = this.f1260a.f512a;
            if (dVar != null) {
                WeakReference weakReference = dVar.f193a;
                x0 x0Var = weakReference != null ? (x0) weakReference.get() : null;
                if (x0Var != null) {
                    x0Var.a("5");
                    s5.a(this.f1260a.f512a.k(), "action.reward.video.click");
                }
            }
            this.f1260a.b();
        } catch (Throwable th) {
            pk.a(th);
        }
        return null;
    }
}
