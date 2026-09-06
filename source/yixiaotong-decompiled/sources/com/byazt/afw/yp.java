package com.byazt.afw;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_NATIVE_YV12_RENDER, 215})
public class yp implements uj {
    public long c;
    public int tt;
    public long ve;

    public void c(int i) {
        this.tt = i;
    }

    public void c(long j) {
        this.c = j;
    }

    public void tt(long j) {
        this.ve = j;
    }

    @Override // com.byazt.afw.uj
    public void a_(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("buffers_time", this.c);
            jSONObject.put("buffers_count", this.tt);
            jSONObject.put("total_duration", this.ve);
        } catch (Throwable th) {
            com.byazt.nr.m.c(th);
        }
    }
}
