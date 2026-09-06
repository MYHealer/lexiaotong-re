package com.miui.zeus.mimo.sdk.view.wave;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.google.android.exoplayer2.C;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.miui.zeus.mimo.sdk.a0;
import com.miui.zeus.mimo.sdk.click.ClickAreaType;
import com.miui.zeus.mimo.sdk.f9;
import com.miui.zeus.mimo.sdk.h8;
import ijiami_1011.s.s.s;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class WaveView extends View implements h8 {
    public ObjectAnimator A;
    public ObjectAnimator B;
    public ValueAnimator C;
    public float D;
    public float E;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f5720a;
    public float b;
    public float c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public final Paint p;
    public final Paint q;
    public final Paint r;
    public final Paint s;
    public final Path t;
    public final Path u;
    public final Path v;
    public float w;
    public float x;
    public float y;
    public ObjectAnimator z;

    public WaveView(Context context) {
        this(context, null);
    }

    public WaveView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WaveView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5720a = 40.0f;
        this.b = 60.0f;
        this.c = 60.0f;
        this.d = Color.parseColor(s.d(new byte[]{17, 6, 0, 10, 8, 36, 89}, "26021a"));
        this.e = Color.parseColor(s.d(new byte[]{66, 87, 83, 113, 88, 39, 37}, "abd3aa"));
        this.f = Color.parseColor(s.d(new byte[]{Ascii.ETB, 118, 1, 38, 82, 39, 34}, "449cba"));
        this.g = 1;
        this.p = new Paint();
        this.q = new Paint();
        this.r = new Paint();
        this.s = new Paint();
        this.t = new Path();
        this.u = new Path();
        this.v = new Path();
        this.w = -1600;
        this.x = -1800;
        this.y = AVMDLDataLoader.AVMDLErrorIsInvalidContentLenth + (2000 / 4.0f);
        this.D = 3.0f;
        this.E = 0.0f;
        a(context, attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(ValueAnimator valueAnimator) {
        this.E = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate();
    }

    private int getMaxHalfWaveHeight() {
        return Math.max(Math.max(((int) this.f5720a) / 2, ((int) this.b) / 2), (((int) this.c) / 2) + 20);
    }

    private int getMaxWaveHeight() {
        int iMax = Math.max(((int) this.f5720a) / 2, ((int) this.b) / 2);
        return Math.max(iMax, (((int) this.c) / 2) + 20) + iMax;
    }

    private int getMinWaveHeight() {
        return getMaxWaveHeight() + getRotateOffsetValue();
    }

    private int getRotateOffsetValue() {
        float f = this.D;
        if (f == 0.0f) {
            return 0;
        }
        return (int) ((((double) this.h) * Math.tan(Math.toRadians(f + 2.0f))) / 2.0d);
    }

    public final void a() {
        this.p.setColor(this.d);
        this.p.setStrokeWidth(3.0f);
        this.p.setAntiAlias(true);
        this.p.setStyle(Paint.Style.FILL_AND_STROKE);
        this.q.setColor(this.e);
        this.q.setStrokeWidth(3.0f);
        this.q.setAntiAlias(true);
        this.q.setStyle(Paint.Style.FILL_AND_STROKE);
        this.r.setColor(this.f);
        this.r.setStrokeWidth(3.0f);
        this.r.setAntiAlias(true);
        this.r.setStyle(Paint.Style.FILL_AND_STROKE);
        this.s.setAntiAlias(true);
        this.s.setColor(Color.parseColor(s.d(new byte[]{Ascii.ETB, 112, 92, 8, 82, 8, 81}, "42d8b8")));
        this.s.setStyle(Paint.Style.STROKE);
        this.s.setStrokeWidth(3.0f);
    }

    public final void a(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a0.c);
        this.d = typedArrayObtainStyledAttributes.getColor(a0.d2, this.d);
        this.e = typedArrayObtainStyledAttributes.getColor(a0.P3, this.e);
        this.f = typedArrayObtainStyledAttributes.getColor(a0.u1, this.f);
        this.g = typedArrayObtainStyledAttributes.getInt(a0.D2, 0);
        typedArrayObtainStyledAttributes.recycle();
        int i = f9.f5428a;
        this.f5720a = Math.round(context.getResources().getDisplayMetrics().density * 14.5f);
        this.b = Math.round(context.getResources().getDisplayMetrics().density * 21.8f);
        this.c = Math.round(context.getResources().getDisplayMetrics().density * 21.8f);
        a();
    }

    public final void b() {
        c();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, s.d(new byte[]{85, SignedBytes.MAX_POWER_OF_TWO, 86, 94, 71, 96, 0, Ascii.DC2, 3, 45, 87, 3, SignedBytes.MAX_POWER_OF_TWO, 87, 77}, "329037"), 0.0f, 1600);
        this.z = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setDuration(2500L);
        this.z.setRepeatCount(-1);
        this.z.setInterpolator(new LinearInterpolator());
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this, s.d(new byte[]{89, 92, 6, 1, 90, 3, 54, 5, 16, 7, 126, 3, 82, 70, 7, 17}, "45be6f"), 0.0f, 1800);
        this.A = objectAnimatorOfFloat2;
        objectAnimatorOfFloat2.setDuration(2750L);
        this.A.setRepeatCount(-1);
        this.A.setInterpolator(new LinearInterpolator());
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this, s.d(new byte[]{83, 81, 2, 8, 50, 87, Ascii.ETB, 1, 41, 4, 87, Ascii.SYN, 84, 68}, "10ace6"), 0.0f, 2000);
        this.B = objectAnimatorOfFloat3;
        objectAnimatorOfFloat3.setDuration(C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
        this.B.setRepeatCount(-1);
        this.B.setInterpolator(new LinearInterpolator());
        float f = this.D;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(-f, 0.0f, f);
        this.C = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(2500L);
        this.C.setRepeatCount(-1);
        this.C.setRepeatMode(2);
        this.C.setInterpolator(new AccelerateDecelerateInterpolator());
        this.C.addUpdateListener(WaveView$$Lambda$1.lambdaFactory$(this));
        setLayerType(1, null);
        this.z.start();
        this.A.start();
        this.B.start();
        this.C.start();
    }

    public final void c() {
        ObjectAnimator objectAnimator = this.z;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        ObjectAnimator objectAnimator2 = this.A;
        if (objectAnimator2 != null) {
            objectAnimator2.cancel();
        }
        ObjectAnimator objectAnimator3 = this.B;
        if (objectAnimator3 != null) {
            objectAnimator3.cancel();
        }
        ValueAnimator valueAnimator = this.C;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    public ClickAreaType getClickAreaType() {
        return ClickAreaType.TYPE_OTHER;
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        b();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.rotate(this.E, getWidth() / 2.0f, 0.0f);
        this.v.reset();
        this.v.moveTo(this.o + this.y, this.n - 20);
        int i = 0;
        int i2 = 0;
        while (i2 <= this.h + 2000) {
            float f = 2000;
            float f2 = f / 4.0f;
            float f3 = f / 2.0f;
            this.v.rQuadTo(f2, -this.c, f3, 0.0f);
            this.v.rQuadTo(f2, this.c, f3, 0.0f);
            i2 += 2000;
        }
        this.v.lineTo(this.o + (i2 * 2000), this.i);
        this.v.lineTo(this.o, this.i);
        this.v.close();
        canvas.drawPath(this.v, this.r);
        canvas.restore();
        canvas.save();
        canvas.rotate(this.E + 1.0f, getWidth() / 2.0f, 0.0f);
        this.u.reset();
        this.u.moveTo(this.m + this.x, this.l);
        int i3 = 0;
        while (i3 <= this.h + 1800) {
            float f4 = 1800;
            float f5 = f4 / 4.0f;
            float f6 = f4 / 2.0f;
            this.u.rQuadTo(f5, -this.b, f6, 0.0f);
            this.u.rQuadTo(f5, this.b, f6, 0.0f);
            i3 += 1800;
        }
        this.u.lineTo(this.m + (i3 * 1800), this.i);
        this.u.lineTo(this.m, this.i);
        this.u.close();
        canvas.drawPath(this.u, this.q);
        canvas.restore();
        canvas.save();
        canvas.rotate(this.E + 2.0f, getWidth() / 2.0f, 0.0f);
        this.t.reset();
        this.t.moveTo(this.k + this.w, this.j);
        while (i <= this.h + 1600) {
            float f7 = 1600;
            float f8 = f7 / 4.0f;
            float f9 = f7 / 2.0f;
            this.t.rQuadTo(f8, this.f5720a, f9, 0.0f);
            this.t.rQuadTo(f8, -this.f5720a, f9, 0.0f);
            i += 1600;
        }
        this.t.lineTo(this.k + (i * 1600), this.i + getRotateOffsetValue() + getMaxHalfWaveHeight());
        this.t.lineTo(this.k, this.i + getRotateOffsetValue() + getMaxHalfWaveHeight());
        this.t.close();
        canvas.drawPath(this.t, this.p);
        canvas.restore();
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.h = i;
        this.i = i2;
        if (i > 1200) {
            this.D = 0.12f;
        }
        int maxHalfWaveHeight = i2 / 2;
        int i5 = this.g;
        if (i5 == 0) {
            maxHalfWaveHeight = getMaxHalfWaveHeight() + getRotateOffsetValue();
        } else if (i5 != 1 && i5 == 2) {
            maxHalfWaveHeight = (i2 - getMaxHalfWaveHeight()) - getRotateOffsetValue();
        }
        this.k = -1600;
        this.j = maxHalfWaveHeight;
        this.m = -1800;
        this.l = maxHalfWaveHeight;
        this.o = AVMDLDataLoader.AVMDLErrorIsInvalidContentLenth;
        this.n = maxHalfWaveHeight;
    }

    public void setBackWaveOffset(float f) {
        this.y = f;
        invalidate();
    }

    public void setFrontWaveOffset(float f) {
        this.w = f;
        invalidate();
    }

    public void setMiddleWaveOffset(float f) {
        this.x = f;
        invalidate();
    }

    public void setWavePositionLevel(int i) {
        this.g = i;
        requestLayout();
    }

    public void setWaveRotation(float f) {
        this.D = f;
        requestLayout();
    }
}
