package com.ubixnow.ooooo;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.stub.StubApp;
import com.yfanads.android.qapp.Val;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class O0OO00 {
    private static String OooO00o;
    private static Bundle OooO0O0;

    public static Bundle OooO00o(Context context) {
        if (OooO0O0 == null) {
            try {
                OooO0O0 = StubApp.getOrigApplicationContext(context.getApplicationContext()).getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            } catch (PackageManager.NameNotFoundException e) {
                ooooO000.OooO00o(e);
            }
        }
        Bundle bundle = OooO0O0;
        return bundle == null ? new Bundle() : bundle;
    }

    private static String OooO00o() {
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                return Application.getProcessName();
            }
            String strOooO0OO = OooO0OO();
            return TextUtils.isEmpty(strOooO0OO) ? OooO0O0() : strOooO0OO;
        } catch (Exception e) {
            ooooO000.OooO00o(e);
            return null;
        }
    }

    public static boolean OooO00o(Context context, Bundle bundle) {
        if (context == null) {
            return false;
        }
        String strOooO0Oo = OooO0Oo(context);
        if (TextUtils.isEmpty(strOooO0Oo) && bundle != null) {
            strOooO0Oo = bundle.getString("com.sensorsdata.analytics.android.MainProcessName");
        }
        if (TextUtils.isEmpty(strOooO0Oo)) {
            return true;
        }
        String strOooO00o = OooO00o();
        return TextUtils.isEmpty(strOooO00o) || strOooO0Oo.equals(strOooO00o);
    }

    public static CharSequence OooO0O0(Context context) {
        if (context == null) {
            return "";
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            return packageManager.getApplicationInfo(context.getPackageName(), 128).loadLabel(packageManager);
        } catch (Exception e) {
            ooooO000.OooO00o(e);
            return "";
        }
    }

    private static String OooO0O0() {
        try {
            Method declaredMethod = Class.forName(Val.AT, false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(null, new Object[0]);
            if (objInvoke instanceof String) {
                return (String) objInvoke;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String OooO0OO() {
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream("/proc/self/cmdline");
            try {
                byte[] bArr = new byte[256];
                int i = 0;
                while (true) {
                    int i2 = fileInputStream.read();
                    if (i2 <= 0 || i >= 256) {
                        break;
                    }
                    bArr[i] = (byte) i2;
                    i++;
                }
                if (i > 0) {
                    String str = new String(bArr, 0, i, "UTF-8");
                    try {
                        fileInputStream.close();
                    } catch (IOException e) {
                        ooooO000.OooO00o(e);
                    }
                    return str;
                }
            } catch (Throwable unused) {
                if (fileInputStream != null) {
                }
                return null;
            }
        } catch (Throwable unused2) {
            fileInputStream = null;
        }
        try {
            fileInputStream.close();
        } catch (IOException e2) {
            ooooO000.OooO00o(e2);
        }
        return null;
    }

    public static String OooO0OO(Context context) {
        if (context == null) {
            return "";
        }
        if (!TextUtils.isEmpty(OooO00o)) {
            return OooO00o;
        }
        try {
            OooO00o = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
        return OooO00o;
    }

    public static String OooO0Oo(Context context) {
        if (context == null) {
            return "";
        }
        try {
            return StubApp.getOrigApplicationContext(context.getApplicationContext()).getApplicationInfo().processName;
        } catch (Exception e) {
            ooooO000.OooO00o(e);
            return "";
        }
    }

    public static boolean OooO0Oo() {
        return TextUtils.equals(oOO0OOO.OooO0O0, Thread.currentThread().getName());
    }

    public static String OooO0o0(Context context) {
        if (context == null) {
            return "";
        }
        try {
            return context.getApplicationInfo().processName;
        } catch (Exception e) {
            ooooO000.OooO00o(e);
            return "";
        }
    }
}
