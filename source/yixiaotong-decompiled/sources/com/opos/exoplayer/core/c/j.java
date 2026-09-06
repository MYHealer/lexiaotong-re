package com.opos.exoplayer.core.c;

import client.android.yixiaotong.zksoundwave.SWCommandUtil;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.android.exoplayer2.audio.OpusUtil;
import com.google.android.exoplayer2.util.MimeTypes;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class j {
    private static final String[] h = {MimeTypes.AUDIO_MPEG_L1, MimeTypes.AUDIO_MPEG_L2, MimeTypes.AUDIO_MPEG};
    private static final int[] i = {SWCommandUtil.SampleRate, OpusUtil.SAMPLE_RATE, 32000};
    private static final int[] j = {32, 64, 96, 128, 160, 192, 224, 256, 288, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_CHLO_COUNT, 384, 416, 448};
    private static final int[] k = {32, 48, 56, 64, 80, 96, 112, 128, MediaPlayer.MEDIA_PLAYER_OPTION_SPADE, 160, 176, 192, 224, 256};
    private static final int[] l = {32, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME, 384};
    private static final int[] m = {32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME};
    private static final int[] n = {8, 16, 24, 32, 40, 48, 56, 64, 80, 96, 112, 128, MediaPlayer.MEDIA_PLAYER_OPTION_SPADE, 160};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6368a;
    public String b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;

    public static int a(int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        if ((i2 & (-2097152)) != -2097152 || (i3 = (i2 >>> 19) & 3) == 1 || (i4 = (i2 >>> 17) & 3) == 0 || (i5 = (i2 >>> 12) & 15) == 0 || i5 == 15 || (i6 = (i2 >>> 10) & 3) == 3) {
            return -1;
        }
        int i8 = i[i6];
        if (i3 == 2) {
            i8 /= 2;
        } else if (i3 == 0) {
            i8 /= 4;
        }
        int i9 = (i2 >>> 9) & 1;
        if (i4 == 3) {
            return ((((i3 == 3 ? j[i5 - 1] : k[i5 - 1]) * 12000) / i8) + i9) * 4;
        }
        if (i3 == 3) {
            i7 = i4 == 2 ? l[i5 - 1] : m[i5 - 1];
        } else {
            i7 = n[i5 - 1];
        }
        if (i3 == 3) {
            return ((i7 * 144000) / i8) + i9;
        }
        return (((i4 == 1 ? 72000 : 144000) * i7) / i8) + i9;
    }

    private void a(int i2, String str, int i3, int i4, int i5, int i6, int i7) {
        this.f6368a = i2;
        this.b = str;
        this.c = i3;
        this.d = i4;
        this.e = i5;
        this.f = i6;
        this.g = i7;
    }

    public static boolean a(int i2, j jVar) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        if ((i2 & (-2097152)) != -2097152 || (i3 = (i2 >>> 19) & 3) == 1 || (i4 = (i2 >>> 17) & 3) == 0 || (i5 = (i2 >>> 12) & 15) == 0 || i5 == 15 || (i6 = (i2 >>> 10) & 3) == 3) {
            return false;
        }
        int i11 = i[i6];
        if (i3 == 2) {
            i11 /= 2;
        } else if (i3 == 0) {
            i11 /= 4;
        }
        int i12 = i11;
        int i13 = (i2 >>> 9) & 1;
        if (i4 == 3) {
            i7 = i3 == 3 ? j[i5 - 1] : k[i5 - 1];
            i9 = (((i7 * 12000) / i12) + i13) * 4;
            i10 = 384;
        } else {
            int i14 = 1152;
            if (i3 == 3) {
                i7 = i4 == 2 ? l[i5 - 1] : m[i5 - 1];
                i8 = 144000 * i7;
            } else {
                i7 = n[i5 - 1];
                i14 = i4 == 1 ? 576 : 1152;
                i8 = (i4 == 1 ? 72000 : 144000) * i7;
            }
            i9 = (i8 / i12) + i13;
            i10 = i14;
        }
        jVar.a(i3, h[3 - i4], i9, i12, ((i2 >> 6) & 3) == 3 ? 1 : 2, i7 * 1000, i10);
        return true;
    }
}
