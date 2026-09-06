package com.yfanads.android.strategy;

import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.view.View;
import android.view.ViewTreeObserver;
import com.yfanads.android.core.b;
import com.yfanads.android.libs.AbsCallback;
import com.yfanads.android.utils.ScreenUtil;
import com.yfanads.android.utils.YFLog;
import com.yfanads.android.utils.YFUtil;
import java.util.Arrays;

/* JADX INFO: compiled from: AdViewTrackerImpl.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class b<T extends com.yfanads.android.core.b> extends AbsCallback<T> implements com.yfanads.android.core.a, Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f9678a;
    public long b;
    public View c;
    public int d;
    public boolean e;
    public String f;
    public int[] g;
    public int h;
    public int i;

    public b(T t) {
        super(t);
        this.f9678a = "AdViewTrackerImpl";
        this.e = false;
        this.f9678a = "AdViewTrackerImpl|" + hashCode();
        this.d = 1;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        YFLog.debug(this.f9678a + " onViewAttachedToWindow ");
        this.b = System.currentTimeMillis();
        view.getViewTreeObserver().addOnGlobalLayoutListener(this);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        YFLog.debug(this.f9678a + " onViewDetachedFromWindow ");
        a();
        view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }

    @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
    public final void onWindowFocusChanged(boolean z) {
        YFLog.debug(this.f9678a + " onWindowFocusChanged " + z);
        if (z) {
            this.b = System.currentTimeMillis();
        } else {
            a();
        }
    }

    public final void a(View view) {
        if (view != null) {
            this.c = view;
            Context context = view.getContext();
            this.g = ScreenUtil.getScreenSize(context, false);
            this.i = (int) ScreenUtil.getNavigationBarHeight(context);
            view.addOnAttachStateChangeListener(this);
            view.getViewTreeObserver().addOnWindowFocusChangeListener(this);
            view.getViewTreeObserver().addOnScrollChangedListener(this);
            view.postDelayed(new Runnable() { // from class: com.yfanads.android.strategy.b$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.b();
                }
            }, 100L);
            this.e = true;
            com.yfanads.android.core.e.a(new StringBuilder(), this.f9678a, " addListener success");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        this.f = "addViewListener";
        Handler handler = YFUtil.MAIN_HANDLER;
        handler.removeCallbacks(this);
        handler.postDelayed(this, 100L);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        this.f = "onGlobalLayout";
        Handler handler = YFUtil.MAIN_HANDLER;
        handler.removeCallbacks(this);
        handler.postDelayed(this, 100L);
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        this.f = "onScrollChanged";
        Handler handler = YFUtil.MAIN_HANDLER;
        handler.removeCallbacks(this);
        handler.postDelayed(this, 100L);
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str = this.f;
        if (this.d == 3) {
            YFLog.debug(str + " has expose, return.");
            return;
        }
        View view = this.c;
        if (view == null) {
            YFLog.warn(str + " showView is null, return.");
            return;
        }
        try {
            b(view);
            int width = this.c.getWidth();
            int height = this.c.getHeight();
            Rect rect = new Rect();
            int[] iArr = this.g;
            boolean z = false;
            int i = iArr[0] + (width / 2);
            int i2 = iArr[1] + (height / 2);
            boolean z2 = this.c.getGlobalVisibleRect(rect) && rect.bottom - rect.top >= height / 2;
            if (z2) {
                int[] iArr2 = new int[2];
                this.c.getLocationOnScreen(iArr2);
                int i3 = iArr2[0];
                int i4 = iArr2[1];
                if (i3 >= 0 && i3 + width <= i && i4 >= 0 && i4 + height <= i2) {
                    z = true;
                }
                YFLog.debug(this.f9678a + " check: " + rect + " half visible , [x" + i3 + "+w" + width + "|" + i + ",y" + i4 + "+h" + height + "|" + i2 + "] result " + z);
            } else {
                YFLog.debug(this.f9678a + " check: " + rect + " half not visible");
            }
            if (z2 && z) {
                this.d = 2;
                a();
            }
        } catch (Exception e) {
            com.yfanads.android.core.f.a(e, new StringBuilder("checkVisibilityView "));
        }
    }

    public final void c() {
        View view = this.c;
        if (view == null || !this.e) {
            return;
        }
        view.removeOnAttachStateChangeListener(this);
        ViewTreeObserver viewTreeObserver = this.c.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnWindowFocusChangeListener(this);
            viewTreeObserver.removeOnGlobalLayoutListener(this);
            viewTreeObserver.removeOnScrollChangedListener(this);
        }
        YFUtil.MAIN_HANDLER.removeCallbacks(this);
        this.c = null;
        this.e = false;
        com.yfanads.android.core.d.a(new StringBuilder(), this.f9678a, " removeViewListener finished & showView nulled");
    }

    public final void b(View view) {
        if (this.h == 0) {
            Rect rect = new Rect();
            view.getWindowVisibleDisplayFrame(rect);
            int i = rect.bottom;
            this.h = i;
            int[] iArr = this.g;
            int i2 = iArr[1] - this.i;
            if (i2 >= i) {
                iArr[1] = i2;
            }
        }
        YFLog.debug(this.f9678a + " init: " + Arrays.toString(this.g));
    }

    public final void a() {
        if (get() == null) {
            YFLog.warn(this.f + " get() is null, return.");
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - this.b;
        if (this.d == 2) {
            this.d = 3;
            get().collectExposureData(jCurrentTimeMillis);
        }
    }
}
