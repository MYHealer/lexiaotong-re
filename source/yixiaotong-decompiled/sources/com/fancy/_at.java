package com.fancy;

import android.content.Context;
import android.os.BatteryManager;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _at {
    public static int _a(Context context) {
        try {
            return ((BatteryManager) context.getSystemService("batterymanager")).getIntProperty(4);
        } catch (Exception unused) {
            return 0;
        }
    }

    public static boolean _b(Context context) {
        try {
            return ((BatteryManager) context.getSystemService("batterymanager")).isCharging();
        } catch (Exception unused) {
            return false;
        }
    }
}
