package com.alibaba.fastjson.util;

import androidx.room.RoomDatabase;
import com.alibaba.fastjson.JSONException;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import java.io.Closeable;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import kotlin.text.Typography;
import ms.bz.bd.c.Pgl.pblv;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class IOUtils {
    public static final char[] ASCII_CHARS;
    static final char[] DigitOnes;
    static final char[] DigitTens;
    static final char[] digits;
    public static final boolean[] identifierFlags;
    public static final char[] replaceChars;
    static final int[] sizeTable;
    public static final byte[] specicalFlags_doubleQuotes;
    public static final byte[] specicalFlags_singleQuotes;
    public static boolean[] whitespaceFlags;
    public static final char[] DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    public static final boolean[] firstIdentifierFlags = new boolean[256];

    public static int stringSize(long j) {
        long j2 = 10;
        for (int i = 1; i < 19; i++) {
            if (j < j2) {
                return i;
            }
            j2 *= 10;
        }
        return 19;
    }

    static {
        char c = 0;
        while (true) {
            boolean[] zArr = firstIdentifierFlags;
            if (c >= zArr.length) {
                break;
            }
            if (c >= 'A' && c <= 'Z') {
                zArr[c] = true;
            } else if (c >= 'a' && c <= 'z') {
                zArr[c] = true;
            } else if (c == '_') {
                zArr[c] = true;
            }
            c = (char) (c + 1);
        }
        identifierFlags = new boolean[256];
        char c2 = 0;
        while (true) {
            boolean[] zArr2 = identifierFlags;
            if (c2 >= zArr2.length) {
                break;
            }
            if (c2 >= 'A' && c2 <= 'Z') {
                zArr2[c2] = true;
            } else if (c2 >= 'a' && c2 <= 'z') {
                zArr2[c2] = true;
            } else if (c2 == '_') {
                zArr2[c2] = true;
            } else if (c2 >= '0' && c2 <= '9') {
                zArr2[c2] = true;
            }
            c2 = (char) (c2 + 1);
        }
        byte[] bArr = new byte[256];
        specicalFlags_doubleQuotes = bArr;
        byte[] bArr2 = new byte[256];
        specicalFlags_singleQuotes = bArr2;
        replaceChars = new char[128];
        bArr[0] = 4;
        bArr[1] = 4;
        bArr[2] = 4;
        bArr[3] = 4;
        bArr[4] = 4;
        bArr[5] = 4;
        bArr[6] = 4;
        bArr[7] = 4;
        bArr[8] = 1;
        bArr[9] = 1;
        bArr[10] = 1;
        bArr[11] = 4;
        bArr[12] = 1;
        bArr[13] = 1;
        bArr[34] = 1;
        bArr[92] = 1;
        bArr2[0] = 4;
        bArr2[1] = 4;
        bArr2[2] = 4;
        bArr2[3] = 4;
        bArr2[4] = 4;
        bArr2[5] = 4;
        bArr2[6] = 4;
        bArr2[7] = 4;
        bArr2[8] = 1;
        bArr2[9] = 1;
        bArr2[10] = 1;
        bArr2[11] = 4;
        bArr2[12] = 1;
        bArr2[13] = 1;
        bArr2[92] = 1;
        bArr2[39] = 1;
        for (int i = 14; i <= 31; i++) {
            specicalFlags_doubleQuotes[i] = 4;
            specicalFlags_singleQuotes[i] = 4;
        }
        for (int i2 = 127; i2 <= 160; i2++) {
            specicalFlags_doubleQuotes[i2] = 4;
            specicalFlags_singleQuotes[i2] = 4;
        }
        char[] cArr = replaceChars;
        cArr[0] = '0';
        cArr[1] = '1';
        cArr[2] = '2';
        cArr[3] = '3';
        cArr[4] = '4';
        cArr[5] = '5';
        cArr[6] = '6';
        cArr[7] = '7';
        cArr[8] = 'b';
        cArr[9] = 't';
        cArr[10] = 'n';
        cArr[11] = 'v';
        cArr[12] = 'f';
        cArr[13] = 'r';
        cArr[34] = Typography.quote;
        cArr[39] = '\'';
        cArr[47] = org.apache.commons.io.IOUtils.DIR_SEPARATOR_UNIX;
        cArr[92] = org.apache.commons.io.IOUtils.DIR_SEPARATOR_WINDOWS;
        ASCII_CHARS = new char[]{'0', '0', '0', '1', '0', '2', '0', '3', '0', '4', '0', '5', '0', '6', '0', '7', '0', '8', '0', '9', '0', 'A', '0', 'B', '0', 'C', '0', 'D', '0', 'E', '0', 'F', '1', '0', '1', '1', '1', '2', '1', '3', '1', '4', '1', '5', '1', '6', '1', '7', '1', '8', '1', '9', '1', 'A', '1', 'B', '1', 'C', '1', 'D', '1', 'E', '1', 'F', '2', '0', '2', '1', '2', '2', '2', '3', '2', '4', '2', '5', '2', '6', '2', '7', '2', '8', '2', '9', '2', 'A', '2', 'B', '2', 'C', '2', 'D', '2', 'E', '2', 'F'};
        digits = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        DigitTens = new char[]{'0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '4', '4', '4', '4', '4', '4', '4', '4', '4', '4', '5', '5', '5', '5', '5', '5', '5', '5', '5', '5', '6', '6', '6', '6', '6', '6', '6', '6', '6', '6', '7', '7', '7', '7', '7', '7', '7', '7', '7', '7', '8', '8', '8', '8', '8', '8', '8', '8', '8', '8', '9', '9', '9', '9', '9', '9', '9', '9', '9', '9'};
        DigitOnes = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        sizeTable = new int[]{9, 99, RoomDatabase.MAX_BIND_PARAMETER_CNT, AVMDLDataLoader.KeyIsEnableEventInfo, pblv.COLLECT_MODE_DEFAULT, 999999, 9999999, 99999999, 999999999, Integer.MAX_VALUE};
        boolean[] zArr3 = new boolean[256];
        whitespaceFlags = zArr3;
        zArr3[32] = true;
        zArr3[10] = true;
        zArr3[13] = true;
        zArr3[9] = true;
        zArr3[12] = true;
        zArr3[8] = true;
    }

    public static void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    public static void getChars(long j, int i, char[] cArr) {
        char c;
        if (j < 0) {
            j = -j;
            c = '-';
        } else {
            c = 0;
        }
        while (j > 2147483647L) {
            long j2 = j / 100;
            int i2 = (int) (j - (((j2 << 6) + (j2 << 5)) + (j2 << 2)));
            cArr[i - 1] = DigitOnes[i2];
            i -= 2;
            cArr[i] = DigitTens[i2];
            j = j2;
        }
        int i3 = (int) j;
        while (i3 >= 65536) {
            int i4 = i3 / 100;
            int i5 = i3 - (((i4 << 6) + (i4 << 5)) + (i4 << 2));
            cArr[i - 1] = DigitOnes[i5];
            i -= 2;
            cArr[i] = DigitTens[i5];
            i3 = i4;
        }
        while (true) {
            int i6 = (52429 * i3) >>> 19;
            int i7 = i - 1;
            cArr[i7] = digits[i3 - ((i6 << 3) + (i6 << 1))];
            if (i6 == 0) {
                break;
            }
            i3 = i6;
            i = i7;
        }
        if (c != 0) {
            cArr[i - 2] = c;
        }
    }

    public static void getChars(int i, int i2, char[] cArr) {
        char c;
        if (i < 0) {
            i = -i;
            c = '-';
        } else {
            c = 0;
        }
        while (i >= 65536) {
            int i3 = i / 100;
            int i4 = i - (((i3 << 6) + (i3 << 5)) + (i3 << 2));
            cArr[i2 - 1] = DigitOnes[i4];
            i2 -= 2;
            cArr[i2] = DigitTens[i4];
            i = i3;
        }
        while (true) {
            int i5 = (52429 * i) >>> 19;
            int i6 = i2 - 1;
            cArr[i6] = digits[i - ((i5 << 3) + (i5 << 1))];
            if (i5 == 0) {
                break;
            }
            i = i5;
            i2 = i6;
        }
        if (c != 0) {
            cArr[i2 - 2] = c;
        }
    }

    public static void getChars(byte b, int i, char[] cArr) {
        char c;
        int i2;
        if (b < 0) {
            c = '-';
            i2 = -b;
        } else {
            c = 0;
            i2 = b;
        }
        while (true) {
            int i3 = (52429 * i2) >>> 19;
            int i4 = i - 1;
            cArr[i4] = digits[i2 - ((i3 << 3) + (i3 << 1))];
            if (i3 == 0) {
                break;
            }
            i2 = i3;
            i = i4;
        }
        if (c != 0) {
            cArr[i - 2] = c;
        }
    }

    public static int stringSize(int i) {
        int i2 = 0;
        while (i > sizeTable[i2]) {
            i2++;
        }
        return i2 + 1;
    }

    public static void decode(CharsetDecoder charsetDecoder, ByteBuffer byteBuffer, CharBuffer charBuffer) {
        try {
            CoderResult coderResultDecode = charsetDecoder.decode(byteBuffer, charBuffer, true);
            if (!coderResultDecode.isUnderflow()) {
                coderResultDecode.throwException();
            }
            CoderResult coderResultFlush = charsetDecoder.flush(charBuffer);
            if (coderResultFlush.isUnderflow()) {
                return;
            }
            coderResultFlush.throwException();
        } catch (CharacterCodingException e) {
            throw new JSONException(e.getMessage(), e);
        }
    }

    public static boolean firstIdentifier(char c) {
        boolean[] zArr = firstIdentifierFlags;
        return c < zArr.length && zArr[c];
    }

    public static boolean isIdent(char c) {
        boolean[] zArr = identifierFlags;
        return c < zArr.length && zArr[c];
    }
}
