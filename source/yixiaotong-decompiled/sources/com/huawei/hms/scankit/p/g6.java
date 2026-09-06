package com.huawei.hms.scankit.p;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.huawei.openalliance.ad.constant.ai;

/* JADX INFO: compiled from: SymbolInfo.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class g6 {
    static final g6[] i;
    private static g6[] j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f4264a;
    private final int b;
    private final int c;
    public final int d;
    public final int e;
    private final int f;
    private final int g;
    private final int h;

    static {
        g6[] g6VarArr = {new g6(false, 3, 5, 8, 8, 1), new g6(false, 5, 7, 10, 10, 1), new g6(true, 5, 7, 16, 6, 1), new g6(false, 8, 10, 12, 12, 1), new g6(true, 10, 11, 14, 6, 2), new g6(false, 12, 12, 14, 14, 1), new g6(true, 16, 14, 24, 10, 1), new g6(false, 18, 14, 16, 16, 1), new g6(false, 22, 18, 18, 18, 1), new g6(true, 22, 18, 16, 10, 2), new g6(false, 30, 20, 20, 20, 1), new g6(true, 32, 24, 16, 14, 2), new g6(false, 36, 24, 22, 22, 1), new g6(false, 44, 28, 24, 24, 1), new g6(true, 49, 28, 22, 14, 2), new g6(false, 62, 36, 14, 14, 4), new g6(false, 86, 42, 16, 16, 4), new g6(false, 114, 48, 18, 18, 4), new g6(false, MediaPlayer.MEDIA_PLAYER_OPTION_SPADE, 56, 20, 20, 4), new g6(false, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_BITRATE, 68, 22, 22, 4), new g6(false, 204, 84, 24, 24, 4, 102, 42), new g6(false, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEOCODEC_PIXEL_ALIGN, 112, 14, 14, 16, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_CODEC_ID, 56), new g6(false, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_PTS_SYNCED_SEI_NOTIFICATION, MediaPlayer.MEDIA_PLAYER_OPTION_SPADE, 16, 16, 16, 92, 36), new g6(false, MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_HTTP_RES_FINISH_TIME, 192, 18, 18, 16, 114, 48), new g6(false, 576, 224, 20, 20, 16, MediaPlayer.MEDIA_PLAYER_OPTION_SPADE, 56), new g6(false, 696, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_HTTP_REQ_FINSIH_TIME, 22, 22, 16, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_BITRATE, 68), new g6(false, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_EARLY_INIT_RENDER, MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_DEVICE_WAIT_START_TIME, 24, 24, 16, MediaPlayer.MEDIA_PLAYER_OPTION_SET_PIPE_DECLARE_LENGTH, 56), new g6(false, 1050, 408, 18, 18, 36, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED, 68), new g6(false, 1304, ai.v, 20, 20, 36, 163, 62), new c1()};
        i = g6VarArr;
        j = g6VarArr;
    }

    public g6(boolean z, int i2, int i3, int i4, int i5, int i6) {
        this(z, i2, i3, i4, i5, i6, i2, i3);
    }

    public static g6 a(int i2, h6 h6Var, b2 b2Var, b2 b2Var2, boolean z) {
        for (g6 g6Var : j) {
            if (!(h6Var == h6.FORCE_SQUARE && g6Var.f4264a) && ((h6Var != h6.FORCE_RECTANGLE || g6Var.f4264a) && ((b2Var == null || (g6Var.h() >= b2Var.b() && g6Var.g() >= b2Var.a())) && ((b2Var2 == null || (g6Var.h() <= b2Var2.b() && g6Var.g() <= b2Var2.a())) && i2 <= g6Var.b)))) {
                return g6Var;
            }
        }
        if (z) {
            throw new IllegalArgumentException("Can't find a symbol arrangement that matches the message. Data codewords: " + i2);
        }
        return null;
    }

    public final int a() {
        return this.b;
    }

    public int a(int i2) {
        return this.g;
    }

    public final int b() {
        return this.c;
    }

    public final int b(int i2) {
        return this.h;
    }

    public int d() {
        return this.b / this.g;
    }

    public final int e() {
        return i() * this.e;
    }

    public final int f() {
        return c() * this.d;
    }

    public final int g() {
        return e() + (i() * 2);
    }

    public final int h() {
        return f() + (c() * 2);
    }

    public final String toString() {
        return (this.f4264a ? "Rectangular Symbol:" : "Square Symbol:") + " data region " + this.d + 'x' + this.e + ", symbol size " + h() + 'x' + g() + ", symbol data size " + f() + 'x' + e() + ", codewords " + this.b + '+' + this.c;
    }

    g6(boolean z, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.f4264a = z;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.e = i5;
        this.f = i6;
        this.g = i7;
        this.h = i8;
    }

    private int c() {
        int i2 = this.f;
        int i3 = 1;
        if (i2 != 1) {
            i3 = 2;
            if (i2 != 2 && i2 != 4) {
                if (i2 == 16) {
                    return 4;
                }
                if (i2 == 36) {
                    return 6;
                }
                throw new IllegalStateException("Cannot handle this number of data regions");
            }
        }
        return i3;
    }

    private int i() {
        int i2 = this.f;
        if (i2 == 1 || i2 == 2) {
            return 1;
        }
        if (i2 == 4) {
            return 2;
        }
        if (i2 == 16) {
            return 4;
        }
        if (i2 == 36) {
            return 6;
        }
        throw new IllegalStateException("Cannot handle this number of data regions");
    }
}
