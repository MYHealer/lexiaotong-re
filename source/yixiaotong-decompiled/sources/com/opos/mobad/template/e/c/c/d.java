package com.opos.mobad.template.e.c.c;

import android.animation.Animator;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.SystemClock;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.template.cmn.ae;
import com.opos.mobad.template.cmn.l;
import com.opos.mobad.template.h;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class d extends com.opos.mobad.template.e.c.a implements SensorEventListener {
    private RelativeLayout c;
    private ImageView d;
    private com.opos.mobad.template.c e;
    private Animator f;
    private Animator g;
    private l h;
    private RelativeLayout i;
    private SensorManager j;
    private boolean k;
    private boolean l;
    private int m;
    private boolean n;
    private int o;
    private int p;
    private float q;
    private float r;
    private float s;
    private long t;
    private boolean u;

    public d(Context context, com.opos.mobad.template.e.a aVar, int i) {
        super(context, aVar);
        this.n = false;
        this.o = 1000;
        this.p = 13000;
        this.t = 0L;
        this.u = false;
        a();
        this.m = i;
        b();
    }

    private void a(SensorEvent sensorEvent) {
        if (this.u || sensorEvent == null || sensorEvent.values == null || sensorEvent.values.length < 3) {
            return;
        }
        if (this.t <= 0) {
            b(sensorEvent);
            return;
        }
        double dSqrt = Math.sqrt(Math.pow(sensorEvent.values[0] - this.q, 2.0d) + Math.pow(sensorEvent.values[1] - this.r, 2.0d) + Math.pow(sensorEvent.values[2] - this.s, 2.0d));
        float f = this.q;
        float f2 = this.r;
        float f3 = this.s;
        if (dSqrt * 1000.0d < this.p) {
            if (SystemClock.elapsedRealtime() - this.t >= this.o) {
                b(sensorEvent);
            }
        } else {
            this.u = true;
            com.opos.mobad.template.c cVar = this.e;
            if (cVar != null) {
                cVar.b(new int[]{(int) ((sensorEvent.values[0] - f) * 100.0f), (int) ((sensorEvent.values[1] - f2) * 100.0f), (int) ((sensorEvent.values[2] - f3) * 100.0f)});
                com.opos.cmn.an.f.a.b("SplashInteractiveShakeView", "xacc2:" + sensorEvent.values[0] + ",yacc2:" + sensorEvent.values[1] + ",zacc2:" + sensorEvent.values[2] + ",xacc1:" + f + ",yacc1:" + f2 + ",zacc1:" + f3);
            }
            k();
        }
    }

    private void b(SensorEvent sensorEvent) {
        this.q = sensorEvent.values[0];
        this.r = sensorEvent.values[1];
        this.s = sensorEvent.values[2];
        this.t = SystemClock.elapsedRealtime();
    }

    private void k() {
        SensorManager sensorManager = this.j;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this);
            this.j = null;
        }
        this.s = 0.0f;
        this.r = 0.0f;
        this.q = 0.0f;
        this.t = 0L;
    }

    private void l() {
        if (this.j != null) {
            return;
        }
        SensorManager sensorManager = (SensorManager) this.b.getSystemService("sensor");
        this.j = sensorManager;
        Sensor defaultSensor = sensorManager.getDefaultSensor(1);
        if (defaultSensor == null) {
            return;
        }
        this.j.registerListener(this, defaultSensor, 1);
    }

    @Override // com.opos.mobad.template.e.c.a
    protected void a() {
        this.k = h.a();
        this.l = h.a(this.b);
    }

    @Override // com.opos.mobad.template.e.c.a
    public void a(com.opos.mobad.template.cmn.baseview.f fVar) {
    }

    @Override // com.opos.mobad.template.e.c.a
    public void a(com.opos.mobad.template.e.b.a aVar) {
        if (this.l && aVar != null && (aVar instanceof com.opos.mobad.template.e.b.e)) {
            com.opos.mobad.template.e.b.e eVar = (com.opos.mobad.template.e.b.e) aVar;
            if (eVar.k > 0) {
                this.o = eVar.k;
            }
            if (eVar.l > 0) {
                this.p = eVar.l;
            }
        }
    }

    @Override // com.opos.mobad.template.e.c.a
    public void a(com.opos.mobad.template.e.c.b bVar) {
        this.e = bVar;
    }

    @Override // com.opos.mobad.template.e.c.a
    protected void b() {
        this.c = new RelativeLayout(this.b);
        if (this.m == 1) {
            this.d = new ImageView(this.b);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.b, 20.0f), com.opos.cmn.an.h.f.a.a(this.b, 20.0f));
            layoutParams.addRule(15);
            layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(this.b, 6.0f);
            this.d.setImageResource(R.drawable.opos_mobad_icon_hand);
            this.d.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            this.c.addView(this.d, layoutParams);
            this.c.setVisibility(4);
            if (this.k) {
                this.g = ae.g(this.d);
                return;
            }
            return;
        }
        this.i = new RelativeLayout(this.b);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.b, 110.0f), com.opos.cmn.an.h.f.a.a(this.b, 110.0f));
        layoutParams2.addRule(14);
        this.c.addView(this.i, layoutParams2);
        this.i.setId(View.generateViewId());
        ImageView imageView = new ImageView(this.b);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.b, 84.0f), com.opos.cmn.an.h.f.a.a(this.b, 84.0f));
        layoutParams3.addRule(13);
        imageView.setBackgroundResource(R.drawable.opos_mobad_bg_cricle_black);
        this.i.addView(imageView, layoutParams3);
        this.h = new l(this.b);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.b, 110.0f), com.opos.cmn.an.h.f.a.a(this.b, 110.0f));
        layoutParams4.addRule(13);
        this.h.setScaleType(ImageView.ScaleType.FIT_XY);
        this.h.setImageResource(R.drawable.opos_mobad_bg_circle_light);
        this.h.a(com.opos.cmn.an.h.f.a.a(this.b, 28.0f));
        this.h.b(com.opos.cmn.an.h.f.a.a(this.b, 110.0f));
        this.i.addView(this.h, layoutParams4);
        ImageView imageView2 = new ImageView(this.b);
        this.d = imageView2;
        imageView2.setImageResource(R.drawable.opos_mobad_icon_hand);
        this.d.setScaleType(ImageView.ScaleType.CENTER);
        this.i.addView(this.d, layoutParams3);
        TextView textView = new TextView(this.b);
        textView.setTextSize(1, 18.0f);
        textView.setText("摇动手机");
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(this.b, 26.0f));
        layoutParams5.addRule(14);
        layoutParams5.addRule(3, this.i.getId());
        textView.setId(View.generateViewId());
        textView.setTextColor(-1);
        h.a(textView);
        this.c.addView(textView, layoutParams5);
        this.c.setVisibility(4);
        if (this.k) {
            this.g = ae.d(this.d);
        }
    }

    @Override // com.opos.mobad.template.e.c.a
    public View c() {
        return this.c;
    }

    @Override // com.opos.mobad.template.e.c.a
    public boolean e() {
        return this.l;
    }

    @Override // com.opos.mobad.template.e.c.c
    public void g() {
        if (this.l && !this.n) {
            this.n = true;
            if (this.k) {
                Animator animatorB = ae.b((View) this.c);
                this.f = animatorB;
                animatorB.addListener(new Animator.AnimatorListener() { // from class: com.opos.mobad.template.e.c.c.d.1
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        d.this.g.start();
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }
                });
                this.f.start();
            }
            l();
        }
    }

    @Override // com.opos.mobad.template.e.c.c
    public void h() {
        if (this.l) {
            l();
        }
    }

    @Override // com.opos.mobad.template.e.c.c
    public void i() {
        k();
    }

    @Override // com.opos.mobad.template.e.c.c
    public void j() {
        Animator animator = this.f;
        if (animator != null) {
            animator.end();
        }
        Animator animator2 = this.g;
        if (animator2 != null) {
            animator2.end();
        }
        k();
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        a(sensorEvent);
    }
}
