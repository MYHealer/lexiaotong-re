package com.ubixnow.adtype.nativead.api;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.ubixnow.core.common.ui.UMNFrameLayout;
import com.ubixnow.ooooo.o00O000;
import com.ubixnow.ooooo.o0O0oo0o;
import com.ubixnow.ooooo.o0OO0;
import com.ubixnow.ooooo.o0OO000;
import com.ubixnow.ooooo.o0OO000o;
import com.ubixnow.ooooo.o0OO0O0;
import com.ubixnow.ooooo.o0OOO00;
import com.ubixnow.ooooo.oO0000O;
import com.ubixnow.ooooo.oO0O0OoO;
import com.ubixnow.ooooo.oOO00000;
import com.ubixnow.ooooo.oo000o;
import com.ubixnow.ooooo.oo00o;
import com.ubixnow.ooooo.ooooO000;
import com.ubixnow.utils.BaseUtils;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class UMNNativeAdView extends FrameLayout {
    private static final String TAG = "UMNNativeAdView";
    private FrameLayout innerLayout;
    private boolean isClicked;
    private oo000o mAbsUbixInfo;
    public View mAdView;
    public boolean mIsInWindow;
    private onVisibleChangeListener onVisibleChangeListener;
    private Rect rect;
    private HashMap<String, String> trackExtraMap;

    public interface onVisibleChangeListener {
        void visibleChange(boolean z);
    }

    public UMNNativeAdView(Context context) {
        super(context);
        this.trackExtraMap = new HashMap<>();
        this.isClicked = false;
        this.rect = new Rect();
    }

    public UMNNativeAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.trackExtraMap = new HashMap<>();
        this.isClicked = false;
        this.rect = new Rect();
    }

    public UMNNativeAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.trackExtraMap = new HashMap<>();
        this.isClicked = false;
        this.rect = new Rect();
    }

    /* JADX WARN: Code duplicated, block: B:9:0x001b  */
    private void changeHeight(oo000o oo000oVar) {
        int i;
        if (oo000oVar != null) {
            try {
                if (oo000oVar.getBaseAdConfig() == null || oo000oVar.getBaseAdConfig().OooOOO0 == null) {
                    i = 0;
                } else {
                    i = oo000oVar.getBaseAdConfig().OooOOO0.Oooo0o;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        } else {
            i = 0;
        }
        String str = TAG;
        ooooO000.OooO0O0(str, "---offset height:" + i + " platform " + oo000oVar.getBaseAdConfig().OooO00o.OooO0OO);
        if (i > 0) {
            int iOooO00o = oOO00000.OooO00o(i) + ((UMNNativeParams) oo000oVar.getBaseAdConfig().OooO0o0).height;
            ooooO000.OooO0O0(str + "---change height:成功修改信息流模版高度" + iOooO00o);
            this.innerLayout.getLayoutParams().height = iOooO00o;
        }
    }

    private void handleCtrTracking() {
        oo000o oo000oVar = this.mAbsUbixInfo;
        if (oo000oVar != null) {
            oo000oVar.extraInfo = new HashMap<>();
            this.mAbsUbixInfo.extraInfo.put(oo00o.trackingExtraInfo, this.trackExtraMap);
        }
    }

    private ViewGroup initFramLayout() {
        UMNFrameLayout uMNFrameLayout = new UMNFrameLayout(BaseUtils.getContext());
        uMNFrameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        return uMNFrameLayout;
    }

    private void showFeedBackButton(String str) {
        try {
            if (TextUtils.isEmpty(str) || getContext() == null || !(getContext() instanceof Activity)) {
                return;
            }
            final o0OO0 o0oo0 = new o0OO0();
            o0oo0.OooOO0O = this;
            o0oo0.OooOOO = str;
            o0oo0.OooOOO0 = 2;
            o0oo0.OooOO0o = o0OO0O0.OooO.MIDDLE;
            o0oo0.OooOOOo = o0OO000.OooO00o(this.mAbsUbixInfo);
            o0oo0.OooOOOO = true;
            final o0OO0O0 o0oo0o0 = new o0OO0O0();
            BaseUtils.postDelayed(new Runnable() { // from class: com.ubixnow.adtype.nativead.api.UMNNativeAdView.1
                @Override // java.lang.Runnable
                public void run() {
                    o0oo0o0.OooO00o(o0oo0, (Activity) UMNNativeAdView.this.getContext());
                }
            }, 500L);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showShakeView(o00O000 o00o000, final View view) {
        oO0O0OoO.OooO00o oooO00o;
        ooooO000.OooO0O0(TAG, "shakeView is null? " + (view == null));
        final oO0O0OoO oo0o0ooo = o00o000.OooO00o;
        int i = oo0o0ooo.OooO0OO;
        if (i == 2) {
            return;
        }
        if (!(o00o000.OooOOO0.OoooO0 && (i == 5 || i == 3)) && oo0o0ooo.OooOO0 == 1 && view != null && (oooO00o = oo0o0ooo.OooOOoo) != null && oooO00o.OooO0OO && oooO00o.OooO0o0 > 0 && oooO00o.OooO0Oo > 0) {
            post(new Runnable() { // from class: com.ubixnow.adtype.nativead.api.UMNNativeAdView.2
                @Override // java.lang.Runnable
                public void run() {
                    if (ooooO000.OooO00o) {
                        ooooO000.OooO0O0(UMNNativeAdView.TAG, "measureHeight: " + UMNNativeAdView.this.getMeasuredHeight() + "measureWidth: " + UMNNativeAdView.this.getMeasuredWidth());
                    }
                    int[] iArrOooO00o = oO0000O.OooO00o(oO0000O.OooO00o(oo0o0ooo.OooOOoo.OooO0o0), oO0000O.OooO00o(oo0o0ooo.OooOOoo.OooO0Oo), UMNNativeAdView.this.getMeasuredHeight(), UMNNativeAdView.this.getMeasuredWidth(), oo0o0ooo.OooO0OO == 6);
                    if (iArrOooO00o != null) {
                        if (ooooO000.OooO00o) {
                            ooooO000.OooO0O0(UMNNativeAdView.TAG, "add shake view! finalWidth: " + iArrOooO00o[0] + " finalHeigth: " + iArrOooO00o[1]);
                        }
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iArrOooO00o[0], iArrOooO00o[1]);
                        layoutParams.gravity = 17;
                        UMNNativeAdView.this.addView(view, layoutParams);
                        View view2 = view;
                        if (view2 instanceof UMNNativeShakeView) {
                            ((UMNNativeShakeView) view2).changeSize(iArrOooO00o[0], iArrOooO00o[1]);
                        }
                    }
                }
            });
        }
    }

    private void unregisterView(ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            childAt.setOnClickListener(null);
            if (childAt instanceof ViewGroup) {
                unregisterView((ViewGroup) childAt);
            } else {
                childAt.setOnClickListener(null);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        try {
            if (getChildAt(getChildCount() - 1) != null && (getChildAt(getChildCount() - 1) instanceof o0OOO00)) {
                ((ImageView) getChildAt(getChildCount() - 1)).getGlobalVisibleRect(this.rect);
                if (motionEvent.getRawX() >= this.rect.left && motionEvent.getRawX() <= this.rect.right && motionEvent.getRawY() >= this.rect.top && motionEvent.getRawY() <= this.rect.bottom) {
                    return super.dispatchTouchEvent(motionEvent);
                }
            }
            if (motionEvent.getAction() == 0) {
                if (this.mAbsUbixInfo == null) {
                    return super.dispatchTouchEvent(motionEvent);
                }
                ooooO000.OooO00o(ooooO000.OooO0OO, "isExecute " + this.mAbsUbixInfo.OooO0OO);
                if (!this.mAbsUbixInfo.OooO0OO) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    oo000o oo000oVar = this.mAbsUbixInfo;
                    if (jCurrentTimeMillis - oo000oVar.OooO0Oo > 50) {
                        oo000oVar.extraInfo.put(o0OO000o.o00O00Oo, "2");
                        this.mAbsUbixInfo.OooO0Oo = System.currentTimeMillis();
                        ooooO000.OooO00o(ooooO000.OooO0OO, "check1");
                        oo000o oo000oVar2 = this.mAbsUbixInfo;
                        if (oo000oVar2.OooO0o0) {
                            oo000oVar2.OooO0o0 = o0O0oo0o.OooO00o(motionEvent, this.innerLayout, oo000oVar2);
                            ooooO000.OooO00o(ooooO000.OooO0OO, "check2" + this.mAbsUbixInfo.OooO0o0);
                            oo000o oo000oVar3 = this.mAbsUbixInfo;
                            if (oo000oVar3.OooO0o0) {
                                if (!this.isClicked) {
                                    this.isClicked = true;
                                    oo000oVar3.extraInfo.put(o0OO000o.o00O00Oo, "1");
                                }
                                this.mAbsUbixInfo.OooO0OO = true;
                                return true;
                            }
                        } else {
                            ooooO000.OooO00o(ooooO000.OooO0OO, ooooO000.OooO0OO("j10"));
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public boolean isAttachInWindow() {
        return this.mIsInWindow;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mIsInWindow = true;
        onVisibleChangeListener onvisiblechangelistener = this.onVisibleChangeListener;
        if (onvisiblechangelistener != null) {
            onvisiblechangelistener.visibleChange(true);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mIsInWindow = false;
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
    }

    public void renderGdtView(View view, oo00o oo00oVar, ViewGroup viewGroup, View view2) {
        try {
            if (oo00oVar instanceof oo000o) {
                this.mAbsUbixInfo = (oo000o) oo00oVar;
            }
            if (viewGroup == null || viewGroup.getParent() == null) {
                return;
            }
            ((ViewGroup) viewGroup.getParent()).removeView(viewGroup);
            FrameLayout frameLayout = (FrameLayout) initFramLayout();
            this.innerLayout = frameLayout;
            frameLayout.addView(viewGroup, new ViewGroup.LayoutParams(-1, -2));
            addView(this.innerLayout);
            showShakeView(oo00oVar.getBaseAdConfig(), view2);
            showFeedBackButton(oo00oVar.getBaseAdConfig().OooOOO0.Oooo0oO);
            handleCtrTracking();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void renderView(View view, oo00o oo00oVar, View view2, ViewGroup.LayoutParams layoutParams) {
        try {
            FrameLayout frameLayout = this.innerLayout;
            if (frameLayout != null) {
                frameLayout.removeAllViews();
                removeView(this.innerLayout);
            }
            if (oo00oVar instanceof oo000o) {
                this.mAbsUbixInfo = (oo000o) oo00oVar;
            }
            this.mAdView = view;
            this.innerLayout = (FrameLayout) initFramLayout();
            changeHeight(this.mAbsUbixInfo);
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(-1, -2);
            }
            this.innerLayout.addView(this.mAdView, layoutParams);
            addView(this.innerLayout);
            showShakeView(oo00oVar.getBaseAdConfig(), view2);
            showFeedBackButton(oo00oVar.getBaseAdConfig().OooOOO0.Oooo0oO);
            handleCtrTracking();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setVisibleChangeListener(onVisibleChangeListener onvisiblechangelistener) {
        this.onVisibleChangeListener = onvisiblechangelistener;
    }
}
