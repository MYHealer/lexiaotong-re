package com.byazt.lw;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.huawei.hms.ads.ez;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 2104, MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_AUTO_RECOVERY})
public class sp implements com.byazt.dr.c {
    public final Object c;

    @Override // com.byazt.dr.c
    public Object c(Map<String, JSONObject> map) {
        return this.c;
    }

    public sp(String str) {
        if (str.equalsIgnoreCase(ez.Code)) {
            this.c = Boolean.TRUE;
        } else if (str.equalsIgnoreCase(ez.V)) {
            this.c = Boolean.FALSE;
        } else {
            if (!str.equalsIgnoreCase("null")) {
                throw new IllegalArgumentException();
            }
            this.c = null;
        }
    }

    @Override // com.byazt.dr.c
    public com.byazt.zg.n c() {
        return com.byazt.zg.a.CONSTANT;
    }

    public String toString() {
        return "KeywordNode [keywordValue=" + this.c + "]";
    }

    @Override // com.byazt.dr.c
    public String tt() {
        Object obj = this.c;
        return obj != null ? obj.toString() : "NULL";
    }
}
