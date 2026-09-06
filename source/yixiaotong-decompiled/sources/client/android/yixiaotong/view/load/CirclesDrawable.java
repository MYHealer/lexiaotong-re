package client.android.yixiaotong.view.load;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import android.util.TypedValue;
import java.security.InvalidParameterException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
class CirclesDrawable extends RefreshDrawable implements Runnable {
    private static final int ALPHA_OPAQUE = 255;
    private static final float CIRCLE_COUNT;
    private static final float MAX_LEVEL = 10000.0f;
    private static final float MAX_LEVEL_PER_CIRCLE;
    private static int mColor1;
    private static int mColor2;
    private static int mColor3;
    private static int mColor4;
    private int fstColor;
    private boolean goesBackward;
    private boolean isRunning;
    private Paint mAbovePaint;
    private int mAxisValue;
    private Rect mBounds;
    private ColorFilter mColorFilter;
    private int mControlPointMaximum;
    private int mControlPointMinimum;
    private ProgressStates mCurrentState;
    private int mDiameter;
    private int mDrawHeight;
    private int mDrawWidth;
    private Paint mFstHalfPaint;
    private int mHalf;
    private Handler mHandler;
    private int mLevel;
    private RectF mOval;
    private Path mPath;
    private Paint mScndHalfPaint;
    private int mTop;
    private int scndColor;

    private enum ProgressStates {
        FOLDING_DOWN,
        FOLDING_LEFT,
        FOLDING_UP,
        FOLDING_RIGHT
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

    public CirclesDrawable(Context context, PullRefreshLayout pullRefreshLayout) {
        super(context, pullRefreshLayout);
        this.mOval = new RectF();
        this.mHandler = new Handler();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.mLevel = 2500;
        this.isRunning = true;
        this.mHandler.postDelayed(this, 10L);
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.isRunning = false;
        this.mHandler.removeCallbacks(this);
    }

    @Override // client.android.yixiaotong.view.load.RefreshDrawable
    public void setColorSchemeColors(int[] iArr) {
        initCirclesProgress(iArr);
    }

    @Override // client.android.yixiaotong.view.load.RefreshDrawable
    public void setPercent(float f) {
        updateLevel((int) (f * 2500.0f));
    }

    private void updateLevel(int i) {
        boolean z = false;
        if (i == 10000.0f) {
            i = 0;
        }
        float f = i;
        float f2 = MAX_LEVEL_PER_CIRCLE;
        ProgressStates progressStates = ProgressStates.values()[(int) (f / f2)];
        this.mCurrentState = progressStates;
        resetColor(progressStates);
        int i2 = (int) (f % f2);
        if (this.goesBackward) {
            z = i2 == ((int) (f % (f2 / 2.0f)));
            i2 = (int) (f2 - i2);
        } else if (i2 != ((int) (f % (f2 / 2.0f)))) {
            z = true;
        }
        this.mFstHalfPaint.setColor(this.fstColor);
        this.mScndHalfPaint.setColor(this.scndColor);
        if (!z) {
            this.mAbovePaint.setColor(this.mScndHalfPaint.getColor());
        } else {
            this.mAbovePaint.setColor(this.mFstHalfPaint.getColor());
        }
        float f3 = i2;
        this.mAbovePaint.setAlpha(((int) ((f3 / f2) * 55.0f)) + 200);
        int i3 = this.mControlPointMinimum;
        this.mAxisValue = (int) (i3 + ((this.mControlPointMaximum - i3) * (f3 / f2)));
    }

    @Override // client.android.yixiaotong.view.load.RefreshDrawable
    public void offsetTopAndBottom(int i) {
        this.mTop += i;
        invalidateSelf();
    }

    @Override // java.lang.Runnable
    public void run() {
        int i = this.mLevel + 80;
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

    private void initCirclesProgress(int[] iArr) {
        initColors(iArr);
        this.mPath = new Path();
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        this.mFstHalfPaint = new Paint(paint);
        this.mScndHalfPaint = new Paint(paint);
        this.mAbovePaint = new Paint(paint);
        setColorFilter(this.mColorFilter);
    }

    private void initColors(int[] iArr) {
        if (iArr == null || iArr.length < 4) {
            throw new InvalidParameterException("The color scheme length must be 4");
        }
        mColor1 = iArr[0];
        mColor2 = iArr[1];
        mColor3 = iArr[2];
        mColor4 = iArr[3];
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        int iDp2px = dp2px(40);
        this.mDrawWidth = iDp2px;
        this.mDrawHeight = iDp2px;
        int finalOffset = getRefreshLayout().getFinalOffset();
        int i = this.mDrawHeight;
        this.mTop = (-iDp2px) - ((finalOffset - i) / 2);
        this.mBounds = rect;
        measureCircleProgress(this.mDrawWidth, i);
    }

    private void resetColor(ProgressStates progressStates) {
        int iOrdinal = progressStates.ordinal();
        if (iOrdinal == 0) {
            this.fstColor = mColor1;
            this.scndColor = mColor2;
            this.goesBackward = false;
            return;
        }
        if (iOrdinal == 1) {
            this.fstColor = mColor1;
            this.scndColor = mColor3;
            this.goesBackward = true;
        } else if (iOrdinal == 2) {
            this.fstColor = mColor3;
            this.scndColor = mColor4;
            this.goesBackward = true;
        } else {
            if (iOrdinal != 3) {
                return;
            }
            this.fstColor = mColor2;
            this.scndColor = mColor4;
            this.goesBackward = false;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.mCurrentState != null) {
            canvas.save();
            canvas.translate((this.mBounds.width() / 2) - (this.mDrawWidth / 2), this.mTop);
            makeCirclesProgress(canvas);
            canvas.restore();
        }
    }

    private void measureCircleProgress(int i, int i2) {
        int iMin = Math.min(i, i2);
        this.mDiameter = iMin;
        this.mHalf = iMin / 2;
        this.mOval.set(0.0f, 0.0f, iMin, iMin);
        int i3 = this.mDiameter;
        this.mControlPointMinimum = (-i3) / 6;
        this.mControlPointMaximum = i3 + (i3 / 6);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0012  */
    /* JADX WARN: Code duplicated, block: B:12:0x0016  */
    private void makeCirclesProgress(Canvas canvas) {
        int iOrdinal = this.mCurrentState.ordinal();
        if (iOrdinal == 0) {
            drawYMotion(canvas);
        } else if (iOrdinal == 1) {
            drawXMotion(canvas);
        } else if (iOrdinal == 2) {
            drawYMotion(canvas);
        } else if (iOrdinal == 3) {
            drawXMotion(canvas);
        }
        canvas.drawPath(this.mPath, this.mAbovePaint);
    }

    private void drawXMotion(Canvas canvas) {
        canvas.drawArc(this.mOval, 90.0f, 180.0f, true, this.mFstHalfPaint);
        canvas.drawArc(this.mOval, -270.0f, -180.0f, true, this.mScndHalfPaint);
        this.mPath.reset();
        this.mPath.moveTo(this.mHalf, 0.0f);
        Path path = this.mPath;
        int i = this.mAxisValue;
        float f = i;
        float f2 = i;
        int i2 = this.mDiameter;
        path.cubicTo(f, 0.0f, f2, i2, this.mHalf, i2);
    }

    private void drawYMotion(Canvas canvas) {
        canvas.drawArc(this.mOval, 0.0f, -180.0f, true, this.mFstHalfPaint);
        canvas.drawArc(this.mOval, -180.0f, -180.0f, true, this.mScndHalfPaint);
        this.mPath.reset();
        this.mPath.moveTo(0.0f, this.mHalf);
        Path path = this.mPath;
        int i = this.mAxisValue;
        int i2 = this.mDiameter;
        path.cubicTo(0.0f, i, i2, i, i2, this.mHalf);
    }

    @Override // client.android.yixiaotong.view.load.RefreshDrawable, android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.mColorFilter = colorFilter;
        this.mFstHalfPaint.setColorFilter(colorFilter);
        this.mScndHalfPaint.setColorFilter(colorFilter);
        this.mAbovePaint.setColorFilter(colorFilter);
    }

    private int dp2px(int i) {
        return (int) TypedValue.applyDimension(1, i, getContext().getResources().getDisplayMetrics());
    }
}
