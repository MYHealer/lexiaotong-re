package com.hihonor.hianalytics.hnha;

import android.text.TextUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public abstract class w0 {
    private s0 a(int i) {
        String strG;
        if (i != 0) {
            strG = i();
            if (!TextUtils.isEmpty(strG)) {
                return new s0(t0.UDID, strG);
            }
        } else {
            strG = "";
        }
        if ((i & 2) != 0) {
            strG = g();
            if (!TextUtils.isEmpty(strG)) {
                return new s0(t0.IMEI, strG);
            }
        }
        if ((i & 1) == 0) {
            return new s0(t0.EMPTY, strG);
        }
        return new s0(t0.SN, h());
    }

    private s0 b(int i) {
        String strH;
        if ((i & 4) != 0 && (i & 1) != 0) {
            return new s0(t0.UDID, a(h()));
        }
        if ((i & 1) != 0) {
            strH = h();
            if (!TextUtils.isEmpty(strH)) {
                return new s0(t0.SN, strH);
            }
        } else {
            strH = "";
        }
        if ((i & 2) == 0) {
            return new s0(t0.EMPTY, strH);
        }
        return new s0(t0.IMEI, g());
    }

    private boolean f() {
        return !TextUtils.isEmpty(g.m());
    }

    private String g() {
        b1 b1VarB = x0.c().b();
        if (TextUtils.isEmpty(b1VarB.l())) {
            b1VarB.e(com.hihonor.hianalytics.util.n.c());
        }
        return b1VarB.l();
    }

    private String h() {
        b1 b1VarB = x0.c().b();
        if (TextUtils.isEmpty(b1VarB.t())) {
            b1VarB.h(com.hihonor.hianalytics.util.n.d());
        }
        return b1VarB.t();
    }

    private String i() {
        b1 b1VarB = x0.c().b();
        if (TextUtils.isEmpty(b1VarB.u())) {
            b1VarB.i(u0.c());
        }
        return b1VarB.u();
    }

    public abstract String a();

    public abstract String a(String str);

    public abstract String b();

    public abstract String c();

    public abstract int d();

    public s0 e() {
        String strC = c();
        if (!TextUtils.isEmpty(strC)) {
            return new s0(t0.UDID, strC);
        }
        String strA = a();
        if (!TextUtils.isEmpty(strA)) {
            return new s0(t0.IMEI, strA);
        }
        boolean zF = f();
        String strB = b();
        if (TextUtils.isEmpty(strB)) {
            return zF ? a(d()) : b(d());
        }
        return zF ? new s0(t0.SN, strB) : new s0(t0.UDID, a(strB));
    }
}
