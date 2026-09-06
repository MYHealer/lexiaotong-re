package com.miui.zeus.mimo.sdk.server;

import android.content.Context;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.miui.zeus.mimo.sdk.j5;
import com.miui.zeus.mimo.sdk.l5;
import com.miui.zeus.mimo.sdk.server.api.AdRequest;
import com.miui.zeus.mimo.sdk.server.api.AdResponse;
import com.miui.zeus.mimo.sdk.server.http.HttpRequest;
import com.miui.zeus.mimo.sdk.server.http.Server;
import ijiami_1011.NCall;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class MimoAdServer extends Server<AdResponse> {
    public AdRequest d;
    public Context e;
    public long f;
    public long g;

    public MimoAdServer(String str) {
        super(str);
    }

    public l5<AdResponse> a(Context context, AdRequest adRequest) {
        return (l5) NCall.IL(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_POST_STALL_500), this, context, adRequest});
    }

    @Override // com.miui.zeus.mimo.sdk.server.http.Server
    public l5<AdResponse> a(String str) {
        return (l5) NCall.IL(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_INIT_RTT), this, str});
    }

    @Override // com.miui.zeus.mimo.sdk.server.http.Server
    public String b() {
        return (String) NCall.IL(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_MAX_CRYPTO_RETRANSMISSIONS), this});
    }

    public void b(j5 j5Var) {
        NCall.IV(new Object[]{390, this, j5Var});
    }

    public l5<HttpRequest> c() {
        return (l5) NCall.IL(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_MAX_RETRANSMISSIONS), this});
    }
}
