package com.alipay.sdk.encrypt;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import okio.Utf8;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f1638a = 128;
    private static final int b = 64;
    private static final int c = 24;
    private static final int d = 8;
    private static final int e = 16;
    private static final int f = 4;
    private static final int g = -128;
    private static final char h = '=';
    private static final byte[] i = new byte[128];
    private static final char[] j = new char[64];

    private static boolean a(char c2) {
        return c2 == ' ' || c2 == '\r' || c2 == '\n' || c2 == '\t';
    }

    private static boolean b(char c2) {
        return c2 == '=';
    }

    static {
        int i2 = 0;
        for (int i3 = 0; i3 < 128; i3++) {
            i[i3] = -1;
        }
        for (int i4 = 90; i4 >= 65; i4--) {
            i[i4] = (byte) (i4 - 65);
        }
        for (int i5 = 122; i5 >= 97; i5--) {
            i[i5] = (byte) (i5 - 71);
        }
        for (int i6 = 57; i6 >= 48; i6--) {
            i[i6] = (byte) (i6 + 4);
        }
        byte[] bArr = i;
        bArr[43] = 62;
        bArr[47] = Utf8.REPLACEMENT_BYTE;
        for (int i7 = 0; i7 <= 25; i7++) {
            j[i7] = (char) (i7 + 65);
        }
        int i8 = 26;
        int i9 = 0;
        while (i8 <= 51) {
            j[i8] = (char) (i9 + 97);
            i8++;
            i9++;
        }
        int i10 = 52;
        while (i10 <= 61) {
            j[i10] = (char) (i2 + 48);
            i10++;
            i2++;
        }
        char[] cArr = j;
        cArr[62] = '+';
        cArr[63] = IOUtils.DIR_SEPARATOR_UNIX;
    }

    private static boolean c(char c2) {
        return c2 < 128 && i[c2] != -1;
    }

    public static String a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        int length = bArr.length * 8;
        if (length == 0) {
            return "";
        }
        int i2 = length % 24;
        int i3 = length / 24;
        char[] cArr = new char[(i2 != 0 ? i3 + 1 : i3) * 4];
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < i3; i6++) {
            byte b2 = bArr[i4];
            int i7 = i4 + 2;
            byte b3 = bArr[i4 + 1];
            i4 += 3;
            byte b4 = bArr[i7];
            byte b5 = (byte) (b3 & 15);
            byte b6 = (byte) (b2 & 3);
            int i8 = b2 & (-128);
            int i9 = b2 >> 2;
            if (i8 != 0) {
                i9 ^= 192;
            }
            byte b7 = (byte) i9;
            int i10 = b3 & (-128);
            int i11 = b3 >> 4;
            if (i10 != 0) {
                i11 ^= 240;
            }
            byte b8 = (byte) i11;
            int i12 = (b4 & (-128)) == 0 ? b4 >> 6 : (b4 >> 6) ^ MediaPlayer.MEDIA_PLAYER_OPTION_HW_DEC_DROP_NON_REF;
            char[] cArr2 = j;
            cArr[i5] = cArr2[b7];
            cArr[i5 + 1] = cArr2[b8 | (b6 << 4)];
            int i13 = i5 + 3;
            cArr[i5 + 2] = cArr2[(b5 << 2) | ((byte) i12)];
            i5 += 4;
            cArr[i13] = cArr2[b4 & Utf8.REPLACEMENT_BYTE];
        }
        if (i2 == 8) {
            byte b9 = bArr[i4];
            byte b10 = (byte) (b9 & 3);
            int i14 = b9 & (-128);
            int i15 = b9 >> 2;
            if (i14 != 0) {
                i15 ^= 192;
            }
            char[] cArr3 = j;
            cArr[i5] = cArr3[(byte) i15];
            cArr[i5 + 1] = cArr3[b10 << 4];
            cArr[i5 + 2] = h;
            cArr[i5 + 3] = h;
        } else if (i2 == 16) {
            byte b11 = bArr[i4];
            byte b12 = bArr[i4 + 1];
            byte b13 = (byte) (b12 & 15);
            byte b14 = (byte) (b11 & 3);
            int i16 = b11 & (-128);
            int i17 = b11 >> 2;
            if (i16 != 0) {
                i17 ^= 192;
            }
            byte b15 = (byte) i17;
            int i18 = b12 & (-128);
            int i19 = b12 >> 4;
            if (i18 != 0) {
                i19 ^= 240;
            }
            char[] cArr4 = j;
            cArr[i5] = cArr4[b15];
            cArr[i5 + 1] = cArr4[((byte) i19) | (b14 << 4)];
            cArr[i5 + 2] = cArr4[b13 << 2];
            cArr[i5 + 3] = h;
        }
        return new String(cArr);
    }

    public static byte[] a(String str) {
        if (str == null) {
            return null;
        }
        char[] charArray = str.toCharArray();
        int iA = a(charArray);
        if (iA % 4 != 0) {
            return null;
        }
        int i2 = iA / 4;
        if (i2 == 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[i2 * 3];
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i3 < i2 - 1) {
            int i6 = i4 + 1;
            char c2 = charArray[i4];
            if (c(c2)) {
                int i7 = i4 + 2;
                char c3 = charArray[i6];
                if (c(c3)) {
                    int i8 = i4 + 3;
                    char c4 = charArray[i7];
                    if (c(c4)) {
                        i4 += 4;
                        char c5 = charArray[i8];
                        if (c(c5)) {
                            byte[] bArr2 = i;
                            byte b2 = bArr2[c2];
                            byte b3 = bArr2[c3];
                            byte b4 = bArr2[c4];
                            byte b5 = bArr2[c5];
                            bArr[i5] = (byte) ((b2 << 2) | (b3 >> 4));
                            int i9 = i5 + 2;
                            bArr[i5 + 1] = (byte) (((b3 & 15) << 4) | ((b4 >> 2) & 15));
                            i5 += 3;
                            bArr[i9] = (byte) ((b4 << 6) | b5);
                            i3++;
                        }
                    }
                }
            }
            return null;
        }
        int i10 = i4 + 1;
        char c6 = charArray[i4];
        if (!c(c6)) {
            return null;
        }
        int i11 = i4 + 2;
        char c7 = charArray[i10];
        if (!c(c7)) {
            return null;
        }
        byte[] bArr3 = i;
        byte b6 = bArr3[c6];
        byte b7 = bArr3[c7];
        char c8 = charArray[i11];
        char c9 = charArray[i4 + 3];
        if (!c(c8) || !c(c9)) {
            if (b(c8) && b(c9)) {
                if ((b7 & 15) != 0) {
                    return null;
                }
                int i12 = i3 * 3;
                byte[] bArr4 = new byte[i12 + 1];
                System.arraycopy(bArr, 0, bArr4, 0, i12);
                bArr4[i5] = (byte) ((b6 << 2) | (b7 >> 4));
                return bArr4;
            }
            if (b(c8) || !b(c9)) {
                return null;
            }
            byte b8 = bArr3[c8];
            if ((b8 & 3) != 0) {
                return null;
            }
            int i13 = i3 * 3;
            byte[] bArr5 = new byte[i13 + 2];
            System.arraycopy(bArr, 0, bArr5, 0, i13);
            bArr5[i5] = (byte) ((b6 << 2) | (b7 >> 4));
            bArr5[i5 + 1] = (byte) (((b8 >> 2) & 15) | ((b7 & 15) << 4));
            return bArr5;
        }
        byte b9 = bArr3[c8];
        byte b10 = bArr3[c9];
        bArr[i5] = (byte) ((b6 << 2) | (b7 >> 4));
        bArr[i5 + 1] = (byte) (((b7 & 15) << 4) | ((b9 >> 2) & 15));
        bArr[i5 + 2] = (byte) (b10 | (b9 << 6));
        return bArr;
    }

    private static int a(char[] cArr) {
        if (cArr == null) {
            return 0;
        }
        int length = cArr.length;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            if (!a(cArr[i3])) {
                cArr[i2] = cArr[i3];
                i2++;
            }
        }
        return i2;
    }
}
