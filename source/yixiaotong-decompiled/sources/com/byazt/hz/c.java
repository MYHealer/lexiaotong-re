package com.byazt.hz;

import android.app.Activity;
import android.content.Context;
import com.byazt.vx.nu;
import com.byazt.vx.yp;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 701, 20})
public class c extends uj {
    public com.byazt.zq.tt c;
    public com.byazt.bi.c gt;
    public com.byazt.bi.tt my;
    public boolean rl;
    public com.byazt.zq.ve tt;

    public void c(com.byazt.bi.c cVar) {
        this.gt = cVar;
    }

    public c(Context context) {
        super(context);
        this.rl = false;
        this.c = new com.byazt.zq.tt() { // from class: com.byazt.hz.c.3
            /* JADX WARN: Code duplicated, block: B:15:0x006b  */
            @Override // com.byazt.ln.c
            public void c() {
                String strC;
                String str;
                long jCurrentTimeMillis;
                c.this.rl = true;
                c.this.qy();
                if (!yp.c() || c.this.uj == null || !MediationConstant.ADN_PANGLE.equals(c.this.uj.getAdNetWorkName())) {
                    strC = null;
                } else {
                    if (!yp.ve()) {
                        c.this.c(true);
                        com.byazt.pp.c cVar = new com.byazt.pp.c(40063, com.byazt.pp.c.c(40063));
                        com.byazt.ng.a.c(c.this.uj, c.this.f2323a, cVar, 1, c.this.rl() ? 1 : 0, (String) null, 0L, nu.c());
                        c.this.c(cVar);
                        return;
                    }
                    if (yp.sp()) {
                        strC = nu.c();
                    } else {
                        strC = null;
                    }
                }
                if (c.this.gt != null) {
                    c.this.gt.c();
                }
                com.byazt.hr.u.c().sp(c.this.n);
                if (c.this.uj != null) {
                    com.byazt.eu.tt.c("TTMediationSDK", com.byazt.eu.uj.c(c.this.n, "show_listen") + "adSlotId：" + c.this.uj.getAdNetworkSlotId() + "，广告类型：" + com.byazt.yl.c.c(c.this.uj.getAdNetworkPlatformId()));
                    com.byazt.hr.sl.c().tt(c.this.n, c.this.uj.getAdNetworkSlotId());
                }
                c cVar2 = c.this;
                cVar2.c(cVar2.ve);
                c cVar3 = c.this;
                cVar3.ve(cVar3.uj);
                if (c.this.uj != null) {
                    com.byazt.xx.ve.c(c.this.uj.getAdnName(), c.this.n, c.this.uj.getAdNetworkSlotId());
                }
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                if (nu.c(c.this.uj)) {
                    String strTt = nu.tt();
                    jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
                    str = strTt;
                } else {
                    str = null;
                    jCurrentTimeMillis = -1;
                }
                com.byazt.ng.a.c(c.this.uj, c.this.f2323a, c.this.rl() ? 1 : 0, str, jCurrentTimeMillis, strC, false, c.this.gt());
                com.byazt.bg.c.sp(c.this.n);
                com.byazt.bg.c.ve(c.this.n);
                com.byazt.psp.uj.c(1, c.this.f2323a.gt(), c.this.uj.getAdType(), c.this.uj.getCpm());
                com.byazt.oi.ve.c(c.this.n, c.this.uj);
            }

            @Override // com.byazt.ln.c
            public void c(com.byazt.pp.c cVar) {
                String strTt;
                long jCurrentTimeMillis;
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                if (nu.c(c.this.uj)) {
                    strTt = nu.tt();
                    jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
                } else {
                    strTt = null;
                    jCurrentTimeMillis = -1;
                }
                com.byazt.ng.a.c(c.this.uj, c.this.f2323a, cVar, 1, c.this.rl() ? 1 : 0, strTt, jCurrentTimeMillis);
                c.this.c(cVar);
            }

            /* JADX WARN: Code duplicated, block: B:15:0x004b  */
            @Override // com.byazt.ln.c
            public void g_() {
                String str;
                String str2;
                long jCurrentTimeMillis;
                String strC;
                c.this.gr();
                if (!yp.c()) {
                    if (c.this.gt != null) {
                        c.this.gt.tt();
                    }
                    str = null;
                } else {
                    if (c.this.uj == null || !MediationConstant.ADN_PANGLE.equals(c.this.uj.getAdNetWorkName())) {
                        strC = null;
                    } else if (!yp.ve()) {
                        com.byazt.ng.a.c(c.this.uj, c.this.f2323a, 5, 1, c.this.rl() ? 1 : 0, nu.c());
                        return;
                    } else if (yp.x()) {
                        strC = nu.c();
                    } else {
                        strC = null;
                    }
                    if (!c.this.zm() && c.this.gt != null) {
                        c.this.gt.tt();
                    }
                    str = strC;
                }
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                if (nu.c(c.this.uj)) {
                    String strTt = nu.tt();
                    jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
                    str2 = strTt;
                } else {
                    str2 = null;
                    jCurrentTimeMillis = -1;
                }
                com.byazt.bg.c.n(c.this.n);
                com.byazt.ng.a.c(c.this.uj, c.this.f2323a, c.this.rl() ? 1 : 0, str2, jCurrentTimeMillis, str, c.this.uj.isClickListenRepeatOnce());
            }

            @Override // com.byazt.ln.c
            public void h_() {
                c.this.gu();
                if (c.this.m) {
                    if (yp.c()) {
                        if (c.this.uj != null && MediationConstant.ADN_PANGLE.equals(c.this.uj.getAdNetWorkName())) {
                            if (!yp.ve()) {
                                com.byazt.ng.a.c(c.this.uj, c.this.f2323a, 2, 1, c.this.rl() ? 1 : 0, nu.c());
                                return;
                            }
                            com.byazt.ng.a.c(c.this.uj, c.this.f2323a, 2, 0, c.this.rl() ? 1 : 0, (String) null);
                        }
                        if (c.this.zm()) {
                            return;
                        }
                        c.this.yv();
                        if (c.this.gt != null) {
                            c.this.gt.ve();
                            return;
                        }
                        return;
                    }
                    c.this.yv();
                    if (c.this.gt != null) {
                        c.this.gt.ve();
                    }
                }
            }

            @Override // com.byazt.ln.c
            public void uj() {
                if (yp.c()) {
                    if (c.this.uj != null && MediationConstant.ADN_PANGLE.equals(c.this.uj.getAdNetWorkName())) {
                        if (!yp.ve()) {
                            com.byazt.ng.a.c(c.this.uj, c.this.f2323a, 1, 1, c.this.rl() ? 1 : 0, nu.c());
                            return;
                        }
                        com.byazt.ng.a.c(c.this.uj, c.this.f2323a, 1, 0, c.this.rl() ? 1 : 0, (String) null);
                    }
                    if (c.this.zm()) {
                        return;
                    }
                    c.this.yv();
                    if (c.this.gt != null) {
                        c.this.gt.uj();
                        return;
                    }
                    return;
                }
                c.this.yv();
                if (c.this.gt != null) {
                    c.this.gt.uj();
                }
            }

            @Override // com.byazt.ln.c
            public void n() {
                String strTt;
                long jCurrentTimeMillis;
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                if (nu.c(c.this.uj)) {
                    strTt = nu.tt();
                    jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
                } else {
                    strTt = null;
                    jCurrentTimeMillis = -1;
                }
                com.byazt.ng.a.c(c.this.uj, c.this.f2323a, (com.byazt.pp.c) null, 2, c.this.rl() ? 1 : 0, strTt, jCurrentTimeMillis);
                if (c.this.gt != null) {
                    c.this.gt.n();
                }
            }

            @Override // com.byazt.ln.c
            public void a() {
                if (yp.c()) {
                    if (c.this.uj != null && MediationConstant.ADN_PANGLE.equals(c.this.uj.getAdNetWorkName())) {
                        if (!yp.ve()) {
                            com.byazt.ng.a.c(c.this.uj, c.this.f2323a, 3, 1, c.this.rl() ? 1 : 0, nu.c());
                            return;
                        }
                        com.byazt.ng.a.c(c.this.uj, c.this.f2323a, 3, 0, c.this.rl() ? 1 : 0, (String) null);
                    }
                    if (c.this.zm()) {
                        return;
                    }
                    c.this.yv();
                    if (c.this.gt != null) {
                        c.this.gt.a();
                        return;
                    }
                    return;
                }
                c.this.yv();
                if (c.this.gt != null) {
                    c.this.gt.a();
                }
            }

            @Override // com.byazt.ln.c
            public void c(com.byazt.bo.c cVar) {
                if (c.this.gt != null) {
                    c.this.gt.c(t.c(c.this.f2323a, cVar, c.this.uj, (Map<String, Object>) null));
                }
            }
        };
        this.tt = new com.byazt.zq.ve() { // from class: com.byazt.hz.c.4
            @Override // com.byazt.xu.c
            public void c() {
                String strTt;
                long jCurrentTimeMillis;
                c.this.rl = true;
                c.this.qy();
                if (c.this.gt != null) {
                    c.this.gt.c();
                }
                com.byazt.hr.u.c().sp(c.this.n);
                if (c.this.uj != null) {
                    com.byazt.eu.tt.c("TTMediationSDK", com.byazt.eu.uj.c(c.this.n, "show_listen") + "adSlotId：" + c.this.uj.getAdNetworkSlotId() + "，广告类型：" + com.byazt.yl.c.c(c.this.uj.getAdNetworkPlatformId()));
                    com.byazt.hr.sl.c().tt(c.this.n, c.this.uj.getAdNetworkSlotId());
                }
                c cVar = c.this;
                cVar.c(cVar.ve);
                c cVar2 = c.this;
                cVar2.ve(cVar2.uj);
                if (c.this.uj != null) {
                    com.byazt.xx.ve.c(c.this.uj.getAdnName(), c.this.n, c.this.uj.getAdNetworkSlotId());
                }
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                if (nu.c(c.this.uj)) {
                    strTt = nu.tt();
                    jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
                } else {
                    strTt = null;
                    jCurrentTimeMillis = -1;
                }
                com.byazt.yl.ve veVar = c.this.uj;
                com.byazt.ll.tt ttVar = c.this.f2323a;
                boolean zRl = c.this.rl();
                com.byazt.ng.a.c(veVar, ttVar, zRl ? 1 : 0, strTt, jCurrentTimeMillis, false, c.this.gt());
                com.byazt.oi.ve.c(c.this.n, c.this.uj);
            }

            @Override // com.byazt.xu.c
            public void c(com.byazt.pp.c cVar) {
                String strTt;
                long jCurrentTimeMillis;
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                if (nu.c(c.this.uj)) {
                    strTt = nu.tt();
                    jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
                } else {
                    strTt = null;
                    jCurrentTimeMillis = -1;
                }
                com.byazt.ng.a.c(c.this.uj, c.this.f2323a, cVar, 1, c.this.rl() ? 1 : 0, strTt, jCurrentTimeMillis);
                c.this.c(cVar);
            }

            @Override // com.byazt.xu.c
            public void tt() {
                String strTt;
                long jCurrentTimeMillis;
                c.this.gr();
                if (c.this.gt != null) {
                    c.this.gt.tt();
                }
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                if (nu.c(c.this.uj)) {
                    strTt = nu.tt();
                    jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
                } else {
                    strTt = null;
                    jCurrentTimeMillis = -1;
                }
                com.byazt.yl.ve veVar = c.this.uj;
                com.byazt.ll.tt ttVar = c.this.f2323a;
                boolean zRl = c.this.rl();
                boolean zIsClickListenRepeatOnce = c.this.uj.isClickListenRepeatOnce();
                com.byazt.ng.a.c(veVar, ttVar, zRl ? 1 : 0, strTt, jCurrentTimeMillis, zIsClickListenRepeatOnce);
            }

            @Override // com.byazt.xu.c
            public void ve() {
                c.this.gu();
                if (c.this.m) {
                    c.this.yv();
                    if (c.this.gt != null) {
                        c.this.gt.ve();
                    }
                }
            }

            @Override // com.byazt.xu.c
            public void uj() {
                if (c.this.gt != null) {
                    c.this.gt.sp();
                }
            }

            @Override // com.byazt.xu.c
            public void n() {
                if (c.this.gt != null) {
                    c.this.gt.x();
                }
            }
        };
    }

    public void c(com.byazt.ll.tt ttVar, com.byazt.bi.tt ttVar2) {
        super.tt(ttVar);
        this.f2323a = ttVar;
        this.my = ttVar2;
        this.i = this.c;
        i();
    }

    public void c(Activity activity) {
        c(activity, (Object) null, (String) null);
    }

    @Override // com.byazt.hz.uj
    public void c(Activity activity, Object obj, String str) {
        if (activity == null) {
            com.byazt.eu.tt.uj("TTMediationSDK", "activity can not be null !");
        } else {
            tt(activity, obj, str);
            c(this.uj);
        }
    }

    private void tt(Activity activity, Object obj, String str) {
        super.c(activity, obj, str, new da.c() { // from class: com.byazt.hz.c.1
            @Override // com.byazt.hz.da.c
            public void c() {
                c.this.c(new com.byazt.pp.c(40052, com.byazt.pp.c.c(40052)));
            }
        });
    }

    @Override // com.byazt.hz.tt
    public com.byazt.pp.ve f_() {
        if (this.rl) {
            return super.f_();
        }
        return null;
    }

    @Override // com.byazt.hz.da, com.byazt.hz.tt
    public void ve() {
        if (this.uj == null) {
            com.byazt.hk.c.c().c(this.ve.c(false), this.n, this.f2323a, rh(), this.uj);
        }
        super.ve();
        this.gt = null;
        this.my = null;
    }

    @Override // com.byazt.hz.tt, com.byazt.ul.c
    public void sp() {
        com.byazt.bi.tt ttVar = this.my;
        if (ttVar != null) {
            ttVar.c();
        }
    }

    @Override // com.byazt.hz.tt, com.byazt.ul.c
    public void tt(com.byazt.pp.c cVar) {
        com.byazt.bi.tt ttVar = this.my;
        if (ttVar != null) {
            ttVar.c(cVar);
        }
    }

    @Override // com.byazt.hz.tt, com.byazt.ul.c
    public void x() {
        com.byazt.bi.tt ttVar = this.my;
        if (ttVar != null) {
            ttVar.tt();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final com.byazt.pp.c cVar) {
        com.byazt.eu.n.ve(new Runnable() { // from class: com.byazt.hz.c.2
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.gt != null) {
                    c.this.gt.c(cVar);
                }
            }
        });
    }

    @Override // com.byazt.hz.uj, com.byazt.hz.da
    public void c(com.byazt.yl.ve veVar, Activity activity, Object obj, String str) {
        if (veVar != null) {
            if (veVar.getSubAdType() == 1) {
                this.i = this.tt;
            } else if (veVar.getSubAdType() == 2) {
                this.i = this.c;
            }
        }
        super.c(veVar, activity, obj, str);
    }
}
