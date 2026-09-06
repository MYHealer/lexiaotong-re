package com.miui.zeus.mimo.sdk.server.api;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.miui.zeus.mimo.sdk.bean.MimoAdInfo;
import com.miui.zeus.mimo.sdk.m5;
import ijiami_1011.NCall;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class AdResponse extends m5 {
    public JSONObject d;
    public JSONObject e;
    public List<MimoAdInfo> f;
    public long g;

    public AdResponse(String str) {
        super(str);
    }

    @Override // com.miui.zeus.mimo.sdk.m5
    public void a(JSONObject jSONObject) {
        NCall.IV(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_PAD_HELLO), this, jSONObject});
    }

    @Override // com.miui.zeus.mimo.sdk.m5
    public boolean a() {
        return NCall.IZ(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_ENABLE_UNRELIABLE), this});
    }
}
