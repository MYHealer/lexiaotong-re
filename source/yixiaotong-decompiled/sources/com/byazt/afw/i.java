package com.byazt.afw;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_NATIVE_YV12_RENDER, 42})
public class i implements uj {
    public long c;
    public long tt;
    public int uj;
    public int ve;

    public void c(int i) {
        this.uj = i;
    }

    public void c(long j) {
        this.c = j;
    }

    public void tt(int i) {
        this.ve = i;
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
            jSONObject.put("video_start_duration", this.c);
            jSONObject.put("video_cache_size", this.tt);
            jSONObject.put("is_auto_play", this.ve);
            jSONObject.put("is_supplement_replay", this.uj);
        } catch (Throwable th) {
            com.byazt.nr.m.c(th);
        }
    }
}
