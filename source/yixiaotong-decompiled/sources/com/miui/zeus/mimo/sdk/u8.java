package com.miui.zeus.mimo.sdk;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import client.android.yixiaotong.controller.error.ErrorUtil;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class u8 extends FrameLayout implements DialogInterface {
    public static final String h = "u8";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PopupWindow f5635a;
    public Context b;
    public View c;
    public c d;
    public int e;
    public int f;
    public int g;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                PopupWindow popupWindow = u8.this.f5635a;
                if (popupWindow == null || !popupWindow.isShowing()) {
                    return;
                }
                u8.this.f5635a.dismiss();
            } catch (Exception e) {
                String str = u8.h;
                m.b(u8.h, ijiami_1011.s.s.s.d(new byte[]{92, 94, 17, 89, 15, 66, Ascii.DC2, 68, 3, 66, 11, 69}, "87b4f1"), e);
            }
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                u8.this.dismiss();
                u8.this.removeAllViews();
            } catch (Exception unused) {
            }
        }
    }

    public interface c {
    }

    public u8(Context context) {
        super(context);
        a(context);
    }

    public final void a(Context context) {
        int identifier;
        this.b = context;
        if (f9.c <= 0) {
            synchronized (f9.class) {
                if (f9.c == 0 && (identifier = context.getResources().getIdentifier(ijiami_1011.s.s.s.d(new byte[]{66, Ascii.DC2, 2, 76, 65, 65, 62, 6, 7, 16, 110, 13, 84, 15, 4, 80, SignedBytes.MAX_POWER_OF_TWO}, "1fc842"), ijiami_1011.s.s.s.d(new byte[]{85, 88, 84, 86, 86}, "119386"), ijiami_1011.s.s.s.d(new byte[]{82, 11, 5, 19, 88, 13, 5}, "3eaa7d"))) > 0) {
                    f9.c = context.getResources().getDimensionPixelSize(identifier);
                }
            }
        }
        this.e = f9.c;
        this.f = f9.b(context);
        int iC = f9.c(context);
        this.g = iC;
        Context context2 = this.b;
        int i = iC + this.e + this.f;
        PopupWindow popupWindow = this.c != null ? new PopupWindow(this.c, -1, i) : new PopupWindow(context2);
        popupWindow.setHeight(i);
        popupWindow.setWidth(-1);
        popupWindow.setTouchable(true);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setContentView(this);
        popupWindow.setClippingEnabled(false);
        popupWindow.setFocusable(true);
        popupWindow.getBackground().getPadding(new Rect());
        popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        try {
            Class.forName(PopupWindow.class.getName()).getDeclaredMethod(ijiami_1011.s.s.s.d(new byte[]{66, 93, 77, 51, 11, 93, 5, 11, 17, 46, 80, Ascii.FS, 94, 77, 77, 48, Ascii.ESC, 67, 4}, "189db3"), Integer.TYPE).invoke(popupWindow, Integer.valueOf(ErrorUtil.CODE_V3ACCOUNT));
        } catch (Exception e) {
            m.b(h, ijiami_1011.s.s.s.d(new byte[]{75, 6, 68, 50, 10, 8, 5, 11, 17, 54, 72, Ascii.NAK, 93, 67, 85, 69, 89, 70}, "8c0ecf"), e);
        }
        this.f5635a = popupWindow;
    }

    @Override // android.content.DialogInterface
    public void cancel() {
        x8.e(new b());
    }

    @Override // android.content.DialogInterface
    public void dismiss() {
        x8.e(new a());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        try {
            c cVar = this.d;
            if (cVar != null) {
                f0 f0Var = (f0) cVar;
                f0Var.f5419a.onAdShow();
                f0Var.f5419a.b();
            }
        } catch (Exception e) {
            m.b(h, ijiami_1011.s.s.s.d(new byte[]{14, 12, 112, 17, 17, 84, 2, 12, 3, 6, 101, 10, 54, 11, 95, 1, 10, 66, 65, 1, 70, 88, 17}, "ab1ee5"), e);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        d0 d0Var;
        super.onDetachedFromWindow();
        try {
            c cVar = this.d;
            if (cVar == null || (d0Var = ((f0) cVar).f5419a.c) == null) {
                return;
            }
            d0Var.onAdClosed();
        } catch (Exception e) {
            m.b(h, ijiami_1011.s.s.s.d(new byte[]{95, 90, 34, 81, 68, 83, 2, 12, 3, 6, 119, Ascii.ETB, 95, 89, 49, 93, 94, 86, 14, 19, 70, 7, 17, 95, 16}, "04f402"), e);
        }
    }

    @Override // android.view.View
    public void setFocusable(boolean z) {
        View view = this.c;
        if (view != null) {
            view.setFocusable(z);
        }
    }

    public void setHeight(int i) {
        try {
            this.f5635a.setHeight(i);
        } catch (Exception e) {
            m.b(h, ijiami_1011.s.s.s.d(new byte[]{17, 0, Ascii.SYN, 121, 7, 93, 6, 12, Ascii.DC2, 66, 84, 69, 88, 69}, "beb1b4"), e);
        }
    }

    public void setOnWindowListener(c cVar) {
        this.d = cVar;
    }

    public void setOutsideDismiss(boolean z) {
        this.f5635a.setOutsideTouchable(z);
    }

    public void setWidth(int i) {
        try {
            this.f5635a.setWidth(i);
        } catch (Exception e) {
            m.b(h, ijiami_1011.s.s.s.d(new byte[]{68, 82, 68, 97, 12, 84, Ascii.NAK, 12, 70, 7, 17, 95, Ascii.ETB}, "7706e0"), e);
        }
    }
}
