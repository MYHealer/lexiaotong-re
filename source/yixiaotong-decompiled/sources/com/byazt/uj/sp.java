package com.byazt.uj;

import android.app.Activity;
import com.byazt.nr.m;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.function.Function;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 15, MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_AUTO_RECOVERY})
public class sp extends ve {
    public sp(com.byazt.wn.tt ttVar, Function function) {
        super(ttVar, function);
    }

    @Override // com.byazt.yl.ve
    public void showAd(Activity activity, Object obj, String str) {
        try {
            showAd(activity);
        } catch (Exception e) {
            m.c(e);
        }
    }

    public void showAd(Activity activity) {
        if (this.x != null) {
            this.x.mediationCallShow();
        }
        if (this.i != null) {
            this.i.apply(com.byazt.yxi.uj.c().c(8113).c(20033, activity).c(Void.class).tt());
        }
    }
}
