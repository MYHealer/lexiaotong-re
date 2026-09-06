package com.byazt.xt;

import com.byazt.vx.p;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_AVPH_DNS_PARSE, 46})
public class n implements c.InterfaceC0331c {
    public List<c> c = new CopyOnWriteArrayList();
    public com.byazt.dv.tt tt;
    public com.byazt.iz.tt ve;

    @Override // com.byazt.xt.c.InterfaceC0331c
    public com.byazt.dv.tt c() {
        return this.tt;
    }

    @Override // com.byazt.xt.c.InterfaceC0331c
    public com.byazt.iz.tt tt() {
        return this.ve;
    }

    public n(List<c> list) {
        if (p.c(list)) {
            return;
        }
        this.c.addAll(list);
    }

    public void c(com.byazt.iz.tt ttVar, com.byazt.dv.tt ttVar2) {
        this.ve = ttVar;
        this.tt = ttVar2;
        if (p.c(this.c)) {
            return;
        }
        com.byazt.eu.n.c(new Runnable() { // from class: com.byazt.xt.n.1
            @Override // java.lang.Runnable
            public void run() {
                ((c) n.this.c.get(0)).c(n.this);
            }
        });
    }

    @Override // com.byazt.xt.c.InterfaceC0331c
    public void c(c cVar) {
        int iIndexOf;
        if (p.c(this.c) || cVar == null || (iIndexOf = this.c.indexOf(cVar)) == -1 || iIndexOf >= this.c.size() - 1) {
            return;
        }
        this.c.get(iIndexOf + 1).c(this);
    }
}
