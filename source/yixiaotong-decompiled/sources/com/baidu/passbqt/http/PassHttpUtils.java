package com.baidu.passbqt.http;

import android.util.Log;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
public class PassHttpUtils {
    private static final String b = "PassHttpUtils";
    private static final Pattern c = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f1938a = false;

    public static void a(String str, String str2) {
        if (f1938a) {
            Log.e(str, str2);
        }
    }

    public static void a(String str) {
        a(b, str);
    }

    public static boolean b(String str) {
        return c.matcher(str).matches();
    }
}
