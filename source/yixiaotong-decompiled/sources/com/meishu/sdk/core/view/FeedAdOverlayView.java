package com.meishu.sdk.core.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import com.meishu.sdk.core.safe.i;
import com.meishu.sdk.core.safe.j;
import com.meishu.sdk.core.safe.l;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.s1;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class FeedAdOverlayView extends View {
    public static final float EXTEND_DOWN_RATIO = 0.1f;
    public static final float EXTEND_LEFT_RATIO = 0.55f;
    public static final float EXTEND_RIGHT_RATIO = 0.5f;
    public static final float EXTEND_UP_RATIO = 0.15f;
    private static final String TAG = "FeedAdOverlayView";
    private WeakReference<View> adContainerRef;
    private OnOverlayAttachListener attachListener;
    private OnOverlayClickListener clickListener;
    private WeakReference<ViewGroup> contentViewRef;
    private long downEventTime;
    private boolean downInAdArea;
    private float downRawX;
    private float downRawY;
    private float downX;
    private float downY;
    private float extendDownRatio;
    private float extendLeftRatio;
    private float extendRightRatio;
    private float extendUpRatio;
    private boolean interceptAllEvents;
    private InvalidityCheckerListener invalidityChecker;
    private boolean isSliding;
    private i layoutChangeListener;
    private int minSlideDistanceDp;
    private String overlayUniqueId;
    private j scrollChangedListener;
    private boolean slideClickEnabled;
    private int slideScrollDistance;
    private WeakReference<View> slidingTargetRef;
    private float upRawX;
    private float upRawY;

    public interface InvalidityCheckerListener {
        void onInvalid(String str);
    }

    public interface OnOverlayAttachListener {
        void onOverlayAttached();

        void onOverlayDetached();
    }

    public interface OnOverlayClickListener {
        void onOverlayClick(boolean z, boolean z2, TouchPoint touchPoint, TouchPoint touchPoint2, int i, String str);
    }

    public FeedAdOverlayView(Context context, View view, OnOverlayClickListener onOverlayClickListener) {
        super(context);
        this.extendUpRatio = 0.15f;
        this.extendDownRatio = 0.1f;
        this.extendLeftRatio = 0.55f;
        this.extendRightRatio = 0.5f;
        this.interceptAllEvents = false;
        this.slideClickEnabled = false;
        this.minSlideDistanceDp = 250;
        this.downInAdArea = false;
        this.isSliding = false;
        this.slideScrollDistance = 0;
        this.adContainerRef = new WeakReference<>(view);
        this.clickListener = onOverlayClickListener;
        setBackgroundColor(0);
    }

    private View findUnderlyingView(ViewGroup viewGroup, float f, float f2) {
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount);
            if (childAt != this) {
                int[] iArr = new int[2];
                childAt.getLocationOnScreen(iArr);
                int i = iArr[0];
                if (new Rect(i, iArr[1], childAt.getWidth() + i, childAt.getHeight() + iArr[1]).contains((int) f, (int) f2) && !(childAt instanceof FeedAdOverlayView)) {
                    return childAt;
                }
            }
        }
        return null;
    }

    private void forwardEventToUnderlying(MotionEvent motionEvent, int i) {
        View viewFindUnderlyingView;
        try {
            WeakReference<ViewGroup> weakReference = this.contentViewRef;
            ViewGroup viewGroup = weakReference != null ? weakReference.get() : null;
            if (viewGroup == null) {
                return;
            }
            float rawX = motionEvent.getRawX();
            float rawY = motionEvent.getRawY();
            if (i == 0) {
                viewFindUnderlyingView = findUnderlyingView(viewGroup, rawX, rawY);
                if (viewFindUnderlyingView == null) {
                    LogUtil.d(TAG, "forwardEventToUnderlying: no underlying view at (" + rawX + "," + rawY + ")");
                    return;
                }
                this.slidingTargetRef = new WeakReference<>(viewFindUnderlyingView);
            } else {
                WeakReference<View> weakReference2 = this.slidingTargetRef;
                View view = weakReference2 != null ? weakReference2.get() : null;
                if (view == null) {
                    return;
                } else {
                    viewFindUnderlyingView = view;
                }
            }
            dispatchToView(viewFindUnderlyingView, motionEvent, i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private float[] toAdContainerCoords(float f, float f2) {
        View view = this.adContainerRef.get();
        return (view == null || getWidth() == 0 || getHeight() == 0) ? new float[]{f, f2} : new float[]{(f * view.getWidth()) / getWidth(), (f2 * view.getHeight()) / getHeight()};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePosition(ViewGroup viewGroup) {
        View view = this.adContainerRef.get();
        if (view == null || viewGroup == null || view.getWidth() == 0 || view.getHeight() == 0) {
            return;
        }
        if (view.getWindowToken() == null) {
            if (getVisibility() != 4) {
                setVisibility(4);
                return;
            }
            return;
        }
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        int i = displayMetrics.widthPixels;
        int i2 = displayMetrics.heightPixels;
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        if (view.getHeight() + iArr[1] > 0 && iArr[1] < i2) {
            if (view.getWidth() + iArr[0] > 0 && iArr[0] < i) {
                if (getVisibility() != 0) {
                    setVisibility(0);
                }
                int i3 = iArr[0];
                float f = i;
                int i4 = i3 - ((int) (this.extendLeftRatio * f));
                float f2 = i2;
                int i5 = iArr[1] - ((int) (this.extendUpRatio * f2));
                int measuredWidth = view.getMeasuredWidth() + i3 + ((int) (f * this.extendRightRatio));
                int measuredHeight = view.getMeasuredHeight() + iArr[1] + ((int) (f2 * this.extendDownRatio));
                int[] iArr2 = new int[2];
                viewGroup.getLocationOnScreen(iArr2);
                int i6 = i4 - iArr2[0];
                int i7 = i5 - iArr2[1];
                int i8 = measuredWidth - i4;
                int i9 = measuredHeight - i5;
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
                if (marginLayoutParams == null) {
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = new ViewGroup.MarginLayoutParams(i8, i9);
                    marginLayoutParams2.leftMargin = i6;
                    marginLayoutParams2.topMargin = i7;
                    setLayoutParams(marginLayoutParams2);
                    return;
                }
                if (marginLayoutParams.width == i8 && marginLayoutParams.height == i9 && marginLayoutParams.leftMargin == i6 && marginLayoutParams.topMargin == i7) {
                    return;
                }
                marginLayoutParams.width = i8;
                marginLayoutParams.height = i9;
                marginLayoutParams.leftMargin = i6;
                marginLayoutParams.topMargin = i7;
                setLayoutParams(marginLayoutParams);
                return;
            }
        }
        if (getVisibility() != 4) {
            setVisibility(4);
        }
    }

    public void attachToContent(final ViewGroup viewGroup) {
        try {
            this.contentViewRef = new WeakReference<>(viewGroup);
            viewGroup.addView(this, new ViewGroup.LayoutParams(0, 0));
            this.scrollChangedListener = new j() { // from class: com.meishu.sdk.core.view.FeedAdOverlayView.1
                @Override // com.meishu.sdk.core.safe.j
                public void safeOnScrollChanged() {
                    FeedAdOverlayView.this.updatePosition(viewGroup);
                }
            };
            this.layoutChangeListener = new i() { // from class: com.meishu.sdk.core.view.FeedAdOverlayView.2
                @Override // com.meishu.sdk.core.safe.i
                public void safeOnLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    FeedAdOverlayView.this.updatePosition(viewGroup);
                }
            };
            View view = this.adContainerRef.get();
            if (view != null) {
                view.getViewTreeObserver().addOnScrollChangedListener(this.scrollChangedListener);
                view.addOnLayoutChangeListener(this.layoutChangeListener);
            }
            viewGroup.post(new l() { // from class: com.meishu.sdk.core.view.FeedAdOverlayView.3
                @Override // com.meishu.sdk.core.safe.l
                public void safeRun() {
                    FeedAdOverlayView.this.updatePosition(viewGroup);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void detach() {
        try {
            View view = this.adContainerRef.get();
            if (view != null) {
                if (this.scrollChangedListener != null) {
                    view.getViewTreeObserver().removeOnScrollChangedListener(this.scrollChangedListener);
                }
                i iVar = this.layoutChangeListener;
                if (iVar != null) {
                    view.removeOnLayoutChangeListener(iVar);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.scrollChangedListener = null;
        this.layoutChangeListener = null;
        this.clickListener = null;
        this.attachListener = null;
        this.invalidityChecker = null;
        try {
            ViewGroup viewGroup = (ViewGroup) getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        OnOverlayAttachListener onOverlayAttachListener = this.attachListener;
        if (onOverlayAttachListener != null) {
            onOverlayAttachListener.onOverlayAttached();
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        OnOverlayAttachListener onOverlayAttachListener = this.attachListener;
        if (onOverlayAttachListener != null) {
            onOverlayAttachListener.onOverlayDetached();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.downRawX = motionEvent.getRawX();
                this.downRawY = motionEvent.getRawY();
                this.downX = motionEvent.getX();
                this.downY = motionEvent.getY();
                this.upRawX = this.downRawX;
                this.upRawY = this.downRawY;
                this.downEventTime = System.currentTimeMillis();
                this.isSliding = false;
                this.slideScrollDistance = 0;
                this.slidingTargetRef = null;
                this.downInAdArea = s1.a(this.adContainerRef.get(), this.downRawX, this.downRawY);
                forwardEventToUnderlying(motionEvent, 0);
                return true;
            }
            if (action != 1) {
                if (action != 2) {
                    if (action != 3) {
                        return this.interceptAllEvents;
                    }
                    forwardEventToUnderlying(motionEvent, 3);
                    this.isSliding = false;
                    InvalidityCheckerListener invalidityCheckerListener = this.invalidityChecker;
                    if (invalidityCheckerListener != null) {
                        invalidityCheckerListener.onInvalid(this.overlayUniqueId);
                    }
                    return this.interceptAllEvents;
                }
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                this.slideScrollDistance = (int) Math.max(Math.abs(rawX - this.downRawX), Math.abs(rawY - this.downRawY));
                if (!this.isSliding) {
                    if (this.slideScrollDistance > ViewConfiguration.get(getContext()).getScaledTouchSlop()) {
                        this.isSliding = true;
                    }
                }
                forwardEventToUnderlying(motionEvent, 2);
                this.upRawX = rawX;
                this.upRawY = rawY;
                return true;
            }
            this.upRawX = motionEvent.getRawX();
            this.upRawY = motionEvent.getRawY();
            float f = getContext().getResources().getDisplayMetrics().density;
            boolean z = this.isSliding;
            boolean z2 = !z;
            boolean z3 = this.slideClickEnabled && z && ((float) this.slideScrollDistance) / f >= ((float) this.minSlideDistanceDp);
            if (z2) {
                forwardEventToUnderlying(motionEvent, 3);
            } else {
                forwardEventToUnderlying(motionEvent, 1);
            }
            if ((z2 || z3) && this.clickListener != null) {
                float[] adContainerCoords = toAdContainerCoords(this.downX, this.downY);
                float[] adContainerCoords2 = toAdContainerCoords(motionEvent.getX(), motionEvent.getY());
                long jCurrentTimeMillis = System.currentTimeMillis();
                this.clickListener.onOverlayClick(z3, this.downInAdArea, new TouchPoint(this.downRawX, this.downRawY, this.downEventTime, this.upRawX, this.upRawY, jCurrentTimeMillis), new TouchPoint(adContainerCoords[0], adContainerCoords[1], this.downEventTime, adContainerCoords2[0], adContainerCoords2[1], jCurrentTimeMillis), this.slideScrollDistance, this.overlayUniqueId);
            } else {
                InvalidityCheckerListener invalidityCheckerListener2 = this.invalidityChecker;
                if (invalidityCheckerListener2 != null) {
                    invalidityCheckerListener2.onInvalid(this.overlayUniqueId);
                }
            }
            return this.interceptAllEvents;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void releaseAdContainerRef() {
        View view = this.adContainerRef.get();
        if (view != null) {
            try {
                if (this.scrollChangedListener != null) {
                    view.getViewTreeObserver().removeOnScrollChangedListener(this.scrollChangedListener);
                }
                i iVar = this.layoutChangeListener;
                if (iVar != null) {
                    view.removeOnLayoutChangeListener(iVar);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.adContainerRef = new WeakReference<>(null);
        if (getVisibility() != 4) {
            setVisibility(4);
        }
    }

    public void requestPositionUpdate() {
        try {
            WeakReference<ViewGroup> weakReference = this.contentViewRef;
            ViewGroup viewGroup = weakReference != null ? weakReference.get() : null;
            if (viewGroup != null) {
                updatePosition(viewGroup);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setAttachListener(OnOverlayAttachListener onOverlayAttachListener) {
        this.attachListener = onOverlayAttachListener;
    }

    public void setExtendRatios(int i, int i2, int i3, int i4) {
        this.extendUpRatio = i / 100.0f;
        this.extendDownRatio = i2 / 100.0f;
        this.extendLeftRatio = i3 / 100.0f;
        this.extendRightRatio = i4 / 100.0f;
    }

    public void setInvalidityChecker(InvalidityCheckerListener invalidityCheckerListener) {
        this.invalidityChecker = invalidityCheckerListener;
    }

    public void setMinSlideDistanceDp(int i) {
        this.minSlideDistanceDp = i;
    }

    public void setOverlayUniqueId(String str) {
        this.overlayUniqueId = str;
    }

    public void setSlideClickEnabled(boolean z) {
        this.slideClickEnabled = z;
    }

    public void updateAdContainer(View view) {
        if (view == null) {
            return;
        }
        View view2 = this.adContainerRef.get();
        if (view2 != null) {
            if (this.scrollChangedListener != null) {
                try {
                    view2.getViewTreeObserver().removeOnScrollChangedListener(this.scrollChangedListener);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            i iVar = this.layoutChangeListener;
            if (iVar != null) {
                try {
                    view2.removeOnLayoutChangeListener(iVar);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        this.adContainerRef = new WeakReference<>(view);
        if (this.scrollChangedListener != null) {
            try {
                view.getViewTreeObserver().addOnScrollChangedListener(this.scrollChangedListener);
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
        i iVar2 = this.layoutChangeListener;
        if (iVar2 != null) {
            try {
                view.addOnLayoutChangeListener(iVar2);
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }

    private void dispatchToView(View view, MotionEvent motionEvent, int i) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int[] iArr2 = new int[2];
        getLocationOnScreen(iArr2);
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        motionEventObtain.setAction(i);
        motionEventObtain.offsetLocation(iArr2[0] - iArr[0], iArr2[1] - iArr[1]);
        view.dispatchTouchEvent(motionEventObtain);
        motionEventObtain.recycle();
    }
}
