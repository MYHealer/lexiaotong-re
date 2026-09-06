package com.huawei.hms.scankit.p;

import com.huawei.hms.hmsscankit.WriterException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: Encoder.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class m2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f4308a = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, 37, 38, -1, -1, -1, -1, 39, 40, -1, 41, 42, 43, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 44, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, -1, -1, -1, -1, -1};

    /* JADX INFO: compiled from: Encoder.java */
    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f4309a;

        static {
            int[] iArr = new int[d4.values().length];
            f4309a = iArr;
            try {
                iArr[d4.NUMERIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4309a[d4.ALPHANUMERIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4309a[d4.BYTE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f4309a[d4.KANJI.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private static int a(a0 a0Var) {
        return a4.a(a0Var) + a4.b(a0Var) + a4.c(a0Var) + a4.d(a0Var);
    }

    static void b(CharSequence charSequence, r rVar) {
        int length = charSequence.length();
        int i = 0;
        while (i < length) {
            int iCharAt = charSequence.charAt(i) - '0';
            int i2 = i + 2;
            if (i2 < length) {
                rVar.a((iCharAt * 100) + ((charSequence.charAt(i + 1) - '0') * 10) + (charSequence.charAt(i2) - '0'), 10);
                i += 3;
            } else {
                i++;
                if (i < length) {
                    rVar.a((iCharAt * 10) + (charSequence.charAt(i) - '0'), 7);
                    i = i2;
                } else {
                    rVar.a(iCharAt, 4);
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:31:0x008f  */
    public static m5 a(String str, r2 r2Var, Map<k2, ?> map) throws WriterException {
        c7 c7VarA;
        l0 l0VarA;
        boolean z = map != null && map.containsKey(k2.CHARACTER_SET);
        String string = z ? map.get(k2.CHARACTER_SET).toString() : "ISO-8859-1";
        d4 d4VarA = a(str, string);
        r rVar = new r();
        d4 d4Var = d4.BYTE;
        if (d4VarA == d4Var && z && (l0VarA = l0.a(string)) != null) {
            a(l0VarA, rVar);
        }
        if (map != null && map.containsKey(k2.GS1_FORMAT) && Boolean.valueOf(map.get(k2.GS1_FORMAT).toString()).booleanValue()) {
            a(d4.FNC1_FIRST_POSITION, rVar);
        }
        a(d4VarA, rVar);
        r rVar2 = new r();
        a(str, d4VarA, rVar2, string);
        if (map != null) {
            k2 k2Var = k2.QR_VERSION;
            if (map.containsKey(k2Var)) {
                c7VarA = c7.c(Integer.parseInt(map.get(k2Var).toString()));
                if (!a(a(d4VarA, rVar, rVar2, c7VarA), c7VarA, r2Var)) {
                    throw new WriterException("Data too big for requested version");
                }
            } else {
                c7VarA = a(r2Var, d4VarA, rVar, rVar2);
            }
        } else {
            c7VarA = a(r2Var, d4VarA, rVar, rVar2);
        }
        r rVar3 = new r();
        rVar3.a(rVar);
        a(d4VarA == d4Var ? rVar2.f() : str.length(), c7VarA, d4VarA, rVar3);
        rVar3.a(rVar2);
        c7.b bVarA = c7VarA.a(r2Var);
        int iE = c7VarA.e() - bVarA.d();
        a(iE, rVar3);
        r rVarA = a(rVar3, c7VarA.e(), iE, bVarA.c());
        m5 m5Var = new m5();
        m5Var.a(r2Var);
        m5Var.a(d4VarA);
        m5Var.a(c7VarA);
        int iD = c7VarA.d();
        a0 a0Var = new a0(iD, iD);
        int iA = a(rVarA, r2Var, c7VarA, a0Var);
        m5Var.b(iA);
        c4.a(rVarA, r2Var, c7VarA, iA, a0Var);
        m5Var.a(a0Var);
        return m5Var;
    }

    private static c7 a(r2 r2Var, d4 d4Var, r rVar, r rVar2) throws WriterException {
        return a(a(d4Var, rVar, rVar2, a(a(d4Var, rVar, rVar2, c7.c(1)), r2Var)), r2Var);
    }

    private static int a(d4 d4Var, r rVar, r rVar2, c7 c7Var) {
        return rVar.e() + d4Var.a(c7Var) + rVar2.e();
    }

    static int a(int i) {
        int[] iArr = f4308a;
        if (i < iArr.length) {
            return iArr[i];
        }
        return -1;
    }

    private static d4 a(String str, String str2) {
        if ("Shift_JIS".equals(str2) && a(str)) {
            return d4.KANJI;
        }
        boolean z = false;
        boolean z2 = false;
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt >= '0' && cCharAt <= '9') {
                z2 = true;
            } else {
                if (a(cCharAt) == -1) {
                    return d4.BYTE;
                }
                z = true;
            }
        }
        if (z) {
            return d4.ALPHANUMERIC;
        }
        if (z2) {
            return d4.NUMERIC;
        }
        return d4.BYTE;
    }

    private static boolean a(String str) {
        try {
            byte[] bytes = str.getBytes("Shift_JIS");
            int length = bytes.length;
            if (length % 2 != 0) {
                return false;
            }
            for (int i = 0; i < length; i += 2) {
                int i2 = bytes[i] & 255;
                if ((i2 < 129 || i2 > 159) && (i2 < 224 || i2 > 235)) {
                    return false;
                }
            }
            return true;
        } catch (UnsupportedEncodingException unused) {
            return false;
        }
    }

    private static int a(r rVar, r2 r2Var, c7 c7Var, a0 a0Var) throws WriterException {
        int i = Integer.MAX_VALUE;
        int i2 = -1;
        for (int i3 = 0; i3 < 8; i3++) {
            c4.a(rVar, r2Var, c7Var, i3, a0Var);
            int iA = a(a0Var);
            if (iA < i) {
                i2 = i3;
                i = iA;
            }
        }
        return i2;
    }

    private static c7 a(int i, r2 r2Var) throws WriterException {
        for (int i2 = 1; i2 <= 40; i2++) {
            c7 c7VarC = c7.c(i2);
            if (a(i, c7VarC, r2Var)) {
                return c7VarC;
            }
        }
        throw new WriterException("Data too big");
    }

    private static boolean a(int i, c7 c7Var, r2 r2Var) {
        return c7Var.e() - c7Var.a(r2Var).d() >= (i + 7) / 8;
    }

    static void a(int i, r rVar) throws WriterException {
        int i2 = i * 8;
        if (rVar.e() <= i2) {
            for (int i3 = 0; i3 < 4 && rVar.e() < i2; i3++) {
                rVar.a(false);
            }
            int iE = rVar.e() & 7;
            if (iE > 0) {
                while (iE < 8) {
                    rVar.a(false);
                    iE++;
                }
            }
            int iF = i - rVar.f();
            for (int i4 = 0; i4 < iF; i4++) {
                rVar.a((i4 & 1) == 0 ? 236 : 17, 8);
            }
            if (rVar.e() != i2) {
                throw new WriterException("Bits size does not equal capacity");
            }
            return;
        }
        throw new WriterException("data bits cannot fit in the QR Code" + rVar.e() + " > " + i2);
    }

    static void a(int i, int i2, int i3, int i4, int[] iArr, int[] iArr2) throws WriterException {
        if (i4 < i3) {
            int i5 = i % i3;
            int i6 = i3 - i5;
            int i7 = i / i3;
            int i8 = i7 + 1;
            int i9 = i2 / i3;
            int i10 = i9 + 1;
            int i11 = i7 - i9;
            int i12 = i8 - i10;
            if (i11 != i12) {
                throw new WriterException("EC bytes mismatch");
            }
            if (i3 != i6 + i5) {
                throw new WriterException("RS blocks mismatch");
            }
            if (i != ((i9 + i11) * i6) + ((i10 + i12) * i5)) {
                throw new WriterException("Total bytes mismatch");
            }
            if (i4 < i6) {
                iArr[0] = i9;
                iArr2[0] = i11;
                return;
            } else {
                iArr[0] = i10;
                iArr2[0] = i12;
                return;
            }
        }
        throw new WriterException("Block ID too large");
    }

    static r a(r rVar, int i, int i2, int i3) throws WriterException {
        if (rVar.f() == i2) {
            ArrayList arrayList = new ArrayList(i3);
            int i4 = 0;
            int iMax = 0;
            int iMax2 = 0;
            for (int i5 = 0; i5 < i3; i5++) {
                int[] iArr = new int[1];
                int[] iArr2 = new int[1];
                a(i, i2, i3, i5, iArr, iArr2);
                int i6 = iArr[0];
                byte[] bArr = new byte[i6];
                rVar.a(i4 * 8, bArr, 0, i6);
                byte[] bArrA = a(bArr, iArr2[0]);
                arrayList.add(new x(bArr, bArrA));
                iMax2 = Math.max(iMax2, i6);
                iMax = Math.max(iMax, bArrA.length);
                i4 += iArr[0];
            }
            if (i2 == i4) {
                r rVar2 = new r();
                for (int i7 = 0; i7 < iMax2; i7++) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        byte[] bArrA2 = ((x) it.next()).a();
                        if (i7 < bArrA2.length) {
                            rVar2.a(bArrA2[i7], 8);
                        }
                    }
                }
                for (int i8 = 0; i8 < iMax; i8++) {
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        byte[] bArrB = ((x) it2.next()).b();
                        if (i8 < bArrB.length) {
                            rVar2.a(bArrB[i8], 8);
                        }
                    }
                }
                if (i == rVar2.f()) {
                    return rVar2;
                }
                throw new WriterException("Interleaving error: " + i + " and " + rVar2.f() + " differ.");
            }
            throw new WriterException("Data bytes does not match offset");
        }
        throw new WriterException("Number of bits and data bytes does not match");
    }

    static byte[] a(byte[] bArr, int i) {
        int length = bArr.length;
        int[] iArr = new int[length + i];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = bArr[i2] & 255;
        }
        new u5(y2.l).a(iArr, i);
        byte[] bArr2 = new byte[i];
        for (int i3 = 0; i3 < i; i3++) {
            bArr2[i3] = (byte) iArr[length + i3];
        }
        return bArr2;
    }

    static void a(d4 d4Var, r rVar) {
        rVar.a(d4Var.a(), 4);
    }

    static void a(int i, c7 c7Var, d4 d4Var, r rVar) throws WriterException {
        int iA = d4Var.a(c7Var);
        int i2 = 1 << iA;
        if (i < i2) {
            rVar.a(i, iA);
            return;
        }
        throw new WriterException(i + " is bigger than " + (i2 - 1));
    }

    static void a(String str, d4 d4Var, r rVar, String str2) throws WriterException {
        int i = a.f4309a[d4Var.ordinal()];
        if (i == 1) {
            b(str, rVar);
            return;
        }
        if (i == 2) {
            a((CharSequence) str, rVar);
        } else if (i == 3) {
            a(str, rVar, str2);
        } else {
            if (i != 4) {
                throw new WriterException("Invalid mode: " + d4Var);
            }
            a(str, rVar);
        }
    }

    static void a(CharSequence charSequence, r rVar) throws WriterException {
        int length = charSequence.length();
        int i = 0;
        while (i < length) {
            int iA = a(charSequence.charAt(i));
            if (iA == -1) {
                throw new WriterException();
            }
            int i2 = i + 1;
            if (i2 < length) {
                int iA2 = a(charSequence.charAt(i2));
                if (iA2 != -1) {
                    rVar.a((iA * 45) + iA2, 11);
                    i += 2;
                } else {
                    throw new WriterException();
                }
            } else {
                rVar.a(iA, 6);
                i = i2;
            }
        }
    }

    static void a(String str, r rVar, String str2) throws WriterException {
        try {
            for (byte b : str.getBytes(str2)) {
                rVar.a(b, 8);
            }
        } catch (UnsupportedEncodingException e) {
            throw new WriterException(e);
        }
    }

    static void a(String str, r rVar) throws WriterException {
        int i;
        try {
            byte[] bytes = str.getBytes("Shift_JIS");
            int length = bytes.length;
            for (int i2 = 0; i2 < length; i2 += 2) {
                int i3 = ((bytes[i2] & 255) << 8) | (bytes[i2 + 1] & 255);
                int i4 = 33088;
                if (i3 >= 33088 && i3 <= 40956) {
                    i = i3 - i4;
                } else if (i3 < 57408 || i3 > 60351) {
                    i = -1;
                } else {
                    i4 = 49472;
                    i = i3 - i4;
                }
                if (i != -1) {
                    rVar.a(((i >> 8) * 192) + (i & 255), 13);
                } else {
                    throw new WriterException("Invalid byte sequence");
                }
            }
        } catch (UnsupportedEncodingException e) {
            throw new WriterException(e);
        }
    }

    private static void a(l0 l0Var, r rVar) {
        rVar.a(d4.ECI.a(), 4);
        rVar.a(l0Var.a(), 8);
    }
}
