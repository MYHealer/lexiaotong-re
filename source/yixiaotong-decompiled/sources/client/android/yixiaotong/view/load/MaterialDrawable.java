package client.android.yixiaotong.view.load;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
class MaterialDrawable extends RefreshDrawable implements Animatable {
    private static final int ANIMATION_DURATION = 1333;
    private static final int ARROW_HEIGHT = 5;
    private static final int ARROW_HEIGHT_LARGE = 6;
    private static final float ARROW_OFFSET_ANGLE = 5.0f;
    private static final int ARROW_WIDTH = 10;
    private static final int ARROW_WIDTH_LARGE = 12;
    private static final float CENTER_RADIUS = 8.75f;
    private static final float CENTER_RADIUS_LARGE = 12.5f;
    private static final int CIRCLE_BG_LIGHT = -328966;
    private static final int CIRCLE_DIAMETER = 40;
    private static final int CIRCLE_DIAMETER_LARGE = 56;
    static final int DEFAULT = 1;
    private static final Interpolator END_CURVE_INTERPOLATOR;
    private static final int FILL_SHADOW_COLOR = 1023410176;
    private static final int KEY_SHADOW_COLOR = 503316480;
    static final int LARGE = 0;
    private static final int MAX_ALPHA = 255;
    private static final float MAX_PROGRESS_ANGLE = 0.8f;
    private static final float MAX_PROGRESS_ARC = 0.8f;
    private static final float NUM_POINTS = 5.0f;
    private static final int SHADOW_ELEVATION = 4;
    private static final float SHADOW_RADIUS = 3.5f;
    private static final Interpolator START_CURVE_INTERPOLATOR;
    private static final float STROKE_WIDTH = 2.5f;
    private static final float STROKE_WIDTH_LARGE = 3.0f;
    private static final float X_OFFSET = 0.0f;
    private static final float Y_OFFSET = 1.75f;
    private final int[] COLORS;
    private Animation mAnimation;
    private final ArrayList<Animation> mAnimators;
    private final Drawable.Callback mCallback;
    private ShapeDrawable mCircle;
    private int mDiameter;
    private Animation mFinishAnimation;
    private double mHeight;
    private int mPadding;
    private View mParent;
    private Resources mResources;
    private final Ring mRing;
    private float mRotation;
    private float mRotationCount;
    private int mShadowRadius;
    private int mTop;
    private double mWidth;
    private static final Interpolator LINEAR_INTERPOLATOR = new LinearInterpolator();
    private static final Interpolator EASE_INTERPOLATOR = new AccelerateDecelerateInterpolator();

    @Retention(RetentionPolicy.CLASS)
    public @interface ProgressDrawableSize {
    }

    private float getRotation() {
        return this.mRotation;
    }

    @Override // client.android.yixiaotong.view.load.RefreshDrawable, android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    static {
        END_CURVE_INTERPOLATOR = new EndCurveInterpolator();
        START_CURVE_INTERPOLATOR = new StartCurveInterpolator();
    }

    public MaterialDrawable(Context context, PullRefreshLayout pullRefreshLayout) {
        super(context, pullRefreshLayout);
        int[] iArr = {-16777216};
        this.COLORS = iArr;
        this.mAnimators = new ArrayList<>();
        Drawable.Callback callback = new Drawable.Callback() { // from class: client.android.yixiaotong.view.load.MaterialDrawable.5
            @Override // android.graphics.drawable.Drawable.Callback
            public void invalidateDrawable(Drawable drawable) {
                MaterialDrawable.this.invalidateSelf();
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
                MaterialDrawable.this.scheduleSelf(runnable, j);
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
                MaterialDrawable.this.unscheduleSelf(runnable);
            }
        };
        this.mCallback = callback;
        this.mParent = pullRefreshLayout;
        this.mResources = context.getResources();
        Ring ring = new Ring(callback);
        this.mRing = ring;
        ring.setColors(iArr);
        updateSizes(1);
        setupAnimators();
        createCircleDrawable();
        setBackgroundColor(CIRCLE_BG_LIGHT);
        int iDp2px = dp2px(40);
        this.mDiameter = iDp2px;
        this.mTop = (-iDp2px) - ((getRefreshLayout().getFinalOffset() - this.mDiameter) / 2);
    }

    private void createCircleDrawable() {
        float f = getContext().getResources().getDisplayMetrics().density;
        this.mShadowRadius = (int) (f * 3.5f);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShadow(this.mShadowRadius, (int) (20.0f * f * 2.0f)));
        this.mCircle = shapeDrawable;
        shapeDrawable.getPaint().setShadowLayer(this.mShadowRadius, (int) (0.0f * f), (int) (1.75f * f), KEY_SHADOW_COLOR);
        this.mPadding = this.mShadowRadius;
        this.mCircle.getPaint().setColor(-1);
    }

    private class OvalShadow extends OvalShape {
        private int mCircleDiameter;
        private RadialGradient mRadialGradient;
        private Paint mShadowPaint = new Paint();
        private int mShadowRadius;

        public OvalShadow(int i, int i2) {
            this.mShadowRadius = i;
            this.mCircleDiameter = i2;
            int i3 = this.mCircleDiameter;
            RadialGradient radialGradient = new RadialGradient(i3 / 2, i3 / 2, this.mShadowRadius, new int[]{MaterialDrawable.FILL_SHADOW_COLOR, 0}, (float[]) null, Shader.TileMode.CLAMP);
            this.mRadialGradient = radialGradient;
            this.mShadowPaint.setShader(radialGradient);
        }

        @Override // android.graphics.drawable.shapes.OvalShape, android.graphics.drawable.shapes.RectShape, android.graphics.drawable.shapes.Shape
        public void draw(Canvas canvas, Paint paint) {
            float fCenterX = MaterialDrawable.this.getBounds().centerX();
            float fCenterY = MaterialDrawable.this.getBounds().centerY();
            canvas.drawCircle(fCenterX, fCenterY, (this.mCircleDiameter / 2) + this.mShadowRadius, this.mShadowPaint);
            canvas.drawCircle(fCenterX, fCenterY, this.mCircleDiameter / 2, paint);
        }
    }

    private void setSizeParameters(double d, double d2, double d3, double d4, float f, float f2) {
        Ring ring = this.mRing;
        float f3 = this.mResources.getDisplayMetrics().density;
        double d5 = f3;
        this.mWidth = d * d5;
        this.mHeight = d2 * d5;
        ring.setStrokeWidth(((float) d4) * f3);
        ring.setCenterRadius(d3 * d5);
        ring.setColorIndex(0);
        ring.setArrowDimensions(f * f3, f2 * f3);
        ring.setInsets((int) this.mWidth, (int) this.mHeight);
    }

    public void updateSizes(int i) {
        if (i == 0) {
            setSizeParameters(56.0d, 56.0d, 12.5d, 3.0d, 12.0f, 6.0f);
        } else {
            setSizeParameters(40.0d, 40.0d, 8.75d, 2.5d, 10.0f, 5.0f);
        }
    }

    public void showArrow(boolean z) {
        this.mRing.setShowArrow(z);
    }

    public void setArrowScale(float f) {
        this.mRing.setArrowScale(f);
    }

    public void setStartEndTrim(float f, float f2) {
        this.mRing.setStartTrim(f);
        this.mRing.setEndTrim(f2);
    }

    public void setProgressRotation(float f) {
        this.mRing.setRotation(f);
    }

    public void setBackgroundColor(int i) {
        this.mRing.setBackgroundColor(i);
    }

    @Override // client.android.yixiaotong.view.load.RefreshDrawable
    public void setPercent(float f) {
        if (f < 0.4f) {
            return;
        }
        float f2 = (f - 0.4f) / 0.6f;
        setAlpha((int) (255.0f * f2));
        showArrow(true);
        setStartEndTrim(0.0f, Math.min(0.8f, f2 * 0.8f));
        setArrowScale(Math.min(1.0f, f2));
        setProgressRotation(f2 >= 0.8f ? ((f2 - 0.8f) / 0.2f) * 0.25f : 0.0f);
    }

    @Override // client.android.yixiaotong.view.load.RefreshDrawable
    public void setColorSchemeColors(int... iArr) {
        this.mRing.setColors(iArr);
        this.mRing.setColorIndex(0);
    }

    @Override // client.android.yixiaotong.view.load.RefreshDrawable
    public void offsetTopAndBottom(int i) {
        this.mTop += i;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        int iSave = canvas.save();
        canvas.translate(0.0f, this.mTop);
        this.mCircle.draw(canvas);
        canvas.rotate(this.mRotation, bounds.exactCenterX(), bounds.exactCenterY());
        this.mRing.draw(canvas, bounds);
        canvas.restoreToCount(iSave);
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i, int i2, int i3, int i4) {
        int i5 = (i3 - i) / 2;
        int i6 = this.mDiameter;
        super.setBounds(i5 - (i6 / 2), i2, i5 + (i6 / 2), i6 + i2);
    }

    private int dp2px(int i) {
        return (int) TypedValue.applyDimension(1, i, getContext().getResources().getDisplayMetrics());
    }

    @Override // client.android.yixiaotong.view.load.RefreshDrawable, android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.mRing.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.mRing.getAlpha();
    }

    @Override // client.android.yixiaotong.view.load.RefreshDrawable, android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.mRing.setColorFilter(colorFilter);
    }

    void setRotation(float f) {
        this.mRotation = f;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        ArrayList<Animation> arrayList = this.mAnimators;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Animation animation = arrayList.get(i);
            if (animation.hasStarted() && !animation.hasEnded()) {
                return true;
            }
        }
        return false;
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.mAnimation.reset();
        this.mRing.storeOriginals();
        if (this.mRing.getEndTrim() != this.mRing.getStartTrim()) {
            this.mParent.startAnimation(this.mFinishAnimation);
            return;
        }
        this.mRing.setColorIndex(0);
        this.mRing.resetOriginals();
        this.mParent.startAnimation(this.mAnimation);
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.mParent.clearAnimation();
        setRotation(0.0f);
        this.mRing.setShowArrow(false);
        this.mRing.setColorIndex(0);
        this.mRing.resetOriginals();
    }

    private void setupAnimators() {
        final Ring ring = this.mRing;
        Animation animation = new Animation() { // from class: client.android.yixiaotong.view.load.MaterialDrawable.1
            @Override // android.view.animation.Animation
            public void applyTransformation(float f, Transformation transformation) {
                float fFloor = (float) (Math.floor(ring.getStartingRotation() / 0.8f) + 1.0d);
                ring.setStartTrim(ring.getStartingStartTrim() + ((ring.getStartingEndTrim() - ring.getStartingStartTrim()) * f));
                ring.setRotation(ring.getStartingRotation() + ((fFloor - ring.getStartingRotation()) * f));
                ring.setArrowScale(1.0f - f);
            }
        };
        animation.setInterpolator(EASE_INTERPOLATOR);
        animation.setDuration(666L);
        animation.setAnimationListener(new Animation.AnimationListener() { // from class: client.android.yixiaotong.view.load.MaterialDrawable.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation2) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation2) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation2) {
                ring.goToNextColor();
                ring.storeOriginals();
                ring.setShowArrow(false);
                MaterialDrawable.this.mParent.startAnimation(MaterialDrawable.this.mAnimation);
            }
        });
        Animation animation2 = new Animation() { // from class: client.android.yixiaotong.view.load.MaterialDrawable.3
            @Override // android.view.animation.Animation
            public void applyTransformation(float f, Transformation transformation) {
                float radians = (float) Math.toRadians(((double) ring.getStrokeWidth()) / (ring.getCenterRadius() * 6.283185307179586d));
                float startingEndTrim = ring.getStartingEndTrim();
                float startingStartTrim = ring.getStartingStartTrim();
                float startingRotation = ring.getStartingRotation();
                ring.setEndTrim(startingEndTrim + ((0.8f - radians) * MaterialDrawable.START_CURVE_INTERPOLATOR.getInterpolation(f)));
                ring.setStartTrim(startingStartTrim + (MaterialDrawable.END_CURVE_INTERPOLATOR.getInterpolation(f) * 0.8f));
                ring.setRotation(startingRotation + (0.25f * f));
                MaterialDrawable.this.setRotation((f * 144.0f) + ((MaterialDrawable.this.mRotationCount / 5.0f) * 720.0f));
            }
        };
        animation2.setRepeatCount(-1);
        animation2.setRepeatMode(1);
        animation2.setInterpolator(LINEAR_INTERPOLATOR);
        animation2.setDuration(1333L);
        animation2.setAnimationListener(new Animation.AnimationListener() { // from class: client.android.yixiaotong.view.load.MaterialDrawable.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation3) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation3) {
                MaterialDrawable.this.mRotationCount = 0.0f;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation3) {
                ring.storeOriginals();
                ring.goToNextColor();
                Ring ring2 = ring;
                ring2.setStartTrim(ring2.getEndTrim());
                MaterialDrawable materialDrawable = MaterialDrawable.this;
                materialDrawable.mRotationCount = (materialDrawable.mRotationCount + 1.0f) % 5.0f;
            }
        });
        this.mFinishAnimation = animation;
        this.mAnimation = animation2;
    }

    private static class Ring {
        private int mAlpha;
        private Path mArrow;
        private int mArrowHeight;
        private final Paint mArrowPaint;
        private float mArrowScale;
        private int mArrowWidth;
        private int mBackgroundColor;
        private final Drawable.Callback mCallback;
        private final Paint mCirclePaint;
        private int mColorIndex;
        private int[] mColors;
        private float mEndTrim;
        private final Paint mPaint;
        private double mRingCenterRadius;
        private float mRotation;
        private boolean mShowArrow;
        private float mStartTrim;
        private float mStartingEndTrim;
        private float mStartingRotation;
        private float mStartingStartTrim;
        private float mStrokeInset;
        private float mStrokeWidth;
        private final RectF mTempBounds = new RectF();

        public int getAlpha() {
            return this.mAlpha;
        }

        public double getCenterRadius() {
            return this.mRingCenterRadius;
        }

        public float getEndTrim() {
            return this.mEndTrim;
        }

        public float getInsets() {
            return this.mStrokeInset;
        }

        public float getRotation() {
            return this.mRotation;
        }

        public float getStartTrim() {
            return this.mStartTrim;
        }

        public float getStartingEndTrim() {
            return this.mStartingEndTrim;
        }

        public float getStartingRotation() {
            return this.mStartingRotation;
        }

        public float getStartingStartTrim() {
            return this.mStartingStartTrim;
        }

        public float getStrokeWidth() {
            return this.mStrokeWidth;
        }

        public void setAlpha(int i) {
            this.mAlpha = i;
        }

        public void setArrowDimensions(float f, float f2) {
            this.mArrowWidth = (int) f;
            this.mArrowHeight = (int) f2;
        }

        public void setBackgroundColor(int i) {
            this.mBackgroundColor = i;
        }

        public void setCenterRadius(double d) {
            this.mRingCenterRadius = d;
        }

        public void setColorIndex(int i) {
            this.mColorIndex = i;
        }

        public void storeOriginals() {
            this.mStartingStartTrim = this.mStartTrim;
            this.mStartingEndTrim = this.mEndTrim;
            this.mStartingRotation = this.mRotation;
        }

        public Ring(Drawable.Callback callback) {
            Paint paint = new Paint();
            this.mPaint = paint;
            Paint paint2 = new Paint();
            this.mArrowPaint = paint2;
            this.mStartTrim = 0.0f;
            this.mEndTrim = 0.0f;
            this.mRotation = 0.0f;
            this.mStrokeWidth = 5.0f;
            this.mStrokeInset = MaterialDrawable.STROKE_WIDTH;
            this.mCirclePaint = new Paint();
            this.mCallback = callback;
            paint.setStrokeCap(Paint.Cap.SQUARE);
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.STROKE);
            paint2.setStyle(Paint.Style.FILL);
            paint2.setAntiAlias(true);
        }

        public void draw(Canvas canvas, Rect rect) {
            RectF rectF = this.mTempBounds;
            rectF.set(rect);
            float f = this.mStrokeInset;
            rectF.inset(f, f);
            float f2 = this.mStartTrim;
            float f3 = this.mRotation;
            float f4 = (f2 + f3) * 360.0f;
            float f5 = ((this.mEndTrim + f3) * 360.0f) - f4;
            this.mPaint.setColor(this.mColors[this.mColorIndex]);
            canvas.drawArc(rectF, f4, f5, false, this.mPaint);
            drawTriangle(canvas, f4, f5, rect);
            if (this.mAlpha < 255) {
                this.mCirclePaint.setColor(this.mBackgroundColor);
                this.mCirclePaint.setAlpha(255 - this.mAlpha);
                canvas.drawCircle(rect.exactCenterX(), rect.exactCenterY(), rect.width() / 2, this.mCirclePaint);
            }
        }

        private void drawTriangle(Canvas canvas, float f, float f2, Rect rect) {
            if (this.mShowArrow) {
                Path path = this.mArrow;
                if (path == null) {
                    Path path2 = new Path();
                    this.mArrow = path2;
                    path2.setFillType(Path.FillType.EVEN_ODD);
                } else {
                    path.reset();
                }
                float f3 = (((int) this.mStrokeInset) / 2) * this.mArrowScale;
                float fCos = (float) ((this.mRingCenterRadius * Math.cos(0.0d)) + ((double) rect.exactCenterX()));
                float fSin = (float) ((this.mRingCenterRadius * Math.sin(0.0d)) + ((double) rect.exactCenterY()));
                this.mArrow.moveTo(0.0f, 0.0f);
                this.mArrow.lineTo(this.mArrowWidth * this.mArrowScale, 0.0f);
                Path path3 = this.mArrow;
                float f4 = this.mArrowWidth;
                float f5 = this.mArrowScale;
                path3.lineTo((f4 * f5) / 2.0f, this.mArrowHeight * f5);
                this.mArrow.offset(fCos - f3, fSin);
                this.mArrow.close();
                this.mArrowPaint.setColor(this.mColors[this.mColorIndex]);
                canvas.rotate((f + f2) - 5.0f, rect.exactCenterX(), rect.exactCenterY());
                canvas.drawPath(this.mArrow, this.mArrowPaint);
            }
        }

        public void setColors(int[] iArr) {
            this.mColors = iArr;
            setColorIndex(0);
        }

        public void goToNextColor() {
            this.mColorIndex = (this.mColorIndex + 1) % this.mColors.length;
        }

        public void setColorFilter(ColorFilter colorFilter) {
            this.mPaint.setColorFilter(colorFilter);
            invalidateSelf();
        }

        public void setStrokeWidth(float f) {
            this.mStrokeWidth = f;
            this.mPaint.setStrokeWidth(f);
            invalidateSelf();
        }

        public void setStartTrim(float f) {
            this.mStartTrim = f;
            invalidateSelf();
        }

        public void setEndTrim(float f) {
            this.mEndTrim = f;
            invalidateSelf();
        }

        public void setRotation(float f) {
            this.mRotation = f;
            invalidateSelf();
        }

        public void setInsets(int i, int i2) {
            float fMin = Math.min(i, i2);
            double d = this.mRingCenterRadius;
            this.mStrokeInset = (float) ((d <= 0.0d || fMin < 0.0f) ? Math.ceil(this.mStrokeWidth / 2.0f) : ((double) (fMin / 2.0f)) - d);
        }

        public void setShowArrow(boolean z) {
            if (this.mShowArrow != z) {
                this.mShowArrow = z;
                invalidateSelf();
            }
        }

        public void setArrowScale(float f) {
            if (f != this.mArrowScale) {
                this.mArrowScale = f;
                invalidateSelf();
            }
        }

        public void resetOriginals() {
            this.mStartingStartTrim = 0.0f;
            this.mStartingEndTrim = 0.0f;
            this.mStartingRotation = 0.0f;
            setStartTrim(0.0f);
            setEndTrim(0.0f);
            setRotation(0.0f);
        }

        private void invalidateSelf() {
            this.mCallback.invalidateDrawable(null);
        }
    }

    private static class EndCurveInterpolator extends AccelerateDecelerateInterpolator {
        private EndCurveInterpolator() {
        }

        @Override // android.view.animation.AccelerateDecelerateInterpolator, android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            return super.getInterpolation(Math.max(0.0f, (f - 0.5f) * 2.0f));
        }
    }

    private static class StartCurveInterpolator extends AccelerateDecelerateInterpolator {
        private StartCurveInterpolator() {
        }

        @Override // android.view.animation.AccelerateDecelerateInterpolator, android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            return super.getInterpolation(Math.min(1.0f, f * 2.0f));
        }
    }
}
