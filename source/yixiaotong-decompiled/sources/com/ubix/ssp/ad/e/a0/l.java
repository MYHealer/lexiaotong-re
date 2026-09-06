package com.ubix.ssp.ad.e.a0;

import android.content.Context;
import android.graphics.Color;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f8708a;
    private int b;
    private boolean c;
    private Context d;
    private WindowManager e;
    private View f;
    private b g;
    private a h;
    private int i = Color.parseColor("#A6020202");
    boolean j = false;

    public interface a {
        void a();
    }

    private class b extends FrameLayout {
        public b(Context context) {
            super(context);
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            KeyEvent.DispatcherState keyDispatcherState;
            if (keyEvent.getKeyCode() == 4 && getKeyDispatcherState() != null) {
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                    if (keyDispatcherState2 != null) {
                        keyDispatcherState2.startTracking(keyEvent, this);
                    }
                    return true;
                }
                if (keyEvent.getAction() != 1 || (keyDispatcherState = getKeyDispatcherState()) == null || !keyDispatcherState.isTracking(keyEvent) || keyEvent.isCanceled()) {
                    return super.dispatchKeyEvent(keyEvent);
                }
                l lVar = l.this;
                if (lVar.j) {
                    lVar.a();
                }
                return true;
            }
            return super.dispatchKeyEvent(keyEvent);
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            return super.dispatchTouchEvent(motionEvent);
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if ((motionEvent.getAction() != 0 || (x >= 0 && x < getWidth() && y >= 0 && y < getHeight())) && motionEvent.getAction() != 4) {
                return super.onTouchEvent(motionEvent);
            }
            return true;
        }
    }

    public l(int i, int i2) {
        this.f8708a = -2;
        this.b = -2;
        this.f8708a = i;
        this.b = i2;
    }

    public l(View view, int i, int i2) {
        this.f8708a = -2;
        this.b = -2;
        if (view != null) {
            Context context = view.getContext();
            this.d = context;
            this.e = (WindowManager) context.getSystemService("window");
        }
        a(view);
        this.f8708a = i;
        this.b = i2;
    }

    private int a(int i) {
        return (i & (-8815129)) | 1073742368;
    }

    private WindowManager.LayoutParams a(IBinder iBinder) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.flags = a(layoutParams.flags);
        layoutParams.type = 1000;
        layoutParams.token = iBinder;
        layoutParams.format = -3;
        layoutParams.setTitle("PopupWindow:" + Integer.toHexString(hashCode()));
        return layoutParams;
    }

    private b a(View view, int i) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = r.i(view.getContext());
        layoutParams.gravity = i;
        b bVar = new b(this.d);
        bVar.addView(view, layoutParams);
        bVar.setClipChildren(false);
        bVar.setClipToPadding(false);
        bVar.invalidate();
        bVar.setBackgroundColor(this.i);
        return bVar;
    }

    private void a(View view, ViewGroup viewGroup, View view2) {
        if (view.getParent() != null) {
            this.e.removeViewImmediate(view);
        }
        if (viewGroup != null) {
            viewGroup.removeView(view2);
        }
        ((ViewGroup) view2).removeAllViews();
        this.g = null;
        this.f = null;
        this.d = null;
    }

    private void a(WindowManager.LayoutParams layoutParams) {
        Context context = this.d;
        if (context != null) {
            layoutParams.packageName = context.getPackageName();
        }
        this.e.addView(this.g, layoutParams);
    }

    private void b(WindowManager.LayoutParams layoutParams) {
        View view = this.f;
        if (view == null || this.d == null || this.e == null) {
            throw new IllegalStateException("You must specify a valid content view by calling setContentView() before attempting to show the popup.");
        }
        this.g = a(view, layoutParams.gravity);
    }

    public void a() {
        synchronized (this) {
            if (b()) {
                b bVar = this.g;
                View view = this.f;
                ViewParent parent = view.getParent();
                ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
                this.c = false;
                a(bVar, viewGroup, view);
                a aVar = this.h;
                if (aVar != null) {
                    aVar.a();
                }
            }
        }
    }

    public void a(View view) {
        if (b()) {
            return;
        }
        this.f = view;
        if (this.d == null && view != null) {
            this.d = view.getContext();
        }
        if (this.e != null || this.f == null) {
            return;
        }
        this.e = (WindowManager) this.d.getSystemService("window");
    }

    public void b(View view, int i) {
        synchronized (this) {
            if (!b() && this.f != null) {
                this.c = true;
                WindowManager.LayoutParams layoutParamsA = a(view.getWindowToken());
                if (i != 0) {
                    layoutParamsA.gravity = i;
                }
                b(layoutParamsA);
                layoutParamsA.x = 0;
                layoutParamsA.y = 0;
                a(layoutParamsA);
            }
        }
    }

    public boolean b() {
        return this.c;
    }
}
