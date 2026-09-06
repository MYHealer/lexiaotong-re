package com.opos.mobad.g.a;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import com.heytap.msp.mobad.api.ad.IBidding;
import com.opos.mobad.r.a.q;
import com.stub.StubApp;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class c extends com.opos.mobad.q.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.opos.mobad.ad.f.f f6953a;
    private String b;
    private String c;
    private RelativeLayout d;
    private com.opos.mobad.ad.f.c g;
    private ViewGroup h;
    private Context i;
    private com.opos.mobad.g.a.a.p<com.opos.mobad.ad.f.a> j;
    private com.opos.mobad.g.b k;
    private boolean l;
    private boolean m;
    private List<String> n;

    private class a extends com.opos.mobad.g.a.a.b implements com.opos.mobad.ad.f, com.opos.mobad.ad.f.c {
        private final int b;
        private final com.opos.mobad.ad.f.c c;

        public a(int i, com.opos.mobad.g.a.a.p pVar, com.opos.mobad.ad.f.c cVar) {
            super(i, pVar);
            this.b = i;
            this.c = cVar;
        }

        @Override // com.opos.mobad.g.a.a.b, com.opos.mobad.ad.b.a
        public void a(int i, String str) {
            c.this.d("ad failed:" + i + ",msg:" + str + ", state=" + c.this.c());
            if (1 == c.this.c()) {
                super.a(i, str);
            } else if (2 != c.this.c() || this.b != c.this.j.i()) {
                c.this.d("ignore fail:" + this.b);
            } else {
                c.this.d(i, str);
                com.opos.mobad.service.c.c(new Runnable() { // from class: com.opos.mobad.g.a.c.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (c.this.c() == 5) {
                            c.this.d("onFail to destroy view but destroy state");
                        } else {
                            c.this.r();
                        }
                    }
                });
            }
        }

        @Override // com.opos.mobad.ad.l.b
        public void a(long j) {
            c.this.d("ad click:" + this.b + "," + c.this.j.h());
            if (this.b != c.this.j.i()) {
                return;
            }
            com.opos.mobad.c.b.g().b(c.this.b);
            c.this.l();
        }

        @Override // com.opos.mobad.ad.l.b
        public void a(String str) {
            c.this.d("ad show");
            if (this.b != c.this.j.i()) {
                return;
            }
            com.opos.mobad.c.b.g().a(c.this.b);
            c.this.e(str);
        }

        @Override // com.opos.mobad.ad.f
        public void a(Map<String, String> map) {
            com.opos.mobad.ad.f.c cVar = this.c;
            if (cVar instanceof com.opos.mobad.ad.f) {
                ((com.opos.mobad.ad.f) cVar).a(map);
            }
        }

        @Override // com.opos.mobad.g.a.a.b, com.opos.mobad.ad.b.a
        public void b() {
            c.this.d("ad close:" + this.b + "," + c.this.j.h());
            if (this.b != c.this.j.i()) {
                return;
            }
            c.this.m = true;
            c.this.m();
        }
    }

    public c(final Context context, final String str, com.opos.mobad.ad.f.f fVar, final com.opos.mobad.ad.f.c cVar, final com.opos.mobad.g.b bVar) {
        super(cVar);
        this.m = false;
        if (context == null || TextUtils.isEmpty(str) || fVar == null || cVar == null || bVar == null) {
            com.opos.cmn.an.f.a.c("HostSplashAdDelegator", "HotSplashAd params null.");
            d(-1, "HotSplashAd params null.");
            return;
        }
        this.g = cVar;
        this.b = str;
        this.i = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.d = new RelativeLayout(this.i);
        this.f6953a = a(fVar);
        this.k = bVar;
        this.j = a(str, new com.opos.mobad.g.a.b.b<com.opos.mobad.ad.f.a>() { // from class: com.opos.mobad.g.a.c.1
            @Override // com.opos.mobad.g.a.b.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public com.opos.mobad.ad.f.a b(com.opos.mobad.c.a.d.a aVar, com.opos.mobad.g.a.a.p pVar) {
                com.opos.mobad.ad.c cVarB = bVar.b(aVar.m);
                if (cVarB == null) {
                    return null;
                }
                return cVarB.a(context, str, aVar.n, c.this.f6953a, c.this.new a(aVar.m, pVar, cVar));
            }
        }, new com.opos.mobad.g.a.c.a(this.i));
    }

    private com.opos.mobad.ad.f.f a(com.opos.mobad.ad.f.f fVar) {
        String strA;
        com.opos.mobad.ad.f.f.a aVarA = new com.opos.mobad.ad.f.f.a(this.i).a(fVar.f6655a).a(fVar.d).b(fVar.f).c(com.opos.mobad.c.b.a().a(this.b) == q.VERTICAL.getValue()).a(fVar.g);
        if (TextUtils.isEmpty(fVar.b)) {
            Context context = this.i;
            strA = com.opos.mobad.q.n.a(context, context.getPackageName());
        } else {
            strA = fVar.b;
        }
        String str = TextUtils.isEmpty(fVar.c) ? "欢迎使用" : fVar.c;
        return aVarA.b(str).a(strA).a(m.a(fVar.e, this.i, strA, str)).a();
    }

    private com.opos.mobad.g.a.a.p<com.opos.mobad.ad.f.a> a(final String str, final com.opos.mobad.g.a.b.b<com.opos.mobad.ad.f.a> bVar, final com.opos.mobad.g.a.c.a aVar) {
        final com.opos.mobad.ad.b.a aVar2 = new com.opos.mobad.ad.b.a() { // from class: com.opos.mobad.g.a.c.2
            @Override // com.opos.mobad.ad.b.a
            public void a() {
                c.this.d("onAdReady");
                com.opos.mobad.service.c.c(new Runnable() { // from class: com.opos.mobad.g.a.c.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.p();
                    }
                });
                c.this.o();
            }

            @Override // com.opos.mobad.ad.b.a
            public void a(int i, String str2) {
                int iA = com.opos.mobad.g.a.a.l.a(i);
                com.opos.cmn.an.f.a.b("HostSplashAdDelegator", "onAdFailed code=" + i + ",msg =" + str2 + "ErrorCodeTranslate: " + iA);
                c.this.c(iA, str2);
            }

            @Override // com.opos.mobad.ad.b.a
            public void b() {
                c.this.d("onAdClose");
                c.this.m();
            }
        };
        final int iK = com.opos.mobad.c.b.a().k();
        return new com.opos.mobad.g.a.a.c(str, 60, new com.opos.mobad.g.a.a.c.a<com.opos.mobad.g.a.a.p<com.opos.mobad.ad.f.a>>() { // from class: com.opos.mobad.g.a.c.3
            @Override // com.opos.mobad.g.a.a.c.a
            public int a(int i) {
                return c.this.k.a(i);
            }

            @Override // com.opos.mobad.g.a.a.c.a
            public com.opos.mobad.g.a.a.p<com.opos.mobad.ad.f.a> a(List<com.opos.mobad.c.a.d.a> list, com.opos.mobad.c.a.d.a aVar3, long j) {
                return com.opos.mobad.g.a.a.k.a(str, new com.opos.mobad.g.a.e.b(iK), list, aVar3, j, bVar, aVar, aVar2);
            }

            @Override // com.opos.mobad.g.a.a.c.a
            public com.opos.mobad.g.a.a.p<com.opos.mobad.ad.f.a> a(List<com.opos.mobad.c.a.d.a> list, com.opos.mobad.c.a.d.a aVar3, long j, int i) {
                return com.opos.mobad.g.a.a.k.a(str, new com.opos.mobad.g.a.e.c(i, iK), list, aVar3, j, bVar, aVar, aVar2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        this.d.removeAllViews();
        if (this.j == null) {
            return;
        }
        if (!s()) {
            com.opos.cmn.an.f.a.b("HostSplashAdDelegator", "pangle channel not create view");
            return;
        }
        boolean z = this.j.i() != com.opos.mobad.c.a.d.a.f6704a;
        if (z && this.f6953a.h) {
            View viewA = this.f6953a.e.a();
            if (this.d != null && viewA != null) {
                if (viewA.getParent() != null) {
                    ((ViewGroup) viewA.getParent()).removeView(viewA);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, (int) ((com.opos.cmn.an.h.f.a.b(this.i) * 0.3778f) + 0.5f));
                layoutParams.addRule(12);
                viewA.setId(1);
                viewA.setBackgroundColor(-1);
                n.a(this.d, viewA, layoutParams);
            }
        }
        com.opos.mobad.ad.f.a aVar = (com.opos.mobad.ad.f.a) this.j.h();
        if (aVar != null) {
            View viewG = aVar.g();
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
            if (z) {
                layoutParams2.addRule(2, 1);
            }
            if (n.a(this.d, viewG, layoutParams2)) {
                return;
            }
            d(10500, com.opos.mobad.ad.a.a(10500));
        }
    }

    private int q() {
        return com.opos.mobad.c.b.a().k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        RelativeLayout relativeLayout;
        try {
            ViewGroup viewGroup = this.h;
            if (viewGroup != null && (relativeLayout = this.d) != null) {
                viewGroup.removeView(relativeLayout);
            }
            this.h = null;
        } catch (Exception e) {
            com.opos.cmn.an.f.a.d("HostSplashAdDelegator", "destroyView", e);
        }
    }

    private boolean s() {
        int i = this.j.i();
        return (i == com.opos.mobad.c.a.d.a.j || i == com.opos.mobad.c.a.d.a.f) ? false : true;
    }

    @Override // com.opos.mobad.q.j, com.opos.mobad.ad.b
    public void a() {
        a(q());
    }

    @Override // com.opos.mobad.ad.i.a, com.opos.mobad.ad.i
    public void a(int i, String str, int i2) {
        if (com.opos.mobad.c.b.a().b(this.b) && c() == 2 && !this.l) {
            this.l = true;
            com.opos.mobad.c.b.f().a(this.b, this.c, i, str, this.j.i(), f(), i2);
        }
    }

    @Override // com.opos.mobad.q.j, com.opos.mobad.ad.k
    public void a(int i, List<String> list) {
        i.a aVarA = i.a(list);
        if (aVarA.f6989a != 0) {
            com.opos.mobad.c.b.g().c(this.b);
        }
        a(aVarA.b, i, list);
    }

    @Override // com.opos.mobad.ad.f.a
    public void a(Activity activity) {
        if (com.opos.cmn.i.b.a(activity)) {
            this.g.a(-1, "Activity is null or activity is finishing.");
            return;
        }
        if (!com.opos.cmn.an.h.f.a.a(activity)) {
            this.g.a(-1, "splash must be displayed in full screen mode.");
            return;
        }
        if (!s()) {
            ((com.opos.mobad.ad.f.a) this.j.h()).a(activity);
            return;
        }
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(R.id.content);
        this.h = viewGroup;
        if (viewGroup == null) {
            this.g.a(-1, "container null");
            return;
        }
        View viewG = g();
        if (viewG == null) {
            this.g.a(-1, "unknown error.");
            return;
        }
        ViewParent parent = viewG.getParent();
        if (parent != null) {
            if (parent == this.h) {
                return;
            }
            if (!(parent instanceof ViewGroup)) {
                this.g.a(-1, "view had add to container");
                return;
            }
            ((ViewGroup) parent).removeView(viewG);
        }
        this.h.addView(viewG, new ViewGroup.LayoutParams(-1, -1));
        ((com.opos.mobad.ad.f.a) this.j.h()).a(activity);
    }

    @Override // com.opos.mobad.q.j, com.opos.mobad.ad.k
    public void a(List<String> list) {
        a(q(), list);
    }

    @Override // com.opos.mobad.q.j, com.opos.mobad.ad.b
    public void b() {
        super.b();
        com.opos.mobad.g.a.a.p<com.opos.mobad.ad.f.a> pVar = this.j;
        if (pVar != null) {
            pVar.b();
        }
        r();
    }

    @Override // com.opos.mobad.ad.i.a, com.opos.mobad.ad.i
    public void b(int i) {
        if (com.opos.mobad.c.b.a().b(this.b) && c() == 2 && !this.l) {
            this.l = true;
            com.opos.mobad.c.b.f().a(this.b, this.c, this.j.i(), f(), i);
        }
    }

    @Override // com.opos.mobad.q.j
    protected boolean b(String str, int i) {
        return b(str, i, (List<String>) null);
    }

    @Override // com.opos.mobad.q.j
    protected boolean b(String str, int i, List<String> list) {
        return b(str, i, list, "");
    }

    @Override // com.opos.mobad.q.j
    protected boolean b(String str, int i, List<String> list, String str2) {
        d("doload");
        if (TextUtils.isEmpty(str)) {
            d("error request Id:" + str);
            d(10701, "show error, please reload");
            return true;
        }
        this.l = false;
        this.m = false;
        this.c = str;
        this.n = list;
        this.j.a(str, i, list, str2);
        return true;
    }

    @Override // com.opos.mobad.ad.i.a, com.opos.mobad.ad.i
    public void c(int i) {
        com.opos.mobad.ad.b bVarH;
        if ((com.opos.mobad.c.b.a().b(this.b) || this.n != null) && (bVarH = this.j.h()) != null) {
            bVarH.c(i);
        }
    }

    @Override // com.opos.mobad.q.j
    protected boolean c(String str) {
        return false;
    }

    public void d(String str) {
        com.opos.cmn.an.f.a.b("HostSplashAdDelegator", str);
    }

    @Override // com.opos.mobad.q.j, com.opos.mobad.ad.b
    public boolean d() {
        com.opos.mobad.ad.b bVarH = this.j.h();
        if (bVarH != null) {
            return bVarH.d();
        }
        return false;
    }

    @Override // com.opos.mobad.ad.i.a, com.opos.mobad.ad.i
    public int f() {
        int iA;
        if (com.opos.mobad.c.b.a().b(this.b)) {
            iA = h.a(this.j.i(), this.j.h(), this.j.j());
        } else {
            com.opos.cmn.an.f.a.b("HostSplashAdDelegator", "isBiddingOutEnable:false");
            iA = IBidding.ECPM_PRICE_STATUS_BIDDING_OUT_DISABLE;
        }
        com.opos.mobad.c.b.f().a(this.b, this.c, iA, this.j.i());
        return iA;
    }

    @Override // com.opos.mobad.ad.f.b
    public View g() {
        if (c() != 2) {
            return null;
        }
        p();
        return this.d;
    }

    @Override // com.opos.mobad.q.i, com.opos.mobad.ad.f.b
    public void h() {
        d("zoomOutAnimationStart");
        if (!this.m) {
            d("zoomOutAnimationStart but not dismiss");
            return;
        }
        RelativeLayout relativeLayout = this.d;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(4);
        }
    }

    @Override // com.opos.mobad.q.i, com.opos.mobad.ad.f.b
    public void i() {
        d("zoomOutAnimationFinish");
        com.opos.mobad.ad.f.b bVar = (com.opos.mobad.ad.f.b) this.j.h();
        if (bVar != null) {
            bVar.i();
        }
    }

    @Override // com.opos.mobad.q.i, com.opos.mobad.ad.f.b
    public View j() {
        com.opos.mobad.ad.f.b bVar = (com.opos.mobad.ad.f.b) this.j.h();
        if (bVar == null) {
            return null;
        }
        return bVar.j();
    }

    @Override // com.opos.mobad.q.i, com.opos.mobad.ad.f.b
    public boolean k() {
        com.opos.mobad.ad.f.b bVar = (com.opos.mobad.ad.f.b) this.j.h();
        if (bVar == null) {
            return false;
        }
        return bVar.k();
    }
}
