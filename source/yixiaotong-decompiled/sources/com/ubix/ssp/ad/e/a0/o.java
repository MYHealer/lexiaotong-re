package com.ubix.ssp.ad.e.a0;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class o extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    com.ubix.ssp.ad.e.a f8716a;
    private f b;
    private boolean c;
    private s d;
    private float e;
    private float f;
    private int g;
    private int h;
    private int i;
    private boolean j;
    private boolean k;
    private AtomicBoolean l;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            o oVar = o.this;
            oVar.measure(oVar.h, o.this.i);
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            o.this.setShakeSensor(null);
            o.this.requestLayout();
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            o.this.b();
        }
    }

    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                o oVar = o.this;
                oVar.setShakeSensor(oVar.findViewById(910101));
            } catch (Exception unused) {
            }
        }
    }

    class e implements s.e {
        e() {
        }

        @Override // com.ubix.ssp.ad.e.a0.s.e
        public void a(float f, float f2) {
            try {
                if (!o.this.isShown() || com.ubix.ssp.ad.e.a0.y.c.a(o.this.findViewById(910100), 0.75f, false, (List<Integer>) null) || com.ubix.ssp.ad.e.a0.y.c.a(o.this)) {
                    return;
                }
                o.this.b();
                if (o.this.b != null) {
                    o.this.b.a(f, f2);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // com.ubix.ssp.ad.e.a0.s.e
        public void a(Bundle bundle) {
            if (!o.this.isShown() || com.ubix.ssp.ad.e.a0.y.c.a(o.this.findViewById(910100), 0.75f, false, (List<Integer>) null) || com.ubix.ssp.ad.e.a0.y.c.a(o.this) || o.this.b == null) {
                return;
            }
            o.this.b.a(bundle);
        }
    }

    public interface f {
        void a(float f, float f2);

        void a(Bundle bundle);

        boolean a();
    }

    public o(Context context, String str, String str2, int i, int i2, int i3, boolean z) {
        com.ubix.ssp.ad.e.a aVar;
        int i4;
        super(context);
        this.f8716a = null;
        this.c = false;
        this.j = false;
        this.k = false;
        this.l = new AtomicBoolean(false);
        setId(910100);
        this.e = i / 100.0f;
        this.f = i2 / 100.0f;
        this.g = Math.max(i3, 40);
        this.k = z;
        this.f8716a = (str == null && str2 == null) ? new com.ubix.ssp.ad.e.a(getContext(), 0, 0, true, false, null, null) : new com.ubix.ssp.ad.e.a(getContext(), 0, 0, true, true, str, str2);
        this.f8716a.setId(910104);
        if (this.k) {
            aVar = this.f8716a;
            i4 = 4;
        } else {
            aVar = this.f8716a;
            i4 = 8;
        }
        aVar.setVisibility(i4);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        addView(this.f8716a, layoutParams);
        setBackgroundColor(0);
        this.g = (int) (this.g * r.a().a(context));
    }

    public void a() {
        this.j = true;
        setVisibility(8);
    }

    public void a(int i, double d2, int[] iArr, int i2, int i3, double d3, boolean z, boolean z2) {
        try {
            this.d = i == 1 ? new s(getContext(), d2, iArr, i3, d3, z, z2) : new s(getContext(), d2, iArr[0], d3);
            postDelayed(new d(), 0L);
            this.d.a((ImageView) findViewById(910101));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    protected void b() {
        try {
            f fVar = this.b;
            if (fVar != null && fVar.a() && this.d != null) {
                setVisibility(8);
            }
            s sVar = this.d;
            if (sVar != null) {
                sVar.f();
            }
            AtomicBoolean atomicBoolean = this.l;
            if (atomicBoolean != null) {
                atomicBoolean.set(false);
            }
            s sVar2 = this.d;
            if (sVar2 != null) {
                sVar2.a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        post(new b());
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        setVisibility(8);
        post(new a());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        post(new c());
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        View viewFindViewById = findViewById(910104);
        if (viewFindViewById != null) {
            float f2 = i3 - i;
            int measuredWidth = (int) ((this.e * f2) - (viewFindViewById.getMeasuredWidth() / 2));
            int measuredWidth2 = (int) ((f2 * this.e) + (viewFindViewById.getMeasuredWidth() / 2));
            float f3 = (i4 - i2) * this.f;
            float f4 = this.g / 2;
            viewFindViewById.layout(measuredWidth, (int) (f3 - f4), measuredWidth2, (int) (f3 + f4));
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        f fVar;
        try {
            super.onMeasure(i, i2);
            this.h = i;
            this.i = i2;
            int height = (((ViewGroup) getParent()).getHeight() - ((ViewGroup) getParent()).getPaddingTop()) - ((ViewGroup) getParent()).getPaddingBottom();
            if (height < 0) {
                height = ((ViewGroup) getParent()).getHeight();
            }
            int width = (((ViewGroup) getParent()).getWidth() - ((ViewGroup) getParent()).getPaddingLeft()) - ((ViewGroup) getParent()).getPaddingRight();
            this.f8716a.a(width, this.g);
            setMeasuredDimension(width, height);
            if (getVisibility() != 8 || this.j || (fVar = this.b) == null || fVar.a()) {
                return;
            }
            setVisibility(0);
        } catch (Throwable th) {
            th.printStackTrace();
            setMeasuredDimension(i, i2);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        f fVar;
        super.onWindowFocusChanged(z);
        if (!z || (fVar = this.b) == null || !fVar.a() || this.d == null) {
            return;
        }
        setVisibility(8);
        b();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            setShakeSensor(findViewById(910101));
        } else {
            b();
        }
    }

    public void setCallback(f fVar) {
        this.b = fVar;
        if (this.k || this.j || fVar == null || fVar.a()) {
            return;
        }
        this.f8716a.setVisibility(0);
    }

    protected void setShakeSensor(View view) {
        f fVar = this.b;
        if (fVar != null && fVar.a() && this.d != null) {
            setVisibility(8);
            return;
        }
        synchronized (this) {
            if (this.d != null && !this.l.get() && !this.c) {
                setVisibility(0);
                this.l.set(true);
                this.d.a(new e());
            }
        }
    }
}
