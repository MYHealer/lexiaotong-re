package com.byazt.gv;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.huawei.openalliance.ad.constant.x;
import java.util.UUID;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_LOOPER_TIMEOUT, 54})
public abstract class ve implements tt, Comparable<ve>, Runnable {
    public tt.c c = tt.c.NORMAL;
    public String tt = UUID.randomUUID().toString() + x.A + String.valueOf(System.nanoTime());

    public tt.c c() {
        return this.c;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public int compareTo(ve veVar) {
        if (c().c() < veVar.c().c()) {
            return 1;
        }
        return c().c() > veVar.c().c() ? -1 : 0;
    }
}
