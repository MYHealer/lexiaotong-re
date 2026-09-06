package crossoverone.statuslib;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class StatusUtil {
    public static final int USE_CUR_COLOR = -2;
    public static final int USE_DEFAULT_COLOR = -1;
    public static int defaultColor_21 = Color.parseColor("#33000000");

    public static void setUseStatusBarColor(Activity activity, int i) {
        setUseStatusBarColor(activity, i, -2);
    }

    public static void setUseStatusBarColor(Activity activity, int i, int i2) {
        activity.getWindow().setStatusBarColor(i);
    }

    @Deprecated
    public static void setTransparentStatusBar(Activity activity) {
        setUseStatusBarColor(activity, 0);
    }

    public static void setSystemStatus(Activity activity, boolean z, boolean z2) {
        int i = z ? 1024 : 0;
        if (z2) {
            i |= 8192;
        }
        activity.getWindow().getDecorView().setSystemUiVisibility(i);
    }

    public static int getStatusBarHeight(Context context) {
        return getSizeByReflection(context, "status_bar_height");
    }

    public static int getNavigationBarHeight(Context context) {
        return getSizeByReflection(context, "navigation_bar_height");
    }

    public static int getSizeByReflection(Context context, String str) {
        try {
            Class<?> cls = Class.forName("com.android.internal.R$dimen");
            return context.getResources().getDimensionPixelSize(Integer.parseInt(cls.getField(str).get(cls.newInstance()).toString()));
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static void setNavigationBar(Activity activity, int i) {
        activity.getWindow().setNavigationBarColor(i);
    }
}
