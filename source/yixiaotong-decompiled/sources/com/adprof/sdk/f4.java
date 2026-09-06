package com.adprof.sdk;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class f4 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n4 f1164a;

    public f4(n4 n4Var) {
        this.f1164a = n4Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            n4 n4Var = this.f1164a;
            if (!n4Var.f505a && n4Var.c && !n4Var.f503a.isEmpty()) {
                if (!n4.a(this.f1164a)) {
                    pk.a("BannerAdManager switchRunnable - 容器无效，停止轮播");
                    this.f1164a.h();
                    return;
                }
                n4 n4Var2 = this.f1164a;
                n4Var2.f506b = (n4Var2.f506b + 1) % n4Var2.f503a.size();
                n4 n4Var3 = this.f1164a;
                this.f1164a.f497a.post(new e4(this, (d) n4Var3.f503a.get(n4Var3.f506b)));
                n4 n4Var4 = this.f1164a;
                if (n4Var4.c && n4.a(n4Var4)) {
                    n4 n4Var5 = this.f1164a;
                    n4Var5.f507b.postDelayed(n4Var5.f508b, n4.b);
                }
            }
        } catch (Throwable th) {
            pk.a(th);
        }
    }
}
