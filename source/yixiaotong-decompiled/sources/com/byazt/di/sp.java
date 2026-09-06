package com.byazt.di;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DROP_AUDIO_PTS, MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_AUTO_RECOVERY})
public class sp {
    public static volatile sp c;
    public com.byazt.ou.a tt = null;

    public com.byazt.ou.a tt() {
        return this.tt;
    }

    private sp() {
    }

    public static sp c() {
        if (c == null) {
            synchronized (sp.class) {
                if (c == null) {
                    c = new sp();
                }
            }
        }
        return c;
    }
}
