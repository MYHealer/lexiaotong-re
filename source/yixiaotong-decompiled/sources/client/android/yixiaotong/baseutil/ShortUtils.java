package client.android.yixiaotong.baseutil;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class ShortUtils {
    private ShortUtils() {
    }

    public static byte[] shortToBytes(short s) {
        byte[] bArr = new byte[2];
        for (int i = 0; i < 2; i++) {
            bArr[i] = (byte) ((s >>> ((1 - i) * 8)) & 255);
        }
        return bArr;
    }
}
