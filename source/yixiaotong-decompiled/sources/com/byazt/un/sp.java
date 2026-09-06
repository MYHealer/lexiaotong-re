package com.byazt.un;

import com.byazt.nr.m;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 96, MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_AUTO_RECOVERY})
public class sp {
    public a c;

    public sp(a aVar) {
        this.c = aVar;
    }

    public boolean c() {
        boolean zC = this.c.p != null ? this.c.p.c() : false;
        m.c("ClickCreativeListener", "isVisible=" + zC + ",mPlayBtn.getVisibility() == VISIBLE->" + (this.c.ve.getVisibility() == 0));
        return zC || this.c.ve.getVisibility() == 0;
    }

    public boolean tt() {
        if (com.byazt.ex.c.c(this.c.zm)) {
            return true;
        }
        return (this.c.x != null && this.c.x.getVisibility() == 0) || (this.c.da != null && this.c.da.getVisibility() == 0) || ((this.c.sl != null && this.c.sl.getVisibility() == 0) || (this.c.t != null && this.c.t.getVisibility() == 0));
    }
}
