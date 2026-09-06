package com.byazt.py;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 1879, 13})
public class tt implements Runnable {
    public com.byazt.nbs.tt c;
    public Runnable tt;
    public boolean ve = false;

    public boolean c() {
        return this.ve;
    }

    public tt(com.byazt.nbs.tt ttVar, Runnable runnable) {
        this.c = ttVar;
        this.tt = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.byazt.nbs.tt ttVar = this.c;
        if (ttVar != null && ttVar.i() == 4) {
            this.c.x().put("serverBidding_timeout", Boolean.TRUE);
        }
        this.ve = true;
        Runnable runnable = this.tt;
        if (runnable != null) {
            runnable.run();
        }
    }
}
