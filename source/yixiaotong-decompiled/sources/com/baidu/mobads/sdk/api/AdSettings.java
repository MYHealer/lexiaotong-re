package com.baidu.mobads.sdk.api;

import com.baidu.mobads.sdk.internal.co;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class AdSettings {
    public static String getSDKVersion() {
        return co.c() + "";
    }

    public static void setNotificationIcon(int i) {
        CustomNotification.setNotificationIcon(i);
    }

    public static void setNotificationChannel(String str) {
        CustomNotification.setNotificationChannel(str);
    }
}
