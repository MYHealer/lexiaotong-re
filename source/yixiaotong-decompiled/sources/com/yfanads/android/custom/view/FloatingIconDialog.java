package com.yfanads.android.custom.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.Keyframe;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import com.google.android.material.badge.BadgeDrawable;
import com.stub.StubApp;
import com.yfanads.ads.libs.R;
import com.yfanads.android.libs.utils.YFOptional;
import com.yfanads.android.lifecycle.DialogManager;
import com.yfanads.android.utils.ScreenUtil;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class FloatingIconDialog {
    public static final int ANIM_TYPE_BOUNCE = 2;
    public static final int ANIM_TYPE_DEFAULT = 0;
    public static final int ANIM_TYPE_NONE = 3;
    public static final int ANIM_TYPE_SPRING = 1;
    public static final int LOC_TYPE_DEFAULT = 4;
    public static final int LOC_TYPE_LB = 2;
    public static final int LOC_TYPE_LT = 1;
    public static final int LOC_TYPE_RT = 3;
    private static final int SNAP_ANIMATION_DURATION = 300;
    private static final String TAG = "FloatingIconDialog";
    private String activityLocalName;
    private boolean canDragging;
    private Context context;
    private int currentAnimType;
    private Dialog dialog;
    private View dialogView;
    private long downTime;
    private float downX;
    private float downY;
    private int initialX;
    private int initialY;
    private boolean isDragging;
    private float lastTouchX;
    private float lastTouchY;
    private int layoutId;
    private int locationType;
    private OnIconClickListener onIconClickListener;
    private int screenHeight;
    private int screenWidth;
    private int size12dp;
    private int size67dp;
    private ValueAnimator snapAnimator;
    private int statusBarHeight;
    private int tapTimeout;
    private int touchSlop;

    public static class FloatingIconBuilder {
        FloatingIconDialog dialog = new FloatingIconDialog();

        public FloatingIconDialog build() {
            return this.dialog;
        }

        public FloatingIconBuilder setAnimationType(int i) {
            this.dialog.currentAnimType = i;
            return this;
        }

        public FloatingIconBuilder setLayoutId(int i) {
            this.dialog.layoutId = i;
            return this;
        }

        public FloatingIconBuilder setLocationType(int i) {
            this.dialog.locationType = i;
            return this;
        }
    }

    public interface OnIconClickListener {
        void onIconClick();

        void onLocationType(boolean z);
    }

    private FloatingIconDialog() {
        this.isDragging = false;
        this.canDragging = true;
        this.currentAnimType = 0;
        this.locationType = 4;
    }

    private Point calculateSnapPosition(View view, int i, int i2) {
        Point point = new Point(i, i2);
        int width = (view.getWidth() / 2) + i;
        int i3 = this.screenWidth;
        point.x = width < i3 / 2 ? 0 : i3 - view.getWidth();
        int i4 = point.y;
        int i5 = this.statusBarHeight;
        if (i4 < i5) {
            point.y = i5;
        }
        int height = (this.screenHeight - view.getHeight()) - getNavigationBarHeight();
        if (point.y > height) {
            point.y = height;
        }
        return point;
    }

    private void cancelSnapAnimation() {
        ValueAnimator valueAnimator = this.snapAnimator;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return;
        }
        this.snapAnimator.cancel();
        this.snapAnimator = null;
    }

    private void createDialog(Activity activity, int i) {
        this.dialog = new ProxyDialog(activity, R.style.FloatingDialogTheme);
        this.dialogView = LayoutInflater.from(this.context).inflate(i, (ViewGroup) null);
        this.size12dp = ScreenUtil.dip2px(this.context, 12.0f);
        this.size67dp = ScreenUtil.dip2px(this.context, 67.0f);
        this.dialog.setContentView(this.dialogView);
        setupWindowParams();
        setupTouchListeners(this.dialogView);
        this.activityLocalName = activity.getLocalClassName();
        DialogManager.getInstance().registerDialog(this.activityLocalName, this.dialog);
    }

    private int getNavigationBarHeight() {
        int identifier = this.context.getResources().getIdentifier("navigation_bar_height", "dimen", "android");
        if (identifier > 0) {
            return this.context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    private void onIconClick() {
        Log.i(TAG, "onIconClick click");
        YFOptional.ofNullable(this.onIconClickListener).ifPresentRun(new YFOptional.Consumer() { // from class: com.yfanads.android.custom.view.FloatingIconDialog$$ExternalSyntheticLambda2
            @Override // com.yfanads.android.libs.utils.YFOptional.Consumer
            public final void accept(Object obj) {
                ((FloatingIconDialog.OnIconClickListener) obj).onIconClick();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: onTouchDone, reason: merged with bridge method [inline-methods] */
    public boolean m1250x8c4dffac(View view, MotionEvent motionEvent) {
        Window window = this.dialog.getWindow();
        if (window == null) {
            return false;
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        int action = motionEvent.getAction();
        if (action == 0) {
            cancelSnapAnimation();
            this.downX = motionEvent.getRawX();
            this.downY = motionEvent.getRawY();
            this.downTime = System.currentTimeMillis();
            this.lastTouchX = this.downX;
            this.lastTouchY = this.downY;
            this.initialX = attributes.x;
            this.initialY = attributes.y;
            this.isDragging = false;
            return true;
        }
        if (action == 1) {
            if (this.isDragging) {
                performSnapAnimation(view);
                this.isDragging = false;
                return true;
            }
            long jCurrentTimeMillis = System.currentTimeMillis() - this.downTime;
            float fSqrt = (float) Math.sqrt(Math.pow(motionEvent.getRawY() - this.downY, 2.0d) + Math.pow(motionEvent.getRawX() - this.downX, 2.0d));
            if (jCurrentTimeMillis >= this.tapTimeout || fSqrt >= this.touchSlop) {
                return false;
            }
            onIconClick();
            return true;
        }
        if (action != 2) {
            if (action != 3) {
                return false;
            }
            if (this.isDragging) {
                performSnapAnimation(view);
                this.isDragging = false;
            }
            return true;
        }
        float rawX = motionEvent.getRawX() - this.lastTouchX;
        float rawY = motionEvent.getRawY() - this.lastTouchY;
        if (this.canDragging && !this.isDragging && (Math.abs(rawX) > this.touchSlop || Math.abs(rawY) > this.touchSlop)) {
            this.isDragging = true;
        }
        if (this.isDragging) {
            attributes.x = this.initialX + ((int) (motionEvent.getRawX() - this.downX));
            attributes.y = this.initialY + ((int) (motionEvent.getRawY() - this.downY));
            attributes.x = Math.max(0, Math.min(attributes.x, this.screenWidth - view.getWidth()));
            attributes.y = Math.max(0, Math.min(attributes.y, this.screenHeight - view.getHeight()));
            window.setAttributes(attributes);
        }
        this.lastTouchX = motionEvent.getRawX();
        this.lastTouchY = motionEvent.getRawY();
        return true;
    }

    private void performBounceSnapAnimation(View view) {
        Window window = this.dialog.getWindow();
        if (window == null) {
            return;
        }
        final WindowManager.LayoutParams attributes = window.getAttributes();
        final int i = attributes.x;
        final int i2 = attributes.y;
        Point pointCalculateSnapPosition = calculateSnapPosition(view, i, i2);
        final int i3 = pointCalculateSnapPosition.x;
        final int i4 = pointCalculateSnapPosition.y;
        if (i == i3 && i2 == i4) {
            return;
        }
        cancelSnapAnimation();
        ValueAnimator valueAnimatorOfPropertyValuesHolder = ValueAnimator.ofPropertyValuesHolder(PropertyValuesHolder.ofKeyframe("progress", Keyframe.ofFloat(0.0f, 0.0f), Keyframe.ofFloat(0.6f, 1.05f), Keyframe.ofFloat(0.8f, 0.98f), Keyframe.ofFloat(1.0f, 1.0f)));
        this.snapAnimator = valueAnimatorOfPropertyValuesHolder;
        valueAnimatorOfPropertyValuesHolder.setDuration(600L);
        this.snapAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.yfanads.android.custom.view.FloatingIconDialog$$ExternalSyntheticLambda4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f$0.m1247x4494cc1a(attributes, i, i3, i2, i4, valueAnimator);
            }
        });
        this.snapAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.yfanads.android.custom.view.FloatingIconDialog.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                FloatingIconDialog.this.snapAnimator = null;
                FloatingIconDialog.this.updateLocationType(i3 == 0);
            }
        });
        this.snapAnimator.start();
    }

    private void performDefaultSnapAnimation(View view) {
        Window window = this.dialog.getWindow();
        if (window == null) {
            return;
        }
        final WindowManager.LayoutParams attributes = window.getAttributes();
        final int i = attributes.x;
        final int i2 = attributes.y;
        Point pointCalculateSnapPosition = calculateSnapPosition(view, i, i2);
        final int i3 = pointCalculateSnapPosition.x;
        final int i4 = pointCalculateSnapPosition.y;
        Log.d(TAG, "performDefaultSnapAnimation startX=" + i + ", startY=" + i2 + ", targetX=" + i3 + ", targetY=" + i4);
        if (i == i3 && i2 == i4) {
            updateLocationType(i3 <= this.size12dp);
            return;
        }
        cancelSnapAnimation();
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.snapAnimator = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(300L);
        this.snapAnimator.setInterpolator(new DecelerateInterpolator(1.5f));
        this.snapAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.yfanads.android.custom.view.FloatingIconDialog$$ExternalSyntheticLambda5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f$0.m1248xe3df20d(i, i3, i2, i4, attributes, valueAnimator);
            }
        });
        this.snapAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.yfanads.android.custom.view.FloatingIconDialog.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                FloatingIconDialog.this.snapAnimator = null;
                Log.d(FloatingIconDialog.TAG, "onAnimationCancel targetX: " + i3 + " targetY: " + i4);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                FloatingIconDialog.this.snapAnimator = null;
                Log.d(FloatingIconDialog.TAG, "onAnimationEnd targetX: " + i3 + " targetY: " + i4 + " size12dp" + FloatingIconDialog.this.size12dp);
                FloatingIconDialog floatingIconDialog = FloatingIconDialog.this;
                floatingIconDialog.updateLocationType(i3 <= floatingIconDialog.size12dp);
            }
        });
        this.snapAnimator.start();
    }

    private void performImmediateSnap(View view) {
        Window window = this.dialog.getWindow();
        if (window == null) {
            return;
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        Point pointCalculateSnapPosition = calculateSnapPosition(view, attributes.x, attributes.y);
        attributes.x = pointCalculateSnapPosition.x;
        attributes.y = pointCalculateSnapPosition.y;
        window.setAttributes(attributes);
        updateLocationType(pointCalculateSnapPosition.x == 0);
    }

    private void performShowAnimation(View view) {
        if (view == null) {
            return;
        }
        view.setScaleX(0.0f);
        view.setScaleY(0.0f);
        view.setAlpha(0.0f);
        view.animate().scaleX(1.0f).scaleY(1.0f).alpha(1.0f).setDuration(400L).setInterpolator(new OvershootInterpolator(1.0f)).start();
    }

    private void performSnapAnimation(View view) {
        int i = this.currentAnimType;
        if (i == 1) {
            performSpringSnapAnimation(view);
            return;
        }
        if (i == 2) {
            performBounceSnapAnimation(view);
        } else if (i != 3) {
            performDefaultSnapAnimation(view);
        } else {
            performImmediateSnap(view);
        }
    }

    private void performSpringSnapAnimation(View view) {
        Window window = this.dialog.getWindow();
        if (window == null) {
            return;
        }
        final WindowManager.LayoutParams attributes = window.getAttributes();
        final int i = attributes.x;
        final int i2 = attributes.y;
        Point pointCalculateSnapPosition = calculateSnapPosition(view, i, i2);
        final int i3 = pointCalculateSnapPosition.x;
        final int i4 = pointCalculateSnapPosition.y;
        if (i == i3 && i2 == i4) {
            return;
        }
        cancelSnapAnimation();
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.snapAnimator = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(500L);
        this.snapAnimator.setInterpolator(new OvershootInterpolator(1.2f));
        this.snapAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.yfanads.android.custom.view.FloatingIconDialog$$ExternalSyntheticLambda3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f$0.m1249xafe1c800(i, i3, i2, i4, attributes, valueAnimator);
            }
        });
        this.snapAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.yfanads.android.custom.view.FloatingIconDialog.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                FloatingIconDialog.this.snapAnimator = null;
                FloatingIconDialog.this.updateLocationType(i3 == 0);
            }
        });
        this.snapAnimator.start();
    }

    private void setupTouchListeners(View view) {
        view.setClickable(true);
        view.setFocusable(true);
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.yfanads.android.custom.view.FloatingIconDialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                return this.f$0.m1250x8c4dffac(view2, motionEvent);
            }
        });
        view.setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.android.custom.view.FloatingIconDialog$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.m1251xba269a0b(view2);
            }
        });
    }

    private void setupWindowParams() {
        int i;
        int i2;
        Window window = this.dialog.getWindow();
        if (window == null) {
            return;
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.flags = 40;
        attributes.width = -2;
        attributes.height = -2;
        attributes.gravity = BadgeDrawable.TOP_START;
        int i3 = this.locationType;
        if (i3 != 1) {
            if (i3 == 2) {
                i = (this.screenHeight * 3) / 4;
            } else if (i3 != 3) {
                i2 = this.screenWidth;
                i = (this.screenHeight * 3) / 4;
            } else {
                i2 = this.screenWidth;
                i = (this.screenHeight / 4) - this.size67dp;
            }
            attributes.x = i2;
            attributes.y = i;
            window.setAttributes(attributes);
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        i = (this.screenHeight / 4) - this.size67dp;
        i2 = 0;
        attributes.x = i2;
        attributes.y = i;
        window.setAttributes(attributes);
        window.setBackgroundDrawable(new ColorDrawable(0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLocationType(boolean z) {
        OnIconClickListener onIconClickListener = this.onIconClickListener;
        if (onIconClickListener != null) {
            onIconClickListener.onLocationType(z);
        }
    }

    public void create(Activity activity) {
        Context origApplicationContext = StubApp.getOrigApplicationContext(activity.getApplicationContext());
        this.context = origApplicationContext;
        Display defaultDisplay = ((WindowManager) origApplicationContext.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        this.screenWidth = point.x;
        this.screenHeight = point.y;
        this.touchSlop = ViewConfiguration.get(this.context).getScaledTouchSlop();
        this.tapTimeout = ViewConfiguration.getTapTimeout();
        createDialog(activity, this.layoutId);
    }

    public void dismiss() {
        Dialog dialog = this.dialog;
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        this.dialog.dismiss();
        DialogManager.getInstance().unregisterDialog(this.activityLocalName, this.dialog);
    }

    public View getDialogView() {
        return this.dialogView;
    }

    public Point getPosition() {
        Dialog dialog = this.dialog;
        if (dialog == null || dialog.getWindow() == null) {
            return new Point(0, 0);
        }
        WindowManager.LayoutParams attributes = this.dialog.getWindow().getAttributes();
        return new Point(attributes.x, attributes.y);
    }

    public boolean isShowing() {
        Dialog dialog = this.dialog;
        return dialog != null && dialog.isShowing();
    }

    /* JADX INFO: renamed from: lambda$performBounceSnapAnimation$4$com-yfanads-android-custom-view-FloatingIconDialog, reason: not valid java name */
    /* synthetic */ void m1247x4494cc1a(WindowManager.LayoutParams layoutParams, int i, int i2, int i3, int i4, ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue("progress")).floatValue();
        layoutParams.x = (int) (((i2 - i) * fFloatValue) + i);
        layoutParams.y = (int) (((i4 - i3) * fFloatValue) + i3);
        Window window = this.dialog.getWindow();
        if (window != null) {
            window.setAttributes(layoutParams);
        }
    }

    /* JADX INFO: renamed from: lambda$performDefaultSnapAnimation$2$com-yfanads-android-custom-view-FloatingIconDialog, reason: not valid java name */
    /* synthetic */ void m1248xe3df20d(int i, int i2, int i3, int i4, WindowManager.LayoutParams layoutParams, ValueAnimator valueAnimator) {
        float animatedFraction = valueAnimator.getAnimatedFraction();
        layoutParams.x = (int) (((i2 - i) * animatedFraction) + i);
        layoutParams.y = (int) (((i4 - i3) * animatedFraction) + i3);
        Window window = this.dialog.getWindow();
        if (window != null) {
            window.setAttributes(layoutParams);
        }
    }

    /* JADX INFO: renamed from: lambda$performSpringSnapAnimation$3$com-yfanads-android-custom-view-FloatingIconDialog, reason: not valid java name */
    /* synthetic */ void m1249xafe1c800(int i, int i2, int i3, int i4, WindowManager.LayoutParams layoutParams, ValueAnimator valueAnimator) {
        float animatedFraction = valueAnimator.getAnimatedFraction();
        layoutParams.x = (int) (((i2 - i) * animatedFraction) + i);
        layoutParams.y = (int) (((i4 - i3) * animatedFraction) + i3);
        Window window = this.dialog.getWindow();
        if (window != null) {
            window.setAttributes(layoutParams);
        }
    }

    /* JADX INFO: renamed from: lambda$setupTouchListeners$1$com-yfanads-android-custom-view-FloatingIconDialog, reason: not valid java name */
    /* synthetic */ void m1251xba269a0b(View view) {
        onIconClick();
    }

    public void setOnIconClickListener(OnIconClickListener onIconClickListener) {
        this.onIconClickListener = onIconClickListener;
    }

    public void show() {
        try {
            Dialog dialog = this.dialog;
            if (dialog == null || dialog.isShowing()) {
                return;
            }
            this.dialog.show();
        } catch (Exception e) {
            Log.e(TAG, "show: " + e.getMessage());
        }
    }

    public void startDragging() {
        this.canDragging = true;
    }

    public void stopDragging() {
        this.canDragging = false;
    }
}
