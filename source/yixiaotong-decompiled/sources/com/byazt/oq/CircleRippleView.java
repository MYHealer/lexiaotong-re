package com.byazt.oq;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 269, 1558})
public class CircleRippleView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2579a;
    public int c;
    public Paint da;
    public List<Integer> i;
    public float n;
    public Paint sl;
    public boolean sp;
    public float t;
    public int tt;
    public float u;
    public int uj;
    public float ve;
    public List<Integer> x;
    public int yp;

    public void setColor(int i) {
        this.c = i;
    }

    public void setCoreColor(int i) {
        this.tt = i;
    }

    public void setCoreRadius(int i) {
        this.ve = i;
    }

    public void setDiffuseSpeed(int i) {
        this.f2579a = i;
    }

    public void setDiffuseWidth(int i) {
        this.uj = i;
    }

    public void setMaxWidth(int i) {
        this.n = i;
    }

    public CircleRippleView(Context context) {
        this(context, null);
    }

    public CircleRippleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public CircleRippleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = -1;
        this.tt = SupportMenu.CATEGORY_MASK;
        this.ve = 18.0f;
        this.uj = 3;
        this.n = 50.0f;
        this.f2579a = 2;
        this.sp = false;
        this.x = new ArrayList();
        this.i = new ArrayList();
        this.yp = 24;
        ve();
    }

    private void ve() {
        Paint paint = new Paint();
        this.da = paint;
        paint.setAntiAlias(true);
        this.da.setStrokeWidth(this.yp);
        this.x.add(255);
        this.i.add(0);
        Paint paint2 = new Paint();
        this.sl = paint2;
        paint2.setAntiAlias(true);
        this.sl.setColor(Color.parseColor("#0FFFFFFF"));
        this.sl.setStyle(Paint.Style.FILL);
    }

    @Override // android.view.View
    public void invalidate() {
        if (hasWindowFocus()) {
            super.invalidate();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            invalidate();
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        float f = i / 2.0f;
        this.t = f;
        this.u = i2 / 2.0f;
        float f2 = f - (this.yp / 2.0f);
        this.n = f2;
        this.ve = f2 / 4.0f;
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        setMeasuredDimension(Math.min(size, size2), Math.min(size, size2));
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        this.da.setShader(new LinearGradient(this.t, 0.0f, this.u, getMeasuredHeight(), -1, ViewCompat.MEASURED_SIZE_MASK, Shader.TileMode.CLAMP));
        int i = 0;
        while (true) {
            if (i >= this.x.size()) {
                break;
            }
            Integer num = this.x.get(i);
            this.da.setAlpha(num.intValue());
            Integer num2 = this.i.get(i);
            if (this.ve + num2.intValue() < this.n) {
                canvas.drawCircle(this.t, this.u, this.ve + num2.intValue(), this.da);
            }
            if (num.intValue() > 0 && num2.intValue() < this.n) {
                this.x.set(i, Integer.valueOf(num.intValue() - this.f2579a > 0 ? num.intValue() - (this.f2579a * 3) : 1));
                this.i.set(i, Integer.valueOf(num2.intValue() + this.f2579a));
            }
            i++;
        }
        List<Integer> list = this.i;
        if (list.get(list.size() - 1).intValue() >= this.n / this.uj) {
            this.x.add(255);
            this.i.add(0);
        }
        if (this.i.size() >= 3) {
            this.i.remove(0);
            this.x.remove(0);
        }
        this.da.setAlpha(255);
        this.da.setColor(this.tt);
        canvas.drawCircle(this.t, this.u, this.ve, this.sl);
        if (this.sp) {
            invalidate();
        }
    }

    public void c() {
        this.sp = true;
        invalidate();
    }

    public void tt() {
        this.sp = false;
        this.i.clear();
        this.x.clear();
        this.x.add(255);
        this.i.add(0);
        invalidate();
    }
}
