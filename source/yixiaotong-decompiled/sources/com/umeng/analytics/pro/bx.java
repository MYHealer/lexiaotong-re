package com.umeng.analytics.pro;

/* JADX INFO: compiled from: TProtocolUtil.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class bx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f9134a = Integer.MAX_VALUE;

    public static void a(int i) {
        f9134a = i;
    }

    public static void a(bu buVar, byte b) throws bb {
        a(buVar, b, f9134a);
    }

    public static void a(bu buVar, byte b, int i) throws bb {
        if (i <= 0) {
            throw new bb("Maximum skip depth exceeded");
        }
        int i2 = 0;
        switch (b) {
            case 2:
                buVar.t();
                return;
            case 3:
                buVar.u();
                return;
            case 4:
                buVar.y();
                return;
            case 5:
            case 7:
            case 9:
            default:
                return;
            case 6:
                buVar.v();
                return;
            case 8:
                buVar.w();
                return;
            case 10:
                buVar.x();
                return;
            case 11:
                buVar.A();
                return;
            case 12:
                buVar.j();
                while (true) {
                    bp bpVarL = buVar.l();
                    if (bpVarL.b != 0) {
                        a(buVar, bpVarL.b, i - 1);
                        buVar.m();
                    } else {
                        buVar.k();
                        return;
                    }
                }
                break;
            case 13:
                br brVarN = buVar.n();
                while (i2 < brVarN.c) {
                    int i3 = i - 1;
                    a(buVar, brVarN.f9130a, i3);
                    a(buVar, brVarN.b, i3);
                    i2++;
                }
                buVar.o();
                return;
            case 14:
                by byVarR = buVar.r();
                while (i2 < byVarR.b) {
                    a(buVar, byVarR.f9135a, i - 1);
                    i2++;
                }
                buVar.s();
                return;
            case 15:
                bq bqVarP = buVar.p();
                while (i2 < bqVarP.b) {
                    a(buVar, bqVarP.f9129a, i - 1);
                    i2++;
                }
                buVar.q();
                return;
        }
    }

    public static bw a(byte[] bArr, bw bwVar) {
        if (bArr[0] > 16) {
            return new bo.a();
        }
        return (bArr.length <= 1 || (bArr[1] & 128) == 0) ? bwVar : new bo.a();
    }
}
