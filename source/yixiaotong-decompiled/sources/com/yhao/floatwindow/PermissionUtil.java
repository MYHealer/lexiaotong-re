package com.yhao.floatwindow;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Binder;
import android.os.Build;
import android.provider.Settings;
import android.view.View;
import android.view.WindowManager;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
class PermissionUtil {
    PermissionUtil() {
    }

    static boolean hasPermission(Context context) {
        return Settings.canDrawOverlays(context);
    }

    static boolean hasPermissionOnActivityResult(Context context) {
        if (Build.VERSION.SDK_INT == 26) {
            return hasPermissionForO(context);
        }
        return Settings.canDrawOverlays(context);
    }

    static boolean hasPermissionBelowMarshmallow(Context context) {
        try {
            return ((Integer) AppOpsManager.class.getMethod("checkOp", Integer.TYPE, Integer.TYPE, String.class).invoke((AppOpsManager) context.getSystemService("appops"), 24, Integer.valueOf(Binder.getCallingUid()), StubApp.getOrigApplicationContext(context.getApplicationContext()).getPackageName())).intValue() == 0;
        } catch (Exception unused) {
            return false;
        }
    }

    private static boolean hasPermissionForO(Context context) {
        try {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (windowManager == null) {
                return false;
            }
            View view = new View(context);
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(0, 0, 2038, 24, -2);
            view.setLayoutParams(layoutParams);
            windowManager.addView(view, layoutParams);
            windowManager.removeView(view);
            return true;
        } catch (Exception e) {
            LogUtil.e("hasPermissionForO e:" + e.toString());
            return false;
        }
    }
}
