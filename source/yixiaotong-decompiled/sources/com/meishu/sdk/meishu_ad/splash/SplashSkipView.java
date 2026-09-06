package com.meishu.sdk.meishu_ad.splash;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import com.huawei.openalliance.ad.constant.ba;
import com.meishu.sdk.core.AdSdk;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.platform.ms.splash.ShakeUtil;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class SplashSkipView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Paint f5080a;
    public Paint b;
    public Paint c;
    public float d;
    public float e;
    public float f;
    public float g;
    public float h;
    public RectF i;
    public float j;
    public int k;
    public int l;
    public int m;
    public Handler n;
    public b o;
    public boolean p;
    public boolean q;
    public boolean r;
    public Runnable s;

    public class a extends com.meishu.sdk.core.safe.l {
        public a() {
        }

        @Override // com.meishu.sdk.core.safe.l
        public void safeRun() {
            SplashSkipView splashSkipView = SplashSkipView.this;
            splashSkipView.k += 100;
            splashSkipView.invalidate();
            SplashSkipView splashSkipView2 = SplashSkipView.this;
            int i = splashSkipView2.k;
            int i2 = splashSkipView2.l;
            if (i > i2) {
                splashSkipView2.a(false);
                return;
            }
            int i3 = i2 - i;
            splashSkipView2.n.postDelayed(splashSkipView2.s, 100L);
            b bVar = SplashSkipView.this.o;
            if (bVar != null) {
                bVar.onTick(i3);
            }
            SplashSkipView splashSkipView3 = SplashSkipView.this;
            if (i3 >= splashSkipView3.l - splashSkipView3.m || splashSkipView3.getVisibility() == 0) {
                return;
            }
            SplashSkipView splashSkipView4 = SplashSkipView.this;
            if (splashSkipView4.q) {
                splashSkipView4.setVisibility(0);
            }
        }
    }

    public interface b {
        void onSkip();

        void onTick(long j);

        void onTimeOver();
    }

    public SplashSkipView(Context context) {
        super(context);
        this.d = 2.2f;
        this.e = 12.1f;
        this.f = 10.0f;
        this.g = 18.0f;
        this.k = 0;
        this.l = 5000;
        this.m = 100;
        this.p = false;
        this.q = true;
        new AtomicInteger(0);
        this.s = new a();
    }

    public final void a() {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        float f = this.d;
        float f2 = displayMetrics.density;
        this.d = f * f2;
        this.e *= f2;
        this.f *= f2;
        this.g *= f2;
        Paint paint = new Paint();
        this.f5080a = paint;
        paint.setTextSize(this.e);
        this.f5080a.setColor(-1);
        this.f5080a.setAntiAlias(true);
        this.f5080a.setShadowLayer(displayMetrics.density * 3.0f, 0.0f, 0.0f, -7829368);
        Paint paint2 = new Paint();
        this.b = paint2;
        paint2.setColor(Color.parseColor("#b7ffffff"));
        this.b.setAntiAlias(true);
        this.b.setStrokeWidth(this.d);
        this.b.setStyle(Paint.Style.STROKE);
        Paint paint3 = new Paint();
        this.c = paint3;
        paint3.setColor(Color.parseColor("#42c1f0"));
        this.c.setAntiAlias(true);
        this.c.setStrokeWidth(this.d);
        this.c.setStyle(Paint.Style.STROKE);
        this.j = this.f5080a.measureText("跳过");
        this.h = this.g;
        float f3 = this.d / 2.0f;
        float f4 = 0.0f + f3 + 1.0f;
        float f5 = ((this.h * 2.0f) - f3) - 1.0f;
        this.i = new RectF(f4, f4, f5, f5);
        if (this.n != null) {
            return;
        }
        this.n = new Handler();
    }

    public void b() {
        try {
            this.n.removeCallbacks(this.s);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getShowTime() {
        return this.m;
    }

    public int getTotalTime() {
        return this.l;
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.r = true;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.r = false;
        ShakeUtil.getInstance().a();
        b();
        this.o = null;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawArc(this.i, 0.0f, 360.0f, false, this.b);
        canvas.save();
        canvas.rotate(-90.0f, getMeasuredWidth() / 2.0f, getMeasuredHeight() / 2.0f);
        int i = this.k;
        int i2 = this.m;
        canvas.drawArc(this.i, 0.0f, i > i2 ? (((i - i2) * 1.0f) / (this.l - i2)) * 360.0f : 0.0f, false, this.c);
        canvas.restore();
        Paint.FontMetrics fontMetrics = this.f5080a.getFontMetrics();
        canvas.drawText("跳过", (getMeasuredWidth() / 2) - (this.j / 2.0f), (int) ((getMeasuredHeight() / 2) - ((fontMetrics.top + fontMetrics.bottom) / 2.0f)), this.f5080a);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == Integer.MIN_VALUE) {
            size = (int) (this.h * 2.0f);
        }
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode2 == Integer.MIN_VALUE) {
            size2 = (int) (this.h * 2.0f);
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            setAlpha(0.5f);
        } else if (action == 1) {
            a(true);
        }
        return true;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.r && z && this.p && AdSdk.adConfig().splashClickPause()) {
            ShakeUtil.getInstance().a(true);
            ShakeUtil.getInstance().f();
            LogUtil.d("SplashSkipView", ba.ag);
            c();
            return;
        }
        if (this.r && !z && this.p && AdSdk.adConfig().splashClickPause()) {
            LogUtil.d("SplashSkipView", "pause");
            ShakeUtil.getInstance().e();
            b();
        }
    }

    public void setOnSkipListener(b bVar) {
        this.o = bVar;
    }

    public void setShow(boolean z) {
        this.q = z;
    }

    public void setTotalTime(int i) {
        if (i <= 0) {
            return;
        }
        this.l = i;
    }

    public void c() {
        this.p = true;
        b();
        this.n.post(this.s);
    }

    public void a(boolean z) {
        b();
        setAlpha(1.0f);
        b bVar = this.o;
        if (bVar != null) {
            if (z) {
                bVar.onSkip();
            } else {
                bVar.onTimeOver();
            }
            this.o = null;
        }
    }

    public SplashSkipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = 2.2f;
        this.e = 12.1f;
        this.f = 10.0f;
        this.g = 18.0f;
        this.k = 0;
        this.l = 5000;
        this.m = 100;
        this.p = false;
        this.q = true;
        new AtomicInteger(0);
        this.s = new a();
        a();
    }
}
