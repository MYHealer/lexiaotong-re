package com.opos.mobad.template.i;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Paint;
import android.graphics.drawable.GradientDrawable;
import android.text.TextPaint;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.ViewCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.google.android.exoplayer2.ExoPlayer;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.template.cmn.baseview.BaseTextView;
import com.stub.StubApp;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class t implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.opos.mobad.template.cmn.baseview.c f8209a;
    private com.opos.mobad.template.cmn.baseview.c b;
    private Context c;
    private j d;
    private com.opos.mobad.template.cmn.p e;
    private BaseTextView f;
    private TextView g;
    private RelativeLayout h;
    private int i;
    private int j;
    private int k;
    private int l;
    private final int m;
    private boolean n;
    private com.opos.mobad.d.c.d o;
    private AnimatorSet p;
    private View q;
    private ImageView r;
    private boolean t;
    private final long u = 1000;
    private final long v = 500;
    private final View.OnTouchListener w = new View.OnTouchListener() { // from class: com.opos.mobad.template.i.t.1
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                t.this.i = (int) motionEvent.getX();
                t.this.j = (int) motionEvent.getY();
                t.this.n = false;
            } else if (2 == motionEvent.getAction()) {
                int y = (int) motionEvent.getY();
                int x = (int) motionEvent.getX();
                if (t.this.d == j.SLIDE_UP && y <= 0 && !t.this.n) {
                    t.this.a(x, y);
                }
            } else if (1 == motionEvent.getAction()) {
                t.this.k = (int) motionEvent.getX();
                t.this.l = (int) motionEvent.getY();
                if (t.this.d == j.SLIDE_UP && ((t.this.i == t.this.k && t.this.j == t.this.l) || (t.this.j - t.this.l > ((double) t.this.m) * 0.4d && !t.this.n))) {
                    t tVar = t.this;
                    tVar.a(tVar.k, t.this.l);
                }
            }
            return true;
        }
    };
    private final Runnable x = new Runnable() { // from class: com.opos.mobad.template.i.t.2
        @Override // java.lang.Runnable
        public void run() {
            if (t.this.t) {
                return;
            }
            t.this.p.start();
            t.this.o.a(ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
        }
    };
    private final int[] s = {1728053247, ViewCompat.MEASURED_SIZE_MASK};

    public t(Context context, j jVar, int i) {
        this.c = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.d = jVar;
        this.b = new com.opos.mobad.template.cmn.baseview.c(this.c);
        int iA = a(i);
        int iA2 = com.opos.cmn.an.h.f.a.a(this.c, 290.0f);
        this.m = iA2;
        this.f8209a = new com.opos.mobad.template.cmn.baseview.c(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, iA2);
        this.f8209a.setPadding(0, 0, 0, com.opos.cmn.an.h.f.a.a(context, iA));
        layoutParams.addRule(13);
        this.b.addView(this.f8209a, layoutParams);
        this.b.setVisibility(4);
        h();
        i();
        j();
        g();
    }

    private int a(int i) {
        if (i != 0) {
            switch (i) {
                case 2:
                case 7:
                    return 87;
                case 3:
                    return 46;
                case 4:
                case 11:
                case 12:
                    return 42;
                case 5:
                case 6:
                case 9:
                case 10:
                    break;
                case 8:
                    return 37;
                default:
                    return 81;
            }
        }
        return 80;
    }

    private ValueAnimator a(final View view, int i, int i2) {
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(i, i2);
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.opos.mobad.template.i.t.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (t.this.t) {
                    return;
                }
                int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                layoutParams.height = iIntValue;
                view.setLayoutParams(layoutParams);
            }
        });
        return valueAnimatorOfInt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2) {
        int[] iArr = {this.i, this.j, i, i2};
        this.n = true;
        com.opos.mobad.template.cmn.p pVar = this.e;
        if (pVar != null) {
            pVar.b(this.b, iArr);
        }
    }

    private void a(TextView textView) {
        if (textView != null) {
            TextPaint paint = textView.getPaint();
            paint.setStrokeWidth(0.8f);
            paint.setStyle(Paint.Style.FILL_AND_STROKE);
        }
    }

    private void g() {
        this.f8209a.setOnTouchListener(this.w);
    }

    private void h() {
        BaseTextView baseTextView = new BaseTextView(this.c);
        this.f = baseTextView;
        baseTextView.setId(View.generateViewId());
        this.f.setTextSize(1, 14.0f);
        this.f.setTextColor(ColorUtils.setAlphaComponent(-1, 216));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        this.f8209a.addView(this.f, layoutParams);
        a(this.f);
    }

    private void i() {
        TextView textView = new TextView(this.c);
        this.g = textView;
        textView.setId(View.generateViewId());
        this.g.setText("向上滑动");
        this.g.setTextColor(-1);
        this.g.setTextSize(1, 18.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(2, this.f.getId());
        layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.c, 1.0f);
        this.f8209a.addView(this.g, layoutParams);
        a(this.g);
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
    private void j() {
        int iA = com.opos.cmn.an.h.f.a.a(this.c, 60.0f);
        int iA2 = com.opos.cmn.an.h.f.a.a(this.c, 41.0f);
        RelativeLayout relativeLayout = new RelativeLayout(this.c);
        this.h = new RelativeLayout(this.c);
        this.q = new View(this.c);
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.s);
        gradientDrawable.setShape(0);
        this.q.setBackground(gradientDrawable);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (iA * 0.7f), -1);
        layoutParams.addRule(12);
        layoutParams.topMargin = (iA2 / 2) - com.opos.cmn.an.h.f.a.a(this.c, 2.0f);
        layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(this.c, 1.0f);
        layoutParams.addRule(11);
        ImageView imageView = new ImageView(this.c);
        this.r = imageView;
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(iA, iA2);
        layoutParams2.addRule(14);
        this.r.setImageResource(R.drawable.opos_mobad_slide_up);
        this.h.addView(this.r, layoutParams2);
        this.h.addView(this.q, layoutParams);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(iA, com.opos.cmn.an.h.f.a.a(this.c, 138.0f));
        layoutParams3.addRule(14);
        relativeLayout.addView(this.h, layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams4.addRule(14);
        layoutParams4.addRule(2, this.g.getId());
        layoutParams4.bottomMargin = com.opos.cmn.an.h.f.a.a(this.c, 1.0f);
        this.f8209a.addView(relativeLayout, layoutParams4);
    }

    @Override // com.opos.mobad.template.i.d
    public View a() {
        return this.b;
    }

    @Override // com.opos.mobad.template.i.d
    public void a(com.opos.mobad.template.cmn.baseview.f fVar) {
        this.b.a(fVar);
        this.f8209a.a(fVar);
    }

    @Override // com.opos.mobad.template.i.d
    public void a(c cVar) {
        this.e = cVar;
    }

    @Override // com.opos.mobad.template.i.d
    public void a(String str, int i, int i2, Map<String, String> map) {
        this.f.setText(str);
    }

    @Override // com.opos.mobad.template.i.d
    public void b() {
    }

    @Override // com.opos.mobad.template.i.d
    public void c() {
        this.t = false;
        com.opos.mobad.d.c.d dVar = this.o;
        if (dVar != null) {
            dVar.a();
            this.o.b();
        }
        Interpolator interpolatorCreate = PathInterpolatorCompat.create(0.3f, 0.0f, 0.1f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.h, "alpha", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.r, "translationY", com.opos.cmn.an.h.f.a.a(this.c, 98.0f), 0.0f);
        objectAnimatorOfFloat2.setInterpolator(interpolatorCreate);
        ValueAnimator valueAnimatorA = a(this.q, com.opos.cmn.an.h.f.a.a(this.c, 20.0f), com.opos.cmn.an.h.f.a.a(this.c, 118.0f));
        valueAnimatorA.setInterpolator(interpolatorCreate);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(1000L);
        animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2, valueAnimatorA);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.h, "alpha", 1.0f, 0.0f);
        objectAnimatorOfFloat3.setDuration(500L);
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.p = animatorSet2;
        animatorSet2.playSequentially(animatorSet, objectAnimatorOfFloat3);
        com.opos.mobad.d.c.d dVar2 = new com.opos.mobad.d.c.d(com.opos.mobad.d.c.c.a(), this.x);
        this.o = dVar2;
        dVar2.a(0L);
    }

    @Override // com.opos.mobad.template.i.d
    public void d() {
        com.opos.mobad.d.c.d dVar = this.o;
        if (dVar != null) {
            dVar.a();
            this.o.b();
        }
        AnimatorSet animatorSet = this.p;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }

    @Override // com.opos.mobad.template.i.d
    public void e() {
        com.opos.mobad.d.c.d dVar = this.o;
        if (dVar != null) {
            dVar.a(0L);
        }
    }

    @Override // com.opos.mobad.template.i.d
    public void f() {
        com.opos.cmn.an.f.a.b("SplashSlideView", "destroy");
        this.t = true;
        AnimatorSet animatorSet = this.p;
        if (animatorSet != null) {
            animatorSet.end();
        }
        com.opos.mobad.d.c.d dVar = this.o;
        if (dVar != null) {
            dVar.a();
            this.o.b();
        }
    }
}
