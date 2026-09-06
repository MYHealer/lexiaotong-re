package com.byazt.afw;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_NATIVE_YV12_RENDER, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class z implements uj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public JSONArray f1971a;
    public long c;
    public int da;
    public long i;
    public String n;
    public boolean sl;
    public int sp;
    public long tt;
    public int uj;
    public int ve;
    public long x;

    public void c(int i) {
        this.da = i;
    }

    public void c(long j) {
        this.i = j;
    }

    public void c(String str) {
        this.n = str;
    }

    public void c(JSONArray jSONArray) {
        this.f1971a = jSONArray;
    }

    public void c(boolean z) {
        this.sl = z;
    }

    public void tt(int i) {
        this.sp = i;
    }

    public void tt(long j) {
        this.x = j;
    }

    public void uj(int i) {
        this.uj = i;
    }

    public void uj(long j) {
        this.tt = j;
    }

    public void ve(int i) {
        this.ve = i;
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
            jSONObject.put("error_code", this.ve);
            jSONObject.put("extra_error_code", this.uj);
            jSONObject.put("error_message", this.n);
            jSONObject.put("event_list", this.f1971a);
            jSONObject.put("vbtt_skip_type", this.sp);
            jSONObject.put("video_cache_size", this.x);
            jSONObject.put("current", this.i);
            jSONObject.put("percent", this.da);
            jSONObject.put("has_endcard_skip", this.sl);
        } catch (Throwable th) {
            com.byazt.nr.m.c(th);
        }
    }
}
