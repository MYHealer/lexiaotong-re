package com.byazt.dg;

import android.graphics.Path;
import android.graphics.PointF;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEODECODER_FPS, 42})
public class i extends com.byazt.vc.c<PointF> {
    public Path da;
    public final com.byazt.vc.c<PointF> sl;

    public Path tt() {
        return this.da;
    }

    public i(com.byazt.ga.a aVar, com.byazt.vc.c<PointF> cVar) {
        super(aVar, cVar.c, cVar.tt, cVar.ve, cVar.uj, cVar.n, cVar.f2810a, cVar.sp);
        this.sl = cVar;
        c();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void c() {
        boolean z = (this.tt == 0 || this.c == 0 || !((PointF) this.c).equals(((PointF) this.tt).x, ((PointF) this.tt).y)) ? false : true;
        if (this.c == 0 || this.tt == 0 || z) {
            return;
        }
        this.da = com.byazt.kk.da.c((PointF) this.c, (PointF) this.tt, this.sl.x, this.sl.i);
    }
}
