package com.xiaomi.onetrack.util;

import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
import java.util.TimeZone;
import okio.Utf8;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class ac {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f9508a = 604800000;
    public static final int b = 86400000;
    public static final int c = 43200000;
    public static final int d = 3600000;
    public static final int e = 60000;
    public static final int f = 1000;
    private static final String g = ijiami_1011.s.s.s.d(new byte[]{99, 93, 15, 6, 103, Ascii.ETB, 8, 8}, "74bc2c");
    private static final long h = 300000;
    private static long i;
    private static long j;
    private static long k;

    public static long a() {
        return System.currentTimeMillis();
    }

    public static boolean a(long j2) {
        String str = ijiami_1011.s.s.s.d(new byte[]{94, 94, 55, 9, 82, 88, Ascii.CAN, 72, 5, Ascii.ETB, 67, Ascii.ETB, 82, 94, Ascii.ETB, 70, 66, 74, 65, 94}, "70cf69") + a();
        String str2 = g;
        p.a(str2, str);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(a());
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        long timeInMillis = calendar.getTimeInMillis();
        long j3 = timeInMillis + 86400000;
        p.a(str2, ijiami_1011.s.s.s.d(new byte[]{99, 74, 77, 83, 71, 67, 60, 94}, "899257") + timeInMillis + ijiami_1011.s.s.s.d(new byte[]{111, 104, 4, 88, 0, 111, 91}, "e3a6d2") + j3 + ijiami_1011.s.s.s.d(new byte[]{80, 16, 65, 4, 71, 94, 14, 10}, "4e3e37") + ((j3 - timeInMillis) - 86400000));
        p.a(str2, ijiami_1011.s.s.s.d(new byte[]{90, Ascii.NAK, 69, 90, 86, 16, Ascii.NAK, 11, 2, 3, 72, 95}, "3fe380") + (timeInMillis <= j2 && j2 < j3));
        return timeInMillis <= j2 && j2 < j3;
    }

    public static boolean a(long j2, int i2) {
        return Math.abs(System.currentTimeMillis() - j2) >= ((long) (i2 + new Random().nextInt(i2 / 2)));
    }

    public static boolean a(long j2, long j3) {
        return Math.abs(System.currentTimeMillis() - j2) >= j3;
    }

    public static long b() {
        Calendar calendar;
        try {
            calendar = Calendar.getInstance(TimeZone.getTimeZone(q.b()));
        } catch (Exception unused) {
            calendar = Calendar.getInstance();
        }
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    public static boolean b(long j2) {
        String str = ijiami_1011.s.s.s.d(new byte[]{89, 11, 101, 94, 85, 86, Ascii.CAN, 39, 10, 11, 84, 11, 68, 49, 88, 92, 84, Ascii.ESC, 2, 17, Ascii.DC4, 16, 84, 11, 68, 69, 69, 66, 17, 13}, "0e1117") + System.currentTimeMillis();
        String str2 = g;
        p.a(str2, str);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        long timeInMillis = calendar.getTimeInMillis();
        long j3 = timeInMillis + 86400000;
        p.a(str2, ijiami_1011.s.s.s.d(new byte[]{Utf8.REPLACEMENT_BYTE, Ascii.NAK, 70, 80, 66, SignedBytes.MAX_POWER_OF_TWO, 60, 94}, "df2104") + timeInMillis + ijiami_1011.s.s.s.d(new byte[]{57, 58, 93, 93, 0, 60, 91}, "3a83da") + j3 + ijiami_1011.s.s.s.d(new byte[]{83, 19, 16, 84, Ascii.ETB, 89, 14, 10}, "7fb5c0") + ((j3 - timeInMillis) - 86400000));
        p.a(str2, ijiami_1011.s.s.s.d(new byte[]{12, Ascii.NAK, Ascii.DC2, 91, 88, 17, Ascii.NAK, 11, 2, 3, 72, 95}, "ef2261") + (timeInMillis <= j2 && j2 < j3));
        return timeInMillis <= j2 && j2 < j3;
    }

    public static String c(long j2) {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(j2);
            return new SimpleDateFormat(ijiami_1011.s.s.s.d(new byte[]{123, 113, 14, 11, 85, 8, Ascii.DC2, Ascii.ETB, 70, Ascii.ESC, 72, 72, 126, 116, Ascii.EM, 2, 92}, "394f82")).format(calendar.getTime());
        } catch (Exception unused) {
            return "";
        }
    }

    public static boolean d(long j2) {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone(ijiami_1011.s.s.s.d(new byte[]{127, 122, 55, 72, 10}, "87cc28")));
        Calendar calendar2 = Calendar.getInstance(TimeZone.getTimeZone(ijiami_1011.s.s.s.d(new byte[]{126, 41, 102, 72, 8}, "9d2c0b")));
        calendar2.setTimeInMillis(j2);
        return calendar2.get(1) == calendar.get(1) && calendar2.get(2) == calendar.get(2) && calendar2.get(5) == calendar.get(5);
    }
}
