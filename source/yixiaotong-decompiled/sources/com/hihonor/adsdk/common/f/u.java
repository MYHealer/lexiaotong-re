package com.hihonor.adsdk.common.f;

import android.app.Activity;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import java.util.Locale;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class u {
    private static final String hnadsa = "ScreenUtils";
    private static final String hnadsb = "navigationbar_is_min";

    private static Context hnadsa() {
        return com.hihonor.adsdk.common.a.hnadsa().hnadsb();
    }

    public static boolean hnadsb(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }

    public static boolean hnadsc(Context context) {
        return context.getResources().getConfiguration().orientation == 1;
    }

    public static int hnadsd(Activity activity) {
        int rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
        if (rotation == 0) {
            return 0;
        }
        if (rotation != 1) {
            return rotation != 2 ? 270 : 180;
        }
        return 90;
    }

    public static int hnadse() {
        try {
            WindowManager windowManager = (WindowManager) hnadsa().getSystemService("window");
            if (windowManager == null) {
                com.hihonor.adsdk.common.b.b.hnadse(hnadsa, "getScreenHeightByWindow,wm is null", new Object[0]);
                return hnadsd();
            }
            Point point = new Point();
            windowManager.getDefaultDisplay().getRealSize(point);
            return point.y;
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "getScreenHeightByWindow,exception:" + e.getMessage(), new Object[0]);
            return hnadsd();
        }
    }

    public static void hnadsf(Activity activity) {
        activity.setRequestedOrientation(0);
    }

    public static void hnadsg(Activity activity) {
        activity.setRequestedOrientation(1);
    }

    public static int hnadsh() {
        try {
            int identifier = hnadsa().getResources().getIdentifier("status_bar_height", "dimen", "android");
            if (identifier > 0) {
                return hnadsa().getResources().getDimensionPixelSize(identifier);
            }
            return 0;
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "getStateBarHeight: Exception: " + e.getMessage(), new Object[0]);
            return -1;
        }
    }

    public static boolean hnadsi() {
        try {
            return (hnadsa().getResources().getConfiguration().uiMode & 48) == 32;
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "isDarkTheme: Exception: " + e.getMessage(), new Object[0]);
            return false;
        }
    }

    public static boolean hnadsj() {
        Context contextHnadsb = com.hihonor.adsdk.common.a.hnadsa().hnadsb();
        if (contextHnadsb == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "isNavigationBarShow context is null", new Object[0]);
            return false;
        }
        try {
            int i = Settings.Global.getInt(contextHnadsb.getContentResolver(), hnadsb);
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "isNavigationBarShow globalInt = %s", Integer.valueOf(i));
            return i == 0;
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "isNavigationBarShow message = %s", e.getMessage());
            return false;
        }
    }

    public static boolean hnadsk() {
        return TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1;
    }

    public static int hnadsa(float f) {
        try {
            return (int) ((f * hnadsa().getResources().getDisplayMetrics().density) + 0.5f);
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "dpToPx: Exception: " + e.getMessage(), new Object[0]);
            return -1;
        }
    }

    public static int hnadsb(float f) {
        try {
            return (int) ((f / hnadsa().getResources().getDisplayMetrics().density) + 0.5f);
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "pxToDp: Exception: " + e.getMessage(), new Object[0]);
            return -1;
        }
    }

    public static int hnadsc(float f) {
        try {
            return (int) ((f / hnadsa().getResources().getDisplayMetrics().scaledDensity) + 0.5f);
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "pxToSp: Exception: " + e.getMessage(), new Object[0]);
            return -1;
        }
    }

    public static int hnadsd(float f) {
        try {
            return (int) ((f * hnadsa().getResources().getDisplayMetrics().scaledDensity) + 0.5f);
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "spToPx: Exception: " + e.getMessage(), new Object[0]);
            return -1;
        }
    }

    public static int hnadsf() {
        try {
            WindowManager windowManager = (WindowManager) hnadsa().getSystemService("window");
            if (windowManager == null) {
                com.hihonor.adsdk.common.b.b.hnadse(hnadsa, "getScreenWidthByWindow,wm is null", new Object[0]);
                return hnadsg();
            }
            Point point = new Point();
            windowManager.getDefaultDisplay().getRealSize(point);
            return point.x;
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "getScreenWidthByWindow,exception: " + e.getMessage(), new Object[0]);
            return hnadsg();
        }
    }

    public static int hnadsg() {
        try {
            return hnadsa().getResources().getDisplayMetrics().widthPixels;
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "getScreenWidth: Exception: " + e.getMessage(), new Object[0]);
            return -1;
        }
    }

    public static float hnadsa(int i, float f, DisplayMetrics displayMetrics) {
        float f2;
        if (i == 0) {
            return f;
        }
        if (i == 1) {
            f2 = displayMetrics.density;
        } else if (i == 2) {
            f2 = displayMetrics.scaledDensity;
        } else if (i == 3) {
            f *= displayMetrics.xdpi;
            f2 = 0.013888889f;
        } else if (i == 4) {
            f2 = displayMetrics.xdpi;
        } else {
            if (i != 5) {
                return 0.0f;
            }
            f *= displayMetrics.xdpi;
            f2 = 0.03937008f;
        }
        return f * f2;
    }

    public static Bitmap hnadsb(Activity activity) {
        View decorView = activity.getWindow().getDecorView();
        decorView.setDrawingCacheEnabled(true);
        decorView.buildDrawingCache();
        Bitmap drawingCache = decorView.getDrawingCache();
        int iHnadse = hnadse(activity);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(drawingCache, 0, iHnadse, displayMetrics.widthPixels, displayMetrics.heightPixels - iHnadse);
        decorView.destroyDrawingCache();
        return bitmapCreateBitmap;
    }

    public static int hnadsc() {
        try {
            int identifier = hnadsa().getResources().getIdentifier("navigation_bar_height", "dimen", "android");
            if (identifier > 0) {
                return hnadsa().getResources().getDimensionPixelSize(identifier);
            }
            return 0;
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "getNavigationBarHeight: Exception: " + e.getMessage(), new Object[0]);
            return -1;
        }
    }

    public static int hnadsd() {
        try {
            return hnadsa().getResources().getDisplayMetrics().heightPixels;
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "getScreenHeight: Exception: " + e.getMessage(), new Object[0]);
            return -1;
        }
    }

    public static boolean hnadsd(Context context) {
        return ((KeyguardManager) context.getSystemService("keyguard")).inKeyguardRestrictedInputMode();
    }

    public static Bitmap hnadsa(Activity activity) {
        View decorView = activity.getWindow().getDecorView();
        decorView.setDrawingCacheEnabled(true);
        decorView.buildDrawingCache();
        Bitmap drawingCache = decorView.getDrawingCache();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(drawingCache, 0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels);
        decorView.destroyDrawingCache();
        return bitmapCreateBitmap;
    }

    public static int hnadse(Activity activity) {
        try {
            Rect rect = new Rect();
            activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            return rect.top;
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "getStatusBarHeight: Exception: " + e.getMessage(), new Object[0]);
            return -1;
        }
    }

    public static int hnadsc(Activity activity) {
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getRealSize(point);
        int i = point.y;
        defaultDisplay.getSize(point);
        int i2 = point.y;
        Resources resources = activity.getResources();
        try {
            if (resources.getBoolean(resources.getIdentifier("config_showNavigationBar", "bool", "android"))) {
                return Math.max(0, i - i2);
            }
        } catch (Throwable th) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "getNavigationBarHeight, Exception: " + th.getMessage(), new Object[0]);
        }
        return 0;
    }

    public static float hnadsb() {
        return hnadsa().getResources().getDisplayMetrics().density;
    }

    public static int hnadsa(Context context) {
        try {
            Class<?> cls = Class.forName("com.android.internal.R$dimen");
            return context.getResources().getDimensionPixelSize(q.hnadsd(cls.getField("status_bar_height").get(cls.newInstance()).toString(), true));
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "getStatusHeight: Exception: " + e.getMessage(), new Object[0]);
            return -1;
        }
    }
}
