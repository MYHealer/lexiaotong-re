package com.huawei.hms.scankit.p;

import java.util.Map;

/* JADX INFO: compiled from: Decoder.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class n1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final t5 f4312a = new t5(y2.l);

    public o1 a(s sVar, Map<f1, ?> map) throws a {
        t tVar = new t(sVar);
        try {
            return a(tVar, map);
        } catch (a e) {
            try {
                tVar.e();
                tVar.a(true);
                tVar.d();
                tVar.c();
                tVar.a();
                o1 o1VarA = a(tVar, map);
                o1VarA.a(new n5(true));
                return o1VarA;
            } catch (a unused) {
                throw e;
            }
        }
    }

    private o1 a(t tVar, Map<f1, ?> map) throws a {
        c7 c7VarD = tVar.d();
        r2 r2VarB = tVar.c().b();
        y0[] y0VarArrA = y0.a(tVar.b(), c7VarD, r2VarB);
        int iB = 0;
        for (y0 y0Var : y0VarArrA) {
            iB += y0Var.b();
        }
        byte[] bArr = new byte[iB];
        int i = 0;
        for (y0 y0Var2 : y0VarArrA) {
            byte[] bArrA = y0Var2.a();
            int iB2 = y0Var2.b();
            a(bArrA, iB2);
            int i2 = 0;
            while (i2 < iB2) {
                bArr[i] = bArrA[i2];
                i2++;
                i++;
            }
        }
        return k1.a(bArr, c7VarD, r2VarB, map);
    }

    private void a(byte[] bArr, int i) throws a {
        int length = bArr.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = bArr[i2] & 255;
        }
        try {
            this.f4312a.a(iArr, bArr.length - i);
            for (int i3 = 0; i3 < i; i3++) {
                bArr[i3] = (byte) iArr[i3];
            }
        } catch (a unused) {
            throw a.a();
        }
    }
}
