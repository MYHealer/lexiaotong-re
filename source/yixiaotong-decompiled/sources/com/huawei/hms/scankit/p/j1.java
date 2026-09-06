package com.huawei.hms.scankit.p;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: compiled from: DecodedBitStreamParser.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
final class j1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f4280a = ";<>@[\\]_`~!\r\t,:\n-.$/\"|*()?{}'".toCharArray();
    private static final char[] b = "0123456789&\r\t,:#-.$/+%*=^".toCharArray();
    private static final BigInteger[] c;

    /* JADX INFO: compiled from: DecodedBitStreamParser.java */
    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f4281a;

        static {
            int[] iArr = new int[b.values().length];
            f4281a = iArr;
            try {
                iArr[b.ALPHA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4281a[b.LOWER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4281a[b.MIXED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f4281a[b.PUNCT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f4281a[b.ALPHA_SHIFT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f4281a[b.PUNCT_SHIFT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX INFO: compiled from: DecodedBitStreamParser.java */
    private enum b {
        ALPHA,
        LOWER,
        MIXED,
        PUNCT,
        ALPHA_SHIFT,
        PUNCT_SHIFT
    }

    static {
        BigInteger[] bigIntegerArr = new BigInteger[16];
        c = bigIntegerArr;
        bigIntegerArr[0] = BigInteger.ONE;
        BigInteger bigIntegerValueOf = BigInteger.valueOf(900L);
        bigIntegerArr[1] = bigIntegerValueOf;
        int i = 2;
        while (true) {
            BigInteger[] bigIntegerArr2 = c;
            if (i >= bigIntegerArr2.length) {
                return;
            }
            bigIntegerArr2[i] = bigIntegerArr2[i - 1].multiply(bigIntegerValueOf);
            i++;
        }
    }

    static o1 a(int[] iArr, String str, Map<f1, ?> map) throws com.huawei.hms.scankit.p.a {
        int i;
        int iA;
        StringBuilder sb = new StringBuilder(iArr.length * 2);
        Charset charset = StandardCharsets.ISO_8859_1;
        int i2 = iArr[1];
        y4 y4Var = new y4();
        Charset charsetForName = charset;
        int i3 = 2;
        int i4 = i2;
        while (true) {
            int i5 = iArr[0];
            if (i3 > i5 || (i3 == i5 && sb.length() > 0)) {
                break;
            }
            if (i4 == 927) {
                iA = i3 + 1;
                charsetForName = Charset.forName(l0.a(iArr[i3]).name());
            } else {
                iA = a(sb, i4, iArr, i3, charsetForName, y4Var);
            }
            if (iA >= iArr.length) {
                throw com.huawei.hms.scankit.p.a.a();
            }
            i3 = iA + 1;
            i4 = iArr[iA];
        }
        if (sb.length() == 0) {
            throw com.huawei.hms.scankit.p.a.a();
        }
        if (charsetForName != StandardCharsets.ISO_8859_1) {
            o1 o1Var = new o1(null, sb.toString(), null, str);
            o1Var.a(y4Var);
            return o1Var;
        }
        int length = sb.length();
        byte[] bArr = new byte[length];
        for (i = 0; i < length; i++) {
            bArr[i] = (byte) sb.charAt(i);
        }
        try {
            o1 o1Var2 = new o1(null, new String(bArr, f6.a(bArr, map)), null, str);
            o1Var2.a(y4Var);
            return o1Var2;
        } catch (UnsupportedEncodingException unused) {
            throw com.huawei.hms.scankit.p.a.a();
        }
    }

    private static boolean a(int i) {
        return i == 901 || i == 924 || i == 902 || i == 928 || i == 923 || i == 922;
    }

    private static int b(int[] iArr, int i, StringBuilder sb) throws com.huawei.hms.scankit.p.a {
        int i2 = iArr[0];
        int[] iArr2 = new int[(i2 - i) * 2];
        int[] iArr3 = new int[(i2 - i) * 2];
        boolean z = false;
        int i3 = 0;
        while (i < iArr[0] && !z) {
            int i4 = i + 1;
            int i5 = iArr[i];
            if (i5 < 900) {
                iArr2[i3] = i5 / 30;
                iArr2[i3 + 1] = i5 % 30;
                i3 += 2;
            } else if (i5 == 900) {
                iArr2[i3] = 900;
                i3++;
            } else if (i5 == 913) {
                iArr2[i3] = 913;
                i += 2;
                iArr3[i3] = iArr[i4];
                i3++;
            } else {
                if (!a(i5)) {
                    throw com.huawei.hms.scankit.p.a.a();
                }
                z = true;
            }
            i = i4;
        }
        a(iArr2, iArr3, i3, sb);
        return i;
    }

    private static b[] c(StringBuilder sb, int[] iArr, b bVar, b bVar2, int[] iArr2) throws com.huawei.hms.scankit.p.a {
        b bVar3;
        int i = iArr2[1];
        if (i < 26) {
            iArr2[2] = (char) (i + 97);
        } else if (i == 900) {
            bVar = b.ALPHA;
        } else if (i != 913) {
            switch (i) {
                case 26:
                    iArr2[2] = 32;
                    break;
                case 27:
                    bVar3 = b.ALPHA_SHIFT;
                    bVar2 = bVar;
                    bVar = bVar3;
                    break;
                case 28:
                    bVar = b.MIXED;
                    break;
                case 29:
                    bVar3 = b.PUNCT_SHIFT;
                    bVar2 = bVar;
                    bVar = bVar3;
                    break;
                default:
                    throw com.huawei.hms.scankit.p.a.a();
            }
        } else {
            sb.append((char) iArr[iArr2[0]]);
        }
        return new b[]{bVar, bVar2};
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0039  */
    private static b[] d(StringBuilder sb, int[] iArr, b bVar, b bVar2, int[] iArr2) throws com.huawei.hms.scankit.p.a {
        int i = iArr2[1];
        if (i < 25) {
            iArr2[2] = b[i];
        } else if (i == 900) {
            bVar = b.ALPHA;
        } else if (i != 913) {
            switch (i) {
                case 25:
                    bVar = b.PUNCT;
                    break;
                case 26:
                    iArr2[2] = 32;
                    break;
                case 27:
                    bVar = b.LOWER;
                    break;
                case 28:
                    bVar = b.ALPHA;
                    break;
                case 29:
                    bVar2 = bVar;
                    bVar = b.PUNCT_SHIFT;
                    break;
                default:
                    throw com.huawei.hms.scankit.p.a.a();
            }
        } else {
            sb.append((char) iArr[iArr2[0]]);
        }
        return new b[]{bVar, bVar2};
    }

    private static b[] e(StringBuilder sb, int[] iArr, b bVar, b bVar2, int[] iArr2) throws com.huawei.hms.scankit.p.a {
        int i = iArr2[1];
        if (i < 29) {
            iArr2[2] = f4280a[i];
        } else if (i == 29 || i == 900) {
            bVar = b.ALPHA;
        } else {
            if (i != 913) {
                throw com.huawei.hms.scankit.p.a.a();
            }
            sb.append((char) iArr[iArr2[0]]);
        }
        return new b[]{bVar, bVar2};
    }

    private static b[] f(StringBuilder sb, int[] iArr, b bVar, b bVar2, int[] iArr2) throws com.huawei.hms.scankit.p.a {
        b bVar3;
        int i = iArr2[1];
        if (i >= 29) {
            if (i == 29 || i == 900) {
                bVar3 = b.ALPHA;
            } else {
                if (i != 913) {
                    throw com.huawei.hms.scankit.p.a.a();
                }
                sb.append((char) iArr[iArr2[0]]);
            }
            return new b[]{bVar3, bVar2};
        }
        iArr2[2] = f4280a[i];
        bVar3 = bVar2;
        return new b[]{bVar3, bVar2};
    }

    private static b[] b(StringBuilder sb, int[] iArr, b bVar, b bVar2, int[] iArr2) throws com.huawei.hms.scankit.p.a {
        b bVar3;
        int i = iArr2[1];
        if (i >= 26) {
            if (i == 26) {
                iArr2[2] = 32;
            } else if (i == 900) {
                bVar3 = b.ALPHA;
            } else {
                throw com.huawei.hms.scankit.p.a.a();
            }
            return new b[]{bVar3, bVar2};
        }
        iArr2[2] = (char) (i + 65);
        bVar3 = bVar2;
        return new b[]{bVar3, bVar2};
    }

    private static int a(StringBuilder sb, int i, int[] iArr, int i2, Charset charset, y4 y4Var) throws com.huawei.hms.scankit.p.a {
        if (i == 913) {
            int i3 = i2 + 1;
            sb.append((char) iArr[i2]);
            return i3;
        }
        if (i != 928) {
            switch (i) {
                case 900:
                    return b(iArr, i2, sb);
                case 901:
                    break;
                case 902:
                    return a(iArr, i2, sb);
                default:
                    switch (i) {
                        case MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_READ_BLOCK_TIMEOUT /* 922 */:
                        case MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_READ_BLOCK_MODE /* 923 */:
                            throw com.huawei.hms.scankit.p.a.a();
                        case MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_FIX_STREAM_FIN_AND_RST /* 924 */:
                            break;
                        case MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_VERSION /* 925 */:
                            return i2 + 1;
                        case MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_TIMER_VERSION /* 926 */:
                            return i2 + 2;
                        default:
                            return b(iArr, i2 - 1, sb);
                    }
                    break;
            }
            return a(i, iArr, charset, i2, sb);
        }
        return a(iArr, i2, y4Var);
    }

    static int a(int[] iArr, int i, y4 y4Var) throws com.huawei.hms.scankit.p.a {
        int i2 = 0;
        if (i + 2 <= iArr[0]) {
            int[] iArr2 = new int[2];
            while (i2 < 2) {
                iArr2[i2] = iArr[i];
                i2++;
                i++;
            }
            try {
                y4Var.c(Integer.parseInt(a(iArr2, 2)));
                StringBuilder sb = new StringBuilder();
                int iB = b(iArr, i, sb);
                y4Var.b(sb.toString());
                int i3 = iArr[iB] == 923 ? iB + 1 : -1;
                a(iB, iArr, y4Var);
                if (i3 != -1) {
                    int i4 = iB - i3;
                    if (y4Var.a()) {
                        i4--;
                    }
                    y4Var.a(Arrays.copyOfRange(iArr, i3, i4 + i3));
                }
                return iB;
            } catch (Exception unused) {
                throw com.huawei.hms.scankit.p.a.a();
            }
        }
        throw com.huawei.hms.scankit.p.a.a();
    }

    private static void a(int i, int[] iArr, y4 y4Var) throws com.huawei.hms.scankit.p.a {
        while (i < iArr[0]) {
            int i2 = iArr[i];
            if (i2 == 923) {
                int i3 = iArr[i + 1];
                if (i3 == 0) {
                    StringBuilder sb = new StringBuilder();
                    i = b(iArr, i + 2, sb);
                    y4Var.c(sb.toString());
                } else if (i3 == 3) {
                    StringBuilder sb2 = new StringBuilder();
                    i = b(iArr, i + 2, sb2);
                    y4Var.d(sb2.toString());
                } else if (i3 == 4) {
                    StringBuilder sb3 = new StringBuilder();
                    i = b(iArr, i + 2, sb3);
                    y4Var.a(sb3.toString());
                } else if (i3 == 1) {
                    StringBuilder sb4 = new StringBuilder();
                    i = a(iArr, i + 2, sb4);
                    y4Var.b(Integer.parseInt(sb4.toString()));
                } else if (i3 == 2) {
                    StringBuilder sb5 = new StringBuilder();
                    i = a(iArr, i + 2, sb5);
                    y4Var.b(Long.parseLong(sb5.toString()));
                } else if (i3 == 6) {
                    StringBuilder sb6 = new StringBuilder();
                    i = a(iArr, i + 2, sb6);
                    y4Var.a(Integer.parseInt(sb6.toString()));
                } else if (i3 == 5) {
                    StringBuilder sb7 = new StringBuilder();
                    i = a(iArr, i + 2, sb7);
                    y4Var.a(Long.parseLong(sb7.toString()));
                } else {
                    throw com.huawei.hms.scankit.p.a.a();
                }
            } else if (i2 == 922) {
                i++;
                y4Var.a(true);
            } else {
                throw com.huawei.hms.scankit.p.a.a();
            }
        }
    }

    private static void a(int[] iArr, int[] iArr2, int i, StringBuilder sb) throws com.huawei.hms.scankit.p.a {
        b bVar = b.ALPHA;
        b bVar2 = bVar;
        int i2 = 0;
        while (i2 < i) {
            int[] iArr3 = {i2, iArr[i2], 0};
            b[] bVarArrA = {bVar, bVar2};
            switch (a.f4281a[bVar.ordinal()]) {
                case 1:
                    bVarArrA = a(sb, iArr2, bVar, bVar2, iArr3);
                    break;
                case 2:
                    bVarArrA = c(sb, iArr2, bVar, bVar2, iArr3);
                    break;
                case 3:
                    bVarArrA = d(sb, iArr2, bVar, bVar2, iArr3);
                    break;
                case 4:
                    bVarArrA = e(sb, iArr2, bVar, bVar2, iArr3);
                    break;
                case 5:
                    bVarArrA = b(sb, iArr2, bVar, bVar2, iArr3);
                    break;
                case 6:
                    bVarArrA = f(sb, iArr2, bVar, bVar2, iArr3);
                    break;
            }
            bVar = bVarArrA[0];
            bVar2 = bVarArrA[1];
            int i3 = iArr3[0];
            char c2 = (char) iArr3[2];
            if (c2 != 0) {
                sb.append(c2);
            }
            i2 = i3 + 1;
        }
    }

    private static b[] a(StringBuilder sb, int[] iArr, b bVar, b bVar2, int[] iArr2) throws com.huawei.hms.scankit.p.a {
        int i = iArr2[1];
        if (i < 26) {
            iArr2[2] = (char) (i + 65);
        } else if (i == 900) {
            bVar = b.ALPHA;
        } else if (i != 913) {
            switch (i) {
                case 26:
                    iArr2[2] = 32;
                    break;
                case 27:
                    bVar = b.LOWER;
                    break;
                case 28:
                    bVar = b.MIXED;
                    break;
                case 29:
                    bVar2 = bVar;
                    bVar = b.PUNCT_SHIFT;
                    break;
                default:
                    throw com.huawei.hms.scankit.p.a.a();
            }
        } else {
            sb.append((char) iArr[iArr2[0]]);
        }
        return new b[]{bVar, bVar2};
    }

    private static int a(int i, int[] iArr, Charset charset, int i2, StringBuilder sb) throws com.huawei.hms.scankit.p.a {
        int iA;
        int i3;
        int i4;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i5 = 0;
        long j = 0;
        boolean z = false;
        if (i == 901) {
            int[] iArr2 = new int[6];
            int i6 = i2 + 1;
            int i7 = iArr[i2];
            while (true) {
                i4 = iArr[0];
                if (i6 < i4 && !z) {
                    int i8 = i5 + 1;
                    iArr2[i5] = i7;
                    j = (j * 900) + ((long) i7);
                    int i9 = i6 + 1;
                    i7 = iArr[i6];
                    if (i7 != 928) {
                        switch (i7) {
                            case 900:
                            case 901:
                            case 902:
                                break;
                            default:
                                switch (i7) {
                                    case MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_READ_BLOCK_TIMEOUT /* 922 */:
                                    case MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_READ_BLOCK_MODE /* 923 */:
                                    case MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_FIX_STREAM_FIN_AND_RST /* 924 */:
                                        break;
                                    default:
                                        if (i8 % 5 != 0 || i8 <= 0) {
                                            i6 = i9;
                                            i5 = i8;
                                        } else {
                                            for (int i10 = 0; i10 < 6; i10++) {
                                                byteArrayOutputStream.write((byte) (j >> ((5 - i10) * 8)));
                                            }
                                            j = 0;
                                            i6 = i9;
                                            i5 = 0;
                                        }
                                        break;
                                }
                                break;
                        }
                    }
                    z = true;
                    i5 = i8;
                }
            }
            if (i6 == i4 && i7 < 900) {
                iArr2[i5] = i7;
                i5++;
            }
            for (i3 = 0; i3 < i5; i3++) {
                byteArrayOutputStream.write((byte) iArr2[i3]);
            }
            iA = i6;
        } else {
            iA = i == 924 ? a(i2, iArr, false, 0, 0L, byteArrayOutputStream) : i2;
        }
        sb.append(new String(byteArrayOutputStream.toByteArray(), charset));
        return iA;
    }

    private static int a(int i, int[] iArr, boolean z, int i2, long j, ByteArrayOutputStream byteArrayOutputStream) throws com.huawei.hms.scankit.p.a {
        while (i < iArr[0] && !z) {
            int i3 = i + 1;
            int i4 = iArr[i];
            if (i4 < 900) {
                i2++;
                j = (j * 900) + ((long) i4);
                i = i3;
            } else {
                if (i4 != 928) {
                    switch (i4) {
                        default:
                            switch (i4) {
                                case MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_READ_BLOCK_TIMEOUT /* 922 */:
                                case MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_READ_BLOCK_MODE /* 923 */:
                                case MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_FIX_STREAM_FIN_AND_RST /* 924 */:
                                    break;
                                default:
                                    throw com.huawei.hms.scankit.p.a.a();
                            }
                        case 900:
                        case 901:
                        case 902:
                            z = true;
                            break;
                    }
                }
                z = true;
            }
            if (i2 % 5 == 0 && i2 > 0) {
                for (int i5 = 0; i5 < 6; i5++) {
                    byteArrayOutputStream.write((byte) (j >> ((5 - i5) * 8)));
                }
                j = 0;
                i2 = 0;
            }
        }
        return i;
    }

    private static int a(int[] iArr, int i, StringBuilder sb) throws com.huawei.hms.scankit.p.a {
        int[] iArr2 = new int[15];
        boolean z = false;
        int i2 = 0;
        while (true) {
            int i3 = iArr[0];
            if (i < i3 && !z) {
                int i4 = i + 1;
                int i5 = iArr[i];
                if (i4 == i3) {
                    z = true;
                }
                if (i5 < 900) {
                    iArr2[i2] = i5;
                    i2++;
                    i = i4;
                } else if (i5 == 900 || i5 == 901 || i5 == 928) {
                    z = true;
                } else {
                    switch (i5) {
                        case MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_READ_BLOCK_TIMEOUT /* 922 */:
                        case MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_READ_BLOCK_MODE /* 923 */:
                        case MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_FIX_STREAM_FIN_AND_RST /* 924 */:
                            z = true;
                            break;
                        default:
                            throw com.huawei.hms.scankit.p.a.a();
                    }
                }
                if (i2 % 15 == 0 || i5 == 902 || z) {
                    if (i2 > 0) {
                        sb.append(a(iArr2, i2));
                        i2 = 0;
                    }
                }
            }
        }
        return i;
    }

    private static String a(int[] iArr, int i) throws com.huawei.hms.scankit.p.a {
        BigInteger bigIntegerAdd = BigInteger.ZERO;
        for (int i2 = 0; i2 < i; i2++) {
            bigIntegerAdd = bigIntegerAdd.add(c[(i - i2) - 1].multiply(BigInteger.valueOf(iArr[i2])));
        }
        String string = bigIntegerAdd.toString();
        if (string.charAt(0) == '1') {
            return string.substring(1);
        }
        throw com.huawei.hms.scankit.p.a.a();
    }
}
