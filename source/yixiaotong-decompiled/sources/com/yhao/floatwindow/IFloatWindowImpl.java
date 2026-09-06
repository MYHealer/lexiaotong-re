package com.yhao.floatwindow;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.DecelerateInterpolator;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class IFloatWindowImpl extends IFloatWindow {
    private float downX;
    private float downY;
    private boolean isShow;
    private ValueAnimator mAnimator;
    private FloatWindow.B mB;
    private TimeInterpolator mDecelerateInterpolator;
    private FloatLifecycle mFloatLifecycle;
    private FloatView mFloatView;
    private int mSlop;
    private float upX;
    private float upY;
    private boolean once = true;
    private boolean mClick = false;

    @Override // com.yhao.floatwindow.IFloatWindow
    public boolean isShowing() {
        return this.isShow;
    }

    private IFloatWindowImpl() {
    }

    IFloatWindowImpl(FloatWindow.B b) {
        this.mB = b;
        if (b.mMoveType == 0) {
            this.mFloatView = new FloatPhone(b.mApplicationContext, this.mB.mPermissionListener);
        } else {
            this.mFloatView = new FloatPhone(b.mApplicationContext, this.mB.mPermissionListener);
            initTouchEvent();
        }
        this.mFloatView.setSize(this.mB.mWidth, this.mB.mHeight);
        this.mFloatView.setGravity(this.mB.gravity, this.mB.xOffset, this.mB.yOffset);
        this.mFloatView.setView(this.mB.mView);
        this.mFloatLifecycle = new FloatLifecycle(this.mB.mApplicationContext, this.mB.mShow, this.mB.mActivities, new LifecycleListener() { // from class: com.yhao.floatwindow.IFloatWindowImpl.1
            @Override // com.yhao.floatwindow.LifecycleListener
            public void onShow() {
                IFloatWindowImpl.this.show();
            }

            @Override // com.yhao.floatwindow.LifecycleListener
            public void onHide() {
                IFloatWindowImpl.this.hide();
            }

            @Override // com.yhao.floatwindow.LifecycleListener
            public void onBackToDesktop() {
                if (!IFloatWindowImpl.this.mB.mDesktopShow) {
                    IFloatWindowImpl.this.hide();
                }
                if (IFloatWindowImpl.this.mB.mViewStateListener != null) {
                    IFloatWindowImpl.this.mB.mViewStateListener.onBackToDesktop();
                }
            }
        });
    }

    @Override // com.yhao.floatwindow.IFloatWindow
    public void show() {
        if (this.once) {
            this.mFloatView.init();
            this.once = false;
            this.isShow = true;
        } else {
            if (this.isShow) {
                return;
            }
            getView().setVisibility(0);
            this.isShow = true;
        }
        if (this.mB.mViewStateListener != null) {
            this.mB.mViewStateListener.onShow();
        }
    }

    @Override // com.yhao.floatwindow.IFloatWindow
    public void hide() {
        if (this.once || !this.isShow) {
            return;
        }
        getView().setVisibility(4);
        this.isShow = false;
        if (this.mB.mViewStateListener != null) {
            this.mB.mViewStateListener.onHide();
        }
    }

    @Override // com.yhao.floatwindow.IFloatWindow
    void dismiss() {
        this.mFloatView.dismiss();
        this.isShow = false;
        if (this.mB.mViewStateListener != null) {
            this.mB.mViewStateListener.onDismiss();
        }
    }

    @Override // com.yhao.floatwindow.IFloatWindow
    public void updateX(int i) {
        checkMoveType();
        this.mB.xOffset = i;
        this.mFloatView.updateX(i);
    }

    @Override // com.yhao.floatwindow.IFloatWindow
    public void updateY(int i) {
        checkMoveType();
        this.mB.yOffset = i;
        this.mFloatView.updateY(i);
    }

    @Override // com.yhao.floatwindow.IFloatWindow
    public void updateX(int i, float f) {
        int screenHeight;
        checkMoveType();
        FloatWindow.B b = this.mB;
        if (i == 0) {
            screenHeight = Util.getScreenWidth(b.mApplicationContext);
        } else {
            screenHeight = Util.getScreenHeight(b.mApplicationContext);
        }
        b.xOffset = (int) (screenHeight * f);
        this.mFloatView.updateX(this.mB.xOffset);
    }

    @Override // com.yhao.floatwindow.IFloatWindow
    public void updateY(int i, float f) {
        int screenHeight;
        checkMoveType();
        FloatWindow.B b = this.mB;
        if (i == 0) {
            screenHeight = Util.getScreenWidth(b.mApplicationContext);
        } else {
            screenHeight = Util.getScreenHeight(b.mApplicationContext);
        }
        b.yOffset = (int) (screenHeight * f);
        this.mFloatView.updateY(this.mB.yOffset);
    }

    @Override // com.yhao.floatwindow.IFloatWindow
    public int getX() {
        return this.mFloatView.getX();
    }

    @Override // com.yhao.floatwindow.IFloatWindow
    public int getY() {
        return this.mFloatView.getY();
    }

    @Override // com.yhao.floatwindow.IFloatWindow
    public View getView() {
        this.mSlop = ViewConfiguration.get(this.mB.mApplicationContext).getScaledTouchSlop();
        return this.mB.mView;
    }

    private void checkMoveType() {
        if (this.mB.mMoveType == 0) {
            throw new IllegalArgumentException("FloatWindow of this tag is not allowed to move!");
        }
    }

    private void initTouchEvent() {
        if (this.mB.mMoveType != 1) {
            getView().setOnTouchListener(new View.OnTouchListener() { // from class: com.yhao.floatwindow.IFloatWindowImpl.2
                float changeX;
                float changeY;
                float lastX;
                float lastY;
                int newX;
                int newY;

                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    int action = motionEvent.getAction();
                    if (action == 0) {
                        IFloatWindowImpl.this.downX = motionEvent.getRawX();
                        IFloatWindowImpl.this.downY = motionEvent.getRawY();
                        this.lastX = motionEvent.getRawX();
                        this.lastY = motionEvent.getRawY();
                        IFloatWindowImpl.this.cancelAnimator();
                    } else if (action == 1) {
                        IFloatWindowImpl.this.upX = motionEvent.getRawX();
                        IFloatWindowImpl.this.upY = motionEvent.getRawY();
                        IFloatWindowImpl iFloatWindowImpl = IFloatWindowImpl.this;
                        iFloatWindowImpl.mClick = Math.abs(iFloatWindowImpl.upX - IFloatWindowImpl.this.downX) > ((float) IFloatWindowImpl.this.mSlop) || Math.abs(IFloatWindowImpl.this.upY - IFloatWindowImpl.this.downY) > ((float) IFloatWindowImpl.this.mSlop);
                        int i = IFloatWindowImpl.this.mB.mMoveType;
                        if (i == 3) {
                            int x = IFloatWindowImpl.this.mFloatView.getX();
                            IFloatWindowImpl.this.mAnimator = ObjectAnimator.ofInt(x, (x * 2) + view.getWidth() > Util.getScreenWidth(IFloatWindowImpl.this.mB.mApplicationContext) ? (Util.getScreenWidth(IFloatWindowImpl.this.mB.mApplicationContext) - view.getWidth()) - IFloatWindowImpl.this.mB.mSlideRightMargin : IFloatWindowImpl.this.mB.mSlideLeftMargin);
                            IFloatWindowImpl.this.mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.yhao.floatwindow.IFloatWindowImpl.2.1
                                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                                    int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                                    IFloatWindowImpl.this.mFloatView.updateX(iIntValue);
                                    if (IFloatWindowImpl.this.mB.mViewStateListener != null) {
                                        IFloatWindowImpl.this.mB.mViewStateListener.onPositionUpdate(iIntValue, (int) IFloatWindowImpl.this.upY);
                                    }
                                }
                            });
                            IFloatWindowImpl.this.startAnimator();
                        } else if (i == 4) {
                            IFloatWindowImpl.this.mAnimator = ObjectAnimator.ofPropertyValuesHolder(PropertyValuesHolder.ofInt("x", IFloatWindowImpl.this.mFloatView.getX(), IFloatWindowImpl.this.mB.xOffset), PropertyValuesHolder.ofInt("y", IFloatWindowImpl.this.mFloatView.getY(), IFloatWindowImpl.this.mB.yOffset));
                            IFloatWindowImpl.this.mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.yhao.floatwindow.IFloatWindowImpl.2.2
                                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                                    int iIntValue = ((Integer) valueAnimator.getAnimatedValue("x")).intValue();
                                    int iIntValue2 = ((Integer) valueAnimator.getAnimatedValue("y")).intValue();
                                    IFloatWindowImpl.this.mFloatView.updateXY(iIntValue, iIntValue2);
                                    if (IFloatWindowImpl.this.mB.mViewStateListener != null) {
                                        IFloatWindowImpl.this.mB.mViewStateListener.onPositionUpdate(iIntValue, iIntValue2);
                                    }
                                }
                            });
                            IFloatWindowImpl.this.startAnimator();
                        }
                    } else if (action == 2) {
                        this.changeX = motionEvent.getRawX() - this.lastX;
                        this.changeY = motionEvent.getRawY() - this.lastY;
                        this.newX = (int) (IFloatWindowImpl.this.mFloatView.getX() + this.changeX);
                        this.newY = (int) (IFloatWindowImpl.this.mFloatView.getY() + this.changeY);
                        IFloatWindowImpl.this.mFloatView.updateXY(this.newX, this.newY);
                        if (IFloatWindowImpl.this.mB.mViewStateListener != null) {
                            IFloatWindowImpl.this.mB.mViewStateListener.onPositionUpdate(this.newX, this.newY);
                        }
                        this.lastX = motionEvent.getRawX();
                        this.lastY = motionEvent.getRawY();
                    }
                    return IFloatWindowImpl.this.mClick;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startAnimator() {
        if (this.mB.mInterpolator == null) {
            if (this.mDecelerateInterpolator == null) {
                this.mDecelerateInterpolator = new DecelerateInterpolator();
            }
            this.mB.mInterpolator = this.mDecelerateInterpolator;
        }
        this.mAnimator.setInterpolator(this.mB.mInterpolator);
        this.mAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.yhao.floatwindow.IFloatWindowImpl.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                IFloatWindowImpl.this.mAnimator.removeAllUpdateListeners();
                IFloatWindowImpl.this.mAnimator.removeAllListeners();
                IFloatWindowImpl.this.mAnimator = null;
                if (IFloatWindowImpl.this.mB.mViewStateListener != null) {
                    IFloatWindowImpl.this.mB.mViewStateListener.onMoveAnimEnd();
                }
            }
        });
        this.mAnimator.setDuration(this.mB.mDuration).start();
        if (this.mB.mViewStateListener != null) {
            this.mB.mViewStateListener.onMoveAnimStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelAnimator() {
        ValueAnimator valueAnimator = this.mAnimator;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return;
        }
        this.mAnimator.cancel();
    }
}
