package com.ubix.ssp.ad.e.a0;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import kotlin.io.encoding.Base64;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class n {

    static /* synthetic */ class a {
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final int[] f8714a;
        private static final int[] b;
        static final b c;
        static final b d;
        static final b e;
        private final boolean f;
        private final boolean g;

        static {
            int[] iArr = new int[256];
            f8714a = iArr;
            Arrays.fill(iArr, -1);
            for (int i = 0; i < c.f8715a.length; i++) {
                f8714a[c.f8715a[i]] = i;
            }
            f8714a[61] = -2;
            int[] iArr2 = new int[256];
            b = iArr2;
            Arrays.fill(iArr2, -1);
            for (int i2 = 0; i2 < c.b.length; i2++) {
                b[c.b[i2]] = i2;
            }
            b[61] = -2;
            c = new b(false, false);
            d = new b(true, false);
            e = new b(false, true);
        }

        private b(boolean z, boolean z2) {
            this.f = z;
            this.g = z2;
        }

        private int a(byte[] bArr, int i, int i2) {
            int i3;
            int[] iArr = this.f ? b : f8714a;
            int i4 = i2 - i;
            int i5 = 0;
            if (i4 == 0) {
                return 0;
            }
            if (i4 < 2) {
                if (this.g && iArr[0] == -1) {
                    return 0;
                }
                throw new IllegalArgumentException("Input byte[] should at least have 2 bytes for base64 bytes");
            }
            if (this.g) {
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
        
            if (r4 != 18) goto L32;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private int a(byte[] bArr, int i, int i2, byte[] bArr2) {
            int[] iArr = this.f ? b : f8714a;
            int i3 = 18;
            int i4 = 0;
            int i5 = 0;
            while (i < i2) {
                int i6 = i + 1;
                int i7 = iArr[bArr[i] & 255];
                if (i7 >= 0) {
                    i4 |= i7 << i3;
                    i3 -= 6;
                    if (i3 < 0) {
                        bArr2[i5] = (byte) (i4 >> 16);
                        int i8 = i5 + 2;
                        bArr2[i5 + 1] = (byte) (i4 >> 8);
                        i5 += 3;
                        bArr2[i8] = (byte) i4;
                        i3 = 18;
                        i4 = 0;
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
                } else if (!this.g) {
                    throw new IllegalArgumentException("Illegal base64 character " + Integer.toString(bArr[i], 16));
                }
                i = i6;
            }
            if (i3 == 6) {
                bArr2[i5] = (byte) (i4 >> 16);
                i5++;
            } else if (i3 == 0) {
                int i9 = i5 + 1;
                bArr2[i5] = (byte) (i4 >> 16);
                i5 += 2;
                bArr2[i9] = (byte) (i4 >> 8);
            } else if (i3 == 12) {
                throw new IllegalArgumentException("Last unit does not have enough valid bits");
            }
            while (i < i2) {
                if (this.g) {
                    int i10 = i + 1;
                    if (iArr[bArr[i]] < 0) {
                        i = i10;
                    } else {
                        i = i10;
                    }
                }
                throw new IllegalArgumentException("Input byte array has incorrect ending byte at " + i);
            }
            return i5;
        }

        public byte[] a(String str) {
            return a(str.getBytes(StandardCharsets.ISO_8859_1));
        }

        public byte[] a(byte[] bArr) {
            int iA = a(bArr, 0, bArr.length);
            byte[] bArr2 = new byte[iA];
            int iA2 = a(bArr, 0, bArr.length, bArr2);
            return iA2 != iA ? Arrays.copyOf(bArr2, iA2) : bArr2;
        }
    }

    public static class c {
        private static final byte[] c;
        static final c f;
        private final byte[] g;
        private final int h;
        private final boolean i;
        private final boolean j;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final char[] f8715a = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', IOUtils.DIR_SEPARATOR_UNIX};
        private static final char[] b = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '-', '_'};
        static final c d = new c(false, null, -1, true);
        static final c e = new c(true, null, -1, true);

        static {
            byte[] bArr = {13, 10};
            c = bArr;
            f = new c(false, bArr, 76, true);
        }

        private c(boolean z, byte[] bArr, int i, boolean z2) {
            this.i = z;
            this.g = bArr;
            this.h = i;
            this.j = z2;
        }

        /* synthetic */ c(boolean z, byte[] bArr, int i, boolean z2, a aVar) {
            this(z, bArr, i, z2);
        }

        private final int a(int i) {
            int i2;
            if (this.j) {
                i2 = ((i + 2) / 3) * 4;
            } else {
                int i3 = i % 3;
                i2 = ((i / 3) * 4) + (i3 == 0 ? 0 : i3 + 1);
            }
            int i4 = this.h;
            return i4 > 0 ? i2 + (((i2 - 1) / i4) * this.g.length) : i2;
        }

        private int a(byte[] bArr, int i, int i2, byte[] bArr2) {
            int i3;
            char[] cArr = this.i ? b : f8715a;
            int i4 = ((i2 - i) / 3) * 3;
            int i5 = i + i4;
            int i6 = this.h;
            if (i6 > 0 && i4 > (i3 = (i6 / 4) * 3)) {
                i4 = i3;
            }
            int i7 = i;
            int i8 = 0;
            while (i7 < i5) {
                int iMin = Math.min(i7 + i4, i5);
                int i9 = i7;
                int i10 = i8;
                while (i9 < iMin) {
                    int i11 = i9 + 2;
                    int i12 = ((bArr[i9 + 1] & 255) << 8) | ((bArr[i9] & 255) << 16);
                    i9 += 3;
                    int i13 = i12 | (bArr[i11] & 255);
                    bArr2[i10] = (byte) cArr[(i13 >>> 18) & 63];
                    bArr2[i10 + 1] = (byte) cArr[(i13 >>> 12) & 63];
                    int i14 = i10 + 3;
                    bArr2[i10 + 2] = (byte) cArr[(i13 >>> 6) & 63];
                    i10 += 4;
                    bArr2[i14] = (byte) cArr[i13 & 63];
                }
                int i15 = ((iMin - i7) / 3) * 4;
                i8 += i15;
                if (i15 == this.h && iMin < i2) {
                    byte[] bArr3 = this.g;
                    int length = bArr3.length;
                    int i16 = 0;
                    while (i16 < length) {
                        bArr2[i8] = bArr3[i16];
                        i16++;
                        i8++;
                    }
                }
                i7 = iMin;
            }
            if (i7 >= i2) {
                return i8;
            }
            int i17 = i7 + 1;
            int i18 = bArr[i7] & 255;
            int i19 = i8 + 1;
            bArr2[i8] = (byte) cArr[i18 >> 2];
            if (i17 == i2) {
                int i20 = i8 + 2;
                bArr2[i19] = (byte) cArr[(i18 << 4) & 63];
                if (!this.j) {
                    return i20;
                }
                int i21 = i8 + 3;
                bArr2[i20] = Base64.padSymbol;
                int i22 = i8 + 4;
                bArr2[i21] = Base64.padSymbol;
                return i22;
            }
            int i23 = bArr[i17] & 255;
            bArr2[i19] = (byte) cArr[((i18 << 4) & 63) | (i23 >> 4)];
            int i24 = i8 + 3;
            bArr2[i8 + 2] = (byte) cArr[(i23 << 2) & 63];
            if (!this.j) {
                return i24;
            }
            int i25 = i8 + 4;
            bArr2[i24] = Base64.padSymbol;
            return i25;
        }

        public byte[] a(byte[] bArr) {
            int iA = a(bArr.length);
            byte[] bArr2 = new byte[iA];
            int iA2 = a(bArr, 0, bArr.length, bArr2);
            return iA2 != iA ? Arrays.copyOf(bArr2, iA2) : bArr2;
        }

        public String b(byte[] bArr) {
            byte[] bArrA = a(bArr);
            return new String(bArrA, 0, 0, bArrA.length);
        }
    }

    private n() {
    }

    public static b a() {
        return b.c;
    }

    public static c b() {
        return c.d;
    }
}
