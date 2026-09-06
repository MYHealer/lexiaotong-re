package com.ubix.ssp.ad.j;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.icbc.paysdk.constants.Constants;
import com.ubix.ssp.ad.e.a0.r;
import com.ubix.ssp.ad.e.a0.s;
import com.ubix.ssp.ad.e.a0.u;
import com.ubix.ssp.ad.e.q;
import com.ubix.ssp.open.AdError;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a extends com.ubix.ssp.ad.b implements View.OnClickListener {
    private com.ubix.ssp.ad.g.k.i A;
    private ValueAnimator B;
    private boolean C;
    private double D;
    private int E;
    private int F;
    private boolean G;
    private int H;
    private float I;
    private int J;
    private int K;
    private float L;
    private boolean M;
    private boolean N;
    private int O;
    private int P;
    private int Q;
    private long R;
    private long S;
    private long T;
    private int U;
    private boolean V;
    private boolean W;
    Rect a0;
    private com.ubix.ssp.ad.e.t.a.e l;
    com.ubix.ssp.ad.k.a m;
    private boolean n;
    private int o;
    private l p;
    private float q;
    private int r;
    private int s;
    private int t;
    private AtomicBoolean u;
    private volatile ValueAnimator v;
    private volatile com.ubix.ssp.ad.e.a0.g w;
    private int x;
    private int y;
    private int z;

    /* JADX INFO: renamed from: com.ubix.ssp.ad.j.a$a, reason: collision with other inner class name */
    class RunnableC1122a implements Runnable {
        RunnableC1122a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            u.e("onWindowVisibilityChanged inner" + a.this.getWindowVisibility() + ";" + a.this.hasWindowFocus());
            if (a.this.getWindowVisibility() != 0 || a.this.p == null) {
                return;
            }
            a.this.p.sendEmptyMessage(5);
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.k(3);
            if (a.this.u()) {
                if (a.this.findViewById(920101) != null) {
                    ((RelativeLayout.LayoutParams) a.this.findViewById(920101).getLayoutParams()).bottomMargin = r.a(16.0f);
                }
                if (a.this.findViewById(300008) != null) {
                    ((RelativeLayout.LayoutParams) a.this.findViewById(300008).getLayoutParams()).bottomMargin = r.a(40.0f);
                }
                if (a.this.findViewById(300012) != null) {
                    ((RelativeLayout.LayoutParams) a.this.findViewById(300012).getLayoutParams()).bottomMargin = r.a(36.0f);
                }
            }
            if (a.this.findViewById(920101) != null) {
                a.this.findViewById(920101).setVisibility(0);
            }
            if (a.this.findViewById(300008) != null) {
                a.this.findViewById(300008).setVisibility(0);
            }
            if (a.this.findViewById(300012) != null) {
                a.this.findViewById(300012).setVisibility(0);
            }
        }
    }

    class c implements com.ubix.ssp.ad.e.v.e.b {
        c() {
        }

        @Override // com.ubix.ssp.ad.e.v.e.b
        public void a(com.ubix.ssp.ad.e.v.e eVar, String str, String str2, boolean z) {
            a.this.a(str);
        }

        @Override // com.ubix.ssp.ad.e.v.e.b
        public void a(AdError adError) {
        }
    }

    class d implements com.ubix.ssp.ad.g.k.j {
        d() {
        }

        @Override // com.ubix.ssp.ad.g.k.b
        public void a(int i) {
        }

        @Override // com.ubix.ssp.ad.g.k.j
        public void a(int i, int i2) {
        }

        @Override // com.ubix.ssp.ad.g.k.j
        public void a(int i, long j, long j2) {
            if (a.this.A != null) {
                a.this.A.a(i, j, j2);
            }
        }

        @Override // com.ubix.ssp.ad.g.k.b
        public void a(int i, Bundle bundle) {
        }

        @Override // com.ubix.ssp.ad.g.k.b
        public void a(int i, View view) {
        }

        @Override // com.ubix.ssp.ad.g.k.b
        public void b(int i) {
        }

        @Override // com.ubix.ssp.ad.g.k.j
        public void b(int i, int i2) {
        }

        @Override // com.ubix.ssp.ad.g.k.b
        public void b(int i, View view, HashMap<String, String> map) {
            ((com.ubix.ssp.ad.b) a.this).f8574a.putAll(map);
            if (a.this.A != null) {
                a.this.A.b(i, view, ((com.ubix.ssp.ad.b) a.this).f8574a);
            }
        }

        @Override // com.ubix.ssp.ad.g.k.j
        public void c(int i) {
            if (a.this.findViewWithTag(900102) != null) {
                a.this.findViewWithTag(900102).setVisibility(0);
            }
            com.ubix.ssp.ad.k.a aVar = a.this.m;
            if (aVar != null) {
                aVar.setVisibility(4);
            }
        }

        @Override // com.ubix.ssp.ad.g.k.b
        public void e(int i) {
        }

        @Override // com.ubix.ssp.ad.g.k.b
        public void f(int i) {
        }

        @Override // com.ubix.ssp.ad.g.k.j
        public void g(int i) {
        }

        @Override // com.ubix.ssp.ad.g.k.j
        public void h(int i) {
            com.ubix.ssp.ad.k.a aVar;
            if (a.this.findViewWithTag(900102) != null) {
                a.this.findViewWithTag(900102).setVisibility(4);
            }
            com.ubix.ssp.ad.k.a aVar2 = a.this.m;
            if (aVar2 != null) {
                aVar2.setVisibility(0);
            }
            if (a.this.z != 2 || (aVar = a.this.m) == null) {
                return;
            }
            aVar.u();
        }

        @Override // com.ubix.ssp.ad.g.k.b
        public void i(int i) {
        }

        @Override // com.ubix.ssp.ad.g.k.j
        public void j(int i) {
            com.ubix.ssp.ad.k.a aVar;
            if (a.this.z != 2 || (aVar = a.this.m) == null) {
                return;
            }
            aVar.u();
        }
    }

    class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ((com.ubix.ssp.ad.b) a.this).f8574a.put(com.hihonor.adsdk.base.g.j.e.c.hnadsb, a.this.getWidth() + "");
            ((com.ubix.ssp.ad.b) a.this).f8574a.put(com.hihonor.adsdk.base.g.j.e.c.hnadsa, a.this.getHeight() + "");
            ((com.ubix.ssp.ad.b) a.this).f8574a.put("__IMP_AREA__", a.this.getLeft() + "_" + a.this.getTop() + "_" + a.this.getRight() + "_" + a.this.getBottom());
            ((com.ubix.ssp.ad.b) a.this).f8574a.put("adLeft", a.this.getLeft() + "");
            ((com.ubix.ssp.ad.b) a.this).f8574a.put("adRight", a.this.getRight() + "");
            ((com.ubix.ssp.ad.b) a.this).f8574a.put("adTop", a.this.getTop() + "");
            ((com.ubix.ssp.ad.b) a.this).f8574a.put("adBottom", a.this.getBottom() + "");
        }
    }

    class f implements ValueAnimator.AnimatorUpdateListener {
        f() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (a.this.t != ((Integer.parseInt(valueAnimator.getAnimatedValue() + "") * a.this.s) / 100) / 1000) {
                a.this.t = ((Integer.parseInt(valueAnimator.getAnimatedValue() + "") * a.this.s) / 100) / 1000;
                a.this.k(1);
            }
            a.this.t = ((Integer.parseInt(valueAnimator.getAnimatedValue() + "") * a.this.s) / 100) / 1000;
        }
    }

    class g extends AnimatorListenerAdapter {
        g() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            super.onAnimationCancel(animator);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            a.this.p.sendEmptyMessage(5);
            try {
                if (a.this.v != null) {
                    a.this.v.removeAllListeners();
                }
            } catch (Throwable unused) {
            }
        }
    }

    class h implements com.ubix.ssp.ad.e.a0.g.b {
        h() {
        }

        @Override // com.ubix.ssp.ad.e.a0.g.b
        public void a() {
            a.this.p.sendEmptyMessage(5);
        }

        @Override // com.ubix.ssp.ad.e.a0.g.b
        public void a(long j) {
            if (a.this.t != j / 1000) {
                a.this.t = ((int) j) / 1000;
                a.this.k(1);
            }
            a.this.t = ((int) j) / 1000;
        }

        @Override // com.ubix.ssp.ad.e.a0.g.b
        public void b() {
        }
    }

    class i implements s.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f9016a;

        i(View view) {
            this.f9016a = view;
        }

        @Override // com.ubix.ssp.ad.e.a0.s.e
        public void a(float f, float f2) {
            try {
                if (a.this.isShown()) {
                    ((com.ubix.ssp.ad.b) a.this).f.f();
                    ((com.ubix.ssp.ad.b) a.this).f8574a.put("__TRI_VAL__", Base64.encodeToString((f + "").getBytes(), 10));
                    ((com.ubix.ssp.ad.b) a.this).f8574a.put("__CLICK_AREA__", "3");
                    ((com.ubix.ssp.ad.b) a.this).f8574a.put("__CLICK_TRIGGER__", "3");
                    if (a.this.A != null) {
                        a.this.A.a(((com.ubix.ssp.ad.b) a.this).b, this.f9016a, ((com.ubix.ssp.ad.b) a.this).f8574a);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // com.ubix.ssp.ad.e.a0.s.e
        public void a(Bundle bundle) {
            try {
                if (a.this.isShown()) {
                    u.e("onSensorInfo=" + bundle.toString());
                    if (bundle.getInt("__SENSOR_INFO_TYPE__") == 1) {
                        ((com.ubix.ssp.ad.b) a.this).f8574a.put("__X_MAX_ACC__", String.format("%.2f", Float.valueOf(bundle.getFloat("__X_MAX_ACC__"))));
                        ((com.ubix.ssp.ad.b) a.this).f8574a.put("__Y_MAX_ACC__", String.format("%.2f", Float.valueOf(bundle.getFloat("__Y_MAX_ACC__"))));
                        ((com.ubix.ssp.ad.b) a.this).f8574a.put("__Z_MAX_ACC__", String.format("%.2f", Float.valueOf(bundle.getFloat("__Z_MAX_ACC__"))));
                        ((com.ubix.ssp.ad.b) a.this).f8574a.put("__TURN_X__", String.format("%.2f", Float.valueOf(bundle.getFloat("__TURN_X__"))));
                        ((com.ubix.ssp.ad.b) a.this).f8574a.put("__TURN_Y__", String.format("%.2f", Float.valueOf(bundle.getFloat("__TURN_Y__"))));
                        ((com.ubix.ssp.ad.b) a.this).f8574a.put("__TURN_Z__", String.format("%.2f", Float.valueOf(bundle.getFloat("__TURN_Z__"))));
                        ((com.ubix.ssp.ad.b) a.this).f8574a.put("__UBIX_TURN_TARGET__", bundle.getInt("__UBIX_TURN_TARGET__") + "");
                        ((com.ubix.ssp.ad.b) a.this).f8574a.put("__TURN_TIME__", bundle.getLong("__TURN_TIME__") + "");
                    }
                    if (a.this.A != null) {
                        a.this.A.a(((com.ubix.ssp.ad.b) a.this).b, bundle);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    class j implements Runnable {
        j() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ((com.ubix.ssp.ad.b) a.this).f8574a.put(com.hihonor.adsdk.base.g.j.e.c.hnadsb, a.this.getWidth() + "");
            ((com.ubix.ssp.ad.b) a.this).f8574a.put(com.hihonor.adsdk.base.g.j.e.c.hnadsa, a.this.getHeight() + "");
            ((com.ubix.ssp.ad.b) a.this).f8574a.put("__IMP_AREA__", a.this.getLeft() + "_" + a.this.getTop() + "_" + a.this.getRight() + "_" + a.this.getBottom());
            ((com.ubix.ssp.ad.b) a.this).f8574a.put("adLeft", a.this.getLeft() + "");
            ((com.ubix.ssp.ad.b) a.this).f8574a.put("adRight", a.this.getRight() + "");
            ((com.ubix.ssp.ad.b) a.this).f8574a.put("adTop", a.this.getTop() + "");
            ((com.ubix.ssp.ad.b) a.this).f8574a.put("adBottom", a.this.getBottom() + "");
        }
    }

    class k implements Runnable {
        k() {
        }

        @Override // java.lang.Runnable
        public void run() {
            View viewFindViewById = a.this.findViewById(300001);
            if (viewFindViewById != null) {
                viewFindViewById.bringToFront();
            }
            View viewFindViewById2 = a.this.findViewById(300012);
            if (viewFindViewById2 != null) {
                viewFindViewById2.bringToFront();
            }
            View viewFindViewById3 = a.this.findViewById(300008);
            if (viewFindViewById3 != null) {
                viewFindViewById3.bringToFront();
            }
            View viewFindViewById4 = a.this.findViewById(Constants.version);
            if (viewFindViewById4 != null) {
                viewFindViewById4.bringToFront();
            }
        }
    }

    public static class l extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private SoftReference<a> f9019a;

        public l(a aVar) {
            this.f9019a = new SoftReference<>(aVar);
        }

        private void a(int i) {
            View viewFindViewById;
            SoftReference<a> softReference = this.f9019a;
            if (softReference == null || softReference.get() == null || (viewFindViewById = this.f9019a.get().findViewById(300001)) == null || !(viewFindViewById instanceof TextView) || this.f9019a.get().o != 4) {
                return;
            }
            ((TextView) viewFindViewById).setText("跳过 " + i);
        }

        private void a(boolean z) {
            SoftReference<a> softReference = this.f9019a;
            if (softReference == null || softReference.get() == null) {
                return;
            }
            if (this.f9019a.get().m != null) {
                this.f9019a.get().m.setMute(z);
            }
            SoftReference<a> softReference2 = this.f9019a;
            if (softReference2 == null || softReference2.get().findViewById(300012) == null) {
                return;
            }
            ((ImageView) this.f9019a.get().findViewById(300012)).setImageDrawable(q.a(z ? "ubix/ic_volume_off.webp" : "ubix/ic_volume_on.webp"));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c() {
            SoftReference<a> softReference = this.f9019a;
            if (softReference == null || softReference.get() == null) {
                return;
            }
            this.f9019a.get().w();
        }

        private void d() {
            a aVar;
            try {
                SoftReference<a> softReference = this.f9019a;
                if (softReference == null || softReference.get() == null) {
                    return;
                }
                if (this.f9019a.get().U == 0) {
                    if (this.f9019a.get().v != null) {
                        this.f9019a.get().v.pause();
                        if (this.f9019a.get().B != null) {
                            aVar = this.f9019a.get();
                            aVar.B.pause();
                        }
                    }
                } else if (this.f9019a.get().w != null) {
                    this.f9019a.get().w.c();
                    if (this.f9019a.get().B != null) {
                        aVar = this.f9019a.get();
                        aVar.B.pause();
                    }
                }
                View viewFindViewById = this.f9019a.get().findViewById(300001);
                if (viewFindViewById != null && (viewFindViewById instanceof com.ubix.ssp.ad.e.g)) {
                    ((com.ubix.ssp.ad.e.g) viewFindViewById).c();
                }
                if (this.f9019a.get().m != null) {
                    this.f9019a.get().m.u();
                    this.f9019a.get().z = 2;
                }
                if (((com.ubix.ssp.ad.b) this.f9019a.get()).f != null) {
                    ((com.ubix.ssp.ad.b) this.f9019a.get()).f.f();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        private void e() {
            a aVar;
            try {
                SoftReference<a> softReference = this.f9019a;
                if (softReference == null || softReference.get() == null) {
                    return;
                }
                if (this.f9019a.get().U == 0) {
                    if (this.f9019a.get().v != null) {
                        this.f9019a.get().v.resume();
                        if (this.f9019a.get().B != null) {
                            aVar = this.f9019a.get();
                            aVar.B.resume();
                        }
                    }
                } else if (this.f9019a.get().w != null) {
                    this.f9019a.get().w.d();
                    if (this.f9019a.get().B != null) {
                        aVar = this.f9019a.get();
                        aVar.B.resume();
                    }
                }
                View viewFindViewById = this.f9019a.get().findViewById(300001);
                if (viewFindViewById != null && (viewFindViewById instanceof com.ubix.ssp.ad.e.g)) {
                    ((com.ubix.ssp.ad.e.g) viewFindViewById).d();
                }
                if (this.f9019a.get().m != null && this.f9019a.get().z != 0) {
                    this.f9019a.get().m.v();
                    this.f9019a.get().z = 3;
                }
                if (this.f9019a.get().l() || !this.f9019a.get().C) {
                    return;
                }
                if ((com.ubix.ssp.ad.d.b.E == 1 && ((com.ubix.ssp.ad.b) this.f9019a.get()).d) || this.f9019a.get().findViewById(910101) == null) {
                    return;
                }
                this.f9019a.get().setShakeSensor(this.f9019a.get().findViewById(910101));
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        protected void a() {
            u.a("handleAdClose");
            try {
                SoftReference<a> softReference = this.f9019a;
                if (softReference == null || softReference.get() == null) {
                    return;
                }
                this.f9019a.get().z = 5;
                if (((com.ubix.ssp.ad.b) this.f9019a.get()).f != null) {
                    ((com.ubix.ssp.ad.b) this.f9019a.get()).f.f();
                }
                if (((com.ubix.ssp.ad.b) this.f9019a.get()).f != null) {
                    ((com.ubix.ssp.ad.b) this.f9019a.get()).f.a();
                }
                if (this.f9019a.get().A != null) {
                    this.f9019a.get().A.e(((com.ubix.ssp.ad.b) this.f9019a.get()).b);
                }
                if (this.f9019a.get().m != null) {
                    this.f9019a.get().m.w();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        protected void b() {
            u.a("handleAdSkip");
            try {
                SoftReference<a> softReference = this.f9019a;
                if (softReference == null || softReference.get() == null) {
                    return;
                }
                this.f9019a.get().z = 5;
                if (this.f9019a.get().A != null) {
                    if (((com.ubix.ssp.ad.b) this.f9019a.get()).f != null) {
                        ((com.ubix.ssp.ad.b) this.f9019a.get()).f.f();
                    }
                    if (((com.ubix.ssp.ad.b) this.f9019a.get()).f != null) {
                        ((com.ubix.ssp.ad.b) this.f9019a.get()).f.a();
                    }
                    if (this.f9019a.get().v != null) {
                        this.f9019a.get().v.cancel();
                    }
                    if (this.f9019a.get().w != null) {
                        this.f9019a.get().w.a();
                    }
                    if (this.f9019a.get().B != null) {
                        this.f9019a.get().B.cancel();
                    }
                    this.f9019a.get().A.a(((com.ubix.ssp.ad.b) this.f9019a.get()).b, this.f9019a.get().s);
                }
                if (this.f9019a.get().m != null) {
                    this.f9019a.get().m.w();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 0:
                    c();
                    break;
                case 1:
                    SoftReference<a> softReference = this.f9019a;
                    if (softReference != null && softReference.get() != null && (this.f9019a.get().U != 0 ? this.f9019a.get().w == null || this.f9019a.get().w.b() : this.f9019a.get().v == null || !this.f9019a.get().v.isRunning())) {
                        sendEmptyMessage(0);
                    }
                    a(message.arg1);
                    break;
                case 2:
                    d();
                    removeMessages(1);
                    break;
                case 3:
                    if (!hasMessages(1)) {
                        e();
                        this.f9019a.get().k(1);
                    } else {
                        u.b("msg already exist");
                    }
                    break;
                case 4:
                    removeMessages(1);
                    removeMessages(2);
                    removeMessages(3);
                    b();
                    break;
                case 5:
                    removeMessages(1);
                    removeMessages(2);
                    removeMessages(3);
                    a();
                    break;
                case 6:
                    SoftReference<a> softReference2 = this.f9019a;
                    if (softReference2 != null && softReference2.get() != null && this.f9019a.get().m != null) {
                        a(true);
                        break;
                    }
                    break;
                case 7:
                    SoftReference<a> softReference3 = this.f9019a;
                    if (softReference3 != null && softReference3.get() != null && this.f9019a.get().m != null) {
                        a(false);
                        break;
                    }
                    break;
            }
        }
    }

    public a(Context context) {
        super(context);
        this.n = false;
        this.q = 0.0f;
        this.r = 5000;
        this.s = 5000;
        this.t = 5000;
        this.u = new AtomicBoolean();
        this.x = 0;
        this.y = 0;
        this.z = 0;
        this.D = 3.0d;
        this.F = 0;
        this.G = false;
        this.H = 0;
        this.I = 0.05f;
        this.J = 5;
        this.K = 5;
        this.L = 0.5625f;
        this.M = false;
        this.N = false;
        this.O = -1;
        this.P = 0;
        this.Q = 0;
        this.R = 0L;
        this.S = 0L;
        this.T = 0L;
        this.U = 0;
        this.V = false;
        this.W = false;
        this.a0 = new Rect();
        this.p = new l(this);
        setClickable(true);
        this.D = r.a().a(context);
    }

    public static void a(ImageView imageView, int i2) {
        if (imageView != null) {
            try {
                if (imageView.isShown()) {
                    AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                    alphaAnimation.setDuration(200L);
                    alphaAnimation.setFillAfter(true);
                    imageView.startAnimation(alphaAnimation);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        try {
            int i2 = this.H;
            if (i2 == 1) {
                Bitmap bitmapB = com.ubix.ssp.ad.e.a0.c.b(str);
                if (bitmapB != null) {
                    if (bitmapB.getHeight() != 0) {
                        this.L = (bitmapB.getWidth() * 1.0f) / bitmapB.getHeight();
                    }
                    findViewById(900100).setBackground(new BitmapDrawable(bitmapB));
                }
            } else if (i2 == 2) {
                ((ImageView) findViewWithTag(900102)).setScaleType(ImageView.ScaleType.CENTER_CROP);
            }
            com.ubix.ssp.ad.e.v.a aVarB = com.ubix.ssp.ad.e.v.e.b();
            if (aVarB.d(str)) {
                aVarB.a(str, (ImageView) findViewWithTag(900102));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void a(String str, String str2, int i2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("AD_TYPE", 1);
        bundle.putInt("VIDEO_RENDER_TYPE", i2);
        if (this.m == null) {
            com.ubix.ssp.ad.k.a aVar = new com.ubix.ssp.ad.k.a(getContext(), bundle);
            this.m = aVar;
            aVar.setId(300011);
            boolean z = false;
            this.m.setShowAdLogo(false);
            this.m.setShowCountDown(false);
            this.m.setShowVolumeSwitch(false);
            this.m.setShowBanner(false);
            if (i2 != 0 ? i2 != 2 : !(com.ubix.ssp.ad.d.b.f8605a.isSpecifiedVideoWidget() && com.ubix.ssp.ad.d.b.f8605a.isUseTextureView())) {
                z = true;
            }
            this.m.setInnerListener(new d());
            a(!z);
        }
        b(str2);
        this.m.b(str, (String) null);
        this.m.setMute(true);
        if (this.H != 1) {
            this.m.setVideoDisplayType(1);
        }
    }

    private void a(HashMap<String, String> map) {
        Rect rect;
        float f2;
        float f3;
        try {
            View viewFindViewById = findViewById(910501);
            float f4 = 0.6f;
            float f5 = 0.2f;
            if (viewFindViewById != null) {
                rect = new Rect();
                viewFindViewById.getGlobalVisibleRect(rect);
                f3 = 0.2f;
                f5 = 0.35f;
                f2 = 0.6f;
            } else {
                viewFindViewById = findViewById(910701);
                if (viewFindViewById != null) {
                    rect = new Rect();
                    viewFindViewById.getGlobalVisibleRect(rect);
                } else {
                    rect = null;
                }
                if (viewFindViewById == null) {
                    viewFindViewById = findViewById(910401);
                    f2 = 0.25f;
                    if (viewFindViewById != null) {
                        rect = new Rect();
                        viewFindViewById.getGlobalVisibleRect(rect);
                    }
                } else {
                    f2 = 0.3f;
                }
                if (viewFindViewById == null) {
                    viewFindViewById = findViewById(910301);
                    f5 = 0.15f;
                    f4 = 0.7f;
                    if (viewFindViewById != null) {
                        rect = new Rect();
                        viewFindViewById.getGlobalVisibleRect(rect);
                    }
                    f2 = 0.7f;
                    f3 = 0.15f;
                } else {
                    f3 = 0.45f;
                }
            }
            if (rect != null) {
                int iWidth = (int) (((double) (rect.width() * f5)) + (((double) (rect.width() * f4)) * Math.random()));
                int iHeight = (int) (((double) (rect.height() * f3)) + (((double) (rect.height() * f2)) * Math.random()));
                int iWidth2 = (int) (((double) (rect.left + (rect.width() * f5))) + (((double) (rect.width() * f4)) * Math.random()));
                int iHeight2 = (int) (((double) (rect.top + (rect.height() * f3))) + (((double) (rect.height() * f2)) * Math.random()));
                u.e(viewFindViewById + ";visibleRect=" + rect + ";x=" + iWidth + ";y=" + iHeight + ";rx=" + iWidth2 + ";ry=" + iHeight2);
                map.put(com.hihonor.adsdk.base.g.j.e.c.hnadsc, iWidth2 + "");
                map.put(com.hihonor.adsdk.base.g.j.e.c.hnadsd, iHeight2 + "");
                map.put(com.hihonor.adsdk.base.g.j.e.c.hnadse, iWidth2 + "");
                map.put(com.hihonor.adsdk.base.g.j.e.c.hnadsf, iHeight2 + "");
                map.put("__RAW_DOWN_X__", iWidth2 + "");
                map.put("__RAW_DOWN_Y__", iHeight2 + "");
                map.put("__RAW_UP_X__", iWidth2 + "");
                map.put("__RAW_UP_Y__", iHeight2 + "");
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void a(boolean z) {
        ImageView imageView = new ImageView(getContext());
        imageView.setId(300012);
        imageView.setVisibility(4);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(r.a(32.0f), r.a(38.0f));
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        layoutParams.setMargins(0, 0, r.a(10.0f), r.a(32.0f));
        imageView.setPadding(r.a(4.0f), r.a(4.0f), r.a(4.0f), r.a(4.0f));
        imageView.setImageDrawable(q.a("ubix/ic_volume_off.webp"));
        imageView.setOnClickListener(this);
        findViewById(300015).setVisibility(0);
        ((FrameLayout) findViewById(900100)).addView(this.m, 0, new FrameLayout.LayoutParams(-1, -1));
        addView(imageView, layoutParams);
    }

    private boolean b(String str) {
        Bitmap bitmapB;
        try {
            com.ubix.ssp.ad.e.v.a aVarB = com.ubix.ssp.ad.e.v.e.b();
            int i2 = this.H;
            if (i2 == 1) {
                if (aVarB.d(str) && (bitmapB = com.ubix.ssp.ad.e.a0.c.b(str)) != null) {
                    if (bitmapB.getHeight() != 0) {
                        this.L = (bitmapB.getWidth() * 1.0f) / bitmapB.getHeight();
                    }
                    findViewById(900100).setBackground(new BitmapDrawable(bitmapB));
                }
            } else if (i2 == 2) {
                ((ImageView) findViewWithTag(900102)).setScaleType(ImageView.ScaleType.CENTER_CROP);
            }
            if (aVarB.d(str)) {
                aVarB.a(str, (ImageView) findViewWithTag(900102));
            } else {
                a((ImageView) findViewWithTag(900102), 0);
                aVarB.a(str, (ImageView) findViewWithTag(900102), 5, new c());
            }
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    private Rect d(int i2, int i3) {
        Rect rect = new Rect();
        if (i2 * i3 > 0) {
            int i4 = (int) (this.K * i3 * 0.01f);
            int i5 = (int) (this.J * i2 * 0.01f);
            rect.left = i5;
            rect.top = i4;
            rect.right = i2 - i5;
            rect.bottom = i3 - i4;
        }
        return rect;
    }

    private boolean e(int i2, int i3) {
        return Math.abs((this.L / ((((float) i2) * 1.0f) / ((float) i3))) - 1.0f) <= this.I;
    }

    private int getCurrentRotation() {
        return ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getRotation();
    }

    /* JADX WARN: Code duplicated, block: B:15:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:18:0x0138  */
    /* JADX WARN: Code duplicated, block: B:21:0x018c  */
    /* JADX WARN: Code duplicated, block: B:24:0x01bc  */
    /* JADX WARN: Code duplicated, block: B:27:0x01e8  */
    private void s() {
        RelativeLayout.LayoutParams layoutParams;
        View view;
        this.x = r.a().c(getContext());
        this.y = r.a().h(getContext());
        FrameLayout frameLayout = new FrameLayout(getContext());
        TextView textView = new TextView(getContext());
        ImageView imageView = new ImageView(getContext());
        TextView textView2 = new TextView(getContext());
        this.l = new com.ubix.ssp.ad.e.t.a.e(getContext());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, r.b(24.0f));
        int i2 = this.o;
        if (i2 != 1) {
            if (i2 == 2) {
                com.ubix.ssp.ad.e.g gVar = new com.ubix.ssp.ad.e.g(getContext());
                gVar.setTextSize(r.a(4.0f));
                gVar.setTextColor(-1);
                gVar.setText("跳过");
                RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(r.b(24.0f), r.b(24.0f));
                layoutParams2.addRule(4, 300001);
                view = gVar;
                layoutParams = layoutParams3;
            } else if (i2 == 3 || i2 == 4) {
                TextView textView3 = new TextView(getContext());
                textView3.setBackground(com.ubix.ssp.ad.e.a0.c.a(getContext(), Integer.MIN_VALUE, 72));
                textView3.setTextColor(-1);
                textView3.setGravity(17);
                layoutParams = new RelativeLayout.LayoutParams(r.b(40.0f), r.b(16.0f));
                view = textView3;
            }
            this.l.setScaleType(ImageView.ScaleType.FIT_XY);
            textView.setId(300015);
            imageView.setId(300008);
            imageView.setVisibility(0);
            textView2.setId(Constants.version);
            textView2.setTextColor(-1);
            if (view != null) {
                view.setId(300001);
            }
            this.l.setId(900102);
            this.l.setTag(900102);
            frameLayout.setId(900100);
            frameLayout.addView(this.l, new FrameLayout.LayoutParams(-1, -1));
            layoutParams2.addRule(0, 300001);
            layoutParams2.setMargins(0, r.b(20.0f), r.b(8.0f), r.b(1.0f));
            textView.setGravity(16);
            if (layoutParams != null) {
                layoutParams.addRule(11);
                layoutParams.addRule(10);
                layoutParams.setMargins(0, r.b(23.0f), r.b(10.0f), 0);
            }
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(r.a(34.0f), r.a(16.0f));
            layoutParams4.addRule(9);
            layoutParams4.addRule(2);
            layoutParams4.setMargins(r.b(6.0f), 0, 0, r.a(38.0f));
            layoutParams4.addRule(6, 920101);
            textView.setVisibility(8);
            addView(frameLayout, new RelativeLayout.LayoutParams(-1, -1));
            if (view != null) {
                view.setVisibility(4);
                addView(view, layoutParams);
            }
            addView(textView, layoutParams2);
            addView(imageView, layoutParams4);
            addView(textView2);
            textView.setShadowLayer(3.0f, 0.0f, 1.0f, 1711276032);
            textView.setTextColor(-1);
            textView.setText("");
            imageView.setImageDrawable(q.a("ubix/ic_logo.png", this.W));
            if (this.n) {
                RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams5.addRule(12);
                layoutParams5.setMargins(r.b(6.0f), 0, r.b(6.0f), r.b(6.0f));
                addView(com.ubix.ssp.ad.e.f.a(getContext()), layoutParams5);
            }
            setOnClickListener(this);
            if (this.N) {
                View viewH = h();
                addView(viewH);
                viewH.setOnClickListener(this);
            }
            setBackgroundColor(-921103);
        }
        layoutParams2.addRule(11);
        view = null;
        layoutParams = null;
        this.l.setScaleType(ImageView.ScaleType.FIT_XY);
        textView.setId(300015);
        imageView.setId(300008);
        imageView.setVisibility(0);
        textView2.setId(Constants.version);
        textView2.setTextColor(-1);
        if (view != null) {
            view.setId(300001);
        }
        this.l.setId(900102);
        this.l.setTag(900102);
        frameLayout.setId(900100);
        frameLayout.addView(this.l, new FrameLayout.LayoutParams(-1, -1));
        layoutParams2.addRule(0, 300001);
        layoutParams2.setMargins(0, r.b(20.0f), r.b(8.0f), r.b(1.0f));
        textView.setGravity(16);
        if (layoutParams != null) {
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.setMargins(0, r.b(23.0f), r.b(10.0f), 0);
        }
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(r.a(34.0f), r.a(16.0f));
        layoutParams6.addRule(9);
        layoutParams6.addRule(2);
        layoutParams6.setMargins(r.b(6.0f), 0, 0, r.a(38.0f));
        layoutParams6.addRule(6, 920101);
        textView.setVisibility(8);
        addView(frameLayout, new RelativeLayout.LayoutParams(-1, -1));
        if (view != null) {
            view.setVisibility(4);
            addView(view, layoutParams);
        }
        addView(textView, layoutParams2);
        addView(imageView, layoutParams6);
        addView(textView2);
        textView.setShadowLayer(3.0f, 0.0f, 1.0f, 1711276032);
        textView.setTextColor(-1);
        textView.setText("");
        imageView.setImageDrawable(q.a("ubix/ic_logo.png", this.W));
        if (this.n) {
            RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams7.addRule(12);
            layoutParams7.setMargins(r.b(6.0f), 0, r.b(6.0f), r.b(6.0f));
            addView(com.ubix.ssp.ad.e.f.a(getContext()), layoutParams7);
        }
        setOnClickListener(this);
        if (this.N) {
            View viewH2 = h();
            addView(viewH2);
            viewH2.setOnClickListener(this);
        }
        setBackgroundColor(-921103);
    }

    private void setClickArea(int i2) {
        HashMap<String, String> map;
        String str;
        if (i2 == 132 || i2 == 68) {
            map = this.f8574a;
            str = "4";
        } else if (i2 == 16) {
            map = this.f8574a;
            str = "7";
        } else if (i2 == 32) {
            map = this.f8574a;
            str = "11";
        } else {
            if ((i2 & 4) != 4) {
                return;
            }
            map = this.f8574a;
            str = "4";
        }
        map.put("__CLICK_AREA__", str);
        this.f8574a.put("__CLICK_TRIGGER__", str);
    }

    private void t() {
        l lVar;
        if (this.u.get() || !isShown()) {
            return;
        }
        this.u.set(true);
        com.ubix.ssp.ad.g.k.i iVar = this.A;
        if (iVar != null) {
            iVar.a(this.b, this);
        }
        x();
        try {
            if (this.U == 0) {
                if ((this.v == null || this.v.isRunning()) && (lVar = this.p) != null) {
                    lVar.c();
                }
            } else if ((this.w == null || !this.w.b()) && (lVar = this.p) != null) {
                lVar.c();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        post(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean u() {
        return ((double) getHeight()) > ((double) this.x) * 0.88d;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x001d  */
    /* JADX WARN: Code duplicated, block: B:15:0x0020  */
    private void v() {
        int i2 = com.ubix.ssp.ad.d.b.h;
        if (i2 == 0) {
            this.U = 0;
        } else if (i2 == 1) {
            this.U = 1;
        } else if (i2 == 2) {
            if (Build.VERSION.SDK_INT < 33 || ValueAnimator.getDurationScale() != 1.0f) {
                this.U = 1;
            } else {
                this.U = 0;
            }
        }
        if (this.U != 0) {
            if (this.w != null) {
                return;
            }
            this.w = new com.ubix.ssp.ad.e.a0.g(this.r);
            this.w.a(new h());
            this.w.e();
            return;
        }
        if (this.v != null) {
            return;
        }
        this.v = ValueAnimator.ofInt(99, 0);
        this.v.setDuration(this.r);
        this.v.setInterpolator(new LinearInterpolator());
        this.v.addUpdateListener(new f());
        this.v.addListener(new g());
        this.v.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        TextView textView;
        String str;
        v();
        View viewFindViewById = findViewById(300001);
        if (viewFindViewById == null) {
            return;
        }
        viewFindViewById.setVisibility(0);
        int i2 = this.o;
        if (i2 == 2) {
            com.ubix.ssp.ad.e.g gVar = (com.ubix.ssp.ad.e.g) viewFindViewById;
            gVar.setDuration(this.s);
            gVar.e();
        } else {
            if (i2 == 3) {
                textView = (TextView) viewFindViewById;
                str = "跳过";
            } else if (i2 == 4) {
                textView = (TextView) viewFindViewById;
                str = "跳过 " + (this.s / 1000);
            }
            textView.setText(str);
        }
        viewFindViewById.setOnClickListener(this);
    }

    private void x() {
        TextView textView = (TextView) findViewById(920101);
        if (textView != null) {
            int iB = this.y - r.b(12.0f);
            textView.getPaint().measureText(((Object) textView.getText()) + "");
            textView.setMinWidth(iB);
        }
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0074 A[PHI: r0 r15
  0x0074: PHI (r0v39 android.view.View) = (r0v35 android.view.View), (r0v44 android.view.View), (r0v50 android.view.View) binds: [B:51:0x00e7, B:33:0x0072, B:30:0x0059] A[DONT_GENERATE, DONT_INLINE]
  0x0074: PHI (r15v6 com.ubix.ssp.ad.j.a) = (r15v4 com.ubix.ssp.ad.j.a), (r15v0 com.ubix.ssp.ad.j.a), (r15v0 com.ubix.ssp.ad.j.a) binds: [B:51:0x00e7, B:33:0x0072, B:30:0x0059] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:83:0x01b3 A[PHI: r0 r10
  0x01b3: PHI (r0v4 android.view.View) = (r0v3 android.view.View), (r0v11 android.view.View), (r0v15 android.view.View), (r0v39 android.view.View) binds: [B:82:0x01b1, B:78:0x0188, B:71:0x0162, B:34:0x0074] A[DONT_GENERATE, DONT_INLINE]
  0x01b3: PHI (r10v1 'this' com.ubix.ssp.ad.j.a) = 
  (r10v0 'this' com.ubix.ssp.ad.j.a)
  (r10v5 'this' com.ubix.ssp.ad.j.a)
  (r10v6 'this' com.ubix.ssp.ad.j.a)
  (r10v14 'this' com.ubix.ssp.ad.j.a)
 binds: [B:82:0x01b1, B:78:0x0188, B:71:0x0162, B:34:0x0074] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.ubix.ssp.ad.b
    public void a(int i2, int i3, int i4, double d2, int i5, int[] iArr, int i6, String str, String str2, int i7, double d3, boolean z, boolean z2) {
        View viewFindViewById;
        String str3;
        String str4;
        a aVar = this;
        aVar.E = i2;
        aVar.F = i4;
        if (i2 == 16) {
            this = aVar;
            a(i2, str, str2, d2, i5);
            viewFindViewById = this.findViewById(910501);
            if (viewFindViewById != null) {
                viewFindViewById.setOnClickListener(this);
            }
        } else if (i2 == 32) {
            this = aVar;
            this.b(i2, d2, i5);
            this.a(i2, str, str2, true);
        } else if (i2 == 64 || i2 == 68) {
            this = aVar;
            a(i2, str, str2, this.M, d2, i5);
            viewFindViewById = this.findViewById(910701);
            if (viewFindViewById != null) {
                viewFindViewById.setOnClickListener(this);
            }
        } else if (i2 == 128 || i2 == 132) {
            this = aVar;
            this.a(i2, d2, i5);
            this.a(i2, str, str2, true);
            viewFindViewById = this.findViewById(910401);
            if (viewFindViewById != null) {
                viewFindViewById.setOnClickListener(this);
            }
        } else if (i2 == 2) {
            if (aVar.M) {
                a(false, i3, i4, 0, true, false, d2, iArr, i6, i7, d3, z, z2);
            } else {
                a(false, i3, i4, 0, false, false, d2, iArr, i6, i7, d3, z, z2);
            }
            if (i3 == 1 && TextUtils.isEmpty(str)) {
                str3 = "扭动手机";
            } else {
                if (i3 == 2 && TextUtils.isEmpty(str)) {
                    str3 = "翻转手机";
                } else {
                    str3 = str;
                }
                a(i2, str3, str2, true);
            }
            a(i2, str3, str2, true);
        } else if (i2 != 3) {
            if (i2 == 4) {
                a(false, false, d2, i5);
                aVar.a(i2, str, str2, true);
            } else if (i2 != 5) {
                aVar.a(i2, TextUtils.isEmpty(str) ? "点击此处" : str, str2, false);
                com.ubix.ssp.ad.e.c cVar = (com.ubix.ssp.ad.e.c) aVar.findViewById(910301);
                if (cVar != null) {
                    cVar.setNeedWave(true);
                }
                viewFindViewById = aVar.findViewById(910301);
                if (viewFindViewById != null) {
                    this = aVar;
                    viewFindViewById.setOnClickListener(this);
                }
            } else {
                aVar.a(i2, str, str2, false);
                a(false, false, d2, i5);
                viewFindViewById = aVar.findViewById(910301);
                if (viewFindViewById != null) {
                    this = aVar;
                    viewFindViewById.setOnClickListener(this);
                }
            }
            this = aVar;
        } else {
            if (i3 == 1 && TextUtils.isEmpty(str)) {
                str4 = "扭动或点击";
            } else {
                str4 = (i3 == 2 && TextUtils.isEmpty(str)) ? "翻转或点击" : str;
            }
            aVar.a(i2, str4, str2, false);
            if (aVar.M) {
                a(false, i3, i4, 0, true, false, d2, iArr, i6, i7, d3, z, z2);
            } else {
                a(false, i3, i4, 0, false, false, d2, iArr, i6, i7, d3, z, z2);
            }
            aVar = this;
            viewFindViewById = aVar.findViewById(910301);
            if (viewFindViewById != null) {
                this = aVar;
                viewFindViewById.setOnClickListener(this);
            } else {
                this = aVar;
            }
        }
        this.post(this.new j());
    }

    @Override // com.ubix.ssp.ad.b
    protected void a(Context context, Bundle bundle) {
        this.Q = bundle.getInt("S_A_T");
        this.R = bundle.getLong("S_A_T_I");
        this.T = bundle.getLong("G_B_U");
        this.S = bundle.getLong("L_S_A_T_I");
        this.N = bundle.getBoolean("SUPPORT_FEED_BACK");
        this.o = bundle.getInt("SKIP_VIEW_STYLE");
        int i2 = bundle.getInt("SKIP_COUNT_TIME");
        this.s = i2;
        this.r = i2;
        this.n = bundle.getBoolean("IS_DOWNLOAD", false);
        int currentRotation = getCurrentRotation();
        if (currentRotation == 0 || currentRotation == 2) {
            this.M = false;
        } else {
            this.M = true;
        }
        this.W = bundle.getBoolean("IS_UNNAMED");
        s();
    }

    @Override // com.ubix.ssp.ad.b
    protected void a(View view) {
        super.a(view);
        view.setOnClickListener(this);
    }

    @Override // com.ubix.ssp.ad.b
    public void a(String str, String str2) {
        try {
            s sVar = this.f;
            if (sVar != null) {
                sVar.f();
            }
            View viewFindViewById = r().findViewById(910104);
            if (viewFindViewById != null) {
                viewFindViewById.setVisibility(8);
                r().removeView(viewFindViewById);
            }
            View viewFindViewById2 = r().findViewById(910301);
            if (viewFindViewById2 != null) {
                viewFindViewById2.setVisibility(8);
                r().removeView(viewFindViewById2);
            }
            a(1, this.F, 0, 0.0d, 0, new int[0], 0, str, str2, 0, 0.0d, false, false);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ubix.ssp.ad.b
    public void a(String str, String str2, String str3, String str4, String str5, String str6, long j2) {
        boolean z;
        String strA;
        super.a(str, str2, str3, str4, str5, str6, j2);
        TextView textView = (TextView) findViewById(920101);
        if (textView == null) {
            return;
        }
        if (j2 > 0) {
            strA = com.ubix.ssp.ad.e.a0.k.a(j2);
            z = true;
        } else {
            z = false;
            strA = "";
        }
        Object[] objArr = new Object[6];
        objArr[0] = str;
        objArr[1] = str2;
        objArr[2] = str3;
        objArr[3] = TextUtils.isEmpty(str5) ? "" : "丨备案号:" + str5;
        objArr[4] = TextUtils.isEmpty(str6) ? "" : "丨适用年龄:" + str6;
        objArr[5] = z ? "丨应用大小:" + strA : "";
        textView.setText(new com.ubix.ssp.ad.e.f(String.format("应用名称:%s丨应用版本:%s丨开发者:%s%s%s%s丨权限丨隐私丨功能介绍", objArr)).a(this.A));
    }

    protected boolean a(int i2, float f2, float f3) {
        Rect rect = new Rect();
        getGlobalVisibleRect(rect);
        if (i2 == 128 || i2 == 132) {
            com.ubix.ssp.ad.e.e eVar = (com.ubix.ssp.ad.e.e) findViewById(910401);
            if (eVar == null) {
                return false;
            }
            eVar.getGlobalVisibleRect(this.a0);
            return eVar.a(f2, (f3 - this.a0.top) + rect.top);
        }
        if (i2 == 64 || i2 == 68) {
            com.ubix.ssp.ad.e.d dVar = (com.ubix.ssp.ad.e.d) findViewById(910701);
            if (dVar == null) {
                return false;
            }
            dVar.getGlobalVisibleRect(this.a0);
            Rect rect2 = this.a0;
            return dVar.a(f2 - rect2.left, (f3 - rect2.top) + rect.top);
        }
        if (i2 != 16) {
            return i2 == 32 || (i2 & 4) == 4;
        }
        com.ubix.ssp.ad.e.r rVar = (com.ubix.ssp.ad.e.r) findViewById(910501);
        if (rVar == null) {
            return false;
        }
        rVar.getGlobalVisibleRect(this.a0);
        Rect rect3 = this.a0;
        return rVar.a(f2 - rect3.left, (f3 - rect3.top) + rect.top);
    }

    public void b(boolean z) {
        k(z ? 7 : 6);
    }

    @Override // com.ubix.ssp.ad.b
    public boolean b(Bundle bundle) {
        TextView textView;
        String string = bundle.getString("AD_SOURCE");
        this.H = bundle.getInt("RENDER_MODE", 0);
        this.I = bundle.getFloat("SCALE_IGNORE_PERCENT", 0.05f);
        int i2 = bundle.getInt("SCALE_HORIZONTAL_MARGIN", 5);
        this.J = i2;
        if (i2 >= 50) {
            this.J = 5;
        }
        int i3 = bundle.getInt("SCALE_VERTICAL_MARGIN", 5);
        this.K = i3;
        if (i3 >= 50) {
            this.K = 5;
        }
        if (!TextUtils.isEmpty(string) && (textView = (TextView) findViewById(Constants.version)) != null) {
            textView.setShadowLayer(4.0f, 0.0f, 1.0f, 1711276032);
            textView.setTextSize(6.0f);
            textView.setGravity(17);
            textView.setText(string);
        }
        try {
            if (!bundle.getBoolean("IS_VIDEO")) {
                return b(bundle.getStringArray("IMAGE_URL")[0]);
            }
            a(bundle.getString("VIDEO_URL"), bundle.getStringArray("IMAGE_URL")[0], bundle.getInt("VIDEO_RENDER_TYPE", 0));
            b(bundle.getBoolean("AUTO_MUTE", true));
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    @Override // com.ubix.ssp.ad.b
    public void c(int i2, int i3) {
        this.O = i2;
        this.P = i3;
    }

    @Override // com.ubix.ssp.ad.b, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.G = a(this.E, motionEvent.getX(), motionEvent.getY());
            return super.dispatchTouchEvent(motionEvent);
        }
        if (!a(this.E, motionEvent)) {
            return super.dispatchTouchEvent(motionEvent);
        }
        a(motionEvent);
        try {
            this.f8574a.put("__TRI_VAL__", Base64.encodeToString(((Math.round(this.k * 100.0f) / 100.0f) + "").getBytes(), 10));
        } catch (Exception unused) {
        }
        this.f8574a.put("__INSIDE_AREA__", this.G + "");
        setClickArea(this.E);
        com.ubix.ssp.ad.g.k.i iVar = this.A;
        if (iVar == null) {
            return true;
        }
        iVar.b(this.b, this, this.f8574a);
        return true;
    }

    @Override // com.ubix.ssp.ad.b
    public com.ubix.ssp.ad.g.k.b getInterface() {
        return this.A;
    }

    public long getSkipTime() {
        return this.r * 1000;
    }

    @Override // com.ubix.ssp.ad.b
    public void j() {
        s sVar = this.f;
        if (sVar != null) {
            sVar.a();
        }
        this.p.sendEmptyMessage(4);
    }

    public void k(int i2) {
        Message message = new Message();
        message.what = i2;
        message.arg1 = this.t + 1;
        this.p.sendMessage(message);
    }

    @Override // com.ubix.ssp.ad.b
    protected boolean n() {
        int i2 = this.E;
        return i2 == 16 || i2 == 32 || (i2 & 4) == 4;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        t();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.ubix.ssp.ad.g.k.i iVar;
        if (!BaseWrapper.ENTER_ID_AD_SDK.equals(this.f8574a.get("__CLICK_TRIGGER__"))) {
            this.f8574a.put("__CLICK_TRIGGER__", "");
        }
        if (view.getId() == 300012) {
            k(this.m.t() ? 7 : 6);
            return;
        }
        if (view.getId() == 300001) {
            u.e("get lsat by SPLASH_SKIP_VIEW_ID");
            if (this.V || System.currentTimeMillis() - com.ubix.ssp.ad.d.b.g <= this.T || this.Q != 1 || System.currentTimeMillis() - this.S <= this.R) {
                this.p.sendEmptyMessage(4);
                return;
            }
            this.V = true;
            this.S = System.currentTimeMillis();
            a(this.f8574a);
            this.f8574a.put("__CLICK_AREA__", "15");
            this.f8574a.put("__CLICK_TRIGGER__", "15");
            iVar = this.A;
            if (iVar == null) {
                return;
            }
        } else if (view.getId() == 910301 || view.getId() == 910401 || view.getId() == 910701 || view.getId() == 910501) {
            if (view.getId() == 910401 || view.getId() == 910701 || view.getId() == 910501) {
                this.f8574a.put("__INSIDE_AREA__", this.G + "");
            }
            if (this.f8574a.containsKey("__CLICK_UNREAL_TRIGGER__") && BaseWrapper.ENTER_ID_AD_SDK.equals(this.f8574a.get("__CLICK_UNREAL_TRIGGER__"))) {
                this.f8574a.put("__CLICK_AREA__", BaseWrapper.ENTER_ID_AD_SDK);
                this.f8574a.put("__CLICK_TRIGGER__", BaseWrapper.ENTER_ID_AD_SDK);
                this.f8574a.remove("__CLICK_UNREAL_TRIGGER__");
            } else {
                this.f8574a.put("__CLICK_AREA__", "2");
                this.f8574a.put("__CLICK_TRIGGER__", "2");
            }
            iVar = this.A;
            if (iVar == null) {
                return;
            }
        } else {
            if (view.getId() == 920301) {
                com.ubix.ssp.ad.g.k.i iVar2 = this.A;
                if (iVar2 != null) {
                    iVar2.a(this.b);
                    return;
                }
                return;
            }
            iVar = this.A;
            if (iVar == null) {
                return;
            }
        }
        iVar.b(this.b, view, this.f8574a);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i6;
        int iB;
        int iA;
        int iA2;
        int i7;
        int iB2;
        int iA3;
        int measuredWidth;
        int iA4;
        int measuredWidth2;
        int iA5;
        View viewFindViewById;
        int i8;
        int i9;
        int i10;
        int iA6;
        int measuredWidth3;
        int bottom;
        int measuredWidth4;
        int bottom2;
        int iA7;
        int iA8;
        int measuredWidth5;
        int i11;
        int iA9;
        int i12;
        int iA10;
        com.ubix.ssp.ad.e.c cVar;
        double d2;
        int i13;
        int i14;
        int i15;
        int iA11;
        int i16;
        com.ubix.ssp.ad.e.d dVar;
        double d3;
        com.ubix.ssp.ad.e.d dVar2;
        int i17;
        int i18;
        super.onLayout(z, i2, i3, i4, i5);
        for (int i19 = 0; i19 < getChildCount(); i19 = i6 + 1) {
            try {
                View childAt = getChildAt(i19);
                switch (childAt.getId()) {
                    case 300008:
                        i6 = i19;
                        View viewFindViewById2 = findViewById(920101);
                        if (viewFindViewById2 != null) {
                            int left = viewFindViewById2.getLeft();
                            int top = (int) (((double) viewFindViewById2.getTop()) - (((double) r.a(28.0f)) * 0.53d));
                            iA = r.a(28.0f) + viewFindViewById2.getLeft();
                            i7 = top;
                            iA2 = viewFindViewById2.getTop();
                            iB = left;
                        } else {
                            iB = r.b(6.0f);
                            int iA12 = i5 - (r.a(38.0f) + ((int) (((double) r.a(28.0f)) * 0.53d)));
                            iA = r.a(28.0f) + r.b(6.0f);
                            iA2 = i5 - r.a(38.0f);
                            i7 = iA12;
                        }
                        iB2 = iA;
                        iA3 = i7;
                        childAt.layout(iB, iA3, iB2, iA2);
                        break;
                    case 300012:
                        i6 = i19;
                        View viewFindViewById3 = findViewById(920101);
                        if (viewFindViewById3 != null) {
                            int right = viewFindViewById3.getRight() - r.a(32.0f);
                            iA3 = viewFindViewById3.getTop() - r.a(32.0f);
                            int right2 = viewFindViewById3.getRight();
                            iA2 = viewFindViewById3.getTop();
                            iB = right;
                            iB2 = right2;
                        } else {
                            iB = (i4 - r.b(6.0f)) - r.a(32.0f);
                            iA3 = i5 - (r.a(38.0f) + r.a(38.0f));
                            iB2 = i4 - r.b(6.0f);
                            iA2 = i5 - r.a(38.0f);
                        }
                        childAt.layout(iB, iA3, iB2, iA2);
                        break;
                    case Constants.version /* 300016 */:
                        i6 = i19;
                        View viewFindViewById4 = findViewById(300008);
                        childAt.layout(viewFindViewById4.getRight(), viewFindViewById4.getTop() + ((viewFindViewById4.getHeight() - childAt.getMeasuredHeight()) / 2), viewFindViewById4.getRight() + childAt.getMeasuredWidth(), viewFindViewById4.getTop() + ((viewFindViewById4.getHeight() + childAt.getMeasuredHeight()) / 2));
                        break;
                    case 900100:
                        i6 = i19;
                        try {
                            if (this.H == 1) {
                                int i20 = i4 - i2;
                                int i21 = i5 - i3;
                                if (!e(i20, i21)) {
                                    com.ubix.ssp.ad.e.t.a.e eVar = (com.ubix.ssp.ad.e.t.a.e) childAt.findViewWithTag(900102);
                                    eVar.setScaleType(ImageView.ScaleType.FIT_CENTER);
                                    Rect rectD = d(i20, i21);
                                    if (rectD.width() > 0 && rectD.height() > 0 && childAt.findViewWithTag(900102) != null) {
                                        eVar.layout(rectD.left, rectD.top, rectD.right, rectD.bottom);
                                    }
                                }
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        break;
                    case 910100:
                        i6 = i19;
                        if (com.ubix.ssp.ad.e.a0.c.h(getContext())) {
                            childAt.layout((this.y - childAt.getMeasuredWidth()) / 2, (i5 - r.a(180.0f)) - childAt.getMeasuredHeight(), (this.y + childAt.getMeasuredWidth()) / 2, i5 - r.a(180.0f));
                            viewFindViewById = childAt.findViewById(910104);
                        } else if (this.M) {
                            childAt.layout((this.y - childAt.getMeasuredWidth()) / 2, (i5 - r.a(130.0f)) - childAt.getMeasuredHeight(), (this.y + childAt.getMeasuredWidth()) / 2, i5 - r.a(130.0f));
                            ((com.ubix.ssp.ad.e.k) childAt.findViewById(910104)).a(true);
                        } else {
                            if (u()) {
                                measuredWidth = (this.y - childAt.getMeasuredWidth()) / 2;
                                iA4 = (i5 - r.a(210.0f)) - childAt.getMeasuredHeight();
                                measuredWidth2 = (this.y + childAt.getMeasuredWidth()) / 2;
                                iA5 = r.a(210.0f);
                            } else {
                                measuredWidth = (this.y - childAt.getMeasuredWidth()) / 2;
                                iA4 = (i5 - r.a(165.0f)) - childAt.getMeasuredHeight();
                                measuredWidth2 = (this.y + childAt.getMeasuredWidth()) / 2;
                                iA5 = r.a(165.0f);
                            }
                            childAt.layout(measuredWidth, iA4, measuredWidth2, i5 - iA5);
                            viewFindViewById = childAt.findViewById(910104);
                        }
                        ((com.ubix.ssp.ad.e.k) viewFindViewById).a(false);
                        break;
                    case 910101:
                        i6 = i19;
                        if (u()) {
                            int i22 = this.y;
                            i8 = (i22 - (i22 / 5)) / 2;
                            int iA13 = i5 - r.a(200.0f);
                            int i23 = this.y;
                            i9 = iA13 - (i23 / 5);
                            i10 = (i23 + (i23 / 5)) / 2;
                            iA6 = r.a(200.0f);
                        } else {
                            int i24 = this.y;
                            i8 = (i24 - (i24 / 5)) / 2;
                            int iA14 = i5 - r.a(120.0f);
                            int i25 = this.y;
                            i9 = iA14 - (i25 / 5);
                            i10 = (i25 + (i25 / 5)) / 2;
                            iA6 = r.a(120.0f);
                        }
                        iA2 = i5 - iA6;
                        iB2 = i10;
                        iA3 = i9;
                        iB = i8;
                        childAt.layout(iB, iA3, iB2, iA2);
                        break;
                    case 910102:
                        i6 = i19;
                        if (u()) {
                            measuredWidth3 = (this.y - childAt.getMeasuredWidth()) / 2;
                            bottom = findViewById(910101).getBottom() + 20;
                            measuredWidth4 = (this.y + childAt.getMeasuredWidth()) / 2;
                            bottom2 = findViewById(910101).getBottom();
                        } else {
                            measuredWidth3 = (this.y - childAt.getMeasuredWidth()) / 2;
                            bottom = findViewById(910101).getBottom() + 20;
                            measuredWidth4 = (this.y + childAt.getMeasuredWidth()) / 2;
                            bottom2 = findViewById(910101).getBottom();
                        }
                        int i26 = measuredWidth4;
                        iA7 = bottom2 + r.a(20.0f) + 20;
                        iA8 = bottom;
                        measuredWidth5 = i26;
                        childAt.layout(measuredWidth3, iA8, measuredWidth5, iA7);
                        break;
                    case 910200:
                        i6 = i19;
                        if (!this.M && u()) {
                            measuredWidth3 = (this.y - childAt.getMeasuredWidth()) / 2;
                            iA8 = (i5 - r.a(190.0f)) - childAt.getMeasuredHeight();
                            measuredWidth5 = (this.y + childAt.getMeasuredWidth()) / 2;
                            iA11 = r.a(190.0f);
                            iA7 = i5 - iA11;
                            childAt.layout(measuredWidth3, iA8, measuredWidth5, iA7);
                        } else {
                            measuredWidth3 = (this.y - childAt.getMeasuredWidth()) / 2;
                            iA8 = (i5 - r.a(145.0f)) - childAt.getMeasuredHeight();
                            measuredWidth5 = (this.y + childAt.getMeasuredWidth()) / 2;
                            iA11 = r.a(145.0f);
                            iA7 = i5 - iA11;
                            childAt.layout(measuredWidth3, iA8, measuredWidth5, iA7);
                        }
                        break;
                    case 910301:
                        i6 = i19;
                        int iMin = Math.min((int) (((double) this.y) * 0.8d * 0.212d), (int) (((double) r.a().c(getContext())) * 0.15d));
                        int i27 = (int) ((this.D * 25.0d) / 2.0d);
                        if (com.ubix.ssp.ad.e.a0.c.h(getContext())) {
                            int iMin2 = (int) (((double) Math.min(this.y, this.x)) * 0.45d);
                            int i28 = (int) (((double) iMin2) * 0.2d);
                            childAt.layout(((this.y - iMin2) / 2) - i27, ((i5 - r.a(80.0f)) - i28) - i27, ((this.y + iMin2) / 2) + i27, (i5 - r.a(80.0f)) + i27);
                            cVar = (com.ubix.ssp.ad.e.c) childAt;
                            int i29 = i27 * 2;
                            i14 = iMin2 + i29;
                            i13 = i28 + i29;
                        } else {
                            if (this.M) {
                                childAt.layout(((int) (((double) this.y) * 0.3d)) - i27, ((i5 - r.a(60.0f)) - iMin) - i27, ((int) (((double) this.y) * 0.7d)) + i27, (i5 - r.a(60.0f)) + i27);
                                cVar = (com.ubix.ssp.ad.e.c) childAt;
                                d2 = ((double) this.y) * 0.4d;
                            } else {
                                if (u()) {
                                    i11 = ((int) (((double) this.y) * 0.1d)) - i27;
                                    iA9 = ((i5 - r.a(100.0f)) - iMin) - i27;
                                    i12 = ((int) (((double) this.y) * 0.9d)) + i27;
                                    iA10 = r.a(100.0f);
                                } else {
                                    i11 = ((int) (((double) this.y) * 0.1d)) - i27;
                                    iA9 = ((i5 - r.a(70.0f)) - iMin) - i27;
                                    i12 = ((int) (((double) this.y) * 0.9d)) + i27;
                                    iA10 = r.a(70.0f);
                                }
                                childAt.layout(i11, iA9, i12, (i5 - iA10) + i27);
                                cVar = (com.ubix.ssp.ad.e.c) childAt;
                                d2 = ((double) this.y) * 0.8d;
                            }
                            int i30 = i27 * 2;
                            int i31 = ((int) d2) + i30;
                            i13 = iMin + i30;
                            i14 = i31;
                        }
                        cVar.a(i14, i13);
                        break;
                    case 910401:
                        i6 = i19;
                        if (com.ubix.ssp.ad.e.a0.c.h(getContext())) {
                            if (this.M) {
                                i15 = (int) (((double) i5) * 0.5d);
                                childAt.layout(0, i5 - i15, i4, i5);
                            } else {
                                i15 = (int) (((double) i5) * 0.4d);
                                childAt.layout(0, i5 - i15, i4, i5);
                            }
                        } else if (this.M) {
                            i15 = (int) (((double) i5) * 0.65d);
                            childAt.layout(0, i5 - i15, i4, i5);
                        } else if (u()) {
                            i15 = (int) (((double) i5) * 0.45d);
                            childAt.layout(0, i5 - i15, i4, i5);
                        } else {
                            i15 = (int) (((double) i5) * 0.35d);
                            childAt.layout(0, i5 - i15, i4, i5);
                        }
                        ((com.ubix.ssp.ad.e.e) childAt).a(i4, i15);
                        break;
                    case 910501:
                        i6 = i19;
                        childAt.layout(i4 - (i4 / 4), i3, i4, i5);
                        ((com.ubix.ssp.ad.e.r) childAt).a(i4 / 4, i5);
                        break;
                    case 910601:
                        i6 = i19;
                        if (this.M) {
                            measuredWidth3 = (this.y - childAt.getMeasuredWidth()) / 2;
                            iA8 = (i5 - r.a(130.0f)) - childAt.getMeasuredHeight();
                            measuredWidth5 = (this.y + childAt.getMeasuredWidth()) / 2;
                            iA11 = r.a(130.0f);
                        } else if (u()) {
                            measuredWidth3 = (this.y - childAt.getMeasuredWidth()) / 2;
                            iA8 = (i5 - r.a(190.0f)) - childAt.getMeasuredHeight();
                            measuredWidth5 = (this.y + childAt.getMeasuredWidth()) / 2;
                            iA11 = r.a(190.0f);
                        } else {
                            measuredWidth3 = (this.y - childAt.getMeasuredWidth()) / 2;
                            iA8 = (i5 - r.a(145.0f)) - childAt.getMeasuredHeight();
                            measuredWidth5 = (this.y + childAt.getMeasuredWidth()) / 2;
                            iA11 = r.a(145.0f);
                        }
                        iA7 = i5 - iA11;
                        childAt.layout(measuredWidth3, iA8, measuredWidth5, iA7);
                        break;
                    case 910701:
                        if (!com.ubix.ssp.ad.e.a0.c.h(getContext())) {
                            i6 = i19;
                            if (this.M) {
                                double d4 = i4;
                                childAt.layout((int) (d4 * 0.2d), i5 - ((int) (0.3d * d4)), (int) (d4 * 0.8d), i5);
                                dVar2 = (com.ubix.ssp.ad.e.d) childAt;
                                i17 = (int) (d4 * 0.4d);
                                i18 = (int) (0.6d * d4);
                                dVar2.a(true, i18, i17);
                            } else {
                                double d5 = i4;
                                i16 = (int) (0.5d * d5);
                                childAt.layout((int) (0.1d * d5), i5 - i16, (int) (0.9d * d5), i5);
                                dVar = (com.ubix.ssp.ad.e.d) childAt;
                                d3 = d5 * 0.8d;
                                dVar.a(false, (int) d3, i16);
                            }
                        } else if (this.M) {
                            double d6 = i4;
                            i6 = i19;
                            childAt.layout((int) (d6 * 0.2d), i5 - ((int) (0.35d * d6)), (int) (d6 * 0.8d), i5);
                            dVar2 = (com.ubix.ssp.ad.e.d) childAt;
                            i18 = (int) (0.6d * d6);
                            i17 = (int) (d6 * 0.4d);
                            dVar2.a(true, i18, i17);
                        } else {
                            i6 = i19;
                            double d7 = i4;
                            i16 = (int) (d7 * 0.4d);
                            childAt.layout((int) (d7 * 0.2d), i5 - i16, (int) (d7 * 0.8d), i5);
                            dVar = (com.ubix.ssp.ad.e.d) childAt;
                            d3 = d7 * 0.6d;
                            dVar.a(false, (int) d3, i16);
                        }
                        break;
                    default:
                        i6 = i19;
                        break;
                }
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
            return;
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        int currentRotation = getCurrentRotation();
        this.M = (currentRotation == 0 || currentRotation == 2) ? false : true;
        this.x = r.a().c(getContext());
        this.y = r.a().h(getContext());
        x();
        post(new e());
    }

    @Override // com.ubix.ssp.ad.b, android.view.View
    protected void onVisibilityChanged(View view, int i2) {
        super.onVisibilityChanged(view, i2);
        if (i2 == 0) {
            t();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        l lVar;
        int i2;
        super.onWindowFocusChanged(z);
        if (z) {
            lVar = this.p;
            i2 = 3;
        } else {
            lVar = this.p;
            i2 = 2;
        }
        lVar.sendEmptyMessage(i2);
    }

    @Override // android.view.View
    public void onWindowSystemUiVisibilityChanged(int i2) {
        super.onWindowSystemUiVisibilityChanged(i2);
        if (i2 == 0) {
            t();
        }
    }

    @Override // com.ubix.ssp.ad.b, android.view.View
    protected void onWindowVisibilityChanged(int i2) {
        int i3;
        super.onWindowVisibilityChanged(i2);
        if (i2 != 0) {
            if (this.z != 5) {
                this.p.sendEmptyMessage(2);
                return;
            }
            return;
        }
        t();
        if (l()) {
            u.e("onWindowVisibilityChanged outer" + getWindowVisibility() + ";" + hasWindowFocus());
            if (this.P <= 0 || !((i3 = this.O) == 2 || i3 == 22)) {
                this.p.sendEmptyMessage(5);
            } else {
                try {
                    postDelayed(new RunnableC1122a(), this.P);
                } catch (Throwable unused) {
                }
            }
        }
    }

    @Override // com.ubix.ssp.ad.b
    protected void q() {
        post(new k());
    }

    @Override // com.ubix.ssp.ad.b
    protected ViewGroup r() {
        return this;
    }

    @Override // com.ubix.ssp.ad.b
    public void setInnerListener(com.ubix.ssp.ad.g.k.b bVar) {
        this.A = (com.ubix.ssp.ad.g.k.i) bVar;
    }

    @Override // com.ubix.ssp.ad.b
    protected void setShakeSensor(View view) {
        if (this.z == 5) {
            u.a("展示已经结束不再延时监听");
            return;
        }
        super.setShakeSensor(view);
        s sVar = this.f;
        if (sVar == null) {
            return;
        }
        this.C = true;
        sVar.a(new i(view));
    }
}
