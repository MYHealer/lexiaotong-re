package com.yfanads.android.adx.components.base;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.yfanads.android.libs.AbsCallback;
import com.yfanads.android.utils.AdStateManager;
import com.yfanads.android.utils.ScreenUtil;
import com.yfanads.android.utils.YFLog;
import com.yfanads.android.utils.YFUtil;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: ActionTracker.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class b extends AbsCallback<a> implements View.OnAttachStateChangeListener, ViewTreeObserver.OnWindowFocusChangeListener, ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f9567a;
    public View b;
    public boolean c;
    public final int[] d;
    public int e;
    public final int f;
    public final AtomicBoolean g;
    public boolean h;

    public b(a aVar, com.yfanads.android.adx.service.a aVar2) {
        super(aVar);
        this.g = new AtomicBoolean(false);
        this.f9567a = 1;
        Context contextA = com.yfanads.android.adx.service.d.a();
        if (contextA != null) {
            int[] screenSize = ScreenUtil.getScreenSize(contextA, false);
            this.d = screenSize;
            float statusBarHeight = ScreenUtil.getStatusBarHeight(contextA);
            int navigationBarHeight = (int) ScreenUtil.getNavigationBarHeight(contextA);
            this.f = navigationBarHeight;
            if (aVar2 == com.yfanads.android.adx.service.a.SPLASH) {
                screenSize[1] = screenSize[1] + navigationBarHeight;
            }
            com.yfanads.android.adx.utils.a.a("ActionTracker statueHeight:" + statusBarHeight + " naviHeight:" + navigationBarHeight + " height:" + screenSize[1]);
        }
    }

    public final void b(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        viewGroup.removeOnAttachStateChangeListener(this);
        viewGroup.getViewTreeObserver().removeOnWindowFocusChangeListener(this);
        viewGroup.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        viewGroup.getViewTreeObserver().removeOnScrollChangedListener(this);
        YFUtil.MAIN_HANDLER.removeCallbacks(this);
        com.yfanads.android.adx.utils.a.a("ActionTracker removeViewListener success " + viewGroup.hashCode());
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        a("onGlobalLayout");
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        a("onScrollChanged");
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        com.yfanads.android.adx.utils.a.a("ActionTracker onViewDetachedFromWindow " + view.hashCode());
        this.h = false;
        view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        view.getViewTreeObserver().removeOnScrollChangedListener(this);
        this.c = true;
        YFUtil.MAIN_HANDLER.removeCallbacks(this);
        this.f9567a = 1;
        a(false);
    }

    @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
    public final void onWindowFocusChanged(boolean z) {
        com.yfanads.android.adx.utils.a.a("ActionTracker onWindowFocusChanged " + z);
        if (z) {
            a(true);
        } else if (AdStateManager.getInstance().isPushAdShowing()) {
            YFLog.debug("ActionTracker onWindowFocusChanged false but isPushAdShowing, return removeShowView");
        } else if (get() != null) {
            get().a(this.b);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        StringBuilder sb = new StringBuilder("ActionTracker checkVisibilityView: ");
        View view = this.b;
        com.yfanads.android.adx.utils.a.a(sb.append(view != null ? Integer.valueOf(view.hashCode()) : "").toString());
        if (this.b == null) {
            return;
        }
        if (this.g.get()) {
            com.yfanads.android.adx.utils.a.a("ActionTracker checkVisibilityView isPause, return.");
            return;
        }
        if (this.e == 0) {
            Rect rect = new Rect();
            this.b.getWindowVisibleDisplayFrame(rect);
            int i = rect.bottom;
            this.e = i;
            int[] iArr = this.d;
            int i2 = iArr[1] - this.f;
            if (i2 >= i) {
                iArr[1] = i2;
            }
        }
        com.yfanads.android.adx.utils.a.a("ActionTracker init: " + Arrays.toString(this.d));
        int width = this.b.getWidth();
        int height = this.b.getHeight();
        Rect rect2 = new Rect();
        int[] iArr2 = this.d;
        boolean z = false;
        int i3 = (width / 2) + iArr2[0];
        int i4 = height / 2;
        int i5 = iArr2[1] + i4;
        boolean z2 = this.b.getGlobalVisibleRect(rect2) && rect2.bottom - rect2.top >= i4;
        if (z2) {
            int[] iArr3 = new int[2];
            this.b.getLocationOnScreen(iArr3);
            int i6 = iArr3[0];
            int i7 = iArr3[1];
            if (i6 >= 0 && i6 + width <= i3 && i7 >= 0 && i7 + height <= i5) {
                z = true;
            }
            com.yfanads.android.adx.utils.a.a("ActionTracker check: " + rect2 + " half visible , [x" + i6 + "+w" + width + "|" + i3 + ",y" + i7 + "+h" + height + "|" + i5 + "] result " + z);
        } else {
            com.yfanads.android.adx.utils.a.a("ActionTracker check: " + rect2 + " half not visible");
        }
        this.f9567a = (z2 && z) ? 2 : 1;
        a(true);
    }

    public final void a(final ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        this.b = viewGroup;
        viewGroup.addOnAttachStateChangeListener(this);
        viewGroup.getViewTreeObserver().addOnWindowFocusChangeListener(this);
        viewGroup.getViewTreeObserver().addOnScrollChangedListener(this);
        viewGroup.post(new Runnable() { // from class: com.yfanads.android.adx.components.base.b$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(viewGroup);
            }
        });
        com.yfanads.android.adx.utils.a.a("ActionTracker addViewListener success " + viewGroup.hashCode());
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        this.h = true;
        com.yfanads.android.adx.utils.a.a("ActionTracker onViewAttachedToWindow " + view.hashCode());
        view.getViewTreeObserver().addOnGlobalLayoutListener(this);
        if (this.c) {
            view.getViewTreeObserver().addOnScrollChangedListener(this);
        }
    }

    public final void b(boolean z) {
        this.g.set(z);
        StringBuilder sbAppend = new StringBuilder("ActionTracker setPause ").append(this.g.get()).append("|");
        View view = this.b;
        com.yfanads.android.adx.utils.a.a(sbAppend.append(view != null ? Integer.valueOf(view.hashCode()) : "").append("|").append(Thread.currentThread().getName()).toString());
        if (z) {
            YFUtil.MAIN_HANDLER.removeCallbacks(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        try {
            if (view.getVisibility() != 0) {
                com.yfanads.android.adx.utils.a.a("ActionTracker addViewListener isGone " + view.hashCode());
            } else {
                if (!view.isAttachedToWindow() || this.h) {
                    return;
                }
                com.yfanads.android.adx.utils.a.a("ActionTracker addViewListener isAttachedToWindow " + view.hashCode());
                onViewAttachedToWindow(view);
            }
        } catch (Exception e) {
            e.getLocalizedMessage();
        }
    }

    public final void a(boolean z) {
        if (this.f9567a == 2) {
            a aVar = get();
            View view = this.b;
            synchronized (aVar) {
                if (aVar.b.contains(view)) {
                    if (z) {
                        aVar.a("addShowViewForce");
                    }
                    return;
                }
                com.yfanads.android.adx.components.model.a aVar2 = (com.yfanads.android.adx.components.model.a) aVar.f9565a.get(Integer.valueOf(view.hashCode()));
                if (aVar2 != null) {
                    aVar.b.add(aVar2.f9576a);
                }
                com.yfanads.android.adx.utils.a.a("ActionHelper addShowView " + view.hashCode() + " , " + aVar.b.size());
                aVar.a("addShowView");
                return;
            }
        }
        get().a(this.b);
    }

    public final void a(String str) {
        if (this.g.get()) {
            StringBuilder sbAppend = new StringBuilder("ActionTracker checkVisibilityViewDelay ").append(str).append("|true|");
            View view = this.b;
            com.yfanads.android.adx.utils.a.a(sbAppend.append(view != null ? Integer.valueOf(view.hashCode()) : "").append("|").append(Thread.currentThread().getName()).toString());
        } else {
            YFUtil.MAIN_HANDLER.removeCallbacks(this);
            YFUtil.MAIN_HANDLER.postDelayed(this, 100L);
        }
    }
}
