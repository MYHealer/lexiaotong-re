package com.byazt.nb;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ALGORITHM, MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_AUTO_RECOVERY})
public class sp {
    public final float c;
    public final float tt;
    public final String ve;

    public sp(String str, float f, float f2) {
        this.ve = str;
        this.tt = f2;
        this.c = f;
    }

    public boolean c(String str) {
        if (this.ve.equalsIgnoreCase(str)) {
            return true;
        }
        if (this.ve.endsWith("\r")) {
            String str2 = this.ve;
            if (str2.substring(0, str2.length() - 1).equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }
}
