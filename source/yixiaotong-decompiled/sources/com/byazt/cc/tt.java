package com.byazt.cc;

import com.byazt.nr.rh;
import com.byazt.omf.gt;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 448, 13})
public class tt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.byazt.ete.x.uj f2033a;
    public com.byazt.vvt.a.c n;
    public int uj;
    public int c = 0;
    public long tt = 0;
    public int ve = -1;

    public boolean c() {
        return this.c == 4;
    }

    public int c(com.byazt.dj.tt ttVar, int i) {
        int iVe;
        double d;
        this.uj = i;
        int iX = gt.tt().x(i);
        if (iX > 0 && iX <= 3) {
            com.byazt.ete.x.ve veVarC = com.byazt.ete.x.c();
            int i2 = veVarC == null ? 0 : veVarC.i();
            com.byazt.ete.x.uj ujVarSl = veVarC == null ? null : veVarC.sl();
            this.f2033a = ujVarSl;
            if (ujVarSl != null && i2 == 5) {
                if (ujVarSl.tt() > 0) {
                    try {
                        d = Double.parseDouble(com.byazt.whk.c.c().c("DeviceRate", "bytebench_value", ttVar.or()));
                    } catch (Exception unused) {
                        d = 0.0d;
                    }
                    if (d > 0.0d && d < this.f2033a.tt()) {
                        this.c = 1;
                        return 1;
                    }
                }
                if (this.f2033a.ve() > 0 && ((iVe = rh.ve(gt.getContext())) == 2 ? (this.f2033a.ve() & 1) != 0 : !(iVe == 3 ? (this.f2033a.ve() & 2) == 0 : iVe == 4 ? (this.f2033a.ve() & 16) == 0 : iVe == 5 ? (this.f2033a.ve() & 4) == 0 : iVe != 6 || (this.f2033a.ve() & 8) == 0))) {
                    this.c = 2;
                    return 1;
                }
                this.n = com.byazt.vvt.a.c(String.valueOf(i), this.f2033a);
                if (this.f2033a.uj() > 0) {
                    this.c = 3;
                    int iC = this.n.c(this.f2033a.uj(), this.f2033a);
                    if (iC > 0) {
                        this.tt = System.currentTimeMillis() - (((long) iC) * 60000);
                        return 1;
                    }
                    if (iC == 0) {
                        return 1;
                    }
                }
                this.c = 4;
                c(this.n.c(this.f2033a.n(), this.f2033a));
                return 2;
            }
        }
        return iX;
    }

    public boolean tt() {
        com.byazt.ete.x.uj ujVar;
        if (this.tt <= 0 || this.c != 3) {
            return false;
        }
        com.byazt.vvt.a.c cVar = this.n;
        c((cVar == null || (ujVar = this.f2033a) == null) ? -1 : cVar.c(ujVar.n(), this.f2033a));
        this.ve = 2;
        return true;
    }

    private void c(int i) {
        if (i > 0) {
            this.tt = System.currentTimeMillis() - (((long) i) * 60000);
        } else if (i == 0) {
            this.tt = 0L;
        } else {
            this.tt = System.currentTimeMillis();
        }
    }
}
