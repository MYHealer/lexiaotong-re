package com.byazt.fdg;

import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, AVMDLDataLoader.KeyIsPreloadWaitListType, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_START_TIME})
public class nu extends Exception {
    public final int c;

    public nu(int i, String str) {
        super(str);
        this.c = i;
    }

    public nu(int i, String str, Throwable th) {
        super(str, th);
        this.c = i;
    }
}
