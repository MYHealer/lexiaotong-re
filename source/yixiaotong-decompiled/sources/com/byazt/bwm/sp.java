package com.byazt.bwm;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 33, MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_AUTO_RECOVERY})
public abstract class sp implements Comparable<sp>, Runnable {
    public int c;
    public String tt;

    public int c() {
        return this.c;
    }

    public void c(int i) {
        this.c = i;
    }

    public sp(String str, int i) {
        this.c = 0;
        this.c = i == 0 ? 5 : i;
        this.tt = str;
    }

    public sp(String str) {
        this.c = 5;
        this.tt = str;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public int compareTo(sp spVar) {
        if (c() < spVar.c()) {
            return 1;
        }
        return c() >= spVar.c() ? -1 : 0;
    }
}
