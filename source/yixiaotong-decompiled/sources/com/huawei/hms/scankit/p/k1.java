package com.huawei.hms.scankit.p;

import com.google.zxing.common.StringUtils;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: DecodedBitStreamParser.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
final class k1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f4290a = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ $%*+-./:".toCharArray();

    /* JADX INFO: compiled from: DecodedBitStreamParser.java */
    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f4291a;

        static {
            int[] iArr = new int[d4.values().length];
            f4291a = iArr;
            try {
                iArr[d4.NUMERIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4291a[d4.ALPHANUMERIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4291a[d4.BYTE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f4291a[d4.KANJI.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f4291a[d4.TERMINATOR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f4291a[d4.FNC1_FIRST_POSITION.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f4291a[d4.FNC1_SECOND_POSITION.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f4291a[d4.STRUCTURED_APPEND.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f4291a[d4.ECI.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f4291a[d4.HANZI.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    static o1 a(byte[] bArr, c7 c7Var, r2 r2Var, Map<f1, ?> map) throws com.huawei.hms.scankit.p.a {
        int i;
        int i2;
        v vVar = new v(bArr);
        StringBuilder sb = new StringBuilder(50);
        ArrayList arrayList = new ArrayList(1);
        int i3 = -1;
        int i4 = -1;
        int i5 = 0;
        while (true) {
            try {
                d4 d4VarA = vVar.a() < 4 ? d4.TERMINATOR : d4.a(vVar.a(4));
                int[] iArr = {i5, i3, i4};
                a(d4VarA, vVar, sb, c7Var, iArr, null, arrayList, map);
                i5 = iArr[0] == 1 ? 1 : 0;
                i = iArr[1];
                i2 = iArr[2];
                if (d4VarA == d4.TERMINATOR) {
                    break;
                }
                i3 = i;
                i4 = i2;
            } catch (IllegalArgumentException unused) {
                throw com.huawei.hms.scankit.p.a.a();
            }
        }
        return new o1(bArr, sb.toString(), arrayList.isEmpty() ? null : arrayList, r2Var == null ? null : r2Var.toString(), i, i2);
    }

    private static void b(v vVar, StringBuilder sb, int i) throws com.huawei.hms.scankit.p.a {
        if (i * 13 > vVar.a()) {
            throw com.huawei.hms.scankit.p.a.a();
        }
        byte[] bArr = new byte[i * 2];
        int i2 = 0;
        while (i > 0) {
            int iA = vVar.a(13);
            int i3 = (iA % 192) | ((iA / 192) << 8);
            int i4 = i3 + (i3 < 7936 ? 33088 : 49472);
            if (y6.a(bArr, i2)) {
                int i5 = i2 + 1;
                if (y6.a(bArr, i5)) {
                    bArr[i2] = (byte) (i4 >> 8);
                    bArr[i5] = (byte) i4;
                    i2 += 2;
                    i--;
                }
            }
            throw new ArrayIndexOutOfBoundsException();
        }
        try {
            sb.append(new String(bArr, StringUtils.SHIFT_JIS));
        } catch (UnsupportedEncodingException unused) {
            throw com.huawei.hms.scankit.p.a.a();
        }
    }

    private static void c(v vVar, StringBuilder sb, int i) throws com.huawei.hms.scankit.p.a {
        while (i >= 3) {
            if (vVar.a() < 10) {
                throw com.huawei.hms.scankit.p.a.a();
            }
            int iA = vVar.a(10);
            if (iA >= 1000) {
                throw com.huawei.hms.scankit.p.a.a();
            }
            sb.append(a(iA / 100));
            sb.append(a((iA / 10) % 10));
            sb.append(a(iA % 10));
            i -= 3;
        }
        if (i == 2) {
            if (vVar.a() < 7) {
                throw com.huawei.hms.scankit.p.a.a();
            }
            int iA2 = vVar.a(7);
            if (iA2 >= 100) {
                throw com.huawei.hms.scankit.p.a.a();
            }
            sb.append(a(iA2 / 10));
            sb.append(a(iA2 % 10));
            return;
        }
        if (i == 1) {
            if (vVar.a() < 4) {
                throw com.huawei.hms.scankit.p.a.a();
            }
            int iA3 = vVar.a(4);
            if (iA3 >= 10) {
                throw com.huawei.hms.scankit.p.a.a();
            }
            sb.append(a(iA3));
        }
    }

    private static void a(d4 d4Var, v vVar, StringBuilder sb, c7 c7Var, int[] iArr, l0 l0Var, List<byte[]> list, Map<f1, ?> map) throws com.huawei.hms.scankit.p.a {
        int[] iArr2 = a.f4291a;
        switch (iArr2[d4Var.ordinal()]) {
            case 5:
                return;
            case 6:
            case 7:
                iArr[0] = 1;
                return;
            case 8:
                if (vVar.a() >= 16) {
                    iArr[1] = vVar.a(8);
                    iArr[2] = vVar.a(8);
                    return;
                }
                throw com.huawei.hms.scankit.p.a.a();
            case 9:
                if (l0.a(a(vVar)) == null) {
                    throw com.huawei.hms.scankit.p.a.a();
                }
                return;
            case 10:
                int iA = vVar.a(4);
                int iA2 = vVar.a(d4Var.a(c7Var));
                if (iA == 1) {
                    a(vVar, sb, iA2);
                    return;
                }
                return;
            default:
                int iA3 = vVar.a(d4Var.a(c7Var));
                int i = iArr2[d4Var.ordinal()];
                if (i == 1) {
                    c(vVar, sb, iA3);
                    return;
                }
                if (i == 2) {
                    a(vVar, sb, iA3, iArr[0] == 1);
                    return;
                } else if (i == 3) {
                    a(vVar, sb, iA3, l0Var, list, map);
                    return;
                } else {
                    if (i != 4) {
                        throw com.huawei.hms.scankit.p.a.a();
                    }
                    b(vVar, sb, iA3);
                    return;
                }
        }
    }

    private static void a(v vVar, StringBuilder sb, int i) throws com.huawei.hms.scankit.p.a {
        if (i * 13 <= vVar.a()) {
            byte[] bArr = new byte[i * 2];
            int i2 = 0;
            while (i > 0) {
                int iA = vVar.a(13);
                int i3 = (iA % 96) | ((iA / 96) << 8);
                int i4 = i3 + (i3 < 959 ? 41377 : 42657);
                if (y6.a(bArr, i2)) {
                    int i5 = i2 + 1;
                    if (y6.a(bArr, i5)) {
                        bArr[i2] = (byte) ((i4 >> 8) & 255);
                        bArr[i5] = (byte) (i4 & 255);
                        i2 += 2;
                        i--;
                    }
                }
                throw new ArrayIndexOutOfBoundsException();
            }
            try {
                sb.append(new String(bArr, StringUtils.GB2312));
                return;
            } catch (UnsupportedEncodingException unused) {
                throw com.huawei.hms.scankit.p.a.a();
            }
        }
        throw com.huawei.hms.scankit.p.a.a();
    }

    private static void a(v vVar, StringBuilder sb, int i, l0 l0Var, Collection<byte[]> collection, Map<f1, ?> map) throws com.huawei.hms.scankit.p.a {
        String strName;
        if (i * 8 <= vVar.a()) {
            byte[] bArr = new byte[i];
            for (int i2 = 0; i2 < i; i2++) {
                bArr[i2] = (byte) vVar.a(8);
            }
            if (l0Var == null) {
                strName = f6.a(bArr, map);
            } else {
                strName = l0Var.name();
            }
            try {
                sb.append(new String(bArr, strName));
                collection.add(bArr);
                return;
            } catch (UnsupportedEncodingException unused) {
                throw com.huawei.hms.scankit.p.a.a();
            }
        }
        throw com.huawei.hms.scankit.p.a.a();
    }

    private static char a(int i) throws com.huawei.hms.scankit.p.a {
        char[] cArr = f4290a;
        if (i < cArr.length) {
            return cArr[i];
        }
        throw com.huawei.hms.scankit.p.a.a();
    }

    /* JADX WARN: Code duplicated, block: B:26:0x006a  */
    private static void a(v vVar, StringBuilder sb, int i, boolean z) throws com.huawei.hms.scankit.p.a {
        while (i > 1) {
            if (vVar.a() >= 11) {
                int iA = vVar.a(11);
                sb.append(a(iA / 45));
                sb.append(a(iA % 45));
                i -= 2;
            } else {
                throw com.huawei.hms.scankit.p.a.a();
            }
        }
        if (i == 1) {
            if (vVar.a() >= 6) {
                sb.append(a(vVar.a(6)));
            } else {
                throw com.huawei.hms.scankit.p.a.a();
            }
        }
        if (z) {
            for (int length = sb.length(); length < sb.length(); length++) {
                if (sb.charAt(length) == '%') {
                    if (length < sb.length() - 1) {
                        int i2 = length + 1;
                        if (sb.charAt(i2) == '%') {
                            sb.deleteCharAt(i2);
                        } else {
                            sb.setCharAt(length, (char) 29);
                        }
                    } else {
                        sb.setCharAt(length, (char) 29);
                    }
                }
            }
        }
    }

    private static int a(v vVar) throws com.huawei.hms.scankit.p.a {
        int iA = vVar.a(8);
        if ((iA & 128) == 0) {
            return iA & 127;
        }
        if ((iA & 192) == 128) {
            return vVar.a(8) | ((iA & 63) << 8);
        }
        if ((iA & 224) == 192) {
            return vVar.a(16) | ((iA & 31) << 16);
        }
        throw com.huawei.hms.scankit.p.a.a();
    }
}
