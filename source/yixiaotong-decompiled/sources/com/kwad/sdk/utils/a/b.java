package com.kwad.sdk.utils.a;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.common.base.Ascii;
import java.nio.charset.Charset;
import okio.Utf8;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class b {
    public static final Charset UTF_8 = Charset.forName("UTF-8");
    private char[] brL;
    public byte[] brM;
    public int position;

    public static int gh(int i) {
        if ((i >> 7) == 0) {
            return 1;
        }
        if ((i >> 14) == 0) {
            return 2;
        }
        if ((i >> 21) == 0) {
            return 3;
        }
        return (i >> 28) == 0 ? 4 : 5;
    }

    public b(int i) {
        this(new byte[i], 0);
    }

    public b(byte[] bArr) {
        this(bArr, 0);
    }

    public b(byte[] bArr, int i) {
        this.brL = null;
        this.brM = bArr;
        this.position = i;
    }

    public final byte get() {
        byte[] bArr = this.brM;
        int i = this.position;
        this.position = i + 1;
        return bArr[i];
    }

    public final void e(byte b) {
        byte[] bArr = this.brM;
        int i = this.position;
        this.position = i + 1;
        bArr[i] = b;
    }

    public final short getShort() {
        byte[] bArr = this.brM;
        int i = this.position;
        int i2 = i + 1;
        int i3 = bArr[i] & 255;
        this.position = i + 2;
        return (short) ((bArr[i2] << 8) | i3);
    }

    public final void a(short s) {
        byte[] bArr = this.brM;
        int i = this.position;
        bArr[i] = (byte) s;
        this.position = i + 2;
        bArr[i + 1] = (byte) (s >> 8);
    }

    public final int getInt() {
        byte[] bArr = this.brM;
        int i = this.position;
        int i2 = ((bArr[i + 1] & 255) << 8) | (bArr[i] & 255);
        int i3 = i + 3;
        int i4 = i2 | ((bArr[i + 2] & 255) << 16);
        this.position = i + 4;
        return (bArr[i3] << Ascii.CAN) | i4;
    }

    public final void gf(int i) {
        byte[] bArr = this.brM;
        int i2 = this.position;
        bArr[i2] = (byte) i;
        bArr[i2 + 1] = (byte) (i >> 8);
        bArr[i2 + 2] = (byte) (i >> 16);
        this.position = i2 + 4;
        bArr[i2 + 3] = (byte) (i >> 24);
    }

    public final void J(int i, int i2) {
        byte[] bArr = this.brM;
        bArr[i] = (byte) i2;
        bArr[i + 1] = (byte) (i2 >> 8);
        bArr[i + 2] = (byte) (i2 >> 16);
        bArr[i + 3] = (byte) (i2 >> 24);
    }

    public final int Xj() {
        byte[] bArr = this.brM;
        int i = this.position;
        int i2 = i + 1;
        this.position = i2;
        byte b = bArr[i];
        if ((b >> 7) == 0) {
            return b;
        }
        int i3 = i + 2;
        this.position = i3;
        int i4 = (bArr[i2] << 7) | (b & 127);
        if ((i4 >> 14) == 0) {
            return i4;
        }
        int i5 = i + 3;
        this.position = i5;
        int i6 = (i4 & 16383) | (bArr[i3] << 14);
        if ((i6 >> 21) == 0) {
            return i6;
        }
        int i7 = i + 4;
        this.position = i7;
        int i8 = (i6 & 2097151) | (bArr[i5] << Ascii.NAK);
        if ((i8 >> 28) == 0) {
            return i8;
        }
        this.position = i + 5;
        return (bArr[i7] << Ascii.FS) | (i8 & 268435455);
    }

    private int K(int i, int i2) {
        while ((i2 & (-128)) != 0) {
            this.brM[i] = (byte) ((i2 & 127) | 128);
            i2 >>>= 7;
            i++;
        }
        int i3 = i + 1;
        this.brM[i] = (byte) i2;
        return i3;
    }

    public final void gg(int i) {
        this.position = K(this.position, i);
    }

    public final void h(int i, long j) {
        byte[] bArr = this.brM;
        bArr[i] = (byte) j;
        bArr[i + 1] = (byte) (j >> 8);
        bArr[i + 2] = (byte) (j >> 16);
        bArr[i + 3] = (byte) (j >> 24);
        bArr[i + 4] = (byte) (j >> 32);
        bArr[i + 5] = (byte) (j >> 40);
        bArr[i + 6] = (byte) (j >> 48);
        bArr[i + 7] = (byte) (j >> 56);
    }

    public final void bg(long j) {
        h(this.position, j);
        this.position += 8;
    }

    private long getLong(int i) {
        byte[] bArr = this.brM;
        int i2 = i + 6;
        return (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i2]) & 255) << 48) | (((long) bArr[i + 7]) << 56);
    }

    public final long getLong() {
        long j = getLong(this.position);
        this.position += 8;
        return j;
    }

    public final float getFloat() {
        return Float.intBitsToFloat(getInt());
    }

    public final double getDouble() {
        return Double.longBitsToDouble(getLong());
    }

    public final byte[] getBytes(int i) {
        byte[] bArr = new byte[i];
        System.arraycopy(this.brM, this.position, bArr, 0, i);
        this.position += i;
        return bArr;
    }

    public final void p(byte[] bArr) {
        int length = bArr.length;
        if (length > 0) {
            System.arraycopy(bArr, 0, this.brM, this.position, length);
            this.position += length;
        }
    }

    public final String getString(int i) {
        if (i < 0) {
            return null;
        }
        if (i == 0) {
            return "";
        }
        String strGk = gk(i);
        this.position += i;
        return strGk;
    }

    public final String gi(int i) {
        if (i < 0) {
            return null;
        }
        if (i == 0) {
            return "";
        }
        String strGl = gl(i);
        this.position += i;
        return strGl;
    }

    public final void it(String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        iv(str);
    }

    public static int iu(String str) {
        int length = str.length();
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = i + 1;
            char cCharAt = str.charAt(i);
            if (cCharAt < 128) {
                i2++;
            } else if (cCharAt < 2048) {
                i2 += 2;
            } else if (cCharAt < 55296 || cCharAt > 57343) {
                i2 += 3;
            } else {
                i += 2;
                i2 += 4;
            }
            i = i3;
        }
        return i2;
    }

    private char[] gj(int i) {
        char[] cArr = this.brL;
        if (cArr == null) {
            if (i <= 256) {
                this.brL = new char[256];
            } else {
                this.brL = new char[2048];
            }
        } else if (cArr.length < i) {
            this.brL = new char[2048];
        }
        return this.brL;
    }

    private String gk(int i) {
        if (i > 2048) {
            return new String(this.brM, this.position, i, UTF_8);
        }
        char[] cArrGj = gj(i);
        byte[] bArr = this.brM;
        int i2 = this.position;
        int i3 = i + i2;
        int i4 = 0;
        while (i2 < i3) {
            int i5 = i2 + 1;
            byte b = bArr[i2];
            if (b > 0) {
                cArrGj[i4] = (char) (b ^ 1);
                i4++;
                i2 = i5;
            } else if (b < -32) {
                i2 += 2;
                cArrGj[i4] = (char) ((bArr[i5] & Utf8.REPLACEMENT_BYTE) | ((b & Ascii.US) << 6));
                i4++;
            } else if (b < -16) {
                int i6 = i2 + 2;
                i2 += 3;
                cArrGj[i4] = (char) (((bArr[i5] & Utf8.REPLACEMENT_BYTE) << 6) | ((b & 15) << 12) | (bArr[i6] & Utf8.REPLACEMENT_BYTE));
                i4++;
            } else {
                byte b2 = bArr[i5];
                int i7 = i2 + 3;
                byte b3 = bArr[i2 + 2];
                i2 += 4;
                int i8 = ((b2 & Utf8.REPLACEMENT_BYTE) << 12) | ((b & 7) << 18) | ((b3 & Utf8.REPLACEMENT_BYTE) << 6) | (bArr[i7] & Utf8.REPLACEMENT_BYTE);
                int i9 = i4 + 1;
                cArrGj[i4] = (char) ((i8 >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
                i4 += 2;
                cArrGj[i9] = (char) ((i8 & AnalyticsListener.EVENT_DRM_KEYS_LOADED) + Utf8.LOG_SURROGATE_HEADER);
            }
        }
        if (i2 > i3) {
            throw new IllegalArgumentException("Invalid String");
        }
        return new String(cArrGj, 0, i4);
    }

    private String gl(int i) {
        if (i > 2048) {
            return new String(this.brM, this.position, i, UTF_8);
        }
        char[] cArrGj = gj(i);
        byte[] bArr = this.brM;
        int i2 = this.position;
        int i3 = i + i2;
        int i4 = 0;
        while (i2 < i3) {
            int i5 = i2 + 1;
            byte b = bArr[i2];
            if (b > 0) {
                cArrGj[i4] = (char) b;
                i4++;
                i2 = i5;
            } else if (b < -32) {
                i2 += 2;
                cArrGj[i4] = (char) ((bArr[i5] & Utf8.REPLACEMENT_BYTE) | ((b & Ascii.US) << 6));
                i4++;
            } else if (b < -16) {
                int i6 = i2 + 2;
                i2 += 3;
                cArrGj[i4] = (char) (((bArr[i5] & Utf8.REPLACEMENT_BYTE) << 6) | ((b & 15) << 12) | (bArr[i6] & Utf8.REPLACEMENT_BYTE));
                i4++;
            } else {
                byte b2 = bArr[i5];
                int i7 = i2 + 3;
                byte b3 = bArr[i2 + 2];
                i2 += 4;
                int i8 = ((b2 & Utf8.REPLACEMENT_BYTE) << 12) | ((b & 7) << 18) | ((b3 & Utf8.REPLACEMENT_BYTE) << 6) | (bArr[i7] & Utf8.REPLACEMENT_BYTE);
                int i9 = i4 + 1;
                cArrGj[i4] = (char) ((i8 >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
                i4 += 2;
                cArrGj[i9] = (char) ((i8 & AnalyticsListener.EVENT_DRM_KEYS_LOADED) + Utf8.LOG_SURROGATE_HEADER);
            }
        }
        if (i2 > i3) {
            throw new IllegalArgumentException("Invalid String");
        }
        return new String(cArrGj, 0, i4);
    }

    static String j(byte[] bArr, int i) {
        char[] cArr = new char[bArr.length];
        int i2 = 0;
        int i3 = 0;
        while (i2 < i) {
            int i4 = i2 + 1;
            byte b = bArr[i2];
            if (b > 0) {
                cArr[i3] = (char) (b ^ 1);
                i3++;
                i2 = i4;
            } else if (b < -32) {
                i2 += 2;
                cArr[i3] = (char) ((bArr[i4] & Utf8.REPLACEMENT_BYTE) | ((b & Ascii.US) << 6));
                i3++;
            } else if (b < -16) {
                int i5 = i2 + 2;
                i2 += 3;
                cArr[i3] = (char) (((bArr[i4] & Utf8.REPLACEMENT_BYTE) << 6) | ((b & 15) << 12) | (bArr[i5] & Utf8.REPLACEMENT_BYTE));
                i3++;
            } else {
                byte b2 = bArr[i4];
                int i6 = i2 + 3;
                byte b3 = bArr[i2 + 2];
                i2 += 4;
                int i7 = ((b2 & Utf8.REPLACEMENT_BYTE) << 12) | ((b & 7) << 18) | ((b3 & Utf8.REPLACEMENT_BYTE) << 6) | (bArr[i6] & Utf8.REPLACEMENT_BYTE);
                int i8 = i3 + 1;
                cArr[i3] = (char) ((i7 >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
                i3 += 2;
                cArr[i8] = (char) ((i7 & AnalyticsListener.EVENT_DRM_KEYS_LOADED) + Utf8.LOG_SURROGATE_HEADER);
            }
        }
        if (i2 > i) {
            throw new IllegalArgumentException("Invalid String");
        }
        return new String(cArr, 0, i3);
    }

    private void iv(String str) {
        byte[] bArr = this.brM;
        int i = this.position;
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            int i3 = i2 + 1;
            char cCharAt = str.charAt(i2);
            if (cCharAt < 128) {
                bArr[i] = (byte) (cCharAt ^ 1);
                i++;
            } else if (cCharAt < 2048) {
                int i4 = i + 1;
                bArr[i] = (byte) ((cCharAt >>> 6) | 192);
                i += 2;
                bArr[i4] = (byte) ((cCharAt & '?') | 128);
            } else if (cCharAt < 55296 || cCharAt > 57343) {
                bArr[i] = (byte) ((cCharAt >>> '\f') | 224);
                int i5 = i + 2;
                bArr[i + 1] = (byte) (((cCharAt >>> 6) & 63) | 128);
                i += 3;
                bArr[i5] = (byte) ((cCharAt & '?') | 128);
            } else {
                i2 += 2;
                int iCharAt = ((cCharAt << '\n') + str.charAt(i3)) - 56613888;
                bArr[i] = (byte) ((iCharAt >>> 18) | 240);
                bArr[i + 1] = (byte) (((iCharAt >>> 12) & 63) | 128);
                int i6 = i + 3;
                bArr[i + 2] = (byte) (((iCharAt >>> 6) & 63) | 128);
                i += 4;
                bArr[i6] = (byte) ((iCharAt & 63) | 128);
            }
            i2 = i3;
        }
        this.position = i;
    }

    public static byte[] iw(String str) {
        byte[] bArr = new byte[iu(str)];
        int length = str.length();
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = i + 1;
            char cCharAt = str.charAt(i);
            if (cCharAt < 128) {
                bArr[i2] = (byte) (cCharAt ^ 1);
                i2++;
            } else if (cCharAt < 2048) {
                int i4 = i2 + 1;
                bArr[i2] = (byte) ((cCharAt >>> 6) | 192);
                i2 += 2;
                bArr[i4] = (byte) ((cCharAt & '?') | 128);
            } else if (cCharAt < 55296 || cCharAt > 57343) {
                bArr[i2] = (byte) ((cCharAt >>> '\f') | 224);
                int i5 = i2 + 2;
                bArr[i2 + 1] = (byte) (((cCharAt >>> 6) & 63) | 128);
                i2 += 3;
                bArr[i5] = (byte) ((cCharAt & '?') | 128);
            } else {
                i += 2;
                int iCharAt = ((cCharAt << '\n') + str.charAt(i3)) - 56613888;
                bArr[i2] = (byte) ((iCharAt >>> 18) | 240);
                bArr[i2 + 1] = (byte) (((iCharAt >>> 12) & 63) | 128);
                int i6 = i2 + 3;
                bArr[i2 + 2] = (byte) (((iCharAt >>> 6) & 63) | 128);
                i2 += 4;
                bArr[i6] = (byte) ((iCharAt & 63) | 128);
            }
            i = i3;
        }
        return bArr;
    }

    final long L(int i, int i2) {
        long j = 0;
        if (i2 <= 0) {
            return 0L;
        }
        int i3 = i2 >> 3;
        int i4 = i2 & 7;
        int i5 = 0;
        int i6 = i;
        for (int i7 = 0; i7 < i3; i7++) {
            j ^= getLong(i6);
            i6 += 8;
        }
        int i8 = i4 << 3;
        while (i5 < i8) {
            j ^= (((long) this.brM[i6]) & 255) << i5;
            i5 += 8;
            i6++;
        }
        int i9 = (i & 7) << 3;
        return (j >>> (64 - i9)) | (j << i9);
    }
}
