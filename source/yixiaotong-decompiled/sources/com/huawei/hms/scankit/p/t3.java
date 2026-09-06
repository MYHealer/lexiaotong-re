package com.huawei.hms.scankit.p;

import com.huawei.hms.hmsscankit.WriterException;
import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.util.Map;

/* JADX INFO: compiled from: ITFWriter.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class t3 extends p4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f4345a = {1, 1, 1, 1};
    private static final int[] b = {3, 1, 1};

    @Override // com.huawei.hms.scankit.p.p4, com.huawei.hms.scankit.p.g7
    public s a(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<k2, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.ITF) {
            return super.a(str, barcodeFormat, i, i2, map);
        }
        throw new IllegalArgumentException("Can only encode ITF, but got " + barcodeFormat);
    }

    @Override // com.huawei.hms.scankit.p.p4
    public boolean[] a(String str) {
        int length = str.length();
        if (length % 2 != 0) {
            throw new IllegalArgumentException("The length of the input should be even");
        }
        if (length <= 80) {
            boolean[] zArr = new boolean[(length * 9) + 9];
            int iA = p4.a(zArr, 0, f4345a, true);
            for (int i = 0; i < length; i += 2) {
                int iDigit = Character.digit(str.charAt(i), 10);
                int iDigit2 = Character.digit(str.charAt(i + 1), 10);
                int[] iArr = new int[10];
                for (int i2 = 0; i2 < 5; i2++) {
                    int i3 = i2 * 2;
                    int[][] iArr2 = s3.f;
                    iArr[i3] = iArr2[iDigit][i2];
                    iArr[i3 + 1] = iArr2[iDigit2][i2];
                }
                iA += p4.a(zArr, iA, iArr, true);
            }
            p4.a(zArr, iA, b, true);
            return zArr;
        }
        throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got " + length);
    }
}
