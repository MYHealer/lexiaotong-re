package com.hihonor.hianalytics.util;

import android.text.TextUtils;
import com.hihonor.hianalytics.hnha.j2;
import com.huawei.openalliance.ad.constant.x;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public final class b {
    public static float a(String str, float f) {
        try {
            return TextUtils.isEmpty(str) ? f : Float.parseFloat(str);
        } catch (Throwable th) {
            j2.g("BasicUtils", "parseFloat fail=" + SystemUtils.getDesensitizedException(th));
            return f;
        }
    }

    public static int a(int i, int i2) {
        return i + ((int) (Math.random() * ((double) (i2 - i))));
    }

    public static int a(String str, int i) {
        try {
            return TextUtils.isEmpty(str) ? i : Integer.parseInt(str);
        } catch (Throwable th) {
            j2.g("BasicUtils", "parseInt fail=" + SystemUtils.getDesensitizedException(th));
            return i;
        }
    }

    public static long a(String str, long j) {
        try {
            return TextUtils.isEmpty(str) ? j : Long.parseLong(str);
        } catch (Throwable th) {
            j2.g("BasicUtils", "parseLong fail=" + SystemUtils.getDesensitizedException(th));
            return j;
        }
    }

    public static <T> T a(Set<T> set, T t) {
        if (set != null && !set.isEmpty() && set.contains(t)) {
            for (T t2 : set) {
                if (Objects.equals(t2, t)) {
                    return t2;
                }
            }
        }
        return null;
    }

    public static String a(String str) {
        StringBuilder sb = new StringBuilder("hianalytics_");
        sb.append(str);
        String strH = com.hihonor.hianalytics.hnha.g.h();
        if (strH != null && strH.trim().length() > 0) {
            sb.append(strH.trim()).append("_");
        }
        String processName = SystemUtils.getProcessName();
        sb.append(processName.trim().length() > 0 ? processName.replace(x.bQ, "_") : SystemUtils.f());
        return sb.toString();
    }

    public static String a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        int iLastIndexOf = str.lastIndexOf(x.bQ);
        if (iLastIndexOf < 0 || iLastIndexOf >= str.length() - 1) {
            return str.equals(SystemUtils.f()) ? str2 : str;
        }
        return str.substring(iLastIndexOf + 1);
    }

    public static boolean a(String str, boolean z) {
        try {
            return TextUtils.isEmpty(str) ? z : Boolean.parseBoolean(str);
        } catch (Throwable th) {
            j2.g("BasicUtils", "parseBoolean fail=" + SystemUtils.getDesensitizedException(th));
            return z;
        }
    }

    public static String b(String str) {
        return a(str, "main");
    }

    public static boolean c(String str) {
        if (str == null) {
            return true;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
