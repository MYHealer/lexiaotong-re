package com.huawei.hms.scankit.p;

import com.google.common.primitives.SignedBytes;
import com.huawei.hms.hmsscankit.WriterException;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import kotlin.io.encoding.Base64;
import okio.Utf8;

/* JADX INFO: compiled from: PDF417HighLevelEncoder.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
final class w4 {
    private static final byte[] c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final byte[] f4367a = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 38, 13, 9, 44, 58, 35, 45, 46, 36, 47, 43, 37, 42, Base64.padSymbol, 94, 0, 32, 0, 0, 0};
    private static final byte[] b = {59, 60, 62, SignedBytes.MAX_POWER_OF_TWO, 91, 92, 93, 95, 96, 126, 33, 13, 9, 44, 58, 10, 45, 46, 36, 47, 34, 124, 42, 40, 41, Utf8.REPLACEMENT_BYTE, 123, 125, 39, 0};
    private static final byte[] d = new byte[128];
    private static final Charset e = StandardCharsets.ISO_8859_1;

    /* JADX INFO: compiled from: PDF417HighLevelEncoder.java */
    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f4368a;

        static {
            int[] iArr = new int[v0.values().length];
            f4368a = iArr;
            try {
                iArr[v0.TEXT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4368a[v0.BYTE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4368a[v0.NUMERIC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static String a(String str, v0 v0Var, Charset charset) throws WriterException {
        StringBuilder sb = new StringBuilder(str.length());
        if (charset == null) {
            charset = e;
        } else if (e.equals(charset)) {
            x3.a("PDF417", "else");
        } else {
            l0 l0VarA = l0.a(charset.name());
            if (l0VarA != null) {
                a(l0VarA.a(), sb);
            }
        }
        int length = str.length();
        int i = a.f4368a[v0Var.ordinal()];
        if (i == 1) {
            a(str, 0, length, sb, 0);
        } else if (i == 2) {
            byte[] bytes = str.getBytes(charset);
            a(bytes, 0, bytes.length, 1, sb);
        } else if (i != 3) {
            int i2 = 0;
            int i3 = 0;
            int iA = 0;
            while (i2 < length) {
                int iA2 = a(str, i2);
                if (iA2 >= 13) {
                    sb.append((char) 902);
                    a(str, i2, iA2, sb);
                    i2 += iA2;
                    iA = 0;
                    i3 = 2;
                } else {
                    int iB = b(str, i2);
                    if (iB >= 5 || iA2 == length) {
                        if (i3 != 0) {
                            sb.append((char) 900);
                            i3 = 0;
                            iA = 0;
                        }
                        iA = a(str, i2, iB, sb, iA);
                        i2 += iB;
                    } else {
                        int iA3 = a(str, i2, charset);
                        if (iA3 == 0) {
                            iA3 = 1;
                        }
                        int i4 = iA3 + i2;
                        byte[] bytes2 = str.substring(i2, i4).getBytes(charset);
                        if (bytes2.length == 1 && i3 == 0) {
                            a(bytes2, 0, 1, 0, sb);
                        } else {
                            a(bytes2, 0, bytes2.length, i3, sb);
                            i3 = 1;
                            iA = 0;
                        }
                        i2 = i4;
                    }
                }
            }
        } else {
            sb.append((char) 902);
            a(str, 0, length, sb);
        }
        return sb.toString();
    }

    private static boolean a(char c2) {
        return c2 == ' ' || (c2 >= 'a' && c2 <= 'z');
    }

    private static int b(CharSequence charSequence, int i) {
        int length = charSequence.length();
        int i2 = i;
        while (i2 < length) {
            char cCharAt = charSequence.charAt(i2);
            int i3 = 0;
            while (i3 < 13 && c(cCharAt) && i2 < length) {
                i3++;
                i2++;
                if (i2 < length) {
                    cCharAt = charSequence.charAt(i2);
                }
            }
            if (i3 >= 13) {
                return (i2 - i) - i3;
            }
            if (i3 <= 0) {
                if (!f(charSequence.charAt(i2))) {
                    break;
                }
                i2++;
            }
        }
        return i2 - i;
    }

    private static boolean b(char c2) {
        return c2 == ' ' || (c2 >= 'A' && c2 <= 'Z');
    }

    private static boolean c(char c2) {
        return c2 >= '0' && c2 <= '9';
    }

    private static boolean d(char c2) {
        byte[] bArr = c;
        if (y6.a(bArr, (int) c2)) {
            return bArr[c2] != -1;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    private static boolean e(char c2) {
        if (y6.a(c, (int) c2)) {
            return d[c2] != -1;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    private static boolean f(char c2) {
        return c2 == '\t' || c2 == '\n' || c2 == '\r' || (c2 >= ' ' && c2 <= '~');
    }

    static {
        byte[] bArr = new byte[128];
        c = bArr;
        Arrays.fill(bArr, (byte) -1);
        int i = 0;
        int i2 = 0;
        while (true) {
            byte[] bArr2 = f4367a;
            if (i2 >= bArr2.length) {
                break;
            }
            byte b2 = bArr2[i2];
            if (b2 > 0) {
                c[b2] = (byte) i2;
            }
            i2++;
        }
        Arrays.fill(d, (byte) -1);
        while (true) {
            byte[] bArr3 = b;
            if (i >= bArr3.length) {
                return;
            }
            byte b3 = bArr3[i];
            if (b3 > 0) {
                d[b3] = (byte) i;
            }
            i++;
        }
    }

    /* JADX WARN: Code duplicated, block: B:73:0x00f6 A[EDGE_INSN: B:73:0x00f6->B:55:0x00f6 BREAK  A[LOOP:0: B:3:0x000f->B:90:0x000f], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:92:0x000f A[SYNTHETIC] */
    private static int a(CharSequence charSequence, int i, int i2, StringBuilder sb, int i3) {
        StringBuilder sb2 = new StringBuilder(i2);
        int i4 = i3;
        int i5 = 0;
        while (true) {
            int i6 = i + i5;
            char cCharAt = charSequence.charAt(i6);
            if (i4 == 0) {
                if (b(cCharAt)) {
                    if (cCharAt == ' ') {
                        sb2.append((char) 26);
                    } else {
                        sb2.append((char) (cCharAt - 'A'));
                    }
                } else if (a(cCharAt)) {
                    sb2.append((char) 27);
                    i4 = 1;
                } else if (d(cCharAt)) {
                    sb2.append((char) 28);
                    i4 = 2;
                } else {
                    sb2.append((char) 29);
                    sb2.append((char) d[cCharAt]);
                }
                i5++;
                if (i5 >= i2) {
                    break;
                    break;
                }
            } else {
                if (i4 != 1) {
                    if (i4 != 2) {
                        if (e(cCharAt)) {
                            sb2.append((char) d[cCharAt]);
                        } else {
                            sb2.append((char) 29);
                            i4 = 0;
                        }
                    } else if (d(cCharAt)) {
                        sb2.append((char) c[cCharAt]);
                    } else if (b(cCharAt)) {
                        sb2.append((char) 28);
                        i4 = 0;
                    } else if (a(cCharAt)) {
                        sb2.append((char) 27);
                        i4 = 1;
                    } else {
                        int i7 = i6 + 1;
                        if (i7 < i2 && e(charSequence.charAt(i7))) {
                            sb2.append((char) 25);
                            i4 = 3;
                        } else {
                            sb2.append((char) 29);
                            sb2.append((char) d[cCharAt]);
                        }
                    }
                } else if (a(cCharAt)) {
                    if (cCharAt == ' ') {
                        sb2.append((char) 26);
                    } else {
                        sb2.append((char) (cCharAt - 'a'));
                    }
                } else if (b(cCharAt)) {
                    sb2.append((char) 27);
                    sb2.append((char) (cCharAt - 'A'));
                } else if (d(cCharAt)) {
                    sb2.append((char) 28);
                    i4 = 2;
                } else {
                    sb2.append((char) 29);
                    sb2.append((char) d[cCharAt]);
                }
                i5++;
                if (i5 >= i2) {
                    break;
                }
            }
        }
        int length = sb2.length();
        char cCharAt2 = 0;
        for (int i8 = 0; i8 < length; i8++) {
            if (i8 % 2 != 0) {
                cCharAt2 = (char) ((cCharAt2 * 30) + sb2.charAt(i8));
                sb.append(cCharAt2);
            } else {
                cCharAt2 = sb2.charAt(i8);
            }
        }
        if (length % 2 != 0) {
            sb.append((char) ((cCharAt2 * 30) + 29));
        }
        return i4;
    }

    private static void a(byte[] bArr, int i, int i2, int i3, StringBuilder sb) {
        int i4;
        if (i2 == 1 && i3 == 0) {
            sb.append((char) 913);
        } else if (i2 % 6 == 0) {
            sb.append((char) 924);
        } else {
            sb.append((char) 901);
        }
        if (i2 >= 6) {
            char[] cArr = new char[5];
            i4 = i;
            while ((i + i2) - i4 >= 6) {
                long j = 0;
                for (int i5 = 0; i5 < 6; i5++) {
                    j = (j << 8) + ((long) (bArr[i4 + i5] & 255));
                }
                for (int i6 = 0; i6 < 5; i6++) {
                    cArr[i6] = (char) (j % 900);
                    j /= 900;
                }
                for (int i7 = 4; i7 >= 0; i7--) {
                    sb.append(cArr[i7]);
                }
                i4 += 6;
            }
        } else {
            i4 = i;
        }
        while (i4 < i + i2) {
            sb.append((char) (bArr[i4] & 255));
            i4++;
        }
    }

    private static void a(String str, int i, int i2, StringBuilder sb) {
        StringBuilder sb2 = new StringBuilder((i2 / 3) + 1);
        BigInteger bigIntegerValueOf = BigInteger.valueOf(900L);
        BigInteger bigIntegerValueOf2 = BigInteger.valueOf(0L);
        int i3 = 0;
        while (i3 < i2) {
            sb2.setLength(0);
            int iMin = Math.min(44, i2 - i3);
            if (str.length() > 0) {
                int i4 = i + i3;
                BigInteger bigInteger = new BigInteger("1" + str.substring(i4, i4 + iMin));
                do {
                    sb2.append((char) bigInteger.mod(bigIntegerValueOf).intValue());
                    bigInteger = bigInteger.divide(bigIntegerValueOf);
                } while (!bigInteger.equals(bigIntegerValueOf2));
            }
            for (int length = sb2.length() - 1; length >= 0; length--) {
                sb.append(sb2.charAt(length));
            }
            i3 += iMin;
        }
    }

    private static int a(CharSequence charSequence, int i) {
        return m3.a(charSequence, i);
    }

    private static int a(String str, int i, Charset charset) throws WriterException {
        int i2;
        CharsetEncoder charsetEncoderNewEncoder = charset.newEncoder();
        int length = str.length();
        int i3 = i;
        while (i3 < length) {
            char cCharAt = str.charAt(i3);
            int i4 = 0;
            while (i4 < 13 && c(cCharAt) && (i2 = i3 + (i4 = i4 + 1)) < length) {
                cCharAt = str.charAt(i2);
            }
            if (i4 >= 13) {
                return i3 - i;
            }
            char cCharAt2 = str.charAt(i3);
            if (!charsetEncoderNewEncoder.canEncode(cCharAt2)) {
                throw new WriterException("Non-encodable character detected: " + cCharAt2 + " (Unicode: " + ((int) cCharAt2) + ')');
            }
            i3++;
        }
        return i3 - i;
    }

    private static void a(int i, StringBuilder sb) throws WriterException {
        if (i >= 0 && i < 900) {
            sb.append((char) 927);
            sb.append((char) i);
        } else if (i < 810900) {
            sb.append((char) 926);
            sb.append((char) ((i / 900) - 1));
            sb.append((char) (i % 900));
        } else {
            if (i < 811800) {
                sb.append((char) 925);
                sb.append((char) (810900 - i));
                return;
            }
            throw new WriterException("ECI number not in valid range from 0..811799, but was " + i);
        }
    }
}
