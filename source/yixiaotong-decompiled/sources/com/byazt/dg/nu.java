package com.byazt.dg;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEODECODER_FPS, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_START_TIME})
public class nu<K, A> extends c<K, A> {
    public final A uj;

    @Override // com.byazt.dg.c
    public float a() {
        return 1.0f;
    }

    @Override // com.byazt.dg.c
    public void c(float f) {
        this.tt = f;
    }

    @Override // com.byazt.dg.c
    public void tt() {
        if (this.ve != null) {
            super.tt();
        }
    }

    @Override // com.byazt.dg.c
    public A sp() {
        com.byazt.vc.ve<A> veVar = this.ve;
        A a2 = this.uj;
        return veVar.c(0.0f, 0.0f, a2, a2, x(), x(), x());
    }

    @Override // com.byazt.dg.c
    public A c(com.byazt.vc.c<K> cVar, float f) {
        return sp();
    }
}
