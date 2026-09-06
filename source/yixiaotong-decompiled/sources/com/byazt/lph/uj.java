package com.byazt.lph;

import android.os.HandlerThread;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_MAX_ACK_DELAY, 15})
public class uj extends HandlerThread {
    public n c;

    public void c(n nVar) {
        this.c = nVar;
    }

    public uj() {
        super("csj_openlog");
    }

    @Override // android.os.HandlerThread
    public void onLooperPrepared() {
        super.onLooperPrepared();
        n nVar = this.c;
        if (nVar != null) {
            nVar.ve();
        }
    }
}
