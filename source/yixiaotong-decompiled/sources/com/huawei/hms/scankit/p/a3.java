package com.huawei.hms.scankit.p;

/* JADX INFO: compiled from: GlobalHistogramBinarizer.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class a3 extends o {
    private static final byte[] d = new byte[0];
    private byte[] b;
    private final int[] c;

    public a3(y3 y3Var) {
        super(y3Var);
        this.b = d;
        this.c = new int[32];
    }

    @Override // com.huawei.hms.scankit.p.o
    public r a(int i, r rVar) throws a {
        y3 y3VarC = c();
        int iC = y3VarC.c();
        if (rVar == null || rVar.e() < iC) {
            rVar = new r(iC);
        } else {
            rVar.a();
        }
        a(iC);
        byte[] bArrA = y3VarC.a(i, this.b);
        int[] iArr = this.c;
        for (int i2 = 0; i2 < iC; i2++) {
            int i3 = (bArrA[i2] & 255) >> 3;
            iArr[i3] = iArr[i3] + 1;
        }
        int iA = a(iArr, false);
        if (iC < 3) {
            for (int i4 = 0; i4 < iC; i4++) {
                if ((bArrA[i4] & 255) < iA) {
                    rVar.g(i4);
                }
            }
        } else {
            int i5 = 1;
            int i6 = bArrA[0] & 255;
            int i7 = bArrA[1] & 255;
            while (i5 < iC - 1) {
                int i8 = i5 + 1;
                int i9 = bArrA[i8] & 255;
                if ((((i7 * 4) - i6) - i9) / 2 < iA) {
                    rVar.g(i5);
                }
                i6 = i7;
                i5 = i8;
                i7 = i9;
            }
        }
        return rVar;
    }

    @Override // com.huawei.hms.scankit.p.o
    public s a() throws a {
        y3 y3VarC = c();
        int iC = y3VarC.c();
        int iA = y3VarC.a();
        a(iC);
        int[] iArr = this.c;
        for (int i = 1; i < 5; i++) {
            byte[] bArrA = y3VarC.a((iA * i) / 5, this.b);
            int i2 = (iC * 4) / 5;
            for (int i3 = iC / 5; i3 < i2; i3++) {
                int i4 = (bArrA[i3] & 255) >> 3;
                iArr[i4] = iArr[i4] + 1;
            }
        }
        int iA2 = a(iArr, true);
        byte[] bArrB = y3VarC.b();
        int i5 = (iC + 31) / 32;
        int[] iArr2 = new int[i5 * iA];
        for (int i6 = 0; i6 < iA; i6++) {
            int i7 = i6 * iC;
            for (int i8 = 0; i8 < iC; i8++) {
                if ((bArrB[i7 + i8] & 255) < iA2) {
                    int i9 = (i6 * i5) + (i8 >> 5);
                    iArr2[i9] = iArr2[i9] | (1 << (i8 & 31));
                }
            }
        }
        return new s(iC, iA, i5, iArr2);
    }

    @Override // com.huawei.hms.scankit.p.o
    public o a(y3 y3Var) {
        return new a3(y3Var);
    }

    private void a(int i) {
        if (this.b.length < i) {
            this.b = new byte[i];
        }
        for (int i2 = 0; i2 < 32; i2++) {
            this.c[i2] = 0;
        }
    }

    private static int a(int[] iArr, boolean z) throws a {
        int length = iArr.length;
        boolean z2 = false;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            int i5 = iArr[i4];
            if (i5 > i) {
                i3 = i4;
                i = i5;
            }
            if (i5 > i2) {
                i2 = i5;
            }
        }
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < length; i8++) {
            int i9 = i8 - i3;
            int i10 = iArr[i8] * i9 * i9;
            if (i10 > i7) {
                i6 = i8;
                i7 = i10;
            }
        }
        if (i3 <= i6) {
            int i11 = i3;
            i3 = i6;
            i6 = i11;
        }
        int i12 = i3 - i6;
        if (i12 <= length / 16) {
            throw a.a();
        }
        int i13 = i3 - 1;
        int i14 = -1;
        int i15 = i13;
        while (i13 > i6) {
            int i16 = i13 - i6;
            int i17 = i16 * i16 * (i3 - i13) * (i2 - iArr[i13]);
            if (i17 > i14) {
                i15 = i13;
                i14 = i17;
            }
            i13--;
        }
        if (z) {
            if (i15 < 10 && i14 < 100000 && i12 < 10) {
                z2 = true;
            }
            b3.p = z2;
        }
        return i15 << 3;
    }
}
