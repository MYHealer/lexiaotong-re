package com.kwad.components.ad.splashscreen.presenter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import client.android.yixiaotong.v3.comman.AppTypeIdUtil;
import com.kwad.components.ad.splashscreen.local.SplashSkipViewModel;
import com.kwad.components.ad.splashscreen.widget.SkipView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.br;
import com.kwad.sdk.utils.by;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class c extends e implements com.kwad.sdk.core.j.c {
    private TextView Hu;
    private com.kwad.components.ad.splashscreen.widget.b Hv;
    private AdInfo.AdPreloadInfo Hw;
    private boolean Hx = false;
    private View Hy;
    private AdInfo wx;

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        com.kwad.sdk.core.d.c.d("SkipAdPresenter", "onBind");
        AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(this.HC.mAdTemplate);
        this.wx = adInfoEO;
        u(adInfoEO);
        w(this.wx);
        if (v(this.wx)) {
            this.Hv = (com.kwad.components.ad.splashscreen.widget.b) findViewById(com.kwad.components.ad.splashscreen.e.c.A(this.wx) ? R.id.ksad_splash_skip_right_view : R.id.ksad_splash_skip_left_view);
        } else {
            this.Hv = (com.kwad.components.ad.splashscreen.widget.b) findViewById(com.kwad.components.ad.splashscreen.e.c.A(this.wx) ? R.id.ksad_splash_circle_skip_right_view : R.id.ksad_splash_circle_skip_left_view);
        }
        this.Hv.a(mw(), this.wx);
        this.Hv.setOnViewListener(new SkipView.a() { // from class: com.kwad.components.ad.splashscreen.presenter.c.1
            @Override // com.kwad.components.ad.splashscreen.widget.SkipView.a
            public final void mA() {
                c.this.mx();
            }

            @Override // com.kwad.components.ad.splashscreen.widget.SkipView.a
            public final void mB() {
                c.this.my();
            }

            @Override // com.kwad.components.ad.splashscreen.widget.SkipView.a
            public final void ay(int i) {
                c.this.HC.ax(i);
            }
        });
        x(this.wx);
        this.HC.GP.a(this);
    }

    private void u(AdInfo adInfo) {
        findViewById(com.kwad.components.ad.splashscreen.e.c.A(adInfo) ? R.id.ksad_splash_right_top_root : R.id.ksad_splash_left_top_root).setVisibility(0);
    }

    private SplashSkipViewModel mw() {
        SplashSkipViewModel splashSkipViewModel = new SplashSkipViewModel();
        int i = this.wx.adSplashInfo.imageDisplaySecond <= 0 ? 5 : this.wx.adSplashInfo.imageDisplaySecond;
        int iMin = Math.min(this.wx.adSplashInfo.videoDisplaySecond, com.kwad.sdk.core.response.helper.a.N(this.wx));
        if (com.kwad.sdk.core.response.helper.a.bi(this.wx)) {
            i = iMin;
        }
        splashSkipViewModel.skipSecond = i;
        return splashSkipViewModel;
    }

    private static boolean v(AdInfo adInfo) {
        return !com.kwad.sdk.core.response.helper.a.cI(adInfo);
    }

    private void w(AdInfo adInfo) {
        int i;
        if (com.kwad.components.ad.splashscreen.e.c.A(adInfo)) {
            i = R.id.ksad_splash_preload_right_tips;
        } else {
            i = R.id.ksad_splash_preload_left_tips;
        }
        this.Hu = (TextView) findViewById(i);
        AdInfo.AdPreloadInfo adPreloadInfo = adInfo.adPreloadInfo;
        this.Hw = adPreloadInfo;
        if (adPreloadInfo != null && !br.isNullString(adPreloadInfo.preloadTips)) {
            this.Hu.setVisibility(0);
            this.Hu.setText(this.Hw.preloadTips);
        } else {
            this.Hu.setVisibility(8);
        }
    }

    private void x(AdInfo adInfo) {
        this.Hy = findViewById(R.id.ksad_skip_view_area);
        if (com.kwad.sdk.core.response.helper.a.cJ(adInfo) && adInfo.adSplashInfo.skipButtonPosition == 0) {
            this.Hy.setVisibility(0);
            this.Hy.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.splashscreen.presenter.c.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    c.this.mx();
                }
            });
            this.Hy.post(new bi() { // from class: com.kwad.components.ad.splashscreen.presenter.c.3
                @Override // com.kwad.sdk.utils.bi
                public final void doTask() {
                    ((View) c.this.Hv).post(new bi() { // from class: com.kwad.components.ad.splashscreen.presenter.c.3.1
                        @Override // com.kwad.sdk.utils.bi
                        public final void doTask() {
                            int iAA = c.this.Hv.aA(35);
                            ViewGroup.LayoutParams layoutParams = c.this.Hy.getLayoutParams();
                            layoutParams.width = iAA + com.kwad.sdk.c.a.a.a(c.this.HC.mRootContainer.getContext(), 66.0f);
                            c.this.Hy.setLayoutParams(layoutParams);
                        }
                    });
                }
            });
            return;
        }
        this.Hy.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mx() {
        com.kwad.components.ad.splashscreen.monitor.a.mt().ao(this.HC.mAdTemplate);
        this.HC.mo();
        JSONObject jSONObject = new JSONObject();
        if (this.HC.GN != null) {
            try {
                jSONObject.put("duration", this.HC.GN.getCurrentPosition());
            } catch (JSONException e) {
                com.kwad.sdk.core.d.c.printStackTrace(e);
            }
        }
        com.kwad.sdk.core.adlog.a.C0733a c0733a = new com.kwad.sdk.core.adlog.a.C0733a();
        if (this.HC.mTimerHelper != null) {
            c0733a.duration = this.HC.mTimerHelper.getTime();
        }
        com.kwad.sdk.core.adlog.c.b(this.HC.mAdTemplate, new com.kwad.sdk.core.adlog.c.b().ed(1).el(22).b(c0733a), jSONObject);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.HC.GP.b(this);
        by.postOnUiThread(new Runnable() { // from class: com.kwad.components.ad.splashscreen.presenter.c.4
            @Override // java.lang.Runnable
            public final void run() {
                if (c.this.Hv != null) {
                    c.this.Hv.cw();
                }
            }
        });
    }

    @Override // com.kwad.sdk.core.j.c
    public final void bz() {
        com.kwad.sdk.core.d.c.d("SkipAdPresenter", "onPageVisible");
        this.Hv.C(this.wx);
        mz();
    }

    public final void my() {
        this.HC.mRootContainer.post(new bi() { // from class: com.kwad.components.ad.splashscreen.presenter.c.5
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                if (com.kwad.components.core.e.c.b.pG()) {
                    c.this.HC.mRootContainer.postDelayed(this, 1000L);
                } else {
                    c.this.HC.mm();
                }
            }
        });
    }

    private synchronized void mz() {
        if (!this.Hx && this.Hv != null) {
            if (com.kwad.sdk.core.response.helper.a.cK(this.wx) && com.kwad.sdk.core.response.helper.a.cL(this.wx)) {
                com.kwad.sdk.core.adlog.c.b(this.HC.mAdTemplate, AppTypeIdUtil.NewDevice4GDrinkOTA_1, (JSONObject) null);
                this.Hx = true;
            }
        }
    }

    @Override // com.kwad.sdk.core.j.c
    public final void bA() {
        com.kwad.sdk.core.d.c.d("SkipAdPresenter", "onPageInvisible");
        this.Hv.B(this.wx);
    }
}
