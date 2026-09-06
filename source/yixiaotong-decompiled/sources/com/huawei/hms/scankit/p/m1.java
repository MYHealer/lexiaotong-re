package com.huawei.hms.scankit.p;

import java.util.Map;

/* JADX INFO: compiled from: Decoder.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class m1 {
    private b7 b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final t5 f4307a = new t5(y2.m);

    public b7 a() {
        return this.b;
    }

    public o1 a(s sVar, Map<f1, ?> map) throws a {
        u uVar = new u(sVar);
        b7 b7VarA = uVar.a();
        this.b = b7VarA;
        z0[] z0VarArrA = z0.a(uVar.b(), b7VarA);
        int iB = 0;
        for (z0 z0Var : z0VarArrA) {
            iB += z0Var.b();
        }
        byte[] bArr = new byte[iB];
        int length = z0VarArrA.length;
        for (int i = 0; i < length; i++) {
            z0 z0Var2 = z0VarArrA[i];
            byte[] bArrA = z0Var2.a();
            int iB2 = z0Var2.b();
            a(bArrA, iB2);
            for (int i2 = 0; i2 < iB2; i2++) {
                bArr[(i2 * length) + i] = bArrA[i2];
            }
        }
        return i1.a(bArr, map);
    }

    private void a(byte[] bArr, int i) throws a {
        int length = bArr.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = bArr[i2] & 255;
        }
        try {
            this.f4307a.a(iArr, bArr.length - i);
            for (int i3 = 0; i3 < i; i3++) {
                bArr[i3] = (byte) iArr[i3];
            }
        } catch (a unused) {
            throw a.a();
        }
    }
}
