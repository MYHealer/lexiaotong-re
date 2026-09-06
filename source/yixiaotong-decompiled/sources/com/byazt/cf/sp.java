package com.byazt.cf;

import android.content.Context;
import com.byazt.omf.gt;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 18, MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_AUTO_RECOVERY})
public class sp extends ve {
    public static final sp ve = new sp(gt.getContext());

    public static sp c() {
        return ve;
    }

    @Override // com.byazt.cf.ve
    public int tt() {
        return 7;
    }

    private sp(Context context) {
        super(context);
    }

    public void c(com.byazt.dj.tt ttVar, String str, int i, uj ujVar) {
        com.byazt.cjm.ve veVar = new com.byazt.cjm.ve();
        veVar.c(str);
        veVar.c(i + 1);
        c(ttVar, ujVar, veVar, null, null, null);
    }
}
