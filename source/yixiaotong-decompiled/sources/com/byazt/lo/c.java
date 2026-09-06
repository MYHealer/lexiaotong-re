package com.byazt.lo;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_IGNORE_BACKGROUND_RENDERSTALL, 20})
public class c {
    public JSONArray c;
    public JSONObject n;
    public JSONObject tt;
    public JSONObject uj;
    public JSONObject ve;

    public JSONArray c() {
        return this.c;
    }

    public void c(JSONArray jSONArray) {
        this.c = jSONArray;
    }

    public void c(JSONObject jSONObject) {
        this.tt = jSONObject;
    }

    public JSONObject n() {
        return this.n;
    }

    public JSONObject tt() {
        return this.tt;
    }

    public void tt(JSONObject jSONObject) {
        this.ve = jSONObject;
    }

    public JSONObject uj() {
        return this.uj;
    }

    public void uj(JSONObject jSONObject) {
        this.n = jSONObject;
    }

    public JSONObject ve() {
        return this.ve;
    }

    public void ve(JSONObject jSONObject) {
        this.uj = jSONObject;
    }
}
