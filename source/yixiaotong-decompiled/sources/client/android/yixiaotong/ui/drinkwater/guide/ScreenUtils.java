package client.android.yixiaotong.ui.drinkwater.guide;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class ScreenUtils {
    private ScreenUtils() {
        throw new AssertionError();
    }

    public static float dpToPx(Context context, float f) {
        if (context == null) {
            return -1.0f;
        }
        return f * context.getResources().getDisplayMetrics().density;
    }

    public static int dpToPx(Context context, int i) {
        return (int) (i * context.getResources().getDisplayMetrics().density);
    }

    public static int getScreenWidth(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int getScreenHeight(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static int getStatusBarHeight(Activity activity) {
        Rect rect = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        int i = rect.top;
        return i == 0 ? getStatusBarHeightByReflection(activity) : i;
    }

    public static int getStatusBarHeightByReflection(Context context) {
        try {
            Class<?> cls = Class.forName("com.android.internal.R$dimen");
            return context.getResources().getDimensionPixelSize(Integer.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString()));
        } catch (Exception e) {
            e.printStackTrace();
            return 38;
        }
    }
}
