package com.byazt.mt;

import android.content.Context;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import client.android.yixiaotong.v3.comman.AppTypeIdUtil;
import com.byazt.aq.a;
import com.byazt.nr.da;
import com.byazt.nr.m;
import com.byazt.or.n;
import com.byazt.sr.ve;
import com.byazt.tm.DynamicRootView;
import com.byazt.xl.sl;
import com.byazt.xl.sp;
import com.byazt.xl.u;
import com.byazt.xl.uj;
import com.byazt.xl.x;
import com.byazt.xl.yp;
import com.byazt.xv.ThemeStatusBroadcastReceiver;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 684, 20})
public class c implements sl, uj<DynamicRootView> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public u f2484a;
    public DynamicRootView c;
    public x n;
    public ScheduledFuture<?> sp;
    public com.byazt.du.x tt;
    public sp uj;
    public Context ve;
    public AtomicBoolean x = new AtomicBoolean(false);
    public volatile boolean i = false;

    public DynamicRootView a() {
        return this.c;
    }

    public void c(x xVar) {
        this.n = xVar;
    }

    public void tt(boolean z) {
        this.i = z;
    }

    public c(Context context, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver, boolean z, com.byazt.du.x xVar, u uVar, com.byazt.wl.c cVar) {
        this.ve = context;
        DynamicRootView dynamicRootView = new DynamicRootView(context, themeStatusBroadcastReceiver, z, uVar, cVar);
        this.c = dynamicRootView;
        this.tt = xVar;
        this.f2484a = uVar;
        dynamicRootView.setRenderListener(this);
        this.f2484a = uVar;
    }

    @Override // com.byazt.xl.uj
    public void c(sp spVar) {
        this.uj = spVar;
        int iX = this.f2484a.x();
        if (iX < 0) {
            this.c.c(this.tt instanceof com.byazt.du.sp ? 127 : AppTypeIdUtil.Drink4GCostControl_1, "time is " + iX);
            return;
        }
        this.sp = n.c(new RunnableC0215c(2), iX, TimeUnit.MILLISECONDS);
        if (this.i) {
            da.ve().postDelayed(new Runnable() { // from class: com.byazt.mt.c.1
                @Override // java.lang.Runnable
                public void run() {
                    c.this.x();
                }
            }, this.f2484a.sl());
        } else if (Looper.getMainLooper() == Looper.myLooper() && this.f2484a.sl() <= 0) {
            x();
        } else {
            da.tt().postDelayed(new Runnable() { // from class: com.byazt.mt.c.2
                @Override // java.lang.Runnable
                public void run() {
                    c.this.x();
                }
            }, this.f2484a.sl());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        this.f2484a.sp().tt(ve());
        JSONObject jSONObjectN = this.f2484a.n();
        if (!com.byazt.six.tt.c(jSONObjectN)) {
            this.c.c(this.tt instanceof com.byazt.du.sp ? AppTypeIdUtil.NewDevice4GBathOTA : 113, "data null is " + (jSONObjectN == null));
        } else {
            this.tt.c(new com.byazt.wl.tt() { // from class: com.byazt.mt.c.3
                @Override // com.byazt.wl.tt
                public void c(final com.byazt.aq.x xVar) {
                    c.this.da();
                    c.this.f2484a.sp().ve(c.this.ve());
                    c.this.c(xVar);
                    c.this.tt(xVar);
                    if (c.this.i) {
                        c.this.ve(xVar);
                    } else {
                        da.tt().post(new Runnable() { // from class: com.byazt.mt.c.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                c.this.ve(xVar);
                            }
                        });
                    }
                    if (c.this.c == null || xVar == null) {
                        return;
                    }
                    c.this.c.setBgColor(xVar.c());
                    c.this.c.setBgMaterialCenterCalcColor(xVar.tt());
                }
            });
            this.tt.c(this.f2484a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.byazt.aq.x xVar) {
        List<com.byazt.aq.x> listSl;
        if (xVar == null || (listSl = xVar.sl()) == null || listSl.size() <= 0) {
            return;
        }
        Collections.sort(listSl, new Comparator<com.byazt.aq.x>() { // from class: com.byazt.mt.c.4
            @Override // java.util.Comparator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public int compare(com.byazt.aq.x xVar2, com.byazt.aq.x xVar3) {
                a aVarN = xVar2.da().n();
                a aVarN2 = xVar3.da().n();
                if (aVarN == null || aVarN2 == null) {
                    return 0;
                }
                return aVarN.hj() >= aVarN2.hj() ? 1 : -1;
            }
        });
        for (com.byazt.aq.x xVar2 : listSl) {
            if (xVar2 != null) {
                c(xVar2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tt(com.byazt.aq.x xVar) {
        float fSp;
        float fA;
        List<com.byazt.aq.x> listSl;
        if (xVar == null) {
            return;
        }
        List<com.byazt.aq.x> listSl2 = xVar.sl();
        if (listSl2 == null || listSl2.size() <= 0) {
            fSp = 0.0f;
        } else {
            fSp = 0.0f;
            for (com.byazt.aq.x xVar2 : listSl2) {
                if (xVar2.sp() > xVar.sp() - xVar2.i() || (listSl = xVar2.sl()) == null || listSl.size() <= 0) {
                    fA = 0.0f;
                } else {
                    fA = 0.0f;
                    for (com.byazt.aq.x xVar3 : listSl) {
                        if (xVar3.da().getType().equals("logo-union")) {
                            fA = xVar3.da().a();
                            fSp = (((-fA) + xVar.sp()) - xVar2.sp()) + xVar2.da().n().mq();
                        }
                    }
                }
                tt(xVar2);
                if (fA <= -15.0f) {
                    xVar2.a(xVar2.i() - fA);
                    xVar2.uj(xVar2.sp() + fA);
                    for (com.byazt.aq.x xVar4 : xVar2.sl()) {
                        xVar4.uj(xVar4.sp() - fA);
                    }
                }
            }
        }
        com.byazt.aq.x xVarT = xVar.t();
        if (xVarT == null) {
            return;
        }
        float fA2 = xVar.a() - xVarT.a();
        float fSp2 = xVar.sp() - xVarT.sp();
        xVar.ve(fA2);
        xVar.uj(fSp2);
        if (fSp > 0.0f) {
            xVar.uj(xVar.sp() - fSp);
            xVar.a(xVar.i() + fSp);
            for (com.byazt.aq.x xVar5 : xVar.sl()) {
                xVar5.uj(xVar5.sp() + fSp);
            }
        }
    }

    @Override // com.byazt.xl.uj
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public DynamicRootView sp() {
        return a();
    }

    public void tt() {
        c(sp());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void c(View view) {
        if (view == 0) {
            return;
        }
        if (view instanceof ViewGroup) {
            int i = 0;
            while (true) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (i >= viewGroup.getChildCount()) {
                    break;
                }
                c(viewGroup.getChildAt(i));
                i++;
            }
        }
        if (view instanceof com.byazt.tm.n) {
            ((com.byazt.tm.n) view).tt();
        }
    }

    @Override // com.byazt.xl.uj
    public int ve() {
        return this.tt instanceof com.byazt.du.sp ? 3 : 2;
    }

    public void uj() {
        this.c.c();
    }

    public void n() {
        this.c.tt();
    }

    public void c(boolean z) {
        this.c.setSoundMute(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ve(com.byazt.aq.x xVar) {
        if (xVar == null) {
            this.c.c(this.tt instanceof com.byazt.du.sp ? AppTypeIdUtil.NewDevice4GBathOTA : 113, "layoutUnit is null");
            return;
        }
        this.f2484a.sp().uj(ve());
        try {
            this.c.c(xVar, ve());
        } catch (Exception e) {
            this.c.c(this.tt instanceof com.byazt.du.sp ? 128 : 118, "exception is " + e.getMessage());
        }
    }

    private boolean i() {
        DynamicRootView dynamicRootView = this.c;
        return (dynamicRootView == null || dynamicRootView.getChildCount() == 0) ? false : true;
    }

    @Override // com.byazt.xl.sl
    public void c(yp ypVar) {
        if (this.x.get()) {
            return;
        }
        this.x.set(true);
        if (ypVar.ve() && i()) {
            this.c.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.uj.c(sp(), ypVar);
            return;
        }
        this.uj.c(ypVar.sl(), ypVar.da());
    }

    @Override // com.byazt.xl.sl
    public void c(View view, int i, ve veVar, int i2) {
        x xVar = this.n;
        if (xVar != null) {
            xVar.c(view, i, veVar, i2);
        }
    }

    @Override // com.byazt.xl.sl
    public void tt(View view, int i, ve veVar, int i2) {
        x xVar = this.n;
        if (xVar != null) {
            xVar.tt(view, i, veVar, i2);
        }
    }

    /* JADX INFO: renamed from: com.byazt.mt.c$c, reason: collision with other inner class name */
    @com.byazt.zqa.c(c = {0, 1, 684, 44})
    private class RunnableC0215c implements Runnable {
        public int tt;

        public RunnableC0215c(int i) {
            this.tt = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.tt == 2) {
                c.this.c.c(c.this.tt instanceof com.byazt.du.sp ? 127 : AppTypeIdUtil.Drink4GCostControl_1, (String) null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void da() {
        try {
            ScheduledFuture<?> scheduledFuture = this.sp;
            if (scheduledFuture == null || scheduledFuture.isCancelled()) {
                return;
            }
            this.sp.cancel(false);
            this.sp = null;
        } catch (Throwable th) {
            m.c(th);
        }
    }
}
