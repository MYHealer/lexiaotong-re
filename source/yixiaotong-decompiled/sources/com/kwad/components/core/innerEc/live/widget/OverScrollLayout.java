package com.kwad.components.core.innerEc.live.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.NestedScrollingParentHelper;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class OverScrollLayout extends FrameLayout implements NestedScrollingParent2 {
    private boolean aap;
    private boolean aaq;
    private boolean aar;
    private a aas;
    private b aat;
    public com.kwad.components.core.innerEc.live.widget.a<ScrollState> aau;
    private OverScrollType aav;
    private final NestedScrollingParentHelper mNestedScrollingParentHelper;
    private ValueAnimator mn;

    public enum OverScrollType {
        ONLY_UP_DRAG,
        ONLY_DOWN_DRAG,
        BOTH_UP_AND_DOWN_DRAG,
        NONE;

        public final boolean isDownDragEnable() {
            return this == ONLY_DOWN_DRAG || this == BOTH_UP_AND_DOWN_DRAG;
        }

        public final boolean isUpDragEnable() {
            return this == ONLY_UP_DRAG || this == BOTH_UP_AND_DOWN_DRAG;
        }
    }

    public enum ScrollState {
        START_REFRESHING,
        REFRESHING,
        SCROLL_UP,
        SCROLL_DOWN,
        START_LOAD_MORE,
        LOADING_MORE
    }

    public interface a {
    }

    public interface b {
        boolean tk();
    }

    public boolean getIsNeedControlBounceBack() {
        return this.aar;
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(View view, float f, float f2) {
        return false;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public boolean onStartNestedScroll(View view, View view2, int i, int i2) {
        this.aap = this.aap || i2 == 0;
        this.aaq = this.aaq || i2 == 1;
        return (i & 2) != 0;
    }

    public void setIsNeedControlBounceBack(boolean z) {
        this.aar = z;
    }

    public void setOnTargetViewOffsetListener(a aVar) {
        this.aas = aVar;
    }

    public void setOnTargetViewStopListener(b bVar) {
        this.aat = bVar;
    }

    public void setOverScrollType(OverScrollType overScrollType) {
        this.aav = overScrollType;
    }

    static /* synthetic */ int a(OverScrollLayout overScrollLayout, View view, float f) {
        return b(view, f);
    }

    public OverScrollLayout(Context context) {
        super(context);
        this.aap = false;
        this.aaq = false;
        this.aau = com.kwad.components.core.innerEc.live.widget.a.h(null);
        this.aav = OverScrollType.BOTH_UP_AND_DOWN_DRAG;
        this.mNestedScrollingParentHelper = new NestedScrollingParentHelper(this);
    }

    public OverScrollLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aap = false;
        this.aaq = false;
        this.aau = com.kwad.components.core.innerEc.live.widget.a.h(null);
        this.aav = OverScrollType.BOTH_UP_AND_DOWN_DRAG;
        this.mNestedScrollingParentHelper = new NestedScrollingParentHelper(this);
    }

    public OverScrollLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aap = false;
        this.aaq = false;
        this.aau = com.kwad.components.core.innerEc.live.widget.a.h(null);
        this.aav = OverScrollType.BOTH_UP_AND_DOWN_DRAG;
        this.mNestedScrollingParentHelper = new NestedScrollingParentHelper(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        tj();
    }

    private void tj() {
        ValueAnimator valueAnimator = this.mn;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.mn.removeAllListeners();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(View view, View view2, int i) {
        return onStartNestedScroll(view, view2, i, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(View view, View view2, int i) {
        onNestedScrollAccepted(view, view2, i, 0);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScrollAccepted(View view, View view2, int i, int i2) {
        this.mNestedScrollingParentHelper.onNestedScrollAccepted(view, view2, i, i2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(View view) {
        onStopNestedScroll(view, 0);
    }

    @Override // android.view.View
    public boolean canScrollVertically(int i) {
        if (this.aav.isDownDragEnable()) {
            return i < 0;
        }
        return this.aav.isUpDragEnable() && i > 0;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onStopNestedScroll(View view, int i) {
        this.mNestedScrollingParentHelper.onStopNestedScroll(view, i);
        if (i == 0) {
            this.aap = false;
        }
        if (i == 1) {
            this.aaq = false;
        }
        if (this.aap || this.aaq || view.getTranslationY() == 0.0f) {
            return;
        }
        if (this.aar) {
            b bVar = this.aat;
            if (bVar != null) {
                view.getTranslationY();
                if (bVar.tk()) {
                    return;
                }
            }
            z(view);
            return;
        }
        z(view);
    }

    private void z(final View view) {
        float translationY = view.getTranslationY();
        tj();
        final boolean z = translationY < 0.0f;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(c(view, translationY), 0.0f);
        this.mn = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(300L);
        this.mn.setInterpolator(new DecelerateInterpolator());
        this.mn.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.core.innerEc.live.widget.OverScrollLayout.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                Float f = (Float) valueAnimator.getAnimatedValue();
                OverScrollLayout overScrollLayout = OverScrollLayout.this;
                View view2 = view;
                overScrollLayout.k(view2, OverScrollLayout.a(overScrollLayout, view2, f.floatValue()) * (z ? -1 : 1));
            }
        });
        this.mn.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.core.innerEc.live.widget.OverScrollLayout.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                OverScrollLayout.this.k(view, 0);
            }
        });
        this.mn.start();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        onNestedPreScroll(view, i, i2, iArr, 0);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr, int i3) {
        int translationY = (int) view.getTranslationY();
        if (translationY > 0 && i2 > 0) {
            if (translationY - i2 <= 0) {
                i2 = translationY;
            }
            iArr[1] = i2;
            k(view, translationY - i2);
            return;
        }
        if (translationY >= 0 || i2 >= 0) {
            return;
        }
        if (translationY - i2 >= 0) {
            i2 = translationY;
        }
        iArr[1] = i2;
        k(view, translationY - i2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        onNestedScroll(view, i, i2, i3, i4, 0);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScroll(View view, int i, int i2, int i3, int i4, int i5) {
        a(view, i2, i4, i5, new int[2]);
    }

    private void a(View view, int i, int i2, int i3, int[] iArr) {
        if (i3 != 0) {
            return;
        }
        int translationY = (int) view.getTranslationY();
        if (translationY == 0) {
            if (i2 < 0) {
                this.aau.onNext(ScrollState.START_REFRESHING);
            } else if (i2 != 0) {
                this.aau.onNext(ScrollState.START_LOAD_MORE);
            } else if (i >= 0) {
                this.aau.onNext(ScrollState.SCROLL_DOWN);
            } else {
                this.aau.onNext(ScrollState.SCROLL_UP);
            }
        } else if (translationY > 0) {
            this.aau.onNext(ScrollState.REFRESHING);
        } else {
            this.aau.onNext(ScrollState.LOADING_MORE);
        }
        if (translationY >= 0 && i2 < 0) {
            if (this.aav.isDownDragEnable()) {
                iArr[1] = i2;
                k(view, b(view, (-c(view, translationY)) + i2));
                return;
            } else {
                getParent().requestDisallowInterceptTouchEvent(false);
                return;
            }
        }
        if (translationY > 0 || i2 <= 0) {
            return;
        }
        if (this.aav.isUpDragEnable()) {
            iArr[1] = i2;
            k(view, -b(view, c(view, translationY) + i2));
        } else {
            getParent().requestDisallowInterceptTouchEvent(false);
        }
    }

    private static int b(View view, float f) {
        float height = view.getHeight();
        float f2 = 1.8f * height;
        return (int) (height - ((f2 * height) / (Math.abs(f) + f2)));
    }

    private static int c(View view, float f) {
        float height = view.getHeight();
        float f2 = 1.8f * height;
        return (int) (((f2 * height) / (height - Math.abs(f))) - f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(View view, int i) {
        view.setTranslationY(i);
    }

    public void setEnableOverScroll(boolean z) {
        setOverScrollMode(z ? 0 : 2);
    }
}
