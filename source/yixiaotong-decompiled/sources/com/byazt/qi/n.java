package com.byazt.qi;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.telephony.TelephonyManager;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 527, 46})
public class n {
    public static volatile boolean c;

    public static void c(Context context) {
        if (c || context == null) {
            return;
        }
        tt(context);
        ve(context);
        uj(context);
        n(context);
        c = true;
    }

    private static void tt(Context context) {
        boolean booleanExtra = true;
        double intExtra = -0.1d;
        try {
            Intent intentRegisterReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (intentRegisterReceiver != null) {
                booleanExtra = intentRegisterReceiver.getBooleanExtra("present", false);
                intExtra = ((double) intentRegisterReceiver.getIntExtra("temperature", -1)) / 10.0d;
            }
        } catch (Throwable unused) {
        }
        a.c(1006, new Object[]{Boolean.valueOf(booleanExtra), Double.valueOf(intExtra)});
    }

    private static void ve(Context context) {
        int i;
        int i2;
        CameraManager cameraManager = (CameraManager) context.getSystemService("camera");
        if (cameraManager != null) {
            try {
                i = 0;
                i2 = 0;
                for (String str : cameraManager.getCameraIdList()) {
                    int iIntValue = ((Integer) cameraManager.getCameraCharacteristics(str).get(CameraCharacteristics.LENS_FACING)).intValue();
                    if (iIntValue == 0) {
                        i++;
                    } else if (iIntValue == 1) {
                        i2++;
                    }
                }
            } catch (Throwable unused) {
                i = -1;
                i2 = i;
            }
            a.c(1007, new Object[]{Integer.valueOf(Build.VERSION.SDK_INT), Integer.valueOf(i), Integer.valueOf(i2)});
        }
        i = -2;
        i2 = i;
        a.c(1007, new Object[]{Integer.valueOf(Build.VERSION.SDK_INT), Integer.valueOf(i), Integer.valueOf(i2)});
    }

    private static void uj(Context context) {
        Configuration configuration = context.getResources().getConfiguration();
        boolean z = true;
        if (configuration != null && (configuration.touchscreen == 1 || configuration.touchscreen == 0)) {
            z = false;
        }
        a.c(1008, new Object[]{Boolean.valueOf(z)});
    }

    private static void n(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        a.c(1009, new Object[]{Integer.valueOf(telephonyManager != null ? telephonyManager.getSimState() : -1)});
    }
}
