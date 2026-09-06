package com.byazt.jx;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 214, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_START_TIME})
public class nu implements ve {
    public final String c;
    public final int tt;
    public final boolean uj;
    public final com.byazt.kd.x ve;

    public String c() {
        return this.c;
    }

    public com.byazt.kd.x tt() {
        return this.ve;
    }

    public boolean ve() {
        return this.uj;
    }

    public nu(String str, int i, com.byazt.kd.x xVar, boolean z) {
        this.c = str;
        this.tt = i;
        this.ve = xVar;
        this.uj = z;
    }

    @Override // com.byazt.jx.ve
    public com.byazt.zy.ve c(com.byazt.ga.x xVar, com.byazt.ga.a aVar, com.byazt.zk.ve veVar) {
        return new com.byazt.zy.rh(xVar, veVar, this);
    }

    public String toString() {
        return "ShapePath{name=" + this.c + ", index=" + this.tt + '}';
    }
}
