package com.adprof.sdk;

import android.util.Log;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class e4 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f1141a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ f4 f232a;

    public e4(f4 f4Var, d dVar) {
        this.f232a = f4Var;
        this.f1141a = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (!n4.a(this.f232a.f1164a)) {
                pk.a("BannerAdManager switchRunnable UI - 容器无效，跳过切换");
                return;
            }
            n4 n4Var = this.f232a.f1164a;
            d dVar = this.f1141a;
            ((p5) n4Var).f546a = dVar;
            n4.a(n4Var, dVar);
            this.f232a.f1164a.c();
        } catch (Throwable th) {
            oh.b(th);
            pk.d("switchRunnable = " + Log.getStackTraceString(th));
        }
    }
}
