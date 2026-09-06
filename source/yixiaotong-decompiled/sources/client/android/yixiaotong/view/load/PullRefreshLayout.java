package client.android.yixiaotong.view.load;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.Transformation;
import android.widget.ImageView;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import client.android.yixiaotong.R;
import java.security.InvalidParameterException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class PullRefreshLayout extends ViewGroup {
    private static final float DECELERATE_INTERPOLATION_FACTOR = 2.0f;
    private static final int DRAG_MAX_DISTANCE = 64;
    private static final float DRAG_RATE = 0.5f;
    private static final int INVALID_POINTER = -1;
    public static final int MODE_BOTTOM = 1;
    public static final int MODE_TOP = 0;
    public static final int STYLE_CIRCLES = 1;
    public static final int STYLE_MATERIAL = 0;
    public static final int STYLE_RING = 3;
    public static final int STYLE_WATER_DROP = 2;
    private static final String TAG = "PullRefreshLayout";
    private int mActivePointerId;
    private final Animation mAnimateToCorrectPosition;
    private final Animation mAnimateToStartPosition;
    private int[] mColorSchemeColors;
    private int mCurrentOffsetTop;
    private Interpolator mDecelerateInterpolator;
    private int mFrom;
    private float mInitialMotionY;
    private boolean mIsBeingDragged;
    private OnRefreshListener mListener;
    private int mMediumAnimationDuration;
    private int mMode;
    private boolean mNotify;
    private RefreshDrawable mRefreshDrawable;
    private Animation.AnimationListener mRefreshListener;
    private ImageView mRefreshView;
    private boolean mRefreshing;
    private int mSpinnerFinalOffset;
    private View mTarget;
    private Animation.AnimationListener mToStartListener;
    private int mTotalDragDistance;
    private int mTouchSlop;

    public interface OnRefreshListener {
        void onRefresh();
    }

    public int getFinalOffset() {
        return this.mSpinnerFinalOffset;
    }

    public void setOnRefreshListener(OnRefreshListener onRefreshListener) {
        this.mListener = onRefreshListener;
    }

    public PullRefreshLayout(Context context) {
        this(context, null);
    }

    public PullRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mAnimateToStartPosition = new Animation() { // from class: client.android.yixiaotong.view.load.PullRefreshLayout.1
            @Override // android.view.animation.Animation
            public void applyTransformation(float f, Transformation transformation) {
                PullRefreshLayout.this.moveToStart(f);
            }
        };
        this.mAnimateToCorrectPosition = new Animation() { // from class: client.android.yixiaotong.view.load.PullRefreshLayout.2
            @Override // android.view.animation.Animation
            public void applyTransformation(float f, Transformation transformation) {
                PullRefreshLayout.this.setTargetOffsetTop((PullRefreshLayout.this.mFrom + ((int) ((PullRefreshLayout.this.mSpinnerFinalOffset - PullRefreshLayout.this.mFrom) * f))) - PullRefreshLayout.this.mTarget.getTop(), false);
            }
        };
        this.mRefreshListener = new Animation.AnimationListener() { // from class: client.android.yixiaotong.view.load.PullRefreshLayout.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                PullRefreshLayout.this.mRefreshView.setVisibility(0);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (PullRefreshLayout.this.mRefreshing) {
                    PullRefreshLayout.this.mRefreshDrawable.start();
                    if (PullRefreshLayout.this.mNotify && PullRefreshLayout.this.mListener != null) {
                        PullRefreshLayout.this.mListener.onRefresh();
                    }
                } else {
                    PullRefreshLayout.this.mRefreshDrawable.stop();
                    PullRefreshLayout.this.mRefreshView.setVisibility(8);
                    PullRefreshLayout.this.animateOffsetToStartPosition();
                }
                PullRefreshLayout pullRefreshLayout = PullRefreshLayout.this;
                pullRefreshLayout.mCurrentOffsetTop = pullRefreshLayout.mTarget.getTop();
            }
        };
        this.mToStartListener = new Animation.AnimationListener() { // from class: client.android.yixiaotong.view.load.PullRefreshLayout.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                PullRefreshLayout.this.mRefreshDrawable.stop();
                PullRefreshLayout.this.mRefreshView.setVisibility(8);
                PullRefreshLayout pullRefreshLayout = PullRefreshLayout.this;
                pullRefreshLayout.mCurrentOffsetTop = pullRefreshLayout.mTarget.getTop();
            }
        };
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PullRefreshLayout);
        int integer = typedArrayObtainStyledAttributes.getInteger(R.styleable.PullRefreshLayout_type, 0);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.PullRefreshLayout_colors, R.array.google_colors);
        typedArrayObtainStyledAttributes.recycle();
        this.mDecelerateInterpolator = new DecelerateInterpolator(2.0f);
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.mMediumAnimationDuration = getResources().getInteger(android.R.integer.config_mediumAnimTime);
        int iDp2px = dp2px(64);
        this.mTotalDragDistance = iDp2px;
        this.mSpinnerFinalOffset = iDp2px;
        this.mRefreshView = new ImageView(context);
        this.mColorSchemeColors = context.getResources().getIntArray(resourceId);
        setRefreshStyle(integer);
        this.mRefreshView.setVisibility(8);
        addView(this.mRefreshView);
        setWillNotDraw(false);
        ViewCompat.setChildrenDrawingOrderEnabled(this, true);
    }

    public void setColorSchemeColors(int[] iArr) {
        this.mColorSchemeColors = iArr;
        this.mRefreshDrawable.setColorSchemeColors(iArr);
    }

    public void setRefreshStyle(int i) {
        setRefreshing(false);
        if (i == 0) {
            this.mRefreshDrawable = new MaterialDrawable(getContext(), this);
        } else if (i == 1) {
            this.mRefreshDrawable = new CirclesDrawable(getContext(), this);
        } else if (i == 2) {
            this.mRefreshDrawable = new WaterDropDrawable(getContext(), this);
        } else if (i == 3) {
            this.mRefreshDrawable = new RingDrawable(getContext(), this);
        } else {
            throw new InvalidParameterException("Type does not exist");
        }
        this.mRefreshDrawable.setColorSchemeColors(this.mColorSchemeColors);
        this.mRefreshView.setImageDrawable(this.mRefreshDrawable);
    }

    public void setRefreshDrawable(RefreshDrawable refreshDrawable) {
        setRefreshing(false);
        this.mRefreshDrawable = refreshDrawable;
        refreshDrawable.setColorSchemeColors(this.mColorSchemeColors);
        this.mRefreshView.setImageDrawable(this.mRefreshDrawable);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        ensureTarget();
        if (this.mTarget == null) {
            return;
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingRight()) - getPaddingLeft(), 1073741824);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824);
        this.mTarget.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        this.mRefreshView.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
    }

    private void ensureTarget() {
        if (this.mTarget == null && getChildCount() > 0) {
            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                if (childAt != this.mRefreshView) {
                    this.mTarget = childAt;
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:32:0x004b  */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled() || canChildScrollUp() || this.mRefreshing) {
            return false;
        }
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (actionMasked == 0) {
            setTargetOffsetTop(0, true);
            int pointerId = MotionEventCompat.getPointerId(motionEvent, 0);
            this.mActivePointerId = pointerId;
            this.mIsBeingDragged = false;
            float motionEventY = getMotionEventY(motionEvent, pointerId);
            if (motionEventY == -1.0f) {
                return false;
            }
            this.mInitialMotionY = motionEventY;
        } else if (actionMasked == 1) {
            this.mIsBeingDragged = false;
            this.mActivePointerId = -1;
        } else if (actionMasked == 2) {
            int i = this.mActivePointerId;
            if (i == -1) {
                return false;
            }
            float motionEventY2 = getMotionEventY(motionEvent, i);
            if (motionEventY2 == -1.0f) {
                return false;
            }
            if (motionEventY2 - this.mInitialMotionY > this.mTouchSlop && !this.mIsBeingDragged) {
                this.mIsBeingDragged = true;
            }
        } else if (actionMasked == 3) {
            this.mIsBeingDragged = false;
            this.mActivePointerId = -1;
        } else if (actionMasked == 6) {
            onSecondaryPointerUp(motionEvent);
        }
        return this.mIsBeingDragged;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.mIsBeingDragged) {
            return super.onTouchEvent(motionEvent);
        }
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (actionMasked != 1) {
            if (actionMasked == 2) {
                int iFindPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, this.mActivePointerId);
                if (iFindPointerIndex < 0) {
                    return false;
                }
                float y = (MotionEventCompat.getY(motionEvent, iFindPointerIndex) - this.mInitialMotionY) * 0.5f;
                float f = y / this.mTotalDragDistance;
                if (f < 0.0f) {
                    return false;
                }
                float fMin = Math.min(1.0f, Math.abs(f));
                float fAbs = Math.abs(y) - this.mTotalDragDistance;
                float f2 = this.mSpinnerFinalOffset;
                double dMax = Math.max(0.0f, Math.min(fAbs, f2 * 2.0f) / f2) / 4.0f;
                int iPow = (int) ((f2 * fMin) + (((float) (dMax - Math.pow(dMax, 2.0d))) * 2.0f * f2 * 2.0f));
                if (this.mRefreshView.getVisibility() != 0) {
                    this.mRefreshView.setVisibility(0);
                }
                if (y < this.mTotalDragDistance) {
                    this.mRefreshDrawable.setPercent(fMin);
                }
                setTargetOffsetTop(iPow - this.mCurrentOffsetTop, true);
            } else if (actionMasked != 3) {
                if (actionMasked == 5) {
                    this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, MotionEventCompat.getActionIndex(motionEvent));
                } else if (actionMasked == 6) {
                    onSecondaryPointerUp(motionEvent);
                }
            }
            return true;
        }
        int i = this.mActivePointerId;
        if (i == -1) {
            return false;
        }
        float y2 = (MotionEventCompat.getY(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, i)) - this.mInitialMotionY) * 0.5f;
        this.mIsBeingDragged = false;
        if (y2 > this.mTotalDragDistance) {
            setRefreshing(true, true);
        } else {
            this.mRefreshing = false;
            animateOffsetToStartPosition();
        }
        this.mActivePointerId = -1;
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void animateOffsetToStartPosition() {
        this.mFrom = this.mCurrentOffsetTop;
        this.mAnimateToStartPosition.reset();
        this.mAnimateToStartPosition.setDuration(this.mMediumAnimationDuration);
        this.mAnimateToStartPosition.setInterpolator(this.mDecelerateInterpolator);
        this.mAnimateToStartPosition.setAnimationListener(this.mToStartListener);
        this.mRefreshView.clearAnimation();
        this.mRefreshView.startAnimation(this.mAnimateToStartPosition);
    }

    private void animateOffsetToCorrectPosition() {
        this.mFrom = this.mCurrentOffsetTop;
        this.mAnimateToCorrectPosition.reset();
        this.mAnimateToCorrectPosition.setDuration(this.mMediumAnimationDuration);
        this.mAnimateToCorrectPosition.setInterpolator(this.mDecelerateInterpolator);
        this.mAnimateToCorrectPosition.setAnimationListener(this.mRefreshListener);
        this.mRefreshView.clearAnimation();
        this.mRefreshView.startAnimation(this.mAnimateToCorrectPosition);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void moveToStart(float f) {
        int i = this.mFrom;
        setTargetOffsetTop((i - ((int) (i * f))) - this.mTarget.getTop(), false);
    }

    public void setRefreshing(boolean z) {
        if (this.mRefreshing != z) {
            setRefreshing(z, false);
        }
    }

    private void setRefreshing(boolean z, boolean z2) {
        if (this.mRefreshing != z) {
            this.mNotify = z2;
            ensureTarget();
            this.mRefreshing = z;
            if (z) {
                this.mRefreshDrawable.setPercent(1.0f);
                animateOffsetToCorrectPosition();
            } else {
                animateOffsetToStartPosition();
            }
        }
    }

    private void onSecondaryPointerUp(MotionEvent motionEvent) {
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        if (MotionEventCompat.getPointerId(motionEvent, actionIndex) == this.mActivePointerId) {
            this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, actionIndex == 0 ? 1 : 0);
        }
    }

    private float getMotionEventY(MotionEvent motionEvent, int i) {
        int iFindPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, i);
        if (iFindPointerIndex < 0) {
            return -1.0f;
        }
        return MotionEventCompat.getY(motionEvent, iFindPointerIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTargetOffsetTop(int i, boolean z) {
        this.mRefreshView.bringToFront();
        this.mTarget.offsetTopAndBottom(i);
        this.mRefreshDrawable.offsetTopAndBottom(i);
        this.mCurrentOffsetTop = this.mTarget.getTop();
    }

    private boolean canChildScrollUp() {
        return ViewCompat.canScrollVertically(this.mTarget, -1);
    }

    private boolean canChildScrollDown() {
        return ViewCompat.canScrollVertically(this.mTarget, -1);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        ensureTarget();
        if (this.mTarget == null) {
            return;
        }
        int measuredHeight = getMeasuredHeight();
        int measuredWidth = getMeasuredWidth();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        View view = this.mTarget;
        int i5 = this.mCurrentOffsetTop;
        int i6 = (measuredWidth + paddingLeft) - paddingRight;
        int i7 = (measuredHeight + paddingTop) - paddingBottom;
        view.layout(paddingLeft, paddingTop + i5, i6, i5 + i7);
        this.mRefreshView.layout(paddingLeft, paddingTop, i6, i7);
    }

    private int dp2px(int i) {
        return (int) TypedValue.applyDimension(1, i, getContext().getResources().getDisplayMetrics());
    }
}
