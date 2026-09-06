package com.huawei.hms.scankit.p;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.cdo.oaps.ad.OapsKey;
import com.huawei.hms.ads.ContentClassification;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.j256.ormlite.stmt.query.SimpleComparison;
import com.umeng.analytics.pro.am;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Map;
import org.apache.commons.io.IOUtils;

/* JADX INFO: compiled from: Decoder.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class l1 {
    private static final String[] b = {"CTRL_PS", PPSLabelView.Code, "A", "B", "C", "D", ExifInterface.LONGITUDE_EAST, "F", "G", "H", "I", ContentClassification.AD_CONTENT_CLASSIFICATION_J, "K", "L", "M", "N", "O", "P", "Q", "R", ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_DIRECTION_TRUE, "U", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "W", "X", "Y", "Z", "CTRL_LL", "CTRL_ML", "CTRL_DL", "CTRL_BS"};
    private static final String[] c = {"CTRL_PS", PPSLabelView.Code, "a", com.kuaishou.weapon.p0.t.l, "c", com.kuaishou.weapon.p0.t.t, "e", "f", OapsKey.KEY_GRADE, IAdInterListener.AdReqParam.HEIGHT, "i", "j", com.kuaishou.weapon.p0.t.f4727a, com.kuaishou.weapon.p0.t.d, "m", "n", "o", "p", "q", com.kuaishou.weapon.p0.t.k, "s", "t", "u", "v", IAdInterListener.AdReqParam.WIDTH, "x", "y", am.aD, "CTRL_US", "CTRL_ML", "CTRL_DL", "CTRL_BS"};
    private static final String[] d = {"CTRL_PS", PPSLabelView.Code, "\u0001", "\u0002", "\u0003", "\u0004", "\u0005", "\u0006", "\u0007", "\b", "\t", IOUtils.LINE_SEPARATOR_UNIX, "\u000b", "\f", "\r", "\u001b", "\u001c", "\u001d", "\u001e", "\u001f", "@", "\\", "^", "_", "`", "|", "~", "\u007f", "CTRL_LL", "CTRL_UL", "CTRL_PL", "CTRL_BS"};
    private static final String[] e = {"", "\r", IOUtils.LINE_SEPARATOR_WINDOWS, ". ", ", ", ": ", "!", "\"", "#", "$", "%", "&", "'", "(", ")", "*", "+", ",", com.huawei.openalliance.ad.constant.x.A, ".", "/", com.huawei.openalliance.ad.constant.x.bQ, ";", SimpleComparison.LESS_THAN_OPERATION, "=", SimpleComparison.GREATER_THAN_OPERATION, "?", "[", "]", "{", com.alipay.sdk.util.i.d, "CTRL_UL"};
    private static final String[] f = {"CTRL_PS", PPSLabelView.Code, "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ",", ".", "CTRL_UL", "CTRL_US"};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private g f4299a;

    /* JADX INFO: compiled from: Decoder.java */
    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f4300a;

        static {
            int[] iArr = new int[b.values().length];
            f4300a = iArr;
            try {
                iArr[b.UPPER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4300a[b.LOWER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4300a[b.MIXED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f4300a[b.PUNCT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f4300a[b.DIGIT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: compiled from: Decoder.java */
    private enum b {
        UPPER,
        LOWER,
        MIXED,
        DIGIT,
        PUNCT,
        BINARY
    }

    private static int a(int i, boolean z) {
        return ((z ? 88 : 112) + (i * 16)) * i;
    }

    public o1 a(g gVar, Map<f1, ?> map) throws com.huawei.hms.scankit.p.a {
        this.f4299a = gVar;
        boolean[] zArrB = b(a(gVar.a()));
        o1 o1Var = new o1(a(zArrB), a(zArrB, map), null, null);
        o1Var.a(zArrB.length);
        return o1Var;
    }

    private boolean[] b(boolean[] zArr) throws com.huawei.hms.scankit.p.a {
        int i;
        y2 y2Var;
        g gVar = this.f4299a;
        if (gVar != null) {
            if (gVar.f() <= 2) {
                y2Var = y2.j;
                i = 6;
            } else {
                i = 8;
                if (this.f4299a.f() <= 8) {
                    y2Var = y2.n;
                } else if (this.f4299a.f() <= 22) {
                    y2Var = y2.i;
                    i = 10;
                } else {
                    y2Var = y2.h;
                    i = 12;
                }
            }
            int iE = this.f4299a.e();
            int length = zArr.length / i;
            if (length >= iE) {
                int length2 = zArr.length % i;
                int[] iArr = new int[length];
                int i2 = 0;
                while (i2 < length) {
                    iArr[i2] = a(zArr, length2, i);
                    i2++;
                    length2 += i;
                }
                try {
                    new t5(y2Var).a(iArr, length - iE);
                    return a(iE, i, iArr);
                } catch (com.huawei.hms.scankit.p.a e2) {
                    throw com.huawei.hms.scankit.p.a.a(e2.getMessage());
                }
            }
            throw com.huawei.hms.scankit.p.a.a();
        }
        throw com.huawei.hms.scankit.p.a.a();
    }

    private static String a(boolean[] zArr, Map<f1, ?> map) throws com.huawei.hms.scankit.p.a {
        b bVar = b.UPPER;
        StringBuilder sbA = a(zArr, bVar, bVar);
        int length = sbA.length();
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr[i] = (byte) sbA.charAt(i);
        }
        try {
            return new String(bArr, f6.a(bArr, map));
        } catch (UnsupportedEncodingException unused) {
            throw com.huawei.hms.scankit.p.a.a();
        }
    }

    private static StringBuilder a(boolean[] zArr, b bVar, b bVar2) {
        int length = zArr.length;
        StringBuilder sb = new StringBuilder(20);
        int i = 0;
        while (i < length) {
            if (bVar2 != b.BINARY) {
                int i2 = bVar2 == b.DIGIT ? 4 : 5;
                if (length - i < i2) {
                    break;
                }
                int iA = a(zArr, i, i2);
                i += i2;
                String strA = a(bVar2, iA);
                if (strA.startsWith("CTRL_")) {
                    bVar = a(strA.charAt(5));
                    if (strA.charAt(6) != 'L') {
                        b bVar3 = bVar2;
                        bVar2 = bVar;
                        bVar = bVar3;
                    }
                } else {
                    sb.append(strA);
                }
                bVar2 = bVar;
            } else {
                if (length - i < 5) {
                    break;
                }
                int iA2 = a(zArr, i, 5);
                int i3 = i + 5;
                if (iA2 == 0) {
                    if (length - i3 < 11) {
                        break;
                    }
                    iA2 = a(zArr, i3, 11) + 31;
                    i3 = i + 16;
                }
                int i4 = 0;
                while (true) {
                    if (i4 >= iA2) {
                        i = i3;
                        break;
                    }
                    if (length - i3 < 8) {
                        i = length;
                        break;
                    }
                    sb.append((char) a(zArr, i3, 8));
                    i3 += 8;
                    i4++;
                }
                bVar2 = bVar;
            }
        }
        return sb;
    }

    private static b a(char c2) {
        if (c2 == 'B') {
            return b.BINARY;
        }
        if (c2 == 'D') {
            return b.DIGIT;
        }
        if (c2 == 'P') {
            return b.PUNCT;
        }
        if (c2 == 'L') {
            return b.LOWER;
        }
        if (c2 != 'M') {
            return b.UPPER;
        }
        return b.MIXED;
    }

    private static String a(b bVar, int i) {
        int i2 = a.f4300a[bVar.ordinal()];
        if (i2 == 1) {
            return b[i];
        }
        if (i2 == 2) {
            return c[i];
        }
        if (i2 == 3) {
            return d[i];
        }
        if (i2 == 4) {
            return e[i];
        }
        if (i2 != 5) {
            throw new IllegalStateException("Bad table");
        }
        return f[i];
    }

    private boolean[] a(int i, int i2, int[] iArr) throws com.huawei.hms.scankit.p.a {
        int i3 = 1 << i2;
        int i4 = i3 - 1;
        int i5 = 0;
        for (int i6 = 0; i6 < i; i6++) {
            int i7 = iArr[i6];
            if (i7 == 0 || i7 == i4) {
                throw com.huawei.hms.scankit.p.a.a();
            }
            if (i7 == 1 || i7 == i3 - 2) {
                i5++;
            }
        }
        boolean[] zArr = new boolean[(i * i2) - i5];
        int i8 = 0;
        for (int i9 = 0; i9 < i; i9++) {
            int i10 = iArr[i9];
            if (i10 == 1 || i10 == i3 - 2) {
                Arrays.fill(zArr, i8, (i8 + i2) - 1, i10 > 1);
                i8 += i2 - 1;
            } else {
                int i11 = i2 - 1;
                while (i11 >= 0) {
                    int i12 = i8 + 1;
                    zArr[i8] = ((1 << i11) & i10) != 0;
                    i11--;
                    i8 = i12;
                }
            }
        }
        return zArr;
    }

    private boolean[] a(s sVar) {
        g gVar = this.f4299a;
        boolean z = gVar != null && gVar.g();
        g gVar2 = this.f4299a;
        int iF = gVar2 != null ? gVar2.f() : 0;
        int i = (z ? 11 : 14) + (iF * 4);
        int[] iArr = new int[i];
        boolean[] zArr = new boolean[a(iF, z)];
        int i2 = 2;
        if (z) {
            for (int i3 = 0; i3 < i; i3++) {
                iArr[i3] = i3;
            }
        } else {
            int i4 = i / 2;
            int i5 = ((i + 1) + (((i4 - 1) / 15) * 2)) / 2;
            for (int i6 = 0; i6 < i4; i6++) {
                int i7 = (i6 / 15) + i6;
                iArr[(i4 - i6) - 1] = (i5 - i7) - 1;
                iArr[i4 + i6] = i7 + i5 + 1;
            }
        }
        int i8 = 0;
        int i9 = 0;
        while (i8 < iF) {
            int i10 = ((iF - i8) * 4) + (z ? 9 : 12);
            int i11 = i8 * 2;
            int i12 = (i - 1) - i11;
            int i13 = 0;
            while (i13 < i10) {
                int i14 = i13 * 2;
                int i15 = 0;
                while (i15 < i2) {
                    int i16 = i11 + i15;
                    int i17 = i11 + i13;
                    zArr[i9 + i14 + i15] = sVar.b(iArr[i16], iArr[i17]);
                    int i18 = i12 - i15;
                    zArr[(i10 * 2) + i9 + i14 + i15] = sVar.b(iArr[i17], iArr[i18]);
                    int i19 = i12 - i13;
                    zArr[(i10 * 4) + i9 + i14 + i15] = sVar.b(iArr[i18], iArr[i19]);
                    zArr[(i10 * 6) + i9 + i14 + i15] = sVar.b(iArr[i19], iArr[i16]);
                    i15++;
                    z = z;
                    i2 = 2;
                }
                i13++;
                i2 = 2;
            }
            i9 += i10 * 8;
            i8++;
            i2 = 2;
        }
        return zArr;
    }

    private static int a(boolean[] zArr, int i, int i2) {
        int i3 = 0;
        for (int i4 = i; i4 < i + i2; i4++) {
            i3 <<= 1;
            if (zArr[i4]) {
                i3 |= 1;
            }
        }
        return i3;
    }

    private static byte a(boolean[] zArr, int i) {
        int iA;
        int length = zArr.length - i;
        if (length >= 8) {
            iA = a(zArr, i, 8);
        } else {
            iA = a(zArr, i, length) << (8 - length);
        }
        return (byte) iA;
    }

    static byte[] a(boolean[] zArr) {
        int length = (zArr.length + 7) / 8;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr[i] = a(zArr, i * 8);
        }
        return bArr;
    }
}
