package com.fancy;

import android.content.Context;
import androidx.core.app.NotificationManagerCompat;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _hi {
    public static boolean _a(Context context) {
        if (context != null) {
            try {
                return NotificationManagerCompat.from(context).areNotificationsEnabled();
            } catch (Exception unused) {
            }
        }
        return false;
    }
}
