package com.hihonor.hianalytics.util;

import android.os.SystemClock;
import android.text.TextUtils;
import com.hihonor.hianalytics.hnha.j2;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public final class r {
    public static long a() {
        return SystemClock.elapsedRealtimeNanos();
    }

    public static long a(int i) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(1, i);
        return calendar.getTimeInMillis();
    }

    public static long a(boolean z) {
        return z ? SystemClock.elapsedRealtime() : SystemClock.uptimeMillis();
    }

    public static String a(long j) {
        return a("yyyy-MM-dd HH:mm:ss.SSS", j);
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "yyyy-MM-dd HH:mm:ss.SSS";
        }
        return a(str, System.currentTimeMillis());
    }

    public static String a(String str, long j) {
        return a(str, Locale.getDefault(), TimeZone.getDefault(), j);
    }

    public static String a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            str = "XXX";
        }
        try {
            return new SimpleDateFormat(str, Locale.getDefault()).format(Calendar.getInstance().getTime());
        } catch (Throwable th) {
            j2.g("TimeUtils", "getTimeZoneDesc fail=" + SystemUtils.getDesensitizedException(th));
            return str2;
        }
    }

    public static String a(String str, Locale locale, TimeZone timeZone, long j) {
        if (TextUtils.isEmpty(str)) {
            str = "yyyy-MM-dd HH:mm:ss.SSS";
        }
        if (locale == null) {
            locale = Locale.getDefault();
        }
        if (timeZone == null) {
            timeZone = TimeZone.getDefault();
        }
        try {
            Calendar calendar = Calendar.getInstance(timeZone);
            calendar.setTimeInMillis(j);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, locale);
            simpleDateFormat.setTimeZone(timeZone);
            return simpleDateFormat.format(calendar.getTime());
        } catch (Throwable th) {
            j2.g("TimeUtils", "formatTime fail=" + SystemUtils.getDesensitizedException(th));
            return String.valueOf(j);
        }
    }

    public static String a(String str, TimeZone timeZone, long j) {
        return a(str, Locale.getDefault(), timeZone, j);
    }

    public static long b() {
        return System.currentTimeMillis();
    }

    public static String b(int i) {
        return i > 0 ? a("dd-HH:mm:ss", TimeZone.getTimeZone("GMT"), ((long) i) * 1000) : String.valueOf(i);
    }

    public static String b(long j) {
        long j2 = j / 1000000;
        return (j2 / 1000) + "." + (j2 % 1000) + "." + (j % 1000000);
    }

    public static int c() {
        return (int) (b() / 1000);
    }

    public static long c(long j) {
        return (j / 1000) / 1000;
    }

    public static long d() {
        return d(b());
    }

    public static long d(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    public static String e() {
        return a("XXX", "");
    }

    public static String e(long j) {
        return b(a() - j);
    }

    public static String f(long j) {
        return j > 0 ? a("dd-HH:mm:ss.SSS", TimeZone.getTimeZone("GMT"), j) : String.valueOf(j);
    }
}
