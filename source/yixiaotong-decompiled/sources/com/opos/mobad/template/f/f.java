package com.opos.mobad.template.f;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.palette.graphics.Palette;
import com.stub.StubApp;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class f extends com.opos.mobad.template.j.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected int f7599a;
    protected int b;
    private com.opos.mobad.template.f.a.a f;
    private com.opos.mobad.template.cmn.baseview.c g;
    private RelativeLayout h;
    private ImageView i;
    private ImageView j;
    private RelativeLayout k;
    private ImageView l;
    private RelativeLayout m;
    private ImageView n;
    private View o;
    private TextView p;
    private TextView q;
    private com.opos.mobad.template.e.c.a r;
    private int s;
    private Context t;
    private com.opos.mobad.template.d.b u;
    private com.opos.mobad.d.a v;
    private com.opos.mobad.template.cmn.j.b w;
    private com.opos.mobad.template.cmn.p x;
    private com.opos.mobad.template.e.c.b y;
    private com.opos.mobad.template.cmn.baseview.f z;

    public f(Context context, int i, com.opos.mobad.d.a aVar) {
        super(i);
        this.w = new com.opos.mobad.template.cmn.j.b() { // from class: com.opos.mobad.template.f.f.8
            @Override // com.opos.mobad.template.cmn.j.b
            public boolean a() {
                return f.this.n() == 8;
            }
        };
        this.x = new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.f.f.9
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                f.this.h(view, iArr);
            }
        };
        this.y = new com.opos.mobad.template.e.c.b() { // from class: com.opos.mobad.template.f.f.10
            @Override // com.opos.mobad.template.e.c.b
            public void a(int i2, int[] iArr) {
                f.this.a(i2, iArr);
            }

            @Override // com.opos.mobad.template.e.c.b
            public void a(View view, int[] iArr) {
                f.this.h(view, iArr);
            }

            @Override // com.opos.mobad.template.e.c.b
            public void a(int[] iArr) {
                f.this.a(iArr);
            }

            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                f.this.g(view, iArr);
            }

            @Override // com.opos.mobad.template.c
            public void b(int[] iArr) {
                f.this.b(iArr);
            }
        };
        this.z = new com.opos.mobad.template.cmn.baseview.f() { // from class: com.opos.mobad.template.f.f.2
            @Override // com.opos.mobad.template.cmn.baseview.f
            public void a(View view, int i2, boolean z) {
                com.opos.cmn.an.f.a.a("ImageDynamicInters", "onMockEventIntercepted->clickMockEvent:" + i2 + ";disAllowClick:" + z + ";view:" + view.getClass().getName());
                f.this.a(view, i2, z);
            }
        };
        this.t = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.s = i;
        this.v = aVar;
        i();
    }

    public static final com.opos.mobad.template.a a(Context context, int i, com.opos.mobad.d.a aVar) {
        return new f(context, i, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final Bitmap bitmap) {
        com.opos.mobad.template.cmn.f.a(this.t, bitmap, 100, 0.2f, 200.0f, new com.opos.mobad.template.cmn.f.a() { // from class: com.opos.mobad.template.f.f.6
            @Override // com.opos.mobad.template.cmn.f.a
            public void a() {
            }

            @Override // com.opos.mobad.template.cmn.f.a
            public void a(Bitmap bitmap2) {
                if (f.this.n() == 8) {
                    return;
                }
                f.this.l.setImageBitmap(bitmap);
                f.this.b(bitmap2);
                f.this.c(bitmap);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Palette palette) {
        int color;
        if (n() == 8) {
            com.opos.cmn.an.f.a.a("ImageDynamicInterstitial", "takeColor call view is destroyed");
            return;
        }
        Palette.Swatch swatchB = com.opos.mobad.template.cmn.s.b(palette);
        GradientDrawable gradientDrawable = new GradientDrawable();
        if (swatchB != null) {
            this.b = com.opos.mobad.template.cmn.s.a(swatchB) ? this.f7599a : com.opos.mobad.template.cmn.s.a((int) swatchB.getHsl()[0], this.f7599a);
            if (com.opos.mobad.template.cmn.s.b(swatchB)) {
                color = Color.parseColor("#1AFFFFFF");
            }
            gradientDrawable.setStroke(com.opos.cmn.an.h.f.a.a(this.t, 0.33f), color);
            gradientDrawable.setCornerRadius(com.opos.cmn.an.h.f.a.a(this.t, 12.0f));
            this.m.setBackground(gradientDrawable);
        }
        this.b = this.f7599a;
        color = Color.parseColor("#1A000000");
        gradientDrawable.setStroke(com.opos.cmn.an.h.f.a.a(this.t, 0.33f), color);
        gradientDrawable.setCornerRadius(com.opos.cmn.an.h.f.a.a(this.t, 12.0f));
        this.m.setBackground(gradientDrawable);
    }

    private void a(com.opos.mobad.template.d.b bVar) {
        com.opos.mobad.template.e.c.a aVarA = com.opos.mobad.template.e.a.i.a().a(this.t, e(), bVar.L);
        this.r = aVarA;
        if (aVarA == null) {
            p();
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(13);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.t, 24.0f);
        this.g.addView(this.r.c(), layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Bitmap bitmap) {
        Bitmap bitmapCopy = bitmap.copy(Bitmap.Config.ARGB_8888, true);
        int height = (int) (bitmapCopy.getHeight() * 0.12f);
        for (int i = 0; i <= height; i++) {
            int iMin = Math.min(Double.valueOf(BigDecimal.valueOf(255.0d / ((double) height)).setScale(0, RoundingMode.HALF_UP).doubleValue()).intValue() * i, 255);
            for (int i2 = 0; i2 < bitmapCopy.getWidth(); i2++) {
                int pixel = bitmapCopy.getPixel(i2, i);
                bitmapCopy.setPixel(i2, i, Color.argb(iMin, Color.red(pixel), Color.green(pixel), Color.blue(pixel)));
            }
        }
        if (n() == 8) {
            com.opos.cmn.an.f.a.a("ImageDynamicInterstitial", "takeColor call view is destroyed");
        } else {
            this.j.setImageBitmap(bitmapCopy);
        }
    }

    private void b(com.opos.mobad.template.d.b bVar) {
        if (bVar == null) {
            return;
        }
        if (TextUtils.isEmpty(bVar.b)) {
            this.p.setVisibility(8);
        } else {
            this.p.setText(bVar.b);
        }
        if (TextUtils.isEmpty(bVar.f7534a)) {
            this.q.setVisibility(8);
        } else {
            this.q.setText(bVar.f7534a);
        }
        if (bVar.k == null || TextUtils.isEmpty(bVar.k.f7535a)) {
            q();
        } else {
            int iA = com.opos.cmn.an.h.f.a.a(this.t, 50.0f);
            com.opos.mobad.template.cmn.j.a(bVar.k.f7535a, bVar.k.b, iA, iA, this.v, new com.opos.mobad.template.cmn.j.a() { // from class: com.opos.mobad.template.f.f.1
                @Override // com.opos.mobad.template.cmn.j.a
                public void a(int i, Bitmap bitmap) {
                    if (i == 1) {
                        f.this.n.setImageBitmap(bitmap);
                    } else {
                        f.this.q();
                    }
                    f.this.b(i);
                }

                @Override // com.opos.mobad.template.cmn.j.a
                public void a(Bitmap bitmap) {
                    if (f.this.n() == 8) {
                        return;
                    }
                    f.this.n.setImageBitmap(bitmap);
                }
            }, this.w);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Bitmap bitmap) {
        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() { // from class: com.opos.mobad.template.f.f.7
            @Override // androidx.palette.graphics.Palette.PaletteAsyncListener
            public void onGenerated(Palette palette) {
                f.this.a(palette);
            }
        });
    }

    private void c(com.opos.mobad.template.d.b bVar) {
        if (bVar == null || bVar.c == null) {
            return;
        }
        com.opos.mobad.template.cmn.j.a(bVar.c.get(0).f7535a, bVar.c.get(0).b, com.opos.cmn.an.h.f.a.a(this.t, 720.0f), com.opos.cmn.an.h.f.a.a(this.t, 402.0f), this.v, new com.opos.mobad.template.cmn.j.a() { // from class: com.opos.mobad.template.f.f.3
            @Override // com.opos.mobad.template.cmn.j.a
            public void a(int i, Bitmap bitmap) {
                if (i == 1) {
                    f.this.a(bitmap);
                }
                f.this.b(i);
            }

            @Override // com.opos.mobad.template.cmn.j.a
            public void a(Bitmap bitmap) {
                if (f.this.n() == 8) {
                    return;
                }
                f.this.a(bitmap);
            }
        }, this.w);
    }

    private void i() {
        com.opos.mobad.template.cmn.baseview.c cVar = new com.opos.mobad.template.cmn.baseview.c(this.t);
        this.g = cVar;
        com.opos.mobad.template.cmn.p.a(cVar, this.x);
        this.g.a(this.z);
        ImageView imageView = new ImageView(this.t);
        this.i = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.g.addView(this.i, new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.t, 401.0f)));
        RelativeLayout relativeLayout = new RelativeLayout(this.t);
        this.k = relativeLayout;
        relativeLayout.setId(View.generateViewId());
        this.g.addView(this.k, new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.t, 144.0f)));
        this.l = new ImageView(this.t);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.l.setScaleType(ImageView.ScaleType.FIT_XY);
        this.k.addView(this.l, layoutParams);
        this.h = new RelativeLayout(this.t);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.t, 306.0f));
        layoutParams2.addRule(12);
        this.g.addView(this.h, layoutParams2);
        ImageView imageView2 = new ImageView(this.t);
        this.j = imageView2;
        imageView2.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.h.addView(this.j, new RelativeLayout.LayoutParams(-1, -1));
        this.o = new View(this.t);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -1);
        this.o.setLayoutParams(layoutParams3);
        this.o.setAlpha(0.16f);
        this.o.setBackgroundColor(ViewCompat.MEASURED_SIZE_MASK);
        this.h.addView(this.o, layoutParams3);
        this.f7599a = Color.parseColor(com.opos.mobad.template.cmn.d.COLOR_DEF2.a());
        this.m = new RelativeLayout(this.t);
        int iA = com.opos.cmn.an.h.f.a.a(this.t, 0.33f);
        this.m.setPadding(iA, iA, iA, iA);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.t, 60.0f), com.opos.cmn.an.h.f.a.a(this.t, 60.0f));
        layoutParams4.addRule(14);
        layoutParams4.topMargin = com.opos.cmn.an.h.f.a.a(this.t, 143.0f);
        this.g.addView(this.m, layoutParams4);
        Context context = this.t;
        com.opos.mobad.template.cmn.n nVar = new com.opos.mobad.template.cmn.n(context, com.opos.cmn.an.h.f.a.a(context, 12.0f));
        this.n = nVar;
        nVar.setScaleType(ImageView.ScaleType.FIT_XY);
        this.m.addView(this.n, new RelativeLayout.LayoutParams(-1, -1));
        TextView textView = new TextView(this.t);
        this.p = textView;
        com.opos.mobad.template.h.a(textView);
        this.p.setTextColor(-1);
        this.p.setTextSize(1, 14.0f);
        this.p.setGravity(17);
        this.p.setMaxEms(6);
        this.p.setEllipsize(TextUtils.TruncateAt.END);
        this.p.setSingleLine();
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams5.addRule(14);
        layoutParams5.topMargin = com.opos.cmn.an.h.f.a.a(this.t, 211.0f);
        this.g.addView(this.p, layoutParams5);
        TextView textView2 = new TextView(this.t);
        this.q = textView2;
        textView2.setTextColor(Color.parseColor("#8AFFFFFF"));
        this.q.setTextSize(1, 12.0f);
        this.q.setGravity(17);
        this.q.setEllipsize(TextUtils.TruncateAt.END);
        this.q.setSingleLine();
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams6.addRule(14);
        layoutParams6.topMargin = com.opos.cmn.an.h.f.a.a(this.t, 235.0f);
        this.g.addView(this.q, layoutParams6);
    }

    private void p() {
        com.opos.mobad.template.f.a.a aVar = new com.opos.mobad.template.f.a.a(this.t, com.opos.mobad.template.f.a.a.EnumC1008a.FINGER);
        this.f = aVar;
        aVar.a(16);
        this.f.b(8);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.t, 220.0f), com.opos.cmn.an.h.f.a.a(this.t, 44.0f));
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.t, 24.0f);
        this.g.addView(this.f.a(), layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        this.m.setVisibility(8);
        if (this.p.getVisibility() == 0) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(14);
            layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.t, 176.0f);
            this.g.updateViewLayout(this.p, layoutParams);
        }
        if (this.q.getVisibility() == 0) {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.addRule(14);
            layoutParams2.topMargin = com.opos.cmn.an.h.f.a.a(this.t, 196.0f);
            this.g.updateViewLayout(this.q, layoutParams2);
        }
    }

    @Override // com.opos.mobad.template.j.a, com.opos.mobad.template.a
    public void a() {
        com.opos.mobad.template.e.c.a aVar = this.r;
        if (aVar != null) {
            aVar.i();
        }
    }

    public void a(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        final com.opos.mobad.d.e.a aVar = new com.opos.mobad.d.e.a(viewGroup.getContext());
        aVar.a(new com.opos.mobad.d.e.a.InterfaceC0958a() { // from class: com.opos.mobad.template.f.f.4
            @Override // com.opos.mobad.d.e.a.InterfaceC0958a
            public void a(boolean z) {
                if (z) {
                    com.opos.mobad.d.c.c.a(new Runnable() { // from class: com.opos.mobad.template.f.f.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (f.this.n() == 8) {
                                return;
                            }
                            f.this.a(com.opos.mobad.template.h.a(f.this.r));
                            if (f.this.r != null) {
                                f.this.r.g();
                            }
                        }
                    });
                    aVar.a((com.opos.mobad.d.e.a.InterfaceC0958a) null);
                }
            }
        });
        aVar.a(new com.opos.mobad.d.e.a.c() { // from class: com.opos.mobad.template.f.f.5
            @Override // com.opos.mobad.d.e.a.c
            public void a(final boolean z, final boolean z2) {
                com.opos.mobad.d.c.c.a(new Runnable() { // from class: com.opos.mobad.template.f.f.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (f.this.n() == 8) {
                            return;
                        }
                        Map<String, String> mapA = com.opos.mobad.template.h.a(f.this.r);
                        mapA.put("isVisibleRect", String.valueOf(z));
                        mapA.put("isAttached", String.valueOf(z2));
                        f.this.b(mapA);
                    }
                });
                aVar.a((com.opos.mobad.d.e.a.c) null, (View) null);
            }
        }, c());
        viewGroup.addView(aVar, 0, 0);
    }

    @Override // com.opos.mobad.template.a
    public void a(com.opos.mobad.template.d.f fVar) {
        String str;
        String str2;
        com.opos.mobad.template.d.b bVarA = fVar.a();
        if (bVarA == null) {
            str = "ImageDynamicInterstitial";
            str2 = "render with data null";
        } else {
            if (bVarA.c != null && bVarA.c.size() > 0) {
                c(bVarA);
                b(bVarA);
                if (this.u == null) {
                    m();
                    a(bVarA);
                    a((ViewGroup) this.g);
                }
                this.u = bVarA;
                com.opos.mobad.template.e.c.a aVar = this.r;
                if (aVar != null) {
                    aVar.a(this.y);
                    this.r.a(this.z);
                    this.r.a(com.opos.mobad.template.e.b.a.a(bVarA));
                }
                com.opos.mobad.template.f.a.a aVar2 = this.f;
                if (aVar2 != null) {
                    aVar2.a(bVarA.j);
                    this.f.a().setOnClickListener(this.y);
                    this.f.a().setOnTouchListener(this.y);
                    this.f.a().a(this.z);
                    return;
                }
                return;
            }
            str = "";
            str2 = "render with imgList null";
        }
        com.opos.cmn.an.f.a.d(str, str2);
        a(1);
    }

    @Override // com.opos.mobad.template.j.a, com.opos.mobad.template.a
    public void b() {
        com.opos.mobad.template.e.c.a aVar = this.r;
        if (aVar != null) {
            aVar.h();
        }
    }

    @Override // com.opos.mobad.template.a
    public View c() {
        return this.g;
    }

    @Override // com.opos.mobad.template.j.a
    protected boolean f() {
        return false;
    }

    @Override // com.opos.mobad.template.j.a
    protected boolean g() {
        return false;
    }

    @Override // com.opos.mobad.template.j.a
    protected void h() {
        com.opos.mobad.template.e.c.a aVar = this.r;
        if (aVar != null) {
            aVar.j();
        }
    }
}
