package com.byazt.hz;

import android.content.Context;
import com.byazt.vx.h;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 701, 46})
public class n extends tt implements com.byazt.ix.ve {
    public final int c;
    public List<com.byazt.nbs.da> m;
    public com.byazt.ix.uj.ve tt;

    public n(Context context, int i) {
        super(context);
        this.c = i;
    }

    @Override // com.byazt.ix.ve
    public void c(com.byazt.ll.tt ttVar, com.byazt.yl.ve veVar, com.byazt.ix.uj.ve veVar2) {
        this.tt = veVar2;
        c(ttVar);
        this.ve.tt(true);
        this.ve.n(true);
        this.ve.gu().c(ttVar.c());
        this.sp = c(this.sp, veVar);
        this.ve.c(this.sp);
        this.f2323a.n(1);
        com.byazt.nbs.tt ttVarC = com.byazt.xx.ve.c(this.f2323a, this.sp);
        if (ttVarC != null) {
            this.sp = ttVarC;
            this.ve.c(this.sp);
        }
        if (this.sp == null) {
            com.byazt.eu.tt.c("TTMediationSDK", "--==-- 预缓存补充请求未发起，mRitConfig为null");
            com.byazt.ix.uj.ve veVar3 = this.tt;
            if (veVar3 != null) {
                veVar3.c(this.n, false, 0, null);
                return;
            }
            return;
        }
        List<com.byazt.nbs.da> listL = this.sp.l();
        if (listL == null || listL.size() <= 0) {
            com.byazt.eu.tt.c("TTMediationSDK", "--==-- 预缓存补充请求未发起，过滤后的waterfall为空");
            com.byazt.ix.uj.ve veVar4 = this.tt;
            if (veVar4 != null) {
                veVar4.c(this.n, false, 0, null);
                return;
            }
            return;
        }
        this.sp.sp((long) (this.sp.aw() * this.sp.a()));
        this.sp.a((long) (this.sp.sv() * this.sp.n()));
        this.sp.tt(false);
        this.sp.c(false);
        List<com.byazt.nbs.da> listL2 = this.sp.l();
        this.m = listL2;
        h.c(listL2, this.z);
        if (com.byazt.eu.tt.tt()) {
            com.byazt.eu.tt.c("TTMediationSDK", "--==-- 预缓存补充请求，过滤后的waterfall：");
            for (com.byazt.nbs.da daVar : this.m) {
                com.byazt.eu.tt.c("TTMediationSDK", com.byazt.eu.uj.c(this.n) + "waterfall: " + daVar.z() + "adnSlotId: " + daVar.rh() + ", loadSort: " + daVar.yv() + ", showSort: " + daVar.p() + ", eCpm: " + daVar.gr());
            }
        }
        i();
    }

    @Override // com.byazt.hz.tt
    public com.byazt.om.sp i() {
        ArrayList arrayList = new ArrayList();
        int i = this.c;
        if (i == 3) {
            arrayList.add(new com.byazt.om.i());
        } else if (i == 4) {
            arrayList.add(new com.byazt.om.da(this.ve, this.sp, this.m));
        } else {
            arrayList.add(new com.byazt.om.tt());
        }
        com.byazt.om.sp spVar = new com.byazt.om.sp(arrayList);
        spVar.c(this.ve);
        return spVar;
    }

    private com.byazt.nbs.tt c(com.byazt.nbs.tt ttVar, com.byazt.yl.ve veVar) {
        if (ttVar == null || veVar == null) {
            return null;
        }
        double cpm = veVar.getCpm();
        com.byazt.eu.tt.tt("TMe", "筛选预缓存 ecpm ".concat(String.valueOf(cpm)));
        com.byazt.nbs.tt ttVarClone = ttVar.clone();
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        for (com.byazt.nbs.da daVar : ttVarClone.l()) {
            if (daVar != null && daVar.pf() && daVar.gr() > cpm) {
                copyOnWriteArrayList.add(daVar);
            }
        }
        if (ttVarClone.yp()) {
            ttVarClone.tt(copyOnWriteArrayList);
        } else {
            ttVarClone.c(copyOnWriteArrayList);
        }
        return ttVarClone;
    }

    @Override // com.byazt.hz.tt, com.byazt.ul.c
    public void sp() {
        super.sp();
        com.byazt.ix.uj.ve veVar = this.tt;
        if (veVar != null) {
            veVar.c(this.sp != null ? this.sp.nb() : "", true, 0, this.ve.t());
        }
    }

    @Override // com.byazt.hz.tt, com.byazt.ul.c
    public void tt(com.byazt.pp.c cVar) {
        super.tt(cVar);
        if (this.tt != null) {
            int i = 20005;
            if (cVar != null) {
                if (cVar.c == 10003) {
                    i = 10003;
                } else {
                    int i2 = cVar.c;
                }
            }
            this.tt.c(this.sp != null ? this.sp.nb() : "", false, i, null);
        }
    }
}
