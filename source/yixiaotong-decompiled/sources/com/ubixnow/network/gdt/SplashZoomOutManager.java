package com.ubixnow.network.gdt;

import android.R;
import android.animation.Animator;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import com.qq.e.ads.splash.SplashAD;
import com.ubixnow.ooooo.oOO00000;
import com.ubixnow.ooooo.ooooO000;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class SplashZoomOutManager {
    private static final String OooO00o = "------SplashZoomOutManager";
    private static final int OooO0O0 = 0;
    private static final int OooO0OO = 1;
    private static SplashZoomOutManager OooO0Oo;
    private int OooO;
    private int OooO0o;
    private int OooO0o0;
    private int OooO0oO;
    private int OooO0oo;
    private int OooOO0;
    private SplashAD OooOO0O;
    private View OooOO0o;
    private int OooOOO;
    private int OooOOO0;
    private int[] OooOOOO = new int[2];
    private int OooOOOo;
    private int OooOOo0;

    public interface AnimationCallBack {
        void animationEnd();

        void animationStart(int i);
    }

    private SplashZoomOutManager(Context context) {
        int iRound = Math.round(Math.min(oOO00000.OooO0o0(context), oOO00000.OooO0o(context)) * 0.3f);
        this.OooO0o0 = iRound;
        this.OooO0o = Math.round((iRound * 16) / 9);
        this.OooO0oO = oOO00000.OooO00o(6.0f);
        this.OooO0oo = oOO00000.OooO00o(100.0f);
        this.OooO = 1;
        this.OooOO0 = 300;
    }

    public static synchronized SplashZoomOutManager getInstance(Context context) {
        if (OooO0Oo == null) {
            OooO0Oo = new SplashZoomOutManager(context);
        }
        return OooO0Oo;
    }

    public void clearStaticData() {
        removeFromParent(this.OooOO0o);
        this.OooOO0O = null;
        this.OooOO0o = null;
    }

    public SplashAD getSplashAD() {
        return this.OooOO0O;
    }

    public View getSplashView(Activity activity) {
        SplashZoomOutManager splashZoomOutManager = getInstance(activity);
        ooooO000.OooO0O0(OooO00o, "---zoomOut addFloatView");
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(R.id.content);
        ooooO000.OooO0O0(OooO00o, "-----zoomOut addFloatView viewGroup " + (viewGroup != null));
        return splashZoomOutManager.startZoomOut((ViewGroup) activity.getWindow().getDecorView(), viewGroup, new AnimationCallBack() { // from class: com.ubixnow.network.gdt.SplashZoomOutManager.2
            @Override // com.ubixnow.network.gdt.SplashZoomOutManager.AnimationCallBack
            public void animationEnd() {
                if (SplashZoomOutManager.this.OooOO0O != null) {
                    SplashZoomOutManager.this.OooOO0O.zoomOutAnimationFinish();
                }
            }

            @Override // com.ubixnow.network.gdt.SplashZoomOutManager.AnimationCallBack
            public void animationStart(int i) {
            }
        });
    }

    public void removeFromParent(View view) {
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view);
            }
        }
    }

    public void setSplashInfo(SplashAD splashAD, View view, View view2) {
        this.OooOO0O = splashAD;
        this.OooOO0o = view;
        view.getLocationOnScreen(this.OooOOOO);
        this.OooOOO0 = view.getWidth();
        this.OooOOO = view.getHeight();
        this.OooOOOo = view2.getWidth();
        this.OooOOo0 = view2.getHeight();
    }

    public ViewGroup startZoomOut(final View view, ViewGroup viewGroup, final ViewGroup viewGroup2, final AnimationCallBack animationCallBack) {
        if (view == null || viewGroup2 == null) {
            return null;
        }
        Context context = viewGroup2.getContext();
        final int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int width = view.getWidth();
        int height = view.getHeight();
        int width2 = viewGroup.getWidth();
        int height2 = viewGroup.getHeight();
        if (width2 == 0) {
            width2 = this.OooOOOo;
        }
        if (height2 == 0) {
            height2 = this.OooOOo0;
        }
        int i = this.OooO0o0;
        float f = i / width;
        int i2 = this.OooO0o;
        float f2 = i2 / height;
        float f3 = this.OooO == 0 ? this.OooO0oO : (width2 - this.OooO0oO) - i;
        final float f4 = (height2 - this.OooO0oo) - i2;
        ooooO000.OooO0O0(OooO00o, "zoomOut animationContainerWidth:" + width2 + " animationContainerHeight:" + height2);
        ooooO000.OooO0O0(OooO00o, "zoomOut splashScreenX:" + iArr[0] + " splashScreenY:" + iArr[1]);
        ooooO000.OooO0O0(OooO00o, "zoomOut splashWidth:" + width + " splashHeight:" + height);
        ooooO000.OooO0O0(OooO00o, "zoomOut width:" + this.OooO0o0 + " height:" + this.OooO0o);
        ooooO000.OooO0O0(OooO00o, "zoomOut animationDistX:" + f3 + " animationDistY:" + f4);
        removeFromParent(view);
        viewGroup.addView(view, new FrameLayout.LayoutParams(width, height));
        final SplashZoomOutLayout splashZoomOutLayout = new SplashZoomOutLayout(context, this.OooO0oO);
        view.setPivotX(0.0f);
        view.setPivotY(0.0f);
        final float f5 = f3;
        view.animate().scaleX(f).scaleY(f2).x(f3).y(f4).setInterpolator(new OvershootInterpolator(0.0f)).setDuration(this.OooOO0).setListener(new Animator.AnimatorListener() { // from class: com.ubixnow.network.gdt.SplashZoomOutManager.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ooooO000.OooO0O0(SplashZoomOutManager.OooO00o, "zoomOut onAnimationEnd");
                SplashZoomOutManager.this.removeFromParent(view);
                view.setScaleX(1.0f);
                view.setScaleY(1.0f);
                view.setX(0.0f);
                view.setY(0.0f);
                int[] iArr2 = new int[2];
                viewGroup2.getLocationOnScreen(iArr2);
                float f6 = f5 - iArr2[0];
                int[] iArr3 = iArr;
                float f7 = f6 + iArr3[0];
                float f8 = (f4 - iArr2[1]) + iArr3[1];
                ooooO000.OooO0O0(SplashZoomOutManager.OooO00o, "zoomOut distX:" + f7 + " distY:" + f8);
                ooooO000.OooO0O0(SplashZoomOutManager.OooO00o, "zoomOut containerScreenX:" + iArr2[0] + " containerScreenY:" + iArr2[1]);
                splashZoomOutLayout.addView(view, -1, -1);
                viewGroup2.addView(splashZoomOutLayout, new FrameLayout.LayoutParams(SplashZoomOutManager.this.OooO0o0, SplashZoomOutManager.this.OooO0o));
                splashZoomOutLayout.setTranslationX(f7);
                splashZoomOutLayout.setTranslationY(f8);
                AnimationCallBack animationCallBack2 = animationCallBack;
                if (animationCallBack2 != null) {
                    animationCallBack2.animationEnd();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ooooO000.OooO0O0(SplashZoomOutManager.OooO00o, "zoomOut onAnimationStart");
                AnimationCallBack animationCallBack2 = animationCallBack;
                if (animationCallBack2 != null) {
                    animationCallBack2.animationStart(SplashZoomOutManager.this.OooOO0);
                }
            }
        });
        return splashZoomOutLayout;
    }

    public ViewGroup startZoomOut(ViewGroup viewGroup, ViewGroup viewGroup2, AnimationCallBack animationCallBack) {
        String str;
        ooooO000.OooO0O0(OooO00o, "zoomOut startZoomOut activity");
        if (viewGroup == null || viewGroup2 == null) {
            str = "zoomOut animationContainer or zoomOutContainer is null";
        } else if (this.OooOO0o == null) {
            str = "zoomOut   splashView is null";
        } else {
            if (this.OooOO0O != null) {
                int[] iArr = new int[2];
                viewGroup.getLocationOnScreen(iArr);
                int[] iArr2 = this.OooOOOO;
                int i = iArr2[0] - iArr[0];
                int i2 = iArr2[1] - iArr[1];
                removeFromParent(this.OooOO0o);
                viewGroup.addView(this.OooOO0o, new FrameLayout.LayoutParams(this.OooOOO0, this.OooOOO));
                this.OooOO0o.setX(i);
                this.OooOO0o.setY(i2);
                return startZoomOut(this.OooOO0o, viewGroup, viewGroup2, animationCallBack);
            }
            str = "zoomOut splashAD  is null";
        }
        ooooO000.OooO0O0(OooO00o, str);
        return null;
    }
}
