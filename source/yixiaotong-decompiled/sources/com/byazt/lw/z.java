package com.byazt.lw;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 2104, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class z implements com.byazt.dr.c {
    public Number c;

    @Override // com.byazt.dr.c
    public Object c(Map<String, JSONObject> map) {
        return this.c;
    }

    public z(String str) {
        if (str.indexOf(46) >= 0) {
            Float fValueOf = Float.valueOf(str);
            this.c = fValueOf;
            if (Float.isInfinite(fValueOf.floatValue())) {
                this.c = Double.valueOf(str);
                return;
            }
            return;
        }
        try {
            this.c = Integer.valueOf(str);
        } catch (NumberFormatException unused) {
            this.c = Long.valueOf(str);
        }
    }

    @Override // com.byazt.dr.c
    public com.byazt.zg.n c() {
        return com.byazt.zg.a.NUMBER;
    }

    @Override // com.byazt.dr.c
    public String tt() {
        return this.c.toString();
    }

    public String toString() {
        return tt();
    }
}
