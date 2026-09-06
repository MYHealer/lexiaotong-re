package com.byazt.ia;

import android.content.Context;
import com.byazt.mg.sl;
import com.byazt.uy.x;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_EXACT, MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_AUTO_RECOVERY})
public class sp extends ve {
    public sp(Context context, tt ttVar, uj ujVar) {
        super(com.byazt.uy.ve.JAVA, context, ttVar, ujVar);
    }

    @Override // com.byazt.ia.ve
    public com.byazt.xz.c c(com.byazt.xz.c cVar) {
        com.byazt.xz.c cVarC = super.c(cVar);
        cVarC.c("app_count", (Object) 1);
        cVarC.c("magic_tag", "ss_app_log");
        ve(cVarC);
        com.byazt.xz.tt ttVarC = com.byazt.xz.tt.c(this.tt);
        ttVarC.c(x.c().c());
        ttVarC.c(x.ve().c());
        ttVarC.tt(this.ve.ve());
        cVarC.c(ttVarC);
        sl.c(cVarC, ttVarC, this.c);
        return cVarC;
    }
}
