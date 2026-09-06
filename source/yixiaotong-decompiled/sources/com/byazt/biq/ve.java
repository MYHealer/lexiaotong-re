package com.byazt.biq;

import com.byazt.aas.nb;
import com.byazt.ete.ic;
import com.byazt.kcl.a;
import com.byazt.omf.gt;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 12, 54})
public class ve {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f2004a;
    public int n;
    public final com.byazt.fcd.c sp;
    public final int uj;
    public int c = 0;
    public int tt = 0;
    public int ve = 1000;

    public int a() {
        return this.tt;
    }

    public void c(int i) {
        this.n += i;
    }

    public int i() {
        return this.ve;
    }

    public int n() {
        return this.c;
    }

    public void sp() {
        this.c++;
    }

    public int tt() {
        return this.n;
    }

    public void tt(int i) {
        this.tt = i;
    }

    public int ve() {
        return this.uj;
    }

    public void ve(int i) {
        this.ve = i;
    }

    public void x() {
        this.tt++;
    }

    public ve(boolean z, ic icVar, a aVar, com.byazt.fcd.c cVar) {
        int iN;
        this.f2004a = aVar;
        this.sp = cVar;
        if (z) {
            iN = gt.tt().uj(nb.t(icVar));
        } else {
            iN = gt.tt().n(nb.t(icVar));
        }
        this.uj = iN;
    }

    public long c() {
        return this.f2004a.h();
    }

    public int uj() {
        return this.sp.pf();
    }
}
