package com.miui.zeus.safe.sdk.config;

import android.content.Intent;
import android.content.IntentFilter;
import com.google.common.base.Ascii;
import com.miui.zeus.safe.sdk.a;
import ijiami_1011.s.s.s;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class UsbConfig {

    public static class UsbInfo {
        private boolean isConnected;
        private int usbFunction;

        public UsbInfo(boolean z, int i) {
            this.isConnected = z;
            this.usbFunction = i;
        }

        public int getUsbFunction() {
            return this.usbFunction;
        }

        public boolean isConnected() {
            return this.isConnected;
        }
    }

    public UsbInfo getUsbInfo() {
        boolean booleanExtra;
        boolean z = false;
        int i = -1;
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(s.d(new byte[]{85, 8, 5, Ascii.DC4, 90, 10, 5, 74, 14, 3, 67, 1, 67, 7, 19, 3, Ascii.ESC, Ascii.SYN, Ascii.DC2, 6, 72, 3, 82, 17, 93, 9, 15, 72, 96, 48, 35, 59, 53, 54, 112, 49, 113}, "4faf5c"));
            Intent intentRegisterReceiver = a.a().registerReceiver(null, intentFilter);
            booleanExtra = intentRegisterReceiver.getBooleanExtra(s.d(new byte[]{0, 14, 93, 95, 87, 5, Ascii.NAK, 1, 2}, "ca312f"), false);
            try {
                if (intentRegisterReceiver.getBooleanExtra(s.d(new byte[]{15, 76, 72}, "b8887b"), false)) {
                    i = 1;
                } else if (intentRegisterReceiver.getBooleanExtra(s.d(new byte[]{Ascii.DC2, Ascii.SYN, 71}, "bb7ce7"), false)) {
                    i = 2;
                } else if (intentRegisterReceiver.getBooleanExtra(s.d(new byte[]{4, 85, 80}, "e12f35"), false)) {
                    i = 3;
                }
            } catch (Throwable unused) {
                z = booleanExtra;
                booleanExtra = z;
            }
        } catch (Throwable unused2) {
        }
        return new UsbInfo(booleanExtra, i);
    }
}
