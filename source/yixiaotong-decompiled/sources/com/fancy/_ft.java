package com.fancy;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _ft {
    public static long _a(int i, byte[] bArr) {
        return (((long) bArr[i + 7]) << 56) + (((long) (bArr[i + 6] & 255)) << 48) + (((long) (bArr[i + 5] & 255)) << 40) + (((long) (bArr[i + 4] & 255)) << 32) + (((long) (bArr[i + 3] & 255)) << 24) + ((long) ((bArr[i + 2] & 255) << 16)) + ((long) ((bArr[i + 1] & 255) << 8)) + ((long) (bArr[i] & 255));
    }

    public static long[] _a(byte[] bArr) {
        byte[] bArr2 = bArr;
        int length = bArr2.length;
        int i = length & 15;
        int i2 = length - i;
        long jRotateLeft = 3782874213L;
        long jRotateLeft2 = 3782874213L;
        int i3 = 0;
        while (i3 < i2) {
            long j_a = _a(i3, bArr2);
            long j_a2 = _a(i3 + 8, bArr2);
            long jRotateLeft3 = ((Long.rotateLeft((Long.rotateLeft(j_a * (-8663945395140668459L), 31) * 5545529020109919103L) ^ jRotateLeft2, 27) + jRotateLeft) * 5) + 1390208809;
            jRotateLeft = ((Long.rotateLeft(jRotateLeft ^ (Long.rotateLeft(5545529020109919103L * j_a2, 33) * (-8663945395140668459L)), 31) + jRotateLeft3) * 5) + 944331445;
            i3 += 16;
            jRotateLeft2 = jRotateLeft3;
            length = length;
            bArr2 = bArr;
        }
        int i4 = length;
        long j = 0;
        switch (i) {
            case 15:
                j = ((long) bArr[i3 + 14]) << 48;
            case 14:
                j ^= ((long) bArr[i3 + 13]) << 40;
            case 13:
                j ^= ((long) bArr[i3 + 12]) << 32;
            case 12:
                j ^= ((long) bArr[i3 + 11]) << 24;
            case 11:
                j ^= (long) (bArr[i3 + 10] << 16);
            case 10:
                j ^= (long) (bArr[i3 + 9] << 8);
            case 9:
                jRotateLeft ^= Long.rotateLeft((j ^ ((long) bArr[i3 + 8])) * 5545529020109919103L, 33) * (-8663945395140668459L);
            case 8:
                j = ((long) bArr[i3 + 7]) << 56;
            case 7:
                j ^= ((long) bArr[i3 + 6]) << 48;
            case 6:
                j ^= ((long) bArr[i3 + 5]) << 40;
            case 5:
                j ^= ((long) bArr[i3 + 4]) << 32;
            case 4:
                j ^= ((long) bArr[i3 + 3]) << 24;
            case 3:
                j ^= (long) (bArr[i3 + 2] << 16);
            case 2:
                j ^= (long) (bArr[i3 + 1] << 8);
            case 1:
                jRotateLeft2 ^= Long.rotateLeft((j ^ ((long) bArr[i3])) * (-8663945395140668459L), 31) * 5545529020109919103L;
                break;
        }
        long j2 = i4;
        long j3 = jRotateLeft2 ^ j2;
        long j4 = j2 ^ jRotateLeft;
        long j5 = j3 + j4;
        long j6 = j4 + j5;
        long j7 = (j5 ^ (j5 >>> 33)) * (-49064778989728563L);
        long j8 = (j7 ^ (j7 >>> 33)) * (-4265267296055464877L);
        long j9 = (j6 ^ (j6 >>> 33)) * (-49064778989728563L);
        long j10 = (j9 ^ (j9 >>> 33)) * (-4265267296055464877L);
        long j11 = j10 ^ (j10 >>> 33);
        long j12 = (j8 ^ (j8 >>> 33)) + j11;
        return new long[]{j12, j11 + j12};
    }
}
