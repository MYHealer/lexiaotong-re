package com.ubix.ssp.ad.e.a0;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class v {
    public static int a(Context context, String str, String str2, int i) {
        return context.getSharedPreferences(str, 0).getInt(str2, i);
    }

    public static Boolean a(Context context, String str, String str2) {
        return Boolean.valueOf(context.getSharedPreferences(str, 0).getBoolean(str2, false));
    }

    public static Boolean a(Context context, String str, String str2, long j) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(str, 0).edit();
        editorEdit.putLong(str2, j);
        return Boolean.valueOf(editorEdit.commit());
    }

    public static Boolean a(Context context, String str, String str2, Boolean bool) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(str, 0).edit();
        editorEdit.putBoolean(str2, bool.booleanValue());
        return Boolean.valueOf(editorEdit.commit());
    }

    public static String a(Context context, String str, String str2, String str3) {
        return context.getSharedPreferences(str, 0).getString(str2, str3);
    }

    public static int b(Context context, String str, String str2) {
        return context.getSharedPreferences(str, 0).getInt(str2, -1);
    }

    public static Boolean b(Context context, String str, String str2, int i) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(str, 0).edit();
        editorEdit.putInt(str2, i);
        return Boolean.valueOf(editorEdit.commit());
    }

    public static Boolean b(Context context, String str, String str2, String str3) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(str, 0).edit();
        editorEdit.putString(str2, str3);
        return Boolean.valueOf(editorEdit.commit());
    }

    public static long c(Context context, String str, String str2) {
        return context.getSharedPreferences(str, 0).getLong(str2, 0L);
    }

    public static String d(Context context, String str, String str2) {
        return context.getSharedPreferences(str, 0).getString(str2, "");
    }
}
