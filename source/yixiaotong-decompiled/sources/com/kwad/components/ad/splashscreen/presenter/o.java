package com.kwad.components.ad.splashscreen.presenter;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.os.SystemClock;
import android.os.Vibrator;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import com.kwad.components.ad.splashscreen.widget.KsShakeView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.helper.SlideConvertHelper;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.by;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class o extends i implements View.OnClickListener, com.kwad.components.ad.splashscreen.g, com.kwad.sdk.core.g.b, com.kwad.sdk.widget.d {
    private boolean Hs;
    private TextView ID;
    private KsShakeView IG;
    private ViewGroup IM;
    private com.kwad.components.ad.splashscreen.d Ij;
    private com.kwad.sdk.core.g.d hu;
    private Vibrator hw;
    private long mStartTime;

    @Override // com.kwad.components.ad.splashscreen.g
    public final void aw(int i) {
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    protected final void initView() {
        this.mStartTime = SystemClock.elapsedRealtime();
        getRootView().post(new bi() { // from class: com.kwad.components.ad.splashscreen.presenter.o.1
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                o.this.HC.He = SystemClock.elapsedRealtime() - o.this.mStartTime;
            }
        });
        Context context = getContext();
        if (context != null) {
            this.hw = (Vibrator) context.getSystemService("vibrator");
        }
        ViewStub viewStub = (ViewStub) findViewById(R.id.ksad_shake_layout);
        if (viewStub != null) {
            this.IM = (ViewGroup) viewStub.inflate();
        } else {
            this.IM = (ViewGroup) findViewById(R.id.ksad_shake_root);
        }
        this.ID = (TextView) this.IM.findViewById(R.id.ksad_shake_action);
        KsShakeView ksShakeView = (KsShakeView) this.IM.findViewById(R.id.ksad_shake_view);
        this.IG = ksShakeView;
        ksShakeView.setOnClickListener(this);
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    protected final void mJ() {
        this.Ij = com.kwad.components.ad.splashscreen.d.a(this.HC.mAdTemplate, com.kwad.sdk.core.response.helper.e.eO(this.HC.mAdTemplate), this.HC.mApkDownloadHelper, 2);
        this.Hs = com.kwad.sdk.core.response.helper.d.eD(this.HC.mAdTemplate);
        new com.kwad.sdk.widget.h(this.IG.getContext(), this.IG, this);
        this.HC.a(this);
        TextView textView = this.ID;
        if (textView != null) {
            textView.setText(this.Ij.lW());
        }
        KsShakeView ksShakeView = this.IG;
        if (ksShakeView != null) {
            ksShakeView.aC(this.Ij.lX());
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    protected final void mK() {
        if (this.IM == null || this.HC == null) {
            return;
        }
        this.IM.setVisibility(0);
        com.kwad.sdk.core.adlog.c.b(this.HC.mAdTemplate, 185, (JSONObject) null);
        com.kwad.components.core.webview.tachikoma.e.a.zA().cl(185);
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    protected final void mL() {
        float fDK = com.kwad.sdk.core.response.helper.b.dK(this.HC.mAdTemplate);
        boolean zDZ = com.kwad.sdk.core.response.helper.b.dZ(com.kwad.sdk.core.response.helper.e.eO(this.HC.mAdTemplate));
        boolean zEa = com.kwad.sdk.core.response.helper.b.ea(com.kwad.sdk.core.response.helper.e.eO(this.HC.mAdTemplate));
        com.kwad.sdk.core.g.d dVar = this.hu;
        if (dVar == null) {
            com.kwad.sdk.core.g.d dVar2 = new com.kwad.sdk.core.g.d(zDZ, fDK);
            this.hu = dVar2;
            dVar2.bG(zEa);
            this.hu.a(this);
            return;
        }
        dVar.m(fDK);
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    protected final void mM() {
        com.kwad.sdk.core.g.d dVar = this.hu;
        if (dVar != null) {
            dVar.cb(getContext());
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    protected final void mN() {
        com.kwad.sdk.core.g.d dVar = this.hu;
        if (dVar != null) {
            dVar.cc(getContext());
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    protected final void fY() {
        this.IG.post(new bi() { // from class: com.kwad.components.ad.splashscreen.presenter.o.2
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                o.this.IG.od();
            }
        });
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    protected final void j(int i, String str) {
        TextView textView = this.ID;
        if (textView != null) {
            if (i == 2) {
                textView.setText(str);
            } else {
                textView.setText("或点击" + str);
            }
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.sdk.core.d.c.d("SplashShakePresenter", "onUnbind");
        if (this.HC != null) {
            this.HC.b(this);
        }
        KsShakeView ksShakeView = this.IG;
        if (ksShakeView != null) {
            ksShakeView.oe();
        }
    }

    @Override // com.kwad.sdk.core.g.b
    public final void a(final double d) {
        boolean zPG = com.kwad.components.core.e.c.b.pG();
        if (!this.HC.GP.Ae() || zPG) {
            return;
        }
        this.IG.b(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.splashscreen.presenter.o.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (o.this.HC != null) {
                    o.this.HC.a(1, o.this.getContext(), 157, 1, new com.kwad.components.ad.splashscreen.h.a() { // from class: com.kwad.components.ad.splashscreen.presenter.o.3.1
                        @Override // com.kwad.components.ad.splashscreen.h.a
                        public final void b(com.kwad.sdk.core.adlog.c.b bVar) {
                            bVar.j(d);
                        }
                    });
                }
                o.this.IG.od();
            }
        });
        by.a(getContext(), this.hw);
        mN();
    }

    @Override // com.kwad.sdk.core.g.b
    public final void cj() {
        com.kwad.sdk.core.adlog.c.cw(this.HC.mAdTemplate);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        com.kwad.sdk.core.d.c.d("SplashShakePresenter", "onClick: " + view);
        if (!view.equals(this.IG) || this.HC == null || this.HC.mAdTemplate == null || !com.kwad.sdk.core.response.helper.b.es(com.kwad.sdk.core.response.helper.e.eO(this.HC.mAdTemplate))) {
            return;
        }
        this.HC.c(1, getContext(), 158, 1);
    }

    @Override // com.kwad.sdk.widget.d
    public final void a(View view) {
        com.kwad.sdk.core.d.c.d("SplashShakePresenter", "onSingleTap: " + view);
        if (com.kwad.sdk.core.response.helper.b.es(com.kwad.sdk.core.response.helper.e.eO(this.HC.mAdTemplate)) && this.HC != null) {
            this.HC.c(1, getContext(), 158, 1);
        }
    }

    @Override // com.kwad.sdk.widget.d
    public final void a(View view, float f, float f2, float f3, float f4) {
        com.kwad.sdk.core.d.c.d("SplashShakePresenter", "onSlide: enableSlickClick: " + this.Hs);
        if (SlideConvertHelper.a(this.HC.mAdTemplate, f, f2, f3, f4) && this.HC != null) {
            this.HC.c(1, view.getContext(), 153, 1);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.g
    public final void mc() {
        com.kwad.sdk.core.g.d dVar = this.hu;
        if (dVar != null) {
            dVar.cc(getContext());
        }
    }
}
