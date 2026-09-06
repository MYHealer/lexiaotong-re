package com.opos.mobad.template.f;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.stub.StubApp;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class j implements com.opos.mobad.template.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.opos.mobad.template.a.InterfaceC1003a f7638a;
    private com.opos.mobad.d.a b;
    private int c;
    private Context d;
    private int e;
    private RelativeLayout f;
    private d g;
    private com.opos.mobad.template.d.b h;
    private boolean i;
    private com.opos.mobad.template.e.c.a k;
    private volatile boolean j = false;
    private boolean l = false;

    private j(Context context, int i, int i2, com.opos.mobad.d.a aVar) {
        if (context == null) {
            return;
        }
        this.c = i;
        this.d = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.e = i2;
        this.b = aVar;
        this.i = i2 == 1;
        f();
    }

    public static final com.opos.mobad.template.a a(Context context, int i, com.opos.mobad.d.a aVar) {
        return new j(context, i, 1, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.opos.mobad.template.d.b bVar, Bitmap bitmap) {
        d dVar = this.g;
        if (dVar != null) {
            dVar.a(bVar, bitmap);
        }
    }

    public static final com.opos.mobad.template.a b(Context context, int i, com.opos.mobad.d.a aVar) {
        return new j(context, i, 0, aVar);
    }

    private void b(com.opos.mobad.template.d.b bVar) {
        if (!this.l) {
            com.opos.mobad.template.e.c.a aVarA = com.opos.mobad.template.e.a.i.a().a(this.d, e(), bVar.L);
            this.k = aVarA;
            if (aVarA == null) {
                return;
            }
            aVarA.a(new com.opos.mobad.template.e.c.b() { // from class: com.opos.mobad.template.f.j.3
                @Override // com.opos.mobad.template.e.c.b
                public void a(int i, int[] iArr) {
                    if (j.this.f7638a != null) {
                        j.this.f7638a.a(i, iArr);
                    }
                }

                @Override // com.opos.mobad.template.e.c.b
                public void a(View view, int[] iArr) {
                    if (j.this.f7638a != null) {
                        j.this.f7638a.h(view, iArr);
                    }
                }

                @Override // com.opos.mobad.template.e.c.b
                public void a(int[] iArr) {
                    if (j.this.f7638a != null) {
                        j.this.f7638a.b(iArr);
                    }
                }

                @Override // com.opos.mobad.template.cmn.p
                public void b(View view, int[] iArr) {
                    if (j.this.f7638a != null) {
                        j.this.f7638a.g(view, iArr);
                    }
                }

                @Override // com.opos.mobad.template.c
                public void b(int[] iArr) {
                    if (j.this.f7638a != null) {
                        j.this.f7638a.a(iArr);
                    }
                }
            });
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.d, 46.0f));
            layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.d, 78.0f);
            if (this.k.e() && this.k.c() != null) {
                layoutParams.addRule(14);
                layoutParams.addRule(12);
                this.f.addView(this.k.c(), layoutParams);
            }
            this.l = true;
        }
        com.opos.mobad.template.e.c.a aVar = this.k;
        if (aVar != null) {
            aVar.a(com.opos.mobad.template.e.b.a.a(bVar));
        }
    }

    private void c(com.opos.mobad.template.d.b bVar) {
        if (bVar.c != null) {
            this.b.a(bVar.c.get(0).f7535a, bVar.c.get(0).b, new com.opos.mobad.d.a.InterfaceC0955a() { // from class: com.opos.mobad.template.f.j.6
                @Override // com.opos.mobad.d.a.InterfaceC0955a
                public void a(int i, final Bitmap bitmap) {
                    if (j.this.d == null) {
                        return;
                    }
                    if (i != 0 && i != 1) {
                        if (j.this.f7638a != null) {
                            j.this.f7638a.c(i);
                        }
                    } else {
                        if (i == 1 && j.this.f7638a != null) {
                            j.this.f7638a.c(i);
                        }
                        com.opos.mobad.d.c.c.c(new Runnable() { // from class: com.opos.mobad.template.f.j.6.1
                            @Override // java.lang.Runnable
                            public void run() {
                                Bitmap bitmap2 = bitmap;
                                if (bitmap2 == null || bitmap2.isRecycled() || j.this.g == null) {
                                    return;
                                }
                                j.this.g.a(bitmap);
                            }
                        });
                    }
                }
            });
        }
    }

    private void f() {
        this.f = new RelativeLayout(this.d);
        this.g = this.e == 1 ? new k(this.d) : new i(this.d);
        this.f.addView(this.g.a());
        this.g.a(new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.f.j.1
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                if (j.this.f7638a != null) {
                    j.this.f7638a.h(view, iArr);
                }
            }
        });
        this.g.a(new com.opos.mobad.template.cmn.baseview.f() { // from class: com.opos.mobad.template.f.j.2
            @Override // com.opos.mobad.template.cmn.baseview.f
            public void a(View view, int i, boolean z) {
                com.opos.cmn.an.f.a.a("ImageHalfScreenInterstitial", "onMockEventIntercepted->clickMockEvent:" + i + ";disAllowClick:" + z + ";view:" + view.getClass().getName());
                if (j.this.f7638a != null) {
                    j.this.f7638a.a(view, i, z);
                }
            }
        });
    }

    private boolean g() {
        return this.c == 2007;
    }

    @Override // com.opos.mobad.template.a
    public void a() {
        com.opos.mobad.template.e.c.a aVar;
        if (this.j || (aVar = this.k) == null) {
            return;
        }
        aVar.i();
    }

    public void a(ViewGroup viewGroup, final com.opos.mobad.template.a.InterfaceC1003a interfaceC1003a, final com.opos.mobad.template.e.c.a aVar) {
        if (viewGroup == null || interfaceC1003a == null) {
            return;
        }
        final com.opos.mobad.d.e.a aVar2 = new com.opos.mobad.d.e.a(viewGroup.getContext());
        aVar2.a(new com.opos.mobad.d.e.a.InterfaceC0958a() { // from class: com.opos.mobad.template.f.j.4
            @Override // com.opos.mobad.d.e.a.InterfaceC0958a
            public void a(boolean z) {
                if (z) {
                    com.opos.mobad.d.c.c.a(new Runnable() { // from class: com.opos.mobad.template.f.j.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (interfaceC1003a != null) {
                                interfaceC1003a.a(com.opos.mobad.template.h.a(aVar));
                            }
                            if (aVar == null || aVar.c() == null) {
                                return;
                            }
                            aVar.c().setVisibility(0);
                        }
                    });
                    aVar2.a((com.opos.mobad.d.e.a.InterfaceC0958a) null);
                }
            }
        });
        aVar2.a(new com.opos.mobad.d.e.a.c() { // from class: com.opos.mobad.template.f.j.5
            @Override // com.opos.mobad.d.e.a.c
            public void a(final boolean z, final boolean z2) {
                com.opos.mobad.d.c.c.a(new Runnable() { // from class: com.opos.mobad.template.f.j.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (interfaceC1003a != null) {
                            Map<String, String> mapA = com.opos.mobad.template.h.a(aVar);
                            mapA.put("isVisibleRect", String.valueOf(z));
                            mapA.put("isAttached", String.valueOf(z2));
                            interfaceC1003a.a(mapA);
                        }
                    }
                });
                aVar2.a((com.opos.mobad.d.e.a.c) null, (View) null);
            }
        }, c());
        viewGroup.addView(aVar2, 0, 0);
    }

    @Override // com.opos.mobad.template.a
    public void a(com.opos.mobad.template.a.InterfaceC1003a interfaceC1003a) {
        this.f7638a = interfaceC1003a;
    }

    public void a(final com.opos.mobad.template.d.b bVar) {
        if (this.b == null || bVar == null || bVar.k == null || TextUtils.isEmpty(bVar.k.f7535a)) {
            a(bVar, null);
        } else {
            this.b.a(bVar.k.f7535a, bVar.k.b, new com.opos.mobad.d.a.InterfaceC0955a() { // from class: com.opos.mobad.template.f.j.7
                @Override // com.opos.mobad.d.a.InterfaceC0955a
                public void a(int i, final Bitmap bitmap) {
                    if (j.this.d == null) {
                        return;
                    }
                    if (i == 0 || i == 1) {
                        if (i == 1 && j.this.f7638a != null) {
                            j.this.f7638a.c(i);
                        }
                        com.opos.mobad.d.c.c.c(new Runnable() { // from class: com.opos.mobad.template.f.j.7.1
                            @Override // java.lang.Runnable
                            public void run() {
                                Bitmap bitmap2 = bitmap;
                                if (bitmap2 == null || bitmap2.isRecycled()) {
                                    return;
                                }
                                j.this.a(bVar, bitmap);
                            }
                        });
                        return;
                    }
                    com.opos.mobad.d.c.c.c(new Runnable() { // from class: com.opos.mobad.template.f.j.7.2
                        @Override // java.lang.Runnable
                        public void run() {
                            j.this.a(bVar, null);
                        }
                    });
                    if (j.this.f7638a != null) {
                        j.this.f7638a.c(i);
                    }
                }
            });
        }
    }

    @Override // com.opos.mobad.template.a
    public void a(com.opos.mobad.template.d.f fVar) {
        com.opos.mobad.template.a.InterfaceC1003a interfaceC1003a;
        d dVar;
        com.opos.mobad.template.d.b bVarA = fVar.a();
        if (bVarA == null) {
            com.opos.cmn.an.f.a.d("ImageHalfScreenInterstitial", "render with data null");
            com.opos.mobad.template.a.InterfaceC1003a interfaceC1003a2 = this.f7638a;
            if (interfaceC1003a2 != null) {
                interfaceC1003a2.a(1);
                return;
            }
            return;
        }
        if (bVarA.c == null || bVarA.c.size() <= 0) {
            com.opos.cmn.an.f.a.d("ImageHalfScreenInterstitial", "render with imgList null");
            com.opos.mobad.template.a.InterfaceC1003a interfaceC1003a3 = this.f7638a;
            if (interfaceC1003a3 != null) {
                interfaceC1003a3.a(1);
                return;
            }
            return;
        }
        c(bVarA);
        a(bVarA);
        if (g()) {
            b(bVarA);
        }
        com.opos.mobad.template.a.InterfaceC1003a interfaceC1003a4 = this.f7638a;
        if (interfaceC1003a4 != null && (dVar = this.g) != null) {
            dVar.a(interfaceC1003a4);
        }
        if (this.h == null && (interfaceC1003a = this.f7638a) != null) {
            interfaceC1003a.e();
            a(this.f, this.f7638a, this.k);
        }
        this.h = bVarA;
    }

    @Override // com.opos.mobad.template.a
    public void b() {
        com.opos.mobad.template.e.c.a aVar;
        if (this.j || (aVar = this.k) == null) {
            return;
        }
        aVar.h();
    }

    @Override // com.opos.mobad.template.a
    public View c() {
        return this.f;
    }

    @Override // com.opos.mobad.template.a
    public void d() {
        this.j = true;
        this.d = null;
        this.h = null;
        RelativeLayout relativeLayout = this.f;
        if (relativeLayout != null) {
            relativeLayout.removeAllViews();
        }
        com.opos.mobad.template.e.c.a aVar = this.k;
        if (aVar != null) {
            aVar.j();
        }
    }

    @Override // com.opos.mobad.template.a
    public int e() {
        return this.c;
    }
}
