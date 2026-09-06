package com.kwad.components.core.page.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.kwad.sdk.wrapper.m;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class TextProgressBar extends ProgressBar {
    private String afW;
    private LinearGradient afX;
    private Matrix afY;
    private boolean afZ;
    private boolean aga;
    private boolean agb;
    private int agc;
    private int agd;
    private Drawable age;
    private int agf;
    private Rect agg;
    private int[] agh;
    private int agi;
    private int agj;
    private boolean agk;
    private Paint mPaint;
    private RectF mRectF;

    public void setDrawableLeft(Drawable drawable) {
        this.age = drawable;
    }

    public void setDrawablePadding(int i) {
        this.agf = i;
    }

    public void setHasProgress(boolean z) {
        this.agb = z;
    }

    @Override // android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
        this.agc = i;
        this.agd = i3;
    }

    public void setVertical(boolean z) {
        this.aga = z;
    }

    public TextProgressBar(Context context) {
        this(context, null);
    }

    public TextProgressBar(Context context, AttributeSet attributeSet) {
        super(m.wrapContextIfNeed(context), attributeSet);
        this.aga = false;
        this.agb = true;
        this.agg = new Rect();
        uV();
    }

    @Override // android.widget.ProgressBar
    public void setProgress(int i) {
        if (this.agb) {
            super.setProgress(i);
        } else {
            super.setProgress(0);
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected synchronized void onDraw(Canvas canvas) {
        int width;
        if (this.aga) {
            canvas.save();
            canvas.rotate(90.0f);
            canvas.translate(0.0f, -getWidth());
            super.onDraw(canvas);
            canvas.restore();
        } else {
            super.onDraw(canvas);
        }
        if (!TextUtils.isEmpty(this.afW)) {
            Paint paint = this.mPaint;
            String str = this.afW;
            paint.getTextBounds(str, 0, str.length(), this.agg);
        }
        int height = (getHeight() / 2) - this.agg.centerY();
        Drawable drawable = this.age;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = this.age.getIntrinsicHeight();
            int width2 = (((getWidth() - this.agg.width()) - intrinsicWidth) - this.agf) / 2;
            int i = intrinsicWidth + width2;
            this.age.setBounds(width2, (getHeight() - intrinsicHeight) / 2, i, (getHeight() + intrinsicHeight) / 2);
            this.age.draw(canvas);
            width = i + this.agf;
        } else {
            width = (getWidth() / 2) - this.agg.centerX();
        }
        if (this.agh != null) {
            float progress = ((getProgress() * 1.0f) / getMax()) * getWidth();
            float f = width;
            if (progress >= f) {
                if (this.afX == null) {
                    this.afX = new LinearGradient(f, 0.0f, width + this.agg.width(), 0.0f, this.agh, (float[]) null, Shader.TileMode.CLAMP);
                    Matrix matrix = new Matrix();
                    this.afY = matrix;
                    this.afX.setLocalMatrix(matrix);
                }
                this.mPaint.setShader(this.afX);
                this.afY.setScale(((progress - f) * 1.0f) / this.agg.width(), 1.0f, f, 0.0f);
                this.afX.setLocalMatrix(this.afY);
            } else {
                this.mPaint.setShader(null);
            }
            canvas.drawText(this.afW, f, height, this.mPaint);
            return;
        }
        if (!isIndeterminate() && !this.agk) {
            this.mPaint.setColor(this.agi);
            String str2 = this.afW;
            if (str2 != null) {
                canvas.drawText(str2, width, height, this.mPaint);
            }
            return;
        }
        float width3 = (getWidth() * getProgress()) / getMax();
        int iSave = canvas.save();
        this.mRectF.set(width3, 0.0f, getWidth(), getHeight());
        canvas.clipRect(this.mRectF);
        this.mPaint.setColor(this.agj);
        String str3 = this.afW;
        if (str3 != null) {
            canvas.drawText(str3, width, height, this.mPaint);
        }
        canvas.restoreToCount(iSave);
        int iSave2 = canvas.save();
        this.mRectF.set(0.0f, 0.0f, width3, getHeight());
        canvas.clipRect(this.mRectF);
        this.mPaint.setColor(this.agi);
        String str4 = this.afW;
        if (str4 != null) {
            canvas.drawText(str4, width, height, this.mPaint);
        }
        canvas.restoreToCount(iSave2);
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected synchronized void onMeasure(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null && !TextUtils.isEmpty(this.afW)) {
            Rect rect = new Rect();
            Paint paint = this.mPaint;
            String str = this.afW;
            paint.getTextBounds(str, 0, str.length(), rect);
            if (layoutParams.width == -2) {
                layoutParams.width = rect.width() + this.agc + this.agd;
                i = View.MeasureSpec.makeMeasureSpec(layoutParams.width, 1073741824);
            }
            if (layoutParams.height == -2) {
                layoutParams.height = rect.height();
                i2 = View.MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
            }
        }
        if (this.aga) {
            super.onMeasure(i2, i);
            setMeasuredDimension(getMeasuredHeight(), getMeasuredWidth());
        } else {
            super.onMeasure(i, i2);
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        if (this.aga) {
            super.onSizeChanged(i2, i, i3, i4);
        } else {
            super.onSizeChanged(i, i2, i3, i4);
        }
    }

    private void uV() {
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        this.mPaint.setColor(-1);
        this.mPaint.setTextSize(com.kwad.sdk.c.a.a.a(getContext(), 12.0f));
        this.agf = com.kwad.sdk.c.a.a.a(getContext(), 2.0f);
        this.mRectF = new RectF();
        this.agi = -1;
        this.agj = -117146;
    }

    private void setProgressText(int i) {
        this.afW = String.valueOf((int) (((i * 1.0f) / getMax()) * 100.0f)) + "%";
    }

    public final void e(String str, int i) {
        this.afW = str;
        this.afZ = true;
        setProgress(i);
        invalidate();
    }

    public void setTextDimenSp(int i) {
        this.mPaint.setTextSize(TypedValue.applyDimension(2, i, getResources().getDisplayMetrics()));
    }

    public void setTextDimen(float f) {
        this.mPaint.setTextSize(f);
    }

    public void setTextColor(int i) {
        this.agk = false;
        this.agi = i;
        postInvalidate();
    }

    public final void setTextColor(int i, int i2) {
        this.agk = true;
        this.agi = i;
        this.agj = i2;
        postInvalidate();
    }
}
