package com.opos.mobad.template.e.c;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.template.cmn.ae;
import com.opos.mobad.template.cmn.baseview.f;
import com.opos.mobad.template.cmn.k;
import com.opos.mobad.template.cmn.x;
import com.opos.mobad.template.h;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class d extends a implements SensorEventListener {
    private b c;
    private RelativeLayout d;
    private ImageView e;
    private TextView f;
    private k g;
    private x h;
    private Animator i;
    private Animator j;
    private SensorManager k;
    private int l;
    private int m;
    private boolean n;
    private boolean o;
    private boolean p;
    private boolean q;
    private boolean r;
    private boolean s;
    private int t;
    private int u;
    private float v;
    private float w;
    private float x;
    private long y;
    private boolean z;

    public d(Context context, com.opos.mobad.template.e.a aVar, int i, int i2, boolean z) {
        super(context, aVar);
        this.q = false;
        this.r = false;
        this.s = false;
        this.t = 1000;
        this.u = 13000;
        this.y = 0L;
        this.z = false;
        this.p = z;
        this.l = i;
        this.m = i2;
        a();
        b();
    }

    private void a(Context context) {
        com.opos.mobad.d.e.a aVar = new com.opos.mobad.d.e.a(context);
        aVar.a(new com.opos.mobad.d.e.a.InterfaceC0958a() { // from class: com.opos.mobad.template.e.c.d.1
            @Override // com.opos.mobad.d.e.a.InterfaceC0958a
            public void a(boolean z) {
                d.this.r = z;
                if (!z) {
                    d.this.i();
                    return;
                }
                if (d.this.h != null && d.this.h.getVisibility() != 0) {
                    d.this.h.setVisibility(0);
                    d.this.k();
                }
                d.this.g();
                d.this.h();
            }
        });
        this.d.addView(aVar, new RelativeLayout.LayoutParams(0, 0));
    }

    private void a(SensorEvent sensorEvent) {
        if (this.z || this.q || !this.r || sensorEvent == null || sensorEvent.values == null || sensorEvent.values.length < 3) {
            return;
        }
        if (this.y <= 0) {
            b(sensorEvent);
            return;
        }
        double dSqrt = Math.sqrt(Math.pow(sensorEvent.values[0] - this.v, 2.0d) + Math.pow(sensorEvent.values[1] - this.w, 2.0d) + Math.pow(sensorEvent.values[2] - this.x, 2.0d));
        float f = this.v;
        float f2 = this.w;
        float f3 = this.x;
        if (dSqrt * 1000.0d < this.u) {
            if (SystemClock.elapsedRealtime() - this.y >= this.t) {
                b(sensorEvent);
                return;
            }
            return;
        }
        this.z = true;
        b bVar = this.c;
        if (bVar != null) {
            if (this.l == 1) {
                bVar.a(new int[]{(int) ((sensorEvent.values[0] - f) * 100.0f), (int) ((sensorEvent.values[1] - f2) * 100.0f), (int) ((sensorEvent.values[2] - f3) * 100.0f)});
            } else {
                bVar.b(new int[]{(int) ((sensorEvent.values[0] - f) * 100.0f), (int) ((sensorEvent.values[1] - f2) * 100.0f), (int) ((sensorEvent.values[2] - f3) * 100.0f)});
            }
            com.opos.cmn.an.f.a.b("InteractiveShakeView", "xacc2:" + sensorEvent.values[0] + ",yacc2:" + sensorEvent.values[1] + ",zacc2:" + sensorEvent.values[2] + ",xacc1:" + f + ",yacc1:" + f2 + ",zacc1:" + f3);
        }
        i();
        k kVar = this.g;
        if (kVar != null) {
            kVar.c();
        }
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.opos.mobad.template.e.c.d.3
            @Override // java.lang.Runnable
            public void run() {
                d.this.z = false;
                d.this.h();
            }
        }, 1500L);
    }

    private void b(SensorEvent sensorEvent) {
        this.v = sensorEvent.values[0];
        this.w = sensorEvent.values[1];
        this.x = sensorEvent.values[2];
        this.y = SystemClock.elapsedRealtime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        x xVar = this.h;
        if (xVar == null || xVar.getWidth() <= 0) {
            return;
        }
        int width = this.h.getWidth();
        this.g = new k(this.b, this.p, width);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(width, com.opos.cmn.an.h.f.a.a(this.b, 44.0f));
        layoutParams.addRule(13);
        this.d.addView(this.g, layoutParams);
    }

    private void l() {
        if (this.o) {
            SensorManager sensorManager = this.k;
            if (sensorManager != null) {
                sensorManager.unregisterListener(this);
                this.k = null;
            }
            this.x = 0.0f;
            this.w = 0.0f;
            this.v = 0.0f;
            this.y = 0L;
        }
    }

    private void m() {
        if (this.o && this.k == null) {
            SensorManager sensorManager = (SensorManager) this.b.getSystemService("sensor");
            this.k = sensorManager;
            Sensor defaultSensor = sensorManager.getDefaultSensor(1);
            if (defaultSensor == null) {
                return;
            }
            this.k.registerListener(this, defaultSensor, 1);
        }
    }

    @Override // com.opos.mobad.template.e.c.a
    protected void a() {
        this.n = h.a();
        this.o = h.a(this.b);
    }

    @Override // com.opos.mobad.template.e.c.a
    public void a(f fVar) {
    }

    @Override // com.opos.mobad.template.e.c.a
    public void a(com.opos.mobad.template.e.b.a aVar) {
        if (!this.o || aVar == null) {
            return;
        }
        if (aVar instanceof com.opos.mobad.template.e.b.e) {
            com.opos.mobad.template.e.b.e eVar = (com.opos.mobad.template.e.b.e) aVar;
            if (eVar.k > 0) {
                this.t = eVar.k;
            }
            if (eVar.l > 0) {
                this.u = eVar.l;
            }
        }
        if (TextUtils.isEmpty(aVar.b)) {
            return;
        }
        this.f.setText("摇一摇" + aVar.b);
    }

    @Override // com.opos.mobad.template.e.c.a
    public void a(b bVar) {
        this.c = bVar;
    }

    @Override // com.opos.mobad.template.e.c.a
    protected void b() {
        if (this.o) {
            RelativeLayout relativeLayout = new RelativeLayout(this.b);
            this.d = relativeLayout;
            relativeLayout.setVisibility(4);
            this.d.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            this.d.setClipChildren(false);
            x xVar = new x(this.b);
            this.h = xVar;
            xVar.setVisibility(4);
            this.h.a(com.opos.cmn.an.h.f.a.a(this.b, 44.0f));
            this.h.setOrientation(0);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(this.b, 44.0f));
            layoutParams.addRule(13);
            this.h.setPadding(com.opos.cmn.an.h.f.a.a(this.b, 15.0f), 0, com.opos.cmn.an.h.f.a.a(this.b, 16.0f), 0);
            this.h.setBackgroundColor(Color.argb(138, 66, 70, 76));
            this.d.addView(this.h, layoutParams);
            this.e = new ImageView(this.b);
            LinearLayout.LayoutParams layoutParams2 = this.m == 1 ? new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.b, 21.0f), com.opos.cmn.an.h.f.a.a(this.b, 21.0f)) : new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.b, 27.0f), com.opos.cmn.an.h.f.a.a(this.b, 27.0f));
            layoutParams2.gravity = 16;
            this.e.setImageResource(R.drawable.opos_mobad_icon_hand);
            this.e.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            this.h.addView(this.e, layoutParams2);
            TextView textView = new TextView(this.b);
            this.f = textView;
            textView.setTextSize(1, this.m == 1 ? 14.0f : 18.0f);
            this.f.setText("摇一摇");
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams3.leftMargin = com.opos.cmn.an.h.f.a.a(this.b, 9.0f);
            layoutParams3.gravity = 16;
            this.f.setTextColor(-1);
            h.a(this.f);
            this.h.addView(this.f, layoutParams3);
            if (this.n) {
                this.j = ae.e(this.e);
            }
            a(this.b);
        }
    }

    @Override // com.opos.mobad.template.e.c.a
    public View c() {
        return this.d;
    }

    @Override // com.opos.mobad.template.e.c.a
    public boolean e() {
        return this.o;
    }

    @Override // com.opos.mobad.template.e.c.a
    public void f() {
        i();
        this.q = true;
    }

    @Override // com.opos.mobad.template.e.c.c
    public void g() {
        if (this.o && !this.s) {
            this.s = true;
            if (this.n) {
                Animator animatorB = ae.b((View) this.d);
                this.i = animatorB;
                animatorB.addListener(new Animator.AnimatorListener() { // from class: com.opos.mobad.template.e.c.d.2
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        d.this.j.start();
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }
                });
                this.i.start();
            }
        }
    }

    @Override // com.opos.mobad.template.e.c.c
    public void h() {
        com.opos.cmn.an.f.a.b("InteractiveShakeView", "isEnd:" + this.q + " mIsViewVisible:" + this.r);
        if (!this.q && this.r && this.o) {
            m();
            k kVar = this.g;
            if (kVar != null) {
                kVar.b();
            }
        }
    }

    @Override // com.opos.mobad.template.e.c.c
    public void i() {
        l();
        k kVar = this.g;
        if (kVar != null) {
            kVar.a();
        }
    }

    @Override // com.opos.mobad.template.e.c.c
    public void j() {
        if (this.o) {
            Animator animator = this.i;
            if (animator != null) {
                h.a(animator);
            }
            Animator animator2 = this.j;
            if (animator2 != null) {
                h.a(animator2);
            }
            l();
            RelativeLayout relativeLayout = this.d;
            if (relativeLayout != null) {
                relativeLayout.removeAllViews();
            }
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        a(sensorEvent);
    }
}
