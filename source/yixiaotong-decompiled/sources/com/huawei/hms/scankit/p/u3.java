package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.util.LoadOpencvJNIUtil;

/* JADX INFO: compiled from: ImageResize.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class u3 {
    public static int a(int i, int i2, int i3) {
        if (i >= i2) {
            return i2;
        }
        return i <= i3 ? i3 : i;
    }

    public static p a(p pVar) {
        int iE = pVar.e();
        int iC = pVar.c();
        byte[] bArrD = pVar.d();
        byte[] bArr = new byte[iE * iC];
        for (int i = 0; i < iC; i++) {
            for (int i2 = 0; i2 < iE; i2++) {
                bArr[(((i2 * iC) + iC) - i) - 1] = bArrD[(i * iE) + i2];
            }
        }
        return new p(new n3(new j5(bArr, iC, iE, 0, 0, iC, iE, false)));
    }

    public static p a(p pVar, float f) {
        if (f == 1.0f) {
            return pVar;
        }
        int iC = pVar.c();
        int iE = pVar.e();
        int i = (int) (iE / f);
        int i2 = (int) (iC / f);
        byte[] bArrD = pVar.d();
        int i3 = i * i2;
        byte[] bArr = new byte[i3];
        int i4 = 0;
        int i5 = 0;
        while (i5 < i3) {
            double dA = a(i5 % i, i - 1, i4) * f;
            double dA2 = a(i5 / i, i2 - 1, i4) * f;
            double dFloor = Math.floor(dA);
            int i6 = i5;
            double dFloor2 = Math.floor(dA2);
            double d = dA - dFloor;
            double d2 = dA2 - dFloor2;
            int i7 = iE - 1;
            int i8 = i3;
            int iA = a((int) dFloor, i7, 0);
            int i9 = iC - 1;
            int iA2 = a((int) dFloor2, i9, 0);
            int i10 = iA2 * iE;
            int i11 = iC;
            int i12 = i;
            double d3 = 1.0d - d;
            double d4 = 1.0d - d2;
            int i13 = iA + 1;
            byte[] bArr2 = bArr;
            int i14 = iA2 + 1;
            bArr2[i6] = (byte) (((int) ((((double) (bArrD[i10 + iA] & 255)) * d3 * d4) + (((double) (bArrD[i10 + a(i13, i7, 0)] & 255)) * d * d4) + (((double) (bArrD[(a(i14, i9, 0) * iE) + iA] & 255)) * d3 * d2) + (((double) (bArrD[(a(i14, i9, 0) * iE) + a(i13, i7, 0)] & 255)) * d * d2))) & 255);
            i5 = i6 + 1;
            i4 = 0;
            i3 = i8;
            i = i12;
            iC = i11;
            i2 = i2;
            bArr = bArr2;
        }
        return new p(new n3(new j5(bArr, i, i2, 0, 0, i, i2, false)));
    }

    public static p a(boolean z, p pVar, float f) {
        if (f == 1.0f) {
            return pVar;
        }
        int iC = pVar.c();
        int iE = pVar.e();
        int i = (int) (iE / f);
        int i2 = (int) (iC / f);
        return new p(new n3(new j5(LoadOpencvJNIUtil.imageResize(pVar.d(), iC, iE, i2, i), i, i2, 0, 0, i, i2, false)));
    }
}
