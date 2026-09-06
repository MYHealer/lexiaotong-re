package com.byazt.om;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SAMPLE_RATE, 54})
public class ve implements c {
    @Override // com.byazt.om.c
    public void c(c.InterfaceC0233c interfaceC0233c) {
        com.byazt.iz.tt ttVarC = interfaceC0233c.c();
        com.byazt.ll.tt ttVarGu = ttVarC.gu();
        com.byazt.nbs.tt ttVarM = ttVarC.m();
        com.byazt.nbs.tt ttVarC2 = com.byazt.xx.ve.c(ttVarGu, ttVarM);
        if (ttVarC2 != null) {
            if (ttVarGu.ve() == 2 || ttVarGu.ve() == 4 || ttVarGu.ve() == 5) {
                com.byazt.ix.uj.c().c(ttVarGu.gt(), ttVarGu);
            }
            ttVarM = ttVarC2;
        }
        if (ttVarM.l() == null || ttVarM.l().size() == 0) {
            com.byazt.ng.a.c(ttVarGu, ttVarC.m() != null ? ttVarC.m().lo() : null, !ttVarC.yv(), ttVarC.pf().c, 810085, (Map<String, Object>) null);
            ttVarC.c(new com.byazt.pp.c(810085, com.byazt.pp.c.c(810085)));
        } else {
            ttVarC.c(ttVarM);
            interfaceC0233c.c(interfaceC0233c.c());
        }
    }

    @Override // com.byazt.om.c
    public void tt(c.InterfaceC0233c interfaceC0233c) {
        interfaceC0233c.c((String) null);
    }
}
