package com.byazt.afw;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_NATIVE_YV12_RENDER, 72})
public class da extends c {
    public String c;
    public long tt;

    public da(String str, long j) {
        this.c = str;
        this.tt = j;
    }

    @Override // com.byazt.afw.uj
    public void a_(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("preload_url", this.c);
            jSONObject.put("preload_size", this.tt);
            c(jSONObject);
        } catch (Throwable th) {
            com.byazt.nr.m.c(th);
        }
    }
}
