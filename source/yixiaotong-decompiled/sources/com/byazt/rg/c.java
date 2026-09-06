package com.byazt.rg;

import android.content.Context;
import com.byazt.fe.UGRatingBar;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_MAX_RECONNECT_COUNT, 20})
public class c extends com.byazt.fe.c {
    public c(Context context) {
        super(context);
    }

    @Override // com.byazt.fe.c, com.byazt.xj.ve
    /* JADX INFO: renamed from: sp */
    public UGRatingBar c() {
        UGNewRatingBar uGNewRatingBar = new UGNewRatingBar(this.tt);
        uGNewRatingBar.c(this);
        return uGNewRatingBar;
    }
}
