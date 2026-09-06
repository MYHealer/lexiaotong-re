package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.facebook.common.internal.Preconditions;
import java.util.Arrays;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class RoundedCornersDrawable extends ForwardingDrawable implements Rounded {
    int mBorderColor;
    float mBorderWidth;
    boolean mIsCircle;
    int mOverlayColor;
    final Paint mPaint;
    private final Path mPath;
    final float[] mRadii;
    private final RectF mTempRectangle;
    Type mType;

    public enum Type {
        OVERLAY_COLOR,
        CLIPPING
    }

    public RoundedCornersDrawable(Drawable drawable) {
        super((Drawable) Preconditions.checkNotNull(drawable));
        this.mType = Type.OVERLAY_COLOR;
        this.mRadii = new float[8];
        this.mPaint = new Paint(1);
        this.mIsCircle = false;
        this.mBorderWidth = 0.0f;
        this.mBorderColor = 0;
        this.mOverlayColor = 0;
        this.mPath = new Path();
        this.mTempRectangle = new RectF();
    }

    public void setType(Type type) {
        this.mType = type;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void setCircle(boolean z) {
        this.mIsCircle = z;
        updatePath();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void setRadius(float f) {
        Arrays.fill(this.mRadii, f);
        updatePath();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void setRadii(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.mRadii, 0.0f);
        } else {
            Preconditions.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.mRadii, 0, 8);
        }
        updatePath();
        invalidateSelf();
    }

    public void setOverlayColor(int i) {
        this.mOverlayColor = i;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void setBorder(int i, float f) {
        this.mBorderColor = i;
        this.mBorderWidth = f;
        updatePath();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        updatePath();
    }

    private void updatePath() {
        this.mPath.reset();
        this.mTempRectangle.set(getBounds());
        RectF rectF = this.mTempRectangle;
        float f = this.mBorderWidth;
        rectF.inset(f / 2.0f, f / 2.0f);
        if (this.mIsCircle) {
            this.mPath.addCircle(this.mTempRectangle.centerX(), this.mTempRectangle.centerY(), Math.min(this.mTempRectangle.width(), this.mTempRectangle.height()) / 2.0f, Path.Direction.CW);
        } else {
            this.mPath.addRoundRect(this.mTempRectangle, this.mRadii, Path.Direction.CW);
        }
        RectF rectF2 = this.mTempRectangle;
        float f2 = this.mBorderWidth;
        rectF2.inset((-f2) / 2.0f, (-f2) / 2.0f);
    }

    /* JADX INFO: renamed from: com.facebook.drawee.drawable.RoundedCornersDrawable$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$drawee$drawable$RoundedCornersDrawable$Type;

        static {
            int[] iArr = new int[Type.values().length];
            $SwitchMap$com$facebook$drawee$drawable$RoundedCornersDrawable$Type = iArr;
            try {
                iArr[Type.CLIPPING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$facebook$drawee$drawable$RoundedCornersDrawable$Type[Type.OVERLAY_COLOR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        int i = AnonymousClass1.$SwitchMap$com$facebook$drawee$drawable$RoundedCornersDrawable$Type[this.mType.ordinal()];
        if (i == 1) {
            int iSave = canvas.save();
            this.mPath.setFillType(Path.FillType.EVEN_ODD);
            canvas.clipPath(this.mPath);
            super.draw(canvas);
            canvas.restoreToCount(iSave);
        } else if (i == 2) {
            super.draw(canvas);
            this.mPaint.setColor(this.mOverlayColor);
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPath.setFillType(Path.FillType.INVERSE_EVEN_ODD);
            canvas.drawPath(this.mPath, this.mPaint);
            if (this.mIsCircle) {
                float fWidth = ((bounds.width() - bounds.height()) + this.mBorderWidth) / 2.0f;
                float fHeight = ((bounds.height() - bounds.width()) + this.mBorderWidth) / 2.0f;
                if (fWidth > 0.0f) {
                    canvas.drawRect(bounds.left, bounds.top, bounds.left + fWidth, bounds.bottom, this.mPaint);
                    canvas.drawRect(bounds.right - fWidth, bounds.top, bounds.right, bounds.bottom, this.mPaint);
                }
                if (fHeight > 0.0f) {
                    canvas.drawRect(bounds.left, bounds.top, bounds.right, bounds.top + fHeight, this.mPaint);
                    canvas.drawRect(bounds.left, bounds.bottom - fHeight, bounds.right, bounds.bottom, this.mPaint);
                }
            }
        }
        if (this.mBorderColor != 0) {
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setColor(this.mBorderColor);
            this.mPaint.setStrokeWidth(this.mBorderWidth);
            this.mPath.setFillType(Path.FillType.EVEN_ODD);
            canvas.drawPath(this.mPath, this.mPaint);
        }
    }
}
