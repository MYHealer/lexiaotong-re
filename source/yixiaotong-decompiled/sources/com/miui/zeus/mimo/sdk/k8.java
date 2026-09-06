package com.miui.zeus.mimo.sdk;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.google.common.base.Ascii;
import com.miui.zeus.mimo.sdk.bean.MimoAdInfo;
import com.miui.zeus.mimo.sdk.click.ClickAreaType;
import com.miui.zeus.mimo.sdk.k8;
import com.miui.zeus.mimo.sdk.view.component.ImageICP;
import okio.Utf8;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class k8 extends RelativeLayout implements h8 {
    public static final /* synthetic */ int k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ViewGroup f5511a;
    public ViewGroup b;
    public TextView c;
    public ObjectAnimator d;
    public q5 e;
    public MimoAdInfo f;
    public i8 g;
    public l6 h;
    public boolean i;
    public ImageICP j;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            k8 k8Var = k8.this;
            i8 i8Var = k8Var.g;
            if (i8Var != null) {
                i8Var.onClick(view, k8Var.getClickAreaType());
            }
        }
    }

    public class b implements q5.b {
        public b() {
        }
    }

    public k8(Context context, AttributeSet attributeSet) {
        this(context, null, 0);
    }

    public k8(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.i = false;
        b();
    }

    public void a() {
        this.i = false;
        this.h = null;
        ViewGroup viewGroup = this.b;
        if (viewGroup != null) {
            viewGroup.clearAnimation();
        }
        ObjectAnimator objectAnimator = this.d;
        if (objectAnimator != null) {
            objectAnimator.cancel();
            this.d = null;
        }
        q5 q5Var = this.e;
        if (q5Var != null) {
            q5Var.b();
            this.e = null;
        }
    }

    public void a(MimoAdInfo mimoAdInfo, i8 i8Var) {
        this.g = i8Var;
        this.f = mimoAdInfo;
        this.c.setText((!mimoAdInfo.t() || w6.a(getContext(), mimoAdInfo)) ? ijiami_1011.s.s.s.d(new byte[]{-37, -47, -124, -34, -36, -101, -122, -56, -54, -122, -119, -20, -43, -16, -114, 119, 49, 103}, "3f76a7") : ijiami_1011.s.s.s.d(new byte[]{-125, -109, -68, -125, -66, -125, -123, -36, -19, -118, -116, -40, 37, 104, 103}, "d87f30"));
    }

    public final void b() {
        View.inflate(getContext(), a0.e4, this);
        this.c = (TextView) findViewById(a0.D1);
        this.b = (ViewGroup) findViewById(a0.X2);
        ViewGroup viewGroup = (ViewGroup) findViewById(a0.W4);
        this.f5511a = viewGroup;
        viewGroup.setOnClickListener(new a());
        this.j = (ImageICP) findViewById(a0.k);
    }

    public void c() {
        long j;
        int i;
        int i2;
        int i3;
        MimoAdInfo mimoAdInfo;
        String str;
        ViewGroup viewGroup = this.b;
        if (viewGroup != null) {
            viewGroup.setVisibility(4);
        }
        ImageICP imageICP = this.j;
        if (imageICP == null || (mimoAdInfo = this.f) == null || (str = mimoAdInfo.n1) == null) {
            d();
        } else {
            imageICP.a(str, (i8) null, new RequestListener<Drawable>() { // from class: com.miui.zeus.mimo.sdk.view.component.MimoShakeView$2
                @Override // com.bumptech.glide.request.RequestListener
                public boolean onLoadFailed(GlideException glideException, Object obj, Target<Drawable> target, boolean z) {
                    k8 k8Var = this.this$0;
                    int i4 = k8.k;
                    k8Var.d();
                    return false;
                }

                @Override // com.bumptech.glide.request.RequestListener
                public boolean onResourceReady(Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z) {
                    return false;
                }
            });
        }
        q5 q5Var = this.e;
        if (q5Var != null) {
            q5Var.b();
            this.e = null;
        }
        MimoAdInfo mimoAdInfo2 = this.f;
        if (mimoAdInfo2 != null) {
            i2 = mimoAdInfo2.Y0;
            i3 = mimoAdInfo2.X0;
            j = ((long) mimoAdInfo2.Z0) * 1000;
            i = mimoAdInfo2.o1;
        } else {
            j = 0;
            i = 3;
            i2 = 0;
            i3 = 0;
        }
        q5 q5Var2 = new q5();
        this.e = q5Var2;
        b bVar = new b();
        HandlerThread handlerThread = new HandlerThread(ijiami_1011.s.s.s.d(new byte[]{99, 1, 95, 68, 90, Ascii.ETB, 53, 12, Ascii.DC4, 7, 80, 1}, "0d175e"));
        q5Var2.M = handlerThread;
        handlerThread.start();
        q5Var2.N = new Handler(q5Var2.M.getLooper());
        SensorManager sensorManager = (SensorManager) y8.f5752a.getSystemService(ijiami_1011.s.s.s.d(new byte[]{68, 92, 11, 74, 11, 19}, "79e9da"));
        q5Var2.f = sensorManager;
        if (sensorManager != null) {
            q5Var2.g = sensorManager.getDefaultSensor(1);
            Sensor defaultSensor = q5Var2.f.getDefaultSensor(11);
            q5Var2.m = defaultSensor;
            if (q5Var2.g != null && defaultSensor != null) {
                q5Var2.f.registerListener(q5Var2, defaultSensor, 0, q5Var2.N);
                q5Var2.f.registerListener(q5Var2, q5Var2.g, 3, q5Var2.N);
                q5Var2.e = bVar;
                q5Var2.h = i2;
                q5Var2.t = i3;
                q5Var2.i = j;
                q5Var2.L = i;
            }
        } else {
            q5Var2.e = bVar;
            q5Var2.h = i2;
            q5Var2.t = i3;
            q5Var2.i = j;
            q5Var2.L = i;
        }
        setVisibility(0);
        this.i = true;
    }

    public final void d() {
        this.b.setVisibility(0);
        ObjectAnimator objectAnimator = this.d;
        if (objectAnimator != null) {
            objectAnimator.cancel();
            this.d = null;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.b, ijiami_1011.s.s.s.d(new byte[]{71, 89, 69, 7, 16, 13, 14, 10, Utf8.REPLACEMENT_BYTE}, "561fdd"), 30.0f, -30.0f);
        this.d = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setDuration(500L);
        this.d.setRepeatMode(2);
        this.d.setRepeatCount(-1);
        this.d.start();
    }

    public ClickAreaType getClickAreaType() {
        return ClickAreaType.TYPE_NATIVE_SHAKE;
    }

    public l6 getExtShakeInfo() {
        return this.h;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a();
    }
}
