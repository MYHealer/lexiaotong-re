package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.util.Map;

/* JADX INFO: compiled from: DataMatrixWriter.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class d1 implements g7 {
    @Override // com.huawei.hms.scankit.p.g7
    public s a(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<k2, ?> map) {
        b2 b2Var;
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        }
        if (barcodeFormat != BarcodeFormat.DATA_MATRIX) {
            throw new IllegalArgumentException("Can only encode DATA_MATRIX, but got " + barcodeFormat);
        }
        if (i < 0 || i2 < 0) {
            throw new IllegalArgumentException("Requested dimensions can't be negative: " + i + 'x' + i2);
        }
        h6 h6Var = h6.FORCE_SQUARE;
        b2 b2Var2 = null;
        int i3 = 4;
        if (map != null) {
            h6 h6Var2 = (h6) map.get(k2.DATA_MATRIX_SHAPE);
            if (h6Var2 != null) {
                h6Var = h6Var2;
            }
            b2 b2Var3 = (b2) map.get(k2.MIN_SIZE);
            if (b2Var3 == null) {
                b2Var3 = null;
            }
            b2 b2Var4 = (b2) map.get(k2.MAX_SIZE);
            b2Var2 = b2Var4 != null ? b2Var4 : null;
            k2 k2Var = k2.MARGIN;
            i3 = map.containsKey(k2Var) ? Integer.parseInt(map.get(k2Var).toString()) : 4;
            b2Var = b2Var2;
            b2Var2 = b2Var3;
        } else {
            b2Var = null;
        }
        String strA = m3.a(str, h6Var, b2Var2, b2Var);
        g6 g6VarA = g6.a(strA.length(), h6Var, b2Var2, b2Var, true);
        q1 q1Var = new q1(p2.a(strA, g6VarA), g6VarA.f(), g6VarA.e());
        q1Var.a();
        return a(q1Var, g6VarA, i, i2, i3);
    }

    private static s a(q1 q1Var, g6 g6Var, int i, int i2, int i3) {
        int iF = g6Var.f();
        int iE = g6Var.e();
        a0 a0Var = new a0(g6Var.h(), g6Var.g());
        int i4 = 0;
        for (int i5 = 0; i5 < iE; i5++) {
            if (i5 % g6Var.e == 0) {
                int i6 = 0;
                for (int i7 = 0; i7 < g6Var.h(); i7++) {
                    a0Var.a(i6, i4, i7 % 2 == 0);
                    i6++;
                }
                i4++;
            }
            int i8 = 0;
            for (int i9 = 0; i9 < iF; i9++) {
                if (i9 % g6Var.d == 0) {
                    a0Var.a(i8, i4, true);
                    i8++;
                }
                a0Var.a(i8, i4, q1Var.a(i9, i5));
                int i10 = i8 + 1;
                int i11 = g6Var.d;
                if (i9 % i11 == i11 - 1) {
                    a0Var.a(i10, i4, i5 % 2 == 0);
                    i8 += 2;
                } else {
                    i8 = i10;
                }
            }
            int i12 = i4 + 1;
            int i13 = g6Var.e;
            if (i5 % i13 == i13 - 1) {
                int i14 = 0;
                for (int i15 = 0; i15 < g6Var.h(); i15++) {
                    a0Var.a(i14, i12, true);
                    i14++;
                }
                i4 += 2;
            } else {
                i4 = i12;
            }
        }
        return a(a0Var, i, i2, i3);
    }

    private static s a(a0 a0Var, int i, int i2, int i3) {
        s sVar;
        int iC = a0Var.c();
        int iB = a0Var.b();
        int i4 = i3 * 2;
        int i5 = iC + i4;
        int i6 = i4 + iB;
        int iMax = Math.max(i, i5);
        int iMax2 = Math.max(i2, i6);
        int iMin = Math.min(iMax / i5, iMax2 / i6);
        int i7 = (iMax - (iC * iMin)) / 2;
        int i8 = (iMax2 - (iB * iMin)) / 2;
        if (i2 >= iB && i >= iC) {
            sVar = new s(i, i2);
        } else {
            sVar = new s(iC, iB);
            i7 = 0;
            i8 = 0;
        }
        sVar.a();
        int i9 = 0;
        while (i9 < iB) {
            int i10 = 0;
            int i11 = i7;
            while (i10 < iC) {
                if (a0Var.a(i10, i9) == 1) {
                    sVar.a(i11, i8, iMin, iMin);
                }
                i10++;
                i11 += iMin;
            }
            i9++;
            i8 += iMin;
        }
        return sVar;
    }
}
