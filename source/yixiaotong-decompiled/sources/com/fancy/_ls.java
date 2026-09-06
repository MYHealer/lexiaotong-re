package com.fancy;

import java.nio.charset.Charset;
import java.util.Arrays;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _ls {
    public static final char[] _a = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', IOUtils.DIR_SEPARATOR_UNIX};
    public static final char[] _b = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '-', '_'};
    public static final int[] _c;
    public static final int[] _d;
    public static final _ls _e;

    static {
        int[] iArr = new int[256];
        _c = iArr;
        Arrays.fill(iArr, -1);
        int i = 0;
        int i2 = 0;
        while (true) {
            char[] cArr = _a;
            if (i2 >= 64) {
                break;
            }
            _c[cArr[i2]] = i2;
            i2++;
        }
        _c[61] = -2;
        int[] iArr2 = new int[256];
        _d = iArr2;
        Arrays.fill(iArr2, -1);
        while (true) {
            char[] cArr2 = _b;
            if (i >= 64) {
                _d[61] = -2;
                _e = new _ls();
                return;
            } else {
                _d[cArr2[i]] = i;
                i++;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x005d, code lost:
    
        if (r9 != 18) goto L42;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] _a(String str) {
        int i;
        int i2;
        byte[] bytes = str.getBytes(Charset.forName("ISO-8859-1"));
        int length = bytes.length;
        if (length == 0) {
            i = 0;
        } else {
            int i3 = 2;
            if (length < 2) {
                throw new IllegalArgumentException("Input byte[] should at least have 2 bytes for base64 bytes");
            }
            if (bytes[length - 1] != 61) {
                i3 = 0;
            } else if (bytes[length - 2] != 61) {
                i3 = 1;
            }
            if (i3 == 0 && (i2 = length & 3) != 0) {
                i3 = 4 - i2;
            }
            i = (((length + 3) / 4) * 3) - i3;
        }
        byte[] bArr = new byte[i];
        int length2 = bytes.length;
        int[] iArr = _c;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 18;
        while (i4 < length2) {
            int i8 = i4 + 1;
            int i9 = iArr[bytes[i4] & 255];
            if (i9 >= 0) {
                i5 |= i9 << i7;
                i7 -= 6;
                if (i7 < 0) {
                    bArr[i6] = (byte) (i5 >> 16);
                    int i10 = i6 + 2;
                    bArr[i6 + 1] = (byte) (i5 >> 8);
                    i6 += 3;
                    bArr[i10] = (byte) i5;
                    i5 = 0;
                    i7 = 18;
                }
                i4 = i8;
            } else {
                if (i9 != -2) {
                    throw new IllegalArgumentException(_ie._a("Illegal base64 character ").append(Integer.toString(bytes[i4], 16)).toString());
                }
                if (i7 == 6) {
                    if (i8 != length2) {
                        i4 += 2;
                        if (bytes[i8] == 61) {
                            break;
                        }
                    }
                    throw new IllegalArgumentException("Input byte array has wrong 4-byte ending unit");
                }
                i4 = i8;
            }
        }
        if (i7 == 6) {
            bArr[i6] = (byte) (i5 >> 16);
            i6++;
        } else if (i7 == 0) {
            int i11 = i6 + 1;
            bArr[i6] = (byte) (i5 >> 16);
            i6 += 2;
            bArr[i11] = (byte) (i5 >> 8);
        } else if (i7 == 12) {
            throw new IllegalArgumentException("Last unit does not have enough valid bits");
        }
        if (i4 >= length2) {
            return i6 != i ? Arrays.copyOf(bArr, i6) : bArr;
        }
        throw new IllegalArgumentException("Input byte array has incorrect ending byte at " + i4);
    }
}
