package com.huawei.hms.scankit.p;

import com.google.zxing.common.StringUtils;
import java.nio.charset.Charset;
import java.util.Map;

/* JADX INFO: compiled from: StringUtils.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class f6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f4249a;
    private static final boolean b;

    static {
        String strName = Charset.defaultCharset().name();
        f4249a = strName;
        b = StringUtils.SHIFT_JIS.equalsIgnoreCase(strName) || "EUC_JP".equalsIgnoreCase(strName);
    }

    public static String a(byte[] bArr, Map<f1, ?> map) {
        int i;
        if (map != null) {
            f1 f1Var = f1.CHARACTER_SET;
            if (map.containsKey(f1Var)) {
                return map.get(f1Var).toString();
            }
        }
        int[] iArr = new int[15];
        iArr[0] = bArr.length;
        iArr[1] = 1;
        iArr[2] = 1;
        iArr[3] = 1;
        boolean z = bArr.length > 3 && bArr[0] == -17 && bArr[1] == -69 && bArr[2] == -65;
        int i2 = 0;
        while (true) {
            i = iArr[0];
            if (i2 >= i || !(iArr[1] == 1 || iArr[2] == 1 || iArr[3] == 1)) {
                break;
            }
            int i3 = bArr[i2] & 255;
            c(i3, iArr);
            b(i3, iArr);
            a(i3, iArr);
            i2++;
        }
        return a(bArr, iArr[3] == 1, iArr[2] == 1, iArr[1] == 1, iArr[4], iArr[8], z, iArr[5], iArr[6], iArr[7], iArr[12], iArr[13], iArr[9], iArr[14], i);
    }

    private static void b(int i, int[] iArr) {
        if (iArr[2] == 1) {
            int i2 = iArr[8];
            if (i2 > 0) {
                if (i < 64 || i == 127 || i > 252) {
                    iArr[2] = 0;
                    return;
                } else {
                    iArr[8] = i2 - 1;
                    return;
                }
            }
            if (i == 128 || i == 160 || i > 239) {
                iArr[2] = 0;
                return;
            }
            if (i > 160 && i < 224) {
                iArr[9] = iArr[9] + 1;
                iArr[11] = 0;
                int i3 = iArr[10] + 1;
                iArr[10] = i3;
                if (i3 > iArr[12]) {
                    iArr[12] = i3;
                    return;
                }
                return;
            }
            if (i <= 127) {
                iArr[10] = 0;
                iArr[11] = 0;
                return;
            }
            iArr[8] = i2 + 1;
            iArr[10] = 0;
            int i4 = iArr[11] + 1;
            iArr[11] = i4;
            if (i4 > iArr[13]) {
                iArr[13] = i4;
            }
        }
    }

    private static void c(int i, int[] iArr) {
        if (iArr[3] == 1) {
            int i2 = iArr[4];
            if (i2 > 0) {
                if ((i & 128) == 0) {
                    iArr[3] = 0;
                    return;
                } else {
                    iArr[4] = i2 - 1;
                    return;
                }
            }
            if ((i & 128) != 0) {
                if ((i & 64) == 0) {
                    iArr[3] = 0;
                    return;
                }
                iArr[4] = i2 + 1;
                if ((i & 32) == 0) {
                    iArr[5] = iArr[5] + 1;
                    return;
                }
                iArr[4] = i2 + 2;
                if ((i & 16) == 0) {
                    iArr[6] = iArr[6] + 1;
                    return;
                }
                iArr[4] = i2 + 3;
                if ((i & 8) == 0) {
                    iArr[7] = iArr[7] + 1;
                } else {
                    iArr[3] = 0;
                }
            }
        }
    }

    private static void a(int i, int[] iArr) {
        if (iArr[1] == 1) {
            if (i > 127 && i < 160) {
                iArr[1] = 0;
                return;
            }
            if (i > 159) {
                if (i < 192 || i == 215 || i == 247) {
                    iArr[14] = iArr[14] + 1;
                }
            }
        }
    }

    public static String a(byte[] bArr, boolean z, boolean z2, boolean z3, int i, int i2, boolean z4, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        if (z && i > 0) {
            z = false;
        }
        if (z2 && i2 > 0) {
            z2 = false;
        }
        if (z && (z4 || i3 + i4 + i5 > 0)) {
            return "UTF8";
        }
        if (a(bArr).booleanValue()) {
            return "GBK";
        }
        if (z2 && (b || i6 >= 3 || i7 >= 3)) {
            return StringUtils.SHIFT_JIS;
        }
        if (z3 && z2) {
            return (!(i6 == 2 && i8 == 2) && i9 * 10 < i10) ? "ISO8859_1" : StringUtils.SHIFT_JIS;
        }
        if (z3 && i9 * 10 < i10) {
            return "ISO8859_1";
        }
        if (z2) {
            return StringUtils.SHIFT_JIS;
        }
        if (z) {
            return "UTF8";
        }
        return (z || !"UTF-8".equals(f4249a)) ? f4249a : StringUtils.GB2312;
    }

    public static Boolean a(byte[] bArr) {
        int length = bArr.length;
        boolean z = false;
        int i = 0;
        while (i < length) {
            byte b2 = bArr[i];
            if ((b2 & 128) != 0) {
                int i2 = b2 & 255;
                if ((i2 < 170 && i2 > 160) || (i2 < 248 && i2 > 175)) {
                    i++;
                    if (i < length) {
                        byte b3 = bArr[i];
                        if ((b3 & 255) >= 255 || (b3 & 255) <= 160 || (b3 & 255) == 127) {
                        }
                    }
                    return Boolean.valueOf(z);
                }
                if (i2 >= 161 || i2 <= 128) {
                    if (((i2 < 255 && i2 > 169) || (i2 < 170 && i2 > 167)) && (i = i + 1) < length) {
                        byte b4 = bArr[i];
                        if ((b4 & 255) >= 161 || (b4 & 255) <= 63 || (b4 & 255) == 127) {
                        }
                    }
                    return Boolean.valueOf(z);
                }
                i++;
                if (i < length) {
                    byte b5 = bArr[i];
                    if ((b5 & 255) >= 255 || (b5 & 255) <= 63 || (b5 & 255) == 127) {
                    }
                }
                return Boolean.valueOf(z);
            }
            i++;
        }
        z = true;
        return Boolean.valueOf(z);
    }
}
