package com.kwad.components.ad.splashscreen.presenter;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.os.SystemClock;
import android.os.Vibrator;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.ad.splashscreen.widget.KsButtonBorderSpreadView;
import com.kwad.components.ad.splashscreen.widget.KsShakeView;
import com.kwad.components.ad.splashscreen.widget.KsSlideArrowView;
import com.kwad.components.ad.splashscreen.widget.KsSlidePopUpView;
import com.kwad.components.ad.splashscreen.widget.KsSplashSlidePathView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.helper.SlideConvertHelper;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.by;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class n extends i implements View.OnClickListener, com.kwad.components.ad.splashscreen.g, com.kwad.sdk.core.g.b {
    private TextView IC;
    private TextView ID;
    private KsSlidePopUpView IE;
    private KsButtonBorderSpreadView IF;
    private KsShakeView IG;
    private View IH;
    private ImageView II;
    private KsSplashSlidePathView Ig;
    private com.kwad.components.ad.splashscreen.d Ij;
    private KsSlideArrowView Ik;
    private KsSlideArrowView Il;
    private double Im;
    private AdMatrixInfo.SplashSlideInfo In;
    private float Io;
    private float Ip;
    private float Iq;
    private float Ir;
    private float Is;
    private boolean It = false;
    private boolean Iu = false;
    private com.kwad.sdk.core.g.d hu;
    private Vibrator hw;
    private float mActionBarHeight;
    private AdInfo mAdInfo;
    private long mStartTime;

    @Override // com.kwad.components.ad.splashscreen.g
    public final void aw(int i) {
    }

    static /* synthetic */ boolean a(n nVar, boolean z) {
        nVar.Iu = true;
        return true;
    }

    static /* synthetic */ boolean b(n nVar, boolean z) {
        nVar.It = true;
        return true;
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i, com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i, com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        View rootView;
        this.mStartTime = SystemClock.elapsedRealtime();
        super.ay();
        if (this.HC == null || (rootView = getRootView()) == null) {
            return;
        }
        rootView.post(new bi() { // from class: com.kwad.components.ad.splashscreen.presenter.n.1
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                if (n.this.HC != null) {
                    n.this.HC.He = SystemClock.elapsedRealtime() - n.this.mStartTime;
                }
            }
        });
        this.HC.a(this);
        AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(this.HC.mAdTemplate);
        this.mAdInfo = adInfoEO;
        try {
            AdMatrixInfo.SplashSlideInfo splashSlideInfo = adInfoEO.adMatrixInfo.adDataV2.splashInfo.interactionInfo.slideInfo;
            this.In = splashSlideInfo;
            this.Im = splashSlideInfo.convertDistance;
            ViewStub viewStub = (ViewStub) findViewById(R.id.ksad_splash_slideTouchView);
            if (viewStub != null) {
                this.Ig = (KsSplashSlidePathView) viewStub.inflate();
            } else {
                this.Ig = (KsSplashSlidePathView) findViewById(R.id.ksad_splash_slideview_root);
            }
            KsSplashSlidePathView ksSplashSlidePathView = this.Ig;
            if (ksSplashSlidePathView != null) {
                ksSplashSlidePathView.setOnSlideTouchListener(new KsSplashSlidePathView.a() { // from class: com.kwad.components.ad.splashscreen.presenter.n.3
                    @Override // com.kwad.components.ad.splashscreen.widget.KsSplashSlidePathView.a
                    public final void a(float f, float f2, float f3, float f4) {
                        final float fPx2dip = com.kwad.sdk.c.a.a.px2dip(n.this.mS(), (float) Math.sqrt(Math.pow(f3 - f, 2.0d) + Math.pow(f4 - f2, 2.0d)));
                        if (!SlideConvertHelper.a(n.this.HC.mAdTemplate, f, f2, f3, f4) || n.this.HC == null) {
                            return;
                        }
                        n.this.HC.a(1, n.this.mS(), 153, 1, new com.kwad.components.ad.splashscreen.h.a() { // from class: com.kwad.components.ad.splashscreen.presenter.n.3.1
                            @Override // com.kwad.components.ad.splashscreen.h.a
                            public final void b(com.kwad.sdk.core.adlog.c.b bVar) {
                                bVar.em(n.this.In.style);
                                bVar.en((int) fPx2dip);
                            }
                        });
                    }

                    @Override // com.kwad.components.ad.splashscreen.widget.KsSplashSlidePathView.a
                    public final void c(MotionEvent motionEvent) {
                        if (n.this.It && n.this.Iu) {
                            float x = motionEvent.getX() + n.this.Iq;
                            float y = motionEvent.getY() + n.this.Ir;
                            if (x >= n.this.Io && x <= n.this.Io + n.this.Is && y >= n.this.Ip && y <= n.this.Ip + n.this.mActionBarHeight) {
                                n.this.mQ();
                                return;
                            }
                        }
                        if (com.kwad.components.ad.splashscreen.h.o(n.this.mAdInfo)) {
                            n.this.mR();
                        }
                    }
                });
                this.Ig.post(new bi() { // from class: com.kwad.components.ad.splashscreen.presenter.n.4
                    @Override // com.kwad.sdk.utils.bi
                    public final void doTask() {
                        int[] iArr = new int[2];
                        n.this.Ig.getLocationOnScreen(iArr);
                        n.this.Iq = iArr[0];
                        n.this.Ir = iArr[1];
                        n.a(n.this, true);
                    }
                });
            }
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mQ() {
        if (this.HC != null) {
            this.HC.c(1, mS(), 53, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mR() {
        if (this.HC != null) {
            this.HC.c(1, mS(), 53, 2);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.sdk.core.d.c.d("SplashShakeComboPresenter", "onUnbind");
        if (this.HC != null) {
            this.HC.b(this);
        }
        KsShakeView ksShakeView = this.IG;
        if (ksShakeView != null) {
            ksShakeView.oe();
        }
    }

    protected final Context mS() {
        Context context;
        View view;
        try {
            context = getContext();
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTrace(th);
            context = null;
        }
        return (context != null || (view = this.IH) == null) ? context : view.getContext();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.HC != null) {
            this.HC.c(1, mS(), 158, 1);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.g
    public final void mc() {
        com.kwad.sdk.core.g.d dVar = this.hu;
        if (dVar != null) {
            dVar.cc(mS());
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    protected final void initView() {
        Context contextMS = mS();
        if (contextMS != null) {
            this.hw = (Vibrator) contextMS.getSystemService("vibrator");
        }
        ViewStub viewStub = (ViewStub) findViewById(R.id.ksad_shake_combo_layout);
        if (viewStub != null) {
            this.IH = viewStub.inflate();
        } else {
            this.IH = findViewById(R.id.ksad_shake_combo_root);
        }
        this.IE = (KsSlidePopUpView) findViewById(R.id.ksad_shake_combo_slide_popup_view);
        this.IC = (TextView) findViewById(R.id.ksad_shake_combo_shake_main_text);
        this.ID = (TextView) findViewById(R.id.ksad_shake_combo_sub_text);
        this.IG = (KsShakeView) findViewById(R.id.ksad_shake_combo_shake_icon);
        this.Ik = (KsSlideArrowView) findViewById(R.id.ksad_shake_combo_slide_arrow_top);
        this.Il = (KsSlideArrowView) findViewById(R.id.ksad_shake_combo_slide_arrow_bottom);
        this.IF = (KsButtonBorderSpreadView) findViewById(R.id.ksad_shake_combo_button_spread);
        ImageView imageView = (ImageView) findViewById(R.id.ksad_shake_combo_button_background);
        this.II = imageView;
        imageView.post(new bi() { // from class: com.kwad.components.ad.splashscreen.presenter.n.5
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                int[] iArr = new int[2];
                n.this.II.getLocationOnScreen(iArr);
                n.this.Io = iArr[0];
                n.this.Ip = iArr[1];
                n nVar = n.this;
                nVar.Is = nVar.II.getWidth();
                n nVar2 = n.this;
                nVar2.mActionBarHeight = nVar2.II.getHeight();
                n.b(n.this, true);
            }
        });
        this.Ik.setAnimationDelayTime(500);
        this.Il.setAnimationDelayTime(500);
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    protected final void mJ() {
        AdTemplate adTemplate = this.HC.mAdTemplate;
        AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(adTemplate);
        this.Ij = com.kwad.components.ad.splashscreen.d.a(adTemplate, adInfoEO, this.HC.mApkDownloadHelper, 9);
        TextView textView = this.IC;
        if (textView != null) {
            textView.setText(com.kwad.sdk.core.response.helper.b.dS(adInfoEO));
        }
        TextView textView2 = this.ID;
        if (textView2 != null) {
            textView2.setText(this.Ij.lW());
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    protected final void mK() {
        if (this.IH == null || this.HC == null) {
            return;
        }
        this.IH.setVisibility(0);
        com.kwad.sdk.core.adlog.c.b(this.HC.mAdTemplate, 199, (JSONObject) null);
        com.kwad.components.core.webview.tachikoma.e.a.zA().cl(199);
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
        } else {
            dVar.m(fDK);
        }
        KsShakeView ksShakeView = this.IG;
        if (ksShakeView != null) {
            ksShakeView.setOnClickListener(this);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    protected final void mM() {
        com.kwad.sdk.core.g.d dVar = this.hu;
        if (dVar != null) {
            dVar.cb(mS());
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    protected final void mN() {
        com.kwad.sdk.core.g.d dVar = this.hu;
        if (dVar != null) {
            dVar.cc(mS());
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    protected final void fY() {
        KsShakeView ksShakeView = this.IG;
        if (ksShakeView != null) {
            ksShakeView.post(new bi() { // from class: com.kwad.components.ad.splashscreen.presenter.n.6
                @Override // com.kwad.sdk.utils.bi
                public final void doTask() {
                    n.this.IG.od();
                }
            });
        }
        KsSlidePopUpView ksSlidePopUpView = this.IE;
        if (ksSlidePopUpView != null) {
            ksSlidePopUpView.post(new bi() { // from class: com.kwad.components.ad.splashscreen.presenter.n.7
                @Override // com.kwad.sdk.utils.bi
                public final void doTask() {
                    n.this.IE.of();
                }
            });
        }
        KsButtonBorderSpreadView ksButtonBorderSpreadView = this.IF;
        if (ksButtonBorderSpreadView != null) {
            ksButtonBorderSpreadView.postDelayed(new bi() { // from class: com.kwad.components.ad.splashscreen.presenter.n.8
                @Override // com.kwad.sdk.utils.bi
                public final void doTask() {
                    n.this.IF.fY();
                }
            }, 300L);
        }
        KsSlideArrowView ksSlideArrowView = this.Ik;
        if (ksSlideArrowView != null) {
            ksSlideArrowView.postDelayed(new bi() { // from class: com.kwad.components.ad.splashscreen.presenter.n.9
                @Override // com.kwad.sdk.utils.bi
                public final void doTask() {
                    n.this.Ik.fY();
                }
            }, 1000L);
        }
        KsSlideArrowView ksSlideArrowView2 = this.Il;
        if (ksSlideArrowView2 != null) {
            ksSlideArrowView2.postDelayed(new bi() { // from class: com.kwad.components.ad.splashscreen.presenter.n.10
                @Override // com.kwad.sdk.utils.bi
                public final void doTask() {
                    n.this.Il.fY();
                }
            }, 800L);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    protected final void j(int i, String str) {
        if (this.ID != null) {
            if (i != 2) {
                str = "或点击" + str;
            }
            this.ID.setText(str);
        }
    }

    @Override // com.kwad.sdk.core.g.b
    public final void a(final double d) {
        boolean zPG = com.kwad.components.core.e.c.b.pG();
        if (!this.HC.GP.Ae() || zPG) {
            return;
        }
        this.IG.b(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.splashscreen.presenter.n.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (n.this.HC != null) {
                    n.this.HC.a(1, n.this.mS(), 157, 1, new com.kwad.components.ad.splashscreen.h.a() { // from class: com.kwad.components.ad.splashscreen.presenter.n.2.1
                        @Override // com.kwad.components.ad.splashscreen.h.a
                        public final void b(com.kwad.sdk.core.adlog.c.b bVar) {
                            bVar.j(d);
                        }
                    });
                }
                n.this.IG.od();
            }
        });
        by.a(mS(), this.hw);
        mN();
    }

    @Override // com.kwad.sdk.core.g.b
    public final void cj() {
        com.kwad.sdk.core.adlog.c.cw(this.HC.mAdTemplate);
    }
}
