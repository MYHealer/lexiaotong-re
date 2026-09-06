package com.byazt.mg;

import android.os.Build;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Locale;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 170, 54})
public class ve {
    public static boolean c;

    public static boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            str = c();
        }
        if (TextUtils.isEmpty(str) || !str.toLowerCase(Locale.getDefault()).startsWith("emotionui")) {
            return tt();
        }
        return true;
    }

    public static String c() {
        return tt("ro.build.version.emui");
    }

    private static String tt(String str) {
        BufferedReader bufferedReader;
        String line = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop ".concat(String.valueOf(str))).getInputStream()), 1024);
            try {
                line = bufferedReader.readLine();
                bufferedReader.close();
                a.c(bufferedReader);
                return line;
            } catch (Throwable unused) {
                a.c(bufferedReader);
                return line;
            }
        } catch (Throwable unused2) {
            bufferedReader = null;
        }
    }

    public static boolean tt() {
        try {
            return (!TextUtils.isEmpty(Build.BRAND) && Build.BRAND.toLowerCase(Locale.getDefault()).startsWith("huawei")) || (!TextUtils.isEmpty(Build.MANUFACTURER) && Build.MANUFACTURER.toLowerCase(Locale.getDefault()).startsWith("huawei"));
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean ve() {
        if (!c) {
            try {
                if (Class.forName("miui.os.Build") != null) {
                    com.byazt.jz.tt.c = true;
                    c = true;
                    return com.byazt.jz.tt.c;
                }
            } catch (Exception unused) {
            }
            c = true;
        }
        return com.byazt.jz.tt.c;
    }

    public static boolean uj() {
        return Build.DISPLAY.contains("Flyme") || Build.USER.equals("flyme");
    }
}
