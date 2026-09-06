package com.byazt.ouz;

import android.content.Context;
import com.byazt.ete.ic;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 27, MediaPlayer.MEDIA_PLAYER_OPTION_PRE_DECODE_AUTO_PAUSE})
public class gr extends zm {
    public gr(Context context, ic icVar, com.byazt.dj.tt ttVar, int i) {
        super(context, icVar, ttVar, i);
    }

    @Override // com.byazt.ouz.zm, com.byazt.ouz.gu
    public void initExpressView(Context context, ic icVar, com.byazt.dj.tt ttVar) {
        this.uj = "draw_ad";
        this.c = new NativeExpressDrawVideoView(context, icVar, ttVar, "draw_ad");
        c(this.c, this.ve);
    }

    @Override // com.byazt.ouz.tt, com.byazt.nc.yp
    public void setCanInterruptVideoPlay(boolean z) {
        if (this.c != null) {
            ((NativeExpressVideoView) this.c).setCanInterruptVideoPlay(z);
        }
    }
}
