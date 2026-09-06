package com.byazt.wg;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 1071, 20})
public class c {
    public static boolean c(Context context) {
        try {
            String lowerCase = Build.MANUFACTURER.toLowerCase();
            if (!lowerCase.contains("huawei") && !lowerCase.contains("honor")) {
                if (lowerCase.contains("vivo")) {
                    return uj(context);
                }
                if (lowerCase.contains("oppo")) {
                    return n(context);
                }
                if (!lowerCase.contains(MediationConstant.ADN_XIAOMI) && !lowerCase.contains("redmi")) {
                    if (lowerCase.contains("samsung")) {
                        return false;
                    }
                    return a(context);
                }
                return ve(context);
            }
            return tt(context);
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean c() {
        String lowerCase = Build.MANUFACTURER.toLowerCase();
        return lowerCase.contains("huawei") || lowerCase.contains("honor") || lowerCase.contains("vivo") || lowerCase.contains(MediationConstant.ADN_XIAOMI) || lowerCase.contains("redmi") || lowerCase.contains("oppo");
    }

    private static boolean tt(Context context) {
        return Settings.Global.getInt(context.getContentResolver(), "navigationbar_is_min", 0) != 0;
    }

    private static boolean ve(Context context) {
        return Settings.Global.getInt(context.getContentResolver(), "force_fsg_nav_bar", 0) != 0;
    }

    private static boolean uj(Context context) {
        return Settings.Secure.getInt(context.getContentResolver(), "navigation_gesture_on", 0) != 0;
    }

    private static boolean n(Context context) {
        return Settings.Secure.getInt(context.getContentResolver(), "hide_navigationbar_enable", 0) != 0;
    }

    private static boolean a(Context context) {
        return Settings.Global.getInt(context.getContentResolver(), "navigationbar_is_min", 0) != 0;
    }
}
