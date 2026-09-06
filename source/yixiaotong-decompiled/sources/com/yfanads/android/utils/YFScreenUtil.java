package com.yfanads.android.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.byazt.bv.BaseConstants;
import com.google.android.exoplayer2.C;
import com.huawei.hms.ml.camera.CountryCodeBean;
import com.stub.StubApp;
import com.yfanads.android.libs.utils.Util;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class YFScreenUtil {
    public static final int VIVO_FILLET = 8;
    public static final int VIVO_NOTCH = 32;

    private YFScreenUtil() {
    }

    public static int dip2px(Context context, float f) {
        return dip2pxC(context, f);
    }

    public static int dip2pxC(Context context, float f) {
        try {
            return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static int dip2pxScale(float f, float f2) {
        return (int) ((f2 * f) + 0.5f);
    }

    public static float getHeight(Activity activity) {
        float realHeight = getRealHeight(activity);
        if (hasNotchScreen(activity)) {
            realHeight -= getStatusBarHeight(activity);
        }
        return px2dip(activity, realHeight);
    }

    public static int getInt(String str, Activity activity) {
        if (!isMiui()) {
            return 0;
        }
        try {
            Class<?> clsLoadClass = activity.getClassLoader().loadClass(CountryCodeBean.ANDRIOD_SYSTEMPROP);
            return ((Integer) clsLoadClass.getMethod("getInt", String.class, Integer.TYPE).invoke(clsLoadClass, new String(str), new Integer(0))).intValue();
        } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static String getKllkDecryptString(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String str3 = "KLLK";
        if (str.contains("KLLK")) {
            str2 = BaseConstants.ROM_OPPO_UPPER_CONSTANT;
        } else {
            str3 = "kllk";
            if (!str.contains("kllk")) {
                return "";
            }
            str2 = "oppo";
        }
        return str.replace(str3, str2);
    }

    public static float getNavigationBarHeight(Context context) {
        int identifier = StubApp.getOrigApplicationContext(context.getApplicationContext()).getResources().getIdentifier("navigation_bar_height", "dimen", "android");
        if (identifier > 0) {
            return StubApp.getOrigApplicationContext(context.getApplicationContext()).getResources().getDimensionPixelSize(identifier);
        }
        return 0.0f;
    }

    public static int getNewScreenHeight(Context context) {
        return (int) (getStatusBarHeight(context) + getScreenHeightInPx(context));
    }

    public static int getRealHeight(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getRealMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public static int getScreenHeight(Context context) {
        return getScreenHeightC(context);
    }

    public static int getScreenHeightC(Context context) {
        try {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getRealMetrics(displayMetrics);
            return displayMetrics.heightPixels;
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static int getScreenHeightInPx(Context context) {
        return StubApp.getOrigApplicationContext(context.getApplicationContext()).getResources().getDisplayMetrics().heightPixels;
    }

    public static int[] getScreenSize(Context context, boolean z) {
        int[] iArr = {0, 0};
        if (context == null) {
            return iArr;
        }
        try {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getRealMetrics(displayMetrics);
            iArr[0] = z ? px2dip(context, displayMetrics.widthPixels) : displayMetrics.widthPixels;
            iArr[1] = z ? px2dip(context, displayMetrics.heightPixels) : displayMetrics.heightPixels;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return iArr;
    }

    public static int getScreenWidth(Context context) {
        return getScreenWidthC(context);
    }

    public static int getScreenWidthC(Context context) {
        try {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getRealMetrics(displayMetrics);
            return displayMetrics.widthPixels;
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static float getScreenWidthDp(Context context) {
        float f = context.getResources().getDisplayMetrics().density;
        float f2 = context.getResources().getDisplayMetrics().widthPixels;
        if (f <= 0.0f) {
            f = 1.0f;
        }
        return (f2 / f) + 0.5f;
    }

    public static int getScreenWidthInPx(Context context) {
        return StubApp.getOrigApplicationContext(context.getApplicationContext()).getResources().getDisplayMetrics().widthPixels;
    }

    public static float getStatusBarHeight(Context context) {
        int identifier = StubApp.getOrigApplicationContext(context.getApplicationContext()).getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return StubApp.getOrigApplicationContext(context.getApplicationContext()).getResources().getDimensionPixelSize(identifier);
        }
        return 0.0f;
    }

    public static int getWindowHeight(Context context) {
        try {
            return context.getResources().getDisplayMetrics().heightPixels;
        } catch (Exception e) {
            e.printStackTrace();
            return getScreenHeight(context);
        }
    }

    public static int getWindowWidth(Context context) {
        try {
            return context.getResources().getDisplayMetrics().widthPixels;
        } catch (Exception e) {
            e.printStackTrace();
            return getScreenWidth(context);
        }
    }

    public static boolean hasNotchAtHuawei(Context context) {
        try {
            Class<?> clsLoadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
            return ((Boolean) clsLoadClass.getMethod("hasNotchInScreen", new Class[0]).invoke(clsLoadClass, new Object[0])).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean hasNotchAtOPPO(Context context) {
        return context.getPackageManager().hasSystemFeature(getKllkDecryptString("com.kllk.feature.screen.heteromorphism"));
    }

    public static boolean hasNotchAtVivo(Context context) {
        try {
            Class<?> clsLoadClass = context.getClassLoader().loadClass("android.util.FtFeature");
            return ((Boolean) clsLoadClass.getMethod("isFeatureSupport", Integer.TYPE).invoke(clsLoadClass, 32)).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean hasNotchScreen(Activity activity) {
        return isAndroidPHasNotch(activity) || getInt("ro.miui.notch", activity) == 1 || hasNotchAtHuawei(activity) || hasNotchAtOPPO(activity) || hasNotchAtVivo(activity);
    }

    public static void hideBottomUIMenu(Activity activity) {
        if (activity == null) {
            return;
        }
        try {
            activity.getWindow().getDecorView().setSystemUiVisibility(3842);
            activity.getWindow().addFlags(C.BUFFER_FLAG_FIRST_SAMPLE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean isAndroidPHasNotch(Activity activity) {
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                WindowInsets rootWindowInsets = activity.getWindow().getDecorView().getRootWindowInsets();
                if ((rootWindowInsets != null ? rootWindowInsets.getDisplayCutout() : null) != null) {
                    return true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static boolean isFullScreen(Activity activity) {
        int systemUiVisibility = activity.getWindow().getDecorView().getSystemUiVisibility();
        return (systemUiVisibility & 4) == 4 && (systemUiVisibility & 2) == 2;
    }

    public static boolean isLandscape(Context context) {
        return isLandscape(context, 1.7777778f);
    }

    public static boolean isLandscape(Context context, float f) {
        try {
            Resources resources = context.getResources();
            int i = resources.getDisplayMetrics().heightPixels;
            int i2 = resources.getDisplayMetrics().widthPixels;
            Log.i(Util.TAG, "heightPixels:" + i + " ,widthPixels:" + i2 + " ,density:" + resources.getDisplayMetrics().density + " ,densityDpi:" + resources.getDisplayMetrics().densityDpi);
            return ((float) i2) * f > ((float) i);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean isMiui() {
        try {
            Class.forName("miui.os.Build");
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static int px2dip(Context context, float f) {
        return px2dipC(context, f);
    }

    public static int px2dipC(Context context, float f) {
        try {
            return (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f);
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static void removeFromParent(View view) {
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view);
            }
        }
    }

    public static void setViewSize(View view, int i, int i2) {
        ViewGroup.LayoutParams layoutParams;
        if (view.getParent() instanceof FrameLayout) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) view.getLayoutParams();
            layoutParams2.width = i;
            layoutParams2.height = i2;
            layoutParams = layoutParams2;
        } else if (view.getParent() instanceof RelativeLayout) {
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) view.getLayoutParams();
            layoutParams3.width = i;
            layoutParams3.height = i2;
            layoutParams = layoutParams3;
        } else {
            if (!(view.getParent() instanceof LinearLayout)) {
                return;
            }
            LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) view.getLayoutParams();
            layoutParams4.width = i;
            layoutParams4.height = i2;
            layoutParams = layoutParams4;
        }
        view.setLayoutParams(layoutParams);
        view.requestLayout();
    }
}
