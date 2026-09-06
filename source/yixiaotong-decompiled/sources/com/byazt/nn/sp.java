package com.byazt.nn;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 1020, MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_AUTO_RECOVERY})
public class sp {
    public int c;
    public int tt;
    public String ve;

    public int c() {
        return this.tt;
    }

    public int getType() {
        return this.c;
    }

    public String tt() {
        return this.ve;
    }

    public sp(int i) {
        this(i, 0, null);
    }

    public sp(int i, int i2) {
        this(i, i2, null);
    }

    public sp(int i, String str) {
        this(i, 0, str);
    }

    public sp(int i, int i2, String str) {
        this.c = i;
        this.tt = i2;
        this.ve = str;
    }
}
