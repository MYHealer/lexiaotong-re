package com.byazt.afw;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_NATIVE_YV12_RENDER, MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_AUTO_RECOVERY})
public class sp implements uj {
    public long c;
    public long tt;
    public int ve = 0;

    public void c(int i) {
        this.ve = i;
    }

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
            jSONObject.put("total_duration", this.c);
            jSONObject.put("buffers_time", this.tt);
            jSONObject.put("video_backup", this.ve);
        } catch (Throwable th) {
            com.byazt.nr.m.c(th);
        }
    }
}
