package com.huawei.hms.scankit.p;

import com.alibaba.fastjson.asm.Opcodes;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.common.base.Ascii;
import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: compiled from: Code39Reader.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class q0 extends o4 {
    public static final int[] e = {52, 289, 97, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_CHLO_COUNT, 49, 304, 112, 37, 292, 100, 265, 73, MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_AUDIO_PROBESIZE, 25, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEOCODEC_PIXEL_ALIGN, 88, 13, 268, 76, 28, 259, 67, 322, 19, 274, 82, 7, 262, 70, 22, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DEMUXER_STALL_500, 193, 448, 145, 400, 208, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_INIT_RTT, MediaPlayer.MEDIA_PLAYER_OPTION_PRE_DECODE_AUTO_PAUSE, Opcodes.JSR, 162, 138, 42};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f4325a;
    private final boolean b;
    private final StringBuilder c;
    private final int[] d;

    public q0() {
        this(false);
    }

    private static boolean b(int[] iArr) {
        int i = Integer.MAX_VALUE;
        int i2 = 0;
        for (int i3 : iArr) {
            if (i3 < i) {
                i = i3;
            }
            if (i3 > i2) {
                i2 = i3;
            }
        }
        return i2 / i > 6;
    }

    private static int c(int[] iArr) {
        int length = iArr.length;
        if (b(iArr)) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = Integer.MAX_VALUE;
            for (int i3 : iArr) {
                if (i3 < i2 && i3 > i) {
                    i2 = i3;
                }
            }
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            for (int i7 = 0; i7 < length; i7++) {
                int i8 = iArr[i7];
                if (i8 > i2) {
                    i6 |= 1 << ((length - 1) - i7);
                    i4++;
                    i5 += i8;
                }
            }
            if (i4 == 3) {
                for (int i9 = 0; i9 < length && i4 > 0; i9++) {
                    int i10 = iArr[i9];
                    if (i10 > i2) {
                        i4--;
                        if (i10 * 2 >= i5) {
                            return -1;
                        }
                    }
                }
                return i6;
            }
            if (i4 <= 3) {
                return -1;
            }
            i = i2;
        }
    }

    public q0(boolean z) {
        this(z, false);
    }

    @Override // com.huawei.hms.scankit.p.o4
    public w5 a(int i, r rVar, Map<f1, ?> map) throws a {
        int[] iArr = this.d;
        Arrays.fill(iArr, 0);
        StringBuilder sb = this.c;
        sb.setLength(0);
        int[] iArrA = a(rVar, iArr);
        int iC = rVar.c(iArrA[1]);
        int iE = rVar.e();
        while (true) {
            o4.a(rVar, iC, iArr);
            int iC2 = c(iArr);
            if (iC2 < 0) {
                throw a.a();
            }
            char cA = a(iC2);
            sb.append(cA);
            int i2 = iC;
            for (int i3 : iArr) {
                i2 += i3;
            }
            int iC3 = rVar.c(i2);
            if (cA == '*') {
                sb.setLength(sb.length() - 1);
                int i4 = 0;
                for (int i5 : iArr) {
                    i4 += i5;
                }
                int i6 = (iC3 - iC) - i4;
                if (iC3 == iE || i6 * 5 >= i4) {
                    return a(sb, iArrA, iC, i4, i);
                }
                throw a.a();
            }
            iC = iC3;
        }
    }

    public q0(boolean z, boolean z2) {
        this.f4325a = z;
        this.b = z2;
        this.c = new StringBuilder(20);
        this.d = new int[9];
    }

    private w5 a(StringBuilder sb, int[] iArr, int i, int i2, int i3) throws a {
        String string;
        if (this.f4325a) {
            int length = sb.length() - 1;
            int iIndexOf = 0;
            for (int i4 = 0; i4 < length; i4++) {
                iIndexOf += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".indexOf(this.c.charAt(i4));
            }
            if (sb.charAt(length) == "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".charAt(iIndexOf % 43)) {
                sb.setLength(length);
            } else {
                throw a.a();
            }
        }
        if (sb.length() != 0) {
            if (this.b) {
                string = a(sb);
            } else {
                string = sb.toString();
            }
            float f = i3;
            return new w5(string, null, new y5[]{new y5(iArr[0], f), new y5(i + i2, f)}, BarcodeFormat.CODE_39);
        }
        throw a.a();
    }

    private static int[] a(r rVar, int[] iArr) throws a {
        int iE = rVar.e();
        int iC = rVar.c(0);
        int length = iArr.length;
        boolean z = false;
        int i = 0;
        int i2 = iC;
        while (iC < iE) {
            if (rVar.b(iC) != z) {
                if (i >= 0 && i < iArr.length) {
                    iArr[i] = iArr[i] + 1;
                } else {
                    throw a.a();
                }
            } else {
                if (i != length - 1) {
                    i++;
                } else {
                    if (c(iArr) == 148 && rVar.a(Math.max(0, i2 - ((iC - i2) / 5)), i2, false, true)) {
                        return new int[]{i2, iC};
                    }
                    i2 += iArr[0] + iArr[1];
                    int i3 = i - 1;
                    System.arraycopy(iArr, 2, iArr, 0, i3);
                    iArr[i3] = 0;
                    iArr[i] = 0;
                    i--;
                }
                iArr[i] = 1;
                z = !z;
            }
            iC++;
        }
        throw a.a();
    }

    private static char a(int i) throws a {
        int i2 = 0;
        while (true) {
            int[] iArr = e;
            if (i2 >= iArr.length) {
                if (i == 148) {
                    return '*';
                }
                throw a.a();
            }
            if (iArr[i2] == i) {
                return "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".charAt(i2);
            }
            i2++;
        }
    }

    private static String a(CharSequence charSequence) throws a {
        int length = charSequence.length();
        StringBuilder sb = new StringBuilder(length);
        int i = 0;
        while (i < length) {
            char cCharAt = charSequence.charAt(i);
            if (cCharAt != '+' && cCharAt != '$' && cCharAt != '%' && cCharAt != '/') {
                sb.append(cCharAt);
            } else {
                i++;
                sb.append(a(cCharAt, charSequence.charAt(i)));
            }
            i++;
        }
        return sb.toString();
    }

    private static char a(char c, char c2) throws a {
        int i;
        if (c != '$') {
            if (c != '%') {
                if (c != '+') {
                    if (c == '/') {
                        if (c2 < 'A' || c2 > 'O') {
                            if (c2 == 'Z') {
                                return ':';
                            }
                            throw a.a();
                        }
                        i = c2 - ' ';
                    }
                    return (char) 0;
                }
                if (c2 < 'A' || c2 > 'Z') {
                    throw a.a();
                }
                i = c2 + ' ';
            } else if (c2 >= 'A' && c2 <= 'E') {
                i = c2 - '&';
            } else if (c2 >= 'F' && c2 <= 'J') {
                i = c2 - 11;
            } else if (c2 >= 'K' && c2 <= 'O') {
                i = c2 + 16;
            } else {
                if (c2 < 'P' || c2 > 'T') {
                    if (c2 != 'U') {
                        if (c2 == 'V') {
                            return '@';
                        }
                        if (c2 == 'W') {
                            return '`';
                        }
                        if (c2 == 'X' || c2 == 'Y' || c2 == 'Z') {
                            return Ascii.MAX;
                        }
                        throw a.a();
                    }
                    return (char) 0;
                }
                i = c2 + '+';
            }
        } else {
            if (c2 < 'A' || c2 > 'Z') {
                throw a.a();
            }
            i = c2 - '@';
        }
        return (char) i;
    }
}
