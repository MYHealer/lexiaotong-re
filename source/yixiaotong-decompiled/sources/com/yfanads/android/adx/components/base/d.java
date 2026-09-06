package com.yfanads.android.adx.components.base;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import com.huawei.openalliance.ad.constant.x;
import com.yfanads.android.adx.components.base.c;
import com.yfanads.android.utils.ScreenUtil;
import com.yfanads.android.utils.YFLog;
import com.yfanads.android.utils.YFUtil;
import java.util.Arrays;

/* JADX INFO: compiled from: AdViewTrackerImpl.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class d<T extends c> implements View.OnAttachStateChangeListener, ViewTreeObserver.OnWindowFocusChangeListener, ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f9568a;
    public long b;
    public String e;
    public int[] f;
    public int g;
    public int h;
    public View i;
    public T j;
    public boolean d = false;
    public int c = 1;

    public d(T t) {
        this.f9568a = "AdxViewTracker";
        this.j = t;
        this.f9568a = "AdxViewTracker|" + hashCode();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        YFLog.debug(this.f9568a + " onViewAttachedToWindow ");
        this.b = System.currentTimeMillis();
        view.getViewTreeObserver().addOnGlobalLayoutListener(this);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        YFLog.debug(this.f9568a + " onViewDetachedFromWindow ");
        long jCurrentTimeMillis = System.currentTimeMillis() - this.b;
        if (this.c == 2) {
            this.c = 3;
            T t = this.j;
            if (t != null) {
                t.collectExposureData(jCurrentTimeMillis);
                this.j = null;
            }
        }
        view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }

    @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
    public final void onWindowFocusChanged(boolean z) {
        YFLog.debug(this.f9568a + " onWindowFocusChanged " + z);
        if (z) {
            this.b = System.currentTimeMillis();
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - this.b;
        if (this.c == 2) {
            this.c = 3;
            T t = this.j;
            if (t != null) {
                t.collectExposureData(jCurrentTimeMillis);
                this.j = null;
            }
        }
    }

    public final void a(View view) {
        if (view != null) {
            this.i = view;
            Context context = view.getContext();
            this.f = ScreenUtil.getScreenSize(context, false);
            this.h = (int) ScreenUtil.getNavigationBarHeight(context);
            view.addOnAttachStateChangeListener(this);
            view.getViewTreeObserver().addOnWindowFocusChangeListener(this);
            view.getViewTreeObserver().addOnScrollChangedListener(this);
            view.post(new Runnable() { // from class: com.yfanads.android.adx.components.base.d$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.a();
                }
            });
            this.d = true;
            YFLog.high(this.f9568a + " addListener success");
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str = this.e;
        if (a(str, this.i)) {
            YFLog.debug(str + " isVisibilityView success.");
            this.c = 2;
            long jCurrentTimeMillis = System.currentTimeMillis() - this.b;
            if (this.c == 2) {
                this.c = 3;
                T t = this.j;
                if (t != null) {
                    t.collectExposureData(jCurrentTimeMillis);
                    this.j = null;
                }
            }
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        this.e = "onGlobalLayout";
        YFUtil.MAIN_HANDLER.removeCallbacks(this);
        YFUtil.MAIN_HANDLER.postDelayed(this, 100L);
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        this.e = "onScrollChanged";
        YFUtil.MAIN_HANDLER.removeCallbacks(this);
        YFUtil.MAIN_HANDLER.postDelayed(this, 100L);
    }

    public final void b() {
        View view = this.i;
        if (view == null || !this.d) {
            return;
        }
        view.removeOnAttachStateChangeListener(this);
        ViewTreeObserver viewTreeObserver = this.i.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnWindowFocusChangeListener(this);
            viewTreeObserver.removeOnGlobalLayoutListener(this);
            viewTreeObserver.removeOnScrollChangedListener(this);
        }
        YFUtil.MAIN_HANDLER.removeCallbacks(this);
        this.i = null;
        this.d = false;
        YFLog.debug(this.f9568a + " removeViewListener finished & showView nulled");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        this.e = "addViewListener";
        YFUtil.MAIN_HANDLER.removeCallbacks(this);
        YFUtil.MAIN_HANDLER.postDelayed(this, 100L);
    }

    public final void b(View view) {
        if (this.g == 0) {
            Rect rect = new Rect();
            view.getWindowVisibleDisplayFrame(rect);
            int i = rect.bottom;
            this.g = i;
            int[] iArr = this.f;
            int i2 = iArr[1] - this.h;
            if (i2 >= i) {
                iArr[1] = i2;
            }
        }
        YFLog.debug(this.f9568a + " init: " + Arrays.toString(this.f));
    }

    public final boolean a(String str, View view) {
        if (this.c == 3) {
            YFLog.debug(str + " has expose, return.");
            return false;
        }
        if (view == null) {
            YFLog.warn(str + " showView is null, return.");
            return false;
        }
        try {
            b(view);
            int width = view.getWidth();
            int height = view.getHeight();
            Rect rect = new Rect();
            int[] iArr = this.f;
            int i = iArr[0] + (width / 2);
            boolean z = true;
            int i2 = iArr[1] + (height / 2);
            if (view.getGlobalVisibleRect(rect) && rect.bottom - rect.top >= height / 2) {
                int[] iArr2 = new int[2];
                view.getLocationOnScreen(iArr2);
                int i3 = iArr2[0];
                int i4 = iArr2[1];
                if (i3 < 0 || i3 + width > i || i4 < 0 || i4 + height > i2) {
                    z = false;
                }
                YFLog.debug(this.f9568a + x.bQ + str + " check: " + rect + " half visible , [x" + i3 + "+w" + width + "|" + i + ",y" + i4 + "+h" + height + "|" + i2 + "] result " + z);
                return z;
            }
            YFLog.debug(this.f9568a + x.bQ + str + " check: " + rect + " half not visible");
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
