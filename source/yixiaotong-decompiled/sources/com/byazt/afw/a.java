package com.byazt.afw;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_NATIVE_YV12_RENDER, 34})
public class a implements uj {
    public long c;
    public long tt;

    public void c(long j) {
        this.c = j;
    }

    public void tt(long j) {
        this.tt = j;
    }

    @Override // com.byazt.afw.uj
    public void a_(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("buffers_time", this.c);
            jSONObject.put("total_duration", this.tt);
        } catch (Throwable th) {
            com.byazt.nr.m.c(th);
        }
    }
}
