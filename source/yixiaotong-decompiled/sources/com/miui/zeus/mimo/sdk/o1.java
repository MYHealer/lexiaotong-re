package com.miui.zeus.mimo.sdk;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;
import com.miui.zeus.mimo.sdk.ad.nativead.NativeAdUIController;
import com.miui.zeus.mimo.sdk.common.ViewEventHelper;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class o1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NativeAdUIController f5542a;

    public class a extends TouchDelegate {
        public a(Rect rect, View view) {
            super(rect, view);
        }

        @Override // android.view.TouchDelegate
        public boolean onTouchEvent(MotionEvent motionEvent) {
            NativeAdUIController nativeAdUIController = o1.this.f5542a;
            ViewEventHelper viewEventHelper = nativeAdUIController.l;
            if (viewEventHelper != null) {
                View view = nativeAdUIController.f5302a;
                if (viewEventHelper.b < 0) {
                    viewEventHelper.b = ViewConfiguration.get(viewEventHelper.d).getScaledTouchSlop();
                }
                if (motionEvent.getAction() == 0) {
                    viewEventHelper.c = System.currentTimeMillis();
                    viewEventHelper.f5395a.f5538a = (int) motionEvent.getX();
                    viewEventHelper.f5395a.b = (int) motionEvent.getY();
                } else if (motionEvent.getAction() == 1) {
                    viewEventHelper.f5395a.c = (int) motionEvent.getX();
                    viewEventHelper.f5395a.d = (int) motionEvent.getY();
                    viewEventHelper.f5395a.e = view.getWidth();
                    viewEventHelper.f5395a.f = view.getHeight();
                    n6 n6Var = viewEventHelper.f5395a;
                    float fAbs = Math.abs(n6Var.c - n6Var.f5538a);
                    n6 n6Var2 = viewEventHelper.f5395a;
                    float fAbs2 = Math.abs(n6Var2.d - n6Var2.b);
                    float fAbs3 = Math.abs(System.currentTimeMillis() - viewEventHelper.c);
                    float f = viewEventHelper.b;
                    if (fAbs < f && fAbs2 < f && fAbs3 < 200.0f) {
                        int[] iArr = new int[2];
                        view.getLocationOnScreen(iArr);
                        n6 n6Var3 = viewEventHelper.f5395a;
                        n6Var3.g = iArr[0];
                        n6Var3.h = iArr[1];
                    }
                }
            }
            return false;
        }
    }

    public o1(NativeAdUIController nativeAdUIController) {
        this.f5542a = nativeAdUIController;
    }

    @Override // java.lang.Runnable
    public void run() {
        Rect rect = new Rect();
        rect.setEmpty();
        if (this.f5542a.f5302a == null) {
            return;
        }
        this.f5542a.f5302a.setTouchDelegate(new a(rect, this.f5542a.f5302a));
    }
}
