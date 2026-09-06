package com.byazt.h;

import com.byazt.m.BaseException;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_TCP_FAST_OPEN_SUCCESS, 72})
public class da extends BaseException {
    public int c;

    public da(int i, String str) {
        super(1072, "applyCode=" + i + ", " + str);
        this.c = i;
    }
}
