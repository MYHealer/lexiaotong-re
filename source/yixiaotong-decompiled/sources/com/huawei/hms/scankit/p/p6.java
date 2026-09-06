package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;

/* JADX INFO: compiled from: UPCEANExtension2Support.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
final class p6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int[] f4324a = new int[4];
    private final StringBuilder b = new StringBuilder();

    p6() {
    }

    w5 a(int i, r rVar, int[] iArr) throws a {
        StringBuilder sb = this.b;
        sb.setLength(0);
        float f = i;
        return new w5(sb.toString(), null, new y5[]{new y5((iArr[0] + iArr[1]) / 2.0f, f), new y5(a(rVar, iArr, sb), f)}, BarcodeFormat.UPC_EAN_EXTENSION);
    }

    private int a(r rVar, int[] iArr, StringBuilder sb) throws a {
        int[] iArr2 = this.f4324a;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int iE = rVar.e();
        int iD = iArr[1];
        int i = 0;
        for (int i2 = 0; i2 < 2 && iD < iE; i2++) {
            int iA = s6.a(rVar, iArr2, iD, s6.g);
            sb.append((char) ((iA % 10) + 48));
            for (int i3 : iArr2) {
                iD += i3;
            }
            if (iA >= 10) {
                i |= 1 << (1 - i2);
            }
            if (i2 != 1) {
                iD = rVar.d(rVar.c(iD));
            }
        }
        if (sb.length() == 2) {
            try {
                if (Integer.parseInt(sb.toString()) % 4 == i) {
                    return iD;
                }
                throw a.a();
            } catch (NumberFormatException unused) {
                throw a.a();
            }
        }
        throw a.a();
    }
}
