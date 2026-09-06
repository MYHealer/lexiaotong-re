package com.yfanads.android.custom.view;

import android.R;
import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import com.huawei.openalliance.ad.constant.br;
import com.yfanads.android.libs.utils.Util;
import com.yfanads.android.utils.AdStateManager;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class TopPushDialog extends Dialog implements Application.ActivityLifecycleCallbacks {
    private static final String TAG = "TopPushAdDialog";
    private long actualExposureTime;
    public int checkTimes;
    private int closeId;
    private OnDismissListener dismissListener;
    private ScheduledExecutorService executorService;
    private int height;
    public boolean isClickClose;
    private boolean isExposureCallbackCalled;
    private boolean isPaused;
    private boolean isShutDown;
    private boolean isSwipeToDismissEnabled;
    private int layoutId;
    public Activity mActivity;
    private AnimationType mAnimationType;
    private View mConvertView;
    private DialogBindData mDialogBindData;
    private int mOffsetTop;
    private ScheduledFuture<?> scheduledFuture;
    private long startTime;
    private int width;

    public static class Builder {
        public int closeId;
        private final Context context;
        public boolean isClickClose;
        public int layoutId;
        public int offsetTop;
        private boolean swipeToDismiss = true;
        private int width = -1;
        private int height = -2;
        public String tag = "default";
        public AnimationType animationType = AnimationType.FROM_TOP;

        public Builder(Context context) {
            this.context = context;
        }

        public TopPushDialog build() {
            TopPushDialog topPushDialog = new TopPushDialog(this.context);
            topPushDialog.setLayoutId(this.layoutId);
            topPushDialog.setCloseId(this.closeId);
            topPushDialog.isClickClose(this.isClickClose);
            topPushDialog.setWidth(this.width);
            topPushDialog.setHeight(this.height);
            topPushDialog.setOffsetTop(this.offsetTop);
            topPushDialog.setSwipeToDismissEnabled(this.swipeToDismiss);
            topPushDialog.setAnimationType(this.animationType);
            return topPushDialog;
        }

        public Builder setAnimationType(AnimationType animationType) {
            this.animationType = animationType;
            return this;
        }

        public Builder setClickClose(boolean z) {
            this.isClickClose = z;
            return this;
        }

        public Builder setCloseId(int i) {
            this.closeId = i;
            return this;
        }

        public Builder setLayoutId(int i) {
            this.layoutId = i;
            return this;
        }

        public Builder setOffsetTop(int i) {
            this.offsetTop = i;
            return this;
        }

        public Builder setSize(int i, int i2) {
            this.width = i;
            this.height = i2;
            return this;
        }

        public Builder setSwipeToDismiss(boolean z) {
            this.swipeToDismiss = z;
            return this;
        }

        public Builder setTag(String str) {
            this.tag = str;
            return this;
        }
    }

    public static class CustomSwipeLayout extends FrameLayout {
        private static final int SWIPE_THRESHOLD = 100;
        private Runnable dismissListener;
        private boolean isSwiping;
        private boolean isTopShow;
        private float startY;

        public CustomSwipeLayout(Context context) {
            super(context);
            this.isSwiping = false;
            this.isTopShow = true;
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.startY = motionEvent.getY();
                this.isSwiping = false;
            } else if (action == 2 && !this.isSwiping) {
                float y = motionEvent.getY() - this.startY;
                if (!this.isTopShow ? y > 100.0f : y < -100.0f) {
                    this.isSwiping = true;
                    return true;
                }
            }
            return super.onInterceptTouchEvent(motionEvent);
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            Runnable runnable;
            if (!this.isSwiping) {
                return super.onTouchEvent(motionEvent);
            }
            if (motionEvent.getAction() == 1 && (runnable = this.dismissListener) != null) {
                runnable.run();
            }
            return true;
        }

        public void setSwipeDismissListener(Runnable runnable) {
            this.dismissListener = runnable;
        }

        public void setTopShow(boolean z) {
            this.isTopShow = z;
        }
    }

    public interface DialogBindData {
        void actualExposureTime();

        void bindViewData(View view);

        ViewGroup getRootView();
    }

    public interface OnDismissListener {
        void onDismiss();
    }

    public TopPushDialog(Context context) {
        super(context, R.style.Theme.DeviceDefault.Light.NoActionBar.TranslucentDecor);
        this.isSwipeToDismissEnabled = true;
        this.mAnimationType = AnimationType.FROM_TOP;
        this.width = -1;
        this.height = -2;
        this.isExposureCallbackCalled = false;
        this.isPaused = false;
    }

    public TopPushDialog(Context context, int i) {
        super(context, i);
        this.isSwipeToDismissEnabled = true;
        this.mAnimationType = AnimationType.FROM_TOP;
        this.width = -1;
        this.height = -2;
        this.isExposureCallbackCalled = false;
        this.isPaused = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkWithWait() {
        Activity activity = this.mActivity;
        if (activity != null) {
            if (activity.getWindow() != null && this.mActivity.getWindow().getDecorView().getVisibility() == 0) {
                Log.i(TAG, "checkWithWait activity is visible and show, checkTimes: " + this.checkTimes);
                reallyShow();
                return;
            }
            Log.i(TAG, "checkWithWait activity is not visible and waite, checkTimes: " + this.checkTimes);
            int i = this.checkTimes;
            if (i >= 10) {
                this.mActivity.getApplication().registerActivityLifecycleCallbacks(this);
            } else {
                this.checkTimes = i + 1;
                Util.MAIN_HANDLER.postDelayed(new Runnable() { // from class: com.yfanads.android.custom.view.TopPushDialog$$ExternalSyntheticLambda4
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.checkWithWait();
                    }
                }, 100L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismissWithAnimation() {
        Util.MAIN_HANDLER.post(new Runnable() { // from class: com.yfanads.android.custom.view.TopPushDialog$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m1254xc73c9625();
            }
        });
    }

    private void ensureExecutorService() {
        ScheduledExecutorService scheduledExecutorService = this.executorService;
        if (scheduledExecutorService == null || scheduledExecutorService.isShutdown()) {
            this.executorService = Executors.newSingleThreadScheduledExecutor();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void realDismiss() {
        AdStateManager.getInstance().setPushAdShowing(false);
        OnDismissListener onDismissListener = this.dismissListener;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
        Log.d(TAG, "onDismiss");
        if (this.mDialogBindData != null) {
            this.mDialogBindData = null;
        }
        shutdown();
        Activity activity = this.mActivity;
        if (activity != null) {
            activity.getApplication().unregisterActivityLifecycleCallbacks(this);
        }
        this.mActivity = null;
    }

    private void reallyShow() {
        Log.i(TAG, "reallyShow isClickClose " + this.isClickClose);
        try {
            show();
            if (this.isClickClose) {
                this.executorService = Executors.newSingleThreadScheduledExecutor();
                startDetection();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void removeFromParent(View view) {
        if (view.getParent() instanceof ViewGroup) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scheduleWithFixedDelay() {
        if (isShowing()) {
            if (this.isPaused) {
                this.startTime = System.currentTimeMillis();
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j = jCurrentTimeMillis - this.startTime;
            if (j > 0) {
                this.actualExposureTime += j;
            }
            this.startTime = jCurrentTimeMillis;
            if (this.actualExposureTime < 1000 || this.isExposureCallbackCalled) {
                return;
            }
            this.isExposureCallbackCalled = true;
            if (this.mDialogBindData != null) {
                Util.MAIN_HANDLER.post(new Runnable() { // from class: com.yfanads.android.custom.view.TopPushDialog$$ExternalSyntheticLambda3
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.m1256x5aa8effc();
                    }
                });
            }
        }
    }

    private void setupSwipeToDismiss(View view) {
        if (this.isSwipeToDismissEnabled && (view instanceof ViewGroup)) {
            CustomSwipeLayout customSwipeLayout = new CustomSwipeLayout(view.getContext());
            customSwipeLayout.setSwipeDismissListener(new Runnable() { // from class: com.yfanads.android.custom.view.TopPushDialog$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.dismissWithAnimation();
                }
            });
            customSwipeLayout.setTopShow(this.mAnimationType == AnimationType.FROM_TOP);
            ViewGroup viewGroup = (ViewGroup) this.mConvertView.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.mConvertView);
                customSwipeLayout.addView(this.mConvertView);
                viewGroup.addView(customSwipeLayout);
            }
        }
    }

    public TopPushDialog bindData(DialogBindData dialogBindData) {
        this.mDialogBindData = dialogBindData;
        return this;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        if (this.mConvertView == null) {
            realDismiss();
            super.dismiss();
        } else {
            Animation animationLoadAnimation = AnimationUtils.loadAnimation(getContext(), this.mAnimationType == AnimationType.FROM_TOP ? com.yfanads.ads.libs.R.anim.slide_out_to_top_notification : com.yfanads.ads.libs.R.anim.slide_out_to_bottom_notification);
            animationLoadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.yfanads.android.custom.view.TopPushDialog.1
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    TopPushDialog.this.realDismiss();
                    TopPushDialog.super.dismiss();
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }
            });
            this.mConvertView.startAnimation(animationLoadAnimation);
        }
    }

    public void isClickClose(boolean z) {
        this.isClickClose = z;
    }

    /* JADX INFO: renamed from: lambda$dismissWithAnimation$2$com-yfanads-android-custom-view-TopPushDialog, reason: not valid java name */
    /* synthetic */ void m1254xc73c9625() {
        OnDismissListener onDismissListener = this.dismissListener;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
        dismiss();
    }

    /* JADX INFO: renamed from: lambda$onCreate$0$com-yfanads-android-custom-view-TopPushDialog, reason: not valid java name */
    /* synthetic */ void m1255lambda$onCreate$0$comyfanadsandroidcustomviewTopPushDialog(View view) {
        realDismiss();
    }

    /* JADX INFO: renamed from: lambda$scheduleWithFixedDelay$1$com-yfanads-android-custom-view-TopPushDialog, reason: not valid java name */
    /* synthetic */ void m1256x5aa8effc() {
        try {
            DialogBindData dialogBindData = this.mDialogBindData;
            if (dialogBindData != null) {
                dialogBindData.actualExposureTime();
            }
            shutdown();
        } catch (Exception e) {
            Log.e(TAG, "Error calling actualExposureTime callback", e);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        if (activity == this.mActivity) {
            pauseDetection();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        Activity activity2 = this.mActivity;
        if (activity == activity2) {
            try {
                activity2.getApplication().unregisterActivityLifecycleCallbacks(this);
                resumeDetection();
                reallyShow();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        View viewFindViewById;
        View view;
        super.onCreate(bundle);
        requestWindowFeature(1);
        Window window = getWindow();
        if (window != null) {
            AnimationType animationType = this.mAnimationType;
            AnimationType animationType2 = AnimationType.FROM_TOP;
            if (animationType == animationType2) {
                window.setGravity(49);
            } else {
                window.setGravity(81);
            }
            window.clearFlags(2);
            window.setBackgroundDrawableResource(R.color.transparent);
            window.setFlags(32, 32);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = this.width;
            attributes.height = this.height;
            if (this.mAnimationType == animationType2) {
                attributes.gravity = 49;
            } else {
                attributes.gravity = 81;
            }
            attributes.y = this.mOffsetTop;
            window.setAttributes(attributes);
        }
        if (this.layoutId > 0) {
            View viewInflate = LayoutInflater.from(getContext()).inflate(this.layoutId, (ViewGroup) null);
            this.mConvertView = viewInflate;
            if (viewInflate != null) {
                DialogBindData dialogBindData = this.mDialogBindData;
                if (dialogBindData != null) {
                    ViewGroup rootView = dialogBindData.getRootView();
                    if (rootView != null) {
                        removeFromParent(this.mConvertView);
                        ViewGroup.LayoutParams layoutParams = this.mConvertView.getLayoutParams();
                        rootView.addView(this.mConvertView);
                        if (layoutParams != null) {
                            this.mConvertView.setLayoutParams(layoutParams);
                        }
                        this.mDialogBindData.bindViewData(rootView);
                        view = rootView;
                    } else {
                        this.mDialogBindData.bindViewData(this.mConvertView);
                        view = this.mConvertView;
                    }
                    setContentView(view);
                }
                setupSwipeToDismiss(this.mConvertView);
                int i = this.closeId;
                if (i <= 0 || (viewFindViewById = this.mConvertView.findViewById(i)) == null) {
                    return;
                }
                viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.android.custom.view.TopPushDialog$$ExternalSyntheticLambda2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        this.f$0.m1255lambda$onCreate$0$comyfanadsandroidcustomviewTopPushDialog(view2);
                    }
                });
            }
        }
    }

    public void pauseDetection() {
        if (!this.isClickClose || this.isShutDown) {
            return;
        }
        this.isPaused = true;
        ScheduledFuture<?> scheduledFuture = this.scheduledFuture;
        if (scheduledFuture == null || scheduledFuture.isCancelled()) {
            return;
        }
        this.scheduledFuture.cancel(false);
        this.scheduledFuture = null;
    }

    public void resumeDetection() {
        if (!this.isClickClose || this.isShutDown) {
            return;
        }
        this.isPaused = false;
        ScheduledFuture<?> scheduledFuture = this.scheduledFuture;
        if (scheduledFuture == null || scheduledFuture.isCancelled()) {
            startDetection();
        }
        ensureExecutorService();
        startDetection();
    }

    public void setAnimationType(AnimationType animationType) {
        this.mAnimationType = animationType;
    }

    public void setCloseId(int i) {
        this.closeId = i;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public void setLayoutId(int i) {
        this.layoutId = i;
    }

    public void setOffsetTop(int i) {
        this.mOffsetTop = i;
    }

    public void setOnDismissListener(OnDismissListener onDismissListener) {
        this.dismissListener = onDismissListener;
    }

    public void setSwipeToDismissEnabled(boolean z) {
        this.isSwipeToDismissEnabled = z;
    }

    public void setWidth(int i) {
        this.width = i;
    }

    @Override // android.app.Dialog
    public void show() {
        AdStateManager.getInstance().setPushAdShowing(true);
        super.show();
        Log.d(TAG, br.b.V);
        if (this.mConvertView != null) {
            this.mConvertView.startAnimation(AnimationUtils.loadAnimation(getContext(), this.mAnimationType == AnimationType.FROM_TOP ? com.yfanads.ads.libs.R.anim.slide_in_from_top_notification : com.yfanads.ads.libs.R.anim.slide_in_from_bottom_notification));
        }
    }

    public void show(Activity activity) {
        this.mActivity = activity;
        checkWithWait();
    }

    public void shutdown() {
        ScheduledExecutorService scheduledExecutorService;
        try {
            this.isExposureCallbackCalled = true;
            this.isPaused = true;
            ScheduledFuture<?> scheduledFuture = this.scheduledFuture;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(true);
                this.scheduledFuture = null;
            }
            if (this.isClickClose && (scheduledExecutorService = this.executorService) != null) {
                scheduledExecutorService.shutdownNow();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.isShutDown = true;
    }

    public void startDetection() {
        ScheduledFuture<?> scheduledFuture = this.scheduledFuture;
        if (scheduledFuture == null || scheduledFuture.isCancelled()) {
            ScheduledExecutorService scheduledExecutorService = this.executorService;
            if (scheduledExecutorService != null) {
                this.scheduledFuture = scheduledExecutorService.scheduleWithFixedDelay(new Runnable() { // from class: com.yfanads.android.custom.view.TopPushDialog$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.scheduleWithFixedDelay();
                    }
                }, 0L, 100L, TimeUnit.MILLISECONDS);
            }
            this.startTime = System.currentTimeMillis();
            this.isPaused = false;
        }
    }
}
