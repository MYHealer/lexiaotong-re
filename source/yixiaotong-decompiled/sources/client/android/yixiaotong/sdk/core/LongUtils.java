package client.android.yixiaotong.sdk.core;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
class LongUtils {
    private LongUtils() {
    }

    static byte[] long2Bytes(long j) {
        byte[] bArr = new byte[8];
        int i = 0;
        while (i < 8) {
            int i2 = i + 1;
            bArr[i] = (byte) ((j >> (64 - (i2 * 8))) & 255);
            i = i2;
        }
        return bArr;
    }

    static long bytes2Long(byte[] bArr) {
        long j = 0;
        for (int i = 0; i < 8; i++) {
            j = (j << 8) | ((long) (bArr[i] & 255));
        }
        return j;
    }
}
