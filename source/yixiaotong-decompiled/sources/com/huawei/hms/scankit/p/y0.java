package com.huawei.hms.scankit.p;

/* JADX INFO: compiled from: DataBlock.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
final class y0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f4376a;
    private final byte[] b;

    private y0(int i, byte[] bArr) {
        this.f4376a = i;
        this.b = bArr;
    }

    static y0[] a(byte[] bArr, c7 c7Var, r2 r2Var) {
        if (bArr.length != c7Var.e()) {
            throw new IllegalArgumentException();
        }
        c7.b bVarA = c7Var.a(r2Var);
        c7.a[] aVarArrA = bVarA.a();
        int iA = 0;
        for (c7.a aVar : aVarArrA) {
            iA += aVar.a();
        }
        y0[] y0VarArr = new y0[iA];
        int i = 0;
        for (c7.a aVar2 : aVarArrA) {
            int i2 = 0;
            while (i2 < aVar2.a()) {
                int iB = aVar2.b();
                y0VarArr[i] = new y0(iB, new byte[bVarA.b() + iB]);
                i2++;
                i++;
            }
        }
        int length = y0VarArr[0].b.length;
        int i3 = iA - 1;
        while (i3 >= 0 && y0VarArr[i3].b.length != length) {
            i3--;
        }
        return a(y0VarArr, bArr, length, bVarA, i, i3 + 1);
    }

    byte[] a() {
        return this.b;
    }

    int b() {
        return this.f4376a;
    }

    private static y0[] a(y0[] y0VarArr, byte[] bArr, int i, c7.b bVar, int i2, int i3) {
        int iB = i - bVar.b();
        int i4 = 0;
        for (int i5 = 0; i5 < iB; i5++) {
            int i6 = 0;
            while (i6 < i2) {
                y0VarArr[i6].b[i5] = bArr[i4];
                i6++;
                i4++;
            }
        }
        int i7 = i3;
        while (i7 < i2) {
            y0VarArr[i7].b[iB] = bArr[i4];
            i7++;
            i4++;
        }
        int length = y0VarArr[0].b.length;
        while (iB < length) {
            int i8 = 0;
            while (i8 < i2) {
                int i9 = i8 < i3 ? iB : iB + 1;
                if (i8 >= 0 && i8 < y0VarArr.length && y6.a(y0VarArr[i8].b, i9) && y6.a(bArr, i4)) {
                    y0VarArr[i8].b[i9] = bArr[i4];
                    i8++;
                    i4++;
                } else {
                    throw new ArrayIndexOutOfBoundsException();
                }
            }
            iB++;
        }
        return y0VarArr;
    }
}
