package com.opos.mobad.template.e.c.b;

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
import com.opos.mobad.template.e.b.e;
import com.opos.mobad.template.h;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class b extends com.opos.mobad.template.e.c.a implements SensorEventListener {
    private long A;
    private boolean B;
    private int c;
    private int d;
    private int e;
    private com.opos.mobad.template.e.c.b f;
    private RelativeLayout g;
    private ImageView h;
    private TextView i;
    private k j;
    private x k;
    private Animator l;
    private Animator m;
    private SensorManager n;
    private boolean o;
    private boolean p;
    private boolean q;
    private boolean r;
    private boolean s;
    private boolean t;
    private String u;
    private int v;
    private int w;
    private float x;
    private float y;
    private float z;

    public b(Context context, com.opos.mobad.template.e.a aVar, int i, boolean z, String str) {
        super(context, aVar);
        this.c = 4;
        this.r = false;
        this.s = false;
        this.t = false;
        this.v = 1000;
        this.w = 13000;
        this.A = 0L;
        this.B = false;
        this.q = z;
        this.u = str;
        k();
        b(i);
        a();
        a(i);
    }

    private void a(int i) {
        if (this.p) {
            b();
            d(i);
            c(i);
        }
    }

    private void a(Context context) {
        com.opos.mobad.d.e.a aVar = new com.opos.mobad.d.e.a(context);
        aVar.a(new com.opos.mobad.d.e.a.InterfaceC0958a() { // from class: com.opos.mobad.template.e.c.b.b.1
            @Override // com.opos.mobad.d.e.a.InterfaceC0958a
            public void a(boolean z) {
                b.this.s = z;
                if (!z) {
                    b.this.i();
                    return;
                }
                if (b.this.k != null && b.this.k.getVisibility() != 0) {
                    b.this.k.setVisibility(0);
                    b.this.m();
                }
                b.this.g();
                b.this.h();
            }
        });
        this.g.addView(aVar, new RelativeLayout.LayoutParams(0, 0));
    }

    private void a(SensorEvent sensorEvent) {
        if (this.B || this.r || !this.s || sensorEvent == null || sensorEvent.values == null || sensorEvent.values.length < 3) {
            return;
        }
        if (this.A <= 0) {
            b(sensorEvent);
            return;
        }
        double dSqrt = Math.sqrt(Math.pow(sensorEvent.values[0] - this.x, 2.0d) + Math.pow(sensorEvent.values[1] - this.y, 2.0d) + Math.pow(sensorEvent.values[2] - this.z, 2.0d));
        float f = this.x;
        float f2 = this.y;
        float f3 = this.z;
        if (dSqrt * 1000.0d < this.w) {
            if (SystemClock.elapsedRealtime() - this.A >= this.v) {
                b(sensorEvent);
                return;
            }
            return;
        }
        this.B = true;
        com.opos.mobad.template.e.c.b bVar = this.f;
        if (bVar != null) {
            bVar.b(new int[]{(int) ((sensorEvent.values[0] - f) * 100.0f), (int) ((sensorEvent.values[1] - f2) * 100.0f), (int) ((sensorEvent.values[2] - f3) * 100.0f)});
            com.opos.cmn.an.f.a.b("NatTempInteractiveShakeView", "xacc2:" + sensorEvent.values[0] + ",yacc2:" + sensorEvent.values[1] + ",zacc2:" + sensorEvent.values[2] + ",xacc1:" + f + ",yacc1:" + f2 + ",zacc1:" + f3);
        }
        i();
        k kVar = this.j;
        if (kVar != null) {
            kVar.c();
        }
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.opos.mobad.template.e.c.b.b.3
            @Override // java.lang.Runnable
            public void run() {
                b.this.B = false;
                b.this.h();
            }
        }, 1500L);
    }

    private void b(int i) {
        Context context;
        float f;
        if (i == 0) {
            context = this.b;
            f = 28.0f;
        } else {
            if (i != 1) {
                return;
            }
            context = this.b;
            f = 44.0f;
        }
        this.d = com.opos.cmn.an.h.f.a.a(context, f);
        this.e = com.opos.cmn.an.h.f.a.a(this.b, f);
    }

    private void b(SensorEvent sensorEvent) {
        this.x = sensorEvent.values[0];
        this.y = sensorEvent.values[1];
        this.z = sensorEvent.values[2];
        this.A = SystemClock.elapsedRealtime();
    }

    private void c(int i) {
        TextView textView;
        float f;
        if (i == 0) {
            textView = this.i;
            f = 12.0f;
        } else {
            if (i != 1) {
                return;
            }
            textView = this.i;
            f = 16.0f;
        }
        textView.setTextSize(1, f);
    }

    private void d(int i) {
        int i2;
        int i3;
        if (i != 0) {
            i2 = i != 1 ? 0 : 18;
            i3 = i2;
        } else {
            i2 = 8;
            i3 = 10;
        }
        this.k.setPadding(com.opos.cmn.an.h.f.a.a(this.b, i2), com.opos.cmn.an.h.f.a.a(this.b, 0.0f), com.opos.cmn.an.h.f.a.a(this.b, i3), com.opos.cmn.an.h.f.a.a(this.b, 0.0f));
    }

    private void k() {
        if (this.b == null || this.b.getResources() == null || this.b.getResources().getConfiguration() == null) {
            return;
        }
        this.q = this.b.getResources().getConfiguration().orientation != 2;
    }

    private void l() {
        ViewGroup.LayoutParams layoutParams = this.h.getLayoutParams();
        layoutParams.height = com.opos.cmn.an.h.f.a.a(this.b, 20.0f);
        layoutParams.width = com.opos.cmn.an.h.f.a.a(this.b, 20.0f);
        this.h.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        x xVar = this.k;
        if (xVar == null || xVar.getWidth() <= 0) {
            return;
        }
        int width = this.k.getWidth() - com.opos.cmn.an.h.f.a.a(this.b, 1.0f);
        int height = this.k.getHeight() - com.opos.cmn.an.h.f.a.a(this.b, 1.0f);
        this.j = new k(this.b, this.q, width, height, this.e);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(width, height);
        layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.b, 1.0f) / 2;
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.b, 1.0f) / 2;
        this.g.addView(this.j, layoutParams);
    }

    private void n() {
        if (this.p) {
            SensorManager sensorManager = this.n;
            if (sensorManager != null) {
                sensorManager.unregisterListener(this);
                this.n = null;
            }
            this.z = 0.0f;
            this.y = 0.0f;
            this.x = 0.0f;
            this.A = 0L;
        }
    }

    private void o() {
        if (this.p && this.n == null) {
            SensorManager sensorManager = (SensorManager) this.b.getSystemService("sensor");
            this.n = sensorManager;
            Sensor defaultSensor = sensorManager.getDefaultSensor(1);
            if (defaultSensor == null) {
                return;
            }
            this.n.registerListener(this, defaultSensor, 1);
        }
    }

    @Override // com.opos.mobad.template.e.c.a
    protected void a() {
        this.o = h.a();
        this.p = h.a(this.b);
    }

    @Override // com.opos.mobad.template.e.c.a
    public void a(f fVar) {
    }

    @Override // com.opos.mobad.template.e.c.a
    public void a(com.opos.mobad.template.e.b.a aVar) {
        if (!this.p || aVar == null) {
            return;
        }
        if (aVar instanceof e) {
            e eVar = (e) aVar;
            if (eVar.k > 0) {
                this.v = eVar.k;
            }
            if (eVar.l > 0) {
                this.w = eVar.l;
            }
        }
        if (TextUtils.isEmpty(aVar.b)) {
            return;
        }
        this.i.setText("摇一摇" + aVar.b);
    }

    @Override // com.opos.mobad.template.e.c.a
    public void a(com.opos.mobad.template.e.c.b bVar) {
        this.f = bVar;
    }

    @Override // com.opos.mobad.template.e.c.a
    protected void b() {
        TextView textView;
        int i;
        RelativeLayout relativeLayout = new RelativeLayout(this.b);
        this.g = relativeLayout;
        relativeLayout.setVisibility(4);
        this.g.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        this.g.setClipChildren(false);
        x xVar = new x(this.b);
        this.k = xVar;
        xVar.setVisibility(4);
        this.k.a(this.e);
        this.k.setOrientation(0);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.d);
        this.k.setPadding(com.opos.cmn.an.h.f.a.a(this.b, 8.0f), 0, com.opos.cmn.an.h.f.a.a(this.b, 10.0f), 0);
        x xVar2 = this.k;
        String str = this.u;
        xVar2.setBackgroundColor(str != null ? Color.parseColor(str) : Color.argb(138, 66, 70, 76));
        this.g.addView(this.k, layoutParams);
        this.h = new ImageView(this.b);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.b, 20.0f), com.opos.cmn.an.h.f.a.a(this.b, 20.0f));
        layoutParams2.gravity = 16;
        this.h.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.k.addView(this.h, layoutParams2);
        TextView textView2 = new TextView(this.b);
        this.i = textView2;
        textView2.setTextSize(1, 18.0f);
        this.i.setText("摇一摇");
        this.i.setMaxEms(12);
        this.i.setMaxLines(1);
        this.i.setEllipsize(TextUtils.TruncateAt.END);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.leftMargin = com.opos.cmn.an.h.f.a.a(this.b, this.c);
        layoutParams3.gravity = 16;
        h.a(this.i);
        this.k.addView(this.i, layoutParams3);
        if (this.u != null) {
            this.h.setImageResource(R.drawable.opos_mobad_icon_hand_nt_btn);
            textView = this.i;
            i = -1;
        } else {
            this.h.setImageResource(R.drawable.opos_mobad_icon_hand_nt);
            textView = this.i;
            i = -436207617;
        }
        textView.setTextColor(i);
        l();
        if (this.o) {
            this.m = ae.f(this.h);
        }
        a(this.b);
    }

    @Override // com.opos.mobad.template.e.c.a
    public View c() {
        return this.g;
    }

    @Override // com.opos.mobad.template.e.c.a
    public boolean e() {
        return this.p;
    }

    @Override // com.opos.mobad.template.e.c.a
    public void f() {
        i();
        this.r = true;
    }

    @Override // com.opos.mobad.template.e.c.c
    public void g() {
        if (this.p && !this.t) {
            this.t = true;
            if (this.o) {
                Animator animatorB = ae.b((View) this.g);
                this.l = animatorB;
                animatorB.addListener(new Animator.AnimatorListener() { // from class: com.opos.mobad.template.e.c.b.b.2
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        b.this.m.start();
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }
                });
                this.l.start();
            }
        }
    }

    @Override // com.opos.mobad.template.e.c.c
    public void h() {
        com.opos.cmn.an.f.a.b("NatTempInteractiveShakeView", "isEnd:" + this.r + " mIsViewVisible:" + this.s);
        if (!this.r && this.s && this.p) {
            o();
            k kVar = this.j;
            if (kVar != null) {
                kVar.b();
            }
        }
    }

    @Override // com.opos.mobad.template.e.c.c
    public void i() {
        n();
        k kVar = this.j;
        if (kVar != null) {
            kVar.a();
        }
    }

    @Override // com.opos.mobad.template.e.c.c
    public void j() {
        if (this.p) {
            Animator animator = this.l;
            if (animator != null) {
                h.a(animator);
            }
            Animator animator2 = this.m;
            if (animator2 != null) {
                h.a(animator2);
            }
            n();
            RelativeLayout relativeLayout = this.g;
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
