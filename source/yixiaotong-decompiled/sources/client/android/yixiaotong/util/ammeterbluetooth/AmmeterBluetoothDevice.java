package client.android.yixiaotong.util.ammeterbluetooth;

import java.io.Serializable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class AmmeterBluetoothDevice implements Serializable {
    public String mAddress;
    public String mName;
    public int mRssi;

    public String toString() {
        String str = this.mAddress;
        return str == null ? "" : str;
    }

    public AmmeterBluetoothDevice(String str, String str2, int i) {
        this.mName = str;
        this.mAddress = str2;
        this.mRssi = i;
    }

    public boolean equals(Object obj) {
        return toString().equals(obj.toString());
    }

    public static class HexString {
        private static final char[] kHexChars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

        private HexString() {
        }

        public static String stringToHex(String str) {
            return bufferToHex(str.getBytes());
        }

        public static String bufferToHex(byte[] bArr) {
            return bufferToHex(bArr, 0, bArr.length);
        }

        public static String bufferToHex(byte[] bArr, int i, int i2) {
            StringBuffer stringBuffer = new StringBuffer(i2 * 2);
            int i3 = i2 + i;
            while (i < i3) {
                appendHexPair(bArr[i], stringBuffer);
                i++;
            }
            return stringBuffer.toString();
        }

        public static String hexToString(String str) throws NumberFormatException {
            return new String(hexToBuffer(str));
        }

        public static byte[] hexToBuffer(String str) throws NumberFormatException {
            int i;
            int length = str.length();
            byte[] bArr = new byte[(length + 1) / 2];
            boolean z = length % 2 != 1;
            byte b = 0;
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                char cCharAt = str.charAt(i3);
                if (cCharAt >= '0' && cCharAt <= '9') {
                    i = cCharAt - '0';
                } else if (cCharAt >= 'A' && cCharAt <= 'F') {
                    i = cCharAt - '7';
                } else {
                    if (cCharAt < 'a' || cCharAt > 'f') {
                        throw new NumberFormatException("Invalid hex digit '" + cCharAt + "'.");
                    }
                    i = cCharAt - 'W';
                }
                if (z) {
                    b = (byte) (i << 4);
                } else {
                    b = (byte) (b + ((byte) i));
                    bArr[i2] = b;
                    i2++;
                }
                z = !z;
            }
            return bArr;
        }

        private static void appendHexPair(byte b, StringBuffer stringBuffer) {
            char[] cArr = kHexChars;
            char c = cArr[(b & 240) >> 4];
            char c2 = cArr[b & 15];
            stringBuffer.append(c);
            stringBuffer.append(c2);
        }
    }
}
