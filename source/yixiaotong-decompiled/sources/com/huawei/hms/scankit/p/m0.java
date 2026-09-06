package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: CodaBarReader.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class m0 extends o4 {
    public static final char[] e = "0123456789-$:/.+ABCD".toCharArray();
    public static final int[] f = {3, 6, 9, 96, 18, 66, 33, 36, 48, 72, 12, 24, 69, 81, 84, 21, 26, 41, 11, 14};
    private static final char[] g = {'A', 'B', 'C', 'D'};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final StringBuilder f4306a = new StringBuilder(20);
    private int[] b = new int[80];
    private int c = 0;
    private int d;

    @Override // com.huawei.hms.scankit.p.o4
    public w5 a(int i, r rVar, Map<f1, ?> map) throws a {
        Arrays.fill(this.b, 0);
        a(rVar);
        int[] iArrA = a();
        int i2 = iArrA[0];
        int i3 = iArrA[1];
        for (int i4 = 0; i4 < this.f4306a.length(); i4++) {
            StringBuilder sb = this.f4306a;
            sb.setCharAt(i4, e[sb.charAt(i4)]);
        }
        char cCharAt = this.f4306a.charAt(0);
        char[] cArr = g;
        if (!a(cArr, cCharAt)) {
            throw a.a();
        }
        StringBuilder sb2 = this.f4306a;
        if (!a(cArr, sb2.charAt(sb2.length() - 1))) {
            throw a.a();
        }
        if (this.f4306a.length() <= 3) {
            throw a.a();
        }
        int i5 = this.d;
        for (int i6 = 0; i6 < i2; i6++) {
            i5 += this.b[i6];
        }
        float f2 = i5;
        while (i2 < i3 - 1) {
            i5 += this.b[i2];
            i2++;
        }
        float f3 = i;
        return new w5(this.f4306a.toString(), null, new y5[]{new y5(f2, f3), new y5(i5, f3)}, BarcodeFormat.CODABAR);
    }

    private int b() throws a {
        for (int i = 1; i < this.c; i += 2) {
            int iB = b(i);
            if (iB != -1 && a(g, e[iB])) {
                int i2 = 0;
                for (int i3 = i; i3 < i + 7; i3++) {
                    i2 += this.b[i3];
                }
                if (i == 1 || this.b[i - 1] >= i2 / 2) {
                    return i;
                }
            }
        }
        throw a.a();
    }

    private void c(int i) throws a {
        int[] iArr = {0, 0, 0, 0};
        int[] iArr2 = {0, 0, 0, 0};
        int length = this.f4306a.length() - 1;
        int i2 = i;
        int i3 = 0;
        while (true) {
            int i4 = f[this.f4306a.charAt(i3)];
            for (int i5 = 6; i5 >= 0; i5--) {
                int i6 = (i5 & 1) + ((i4 & 1) * 2);
                iArr[i6] = iArr[i6] + this.b[i2 + i5];
                iArr2[i6] = iArr2[i6] + 1;
                i4 >>= 1;
            }
            if (i3 >= length) {
                break;
            }
            i2 += 8;
            i3++;
        }
        float[] fArr = new float[4];
        float[] fArr2 = new float[4];
        for (int i7 = 0; i7 < 2; i7++) {
            fArr2[i7] = 0.0f;
            int i8 = i7 + 2;
            float f2 = iArr[i7] / iArr2[i7];
            int i9 = iArr[i8];
            int i10 = iArr2[i8];
            float f3 = (f2 + (i9 / i10)) / 2.0f;
            fArr2[i8] = f3;
            fArr[i7] = f3;
            fArr[i8] = ((i9 * 2.0f) + 1.5f) / i10;
        }
        int i11 = 0;
        int i12 = i;
        loop3: while (true) {
            int i13 = f[this.f4306a.charAt(i11)];
            for (int i14 = 6; i14 >= 0; i14--) {
                int i15 = (i14 & 1) + ((i13 & 1) * 2);
                float f4 = this.b[i12 + i14];
                if (f4 < fArr2[i15] || f4 > fArr[i15]) {
                    break loop3;
                }
                i13 >>= 1;
            }
            if (i11 >= length) {
                return;
            }
            i12 += 8;
            i11++;
        }
        throw a.a();
    }

    private int b(int i) {
        int i2 = i + 7;
        if (i2 >= this.c) {
            return -1;
        }
        int[] iArr = this.b;
        HashSet hashSet = new HashSet();
        for (int i3 = i; i3 < i2; i3++) {
            hashSet.add(Integer.valueOf(iArr[i3]));
        }
        Iterator it = hashSet.iterator();
        int i4 = 0;
        int iIntValue = 0;
        while (it.hasNext()) {
            iIntValue += ((Integer) it.next()).intValue();
        }
        if (hashSet.size() > 0) {
            int size = iIntValue / hashSet.size();
            int i5 = 128;
            int i6 = 0;
            for (int i7 = 0; i7 < 7; i7++) {
                i5 >>= 1;
                if (iArr[i + i7] > size) {
                    i6 |= i5;
                }
            }
            while (true) {
                int[] iArr2 = f;
                if (i4 >= iArr2.length) {
                    break;
                }
                if (iArr2[i4] == i6) {
                    return i4;
                }
                i4++;
            }
        }
        return -1;
    }

    private int[] a() throws a {
        int i;
        int iB = b();
        int i2 = 0;
        this.f4306a.setLength(0);
        int i3 = iB;
        while (true) {
            int iB2 = b(i3);
            if (iB2 != -1) {
                this.f4306a.append((char) iB2);
                i = i3 + 8;
                if ((this.f4306a.length() > 1 && a(g, e[iB2])) || i >= this.c) {
                    break;
                }
                i3 = i;
            } else {
                throw a.a();
            }
        }
        int i4 = this.b[i3 + 7];
        for (int i5 = -8; i5 < -1; i5++) {
            i2 += this.b[i + i5];
        }
        if (i < this.c && i4 < i2 / 2) {
            throw a.a();
        }
        c(iB);
        return new int[]{iB, i};
    }

    private void a(r rVar) throws a {
        int i = 0;
        this.c = 0;
        int iD = rVar.d(0);
        this.d = iD;
        int iE = rVar.e();
        if (iD < iE) {
            boolean z = true;
            while (iD < iE) {
                if (rVar.b(iD) != z) {
                    i++;
                } else {
                    a(i);
                    z = !z;
                    i = 1;
                }
                iD++;
            }
            a(i);
            return;
        }
        throw a.a();
    }

    private void a(int i) throws a {
        try {
            int[] iArr = this.b;
            int i2 = this.c;
            iArr[i2] = i;
            int i3 = i2 + 1;
            this.c = i3;
            if (i3 >= iArr.length) {
                int[] iArr2 = new int[i3 * 2];
                System.arraycopy(iArr, 0, iArr2, 0, i3);
                this.b = iArr2;
            }
        } catch (NumberFormatException unused) {
            throw a.a();
        }
    }

    public static boolean a(char[] cArr, char c) {
        if (cArr != null) {
            for (char c2 : cArr) {
                if (c2 == c) {
                    return true;
                }
            }
        }
        return false;
    }
}
