package com.hihonor.hianalytics.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.hihonor.hianalytics.hnha.j2;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class p {
    public static long a(String str, String str2, long j) throws IllegalAccessException, InvocationTargetException {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            j2.b("SharedPreUtils", "getLong illegal spKey=" + str2 + ",spName=" + str);
            return j;
        }
        SharedPreferences sharedPreferencesC = c(str);
        return sharedPreferencesC != null ? sharedPreferencesC.getLong(str2, j) : j;
    }

    public static String a(Context context, String str) {
        String strH = com.hihonor.hianalytics.hnha.g.h();
        if (TextUtils.isEmpty(strH)) {
            strH = context.getPackageName();
        }
        return "hianalytics_" + str + "_" + strH;
    }

    public static String a(String str, String str2, String str3) throws IllegalAccessException, InvocationTargetException {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            j2.b("SharedPreUtils", "getString illegal spKey=" + str2 + ",spName=" + str);
            return str3;
        }
        SharedPreferences sharedPreferencesC = c(str);
        return sharedPreferencesC != null ? sharedPreferencesC.getString(str2, str3) : str3;
    }

    public static Set<String> a(SharedPreferences sharedPreferences) {
        return sharedPreferences.getAll().keySet();
    }

    private static void a(SharedPreferences sharedPreferences, Set<String> set, Map<String, String> map) {
        for (String str : set) {
            map.put(str, sharedPreferences.getString(str, ""));
        }
    }

    public static void a(String str) throws IllegalAccessException, InvocationTargetException {
        SharedPreferences sharedPreferencesC = c(str);
        if (sharedPreferencesC != null) {
            j2.c("SharedPreUtils", "begin clear data,type=" + str);
            SharedPreferences.Editor editorEdit = sharedPreferencesC.edit();
            editorEdit.clear();
            editorEdit.commit();
        }
    }

    public static synchronized void a(String str, boolean z) {
        j2.a("SharedPreUtils", "clearDataFile tag=" + str + ",isClearAll=" + z);
        SharedPreferences sharedPreferencesC = c("stat_v2_1");
        if (sharedPreferencesC != null) {
            SharedPreferences.Editor editorEdit = sharedPreferencesC.edit();
            if (z) {
                editorEdit.clear();
            } else {
                editorEdit.remove(str);
            }
            editorEdit.commit();
        }
        SharedPreferences sharedPreferencesC2 = c("cached_v2_1");
        if (sharedPreferencesC2 != null) {
            SharedPreferences.Editor editorEdit2 = sharedPreferencesC2.edit();
            if (z) {
                editorEdit2.clear();
            } else {
                editorEdit2.remove(str);
            }
            editorEdit2.commit();
        }
        SharedPreferences sharedPreferencesC3 = c("common_nc");
        if (sharedPreferencesC3 != null) {
            SharedPreferences.Editor editorEdit3 = sharedPreferencesC3.edit();
            if (z) {
                editorEdit3.clear();
            }
            editorEdit3.commit();
        }
    }

    public static boolean a(String str, String str2, boolean z) throws IllegalAccessException, InvocationTargetException {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            j2.b("SharedPreUtils", "getBoolean illegal spKey=" + str2 + ",spName=" + str);
            return z;
        }
        SharedPreferences sharedPreferencesC = c(str);
        return sharedPreferencesC != null ? sharedPreferencesC.getBoolean(str2, z) : z;
    }

    public static File b(Context context, String str) {
        return new File(context.getFilesDir(), "../shared_prefs/" + (a(context, str) + ".xml"));
    }

    public static Map<String, String> b(SharedPreferences sharedPreferences) {
        Set<String> setA = a(sharedPreferences);
        HashMap map = new HashMap(setA.size());
        a(sharedPreferences, setA, map);
        return map;
    }

    public static void b(String str) {
        if (TextUtils.isEmpty(str)) {
            j2.g("SharedPreUtils", "clearTypeDataByTag() eventTag is null or empty!");
            return;
        }
        if (!"_default_config_tag".equals(str)) {
            String str2 = str + "-oper";
            String str3 = str + "-maint";
            str = str + "-diffprivacy";
            a(str2, false);
            a(str3, false);
        }
        a(str, false);
    }

    public static void b(String str, String str2, long j) throws IllegalAccessException, InvocationTargetException {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            j2.b("SharedPreUtils", "putLong illegal spKey=" + str2 + ",spName=" + str);
            return;
        }
        SharedPreferences sharedPreferencesC = c(str);
        if (sharedPreferencesC != null) {
            SharedPreferences.Editor editorEdit = sharedPreferencesC.edit();
            editorEdit.putLong(str2, j);
            editorEdit.commit();
        }
    }

    public static void b(String str, String str2, String str3) throws IllegalAccessException, InvocationTargetException {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            j2.b("SharedPreUtils", "putString illegal spKey=" + str2 + ",spName=" + str);
            return;
        }
        SharedPreferences sharedPreferencesC = c(str);
        if (sharedPreferencesC != null) {
            SharedPreferences.Editor editorEdit = sharedPreferencesC.edit();
            editorEdit.putString(str2, str3);
            editorEdit.commit();
        }
    }

    public static void b(String str, String str2, boolean z) throws IllegalAccessException, InvocationTargetException {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            j2.b("SharedPreUtils", "putBoolean illegal spKey=" + str2 + ",spName=" + str);
            return;
        }
        SharedPreferences sharedPreferencesC = c(str);
        if (sharedPreferencesC != null) {
            SharedPreferences.Editor editorEdit = sharedPreferencesC.edit();
            editorEdit.putBoolean(str2, z);
            editorEdit.commit();
        }
    }

    public static long c(Context context, String str) {
        return b(context, str).length();
    }

    public static SharedPreferences c(String str) throws IllegalAccessException, InvocationTargetException {
        Context context = SystemUtils.getContext();
        if (context != null) {
            return context.getSharedPreferences(a(context, str), 0);
        }
        j2.b("SharedPreUtils", "getSPName : context is null");
        return null;
    }
}
