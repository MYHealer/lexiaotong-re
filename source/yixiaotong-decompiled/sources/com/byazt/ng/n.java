package com.byazt.ng;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_INTERRUPT, 46})
public class n {
    public final boolean c;
    public final int tt;
    public final boolean uj;
    public final String ve;

    public n(boolean z, int i, String str, boolean z2) {
        this.c = z;
        this.tt = i;
        this.ve = str;
        this.uj = z2;
    }

    public String toString() {
        return "AdEventUploadResult{mSuccess=" + this.c + ", mStatusCode=" + this.tt + ", mMsg='" + this.ve + "', mIsDataError=" + this.uj + '}';
    }
}
