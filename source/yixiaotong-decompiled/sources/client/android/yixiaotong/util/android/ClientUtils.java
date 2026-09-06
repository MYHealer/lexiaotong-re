package client.android.yixiaotong.util.android;

import android.content.Context;
import android.content.pm.PackageManager;
import client.android.yixiaotong.v3.util.LogUtil;
import java.util.Calendar;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class ClientUtils {
    public static void setFirstLoginApp(Context context, String str, boolean z) {
        new LocalPreferencesHelper(context, "app").saveOrUpdate("not_first_login_" + str, !z);
    }

    public static boolean isFirstLoginApp(Context context, String str) {
        return !new LocalPreferencesHelper(context, "app").getBooleanDefaultFalse("not_first_login_" + str);
    }

    public static void setFirstOpenApp(Context context, boolean z) {
        new LocalPreferencesHelper(context, "app").saveOrUpdate("not_first_open", z);
    }

    public static boolean isFirstOpenApp(Context context) {
        return !new LocalPreferencesHelper(context, "app").getBooleanDefaultFalse("not_first_open");
    }

    public static void setFirstOpenAppCurrentVersion(Context context, boolean z) {
        LocalPreferencesHelper localPreferencesHelper = new LocalPreferencesHelper(context, "app");
        try {
            int i = context.getPackageManager().getPackageInfo(context.getPackageName(), 64).versionCode;
            LogUtil.e("clientUtil", "setFirstOpenAppCurrentVersion:" + i);
            localPreferencesHelper.saveOrUpdate("not_first_open_" + i, z);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static boolean isFirstOpenAppCurrentVersion(Context context) {
        LocalPreferencesHelper localPreferencesHelper = new LocalPreferencesHelper(context, "app");
        try {
            int i = context.getPackageManager().getPackageInfo(context.getPackageName(), 64).versionCode;
            LogUtil.e("clientUtil", "isFirstOpenAppCurrentVersion:" + i);
            return !localPreferencesHelper.getBooleanDefaultFalse("not_first_open_" + i);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void setFirstOpenToday(Context context, boolean z) {
        new LocalPreferencesHelper(context, "app").saveOrUpdate("not_first_open_today_" + Calendar.getInstance().get(6), !z);
    }

    public static boolean isFirstOpenToday(Context context) {
        return !new LocalPreferencesHelper(context, "app").getBooleanDefaultFalse("not_first_open_today_" + Calendar.getInstance().get(6));
    }

    public static boolean isLoginInDevice(Context context, String str) {
        return new LocalPreferencesHelper(context, "app").getString("login_accounts").contains(str);
    }

    public static void setLoginInDevice(Context context, String str) {
        LocalPreferencesHelper localPreferencesHelper = new LocalPreferencesHelper(context, "app");
        if (localPreferencesHelper.getString("login_accounts").contains(str)) {
            return;
        }
        localPreferencesHelper.saveOrUpdate("login_accounts", localPreferencesHelper.getString("login_accounts") + "," + str);
    }

    public static void setIsLoginSuccess(Context context, boolean z) {
        new LocalPreferencesHelper(context, "login").saveOrUpdate("login_state", z);
    }

    public static boolean isLoginSuccess(Context context) {
        return new LocalPreferencesHelper(context, "login").getBooleanDefaultFalse("login_state");
    }
}
