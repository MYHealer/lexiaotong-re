package com.opos.mobad.g.a;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.stub.StubApp;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class l extends com.opos.mobad.q.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.opos.mobad.ad.f.f f6996a;
    private String b;
    private RelativeLayout c;
    private ViewGroup d;
    private Context g;
    private com.opos.mobad.g.a.a.p<com.opos.mobad.ad.f.b> h;
    private RelativeLayout i;
    private com.opos.mobad.g.b j;

    private class a extends com.opos.mobad.g.a.a.b implements com.opos.mobad.ad.f.c {
        private final int b;

        public a(int i, com.opos.mobad.g.a.a.p pVar) {
            super(i, pVar);
            this.b = i;
        }

        @Override // com.opos.mobad.g.a.a.b, com.opos.mobad.ad.b.a
        public void a(int i, String str) {
            l.this.d("ad failed:" + i + ",msg:" + str + ", state=" + l.this.c());
            if (1 == l.this.c()) {
                super.a(i, str);
            } else if (2 != l.this.c() || this.b != l.this.h.i()) {
                l.this.d("ignore fail:" + this.b);
            } else {
                l.this.d(i, str);
                com.opos.mobad.service.c.c(new Runnable() { // from class: com.opos.mobad.g.a.l.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (l.this.c() == 5) {
                            l.this.d("onFail to destroy view but destroy state");
                        } else {
                            l.this.r();
                        }
                    }
                });
            }
        }

        @Override // com.opos.mobad.ad.l.b
        public void a(long j) {
            l.this.d("ad click:" + this.b + "," + l.this.h.h());
            if (this.b != l.this.h.i()) {
                return;
            }
            com.opos.mobad.c.b.g().b(l.this.b);
            l.this.l();
        }

        @Override // com.opos.mobad.ad.l.b
        public void a(String str) {
            l.this.d("ad show");
            if (this.b != l.this.h.i()) {
                return;
            }
            com.opos.mobad.c.b.g().a(l.this.b);
            l.this.e(str);
        }

        @Override // com.opos.mobad.g.a.a.b, com.opos.mobad.ad.b.a
        public void b() {
            l.this.d("ad close:" + this.b + "," + l.this.h.h());
            if (this.b != l.this.h.i()) {
                return;
            }
            l.this.m();
        }
    }

    public l(final Activity activity, final String str, com.opos.mobad.ad.f.f fVar, com.opos.mobad.ad.f.c cVar, final com.opos.mobad.g.b bVar) {
        super(cVar);
        if (fVar == null) {
            com.opos.cmn.an.f.a.c("SplashAdDelegator", "SplashAd params null.");
            d(-1, "SplashAd params null.");
            return;
        }
        if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
            com.opos.cmn.an.f.a.c("SplashAdDelegator", "SplashAd constructor param activity error.");
            d(-1, "SplashAd Constructor param Activity was died.");
            return;
        }
        if (!com.opos.cmn.an.h.f.a.a(activity)) {
            com.opos.cmn.an.f.a.c("SplashAdDelegator", "SplashAd must be displayed in full screen mode.");
            d(-1, "SplashAd must be displayed in full screen mode.");
            return;
        }
        this.b = str;
        this.g = StubApp.getOrigApplicationContext(activity.getApplicationContext());
        this.f6996a = a(fVar);
        this.c = new RelativeLayout(this.g);
        ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView().findViewById(R.id.content);
        this.d = viewGroup;
        this.j = bVar;
        if (viewGroup == null) {
            com.opos.cmn.an.f.a.c("SplashAdDelegator", "SplashAd must has contentView.");
            d(-1, "SplashAd must has contentView.");
        } else if (a(this.f6996a.e.a())) {
            String strA = com.opos.mobad.ad.a.a(10502);
            d(10502, strA);
            com.opos.cmn.an.f.a.c("SplashAdDelegator", strA);
        } else {
            if (fVar.h) {
                a(this.g, this.f6996a);
            }
            this.h = a(str, new com.opos.mobad.g.a.b.b<com.opos.mobad.ad.f.b>() { // from class: com.opos.mobad.g.a.l.1
                @Override // com.opos.mobad.g.a.b.a
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public com.opos.mobad.ad.f.b b(com.opos.mobad.c.a.d.a aVar, com.opos.mobad.g.a.a.p pVar) {
                    com.opos.mobad.ad.c cVarB = bVar.b(aVar.m);
                    if (cVarB == null) {
                        return null;
                    }
                    return cVarB.a(activity, str, aVar.n, l.this.f6996a, (com.opos.mobad.ad.f.c) l.this.new a(aVar.m, pVar));
                }
            }, new com.opos.mobad.g.a.c.a(this.g));
        }
    }

    private com.opos.mobad.ad.f.f a(com.opos.mobad.ad.f.f fVar) {
        String strA;
        com.opos.mobad.ad.f.f.a aVarA = new com.opos.mobad.ad.f.f.a(this.g).a(fVar.f6655a).a(fVar.d).b(fVar.f).c(fVar.h).a(fVar.g);
        if (TextUtils.isEmpty(fVar.b)) {
            Context context = this.g;
            strA = com.opos.mobad.q.n.a(context, context.getPackageName());
        } else {
            strA = fVar.b;
        }
        String str = TextUtils.isEmpty(fVar.c) ? "欢迎使用" : fVar.c;
        return aVarA.b(str).a(strA).a(m.a(fVar.e, this.g, strA, str)).a();
    }

    private com.opos.mobad.g.a.a.p<com.opos.mobad.ad.f.b> a(final String str, final com.opos.mobad.g.a.b.b<com.opos.mobad.ad.f.b> bVar, final com.opos.mobad.g.a.c.a aVar) {
        final com.opos.mobad.ad.b.a aVar2 = new com.opos.mobad.ad.b.a() { // from class: com.opos.mobad.g.a.l.2
            @Override // com.opos.mobad.ad.b.a
            public void a() {
                l.this.d("onAdReady");
                com.opos.mobad.service.c.c(new Runnable() { // from class: com.opos.mobad.g.a.l.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (l.this.c() == 5) {
                            l.this.d("remove but has destroy");
                        } else {
                            l.this.q();
                            l.this.p();
                        }
                    }
                });
                l.this.o();
            }

            @Override // com.opos.mobad.ad.b.a
            public void a(int i, String str2) {
                int iA = com.opos.mobad.g.a.a.l.a(i);
                com.opos.cmn.an.f.a.b("SplashAdDelegator", "onAdFailed code=" + i + ",msg =" + str2 + "ErrorCodeTranslate: " + iA);
                l.this.c(iA, str2);
                l.this.q();
            }

            @Override // com.opos.mobad.ad.b.a
            public void b() {
                l.this.d("onAdClose");
                l.this.m();
            }
        };
        final int iK = com.opos.mobad.c.b.a().k();
        return new com.opos.mobad.g.a.a.c(str, 60, new com.opos.mobad.g.a.a.c.a<com.opos.mobad.g.a.a.p<com.opos.mobad.ad.f.b>>() { // from class: com.opos.mobad.g.a.l.3
            @Override // com.opos.mobad.g.a.a.c.a
            public int a(int i) {
                return l.this.j.a(i);
            }

            @Override // com.opos.mobad.g.a.a.c.a
            public com.opos.mobad.g.a.a.p<com.opos.mobad.ad.f.b> a(List<com.opos.mobad.c.a.d.a> list, com.opos.mobad.c.a.d.a aVar3, long j) {
                return com.opos.mobad.g.a.a.k.a(str, new com.opos.mobad.g.a.e.b(iK), list, aVar3, j, bVar, aVar, aVar2);
            }

            @Override // com.opos.mobad.g.a.a.c.a
            public com.opos.mobad.g.a.a.p<com.opos.mobad.ad.f.b> a(List<com.opos.mobad.c.a.d.a> list, com.opos.mobad.c.a.d.a aVar3, long j, int i) {
                return com.opos.mobad.g.a.a.k.a(str, new com.opos.mobad.g.a.e.c(i, iK), list, aVar3, j, bVar, aVar, aVar2);
            }
        });
    }

    private boolean a(View view) {
        return (view == null || view.getParent() == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        this.c.removeAllViews();
        com.opos.mobad.g.a.a.p<com.opos.mobad.ad.f.b> pVar = this.h;
        if (pVar == null) {
            return;
        }
        boolean z = pVar.i() != com.opos.mobad.c.a.d.a.f6704a;
        if (z && this.f6996a.h) {
            View viewA = this.f6996a.e.a();
            if (this.c != null && viewA != null) {
                if (viewA.getParent() != null) {
                    ((ViewGroup) viewA.getParent()).removeView(viewA);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, (int) ((com.opos.cmn.an.h.f.a.b(this.g) * 0.3778f) + 0.5f));
                layoutParams.addRule(12);
                viewA.setId(1);
                viewA.setBackgroundColor(-1);
                n.a(this.c, viewA, layoutParams);
            }
        }
        com.opos.mobad.ad.f.b bVar = (com.opos.mobad.ad.f.b) this.h.h();
        if (bVar != null) {
            View viewG = bVar.g();
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
            if (z) {
                layoutParams2.addRule(2, 1);
            }
            if (!n.a(this.c, viewG, layoutParams2)) {
                d(10500, com.opos.mobad.ad.a.a(10500));
                return;
            }
        }
        n.a(this.d, this.c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        com.opos.mobad.service.c.a(new Runnable() { // from class: com.opos.mobad.g.a.l.4
            @Override // java.lang.Runnable
            public void run() {
                if (l.this.c() == 5) {
                    l.this.d("remove pre view but has destroy");
                    return;
                }
                l.this.d("removePreLoadView");
                if (l.this.d == null || l.this.i == null) {
                    return;
                }
                l.this.d.removeView(l.this.i);
                l.this.i.removeAllViews();
                l.this.i = null;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        ViewGroup viewGroup = this.d;
        if (viewGroup != null) {
            RelativeLayout relativeLayout = this.i;
            if (relativeLayout != null) {
                viewGroup.removeView(relativeLayout);
            }
            RelativeLayout relativeLayout2 = this.c;
            if (relativeLayout2 != null) {
                viewGroup.removeView(relativeLayout2);
            }
            this.d = null;
        }
    }

    @Override // com.opos.mobad.q.j, com.opos.mobad.ad.b
    public void a() {
        a(com.opos.mobad.c.b.a().k());
    }

    public void a(Context context, com.opos.mobad.ad.f.f fVar) {
        View viewA = fVar.e.a();
        boolean z = fVar.d;
        d("showPreLoadPage: " + z);
        if (z) {
            RelativeLayout relativeLayout = new RelativeLayout(context);
            this.i = relativeLayout;
            relativeLayout.setBackgroundColor(-1);
            this.i.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, n.a(context));
            layoutParams.addRule(12);
            this.i.addView(viewA, layoutParams);
            n.a(this.d, this.i);
        }
    }

    @Override // com.opos.mobad.q.j, com.opos.mobad.ad.b
    public void b() {
        super.b();
        com.opos.mobad.g.a.a.p<com.opos.mobad.ad.f.b> pVar = this.h;
        if (pVar != null) {
            pVar.b();
        }
        r();
    }

    @Override // com.opos.mobad.q.j
    protected boolean b(String str, int i) {
        d("doLoad");
        this.h.a(str, i);
        return true;
    }

    @Override // com.opos.mobad.q.j
    protected boolean c(String str) {
        return false;
    }

    public void d(String str) {
        com.opos.cmn.an.f.a.b("SplashAdDelegator", str);
    }

    @Override // com.opos.mobad.q.j, com.opos.mobad.ad.b
    public boolean d() {
        com.opos.mobad.ad.b bVarH = this.h.h();
        if (bVarH != null) {
            return bVarH.d();
        }
        return false;
    }

    @Override // com.opos.mobad.ad.f.b
    public View g() {
        if (c() != 2) {
            return null;
        }
        p();
        return this.c;
    }

    @Override // com.opos.mobad.q.i, com.opos.mobad.ad.f.b
    public void h() {
    }

    @Override // com.opos.mobad.q.i, com.opos.mobad.ad.f.b
    public void i() {
    }

    @Override // com.opos.mobad.q.i, com.opos.mobad.ad.f.b
    public View j() {
        return null;
    }
}
