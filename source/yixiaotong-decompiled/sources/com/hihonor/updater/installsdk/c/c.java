package com.hihonor.updater.installsdk.c;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import android.provider.Settings;
import com.byazt.hv.TTDownloadField;
import com.hihonor.updater.installsdk.api.DIResultCode;
import com.hihonor.updater.installsdk.exception.GetSettingValueException;
import com.stub.StubApp;
import java.util.Objects;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f3738a = "c";
    private static long b = 0;
    private static int c = -1;
    private static final String d = "download_install_support_version";
    private static final String e = "com.hihonor.systemappsupdater";
    public static final String f = "sys_update_service_state";
    public static final int g = 0;
    private static final int h = 160010300;
    private static final String i = "appFeature";
    private static final String j = "inland";

    private static int a(Context context, String str, int i2) throws GetSettingValueException {
        try {
            return Settings.System.getInt(StubApp.getOrigApplicationContext(context.getApplicationContext()).getContentResolver(), str, i2);
        } catch (Throwable th) {
            a.b(f3738a, "settings getInt error " + th);
            throw new GetSettingValueException(th.toString());
        }
    }

    public static PackageInfo a(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0);
        } catch (Throwable th) {
            a.b(f3738a, "getAppInfo error " + th);
            return null;
        }
    }

    public static String a(int i2) {
        if (i2 == 0) {
            return "success";
        }
        switch (i2) {
            case 3001:
                return "unsupported version";
            case 3002:
                return "call too frequency";
            case 3003:
                return "params error";
            case 3004:
                return "connect failed";
            case 3005:
                return "failed send msg";
            default:
                switch (i2) {
                    case DIResultCode.UNSUPPORTED_ACTION /* 3101 */:
                        return "unsupported action";
                    case DIResultCode.AGREEMENT_NOT_AGREED /* 3102 */:
                        return "agreement not yet agreed";
                    case 3103:
                        return "unsupport caller";
                    case DIResultCode.SIGN_VERIFY_FAILED /* 3104 */:
                        return "caller sign verify failed";
                    case DIResultCode.DI_INFO_VERIFY_FAILED /* 3105 */:
                        return "download info verify failed";
                    case DIResultCode.APP_INFO_NOT_EXIST /* 3106 */:
                        return "app info not exist";
                    case DIResultCode.NO_NETWORK /* 3107 */:
                        return "no network";
                    case DIResultCode.NO_EXTERNAL /* 3108 */:
                        return "storage space not enough";
                    case DIResultCode.APP_IN_UPDATE_LIST /* 3109 */:
                        return "unsupport app";
                    default:
                        return "";
                }
        }
    }

    public static String a(PackageInfo packageInfo) {
        if (packageInfo == null) {
            return null;
        }
        return Build.VERSION.SDK_INT < 28 ? String.valueOf(packageInfo.versionCode) : String.valueOf(packageInfo.getLongVersionCode());
    }

    public static boolean a() {
        return a(-1, 500L);
    }

    public static synchronized boolean a(int i2, long j2) {
        boolean z;
        long jUptimeMillis = SystemClock.uptimeMillis();
        long j3 = b;
        z = c == i2 && j3 > 0 && jUptimeMillis - j3 < j2;
        b = jUptimeMillis;
        c = i2;
        return z;
    }

    public static boolean a(Context context) {
        return b(context, "com.hihonor.systemappsupdater", d) > 0.0f;
    }

    public static boolean a(Context context, String str, String str2) {
        try {
            return context.getPackageManager().getApplicationInfo(str, 128).metaData.getBoolean(str2);
        } catch (Throwable th) {
            a.b(f3738a, "getBooleanData() error " + th);
            return false;
        }
    }

    public static boolean a(JSONObject jSONObject, String str) {
        try {
            return jSONObject.getBoolean(str);
        } catch (Throwable unused) {
            return false;
        }
    }

    public static float b(Context context, String str, String str2) {
        try {
            return context.getPackageManager().getApplicationInfo(str, 128).metaData.getFloat(str2);
        } catch (Throwable th) {
            a.b(f3738a, "getFloatData() error " + th);
            return 0.0f;
        }
    }

    public static int b(JSONObject jSONObject, String str) {
        try {
            return jSONObject.getInt(str);
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static String b(Context context) {
        try {
            int iMyPid = Process.myPid();
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY)).getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == iMyPid) {
                    return runningAppProcessInfo.processName;
                }
            }
            return "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static long c(JSONObject jSONObject, String str) {
        try {
            return jSONObject.getLong(str);
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public static String c(Context context, String str, String str2) {
        try {
            return context.getPackageManager().getApplicationInfo(str, 128).metaData.getString(str2);
        } catch (Throwable th) {
            a.b(f3738a, "getMetaData() error " + th);
            return "";
        }
    }

    public static boolean c(Context context) {
        String strC = c(context, "com.hihonor.systemappsupdater", i);
        String str = f3738a;
        a.c(str, "feature=" + strC);
        if (!Objects.equals(strC, j)) {
            return false;
        }
        try {
            long j2 = Long.parseLong(a(a(StubApp.getOrigApplicationContext(context.getApplicationContext()), "com.hihonor.systemappsupdater")));
            a.c(str, "updater version code=" + j2);
            return j2 >= 160010300;
        } catch (Throwable th) {
            a.b(f3738a, "isSwitchLimitVersion() error " + th);
        }
    }

    public static String d(JSONObject jSONObject, String str) {
        try {
            return jSONObject.getString(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean d(Context context) throws GetSettingValueException {
        int iA = a(context, f, 0);
        a.c(f3738a, "settings value=" + iA);
        return iA > 0;
    }

    public static boolean e(Context context) {
        return b(context, "com.hihonor.systemappsupdater", d) > 1.0f;
    }
}
