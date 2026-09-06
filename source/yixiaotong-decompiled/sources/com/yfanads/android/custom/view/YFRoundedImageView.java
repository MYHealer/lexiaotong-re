package com.yfanads.android.custom.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.appcompat.widget.AppCompatImageView;
import com.yfanads.ads.R;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class YFRoundedImageView extends AppCompatImageView {
    private float cornerRadius;
    private Path path;
    private RectF rect;

    public YFRoundedImageView(Context context) {
        this(context, null);
    }

    private float dp2px(float f) {
        return TypedValue.applyDimension(1, f, getResources().getDisplayMetrics());
    }

    private void init() {
        this.path = new Path();
        this.rect = new RectF();
        setLayerType(2, null);
    }

    public void setCornerRadiusDp(float f) {
        this.cornerRadius = dp2px(f);
        invalidate();
    }

    public YFRoundedImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.cornerRadius > 0.0f) {
            this.rect.set(0.0f, 0.0f, getWidth(), getHeight());
            this.path.reset();
            Path path = this.path;
            RectF rectF = this.rect;
            float f = this.cornerRadius;
            path.addRoundRect(rectF, f, f, Path.Direction.CW);
            canvas.clipPath(this.path);
        }
        super.onDraw(canvas);
    }

    public void setCornerRadius(float f) {
        this.cornerRadius = f;
        invalidate();
    }

    public YFRoundedImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cornerRadius = 0.0f;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.YFRoundedImageView);
            this.cornerRadius = typedArrayObtainStyledAttributes.getDimension(R.styleable.YFRoundedImageView_roundRadius, 0.0f);
            typedArrayObtainStyledAttributes.recycle();
        }
        init();
    }
}
