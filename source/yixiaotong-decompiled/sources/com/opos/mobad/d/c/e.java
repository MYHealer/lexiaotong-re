package com.opos.mobad.d.c;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class e {
    private static int a(View view, ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            if (viewGroup.getChildAt(i) == view) {
                return i;
            }
        }
        return 0;
    }

    public static void a(View view, Drawable drawable) {
        if (view == null || drawable == null) {
            return;
        }
        view.setBackground(drawable);
    }

    public static boolean a(Context context, View view) {
        if (view != null) {
            return a(view);
        }
        if (context == null) {
            return false;
        }
        return com.opos.cmn.an.h.a.a.b(context);
    }

    public static boolean a(View view) {
        return view != null && view.getWindowVisibility() == 0;
    }

    public static int b(View view) {
        int iE;
        try {
            iE = (int) e(view);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.d("ViewUtils", "getViewCoveredRatio()", e);
            iE = -1;
        }
        com.opos.cmn.an.f.a.b("ViewUtils", "getViewCoveredRatio()=" + iE);
        return iE;
    }

    public static int c(View view) {
        if (view != null && view.getVisibility() == 0 && view.isShown()) {
            return f(view) ? 2 : 1;
        }
        return 0;
    }

    public static float d(View view) {
        float alpha;
        long jCurrentTimeMillis = System.currentTimeMillis();
        int i = 0;
        if (view != null) {
            alpha = view.getAlpha();
            View view2 = view;
            while ((view2.getParent() instanceof ViewGroup) && i < 15) {
                ViewGroup viewGroup = (ViewGroup) view2.getParent();
                float alpha2 = viewGroup.getAlpha();
                if (alpha2 < alpha) {
                    alpha = alpha2;
                }
                i++;
                view2 = viewGroup;
            }
        } else {
            alpha = -1.0f;
        }
        com.opos.cmn.an.f.a.b("ViewUtils", "getViewAlpha,alpha=" + alpha + ",level=" + i + ",cost time=" + (System.currentTimeMillis() - jCurrentTimeMillis));
        return alpha;
    }

    private static float e(View view) {
        float fMax = 0.0f;
        if (view != null && view.getVisibility() == 0) {
            View view2 = view;
            int i = 0;
            while ((view2.getParent() instanceof ViewGroup) && i < 15) {
                ViewGroup viewGroup = (ViewGroup) view2.getParent();
                if (viewGroup.getVisibility() != 0) {
                    return fMax;
                }
                for (int iA = a(view2, viewGroup) + 1; iA < viewGroup.getChildCount(); iA++) {
                    View childAt = viewGroup.getChildAt(iA);
                    if (!(childAt instanceof com.opos.mobad.d.e.a) && childAt.getVisibility() == 0) {
                        int[] iArr = new int[2];
                        childAt.getLocationInWindow(iArr);
                        int i2 = iArr[0];
                        Rect rect = new Rect(i2, iArr[1], childAt.getWidth() + i2, iArr[1] + childAt.getHeight());
                        int[] iArr2 = new int[2];
                        view.getLocationInWindow(iArr2);
                        int i3 = iArr2[0];
                        Rect rect2 = new Rect(i3, iArr2[1], view.getWidth() + i3, iArr2[1] + view.getHeight());
                        if (rect.intersect(rect2)) {
                            long jAbs = ((long) Math.abs(rect.bottom - rect.top)) * ((long) Math.abs(rect.left - rect.right));
                            long jAbs2 = ((long) Math.abs(rect2.bottom - rect2.top)) * ((long) Math.abs(rect2.left - rect2.right));
                            if (jAbs2 > 0 && jAbs > 0) {
                                fMax = Math.max(fMax, ((jAbs * 1.0f) / jAbs2) * 100.0f);
                            }
                            com.opos.cmn.an.f.a.b("ViewUtils", "getViewCoveredRatio() intersectArea=" + jAbs + ", totalArea=" + jAbs2 + ", ratio=" + fMax);
                        }
                    }
                }
                i++;
                view2 = viewGroup;
            }
        }
        return fMax;
    }

    private static boolean f(View view) {
        Rect rect = new Rect();
        boolean globalVisibleRect = view.getGlobalVisibleRect(rect);
        boolean z = rect.bottom - rect.top >= view.getMeasuredHeight();
        boolean z2 = rect.right - rect.left >= view.getMeasuredWidth();
        if (!globalVisibleRect || !z || !z2) {
            return true;
        }
        View view2 = view;
        while (view2.getParent() instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view2.getParent();
            if (viewGroup.getVisibility() != 0) {
                return true;
            }
            for (int iA = a(view2, viewGroup) + 1; iA < viewGroup.getChildCount(); iA++) {
                Rect rect2 = new Rect();
                view.getGlobalVisibleRect(rect2);
                View childAt = viewGroup.getChildAt(iA);
                Rect rect3 = new Rect();
                childAt.getGlobalVisibleRect(rect3);
                if (Rect.intersects(rect2, rect3)) {
                    return true;
                }
            }
            view2 = viewGroup;
        }
        return false;
    }
}
