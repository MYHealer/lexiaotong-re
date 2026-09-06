package com.byazt.afw;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_NATIVE_YV12_RENDER, 54})
public class ve implements uj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f1970a;
    public long c;
    public long n;
    public int sp;
    public long tt;
    public int uj;
    public int ve;

    public void c(int i) {
        this.sp = i;
    }

    public void c(long j) {
        this.f1970a = j;
    }

    public void tt(int i) {
        this.ve = i;
    }

    public void tt(long j) {
        this.n = j;
    }

    public void uj(long j) {
        this.tt = j;
    }

    public void ve(int i) {
        this.uj = i;
    }

    public void ve(long j) {
        this.c = j;
    }

    @Override // com.byazt.afw.uj
    public void a_(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("buffers_time", this.c);
            jSONObject.put("total_duration", this.tt);
            jSONObject.put("vbtt_skip_type", this.ve);
            jSONObject.put("skip_reason", this.uj);
            jSONObject.put("video_cache_size", this.n);
            jSONObject.put("current", this.f1970a);
            jSONObject.put("percent", this.sp);
        } catch (Throwable th) {
            com.byazt.nr.m.c(th);
        }
    }
}
