package com.byazt.h;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_TCP_FAST_OPEN_SUCCESS, 71})
public class x implements n {
    public final n c;
    public final n tt;

    public x(n nVar, n nVar2) {
        this.c = nVar;
        this.tt = nVar2;
    }

    @Override // com.byazt.h.n
    public void tt(c cVar) throws IOException {
        cVar.tt = this.tt;
        this.c.tt(cVar);
    }
}
