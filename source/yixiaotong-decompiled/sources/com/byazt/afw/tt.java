package com.byazt.afw;

import com.byazt.afw.uj;
import com.byazt.ete.ic;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_NATIVE_YV12_RENDER, 13})
public class tt<T extends uj> {
    public ic c;
    public boolean n = false;
    public String tt;
    public T uj;
    public JSONObject ve;

    public ic c() {
        return this.c;
    }

    public void c(boolean z) {
        this.n = z;
    }

    public boolean n() {
        return this.n;
    }

    public String tt() {
        return this.tt;
    }

    public T uj() {
        return this.uj;
    }

    public tt(ic icVar, String str, JSONObject jSONObject, T t) {
        this.c = icVar;
        this.tt = str;
        this.ve = jSONObject;
        this.uj = t;
    }

    public JSONObject ve() {
        if (this.ve == null) {
            this.ve = new JSONObject();
        }
        return this.ve;
    }
}
