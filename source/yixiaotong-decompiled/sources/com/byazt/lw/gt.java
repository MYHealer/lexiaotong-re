package com.byazt.lw;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 2104, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO})
public class gt implements com.byazt.dr.c {
    public final String c;

    @Override // com.byazt.dr.c
    public Object c(Map<String, JSONObject> map) {
        return this.c;
    }

    public gt(String str) {
        this.c = str;
    }

    @Override // com.byazt.dr.c
    public com.byazt.zg.n c() {
        return com.byazt.zg.a.STRING;
    }

    @Override // com.byazt.dr.c
    public String tt() {
        return "'" + this.c + "'";
    }

    public String toString() {
        return tt();
    }
}
