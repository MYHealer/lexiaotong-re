package client.android.yixiaotong.sdk.bluetooth.utils;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class ByteUtils {
    private static final String HEXES = "0123456789ABCDEF";

    public static int getIntFromByte(byte b) {
        return b & 255;
    }

    private ByteUtils() {
    }

    public static String byteArrayToHexString(byte[] bArr) {
        StringBuilder sb = new StringBuilder("[");
        int length = bArr.length;
        boolean z = true;
        int i = 0;
        while (i < length) {
            byte b = bArr[i];
            if (!z) {
                sb.append(", ");
            }
            sb.append(HEXES.charAt((b & 240) >> 4));
            sb.append(HEXES.charAt(b & 15));
            i++;
            z = false;
        }
        sb.append(']');
        return sb.toString();
    }

    public static boolean doesArrayBeginWith(byte[] bArr, byte[] bArr2) {
        if (bArr.length < bArr2.length) {
            return false;
        }
        for (int i = 0; i < bArr2.length; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static int getIntFrom2ByteArray(byte[] bArr) {
        return getIntFromByteArray(new byte[]{0, 0, bArr[0], bArr[1]});
    }

    public static int getIntFromByteArray(byte[] bArr) {
        return ByteBuffer.wrap(bArr).getInt();
    }

    public static long getLongFromByteArray(byte[] bArr) {
        return ByteBuffer.wrap(bArr).getLong();
    }

    public static void invertArray(byte[] bArr) {
        int length = bArr.length;
        for (int i = 0; i < length / 2; i++) {
            byte b = bArr[i];
            int i2 = (length - 1) - i;
            bArr[i] = bArr[i2];
            bArr[i2] = b;
        }
    }
}
