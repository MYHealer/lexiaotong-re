package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: compiled from: ITFReader.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class s3 extends o4 {
    private static final int[] c = {6, 8, 10, 12, 14};
    private static final int[] d = {1, 1, 1, 1};
    private static final int[][] e = {new int[]{1, 1, 2}, new int[]{1, 1, 3}};
    public static final int[][] f = {new int[]{1, 1, 2, 2, 1}, new int[]{2, 1, 1, 1, 2}, new int[]{1, 2, 1, 1, 2}, new int[]{2, 2, 1, 1, 1}, new int[]{1, 1, 2, 1, 2}, new int[]{2, 1, 2, 1, 1}, new int[]{1, 2, 2, 1, 1}, new int[]{1, 1, 1, 2, 2}, new int[]{2, 1, 1, 2, 1}, new int[]{1, 2, 1, 2, 1}, new int[]{1, 1, 3, 3, 1}, new int[]{3, 1, 1, 1, 3}, new int[]{1, 3, 1, 1, 3}, new int[]{3, 3, 1, 1, 1}, new int[]{1, 1, 3, 1, 3}, new int[]{3, 1, 3, 1, 1}, new int[]{1, 3, 3, 1, 1}, new int[]{1, 1, 1, 3, 3}, new int[]{3, 1, 1, 3, 1}, new int[]{1, 3, 1, 3, 1}};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f4341a = -1;
    private int b = -1;

    private int[] b(r rVar) throws a {
        int iC = c(rVar);
        while (true) {
            int[] iArrC = c(rVar, iC, d);
            int i = iArrC[1];
            int i2 = iArrC[0];
            this.f4341a = (i - i2) / 4;
            if (a(rVar, i2)) {
                return iArrC;
            }
            iC = iArrC[2];
        }
    }

    private static int c(r rVar) throws a {
        int iE = rVar.e();
        int iC = rVar.c(0);
        if (iC != iE) {
            return iC;
        }
        throw a.a();
    }

    @Override // com.huawei.hms.scankit.p.o4
    public w5 a(int i, r rVar, Map<f1, ?> map) throws a {
        boolean z;
        int[] iArrB = b(rVar);
        int[] iArrA = a(rVar);
        StringBuilder sb = new StringBuilder(20);
        a(rVar, iArrB[1], iArrA[0], sb);
        String string = sb.toString();
        int[] iArr = c;
        int length = string.length();
        int length2 = iArr.length;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i2 >= length2) {
                z = false;
                break;
            }
            int i4 = iArr[i2];
            if (length == i4) {
                z = true;
                break;
            }
            if (i4 > i3) {
                i3 = i4;
            }
            i2++;
        }
        if ((z || length <= i3) && !z) {
            throw a.a();
        }
        float f2 = i;
        return new w5(string, null, new y5[]{new y5(iArrB[0], f2), new y5(iArrA[1], f2)}, BarcodeFormat.ITF);
    }

    private int[] c(r rVar, int i, int[] iArr) throws a {
        char c2;
        int i2;
        int length = iArr.length;
        int[] iArr2 = new int[length];
        int iE = rVar.e();
        char c3 = 0;
        int i3 = i;
        int i4 = i3;
        boolean z = false;
        int i5 = 0;
        while (i3 < iE) {
            if (rVar.b(i3) == z) {
                if (i5 == length - 1) {
                    int[] iArr3 = (int[]) iArr2.clone();
                    Arrays.sort(iArr3);
                    int i6 = iArr3[c3];
                    double d2 = ((double) (iArr3[1] + i6)) * 0.5d;
                    int i7 = iArr3[2];
                    int i8 = iArr3[3];
                    int i9 = i3;
                    if ((((double) (i7 + i8)) * 0.5d) / d2 < 4.0d && (((double) i8) * 1.0d) / ((double) i6) <= 3.0d) {
                        int[] iArr4 = new int[10];
                        o4.a(rVar, i9, iArr4);
                        this.b = -1;
                        for (int i10 = 0; i10 < 10; i10++) {
                            int i11 = iArr4[i10];
                            if (i11 > this.b) {
                                this.b = i11;
                            }
                        }
                        return new int[]{i4, i9, iArr2[0] + i4 + iArr2[1]};
                    }
                    i2 = i9;
                    c2 = 0;
                    i4 += iArr2[0] + iArr2[1];
                    int i12 = i5 - 1;
                    System.arraycopy(iArr2, 2, iArr2, 0, i12);
                    iArr2[i12] = 0;
                    iArr2[i5] = 0;
                    i5--;
                } else {
                    int i13 = i3;
                    c2 = c3;
                    i2 = i13;
                    i5++;
                }
                iArr2[i5] = 1;
                z = !z;
            } else if (i5 >= 0 && i5 < length) {
                iArr2[i5] = iArr2[i5] + 1;
                int i14 = i3;
                c2 = c3;
                i2 = i14;
            } else {
                throw a.a();
            }
            char c4 = c2;
            i3 = i2 + 1;
            c3 = c4;
        }
        throw a.a();
    }

    private int[] b(r rVar, int i, int[] iArr) throws a {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        int iE = rVar.e();
        int i2 = i;
        int i3 = i2;
        boolean z = false;
        int i4 = 0;
        while (i2 < iE) {
            if (rVar.b(i2) == z) {
                if (i4 != length - 1) {
                    i4++;
                } else if (Math.min(iArr2[0], iArr2[1]) != 0 && Math.max(iArr2[0], iArr2[1]) != 0) {
                    float fMax = Math.max(iArr2[0], iArr2[1]) / Math.min(iArr2[0], iArr2[1]);
                    float f2 = iArr2[2] * 2.0f;
                    int i5 = iArr2[0];
                    int i6 = iArr2[1];
                    float f3 = f2 / (i5 + i6);
                    if (fMax <= 3.0f && f3 > 1.5d && f3 < 4.0f) {
                        return new int[]{i3, i2, i5 + i3 + i6};
                    }
                    i3 += i5 + i6;
                    int i7 = i4 - 1;
                    System.arraycopy(iArr2, 2, iArr2, 0, i7);
                    iArr2[i7] = 0;
                    iArr2[i4] = 0;
                    i4--;
                } else {
                    throw a.a();
                }
                iArr2[i4] = 1;
                z = !z;
            } else if (i4 >= 0 && i4 < length) {
                iArr2[i4] = iArr2[i4] + 1;
            } else {
                throw a.a();
            }
            i2++;
        }
        throw a.a();
    }

    private static void a(r rVar, int i, int i2, StringBuilder sb) throws a {
        int[] iArr = new int[10];
        int[] iArr2 = new int[5];
        int[] iArr3 = new int[5];
        while (i < i2) {
            o4.a(rVar, i, iArr);
            int i3 = -1;
            int i4 = 10000;
            for (int i5 = 0; i5 < 10; i5++) {
                int i6 = iArr[i5];
                if (i3 <= i6) {
                    i3 = i6;
                }
                if (i4 >= i6) {
                    i4 = i6;
                }
            }
            if (i3 / i4 <= 8) {
                for (int i7 = 0; i7 < 5; i7++) {
                    int i8 = i7 * 2;
                    iArr2[i7] = iArr[i8];
                    iArr3[i7] = iArr[i8 + 1];
                }
                sb.append((char) (b(iArr2) + 48));
                sb.append((char) (b(iArr3) + 48));
                for (int i9 = 0; i9 < 10; i9++) {
                    i += iArr[i9];
                }
            } else {
                throw a.a();
            }
        }
        if (i != i2) {
            throw a.a();
        }
    }

    private static int b(int[] iArr) throws a {
        int length = f.length;
        float f2 = 0.3f;
        int i = -1;
        for (int i2 = 0; i2 < length; i2++) {
            float fA = o4.a(iArr, f[i2], 0.75f);
            if (fA < f2) {
                i = i2;
                f2 = fA;
            } else if (Math.abs(fA - f2) < 1.0E-7d) {
                i = -1;
            }
        }
        if (i >= 0) {
            return i % 10;
        }
        throw a.a();
    }

    private boolean a(r rVar, int i) {
        int i2 = this.f4341a * 10;
        int i3 = (int) (((double) this.b) * 1.5d);
        if (i2 < i3) {
            i2 = i3;
        }
        for (int i4 = i - 1; i2 > 0 && i4 >= 0 && !rVar.b(i4); i4--) {
            i2--;
        }
        return i2 == 0;
    }

    private int[] a(r rVar) throws a {
        try {
            rVar.h();
            int iC = c(rVar);
            while (true) {
                int[] iArrB = b(rVar, iC, e[0]);
                if (a(rVar, iArrB[0])) {
                    int i = iArrB[0];
                    iArrB[0] = rVar.e() - iArrB[1];
                    iArrB[1] = rVar.e() - i;
                    return iArrB;
                }
                iC = iArrB[2];
            }
        } finally {
            rVar.h();
        }
    }
}
