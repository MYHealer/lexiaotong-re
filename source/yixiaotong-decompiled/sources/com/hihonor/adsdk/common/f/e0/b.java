package com.hihonor.adsdk.common.f.e0;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class b {
    protected final byte[] hnadsa = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
    protected final byte[] hnadsb = new byte[128];

    public b() {
        hnadsa();
    }

    private static boolean hnadsa(char c) {
        return c == '\n' || c == '\r' || c == '\t' || c == ' ';
    }

    public int hnadsa(int i) {
        return i * 2;
    }

    protected void hnadsa() {
        int i = 0;
        int i2 = 0;
        while (true) {
            byte[] bArr = this.hnadsb;
            if (i2 >= bArr.length) {
                break;
            }
            bArr[i2] = -1;
            i2++;
        }
        while (true) {
            byte[] bArr2 = this.hnadsa;
            if (i >= bArr2.length) {
                byte[] bArr3 = this.hnadsb;
                bArr3[65] = bArr3[97];
                bArr3[66] = bArr3[98];
                bArr3[67] = bArr3[99];
                bArr3[68] = bArr3[100];
                bArr3[69] = bArr3[101];
                bArr3[70] = bArr3[102];
                return;
            }
            this.hnadsb[bArr2[i]] = (byte) i;
            i++;
        }
    }

    public int hnadsb(int i) {
        return i / 2;
    }

    public int hnadsb(byte[] bArr, int i, int i2, OutputStream outputStream) throws IOException {
        byte[] bArr2 = new byte[72];
        while (i2 > 0) {
            int iMin = Math.min(36, i2);
            outputStream.write(bArr2, 0, hnadsa(bArr, i, iMin, bArr2, 0));
            i += iMin;
            i2 -= iMin;
        }
        return i2 * 2;
    }

    public int hnadsa(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws IOException {
        int i4 = i2 + i;
        int i5 = i3;
        while (i < i4) {
            int i6 = i + 1;
            byte b = bArr[i];
            int i7 = i5 + 1;
            byte[] bArr3 = this.hnadsa;
            bArr2[i5] = bArr3[(b & 255) >>> 4];
            i5 += 2;
            bArr2[i7] = bArr3[b & 15];
            i = i6;
        }
        return i5 - i3;
    }

    public int hnadsa(byte[] bArr, int i, int i2, OutputStream outputStream) throws IOException {
        byte[] bArr2 = new byte[36];
        int i3 = i2 + i;
        while (i3 > i && hnadsa((char) bArr[i3 - 1])) {
            i3--;
        }
        int i4 = 0;
        int i5 = 0;
        while (i < i3) {
            while (i < i3 && hnadsa((char) bArr[i])) {
                i++;
            }
            int i6 = i + 1;
            byte b = this.hnadsb[bArr[i]];
            while (i6 < i3 && hnadsa((char) bArr[i6])) {
                i6++;
            }
            int i7 = i6 + 1;
            byte b2 = this.hnadsb[bArr[i6]];
            if ((b | b2) >= 0) {
                int i8 = i4 + 1;
                bArr2[i4] = (byte) ((b << 4) | b2);
                if (i8 == 36) {
                    outputStream.write(bArr2);
                    i4 = 0;
                } else {
                    i4 = i8;
                }
                i5++;
                i = i7;
            } else {
                throw new IOException("invalid characters encountered in Hex data");
            }
        }
        if (i4 > 0) {
            outputStream.write(bArr2, 0, i4);
        }
        return i5;
    }

    public int hnadsa(String str, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[36];
        int length = str.length();
        while (length > 0 && hnadsa(str.charAt(length - 1))) {
            length--;
        }
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < length) {
            while (i < length && hnadsa(str.charAt(i))) {
                i++;
            }
            int i4 = i + 1;
            byte b = this.hnadsb[str.charAt(i)];
            while (i4 < length && hnadsa(str.charAt(i4))) {
                i4++;
            }
            int i5 = i4 + 1;
            byte b2 = this.hnadsb[str.charAt(i4)];
            if ((b | b2) >= 0) {
                int i6 = i2 + 1;
                bArr[i2] = (byte) ((b << 4) | b2);
                if (i6 == 36) {
                    outputStream.write(bArr);
                    i2 = 0;
                } else {
                    i2 = i6;
                }
                i3++;
                i = i5;
            } else {
                throw new IOException("invalid characters encountered in Hex string");
            }
        }
        if (i2 > 0) {
            outputStream.write(bArr, 0, i2);
        }
        return i3;
    }

    byte[] hnadsa(String str, int i, int i2) throws IOException {
        if (str != null) {
            if (i < 0 || i2 < 0 || i > str.length() - i2) {
                throw new IndexOutOfBoundsException("invalid offset and/or length specified");
            }
            if ((i2 & 1) == 0) {
                int i3 = i2 >>> 1;
                byte[] bArr = new byte[i3];
                for (int i4 = 0; i4 < i3; i4++) {
                    int i5 = i + 1;
                    byte b = this.hnadsb[str.charAt(i)];
                    i += 2;
                    int i6 = (b << 4) | this.hnadsb[str.charAt(i5)];
                    if (i6 >= 0) {
                        bArr[i4] = (byte) i6;
                    } else {
                        throw new IOException("invalid characters encountered in Hex string");
                    }
                }
                return bArr;
            }
            throw new IOException("a hexadecimal encoding must have an even number of characters");
        }
        throw new NullPointerException("'str' cannot be null");
    }
}
