package com.huawei.hms.scankit.p;

/* JADX INFO: compiled from: DataBlock.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
final class z0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f4384a;
    private final byte[] b;

    private z0(int i, byte[] bArr) {
        this.f4384a = i;
        this.b = bArr;
    }

    static z0[] a(byte[] bArr, b7 b7Var) {
        b7.c cVarD = b7Var.d();
        b7.b[] bVarArrA = cVarD.a();
        int iA = 0;
        for (b7.b bVar : bVarArrA) {
            iA += bVar.a();
        }
        z0[] z0VarArr = new z0[iA];
        int i = 0;
        for (b7.b bVar2 : bVarArrA) {
            int i2 = 0;
            while (i2 < bVar2.a()) {
                int iB = bVar2.b();
                z0VarArr[i] = new z0(iB, new byte[cVarD.b() + iB]);
                i2++;
                i++;
            }
        }
        int length = z0VarArr[0].b.length - cVarD.b();
        int i3 = length - 1;
        int i4 = 0;
        for (int i5 = 0; i5 < i3; i5++) {
            int i6 = 0;
            while (i6 < i) {
                z0VarArr[i6].b[i5] = bArr[i4];
                i6++;
                i4++;
            }
        }
        boolean z = b7Var.h() == 24;
        int i7 = z ? 8 : i;
        int i8 = 0;
        while (i8 < i7) {
            z0VarArr[i8].b[i3] = bArr[i4];
            i8++;
            i4++;
        }
        int length2 = z0VarArr[0].b.length;
        while (length < length2) {
            int i9 = 0;
            while (i9 < i) {
                int i10 = z ? (i9 + 8) % i : i9;
                z0VarArr[i10].b[(!z || i10 <= 7) ? length : length - 1] = bArr[i4];
                i9++;
                i4++;
            }
            length++;
        }
        if (i4 == bArr.length) {
            return z0VarArr;
        }
        throw new IllegalArgumentException();
    }

    byte[] a() {
        return this.b;
    }

    int b() {
        return this.f4384a;
    }
}
