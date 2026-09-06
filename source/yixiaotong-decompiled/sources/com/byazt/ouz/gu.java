package com.byazt.ouz;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.byazt.aas.cu;
import com.byazt.aas.h;
import com.byazt.aas.nb;
import com.byazt.ete.ic;
import com.byazt.ete.ir;
import com.byazt.omf.EmptyView;
import com.byazt.omf.zb;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 27, 17})
public class gu extends tt {
    public static final String TAG = "TTNativeExpressAd";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f2602a;
    public NativeExpressView c;
    public com.byazt.dyf.tt da;
    public EmptyView gr;
    public n my;
    public WeakReference<u> n;
    public int p;
    public final com.byazt.sy.n qy;
    public a rh;
    public final FrameLayout rl;
    public com.byazt.pop.ve sl;
    public com.byazt.pop.c sp;
    public final Context tt;
    public ic ve;
    public final com.byazt.ddx.n yv;
    public boolean zm;
    public String uj = com.byazt.dyf.tt.AD_TAG_FEED;
    public Double t = null;
    public boolean u = false;
    public boolean yp = false;
    public AtomicBoolean z = new AtomicBoolean(false);
    public AtomicBoolean m = new AtomicBoolean(false);
    public AtomicBoolean nu = new AtomicBoolean(false);
    public volatile boolean gt = false;
    public final ViewGroup gu = new FrameLayout(com.byazt.omf.gt.getContext());
    public final c md = new c() { // from class: com.byazt.ouz.gu.1
        @Override // com.byazt.ouz.c
        public void c(View view, int i) {
            if (gu.this.f2602a != null) {
                gu.this.f2602a.c(gu.this.gu, i);
            }
        }

        @Override // com.byazt.ouz.c
        public void tt(View view, int i) {
            boolean zOq = com.byazt.omf.gt.tt().oq();
            if (gu.this.f2602a != null && (!gu.this.nu.getAndSet(true) || zOq)) {
                gu.this.f2602a.tt(gu.this.gu, i);
                com.byazt.ete.nu nuVarYp = gu.this.ve.yp();
                if (gu.this.ve.yv() && nuVarYp != null) {
                    com.byazt.yxu.c.c().c(gu.this.tt, nuVarYp.tt());
                }
            }
            if (gu.this.qy == null || gu.this.qy.c() == null) {
                return;
            }
            gu.this.qy.c().uj();
        }

        @Override // com.byazt.ouz.c
        public void c(View view, String str, int i) {
            if (gu.this.f2602a != null) {
                gu.this.f2602a.c(gu.this.gu, str, i);
            }
        }

        @Override // com.byazt.ouz.c
        public void c(View view, float f, float f2) {
            if (gu.this.c != null && gu.this.qy != null) {
                gu.this.c.setEasyPlayableSender(gu.this.qy.c());
                gu.this.qy.c(gu.this.c.getEasyPlayableLayout(), gu.this.c.getVideoContainer());
            }
            gu.this.gu.removeAllViews();
            gu.this.gu.addView(view);
            gu.this.gu.addView(gu.this.rl, new FrameLayout.LayoutParams((int) f, (int) f2));
            if (gu.this.f2602a != null) {
                gu.this.f2602a.c(gu.this.gu, f, f2);
            }
        }
    };

    @Override // com.byazt.ouz.tt
    public ic getMaterialMeta() {
        return this.ve;
    }

    @Override // com.byazt.ouz.tt, com.byazt.nc.x
    public void setPrice(Double d) {
        this.t = d;
    }

    public gu(Context context, final ic icVar, com.byazt.dj.tt ttVar, int i) {
        this.zm = false;
        this.p = 5;
        this.p = i;
        this.tt = context;
        this.ve = icVar;
        this.zm = com.byazt.omf.gt.tt().xx() || com.byazt.omf.gt.tt().jl();
        com.byazt.rgb.tt.c(icVar, ttVar, i, getLifecycleId());
        initExpressView(context, icVar, ttVar);
        this.rl = new FrameLayout(context);
        this.yv = new com.byazt.ddx.n(this.ve, this.uj);
        this.qy = new com.byazt.sy.n(icVar, new com.byazt.sy.c() { // from class: com.byazt.ouz.gu.2
            @Override // com.byazt.sy.c
            public void c(ViewGroup viewGroup) {
            }

            @Override // com.byazt.ouz.sl
            public void c(ic icVar2) {
            }

            @Override // com.byazt.ouz.sl
            public void uj(int i2) {
            }

            @Override // com.byazt.ouz.sl
            public void c(int i2) {
                if (gu.this.c != null) {
                    gu.this.c.c(i2);
                }
            }

            @Override // com.byazt.ouz.sl
            public long c() {
                if (gu.this.c != null) {
                    return gu.this.c.c();
                }
                return 0L;
            }

            @Override // com.byazt.ouz.sl
            public int tt() {
                if (gu.this.c != null) {
                    return gu.this.c.tt();
                }
                return 0;
            }

            @Override // com.byazt.ouz.sl
            public int ve() {
                if (gu.this.c != null) {
                    return gu.this.c.ve();
                }
                return 0;
            }

            @Override // com.byazt.ouz.sl
            public void uj() {
                if (gu.this.c != null) {
                    gu.this.c.uj();
                }
            }

            @Override // com.byazt.ouz.sl
            public void tt(int i2) {
                if (gu.this.c != null) {
                    gu.this.c.tt(i2);
                }
            }

            @Override // com.byazt.ouz.sl
            public void n() {
                if (gu.this.c != null) {
                    gu.this.c.n();
                }
            }

            @Override // com.byazt.ouz.sl
            public void c(int i2, String str) {
                if (gu.this.c != null) {
                    gu.this.c.c(i2, str);
                }
            }

            @Override // com.byazt.ouz.sl
            public void setPauseFromExpressView(boolean z) {
                if (gu.this.c != null) {
                    gu.this.c.setPauseFromExpressView(z);
                }
            }

            @Override // com.byazt.ouz.sl
            public void c(float f) {
                if (gu.this.c != null) {
                    gu.this.c.c(f);
                }
            }

            @Override // com.byazt.ouz.sl
            public void ve(int i2) {
                if (gu.this.c != null) {
                    gu.this.c.ve(i2);
                }
            }

            @Override // com.byazt.sy.c
            public void c(View view) {
                gu.this.md.c(view, icVar.i());
                ic icVar2 = icVar;
                com.byazt.sy.ve.tt(icVar2, com.byazt.ete.p.sp(icVar2), true, null);
            }

            @Override // com.byazt.sy.c
            public void c(View view, int i2, com.byazt.sr.ve veVar, ir irVar) {
                if (gu.this.c != null) {
                    gu.this.c.c(view, i2, veVar, -1);
                }
                com.byazt.sy.ve.c(icVar, (com.byazt.ete.u) irVar, false, (JSONObject) null, veVar instanceof com.byazt.ete.gr ? ((com.byazt.ete.gr) veVar).c().optBoolean("isLottieInternalClick", false) : false);
            }

            @Override // com.byazt.sy.c
            public void c(View view, int i2, com.byazt.sr.ve veVar, int i3) {
                if (gu.this.c != null) {
                    gu.this.c.c(view, i2, veVar, i3);
                }
            }
        });
    }

    public void initExpressView(Context context, ic icVar, com.byazt.dj.tt ttVar) {
        NativeExpressView nativeExpressView = new NativeExpressView(context, icVar, ttVar, this.uj);
        this.c = nativeExpressView;
        this.gu.addView(nativeExpressView);
        c(this.c, this.ve);
    }

    @Override // com.byazt.ouz.tt, com.byazt.nc.yp
    public View getExpressAdView() {
        com.byazt.dz.uj.c().c(this.ve);
        com.byazt.iyp.tt.c(this.ve.c());
        return this.gu;
    }

    @Override // com.byazt.ouz.tt, com.byazt.nc.yp
    public int getImageMode() {
        ic icVar = this.ve;
        if (icVar == null) {
            return -1;
        }
        return icVar.id();
    }

    @Override // com.byazt.ouz.tt, com.byazt.nc.yp
    public com.byazt.nc.uj getDislikeInfo() {
        ic icVar = this.ve;
        if (icVar == null || icVar.wq() == null) {
            return null;
        }
        this.ve.wq().tt(this.uj);
        return new com.byazt.vo.c(this.ve.wq());
    }

    @Override // com.byazt.ouz.tt, com.byazt.nc.yp
    public void setExpressInteractionListener(com.byazt.ft.tt ttVar) {
        this.f2602a = c.c(this, ttVar);
        this.c.setExpressInteractionListener(this.md);
    }

    @Override // com.byazt.ouz.tt, com.byazt.nc.yp
    public void setExpressInteractionListener(com.byazt.ft.c cVar) {
        this.f2602a = c.c((com.byazt.nc.yp) this, cVar);
        this.c.setExpressInteractionListener(this.md);
    }

    @Override // com.byazt.ouz.tt, com.byazt.nc.yp
    public void setDownloadListener(com.byazt.ocd.ve veVar) {
        this.sp = com.byazt.pop.c.C0251c.c(veVar);
        if (this.x != null) {
            this.x.c(this.sp);
        }
    }

    @Override // com.byazt.ouz.tt, com.byazt.nc.yp
    public Map<String, Object> getMediaExtraInfo() {
        ic icVar = this.ve;
        if (icVar != null) {
            return icVar.yt();
        }
        return null;
    }

    @Override // com.byazt.nc.yp
    public com.byazt.sbm.n getMediationManager() {
        return new com.byazt.ah.ve();
    }

    @Override // com.byazt.nc.yp
    public String getLifecycleId() {
        ic icVar = this.ve;
        if (icVar != null) {
            return icVar.zm();
        }
        return null;
    }

    @Override // com.byazt.ouz.tt, com.byazt.nc.yp
    public int getInteractionType() {
        ic icVar = this.ve;
        if (icVar == null) {
            return -1;
        }
        return icVar.i();
    }

    @Override // com.byazt.ouz.tt, com.byazt.nc.yp
    public void render() {
        com.byazt.dyf.tt ttVar = this.da;
        if (ttVar != null) {
            ttVar.setMonitorView(this.c);
        }
        this.c.m();
        com.byazt.dz.uj.c().c(this.ve);
    }

    @Override // com.byazt.ouz.tt, com.byazt.nc.yp
    public void destroy() {
        super.destroy();
        com.byazt.rgb.tt.ve(getLifecycleId(), 2);
        NativeExpressView nativeExpressView = this.c;
        if (nativeExpressView != null) {
            nativeExpressView.t();
        }
        this.yv.c(zb.tt(this.c), 16);
        com.byazt.pop.ve veVar = this.sl;
        if (veVar != null) {
            veVar.ve();
        }
        com.byazt.sy.n nVar = this.qy;
        if (nVar != null) {
            nVar.tt();
        }
        ic icVar = this.ve;
        cu.tt(icVar != null ? icVar.eo() : 0);
    }

    @Override // com.byazt.ouz.tt, com.byazt.nc.yp
    public void setDislikeCallback(Activity activity, final com.byazt.dhf.c cVar) {
        if (cVar == null || activity == null) {
            return;
        }
        c(activity, new com.byazt.dhf.c(null) { // from class: com.byazt.ouz.gu.3
            @Override // com.byazt.dhf.c
            public void tt() {
                cVar.tt();
            }

            @Override // com.byazt.dhf.c
            public void c(int i, String str, boolean z) {
                com.byazt.rgb.tt.ve(gu.this.getLifecycleId(), 1);
                cVar.c(i, str, z);
            }

            @Override // com.byazt.dhf.c
            public void c() {
                cVar.c();
            }
        });
    }

    @Override // com.byazt.nc.yp
    public void uploadDislikeEvent(String str) {
        com.byazt.ddx.uj.tt(this.ve, str);
    }

    @Override // com.byazt.ouz.tt
    public void c(Dialog dialog) {
        if (dialog == null) {
            com.byazt.nr.m.ve("dialog is null, please check");
            return;
        }
        NativeExpressView nativeExpressView = this.c;
        if (nativeExpressView != null) {
            nativeExpressView.setOuterDislike(dialog);
        }
    }

    @Override // com.byazt.ouz.tt, com.byazt.nc.yp
    public com.byazt.nc.sp getDislikeDialog(Activity activity) {
        if (this.da == null) {
            c(activity, (com.byazt.dhf.c) null);
        }
        return this.da;
    }

    @Override // com.byazt.nc.yp
    public void registerClickableRects(JSONObject jSONObject) {
        NativeExpressView nativeExpressView = this.c;
        if (nativeExpressView != null) {
            nativeExpressView.c(jSONObject);
        }
    }

    @Override // com.byazt.nc.yp
    public void unRegisterRects() {
        NativeExpressView nativeExpressView = this.c;
        if (nativeExpressView != null) {
            nativeExpressView.qy();
        }
    }

    private void c(Activity activity, com.byazt.dhf.c cVar) {
        if (this.da == null) {
            com.byazt.dyf.tt ttVar = new com.byazt.dyf.tt(activity, this.ve.wq(), this.uj, false, com.byazt.xky.tt.c());
            this.da = ttVar;
            com.byazt.tl.ve.c(activity, this.ve, ttVar);
        }
        com.byazt.dyf.tt ttVar2 = this.da;
        if (ttVar2 != null) {
            ttVar2.setMonitorView(this.c);
        }
        this.da.setDislikeInteractionCallback(cVar);
        NativeExpressView nativeExpressView = this.c;
        if (nativeExpressView != null) {
            nativeExpressView.setDislike(this.da);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (!this.gt) {
            this.gt = true;
            if (this.ve.i() == 4) {
                com.byazt.bzd.x.c(new com.byazt.bwm.sp("native_register_download") { // from class: com.byazt.ouz.gu.4
                    @Override // java.lang.Runnable
                    public void run() {
                        gu guVar = gu.this;
                        guVar.sl = com.byazt.yih.x.c(guVar.tt, gu.this.ve, gu.this.uj);
                        if (gu.this.rh != null) {
                            ((com.byazt.nat.c) gu.this.rh.c(com.byazt.nat.c.class)).c(gu.this.sl);
                        }
                        if (gu.this.my != null) {
                            ((com.byazt.nat.c) gu.this.my.c(com.byazt.nat.c.class)).c(gu.this.sl);
                        }
                        if (gu.this.tt instanceof Activity) {
                            gu.this.sl.c((Activity) gu.this.tt, false);
                        }
                        gu guVar2 = gu.this;
                        guVar2.c(guVar2.sl, gu.this.c);
                        gu.this.sl.c();
                        gu.this.sl.c(gu.this.x);
                    }
                });
                return;
            }
            return;
        }
        if (this.sl != null) {
            a aVar = this.rh;
            if (aVar != null) {
                ((com.byazt.nat.c) aVar.c(com.byazt.nat.c.class)).c(this.sl);
            }
            n nVar = this.my;
            if (nVar != null) {
                ((com.byazt.nat.c) nVar.c(com.byazt.nat.c.class)).c(this.sl);
            }
            try {
                c(this.sl, this.c);
                this.sl.c();
                this.sl.c(this.x);
            } catch (Exception unused) {
            }
        }
    }

    public void c(final NativeExpressView nativeExpressView, final ic icVar) {
        this.ve = icVar;
        nativeExpressView.setBackupListener(new com.byazt.xl.ve() { // from class: com.byazt.ouz.gu.5
            @Override // com.byazt.xl.ve
            public boolean c(ViewGroup viewGroup, int i) {
                try {
                    ((NativeExpressView) viewGroup).my();
                    u uVar = new u(viewGroup.getContext());
                    com.byazt.btt.c.c(Integer.valueOf(icVar.hashCode()), gu.this);
                    uVar.c(gu.this.ve, (NativeExpressView) viewGroup, gu.this.sl);
                    uVar.setDislikeInner(gu.this.da);
                    uVar.setDislikeOuter(gu.this.i);
                    if (gu.this.ve != null) {
                        gu guVar = gu.this;
                        guVar.c(guVar.ve.wq());
                    }
                    gu.this.n = new WeakReference<>(uVar);
                    return true;
                } catch (Exception unused) {
                    return false;
                }
            }
        });
        com.byazt.ddx.uj.c(icVar);
        EmptyView emptyViewC = c(nativeExpressView);
        this.gr = emptyViewC;
        if (emptyViewC == null) {
            EmptyView emptyView = new EmptyView(this.tt, nativeExpressView, icVar != null ? icVar.m760if() : 1000);
            this.gr = emptyView;
            emptyView.setAdType(this.p);
            this.gr.c(this.ve, this.uj);
            nativeExpressView.addView(this.gr);
        }
        this.gr.setCallback(new EmptyView.c() { // from class: com.byazt.ouz.gu.6
            @Override // com.byazt.omf.EmptyView.c
            public void c(boolean z) {
                Activity activity;
                WeakReference<Activity> weakReferenceC;
                Activity activity2;
                if (gu.this.sl != null) {
                    if (z) {
                        gu.this.sl.tt();
                    } else {
                        com.byazt.pop.ve unused = gu.this.sl;
                    }
                }
                gu.this.yv.c(zb.tt(nativeExpressView), z ? 12 : 13);
                if (nb.ve(gu.this.ve)) {
                    if (z) {
                        if (!nb.ve(gu.this.ve) || (weakReferenceC = com.byazt.omf.x.m().ve().c()) == null || (activity2 = weakReferenceC.get()) == null) {
                            return;
                        }
                        com.byazt.qqc.ve.c().c(activity2.getWindow(), gu.this.ve, nb.zm(gu.this.ve));
                        return;
                    }
                    WeakReference<Activity> weakReferenceC2 = com.byazt.omf.x.m().ve().c();
                    if (weakReferenceC2 == null || (activity = weakReferenceC2.get()) == null) {
                        return;
                    }
                    com.byazt.qqc.ve.c().tt((Context) activity, gu.this.ve, true);
                }
            }

            @Override // com.byazt.omf.EmptyView.c
            public void c() {
                WeakReference<Activity> weakReferenceC;
                Activity activity;
                gu.this.c();
                gu.this.yv.c(zb.tt(nativeExpressView), 14);
                if (!nb.ve(gu.this.ve) || (weakReferenceC = com.byazt.omf.x.m().ve().c()) == null || (activity = weakReferenceC.get()) == null) {
                    return;
                }
                com.byazt.qqc.ve.c().c(activity.getWindow(), gu.this.ve, nb.zm(gu.this.ve));
            }

            @Override // com.byazt.omf.EmptyView.c
            public void tt() {
                WeakReference<Activity> weakReferenceC;
                Activity activity;
                if (gu.this.sl != null) {
                    gu.this.sl.ve();
                }
                gu.this.yv.c(zb.tt(nativeExpressView), 15);
                gu.this.z.set(false);
                gu.this.m.set(false);
                if (!nb.ve(gu.this.ve) || (weakReferenceC = com.byazt.omf.x.m().ve().c()) == null || (activity = weakReferenceC.get()) == null) {
                    return;
                }
                com.byazt.qqc.ve.c().tt(activity.getWindow(), gu.this.ve, true);
            }

            @Override // com.byazt.omf.EmptyView.c
            public void c(View view, Map<String, Object> map) {
                gu.this.c();
                gu.this.yv.c(zb.tt(view), 11);
                Map mapTt = gu.this.tt();
                mapTt.put("is_repeat", Boolean.valueOf(gu.this.nu.get()));
                if (map != null && map.containsKey("show_send_type")) {
                    mapTt.put("show_send_type", map.get("show_send_type"));
                }
                mapTt.put("is_repeat", Boolean.valueOf(gu.this.nu.get()));
                gu.this.z.set(true);
                if (!gu.this.m.get()) {
                    gu.this.m.set(true);
                    com.byazt.ddx.uj.c(icVar, gu.this.uj, (Map<String, Object>) mapTt, gu.this.t);
                    com.byazt.pf.c.c().uj();
                    ic icVar2 = icVar;
                    cu.c(icVar2 != null ? icVar2.eo() : 0);
                }
                boolean z = (gu.this.f2602a == null || gu.this.nu.get()) ? false : true;
                gu.this.md.tt(view, icVar.i());
                if (z) {
                    if (view == null) {
                        view = gu.this.gu;
                    }
                    ic icVar3 = icVar;
                    String str = gu.this.uj;
                    ic icVar4 = icVar;
                    com.byazt.iyp.tt.c(icVar3, str, view, icVar4 != null && icVar4.up());
                }
                if (gu.this.c != null) {
                    gu.this.c.nu();
                    gu.this.c.z();
                }
            }
        });
        Context context = this.tt;
        String str = this.uj;
        a aVar = new a(context, icVar, str, nb.uj(str));
        this.rh = aVar;
        setAdShowCallBack((com.byazt.vis.ve) aVar.c(com.byazt.vis.ve.class));
        this.rh.c(nativeExpressView);
        ((com.byazt.nat.c) this.rh.c(com.byazt.nat.c.class)).c(this);
        this.c.setClickListener(this.rh);
        Context context2 = this.tt;
        String str2 = this.uj;
        n nVar = new n(context2, icVar, str2, nb.uj(str2));
        this.my = nVar;
        setAdShowCallBack((com.byazt.vis.ve) nVar.c(com.byazt.vis.ve.class));
        this.my.c(nativeExpressView);
        ((com.byazt.nat.c) this.my.c(com.byazt.nat.c.class)).c(this);
        this.c.setClickCreativeListener(this.my);
        if (this.zm) {
            return;
        }
        this.gr.setNeedCheckingShow(true);
    }

    public void setAdShowCallBack(final com.byazt.vis.ve veVar) {
        veVar.c(new com.byazt.vis.ve.c() { // from class: com.byazt.ouz.gu.7
            @Override // com.byazt.vis.ve.c
            public boolean c() {
                veVar.c(gu.this.gr);
                veVar.c(gu.this.tt());
                veVar.c(gu.this.uj);
                veVar.c(gu.this.t);
                return gu.this.z.get();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, Object> tt() {
        HashMap map = new HashMap();
        yv.c(map, this.ve, this.c);
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.byazt.pop.ve veVar, NativeExpressView nativeExpressView) {
        if (veVar == null || nativeExpressView == null) {
            return;
        }
        ic icVar = this.ve;
        this.x = new tt.c(this.sp, icVar != null ? icVar.uj() : "");
        veVar.c(this.x);
    }

    private EmptyView c(ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof EmptyView) {
                return (EmptyView) childAt;
            }
        }
        return null;
    }

    @Override // com.byazt.ouz.tt, com.byazt.nc.x
    public void win(Double d) {
        if (this.u) {
            return;
        }
        h.c(this.ve, d);
        this.u = true;
    }

    @Override // com.byazt.ouz.tt, com.byazt.nc.x
    public void loss(Double d, String str, String str2) {
        if (this.yp) {
            return;
        }
        h.c(this.ve, d, str, str2);
        this.yp = true;
    }

    public void finalize() throws Throwable {
        super.finalize();
        com.byazt.rgb.tt.ve(getLifecycleId(), 3);
    }
}
