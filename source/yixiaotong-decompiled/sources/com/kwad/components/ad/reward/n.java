package com.kwad.components.ad.reward;

import android.content.Context;
import android.os.SystemClock;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.kwad.components.ad.reward.page.BackPressHandleResult;
import com.kwad.components.ad.reward.presenter.r;
import com.kwad.components.ad.reward.presenter.t;
import com.kwad.components.ad.reward.presenter.u;
import com.kwad.components.ad.reward.presenter.v;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdGlobalConfigInfo;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.as;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class n extends com.kwad.components.ad.reward.presenter.b implements com.kwad.components.ad.reward.e.g, com.kwad.components.core.e.e.f {
    private com.kwad.components.core.n.b kj;
    private r kk;
    private FrameLayout kl;
    private com.kwad.components.ad.reward.presenter.f.b km;
    private com.kwad.components.ad.reward.presenter.e.a ko;
    private com.kwad.components.ad.reward.presenter.f.f kp;
    private Context mContext;
    private com.kwad.components.ad.reward.model.c mModel;
    private ViewGroup mRootContainer;
    private g uj;

    /* JADX INFO: renamed from: uk, reason: collision with root package name */
    private a f4752uk;
    private boolean kq = false;
    private com.kwad.components.core.webview.tachikoma.f.g mU = new com.kwad.components.core.webview.tachikoma.f.g() { // from class: com.kwad.components.ad.reward.n.1
        @Override // com.kwad.components.core.webview.tachikoma.f.g
        public final void a(String str, long j, long j2, long j3) {
            try {
                if (n.this.uj.mStartRenderTime > 0) {
                    com.kwad.sdk.commercial.convert.d.b(com.kwad.sdk.core.response.helper.e.eI(n.this.uj.mAdTemplate), 2, SystemClock.elapsedRealtime() - n.this.uj.mStartRenderTime);
                }
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
            n.this.uj.na = true;
        }

        @Override // com.kwad.components.core.webview.tachikoma.f.b
        public final void x(String str) {
            if ("tk_reward".equals(str) || "tk_live_video".equals(str)) {
                n nVar = n.this;
                nVar.a(nVar);
                g.a(n.this.getContext(), n.this.uj, n.this.m980do());
                n.this.uj.a(RewardRenderResult.DEFAULT);
                n nVar2 = n.this;
                nVar2.a(nVar2.kj, n.this.mModel);
                return;
            }
            if ("tk_image_video".equals(str)) {
                n nVar3 = n.this;
                nVar3.a(nVar3);
                n.this.uj.a(RewardRenderResult.DEFAULT);
                n nVar4 = n.this;
                nVar4.a(nVar4.kj, n.this.mModel);
            }
        }
    };

    public interface a {
        void onUnbind();
    }

    public final void a(a aVar) {
        this.f4752uk = aVar;
    }

    @Override // com.kwad.components.ad.reward.e.g
    public final int getPriority() {
        return 0;
    }

    public n(com.kwad.components.core.n.b bVar, Context context, ViewGroup viewGroup, com.kwad.components.ad.reward.model.c cVar, g gVar) {
        boolean z = false;
        this.mContext = context;
        this.mRootContainer = viewGroup;
        this.mModel = cVar;
        this.uj = gVar;
        this.kj = bVar;
        a(cVar);
        AdInfo adInfoDa = cVar.da();
        boolean zEM = com.kwad.sdk.core.response.helper.b.eM(adInfoDa);
        boolean z2 = (com.kwad.sdk.core.response.helper.a.cY(adInfoDa) && a(this.uj.mAdResultData.adGlobalConfigInfo)) || com.kwad.sdk.core.response.helper.a.bj(adInfoDa) || g.T(cVar.getAdTemplate());
        if (com.kwad.sdk.core.response.helper.a.dj(adInfoDa) && a(this.uj.mAdResultData.adGlobalConfigInfo)) {
            z = true;
        }
        com.kwad.sdk.core.d.c.d("RewardPresenter", "notFullTk: " + z2 + ", mLoadStrategy: " + this.uj.tt);
        if (z) {
            com.kwad.components.core.webview.tachikoma.e.c.zG().a(this.mU);
            gVar.a(RewardRenderResult.LIVE_TK);
            dj();
        } else if (zEM) {
            com.kwad.components.core.webview.tachikoma.e.c.zG().a(this.mU);
            gVar.a(RewardRenderResult.TK_IMAGE);
            dk();
        } else if (!z2 && this.uj.tt.equals(LoadStrategy.FULL_TK)) {
            com.kwad.components.core.webview.tachikoma.e.c.zG().a(this.mU);
            gVar.a(RewardRenderResult.NEO_TK);
            hI();
        } else {
            gVar.a(RewardRenderResult.DEFAULT);
            a(bVar, cVar);
        }
    }

    private static boolean a(AdGlobalConfigInfo adGlobalConfigInfo) {
        return adGlobalConfigInfo == null || adGlobalConfigInfo.neoPageType != 1;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.kl = (FrameLayout) this.mRootContainer.findViewById(R.id.ksad_reward_play_layout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: do, reason: not valid java name */
    public FrameLayout m980do() {
        if (this.kl == null) {
            this.kl = (FrameLayout) this.mRootContainer.findViewById(R.id.ksad_reward_play_layout);
        }
        return this.kl;
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.uj.b(this);
        com.kwad.components.ad.reward.c.a.ih().setCallerContext(this.uj);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.uj.c(this);
        a aVar = this.f4752uk;
        if (aVar != null) {
            aVar.onUnbind();
        }
        com.kwad.components.core.e.e.g.qK().b(this);
        com.kwad.components.ad.reward.c.a.ih().reset();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
        this.kj = null;
        com.kwad.components.core.webview.tachikoma.e.c.zG().b(this.mU);
    }

    private void hI() {
        com.kwad.components.ad.reward.presenter.f.f fVar = new com.kwad.components.ad.reward.presenter.f.f();
        this.kp = fVar;
        a(fVar);
    }

    private void dk() {
        com.kwad.components.ad.reward.presenter.f.c cVar = new com.kwad.components.ad.reward.presenter.f.c();
        this.kp = cVar;
        a(cVar);
    }

    private void dj() {
        com.kwad.components.ad.reward.presenter.f.b bVar = new com.kwad.components.ad.reward.presenter.f.b();
        this.km = bVar;
        a(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(n nVar) {
        if (this.kq) {
            return;
        }
        nVar.a((Presenter) new com.kwad.components.ad.reward.presenter.a(this.uj), true);
        this.kq = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.kwad.components.core.n.b bVar, com.kwad.components.ad.reward.model.c cVar) {
        if (this.mModel == null) {
            return;
        }
        com.kwad.components.core.e.e.g.qK().a(this);
        AdInfo adInfoDa = this.mModel.da();
        AdTemplate adTemplate = this.mModel.getAdTemplate();
        if (cVar.jM) {
            a(this);
        }
        a(new v(), true);
        if (com.kwad.sdk.core.response.helper.a.aV(adInfoDa)) {
            a(new com.kwad.components.ad.reward.presenter.d(), true);
        }
        a(new com.kwad.components.ad.reward.presenter.m(), true);
        a(new com.kwad.components.ad.reward.presenter.h(), true);
        a(new com.kwad.components.ad.reward.presenter.platdetail.c(), true);
        a(new com.kwad.components.ad.reward.presenter.platdetail.a.e(), true);
        boolean zIF = cVar.iF();
        boolean zIG = cVar.iG();
        boolean z = cVar.db() && !as.isOrientationPortrait();
        if (!zIF && !zIG && !z) {
            a(new com.kwad.components.ad.reward.presenter.platdetail.actionbar.c(), true);
        }
        a(new com.kwad.components.ad.reward.presenter.n(), true);
        a(new com.kwad.components.ad.reward.presenter.c(adInfoDa), true);
        a(new com.kwad.components.ad.reward.presenter.d.b(adTemplate, true), true);
        a(new com.kwad.components.ad.reward.presenter.c.a(), true);
        a(new u(), true);
        a(new com.kwad.components.ad.reward.presenter.e(adInfoDa, this.mRootContainer), true);
        r rVar = new r(adTemplate);
        this.kk = rVar;
        a((Presenter) rVar, true);
        a(new com.kwad.components.ad.reward.presenter.l(), true);
        if (this.uj.sO && com.kwad.components.ad.reward.d.a.b(this.uj.mContext, com.kwad.sdk.core.response.helper.e.eO(adTemplate))) {
            a(new com.kwad.components.ad.reward.presenter.a.a(), true);
        }
        if (com.kwad.sdk.core.response.helper.b.eb(adTemplate)) {
            a(new t(), true);
        }
        if (com.kwad.sdk.core.response.helper.a.bj(adInfoDa)) {
            a(new com.kwad.components.ad.reward.presenter.platdetail.b(), true);
        }
        if (com.kwad.sdk.core.response.helper.a.cY(adInfoDa)) {
            a(new com.kwad.components.ad.reward.presenter.b.c(), true);
            a(new com.kwad.components.ad.reward.presenter.b.a(), true);
            a(new com.kwad.components.ad.reward.presenter.b.b(), true);
            a(new com.kwad.components.ad.reward.presenter.k(), true);
        }
        a(new com.kwad.components.ad.reward.presenter.j(), true);
        try {
            if (this.uj.mStartRenderTime > 0) {
                com.kwad.sdk.commercial.convert.d.b(com.kwad.sdk.core.response.helper.e.eI(this.uj.mAdTemplate), 1, SystemClock.elapsedRealtime() - this.uj.mStartRenderTime);
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private void a(com.kwad.components.ad.reward.model.c cVar) {
        AdInfo adInfoDa = cVar.da();
        if (!cVar.jM) {
            a(this);
        }
        if (g.g(adInfoDa)) {
            a(new com.kwad.components.ad.reward.presenter.g());
        }
        if (com.kwad.sdk.core.response.helper.a.aU(adInfoDa) && as.VM()) {
            a(new com.kwad.components.ad.reward.presenter.h.a());
        }
        if (com.kwad.sdk.core.response.helper.b.dN(adInfoDa)) {
            a(new com.kwad.components.ad.reward.presenter.f.h());
        }
        if (com.kwad.sdk.core.response.helper.b.eJ(adInfoDa) && as.isOrientationPortrait()) {
            com.kwad.components.ad.reward.presenter.e.a aVar = new com.kwad.components.ad.reward.presenter.e.a();
            this.ko = aVar;
            a(aVar);
        }
    }

    public final BackPressHandleResult hJ() {
        r rVar = this.kk;
        if (rVar != null && rVar.onBackPressed()) {
            return BackPressHandleResult.HANDLED;
        }
        com.kwad.components.ad.reward.presenter.e.a aVar = this.ko;
        if (aVar != null && aVar.hJ() == BackPressHandleResult.HANDLED) {
            return BackPressHandleResult.HANDLED;
        }
        com.kwad.components.ad.reward.presenter.f.b bVar = this.km;
        if (bVar != null) {
            return bVar.hJ();
        }
        com.kwad.components.ad.reward.presenter.f.f fVar = this.kp;
        if (fVar != null) {
            return fVar.hJ();
        }
        return BackPressHandleResult.NOT_HANDLED;
    }

    @Override // com.kwad.components.ad.reward.e.g
    public final void dd() {
        this.uj.D(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(com.kwad.components.ad.reward.e.g gVar) {
        return getPriority() - gVar.getPriority();
    }

    @Override // com.kwad.components.core.e.e.f
    public final void show() {
        this.uj.gQ();
        this.uj.E(true);
    }

    @Override // com.kwad.components.core.e.e.f
    public final void dismiss() {
        this.uj.E(false);
        this.uj.gP();
    }
}
