package com.byazt.rs;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DECODE_SEI_ONCE, 15})
public class uj {
    public final String c;
    public final String tt;
    public final String uj;
    public final String ve;

    public String c() {
        return this.c;
    }

    public String tt() {
        return this.ve;
    }

    public String ve() {
        return this.uj;
    }

    public uj(String str, String str2, String str3, String str4) {
        this.c = str;
        this.tt = str2;
        this.ve = str3;
        this.uj = str4 == null ? "img_0.png" : str4;
    }
}
