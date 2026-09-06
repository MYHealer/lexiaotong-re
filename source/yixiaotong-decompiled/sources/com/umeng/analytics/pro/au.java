package com.umeng.analytics.pro;

import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;

/* JADX INFO: compiled from: TApplicationException.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class au extends bb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f9107a = 0;
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 3;
    public static final int e = 4;
    public static final int f = 5;
    public static final int g = 6;
    public static final int h = 7;
    private static final bz j = new bz("TApplicationException");
    private static final bp k = new bp(CrashHianalyticsData.MESSAGE, (byte) 11, 1);
    private static final bp l = new bp("type", (byte) 8, 2);
    private static final long m = 1;
    protected int i;

    public int a() {
        return this.i;
    }

    public au() {
        this.i = 0;
    }

    public au(int i) {
        this.i = i;
    }

    public au(int i, String str) {
        super(str);
        this.i = i;
    }

    public au(String str) {
        super(str);
        this.i = 0;
    }

    public static au a(bu buVar) throws bb {
        buVar.j();
        String strZ = null;
        int iW = 0;
        while (true) {
            bp bpVarL = buVar.l();
            if (bpVarL.b != 0) {
                short s = bpVarL.c;
                if (s != 1) {
                    if (s == 2) {
                        if (bpVarL.b == 8) {
                            iW = buVar.w();
                        } else {
                            bx.a(buVar, bpVarL.b);
                        }
                    } else {
                        bx.a(buVar, bpVarL.b);
                    }
                } else if (bpVarL.b == 11) {
                    strZ = buVar.z();
                } else {
                    bx.a(buVar, bpVarL.b);
                }
                buVar.m();
            } else {
                buVar.k();
                return new au(iW, strZ);
            }
        }
    }

    public void b(bu buVar) throws bb {
        buVar.a(j);
        if (getMessage() != null) {
            buVar.a(k);
            buVar.a(getMessage());
            buVar.c();
        }
        buVar.a(l);
        buVar.a(this.i);
        buVar.c();
        buVar.d();
        buVar.b();
    }
}
