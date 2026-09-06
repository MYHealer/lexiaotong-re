package com.byazt.om;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SAMPLE_RATE, 15})
public class uj implements c {
    @Override // com.byazt.om.c
    public void c(c.InterfaceC0233c interfaceC0233c) {
        com.byazt.iz.tt ttVarC = interfaceC0233c.c();
        ttVarC.nu().c(0);
        int iVe = ttVarC.gu().ve();
        List<com.byazt.nbs.da> list = ttVarC.m().md().get(0);
        JSONObject jSONObject = new JSONObject();
        String strC = com.byazt.ug.c.c().c(ttVarC.gr(), ttVarC.getContext(), ttVarC.gu(), list, ttVarC.m(), iVe, !ttVarC.yv(), jSONObject);
        com.byazt.ng.a.c(ttVarC.gu(), jSONObject);
        ttVarC.c(strC);
    }

    @Override // com.byazt.om.c
    public void tt(c.InterfaceC0233c interfaceC0233c) {
        interfaceC0233c.c((String) null);
    }
}
