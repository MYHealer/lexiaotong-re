package com.byazt.uf;

import android.content.Context;
import com.byazt.nr.m;
import com.byazt.twu.sp;
import com.byazt.twu.x;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.yfanads.android.utils.YFAdsConst;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_DEVICE_WAIT_END_TIME, 15})
public class uj implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public x f2769a;
    public com.byazt.twu.uj c;
    public com.byazt.rz.c da;
    public com.byazt.rz.c i;
    public com.byazt.twu.c n;
    public com.byazt.rz.c sl;
    public com.byazt.rz.c sp;
    public com.byazt.rz.c t;
    public com.byazt.twu.a tt;
    public com.byazt.vb.n u;
    public sp uj;
    public com.byazt.twu.n ve;
    public com.byazt.rz.c x;
    public List<com.byazt.twu.tt> yp = new ArrayList();

    @Override // com.byazt.uf.n
    public int c() {
        return 0;
    }

    @Override // com.byazt.uf.n
    public List<com.byazt.vb.tt> c(int i, com.byazt.vb.tt ttVar, boolean z, String str) {
        return null;
    }

    public uj(com.byazt.vb.n nVar) {
        this.u = nVar;
        Context context = nVar.getContext();
        if (com.byazt.mv.c.c(nVar)) {
            this.sp = this.u.sp();
            com.byazt.twu.uj ujVar = new com.byazt.twu.uj(context, this.sp, this.u);
            this.c = ujVar;
            this.yp.add(ujVar);
        }
        if (com.byazt.mv.c.n(nVar)) {
            if (this.u.c() != null) {
                this.i = this.u.c();
            } else {
                this.i = this.u.x();
            }
            com.byazt.twu.n nVar2 = new com.byazt.twu.n(context, this.i, this.u);
            this.ve = nVar2;
            this.yp.add(nVar2);
        }
        if (com.byazt.mv.c.tt(nVar)) {
            this.x = this.u.x();
            com.byazt.twu.a aVar = new com.byazt.twu.a(context, this.x, this.u);
            this.tt = aVar;
            this.yp.add(aVar);
        }
        if (com.byazt.mv.c.ve(nVar)) {
            this.da = this.u.x();
            sp spVar = new sp(context, this.da, this.u);
            this.uj = spVar;
            this.yp.add(spVar);
        }
        if (com.byazt.mv.c.uj(nVar)) {
            this.sl = this.u.i();
            com.byazt.twu.c cVar = new com.byazt.twu.c(context, this.sl, this.u);
            this.n = cVar;
            this.yp.add(cVar);
        }
        if (com.byazt.mv.c.a(nVar)) {
            this.t = this.u.a();
            x xVar = new x(context, this.t, this.u);
            this.f2769a = xVar;
            this.yp.add(xVar);
        }
    }

    @Override // com.byazt.uf.n
    public void c(com.byazt.vb.tt ttVar, int i, boolean z) {
        if (ttVar == null) {
            return;
        }
        try {
            ttVar.tt(System.currentTimeMillis());
            Iterator<com.byazt.twu.tt> it = this.yp.iterator();
            while (it.hasNext()) {
                it.next().tt(ttVar);
            }
        } catch (Throwable th) {
            m.c(th);
            com.byazt.ml.tt.c(com.byazt.mv.tt.c.c(), 1, this.u);
        }
    }

    @Override // com.byazt.uf.n
    public tt c(int i, List<com.byazt.vb.tt> list, int i2) {
        Iterator<com.byazt.twu.tt> it = this.yp.iterator();
        tt ttVarC = null;
        while (it.hasNext()) {
            ttVarC = it.next().c(i, list);
            if (ttVarC.c()) {
                break;
            }
        }
        return ttVarC;
    }

    public List<com.byazt.vb.tt> c(com.byazt.vb.tt ttVar, int i, int i2, boolean z) {
        Iterator<com.byazt.twu.tt> it = this.yp.iterator();
        while (it.hasNext()) {
            List<com.byazt.vb.tt> listC = it.next().c(i2, i, ttVar, z);
            if (listC != null && listC.size() != 0) {
                return listC;
            }
        }
        return null;
    }

    @Override // com.byazt.uf.n
    public List<com.byazt.vb.tt> c(int i, com.byazt.vb.tt ttVar, boolean z, List<String> list) {
        Iterator<com.byazt.twu.tt> it = this.yp.iterator();
        while (it.hasNext()) {
            List<com.byazt.vb.tt> listC = it.next().c(i, ttVar, z, list, YFAdsConst.REPORT_DB);
            if (listC != null && listC.size() != 0) {
                return listC;
            }
        }
        return null;
    }

    @Override // com.byazt.uf.n
    public boolean c(int i, String str, com.byazt.vb.tt ttVar) {
        Iterator<com.byazt.twu.tt> it = this.yp.iterator();
        while (it.hasNext()) {
            if (it.next().c(i, str, ttVar)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.byazt.uf.n
    public int tt() {
        int size = this.yp.size();
        int iN = 0;
        for (int i = 0; i < size; i++) {
            iN += this.yp.get(i).n();
        }
        return iN;
    }
}
