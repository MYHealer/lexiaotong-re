package com.byazt.gu;

import com.byazt.eg.gu;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 17, MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_AUTO_RECOVERY})
public class sp extends com.byazt.gqp.uj {
    public gu c;

    public sp(gu guVar) {
        this.c = guVar;
    }

    @Override // com.byazt.gqp.uj
    public void c(int i) {
        this.c.my().c(i);
    }

    @Override // com.byazt.gqp.uj
    public void tt(int i) {
        if (i < 5) {
            this.c.my().tt(5);
        } else {
            this.c.my().tt(i);
        }
    }
}
