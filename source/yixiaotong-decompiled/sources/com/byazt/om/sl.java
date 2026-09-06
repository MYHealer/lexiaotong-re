package com.byazt.om;

import android.os.SystemClock;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.opos.acs.st.utils.ErrorContants;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SAMPLE_RATE, 158})
public class sl implements c {
    @Override // com.byazt.om.c
    public void c(c.InterfaceC0233c interfaceC0233c) {
        com.byazt.iz.tt ttVarC = interfaceC0233c.c();
        com.byazt.ll.tt ttVarGu = ttVarC.gu();
        ttVarGu.gt();
        if (ttVarGu != null && ttVarGu.tk()) {
            String str = "TTMediationSDK";
            com.byazt.eu.tt.tt("TTMediationSDK", com.byazt.eu.uj.c(ttVarGu.gt()) + "V2 公共缓存池广告请求......");
            String strLo = ttVarC.m() != null ? ttVarC.m().lo() : null;
            boolean z = !ttVarC.yv();
            if (com.byazt.bp.tt.tt().x()) {
                List<com.byazt.ix.sp> listC = com.byazt.vy.c.c().c(ttVarGu);
                if (listC != null && !listC.isEmpty()) {
                    com.byazt.ng.a.c(listC.get(0).c, ttVarGu, ttVarC.m(), 0L, ttVarC.pf().c, z, listC != null ? listC.size() : 0, ttVarC.pf().n, false);
                    int size = listC.size() - 1;
                    String strA = null;
                    while (size >= 0) {
                        com.byazt.ix.sp spVar = listC.get(size);
                        com.byazt.yl.ve veVar = spVar.c;
                        veVar.setOriginPrimeRit(spVar.a());
                        veVar.setOriginLinkId(spVar.uj() != null ? spVar.uj().c() : null);
                        if (size == 0) {
                            strA = spVar.a();
                        }
                        String str2 = strA;
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(veVar);
                        com.byazt.vy.c.c(ttVarGu, spVar.a());
                        com.byazt.ll.tt ttVar = ttVarGu;
                        com.byazt.ng.a.c(com.byazt.bp.tt.tt().c(spVar.a(), ttVarGu.my(), 102).a(veVar.getAdNetworkSlotId()), ttVarGu, com.byazt.hk.c.c().c(veVar.getAdNetworkSlotId()), true, 1, 0, 3, 3, null, -1L, false, false, spVar.uj() != null ? spVar.uj().c() : null, SystemClock.elapsedRealtime() - ttVarC.cu());
                        com.byazt.tjo.a.c(ttVarC.ve(), ttVarC.c(veVar), ttVarC.cu());
                        ttVarC.tt(arrayList);
                        com.byazt.ng.a.c(veVar, 0, "adn cache命中", 0L, ttVar, 0, arrayList.size(), 2, null, 0L, -1L);
                        com.byazt.tjo.a.c(ttVarC.ve(), ttVarC.tt(veVar), ttVarC.cu());
                        size--;
                        ttVarGu = ttVar;
                        strA = str2;
                        listC = listC;
                        str = str;
                    }
                    com.byazt.ll.tt ttVar2 = ttVarGu;
                    com.byazt.vy.c.c(ttVar2, strA);
                    com.byazt.eu.tt.tt(str, com.byazt.eu.uj.c(ttVar2.gt()) + "V2 resetAdLinkInfo......");
                    com.byazt.ng.a.c(ttVar2, strLo, z, ttVarC.pf().c, 0, (Map<String, Object>) null);
                    ttVarC.x();
                    return;
                }
                com.byazt.vy.c.c(ttVarGu, "-1");
                com.byazt.bnd.c cVar = new com.byazt.bnd.c(41008, com.byazt.pp.c.c(41008));
                com.byazt.ng.a.c(ttVarGu, strLo, z, ttVarC.pf().c, cVar.c, (Map<String, Object>) null);
                ttVarC.c(cVar);
                return;
            }
            com.byazt.vy.c.c(ttVarGu, ErrorContants.NET_NO_CALLBACK);
            com.byazt.bnd.c cVar2 = new com.byazt.bnd.c(41007, com.byazt.pp.c.c(41007));
            com.byazt.ng.a.c(ttVarGu, strLo, z, ttVarC.pf().c, cVar2.c, (Map<String, Object>) null);
            ttVarC.c(cVar2);
            return;
        }
        interfaceC0233c.c(interfaceC0233c.c());
    }

    @Override // com.byazt.om.c
    public void tt(c.InterfaceC0233c interfaceC0233c) {
        interfaceC0233c.c((String) null);
    }
}
