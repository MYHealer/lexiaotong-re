package com.opos.exoplayer.core.d;

import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.util.Pair;
import com.google.android.exoplayer2.util.MimeTypes;
import com.opos.exoplayer.core.i.m;
import com.opos.exoplayer.core.i.y;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6374a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    private final String e;
    private final MediaCodecInfo.CodecCapabilities f;

    private a(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z, boolean z2) {
        this.f6374a = (String) com.opos.exoplayer.core.i.a.a(str);
        this.e = str2;
        this.f = codecCapabilities;
        boolean z3 = true;
        this.b = (z || codecCapabilities == null || !a(codecCapabilities)) ? false : true;
        this.c = codecCapabilities != null && c(codecCapabilities);
        if (!z2 && (codecCapabilities == null || !e(codecCapabilities))) {
            z3 = false;
        }
        this.d = z3;
    }

    private static int a(String str, String str2, int i) {
        int i2;
        if (i > 1 || ((y.f6517a >= 26 && i > 0) || MimeTypes.AUDIO_MPEG.equals(str2) || MimeTypes.AUDIO_AMR_NB.equals(str2) || MimeTypes.AUDIO_AMR_WB.equals(str2) || MimeTypes.AUDIO_AAC.equals(str2) || MimeTypes.AUDIO_VORBIS.equals(str2) || MimeTypes.AUDIO_OPUS.equals(str2) || MimeTypes.AUDIO_RAW.equals(str2) || MimeTypes.AUDIO_FLAC.equals(str2) || MimeTypes.AUDIO_ALAW.equals(str2) || MimeTypes.AUDIO_MLAW.equals(str2) || MimeTypes.AUDIO_MSGSM.equals(str2))) {
            return i;
        }
        if (MimeTypes.AUDIO_AC3.equals(str2)) {
            i2 = 6;
        } else {
            i2 = MimeTypes.AUDIO_E_AC3.equals(str2) ? 16 : 30;
        }
        com.opos.cmn.an.f.a.c(com.google.android.exoplayer2.mediacodec.MediaCodecInfo.TAG, "AssumedMaxChannelAdjustment: " + str + ", [" + i + " to " + i2 + "]");
        return i2;
    }

    public static a a(String str) {
        return new a(str, null, null, false, false);
    }

    public static a a(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z, boolean z2) {
        return new a(str, str2, codecCapabilities, z, z2);
    }

    private static boolean a(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return y.f6517a >= 19 && b(codecCapabilities);
    }

    private static boolean a(MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i2, double d) {
        return (d == -1.0d || d <= 0.0d) ? videoCapabilities.isSizeSupported(i, i2) : videoCapabilities.areSizeAndRateSupported(i, i2, d);
    }

    private static boolean b(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("adaptive-playback");
    }

    private void c(String str) {
        com.opos.cmn.an.f.a.b(com.google.android.exoplayer2.mediacodec.MediaCodecInfo.TAG, "NoSupport [" + str + "] [" + this.f6374a + ", " + this.e + "] [" + y.e + "]");
    }

    private static boolean c(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return y.f6517a >= 21 && d(codecCapabilities);
    }

    private void d(String str) {
        com.opos.cmn.an.f.a.b(com.google.android.exoplayer2.mediacodec.MediaCodecInfo.TAG, "AssumedSupport [" + str + "] [" + this.f6374a + ", " + this.e + "] [" + y.e + "]");
    }

    private static boolean d(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("tunneled-playback");
    }

    private static boolean e(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return y.f6517a >= 21 && f(codecCapabilities);
    }

    private static boolean f(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("secure-playback");
    }

    public Point a(int i, int i2) {
        String str;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f;
        if (codecCapabilities == null) {
            str = "align.caps";
        } else {
            MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
            if (videoCapabilities != null) {
                int widthAlignment = videoCapabilities.getWidthAlignment();
                int heightAlignment = videoCapabilities.getHeightAlignment();
                return new Point(y.a(i, widthAlignment) * widthAlignment, y.a(i2, heightAlignment) * heightAlignment);
            }
            str = "align.vCaps";
        }
        c(str);
        return null;
    }

    public boolean a(int i) {
        String str;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f;
        if (codecCapabilities == null) {
            str = "sampleRate.caps";
        } else {
            MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
            if (audioCapabilities == null) {
                str = "sampleRate.aCaps";
            } else {
                if (audioCapabilities.isSampleRateSupported(i)) {
                    return true;
                }
                str = "sampleRate.support, " + i;
            }
        }
        c(str);
        return false;
    }

    public boolean a(int i, int i2, double d) {
        String str;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f;
        if (codecCapabilities == null) {
            str = "sizeAndRate.caps";
        } else {
            MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
            if (videoCapabilities == null) {
                str = "sizeAndRate.vCaps";
            } else {
                if (a(videoCapabilities, i, i2, d)) {
                    return true;
                }
                if (i < i2 && a(videoCapabilities, i2, i, d)) {
                    d("sizeAndRate.rotated, " + i + "x" + i2 + "x" + d);
                    return true;
                }
                str = "sizeAndRate.support, " + i + "x" + i2 + "x" + d;
            }
        }
        c(str);
        return false;
    }

    public MediaCodecInfo.CodecProfileLevel[] a() {
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f;
        return (codecCapabilities == null || (codecProfileLevelArr = codecCapabilities.profileLevels) == null) ? new MediaCodecInfo.CodecProfileLevel[0] : codecProfileLevelArr;
    }

    public boolean b(int i) {
        String str;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f;
        if (codecCapabilities == null) {
            str = "channelCount.caps";
        } else {
            MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
            if (audioCapabilities == null) {
                str = "channelCount.aCaps";
            } else {
                if (a(this.f6374a, this.e, audioCapabilities.getMaxInputChannelCount()) >= i) {
                    return true;
                }
                str = "channelCount.support, " + i;
            }
        }
        c(str);
        return false;
    }

    public boolean b(String str) {
        String strD;
        StringBuilder sb;
        if (str == null || this.e == null || (strD = m.d(str)) == null) {
            return true;
        }
        if (this.e.equals(strD)) {
            Pair<Integer, Integer> pairA = d.a(str);
            if (pairA == null) {
                return true;
            }
            for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : a()) {
                if (codecProfileLevel.profile == ((Integer) pairA.first).intValue() && codecProfileLevel.level >= ((Integer) pairA.second).intValue()) {
                    return true;
                }
            }
            sb = new StringBuilder("codec.profileLevel, ");
        } else {
            sb = new StringBuilder("codec.mime ");
        }
        c(sb.append(str).append(", ").append(strD).toString());
        return false;
    }
}
