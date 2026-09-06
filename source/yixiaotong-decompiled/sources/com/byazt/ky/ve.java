package com.byazt.ky;

import com.byazt.nr.m;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 677, 54})
public class ve implements com.byazt.zyd.tt {
    public List<com.byazt.qcl.tt> c = new CopyOnWriteArrayList();

    @Override // com.byazt.zyd.tt
    public void c(com.byazt.ha.tt ttVar, com.byazt.ip.x xVar) {
        m.c("Tme_node_line", "TTAdLoadNodeLineObserver onStarted " + ttVar.c() + " rit:" + ttVar.x + "  adType:" + ttVar.sp + " source:" + com.byazt.qcl.uj.c(xVar));
        com.byazt.qcl.tt ttVar2 = new com.byazt.qcl.tt("ad_load", "started", xVar != null ? xVar.c() : System.currentTimeMillis());
        this.c.add(ttVar2);
        com.byazt.qcl.ve.c(ttVar2, ttVar.i, ttVar);
    }

    @Override // com.byazt.zyd.tt
    public void tt(com.byazt.ha.tt ttVar, com.byazt.ip.x xVar) {
        m.c("Tme_node_line", "TTAdLoadNodeLineObserver onReqed " + ttVar.c() + " rit:" + ttVar.x + "  adType:" + ttVar.sp + " source:" + com.byazt.qcl.uj.c(xVar));
        com.byazt.qcl.tt ttVar2 = new com.byazt.qcl.tt("ad_load", "reqed", xVar != null ? xVar.c() : System.currentTimeMillis());
        this.c.add(ttVar2);
        com.byazt.qcl.ve.c(ttVar2, ttVar.i, ttVar);
    }

    @Override // com.byazt.zyd.tt
    public void ve(com.byazt.ha.tt ttVar, com.byazt.ip.x xVar) {
        m.c("Tme_node_line", "TTAdLoadNodeLineObserver onReceived " + ttVar.c() + " rit:" + ttVar.x + "  adType:" + ttVar.sp + " source:" + (ttVar.tt ? 1 : 2));
        com.byazt.qcl.tt ttVar2 = new com.byazt.qcl.tt("ad_load", "received", xVar != null ? xVar.c() : System.currentTimeMillis(), ttVar.tt ? 1 : 2);
        this.c.add(ttVar2);
        com.byazt.qcl.ve.c(ttVar2, ttVar.i, ttVar);
    }

    @Override // com.byazt.zyd.tt
    public void uj(com.byazt.ha.tt ttVar, com.byazt.ip.x xVar) {
        m.c("Tme_node_line", "TTAdLoadNodeLineObserver onLoaded " + ttVar.c() + " rit:" + ttVar.x + "  adType:" + ttVar.sp + " source:" + (ttVar.ve ? 1 : 2));
        com.byazt.qcl.tt ttVar2 = new com.byazt.qcl.tt("ad_load", "loaded", xVar != null ? xVar.c() : System.currentTimeMillis(), ttVar.ve ? 1 : 2);
        this.c.add(ttVar2);
        com.byazt.qcl.ve.c(ttVar2, ttVar.i, ttVar);
        Iterator<String> it = ttVar.n.iterator();
        while (it.hasNext()) {
            ((com.byazt.lh.ve) com.byazt.ip.n.c(1)).c(it.next(), new com.byazt.ip.uj.c() { // from class: com.byazt.ky.ve.1
                @Override // com.byazt.ip.uj.c
                public void c(com.byazt.ip.tt ttVar3) {
                    if (ttVar3 instanceof com.byazt.ha.ve) {
                        ((com.byazt.ha.ve) ttVar3).f2284a.addAll(0, ve.this.c);
                    }
                }
            });
        }
    }
}
