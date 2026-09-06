package com.byazt.hz;

import android.content.Context;
import android.text.TextUtils;
import com.byazt.nr.m;
import com.byazt.vx.p;
import com.fancy.adsdk.lib.constants.PtgErrorCode;
import com.huawei.openalliance.ad.constant.br;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 701, 42})
public class i extends tt {
    public com.byazt.me.uj c;
    public com.byazt.om.c.InterfaceC0233c m;
    public boolean nu;
    public com.byazt.zh.ve tt;

    @Override // com.byazt.hz.tt
    public void ve() {
        this.c = null;
    }

    public i(Context context) {
        super(context);
        this.nu = false;
    }

    public void c(com.byazt.ll.tt ttVar, com.byazt.me.uj ujVar) {
        c(ttVar);
        this.c = ujVar;
        i();
    }

    @Override // com.byazt.hz.tt, com.byazt.ul.c
    public void tt(com.byazt.pp.c cVar) {
        com.byazt.me.uj ujVar = this.c;
        if (ujVar != null) {
            ujVar.c(cVar);
            if (this.sl != 0 || this.tt == null) {
                return;
            }
            this.sl = 2;
            this.tt.c(cVar);
        }
    }

    @Override // com.byazt.hz.tt, com.byazt.ul.c
    public void sp() {
        List<com.byazt.yl.ve> listC;
        List<com.byazt.yl.ve> listC2;
        if (this.c == null || (listC2 = c((listC = this.ve.c(true)), this.f2323a.gr())) == null || listC2.size() <= 0) {
            return;
        }
        if (com.byazt.eu.tt.tt()) {
            com.byazt.eu.tt.uj("TTMediationSDK", "返回给外部开发者的广告数量：sumList.size=" + listC2.size());
        }
        CopyOnWriteArrayList<com.byazt.yl.ve> copyOnWriteArrayList = new CopyOnWriteArrayList<>(listC);
        for (com.byazt.yl.ve veVar : listC2) {
            if (veVar != null) {
                veVar.setHasShown(true);
                if (veVar.canAdReuse() && com.byazt.hk.c.c().uj(this.n, veVar.getAdNetworkSlotId(), this.f2323a.n())) {
                    com.byazt.qv.a.c(veVar, this.n, veVar.getAdNetworkSlotId());
                    c(copyOnWriteArrayList, veVar);
                }
                c(this.ve.sl(), veVar);
                c(this.ve.t(), veVar);
                c(this.ve.u(), veVar);
                c(this.ve.yp(), veVar);
            }
        }
        com.byazt.hk.c.c().c(copyOnWriteArrayList, this.n, this.f2323a, this.f2323a.n(), null);
        this.c.c(listC2);
    }

    @Override // com.byazt.hz.tt, com.byazt.ul.c
    public void c(List<com.byazt.yl.ve> list, com.byazt.pp.c cVar) {
        super.c(list, cVar);
        if (!(this.c instanceof com.byazt.me.sp) || p.c(list)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (com.byazt.yl.ve veVar : list) {
            veVar.setCallBack(new com.byazt.yl.ve.c() { // from class: com.byazt.hz.i.1
                @Override // com.byazt.yl.ve.c
                public void c() {
                    i.this.t = true;
                }

                @Override // com.byazt.yl.ve.c
                public void c(com.byazt.yl.ve veVar2) {
                    i.this.c(veVar2, false);
                }
            });
            arrayList.add(veVar);
        }
    }

    @Override // com.byazt.hz.tt, com.byazt.ul.c
    public void c(String str) {
        if (this.sl != 0 || this.tt == null) {
            return;
        }
        this.sl = 1;
        this.tt.c(str);
    }

    public void c(String str, com.byazt.me.uj ujVar) {
        if (this.sl != 1) {
            if (ujVar != null) {
                ujVar.c(new com.byazt.pp.c(10015, com.byazt.pp.c.c(10015)));
            }
        } else if (this.da) {
            if (ujVar != null) {
                ujVar.c(new com.byazt.pp.c(40047, com.byazt.pp.c.c(40047)));
            }
        } else {
            this.da = true;
            this.c = ujVar;
            com.byazt.om.c.InterfaceC0233c interfaceC0233c = this.m;
            if (interfaceC0233c != null) {
                interfaceC0233c.c(str);
            }
        }
    }

    public void c(com.byazt.ll.tt ttVar, com.byazt.zh.ve veVar) {
        c(ttVar);
        this.tt = veVar;
        if (this.ve.m() != null && this.ve.m().z()) {
            this.m = i();
        } else if (veVar != null) {
            veVar.c(new com.byazt.pp.c(PtgErrorCode.SDK_SPLASH_SINGLE_ERROR, com.byazt.pp.c.c(PtgErrorCode.SDK_SPLASH_SINGLE_ERROR)));
        }
    }

    private List<com.byazt.yl.ve> c(List<com.byazt.yl.ve> list, int i) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        ve(list);
        uj();
        final ArrayList arrayList = new ArrayList(list);
        ArrayList arrayList2 = new ArrayList();
        Iterator<com.byazt.yl.ve> it = list.iterator();
        while (it.hasNext() && arrayList2.size() < i) {
            com.byazt.yl.ve next = it.next();
            arrayList2.add(next);
            if (com.byazt.eu.tt.tt()) {
                com.byazt.eu.tt.uj("TTMediationSDK", "");
                com.byazt.eu.tt.uj("TTMediationSDK", com.byazt.eu.uj.c(this.n, br.b.V) + "返回给开发者最终广告：slotId=" + next.getAdNetworkSlotId() + ",slotType:" + next.getAdNetworkSlotType() + ",cpm=" + next.getCpm() + ",广告类型：" + com.byazt.yl.c.c(next.getAdNetworkPlatformId()) + ",ImageMode=" + next.getImageMode() + ",showSort=" + next.getShowSort() + ",isExpressAd=" + next.isExpressAd());
            }
            next.setCallBack(new com.byazt.yl.ve.c() { // from class: com.byazt.hz.i.2
                @Override // com.byazt.yl.ve.c
                public void c() {
                    i.this.t = true;
                    if (i.this.ve != null) {
                        i.this.ve.c(arrayList);
                    }
                }

                @Override // com.byazt.yl.ve.c
                public void c(com.byazt.yl.ve veVar) {
                    boolean z;
                    if (com.byazt.ix.uj.c().ve(i.this.n, i.this.f2323a.n()) || i.this.nu) {
                        z = false;
                    } else {
                        z = true;
                        i.this.nu = true;
                    }
                    i.this.c(veVar, z);
                    i.this.ve(veVar);
                }
            });
            it.remove();
        }
        com.byazt.vy.c.c().c(this.f2323a, com.byazt.vy.c.c(this.f2323a, arrayList2, list));
        c(arrayList2);
        return arrayList2;
    }

    public void c(com.byazt.yl.ve veVar, boolean z) {
        if (veVar != null && veVar.canAdReuse() && com.byazt.hk.c.c().uj(this.n, veVar.getAdNetworkSlotId(), this.f2323a.n())) {
            com.byazt.hk.c.c().c(veVar.getAdNetworkSlotId(), this.f2323a, this.ve.zb(), z, this.ve.or(), this.ve.pf(), this.x.get());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ve(com.byazt.yl.ve veVar) {
        if (this.f2323a.tk() || veVar == null || veVar.getAdNetworkPlatformId() == 7 || (veVar instanceof com.byazt.zm.tt) || this.sp == null || this.sp.z()) {
            return;
        }
        com.byazt.ix.uj.c().tt(this.x.get(), this.n, this.f2323a.n());
    }

    private void c(CopyOnWriteArrayList<com.byazt.yl.ve> copyOnWriteArrayList, com.byazt.yl.ve veVar) {
        for (com.byazt.yl.ve veVar2 : copyOnWriteArrayList) {
            if (veVar2 == veVar && veVar2 != null) {
                copyOnWriteArrayList.remove(veVar2);
            }
        }
    }

    private void ve(List<com.byazt.yl.ve> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        ArrayList<com.byazt.yl.ve> arrayList = new ArrayList(list.size());
        arrayList.addAll(list);
        list.clear();
        for (com.byazt.yl.ve veVar : arrayList) {
            if (veVar != null && !veVar.isHasShown() && veVar.isReady(this.n)) {
                list.add(veVar);
            }
        }
    }

    private void uj() {
        try {
            List<com.byazt.nbs.da> listTt = tt();
            if (listTt == null || listTt.size() <= 0) {
                return;
            }
            for (com.byazt.nbs.da daVar : listTt) {
                if (daVar != null) {
                    String strRh = daVar.rh();
                    if (com.byazt.hk.c.c().uj(this.n, strRh, this.f2323a.n())) {
                        if (daVar.my() == 100) {
                            c(strRh, this.ve.sl());
                        } else if (daVar.my() == 0) {
                            c(strRh, this.ve.t());
                        }
                    }
                }
            }
        } catch (Throwable th) {
            m.c(th);
        }
    }

    private void c(String str, List<com.byazt.yl.ve> list) {
        List<com.byazt.ix.sp> listC;
        if (tt(str, list) || com.byazt.hk.c.c().c(str, this.f2323a, false) != 3 || (listC = com.byazt.hk.c.c().c(str, this.f2323a, this.f2323a.n())) == null || listC.size() <= 0) {
            return;
        }
        for (com.byazt.ix.sp spVar : listC) {
            if (spVar != null && spVar.c != null && !spVar.c.isHasShown() && spVar.c.isReady(this.n)) {
                list.add(spVar.c);
                tt(spVar.c);
            }
        }
    }

    private boolean tt(String str, List<com.byazt.yl.ve> list) {
        if (list == null || list.size() <= 0) {
            return false;
        }
        for (com.byazt.yl.ve veVar : list) {
            if (veVar != null && TextUtils.equals(str, veVar.getAdNetworkSlotId())) {
                return true;
            }
        }
        return false;
    }
}
