package client.android.yixiaotong.view.load;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Handler;
import java.security.InvalidParameterException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
class WaterDropDrawable extends RefreshDrawable implements Runnable {
    private static final float CIRCLE_COUNT;
    private static final float MAX_LEVEL = 10000.0f;
    private static final float MAX_LEVEL_PER_CIRCLE;
    private boolean isRunning;
    private int[] mColorSchemeColors;
    private ProgressStates mCurrentState;
    private Handler mHandler;
    private int mHeight;
    private int mLevel;
    private Paint mPaint;
    private Path mPath;
    private int mTop;
    private int mWidth;
    private Point p1;
    private Point p2;
    private Point p3;
    private Point p4;

    private enum ProgressStates {
        ONE,
        TWO,
        TREE,
        FOUR
    }

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

    static {
        float length = ProgressStates.values().length;
        CIRCLE_COUNT = length;
        MAX_LEVEL_PER_CIRCLE = 10000.0f / length;
    }

    public WaterDropDrawable(Context context, PullRefreshLayout pullRefreshLayout) {
        super(context, pullRefreshLayout);
        this.mHandler = new Handler();
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setColor(-16776961);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setAntiAlias(true);
        this.mPath = new Path();
        this.p1 = new Point();
        this.p2 = new Point();
        this.p3 = new Point();
        this.p4 = new Point();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        canvas.save();
        int i = this.mTop;
        canvas.translate(0.0f, i > 0 ? i : 0.0f);
        this.mPath.reset();
        this.mPath.moveTo(this.p1.x, this.p1.y);
        this.mPath.cubicTo(this.p3.x, this.p3.y, this.p4.x, this.p4.y, this.p2.x, this.p2.y);
        canvas.drawPath(this.mPath, this.mPaint);
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.mWidth = rect.width();
        updateBounds();
        super.onBoundsChange(rect);
    }

    private void updateBounds() {
        int finalOffset = this.mHeight;
        int i = this.mWidth;
        if (finalOffset > getRefreshLayout().getFinalOffset()) {
            finalOffset = getRefreshLayout().getFinalOffset();
        }
        int i2 = i / 2;
        int finalOffset2 = (int) (i2 * (finalOffset / getRefreshLayout().getFinalOffset()));
        this.p1.set(finalOffset2, 0);
        this.p2.set(i - finalOffset2, 0);
        this.p3.set(i2 - finalOffset, finalOffset);
        this.p4.set(i2 + finalOffset, finalOffset);
    }

    @Override // client.android.yixiaotong.view.load.RefreshDrawable
    public void setColorSchemeColors(int[] iArr) {
        if (iArr == null || iArr.length < 4) {
            throw new InvalidParameterException("The color scheme length must be 4");
        }
        this.mPaint.setColor(iArr[0]);
        this.mColorSchemeColors = iArr;
    }

    @Override // client.android.yixiaotong.view.load.RefreshDrawable
    public void setPercent(float f) {
        Paint paint = this.mPaint;
        int[] iArr = this.mColorSchemeColors;
        paint.setColor(evaluate(f, iArr[0], iArr[1]));
    }

    private void updateLevel(int i) {
        int i2 = (int) ((((float) i) == 10000.0f ? 0 : i) / MAX_LEVEL_PER_CIRCLE);
        this.mCurrentState = ProgressStates.values()[i2];
        int[] iArr = this.mColorSchemeColors;
        this.mPaint.setColor(evaluate((i % 2500) / 2500.0f, iArr[i2], iArr[(i2 + 1) % ProgressStates.values().length]));
    }

    @Override // client.android.yixiaotong.view.load.RefreshDrawable
    public void offsetTopAndBottom(int i) {
        int i2 = this.mHeight + i;
        this.mHeight = i2;
        this.mTop = i2 - getRefreshLayout().getFinalOffset();
        updateBounds();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.mLevel = 2500;
        this.isRunning = true;
        this.mHandler.postDelayed(this, 20L);
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.mHandler.removeCallbacks(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        int i = this.mLevel + 60;
        this.mLevel = i;
        if (i > 10000.0f) {
            this.mLevel = 0;
        }
        if (this.isRunning) {
            this.mHandler.postDelayed(this, 20L);
            updateLevel(this.mLevel);
            invalidateSelf();
        }
    }
}
