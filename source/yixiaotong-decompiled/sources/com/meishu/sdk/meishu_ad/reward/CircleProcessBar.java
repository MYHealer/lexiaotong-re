package com.meishu.sdk.meishu_ad.reward;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import androidx.room.RoomDatabase;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class CircleProcessBar extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Paint f5064a;
    public Paint b;
    public Paint c;
    public float d;
    public float e;
    public float f;
    public float g;
    public float h;
    public RectF i;
    public int j;
    public int k;
    public a l;

    public interface a {
        void onSkip();
    }

    public CircleProcessBar(Context context) {
        super(context);
        this.d = 2.2f;
        this.e = 12.1f;
        this.f = 10.0f;
        this.g = 15.5f;
        this.j = 0;
        this.k = 5000;
        a();
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
        this.f5064a = paint;
        paint.setTextSize(this.e);
        this.f5064a.setColor(-1);
        this.f5064a.setAntiAlias(true);
        this.f5064a.setShadowLayer(displayMetrics.density * 3.0f, 0.0f, 0.0f, -7829368);
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
        this.f5064a.measureText("999");
        this.h = this.g;
        float f3 = this.d / 2.0f;
        float f4 = 0.0f + f3 + 1.0f;
        float f5 = ((this.h * 2.0f) - f3) - 1.0f;
        this.i = new RectF(f4, f4, f5, f5);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawArc(this.i, 0.0f, 360.0f, false, this.b);
        canvas.save();
        canvas.rotate(-90.0f, getMeasuredWidth() / 2.0f, getMeasuredHeight() / 2.0f);
        canvas.drawArc(this.i, 0.0f, ((this.j * 1.0f) / this.k) * 360.0f, false, this.c);
        canvas.restore();
        Paint.FontMetrics fontMetrics = this.f5064a.getFontMetrics();
        int measuredHeight = (int) ((getMeasuredHeight() / 2) - ((fontMetrics.top + fontMetrics.bottom) / 2.0f));
        int iMax = Math.max(0, ((this.k - this.j) + RoomDatabase.MAX_BIND_PARAMETER_CNT) / 1000);
        if (iMax != 0) {
            canvas.drawText("" + iMax, (getMeasuredWidth() / 2) - (this.f5064a.measureText(iMax + "") / 2.0f), measuredHeight, this.f5064a);
            return;
        }
        setVisibility(8);
        a aVar = this.l;
        if (aVar != null) {
            aVar.onSkip();
        }
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
            setAlpha(1.0f);
        }
        return true;
    }

    public void setOnSkipListener(a aVar) {
        this.l = aVar;
    }

    public void setmTotalTime(int i) {
        this.k = i;
    }

    public synchronized void a(int i) {
        a aVar;
        this.j = i;
        invalidate();
        if (this.j >= this.k && (aVar = this.l) != null) {
            aVar.onSkip();
        }
    }

    public CircleProcessBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = 2.2f;
        this.e = 12.1f;
        this.f = 10.0f;
        this.g = 15.5f;
        this.j = 0;
        this.k = 5000;
        a();
    }

    public CircleProcessBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = 2.2f;
        this.e = 12.1f;
        this.f = 10.0f;
        this.g = 15.5f;
        this.j = 0;
        this.k = 5000;
        a();
    }
}
