package com.byazt.sz;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SUB, 130})
public class m {
    public com.byazt.xj.ve c;
    public m n;
    public int tt;
    public m uj;
    public JSONObject ve;

    public com.byazt.xj.ve c() {
        return this.c;
    }

    public void c(int i) {
        this.tt = i;
    }

    public void c(m mVar) {
        this.uj = mVar;
    }

    public void c(com.byazt.xj.ve veVar) {
        this.c = veVar;
    }

    public void c(JSONObject jSONObject) {
        this.ve = jSONObject;
    }

    public int tt() {
        return this.tt;
    }

    public void tt(m mVar) {
        this.n = mVar;
    }

    public m uj() {
        return this.uj;
    }

    public JSONObject ve() {
        return this.ve;
    }

    public String toString() {
        return "UGenEvent{mWidget=" + this.c + ", mEventType=" + this.tt + ", mEvent=" + this.ve + '}';
    }
}
