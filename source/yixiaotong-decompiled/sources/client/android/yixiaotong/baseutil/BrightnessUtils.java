package client.android.yixiaotong.baseutil;

import android.app.Activity;
import android.content.ContentResolver;
import android.provider.Settings;
import android.view.WindowManager;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class BrightnessUtils {
    private BrightnessUtils() {
    }

    public static int getScreenBrightness(Activity activity) {
        if (activity == null) {
            return 0;
        }
        try {
            return Settings.System.getInt(activity.getContentResolver(), "screen_brightness");
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static void setBrightness(Activity activity, float f) {
        if (activity == null) {
            return;
        }
        try {
            WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
            attributes.screenBrightness = f;
            activity.getWindow().setAttributes(attributes);
        } catch (Exception unused) {
        }
    }

    public static boolean isAutoBrightness(ContentResolver contentResolver) {
        if (contentResolver == null) {
            return false;
        }
        try {
            return Settings.System.getInt(contentResolver, "screen_brightness_mode") == 1;
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void stopAutoBrightness(Activity activity) {
        if (activity == null) {
            return;
        }
        try {
            Settings.System.putInt(activity.getContentResolver(), "screen_brightness_mode", 0);
        } catch (Exception unused) {
        }
    }

    public static void startAutoBrightness(Activity activity) {
        if (activity == null) {
            return;
        }
        try {
            Settings.System.putInt(activity.getContentResolver(), "screen_brightness_mode", 1);
        } catch (Exception unused) {
        }
    }
}
