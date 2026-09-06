package com.kwad.components.ad.draw.presenter.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import com.kwad.components.core.e.d.d;
import com.kwad.components.core.t.x;
import com.kwad.components.core.video.l;
import com.kwad.components.core.video.m;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.af;
import com.kwad.components.core.webview.jshandler.ai;
import com.kwad.components.core.webview.jshandler.ak;
import com.kwad.components.core.webview.jshandler.al;
import com.kwad.components.core.webview.jshandler.am;
import com.kwad.components.core.webview.jshandler.as;
import com.kwad.components.core.webview.jshandler.az;
import com.kwad.components.core.webview.jshandler.bc;
import com.kwad.components.core.webview.jshandler.n;
import com.kwad.components.core.webview.jshandler.o;
import com.kwad.components.core.webview.jshandler.z;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.KsAdWebView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class c extends com.kwad.components.ad.draw.b.a {
    private ViewGroup ee;
    private KsAdWebView ff;
    private al.a fg;
    private com.kwad.components.core.webview.a fh;
    private com.kwad.sdk.core.webview.b fi;
    private az fk;
    private ValueAnimator fp;
    private ValueAnimator fq;
    private AdTemplate mAdTemplate;
    private d mApkDownloadHelper;
    private int fj = -1;
    private l mVideoPlayStateListener = new m() { // from class: com.kwad.components.ad.draw.presenter.b.c.1
        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayCompleted() {
            super.onMediaPlayCompleted();
            c.this.release();
        }
    };
    private a.b eZ = new a.b() { // from class: com.kwad.components.ad.draw.presenter.b.c.2
        @Override // com.kwad.components.ad.draw.presenter.b.a.b
        public final boolean bc() {
            return c.this.bm();
        }
    };
    private com.kwad.sdk.core.webview.d.a.a fl = new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.ad.draw.presenter.b.c.3
        @Override // com.kwad.sdk.core.webview.d.a.a
        public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
            if (c.this.dQ.dB != null) {
                c.this.dQ.dB.onAdClicked();
            }
        }
    };
    private al.b fm = new al.b() { // from class: com.kwad.components.ad.draw.presenter.b.c.4
        @Override // com.kwad.components.core.webview.jshandler.al.b
        public final void a(al.a aVar) {
            c.this.fg = aVar;
            c.this.ff.setTranslationY(aVar.height + aVar.bottomMargin);
        }
    };
    private ak.b fn = new ak.b() { // from class: com.kwad.components.ad.draw.presenter.b.c.5
        @Override // com.kwad.components.core.webview.jshandler.ak.b
        public final void a(ak.a aVar) {
            c.this.bp();
        }
    };
    private as.b fo = new as.b() { // from class: com.kwad.components.ad.draw.presenter.b.c.6
        @Override // com.kwad.components.core.webview.jshandler.as.b
        public final void a(as.a aVar) {
            c.this.fj = aVar.status;
            com.kwad.sdk.core.d.c.i("DrawPlayWebCard", "updatePageStatus mPageState: " + aVar);
        }
    };

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.ee = (ViewGroup) findViewById(R.id.ksad_ad_normal_container);
        this.ff = (KsAdWebView) findViewById(R.id.ksad_play_web_card_webView);
    }

    @Override // com.kwad.components.ad.draw.b.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.mAdTemplate = this.dQ.mAdTemplate;
        this.dQ.dV.a(this.eZ);
        this.mApkDownloadHelper = this.dQ.mApkDownloadHelper;
        this.dQ.dS.b(this.mVideoPlayStateListener);
        bi();
        bj();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.dQ.dV.a((a.b) null);
        this.dQ.dS.a(this.mVideoPlayStateListener);
        br();
        release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void release() {
        this.fj = -1;
        this.ff.setVisibility(8);
        bl();
    }

    private void bi() {
        com.kwad.sdk.core.webview.b bVar = new com.kwad.sdk.core.webview.b();
        this.fi = bVar;
        bVar.setAdTemplate(this.dQ.mAdTemplate);
        this.fi.mScreenOrientation = 0;
        this.fi.bbV = this.dQ.mRootContainer;
        this.fi.adW = this.dQ.mRootContainer;
        this.fi.ade = this.ff;
    }

    private void bj() {
        this.fj = -1;
        bk();
        this.ff.setBackgroundColor(0);
        this.ff.getBackground().setAlpha(0);
        this.ff.setVisibility(4);
        this.ff.loadUrl(com.kwad.sdk.core.response.helper.b.cV(this.mAdTemplate));
    }

    private void bk() {
        bl();
        com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(this.ff);
        this.fh = aVar;
        a(aVar);
        this.ff.addJavascriptInterface(this.fh, "KwaiAd");
    }

    private void bl() {
        com.kwad.components.core.webview.a aVar = this.fh;
        if (aVar != null) {
            aVar.destroy();
            this.fh = null;
        }
    }

    private void a(com.kwad.components.core.webview.a aVar) {
        aVar.a(new ac(this.fi, this.mApkDownloadHelper, this.fl, (byte) 0));
        aVar.a(new z(this.fi, this.mApkDownloadHelper, this.fl));
        aVar.a(new af(this.fi));
        aVar.a(new ai(this.fi));
        aVar.a(new ae(this.fi));
        aVar.a(new al(this.fi, this.fm));
        aVar.a(new as(this.fo, com.kwad.sdk.core.response.helper.b.cV(this.mAdTemplate)));
        az azVar = new az();
        this.fk = azVar;
        aVar.a(azVar);
        aVar.a(new bc(this.fi, this.mApkDownloadHelper));
        aVar.a(new ak(this.fn));
        aVar.a(new am(this.fi));
        aVar.b(new o(this.fi));
        aVar.b(new n(this.fi));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bm() {
        if (this.fj == 1) {
            bn();
            return true;
        }
        bs();
        return false;
    }

    private void bn() {
        if (this.fg == null) {
            bo();
            return;
        }
        br();
        this.ee.setVisibility(8);
        this.ff.setVisibility(0);
        ValueAnimator valueAnimatorC = x.c(this.ff, this.fg.height + this.fg.bottomMargin, 0);
        this.fp = valueAnimatorC;
        valueAnimatorC.setInterpolator(new DecelerateInterpolator(2.0f));
        this.fp.setDuration(300L);
        this.fp.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.draw.presenter.b.c.7
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                if (c.this.fk != null) {
                    c.this.fk.yx();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (c.this.fk != null) {
                    c.this.fk.yy();
                }
            }
        });
        this.fp.start();
    }

    private void bo() {
        az azVar = this.fk;
        if (azVar != null) {
            azVar.yx();
        }
        this.ee.setVisibility(8);
        this.ff.setVisibility(0);
        az azVar2 = this.fk;
        if (azVar2 != null) {
            azVar2.yy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bp() {
        if (this.ff.getVisibility() != 0) {
            return;
        }
        if (this.fg == null) {
            bq();
            return;
        }
        br();
        ValueAnimator valueAnimatorC = x.c(this.ff, 0, this.fg.height + this.fg.bottomMargin);
        this.fq = valueAnimatorC;
        valueAnimatorC.setInterpolator(new DecelerateInterpolator(2.0f));
        this.fq.setDuration(300L);
        this.fq.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.draw.presenter.b.c.8
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                if (c.this.fk != null) {
                    c.this.fk.yz();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                c.this.ff.setVisibility(4);
                c.this.ee.setVisibility(0);
                if (c.this.fk != null) {
                    c.this.fk.yA();
                }
            }
        });
        this.fq.start();
    }

    private void bq() {
        if (this.ff.getVisibility() != 0) {
            return;
        }
        az azVar = this.fk;
        if (azVar != null) {
            azVar.yz();
        }
        this.ff.setVisibility(4);
        this.ee.setVisibility(0);
        az azVar2 = this.fk;
        if (azVar2 != null) {
            azVar2.yA();
        }
    }

    private void br() {
        ValueAnimator valueAnimator = this.fp;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.fp.cancel();
        }
        ValueAnimator valueAnimator2 = this.fq;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllListeners();
            this.fq.cancel();
        }
    }

    private void bs() {
        String str;
        int i = this.fj;
        if (i == -1) {
            str = "timeout";
        } else {
            str = i != 1 ? "h5error" : "others";
        }
        com.kwad.sdk.core.d.c.w("DrawPlayWebCard", "show webCard fail, reason: ".concat(str));
    }
}
