package com.byazt.whk;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 908, MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_AUTO_RECOVERY})
public class sp {
    public JSONObject c;

    public sp(JSONObject jSONObject) {
        this.c = jSONObject;
    }

    public String toString() {
        JSONObject jSONObject = this.c;
        return jSONObject != null ? jSONObject.toString() : "pitaya error is null";
    }

    public int c() {
        JSONObject jSONObject = this.c;
        if (jSONObject != null) {
            return jSONObject.optInt("code", -1);
        }
        return -1;
    }
}
