package com.byazt.ouz;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.byazt.aas.nb;
import com.byazt.aas.pf;
import com.byazt.ete.ic;
import com.byazt.ete.xd;
import com.byazt.un.NativeVideoTsView;
import java.util.HashSet;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 27, 1208})
public class NativeExpressVideoView extends NativeExpressView implements com.byazt.dh.ve.uj, com.byazt.dh.ve.InterfaceC0133ve, sl {
    public int c;
    public long gr;
    public com.byazt.ua.c gu;
    public boolean n;
    public HashSet<String> p;
    public boolean tt;
    public int uj;
    public boolean ve;
    public com.byazt.xl.uj yv;
    public long zm;

    @Override // com.byazt.ouz.NativeExpressView, com.byazt.ouz.sl
    public long c() {
        return this.gr;
    }

    @Override // com.byazt.ouz.NativeExpressView, com.byazt.ouz.sl
    public void c(float f) {
    }

    @Override // com.byazt.ouz.NativeExpressView, com.byazt.ouz.sl
    public void c(float f, float f2, float f3, float f4, int i) {
    }

    @Override // com.byazt.ouz.NativeExpressView, com.byazt.ouz.sl
    public void da() {
    }

    public com.byazt.ua.c getVideoModel() {
        return this.gu;
    }

    @Override // com.byazt.ouz.NativeExpressView, com.byazt.ouz.sl
    public void n(int i) {
    }

    @Override // com.byazt.ouz.NativeExpressView, com.byazt.ouz.sl
    public void setPauseFromExpressView(boolean z) {
    }

    @Override // com.byazt.ouz.NativeExpressView, com.byazt.ouz.sl
    public void uj(int i) {
    }

    @Override // com.byazt.ouz.NativeExpressView, com.byazt.ouz.sl
    public void ve(int i) {
    }

    @Override // com.byazt.ouz.NativeExpressView, com.byazt.ouz.sl
    public void x() {
    }

    public NativeExpressVideoView(Context context, ic icVar, com.byazt.dj.tt ttVar, String str) {
        super(context, icVar, ttVar, str, true);
        this.c = 1;
        this.tt = false;
        this.ve = true;
        this.n = true;
        this.gt = this.i.ab() == 1;
        u();
    }

    public NativeExpressVideoView(boolean z, Context context, ic icVar, com.byazt.dj.tt ttVar, String str) {
        super(z, context, icVar, ttVar, str, true);
        this.c = 1;
        this.tt = false;
        this.ve = true;
        this.n = true;
        this.gt = this.i.ab() == 1;
        u();
    }

    public void u() {
        this.yp = new FrameLayout(this.f2599a);
        this.uj = nb.t(this.i);
        this.p = new HashSet<>();
        a(this.uj);
        gu();
    }

    public ExpressVideoView c(Context context, ic icVar, String str) {
        return new ExpressVideoView(context, icVar, str, false);
    }

    private void gu() {
        ExpressVideoView expressVideoView;
        try {
            this.gu = new com.byazt.ua.c();
            this.sl = c(this.f2599a, this.i, this.sp);
            this.sl.setNativeExpressVideoView(this);
            this.sl.setAdCreativeClickListener(new NativeVideoTsView.c() { // from class: com.byazt.ouz.NativeExpressVideoView.1
                @Override // com.byazt.un.NativeVideoTsView.c
                public void c(View view, int i) {
                    c expressInteractionListener = NativeExpressVideoView.this.getExpressInteractionListener();
                    if (expressInteractionListener == null) {
                        return;
                    }
                    expressInteractionListener.c(view, i);
                }
            });
            boolean z = false;
            this.sl.setShouldCheckNetChange(false);
            this.sl.setControllerStatusCallBack(new NativeVideoTsView.uj() { // from class: com.byazt.ouz.NativeExpressVideoView.2
                @Override // com.byazt.un.NativeVideoTsView.uj
                public void c(boolean z2, long j, long j2, long j3, boolean z3, boolean z4) {
                    NativeExpressVideoView.this.gu.c = z2;
                    NativeExpressVideoView.this.gu.n = j;
                    NativeExpressVideoView.this.gu.f2766a = j2;
                    NativeExpressVideoView.this.gu.sp = j3;
                    NativeExpressVideoView.this.gu.uj = z3;
                    NativeExpressVideoView.this.gu.x = z4;
                }
            });
            this.sl.setVideoAdLoadListener(this);
            this.sl.setVideoAdInteractionListener(this);
            if (com.byazt.dyf.tt.AD_TAG_FEED.equals(this.sp)) {
                this.sl.setIsAutoPlay(this.tt ? this.x.n() : this.ve);
            } else if ("splash_ad".equals(this.sp)) {
                this.sl.setIsAutoPlay(true);
            } else {
                this.sl.setIsAutoPlay(this.ve);
            }
            if ("splash_ad".equals(this.sp)) {
                expressVideoView = this.sl;
            } else {
                expressVideoView = this.sl;
                if (this.i.ab() == 1) {
                }
                expressVideoView.setIsQuiet(z);
                this.sl.ve();
            }
            z = true;
            expressVideoView.setIsQuiet(z);
            this.sl.ve();
        } catch (Exception e) {
            this.sl = null;
            com.byazt.nr.m.uj("NativeExpressVideoView", "（dev ignore）ExpressVideoView-->print:" + e.toString());
        }
    }

    public void a(int i) {
        int iA = com.byazt.omf.gt.tt().a(i);
        if (3 == iA) {
            this.tt = false;
            this.ve = false;
        } else if (1 == iA) {
            this.tt = false;
            this.ve = com.byazt.nr.rh.uj(this.f2599a);
        } else if (2 == iA) {
            if (com.byazt.nr.rh.n(this.f2599a) || com.byazt.nr.rh.uj(this.f2599a) || com.byazt.nr.rh.a(this.f2599a)) {
                this.tt = false;
                this.ve = true;
            }
        } else if (5 == iA) {
            if (com.byazt.nr.rh.uj(this.f2599a) || com.byazt.nr.rh.a(this.f2599a)) {
                this.tt = false;
                this.ve = true;
            }
        } else if (4 == iA) {
            this.tt = true;
        }
        if (!this.ve) {
            this.c = 3;
        }
        com.byazt.nr.m.c("NativeVideoAdView", "mIsAutoPlay=" + this.ve + ",status=" + iA);
    }

    public void setCanInterruptVideoPlay(boolean z) {
        if (this.sl != null) {
            this.sl.setCanInterruptVideoPlay(z);
        }
    }

    private void setShowAdInteractionView(boolean z) {
        if (this.sl != null) {
            this.sl.setShowAdInteractionView(z);
        }
    }

    @Override // com.byazt.ouz.NativeExpressView
    public void tt(com.byazt.xl.uj<? extends View> ujVar, com.byazt.xl.yp ypVar) {
        this.yv = ujVar;
        if ((ujVar instanceof z) && ((z) ujVar).J_() != null) {
            ((z) this.yv).J_().c((sl) this);
        }
        if (ypVar != null && ypVar.ve()) {
            if ((ypVar.tt() == 2 || ypVar.tt() == 7) && this.sl != null) {
                this.sl.c(this.f2599a, 25, xd.tt(this.i));
            }
            c(ypVar);
        }
        com.byazt.xl.uj ujVar2 = this.yv;
        if (ujVar2 != null && (ujVar2 instanceof com.byazt.mt.c)) {
            ((com.byazt.mt.c) ujVar2).c(this.i.ab() == 1);
        }
        super.tt(ujVar, ypVar);
    }

    private void c(final com.byazt.xl.yp ypVar) {
        if (ypVar == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            tt(ypVar);
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.byazt.ouz.NativeExpressVideoView.3
                @Override // java.lang.Runnable
                public void run() {
                    NativeExpressVideoView.this.tt(ypVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tt(com.byazt.xl.yp ypVar) {
        if (ypVar == null) {
            return;
        }
        double dA = ypVar.a();
        double dSp = ypVar.sp();
        double dX = ypVar.x();
        double dI = ypVar.i();
        int iVe = pf.ve(this.f2599a, (float) dA);
        int iVe2 = pf.ve(this.f2599a, (float) dSp);
        int iVe3 = pf.ve(this.f2599a, (float) dX);
        int iVe4 = pf.ve(this.f2599a, (float) dI);
        float fVe = ypVar.t() > 0.0f ? pf.ve(this.f2599a, ypVar.t()) : 0.0f;
        float fVe2 = ypVar.u() > 0.0f ? pf.ve(this.f2599a, ypVar.u()) : 0.0f;
        float fVe3 = ypVar.yp() > 0.0f ? pf.ve(this.f2599a, ypVar.yp()) : 0.0f;
        float fVe4 = ypVar.z() > 0.0f ? pf.ve(this.f2599a, ypVar.z()) : 0.0f;
        if (fVe2 < fVe) {
            fVe = fVe2;
        }
        if (fVe3 >= fVe) {
            fVe3 = fVe;
        }
        if (fVe4 >= fVe3) {
            fVe4 = fVe3;
        }
        if (ypVar.tt() != 2) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.yp.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(iVe3, iVe4);
            }
            layoutParams.width = iVe3;
            layoutParams.height = iVe4;
            layoutParams.topMargin = iVe2;
            layoutParams.leftMargin = iVe;
            this.yp.setLayoutParams(layoutParams);
        }
        pf.tt(this.yp, fVe4);
        this.yp.removeAllViews();
        if (this.sl != null) {
            this.yp.addView(this.sl);
            this.sl.c(0L, true, false);
            a(this.uj);
            if (!com.byazt.nr.rh.uj(this.f2599a) && !this.ve && this.n) {
                this.sl.F_();
            }
            setShowAdInteractionView(false);
        }
        ViewGroup viewGroup = (ViewGroup) this.yp.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(this.yp);
        }
        if (ypVar instanceof com.byazt.atv.ve) {
            FrameLayout frameLayoutM = ((com.byazt.atv.ve) ypVar).m();
            if (frameLayoutM != null) {
                if (this.sl != null) {
                    this.sl.setClickable(false);
                }
                frameLayoutM.addView(this.yp, new FrameLayout.LayoutParams(-1, -1));
                return;
            }
            return;
        }
        if (ypVar.tt() == 2) {
            View viewC = ypVar.c();
            if (viewC instanceof ViewGroup) {
                if (this.sl != null) {
                    this.sl.setClickable(false);
                }
                ((ViewGroup) viewC).addView(this.yp);
                return;
            }
            return;
        }
        this.rl.addView(this.yp);
    }

    @Override // com.byazt.ouz.NativeExpressView, com.byazt.ouz.sl
    public void c(boolean z) {
        super.c(z);
        this.gt = z;
        this.sl.tt(z, true);
        if (this.sl != null && this.sl.getNativeVideoController() != null) {
            this.sl.getNativeVideoController().tt(z);
        }
        com.byazt.xl.uj ujVar = this.yv;
        if (ujVar == null || !(ujVar instanceof com.byazt.mt.c)) {
            return;
        }
        ((com.byazt.mt.c) ujVar).c(z);
    }

    @Override // com.byazt.ouz.NativeExpressView, com.byazt.ouz.sl
    public void a() {
        super.a();
    }

    @Override // com.byazt.ouz.NativeExpressView, com.byazt.ouz.sl
    public void sp() {
        super.sp();
    }

    @Override // com.byazt.ouz.NativeExpressView, com.byazt.ouz.sl
    public void c(int i) {
        if (this.sl == null) {
            com.byazt.nr.m.uj("NativeExpressVideoView", "onChangeVideoState,ExpressVideoView is null !!!!!!!!!!!!");
            return;
        }
        if (i == 1) {
            this.sl.c(0L, true, false);
            return;
        }
        if (i == 2 || i == 3) {
            this.sl.setVideoPlayStatus(i);
            this.sl.setCanInterruptVideoPlay(true);
            this.sl.performClick();
        } else if (i == 4) {
            this.sl.getNativeVideoController().da();
        } else {
            if (i != 5) {
                return;
            }
            this.sl.c(0L, true, false);
        }
    }

    @Override // com.byazt.ouz.NativeExpressView, com.byazt.xl.x
    public void c(View view, int i, com.byazt.sr.ve veVar, int i2) {
        if (i == -1 || veVar == null) {
            return;
        }
        if (i == 4) {
            gr();
        } else if (i == 5) {
            c(!this.gt);
        } else {
            super.c(view, i, veVar, i2);
        }
    }

    private void gr() {
        com.byazt.xl.uj ujVar = this.yv;
        if (((ujVar instanceof com.byazt.mt.c) || (ujVar instanceof com.byazt.atv.n)) && this.sl != null) {
            this.sl.tt(true);
            if (this.sl.G_()) {
                this.sl.setPauseIcon(true);
                this.sl.setVideoPlayStatus(2);
            } else {
                this.sl.setVideoPlayStatus(3);
                this.sl.setPauseIcon(false);
            }
            this.sl.performClick();
            this.sl.a();
        }
    }

    @Override // com.byazt.ouz.NativeExpressView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        int i;
        super.onAttachedToWindow();
        com.byazt.xl.uj ujVar = this.yv;
        if ((!(ujVar instanceof com.byazt.mt.c) && !(ujVar instanceof com.byazt.atv.n)) || this.sl == null || (i = this.c) == 2 || i == 5) {
            return;
        }
        this.sl.setNeedNativeVideoPlayBtnVisible(true);
        this.sl.F_();
        this.sl.E_();
    }

    @Override // com.byazt.ouz.NativeExpressView, android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        com.byazt.xl.uj ujVar = this.yv;
        if (((ujVar instanceof com.byazt.mt.c) || (ujVar instanceof com.byazt.atv.n)) && this.sl != null && z && this.sl.tt != null && this.sl.tt.getVisibility() == 0) {
            this.sl.tt.setVisibility(8);
        }
    }

    @Override // com.byazt.ouz.NativeExpressView, com.byazt.xl.x
    public void tt(View view, int i, com.byazt.sr.ve veVar, int i2) {
        if (i == -1 || veVar == null) {
            return;
        }
        if (i != 4) {
            if (i != 5) {
                super.tt(view, i, veVar, i2);
                return;
            }
        } else if (this.sp == "draw_ad") {
            if (this.sl != null) {
                this.sl.performClick();
                return;
            }
            return;
        }
        c(!this.gt);
    }

    @Override // com.byazt.ouz.NativeExpressView, com.byazt.ouz.sl
    public int tt() {
        if (this.c == 3 && this.sl != null) {
            this.sl.ve();
        }
        if (this.sl == null || !this.sl.getNativeVideoController().qy()) {
            return this.c;
        }
        return 1;
    }

    @Override // com.byazt.ouz.NativeExpressView, com.byazt.ouz.sl
    public void i() {
        super.i();
    }

    @Override // com.byazt.dh.ve.InterfaceC0133ve
    public void onVideoAdStartPlay() {
        this.n = false;
        if (this.u != null) {
            this.u.onVideoAdStartPlay();
        }
        this.c = 2;
    }

    @Override // com.byazt.dh.ve.InterfaceC0133ve
    public void onVideoAdPaused() {
        this.n = false;
        if (this.u != null) {
            this.u.onVideoAdPaused();
        }
        this.z = true;
        this.c = 3;
    }

    @Override // com.byazt.dh.ve.InterfaceC0133ve
    public void onVideoAdContinuePlay() {
        this.n = false;
        if (this.u != null) {
            this.u.onVideoAdContinuePlay();
        }
        this.z = false;
        this.c = 2;
    }

    @Override // com.byazt.dh.ve.InterfaceC0133ve
    public void onProgressUpdate(long j, long j2) {
        this.n = false;
        if (this.u != null) {
            this.u.onProgressUpdate(j, j2);
        }
        if (c(j)) {
            this.c = 2;
        }
        this.gr = j;
        this.zm = j2;
        if (!this.p.isEmpty()) {
            com.byazt.dh.ve videoController = this.sl.getVideoController();
            if (videoController instanceof com.byazt.un.uj) {
                ((com.byazt.un.uj) videoController).ve(50);
            }
        }
        com.byazt.ua.c cVar = this.gu;
        if (cVar != null) {
            cVar.sp = j;
        }
        com.byazt.xl.uj ujVar = this.yv;
        if (ujVar instanceof com.byazt.atv.n) {
            ((com.byazt.atv.n) ujVar).c(j, j2);
        }
    }

    @Override // com.byazt.dh.ve.InterfaceC0133ve
    public void onVideoComplete() {
        this.n = false;
        com.byazt.xl.uj ujVar = this.yv;
        if (ujVar != null) {
            if (ujVar instanceof com.byazt.mt.c) {
                ((com.byazt.mt.c) ujVar).uj();
            }
            com.byazt.xl.uj ujVar2 = this.yv;
            if (ujVar2 instanceof com.byazt.atv.n) {
                ((com.byazt.atv.n) ujVar2).u();
            }
        }
        if (this.u != null) {
            this.u.onVideoComplete();
        }
        this.c = 5;
        com.byazt.ua.c cVar = this.gu;
        if (cVar != null) {
            cVar.c = true;
        }
    }

    @Override // com.byazt.dh.ve.uj
    public void onVideoLoad() {
        if (this.t != null) {
            this.t.onVideoLoad();
        }
        com.byazt.xl.uj ujVar = this.yv;
        if (ujVar != null) {
            if (ujVar instanceof com.byazt.mt.c) {
                ((com.byazt.mt.c) ujVar).n();
            }
            com.byazt.xl.uj ujVar2 = this.yv;
            if (ujVar2 instanceof com.byazt.atv.n) {
                ((com.byazt.atv.n) ujVar2).yp();
            }
        }
    }

    @Override // com.byazt.dh.ve.uj
    public void onVideoError(int i, int i2) {
        if (this.t != null) {
            this.t.onVideoError(i, i2);
        }
        this.gr = this.zm;
        this.c = 4;
    }

    @Override // com.byazt.ouz.NativeExpressView, com.byazt.ouz.sl
    public void c(final int i, final String str) {
        super.c(i, str);
        com.byazt.dh.ve videoController = this.sl.getVideoController();
        if (videoController instanceof com.byazt.un.uj) {
            com.byazt.un.uj ujVar = (com.byazt.un.uj) videoController;
            ujVar.ve(50);
            ujVar.c(new com.byazt.nj.c.InterfaceC0219c() { // from class: com.byazt.ouz.NativeExpressVideoView.4
                @Override // com.byazt.nj.c.InterfaceC0219c
                public void c(long j, long j2) {
                    int iAbs = (int) Math.abs(((long) i) - j);
                    int i2 = i;
                    if (i2 < 0 || iAbs > 50 || i2 > j2 || iAbs >= 50 || NativeExpressVideoView.this.p.contains(str)) {
                        return;
                    }
                    if (i > j) {
                        NativeExpressVideoView.this.postDelayed(new Runnable() { // from class: com.byazt.ouz.NativeExpressVideoView.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                NativeExpressVideoView.this.sl.setVideoPlayStatus(2);
                                NativeExpressVideoView.this.sl.setCanInterruptVideoPlay(true);
                                NativeExpressVideoView.this.sl.performClick();
                                NativeExpressVideoView.this.tt(i, str);
                            }
                        }, iAbs);
                    } else {
                        NativeExpressVideoView.this.sl.setVideoPlayStatus(2);
                        NativeExpressVideoView.this.sl.setCanInterruptVideoPlay(true);
                        NativeExpressVideoView.this.sl.performClick();
                        NativeExpressVideoView.this.tt(i, str);
                    }
                    NativeExpressVideoView.this.p.add(str);
                }
            });
        }
    }

    private boolean c(long j) {
        int i = this.c;
        if (i == 5 || i == 3 || j <= this.gr) {
            return this.sl != null && this.sl.G_();
        }
        return true;
    }

    @Override // com.byazt.ouz.NativeExpressView
    public com.byazt.dh.ve getVideoController() {
        if (this.sl != null) {
            return this.sl.getVideoController();
        }
        return null;
    }

    public void yp() {
        this.sl.sl();
    }

    @Override // com.byazt.ouz.NativeExpressView
    public void t() {
        super.t();
        if (this.sl != null) {
            this.sl.gt();
        }
    }
}
