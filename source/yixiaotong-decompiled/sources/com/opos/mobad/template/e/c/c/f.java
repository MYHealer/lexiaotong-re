package com.opos.mobad.template.e.c.c;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.template.cmn.baseview.BaseTextView;
import com.opos.mobad.template.cmn.w;
import com.opos.mobad.template.h;
import java.math.BigDecimal;
import java.math.RoundingMode;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class f extends com.opos.mobad.template.e.c.a implements com.opos.mobad.template.k.d.a {
    float c;
    private final int d;
    private boolean e;
    private boolean f;
    private boolean g;
    private boolean h;
    private RelativeLayout i;
    private RelativeLayout j;
    private RelativeLayout k;
    private ImageView l;
    private w m;
    private w n;
    private RelativeLayout o;
    private TextView p;
    private BaseTextView q;
    private com.opos.mobad.template.cmn.baseview.c r;
    private RelativeLayout s;
    private com.opos.mobad.template.e.c.b t;
    private AnimatorSet u;
    private com.opos.mobad.template.k.d v;
    private boolean w;
    private int x;
    private int y;
    private boolean z;

    public f(Context context, com.opos.mobad.template.e.a aVar) {
        super(context, aVar);
        this.d = 42;
        this.g = false;
        this.h = false;
        this.w = false;
        this.x = 30;
        this.y = 2000;
        this.z = true;
        a();
        b();
    }

    private void k() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.k, "rotationY", 0.0f, 30.0f);
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.m, PropertyValuesHolder.ofFloat("scaleX", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(400L);
        animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfPropertyValuesHolder);
        animatorSet.setStartDelay(500L);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.k, "rotationY", 30.0f, 0.0f);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.m, "alpha", 1.0f, 0.0f);
        ObjectAnimator objectAnimatorOfPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(this.n, PropertyValuesHolder.ofFloat("scaleX", 0.0f, 0.8f), PropertyValuesHolder.ofFloat("alpha", 0.0f, 0.8f));
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.setDuration(300L);
        animatorSet2.playTogether(objectAnimatorOfFloat2, objectAnimatorOfFloat3, objectAnimatorOfPropertyValuesHolder2);
        animatorSet2.setStartDelay(500L);
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(this.k, "rotationY", 360.0f, 330.0f);
        ObjectAnimator objectAnimatorOfPropertyValuesHolder3 = ObjectAnimator.ofPropertyValuesHolder(this.n, PropertyValuesHolder.ofFloat("scaleX", 0.8f, 1.0f), PropertyValuesHolder.ofFloat("alpha", 0.8f, 1.0f));
        AnimatorSet animatorSet3 = new AnimatorSet();
        animatorSet3.setDuration(200L);
        animatorSet3.playTogether(objectAnimatorOfFloat4, objectAnimatorOfPropertyValuesHolder3);
        ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(this.k, "rotationY", 330.0f, 360.0f);
        ObjectAnimator objectAnimatorOfFloat6 = ObjectAnimator.ofFloat(this.n, "alpha", 1.0f, 0.0f);
        AnimatorSet animatorSet4 = new AnimatorSet();
        animatorSet4.setDuration(200L);
        animatorSet4.playTogether(objectAnimatorOfFloat5, objectAnimatorOfFloat6);
        animatorSet4.setStartDelay(500L);
        AnimatorSet animatorSet5 = new AnimatorSet();
        this.u = animatorSet5;
        animatorSet5.playSequentially(animatorSet, animatorSet2, animatorSet3, animatorSet4);
        this.u.addListener(new AnimatorListenerAdapter() { // from class: com.opos.mobad.template.e.c.c.f.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                f.this.u.start();
            }
        });
    }

    private void l() {
        RelativeLayout relativeLayout;
        float f;
        if (this.w) {
            return;
        }
        if (this.c > 0.0f) {
            this.n.setAlpha(0.0f);
            this.m.setAlpha(1.0f);
            this.m.setScaleX(1.0f);
            relativeLayout = this.k;
            f = 30.0f;
        } else {
            this.m.setAlpha(0.0f);
            this.n.setAlpha(1.0f);
            this.n.setScaleX(1.0f);
            relativeLayout = this.k;
            f = 330.0f;
        }
        relativeLayout.setRotationY(f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        if (this.w) {
            return;
        }
        this.m.setAlpha(0.0f);
        this.n.setAlpha(0.0f);
        this.k.setRotationY(0.0f);
    }

    @Override // com.opos.mobad.template.e.c.a
    protected void a() {
        this.e = h.a();
        this.f = h.b(this.b);
    }

    @Override // com.opos.mobad.template.k.d.a
    public void a(float f, float f2) {
        if (this.w || this.z) {
            return;
        }
        if (!this.f || this.v.a()) {
            float fFloatValue = new BigDecimal(Math.abs(f2 - f)).divide(new BigDecimal(this.x), 6, RoundingMode.HALF_UP).floatValue();
            if (fFloatValue <= 1.0f) {
                this.c = f2;
                if (f2 > 0.0f) {
                    this.n.setAlpha(0.0f);
                    this.m.setAlpha(fFloatValue);
                    this.m.setScaleX(fFloatValue);
                    this.k.setRotationY(fFloatValue * 30.0f);
                    return;
                }
                this.m.setAlpha(0.0f);
                this.n.setAlpha(fFloatValue);
                this.n.setScaleX(fFloatValue);
                this.k.setRotationY(360.0f - (fFloatValue * 30.0f));
            }
        }
    }

    @Override // com.opos.mobad.template.k.d.a
    public void a(int i, int[] iArr) {
        if (this.w || this.t == null) {
            return;
        }
        l();
        this.t.a(i, iArr);
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.opos.mobad.template.e.c.c.f.2
            @Override // java.lang.Runnable
            public void run() {
                f.this.m();
            }
        }, 1000L);
    }

    @Override // com.opos.mobad.template.e.c.a
    public void a(com.opos.mobad.template.cmn.baseview.f fVar) {
        this.r.a(fVar);
    }

    @Override // com.opos.mobad.template.e.c.a
    public void a(com.opos.mobad.template.e.b.a aVar) {
        com.opos.mobad.template.k.d dVar;
        if (aVar instanceof com.opos.mobad.template.e.b.g) {
            com.opos.mobad.template.e.b.g gVar = (com.opos.mobad.template.e.b.g) aVar;
            if (gVar.k > 0) {
                this.y = gVar.k;
            }
            if (gVar.l > 0) {
                this.x = gVar.l;
            }
            this.z = gVar.m;
        }
        if (this.f) {
            this.o.setVisibility(0);
            this.p.setVisibility(0);
            com.opos.mobad.template.k.d dVar2 = this.v;
            if (dVar2 != null) {
                dVar2.a(this.x, this.y, this.z);
            }
            if (this.e && this.g && !this.h) {
                this.h = true;
                if (this.z || !((dVar = this.v) == null || dVar.a())) {
                    if (this.u.isStarted()) {
                        return;
                    }
                    this.u.start();
                } else if (this.u.isStarted()) {
                    this.u.cancel();
                }
            }
        }
    }

    @Override // com.opos.mobad.template.e.c.a
    public void a(com.opos.mobad.template.e.c.b bVar) {
        this.t = bVar;
        this.r.setOnTouchListener(bVar);
        this.r.setOnClickListener(bVar);
    }

    @Override // com.opos.mobad.template.e.c.a
    protected void b() {
        this.i = new RelativeLayout(this.b);
        this.j = new RelativeLayout(this.b);
        this.i.addView(this.j, new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.b, 176.0f)));
        this.i.setVisibility(4);
        this.s = new RelativeLayout(this.b);
        this.r = new com.opos.mobad.template.cmn.baseview.c(this.b);
        this.q = new BaseTextView(this.b);
        TextView textView = new TextView(this.b);
        this.p = textView;
        textView.setId(View.generateViewId());
        this.p.setTextSize(1, 18.0f);
        this.p.setText("倾斜手机");
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.b, 12.0f);
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.b, 12.0f);
        this.p.setTextColor(-1);
        h.a(this.p);
        this.p.setVisibility(4);
        this.j.addView(this.p, layoutParams);
        RelativeLayout relativeLayout = new RelativeLayout(this.b);
        this.o = relativeLayout;
        relativeLayout.setPadding(0, 0, 0, com.opos.cmn.an.h.f.a.a(this.b, 4.0f));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.b, 84.0f), com.opos.cmn.an.h.f.a.a(this.b, 84.0f));
        layoutParams2.addRule(14);
        layoutParams2.addRule(2, this.p.getId());
        this.j.addView(this.o, layoutParams2);
        this.o.setVisibility(4);
        this.k = new RelativeLayout(this.b);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.b, 30.0f), com.opos.cmn.an.h.f.a.a(this.b, 48.0f));
        layoutParams3.addRule(14);
        layoutParams3.addRule(12);
        this.o.addView(this.k, layoutParams3);
        this.l = new ImageView(this.b);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.b, 30.0f), com.opos.cmn.an.h.f.a.a(this.b, 48.0f));
        layoutParams4.addRule(14);
        this.l.setImageResource(R.drawable.opos_mobad_phone);
        this.l.setScaleType(ImageView.ScaleType.FIT_XY);
        this.k.addView(this.l, layoutParams4);
        w wVar = new w(this.b);
        this.m = wVar;
        wVar.a(com.opos.cmn.an.h.f.a.a(this.b, 6.0f));
        this.m.setBackgroundColor(Color.argb(153, 255, 255, 255));
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.b, 30.0f), com.opos.cmn.an.h.f.a.a(this.b, 48.0f));
        layoutParams5.addRule(15);
        this.m.setPivotX(0.0f);
        this.m.setAlpha(0.0f);
        this.k.addView(this.m, layoutParams5);
        w wVar2 = new w(this.b);
        this.n = wVar2;
        wVar2.a(com.opos.cmn.an.h.f.a.a(this.b, 6.0f));
        this.n.setBackgroundColor(Color.argb(153, 255, 255, 255));
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.b, 30.0f), com.opos.cmn.an.h.f.a.a(this.b, 48.0f));
        layoutParams6.addRule(15);
        this.n.setPivotX(com.opos.cmn.an.h.f.a.a(this.b, 30.0f));
        this.n.setAlpha(0.0f);
        this.k.addView(this.n, layoutParams6);
        if (this.f) {
            this.v = new com.opos.mobad.template.k.d(this.b, this);
            if (this.e) {
                k();
            }
        }
    }

    @Override // com.opos.mobad.template.e.c.a
    public View c() {
        return this.i;
    }

    @Override // com.opos.mobad.template.e.c.c
    public void g() {
        if (this.e && !this.g) {
            this.g = true;
            if (this.f) {
                this.v.b();
                if (this.e) {
                    if (this.z || !this.v.a()) {
                        this.u.start();
                    }
                }
            }
        }
    }

    @Override // com.opos.mobad.template.e.c.c
    public void h() {
        if (this.f) {
            this.v.b();
        }
    }

    @Override // com.opos.mobad.template.e.c.c
    public void i() {
        if (this.f) {
            this.v.d();
        }
    }

    @Override // com.opos.mobad.template.e.c.c
    public void j() {
        this.w = true;
        h.a(this.u);
        com.opos.mobad.template.k.d dVar = this.v;
        if (dVar != null) {
            dVar.d();
        }
        RelativeLayout relativeLayout = this.i;
        if (relativeLayout != null) {
            relativeLayout.removeAllViews();
        }
    }
}
