package com.adprof.sdk;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.adprof.sdk.api.AdError;
import com.adprof.sdk.api.AdRequest;
import com.adprof.sdk.api.SplashAdListener;
import com.adprof.sdk.base.fb.FBView;
import com.huawei.openalliance.ad.constant.br;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class hm extends p5 implements h7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f1215a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ViewGroup f364a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public SplashAdListener f365a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public bn f366a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final rm f367a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f368a;

    public hm(AdRequest adRequest, SplashAdListener splashAdListener, long j) {
        super(adRequest);
        this.f368a = false;
        ((p5) this).f548a = i2.AdStatusNone;
        this.f1215a = j;
        this.f365a = splashAdListener;
        ((p5) this).f549a = new wd(adRequest, 2);
        this.f367a = new rm(this);
    }

    @Override // com.adprof.sdk.p5
    public d a() {
        return ((p5) this).f546a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public final void m654a() {
        AdRequest adRequest = ((p5) this).f1357a;
        long j = 500;
        if (adRequest != null) {
            long closeDelayRemoveViewMills = adRequest.getCloseDelayRemoveViewMills();
            if (closeDelayRemoveViewMills >= 0) {
                j = closeDelayRemoveViewMills;
            }
        }
        if (pk.f594a) {
            pk.d(" splash  CloseDelayRemoveViewMills = " + j);
        }
        new Handler(Looper.getMainLooper()).postDelayed(new fm(this), j);
    }

    @Override // com.adprof.sdk.p5
    public void a(int i, String str, String str2, wd wdVar) {
        a(i, str);
    }

    @Override // com.adprof.sdk.p5
    public void a(AdError adError) {
        a(adError, true, "respond_timeout");
    }

    @Override // com.adprof.sdk.p5
    public void a(d dVar, String str) {
        try {
            if (m699a(dVar, str)) {
                fn.a(new em(this));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.adprof.sdk.p5
    public void a(List list, wd wdVar) {
        try {
            if (!a((d) list.get(0)) || this.f365a == null || ((p5) this).f549a == null) {
                return;
            }
            fn.a(new dm(this));
        } catch (Exception unused) {
        }
    }

    public void b() {
        wl wlVar;
        if (this.f368a) {
            return;
        }
        this.f368a = true;
        rm rmVar = this.f367a;
        if (rmVar != null && (wlVar = rmVar.f709a) != null) {
            wlVar.b();
            rmVar.f709a = null;
        }
        bn bnVar = this.f366a;
        if (bnVar != null) {
            qm qmVar = bnVar.f147a;
            if (qmVar != null) {
                an anVar = (an) qmVar;
                ll.a(((x0) anVar).f821a);
                try {
                    k9 k9Var = anVar.f29a;
                    if (k9Var != null) {
                        k9Var.a();
                        anVar.f29a = null;
                    }
                } catch (Throwable unused) {
                }
                hp.m656a((View) null);
                c2 c2Var = anVar.f28a;
                if (c2Var != null) {
                    c2Var.b();
                    anVar.f28a = null;
                }
                pe peVar = anVar.f30a;
                if (peVar != null) {
                    peVar.c();
                    anVar.f30a = null;
                }
                zl zlVar = anVar.f31a;
                if (zlVar != null) {
                    zlVar.a();
                    zl zlVar2 = anVar.f31a;
                    if (zlVar2 != null) {
                        ViewParent parent = zlVar2.getParent();
                        if (parent instanceof ViewGroup) {
                            ((ViewGroup) parent).removeView(zlVar2);
                        }
                    }
                    anVar.f31a = null;
                }
                ViewParent parent2 = anVar.getParent();
                if (parent2 instanceof ViewGroup) {
                    ((ViewGroup) parent2).removeView(anVar);
                }
                anVar.setOnTouchListener(null);
                FBView fBView = anVar.f27a;
                if (fBView != null) {
                    hp.m656a((View) fBView);
                    anVar.f27a = null;
                }
            }
            this.f366a = null;
        }
        d dVar = ((p5) this).f546a;
        if (dVar != null) {
            dVar.m596a();
            ((p5) this).f546a = null;
        }
        this.f365a = null;
        ((p5) this).f548a = i2.AdStatusNone;
    }

    public void c() {
        pk.c("SplashAdManager---onAdClicked----");
        pk.c("---onAdClicked----");
        ((p5) this).f548a = i2.AdStatusClick;
        d dVar = ((p5) this).f546a;
        if (dVar != null) {
            dVar.g = 0;
        }
        if (dVar != null && dVar.m600b()) {
            pk.d("SplashAdManager onAdClicked --------- mc ");
            h2.a(((p5) this).f546a);
        } else {
            SplashAdListener splashAdListener = this.f365a;
            if (splashAdListener != null) {
                splashAdListener.onSplashAdClick();
            }
        }
    }

    public void e() {
        pk.c("SplashAdManager-----onLandPageShow---");
        oh.a("landing_page_show", "", ((p5) this).f546a);
    }

    @Override // com.adprof.sdk.p5
    public int getBidPrice() {
        d dVar = ((p5) this).f546a;
        return dVar != null ? dVar.b : super.getBidPrice();
    }

    public void d() {
        wl wlVar;
        pk.c("SplashAdManager---onLandPageClose--");
        oh.a("landing_page_close", "", ((p5) this).f546a);
        if (this.f368a) {
            rm rmVar = this.f367a;
            if (rmVar != null && (wlVar = rmVar.f709a) != null) {
                wlVar.b();
                rmVar.f709a = null;
            }
            d dVar = ((p5) this).f546a;
            if (dVar != null) {
                dVar.m596a();
                ((p5) this).f546a = null;
            }
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public final HashMap m653a() {
        this.f366a.f148a.getClass();
        HashMap map = new HashMap();
        int i = ((p5) this).f546a.g;
        if (i > 0) {
            map.put("mcr", Integer.valueOf(i));
        }
        int i2 = ie.f1229a;
        return map;
    }

    @Override // com.adprof.sdk.p5
    public boolean a(AdError adError, boolean z, String str) {
        wl wlVar;
        if (!super.a(adError, z, str)) {
            return false;
        }
        fn.a(new cm(this, z, adError));
        rm rmVar = this.f367a;
        if (rmVar == null || (wlVar = rmVar.f709a) == null) {
            return false;
        }
        wlVar.b();
        rmVar.f709a = null;
        return false;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m655a() {
        try {
            d dVar = ((p5) this).f546a;
            if (dVar != null) {
                this.f367a.getClass();
                boolean z = dVar != null && (dVar.m603d() || dVar.m605f());
                boolean zM604e = ((p5) this).f546a.m604e();
                i2 i2Var = ((p5) this).f548a;
                return (i2Var == i2.AdStatusSuc || i2Var == i2.AdStatusReady) && z && zM604e;
            }
        } catch (Exception e) {
            pk.b("SplashAdManager isReady error: ", e);
            oh.b(e);
        }
        return false;
    }

    public void a(boolean z) {
        kl klVar;
        pk.c("SplashAdManager---onAdClose----" + z);
        ((p5) this).f548a = i2.AdStatusClose;
        d dVar = ((p5) this).f546a;
        if (dVar != null && (klVar = dVar.f185a) != null) {
            dVar.e = z ? 1 : 0;
            ((a2) klVar).b(dVar);
        }
        SplashAdListener splashAdListener = this.f365a;
        if (splashAdListener != null) {
            splashAdListener.onSplashAdClose(z);
        }
        m654a();
    }

    public void a(d dVar) {
        kl klVar;
        qm qmVar;
        try {
            pk.c("SplashAdManager---onAdShow----");
            ((p5) this).f548a = i2.AdStatusPlaying;
            if (dVar.f185a == null) {
                new a2().a(dVar);
            }
            h2.a(dVar);
            bn bnVar = this.f366a;
            if (bnVar != null && (qmVar = bnVar.f147a) != null) {
                qmVar.setVisibility(0);
            }
            d dVar2 = ((p5) this).f546a;
            if (dVar2 != null && (klVar = dVar2.f185a) != null) {
                ((a2) klVar).a(dVar2, br.b.V, m653a());
                n1.f1315a.m689a(((p5) this).f546a.e());
            }
            d dVar3 = ((p5) this).f546a;
            if (dVar3 == null || dVar3.f201c) {
                return;
            }
            dVar3.f201c = true;
            SplashAdListener splashAdListener = this.f365a;
            if (splashAdListener != null) {
                splashAdListener.onSplashAdShow();
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.adprof.sdk.p5
    public void b(Activity activity) {
        qm qmVar;
        if (this.f366a == null || activity != hp.a((View) this.f364a) || (qmVar = this.f366a.f147a) == null) {
            return;
        }
        an anVar = (an) qmVar;
        if (((qm) anVar).f684a != null) {
            pk.d("splash onPause() invoke , pause timer");
            ((qm) anVar).f684a.d();
        }
        zl zlVar = anVar.f31a;
        if (zlVar != null) {
            zlVar.b();
        }
    }

    @Override // com.adprof.sdk.p5
    public void a(Activity activity) {
        qm qmVar;
        if (this.f366a == null || activity != hp.a((View) this.f364a) || (qmVar = this.f366a.f147a) == null) {
            return;
        }
        an anVar = (an) qmVar;
        l8 l8Var = ((qm) anVar).f684a;
        if (l8Var != null) {
            l8Var.e();
        }
        zl zlVar = anVar.f31a;
        if (zlVar != null) {
            zlVar.c();
        }
        pe peVar = anVar.f30a;
        if (peVar != null) {
            peVar.b();
        }
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0090 A[Catch: Exception -> 0x0095, TRY_LEAVE, TryCatch #1 {Exception -> 0x0095, blocks: (B:32:0x008c, B:34:0x0090), top: B:50:0x008c, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:50:0x008c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public void a(ViewGroup viewGroup) {
        e2 e2Var;
        AdError adError;
        d dVar = ((p5) this).f546a;
        int i = 0;
        if (dVar != null && !dVar.m604e()) {
            adError = AdError.ERROR_AD_EXPIRED;
        } else if (!m655a()) {
            adError = AdError.ERROR_AD_NOT_READY;
        } else {
            if (viewGroup != null) {
                this.f364a = viewGroup;
                rm rmVar = this.f367a;
                viewGroup.getContext();
                d dVar2 = ((p5) this).f546a;
                rmVar.getClass();
                if (rmVar.f1406a instanceof hm) {
                    wl wlVar = new wl(dVar2, (hm) rmVar.f1406a, dVar2.k());
                    rmVar.f709a = wlVar;
                    wlVar.m715a();
                }
                bn bnVar = new bn(viewGroup.getContext(), ((p5) this).f549a, ((p5) this).f546a);
                this.f366a = bnVar;
                gm gmVar = new gm(this);
                qm qmVar = bnVar.f147a;
                if (qmVar != null) {
                    qmVar.setInteractionListener(gmVar);
                }
                bn bnVar2 = this.f366a;
                qm qmVar2 = bnVar2.f147a;
                if (qmVar2 == null) {
                    bnVar2.a("show splashView is null");
                    return;
                }
                l8 l8Var = qmVar2.f684a;
                if (l8Var != null) {
                    l8Var.a();
                    qmVar2.f684a.b();
                }
                xl xlVar = qmVar2.f685a;
                xlVar.getClass();
                try {
                    q0 q0Var = ((n5) xlVar).f512a.f188a;
                    o1 o1Var = q0Var.f639a;
                    if (o1Var != null) {
                        int i2 = o1Var.f522a;
                        if (i2 != -1) {
                            i = i2;
                        } else {
                            try {
                                e2Var = q0Var.f637a;
                                if (e2Var != null) {
                                    i = e2Var.f230a.d;
                                }
                            } catch (Exception e) {
                                pk.d(Log.getStackTraceString(e));
                            }
                        }
                        xlVar.c = i;
                    } else {
                        e2Var = q0Var.f637a;
                        if (e2Var != null) {
                            i = e2Var.f230a.d;
                        }
                        xlVar.c = i;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                if (xlVar.c < 3) {
                    xlVar.c = 5;
                }
                l8 l8Var2 = new l8(((long) xlVar.c) * 1000, 500L);
                qmVar2.f684a = l8Var2;
                l8Var2.f439a = new nm(qmVar2);
                l8Var2.c();
                qmVar2.f684a.f();
                viewGroup.removeAllViews();
                hp.m656a((View) bnVar2.f147a);
                viewGroup.addView(bnVar2.f147a);
                return;
            }
            adError = AdError.ERROR_AD_CONTAINER_IS_NULL;
        }
        a(adError, false, "play");
    }
}
