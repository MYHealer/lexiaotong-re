package com.umeng.commonsdk.internal.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.stub.StubApp;

/* JADX INFO: compiled from: UMInternalUtils.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f9238a = "um_pri";
    private static final String b = "um_common_strength";
    private static final String c = "um_common_battery";

    public static String a(Context context) {
        SharedPreferences sharedPreferences;
        if (context == null || (sharedPreferences = StubApp.getOrigApplicationContext(context.getApplicationContext()).getSharedPreferences(f9238a, 0)) == null) {
            return null;
        }
        return sharedPreferences.getString(c, null);
    }

    public static void a(Context context, String str) {
        SharedPreferences sharedPreferences;
        if (context == null || TextUtils.isEmpty(str) || (sharedPreferences = StubApp.getOrigApplicationContext(context.getApplicationContext()).getSharedPreferences(f9238a, 0)) == null) {
            return;
        }
        sharedPreferences.edit().putString(c, str).commit();
    }
}
