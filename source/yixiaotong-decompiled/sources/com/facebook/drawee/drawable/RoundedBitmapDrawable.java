package com.facebook.drawee.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import com.facebook.common.internal.Preconditions;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class RoundedBitmapDrawable extends BitmapDrawable implements TransformAwareDrawable, Rounded {
    int mBorderColor;
    private final Paint mBorderPaint;
    float mBorderWidth;
    float[] mCornerRadii;
    final Matrix mInverseTransform;
    boolean mIsCircle;
    boolean mIsNonzero;
    private boolean mIsPathDirty;
    private boolean mIsShaderTransformDirty;
    private WeakReference<Bitmap> mLastBitmap;
    final RectF mLastRootBounds;
    final Matrix mLastTransform;
    private final Paint mPaint;
    private final Path mPath;
    RectF mRootBounds;
    final Matrix mTransform;

    @Nullable
    private TransformCallback mTransformCallback;

    @Override // com.facebook.drawee.drawable.TransformAwareDrawable
    public void setTransformCallback(@Nullable TransformCallback transformCallback) {
        this.mTransformCallback = transformCallback;
    }

    public RoundedBitmapDrawable(Resources resources, Bitmap bitmap) {
        super(resources, bitmap);
        this.mIsCircle = false;
        this.mCornerRadii = new float[8];
        this.mRootBounds = new RectF();
        this.mLastRootBounds = new RectF();
        this.mTransform = new Matrix();
        this.mInverseTransform = new Matrix();
        this.mLastTransform = new Matrix();
        this.mBorderWidth = 0.0f;
        this.mBorderColor = 0;
        this.mIsNonzero = true;
        this.mPath = new Path();
        this.mIsPathDirty = true;
        this.mPaint = new Paint(1);
        Paint paint = new Paint(1);
        this.mBorderPaint = paint;
        this.mIsShaderTransformDirty = true;
        paint.setStyle(Paint.Style.STROKE);
    }

    public static RoundedBitmapDrawable fromBitmapDrawable(Resources resources, BitmapDrawable bitmapDrawable) {
        return new RoundedBitmapDrawable(resources, bitmapDrawable.getBitmap());
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void setCircle(boolean z) {
        this.mIsCircle = z;
        this.mIsPathDirty = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void setRadius(float f) {
        Preconditions.checkState(f >= 0.0f);
        Arrays.fill(this.mCornerRadii, f);
        this.mIsPathDirty = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void setRadii(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.mCornerRadii, 0.0f);
        } else {
            Preconditions.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.mCornerRadii, 0, 8);
        }
        this.mIsPathDirty = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void setBorder(int i, float f) {
        if (this.mBorderColor == i && this.mBorderWidth == f) {
            return;
        }
        this.mBorderColor = i;
        this.mBorderWidth = f;
        this.mIsPathDirty = true;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (i != this.mPaint.getAlpha()) {
            this.mPaint.setAlpha(i);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
        super.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        updateTransform();
        updateNonzero();
        if (!this.mIsNonzero) {
            super.draw(canvas);
            return;
        }
        updatePath();
        updatePaint();
        int iSave = canvas.save();
        canvas.concat(this.mInverseTransform);
        canvas.drawPath(this.mPath, this.mPaint);
        float f = this.mBorderWidth;
        if (f != 0.0f) {
            this.mBorderPaint.setStrokeWidth(f);
            this.mBorderPaint.setColor(DrawableUtils.multiplyColorAlpha(this.mBorderColor, this.mPaint.getAlpha()));
            canvas.drawPath(this.mPath, this.mBorderPaint);
        }
        canvas.restoreToCount(iSave);
    }

    private void updateNonzero() {
        if (!this.mIsPathDirty) {
            return;
        }
        int i = 0;
        this.mIsNonzero = false;
        if (this.mIsCircle || this.mBorderWidth > 0.0f) {
            this.mIsNonzero = true;
        }
        while (true) {
            float[] fArr = this.mCornerRadii;
            if (i >= fArr.length) {
                return;
            }
            if (fArr[i] > 0.0f) {
                this.mIsNonzero = true;
            }
            i++;
        }
    }

    private void updateTransform() {
        TransformCallback transformCallback = this.mTransformCallback;
        if (transformCallback != null) {
            transformCallback.getTransform(this.mTransform);
            this.mTransformCallback.getRootBounds(this.mRootBounds);
        } else {
            this.mTransform.reset();
            this.mRootBounds.set(getBounds());
        }
        if (!this.mTransform.equals(this.mLastTransform)) {
            this.mIsShaderTransformDirty = true;
            if (!this.mTransform.invert(this.mInverseTransform)) {
                this.mInverseTransform.reset();
                this.mTransform.reset();
            }
            this.mLastTransform.set(this.mTransform);
        }
        if (this.mRootBounds.equals(this.mLastRootBounds)) {
            return;
        }
        this.mIsPathDirty = true;
        this.mLastRootBounds.set(this.mRootBounds);
    }

    private void updatePath() {
        if (this.mIsPathDirty) {
            this.mPath.reset();
            RectF rectF = this.mRootBounds;
            float f = this.mBorderWidth;
            rectF.inset(f / 2.0f, f / 2.0f);
            if (this.mIsCircle) {
                this.mPath.addCircle(this.mRootBounds.centerX(), this.mRootBounds.centerY(), Math.min(this.mRootBounds.width(), this.mRootBounds.height()) / 2.0f, Path.Direction.CW);
            } else {
                this.mPath.addRoundRect(this.mRootBounds, this.mCornerRadii, Path.Direction.CW);
            }
            RectF rectF2 = this.mRootBounds;
            float f2 = this.mBorderWidth;
            rectF2.inset(-(f2 / 2.0f), -(f2 / 2.0f));
            this.mPath.setFillType(Path.FillType.WINDING);
            this.mIsPathDirty = false;
        }
    }

    private void updatePaint() {
        Bitmap bitmap = getBitmap();
        WeakReference<Bitmap> weakReference = this.mLastBitmap;
        if (weakReference == null || weakReference.get() != bitmap) {
            this.mLastBitmap = new WeakReference<>(bitmap);
            this.mPaint.setShader(new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
            this.mIsShaderTransformDirty = true;
        }
        if (this.mIsShaderTransformDirty) {
            this.mPaint.getShader().setLocalMatrix(this.mTransform);
            this.mIsShaderTransformDirty = false;
        }
    }
}
