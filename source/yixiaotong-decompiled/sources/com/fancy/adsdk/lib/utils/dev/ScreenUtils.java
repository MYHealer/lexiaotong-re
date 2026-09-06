package com.fancy.adsdk.lib.utils.dev;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.WindowManager;
import com.fancy._c7;
import com.fancy.adsdk.lib.PtgAdSdk;
import com.fancy.adsdk.lib.utils.Logger;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public class ScreenUtils {
    public static boolean GUBED;

    public static void buildScreenInfo(Context context, _c7 _c7Var) {
        if (context == null || _c7Var == null) {
            return;
        }
        try {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getRealSize(point);
            boolean z = context.getResources().getConfiguration().orientation == 2;
            int i = z ? point.y : point.x;
            int i2 = z ? point.x : point.y;
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getMetrics(displayMetrics);
            float f = z ? displayMetrics.ydpi : displayMetrics.xdpi;
            float f2 = z ? displayMetrics.xdpi : displayMetrics.ydpi;
            _c7Var._n = i;
            _c7Var._o = i2;
            Logger.d("ScreenUtilsTag", "isLandscape: " + z + " getScreenRealWidth: " + i + " getScreenRealHeight: " + i2 + " wdpi: " + f + " hdpi: " + f2);
        } catch (Exception e) {
            Logger.e("ScreenUtilsTag", "buildScreenInfo error", e);
        }
    }

    public static int dp2px(float f) {
        return dp2px(null, f);
    }

    public static int dp2px(Context context, float f) {
        return (int) (((getResources(context).getDisplayMetrics().densityDpi / 160.0f) * f) + 0.5f);
    }

    public static int dpToPx(Context context, float f) {
        return (int) TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
    }

    public static float getDensity() {
        try {
            if (PtgAdSdk.getContext() != null) {
                return PtgAdSdk.getContext().getResources().getDisplayMetrics().density;
            }
            return 0.0f;
        } catch (Exception unused) {
            return 0.0f;
        }
    }

    public static int getDensityDpi() {
        try {
            if (PtgAdSdk.getContext() != null) {
                return PtgAdSdk.getContext().getResources().getDisplayMetrics().densityDpi;
            }
            return 0;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static Resources getResources(Context context) {
        return context == null ? Resources.getSystem() : context.getResources();
    }

    public static int getScreenHeight(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public static float getScreenHeightDp(Context context) {
        float f = context.getResources().getDisplayMetrics().density;
        float f2 = context.getResources().getDisplayMetrics().heightPixels;
        if (f <= 0.0f) {
            f = 1.0f;
        }
        return (f2 / f) + 0.5f;
    }

    public static int getScreenRealHeight(Context context) {
        if (context == null) {
            return 0;
        }
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getRealSize(point);
        boolean z = context.getResources().getConfiguration().orientation == 2;
        int i = z ? point.x : point.y;
        Logger.d("ScreenUtilsT", "isLandscape: " + z + " getScreenRealHeight: " + i);
        return i;
    }

    public static int getScreenRealWidth(Context context) {
        if (context == null) {
            return 0;
        }
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getRealSize(point);
        boolean z = context.getResources().getConfiguration().orientation == 2;
        int i = z ? point.y : point.x;
        Logger.d("ScreenUtilsT", "isLandscape: " + z + " getScreenRealWidth: " + i);
        return i;
    }

    public static int getScreenWidth(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public static float getScreenWidthDp(Context context) {
        float f = context.getResources().getDisplayMetrics().density;
        float f2 = context.getResources().getDisplayMetrics().widthPixels;
        if (f <= 0.0f) {
            f = 1.0f;
        }
        return (f2 / f) + 0.5f;
    }

    public static int getStatusBarHeight(Context context) {
        try {
            Class<?> cls = Class.forName("com.android.internal.R$dimen");
            return context.getResources().getDimensionPixelSize(Integer.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString()));
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static float px2dp(float f) {
        return px2dp(null, f);
    }

    public static float px2dp(Context context, float f) {
        return (f * 160.0f) / getResources(context).getDisplayMetrics().densityDpi;
    }
}
