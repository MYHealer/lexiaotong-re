package com.opos.mobad.template.i;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Paint;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.SystemClock;
import android.text.TextPaint;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.template.cmn.ae;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class q implements SensorEventListener, d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f8201a;
    private RelativeLayout b;
    private ImageView c;
    private TextView d;
    private com.opos.mobad.template.c e;
    private Animator f;
    private Animator g;
    private Animator h;
    private com.opos.mobad.template.cmn.l i;
    private SensorManager j;
    private int k;
    private float o;
    private float p;
    private float q;
    private boolean l = false;
    private int m = 1000;
    private int n = 13000;
    private long r = 0;
    private boolean s = false;

    public q(Context context, int i) {
        this.f8201a = context;
        this.k = i;
        g();
        this.g = ae.d(this.c);
    }

    private int a(int i) {
        if (i != 0 && i != 1 && i != 5) {
            switch (i) {
                case 9:
                case 10:
                case 11:
                case 12:
                    break;
                default:
                    return 18;
            }
        }
        return 0;
    }

    private void a(SensorEvent sensorEvent) {
        if (this.s || sensorEvent == null || sensorEvent.values == null || sensorEvent.values.length < 3) {
            return;
        }
        if (this.r <= 0) {
            b(sensorEvent);
            return;
        }
        double dSqrt = Math.sqrt(Math.pow(sensorEvent.values[0] - this.o, 2.0d) + Math.pow(sensorEvent.values[1] - this.p, 2.0d) + Math.pow(sensorEvent.values[2] - this.q, 2.0d));
        float f = this.o;
        float f2 = this.p;
        float f3 = this.q;
        if (dSqrt * 1000.0d < this.n) {
            if (SystemClock.elapsedRealtime() - this.r >= this.m) {
                b(sensorEvent);
            }
        } else {
            this.s = true;
            com.opos.mobad.template.c cVar = this.e;
            if (cVar != null) {
                cVar.b(new int[]{(int) ((sensorEvent.values[0] - f) * 100.0f), (int) ((sensorEvent.values[1] - f2) * 100.0f), (int) ((sensorEvent.values[2] - f3) * 100.0f)});
                com.opos.cmn.an.f.a.b("SplashShakeView", "xacc2:" + sensorEvent.values[0] + ",yacc2:" + sensorEvent.values[1] + ",zacc2:" + sensorEvent.values[2] + ",xacc1:" + f + ",yacc1:" + f2 + ",zacc1:" + f3);
            }
            h();
        }
    }

    private void a(TextView textView) {
        if (textView != null) {
            TextPaint paint = textView.getPaint();
            paint.setStrokeWidth(0.8f);
            paint.setStyle(Paint.Style.FILL_AND_STROKE);
        }
    }

    private void b(SensorEvent sensorEvent) {
        this.o = sensorEvent.values[0];
        this.p = sensorEvent.values[1];
        this.q = sensorEvent.values[2];
        this.r = SystemClock.elapsedRealtime();
    }

    private void g() {
        RelativeLayout relativeLayout = new RelativeLayout(this.f8201a);
        this.b = relativeLayout;
        relativeLayout.setPadding(0, 0, 0, com.opos.cmn.an.h.f.a.a(this.f8201a, a(this.k)));
        RelativeLayout relativeLayout2 = new RelativeLayout(this.f8201a);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f8201a, 110.0f), com.opos.cmn.an.h.f.a.a(this.f8201a, 110.0f));
        layoutParams.addRule(14);
        this.b.addView(relativeLayout2, layoutParams);
        relativeLayout2.setId(View.generateViewId());
        ImageView imageView = new ImageView(this.f8201a);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f8201a, 84.0f), com.opos.cmn.an.h.f.a.a(this.f8201a, 84.0f));
        layoutParams2.addRule(13);
        imageView.setBackgroundResource(R.drawable.opos_mobad_bg_cricle_black);
        relativeLayout2.addView(imageView, layoutParams2);
        this.i = new com.opos.mobad.template.cmn.l(this.f8201a);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f8201a, 110.0f), com.opos.cmn.an.h.f.a.a(this.f8201a, 110.0f));
        layoutParams3.addRule(13);
        this.i.setScaleType(ImageView.ScaleType.FIT_XY);
        this.i.setImageResource(R.drawable.opos_mobad_bg_circle_light);
        this.i.a(com.opos.cmn.an.h.f.a.a(this.f8201a, 28.0f));
        this.i.b(com.opos.cmn.an.h.f.a.a(this.f8201a, 110.0f));
        relativeLayout2.addView(this.i, layoutParams3);
        ImageView imageView2 = new ImageView(this.f8201a);
        this.c = imageView2;
        imageView2.setImageResource(R.drawable.opos_mobad_icon_hand);
        this.c.setScaleType(ImageView.ScaleType.CENTER);
        relativeLayout2.addView(this.c, layoutParams2);
        TextView textView = new TextView(this.f8201a);
        textView.setTextSize(1, 18.0f);
        textView.setText("摇动手机");
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        if (this.k != 12) {
            layoutParams4.topMargin = com.opos.cmn.an.h.f.a.a(this.f8201a, 12.0f);
        }
        layoutParams4.addRule(14);
        layoutParams4.addRule(3, relativeLayout2.getId());
        textView.setId(View.generateViewId());
        textView.setTextColor(-1);
        a(textView);
        this.b.addView(textView, layoutParams4);
        TextView textView2 = new TextView(this.f8201a);
        this.d = textView2;
        textView2.setTextSize(1, 14.0f);
        this.d.setTextColor(-1);
        a(this.d);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams5.addRule(14);
        layoutParams5.addRule(3, textView.getId());
        this.b.addView(this.d, layoutParams5);
        this.b.setVisibility(4);
    }

    private void h() {
        SensorManager sensorManager = this.j;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this);
            this.j = null;
        }
        this.q = 0.0f;
        this.p = 0.0f;
        this.o = 0.0f;
        this.r = 0L;
    }

    private void i() {
        if (this.j != null) {
            return;
        }
        SensorManager sensorManager = (SensorManager) this.f8201a.getSystemService("sensor");
        this.j = sensorManager;
        Sensor defaultSensor = sensorManager.getDefaultSensor(1);
        if (defaultSensor == null) {
            return;
        }
        this.j.registerListener(this, defaultSensor, 1);
    }

    @Override // com.opos.mobad.template.i.d
    public View a() {
        return this.b;
    }

    @Override // com.opos.mobad.template.i.d
    public void a(com.opos.mobad.template.cmn.baseview.f fVar) {
    }

    @Override // com.opos.mobad.template.i.d
    public void a(c cVar) {
        this.e = cVar;
    }

    @Override // com.opos.mobad.template.i.d
    public void a(String str, int i, int i2, Map<String, String> map) {
        this.d.setText(str);
        if (i > 0) {
            this.m = i;
        }
        if (i2 > 0) {
            this.n = i2;
        }
    }

    @Override // com.opos.mobad.template.i.d
    public void b() {
        if (this.h == null) {
            this.h = ae.b(this.i);
        }
        this.h.start();
    }

    @Override // com.opos.mobad.template.i.d
    public void c() {
        if (this.l) {
            return;
        }
        this.l = true;
        Animator animatorB = ae.b((View) this.b);
        this.f = animatorB;
        animatorB.addListener(new Animator.AnimatorListener() { // from class: com.opos.mobad.template.i.q.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                q.this.g.start();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        this.f.start();
        i();
    }

    @Override // com.opos.mobad.template.i.d
    public void d() {
        h();
    }

    @Override // com.opos.mobad.template.i.d
    public void e() {
        i();
    }

    @Override // com.opos.mobad.template.i.d
    public void f() {
        Animator animator = this.h;
        if (animator != null) {
            animator.end();
        }
        Animator animator2 = this.f;
        if (animator2 != null) {
            animator2.end();
        }
        Animator animator3 = this.g;
        if (animator3 != null) {
            animator3.end();
        }
        h();
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        a(sensorEvent);
    }
}
