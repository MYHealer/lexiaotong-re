package com.ubix.ssp.ad.e.a0.y;

import android.app.Activity;
import android.graphics.Rect;
import android.os.IBinder;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.ubix.ssp.ad.e.a0.u;
import java.lang.reflect.Field;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class c {
    private static double a(a aVar, a aVar2) {
        if (aVar == null || aVar2 == null) {
            return -1.0d;
        }
        double d = aVar.d();
        double dE = aVar.e();
        double dB = aVar.b() + d;
        double dC = aVar.c() + dE;
        double d2 = aVar2.d();
        double dE2 = aVar2.e();
        double dB2 = aVar2.b() + d2;
        double dC2 = aVar2.c() + dE2;
        if (d > dB2 || dB < d2 || dE > dC2 || dC < dE2) {
            return 0.0d;
        }
        return (Math.min(dB, dB2) - Math.max(d, d2)) * (Math.min(dC, dC2) - Math.max(dE, dE2));
    }

    private static int a(View view, ViewGroup viewGroup) {
        int i = 0;
        while (i < viewGroup.getChildCount() && viewGroup.getChildAt(i) != view) {
            i++;
        }
        return i;
    }

    public static boolean a(View view) {
        try {
            IBinder windowToken = view.getWindowToken();
            Class<?> cls = Class.forName("android.view.WindowManagerGlobal");
            Object objInvoke = cls.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
            Field declaredField = cls.getDeclaredField("mViews");
            boolean z = true;
            declaredField.setAccessible(true);
            List list = (List) declaredField.get(objInvoke);
            int i = 1;
            while (z) {
                View view2 = (View) list.get(list.size() - i);
                if (view2.getWindowToken() == null) {
                    i++;
                    if (i >= list.size()) {
                        break;
                    }
                } else if (view2.getContext() instanceof Activity) {
                    if (!((Activity) view2.getContext()).getWindow().getDecorView().isShown() || (view2.getLayoutParams() != null && ((WindowManager.LayoutParams) view2.getLayoutParams()).type == 2005)) {
                        i++;
                    } else {
                        if (view2.getWindowToken() != windowToken) {
                            break;
                        }
                        z = false;
                    }
                } else if (((WindowManager.LayoutParams) view2.getLayoutParams()).type == 2 || ((WindowManager.LayoutParams) view2.getLayoutParams()).type == 2005) {
                    try {
                        if (((WindowManager.LayoutParams) view2.getLayoutParams()).type == 2) {
                            if (view2.findViewById(876547) != null) {
                                break;
                            }
                            if (view2.getWindowToken() == windowToken) {
                                z = false;
                            }
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    i++;
                } else {
                    if (view2.getWindowToken() != windowToken) {
                        break;
                    }
                    z = false;
                }
            }
            return z;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* JADX WARN: Code duplicated, block: B:35:0x015b  */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r6v3 */
    public static boolean a(View view, float f, boolean z, List<Integer> list) {
        View view2 = view;
        Rect rect = new Rect();
        boolean globalVisibleRect = view2.getGlobalVisibleRect(rect);
        int measuredHeight = view.getMeasuredHeight();
        int measuredWidth = view.getMeasuredWidth();
        int i = (rect.bottom - rect.top) * (rect.right - rect.left);
        int i2 = measuredHeight * measuredWidth;
        ?? r6 = 1;
        if (!globalVisibleRect || i < i2 * f) {
            u.b("isViewCovered: 1，if any part of the view is clipped by any of its parents,return true");
            return true;
        }
        View view3 = view2;
        while (view3.getParent() instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view3.getParent();
            if (viewGroup.getVisibility() != 0) {
                u.b("isViewCovered: 2,if the parent of view is not visible,return true");
                return r6;
            }
            if (z != 0) {
                u.b("isViewCovered :3 checkTopView" + z);
                int iA = a(view3, viewGroup) + r6;
                while (iA < viewGroup.getChildCount()) {
                    u.b("currentParent=" + viewGroup + ";" + viewGroup.getId());
                    u.b("currentView=" + view3 + ";" + view3.getId());
                    u.b("currentChildView=" + view2 + ";" + view.getId());
                    if (list == null || list.isEmpty() || !list.contains(Integer.valueOf(viewGroup.getChildAt(iA).getId()))) {
                        Rect rect2 = new Rect();
                        view2.getGlobalVisibleRect(rect2);
                        View childAt = viewGroup.getChildAt(iA);
                        Rect rect3 = new Rect();
                        boolean globalVisibleRect2 = childAt.getGlobalVisibleRect(rect3);
                        if (childAt.isShown() && globalVisibleRect2 && Rect.intersects(rect2, rect3) && childAt.getVisibility() == 0) {
                            if (a(new a(rect.left, rect.top, rect.width(), rect.height()), new a(rect3.left, rect3.top, rect3.width(), rect3.height())) >= ((double) (rect.width() * rect.height())) / 2.0d) {
                                return true;
                            }
                        }
                    }
                    iA++;
                    view2 = view;
                }
            }
            view2 = view;
            view3 = viewGroup;
            r6 = 1;
        }
        return false;
    }

    public static boolean a(View view, boolean z, boolean z2, List<Integer> list) {
        return a(view, 0.5f, z2, list);
    }
}
