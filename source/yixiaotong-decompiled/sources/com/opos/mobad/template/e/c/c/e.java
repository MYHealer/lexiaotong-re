package com.opos.mobad.template.e.c.c;

import android.animation.Animator;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.template.cmn.ae;
import com.opos.mobad.template.cmn.l;
import com.opos.mobad.template.h;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class e extends com.opos.mobad.template.e.c.a implements SensorEventListener {
    private RelativeLayout c;
    private ImageView d;
    private TextView e;
    private com.opos.mobad.template.c f;
    private Animator g;
    private Animator h;
    private Animator i;
    private l j;
    private RelativeLayout k;
    private SensorManager l;
    private boolean m;
    private boolean n;
    private int o;
    private boolean p;
    private int q;
    private int r;
    private float s;
    private float t;
    private float u;
    private long v;
    private boolean w;

    public e(Context context, com.opos.mobad.template.e.a aVar) {
        super(context, aVar);
        this.o = 2;
        this.p = false;
        this.q = 1000;
        this.r = 13000;
        this.v = 0L;
        this.w = false;
        a();
        b();
    }

    private void a(SensorEvent sensorEvent) {
        if (this.w || sensorEvent == null || sensorEvent.values == null || sensorEvent.values.length < 3) {
            return;
        }
        if (this.v <= 0) {
            b(sensorEvent);
            return;
        }
        double dSqrt = Math.sqrt(Math.pow(sensorEvent.values[0] - this.s, 2.0d) + Math.pow(sensorEvent.values[1] - this.t, 2.0d) + Math.pow(sensorEvent.values[2] - this.u, 2.0d));
        float f = this.s;
        float f2 = this.t;
        float f3 = this.u;
        if (dSqrt * 1000.0d < this.r) {
            if (SystemClock.elapsedRealtime() - this.v >= this.q) {
                b(sensorEvent);
            }
        } else {
            this.w = true;
            com.opos.mobad.template.c cVar = this.f;
            if (cVar != null) {
                cVar.b(new int[]{(int) ((sensorEvent.values[0] - f) * 100.0f), (int) ((sensorEvent.values[1] - f2) * 100.0f), (int) ((sensorEvent.values[2] - f3) * 100.0f)});
                com.opos.cmn.an.f.a.b("SplashInteractiveShakeViewOld", "xacc2:" + sensorEvent.values[0] + ",yacc2:" + sensorEvent.values[1] + ",zacc2:" + sensorEvent.values[2] + ",xacc1:" + f + ",yacc1:" + f2 + ",zacc1:" + f3);
            }
            k();
        }
    }

    private void b(SensorEvent sensorEvent) {
        this.s = sensorEvent.values[0];
        this.t = sensorEvent.values[1];
        this.u = sensorEvent.values[2];
        this.v = SystemClock.elapsedRealtime();
    }

    private void k() {
        SensorManager sensorManager = this.l;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this);
            this.l = null;
        }
        this.u = 0.0f;
        this.t = 0.0f;
        this.s = 0.0f;
        this.v = 0L;
    }

    private void l() {
        if (this.l != null) {
            return;
        }
        SensorManager sensorManager = (SensorManager) this.b.getSystemService("sensor");
        this.l = sensorManager;
        Sensor defaultSensor = sensorManager.getDefaultSensor(1);
        if (defaultSensor == null) {
            return;
        }
        this.l.registerListener(this, defaultSensor, 1);
    }

    @Override // com.opos.mobad.template.e.c.a
    protected void a() {
        this.m = h.a();
        this.n = h.a(this.b);
    }

    @Override // com.opos.mobad.template.e.c.a
    public void a(com.opos.mobad.template.cmn.baseview.f fVar) {
    }

    @Override // com.opos.mobad.template.e.c.a
    public void a(com.opos.mobad.template.e.b.a aVar) {
        if (!this.n || aVar == null) {
            return;
        }
        if (!TextUtils.isEmpty(aVar.b)) {
            this.e.setText(aVar.b);
            this.e.setVisibility(0);
        }
        if (aVar instanceof com.opos.mobad.template.e.b.e) {
            com.opos.mobad.template.e.b.e eVar = (com.opos.mobad.template.e.b.e) aVar;
            if (eVar.k > 0) {
                this.q = eVar.k;
            }
            if (eVar.l > 0) {
                this.r = eVar.l;
            }
        }
    }

    @Override // com.opos.mobad.template.e.c.a
    public void a(com.opos.mobad.template.e.c.b bVar) {
        this.f = bVar;
    }

    @Override // com.opos.mobad.template.e.c.a
    protected void b() {
        RelativeLayout relativeLayout = new RelativeLayout(this.b);
        this.c = relativeLayout;
        relativeLayout.setPadding(0, 0, 0, com.opos.cmn.an.h.f.a.a(this.b, this.o));
        this.k = new RelativeLayout(this.b);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.b, 110.0f), com.opos.cmn.an.h.f.a.a(this.b, 110.0f));
        layoutParams.addRule(14);
        this.c.addView(this.k, layoutParams);
        this.k.setId(View.generateViewId());
        ImageView imageView = new ImageView(this.b);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.b, 84.0f), com.opos.cmn.an.h.f.a.a(this.b, 84.0f));
        layoutParams2.addRule(13);
        imageView.setBackgroundResource(R.drawable.opos_mobad_bg_cricle_black);
        this.k.addView(imageView, layoutParams2);
        this.j = new l(this.b);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.b, 110.0f), com.opos.cmn.an.h.f.a.a(this.b, 110.0f));
        layoutParams3.addRule(13);
        this.j.setScaleType(ImageView.ScaleType.FIT_XY);
        this.j.setImageResource(R.drawable.opos_mobad_bg_circle_light);
        this.j.a(com.opos.cmn.an.h.f.a.a(this.b, 28.0f));
        this.j.b(com.opos.cmn.an.h.f.a.a(this.b, 110.0f));
        this.k.addView(this.j, layoutParams3);
        ImageView imageView2 = new ImageView(this.b);
        this.d = imageView2;
        imageView2.setImageResource(R.drawable.opos_mobad_icon_hand);
        this.d.setScaleType(ImageView.ScaleType.CENTER);
        this.k.addView(this.d, layoutParams2);
        TextView textView = new TextView(this.b);
        textView.setTextSize(1, 18.0f);
        textView.setText("摇动手机");
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(this.b, 26.0f));
        layoutParams4.addRule(14);
        layoutParams4.addRule(3, this.k.getId());
        textView.setId(View.generateViewId());
        textView.setTextColor(-1);
        h.a(textView);
        this.c.addView(textView, layoutParams4);
        TextView textView2 = new TextView(this.b);
        this.e = textView2;
        textView2.setTextSize(1, 14.0f);
        this.e.setTextColor(-1);
        h.a(this.e);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(this.b, 20.0f));
        layoutParams5.addRule(14);
        layoutParams5.addRule(3, textView.getId());
        this.e.setVisibility(8);
        this.c.addView(this.e, layoutParams5);
        this.c.setVisibility(4);
        if (this.m) {
            this.h = ae.d(this.d);
            this.i = ae.b(this.j);
        }
    }

    @Override // com.opos.mobad.template.e.c.a
    public View c() {
        return this.c;
    }

    @Override // com.opos.mobad.template.e.c.a
    public void d() {
        Animator animator;
        if (this.n && this.m && (animator = this.i) != null) {
            animator.start();
        }
    }

    @Override // com.opos.mobad.template.e.c.a
    public boolean e() {
        return this.n;
    }

    @Override // com.opos.mobad.template.e.c.c
    public void g() {
        if (this.n && !this.p) {
            this.p = true;
            if (this.m) {
                Animator animatorB = ae.b((View) this.c);
                this.g = animatorB;
                animatorB.addListener(new Animator.AnimatorListener() { // from class: com.opos.mobad.template.e.c.c.e.1
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        e.this.h.start();
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }
                });
                this.g.start();
            }
            l();
        }
    }

    @Override // com.opos.mobad.template.e.c.c
    public void h() {
        if (this.n) {
            l();
        }
    }

    @Override // com.opos.mobad.template.e.c.c
    public void i() {
        k();
    }

    @Override // com.opos.mobad.template.e.c.c
    public void j() {
        Animator animator = this.i;
        if (animator != null) {
            animator.end();
        }
        Animator animator2 = this.g;
        if (animator2 != null) {
            animator2.end();
        }
        Animator animator3 = this.h;
        if (animator3 != null) {
            animator3.end();
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
