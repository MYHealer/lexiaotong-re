package com.opos.mobad.template.g;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Outline;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.RelativeLayout;
import androidx.core.graphics.ColorUtils;
import com.stub.StubApp;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class ah extends com.opos.mobad.template.j.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f7793a;
    private com.opos.mobad.d.a b;
    private com.opos.mobad.template.cmn.aa f;
    private ag g;
    private com.opos.mobad.template.d.b h;
    private int i;
    private int j;
    private am k;
    private com.opos.mobad.d.d.a l;
    private com.opos.mobad.template.d.c m;
    private int n;
    private boolean o;
    private com.opos.mobad.d.e.a p;
    private com.opos.mobad.d.d.b q;
    private com.opos.mobad.template.cmn.p r;
    private com.opos.mobad.template.cmn.p s;
    private com.opos.mobad.template.cmn.q t;
    private com.opos.mobad.template.cmn.q u;
    private com.opos.mobad.template.cmn.baseview.f v;

    private ah(Context context, int i, am amVar, int i2, com.opos.mobad.d.a aVar) {
        this(context, i, amVar, i2, null, aVar);
    }

    private ah(Context context, int i, am amVar, int i2, com.opos.mobad.d.d.a aVar, com.opos.mobad.d.a aVar2) {
        super(i2);
        this.o = false;
        this.q = new com.opos.mobad.d.d.b() { // from class: com.opos.mobad.template.g.ah.8
            @Override // com.opos.mobad.d.d.b
            public void a(Map<String, String> map) {
                if (ah.this.q()) {
                    return;
                }
                ah.this.c(map);
            }

            @Override // com.opos.mobad.d.d.b
            public void c() {
                if (ah.this.q()) {
                    return;
                }
                ah.this.a(new Callable() { // from class: com.opos.mobad.template.g.ah.8.1
                    @Override // java.util.concurrent.Callable
                    public Object call() throws Exception {
                        ah.this.p();
                        return true;
                    }
                });
                ah ahVar = ah.this;
                ahVar.c(0L, ahVar.l.c());
            }

            @Override // com.opos.mobad.d.d.b
            public void d() {
                if (ah.this.q()) {
                    return;
                }
                ah.this.g.a(com.opos.mobad.template.cmn.t.START);
            }

            @Override // com.opos.mobad.d.d.b
            public void e() {
                ah.this.o = true;
                ah.this.o();
                ah.this.g.a(com.opos.mobad.template.cmn.t.COMPLETE);
            }

            @Override // com.opos.mobad.d.d.b
            public void f() {
                if (ah.this.q()) {
                    return;
                }
                ah.this.g.a(com.opos.mobad.template.cmn.t.RESUME);
                if (ah.this.l != null) {
                    ah ahVar = ah.this;
                    ahVar.b(ahVar.l.d(), ah.this.l.c());
                }
            }

            @Override // com.opos.mobad.d.d.b
            public void g() {
                if (ah.this.q()) {
                    return;
                }
                ah.this.g.a(com.opos.mobad.template.cmn.t.PAUSE);
                if (ah.this.l != null) {
                    ah ahVar = ah.this;
                    ahVar.a(ahVar.l.d(), ah.this.l.c());
                }
            }

            @Override // com.opos.mobad.d.d.b
            public void h() {
                if (ah.this.q()) {
                    return;
                }
                ah.this.g.a(com.opos.mobad.template.cmn.t.BUFFERINGSTART);
            }

            @Override // com.opos.mobad.d.d.b
            public void i() {
                if (ah.this.q()) {
                    return;
                }
                ah.this.g.a(com.opos.mobad.template.cmn.t.BUFFERINGEND);
            }

            @Override // com.opos.mobad.d.d.b
            public void j() {
            }
        };
        this.r = new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.g.ah.14
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                if (ah.this.q()) {
                    return;
                }
                ah.this.a(view, iArr);
            }
        };
        this.s = new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.g.ah.15
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                ah.this.i(view, iArr);
            }
        };
        this.t = new com.opos.mobad.template.cmn.q() { // from class: com.opos.mobad.template.g.ah.2
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                ah.this.g(view, iArr);
            }
        };
        this.u = new com.opos.mobad.template.cmn.q() { // from class: com.opos.mobad.template.g.ah.3
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                ah.this.h(view, iArr);
            }
        };
        this.v = new com.opos.mobad.template.cmn.baseview.f() { // from class: com.opos.mobad.template.g.ah.4
            @Override // com.opos.mobad.template.cmn.baseview.f
            public void a(View view, int i3, boolean z) {
                com.opos.cmn.an.f.a.a("BottomLeftImg1Template", "onMockEventIntercepted->clickMockEvent:" + i3 + ";disAllowClick:" + z + ";view:" + view.getClass().getName());
                ah.this.a(view, i3, z);
            }
        };
        if (context == null) {
            return;
        }
        this.f7793a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.n = i;
        this.l = aVar;
        if (aVar != null) {
            aVar.a(this.q);
        }
        this.b = aVar2;
        this.k = amVar;
        c(i2);
    }

    public static com.opos.mobad.template.a a(Context context, am amVar, int i, com.opos.mobad.d.a aVar) {
        return new ah(context, 2, amVar, i, aVar);
    }

    public static com.opos.mobad.template.a a(Context context, am amVar, int i, com.opos.mobad.d.d.a aVar, com.opos.mobad.d.a aVar2) {
        return new ah(context, 1, amVar, i, aVar, aVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final Bitmap bitmap) {
        com.opos.mobad.d.c.c.c(new Runnable() { // from class: com.opos.mobad.template.g.ah.7
            @Override // java.lang.Runnable
            public void run() {
                if (ah.this.g == null || ah.this.q()) {
                    return;
                }
                ah.this.g.b(bitmap);
            }
        });
    }

    private void a(com.opos.mobad.template.d.b bVar) {
        if (bVar != null && bVar.c != null) {
            this.b.a(bVar.c.get(0).f7535a, bVar.c.get(0).b, new com.opos.mobad.d.a.InterfaceC0955a() { // from class: com.opos.mobad.template.g.ah.5
                @Override // com.opos.mobad.d.a.InterfaceC0955a
                public void a(int i, final Bitmap bitmap) {
                    if (ah.this.q()) {
                        com.opos.cmn.an.f.a.d("BottomLeftImg1Template", "state end");
                        return;
                    }
                    if (i != 0 && i != 1) {
                        ah.this.b(i);
                        return;
                    }
                    if (i == 1 && ah.this.d != null) {
                        ah.this.b(i);
                    }
                    com.opos.mobad.d.c.c.c(new Runnable() { // from class: com.opos.mobad.template.g.ah.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Bitmap bitmap2 = bitmap;
                            if (bitmap2 == null || bitmap2.isRecycled() || ah.this.q()) {
                                return;
                            }
                            ah.this.g.a(bitmap);
                        }
                    });
                }
            });
        }
        b(bVar);
    }

    private void b(com.opos.mobad.template.d.b bVar) {
        if (bVar != null) {
            this.g.a(this.d).a(this.r).b(this.s).a(bVar.f7534a).a(bVar.u).a(bVar).b(bVar).b(bVar.j).a(bVar.b, bVar.u);
            this.g.a(this.v);
            c(bVar);
        }
    }

    private void c(int i) {
        ag agVar;
        i();
        this.f = new com.opos.mobad.template.cmn.aa(this.f7793a, new com.opos.mobad.template.cmn.aa.a(this.k.f7821a, this.k.b, this.i / this.j));
        int i2 = this.n;
        if (i2 != 1) {
            if (i2 != 2) {
                agVar = new ag(this.f7793a, this.n, this.b, i);
            } else {
                this.i = com.opos.cmn.an.h.f.a.a(this.f7793a, 328.0f);
                agVar = new ag(this.f7793a, this.n, this.b, i);
            }
            this.g = agVar;
        } else {
            this.g = new ai(this.f7793a, this.n, this.b, this.l);
        }
        RelativeLayout relativeLayoutD = d(25);
        relativeLayoutD.addView(this.g);
        this.f.addView(relativeLayoutD);
        this.f.setVisibility(8);
        this.g.a(com.opos.cmn.an.h.f.a.a(this.f7793a, 16.0f));
        this.g.a(new ai.a() { // from class: com.opos.mobad.template.g.ah.1
            @Override // com.opos.mobad.template.g.ai.a
            public void a(long j, long j2) {
                ah.this.c(j, j2);
            }
        });
        this.f.setOnClickListener(this.u);
        this.f.setOnTouchListener(this.u);
        this.f.a(this.v);
    }

    private void c(com.opos.mobad.template.d.b bVar) {
        if (this.b == null || bVar == null || bVar.k == null || TextUtils.isEmpty(bVar.k.f7535a)) {
            a((Bitmap) null);
        } else {
            this.b.a(bVar.k.f7535a, bVar.k.b, new com.opos.mobad.d.a.InterfaceC0955a() { // from class: com.opos.mobad.template.g.ah.6
                @Override // com.opos.mobad.d.a.InterfaceC0955a
                public void a(int i, final Bitmap bitmap) {
                    if (ah.this.q()) {
                        com.opos.cmn.an.f.a.d("BottomLeftImg1Template", "state end");
                        return;
                    }
                    if (i == 0 || i == 1) {
                        if (i == 1 && ah.this.d != null) {
                            ah.this.b(i);
                        }
                        com.opos.mobad.d.c.c.c(new Runnable() { // from class: com.opos.mobad.template.g.ah.6.1
                            @Override // java.lang.Runnable
                            public void run() {
                                Bitmap bitmap2 = bitmap;
                                if (bitmap2 == null || bitmap2.isRecycled() || ah.this.q()) {
                                    return;
                                }
                                ah.this.a(bitmap);
                            }
                        });
                        return;
                    }
                    ah.this.a((Bitmap) null);
                    if (ah.this.d != null) {
                        ah.this.b(i);
                    }
                }
            });
        }
    }

    private RelativeLayout d(int i) {
        RelativeLayout relativeLayout = new RelativeLayout(this.f7793a);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        relativeLayout.setLayoutParams(layoutParams);
        relativeLayout.setBackgroundColor(ColorUtils.setAlphaComponent(-16777216, i));
        relativeLayout.setOutlineProvider(new ViewOutlineProvider() { // from class: com.opos.mobad.template.g.ah.9
            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view, Outline outline) {
                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), com.opos.cmn.an.h.f.a.a(ah.this.f7793a, 16.0f));
            }
        });
        relativeLayout.setClipToOutline(true);
        return relativeLayout;
    }

    private void i() {
        if (this.k == null) {
            int iA = com.opos.cmn.an.h.f.a.a(this.f7793a, 312.0f);
            this.k = new am(iA, (int) (((double) iA) * 0.6d));
        }
        this.i = this.k.f7821a;
        this.j = com.opos.cmn.an.h.f.a.a(this.f7793a, 218.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        if (this.p == null) {
            com.opos.mobad.d.e.a aVar = new com.opos.mobad.d.e.a(this.f7793a);
            this.p = aVar;
            aVar.a(new com.opos.mobad.d.e.a.InterfaceC0958a() { // from class: com.opos.mobad.template.g.ah.12
                @Override // com.opos.mobad.d.e.a.InterfaceC0958a
                public void a(boolean z) {
                    if (ah.this.m == null) {
                        return;
                    }
                    if (!z) {
                        ah.this.l();
                    } else {
                        ah.this.a((Map<String, String>) null);
                        ah.this.k();
                    }
                }
            });
            this.p.a(new com.opos.mobad.d.e.a.c() { // from class: com.opos.mobad.template.g.ah.13
                @Override // com.opos.mobad.d.e.a.c
                public void a(boolean z, boolean z2) {
                    if (ah.this.m == null) {
                        return;
                    }
                    HashMap map = new HashMap();
                    map.put("isVisibleRect", String.valueOf(z));
                    map.put("isAttached", String.valueOf(z2));
                    ah.this.b(map);
                }
            }, c());
        }
        if (this.f.indexOfChild(this.p) < 0) {
            this.f.addView(this.p, new RelativeLayout.LayoutParams(0, 0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean q() {
        return n() == 8;
    }

    public void a(ViewGroup viewGroup, com.opos.mobad.template.a.InterfaceC1003a interfaceC1003a) {
        if (viewGroup == null || interfaceC1003a == null) {
            return;
        }
        final com.opos.mobad.d.e.a aVar = new com.opos.mobad.d.e.a(viewGroup.getContext());
        aVar.a(new com.opos.mobad.d.e.a.InterfaceC0958a() { // from class: com.opos.mobad.template.g.ah.10
            @Override // com.opos.mobad.d.e.a.InterfaceC0958a
            public void a(boolean z) {
                com.opos.cmn.an.f.a.b("BottomLeftImg1Template", "visible change:" + z);
                if (z) {
                    ah.this.a(com.opos.mobad.template.h.a(ah.this.g.d));
                    aVar.a((com.opos.mobad.d.e.a.InterfaceC0958a) null);
                }
            }
        });
        aVar.a(new com.opos.mobad.d.e.a.c() { // from class: com.opos.mobad.template.g.ah.11
            @Override // com.opos.mobad.d.e.a.c
            public void a(boolean z, boolean z2) {
                Map<String, String> mapA = com.opos.mobad.template.h.a(ah.this.g.d);
                mapA.put("isVisibleRect", String.valueOf(z));
                mapA.put("isAttached", String.valueOf(z2));
                ah.this.b(mapA);
                aVar.a((com.opos.mobad.d.e.a.c) null, (View) null);
            }
        }, c());
        viewGroup.addView(aVar, 0, 0);
    }

    @Override // com.opos.mobad.template.j.a, com.opos.mobad.template.a
    public void a(com.opos.mobad.template.a.InterfaceC1003a interfaceC1003a) {
        super.a(interfaceC1003a);
        ag agVar = this.g;
        if (agVar != null) {
            agVar.a(interfaceC1003a);
        }
    }

    @Override // com.opos.mobad.template.a
    public void a(com.opos.mobad.template.d.f fVar) {
        com.opos.mobad.template.cmn.aa aaVar;
        String str = "BottomLeftImg1Template";
        if (fVar == null) {
            com.opos.cmn.an.f.a.b("BottomLeftImg1Template", "data is null");
        } else if (this.n == 2) {
            com.opos.mobad.template.d.b bVarA = fVar.a();
            str = "";
            if (bVarA == null) {
                com.opos.cmn.an.f.a.d(str, "render with data null");
            } else {
                if (bVarA.c != null && bVarA.c.size() > 0) {
                    a(bVarA);
                    if (this.h == null && this.d != null) {
                        m();
                        a(this.f, this.d);
                    }
                    this.h = bVarA;
                    aaVar = this.f;
                    if (aaVar != null || aaVar.getVisibility() == 0) {
                        return;
                    }
                    this.f.setVisibility(0);
                    return;
                }
                com.opos.cmn.an.f.a.d("", "render with imgList null");
            }
        } else {
            com.opos.mobad.template.d.c cVarB = fVar.b();
            if (cVarB != null && cVarB.M != null && !TextUtils.isEmpty(cVarB.M.f7535a)) {
                b(cVarB);
                if (!TextUtils.isEmpty(cVarB.M.f7535a) && this.m == null) {
                    this.l.a(cVarB.M.f7535a, false);
                    this.l.a(cVarB.A == 1 ? 1.0f : 0.0f);
                }
                this.m = cVarB;
                aaVar = this.f;
                if (aaVar != null) {
                    return;
                } else {
                    return;
                }
            }
            com.opos.cmn.an.f.a.d(str, "render with data null");
        }
        a(1);
    }

    @Override // com.opos.mobad.template.a
    public View c() {
        return this.f;
    }

    @Override // com.opos.mobad.template.j.a
    protected boolean f() {
        com.opos.mobad.d.d.a aVar = this.l;
        if (aVar == null) {
            return true;
        }
        if (this.o) {
            com.opos.cmn.an.f.a.b("BottomLeftImg1Template", "do nothing for has complete");
            return false;
        }
        aVar.g();
        return true;
    }

    @Override // com.opos.mobad.template.j.a
    protected boolean g() {
        com.opos.mobad.d.d.a aVar = this.l;
        if (aVar == null) {
            return true;
        }
        if (this.o) {
            com.opos.cmn.an.f.a.b("BottomLeftImg1Template", "do nothing for has complete");
            return false;
        }
        aVar.f();
        return true;
    }

    @Override // com.opos.mobad.template.j.a
    protected void h() {
        this.f7793a = null;
        this.h = null;
        this.m = null;
        com.opos.mobad.d.d.a aVar = this.l;
        if (aVar != null) {
            aVar.f();
            this.l.h();
        }
        com.opos.mobad.template.cmn.aa aaVar = this.f;
        if (aaVar != null) {
            aaVar.removeAllViews();
        }
    }
}
