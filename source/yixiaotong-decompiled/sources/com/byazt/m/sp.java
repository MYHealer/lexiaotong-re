package com.byazt.m;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 130, MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_AUTO_RECOVERY})
public class sp extends BaseException {
    public sp(int i, String str) {
        super(i, str);
    }

    public sp c(String str) {
        setExtraInfo(str);
        return this;
    }

    public String c() {
        return getExtraInfo();
    }
}
