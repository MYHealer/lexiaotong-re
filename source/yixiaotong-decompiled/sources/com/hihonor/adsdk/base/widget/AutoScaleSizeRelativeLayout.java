package com.hihonor.adsdk.base.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.hihonor.adsdk.base.R;
import com.hihonor.adsdk.common.f.j;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class AutoScaleSizeRelativeLayout extends RelativeLayout {
    private float mRatio;
    private final RectF mRectF;
    private float mRoundCorner;
    private Path mRoundCornerPath;
    private boolean mUseRatioInMatchParentMode;

    public AutoScaleSizeRelativeLayout(Context context) {
        this(context, null);
    }

    private void addRoundRect() {
        this.mRoundCornerPath.reset();
        Path path = this.mRoundCornerPath;
        RectF rectF = this.mRectF;
        float f = this.mRoundCorner;
        path.addRoundRect(rectF, f, f, Path.Direction.CW);
    }

    private int getRatioHeight(int i, float f) {
        if (f <= 0.0f) {
            return 0;
        }
        return (int) (i / f);
    }

    private int getRatioSize(int i, float f) {
        return (int) (f * i);
    }

    private void init(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes;
        if (attributeSet != null && (typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AutoScaleSizeRelativeLayout)) != null) {
            try {
                this.mRoundCorner = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.AutoScaleSizeRelativeLayout_hiad_roundCorner, 0);
                typedArrayObtainStyledAttributes.recycle();
            } catch (Throwable th) {
                typedArrayObtainStyledAttributes.recycle();
                throw th;
            }
        }
        setWillNotDraw(false);
        this.mRoundCornerPath = new Path();
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.mRectF.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
        addRoundRect();
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null && layoutParams.width == -1 && layoutParams.height == -1) {
            super.onMeasure(i, i2);
            return;
        }
        if (this.mRatio > 0.01f) {
            int size = View.MeasureSpec.getSize(i);
            int size2 = View.MeasureSpec.getSize(i2);
            int mode = View.MeasureSpec.getMode(i2);
            if (size > j.hnadse(getContext())) {
                size = j.hnadse(getContext());
            }
            if (mode == Integer.MIN_VALUE || (size > 0 && size2 > 0)) {
                float f = size / size2;
                float f2 = this.mRatio;
                if (f > f2) {
                    size = getRatioSize(size2, f2);
                } else {
                    size2 = getRatioHeight(size, f2);
                }
            } else {
                size2 = getRatioSize(size, this.mRatio);
            }
            i = View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE);
            i2 = View.MeasureSpec.makeMeasureSpec(size2, Integer.MIN_VALUE);
        }
        super.onMeasure(i, i2);
    }

    public void setUseRatioInMatchParentMode(boolean z) {
        this.mUseRatioInMatchParentMode = z;
    }

    public AutoScaleSizeRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (this.mRoundCorner > 0.01f) {
            canvas.clipPath(this.mRoundCornerPath);
        }
        super.draw(canvas);
    }

    public void setRatio(float f) {
        this.mRatio = f;
        invalidate();
    }

    public void setRectCornerRadius(float f) {
        this.mRoundCorner = f;
        addRoundRect();
    }

    public AutoScaleSizeRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRectF = new RectF();
        this.mRoundCorner = 0.0f;
        this.mUseRatioInMatchParentMode = true;
        init(context, attributeSet);
    }
}
