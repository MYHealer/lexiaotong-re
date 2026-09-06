package com.byazt.im;

import android.text.TextUtils;
import com.byazt.aas.nb;
import com.byazt.ete.dz;
import com.byazt.ete.ic;
import com.byazt.ete.ma;
import com.byazt.ete.pu;
import com.byazt.ete.xd;
import com.byazt.ete.zb;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
@com.byazt.zqa.c(c = {0, 1, 1352, 13})
public class tt extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2341a;
    public boolean da;
    public int i;
    public com.byazt.sml.tt n;
    public com.byazt.ete.c sl;
    public int sp;
    public boolean t;
    public boolean u;
    public int uj;
    public com.byazt.jzl.uj x;

    public int a() {
        return this.sp;
    }

    public void c(com.byazt.ete.c cVar) {
        this.sl = cVar;
    }

    public void c(boolean z) {
        this.u = z;
    }

    public int da() {
        return this.uj;
    }

    public boolean i() {
        return this.da;
    }

    public int n() {
        return this.f2341a;
    }

    public com.byazt.ete.c sl() {
        return this.sl;
    }

    public com.byazt.jzl.uj sp() {
        return this.x;
    }

    public boolean t() {
        return this.t;
    }

    public boolean u() {
        return this.u;
    }

    public com.byazt.sml.tt uj() {
        return this.n;
    }

    public int x() {
        return this.i;
    }

    public tt(ic icVar, boolean z) {
        if (icVar == null) {
            return;
        }
        this.tt = icVar;
        this.u = z;
        this.t = pu.c(icVar) == 2;
        tt(icVar);
    }

    private void tt(ic icVar) {
        int iW = icVar.w();
        dz dzVarA = pu.a(icVar);
        ma maVarSp = pu.sp(icVar);
        if (TextUtils.isEmpty(xd.c(icVar))) {
            this.uj = 1;
        } else if (ve(icVar)) {
            if (c(dzVarA) || c(maVarSp)) {
                this.uj = 2;
            } else {
                if (tt(dzVarA) || tt(maVarSp)) {
                    pu.c(icVar, 1);
                }
                this.uj = 1;
            }
        } else if (iW == 1) {
            this.uj = 1;
        } else {
            this.uj = 2;
        }
        uj(icVar);
    }

    private boolean c(dz dzVar) {
        return dzVar != null && c(dzVar.x()) == 2;
    }

    private boolean c(ma maVar) {
        return maVar != null && maVar.sp() == 2;
    }

    private boolean tt(dz dzVar) {
        return dzVar != null && c(dzVar.x()) == 0;
    }

    private boolean tt(ma maVar) {
        return maVar != null && maVar.sp() == 0;
    }

    private int c(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return Integer.parseInt(str);
        } catch (Throwable unused) {
            return 0;
        }
    }

    private boolean ve(ic icVar) {
        return pu.c(icVar) == 2;
    }

    private void uj(ic icVar) {
        n(icVar);
        a(icVar);
    }

    private void n(ic icVar) {
        zb zbVar;
        if (icVar.pa() == null || (zbVar = icVar.pa().get(0)) == null) {
            return;
        }
        String strC = zbVar.c();
        if (TextUtils.isEmpty(strC)) {
            return;
        }
        this.f2341a = zbVar.tt();
        this.sp = zbVar.ve();
        this.n = new com.byazt.sml.tt(strC, zbVar.sp());
    }

    private void a(ic icVar) {
        this.x = xd.z(icVar);
        this.i = nb.t(icVar);
        this.da = icVar.ox();
    }
}
