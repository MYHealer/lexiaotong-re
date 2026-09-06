package com.kwad.sdk.utils;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class bv {
    public static void a(long j, int i, Context context) {
        if (j == 0 || context == null || i <= 0 || i > 100) {
            return;
        }
        long jCurrentTimeMillis = j - System.currentTimeMillis();
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("ksadsdk_pref", 0);
            if (sharedPreferences == null) {
                return;
            }
            if (Math.abs(jCurrentTimeMillis) / com.kuaishou.weapon.p0.bg.s > i) {
                sharedPreferences.edit().putLong("key_time_diff_s2c", jCurrentTimeMillis).apply();
            } else {
                sharedPreferences.edit().remove("key_time_diff_s2c").apply();
            }
        } catch (Throwable unused) {
        }
    }

    public static long C(Context context, boolean z) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (!z) {
            return jCurrentTimeMillis;
        }
        if (context != null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("ksadsdk_pref", 0);
            if (sharedPreferences == null) {
                return Math.abs(jCurrentTimeMillis);
            }
            long j = sharedPreferences.getLong("key_time_diff_s2c", 0L);
            if (j != 0) {
                return jCurrentTimeMillis + j;
            }
        }
        return Math.abs(jCurrentTimeMillis);
    }
}
