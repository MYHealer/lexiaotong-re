package com.byazt.afw;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_NATIVE_YV12_RENDER, 130})
public class m implements uj {
    public long c;
    public boolean tt;

    public void c(long j) {
        this.c = j;
    }

    public void c(boolean z) {
        this.tt = z;
    }

    @Override // com.byazt.afw.uj
    public void a_(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("video_cache_size", this.c);
            jSONObject.put("is_auto_play", this.tt);
        } catch (Throwable th) {
            com.byazt.nr.m.c(th);
        }
    }
}
