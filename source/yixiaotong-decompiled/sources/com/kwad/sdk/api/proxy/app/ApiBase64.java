package com.kwad.sdk.api.proxy.app;

import android.text.TextUtils;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;
import kotlin.io.encoding.Base64;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class ApiBase64 {
    private static final String PRE = "sDAkk/dS";
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    private static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");

    private ApiBase64() {
    }

    public static Encoder getEncoder() {
        return Encoder.RFC4648;
    }

    public static Encoder getUrlSafeEncoder() {
        return Encoder.RFC4648_URLSAFE;
    }

    public static Decoder getDecoder() {
        return Decoder.RFC4648;
    }

    public static Decoder getMimeDecoder() {
        return Decoder.RFC2045;
    }

    public static Decoder getUrlSafeDecoder() {
        return Decoder.RFC4648_URLSAFE;
    }

    public static class Encoder {
        static final Encoder RFC4648 = new Encoder(false, null, -1, true);
        static final Encoder RFC4648_URLSAFE = new Encoder(true, null, -1, false);
        private static final char[] toBase64 = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', IOUtils.DIR_SEPARATOR_UNIX};
        private static final char[] toBase64URL = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '-', '_'};
        private final boolean doPadding;
        private final boolean isURL;
        private final int linemax;
        private final byte[] newline;

        private Encoder(boolean z, byte[] bArr, int i, boolean z2) {
            this.isURL = z;
            this.newline = bArr;
            this.linemax = i;
            this.doPadding = z2;
        }

        private final int outLength(int i) {
            int i2;
            if (this.doPadding) {
                i2 = ((i + 2) / 3) * 4;
            } else {
                int i3 = i % 3;
                i2 = ((i / 3) * 4) + (i3 == 0 ? 0 : i3 + 1);
            }
            int i4 = this.linemax;
            return i4 > 0 ? i2 + (((i2 - 1) / i4) * this.newline.length) : i2;
        }

        public byte[] encode(byte[] bArr) {
            int iOutLength = outLength(bArr.length);
            byte[] bArr2 = new byte[iOutLength];
            int iEncode0 = encode0(bArr, 0, bArr.length, bArr2);
            return iEncode0 != iOutLength ? Arrays.copyOf(bArr2, iEncode0) : bArr2;
        }

        public int encode(byte[] bArr, byte[] bArr2) {
            if (bArr2.length < outLength(bArr.length)) {
                throw new IllegalArgumentException("Output byte array is too small for encoding all input bytes");
            }
            return encode0(bArr, 0, bArr.length, bArr2);
        }

        public String encodeToString(byte[] bArr) {
            byte[] bArrEncode = encode(bArr);
            return new String(bArrEncode, 0, 0, bArrEncode.length);
        }

        public ByteBuffer encode(ByteBuffer byteBuffer) {
            int iEncode0;
            int iOutLength = outLength(byteBuffer.remaining());
            byte[] bArrCopyOf = new byte[iOutLength];
            if (byteBuffer.hasArray()) {
                iEncode0 = encode0(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.arrayOffset() + byteBuffer.limit(), bArrCopyOf);
                byteBuffer.position(byteBuffer.limit());
            } else {
                int iRemaining = byteBuffer.remaining();
                byte[] bArr = new byte[iRemaining];
                byteBuffer.get(bArr);
                iEncode0 = encode0(bArr, 0, iRemaining, bArrCopyOf);
            }
            if (iEncode0 != iOutLength) {
                bArrCopyOf = Arrays.copyOf(bArrCopyOf, iEncode0);
            }
            return ByteBuffer.wrap(bArrCopyOf);
        }

        private int encode0(byte[] bArr, int i, int i2, byte[] bArr2) {
            char[] cArr = this.isURL ? toBase64URL : toBase64;
            int i3 = ((i2 - i) / 3) * 3;
            int i4 = i + i3;
            int i5 = this.linemax;
            if (i5 > 0 && i3 > (i5 / 4) * 3) {
                i3 = (i5 / 4) * 3;
            }
            int i6 = i;
            int i7 = 0;
            while (i6 < i4) {
                int iMin = Math.min(i6 + i3, i4);
                int i8 = i6;
                int i9 = i7;
                while (i8 < iMin) {
                    int i10 = i8 + 2;
                    int i11 = ((bArr[i8 + 1] & 255) << 8) | ((bArr[i8] & 255) << 16);
                    i8 += 3;
                    int i12 = i11 | (bArr[i10] & 255);
                    bArr2[i9] = (byte) cArr[(i12 >>> 18) & 63];
                    bArr2[i9 + 1] = (byte) cArr[(i12 >>> 12) & 63];
                    int i13 = i9 + 3;
                    bArr2[i9 + 2] = (byte) cArr[(i12 >>> 6) & 63];
                    i9 += 4;
                    bArr2[i13] = (byte) cArr[i12 & 63];
                }
                int i14 = ((iMin - i6) / 3) * 4;
                i7 += i14;
                if (i14 == this.linemax && iMin < i2) {
                    byte[] bArr3 = this.newline;
                    int length = bArr3.length;
                    int i15 = 0;
                    while (i15 < length) {
                        bArr2[i7] = bArr3[i15];
                        i15++;
                        i7++;
                    }
                }
                i6 = iMin;
            }
            if (i6 >= i2) {
                return i7;
            }
            int i16 = i6 + 1;
            int i17 = bArr[i6] & 255;
            int i18 = i7 + 1;
            bArr2[i7] = (byte) cArr[i17 >> 2];
            if (i16 == i2) {
                int i19 = i7 + 2;
                bArr2[i18] = (byte) cArr[(i17 << 4) & 63];
                if (!this.doPadding) {
                    return i19;
                }
                int i20 = i7 + 3;
                bArr2[i19] = Base64.padSymbol;
                int i21 = i7 + 4;
                bArr2[i20] = Base64.padSymbol;
                return i21;
            }
            int i22 = bArr[i16] & 255;
            bArr2[i18] = (byte) cArr[((i17 << 4) & 63) | (i22 >> 4)];
            int i23 = i7 + 3;
            bArr2[i7 + 2] = (byte) cArr[(i22 << 2) & 63];
            if (!this.doPadding) {
                return i23;
            }
            int i24 = i7 + 4;
            bArr2[i23] = Base64.padSymbol;
            return i24;
        }
    }

    public static class Decoder {
        private static final int[] fromBase64;
        private final boolean isMIME;
        private final boolean isURL;
        static final Decoder RFC4648 = new Decoder(false, false);
        static final Decoder RFC4648_URLSAFE = new Decoder(true, false);
        static final Decoder RFC2045 = new Decoder(false, true);
        private static final int[] fromBase64URL = new int[256];

        static {
            int[] iArr = new int[256];
            fromBase64 = iArr;
            Arrays.fill(iArr, -1);
            for (int i = 0; i < Encoder.toBase64.length; i++) {
                fromBase64[Encoder.toBase64[i]] = i;
            }
            fromBase64[61] = -2;
            Arrays.fill(fromBase64URL, -1);
            for (int i2 = 0; i2 < Encoder.toBase64URL.length; i2++) {
                fromBase64URL[Encoder.toBase64URL[i2]] = i2;
            }
            fromBase64URL[61] = -2;
        }

        private Decoder(boolean z, boolean z2) {
            this.isURL = z;
            this.isMIME = z2;
        }

        public byte[] decode(byte[] bArr) {
            int iOutLength = outLength(bArr, 0, bArr.length);
            byte[] bArr2 = new byte[iOutLength];
            int iDecode0 = decode0(bArr, 0, bArr.length, bArr2);
            return iDecode0 != iOutLength ? Arrays.copyOf(bArr2, iDecode0) : bArr2;
        }

        public byte[] decode(String str) {
            return decode(str.getBytes(ApiBase64.ISO_8859_1));
        }

        public int decode(byte[] bArr, byte[] bArr2) {
            if (bArr2.length < outLength(bArr, 0, bArr.length)) {
                throw new IllegalArgumentException("Output byte array is too small for decoding all input bytes");
            }
            return decode0(bArr, 0, bArr.length, bArr2);
        }

        public ByteBuffer decode(ByteBuffer byteBuffer) {
            int iRemaining;
            byte[] bArrArray;
            int iArrayOffset;
            int iPosition = byteBuffer.position();
            try {
                if (byteBuffer.hasArray()) {
                    bArrArray = byteBuffer.array();
                    iArrayOffset = byteBuffer.arrayOffset() + byteBuffer.position();
                    iRemaining = byteBuffer.arrayOffset() + byteBuffer.limit();
                    byteBuffer.position(byteBuffer.limit());
                } else {
                    iRemaining = byteBuffer.remaining();
                    bArrArray = new byte[iRemaining];
                    byteBuffer.get(bArrArray);
                    iArrayOffset = 0;
                }
                byte[] bArr = new byte[outLength(bArrArray, iArrayOffset, iRemaining)];
                return ByteBuffer.wrap(bArr, 0, decode0(bArrArray, iArrayOffset, iRemaining, bArr));
            } catch (IllegalArgumentException e) {
                byteBuffer.position(iPosition);
                throw e;
            }
        }

        private int outLength(byte[] bArr, int i, int i2) {
            int i3;
            int[] iArr = this.isURL ? fromBase64URL : fromBase64;
            int i4 = i2 - i;
            int i5 = 0;
            if (i4 == 0) {
                return 0;
            }
            if (i4 < 2) {
                if (this.isMIME && iArr[0] == -1) {
                    return 0;
                }
                throw new IllegalArgumentException("Input byte[] should at least have 2 bytes for base64 bytes");
            }
            if (this.isMIME) {
                int i6 = 0;
                while (i < i2) {
                    int i7 = i + 1;
                    int i8 = bArr[i] & 255;
                    if (i8 == 61) {
                        i4 -= (i2 - i7) + 1;
                        break;
                    }
                    if (iArr[i8] == -1) {
                        i6++;
                    }
                    i = i7;
                }
                i4 -= i6;
            } else if (bArr[i2 - 1] == 61) {
                i5 = bArr[i2 - 2] == 61 ? 2 : 1;
            }
            if (i5 == 0 && (i3 = i4 & 3) != 0) {
                i5 = 4 - i3;
            }
            return (((i4 + 3) / 4) * 3) - i5;
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x002f, code lost:
        
            if (r4 != 18) goto L33;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private int decode0(byte[] bArr, int i, int i2, byte[] bArr2) {
            int[] iArr = this.isURL ? fromBase64URL : fromBase64;
            int i3 = 18;
            int i4 = 0;
            int i5 = 0;
            while (i < i2) {
                int i6 = i + 1;
                int i7 = iArr[bArr[i] & 255];
                if (i7 >= 0) {
                    int i8 = (i7 << i3) | i4;
                    i3 -= 6;
                    if (i3 < 0) {
                        bArr2[i5] = (byte) (i8 >> 16);
                        int i9 = i5 + 2;
                        bArr2[i5 + 1] = (byte) (i8 >> 8);
                        i5 += 3;
                        bArr2[i9] = (byte) i8;
                        i3 = 18;
                        i4 = 0;
                    } else {
                        i4 = i8;
                    }
                } else if (i7 == -2) {
                    if (i3 == 6) {
                        if (i6 != i2) {
                            i += 2;
                            if (bArr[i6] == 61) {
                                break;
                            }
                        }
                        throw new IllegalArgumentException("Input byte array has wrong 4-byte ending unit");
                    }
                    i = i6;
                } else if (!this.isMIME) {
                    throw new IllegalArgumentException("Illegal base64 character " + Integer.toString(bArr[i], 16));
                }
                i = i6;
            }
            if (i3 == 6) {
                bArr2[i5] = (byte) (i4 >> 16);
                i5++;
            } else if (i3 == 0) {
                int i10 = i5 + 1;
                bArr2[i5] = (byte) (i4 >> 16);
                i5 += 2;
                bArr2[i10] = (byte) (i4 >> 8);
            } else if (i3 == 12) {
                throw new IllegalArgumentException("Last unit does not have enough valid bits");
            }
            while (i < i2) {
                if (this.isMIME) {
                    int i11 = i + 1;
                    if (iArr[bArr[i]] < 0) {
                        i = i11;
                    } else {
                        i = i11;
                    }
                }
                throw new IllegalArgumentException("Input byte array has incorrect ending byte at " + i);
            }
            return i5;
        }
    }

    public static String encodeKsSdk(String str) {
        return TextUtils.isEmpty(str) ? "" : PRE.concat(new String(getEncoder().encode(str.getBytes()), UTF_8));
    }

    public static String decodeKsSdk(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str.startsWith(PRE) ? new String(getDecoder().decode(str.substring(8)), UTF_8) : str;
    }

    public static boolean isEncodeKsSdk(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith(PRE);
    }
}
