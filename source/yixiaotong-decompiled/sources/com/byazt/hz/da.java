package com.byazt.hz;

import android.app.Activity;
import android.content.Context;
import com.byazt.nr.m;
import com.huawei.openalliance.ad.constant.br;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 701, 72})
public abstract class da extends tt {
    public boolean nu;
    public boolean rh;

    public interface c {
        void c();
    }

    public void c(boolean z) {
        this.nu = z;
    }

    public boolean rl() {
        return false;
    }

    public boolean zm() {
        return this.nu;
    }

    public da(Context context) {
        super(context);
        this.nu = false;
        this.rh = false;
    }

    /* JADX WARN: Code duplicated, block: B:9:0x001f A[PHI: r2
  0x001f: PHI (r2v5 boolean) = (r2v2 boolean), (r2v0 boolean) binds: [B:31:0x0070, B:7:0x001c] A[DONT_GENERATE, DONT_INLINE]] */
    public void c(com.byazt.iz.tt ttVar) {
        boolean z;
        boolean z2 = true;
        if (this.uj.getAdType() == 10 || this.uj.getAdType() == 8 || this.uj.getAdType() == 7) {
            z2 = (this.f2323a == null || !(this.f2323a.my() == 10 || this.f2323a.my() == 8) || this.sp == null || this.sp.m() == 0) ? (this.uj.adnHasAdVideoCachedApi() && this.uj.isCacheSuccess() && com.byazt.ix.uj.c().ve(this.n, this.f2323a.n())) ? false : true : true;
            if (this.uj.getAdNetworkPlatformId() == 4) {
                z = false;
            } else {
                z = z2;
            }
        } else {
            z = z2;
        }
        if (this.uj.canAdReuse() && com.byazt.hk.c.c().uj(this.n, this.uj.getAdNetworkSlotId(), this.f2323a.n())) {
            com.byazt.hk.c.c().c(this.uj.getAdNetworkSlotId(), this.f2323a, ttVar != null ? ttVar.zb() : null, z, ttVar != null ? ttVar.or() : null, (com.byazt.nbs.i) null, this.x.get());
        }
    }

    public void yv() {
        if (this.f2323a.tk() || this.uj == null || this.uj.getAdNetworkPlatformId() == 4) {
            return;
        }
        com.byazt.ix.uj.c().c(this.x.get(), this.n, this.f2323a.n());
    }

    public void ve(final com.byazt.yl.ve veVar) {
        if (this.f2323a.tk()) {
            return;
        }
        com.byazt.eu.n.ve(new Runnable() { // from class: com.byazt.hz.da.1
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.yl.ve veVar2 = veVar;
                if (veVar2 == null || !veVar2.adnHasAdVideoCachedApi() || !veVar.isCacheSuccess() || (da.this.uj instanceof com.byazt.zm.tt)) {
                    return;
                }
                com.byazt.eu.tt.c("TTMediationSDK", com.byazt.eu.uj.tt(da.this.n, veVar.getAdNetworkSlotId()) + "在show时触发了预加载【" + veVar.getAdNetWorkName() + "】, loadSort: " + veVar.getLoadSort() + ", showSort: " + veVar.getShowSort());
                da.this.rh = true;
                com.byazt.ix.uj.c().tt(da.this.x.get(), da.this.n, da.this.f2323a.n());
            }
        });
    }

    @Override // com.byazt.hz.tt
    public void ve() {
        super.ve();
    }

    public void c(Activity activity, Object obj, String str, c cVar) {
        List<com.byazt.nbs.da> listTt = null;
        if (!rl()) {
            com.byazt.ng.a.c(this.f2323a);
            if (this.t) {
                com.byazt.ng.a.c((List<com.byazt.yl.ve>) null, this.f2323a, 0);
                if (cVar != null) {
                    cVar.c();
                    return;
                }
                return;
            }
        }
        int iTt = tt(this.n);
        if (iTt != 0) {
            com.byazt.ng.a.c((List<com.byazt.yl.ve>) null, this.f2323a, iTt);
            if (cVar != null) {
                cVar.c();
                return;
            }
            return;
        }
        boolean zU = u();
        List<com.byazt.yl.ve> listC = this.ve.c(true);
        this.ve.c(listC);
        try {
            listTt = tt();
        } catch (Throwable th) {
            m.c(th);
        }
        List<com.byazt.nbs.da> list = listTt;
        if (list == null || list.size() <= 0 || !c(list, listC, zU, activity, obj, str)) {
            if (listC != null && listC.size() > 0) {
                for (com.byazt.yl.ve veVar : listC) {
                    if (veVar != null && (!zU || veVar.isCacheSuccess())) {
                        if (tt(veVar, activity, obj, str)) {
                            return;
                        }
                    }
                }
                if (zU && this.uj == null) {
                    for (com.byazt.yl.ve veVar2 : listC) {
                        if (veVar2 != null && tt(veVar2, activity, obj, str)) {
                            return;
                        }
                    }
                }
            }
            com.byazt.ng.a.c(listC, this.f2323a, 0);
            if (cVar != null) {
                cVar.c();
            }
        }
    }

    private boolean uj(com.byazt.yl.ve veVar) {
        return !veVar.isCustomAd() || veVar.getIsRefresh() == 1;
    }

    private boolean tt(com.byazt.yl.ve veVar, Activity activity, Object obj, String str) {
        if (!veVar.isReady(this.n) || veVar.isHasShown()) {
            return false;
        }
        if (rl()) {
            if (uj(veVar) && !com.byazt.cz.c.c(veVar.getAdNetWorkName(), veVar.getAdType(), veVar.getSubAdType())) {
                com.byazt.eu.tt.c("TTMediationSDK", com.byazt.eu.uj.tt(this.n, veVar.getAdNetworkSlotId()) + "弱网情况下没有缓存好的广告,那么直接根据优先级展示，广告类型：" + com.byazt.yl.c.c(veVar.getAdNetworkPlatformId()) + ",isReady()：" + veVar.isReady(this.n));
                c(veVar, activity, obj, str);
                return true;
            }
            com.byazt.eu.tt.tt("TTMediationSDK", "--==--- 插全屏轮播中，不能轮播的自定义adn跳过");
            return false;
        }
        com.byazt.eu.tt.c("TTMediationSDK", com.byazt.eu.uj.tt(this.n, veVar.getAdNetworkSlotId()) + "弱网情况下没有缓存好的广告,那么直接根据优先级展示，广告类型：" + com.byazt.yl.c.c(veVar.getAdNetworkPlatformId()) + ",isReady()：" + veVar.isReady(this.n));
        c(veVar, activity, obj, str);
        return true;
    }

    private boolean ve(com.byazt.yl.ve veVar, Activity activity, Object obj, String str) {
        if (!veVar.isReady(this.n) || veVar.isHasShown()) {
            return false;
        }
        if (rl()) {
            if (uj(veVar) && !com.byazt.cz.c.c(veVar.getAdNetWorkName(), veVar.getAdType(), veVar.getSubAdType())) {
                com.byazt.eu.tt.c("TTMediationSDK", com.byazt.eu.uj.tt(this.n, veVar.getAdNetworkSlotId()) + "弱网情况下没有缓存好的广告,那么直接根据优先级展示，广告类型：" + com.byazt.yl.c.c(veVar.getAdNetworkPlatformId()) + ",isReady()：" + veVar.isReady(this.n));
                tt(veVar);
                c(veVar, activity, obj, str);
                return true;
            }
            com.byazt.eu.tt.tt("TTMediationSDK", "--==--- cache 插全屏轮播中，不能轮播的自定义adn跳过");
            return false;
        }
        com.byazt.eu.tt.c("TTMediationSDK", com.byazt.eu.uj.tt(this.n, veVar.getAdNetworkSlotId()) + "弱网情况下没有缓存好的广告,那么直接根据优先级展示，广告类型：" + com.byazt.yl.c.c(veVar.getAdNetworkPlatformId()) + ",isReady()：" + veVar.isReady(this.n));
        tt(veVar);
        c(veVar, activity, obj, str);
        return true;
    }

    public void c(com.byazt.yl.ve veVar, final Activity activity, final Object obj, final String str) {
        this.uj = veVar;
        com.byazt.eu.n.ve(new Runnable() { // from class: com.byazt.hz.da.2
            @Override // java.lang.Runnable
            public void run() {
                if (da.this.uj != null) {
                    if (da.this.u != null) {
                        da.this.uj.setTTAdAppDownloadListener(da.this.u);
                    }
                    if (da.this.yp != null) {
                        da.this.uj.setAdInteractionListener(da.this.yp);
                    }
                    da.this.ve.uj(da.this.uj);
                    da.this.uj.setHasShown(true);
                    da.this.uj.setTTAdatperCallback(da.this.i);
                    if (da.this.uj.canAdReuse() && com.byazt.hk.c.c().uj(da.this.n, da.this.uj.getAdNetworkSlotId(), da.this.rh())) {
                        com.byazt.qv.a.c(da.this.uj, da.this.n, da.this.uj.getAdNetworkSlotId());
                    }
                    List<com.byazt.yl.ve> listC = da.this.ve.c(true);
                    com.byazt.hk.c.c().c(listC, da.this.n, da.this.f2323a, da.this.f2323a.n(), da.this.uj);
                    com.byazt.eu.tt.c("TTMediationSDK", com.byazt.eu.uj.c(da.this.n, br.b.V) + "展示的广告类型：" + com.byazt.yl.c.c(da.this.uj.getAdNetworkPlatformId()) + ",slotId：" + da.this.uj.getAdNetworkSlotId() + ",slotType:" + da.this.uj.getAdNetworkSlotType() + ",isReady()：" + da.this.uj.isReady(da.this.n) + "，是否为缓存广告:" + da.this.uj.isCacheSuccess());
                    da.this.uj.showAd(activity, obj, str);
                    com.byazt.hr.u.c().tt(da.this.n);
                    com.byazt.hr.t.c().tt(da.this.n, da.this.uj.getAdNetworkSlotId());
                    da.this.t = true;
                    if (da.this.uj != null) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(da.this.uj);
                        if (da.this.f2323a.my() == 7 || da.this.f2323a.my() == 10) {
                            com.byazt.vy.c.c().c(da.this.f2323a, com.byazt.vy.c.c(da.this.f2323a, arrayList, listC));
                        }
                        da.this.c(arrayList);
                    }
                    com.byazt.ng.a.c(da.this.uj, da.this.f2323a, false, da.this.rl() ? 1 : 0);
                }
            }
        });
    }

    private boolean c(List<com.byazt.nbs.da> list, List<com.byazt.yl.ve> list2, boolean z, Activity activity, Object obj, String str) {
        List<com.byazt.ix.sp> listC;
        com.byazt.yl.ve veVar;
        List<com.byazt.ix.sp> listC2;
        com.byazt.yl.ve veVar2;
        HashMap<String, com.byazt.yl.ve> mapTt = tt(list2);
        for (com.byazt.nbs.da daVar : list) {
            if (daVar != null) {
                String strRh = daVar.rh();
                com.byazt.yl.ve veVar3 = mapTt.get(strRh);
                if (veVar3 != null) {
                    if (z) {
                        if (veVar3.isCacheSuccess() && tt(veVar3, activity, obj, str)) {
                            return true;
                        }
                    } else if (tt(veVar3, activity, obj, str)) {
                        return true;
                    }
                }
                if (daVar.gt() && com.byazt.hk.c.c().uj(this.n, strRh, this.f2323a.n()) && com.byazt.hk.c.c().c(strRh, this.f2323a, false) == 3 && (listC2 = com.byazt.hk.c.c().c(strRh, this.f2323a, this.f2323a.n())) != null && listC2.size() > 0 && (veVar2 = listC2.get(0).c) != null) {
                    if (z) {
                        if (veVar2.isCacheSuccess() && ve(veVar2, activity, obj, str)) {
                            return true;
                        }
                    } else if (ve(veVar2, activity, obj, str)) {
                        return true;
                    }
                }
            }
        }
        if (z && this.uj == null) {
            for (com.byazt.nbs.da daVar2 : list) {
                if (daVar2 != null) {
                    String strRh2 = daVar2.rh();
                    com.byazt.yl.ve veVar4 = mapTt.get(strRh2);
                    if (veVar4 != null && tt(veVar4, activity, obj, str)) {
                        return true;
                    }
                    if (daVar2.gt() && com.byazt.hk.c.c().uj(this.n, strRh2, this.f2323a.n()) && com.byazt.hk.c.c().c(strRh2, this.f2323a, false) == 3 && (listC = com.byazt.hk.c.c().c(strRh2, this.f2323a, this.f2323a.n())) != null && listC.size() > 0 && (veVar = listC.get(0).c) != null && ve(veVar, activity, obj, str)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean p() {
        List<com.byazt.nbs.da> listTt;
        try {
            listTt = tt();
        } catch (Throwable th) {
            m.c(th);
            listTt = null;
        }
        return com.byazt.vx.t.c(this.ve.sl(), this.ve.yp(), this.ve.t(), this.f2323a, this.t, this.n, this.f2323a.n(), listTt);
    }
}
