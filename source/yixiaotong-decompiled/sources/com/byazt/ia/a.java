package com.byazt.ia;

import android.content.Context;
import com.byazt.uy.x;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_EXACT, 34})
@Deprecated
public class a extends ve {
    public a(Context context, tt ttVar, uj ujVar) {
        super(com.byazt.uy.ve.CUSTOM_JAVA, context, ttVar, ujVar);
    }

    @Override // com.byazt.ia.ve
    public com.byazt.xz.c c(com.byazt.xz.c cVar) {
        com.byazt.xz.c cVarC = super.c(cVar);
        com.byazt.xz.tt ttVarC = com.byazt.xz.tt.c(this.tt);
        ttVarC.c(x.c().c());
        ttVarC.c(x.ve().c());
        ttVarC.tt(this.ve.ve());
        cVarC.c(ttVarC);
        return cVarC;
    }
}
