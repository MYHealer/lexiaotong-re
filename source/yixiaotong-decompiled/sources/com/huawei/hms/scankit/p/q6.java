package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;

/* JADX INFO: compiled from: UPCEANExtension5Support.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
final class q6 {
    private static final int[] c = {24, 20, 18, 17, 12, 6, 3, 10, 9, 5};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int[] f4330a = new int[4];
    private final StringBuilder b = new StringBuilder();

    q6() {
    }

    w5 a(int i, r rVar, int[] iArr) throws a {
        StringBuilder sb = this.b;
        sb.setLength(0);
        float f = i;
        return new w5(sb.toString(), null, new y5[]{new y5((iArr[0] + iArr[1]) / 2.0f, f), new y5(a(rVar, iArr, sb), f)}, BarcodeFormat.UPC_EAN_EXTENSION);
    }

    private int a(r rVar, int[] iArr, StringBuilder sb) throws a {
        int[] iArr2 = this.f4330a;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int iE = rVar.e();
        int iD = iArr[1];
        int i = 0;
        for (int i2 = 0; i2 < 5 && iD < iE; i2++) {
            int iA = s6.a(rVar, iArr2, iD, s6.g);
            sb.append((char) ((iA % 10) + 48));
            for (int i3 : iArr2) {
                iD += i3;
            }
            if (iA >= 10) {
                i |= 1 << (4 - i2);
            }
            if (i2 != 4) {
                iD = rVar.d(rVar.c(iD));
            }
        }
        if (sb.length() == 5) {
            if (a(sb.toString()) == a(i)) {
                return iD;
            }
            throw a.a();
        }
        throw a.a();
    }

    private static int a(CharSequence charSequence) {
        int length = charSequence.length();
        int iCharAt = 0;
        for (int i = length - 2; i >= 0; i -= 2) {
            iCharAt += charSequence.charAt(i) - '0';
        }
        int iCharAt2 = iCharAt * 3;
        for (int i2 = length - 1; i2 >= 0; i2 -= 2) {
            iCharAt2 += charSequence.charAt(i2) - '0';
        }
        return (iCharAt2 * 3) % 10;
    }

    private static int a(int i) throws a {
        for (int i2 = 0; i2 < 10; i2++) {
            if (i == c[i2]) {
                return i2;
            }
        }
        throw a.a();
    }
}
