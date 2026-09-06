package com.ubix.ssp.ad.e.b0.j;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import com.ubix.ssp.ad.e.a0.u;
import com.ubix.ssp.ad.e.b0.e;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a extends SurfaceView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f8804a;
    public int b;

    public a(Context context) {
        super(context);
        this.f8804a = 0;
        this.b = 0;
        getHolder().setFormat(-3);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8804a = 0;
        this.b = 0;
        getHolder().setFormat(-3);
    }

    public void a(int i, int i2) {
        try {
            if (this.f8804a == i && this.b == i2) {
                return;
            }
            this.f8804a = i;
            this.b = i2;
            getHolder().setFixedSize(i, i2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = this.f8804a;
        int i4 = this.b;
        u.e("parentWidth width=" + ((View) getParent().getParent()).getMeasuredWidth() + ";height=" + ((View) getParent().getParent()).getMeasuredHeight());
        int defaultSize = SurfaceView.getDefaultSize(i3, i);
        int defaultSize2 = SurfaceView.getDefaultSize(i4, i2);
        u.e("width=" + defaultSize + ";height=" + defaultSize2);
        if (i3 * i4 == 0) {
            return;
        }
        int i5 = e.b;
        if (i5 == 1) {
            setMeasuredDimension(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2) - 3);
            return;
        }
        if (i5 == 4) {
            float f = defaultSize / defaultSize2;
            float f2 = i3 / i4;
            u.e("videoDelta =" + f2 + "；" + f);
            if (f2 < f) {
                defaultSize = ((i3 * defaultSize2) / i4) + 1;
            } else {
                defaultSize2 = (i4 * defaultSize) / i3;
            }
        }
        u.e("targetWidth=" + defaultSize + ";targetHeight=" + defaultSize2);
        setMeasuredDimension(defaultSize, defaultSize2);
    }

    @Override // android.view.View
    public void setRotation(float f) {
        if (f != getRotation()) {
            super.setRotation(f);
            requestLayout();
        }
    }

    public void setSurfaceViewCallback(SurfaceHolder.Callback callback) {
        getHolder().addCallback(callback);
    }
}
