package client.android.yixiaotong.util;

import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class BitUtils {
    public static boolean checkBitValue(byte b, int i) {
        return (((byte) (b >>> i)) & 1) == 1;
    }

    public static byte getBitValue(byte b, int i) {
        return (byte) ((b >> i) & 1);
    }

    public static byte reverseBitValue(byte b, int i) {
        return (byte) (b ^ ((byte) (1 << i)));
    }

    public static byte setBitValue(byte b, int i, byte b2) {
        byte b3 = (byte) (1 << i);
        return (byte) (b2 > 0 ? b | b3 : b & (~b3));
    }

    public static void main(String[] strArr) {
        for (byte b = 7; b >= 0; b = (byte) (b - 1)) {
            System.out.printf("%d ", Byte.valueOf(getBitValue((byte) 11, b)));
        }
        System.out.println(IOUtils.LINE_SEPARATOR_UNIX + ((int) setBitValue((byte) 11, 6, (byte) 1)));
        System.out.println((int) reverseBitValue((byte) 11, 6));
        System.out.println(checkBitValue((byte) 11, 6));
        for (byte b2 = 0; b2 < 8; b2 = (byte) (b2 + 1)) {
            if (checkBitValue((byte) 11, b2)) {
                System.out.printf("%d ", Byte.valueOf(b2));
            }
        }
    }
}
