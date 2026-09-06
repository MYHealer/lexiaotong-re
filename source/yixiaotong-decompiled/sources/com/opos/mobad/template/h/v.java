package com.opos.mobad.template.h;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import com.stub.StubApp;
import java.util.Map;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class v extends com.opos.mobad.template.j.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    com.opos.mobad.template.cmn.p f8131a;
    private com.opos.mobad.template.cmn.baseview.c b;
    private Context f;
    private com.opos.mobad.d.d.a g;
    private com.opos.mobad.d.a h;
    private com.opos.mobad.template.d.c i;
    private a j;
    private int k;
    private boolean l;
    private com.opos.mobad.d.e.a m;
    private boolean n;
    private int o;
    private com.opos.mobad.template.e.c.a p;
    private boolean q;
    private com.opos.mobad.template.cmn.p r;
    private com.opos.mobad.template.cmn.p s;
    private com.opos.mobad.template.cmn.q t;
    private com.opos.mobad.template.cmn.baseview.f u;
    private com.opos.mobad.template.cmn.p v;
    private com.opos.mobad.d.d.b w;
    private com.opos.mobad.template.cmn.j.b x;

    private v(Context context, int i, int i2, boolean z, com.opos.mobad.d.d.a aVar, com.opos.mobad.d.a aVar2) {
        super(i);
        this.o = 0;
        this.q = false;
        this.f8131a = new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.h.v.7
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                v.this.h(view, iArr);
            }
        };
        this.r = new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.h.v.8
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                v.this.h(view, iArr);
            }
        };
        this.s = new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.h.v.9
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                v.this.i(view, iArr);
            }
        };
        this.t = new com.opos.mobad.template.cmn.q() { // from class: com.opos.mobad.template.h.v.10
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                v.this.g(view, iArr);
            }
        };
        this.u = new com.opos.mobad.template.cmn.baseview.f() { // from class: com.opos.mobad.template.h.v.11
            @Override // com.opos.mobad.template.cmn.baseview.f
            public void a(View view, int i3, boolean z2) {
                com.opos.cmn.an.f.a.a("RewardOPTVideoTemplate", "onMockEventIntercepted->clickMockEvent:" + i3 + ";disAllowClick:" + z2 + ";view:" + view.getClass().getName());
                v.this.a(view, i3, z2);
            }
        };
        this.v = new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.h.v.12
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                v.this.a(view, iArr);
            }
        };
        this.w = new com.opos.mobad.d.d.b() { // from class: com.opos.mobad.template.h.v.13
            @Override // com.opos.mobad.d.d.b
            public void a(Map<String, String> map) {
                if (v.this.r()) {
                    return;
                }
                v.this.c(map);
            }

            @Override // com.opos.mobad.d.d.b
            public void c() {
                if (v.this.r()) {
                    return;
                }
                v.this.a(new Callable() { // from class: com.opos.mobad.template.h.v.13.1
                    @Override // java.util.concurrent.Callable
                    public Object call() throws Exception {
                        v.this.s();
                        return true;
                    }
                });
            }

            @Override // com.opos.mobad.d.d.b
            public void d() {
                v vVar = v.this;
                vVar.c(0L, vVar.g.c());
                v.this.j.a(com.opos.mobad.template.cmn.t.START);
            }

            @Override // com.opos.mobad.d.d.b
            public void e() {
                v.this.l = true;
                v.this.o();
                v.this.j.a(com.opos.mobad.template.cmn.t.COMPLETE);
                if (v.this.p == null || !v.this.p.e()) {
                    return;
                }
                if (!(v.this.p instanceof com.opos.mobad.template.e.c.d)) {
                    if (!(v.this.p instanceof com.opos.mobad.template.e.c.e) || v.this.p.c() == null || v.this.p.c().getVisibility() == 8) {
                        return;
                    }
                    v.this.p.c().setVisibility(8);
                    return;
                }
                if (v.this.i.J.containsKey("EXT_PARAM_KEY_SHOW_ENDPAGE")) {
                    String str = v.this.i.J.get("EXT_PARAM_KEY_SHOW_ENDPAGE");
                    if (TextUtils.isEmpty(str) || !"1".equals(str)) {
                        return;
                    }
                    v.this.p.f();
                }
            }

            @Override // com.opos.mobad.d.d.b
            public void f() {
                if (v.this.r()) {
                    return;
                }
                v.this.j.a(com.opos.mobad.template.cmn.t.RESUME);
                if (v.this.g != null) {
                    v vVar = v.this;
                    vVar.b(vVar.g.d(), v.this.g.c());
                }
            }

            @Override // com.opos.mobad.d.d.b
            public void g() {
                if (v.this.r()) {
                    return;
                }
                v.this.j.a(com.opos.mobad.template.cmn.t.PAUSE);
                if (v.this.g != null) {
                    v vVar = v.this;
                    vVar.a(vVar.g.d(), v.this.g.c());
                }
            }

            @Override // com.opos.mobad.d.d.b
            public void h() {
                if (v.this.r()) {
                    return;
                }
                v.this.j.a(com.opos.mobad.template.cmn.t.BUFFERINGSTART);
            }

            @Override // com.opos.mobad.d.d.b
            public void i() {
                if (v.this.r()) {
                    return;
                }
                v.this.j.a(com.opos.mobad.template.cmn.t.BUFFERINGEND);
            }

            @Override // com.opos.mobad.d.d.b
            public void j() {
                if (v.this.r()) {
                    return;
                }
                v.this.j.a(com.opos.mobad.template.cmn.t.RENDERFIRSTFRAME);
            }
        };
        this.x = new com.opos.mobad.template.cmn.j.b() { // from class: com.opos.mobad.template.h.v.4
            @Override // com.opos.mobad.template.cmn.j.b
            public boolean a() {
                return v.this.r();
            }
        };
        this.f = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.k = i2;
        this.n = z;
        this.g = aVar;
        this.h = aVar2;
        if (aVar != null) {
            aVar.a(this.w);
        }
        p();
    }

    public static com.opos.mobad.template.a a(Context context, int i, com.opos.mobad.d.d.a aVar, com.opos.mobad.d.a aVar2) {
        if (context == null) {
            return null;
        }
        return new v(context, i, 0, true, aVar, aVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final Bitmap bitmap) {
        com.opos.mobad.d.c.c.c(new Runnable() { // from class: com.opos.mobad.template.h.v.6
            @Override // java.lang.Runnable
            public void run() {
                if (v.this.r()) {
                    return;
                }
                v.this.j.a(bitmap);
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:39:0x00e1  */
    private void a(com.opos.mobad.template.d.b bVar) {
        Context context;
        float f;
        RelativeLayout.LayoutParams layoutParams;
        if (!this.q) {
            com.opos.mobad.template.e.c.a aVarA = com.opos.mobad.template.e.a.i.a().a(this.f, e(), bVar.L);
            this.p = aVarA;
            if (aVarA == null) {
                return;
            }
            aVarA.a(new com.opos.mobad.template.e.c.b() { // from class: com.opos.mobad.template.h.v.14
                @Override // com.opos.mobad.template.e.c.b
                public void a(int i, int[] iArr) {
                    v.this.i().a(i, iArr);
                }

                @Override // com.opos.mobad.template.e.c.b
                public void a(View view, int[] iArr) {
                    v.this.i().h(view, iArr);
                }

                @Override // com.opos.mobad.template.e.c.b
                public void a(int[] iArr) {
                    v.this.i().b(iArr);
                }

                @Override // com.opos.mobad.template.cmn.p
                public void b(View view, int[] iArr) {
                    v.this.i().g(view, iArr);
                }

                @Override // com.opos.mobad.template.c
                public void b(int[] iArr) {
                    v.this.i().a(iArr);
                }
            });
            com.opos.mobad.template.e.c.a aVar = this.p;
            if (aVar instanceof com.opos.mobad.template.e.c.e) {
                aVar.a(this.u);
                if (this.n) {
                    layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(13);
                } else {
                    int iB = com.opos.cmn.an.h.f.a.b(this.f);
                    if (iB > 0) {
                        layoutParams = new RelativeLayout.LayoutParams(-2, iB - com.opos.cmn.an.h.f.a.a(this.f, 80.0f));
                    } else {
                        layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.f, 14.0f);
                    }
                    layoutParams.addRule(14);
                }
                if (this.p.e() && this.p.c() != null) {
                    this.b.addView(this.p.c(), layoutParams);
                }
            } else if (aVar instanceof com.opos.mobad.template.e.c.d) {
                View view = new View(this.f);
                view.setId(View.generateViewId());
                int iA = 0;
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, 0);
                layoutParams2.addRule(12);
                this.b.addView(view, layoutParams2);
                RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.f, 46.0f));
                int i = this.k;
                if (i == 0) {
                    iA = com.opos.cmn.an.h.f.a.a(this.f, 209.0f);
                } else {
                    if (i != 1) {
                        if (i == 2) {
                            context = this.f;
                            f = 92.0f;
                        } else if (i == 3 || i == 7) {
                            context = this.f;
                            f = 30.0f;
                        }
                    } else if (com.opos.mobad.template.h.a(bVar)) {
                        context = this.f;
                        f = 268.0f;
                    } else {
                        iA = com.opos.cmn.an.h.f.a.a(this.f, 209.0f);
                    }
                    iA = com.opos.cmn.an.h.f.a.a(context, f);
                }
                layoutParams3.bottomMargin = iA;
                if (this.p.e() && this.p.c() != null) {
                    layoutParams3.addRule(14);
                    layoutParams3.addRule(2, view.getId());
                    this.b.addView(this.p.c(), layoutParams3);
                }
            }
            this.q = true;
        }
        com.opos.mobad.template.e.c.a aVar2 = this.p;
        if (aVar2 != null) {
            aVar2.a(com.opos.mobad.template.e.b.a.a(bVar));
        }
    }

    private void a(com.opos.mobad.template.d.c cVar) {
        if (cVar != null) {
            this.j.a(cVar);
            b(cVar);
            a((com.opos.mobad.template.d.b) cVar);
        }
    }

    public static com.opos.mobad.template.a b(Context context, int i, com.opos.mobad.d.d.a aVar, com.opos.mobad.d.a aVar2) {
        if (context == null) {
            return null;
        }
        return new v(context, i, 1, true, aVar, aVar2);
    }

    private void b(com.opos.mobad.template.d.c cVar) {
        if (this.h == null || cVar == null || cVar.k == null || TextUtils.isEmpty(cVar.k.f7535a)) {
            a((Bitmap) null);
        } else {
            int iA = com.opos.cmn.an.h.f.a.a(this.f, 42.0f);
            com.opos.mobad.template.cmn.j.a(cVar.k.f7535a, cVar.k.b, iA, iA, this.h, new com.opos.mobad.template.cmn.j.c() { // from class: com.opos.mobad.template.h.v.5
                @Override // com.opos.mobad.template.cmn.j.c
                public void a(int i) {
                    if (i != 1) {
                        v.this.a((Bitmap) null);
                    }
                    v.this.b(i);
                }

                @Override // com.opos.mobad.template.cmn.j.c
                public void a(Bitmap bitmap) {
                    v.this.a(bitmap);
                }
            }, this.x);
        }
    }

    public static com.opos.mobad.template.a c(Context context, int i, com.opos.mobad.d.d.a aVar, com.opos.mobad.d.a aVar2) {
        if (context == null) {
            return null;
        }
        return new v(context, i, 2, false, aVar, aVar2);
    }

    private a c(int i) {
        switch (i) {
            case 0:
                return new z(this.f, this.h, this.g, true);
            case 1:
                return new z(this.f, this.h, this.g, false);
            case 2:
                return new y(this.f, this.h, this.g, true);
            case 3:
                return new y(this.f, this.h, this.g, false);
            case 4:
                return new z(this.f, this.h, this.g, true, 1);
            case 5:
                return new z(this.f, this.h, this.g, false, 1);
            case 6:
            case 10:
            case 11:
            default:
                return new z(this.f, this.h, this.g, true);
            case 7:
                return new y(this.f, this.h, this.g, false, 1);
            case 8:
                return new z(this.f, this.h, this.g, true, 2);
            case 9:
                return new z(this.f, this.h, this.g, false, 2);
            case 12:
                return new z(this.f, this.h, this.g, true, 3);
        }
    }

    static /* synthetic */ int d(v vVar) {
        int i = vVar.o;
        vVar.o = i + 1;
        return i;
    }

    public static com.opos.mobad.template.a d(Context context, int i, com.opos.mobad.d.d.a aVar, com.opos.mobad.d.a aVar2) {
        if (context == null) {
            return null;
        }
        return new v(context, i, 3, false, aVar, aVar2);
    }

    public static com.opos.mobad.template.a e(Context context, int i, com.opos.mobad.d.d.a aVar, com.opos.mobad.d.a aVar2) {
        if (context == null) {
            return null;
        }
        return new v(context, i, 4, true, aVar, aVar2);
    }

    public static com.opos.mobad.template.a f(Context context, int i, com.opos.mobad.d.d.a aVar, com.opos.mobad.d.a aVar2) {
        if (context == null) {
            return null;
        }
        return new v(context, i, 5, true, aVar, aVar2);
    }

    public static com.opos.mobad.template.a g(Context context, int i, com.opos.mobad.d.d.a aVar, com.opos.mobad.d.a aVar2) {
        if (context == null) {
            return null;
        }
        return new v(context, i, 7, false, aVar, aVar2);
    }

    public static com.opos.mobad.template.a h(Context context, int i, com.opos.mobad.d.d.a aVar, com.opos.mobad.d.a aVar2) {
        if (context == null) {
            return null;
        }
        return new v(context, i, 8, true, aVar, aVar2);
    }

    public static com.opos.mobad.template.a i(Context context, int i, com.opos.mobad.d.d.a aVar, com.opos.mobad.d.a aVar2) {
        if (context == null) {
            return null;
        }
        return new v(context, i, 9, true, aVar, aVar2);
    }

    public static com.opos.mobad.template.a j(Context context, int i, com.opos.mobad.d.d.a aVar, com.opos.mobad.d.a aVar2) {
        if (context == null) {
            return null;
        }
        return new v(context, i, 12, true, aVar, aVar2);
    }

    private void p() {
        com.opos.mobad.template.cmn.baseview.c cVar = new com.opos.mobad.template.cmn.baseview.c(this.f);
        this.b = cVar;
        cVar.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        a aVarC = c(this.k);
        this.j = aVarC;
        this.b.addView(aVarC.a());
        q();
        if (Build.VERSION.SDK_INT >= 29) {
            this.b.setForceDarkAllowed(false);
        }
    }

    private void q() {
        this.j.a(this.r).b(this.s).a(this.t).b_(this.u).c(this.v).a(new a.InterfaceC1020a() { // from class: com.opos.mobad.template.h.v.1
            @Override // com.opos.mobad.template.h.a.InterfaceC1020a
            public void a(long j, long j2) {
                if (v.this.r()) {
                    return;
                }
                v.this.c(j, j2);
                if (v.this.p == null || !(v.this.p instanceof com.opos.mobad.template.e.c.e)) {
                    return;
                }
                if (v.this.o == 3 && v.this.p.e() && v.this.p.c() != null && v.this.p.c().getVisibility() != 0) {
                    v.this.p.c().setVisibility(0);
                }
                if (v.this.o == 13 && v.this.p.e() && v.this.p.c() != null && v.this.p.c().getVisibility() != 8) {
                    v.this.p.c().setVisibility(8);
                }
                v.d(v.this);
            }
        });
        com.opos.mobad.template.cmn.p.a(this.b, this.f8131a);
        this.b.a(this.u);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean r() {
        return n() == 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        if (this.m == null) {
            com.opos.mobad.d.e.a aVar = new com.opos.mobad.d.e.a(this.f);
            this.m = aVar;
            aVar.a(new com.opos.mobad.d.e.a.InterfaceC0958a() { // from class: com.opos.mobad.template.h.v.2
                @Override // com.opos.mobad.d.e.a.InterfaceC0958a
                public void a(boolean z) {
                    if (v.this.i == null) {
                        return;
                    }
                    if (!z) {
                        v.this.l();
                        return;
                    }
                    v.this.a(v.this.k == 1 ? com.opos.mobad.template.h.a(v.this.p, v.this.i) : com.opos.mobad.template.h.a(v.this.p));
                    v.this.k();
                    if (v.this.p == null || !(v.this.p instanceof com.opos.mobad.template.e.c.d) || v.this.p.c() == null || !v.this.p.e() || v.this.p.c().getVisibility() == 0) {
                        return;
                    }
                    v.this.p.c().setVisibility(0);
                }
            });
            this.m.a(new com.opos.mobad.d.e.a.c() { // from class: com.opos.mobad.template.h.v.3
                @Override // com.opos.mobad.d.e.a.c
                public void a(boolean z, boolean z2) {
                    com.opos.cmn.an.f.a.b("RewardOPTVideoTemplate", "onViewVisibleWithoutFocus: " + z + ", " + z2);
                    if (v.this.i == null) {
                        return;
                    }
                    Map<String, String> mapA = com.opos.mobad.template.h.a(v.this.p);
                    mapA.put("isVisibleRect", String.valueOf(z));
                    mapA.put("isAttached", String.valueOf(z2));
                    v.this.b(mapA);
                }
            }, c());
        }
        if (this.b.indexOfChild(this.m) < 0) {
            this.b.addView(this.m, new RelativeLayout.LayoutParams(0, 0));
        }
    }

    @Override // com.opos.mobad.template.j.a, com.opos.mobad.template.a
    public void a(com.opos.mobad.template.a.InterfaceC1003a interfaceC1003a) {
        super.a(interfaceC1003a);
        this.j.a(i());
    }

    @Override // com.opos.mobad.template.a
    public void a(com.opos.mobad.template.d.f fVar) {
        if (fVar == null) {
            com.opos.cmn.an.f.a.a("RewardOPTVideoTemplate", "data is null");
        } else {
            com.opos.mobad.template.d.c cVarB = fVar.b();
            if (cVarB != null && !TextUtils.isEmpty(cVarB.M.f7535a)) {
                a(cVarB);
                if (this.i == null) {
                    this.g.a(cVarB.M.f7535a, false);
                    this.g.a(cVarB.A == 1 ? 1.0f : 0.0f);
                }
                this.i = cVarB;
                return;
            }
            com.opos.cmn.an.f.a.d("RewardOPTVideoTemplate", "render with data null");
        }
        a(1);
    }

    @Override // com.opos.mobad.template.a
    public View c() {
        return this.b;
    }

    @Override // com.opos.mobad.template.j.a
    protected boolean f() {
        com.opos.mobad.d.d.a aVar = this.g;
        if (aVar != null) {
            if (this.l) {
                com.opos.cmn.an.f.a.b("RewardOPTVideoTemplate", "do nothing for has complete");
                return false;
            }
            aVar.g();
        }
        com.opos.mobad.template.e.c.a aVar2 = this.p;
        if (aVar2 == null || !(aVar2 instanceof com.opos.mobad.template.e.c.d)) {
            return true;
        }
        aVar2.h();
        return true;
    }

    @Override // com.opos.mobad.template.j.a
    protected boolean g() {
        com.opos.mobad.d.d.a aVar = this.g;
        if (aVar != null) {
            if (this.l) {
                com.opos.cmn.an.f.a.b("RewardOPTVideoTemplate", "do nothing for has complete");
                return false;
            }
            aVar.f();
        }
        com.opos.mobad.template.e.c.a aVar2 = this.p;
        if (aVar2 == null || !(aVar2 instanceof com.opos.mobad.template.e.c.d)) {
            return true;
        }
        aVar2.i();
        return true;
    }

    @Override // com.opos.mobad.template.j.a
    protected void h() {
        this.i = null;
        com.opos.mobad.d.d.a aVar = this.g;
        if (aVar != null) {
            aVar.f();
            this.g.h();
        }
        com.opos.mobad.template.e.c.a aVar2 = this.p;
        if (aVar2 != null) {
            aVar2.j();
        }
        com.opos.mobad.template.cmn.baseview.c cVar = this.b;
        if (cVar != null) {
            cVar.removeAllViews();
        }
    }
}
