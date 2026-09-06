package com.huawei.hms.scankit.p;

import com.alibaba.fastjson.asm.Opcodes;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.common.base.Ascii;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import kotlin.text.Typography;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;

/* JADX INFO: compiled from: DecodedBitStreamParser.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
final class i1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f4273a = {'*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    private static final char[] b;
    private static final char[] c;
    private static final char[] d;
    private static final char[] e;

    /* JADX INFO: compiled from: DecodedBitStreamParser.java */
    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f4274a;

        static {
            int[] iArr = new int[b.values().length];
            f4274a = iArr;
            try {
                iArr[b.C40_ENCODE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4274a[b.TEXT_ENCODE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4274a[b.ANSIX12_ENCODE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f4274a[b.EDIFACT_ENCODE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f4274a[b.BASE256_ENCODE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: compiled from: DecodedBitStreamParser.java */
    private enum b {
        PAD_ENCODE,
        ASCII_ENCODE,
        C40_ENCODE,
        TEXT_ENCODE,
        ANSIX12_ENCODE,
        EDIFACT_ENCODE,
        BASE256_ENCODE,
        UPPER_ENCODE
    }

    static {
        char[] cArr = {'!', Typography.quote, '#', Typography.dollar, '%', Typography.amp, '\'', '(', ')', '*', '+', ',', '-', FilenameUtils.EXTENSION_SEPARATOR, IOUtils.DIR_SEPARATOR_UNIX, ':', ';', Typography.less, '=', Typography.greater, '?', '@', '[', IOUtils.DIR_SEPARATOR_WINDOWS, ']', '^', '_'};
        b = cArr;
        c = new char[]{'*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        d = cArr;
        e = new char[]{'`', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '{', '|', '}', '~', Ascii.MAX};
    }

    static o1 a(byte[] bArr, Map<f1, ?> map) throws com.huawei.hms.scankit.p.a {
        v vVar = new v(bArr);
        StringBuilder sb = new StringBuilder(100);
        StringBuilder sb2 = new StringBuilder(0);
        ArrayList arrayList = new ArrayList(1);
        b bVarA = b.ASCII_ENCODE;
        do {
            b bVar = b.ASCII_ENCODE;
            if (bVarA == bVar) {
                bVarA = a(vVar, sb, sb2);
            } else {
                int i = a.f4274a[bVarA.ordinal()];
                if (i == 1) {
                    b(vVar, sb);
                } else if (i == 2) {
                    d(vVar, sb);
                } else if (i == 3) {
                    a(vVar, sb);
                } else if (i == 4) {
                    c(vVar, sb);
                } else {
                    if (i != 5) {
                        throw com.huawei.hms.scankit.p.a.a("AIScanException");
                    }
                    a(vVar, sb, arrayList);
                }
                bVarA = bVar;
            }
            if (bVarA == b.PAD_ENCODE) {
                break;
            }
        } while (vVar.a() > 0);
        if (sb2.length() > 0) {
            sb.append((CharSequence) sb2);
        }
        int length = sb.length();
        byte[] bArr2 = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            bArr2[i2] = (byte) sb.charAt(i2);
        }
        try {
            String str = new String(bArr2, f6.a(bArr2, map));
            if (arrayList.isEmpty()) {
                arrayList = null;
            }
            return new o1(bArr, str, arrayList, null);
        } catch (UnsupportedEncodingException unused) {
            throw com.huawei.hms.scankit.p.a.a();
        }
    }

    private static void c(v vVar, StringBuilder sb) {
        while (vVar.a() > 16) {
            for (int i = 0; i < 4; i++) {
                int iA = vVar.a(6);
                if (iA == 31) {
                    int iB = 8 - vVar.b();
                    if (iB != 8) {
                        vVar.a(iB);
                        return;
                    }
                    return;
                }
                if ((iA & 32) == 0) {
                    iA |= 64;
                }
                sb.append((char) iA);
            }
            if (vVar.a() <= 0) {
                return;
            }
        }
    }

    private static void d(v vVar, StringBuilder sb) throws com.huawei.hms.scankit.p.a {
        int iA;
        int[] iArr = new int[3];
        boolean z = false;
        int i = 0;
        while (vVar.a() != 8 && (iA = vVar.a(8)) != 254) {
            a(iA, vVar.a(8), iArr);
            for (int i2 = 0; i2 < 3; i2++) {
                int[] iArrA = a(sb, i, iArr[i2], z);
                i = iArrA[0];
                z = iArrA[1] == 1;
            }
            if (vVar.a() <= 0) {
                return;
            }
        }
    }

    private static void b(v vVar, StringBuilder sb) throws com.huawei.hms.scankit.p.a {
        int iA;
        int[] iArr = new int[3];
        boolean z = false;
        int i = 0;
        while (vVar.a() != 8 && (iA = vVar.a(8)) != 254) {
            a(iA, vVar.a(8), iArr);
            for (int i2 = 0; i2 < 3; i2++) {
                int[] iArrB = b(sb, i, iArr[i2], z);
                i = iArrB[0];
                z = iArrB[1] == 1;
            }
            if (vVar.a() <= 0) {
                return;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static int[] b(StringBuilder sb, int i, int i2, boolean z) throws com.huawei.hms.scankit.p.a {
        int i3;
        boolean z2;
        if (i != 0) {
            if (i == 1) {
                if (z) {
                    i2 += 128;
                }
                sb.append((char) i2);
            } else if (i == 2) {
                char[] cArr = b;
                if (i2 < cArr.length) {
                    char c2 = cArr[i2];
                    if (z) {
                        c2 = (char) (c2 + 128);
                    }
                    sb.append(c2);
                    z2 = false;
                } else if (i2 == 27) {
                    sb.append((char) 29);
                    z2 = z;
                } else {
                    if (i2 != 30) {
                        throw com.huawei.hms.scankit.p.a.a("AIScanException");
                    }
                    z2 = true;
                }
                i = 0;
                i3 = z2;
            } else {
                if (i != 3) {
                    throw com.huawei.hms.scankit.p.a.a("AIScanException");
                }
                sb.append((char) (z ? i2 + 224 : i2 + 96));
            }
            i = 0;
            i3 = 0;
        } else if (i2 < 3) {
            i = i2 + 1;
            i3 = z;
        } else {
            char[] cArr2 = f4273a;
            if (i2 < cArr2.length) {
                char c3 = cArr2[i2];
                if (z) {
                    c3 = (char) (c3 + 128);
                }
                sb.append(c3);
                i3 = 0;
            } else {
                throw com.huawei.hms.scankit.p.a.a("AIScanException");
            }
        }
        return new int[]{i, i3};
    }

    private static b a(v vVar, StringBuilder sb, StringBuilder sb2) throws com.huawei.hms.scankit.p.a {
        boolean z = false;
        do {
            int iA = vVar.a(8);
            if (iA == 0) {
                throw com.huawei.hms.scankit.p.a.a("AIScanException");
            }
            if (iA <= 128) {
                if (z) {
                    iA += 128;
                }
                sb.append((char) (iA - 1));
                return b.ASCII_ENCODE;
            }
            if (iA == 129) {
                return b.PAD_ENCODE;
            }
            if (iA <= 229) {
                int i = iA - 130;
                if (i < 10) {
                    sb.append('0');
                }
                sb.append(i);
            } else {
                b bVarA = a(iA, sb, sb2, vVar);
                if (bVarA != null) {
                    if (bVarA != b.UPPER_ENCODE) {
                        return bVarA;
                    }
                    z = true;
                }
            }
        } while (vVar.a() > 0);
        return b.ASCII_ENCODE;
    }

    private static b a(int i, StringBuilder sb, StringBuilder sb2, v vVar) throws com.huawei.hms.scankit.p.a {
        switch (i) {
            case MediaPlayer.MEDIA_PLAYER_OPTION_NETWORK_TRY_COUNT /* 230 */:
                return b.C40_ENCODE;
            case MediaPlayer.MEDIA_PLAYER_OPTION_ALOG_WRITE_FUNC_ADDR /* 231 */:
                return b.BASE256_ENCODE;
            case 232:
                sb.append((char) 29);
                return null;
            case 233:
            case 234:
            case MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_INDEX_CACHE /* 241 */:
                return null;
            case 235:
                return b.UPPER_ENCODE;
            case 236:
                sb.append("[)>\u001e05\u001d");
                sb2.insert(0, "\u001e\u0004");
                return null;
            case 237:
                sb.append("[)>\u001e06\u001d");
                sb2.insert(0, "\u001e\u0004");
                return null;
            case 238:
                return b.ANSIX12_ENCODE;
            case 239:
                return b.TEXT_ENCODE;
            case 240:
                return b.EDIFACT_ENCODE;
            default:
                if (i == 254 && vVar.a() == 0) {
                    return null;
                }
                throw com.huawei.hms.scankit.p.a.a("AIScanException");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static int[] a(StringBuilder sb, int i, int i2, boolean z) throws com.huawei.hms.scankit.p.a {
        int i3;
        boolean z2;
        if (i != 0) {
            if (i == 1) {
                if (z) {
                    i2 = (char) (i2 + 128);
                }
                sb.append(i2);
            } else if (i == 2) {
                char[] cArr = d;
                if (i2 < cArr.length) {
                    char c2 = cArr[i2];
                    if (z) {
                        c2 = (char) (c2 + 128);
                    }
                    sb.append(c2);
                    z2 = false;
                } else if (i2 == 27) {
                    sb.append((char) 29);
                    z2 = z;
                } else {
                    if (i2 != 30) {
                        throw com.huawei.hms.scankit.p.a.a("AIScanException");
                    }
                    z2 = true;
                }
                i = 0;
                i3 = z2;
            } else {
                if (i != 3) {
                    throw com.huawei.hms.scankit.p.a.a("AIScanException");
                }
                char[] cArr2 = e;
                if (i2 < cArr2.length) {
                    char c3 = cArr2[i2];
                    if (z) {
                        c3 = (char) (c3 + 128);
                    }
                    sb.append(c3);
                } else {
                    throw com.huawei.hms.scankit.p.a.a("AIScanException");
                }
            }
            i = 0;
            i3 = 0;
        } else if (i2 < 3) {
            i = i2 + 1;
            i3 = z;
        } else {
            char[] cArr3 = c;
            if (i2 < cArr3.length) {
                char c4 = cArr3[i2];
                if (z) {
                    c4 = (char) (c4 + 128);
                }
                sb.append(c4);
                i3 = 0;
            } else {
                throw com.huawei.hms.scankit.p.a.a("AIScanException");
            }
        }
        return new int[]{i, i3};
    }

    private static void a(v vVar, StringBuilder sb) throws com.huawei.hms.scankit.p.a {
        int iA;
        int[] iArr = new int[3];
        while (vVar.a() != 8 && (iA = vVar.a(8)) != 254) {
            a(iA, vVar.a(8), iArr);
            for (int i = 0; i < 3; i++) {
                int i2 = iArr[i];
                if (i2 == 0) {
                    sb.append('\r');
                } else if (i2 == 1) {
                    sb.append('*');
                } else if (i2 == 2) {
                    sb.append(Typography.greater);
                } else if (i2 == 3) {
                    sb.append(' ');
                } else if (i2 < 14) {
                    sb.append((char) (i2 + 44));
                } else if (i2 < 40) {
                    sb.append((char) (i2 + 51));
                } else {
                    throw com.huawei.hms.scankit.p.a.a("AIScanException");
                }
            }
            if (vVar.a() <= 0) {
                return;
            }
        }
    }

    private static void a(int i, int i2, int[] iArr) {
        int i3 = ((i << 8) + i2) - 1;
        int i4 = i3 / 1600;
        iArr[0] = i4;
        int i5 = i3 - (i4 * 1600);
        int i6 = i5 / 40;
        iArr[1] = i6;
        iArr[2] = i5 - (i6 * 40);
    }

    private static void a(v vVar, StringBuilder sb, Collection<byte[]> collection) throws com.huawei.hms.scankit.p.a {
        int iC = vVar.c();
        int i = iC + 2;
        int iA = a(vVar.a(8), iC + 1);
        if (iA == 0) {
            iA = vVar.a() / 8;
        } else if (iA >= 250) {
            iA = ((iA - 249) * 250) + a(vVar.a(8), i);
            i = iC + 3;
        }
        if (iA >= 0) {
            byte[] bArr = new byte[iA];
            int i2 = 0;
            while (i2 < iA) {
                if (vVar.a() >= 8) {
                    bArr[i2] = (byte) a(vVar.a(8), i);
                    i2++;
                    i++;
                } else {
                    throw com.huawei.hms.scankit.p.a.a("AIScanException");
                }
            }
            collection.add(bArr);
            try {
                sb.append(new String(bArr, "ISO8859_1"));
                return;
            } catch (UnsupportedEncodingException e2) {
                throw new IllegalStateException("Platform does not support required encoding: " + e2);
            }
        }
        throw com.huawei.hms.scankit.p.a.a("AIScanException");
    }

    private static int a(int i, int i2) {
        int i3 = i - (((i2 * Opcodes.FCMPL) % 255) + 1);
        return i3 >= 0 ? i3 : i3 + 256;
    }
}
