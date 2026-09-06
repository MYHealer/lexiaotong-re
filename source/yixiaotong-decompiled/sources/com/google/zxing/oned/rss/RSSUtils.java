package com.google.zxing.oned.rss;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public final class RSSUtils {
    private RSSUtils() {
    }

    public static int getRSSvalue(int[] iArr, int i, boolean z) {
        int i2;
        int length = iArr.length;
        int length2 = iArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length2) {
            i4 += iArr[i3];
            i3++;
            length = length;
        }
        int i5 = i4;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (true) {
            int i9 = length - 1;
            if (i8 >= i9) {
                return i7;
            }
            int i10 = 1 << i8;
            i6 |= i10;
            int i11 = 1;
            while (i11 < iArr[i8]) {
                int i12 = i5 - i11;
                int i13 = length - i8;
                int i14 = i13 - 2;
                int iCombins = combins(i12 - 1, i14);
                if (z && i6 == 0) {
                    int i15 = i13 - 1;
                    if (i12 - i15 >= i15) {
                        iCombins -= combins(i12 - i13, i14);
                    }
                }
                if (i13 - 1 > 1) {
                    int i16 = i12 - i14;
                    int iCombins2 = 0;
                    while (i16 > i) {
                        iCombins2 += combins((i12 - i16) - 1, i13 - 3);
                        i16--;
                        length = length;
                    }
                    iCombins -= iCombins2 * (i9 - i8);
                    i2 = length;
                } else {
                    i2 = length;
                    if (i12 > i) {
                        iCombins--;
                    }
                }
                i7 += iCombins;
                i11++;
                i6 &= ~i10;
                length = i2;
            }
            i5 -= i11;
            i8++;
        }
    }

    private static int combins(int i, int i2) {
        int i3 = i - i2;
        if (i3 > i2) {
            i3 = i2;
            i2 = i3;
        }
        int i4 = 1;
        int i5 = 1;
        while (i > i2) {
            i4 *= i;
            if (i5 <= i3) {
                i4 /= i5;
                i5++;
            }
            i--;
        }
        while (i5 <= i3) {
            i4 /= i5;
            i5++;
        }
        return i4;
    }
}
