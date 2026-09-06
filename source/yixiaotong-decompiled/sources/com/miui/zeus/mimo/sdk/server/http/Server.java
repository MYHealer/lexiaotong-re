package com.miui.zeus.mimo.sdk.server.http;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.common.base.Ascii;
import com.miui.zeus.mimo.sdk.j5;
import com.miui.zeus.mimo.sdk.l5;
import com.miui.zeus.mimo.sdk.m5;
import ijiami_1011.NCall;
import ijiami_1011.s.s.s;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public abstract class Server<T extends m5> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5607a;
    public String b;
    public String c;

    public Server(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException(s.d(new byte[]{69, 74, 90, 17, 2, 3, 15, 67, Ascii.DC2, 66, 83, 0, 16, 86, 67, 93, 13}, "0861ab"));
        }
        this.f5607a = str;
        System.currentTimeMillis();
    }

    public final l5<T> a(j5 j5Var) {
        return (l5) NCall.IL(new Object[]{384, this, j5Var});
    }

    public abstract l5<T> a(String str);

    public final String a() {
        return (String) NCall.IL(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DEMUXER_STALL_500), this});
    }

    public final void a(HttpRequest httpRequest) {
        NCall.IV(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_PRE_STALL_500), this, httpRequest});
    }

    public abstract String b();
}
