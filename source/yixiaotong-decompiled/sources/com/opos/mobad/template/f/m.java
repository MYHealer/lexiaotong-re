package com.opos.mobad.template.f;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.template.cmn.af;
import com.opos.mobad.template.cmn.y;
import com.opos.mobad.template.cmn.z;
import com.stub.StubApp;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class m extends com.opos.mobad.template.j.a {
    private boolean A;
    private int B;
    private Bitmap C;
    private com.opos.mobad.d.d.a D;
    private ViewTreeObserver.OnPreDrawListener E;
    private boolean F;
    private boolean G;
    private boolean H;
    private com.opos.mobad.template.cmn.p I;
    private com.opos.mobad.template.cmn.p J;
    private com.opos.mobad.template.cmn.baseview.f K;
    private com.opos.mobad.template.cmn.j.b L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private RelativeLayout f7672a;
    private z b;
    private RelativeLayout f;
    private RelativeLayout g;
    private LinearLayout h;
    private View i;
    private View j;
    private y k;
    private TextView l;
    private TextView m;
    private LinearLayout n;
    private TextView o;
    private TextView p;
    private TextView q;
    private TextView r;
    private TextView s;
    private TextView t;
    private y u;
    private TextView v;
    private com.opos.mobad.template.cmn.baseview.b w;
    private TextView x;
    private Context y;
    private com.opos.mobad.d.a z;

    public m(Context context, int i, boolean z, com.opos.mobad.d.d.a aVar, com.opos.mobad.d.a aVar2) {
        super(i);
        this.C = null;
        this.F = false;
        this.G = false;
        this.H = false;
        this.I = new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.f.m.5
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                m.this.a(2, iArr);
            }
        };
        this.J = new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.f.m.6
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                m.this.a(3, iArr);
            }
        };
        this.K = new com.opos.mobad.template.cmn.baseview.f() { // from class: com.opos.mobad.template.f.m.7
            @Override // com.opos.mobad.template.cmn.baseview.f
            public void a(View view, int i2, boolean z2) {
                com.opos.cmn.an.f.a.a("InterRetainEndPage", "onMockEventIntercepted->clickMockEvent:" + i2 + ";disAllowClick:" + z2 + ";view:" + view.getClass().getName());
                m.this.a(view, i2, z2);
            }
        };
        this.L = new com.opos.mobad.template.cmn.j.b() { // from class: com.opos.mobad.template.f.m.3
            @Override // com.opos.mobad.template.cmn.j.b
            public boolean a() {
                return m.this.n() == 8;
            }
        };
        this.y = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.z = aVar2;
        this.A = z;
        this.D = aVar;
        i();
    }

    public static m a(Context context, com.opos.mobad.d.d.a aVar, com.opos.mobad.d.a aVar2, int i) {
        if (context == null) {
            return null;
        }
        return new m(context, i, false, aVar, aVar2);
    }

    private void a(final TextView textView) {
        if (textView == null) {
            return;
        }
        try {
            textView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: com.opos.mobad.template.f.m.10
                /* JADX WARN: Code duplicated, block: B:12:0x0028 A[PHI: r1
  0x0028: PHI (r1v2 int) = (r1v1 int), (r1v3 int) binds: [B:11:0x0026, B:8:0x001b] A[DONT_GENERATE, DONT_INLINE]] */
                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public boolean onPreDraw() {
                    int i;
                    if (m.this.n() == 8) {
                        return true;
                    }
                    if (textView.getLineCount() > 1) {
                        i = 3;
                        if (textView.getGravity() != 3) {
                            textView.setGravity(i);
                        }
                    } else {
                        i = 17;
                        if (textView.getGravity() != 17) {
                            textView.setGravity(i);
                        }
                    }
                    return true;
                }
            });
        } catch (Exception e) {
            com.opos.cmn.an.f.a.d("InterRetainEndPage", "preDrawListener->setLineStyle->Exception:" + e);
        }
    }

    private void a(com.opos.mobad.template.d.e eVar) {
        if (eVar == null || TextUtils.isEmpty(eVar.f7535a)) {
            return;
        }
        com.opos.mobad.template.cmn.j.a(eVar.f7535a, eVar.b, this.z, new com.opos.mobad.template.cmn.j.c() { // from class: com.opos.mobad.template.f.m.11
            @Override // com.opos.mobad.template.cmn.j.c
            public void a(int i) {
                if (m.this.n() == 8) {
                    return;
                }
                m.this.b(i);
                com.opos.mobad.template.h.a(com.opos.cmn.an.h.f.a.a(m.this.y, 60.0f), com.opos.cmn.an.h.f.a.a(m.this.y, 60.0f), m.this.k);
                m.this.k.setVisibility(0);
            }

            @Override // com.opos.mobad.template.cmn.j.c
            public void a(Bitmap bitmap) {
                if (m.this.n() == 8) {
                    return;
                }
                if (bitmap != null) {
                    m.this.k.setImageBitmap(bitmap);
                } else {
                    com.opos.mobad.template.h.a(com.opos.cmn.an.h.f.a.a(m.this.y, 60.0f), com.opos.cmn.an.h.f.a.a(m.this.y, 60.0f), m.this.k);
                }
                m.this.k.setVisibility(0);
            }
        }, this.L);
    }

    private void a(com.opos.mobad.template.d.e eVar, String str, String str2) {
        if (this.C != null) {
            this.u.setBackground(new BitmapDrawable(this.C));
            return;
        }
        if (eVar != null && !TextUtils.isEmpty(eVar.f7535a)) {
            af.a(this.D, eVar.f7535a, new af.a() { // from class: com.opos.mobad.template.f.m.9
                @Override // com.opos.mobad.template.cmn.af.a
                public void a() {
                    m.this.b(2);
                    m mVar = m.this;
                    mVar.a(mVar.A, (Bitmap) null, (BitmapDrawable) null, m.this.A);
                }

                @Override // com.opos.mobad.template.cmn.af.a
                public void a(final Bitmap bitmap) {
                    if (m.this.n() == 8) {
                        return;
                    }
                    m.this.C = bitmap;
                    com.opos.mobad.d.c.c.c(new Runnable() { // from class: com.opos.mobad.template.f.m.9.1
                        @Override // java.lang.Runnable
                        public void run() {
                            m mVar;
                            BitmapDrawable bitmapDrawable;
                            boolean z;
                            boolean z2;
                            if (m.this.n() == 8) {
                                return;
                            }
                            Bitmap bitmap2 = bitmap;
                            if (bitmap2 == null) {
                                m.this.a(m.this.A, (Bitmap) null, (BitmapDrawable) null, m.this.A);
                                return;
                            }
                            if (bitmap.getHeight() > bitmap2.getWidth()) {
                                mVar = m.this;
                                bitmapDrawable = new BitmapDrawable(bitmap);
                                z = m.this.A;
                                z2 = true;
                            } else {
                                mVar = m.this;
                                bitmapDrawable = new BitmapDrawable(bitmap);
                                z = m.this.A;
                                z2 = false;
                            }
                            mVar.a(z2, (Bitmap) null, bitmapDrawable, z);
                        }
                    });
                }
            });
        }
        if (!TextUtils.isEmpty(str)) {
            this.v.setText(str);
            this.v.setVisibility(0);
            a(this.v);
            this.v.setVisibility(0);
        }
        a(str2);
    }

    private void a(com.opos.mobad.template.d.e eVar, String str, String str2, List<Pair<String, String>> list, String str3) {
        boolean z;
        boolean z2;
        a(eVar);
        if (!TextUtils.isEmpty(str)) {
            this.l.setText(str);
            this.l.setVisibility(0);
        }
        if (list != null && list.size() == 3) {
            Pair<String, String> pair = list.get(0);
            boolean z3 = true;
            if (pair == null || TextUtils.isEmpty(pair.first.toString()) || TextUtils.isEmpty(pair.second.toString())) {
                z = false;
            } else {
                this.o.setText(pair.first.toString());
                this.p.setText(pair.second.toString());
                z = true;
            }
            Pair<String, String> pair2 = list.get(1);
            if (pair2 == null || TextUtils.isEmpty(pair2.first.toString()) || TextUtils.isEmpty(pair2.second.toString())) {
                z2 = false;
            } else {
                this.q.setText(pair2.first.toString());
                this.r.setText(pair2.second.toString());
                z2 = true;
            }
            Pair<String, String> pair3 = list.get(2);
            if (pair3 == null || TextUtils.isEmpty(pair3.first.toString()) || TextUtils.isEmpty(pair3.second.toString())) {
                z3 = false;
            } else {
                this.s.setText(pair3.first.toString());
                this.t.setText(pair3.second.toString());
            }
            if (z && z2 && z3) {
                this.n.setVisibility(0);
                if (!TextUtils.isEmpty(str2)) {
                    this.m.setText(str2);
                    this.m.setVisibility(0);
                    a(this.m);
                }
            }
        }
        a(str3);
    }

    private void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.x.setText(str);
    }

    private void a(List<com.opos.mobad.template.d.e> list, String str, String str2) {
        if (list != null && list.size() > 0) {
            b(list.get(0));
        }
        if (!TextUtils.isEmpty(str)) {
            this.v.setText(str);
            this.v.setVisibility(0);
            a(this.v);
            this.v.setVisibility(0);
        }
        a(str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, Bitmap bitmap, BitmapDrawable bitmapDrawable, boolean z2) {
        int iA;
        Context context;
        float f;
        Context context2 = this.y;
        if (z) {
            iA = com.opos.cmn.an.h.f.a.a(context2, 200.0f);
            context = this.y;
            f = 112.0f;
        } else {
            iA = com.opos.cmn.an.h.f.a.a(context2, 90.0f);
            context = this.y;
            f = 160.0f;
        }
        int iA2 = com.opos.cmn.an.h.f.a.a(context, f);
        y yVar = this.u;
        if (yVar != null) {
            if (bitmap != null) {
                if (!z2 && z) {
                    iA = com.opos.cmn.an.h.f.a.a(this.y, 90.0f);
                    iA2 = com.opos.cmn.an.h.f.a.a(this.y, 50.0f);
                }
                this.u.setImageBitmap(bitmap);
            } else if (bitmapDrawable != null) {
                if (!z2 && z) {
                    iA = com.opos.cmn.an.h.f.a.a(this.y, 90.0f);
                    iA2 = com.opos.cmn.an.h.f.a.a(this.y, 50.0f);
                }
                this.u.setBackground(bitmapDrawable);
            } else {
                com.opos.mobad.template.h.a(iA, iA2, yVar);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(iA2, iA);
            layoutParams.gravity = 1;
            layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.y, 8.0f);
            this.u.setLayoutParams(layoutParams);
            this.u.setVisibility(0);
        }
    }

    public static m b(Context context, com.opos.mobad.d.d.a aVar, com.opos.mobad.d.a aVar2, int i) {
        if (context == null) {
            return null;
        }
        return new m(context, i, true, aVar, aVar2);
    }

    private void b(com.opos.mobad.template.d.e eVar) {
        if (eVar == null || TextUtils.isEmpty(eVar.f7535a)) {
            return;
        }
        com.opos.mobad.template.cmn.j.a(eVar.f7535a, eVar.b, this.z, new com.opos.mobad.template.cmn.j.c() { // from class: com.opos.mobad.template.f.m.2
            @Override // com.opos.mobad.template.cmn.j.c
            public void a(int i) {
                if (m.this.n() == 8) {
                    return;
                }
                m.this.b(i);
                m mVar = m.this;
                mVar.a(mVar.A, (Bitmap) null, (BitmapDrawable) null, m.this.A);
            }

            @Override // com.opos.mobad.template.cmn.j.c
            public void a(Bitmap bitmap) {
                m mVar;
                boolean z;
                if (m.this.n() == 8) {
                    return;
                }
                if (bitmap == null) {
                    m mVar2 = m.this;
                    mVar2.a(mVar2.A, (Bitmap) null, (BitmapDrawable) null, m.this.A);
                    return;
                }
                if (bitmap.getHeight() > bitmap.getWidth()) {
                    mVar = m.this;
                    z = true;
                } else {
                    mVar = m.this;
                    z = false;
                }
                mVar.a(z, bitmap, (BitmapDrawable) null, mVar.A);
            }
        }, this.L);
    }

    private void i() {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout relativeLayout = new RelativeLayout(this.y);
        this.f7672a = relativeLayout;
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.f7672a.setPadding(0, 0, 0, com.opos.cmn.an.h.f.a.a(this.y, 24.0f));
        this.f7672a.setBackgroundColor(this.y.getResources().getColor(R.color.opos_mobad_retain_mark_color));
        View view = new View(this.y);
        view.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.f7672a.addView(view);
        com.opos.mobad.template.cmn.p.a(this.f7672a, new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.f.m.1
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view2, int[] iArr) {
            }
        });
        z zVar = new z(this.y);
        this.b = zVar;
        zVar.a(com.opos.cmn.an.h.f.a.a(this.y, 20.0f));
        this.b.setBackgroundColor(this.y.getResources().getColor(R.color.opos_mobad_retain_bg_color));
        if (this.A) {
            this.B = com.opos.cmn.an.h.f.a.a(this.y, 600.0f);
            layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.y, 328.0f), -2);
        } else {
            int iB = com.opos.cmn.an.h.f.a.b(this.y);
            this.B = iB > 0 ? iB - com.opos.cmn.an.h.f.a.a(this.y, 64.0f) : com.opos.cmn.an.h.f.a.a(this.y, 280.0f);
            layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.y, 360.0f), -2);
            layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.y, 40.0f);
        }
        this.b.a(this.B);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        this.f7672a.addView(this.b, layoutParams);
        if (this.E == null) {
            this.E = new ViewTreeObserver.OnPreDrawListener() { // from class: com.opos.mobad.template.f.m.4
                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public boolean onPreDraw() {
                    if (m.this.n() != 8 && m.this.b != null && m.this.w != null && m.this.g != null) {
                        try {
                            if (m.this.b.getHeight() == m.this.B) {
                                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) m.this.w.getLayoutParams();
                                layoutParams2.removeRule(3);
                                layoutParams2.addRule(12);
                                m.this.b.updateViewLayout(m.this.w, layoutParams2);
                                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) m.this.g.getLayoutParams();
                                layoutParams3.addRule(2, m.this.w.getId());
                                m.this.b.updateViewLayout(m.this.g, layoutParams3);
                                if (m.this.i != null && m.this.i.getVisibility() != 0) {
                                    m.this.i.setVisibility(0);
                                }
                                if (m.this.j != null && m.this.j.getVisibility() != 0) {
                                    m.this.j.setVisibility(0);
                                }
                            }
                        } catch (Exception e) {
                            com.opos.cmn.an.f.a.d("InterRetainEndPage", "preDrawListener->Exception:" + e);
                        }
                    }
                    return true;
                }
            };
            z zVar2 = this.b;
            if (zVar2 != null && zVar2.getViewTreeObserver().isAlive()) {
                this.b.getViewTreeObserver().addOnPreDrawListener(this.E);
            }
        }
        p();
        q();
        r();
    }

    private void p() {
        RelativeLayout relativeLayout = new RelativeLayout(this.y);
        this.f = relativeLayout;
        relativeLayout.setId(View.generateViewId());
        this.f.setPadding(0, com.opos.cmn.an.h.f.a.a(this.y, 24.0f), 0, com.opos.cmn.an.h.f.a.a(this.y, 6.0f));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(10);
        this.f.setGravity(1);
        this.b.addView(this.f, layoutParams);
        TextView textView = new TextView(this.y);
        textView.setTextSize(1, 18.0f);
        textView.setText("是否要关闭这条广告？");
        com.opos.mobad.template.h.a(textView);
        textView.setTextColor(this.y.getResources().getColor(R.color.opos_mobad_retain_title_color));
        this.f.addView(textView);
    }

    private void q() {
        RelativeLayout relativeLayout = new RelativeLayout(this.y);
        this.g = relativeLayout;
        relativeLayout.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(3, this.f.getId());
        this.b.addView(this.g, layoutParams);
        ScrollView scrollView = new ScrollView(this.y);
        scrollView.setVerticalScrollBarEnabled(false);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        scrollView.setFillViewport(true);
        this.g.addView(scrollView, layoutParams2);
        LinearLayout linearLayout = new LinearLayout(this.y);
        this.h = linearLayout;
        linearLayout.setOrientation(1);
        ViewGroup.LayoutParams layoutParams3 = new ViewGroup.LayoutParams(-1, -2);
        this.h.setPadding(0, com.opos.cmn.an.h.f.a.a(this.y, 8.0f), 0, com.opos.cmn.an.h.f.a.a(this.y, 8.0f));
        scrollView.addView(this.h, layoutParams3);
        Context context = this.y;
        com.opos.mobad.template.cmn.n nVar = new com.opos.mobad.template.cmn.n(context, com.opos.cmn.an.h.f.a.a(context, 12.0f));
        this.k = nVar;
        nVar.setVisibility(8);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.y, 60.0f), com.opos.cmn.an.h.f.a.a(this.y, 60.0f));
        layoutParams4.gravity = 1;
        layoutParams4.bottomMargin = com.opos.cmn.an.h.f.a.a(this.y, 8.0f);
        this.h.addView(this.k, layoutParams4);
        TextView textView = new TextView(this.y);
        this.l = textView;
        textView.setVisibility(8);
        this.l.setTextSize(1, 16.0f);
        this.l.setLines(1);
        this.l.setEllipsize(TextUtils.TruncateAt.END);
        this.l.setTextColor(this.y.getResources().getColor(R.color.opos_mobad_retain_title_color));
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams5.bottomMargin = com.opos.cmn.an.h.f.a.a(this.y, 8.0f);
        layoutParams5.gravity = 1;
        com.opos.mobad.template.h.a(this.l);
        this.h.addView(this.l, layoutParams5);
        TextView textView2 = new TextView(this.y);
        this.m = textView2;
        textView2.setVisibility(8);
        this.m.setTextSize(1, 12.0f);
        this.m.setEllipsize(TextUtils.TruncateAt.END);
        this.m.setTextColor(this.y.getResources().getColor(R.color.opos_mobad_retain_des_color));
        this.m.setPadding(com.opos.cmn.an.h.f.a.a(this.y, 24.0f), 0, com.opos.cmn.an.h.f.a.a(this.y, 24.0f), 0);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams6.gravity = 1;
        layoutParams6.bottomMargin = com.opos.cmn.an.h.f.a.a(this.y, 8.0f);
        this.h.addView(this.m, layoutParams6);
        LinearLayout linearLayout2 = new LinearLayout(this.y);
        this.n = linearLayout2;
        linearLayout2.setVisibility(8);
        this.n.setOrientation(0);
        this.n.setWeightSum(3.0f);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.y, 48.0f));
        this.n.setPadding(com.opos.cmn.an.h.f.a.a(this.y, 20.0f), com.opos.cmn.an.h.f.a.a(this.y, 8.0f), com.opos.cmn.an.h.f.a.a(this.y, 20.0f), 0);
        this.h.addView(this.n, layoutParams7);
        LinearLayout linearLayout3 = new LinearLayout(this.y);
        linearLayout3.setOrientation(1);
        LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(-2, -1);
        layoutParams8.weight = 1.0f;
        this.n.addView(linearLayout3, layoutParams8);
        TextView textView3 = new TextView(this.y);
        this.o = textView3;
        textView3.setTextSize(1, 16.0f);
        this.o.setEllipsize(TextUtils.TruncateAt.END);
        com.opos.mobad.template.h.a(this.o);
        this.o.setTextColor(this.y.getResources().getColor(R.color.opos_mobad_retain_title_color));
        LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams9.bottomMargin = com.opos.cmn.an.h.f.a.a(this.y, 2.0f);
        layoutParams9.gravity = 1;
        linearLayout3.addView(this.o, layoutParams9);
        TextView textView4 = new TextView(this.y);
        this.p = textView4;
        textView4.setTextSize(1, 12.0f);
        this.p.setEllipsize(TextUtils.TruncateAt.END);
        this.p.setTextColor(this.y.getResources().getColor(R.color.opos_mobad_retain_des_color));
        LinearLayout.LayoutParams layoutParams10 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams10.gravity = 1;
        linearLayout3.addView(this.p, layoutParams10);
        LinearLayout linearLayout4 = new LinearLayout(this.y);
        linearLayout4.setOrientation(1);
        LinearLayout.LayoutParams layoutParams11 = new LinearLayout.LayoutParams(-2, -1);
        layoutParams11.weight = 1.0f;
        this.n.addView(linearLayout4, layoutParams11);
        TextView textView5 = new TextView(this.y);
        this.q = textView5;
        textView5.setTextSize(1, 16.0f);
        this.q.setEllipsize(TextUtils.TruncateAt.END);
        com.opos.mobad.template.h.a(this.q);
        this.q.setTextColor(this.y.getResources().getColor(R.color.opos_mobad_retain_title_color));
        LinearLayout.LayoutParams layoutParams12 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams12.bottomMargin = com.opos.cmn.an.h.f.a.a(this.y, 2.0f);
        layoutParams12.gravity = 1;
        linearLayout4.addView(this.q, layoutParams12);
        TextView textView6 = new TextView(this.y);
        this.r = textView6;
        textView6.setTextSize(1, 12.0f);
        this.r.setEllipsize(TextUtils.TruncateAt.END);
        this.r.setTextColor(this.y.getResources().getColor(R.color.opos_mobad_retain_des_color));
        LinearLayout.LayoutParams layoutParams13 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams13.gravity = 1;
        linearLayout4.addView(this.r, layoutParams13);
        LinearLayout linearLayout5 = new LinearLayout(this.y);
        linearLayout5.setOrientation(1);
        LinearLayout.LayoutParams layoutParams14 = new LinearLayout.LayoutParams(-2, -1);
        layoutParams14.weight = 1.0f;
        this.n.addView(linearLayout5, layoutParams14);
        TextView textView7 = new TextView(this.y);
        this.s = textView7;
        textView7.setTextSize(1, 16.0f);
        this.s.setEllipsize(TextUtils.TruncateAt.END);
        com.opos.mobad.template.h.a(this.s);
        this.s.setTextColor(this.y.getResources().getColor(R.color.opos_mobad_retain_title_color));
        LinearLayout.LayoutParams layoutParams15 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams15.bottomMargin = com.opos.cmn.an.h.f.a.a(this.y, 2.0f);
        layoutParams15.gravity = 1;
        linearLayout5.addView(this.s, layoutParams15);
        TextView textView8 = new TextView(this.y);
        this.t = textView8;
        textView8.setTextSize(1, 12.0f);
        this.t.setEllipsize(TextUtils.TruncateAt.END);
        this.t.setTextColor(this.y.getResources().getColor(R.color.opos_mobad_retain_des_color));
        LinearLayout.LayoutParams layoutParams16 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams16.gravity = 1;
        linearLayout5.addView(this.t, layoutParams16);
        Context context2 = this.y;
        com.opos.mobad.template.cmn.n nVar2 = new com.opos.mobad.template.cmn.n(context2, com.opos.cmn.an.h.f.a.a(context2, 16.0f));
        this.u = nVar2;
        nVar2.setScaleType(ImageView.ScaleType.FIT_XY);
        this.u.setVisibility(8);
        this.h.addView(this.u);
        TextView textView9 = new TextView(this.y);
        this.v = textView9;
        textView9.setVisibility(8);
        this.v.setTextSize(1, 14.0f);
        this.v.setEllipsize(TextUtils.TruncateAt.END);
        this.v.setTextColor(this.y.getResources().getColor(R.color.opos_mobad_retain_title_color));
        this.v.setPadding(com.opos.cmn.an.h.f.a.a(this.y, 24.0f), 0, com.opos.cmn.an.h.f.a.a(this.y, 24.0f), 0);
        LinearLayout.LayoutParams layoutParams17 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams17.gravity = 1;
        this.h.addView(this.v, layoutParams17);
        View view = new View(this.y);
        this.j = view;
        view.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams18 = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.y, 36.0f));
        layoutParams18.addRule(10);
        int[] iArr = {this.y.getResources().getColor(R.color.opos_mobad_retain_text_mark_startcolor), this.y.getResources().getColor(R.color.opos_mobad_retain_text_mark_endcolor)};
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, iArr);
        gradientDrawable.setShape(0);
        this.j.setBackground(gradientDrawable);
        this.g.addView(this.j, layoutParams18);
        View view2 = new View(this.y);
        this.i = view2;
        view2.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams19 = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.y, 36.0f));
        layoutParams19.addRule(12);
        GradientDrawable gradientDrawable2 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, iArr);
        gradientDrawable2.setShape(0);
        this.i.setBackground(gradientDrawable2);
        this.g.addView(this.i, layoutParams19);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private void r() {
        com.opos.mobad.template.cmn.baseview.b bVar = new com.opos.mobad.template.cmn.baseview.b(this.y);
        this.w = bVar;
        bVar.setId(View.generateViewId());
        this.w.setOrientation(0);
        this.w.setWeightSum(2.0f);
        this.w.setGravity(17);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(3, this.g.getId());
        this.b.addView(this.w, layoutParams);
        this.w.a(this.K);
        LinearLayout linearLayout = new LinearLayout(this.y);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.weight = 1.0f;
        layoutParams2.gravity = 17;
        linearLayout.setPadding(com.opos.cmn.an.h.f.a.a(this.y, 24.0f), com.opos.cmn.an.h.f.a.a(this.y, 12.0f), com.opos.cmn.an.h.f.a.a(this.y, 24.0f), com.opos.cmn.an.h.f.a.a(this.y, 22.0f));
        this.w.addView(linearLayout, layoutParams2);
        com.opos.mobad.template.cmn.p.a(linearLayout, this.J);
        TextView textView = new TextView(this.y);
        this.x = textView;
        textView.setText("确认关闭");
        this.x.setTextSize(1, 16.0f);
        this.x.setTextColor(this.y.getResources().getColor(R.color.opos_mobad_retain_btn_color));
        this.x.setMaxLines(2);
        this.x.setGravity(17);
        this.x.setEllipsize(TextUtils.TruncateAt.END);
        this.x.setMinHeight(com.opos.cmn.an.h.f.a.a(this.y, 24.0f));
        com.opos.mobad.template.h.a(this.x);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.gravity = 1;
        linearLayout.addView(this.x, layoutParams3);
        LinearLayout linearLayout2 = new LinearLayout(this.y);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = 17;
        linearLayout2.setPadding(0, com.opos.cmn.an.h.f.a.a(this.y, 14.0f), 0, com.opos.cmn.an.h.f.a.a(this.y, 24.0f));
        this.w.addView(linearLayout2, layoutParams4);
        LinearLayout linearLayout3 = new LinearLayout(this.y);
        linearLayout3.setBackgroundColor(this.y.getResources().getColor(R.color.opos_mobad_retain_split_color));
        linearLayout3.setGravity(17);
        linearLayout2.addView(linearLayout3, new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.y, 1.0f), com.opos.cmn.an.h.f.a.a(this.y, 20.0f)));
        LinearLayout linearLayout4 = new LinearLayout(this.y);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams5.weight = 1.0f;
        layoutParams5.gravity = 17;
        linearLayout4.setPadding(com.opos.cmn.an.h.f.a.a(this.y, 24.0f), com.opos.cmn.an.h.f.a.a(this.y, 12.0f), com.opos.cmn.an.h.f.a.a(this.y, 24.0f), com.opos.cmn.an.h.f.a.a(this.y, 22.0f));
        this.w.addView(linearLayout4, layoutParams5);
        TextView textView2 = new TextView(this.y);
        textView2.setText("确认关闭");
        textView2.setTextSize(1, 16.0f);
        textView2.setGravity(17);
        textView2.setTextColor(this.y.getResources().getColor(R.color.opos_mobad_retain_btn_color));
        textView2.setMinHeight(com.opos.cmn.an.h.f.a.a(this.y, 24.0f));
        com.opos.mobad.template.h.a(textView2);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams6.gravity = 1;
        linearLayout4.addView(textView2, layoutParams6);
        com.opos.mobad.template.cmn.p.a(linearLayout4, this.I);
    }

    @Override // com.opos.mobad.template.a
    public void a(com.opos.mobad.template.d.f fVar) {
        if (fVar == null) {
            com.opos.cmn.an.f.a.b("InterRetainEndPage", "data is null");
        } else {
            com.opos.mobad.template.d.d dVarC = fVar.c();
            if (dVarC != null) {
                if (com.opos.mobad.template.h.d(this.y) && !this.A && !this.H) {
                    this.G = true;
                    int iE = this.B - com.opos.mobad.template.h.e(this.y);
                    this.B = iE;
                    this.b.a(iE);
                    this.H = true;
                    com.opos.cmn.an.f.a.b("InterRetainEndPage", "  isGestureNavMode " + this.G + "  mMaxHeight " + this.B + "  getNavBarHeightRes " + com.opos.mobad.template.h.e(this.y));
                    this.f7672a.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: com.opos.mobad.template.f.m.8
                        @Override // android.view.View.OnApplyWindowInsetsListener
                        public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                            if (Build.VERSION.SDK_INT >= 30) {
                                boolean zIsVisible = windowInsets.isVisible(WindowInsets.Type.navigationBars());
                                com.opos.cmn.an.f.a.b("InterRetainEndPage", zIsVisible + "  isNavBarVisible  ");
                                if (!zIsVisible) {
                                    m.this.B += com.opos.mobad.template.h.e(m.this.y);
                                    m.this.b.a(m.this.B);
                                    com.opos.cmn.an.f.a.b("InterRetainEndPage", "onApplyWindowInsets  mMaxHeight" + m.this.B);
                                }
                            }
                            return windowInsets;
                        }
                    });
                }
                if (dVarC.J.containsKey("EXT_PARAM_KEY_TYPE_INTER_STATUSBAR") && "1".equals(dVarC.J.get("EXT_PARAM_KEY_TYPE_INTER_STATUSBAR")) && !this.A && !this.F) {
                    int iC = this.B - com.opos.mobad.template.h.c(this.y);
                    this.B = iC;
                    this.b.a(iC);
                    this.F = true;
                }
                if ("0".equals(dVarC.J.containsKey("EXT_PARAM_KEY_TYPE_LINK") ? dVarC.J.get("EXT_PARAM_KEY_TYPE_LINK") : null)) {
                    a(dVarC.N, dVarC.P, dVarC.Q, dVarC.K, dVarC.R);
                    return;
                } else if (dVarC.d == null || dVarC.d.size() <= 0) {
                    a(dVarC.M, dVarC.Q, dVarC.R);
                    return;
                } else {
                    a(dVarC.d, dVarC.Q, dVarC.R);
                    return;
                }
            }
            com.opos.cmn.an.f.a.d("InterRetainEndPage", "render with data null");
        }
        a(1);
    }

    @Override // com.opos.mobad.template.a
    public View c() {
        return this.f7672a;
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
        RelativeLayout relativeLayout = this.f7672a;
        if (relativeLayout != null) {
            relativeLayout.clearAnimation();
            this.f7672a.removeAllViews();
        }
    }
}
