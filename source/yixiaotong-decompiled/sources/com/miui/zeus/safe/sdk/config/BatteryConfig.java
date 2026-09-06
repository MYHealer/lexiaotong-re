package com.miui.zeus.safe.sdk.config;

import android.content.Intent;
import android.content.IntentFilter;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.miui.zeus.safe.sdk.a;
import ijiami_1011.s.s.s;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class BatteryConfig {

    public static class BatteryInfo {
        private int batteryLevel;
        private int batteryPlugged;
        private int batteryStatus;

        public BatteryInfo(int i, int i2, int i3) {
            this.batteryLevel = i;
            this.batteryStatus = i2;
            this.batteryPlugged = i3;
        }

        public int getBatteryLevel() {
            return this.batteryLevel;
        }

        public int getBatteryPlugged() {
            return this.batteryPlugged;
        }

        public int getBatteryStatus() {
            return this.batteryStatus;
        }
    }

    public BatteryInfo getBatteryInfo() {
        int intExtra;
        int intExtra2;
        Intent intentRegisterReceiver = a.a().registerReceiver(null, new IntentFilter(s.d(new byte[]{2, 89, 86, SignedBytes.MAX_POWER_OF_TWO, 86, 90, 5, 74, 15, 12, 69, 0, 13, 67, Ascii.FS, 83, 90, 71, 8, 11, 8, 76, 115, 36, 55, 99, 119, 96, 96, 108, 34, 44, 39, 44, 118, 32, 39}, "c72293")));
        int i = -1;
        if (intentRegisterReceiver != null) {
            int intExtra3 = intentRegisterReceiver.getIntExtra(s.d(new byte[]{91, 84, 69, 81, 89}, "71345b"), -1);
            int intExtra4 = intentRegisterReceiver.getIntExtra(s.d(new byte[]{Ascii.DC2, 82, 5, 84, 6}, "a1d8c7"), -1);
            intExtra = intentRegisterReceiver.getIntExtra(s.d(new byte[]{69, 67, 86, 77, 71, 66}, "677921"), -1);
            int i2 = (intExtra3 < 0 || intExtra4 <= 0) ? -1 : (intExtra3 * 100) / intExtra4;
            intExtra2 = intentRegisterReceiver.getIntExtra(s.d(new byte[]{SignedBytes.MAX_POWER_OF_TWO, 13, 70, 83, 95, 86, 5}, "0a3483"), -1);
            i = i2;
        } else {
            intExtra = 1;
            intExtra2 = -1;
        }
        return new BatteryInfo(i, intExtra, intExtra2);
    }
}
