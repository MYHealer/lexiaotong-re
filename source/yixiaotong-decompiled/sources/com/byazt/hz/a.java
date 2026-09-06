package com.byazt.hz;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.byazt.nr.m;
import com.byazt.vx.nu;
import com.huawei.openalliance.ad.constant.br;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 701, 34})
public class a extends tt implements com.byazt.zq.c {
    public com.byazt.oc.c c;
    public boolean m;
    public com.byazt.oc.uj nu;
    public com.byazt.oc.tt tt;

    public void c(com.byazt.oc.c cVar) {
        this.c = cVar;
    }

    public void c(com.byazt.oc.uj ujVar) {
        this.nu = ujVar;
    }

    public a(Context context) {
        super(context);
        this.m = false;
    }

    public void c(com.byazt.ll.tt ttVar, com.byazt.oc.tt ttVar2) {
        c(ttVar);
        this.i = this;
        this.tt = ttVar2;
        i();
    }

    private View c(Context context, com.byazt.yl.ve veVar) {
        this.uj = veVar;
        this.ve.uj(this.uj);
        this.uj.setHasShown(true);
        this.uj.setTTAdatperCallback(this.i);
        if (this.uj.canAdReuse() && com.byazt.hk.c.c().uj(this.n, this.uj.getAdNetworkSlotId(), this.f2323a.n())) {
            com.byazt.qv.a.c(this.uj, this.n, this.uj.getAdNetworkSlotId());
        }
        c(false);
        com.byazt.eu.tt.c("TTMediationSDK", com.byazt.eu.uj.c(this.n, br.b.V) + "展示的广告类型：" + com.byazt.yl.c.c(this.uj.getAdNetworkPlatformId()) + ",slotId：" + this.uj.getAdNetworkSlotId() + ",slotType:" + this.uj.getAdNetworkSlotType());
        final View adView = this.uj.getAdView();
        if (!this.uj.isCustomAd() && this.uj.getSubAdType() == 4 && !this.uj.isExpressAd()) {
            com.byazt.oc.uj ujVar = this.nu;
            if (ujVar != null) {
                try {
                    adView = ujVar.c(ve(this.uj));
                    if (adView == null) {
                        com.byazt.eu.tt.c("TTMediationSDK", "--==-- banner混出自渲染信息流，getGMBannerViewFromNativeAd()返回null，将无法展示该广告");
                    }
                } catch (Throwable th) {
                    com.byazt.eu.tt.c("TTMediationSDK", "--==-- banner混出自渲染信息流，getGMBannerViewFromNativeAd()发生异常，将无法展示该广告，信息如下：");
                    m.c(th);
                }
            } else {
                com.byazt.eu.tt.c("TTMediationSDK", "--==-- banner混出自渲染信息流，但未提供GMNativeToBannerListener，将无法展示该广告");
            }
        }
        if (this.uj.hasDislike() && context != null) {
            this.uj.setDislikeCallback((Activity) context, new com.byazt.dhf.c(null) { // from class: com.byazt.hz.a.1
                @Override // com.byazt.dhf.c
                public void c(int i, String str, boolean z) {
                    View view = adView;
                    if (view != null) {
                        View view2 = (View) view.getParent();
                        if (view2 instanceof ViewGroup) {
                            ((ViewGroup) view2).removeViewInLayout(adView);
                        }
                    }
                }
            });
        }
        return adView;
    }

    public synchronized View c(Context context) {
        List<com.byazt.nbs.da> listTt;
        View viewC;
        com.byazt.yl.ve next;
        List<com.byazt.ix.sp> listC;
        com.byazt.yl.ve veVar;
        com.byazt.ng.a.c(this.f2323a);
        if (this.t) {
            com.byazt.ng.a.c((List<com.byazt.yl.ve>) null, this.f2323a, 0);
            ve(new com.byazt.pp.c(40052, com.byazt.pp.c.c(40052)));
            return null;
        }
        int iTt = tt(this.n);
        if (iTt != 0) {
            com.byazt.ng.a.c((List<com.byazt.yl.ve>) null, this.f2323a, iTt);
            ve(new com.byazt.pp.c(iTt, com.byazt.pp.c.c(iTt)));
            return null;
        }
        List<com.byazt.yl.ve> listC2 = this.ve.c(true);
        this.ve.c(listC2);
        try {
            listTt = tt();
        } catch (Throwable th) {
            m.c(th);
            listTt = null;
        }
        if (listTt != null && listTt.size() > 0) {
            HashMap<String, com.byazt.yl.ve> mapTt = tt(listC2);
            viewC = null;
            for (com.byazt.nbs.da daVar : listTt) {
                if (daVar != null) {
                    String strRh = daVar.rh();
                    com.byazt.yl.ve veVar2 = mapTt.get(strRh);
                    if (veVar2 != null && veVar2.isReady(this.n) && !veVar2.isHasShown() && (viewC = c(context, veVar2)) != null) {
                        break;
                    }
                    if (daVar.gt() && com.byazt.hk.c.c().uj(this.n, strRh, this.f2323a.n()) && com.byazt.hk.c.c().c(strRh, this.f2323a, false) == 3 && (listC = com.byazt.hk.c.c().c(strRh, this.f2323a, this.f2323a.n())) != null && listC.size() > 0 && (veVar = listC.get(0).c) != null && veVar.isReady(this.n) && !veVar.isHasShown()) {
                        tt(veVar);
                        viewC = c(context, veVar);
                        if (viewC != null) {
                            break;
                        }
                    }
                }
            }
        } else {
            viewC = null;
        }
        if (viewC == null && listC2 != null && listC2.size() > 0) {
            Iterator<com.byazt.yl.ve> it = listC2.iterator();
            while (it.hasNext() && ((next = it.next()) == null || !next.isReady(this.n) || next.isHasShown() || (viewC = c(context, next)) == null)) {
            }
        }
        if (viewC != null) {
            this.t = true;
            List<com.byazt.yl.ve> listC3 = this.ve.c(true);
            com.byazt.hk.c.c().c(listC3, this.n, this.f2323a, this.f2323a.n(), this.uj);
            if (this.uj != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.uj);
                com.byazt.vy.c.c().c(this.f2323a, com.byazt.vy.c.c(this.f2323a, arrayList, listC3));
                c(arrayList);
            }
            com.byazt.ng.a.c(this.uj, this.f2323a, false, 0);
            return viewC;
        }
        com.byazt.ng.a.c(listC2, this.f2323a, 0);
        ve(new com.byazt.pp.c(40052, com.byazt.pp.c.c(40052)));
        return null;
    }

    private void c(boolean z) {
        if (this.uj != null && this.uj.canAdReuse() && com.byazt.hk.c.c().uj(this.n, this.uj.getAdNetworkSlotId(), this.f2323a.n())) {
            com.byazt.hk.c.c().c(this.uj.getAdNetworkSlotId(), this.f2323a, this.ve.zb(), z, this.ve.or(), this.ve.pf(), this.x.get());
        }
    }

    public boolean uj() {
        List<com.byazt.nbs.da> listTt;
        try {
            listTt = tt();
        } catch (Throwable th) {
            m.c(th);
            listTt = null;
        }
        return com.byazt.vx.t.c(this.ve.sl(), this.ve.yp(), this.ve.t(), this.f2323a, this.t, this.n, this.f2323a.n(), listTt);
    }

    public int n() {
        if (this.uj != null) {
            return this.uj.getImageMode();
        }
        return 0;
    }

    public void a() {
        if (this.uj != null) {
            this.uj.onResume();
        }
    }

    public void rl() {
        if (this.uj != null) {
            this.uj.onPause();
        }
    }

    @Override // com.byazt.hz.tt
    public void ve() {
        if (!this.t) {
            com.byazt.hk.c.c().c(this.ve.c(false), this.n, this.f2323a, this.f2323a.n(), this.uj);
        }
        super.ve();
        this.c = null;
        this.tt = null;
    }

    @Override // com.byazt.hz.tt, com.byazt.ul.c
    public void tt(com.byazt.pp.c cVar) {
        com.byazt.oc.tt ttVar = this.tt;
        if (ttVar != null) {
            ttVar.c(cVar);
        }
    }

    @Override // com.byazt.hz.tt, com.byazt.ul.c
    public void sp() {
        com.byazt.oc.tt ttVar = this.tt;
        if (ttVar != null) {
            ttVar.c();
        }
    }

    @Override // com.byazt.oc.c
    public void c() {
        com.byazt.oc.c cVar = this.c;
        if (cVar != null) {
            cVar.c();
        }
    }

    @Override // com.byazt.oc.c
    public void c(View view) {
        String strTt;
        long jCurrentTimeMillis;
        com.byazt.oc.c cVar = this.c;
        if (cVar != null) {
            cVar.c(view);
        }
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        if (nu.c(this.uj)) {
            strTt = nu.tt();
            jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
        } else {
            strTt = null;
            jCurrentTimeMillis = -1;
        }
        com.byazt.bg.c.n(this.f2323a.gt());
        com.byazt.ng.a.c(this.uj, this.f2323a, 0, strTt, jCurrentTimeMillis, this.uj.isClickListenRepeatOnce());
    }

    @Override // com.byazt.oc.c
    public void tt(View view) {
        String strTt;
        long jCurrentTimeMillis;
        this.m = true;
        if (this.c != null) {
            com.byazt.hr.u.c().sp(this.n);
            com.byazt.hr.u.c().tt(this.n);
            this.c.tt(view);
        }
        if (this.uj != null) {
            com.byazt.eu.tt.c("TTMediationSDK", com.byazt.eu.uj.c(this.n, "show_listen") + "adSlotId：" + this.uj.getAdNetworkSlotId() + "，广告类型：" + com.byazt.yl.c.c(this.uj.getAdNetworkPlatformId()));
            com.byazt.hr.sl.c().tt(this.n, this.uj.getAdNetworkSlotId());
            com.byazt.hr.t.c().tt(this.n, this.uj.getAdNetworkSlotId());
        }
        if (this.uj != null) {
            com.byazt.xx.ve.c(this.uj.getAdnName(), this.n, this.uj.getAdNetworkSlotId());
        }
        c(true);
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        if (nu.c(this.uj)) {
            strTt = nu.tt();
            jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
        } else {
            strTt = null;
            jCurrentTimeMillis = -1;
        }
        com.byazt.ng.a.c(this.uj, this.f2323a, 0, strTt, jCurrentTimeMillis, false, gt());
        com.byazt.bg.c.sp(this.f2323a.gt());
        com.byazt.bg.c.ve(this.f2323a.gt());
        com.byazt.psp.uj.c(1, this.f2323a.gt(), this.uj.getAdType(), this.uj.getCpm());
        com.byazt.oi.ve.c(this.n, this.uj);
    }

    @Override // com.byazt.oc.c
    public void c(com.byazt.pp.c cVar) {
        String strTt;
        long jCurrentTimeMillis;
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        if (nu.c(this.uj)) {
            strTt = nu.tt();
            jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
        } else {
            strTt = null;
            jCurrentTimeMillis = -1;
        }
        com.byazt.ng.a.c(this.uj, this.f2323a, cVar, 1, 0, strTt, jCurrentTimeMillis);
        ve(cVar);
    }

    private void ve(final com.byazt.pp.c cVar) {
        com.byazt.eu.n.ve(new Runnable() { // from class: com.byazt.hz.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.c != null) {
                    a.this.c.c(cVar);
                }
            }
        });
    }

    @Override // com.byazt.hz.tt
    public com.byazt.pp.ve f_() {
        if (this.m) {
            return super.f_();
        }
        return null;
    }

    public void c(Activity activity, com.byazt.dhf.c cVar) {
        if (this.uj != null) {
            this.uj.setDislikeCallback(activity, cVar);
        }
    }

    public void c(Dialog dialog, Integer[] numArr) {
        if (this.uj != null) {
            this.uj.setDislikeDialog(dialog, numArr);
        }
    }

    public com.byazt.nc.sp c(Activity activity) {
        if (this.uj != null) {
            return this.uj.getDislikeDialog(activity);
        }
        return null;
    }

    public com.byazt.nc.uj qy() {
        if (this.uj != null) {
            return this.uj.getDislikeInfo();
        }
        return null;
    }

    private com.byazt.oc.ve ve(final com.byazt.yl.ve veVar) {
        return new com.byazt.oc.ve() { // from class: com.byazt.hz.a.3
            @Override // com.byazt.oc.ve
            public String c() {
                return veVar.getAdTitle();
            }

            @Override // com.byazt.oc.ve
            public String tt() {
                return veVar.getIconUrl();
            }

            @Override // com.byazt.oc.ve
            public String ve() {
                return veVar.getImageUrl();
            }

            @Override // com.byazt.oc.ve
            public String uj() {
                return veVar.getActionText();
            }

            @Override // com.byazt.oc.ve
            public double n() {
                return veVar.getStarRating();
            }

            @Override // com.byazt.oc.ve
            public List<String> a() {
                return veVar.getImages();
            }

            @Override // com.byazt.oc.ve
            public String sp() {
                return veVar.getSource();
            }

            @Override // com.byazt.oc.ve
            public int x() {
                return veVar.getImageMode();
            }

            @Override // com.byazt.oc.ve
            public int i() {
                return veVar.getInteractionType();
            }

            @Override // com.byazt.oc.ve
            public void c(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, com.byazt.me.da daVar) {
                veVar.registerViewForInteraction(activity, viewGroup, list, list2, list3, daVar, null);
            }

            @Override // com.byazt.oc.ve
            public com.byazt.me.c da() {
                if (!veVar.hasAppInfo()) {
                    return null;
                }
                com.byazt.me.c cVar = new com.byazt.me.c();
                cVar.uj(veVar.getAppName());
                cVar.n(veVar.getAuthorName());
                cVar.c(veVar.getPackageSizeBytes());
                cVar.a(veVar.getPermissionsUrl());
                cVar.sp(veVar.getPrivacyAgreement());
                cVar.x(veVar.getVersionName());
                cVar.c(veVar.getPermissionsMap());
                cVar.tt(veVar.getAppInfoExtra());
                cVar.ve(veVar.getFunctionDescUrl());
                cVar.c(veVar.getRegUrl());
                cVar.tt(veVar.getRegNumber());
                return cVar;
            }

            @Override // com.byazt.oc.ve
            public boolean sl() {
                return veVar.hasDislike();
            }

            @Override // com.byazt.oc.ve
            public com.byazt.yf.tt c(Activity activity) {
                return c(activity, (Map<String, Object>) null);
            }

            @Override // com.byazt.oc.ve
            public com.byazt.yf.tt c(Activity activity, Map<String, Object> map) {
                final com.byazt.nc.sp dislikeDialog = veVar.getDislikeDialog(activity);
                return new com.byazt.yf.tt() { // from class: com.byazt.hz.a.3.1
                    @Override // com.byazt.yf.tt
                    public void c() {
                        com.byazt.nc.sp spVar = dislikeDialog;
                        if (spVar != null) {
                            spVar.showDislikeDialog();
                        }
                    }

                    @Override // com.byazt.yf.tt
                    public void c(final com.byazt.yf.sp spVar) {
                        com.byazt.nc.sp spVar2 = dislikeDialog;
                        if (spVar2 != null) {
                            spVar2.setDislikeInteractionCallback(new com.byazt.dhf.c(null) { // from class: com.byazt.hz.a.3.1.1
                                @Override // com.byazt.dhf.c
                                public void c() {
                                    com.byazt.yf.sp spVar3 = spVar;
                                    if (spVar3 != null) {
                                        spVar3.tt();
                                    }
                                }

                                @Override // com.byazt.dhf.c
                                public void c(int i, String str, boolean z) {
                                    com.byazt.yf.sp spVar3 = spVar;
                                    if (spVar3 != null) {
                                        spVar3.c(i, str);
                                    }
                                }

                                @Override // com.byazt.dhf.c
                                public void tt() {
                                    com.byazt.yf.sp spVar3 = spVar;
                                    if (spVar3 != null) {
                                        spVar3.c();
                                    }
                                }
                            });
                        }
                    }
                };
            }

            @Override // com.byazt.oc.ve
            public void c(Activity activity, com.byazt.dhf.c cVar) {
                com.byazt.yl.ve veVar2 = veVar;
                if (veVar2 != null) {
                    veVar2.setDislikeCallback(activity, cVar);
                }
            }

            @Override // com.byazt.oc.ve
            public void c(Dialog dialog, Integer[] numArr) {
                com.byazt.yl.ve veVar2 = veVar;
                if (veVar2 != null) {
                    veVar2.setDislikeDialog(dialog, numArr);
                }
            }

            @Override // com.byazt.oc.ve
            public com.byazt.nc.sp tt(Activity activity) {
                com.byazt.yl.ve veVar2 = veVar;
                if (veVar2 != null) {
                    return veVar2.getDislikeDialog(activity);
                }
                return null;
            }

            @Override // com.byazt.oc.ve
            public com.byazt.nc.sp tt(Dialog dialog, Integer[] numArr) {
                com.byazt.yl.ve veVar2 = veVar;
                if (veVar2 != null) {
                    return veVar2.getDislikeDialog(dialog, numArr);
                }
                return null;
            }

            @Override // com.byazt.oc.ve
            public com.byazt.nc.uj t() {
                com.byazt.yl.ve veVar2 = veVar;
                if (veVar2 != null) {
                    return veVar2.getDislikeInfo();
                }
                return null;
            }
        };
    }

    public void uj(String str) {
        if (this.uj != null) {
            this.uj.uploadDislikeEvent(str);
        }
    }

    public void c(com.byazt.ocd.ve veVar) {
        if (this.uj != null) {
            this.uj.setDownloadListener(veVar);
        }
    }

    public void c(com.byazt.ft.ve veVar) {
        if (this.uj != null) {
            this.uj.setVideoAdListener(veVar);
        }
    }

    public void tt(com.byazt.ocd.tt ttVar) {
        if (this.uj != null) {
            this.uj.setAdInteractionListener(ttVar);
        }
    }
}
