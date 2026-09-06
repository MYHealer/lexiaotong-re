package com.opos.mobad.s;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class c {
    public static long a(Context context, String str, long j) {
        SharedPreferences sharedPreferencesA = a(context);
        if (sharedPreferencesA != null) {
            j = sharedPreferencesA.getLong(str, j);
        }
        com.opos.cmn.an.f.a.b("SPUtils", "getLong = " + j);
        return j;
    }

    public static final SharedPreferences a(Context context) {
        if (context == null) {
            return null;
        }
        return context.getSharedPreferences("com.opos.mobad.utils.prefs", 0);
    }

    public static String a(Context context, String str, String str2) {
        SharedPreferences sharedPreferencesA = a(context);
        if (sharedPreferencesA != null) {
            str2 = sharedPreferencesA.getString(str, str2);
        }
        com.opos.cmn.an.f.a.b("SPUtils", "getString = " + str2);
        return str2;
    }

    public static void b(Context context, String str, long j) {
        SharedPreferences sharedPreferencesA = a(context);
        if (sharedPreferencesA != null) {
            SharedPreferences.Editor editorEdit = sharedPreferencesA.edit();
            editorEdit.putLong(str, j);
            editorEdit.apply();
            com.opos.cmn.an.f.a.b("SPUtils", "setLong key = " + str + " value = " + j);
        }
    }

    public static void b(Context context, String str, String str2) {
        SharedPreferences sharedPreferencesA = a(context);
        if (sharedPreferencesA != null) {
            SharedPreferences.Editor editorEdit = sharedPreferencesA.edit();
            editorEdit.putString(str, str2);
            editorEdit.apply();
            com.opos.cmn.an.f.a.b("SPUtils", "setString key = " + str + " value = " + str2);
        }
    }
}
