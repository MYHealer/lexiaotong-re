package com.byazt.lw;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 2104, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_START_TIME})
public abstract class nu implements com.byazt.dr.c {
    public com.byazt.dr.c c;
    public com.byazt.dr.c tt;
    public com.byazt.zg.ve ve;

    public void c(com.byazt.dr.c cVar) {
        this.c = cVar;
    }

    public void tt(com.byazt.dr.c cVar) {
        this.tt = cVar;
    }

    public nu(com.byazt.zg.ve veVar) {
        this.ve = veVar;
    }

    @Override // com.byazt.dr.c
    public com.byazt.zg.n c() {
        return com.byazt.zg.a.OPERATOR_RESULT;
    }

    @Override // com.byazt.dr.c
    public String tt() {
        return this.c.tt() + this.ve.c() + this.tt.tt();
    }

    public String toString() {
        return tt();
    }
}
