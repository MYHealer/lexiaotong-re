package com.opos.cmn.i;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.os.PowerManager;
import android.view.DisplayCutout;
import android.view.View;
import android.view.WindowInsets;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class k {
    private static final RectF a(View view) {
        RectF rectF;
        try {
            int[] iArr = {-1, -1};
            view.getLocationOnScreen(iArr);
            int i = iArr[0];
            rectF = new RectF(i, iArr[1], i + view.getWidth(), iArr[1] + view.getHeight());
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("ScreenUtils", "", (Throwable) e);
            rectF = null;
        }
        com.opos.cmn.an.f.a.b("ScreenUtils", "getViewScreenLocation=" + (rectF != null ? rectF.toString() : "null"));
        return rectF;
    }

    public static final boolean a(Context context) {
        boolean zIsInteractive = true;
        if (context != null) {
            try {
                PowerManager powerManager = (PowerManager) context.getSystemService("power");
                if (powerManager != null) {
                    zIsInteractive = powerManager.isInteractive();
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("ScreenUtils", "", (Throwable) e);
            }
        }
        com.opos.cmn.an.f.a.b("ScreenUtils", "is screenOn = " + zIsInteractive);
        return zIsInteractive;
    }

    /* JADX WARN: Code duplicated, block: B:35:0x008c A[RETURN] */
    public static final boolean a(Context context, View view) {
        RectF rectF;
        RectF rectF2;
        if (context != null && view != null && view.isInTouchMode()) {
            if (!view.isShown()) {
                com.opos.cmn.an.f.a.b("ScreenUtils", "view not shown");
                return false;
            }
            if (Build.VERSION.SDK_INT >= 28) {
                return b(view);
            }
            if (!com.opos.cmn.an.h.d.a.a(context, view)) {
                return false;
            }
            int iJ = com.opos.cmn.an.h.f.a.j(context);
            if (iJ == 0) {
                rectF = new RectF(0.0f, 0.0f, com.opos.cmn.an.h.f.a.b(context), 79.0f);
            } else if (iJ == 90) {
                rectF = new RectF(0.0f, 0.0f, 79.0f, com.opos.cmn.an.h.f.a.b(context));
            } else if (iJ != 180) {
                if (iJ != 270) {
                    rectF2 = null;
                } else {
                    rectF = new RectF(com.opos.cmn.an.h.f.a.c(context) - 79.0f, 0.0f, com.opos.cmn.an.h.f.a.c(context), com.opos.cmn.an.h.f.a.b(context));
                }
                if (a(rectF2, view)) {
                    return true;
                }
            } else {
                rectF = new RectF(0.0f, com.opos.cmn.an.h.f.a.c(context) - 79.0f, com.opos.cmn.an.h.f.a.b(context), com.opos.cmn.an.h.f.a.c(context));
            }
            rectF2 = rectF;
            if (a(rectF2, view)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean a(RectF rectF, View view) {
        boolean z = false;
        if (view != null && rectF != null) {
            try {
                RectF rectFA = a(view);
                if (rectFA != null && RectF.intersects(rectF, rectFA)) {
                    z = true;
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("ScreenUtils", "", (Throwable) e);
            }
        }
        com.opos.cmn.an.f.a.b("ScreenUtils", "isCoodinateInRect rect=" + rectF + ",view =" + view);
        return z;
    }

    private static final boolean b(View view) {
        DisplayCutout displayCutout;
        List<Rect> boundingRects;
        WindowInsets rootWindowInsets = view.getRootWindowInsets();
        if (rootWindowInsets != null && (displayCutout = rootWindowInsets.getDisplayCutout()) != null && (boundingRects = displayCutout.getBoundingRects()) != null && boundingRects.size() > 0) {
            Iterator<Rect> it = boundingRects.iterator();
            while (it.hasNext()) {
                if (a(new RectF(it.next()), view)) {
                    return true;
                }
            }
        }
        return false;
    }
}
