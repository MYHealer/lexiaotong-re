package com.opos.mobad.template.g;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.heytap.msp.mobad.api.R;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class j extends com.opos.mobad.template.j.c {
    private int A;
    private int B;
    private ViewTreeObserver.OnPreDrawListener C;
    private com.opos.mobad.template.cmn.j.b D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f7895a;
    private int b;
    private int f;
    private Context g;
    private int h;
    private com.opos.mobad.template.d.b i;
    private com.opos.mobad.template.cmn.w j;
    private com.opos.mobad.template.cmn.n k;
    private com.opos.mobad.template.cmn.w l;
    private com.opos.mobad.template.cmn.w m;
    private aj n;
    private com.opos.mobad.template.cmn.aa o;
    private com.opos.mobad.template.a.f p;
    private com.opos.mobad.template.k.c q;
    private RelativeLayout r;
    private RelativeLayout s;
    private v t;
    private LinearLayout u;
    private TextView v;
    private com.opos.mobad.d.a w;
    private com.opos.mobad.template.cmn.w x;
    private Animator y;
    private ad z;

    private j(Context context, am amVar, int i, int i2, com.opos.mobad.d.a aVar) {
        super(i);
        this.f7895a = MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_AUDIO_PROBESIZE;
        this.b = 89;
        this.A = 0;
        this.B = 0;
        this.D = new com.opos.mobad.template.cmn.j.b() { // from class: com.opos.mobad.template.g.j.6
            @Override // com.opos.mobad.template.cmn.j.b
            public boolean a() {
                return j.this.n() == 8;
            }
        };
        this.g = context;
        this.h = i2;
        this.w = aVar;
        p();
        a(amVar);
    }

    private void A() {
        aj ajVarA = aj.a(this.g, this.h);
        this.n = ajVarA;
        ajVarA.a(new al() { // from class: com.opos.mobad.template.g.j.2
            @Override // com.opos.mobad.template.a.InterfaceC1003a
            public void b(View view, int[] iArr) {
                j.this.m(view, iArr);
            }

            @Override // com.opos.mobad.template.a.InterfaceC1003a
            public void c(View view, int[] iArr) {
                j.this.l(view, iArr);
            }

            @Override // com.opos.mobad.template.a.InterfaceC1003a
            public void d(View view, int[] iArr) {
                j.this.n(view, iArr);
            }
        });
        this.n.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(1, this.j.getId());
        layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.g, 16.0f);
        this.n.setVisibility(4);
        this.m.addView(this.n, layoutParams);
    }

    public static j a(Context context, am amVar, int i, com.opos.mobad.d.a aVar) {
        return new j(context, amVar, i, 0, aVar);
    }

    private void a(com.opos.mobad.template.d.b bVar) {
        b(bVar);
        c(bVar);
        if (q()) {
            this.q.a(bVar.p, bVar.e, bVar.f, bVar.h, bVar.i);
        } else {
            this.p.a(bVar.p, bVar.q, bVar.e, bVar.f, bVar.i);
        }
        this.t.a(bVar.j);
        if (TextUtils.isEmpty(bVar.b)) {
            return;
        }
        this.v.setText(bVar.b);
    }

    private void a(am amVar) {
        if (amVar == null) {
            amVar = am.a(this.g);
        }
        Context context = this.g;
        int i = amVar.f7821a;
        int i2 = amVar.b;
        int i3 = this.f7895a;
        this.o = new com.opos.mobad.template.cmn.aa(context, new com.opos.mobad.template.cmn.aa.a(i, i2, i3, i3 / this.f));
        this.l = new com.opos.mobad.template.cmn.w(this.g);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(this.f7895a, -2);
        layoutParams.width = this.f7895a;
        layoutParams.height = -2;
        this.l.setId(View.generateViewId());
        this.l.setLayoutParams(layoutParams);
        this.l.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(this.f7895a, -2);
        layoutParams2.addRule(13);
        this.o.addView(this.l, layoutParams2);
        this.o.setLayoutParams(layoutParams);
        s();
        A();
        u();
        v();
        t();
        r();
    }

    public static j b(Context context, am amVar, int i, com.opos.mobad.d.a aVar) {
        return new j(context, amVar, i, 1, aVar);
    }

    private void b(com.opos.mobad.template.d.b bVar) {
        if (bVar.c == null || bVar.c.size() == 0 || this.k == null) {
            return;
        }
        String str = bVar.c.get(0).f7535a;
        String str2 = bVar.c.get(0).b;
        int i = this.f7895a;
        int i2 = this.b;
        this.k.setScaleType(ImageView.ScaleType.FIT_XY);
        com.opos.mobad.template.cmn.j.a(str, str2, i, i2, this.w, new com.opos.mobad.template.cmn.j.a() { // from class: com.opos.mobad.template.g.j.5
            @Override // com.opos.mobad.template.cmn.j.a
            public void a(int i3, Bitmap bitmap) {
                if (i3 == 1) {
                    j.this.k.setImageBitmap(bitmap);
                }
                j.this.b(i3);
            }

            @Override // com.opos.mobad.template.cmn.j.a
            public void a(Bitmap bitmap) {
                if (j.this.n() == 8) {
                    return;
                }
                j.this.k.setImageBitmap(bitmap);
            }
        }, this.D);
    }

    private void c(com.opos.mobad.template.d.b bVar) {
        com.opos.mobad.template.d.a aVar = bVar.u;
        if (aVar == null || TextUtils.isEmpty(aVar.f7533a) || TextUtils.isEmpty(aVar.b)) {
            return;
        }
        aj ajVar = this.n;
        if (ajVar != null) {
            ajVar.setVisibility(0);
            this.n.a(aVar.f7533a, aVar.b);
        }
        com.opos.mobad.template.cmn.w wVar = this.x;
        if (wVar != null) {
            wVar.setVisibility(0);
        }
    }

    private void p() {
        int i = this.h;
        if (i == 0 || i == 1) {
            this.f7895a = com.opos.cmn.an.h.f.a.a(this.g, 328.0f);
            this.b = com.opos.cmn.an.h.f.a.a(this.g, 89.0f);
        }
        this.f = this.b + com.opos.cmn.an.h.f.a.a(this.g, 10.0f);
    }

    private boolean q() {
        int i = this.h;
        return i == 1 || i == 0;
    }

    private void r() {
        a((View) this.m);
        a((com.opos.mobad.template.cmn.baseview.e) this.m);
        b(this.t);
        a((com.opos.mobad.template.cmn.baseview.e) this.t);
    }

    private void s() {
        com.opos.mobad.template.cmn.w wVar = new com.opos.mobad.template.cmn.w(this.g);
        this.m = wVar;
        wVar.a(com.opos.cmn.an.h.f.a.a(this.g, 10.0f));
        this.m.setId(View.generateViewId());
        this.m.setBackgroundColor(this.g.getResources().getColor(R.color.opos_mobad_root_bg_color));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f7895a, this.b);
        layoutParams.addRule(15);
        this.l.addView(this.m, layoutParams);
        z();
    }

    private void t() {
        this.z = ad.a(this.g, 10, this.w);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        this.z.setId(View.generateViewId());
        this.m.addView(this.z, layoutParams);
    }

    private void u() {
        this.r = new RelativeLayout(this.g);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(15);
        layoutParams.addRule(1, this.j.getId());
        layoutParams.addRule(2, this.n.getId());
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.g, 16.0f);
        layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.g, 4.0f);
        layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(this.g, 8.0f);
        this.m.addView(this.r, layoutParams);
        w();
    }

    private void v() {
        this.s = new RelativeLayout(this.g);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(1, this.r.getId());
        layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.g, 8.0f);
        layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(this.g, 16.0f);
        y();
        this.m.addView(this.s, layoutParams);
    }

    private void w() {
        int iA;
        Context context;
        float f;
        LinearLayout linearLayout = new LinearLayout(this.g);
        this.u = linearLayout;
        linearLayout.setOrientation(0);
        int i = this.h;
        if (i != 0) {
            if (i == 1) {
                context = this.g;
                f = 121.0f;
            } else {
                iA = -1;
            }
            this.B = iA;
            this.r.addView(this.u, new RelativeLayout.LayoutParams(iA, -1));
            TextView textView = new TextView(this.g);
            this.v = textView;
            textView.setTextColor(this.g.getResources().getColor(R.color.opos_mobad_title_color));
            this.v.setTextSize(1, 14.0f);
            this.v.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
            this.v.setSingleLine(true);
            TextPaint paint = this.v.getPaint();
            paint.setStrokeWidth(1.0f);
            paint.setStyle(Paint.Style.FILL_AND_STROKE);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 16;
            this.u.addView(this.v, layoutParams);
            x();
            if (q() || this.C != null) {
            }
            this.C = new ViewTreeObserver.OnPreDrawListener() { // from class: com.opos.mobad.template.g.j.1
                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public boolean onPreDraw() {
                    if (j.this.n() != 8 && j.this.u != null && j.this.v != null && j.this.q != null && j.this.B != 0) {
                        try {
                            if (j.this.u.getWidth() <= j.this.v.getWidth() + j.this.q.getWidth() + ((int) ((j.this.u.getWidth() / j.this.B) * j.this.A))) {
                                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) j.this.v.getLayoutParams();
                                layoutParams2.weight = 1.0f;
                                if (j.this.v.getParent() != null && j.this.v.getParent() == j.this.u) {
                                    j.this.u.updateViewLayout(j.this.v, layoutParams2);
                                    if (j.this.u != null && j.this.C != null && j.this.u.getViewTreeObserver().isAlive()) {
                                        j.this.u.getViewTreeObserver().removeOnPreDrawListener(j.this.C);
                                    }
                                }
                            }
                        } catch (Exception e) {
                            com.opos.cmn.an.f.a.d("BlockBigImage8", "preDrawListener->Exception:" + e);
                        }
                    }
                    return true;
                }
            };
            LinearLayout linearLayout2 = this.u;
            if (linearLayout2 == null || !linearLayout2.getViewTreeObserver().isAlive()) {
                return;
            }
            this.u.getViewTreeObserver().addOnPreDrawListener(this.C);
            return;
        }
        context = this.g;
        f = 107.0f;
        iA = com.opos.cmn.an.h.f.a.a(context, f);
        this.B = iA;
        this.r.addView(this.u, new RelativeLayout.LayoutParams(iA, -1));
        TextView textView2 = new TextView(this.g);
        this.v = textView2;
        textView2.setTextColor(this.g.getResources().getColor(R.color.opos_mobad_title_color));
        this.v.setTextSize(1, 14.0f);
        this.v.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.v.setSingleLine(true);
        TextPaint paint2 = this.v.getPaint();
        paint2.setStrokeWidth(1.0f);
        paint2.setStyle(Paint.Style.FILL_AND_STROKE);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        this.u.addView(this.v, layoutParams2);
        x();
        if (q()) {
        }
    }

    private void x() {
        this.A = com.opos.cmn.an.h.f.a.a(this.g, 4.0f);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        layoutParams.leftMargin = this.A;
        if (!q()) {
            com.opos.mobad.template.a.f fVarB = com.opos.mobad.template.a.f.b(this.g, this.w);
            this.p = fVarB;
            this.u.addView(fVarB, layoutParams);
        } else {
            com.opos.mobad.template.k.c cVarA = com.opos.mobad.template.k.c.a(this.g, 1, 0, this.w);
            this.q = cVarA;
            this.u.addView(cVarA, layoutParams);
            if (this.h == 0) {
                this.q.a(5);
            }
        }
    }

    private void y() {
        v vVarB = v.b(this.g, "");
        this.t = vVarB;
        vVarB.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(this.g, 28.0f));
        layoutParams.addRule(15);
        layoutParams.addRule(11);
        if (this.h != 0) {
            this.s.addView(this.t, layoutParams);
            return;
        }
        this.x = new com.opos.mobad.template.cmn.w(this.g);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(this.g, 28.0f));
        layoutParams2.addRule(5, this.t.getId());
        layoutParams2.addRule(7, this.t.getId());
        layoutParams2.addRule(6, this.t.getId());
        layoutParams2.addRule(8, this.t.getId());
        layoutParams2.addRule(13);
        this.x.setId(View.generateViewId());
        this.x.a(com.opos.cmn.an.h.f.a.a(this.g, 36.0f));
        Animator animatorB = com.opos.mobad.template.cmn.ae.b((RelativeLayout) this.x);
        this.y = animatorB;
        animatorB.start();
        this.x.setVisibility(4);
        this.s.addView(this.t, layoutParams);
        this.s.addView(this.x, layoutParams2);
    }

    private void z() {
        RelativeLayout.LayoutParams layoutParams;
        com.opos.mobad.template.cmn.n nVar;
        com.opos.mobad.template.cmn.w wVar;
        RelativeLayout.LayoutParams layoutParams2;
        com.opos.mobad.template.cmn.w wVar2 = new com.opos.mobad.template.cmn.w(this.g);
        this.j = wVar2;
        wVar2.setId(View.generateViewId());
        if (this.h == 1) {
            this.j.a(com.opos.cmn.an.h.f.a.a(this.g, 10.0f));
            layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.g, 87.0f), com.opos.cmn.an.h.f.a.a(this.g, 57.0f));
            layoutParams.setMargins(com.opos.cmn.an.h.f.a.a(this.g, 16.0f), com.opos.cmn.an.h.f.a.a(this.g, 16.0f), com.opos.cmn.an.h.f.a.a(this.g, 8.0f), 0);
            Context context = this.g;
            nVar = new com.opos.mobad.template.cmn.n(context, com.opos.cmn.an.h.f.a.a(context, 10.0f));
            this.k = nVar;
            wVar = this.j;
            layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        } else {
            this.j.a(com.opos.cmn.an.h.f.a.a(this.g, 10.0f));
            layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.g, 101.0f), com.opos.cmn.an.h.f.a.a(this.g, 57.0f));
            layoutParams.setMargins(com.opos.cmn.an.h.f.a.a(this.g, 16.0f), com.opos.cmn.an.h.f.a.a(this.g, 16.0f), com.opos.cmn.an.h.f.a.a(this.g, 8.0f), 0);
            Context context2 = this.g;
            nVar = new com.opos.mobad.template.cmn.n(context2, com.opos.cmn.an.h.f.a.a(context2, 10.0f));
            this.k = nVar;
            wVar = this.j;
            layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        }
        wVar.addView(nVar, layoutParams2);
        layoutParams.addRule(15);
        com.opos.cmn.an.f.a.b("BlockBigImage8", "imgType " + this.h);
        this.m.addView(this.j, layoutParams);
    }

    @Override // com.opos.mobad.template.j.a, com.opos.mobad.template.a
    public void a() {
    }

    public void a(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        final com.opos.mobad.d.e.a aVar = new com.opos.mobad.d.e.a(viewGroup.getContext());
        aVar.a(new com.opos.mobad.d.e.a.InterfaceC0958a() { // from class: com.opos.mobad.template.g.j.3
            @Override // com.opos.mobad.d.e.a.InterfaceC0958a
            public void a(boolean z) {
                if (z) {
                    com.opos.mobad.d.c.c.a(new Runnable() { // from class: com.opos.mobad.template.g.j.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (j.this.n() == 8) {
                                return;
                            }
                            j.this.a((Map<String, String>) null);
                        }
                    });
                    aVar.a((com.opos.mobad.d.e.a.InterfaceC0958a) null);
                }
            }
        });
        aVar.a(new com.opos.mobad.d.e.a.c() { // from class: com.opos.mobad.template.g.j.4
            @Override // com.opos.mobad.d.e.a.c
            public void a(final boolean z, final boolean z2) {
                com.opos.mobad.d.c.c.a(new Runnable() { // from class: com.opos.mobad.template.g.j.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (j.this.n() == 8) {
                            return;
                        }
                        HashMap map = new HashMap();
                        map.put("isVisibleRect", String.valueOf(z));
                        map.put("isAttached", String.valueOf(z2));
                        j.this.b(map);
                    }
                });
                aVar.a((com.opos.mobad.d.e.a.c) null, (View) null);
            }
        }, c());
        viewGroup.addView(aVar, 0, 0);
    }

    @Override // com.opos.mobad.template.j.a, com.opos.mobad.template.a
    public void a(com.opos.mobad.template.a.InterfaceC1003a interfaceC1003a) {
        super.a(interfaceC1003a);
        if (q()) {
            this.q.a(i());
        } else {
            this.p.a(i());
        }
        ad adVar = this.z;
        if (adVar != null) {
            adVar.a(i());
        }
    }

    @Override // com.opos.mobad.template.a
    public void a(com.opos.mobad.template.d.f fVar) {
        String str;
        if (fVar == null) {
            str = "data is null";
        } else {
            com.opos.mobad.template.d.b bVarA = fVar.a();
            if (bVarA != null) {
                com.opos.cmn.an.f.a.b("BlockBigImage8", "render");
                if (this.i == null) {
                    m();
                    a((ViewGroup) this.l);
                }
                this.i = bVarA;
                com.opos.mobad.template.cmn.aa aaVar = this.o;
                if (aaVar != null && aaVar.getVisibility() != 0) {
                    this.o.setVisibility(0);
                }
                com.opos.mobad.template.cmn.w wVar = this.l;
                if (wVar != null && wVar.getVisibility() != 0) {
                    this.l.setVisibility(0);
                }
                a(bVarA);
                return;
            }
            str = "adShowData is null";
        }
        com.opos.cmn.an.f.a.b("BlockBigImage8", str);
        a(1);
    }

    @Override // com.opos.mobad.template.j.a, com.opos.mobad.template.a
    public void b() {
    }

    @Override // com.opos.mobad.template.a
    public View c() {
        return this.o;
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
        com.opos.cmn.an.f.a.b("BlockBigImage8", "doEnd");
        this.i = null;
        com.opos.mobad.template.cmn.aa aaVar = this.o;
        if (aaVar != null) {
            aaVar.removeAllViews();
        }
    }
}
