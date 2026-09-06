package com.opos.exoplayer.core.i;

import android.text.TextUtils;
import com.alibaba.fastjson.asm.Opcodes;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.android.exoplayer2.util.MimeTypes;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class m {
    public static String a(int i) {
        if (i == 32) {
            return MimeTypes.VIDEO_MP4V;
        }
        if (i == 33) {
            return MimeTypes.VIDEO_H264;
        }
        if (i == 35) {
            return MimeTypes.VIDEO_H265;
        }
        if (i == 64) {
            return MimeTypes.AUDIO_AAC;
        }
        if (i == 107) {
            return MimeTypes.AUDIO_MPEG;
        }
        if (i == 96 || i == 97) {
            return MimeTypes.VIDEO_MPEG2;
        }
        if (i == 165) {
            return MimeTypes.AUDIO_AC3;
        }
        if (i == 166) {
            return MimeTypes.AUDIO_E_AC3;
        }
        switch (i) {
            case 102:
            case 103:
            case 104:
                return MimeTypes.AUDIO_AAC;
            case 105:
                return MimeTypes.AUDIO_MPEG;
            default:
                switch (i) {
                    case Opcodes.RET /* 169 */:
                    case 172:
                        return MimeTypes.AUDIO_DTS;
                    case 170:
                    case MediaPlayer.MEDIA_PLAYER_OPTION_BIT_RATE /* 171 */:
                        return MimeTypes.AUDIO_DTS_HD;
                    case MediaPlayer.MEDIA_PLAYER_OPTION_ABR_SWITCH_COUNT /* 173 */:
                        return MimeTypes.AUDIO_OPUS;
                    default:
                        return null;
                }
        }
    }

    public static boolean a(String str) {
        return "audio".equals(g(str));
    }

    public static boolean b(String str) {
        return "video".equals(g(str));
    }

    public static boolean c(String str) {
        return "text".equals(g(str));
    }

    public static String d(String str) {
        String strA = null;
        if (str == null) {
            return null;
        }
        String strTrim = str.trim();
        if (strTrim.startsWith("avc1") || strTrim.startsWith("avc3")) {
            return MimeTypes.VIDEO_H264;
        }
        if (strTrim.startsWith("hev1") || strTrim.startsWith("hvc1")) {
            return MimeTypes.VIDEO_H265;
        }
        if (strTrim.startsWith("vp9") || strTrim.startsWith("vp09")) {
            return MimeTypes.VIDEO_VP9;
        }
        if (strTrim.startsWith("vp8") || strTrim.startsWith("vp08")) {
            return MimeTypes.VIDEO_VP8;
        }
        if (strTrim.startsWith("mp4a")) {
            if (strTrim.startsWith("mp4a.")) {
                String strSubstring = strTrim.substring(5);
                if (strSubstring.length() >= 2) {
                    try {
                        strA = a(Integer.parseInt(y.e(strSubstring.substring(0, 2)), 16));
                    } catch (NumberFormatException unused) {
                    }
                }
            }
            return strA == null ? MimeTypes.AUDIO_AAC : strA;
        }
        if (strTrim.startsWith("ac-3") || strTrim.startsWith("dac3")) {
            return MimeTypes.AUDIO_AC3;
        }
        if (strTrim.startsWith("ec-3") || strTrim.startsWith("dec3")) {
            return MimeTypes.AUDIO_E_AC3;
        }
        if (strTrim.startsWith(MimeTypes.CODEC_E_AC3_JOC)) {
            return MimeTypes.AUDIO_E_AC3_JOC;
        }
        if (strTrim.startsWith("dtsc") || strTrim.startsWith("dtse")) {
            return MimeTypes.AUDIO_DTS;
        }
        if (strTrim.startsWith("dtsh") || strTrim.startsWith("dtsl")) {
            return MimeTypes.AUDIO_DTS_HD;
        }
        if (strTrim.startsWith("opus")) {
            return MimeTypes.AUDIO_OPUS;
        }
        if (strTrim.startsWith("vorbis")) {
            return MimeTypes.AUDIO_VORBIS;
        }
        return null;
    }

    public static int e(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (a(str)) {
            return 1;
        }
        if (b(str)) {
            return 2;
        }
        if (c(str) || MimeTypes.APPLICATION_CEA608.equals(str) || MimeTypes.APPLICATION_CEA708.equals(str) || MimeTypes.APPLICATION_MP4CEA608.equals(str) || MimeTypes.APPLICATION_SUBRIP.equals(str) || MimeTypes.APPLICATION_TTML.equals(str) || MimeTypes.APPLICATION_TX3G.equals(str) || MimeTypes.APPLICATION_MP4VTT.equals(str) || MimeTypes.APPLICATION_RAWCC.equals(str) || MimeTypes.APPLICATION_VOBSUB.equals(str) || MimeTypes.APPLICATION_PGS.equals(str) || MimeTypes.APPLICATION_DVBSUBS.equals(str)) {
            return 3;
        }
        return (MimeTypes.APPLICATION_ID3.equals(str) || MimeTypes.APPLICATION_EMSG.equals(str) || MimeTypes.APPLICATION_SCTE35.equals(str) || MimeTypes.APPLICATION_CAMERA_MOTION.equals(str)) ? 4 : -1;
    }

    public static int f(String str) {
        str.hashCode();
        switch (str) {
            case "audio/eac3-joc":
            case "audio/eac3":
                return 6;
            case "audio/vnd.dts":
                return 7;
            case "audio/ac3":
                return 5;
            case "audio/vnd.dts.hd":
                return 8;
            case "audio/true-hd":
                return 14;
            default:
                return 0;
        }
    }

    private static String g(String str) {
        if (str == null) {
            return null;
        }
        int iIndexOf = str.indexOf(47);
        if (iIndexOf != -1) {
            return str.substring(0, iIndexOf);
        }
        throw new IllegalArgumentException("Invalid mime type: " + str);
    }
}
