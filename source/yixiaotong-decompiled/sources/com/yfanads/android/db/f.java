package com.yfanads.android.db;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.yfanads.android.libs.utils.DeviceUtils;
import com.yfanads.android.libs.utils.Util;
import com.yfanads.android.utils.YFTimeUtils;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: PreferenceUtils.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicLong f9646a = new AtomicLong(0);

    public static void a(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(DeviceUtils.SP_NAME, 0);
        long j = sharedPreferences.getLong("init_time_long", 0L);
        long j2 = sharedPreferences.getLong("last_time_long", 0L);
        long currentTime = Util.getCurrentTime() / 1000;
        if (j != 0 && currentTime - j2 < 5184000) {
            f9646a.set(j);
            context.getSharedPreferences(DeviceUtils.SP_NAME, 0).edit().putLong("last_time_long", currentTime).apply();
            return;
        }
        f9646a.set(currentTime);
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(DeviceUtils.SP_NAME, 0).edit();
        editorEdit.putLong("init_time_long", currentTime);
        editorEdit.putLong("last_time_long", currentTime);
        editorEdit.apply();
    }

    public static String a(Context context, String str, String str2) {
        return context.getSharedPreferences(DeviceUtils.SP_NAME, 0).getString(str + "&" + str2, "");
    }

    public static void a(Context context, String str) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(DeviceUtils.SP_NAME, 0).edit();
        SharedPreferences sharedPreferences = context.getSharedPreferences(DeviceUtils.SP_NAME, 0);
        int iA = a(5, sharedPreferences.getString("dayT&" + str, ""));
        int iA2 = a(11, sharedPreferences.getString("hourT&" + str, ""));
        editorEdit.putString(e.a("timeT&", str), System.currentTimeMillis() + "&0");
        editorEdit.putString("dayT&" + str, System.currentTimeMillis() + "&" + iA);
        editorEdit.putString(e.a("hourT&", str), System.currentTimeMillis() + "&" + iA2);
        editorEdit.apply();
    }

    public static int a(int i, String str) {
        int i2;
        if (TextUtils.isEmpty(str)) {
            return 1;
        }
        try {
            String[] strArrSplit = str.split("&");
            if (strArrSplit.length < 2) {
                return 1;
            }
            if (i == 5) {
                if (!YFTimeUtils.isEquals(strArrSplit[0], i)) {
                    return 1;
                }
                i2 = Integer.parseInt(strArrSplit[1]);
            } else {
                if (!YFTimeUtils.isEqualsHour(strArrSplit[0])) {
                    return 1;
                }
                i2 = Integer.parseInt(strArrSplit[1]);
            }
            return 1 + i2;
        } catch (Exception e) {
            com.yfanads.android.core.f.a(e, new StringBuilder("saveFrequencyTime getShowNum exception "));
            return 1;
        }
    }
}
