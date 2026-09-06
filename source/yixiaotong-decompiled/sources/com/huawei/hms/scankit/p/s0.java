package com.huawei.hms.scankit.p;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.google.common.base.Ascii;
import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: compiled from: Code93Reader.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class s0 extends o4 {
    private static final char[] c = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".toCharArray();
    public static final int[] d;
    private static final int e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final StringBuilder f4338a = new StringBuilder(20);
    private final int[] b = new int[6];

    static {
        int[] iArr = {276, MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_AUDIO_PROBESIZE, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FLV_ABR, 322, 296, 292, 290, MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_DEVICE_WAIT_START_TIME, 274, 266, 424, 420, TTAdConstant.DEEPLINK_FALL_BACK_CODE, 404, 402, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_MIN_RECEIVED_BEFORE_ACK_DECIMATION, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_INIT_MTU, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_ENABLE_CERT_VERIFY, 308, MediaPlayer.MEDIA_PLAYER_OPTION_GET_LOW_UI_FPS, MediaPlayer.MEDIA_PLAYER_OPTION_GET_FIRST_AUDIO_PTS, MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_AUTO_REOPEN, MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_VIDEO_PROBESIZE, 300, 278, 436, 434, 428, 422, 406, 410, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_DEMUX_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_SPEEDX_DROP, 310, 314, 302, 468, 466, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_PARAM_SEND_OUTLET_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_DECODE_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_DECODE_MS_GAPS, 430, 294, 474, 470, 306, 350};
        d = iArr;
        e = iArr[47];
    }

    private static int b(int[] iArr) {
        int i = 0;
        for (int i2 : iArr) {
            i += i2;
        }
        int length = iArr.length;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            int iRound = Math.round((iArr[i4] * 9.0f) / i);
            if (iRound < 1 || iRound > 4) {
                return -1;
            }
            if ((i4 & 1) == 0) {
                for (int i5 = 0; i5 < iRound; i5++) {
                    i3 = (i3 << 1) | 1;
                }
            } else {
                i3 <<= iRound;
            }
        }
        return i3;
    }

    @Override // com.huawei.hms.scankit.p.o4
    public w5 a(int i, r rVar, Map<f1, ?> map) throws a {
        int[] iArrA = a(rVar);
        int iC = rVar.c(iArrA[1]);
        int iE = rVar.e();
        int[] iArr = this.b;
        Arrays.fill(iArr, 0);
        StringBuilder sb = this.f4338a;
        sb.setLength(0);
        while (true) {
            o4.a(rVar, iC, iArr);
            int iB = b(iArr);
            if (iB < 0) {
                throw a.a();
            }
            char cA = a(iB);
            sb.append(cA);
            int i2 = iC;
            for (int i3 : iArr) {
                i2 += i3;
            }
            int iC2 = rVar.c(i2);
            if (cA == '*') {
                sb.deleteCharAt(sb.length() - 1);
                int i4 = 0;
                for (int i5 : iArr) {
                    i4 += i5;
                }
                if (iC2 == iE || !rVar.b(iC2)) {
                    throw a.a();
                }
                if (sb.length() < 2) {
                    throw a.a();
                }
                a(sb);
                sb.setLength(sb.length() - 2);
                float f = i;
                return new w5(b(sb), null, new y5[]{new y5(iArrA[0], f), new y5(iC + ((i4 * 10) / 9), f)}, BarcodeFormat.CODE_93);
            }
            iC = iC2;
        }
    }

    private static String b(CharSequence charSequence) throws a {
        int length = charSequence.length();
        StringBuilder sb = new StringBuilder(length);
        int i = 0;
        while (i < length) {
            char cCharAt = charSequence.charAt(i);
            if (cCharAt < 'a' || cCharAt > 'd') {
                sb.append(cCharAt);
            } else if (i < length - 1) {
                i++;
                sb.append(a(cCharAt, charSequence.charAt(i)));
            } else {
                throw a.a();
            }
            i++;
        }
        return sb.toString();
    }

    private int[] a(r rVar) throws a {
        int iE = rVar.e();
        int iC = rVar.c(0);
        Arrays.fill(this.b, 0);
        int[] iArr = this.b;
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
                    if (b(iArr) == e) {
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
            int[] iArr = d;
            if (i2 < iArr.length) {
                if (iArr[i2] == i) {
                    return c[i2];
                }
                i2++;
            } else {
                throw a.a();
            }
        }
    }

    private static char a(char c2, char c3) throws a {
        int i;
        switch (c2) {
            case 'a':
                if (c3 < 'A' || c3 > 'Z') {
                    throw a.a();
                }
                i = c3 - '@';
                break;
            case 'b':
                if (c3 >= 'A' && c3 <= 'E') {
                    i = c3 - '&';
                } else if (c3 >= 'F' && c3 <= 'J') {
                    i = c3 - 11;
                } else if (c3 >= 'K' && c3 <= 'O') {
                    i = c3 + 16;
                } else {
                    if (c3 < 'P' || c3 > 'S') {
                        if (c3 < 'T' || c3 > 'Z') {
                            throw a.a();
                        }
                        return Ascii.MAX;
                    }
                    i = c3 + '+';
                }
                break;
            case com.huawei.openalliance.ad.constant.z.k /* 99 */:
                if (c3 < 'A' || c3 > 'O') {
                    if (c3 == 'Z') {
                        return ':';
                    }
                    throw a.a();
                }
                i = c3 - ' ';
                break;
            case 'd':
                if (c3 < 'A' || c3 > 'Z') {
                    throw a.a();
                }
                i = c3 + ' ';
                break;
            default:
                return (char) 0;
        }
        return (char) i;
    }

    private static void a(CharSequence charSequence) throws a {
        int length = charSequence.length();
        a(charSequence, length - 2, 20);
        a(charSequence, length - 1, 15);
    }

    private static void a(CharSequence charSequence, int i, int i2) throws a {
        int iIndexOf = 0;
        int i3 = 1;
        for (int i4 = i - 1; i4 >= 0; i4--) {
            iIndexOf += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(charSequence.charAt(i4)) * i3;
            i3++;
            if (i3 > i2) {
                i3 = 1;
            }
        }
        if (charSequence.charAt(i) != c[iIndexOf % 47]) {
            throw a.a();
        }
    }
}
