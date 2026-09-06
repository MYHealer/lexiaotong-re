package com.miui.zeus.mimo.sdk.server.api;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.miui.zeus.mimo.sdk.c4;
import com.miui.zeus.mimo.sdk.p4;
import com.miui.zeus.mimo.sdk.s3;
import ijiami_1011.NCall;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class AdRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f5599a;
    public String c;
    public p4 d;
    public String e;
    public String f;
    public String h;
    public c4 i;
    public int b = 1;
    public long g = System.currentTimeMillis();

    public s3 a() {
        return (s3) NCall.IL(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_MAX_RETRANSMISSION_TIME_MS), this});
    }

    public String b() {
        return (String) NCall.IL(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_MAX_ACK_DELAY), this});
    }

    public String toString() {
        return (String) NCall.IL(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_MIN_RECEIVED_BEFORE_ACK_DECIMATION), this});
    }
}
