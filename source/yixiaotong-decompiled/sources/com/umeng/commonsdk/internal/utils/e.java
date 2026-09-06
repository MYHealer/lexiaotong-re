package com.umeng.commonsdk.internal.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.stub.StubApp;

/* JADX INFO: compiled from: InfoPreference.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f9237a = "info";
    private static final String b = "ua";

    public static void a(Context context, String str) {
        SharedPreferences sharedPreferences = StubApp.getOrigApplicationContext(context.getApplicationContext()).getSharedPreferences("info", 0);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString(b, str).commit();
        }
    }

    public static String a(Context context) {
        SharedPreferences sharedPreferences = StubApp.getOrigApplicationContext(context.getApplicationContext()).getSharedPreferences("info", 0);
        if (sharedPreferences != null) {
            return sharedPreferences.getString(b, null);
        }
        return null;
    }
}
