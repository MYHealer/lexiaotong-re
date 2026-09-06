package com.opos.mobad.template.i;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.view.ViewCompat;
import com.google.android.exoplayer2.C;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class f implements com.opos.mobad.template.a {
    private com.opos.mobad.template.e A;
    private long B;
    private j C;
    private com.opos.mobad.d.a d;
    private final Context e;
    private com.opos.mobad.template.a.a f;
    private ImageView g;
    private e h;
    private int i;
    private long k;
    private com.opos.mobad.template.d.b l;
    private int m;
    private int n;
    private com.opos.mobad.template.cmn.baseview.c o;
    private RelativeLayout p;
    private d q;
    private com.opos.mobad.template.a.InterfaceC1003a r;
    private com.opos.mobad.template.e.c.a s;
    private com.opos.mobad.template.i.b.a u;
    private ViewGroup v;
    private View w;
    private View x;
    private com.opos.mobad.template.a.b y;
    private com.opos.mobad.template.a.c z;
    private volatile int c = 0;
    private boolean t = false;
    private boolean D = false;
    private Runnable E = new Runnable() { // from class: com.opos.mobad.template.i.f.1
        @Override // java.lang.Runnable
        public void run() {
            if (f.this.c == 4) {
                return;
            }
            if (f.this.B <= 0) {
                f.this.r.d(f.this.k - f.this.B, f.this.k);
                f.this.j.a();
                f.this.a();
                f.this.C();
                return;
            }
            com.opos.cmn.an.f.a.b("LogoSplash", "countdown=" + f.this.B);
            f.this.j.a(1000L);
            if (f.this.A != null) {
                f.this.A.a((int) (f.this.B / 1000));
            }
            f.this.r.d(f.this.k - f.this.B, f.this.k);
            f.this.B -= 1000;
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    com.opos.mobad.template.cmn.j.b f8164a = new com.opos.mobad.template.cmn.j.b() { // from class: com.opos.mobad.template.i.f.14
        @Override // com.opos.mobad.template.cmn.j.b
        public boolean a() {
            return f.this.c == 4;
        }
    };
    com.opos.mobad.template.cmn.p b = new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.i.f.6
        @Override // com.opos.mobad.template.cmn.p
        public void b(View view, int[] iArr) {
            if (f.this.r != null) {
                f.this.r.g(view, iArr);
            }
        }
    };
    private com.opos.mobad.d.c.d j = new com.opos.mobad.d.c.d(com.opos.mobad.d.c.c.a(), this.E);

    /* JADX INFO: renamed from: com.opos.mobad.template.i.f$13, reason: invalid class name */
    class AnonymousClass13 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.opos.mobad.template.d.b f8169a;
        final /* synthetic */ int b;

        AnonymousClass13(com.opos.mobad.template.d.b bVar, int i) {
            this.f8169a = bVar;
            this.b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (f.this.c == 4) {
                com.opos.cmn.an.f.a.b("LogoSplash", "load ima but has destroyed");
            } else {
                com.opos.mobad.template.h.b(this.f8169a.k.f7535a, this.f8169a.k.b, com.opos.cmn.an.h.f.a.a(f.this.e, 85.0f), com.opos.cmn.an.h.f.a.a(f.this.e, 85.0f), f.this.d, new com.opos.mobad.template.b() { // from class: com.opos.mobad.template.i.f.13.1
                    @Override // com.opos.mobad.template.b
                    public void a(final Bitmap bitmap) {
                        Bitmap bitmapCreateBitmap;
                        final Bitmap bitmap2;
                        if (bitmap == null) {
                            Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(AnonymousClass13.this.b, AnonymousClass13.this.b, Bitmap.Config.ARGB_8888);
                            bitmapCreateBitmap2.eraseColor(Color.parseColor("#14000000"));
                            bitmapCreateBitmap = Bitmap.createBitmap(AnonymousClass13.this.b, AnonymousClass13.this.b, Bitmap.Config.ARGB_8888);
                            bitmapCreateBitmap.eraseColor(Color.parseColor("#33000000"));
                            bitmap2 = bitmapCreateBitmap2;
                        } else {
                            bitmapCreateBitmap = null;
                            bitmap2 = bitmap;
                        }
                        final Bitmap bitmap3 = bitmapCreateBitmap;
                        final Bitmap bitmapA = com.opos.mobad.template.cmn.f.a(f.this.e, bitmap2, 75, 0.25f, 56.0f);
                        com.opos.mobad.d.c.c.a(new Runnable() { // from class: com.opos.mobad.template.i.f.13.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                ImageView imageView;
                                Bitmap bitmap4;
                                String str;
                                if (f.this.c != 4) {
                                    f.this.f.a(f.this.A(), bitmap2, AnonymousClass13.this.f8169a.b, AnonymousClass13.this.f8169a.f7534a);
                                    f.this.f.setVisibility(0);
                                    if (bitmap == null) {
                                        imageView = f.this.g;
                                        bitmap4 = bitmap3;
                                    } else if (bitmapA == null) {
                                        str = "null blur bitmap";
                                    } else {
                                        imageView = f.this.g;
                                        bitmap4 = bitmapA;
                                    }
                                    imageView.setImageBitmap(bitmap4);
                                    return;
                                }
                                str = "load bitmap but has destroy";
                                com.opos.cmn.an.f.a.b("LogoSplash", str);
                            }
                        });
                    }
                }, f.this.r);
            }
        }
    }

    /* JADX INFO: renamed from: com.opos.mobad.template.i.f$4, reason: invalid class name */
    class AnonymousClass4 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.opos.mobad.template.d.b f8176a;

        AnonymousClass4(com.opos.mobad.template.d.b bVar) {
            this.f8176a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (f.this.c == 4) {
                com.opos.cmn.an.f.a.b("LogoSplash", "load ima but has destroyed");
            } else if (this.f8176a.c.get(0) == null) {
                com.opos.cmn.an.f.a.b("LogoSplash", "null imgList");
            } else {
                com.opos.mobad.template.h.a(this.f8176a.c.get(0).f7535a, this.f8176a.c.get(0).b, com.opos.cmn.an.h.f.a.b(f.this.e), f.this.i, f.this.d, new com.opos.mobad.template.b() { // from class: com.opos.mobad.template.i.f.4.1
                    @Override // com.opos.mobad.template.b
                    public void a(final Bitmap bitmap) {
                        if (bitmap == null) {
                            com.opos.cmn.an.f.a.b("LogoSplash", "null bitmap");
                            com.opos.mobad.template.h.a(com.opos.cmn.an.h.f.a.b(f.this.e), f.this.i, f.this.g);
                        } else {
                            final boolean zA = f.this.a(f.this.i, com.opos.cmn.an.h.f.a.b(f.this.e), bitmap.getHeight(), bitmap.getWidth());
                            com.opos.mobad.d.c.c.a(new Runnable() { // from class: com.opos.mobad.template.i.f.4.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (f.this.c == 4) {
                                        com.opos.cmn.an.f.a.b("LogoSplash", "load ima but has destroyed");
                                        return;
                                    }
                                    if (zA) {
                                        f.this.g.setScaleType(ImageView.ScaleType.MATRIX);
                                    }
                                    f.this.g.setImageBitmap(bitmap);
                                }
                            });
                        }
                    }
                }, f.this.r);
            }
        }
    }

    private f(Context context, int i, int i2, j jVar, com.opos.mobad.d.a aVar) {
        this.C = j.NONE;
        this.e = context;
        this.C = a(jVar);
        this.n = i2;
        this.m = i;
        this.d = aVar;
        g();
        f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int A() {
        return F() ? 1 : 0;
    }

    private void B() {
        this.p.setVisibility(0);
        u();
        this.w.setVisibility(0);
        this.x.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C() {
        if (D()) {
            com.opos.cmn.an.f.a.b("LogoSplash", "handleAdClosed");
            com.opos.mobad.template.a.InterfaceC1003a interfaceC1003a = this.r;
            if (interfaceC1003a != null) {
                long j = this.k;
                interfaceC1003a.a(j, j);
            }
        }
    }

    private boolean D() {
        View viewC = c();
        return viewC != null && viewC.isShown();
    }

    private boolean E() {
        int i = this.n;
        return i == 1 || i == 4;
    }

    private boolean F() {
        int i = this.n;
        return i == 4 || i == 3 || i == 11 || i == 12;
    }

    private boolean G() {
        int i = this.n;
        return i == 9 || i == 10;
    }

    private boolean H() {
        return this.n == 11;
    }

    private boolean I() {
        return E() || G() || H();
    }

    private boolean J() {
        int i = this.n;
        return i == 11 || i == 12 || i == 10 || i == 9 || i == 4 || i == 5 || i == 0 || i == 3 || i == 1;
    }

    private boolean K() {
        return this.n == 5 || G() || H() || this.n == 12;
    }

    public static f a(Context context, int i, j jVar, com.opos.mobad.d.a aVar) {
        return new f(context, i, 1, jVar, aVar);
    }

    private j a(j jVar) {
        Sensor defaultSensor;
        if (jVar == j.NONE) {
            return jVar;
        }
        if (!com.opos.mobad.template.h.a()) {
            return j.NONE;
        }
        if (jVar != j.SHAKE) {
            return jVar;
        }
        try {
            defaultSensor = ((SensorManager) this.e.getSystemService("sensor")).getDefaultSensor(1);
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.b("LogoSplash", "check", th);
            defaultSensor = null;
        }
        return defaultSensor == null ? j.NONE : jVar;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0077  */
    private void a(com.opos.mobad.template.d.b bVar) {
        int iA;
        if (!this.t) {
            com.opos.mobad.template.e.c.a aVarA = com.opos.mobad.template.e.a.i.a().a(this.e, e(), bVar.L);
            this.s = aVarA;
            if (aVarA == null) {
                return;
            }
            aVarA.a(new com.opos.mobad.template.e.c.b() { // from class: com.opos.mobad.template.i.f.12
                @Override // com.opos.mobad.template.e.c.b
                public void a(int i, int[] iArr) {
                    if (f.this.r != null) {
                        f.this.r.a(i, iArr);
                    }
                }

                @Override // com.opos.mobad.template.e.c.b
                public void a(View view, int[] iArr) {
                    if (f.this.r != null) {
                        f.this.r.h(view, iArr);
                    }
                    f.this.p();
                }

                @Override // com.opos.mobad.template.e.c.b
                public void a(int[] iArr) {
                    if (f.this.r != null) {
                        f.this.r.b(iArr);
                    }
                }

                @Override // com.opos.mobad.template.cmn.p
                public void b(View view, int[] iArr) {
                    if (f.this.r != null) {
                        f.this.r.g(view, iArr);
                    }
                }

                @Override // com.opos.mobad.template.c
                public void b(int[] iArr) {
                    if (f.this.r != null) {
                        f.this.r.a(iArr);
                    }
                }
            });
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(13);
            layoutParams.addRule(14);
            com.opos.mobad.template.e.c.a aVar = this.s;
            if (aVar instanceof com.opos.mobad.template.e.c.c.c) {
                layoutParams.addRule(12);
            } else {
                if (aVar instanceof com.opos.mobad.template.e.c.c.g) {
                    if (com.opos.mobad.template.i.a.a.d(this.m)) {
                        ((com.opos.mobad.template.e.c.c.g) this.s).a(com.opos.mobad.template.i.a.a.a(J(), this.n));
                    }
                    if (com.opos.mobad.template.i.a.a.c(this.m)) {
                        layoutParams.addRule(12);
                        iA = com.opos.cmn.an.h.f.a.a(this.e, com.opos.mobad.template.i.a.a.b(this.n));
                    } else {
                        layoutParams.addRule(2, this.u.getId());
                        iA = com.opos.cmn.an.h.f.a.a(this.e, 12.0f);
                    }
                } else {
                    layoutParams.addRule(2, this.u.getId());
                    iA = com.opos.cmn.an.h.f.a.a(this.e, 12.0f);
                }
                layoutParams.bottomMargin = iA;
            }
            if (this.p != null && this.s.c() != null) {
                this.p.addView(this.s.c(), layoutParams);
            }
            if (this.s.e()) {
                com.opos.mobad.template.e.c.a aVar2 = this.s;
                if ((aVar2 instanceof com.opos.mobad.template.e.c.c.d) && this.m == 59) {
                    this.u.a(aVar2);
                }
            }
            View viewA = this.q.a();
            if (viewA != null) {
                viewA.setVisibility(8);
                this.p.removeView(viewA);
            }
            this.t = true;
        }
        com.opos.mobad.template.e.c.a aVar3 = this.s;
        if (aVar3 != null) {
            aVar3.a(com.opos.mobad.template.e.b.a.a(bVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i, int i2, int i3, int i4) {
        return i * i4 < i2 * i3;
    }

    public static f b(Context context, int i, j jVar, com.opos.mobad.d.a aVar) {
        return new f(context, i, 4, jVar, aVar);
    }

    private void b(com.opos.mobad.template.d.b bVar) {
        com.opos.mobad.template.e.c.a aVar = this.s;
        if (aVar != null) {
            this.u.a(com.opos.mobad.template.i.a.a.a(bVar, aVar.e()));
        } else {
            this.u.setVisibility(4);
        }
    }

    public static f c(Context context, int i, j jVar, com.opos.mobad.d.a aVar) {
        return new f(context, i, 0, jVar, aVar);
    }

    private void c(com.opos.mobad.template.d.b bVar) {
        ViewGroup viewGroup;
        int i;
        int i2 = this.n;
        if ((i2 == 0 || i2 == 1 || i2 == 5 || G()) && bVar.s != null) {
            View viewA = bVar.s.a();
            if (viewA == null) {
                return;
            }
            if (viewA.getParent() != null) {
                ((ViewGroup) viewA.getParent()).removeView(viewA);
            }
            this.v.addView(viewA);
            viewGroup = this.v;
            i = 0;
        } else {
            viewGroup = this.v;
            i = 8;
        }
        viewGroup.setVisibility(i);
    }

    public static f d(Context context, int i, j jVar, com.opos.mobad.d.a aVar) {
        return new f(context, i, 2, jVar, aVar);
    }

    private void d(com.opos.mobad.template.d.b bVar) {
        if (bVar.k != null) {
            this.g.setScaleType(ImageView.ScaleType.FIT_XY);
            com.opos.cmn.an.j.b.c(new AnonymousClass13(bVar, com.opos.cmn.an.h.f.a.a(this.e, 106.0f)));
        }
    }

    public static f e(Context context, int i, j jVar, com.opos.mobad.d.a aVar) {
        return new f(context, i, 3, jVar, aVar);
    }

    private void e(final com.opos.mobad.template.d.b bVar) {
        if (bVar.k == null || TextUtils.isEmpty(bVar.k.f7535a)) {
            this.h.a(bVar, null);
        } else {
            com.opos.mobad.template.cmn.j.a(bVar.k.f7535a, bVar.k.b, this.d, new com.opos.mobad.template.cmn.j.c() { // from class: com.opos.mobad.template.i.f.2
                @Override // com.opos.mobad.template.cmn.j.c
                public void a(int i) {
                    if (f.this.c == 4) {
                        return;
                    }
                    com.opos.mobad.d.c.c.c(new Runnable() { // from class: com.opos.mobad.template.i.f.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (f.this.c == 4) {
                                return;
                            }
                            f.this.h.a(bVar, null);
                        }
                    });
                }

                @Override // com.opos.mobad.template.cmn.j.c
                public void a(Bitmap bitmap) {
                    f.this.h.a(bVar, bitmap);
                }
            }, this.f8164a);
        }
        if (bVar.c == null || bVar.c.isEmpty()) {
            com.opos.cmn.an.f.a.b("LogoSplash", "Image loads but resource is empty");
        } else {
            if (I()) {
                return;
            }
            com.opos.mobad.template.cmn.j.a(bVar.c.get(0).f7535a, bVar.c.get(0).b, this.d, new com.opos.mobad.template.cmn.j.c() { // from class: com.opos.mobad.template.i.f.3
                @Override // com.opos.mobad.template.cmn.j.c
                public void a(int i) {
                    if (i != 1) {
                        f.this.h.a(null);
                    }
                    f.this.r.c(i);
                }

                @Override // com.opos.mobad.template.cmn.j.c
                public void a(Bitmap bitmap) {
                    f.this.h.a(bitmap);
                }
            }, this.f8164a);
        }
    }

    public static f f(Context context, int i, j jVar, com.opos.mobad.d.a aVar) {
        return new f(context, i, 5, jVar, aVar);
    }

    private void f() {
        final com.opos.mobad.d.e.a aVar = new com.opos.mobad.d.e.a(this.e);
        aVar.a(new com.opos.mobad.d.e.a.InterfaceC0958a() { // from class: com.opos.mobad.template.i.f.7
            @Override // com.opos.mobad.d.e.a.InterfaceC0958a
            public void a(boolean z) {
                if (f.this.l == null) {
                    return;
                }
                if (z && f.this.D) {
                    f.this.q();
                } else {
                    f.this.r();
                }
                boolean z2 = true;
                if (z && f.this.c == 0) {
                    f.this.D = true;
                    f.this.b();
                    f.this.t();
                    if (f.this.r != null) {
                        f.this.r.a(com.opos.mobad.template.h.a(f.this.s));
                    }
                }
                com.opos.cmn.an.f.a.b("LogoSplash", "splashView onWindowVisibilityChanged：" + z);
                if (f.this.B > 0 && f.this.c != 3) {
                    z2 = false;
                }
                if (z && z2) {
                    f.this.C();
                    aVar.a((com.opos.mobad.d.e.a.InterfaceC0958a) null);
                }
            }
        });
        aVar.a(new com.opos.mobad.d.e.a.c() { // from class: com.opos.mobad.template.i.f.8
            @Override // com.opos.mobad.d.e.a.c
            public void a(boolean z, boolean z2) {
                if (f.this.l == null) {
                    return;
                }
                if (f.this.r != null) {
                    Map<String, String> mapA = com.opos.mobad.template.h.a(f.this.s);
                    mapA.put("isVisibleRect", String.valueOf(z));
                    mapA.put("isAttached", String.valueOf(z2));
                    f.this.r.a(mapA);
                }
                com.opos.cmn.an.f.a.b("LogoSplash", "splashView onViewVisibleWithoutFocus：" + z + ", " + z2);
                aVar.a((com.opos.mobad.d.e.a.c) null, (View) null);
            }
        }, c());
        this.o.addView(aVar, new RelativeLayout.LayoutParams(0, 0));
    }

    private void f(com.opos.mobad.template.d.b bVar) {
        this.g.setScaleType(ImageView.ScaleType.FIT_XY);
        this.i = this.v != null ? com.opos.cmn.an.h.f.a.c(this.e) - u.d(this.e) : com.opos.cmn.an.h.f.a.c(this.e);
        com.opos.cmn.an.j.b.c(new AnonymousClass4(bVar));
    }

    public static f g(Context context, int i, j jVar, com.opos.mobad.d.a aVar) {
        return new f(context, i, 10, jVar, aVar);
    }

    private void g() {
        com.opos.mobad.template.cmn.baseview.c cVar = new com.opos.mobad.template.cmn.baseview.c(this.e);
        this.o = cVar;
        cVar.setBackgroundColor(-1);
        y();
        h();
        com.opos.mobad.template.cmn.p pVar = new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.i.f.9
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                f.this.o();
                if (f.this.r != null) {
                    f.this.r.h(view, iArr);
                }
            }
        };
        this.o.setOnClickListener(pVar);
        this.o.setOnTouchListener(pVar);
        this.o.a(new com.opos.mobad.template.cmn.baseview.f() { // from class: com.opos.mobad.template.i.f.10
            @Override // com.opos.mobad.template.cmn.baseview.f
            public void a(View view, int i, boolean z) {
                com.opos.cmn.an.f.a.a("LogoSplash", "onMockEventIntercepted->clickMockEvent:" + i + ";disAllowClick:" + z + ";view:" + view.getClass().getName());
                if (f.this.r != null) {
                    f.this.r.a(view, i, z);
                }
            }
        });
        this.o.setVisibility(4);
    }

    private void g(com.opos.mobad.template.d.b bVar) {
        a(bVar);
        b(bVar);
        if (bVar.u != null) {
            if (!J()) {
                this.y.a(A(), bVar.u.f7533a, bVar.u.b);
            } else {
                if (TextUtils.isEmpty(bVar.u.f7533a) || TextUtils.isEmpty(bVar.u.b)) {
                    return;
                }
                this.z.a(bVar.u.f7533a, bVar.u.b);
                this.z.setVisibility(0);
            }
        }
        if (TextUtils.isEmpty(bVar.j)) {
            return;
        }
        this.q.a(bVar.j, bVar.D, bVar.E, null);
    }

    public static f h(Context context, int i, j jVar, com.opos.mobad.d.a aVar) {
        return new f(context, i, 9, jVar, aVar);
    }

    private void h() {
        RelativeLayout relativeLayout = new RelativeLayout(this.e);
        this.p = relativeLayout;
        relativeLayout.setBackgroundColor(-1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        ViewGroup viewGroup = this.v;
        if (viewGroup != null) {
            layoutParams.addRule(2, viewGroup.getId());
        }
        this.o.addView(this.p, layoutParams);
        if (E()) {
            j();
        } else {
            i();
        }
        k();
        x();
    }

    private void h(com.opos.mobad.template.d.b bVar) {
        Context context;
        float f;
        View viewA;
        c(bVar);
        if (E()) {
            d(bVar);
        } else if (K()) {
            e(bVar);
        } else {
            f(bVar);
        }
        g(bVar);
        if (this.w == null) {
            this.w = u.a(bVar, this.o);
        }
        bVar.t.a(new com.opos.mobad.template.e.a() { // from class: com.opos.mobad.template.i.f.5
            @Override // com.opos.mobad.template.e.a
            public void a(View view, int[] iArr) {
                if (f.this.r != null) {
                    f.this.a();
                    f.this.r.e(view, iArr);
                }
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        if (J()) {
            context = this.e;
            f = 24.0f;
        } else {
            context = this.e;
            f = 22.0f;
        }
        layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(context, f);
        layoutParams.bottomMargin = z();
        if (this.x != null) {
            return;
        }
        if (J()) {
            viewA = com.opos.mobad.template.k.c.a(this.l, this.p, layoutParams, this.d, this.r);
        } else {
            viewA = (K() || this.C == j.SLIDE_UP) ? com.opos.mobad.template.h.a(this.l, this.p, layoutParams, this.d, this.r, false) : com.opos.mobad.template.h.a(this.l, this.p, layoutParams, this.d, this.r);
        }
        this.x = viewA;
    }

    public static f i(Context context, int i, j jVar, com.opos.mobad.d.a aVar) {
        return new f(context, i, 11, jVar, aVar);
    }

    private void i() {
        e pVar;
        if (this.n == 5) {
            pVar = new m(this.e);
        } else if (G()) {
            pVar = new n(this.e, this.n);
        } else if (H()) {
            pVar = new o(this.e);
        } else {
            if (this.n != 12) {
                this.g = new ImageView(this.e);
                this.p.addView(this.g, new RelativeLayout.LayoutParams(-1, -1));
                return;
            }
            pVar = new p(this.e);
        }
        this.h = pVar;
        this.p.addView(pVar.a());
    }

    public static f j(Context context, int i, j jVar, com.opos.mobad.d.a aVar) {
        return new f(context, i, 12, jVar, aVar);
    }

    private void j() {
        this.f = new com.opos.mobad.template.a.a(this.e, 1);
        this.g = new ImageView(this.e);
        this.p.addView(this.g, new RelativeLayout.LayoutParams(-1, -1));
        this.p.addView(this.f);
    }

    private void k() {
        if (K()) {
            return;
        }
        if (J()) {
            com.opos.mobad.template.h.a(this.e, A(), this.p);
            return;
        }
        View frameLayout = new FrameLayout(this.e);
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{1711276032, ViewCompat.MEASURED_SIZE_MASK, ViewCompat.MEASURED_SIZE_MASK, 1711276032});
        gradientDrawable.setGradientType(0);
        frameLayout.setBackground(gradientDrawable);
        this.p.addView(frameLayout, new RelativeLayout.LayoutParams(-1, -1));
    }

    private void l() {
        this.q = J() ? i.b(this.e, this.C, this.n) : i.a(this.e, this.C, this.n);
        this.q.a(new c() { // from class: com.opos.mobad.template.i.f.11
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                if (f.this.r != null) {
                    f.this.r.g(view, iArr);
                }
            }

            @Override // com.opos.mobad.template.c
            public void b(int[] iArr) {
                if (f.this.r != null) {
                    f.this.r.a(iArr);
                }
            }
        });
        this.p.addView(this.q.a(), n());
    }

    private void m() {
        com.opos.mobad.template.i.b.a aVar = new com.opos.mobad.template.i.b.a(this.e);
        this.u = aVar;
        aVar.setId(View.generateViewId());
        this.u.setVisibility(4);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(13);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.e, com.opos.mobad.template.i.a.a.a(this.n));
        this.p.addView(this.u, layoutParams);
    }

    private RelativeLayout.LayoutParams n() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(13);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        int iB = com.opos.mobad.template.i.a.a.b(this.n);
        if (this.C != j.SLIDE_UP) {
            layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.e, iB);
        }
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        com.opos.mobad.template.e.c.a aVar = this.s;
        if (aVar != null) {
            aVar.d();
            p();
        } else {
            d dVar = this.q;
            if (dVar != null) {
                dVar.b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        if (this.u == null || !com.opos.mobad.template.i.a.a.f(this.m)) {
            return;
        }
        this.u.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        com.opos.mobad.template.e.c.a aVar = this.s;
        if (aVar != null) {
            aVar.h();
            return;
        }
        d dVar = this.q;
        if (dVar != null) {
            dVar.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        com.opos.mobad.template.e.c.a aVar = this.s;
        if (aVar != null) {
            aVar.i();
            return;
        }
        d dVar = this.q;
        if (dVar != null) {
            dVar.d();
        }
    }

    private void s() {
        com.opos.mobad.template.e.c.a aVar = this.s;
        if (aVar != null) {
            aVar.j();
            return;
        }
        d dVar = this.q;
        if (dVar != null) {
            dVar.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        if (this.s != null) {
            if (this.u != null && com.opos.mobad.template.i.a.a.e(this.m)) {
                this.u.g();
            }
            this.s.g();
            return;
        }
        d dVar = this.q;
        if (dVar != null) {
            dVar.c();
        }
    }

    private void u() {
        com.opos.mobad.template.e.c.a aVar = this.s;
        if (aVar == null || aVar.c() == null) {
            d dVar = this.q;
            if (dVar == null || dVar.a() == null) {
                return;
            }
            this.q.a().setVisibility(0);
            return;
        }
        boolean zE = this.s.e();
        com.opos.mobad.template.e.c.a aVar2 = this.s;
        if (aVar2 instanceof com.opos.mobad.template.e.c.c.c) {
            aVar2.c().setVisibility(0);
            com.opos.mobad.template.i.b.a aVar3 = this.u;
            if (aVar3 != null) {
                aVar3.setVisibility(8);
                return;
            }
            return;
        }
        if (aVar2 instanceof com.opos.mobad.template.e.c.c.g) {
            aVar2.c().setVisibility(0);
            if (com.opos.mobad.template.i.a.a.c(this.m)) {
                w();
                return;
            }
        } else {
            if (!zE) {
                v();
                this.s.c().setVisibility(8);
                return;
            }
            aVar2.c().setVisibility(0);
        }
        v();
    }

    private void v() {
        com.opos.mobad.template.i.b.a aVar = this.u;
        if (aVar == null) {
            return;
        }
        aVar.setVisibility(0);
        com.opos.mobad.template.cmn.p.a(this.u.a(), this.b);
    }

    private void w() {
        com.opos.mobad.template.i.b.a aVar = this.u;
        if (aVar == null) {
            return;
        }
        aVar.setVisibility(8);
    }

    private void x() {
        l();
        m();
        RelativeLayout.LayoutParams layoutParams = (A() == 0 && J()) ? new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.e, 220.0f), -2) : new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        layoutParams.bottomMargin = z();
        if (!J()) {
            com.opos.mobad.template.a.b bVar = new com.opos.mobad.template.a.b(this.e);
            this.y = bVar;
            this.p.addView(bVar, layoutParams);
        } else {
            com.opos.mobad.template.a.c cVar = new com.opos.mobad.template.a.c(this.e);
            this.z = cVar;
            cVar.setVisibility(8);
            this.p.addView(this.z, layoutParams);
        }
    }

    private void y() {
        FrameLayout frameLayout = new FrameLayout(this.e);
        this.v = frameLayout;
        frameLayout.setId(View.generateViewId());
        this.o.addView(this.v, u.c(this.e));
        this.v.setVisibility(0);
    }

    private int z() {
        int i = 15;
        switch (this.n) {
            case 0:
            case 1:
            case 4:
            case 5:
            case 9:
            case 10:
            case 11:
            case 12:
                i = 16;
                break;
            case 2:
                i = 30;
                break;
        }
        return com.opos.cmn.an.h.f.a.a(this.e, i);
    }

    @Override // com.opos.mobad.template.a
    public void a() {
        if (this.c == 2 || this.c == 4) {
            com.opos.cmn.an.f.a.b("LogoSplash", "current state has stop =" + this.c);
            return;
        }
        this.c = 2;
        this.j.a();
        r();
    }

    @Override // com.opos.mobad.template.a
    public void a(com.opos.mobad.template.a.InterfaceC1003a interfaceC1003a) {
        if (J()) {
            this.z.a(interfaceC1003a);
        } else {
            this.y.a(interfaceC1003a);
        }
        this.r = interfaceC1003a;
    }

    @Override // com.opos.mobad.template.a
    public void a(com.opos.mobad.template.d.f fVar) {
        com.opos.mobad.template.a.InterfaceC1003a interfaceC1003a;
        com.opos.mobad.template.d.b bVarA = fVar.a();
        if (bVarA == null || bVarA.t == null) {
            com.opos.cmn.an.f.a.b("LogoSplash", "adShowData is null");
            this.r.a(1);
            return;
        }
        if (I() && (bVarA.k == null || TextUtils.isEmpty(bVarA.k.f7535a))) {
            com.opos.cmn.an.f.a.b("LogoSplash", "iconUrl is null");
            this.r.a(1);
            return;
        }
        if (!I() && (bVarA.c == null || bVarA.c.size() <= 0)) {
            com.opos.cmn.an.f.a.b("LogoSplash", "imgList is null");
            this.r.a(1);
            return;
        }
        com.opos.cmn.an.f.a.b("LogoSplash", "render");
        com.opos.mobad.template.cmn.baseview.c cVar = this.o;
        if (cVar != null && cVar.getVisibility() != 0) {
            this.o.setVisibility(0);
        }
        if (this.l == null && (interfaceC1003a = this.r) != null) {
            interfaceC1003a.e();
        }
        this.A = bVarA.t;
        long j = bVarA.v;
        this.k = j;
        if (j <= 0) {
            this.k = C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS;
        }
        if (this.l == null) {
            this.B = this.k;
        }
        this.l = bVarA;
        h(bVarA);
    }

    @Override // com.opos.mobad.template.a
    public void b() {
        B();
        com.opos.cmn.an.f.a.b("LogoSplash", "start countdown...");
        if (this.c == 1 || this.c == 4) {
            com.opos.cmn.an.f.a.b("LogoSplash", "error state" + this.c);
            return;
        }
        this.c = 1;
        this.j.a(0L);
        q();
    }

    @Override // com.opos.mobad.template.a
    public View c() {
        return this.o;
    }

    @Override // com.opos.mobad.template.a
    public void d() {
        com.opos.cmn.an.f.a.b("LogoSplash", "destroy");
        s();
        e eVar = this.h;
        if (eVar != null) {
            eVar.b();
        }
        a();
        this.l = null;
        this.c = 4;
        this.j.a();
        this.j.b();
    }

    @Override // com.opos.mobad.template.a
    public int e() {
        return this.m;
    }
}
