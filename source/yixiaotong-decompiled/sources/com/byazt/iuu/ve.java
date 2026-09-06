package com.byazt.iuu;

import com.byazt.ete.x;
import com.byazt.iu.n;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
@com.byazt.zqa.c(c = {0, 1, 1651, 54})
public class ve extends tt {
    public final AtomicBoolean c;
    public final AtomicBoolean t;
    public final AtomicBoolean tt;
    public final AtomicBoolean uj;
    public final AtomicBoolean ve;

    public ve(n nVar, x.ve veVar) {
        super(nVar);
        this.c = new AtomicBoolean(false);
        this.tt = new AtomicBoolean(false);
        this.ve = new AtomicBoolean(false);
        this.uj = new AtomicBoolean(false);
        this.t = new AtomicBoolean(false);
        this.n = veVar;
    }

    @Override // com.byazt.iuu.tt
    public void c(int i, String str) {
        this.i = i;
        this.da = str;
        this.tt.set(true);
        this.t.set(true);
        c();
    }

    public void c() {
        if (this.uj.get() && this.sl != 2 && this.sp != null) {
            c(this.sp, 2);
            return;
        }
        if (this.t.get()) {
            if (this.f2353a != null) {
                c(this.f2353a, 1);
            } else if (this.ve.get()) {
                c((com.byazt.iu.ve) null, 3);
            }
        }
    }

    private void c(com.byazt.iu.ve veVar, int i) {
        if (!this.c.compareAndSet(false, true)) {
            if (veVar != null) {
                veVar.ve();
                return;
            }
            return;
        }
        this.sl = i;
        if (i == 3) {
            if (this.x != null) {
                this.x.c(this.i, this.da);
            }
        } else if (veVar != null) {
            veVar.c();
        }
    }

    @Override // com.byazt.iuu.tt
    public void c(boolean z) {
        if (z) {
            this.uj.set(true);
            c();
        } else {
            this.ve.set(true);
            c();
        }
    }

    @Override // com.byazt.iuu.tt
    public void ve() {
        this.t.set(true);
        c();
    }
}
