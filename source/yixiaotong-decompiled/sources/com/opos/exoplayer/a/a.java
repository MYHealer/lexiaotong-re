package com.opos.exoplayer.a;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class a extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f6223a;
    private int b;

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = 0;
    }

    public void a(float f) {
        if (this.f6223a != f) {
            this.f6223a = f;
            requestLayout();
        }
    }

    public void a(int i) {
        if (this.b != i) {
            this.b = i;
            requestLayout();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.b == 3 || this.f6223a <= 0.0f) {
            return;
        }
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        float f = measuredWidth;
        float f2 = measuredHeight;
        float f3 = (this.f6223a / (f / f2)) - 1.0f;
        if (Math.abs(f3) <= 0.01f) {
            return;
        }
        int i3 = this.b;
        if (i3 == 1 || (i3 != 2 && (i3 == 4 ? f3 <= 0.0f : f3 > 0.0f))) {
            measuredHeight = (int) (f / this.f6223a);
        } else {
            measuredWidth = (int) (f2 * this.f6223a);
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824));
    }
}
