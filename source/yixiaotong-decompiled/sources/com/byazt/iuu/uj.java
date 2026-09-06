package com.byazt.iuu;

import com.byazt.ete.x;
import com.byazt.iu.n;
import com.byazt.nr.da;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
@com.byazt.zqa.c(c = {0, 1, 1651, 15})
public class uj extends tt implements Runnable {
    public final AtomicBoolean c;
    public final AtomicBoolean t;
    public final AtomicBoolean tt;
    public final int u;
    public final AtomicBoolean uj;
    public final AtomicBoolean ve;
    public final String yp;

    public uj(n nVar, x.ve veVar, int i, String str) {
        super(nVar);
        this.c = new AtomicBoolean(false);
        this.tt = new AtomicBoolean(false);
        this.ve = new AtomicBoolean(false);
        this.uj = new AtomicBoolean(false);
        this.t = new AtomicBoolean(false);
        this.n = veVar;
        this.u = i;
        this.yp = str;
    }

    @Override // com.byazt.iuu.tt
    public void c(int i, String str) {
        this.i = i;
        this.da = str;
        this.ve.set(true);
        this.t.set(true);
        tt();
    }

    public void c() {
        da.tt().postDelayed(this, n());
    }

    @Override // java.lang.Runnable
    public void run() {
        this.c.set(true);
        tt();
    }

    public void tt() {
        if (this.t.get()) {
            da.tt().removeCallbacks(this);
            if (this.f2353a != null) {
                c(this.f2353a, 1);
                return;
            }
            if (this.uj.get()) {
                if (this.ve.get()) {
                    if (this.n.c("forbid_realtime_use_cache", new x.tt.c().c(this.i).c())) {
                        c((com.byazt.iu.ve) null, 3);
                        return;
                    }
                }
                if (this.sp != null) {
                    c(this.sp, 2);
                    return;
                } else {
                    c((com.byazt.iu.ve) null, 3);
                    return;
                }
            }
            return;
        }
        if (this.c.get() && this.uj.get()) {
            if (x.c(this.sl).c("forbid_realtime_use_cache", new x.tt.c().c(-666).c()) || this.sp == null) {
                return;
            }
            c(this.sp, 2);
        }
    }

    private void c(com.byazt.iu.ve veVar, int i) {
        if (this.tt.compareAndSet(false, true)) {
            this.sl = i;
            if (i == 3) {
                if (this.x != null) {
                    this.x.c(this.i, this.da);
                }
            } else if (veVar != null) {
                veVar.c();
            }
            if (i == 1 && this.sp != null) {
                this.sp.ve();
            }
            if (i != 2 || this.f2353a == null) {
                return;
            }
            this.f2353a.ve();
            return;
        }
        if (i == this.sl || veVar == null) {
            return;
        }
        veVar.ve();
    }

    @Override // com.byazt.iuu.tt
    public void c(boolean z) {
        this.uj.set(true);
        tt();
    }

    @Override // com.byazt.iuu.tt
    public void ve() {
        this.t.set(true);
        tt();
    }

    private long n() {
        long jC = com.byazt.wi.tt.c().c(this.u, this.yp);
        if (jC > 0) {
            return jC;
        }
        return (this.n == null || this.n.a() <= 0) ? ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT : this.n.a();
    }
}
