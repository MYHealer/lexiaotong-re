package com.byazt.hz;

import android.content.Context;
import android.text.TextUtils;
import com.byazt.nr.m;
import com.byazt.vx.p;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.fancy.adsdk.lib.constants.PtgErrorCode;
import com.huawei.openalliance.ad.constant.br;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 701, MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_AUTO_RECOVERY})
public class sp extends tt {
    public com.byazt.fy.tt c;
    public com.byazt.om.c.InterfaceC0233c m;
    public com.byazt.zh.ve tt;

    public sp(Context context) {
        super(context);
    }

    public void c(com.byazt.ll.tt ttVar, com.byazt.fy.tt ttVar2) {
        c(ttVar);
        this.c = ttVar2;
        i();
    }

    @Override // com.byazt.hz.tt, com.byazt.ul.c
    public void tt(com.byazt.pp.c cVar) {
        com.byazt.fy.tt ttVar = this.c;
        if (ttVar != null) {
            ttVar.c(cVar);
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
        if (this.c == null || (listC = c(this.ve.c(true), this.f2323a.gr())) == null || listC.size() <= 0) {
            return;
        }
        if (com.byazt.eu.tt.tt()) {
            com.byazt.eu.tt.uj("TTMediationSDK", "返回给外部开发者的广告数量：sumList.size=" + listC.size());
        }
        CopyOnWriteArrayList<com.byazt.yl.ve> copyOnWriteArrayList = new CopyOnWriteArrayList<>(this.ve.c(true));
        for (com.byazt.yl.ve veVar : listC) {
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
        this.c.c(listC);
    }

    @Override // com.byazt.hz.tt, com.byazt.ul.c
    public void c(List<com.byazt.yl.ve> list, com.byazt.pp.c cVar) {
        super.c(list, cVar);
        if (!(this.c instanceof com.byazt.fy.n) || p.c(list)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (com.byazt.yl.ve veVar : list) {
            veVar.setCallBack(new com.byazt.yl.ve.c() { // from class: com.byazt.hz.sp.1
                @Override // com.byazt.yl.ve.c
                public void c() {
                    sp.this.t = true;
                }

                @Override // com.byazt.yl.ve.c
                public void c(com.byazt.yl.ve veVar2) {
                    sp.this.c(veVar2, -1);
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

    public void c(String str, com.byazt.fy.tt ttVar) {
        if (this.sl != 1) {
            if (ttVar != null) {
                ttVar.c(new com.byazt.pp.c(10015, com.byazt.pp.c.c(10015)));
            }
        } else if (this.da) {
            if (ttVar != null) {
                ttVar.c(new com.byazt.pp.c(40047, com.byazt.pp.c.c(40047)));
            }
        } else {
            this.da = true;
            this.c = ttVar;
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

    @Override // com.byazt.hz.tt
    public void ve() {
        super.ve();
        this.c = null;
    }

    private List<com.byazt.yl.ve> c(List<com.byazt.yl.ve> list, int i) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        ve(list);
        uj();
        final ArrayList arrayList = new ArrayList(list);
        final ArrayList arrayList2 = new ArrayList();
        Iterator<com.byazt.yl.ve> it = list.iterator();
        while (it.hasNext() && arrayList2.size() < i) {
            com.byazt.yl.ve next = it.next();
            next.setCallBack(new com.byazt.yl.ve.c() { // from class: com.byazt.hz.sp.2
                @Override // com.byazt.yl.ve.c
                public void c() {
                    sp.this.t = true;
                    if (sp.this.ve != null) {
                        sp.this.ve.c(arrayList);
                    }
                }

                @Override // com.byazt.yl.ve.c
                public void c(com.byazt.yl.ve veVar) {
                    int i2 = 0;
                    while (i2 < arrayList2.size() && veVar != arrayList2.get(i2)) {
                        i2++;
                    }
                    sp.this.c(veVar, i2);
                }
            });
            arrayList2.add(next);
            if (com.byazt.eu.tt.tt()) {
                com.byazt.eu.tt.uj("TTMediationSDK", "");
                com.byazt.eu.tt.uj("TTMediationSDK", com.byazt.eu.uj.c(this.n, br.b.V) + "返回给开发者最终广告：slotId=" + next.getAdNetworkSlotId() + ",slotType:" + next.getAdNetworkSlotType() + ",cpm=" + next.getCpm() + ",广告类型：" + com.byazt.yl.c.c(next.getAdNetworkPlatformId()) + ",ImageMode=" + next.getImageMode() + ",showSort=" + next.getShowSort() + ",isExpressAd=" + next.isExpressAd());
            }
            it.remove();
        }
        c(arrayList2);
        return arrayList2;
    }

    public void c(com.byazt.yl.ve veVar, int i) {
        if (veVar != null && veVar.canAdReuse() && com.byazt.hk.c.c().uj(this.n, veVar.getAdNetworkSlotId(), this.f2323a.n())) {
            com.byazt.hk.c.c().c(veVar.getAdNetworkSlotId(), this.f2323a, this.ve.zb(), i == 0, this.ve.or(), this.ve.pf(), this.x.get());
        }
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
