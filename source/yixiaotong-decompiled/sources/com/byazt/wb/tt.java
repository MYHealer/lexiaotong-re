package com.byazt.wb;

import com.byazt.ete.ic;
import com.byazt.nc.i;
import com.byazt.omf.gt;
import com.byazt.pro.ve;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_STATS_REPORT_INTERVAL, 13})
public class tt extends com.byazt.vvt.tt<List<i>> {
    @Override // com.byazt.vvt.tt
    public /* bridge */ /* synthetic */ void c(com.byazt.dj.tt ttVar, List list, List<i> list2) {
        c2(ttVar, (List<ic>) list, list2);
    }

    public tt(com.byazt.iu.tt ttVar) {
        super(ttVar);
    }

    @Override // com.byazt.vvt.tt
    public void c(com.byazt.dj.tt ttVar, List<ic> list, com.byazt.vvt.tt.c<List<i>> cVar) {
        ArrayList arrayList = new ArrayList();
        Iterator<ic> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new ve(gt.getContext(), it.next(), 9, ttVar));
        }
        if (cVar != null) {
            cVar.c(arrayList);
        }
    }

    /* JADX INFO: renamed from: c, reason: avoid collision after fix types in other method */
    public void c2(com.byazt.dj.tt ttVar, List<ic> list, List<i> list2) {
        for (int i = 0; i < list2.size(); i++) {
            ic icVar = list.get(i);
            i iVar = list2.get(i);
            if (this.c != null) {
                this.c.tt().c(ttVar, icVar, (Object) iVar, false);
            }
        }
    }
}
