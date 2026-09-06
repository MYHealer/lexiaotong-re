package client.android.yixiaotong.view.load;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import android.util.TypedValue;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
class RingDrawable extends RefreshDrawable {
    private static final int MAX_LEVEL = 200;
    private boolean isRunning;
    private float mAngle;
    private RectF mBounds;
    private int[] mColorSchemeColors;
    private float mDegress;
    private Handler mHandler;
    private int mHeight;
    private int mLevel;
    private Paint mPaint;
    private Path mPath;
    private int mWidth;

    private int evaluate(float f, int i, int i2) {
        int i3 = (i >> 24) & 255;
        int i4 = (i >> 16) & 255;
        int i5 = (i >> 8) & 255;
        int i6 = i & 255;
        return ((i3 + ((int) ((((i2 >> 24) & 255) - i3) * f))) << 24) | ((i4 + ((int) ((((i2 >> 16) & 255) - i4) * f))) << 16) | ((i5 + ((int) ((((i2 >> 8) & 255) - i5) * f))) << 8) | (i6 + ((int) (f * ((i2 & 255) - i6))));
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.isRunning;
    }

    @Override // client.android.yixiaotong.view.load.RefreshDrawable
    public void setColorSchemeColors(int[] iArr) {
        this.mColorSchemeColors = iArr;
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.isRunning = false;
        this.mDegress = 0.0f;
    }

    RingDrawable(Context context, PullRefreshLayout pullRefreshLayout) {
        super(context, pullRefreshLayout);
        this.mHandler = new Handler();
        Paint paint = new Paint(1);
        this.mPaint = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(dp2px(3));
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
        this.mPath = new Path();
    }

    @Override // client.android.yixiaotong.view.load.RefreshDrawable
    public void setPercent(float f) {
        Paint paint = this.mPaint;
        int[] iArr = this.mColorSchemeColors;
        paint.setColor(evaluate(f, iArr[0], iArr[1]));
        this.mAngle = f * 340.0f;
    }

    @Override // client.android.yixiaotong.view.load.RefreshDrawable
    public void offsetTopAndBottom(int i) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.mLevel = 50;
        this.isRunning = true;
        invalidateSelf();
    }

    private void updateLevel(int i) {
        int i2 = (i == 200 ? 0 : i) / 50;
        float f = (i % 50) / 50.0f;
        int[] iArr = this.mColorSchemeColors;
        this.mPaint.setColor(evaluate(f, iArr[i2], iArr[(i2 + 1) % iArr.length]));
        this.mDegress = f * 360.0f;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        int finalOffset = getRefreshLayout().getFinalOffset();
        this.mWidth = finalOffset;
        this.mHeight = finalOffset;
        RectF rectF = new RectF((rect.width() / 2) - (this.mWidth / 2), rect.top, (rect.width() / 2) + (this.mWidth / 2), rect.top + this.mHeight);
        this.mBounds = rectF;
        rectF.inset(dp2px(15), dp2px(15));
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        canvas.save();
        canvas.rotate(this.mDegress, this.mBounds.centerX(), this.mBounds.centerY());
        drawRing(canvas);
        canvas.restore();
        if (this.isRunning) {
            int i = this.mLevel;
            int i2 = i >= 200 ? 0 : i + 1;
            this.mLevel = i2;
            updateLevel(i2);
            invalidateSelf();
        }
    }

    private void drawRing(Canvas canvas) {
        this.mPath.reset();
        this.mPath.arcTo(this.mBounds, 270.0f, this.mAngle, true);
        canvas.drawPath(this.mPath, this.mPaint);
    }

    private int dp2px(int i) {
        return (int) TypedValue.applyDimension(1, i, getContext().getResources().getDisplayMetrics());
    }
}
