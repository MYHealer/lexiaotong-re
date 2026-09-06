package com.huawei.hms.mlplugin.card.bcr;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.DisplayCutout;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.WindowManager;
import com.huawei.hms.ml.common.utils.SmartLog;

/* JADX INFO: compiled from: ViewUtils.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f4177a = "t";

    public static Rect a(Point point, int i, int i2) {
        int i3 = point.x;
        int i4 = i / 2;
        int i5 = point.y;
        int i6 = i2 / 2;
        return new Rect(i3 - i4, i5 - i6, i3 + i4, i5 + i6);
    }

    public static Point b(Context context) {
        int i;
        int i2;
        if (context == null) {
            return new Point(0, 0);
        }
        boolean zG = g(context);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        try {
            Point point = new Point();
            Display.class.getMethod("getRealSize", Point.class).invoke(defaultDisplay, point);
            if (zG) {
                if (point.x >= point.y) {
                    i = point.x;
                    i2 = point.y;
                } else {
                    i = point.y;
                    i2 = point.x;
                }
            } else if (point.x >= point.y) {
                i = point.y;
                i2 = point.x;
            } else {
                i = point.x;
                i2 = point.y;
            }
            int iD = d(context);
            int iF = i(context) ? f(context) : 0;
            if (iD > iF) {
                iF = iD;
            }
            int i3 = zG ? i - iD : displayMetrics.widthPixels;
            int i4 = zG ? displayMetrics.heightPixels : i2 - iF;
            if (h(context)) {
                int iC = c(context);
                if (zG) {
                    i3 -= iC;
                } else {
                    i4 -= iC;
                }
            }
            return new Point(i3, i4);
        } catch (RuntimeException e) {
            SmartLog.e(f4177a, "getAdapterScreenSize e = " + e.getMessage());
            return new Point(0, 0);
        } catch (Exception e2) {
            SmartLog.e(f4177a, "getAdapterScreenSize e = " + e2.getMessage());
            return new Point(0, 0);
        }
    }

    public static int c(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("navigation_bar_height", "dimen", "android");
        if (identifier > 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static int d(Context context) {
        WindowInsets rootWindowInsets;
        DisplayCutout displayCutout;
        if (s.a() && C1209r.c(context)) {
            return C1209r.b(context)[1];
        }
        if (s.d() && C1209r.a()) {
            return C1209r.a(context);
        }
        if (s.b() && C1209r.d(context)) {
            return f(context);
        }
        if (s.c() && C1209r.e(context)) {
            return f(context);
        }
        if (Build.VERSION.SDK_INT < 28 || (rootWindowInsets = ((Activity) context).getWindow().getDecorView().getRootWindowInsets()) == null || (displayCutout = rootWindowInsets.getDisplayCutout()) == null || displayCutout.getBoundingRects() == null) {
            return 0;
        }
        return displayCutout.getSafeInsetTop();
    }

    public static Point e(Context context) {
        return b(context);
    }

    public static int f(Context context) {
        try {
            Class<?> cls = Class.forName("com.android.internal.R$dimen");
            Object obj = cls.getField("status_bar_height").get(cls.newInstance());
            return context.getResources().getDimensionPixelSize(obj != null ? Integer.parseInt(obj.toString()) : -1);
        } catch (RuntimeException e) {
            SmartLog.e(f4177a, "getStatusBarHeight e = " + e.getMessage());
            return 0;
        } catch (Exception e2) {
            SmartLog.e(f4177a, "getStatusBarHeight e = " + e2.getMessage());
            return 0;
        }
    }

    public static boolean g(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }

    public static boolean h(Context context) {
        boolean z;
        Activity activity = (Activity) context;
        ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
        int childCount = viewGroup.getChildCount();
        int i = 0;
        while (true) {
            if (i >= childCount) {
                z = false;
                break;
            }
            View childAt = viewGroup.getChildAt(i);
            int id = childAt.getId();
            if (id != -1 && "navigationBarBackground".equals(activity.getApplication().getResources().getResourceEntryName(id)) && childAt.getVisibility() == 0) {
                z = true;
                break;
            }
            i++;
        }
        if (z) {
            return (viewGroup.getSystemUiVisibility() & 2) == 0;
        }
        return z;
    }

    public static boolean i(Context context) {
        if (!(context instanceof Activity)) {
            return false;
        }
        int i = ((Activity) context).getWindow().getAttributes().flags;
        return (i & (-1025)) == i;
    }

    public static Point a(Context context) {
        int i;
        int i2;
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null");
        }
        boolean zG = g(context);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        try {
            Point point = new Point();
            Display.class.getMethod("getRealSize", Point.class).invoke(defaultDisplay, point);
            if (zG) {
                if (point.x >= point.y) {
                    i = point.x;
                    i2 = point.y;
                } else {
                    i = point.y;
                    i2 = point.x;
                }
            } else if (point.x >= point.y) {
                i = point.y;
                i2 = point.x;
            } else {
                i = point.x;
                i2 = point.y;
            }
            int iD = d(context);
            int iF = i(context) ? f(context) : 0;
            if (iD > iF) {
                iF = iD;
            }
            return new Point(zG ? (i - iD) + 1 : displayMetrics.widthPixels, zG ? displayMetrics.heightPixels : i2 - iF);
        } catch (RuntimeException e) {
            SmartLog.e(f4177a, "getAdapterScreenSize e = " + e.getMessage());
            return new Point(0, 0);
        } catch (Exception e2) {
            SmartLog.e(f4177a, "getAdapterScreenSize e = " + e2.getMessage());
            return new Point(0, 0);
        }
    }

    public static int a(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static Rect a(Point point, float f, boolean z) {
        if (z && f != 0.0f) {
            int iRound = Math.round(point.y * 0.8f);
            int iRound2 = Math.round(iRound / f);
            int i = (point.x - iRound2) >> 1;
            int i2 = (point.y - iRound) >> 1;
            Rect rect = new Rect(i, i2, iRound2 + i, iRound + i2);
            int i3 = point.x;
            int i4 = point.y;
            if (i3 - i4 >= 350) {
                return rect;
            }
            int iRound3 = Math.round(i4 * 0.4f);
            int iRound4 = Math.round(iRound3 / f);
            int i5 = (point.x - iRound4) >> 1;
            int i6 = (point.y - iRound3) >> 1;
            return new Rect(i5, i6, iRound4 + i5, iRound3 + i6);
        }
        int iRound5 = Math.round(point.x * 0.9f);
        int iRound6 = Math.round(iRound5 * f);
        int i7 = (point.x - iRound5) >> 1;
        int iRound7 = Math.round(point.y * 0.2f);
        return new Rect(i7, iRound7, iRound5 + i7, iRound6 + iRound7);
    }
}
