package com.fancy.mpsdk.component.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public class AdvertRatioLayout extends FrameLayout {
    public float _a;
    public float _b;
    public int _c;
    public float _d;
    public int _e;
    public int _f;
    public _a _g;

    public interface _a {
        void _a(int i, int i2);
    }

    public AdvertRatioLayout(Context context) {
        this(context, null, 0);
        _a();
    }

    public AdvertRatioLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        _a();
    }

    public AdvertRatioLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this._a = -1.0f;
        this._b = -1.0f;
        this._c = 0;
        _a();
    }

    public final void _a() {
        this._c = 1;
        this._d = 0.55f;
    }

    public float getMaxHeight() {
        return this._a;
    }

    public float getMaxWidth() {
        return this._b;
    }

    public float getRatio() {
        return this._d;
    }

    public int getRatioStandard() {
        return this._c;
    }

    public void setMaxHeight(float f) {
        this._a = f;
    }

    public void setMaxWidth(float f) {
        this._b = f;
    }

    public void setRatio(float f) {
        this._d = f;
    }

    public void setRatioStandard(int i) {
        this._c = i;
    }

    public void setSizeCallback(_a _aVar) {
        this._g = _aVar;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        int i3;
        _a _aVar;
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i);
        int size2 = View.MeasureSpec.getSize(i);
        if (this._d == 0.0f && (mode == 0 || mode == Integer.MIN_VALUE)) {
            this._d = 0.55f;
        }
        float f = this._d;
        if (f <= 0.0f || !((i3 = this._c) == 1 || i3 == 2)) {
            super.onMeasure(i, i2);
            return;
        }
        if (i3 == 1) {
            float f2 = this._b;
            if (f2 > -1.0f && size2 > f2) {
                size2 = (int) f2;
            }
            if (f >= 0.0f) {
                size = (int) (size2 * f);
            }
            float f3 = this._a;
            if (f3 > -1.0f && size > f3) {
                size = (int) f3;
            }
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(size2, mode2), View.MeasureSpec.makeMeasureSpec(size, 1073741824));
        } else if (i3 == 2) {
            float f4 = this._a;
            if (f4 > -1.0f && size > f4) {
                size = (int) f4;
            }
            if (f >= 0.0f) {
                size2 = (int) (size * f);
            }
            float f5 = this._b;
            if (f5 > -1.0f && size2 > f5) {
                size2 = (int) f5;
            }
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(size2, 1073741824), View.MeasureSpec.makeMeasureSpec(size, mode));
        } else {
            float f6 = this._b;
            if (f6 > -1.0f && size2 > f6) {
                size2 = (int) f6;
            }
            float f7 = this._a;
            if (f7 > -1.0f && size > f7) {
                size = (int) f7;
            }
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(size2, mode2), View.MeasureSpec.makeMeasureSpec(size, mode));
        }
        if ((this._e != size2 || this._f != size) && (_aVar = this._g) != null) {
            _aVar._a(size2, size);
        }
        this._e = size2;
        this._f = size;
    }
}
