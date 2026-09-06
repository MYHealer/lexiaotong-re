package com.ubix.ssp.ad.k;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.google.android.exoplayer2.ExoPlayer;
import com.huawei.hms.ads.ez;
import com.ubix.ssp.ad.e.a0.k;
import com.ubix.ssp.ad.e.a0.r;
import com.ubix.ssp.ad.e.a0.s;
import com.ubix.ssp.ad.e.a0.u;
import com.ubix.ssp.ad.e.i;
import com.ubix.ssp.ad.e.l;
import com.ubix.ssp.ad.e.q;
import com.ubix.ssp.ad.g.k.j;
import com.unionpay.tsmservice.data.Constant;
import java.io.File;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a extends com.ubix.ssp.ad.b implements View.OnClickListener, j {
    private long A;
    private com.ubix.ssp.ad.e.a0.g B;
    private AtomicBoolean C;
    int D;
    boolean E;
    private boolean F;
    private j G;
    private int H;
    private int I;
    private int J;
    private int K;
    private String L;
    boolean M;
    boolean N;
    private boolean O;
    boolean P;
    private int Q;
    private float R;
    private int S;
    private int T;
    private int U;
    private float V;
    private boolean W;
    HandlerThread a0;
    private Handler b0;
    Bitmap c0;
    Matrix d0;
    float e0;
    float f0;
    long g0;
    private final int h0;
    boolean i0;
    int j0;
    float k0;
    private com.ubix.ssp.ad.e.b0.g l;
    int l0;
    private ImageView m;
    int m0;
    private TextView n;
    int n0;
    private TextView o;
    private long o0;
    private ImageView p;
    private long p0;
    private TextView q;
    private int q0;
    private ImageView r;
    private long r0;
    private boolean s;
    private boolean s0;
    private boolean t;
    private boolean t0;
    private boolean u;
    private boolean u0;
    private boolean v;
    private boolean v0;
    private boolean w;
    private int w0;
    private boolean x;
    private Bundle x0;
    private boolean y;
    private boolean y0;
    private boolean z;

    /* JADX INFO: renamed from: com.ubix.ssp.ad.k.a$a, reason: collision with other inner class name */
    class RunnableC1124a implements Runnable {
        RunnableC1124a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.G != null) {
                a.this.G.a(1, 1L, 1L);
            }
            if (a.this.G != null) {
                a.this.G.c(0);
            }
        }
    }

    class b implements com.ubix.ssp.ad.e.a0.g.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f9030a;

        b(long j) {
            this.f9030a = j;
        }

        @Override // com.ubix.ssp.ad.e.a0.g.b
        public void a() {
        }

        @Override // com.ubix.ssp.ad.e.a0.g.b
        public void a(long j) {
            boolean z;
            int iD;
            long j2;
            if (a.this.G == null || !(a.this.G instanceof com.ubix.ssp.ad.g.k.h)) {
                z = false;
                iD = 0;
            } else {
                boolean zA = ((com.ubix.ssp.ad.g.k.h) a.this.G).a();
                a aVar = a.this;
                aVar.q0 = ((com.ubix.ssp.ad.g.k.h) aVar.G).c();
                z = zA;
                iD = ((com.ubix.ssp.ad.g.k.h) a.this.G).d();
            }
            long j3 = this.f9030a;
            float f = j3;
            int i = (int) (((j3 - j) * 100.0f) / f);
            long j4 = (long) ((i / 100.0f) * f);
            if (i > 99 || j < 100) {
                a.this.O = true;
                a.this.x();
                i = 100;
                j2 = j3;
            } else {
                j2 = j4;
            }
            a.this.a(z, iD, i, j2, j3);
            if (a.this.G != null) {
                a.this.G.a(i, j2, j3);
            }
            if (!a.this.O || a.this.G == null) {
                return;
            }
            a.this.G.c(0);
        }

        @Override // com.ubix.ssp.ad.e.a0.g.b
        public void b() {
        }
    }

    class c implements i.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i f9031a;

        c(i iVar) {
            this.f9031a = iVar;
        }

        @Override // com.ubix.ssp.ad.e.i.a
        public void a() {
            if (a.this.G != null) {
                ((com.ubix.ssp.ad.b) a.this).f8574a.put("__CLICK_AREA__", BaseWrapper.ENTER_ID_SYSTEM_HELPER);
                ((com.ubix.ssp.ad.b) a.this).f8574a.put("__CLICK_TRIGGER__", BaseWrapper.ENTER_ID_SYSTEM_HELPER);
                a.this.G.b(0, this.f9031a, ((com.ubix.ssp.ad.b) a.this).f8574a);
            }
        }
    }

    class d implements l.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ l f9032a;

        d(l lVar) {
            this.f9032a = lVar;
        }

        @Override // com.ubix.ssp.ad.e.l.c
        public void a(HashMap<String, String> map) {
            if (a.this.G != null) {
                ((com.ubix.ssp.ad.b) a.this).f8574a.putAll(map);
                ((com.ubix.ssp.ad.b) a.this).f8574a.put("__CLICK_AREA__", "21");
                ((com.ubix.ssp.ad.b) a.this).f8574a.put("__CLICK_TRIGGER__", "21");
                a.this.G.b(0, this.f9032a, ((com.ubix.ssp.ad.b) a.this).f8574a);
            }
        }

        @Override // com.ubix.ssp.ad.e.l.c
        public void onClose() {
            a.this.removeView(this.f9032a);
        }
    }

    class e implements com.ubix.ssp.ad.e.a0.g.b {
        e() {
        }

        @Override // com.ubix.ssp.ad.e.a0.g.b
        public void a() {
        }

        @Override // com.ubix.ssp.ad.e.a0.g.b
        public void a(long j) {
            float f = (400.0f - j) / 400.0f;
            if (a.this.r != null) {
                a.this.r.setAlpha(f);
            }
            a aVar = a.this;
            aVar.D = (int) (((double) (f * 100.0f)) * 0.9d);
            if (aVar.o != null) {
                a.this.o.requestLayout();
            }
            if (a.this.n != null) {
                a.this.n.requestLayout();
            }
        }

        @Override // com.ubix.ssp.ad.e.a0.g.b
        public void b() {
        }
    }

    class f implements com.ubix.ssp.ad.g.k.a {
        f() {
        }

        @Override // com.ubix.ssp.ad.g.k.b
        public void a(int i, View view) {
        }

        @Override // com.ubix.ssp.ad.g.k.b
        public void b(int i) {
        }

        @Override // com.ubix.ssp.ad.g.k.b
        public void b(int i, View view, HashMap<String, String> map) {
            String str;
            HashMap map2;
            if (view == null || view.getId() != 500104) {
                str = "";
                ((com.ubix.ssp.ad.b) a.this).f8574a.put("__CLICK_AREA__", "");
                map2 = ((com.ubix.ssp.ad.b) a.this).f8574a;
            } else {
                str = "2";
                ((com.ubix.ssp.ad.b) a.this).f8574a.put("__CLICK_AREA__", "2");
                map2 = ((com.ubix.ssp.ad.b) a.this).f8574a;
            }
            map2.put("__CLICK_TRIGGER__", str);
            if (a.this.G != null) {
                a.this.G.b(i, view, ((com.ubix.ssp.ad.b) a.this).f8574a);
            }
        }

        @Override // com.ubix.ssp.ad.g.k.b
        public void e(int i) {
        }

        @Override // com.ubix.ssp.ad.g.k.b
        public void f(int i) {
        }

        @Override // com.ubix.ssp.ad.g.k.b
        public void i(int i) {
        }
    }

    class g implements s.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f9035a;

        g(View view) {
            this.f9035a = view;
        }

        @Override // com.ubix.ssp.ad.e.a0.s.e
        public void a(float f, float f2) {
            try {
                if (!a.this.isShown() || com.ubix.ssp.ad.e.a0.y.c.a(a.this)) {
                    return;
                }
                ((com.ubix.ssp.ad.b) a.this).f.f();
                ((com.ubix.ssp.ad.b) a.this).f8574a.put("__TRI_VAL__", Base64.encodeToString((f + "").getBytes(), 10));
                ((com.ubix.ssp.ad.b) a.this).f8574a.put("__CLICK_AREA__", "3");
                ((com.ubix.ssp.ad.b) a.this).f8574a.put("__CLICK_TRIGGER__", "3");
                if (a.this.G != null) {
                    a.this.G.b(((com.ubix.ssp.ad.b) a.this).b, this.f9035a, ((com.ubix.ssp.ad.b) a.this).f8574a);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // com.ubix.ssp.ad.e.a0.s.e
        public void a(Bundle bundle) {
            try {
                if (!a.this.isShown() || com.ubix.ssp.ad.e.a0.y.c.a(a.this)) {
                    return;
                }
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
                if (a.this.G != null) {
                    a.this.G.a(((com.ubix.ssp.ad.b) a.this).b, bundle);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    class h implements Runnable {
        h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (a.this.W) {
                    return;
                }
                a aVar = a.this;
                if (aVar.j0 == -99) {
                    aVar.j0 = 3;
                }
                if (aVar.j0 <= 0) {
                    aVar.j0 = -99;
                    aVar.b0.postDelayed(this, 1500L);
                    a aVar2 = a.this;
                    int i = aVar2.n0 - 1;
                    aVar2.n0 = i;
                    if (i < 1) {
                        aVar2.W = true;
                        return;
                    }
                    return;
                }
                if (aVar.findViewById(500100) != null) {
                    a aVar3 = a.this;
                    if (aVar3.l0 * aVar3.m0 <= 0) {
                        aVar3.l0 = (aVar3.findViewById(500100).getRight() / 5) * 4;
                        a aVar4 = a.this;
                        aVar4.m0 = aVar4.findViewById(500100).getBottom() - ((a.this.findViewById(500100).getBottom() - a.this.findViewById(500100).getTop()) / 2);
                    }
                }
                a.this.postInvalidate();
                a.this.b0.postDelayed(this, 16L);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public a(Context context) {
        super(context);
        this.s = true;
        this.t = true;
        this.u = true;
        this.v = true;
        this.w = true;
        this.x = false;
        this.y = true;
        this.z = true;
        this.A = -1L;
        this.C = new AtomicBoolean(true);
        this.D = 0;
        this.E = false;
        this.F = false;
        this.H = -1;
        this.M = false;
        this.N = false;
        this.O = false;
        this.P = true;
        this.Q = 0;
        this.R = 0.05f;
        this.S = 5;
        this.T = 5;
        this.U = 0;
        this.V = 0.5625f;
        this.W = false;
        this.a0 = new HandlerThread("ConfirmViewDraw");
        this.d0 = new Matrix();
        this.e0 = 1.5f;
        this.f0 = 50.0f;
        this.h0 = 16;
        this.i0 = false;
        this.j0 = 3;
        this.k0 = 0.2f;
        this.n0 = 3;
        this.o0 = -1L;
        this.q0 = 0;
        this.r0 = 0L;
        this.s0 = false;
        this.t0 = false;
        this.u0 = false;
        this.v0 = false;
        this.w0 = 0;
        this.x0 = null;
        this.y0 = false;
    }

    public a(Context context, Bundle bundle) {
        super(context);
        this.s = true;
        this.t = true;
        this.u = true;
        this.v = true;
        this.w = true;
        this.x = false;
        this.y = true;
        this.z = true;
        this.A = -1L;
        this.C = new AtomicBoolean(true);
        this.D = 0;
        this.E = false;
        this.F = false;
        this.H = -1;
        this.M = false;
        this.N = false;
        this.O = false;
        this.P = true;
        this.Q = 0;
        this.R = 0.05f;
        this.S = 5;
        this.T = 5;
        this.U = 0;
        this.V = 0.5625f;
        this.W = false;
        this.a0 = new HandlerThread("ConfirmViewDraw");
        this.d0 = new Matrix();
        this.e0 = 1.5f;
        this.f0 = 50.0f;
        this.h0 = 16;
        this.i0 = false;
        this.j0 = 3;
        this.k0 = 0.2f;
        this.n0 = 3;
        this.o0 = -1L;
        this.q0 = 0;
        this.r0 = 0L;
        this.s0 = false;
        this.t0 = false;
        this.u0 = false;
        this.v0 = false;
        this.w0 = 0;
        this.x0 = null;
        this.y0 = false;
        a(context, bundle);
    }

    private void a(boolean z) {
        try {
            ImageView imageView = this.r;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            if (z) {
                com.ubix.ssp.ad.e.a0.g gVar = new com.ubix.ssp.ad.e.a0.g(400L);
                gVar.a(new e());
                gVar.e();
                return;
            }
            ImageView imageView2 = this.r;
            if (imageView2 != null) {
                imageView2.setAlpha(1.0f);
            }
            this.D = 90;
            TextView textView = this.o;
            if (textView != null) {
                textView.requestLayout();
            }
            TextView textView2 = this.n;
            if (textView2 != null) {
                textView2.requestLayout();
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:100:0x0213  */
    /* JADX WARN: Code duplicated, block: B:169:0x0323  */
    /* JADX WARN: Code duplicated, block: B:71:0x0185  */
    /* JADX WARN: Code duplicated, block: B:96:0x0206  */
    public void a(boolean z, int i, int i2, long j, long j2) {
        boolean z2;
        j jVar;
        TextView textView;
        String str;
        TextView textView2;
        String str2;
        j jVar2;
        if (this.t) {
            this.o0 = Math.min(this.p0, (int) ((((long) (this.P ? this.J : 100)) * j2) / 100));
            if (i2 != 0) {
                u.e("updateCountdown=" + this.o0 + ";isRewarded=" + z + ";" + i + ";progress=" + i2 + ";position=" + j + ";duration=" + j2);
                this.n.setVisibility(0);
                int i3 = this.K;
                if (i3 == 0) {
                    if (z && (i == 0 || i == 3)) {
                        this.n.setText("恭喜获得奖励");
                        x();
                    } else if (!z && i == 3) {
                        this.n.setText("奖励获取失败");
                    } else if (!this.n.getText().equals("恭喜获得奖励") && !this.n.getText().equals("奖励获取失败")) {
                        long j3 = this.o0 - j;
                        if (j3 < 100) {
                            this.n.setText("奖励获取中");
                        } else {
                            textView = this.n;
                            str = ((j3 / 1000) + 1) + "秒后" + (TextUtils.isEmpty(this.L) ? "获取奖励" : this.L);
                            textView.setText(str);
                        }
                    }
                } else if (i3 == 1 || i3 == 2) {
                    if (!z || (i != 0 && i != 3)) {
                        if (z || i != 3) {
                            textView = this.n;
                            str = TextUtils.isEmpty(this.L) ? "点击并跳转获取奖励" : this.L;
                            textView.setText(str);
                        } else {
                            this.n.setText("奖励获取失败");
                        }
                    }
                    this.n.setText("恭喜获得奖励");
                    x();
                } else if (i3 == 3 || i3 == 4 || i3 == 6) {
                    if (z && (i == 0 || i == 3)) {
                        this.n.setText("恭喜获得奖励");
                    } else if (j >= this.o0) {
                        j jVar3 = this.G;
                        if (jVar3 instanceof com.ubix.ssp.ad.g.k.h) {
                            ((com.ubix.ssp.ad.g.k.h) jVar3).f();
                        }
                        int i4 = this.K;
                        if (i4 != 2 && i4 != 1) {
                        }
                    } else if (!this.n.getText().equals("恭喜获得奖励") && !this.n.getText().equals("奖励获取失败")) {
                        long j4 = this.o0 - j;
                        if (j4 < 100) {
                            this.n.setText("奖励获取中");
                        } else {
                            if (!z && i == 3) {
                                this.n.setText("奖励获取失败");
                            } else if (!this.n.getText().equals("奖励获取中")) {
                                int i5 = this.K;
                                if (i5 == 3 || i5 == 4 || i5 == 6) {
                                    textView2 = this.n;
                                    str2 = (((int) (j4 / 1000)) + 1) + "秒后" + this.L;
                                } else {
                                    textView2 = this.n;
                                    str2 = String.format(this.L, Integer.valueOf((((int) (this.o0 - j)) / 1000) + 1));
                                }
                                textView2.setText(str2);
                            }
                            this.n.setVisibility(0);
                        }
                    }
                    x();
                } else if (i3 == 5) {
                    if (z && (i == 0 || i == 3)) {
                        this.n.setText("恭喜获得奖励");
                        x();
                    } else if (z || i != 3) {
                        try {
                            this.n.setText(String.format(TextUtils.isEmpty(this.L) ? "点击广告并停留%s秒获取奖励" : this.L, this.q0 + ""));
                        } catch (Throwable unused) {
                            textView = this.n;
                            str = String.format("点击广告并停留%s秒获取奖励", this.q0 + "");
                            textView.setText(str);
                        }
                    } else {
                        this.n.setText("奖励获取失败");
                    }
                }
                long j5 = this.r0;
                if (j5 >= 0 && !this.s0 && j > j5) {
                    this.s0 = true;
                    j jVar4 = this.G;
                    if (jVar4 instanceof com.ubix.ssp.ad.g.k.h) {
                        ((com.ubix.ssp.ad.g.k.h) jVar4).b();
                    }
                }
                if (!this.M && (jVar2 = this.G) != null && (jVar2 instanceof com.ubix.ssp.ad.g.k.h)) {
                    ((com.ubix.ssp.ad.g.k.h) jVar2).e();
                }
                this.M = true;
                j jVar5 = this.G;
                if (jVar5 != null && (jVar5 instanceof com.ubix.ssp.ad.g.k.h) && ((com.ubix.ssp.ad.g.k.h) jVar5).g()) {
                    y();
                }
                if (this.w0 == 1 && j > ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS && !this.v0) {
                    try {
                        this.v0 = true;
                        i iVar = new i(getContext());
                        iVar.a(this.x0);
                        iVar.setId(500201);
                        iVar.setVisibility(8);
                        iVar.setClickListener(new c(iVar));
                        iVar.a(iVar, 500L);
                        addView(iVar);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
                if (this.w0 == 2) {
                    try {
                        long j6 = this.o0;
                        if (j6 - j < 5000 && j6 > 0 && !this.y0) {
                            this.y0 = true;
                            if (l()) {
                                return;
                            }
                            l lVar = new l(getContext());
                            lVar.setId(500202);
                            lVar.setVisibility(8);
                            lVar.a(lVar, 500L);
                            addView(lVar);
                            lVar.a(this.x0);
                            lVar.setVisibility(0);
                            lVar.setClickListener(new d(lVar));
                        }
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                }
            }
            if (j < this.o0 || i2 == 0) {
                return;
            }
            if (this.N || (jVar = this.G) == null) {
                z2 = true;
            } else {
                if (jVar instanceof com.ubix.ssp.ad.g.k.h) {
                    ((com.ubix.ssp.ad.g.k.h) jVar).f();
                }
                int i6 = this.K;
                if (i6 != 2) {
                    z2 = true;
                    if (i6 != 1) {
                        x();
                    }
                } else {
                    z2 = true;
                }
            }
            this.N = z2;
        }
    }

    private void b(boolean z) {
        if (this.F) {
            return;
        }
        this.F = true;
        a(z);
        this.r.setOnClickListener(this);
    }

    private boolean b(String str) {
        try {
            int i = this.Q;
            if (i == 1) {
                Bitmap bitmapB = com.ubix.ssp.ad.e.a0.c.b(str);
                if (bitmapB != null) {
                    if (bitmapB.getHeight() != 0) {
                        this.V = (bitmapB.getWidth() * 1.0f) / bitmapB.getHeight();
                    }
                    setBackground(new BitmapDrawable(bitmapB));
                }
            } else if (i == 2) {
                ((com.ubix.ssp.ad.e.t.a.e) findViewById(900102)).setScaleType(ImageView.ScaleType.CENTER_CROP);
            }
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    private Rect d(int i, int i2) {
        Rect rect = new Rect();
        if (i * i2 > 0) {
            int i3 = (int) (this.T * i2 * 0.01f);
            int i4 = (int) (this.S * i * 0.01f);
            rect.left = i4;
            rect.top = i3;
            rect.right = i - i4;
            rect.bottom = i2 - i3;
        }
        return rect;
    }

    private boolean e(int i, int i2) {
        return Math.abs((this.V / ((((float) i) * 1.0f) / ((float) i2))) - 1.0f) <= this.R;
    }

    private void s() {
        if (this.w) {
            Bundle bundle = new Bundle();
            bundle.putInt("AD_WIDTH", (int) (r.a().h(getContext()) / r.a().a(getContext())));
            bundle.putInt("AD_HEIGHT", 100);
            bundle.putInt("TEMPLATE_ID", 99001);
            com.ubix.ssp.ad.b bVarA = com.ubix.ssp.ad.b.a(getContext(), bundle, 4, false);
            bVarA.setId(500100);
            addView(bVarA);
            bVarA.setInnerListener(new f());
        }
        TextView textView = new TextView(getContext());
        this.n = textView;
        textView.setMaxLines(1);
        this.n.setMaxWidth(r.a().h(getContext()) - (r.a(40.0f) * 2));
        this.n.setEllipsize(TextUtils.TruncateAt.END);
        this.n.setId(500005);
        this.n.setTextColor(-1);
        this.n.setGravity(17);
        this.n.setVisibility(4);
        this.n.setPadding(r.a(7.0f), 0, r.a(7.0f), 0);
        if (this.z) {
            Drawable drawableA = q.a("ubix/ic_reward_gift.webp");
            drawableA.setBounds(-r.a(2.0f), 0, r.a(16.0f) - r.a(2.0f), r.a(16.0f));
            this.n.setCompoundDrawables(drawableA, null, null, null);
        }
        addView(this.n, new RelativeLayout.LayoutParams(-2, r.a(28.0f)));
        if (this.y) {
            this.n.setOnClickListener(this);
        }
        if (this.s) {
            ImageView imageView = new ImageView(getContext());
            this.m = imageView;
            imageView.setId(500002);
            addView(this.m);
            this.m.setOnClickListener(this);
            this.m.setVisibility(8);
        }
        if (this.x) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            layoutParams.addRule(14);
            layoutParams.setMargins(r.a(16.0f), 0, r.a(16.0f), r.b(2.0f));
            addView(com.ubix.ssp.ad.e.f.a(getContext()), layoutParams);
        }
        if (this.u) {
            ImageView imageView2 = new ImageView(getContext());
            this.p = imageView2;
            imageView2.setId(500003);
            this.p.setImageDrawable(q.a("ubix/ic_logo.png", this.u0));
            addView(this.p);
        }
        if (this.v) {
            TextView textView2 = new TextView(getContext());
            this.q = textView2;
            textView2.setId(500006);
            this.q.setTextColor(-1);
            this.q.setTextSize(6.0f);
            addView(this.q);
        }
        ImageView imageView3 = new ImageView(getContext());
        this.r = imageView3;
        imageView3.setId(500004);
        this.r.setImageDrawable(q.a("ubix/ic_close_shade.webp"));
        this.r.setAlpha(0.0f);
        this.r.setVisibility(4);
        addView(this.r);
        if (this.t0) {
            View viewH = h();
            addView(viewH);
            viewH.setOnClickListener(this);
        }
    }

    private void setTimer(long j) {
        boolean zA;
        int iD;
        if (j != 0) {
            if (this.B != null) {
                return;
            }
            com.ubix.ssp.ad.e.a0.g gVar = new com.ubix.ssp.ad.e.a0.g(j);
            this.B = gVar;
            gVar.a(new b(j));
            this.B.e();
            return;
        }
        this.O = true;
        j jVar = this.G;
        if (jVar == null || !(jVar instanceof com.ubix.ssp.ad.g.k.h)) {
            zA = false;
            iD = 0;
        } else {
            zA = ((com.ubix.ssp.ad.g.k.h) jVar).a();
            iD = ((com.ubix.ssp.ad.g.k.h) this.G).d();
        }
        a(zA, iD, 1, 1L, 1L);
        postDelayed(new RunnableC1124a(), 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        try {
            this.W = true;
            this.j0 = 0;
            HandlerThread handlerThread = this.a0;
            if (handlerThread != null) {
                handlerThread.quitSafely();
                this.a0 = null;
            }
            this.b0 = null;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ubix.ssp.ad.g.k.b
    public void a(int i) {
    }

    @Override // com.ubix.ssp.ad.g.k.j
    public void a(int i, int i2) {
        j jVar = this.G;
        if (jVar != null) {
            jVar.a(i, i2);
        }
    }

    @Override // com.ubix.ssp.ad.b
    public void a(int i, int i2, int i3, double d2, int i4, int[] iArr, int i5, String str, String str2, int i6, double d3, boolean z, boolean z2) {
        View viewFindViewById;
        a aVar = this;
        aVar.I = i;
        try {
            if (getContext() instanceof Activity) {
                aVar.H = ((Activity) getContext()).getWindowManager().getDefaultDisplay().getRotation();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        int i7 = aVar.H;
        boolean z3 = i7 == 1 || i7 == 3;
        if (i == 2) {
            aVar.a(i, str, str2, true);
            a(false, 0, i3, 0, z3, false, d2, iArr, i5, i6, d3, z, z2);
            return;
        }
        if (i == 3) {
            aVar.a(i, TextUtils.isEmpty(str) ? "摇动或点击图标" : str, str2, true);
            a(false, 0, i3, 0, z3, false, d2, iArr, i5, i6, d3, z, z2);
            aVar = this;
            viewFindViewById = aVar.findViewById(910100);
            if (viewFindViewById == null) {
                return;
            }
        } else if (i == 32) {
            a(i, false, d2, i4);
            aVar.a(i, str, str2, true);
            return;
        } else {
            if (i != 33) {
                return;
            }
            a(i, false, d2, i4);
            aVar.a(i, TextUtils.isEmpty(str) ? "滑动或点击图标" : str, str2, true);
            viewFindViewById = aVar.findViewById(910601);
            if (viewFindViewById == null) {
                return;
            }
        }
        viewFindViewById.setOnClickListener(aVar);
    }

    @Override // com.ubix.ssp.ad.g.k.j
    public void a(int i, long j, long j2) {
        boolean z;
        int iD;
        j jVar = this.G;
        if (jVar == null || !(jVar instanceof com.ubix.ssp.ad.g.k.h)) {
            z = false;
            iD = 0;
        } else {
            boolean zA = ((com.ubix.ssp.ad.g.k.h) jVar).a();
            this.q0 = ((com.ubix.ssp.ad.g.k.h) this.G).c();
            z = zA;
            iD = ((com.ubix.ssp.ad.g.k.h) this.G).d();
        }
        a(z, iD, i, j, j2);
        j jVar2 = this.G;
        if (jVar2 != null) {
            jVar2.a(i, j, j2);
        }
    }

    @Override // com.ubix.ssp.ad.g.k.b
    public void a(int i, Bundle bundle) {
    }

    @Override // com.ubix.ssp.ad.g.k.b
    public void a(int i, View view) {
        j jVar = this.G;
        if (jVar != null) {
            jVar.a(i, view);
        }
    }

    @Override // com.ubix.ssp.ad.b
    protected void a(Context context, Bundle bundle) {
        this.x = bundle.getBoolean("IS_DOWNLOAD", false);
        this.t0 = bundle.getBoolean("SUPPORT_FEED_BACK");
        int i = bundle.getInt("COUNTDOWN_STATUS", 0);
        this.z = i == 1 || i == 3;
        int i2 = 2;
        this.y = i == 2 || i == 3;
        this.K = bundle.getInt("REWARD_TYPE", 0);
        this.r0 = bundle.getLong("REWARD_GUIDE_START_TIME");
        this.q0 = (int) (bundle.getLong("REWARD_TASK_TIME") / 1000);
        this.J = bundle.getInt("REWARD_PLAY_PERCENT", 90);
        this.p0 = bundle.getLong("REWARD_DURATION", -1L);
        this.L = bundle.getString("REWARD_DESCRIPTION", "");
        int i3 = bundle.getInt("VIDEO_RENDER_TYPE", 0);
        this.u0 = bundle.getBoolean("IS_UNNAMED");
        if (i3 != 0) {
            i2 = i3;
        } else if (!com.ubix.ssp.ad.d.b.f8605a.isUseTextureView()) {
            i2 = 1;
        }
        this.l = new com.ubix.ssp.ad.e.b0.g(context, i2);
        if (bundle.getInt("AD_TYPE") == 1) {
            this.l.a(false);
        }
        this.l.setId(500001);
        com.ubix.ssp.ad.e.t.a.e eVar = new com.ubix.ssp.ad.e.t.a.e(getContext());
        eVar.setId(900102);
        eVar.setScaleType(ImageView.ScaleType.FIT_XY);
        addView(this.l, new RelativeLayout.LayoutParams(-1, -1));
        addView(eVar);
        s();
    }

    @Override // com.ubix.ssp.ad.b
    public void a(Bundle bundle) {
        View viewFindViewById;
        if (!"reward".equals(bundle.getString("type"))) {
            if (!Constant.CASH_LOAD_CANCEL.equals(bundle.getString("type")) || (viewFindViewById = findViewById(500202)) == null) {
                return;
            }
            ((l) viewFindViewById).a();
            return;
        }
        j jVar = this.G;
        if (jVar instanceof com.ubix.ssp.ad.g.k.h) {
            boolean zA = ((com.ubix.ssp.ad.g.k.h) jVar).a();
            this.q0 = ((com.ubix.ssp.ad.g.k.h) this.G).c();
            int iD = ((com.ubix.ssp.ad.g.k.h) this.G).d();
            long j = this.A;
            a(zA, iD, 100, j, j);
        }
    }

    public void a(String str) {
        if (str == null || findViewById(900102) == null) {
            return;
        }
        try {
            com.ubix.ssp.ad.e.v.e.b().a(str, (ImageView) findViewById(900102), 10, null);
        } catch (Exception unused) {
        }
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
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ubix.ssp.ad.b
    public void a(String str, String str2, String str3, String str4, String str5, String str6, long j) {
        boolean z;
        String strA;
        super.a(str, str2, str3, str4, str5, str6, j);
        TextView textView = (TextView) findViewById(920101);
        if (textView == null) {
            return;
        }
        if (j > 0) {
            strA = k.a(j);
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
        textView.setText(new com.ubix.ssp.ad.e.f(String.format("应用名称:%s丨应用版本:%s丨开发者:%s%s%s%s丨权限丨隐私丨功能介绍", objArr)).a(this.G));
    }

    @Override // com.ubix.ssp.ad.g.k.b
    public void b(int i) {
        j jVar = this.G;
        if (jVar != null) {
            jVar.b(i);
        }
    }

    @Override // com.ubix.ssp.ad.g.k.j
    public void b(int i, int i2) {
        j jVar = this.G;
        if (jVar != null) {
            jVar.b(i, i2);
        }
    }

    @Override // com.ubix.ssp.ad.g.k.b
    public void b(int i, View view, HashMap<String, String> map) {
        map.put("__CLICK_TRIGGER__", "");
        this.f8574a.putAll(map);
        j jVar = this.G;
        if (jVar != null) {
            jVar.b(i, this, this.f8574a);
        }
    }

    public void b(String str, String str2) {
        String str3 = k.f(getContext()).getPath() + "/" + str.hashCode();
        File fileA = com.ubix.ssp.ad.e.v.e.c().a(str);
        if (fileA != null && fileA.exists()) {
            str = str3;
        }
        this.l.a(str, (String) null);
        this.l.setVideoViewListener(this);
        this.l.setVideoImageDisplayType(4);
        if (str2 == null || findViewById(900102) == null) {
            return;
        }
        try {
            com.ubix.ssp.ad.e.v.e.b().a(str2, (ImageView) findViewById(900102), 10, null);
        } catch (Exception unused) {
        }
    }

    @Override // com.ubix.ssp.ad.b
    public boolean b(Bundle bundle) {
        TextView textView;
        this.x0 = bundle;
        setMute(!bundle.getBoolean("AUTO_MUTE"));
        this.P = bundle.getBoolean("IS_VIDEO");
        this.Q = bundle.getInt("RENDER_MODE", 0);
        this.w0 = bundle.getInt("VIDEO_ECTR", 0);
        this.R = bundle.getFloat("SCALE_IGNORE_PERCENT", 0.05f);
        int i = bundle.getInt("SCALE_HORIZONTAL_MARGIN", 5);
        this.S = i;
        if (i >= 50) {
            this.S = 5;
        }
        int i2 = bundle.getInt("SCALE_VERTICAL_MARGIN", 5);
        this.T = i2;
        if (i2 >= 50) {
            this.T = 5;
        }
        if (this.P) {
            b(bundle.getString("VIDEO_URL"), bundle.getStringArray("IMAGE_URL")[0]);
        } else {
            this.l.setVisibility(4);
            b(bundle.getStringArray("IMAGE_URL")[0]);
            a(bundle.getStringArray("IMAGE_URL")[0]);
            this.n.setBackground(com.ubix.ssp.ad.e.a0.c.a(getContext(), 1073741824, 72));
            setTimer(Math.max(5000L, this.p0));
            findViewById(900102).setOnClickListener(this);
        }
        if (this.w) {
            ((com.ubix.ssp.ad.b) findViewById(500100)).b(bundle);
        }
        setIsDownloadAd(this.x);
        String string = bundle.getString("AD_SOURCE");
        if (!TextUtils.isEmpty(string) && (textView = (TextView) findViewById(500006)) != null) {
            textView.setShadowLayer(4.0f, 0.0f, 1.0f, 1711276032);
            textView.setText(string);
        }
        return true;
    }

    @Override // com.ubix.ssp.ad.g.k.j
    public void c(int i) {
        this.O = true;
        a(100, this.l.getDuration(), this.l.getDuration());
        j jVar = this.G;
        if (jVar != null) {
            jVar.c(i);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        float f2;
        super.dispatchDraw(canvas);
        try {
            if (this.c0 == null) {
                return;
            }
            Matrix matrix = this.d0;
            float f3 = this.e0 + this.k0;
            matrix.setScale(f3, f3);
            if (this.i0) {
                this.k0 += 0.02f;
                float f4 = this.f0;
                if (f4 >= 50.0f) {
                    this.f0 = 50.0f;
                    this.i0 = false;
                    this.j0--;
                } else {
                    if (f4 >= 40.0f) {
                        f2 = f4 + 2.0f;
                    } else {
                        f2 = f4 >= 30.0f ? f4 + 2.5f : f4 + 3.0f;
                    }
                    this.f0 = f2;
                }
            } else {
                this.k0 -= 0.02f;
                float f5 = this.f0;
                if (f5 <= 0.0f) {
                    this.f0 = 0.0f;
                    this.i0 = true;
                } else {
                    if (f5 <= 10.0f) {
                        f2 = f5 - 2.0f;
                    } else {
                        f2 = f5 <= 20.0f ? f5 - 2.5f : f5 - 3.0f;
                    }
                    this.f0 = f2;
                }
            }
            Matrix matrix2 = this.d0;
            float f6 = this.l0;
            float f7 = this.f0;
            matrix2.postTranslate(f6 + f7, this.m0 + f7);
            if (this.j0 > 0) {
                canvas.drawBitmap(this.c0, this.d0, null);
            } else {
                canvas.drawColor(0);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ubix.ssp.ad.b, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!a(this.I, motionEvent)) {
            return super.dispatchTouchEvent(motionEvent);
        }
        a(motionEvent);
        try {
            this.f8574a.put("__TRI_VAL__", Base64.encodeToString(((Math.round(this.k * 100.0f) / 100.0f) + "").getBytes(), 10));
        } catch (Exception unused) {
        }
        this.f8574a.put("__INSIDE_AREA__", ez.Code);
        this.f8574a.put("__CLICK_AREA__", "11");
        this.f8574a.put("__CLICK_TRIGGER__", "11");
        j jVar = this.G;
        if (jVar == null) {
            return true;
        }
        jVar.b(this.b, this, this.f8574a);
        return true;
    }

    @Override // com.ubix.ssp.ad.g.k.b
    public void e(int i) {
        j jVar = this.G;
        if (jVar != null) {
            jVar.e(i);
        }
    }

    @Override // com.ubix.ssp.ad.g.k.b
    public void f(int i) {
        j jVar = this.G;
        if (jVar != null) {
            jVar.f(i);
        }
    }

    @Override // com.ubix.ssp.ad.g.k.j
    public void g(int i) {
        j jVar = this.G;
        if (jVar != null) {
            jVar.g(i);
        }
    }

    protected int getAppInfoTop() {
        View viewFindViewById = findViewById(920101);
        if (viewFindViewById != null && viewFindViewById.getVisibility() != 8) {
            return viewFindViewById.getTop();
        }
        View viewFindViewById2 = findViewById(500100);
        return (viewFindViewById2 == null || viewFindViewById2.getVisibility() == 8) ? getBottom() - r.a(80.0f) : viewFindViewById2.getTop();
    }

    @Override // com.ubix.ssp.ad.b
    public com.ubix.ssp.ad.g.k.b getInterface() {
        return this.G;
    }

    @Override // com.ubix.ssp.ad.g.k.j
    public void h(int i) {
        com.ubix.ssp.ad.e.b0.g gVar;
        if (findViewById(900102) != null && (gVar = this.l) != null && gVar.e) {
            findViewById(900102).setVisibility(8);
        }
        if (this.E) {
            return;
        }
        this.E = true;
        j jVar = this.G;
        if (jVar != null) {
            jVar.h(i);
        }
        this.n.setBackground(com.ubix.ssp.ad.e.a0.c.a(getContext(), 1073741824, 72));
        if (this.s) {
            this.m.setVisibility(0);
        }
    }

    @Override // com.ubix.ssp.ad.g.k.b
    public void i(int i) {
        j jVar = this.G;
        if (jVar != null) {
            jVar.i(i);
        }
    }

    @Override // com.ubix.ssp.ad.b
    public void j() {
        super.j();
        try {
            try {
                com.ubix.ssp.ad.e.a0.g gVar = this.B;
                if (gVar != null) {
                    gVar.c();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            x();
            this.l.p();
            s sVar = this.f;
            if (sVar != null) {
                sVar.a();
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    @Override // com.ubix.ssp.ad.g.k.j
    public void j(int i) {
        j jVar = this.G;
        if (jVar != null) {
            jVar.j(i);
        }
    }

    @Override // com.ubix.ssp.ad.b
    protected boolean n() {
        return (this.I & 32) == 32;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        HashMap<String, String> map;
        String str;
        j jVar;
        switch (view.getId()) {
            case 500002:
                com.ubix.ssp.ad.e.b0.g gVar = this.l;
                if (gVar != null) {
                    setMute(!gVar.t);
                }
                break;
            case 500004:
                j jVar2 = this.G;
                if (jVar2 != null) {
                    jVar2.e(0);
                }
                break;
            case 500005:
                if (this.G != null) {
                    map = this.f8574a;
                    str = BaseWrapper.ENTER_ID_GAME_CENTER;
                    map.put("__CLICK_TRIGGER__", str);
                    this.f8574a.put("__CLICK_AREA__", str);
                    jVar = this.G;
                    jVar.b(this.b, view, this.f8574a);
                }
                break;
            case 910100:
            case 910601:
                if (this.G != null) {
                    map = this.f8574a;
                    str = "2";
                    map.put("__CLICK_TRIGGER__", str);
                    this.f8574a.put("__CLICK_AREA__", str);
                    jVar = this.G;
                    jVar.b(this.b, view, this.f8574a);
                }
                break;
            case 920301:
                j jVar3 = this.G;
                if (jVar3 != null) {
                    jVar3.a(this.b);
                }
                break;
            default:
                this.f8574a.put("__CLICK_TRIGGER__", "");
                jVar = this.G;
                if (jVar == null) {
                }
                jVar.b(this.b, view, this.f8574a);
                break;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        j jVar = this.G;
        if (jVar != null) {
            jVar.e(0);
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:19:0x013b. Please report as an issue. */
    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean z2;
        int i5;
        int iA;
        int appInfoTop;
        int iA2;
        int appInfoTop2;
        int i6;
        int measuredHeight;
        int iA3;
        int iA4;
        int measuredWidth;
        int iA5;
        int i7 = this.H;
        boolean z3 = i7 == 1 || i7 == 3;
        this.f8574a.put(com.hihonor.adsdk.base.g.j.e.c.hnadsb, getWidth() + "");
        this.f8574a.put(com.hihonor.adsdk.base.g.j.e.c.hnadsa, getHeight() + "");
        this.f8574a.put("__IMP_AREA__", getLeft() + "_" + getTop() + "_" + getRight() + "_" + getBottom());
        this.f8574a.put("adLeft", getLeft() + "");
        this.f8574a.put("adRight", getRight() + "");
        this.f8574a.put("adTop", getTop() + "");
        this.f8574a.put("adBottom", getBottom() + "");
        int iH = r.a().h(getContext());
        int i8 = 0;
        int top = 0;
        while (i8 < getChildCount()) {
            View childAt = getChildAt(i8);
            int id = childAt.getId();
            if (id == 500201) {
                z2 = z3;
                iH = iH;
                i8 = i8;
                i5 = top;
                childAt.layout((iH - childAt.getMeasuredWidth()) / 2, 0, (iH + childAt.getMeasuredWidth()) / 2, childAt.getMeasuredHeight());
            } else if (id != 500202) {
                float f2 = 30.0f;
                switch (id) {
                    case 500001:
                        childAt.layout(i, i2, i3, i4);
                        z2 = z3;
                        iH = iH;
                        i8 = i8;
                        i5 = top;
                        break;
                    case 500002:
                        if (this.t0) {
                            childAt.layout(r.a(10.0f) + r.b(26.0f), r.a(51.0f), r.a(38.0f) + r.b(26.0f), r.a(79.0f));
                        } else {
                            childAt.layout(r.a(10.0f), r.a(51.0f), r.a(38.0f), r.a(79.0f));
                        }
                        z2 = z3;
                        iH = iH;
                        i8 = i8;
                        i5 = top;
                        break;
                    case 500003:
                        iA = r.a(16.0f);
                        appInfoTop = getAppInfoTop() - r.a(12.0f);
                        iA2 = r.a(46.0f);
                        appInfoTop2 = getAppInfoTop();
                        childAt.layout(iA, appInfoTop, iA2, appInfoTop2);
                        z2 = z3;
                        iH = iH;
                        i8 = i8;
                        i5 = top;
                        break;
                    case 500004:
                        iA = i3 - r.a(30.0f);
                        appInfoTop = r.a(55.0f);
                        iA2 = i3 - r.a(10.0f);
                        appInfoTop2 = r.a(75.0f);
                        childAt.layout(iA, appInfoTop, iA2, appInfoTop2);
                        z2 = z3;
                        iH = iH;
                        i8 = i8;
                        i5 = top;
                        break;
                    case 500005:
                        int iA6 = i3 - (r.a(40.0f) * 2);
                        if (childAt.getMeasuredWidth() < iA6) {
                            iA6 = childAt.getMeasuredWidth();
                        }
                        childAt.layout(((i3 - r.a(10.0f)) - iA6) - this.D, r.a(51.0f), (i3 - r.a(10.0f)) - this.D, r.a(79.0f));
                        z2 = z3;
                        iH = iH;
                        i8 = i8;
                        i5 = top;
                        break;
                    case 500006:
                        View viewFindViewById = findViewById(500003);
                        childAt.layout(viewFindViewById.getRight(), viewFindViewById.getTop() + ((viewFindViewById.getHeight() - childAt.getMeasuredHeight()) / 2), viewFindViewById.getRight() + childAt.getMeasuredWidth(), viewFindViewById.getTop() + ((viewFindViewById.getHeight() + childAt.getMeasuredHeight()) / 2));
                        z2 = z3;
                        iH = iH;
                        i8 = i8;
                        i5 = top;
                        break;
                    default:
                        switch (id) {
                            case 500100:
                                z2 = z3;
                                iH = iH;
                                i8 = i8;
                                i5 = top;
                                childAt.layout(0, i4 - r.a(100.0f), i3, i4);
                                break;
                            case 900102:
                                z2 = z3;
                                iH = iH;
                                i8 = i8;
                                i5 = top;
                                try {
                                    if (this.Q != 1) {
                                        childAt.layout(i, i2, i3, i4);
                                    } else {
                                        int i9 = i3 - i;
                                        int i10 = i4 - i2;
                                        if (!e(i9, i10)) {
                                            ((com.ubix.ssp.ad.e.t.a.e) childAt).setScaleType(ImageView.ScaleType.FIT_CENTER);
                                            Rect rectD = d(i9, i10);
                                            if (rectD.width() > 0 && rectD.height() > 0 && childAt.findViewById(900102) != null) {
                                                childAt.findViewById(900102).layout(rectD.left, rectD.top, rectD.right, rectD.bottom);
                                            }
                                        }
                                    }
                                } catch (Exception e2) {
                                    e = e2;
                                    e.printStackTrace();
                                }
                                break;
                            case 910100:
                                z2 = z3;
                                int i11 = top;
                                View viewFindViewById2 = findViewById(910301);
                                top = viewFindViewById2 != null ? viewFindViewById2.getTop() : i11;
                                int i12 = i3 - i;
                                int measuredHeight2 = (i12 - childAt.getMeasuredHeight()) / 2;
                                int measuredHeight3 = top - childAt.getMeasuredHeight();
                                int iA7 = r.a(5.0f);
                                if (z2) {
                                    i6 = measuredHeight3 + iA7;
                                    measuredHeight = (i12 + childAt.getMeasuredHeight()) / 2;
                                    iA3 = r.a(5.0f) + top;
                                } else {
                                    i6 = measuredHeight3 - iA7;
                                    measuredHeight = (i12 + childAt.getMeasuredHeight()) / 2;
                                    iA3 = top - r.a(5.0f);
                                }
                                childAt.layout(measuredHeight2, i6, measuredHeight, iA3);
                                break;
                            case 910301:
                                try {
                                    double dA = r.a().a(getContext());
                                    i5 = top;
                                    double d2 = i3 - i;
                                    double d3 = 0.8d * d2;
                                    z2 = z3;
                                    try {
                                        int iMin = Math.min((int) (d3 * 0.212d), (int) (((double) r.a().c(getContext())) * (z3 ? 0.13d : 0.15d)));
                                        int i13 = (int) ((dA * 25.0d) / 2.0d);
                                        View viewFindViewById3 = findViewById(500100);
                                        int top2 = viewFindViewById3 != null ? viewFindViewById3.getTop() : 0;
                                        iH = iH;
                                        i8 = i8;
                                        double d4 = i13;
                                        int i14 = (int) ((0.1d * d2) - d4);
                                        try {
                                            int iA8 = ((top2 - iMin) - r.a(z2 ? 30.0f : 65.0f)) - i13;
                                            int i15 = (int) ((d2 * 0.9d) + d4);
                                            if (!z2) {
                                                f2 = 65.0f;
                                            }
                                            childAt.layout(i14, iA8, i15, (top2 - r.a(f2)) + i13);
                                            int i16 = i13 * 2;
                                            ((com.ubix.ssp.ad.e.c) childAt).a((int) (d3 + ((double) i16)), iMin + i16);
                                        } catch (Exception e3) {
                                            e = e3;
                                            e.printStackTrace();
                                        }
                                    } catch (Exception e4) {
                                        e = e4;
                                        iH = iH;
                                        i8 = i8;
                                    }
                                } catch (Exception e5) {
                                    e = e5;
                                    z2 = z3;
                                    iH = iH;
                                    i8 = i8;
                                    i5 = top;
                                }
                                break;
                            case 910601:
                                View viewFindViewById4 = findViewById(910301);
                                if (viewFindViewById4 != null) {
                                    top = viewFindViewById4.getTop();
                                }
                                int i17 = i3 - i;
                                int measuredWidth2 = (i17 - childAt.getMeasuredWidth()) / 2;
                                int measuredHeight4 = top - childAt.getMeasuredHeight();
                                if (z3) {
                                    iA4 = measuredHeight4 + r.a(15.0f);
                                    measuredWidth = (i17 + childAt.getMeasuredWidth()) / 2;
                                    iA5 = r.a(15.0f) + top;
                                } else {
                                    iA4 = measuredHeight4 - r.a(5.0f);
                                    measuredWidth = (i17 + childAt.getMeasuredWidth()) / 2;
                                    iA5 = top - r.a(5.0f);
                                }
                                childAt.layout(measuredWidth2, iA4, measuredWidth, iA5);
                                z2 = z3;
                                break;
                            case 920101:
                                childAt.layout(r.a(16.0f), (findViewById(500100).getTop() - childAt.getMeasuredHeight()) - r.a(3.0f), i3 - r.a(16.0f), findViewById(500100).getTop() - r.a(3.0f));
                                childAt.getLayoutParams().width = (i3 - i) - r.a(32.0f);
                                z2 = z3;
                                iH = iH;
                                i8 = i8;
                                i5 = top;
                                break;
                            case 920301:
                                iA = r.a(10.0f);
                                appInfoTop = r.a(51.0f);
                                iA2 = r.a(10.0f) + r.b(24.0f);
                                appInfoTop2 = r.a(51.0f) + r.b(13.0f);
                                childAt.layout(iA, appInfoTop, iA2, appInfoTop2);
                                z2 = z3;
                                iH = iH;
                                i8 = i8;
                                i5 = top;
                                break;
                            default:
                                z2 = z3;
                                i8 = i8;
                                i5 = top;
                                iH = iH;
                                break;
                        }
                        break;
                }
                i8++;
                iH = iH;
                z3 = z2;
            } else {
                z2 = z3;
                iH = iH;
                i8 = i8;
                i5 = top;
                View viewFindViewById5 = findViewById(500006);
                double d5 = ((double) iH) * 0.98d;
                childAt.layout((int) d5, (viewFindViewById5.getTop() - childAt.getMeasuredHeight()) - r.a(38.0f), (int) (d5 + ((double) childAt.getMeasuredWidth())), viewFindViewById5.getTop() - r.a(38.0f));
            }
            top = i5;
            i8++;
            iH = iH;
            z3 = z2;
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        try {
            this.H = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getRotation();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        try {
            j jVar = this.G;
            if (jVar != null && (jVar instanceof com.ubix.ssp.ad.g.k.h)) {
                boolean zA = ((com.ubix.ssp.ad.g.k.h) jVar).a();
                this.q0 = ((com.ubix.ssp.ad.g.k.h) this.G).c();
                int iD = ((com.ubix.ssp.ad.g.k.h) this.G).d();
                if (this.O && zA) {
                    long j = this.A;
                    a(true, iD, 100, j, j);
                }
            }
            if (z) {
                com.ubix.ssp.ad.e.a0.g gVar = this.B;
                if (gVar != null) {
                    gVar.d();
                }
            } else {
                com.ubix.ssp.ad.e.a0.g gVar2 = this.B;
                if (gVar2 != null) {
                    gVar2.c();
                }
            }
            if (z) {
                if (com.ubix.ssp.ad.d.b.E == 1 && this.d) {
                    return;
                }
                setShakeSensor(null);
                return;
            }
            s sVar = this.f;
            if (sVar != null) {
                sVar.f();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ubix.ssp.ad.b, android.view.View
    protected void onWindowVisibilityChanged(int i) {
        j jVar;
        super.onWindowVisibilityChanged(i);
        try {
            j jVar2 = this.G;
            if (jVar2 != null && (jVar2 instanceof com.ubix.ssp.ad.g.k.h)) {
                boolean zA = ((com.ubix.ssp.ad.g.k.h) jVar2).a();
                this.q0 = ((com.ubix.ssp.ad.g.k.h) this.G).c();
                int iD = ((com.ubix.ssp.ad.g.k.h) this.G).d();
                if ((this.O && zA) || this.K == 5) {
                    long j = this.A;
                    a(zA, iD, 100, j, j);
                }
            }
            if (!this.P && this.C.get() && isShown()) {
                this.C.set(false);
                j jVar3 = this.G;
                if (jVar3 != null) {
                    jVar3.a(0, this);
                }
            }
            if (i != 0) {
                s sVar = this.f;
                if (sVar != null) {
                    sVar.f();
                }
            } else if (com.ubix.ssp.ad.d.b.E != 1 || !this.d) {
                setShakeSensor(null);
            }
            if (this.P || (jVar = this.G) == null) {
                return;
            }
            jVar.b(0, i);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ubix.ssp.ad.b
    protected ViewGroup r() {
        return this;
    }

    @Override // com.ubix.ssp.ad.b
    public void setInnerListener(com.ubix.ssp.ad.g.k.b bVar) {
        this.G = bVar instanceof com.ubix.ssp.ad.g.k.h ? (com.ubix.ssp.ad.g.k.h) bVar : (j) bVar;
    }

    public void setIsDownloadAd(boolean z) {
        this.x = z;
    }

    public void setMute(boolean z) {
        this.l.setMute(z);
        if (findViewById(500002) != null) {
            ((ImageView) findViewById(500002)).setImageDrawable(q.a(z ? "ubix/ic_volume_off.webp" : "ubix/ic_volume_on.webp"));
        }
    }

    @Override // com.ubix.ssp.ad.b
    protected void setShakeSensor(View view) {
        super.setShakeSensor(view);
        if (this.f == null || !isShown()) {
            return;
        }
        this.f.a(new g(view));
    }

    public void setShowAdLogo(boolean z) {
        this.u = z;
        if (findViewById(500003) != null) {
            findViewById(500003).setVisibility(z ? 0 : 8);
        }
    }

    public void setShowBanner(boolean z) {
        this.w = z;
        if (findViewById(500100) != null) {
            findViewById(500100).setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.ubix.ssp.ad.b
    public void setShowCloseBtnDelay(int i) {
        super.setShowCloseBtnDelay(i);
        b(false);
    }

    public void setShowCountDown(boolean z) {
        this.t = z;
        if (findViewById(500005) != null) {
            findViewById(500005).setVisibility(z ? 0 : 8);
        }
    }

    public void setShowVolumeSwitch(boolean z) {
        this.s = z;
        if (findViewById(500002) != null) {
            findViewById(500002).setVisibility(z ? 0 : 8);
        }
    }

    public void setVideoDisplayType(int i) {
        com.ubix.ssp.ad.e.b0.g gVar = this.l;
        if (gVar != null) {
            gVar.setVideoImageDisplayType(i);
        }
    }

    public boolean t() {
        return this.l.t;
    }

    public void u() {
        this.l.i();
    }

    public void v() {
        this.l.j();
    }

    public void w() {
        try {
            com.ubix.ssp.ad.e.b0.g gVar = this.l;
            if (gVar != null) {
                gVar.i();
                this.l.p();
            }
        } catch (Exception unused) {
        }
    }

    public void y() {
        HandlerThread handlerThread = this.a0;
        if (handlerThread == null || handlerThread.isAlive()) {
            return;
        }
        this.c0 = q.a(getContext(), "ubix/ic_slide_hand.webp");
        this.g0 = System.currentTimeMillis();
        h hVar = new h();
        this.a0.start();
        Handler handler = new Handler(this.a0.getLooper());
        this.b0 = handler;
        handler.postDelayed(hVar, 16L);
        setWillNotDraw(false);
        View viewFindViewById = findViewById(500104);
        View viewFindViewById2 = findViewById(500100);
        if (viewFindViewById2 == null || viewFindViewById == null) {
            return;
        }
        this.l0 = viewFindViewById.getLeft() + (viewFindViewById.getWidth() / 2);
        this.m0 = viewFindViewById2.getBottom() - (viewFindViewById2.getHeight() / 2);
    }
}
