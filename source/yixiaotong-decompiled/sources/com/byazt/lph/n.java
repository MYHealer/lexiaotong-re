package com.byazt.lph;

import android.os.Looper;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_MAX_ACK_DELAY, 46})
public class n {
    public volatile uj c;
    public final com.byazt.vb.n tt;
    public final com.byazt.mv.tt ve;

    public void ve() {
    }

    public n(com.byazt.vb.n nVar, com.byazt.mv.tt ttVar) {
        this.tt = nVar;
        this.ve = ttVar;
    }

    public uj n() {
        if (this.c == null) {
            synchronized (this) {
                if (this.c == null) {
                    this.c = new uj();
                }
            }
        }
        return this.c;
    }

    public void a() {
        com.byazt.vb.uj ujVarUj = this.tt.uj();
        if (ujVarUj == null || ujVarUj.z() == null) {
            uj ujVarN = n();
            ujVarN.c(this);
            ujVarN.start();
            return;
        }
        ve();
    }

    public Looper sp() {
        com.byazt.vb.uj ujVarUj = this.tt.uj();
        if (ujVarUj == null || ujVarUj.z() == null) {
            return n().getLooper();
        }
        return ujVarUj.z();
    }
}
