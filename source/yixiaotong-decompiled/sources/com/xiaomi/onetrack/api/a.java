package com.xiaomi.onetrack.api;

import android.content.Context;
import android.content.Intent;
import android.os.Process;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class a {
    private static volatile a c;
    private static String j;
    private final Context h = com.xiaomi.onetrack.f.a.a();
    private final Context i = com.xiaomi.onetrack.f.a.b();
    private static final String b = ijiami_1011.s.s.s.d(new byte[]{35, 72, SignedBytes.MAX_POWER_OF_TWO, 35, 83, Ascii.SYN, 8, Ascii.DC2, 3, 32, 67, 10, 3, 92, 83, 3, 67, Ascii.SYN, 44, 5, 8, 3, 86, 0, 16}, "b80b0b");
    private static final String d = ijiami_1011.s.s.s.d(new byte[]{6, 94, 8, 71, 6, 86, Ascii.NAK, 94, 73, 77, 82, 10, 8, Ascii.US, 11, 90, Ascii.SYN, 81, 79, 5, 8, 3, 93, Ascii.FS, 17, 88, 5, SignedBytes.MAX_POWER_OF_TWO, 77, 119, 15, 1, 50, 16, 80, 6, 14, 97, Ascii.DC4, 92, Ascii.NAK, 81, 5, 1, Ascii.DC4, 77, 69, Ascii.ETB, 4, 82, 3, 122, 7}, "e1f3c8");
    private static final String e = ijiami_1011.s.s.s.d(new byte[]{67, 70, 80, 0, 3, 124, 5}, "741cf5");
    private static final String f = ijiami_1011.s.s.s.d(new byte[]{69, 90, 82}, "51580a");
    private static final String g = ijiami_1011.s.s.s.d(new byte[]{67, 11, 86, 87}, "0b19c4");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f9399a = ijiami_1011.s.s.s.d(new byte[]{81, 91, Ascii.NAK, 92, 89, 88}, "08a566");
    private static final String k = ijiami_1011.s.s.s.d(new byte[]{71, 0, 2, 89, 0, 82, 4}, "7aa2a5");
    private static final String l = ijiami_1011.s.s.s.d(new byte[]{12, 12, 74, 65, 81, 90, 13, 1, Ascii.DC4}, "eb9506");
    private static final String m = ijiami_1011.s.s.s.d(new byte[]{Ascii.ETB, 69, 7, 74, 112, 2}, "b6b89f");
    private static final String n = ijiami_1011.s.s.s.d(new byte[]{85, 91, 16, 15, 112, 87, Ascii.NAK, 13, 16, 7, 120, 1}, "82ef14");
    private static final String o = ijiami_1011.s.s.s.d(new byte[]{14, 89, Ascii.SYN, 11, 120, 90, Ascii.NAK, 13, 16, 7, 101, 12, 14, 85}, "c0cb99");
    private static final String p = ijiami_1011.s.s.s.d(new byte[]{2, 82, Ascii.DC2, 81, 70, 87, 53, 13, 11, 7}, "c1f802");
    private static final String q = ijiami_1011.s.s.s.d(new byte[]{73, 16, 80, 66, 76, 103, 8, 9, 3}, "8e5053");
    private static final Set<String> r = new HashSet(Arrays.asList(ijiami_1011.s.s.s.d(new byte[]{0, 13, 89, Ascii.EM, SignedBytes.MAX_POWER_OF_TWO, 88, 0, 11, 11, 11, Ascii.US, Ascii.GS, 14, 17, 82}, "cb4781"), ijiami_1011.s.s.s.d(new byte[]{84, 9, 88, Ascii.RS, Ascii.ESC, 8, 0, 11, 11, 11, Ascii.US, 8, 86, Ascii.DC4, 94, 85, Ascii.ETB}, "7f50ca"), ijiami_1011.s.s.s.d(new byte[]{7, 94, 88, 74, 95, 95, Ascii.DC4, 13, 72, Ascii.DC2, 80, 6, 15, 80, 82, 1, 91, 88, Ascii.DC2, 16, 7, 14, 93, 0, Ascii.SYN}, "d15d26")));

    private a() {
        j = com.xiaomi.onetrack.f.a.e();
    }

    public static a a() {
        if (c == null) {
            b();
        }
        return c;
    }

    public static void b() {
        if (c == null) {
            synchronized (a.class) {
                if (c == null) {
                    c = new a();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean f() {
        try {
            int i = com.xiaomi.onetrack.f.a.b().getPackageManager().getPackageInfo(ijiami_1011.s.s.s.d(new byte[]{2, 93, 85, Ascii.GS, 14, 81, Ascii.DC4, 13, 72, 3, 95, 4, 13, 75, 76, 90, 0, 75}, "a283c8"), 0).versionCode;
            if (i >= 2023010300) {
                return true;
            }
            com.xiaomi.onetrack.util.p.a(b, ijiami_1011.s.s.s.d(new byte[]{88, 87, 16, 70, Ascii.DC2, 76, 17, Ascii.DC4, 9, 16, 69, 69, 81, 93, 16, 50, 19, 88, 2, 1, 47, 6, 17, 19, 83, 74, Ascii.ETB, 15, 14, 87, 34, 11, 2, 7, 11, 69}, "68dfa9") + i);
        } catch (Throwable th) {
            com.xiaomi.onetrack.util.p.b(b, ijiami_1011.s.s.s.d(new byte[]{90, 74, 103, 19, Ascii.DC2, 68, 14, Ascii.SYN, Ascii.DC2, 39, 92, Ascii.NAK, 71, SignedBytes.MAX_POWER_OF_TWO, 113, 16, 7, 90, Ascii.NAK, 68, 3, 16, 67, 10, 65, 3}, "394fb4") + th.getMessage());
        }
        return false;
    }

    public String a(Intent intent) {
        Exception e2;
        String str;
        FutureTask futureTask = new FutureTask(new b(this, intent));
        long jCurrentTimeMillis = System.currentTimeMillis();
        com.xiaomi.onetrack.util.i.a(futureTask);
        try {
            str = (String) futureTask.get(5L, TimeUnit.SECONDS);
            try {
                if (com.xiaomi.onetrack.util.p.f9551a) {
                    com.xiaomi.onetrack.util.p.a(b, ijiami_1011.s.s.s.d(new byte[]{Ascii.DC2, 89, 84, 89, 85, 4, 4, 42, 7, 15, 84, 95}, "b8724c") + j + ijiami_1011.s.s.s.d(new byte[]{Ascii.EM, 104, 75, 66, 0, 16, Ascii.NAK, 68, 75, 79, Ascii.FS, 72, Ascii.DC4, 26, 95, 83, Ascii.NAK, 54, 19, 5, 5, 7, 120, 1, 3}, "9786ab") + str + ijiami_1011.s.s.s.d(new byte[]{Ascii.DC2, Ascii.ETB, 62, 16, 81, 85, 91}, "27ad81") + Process.myTid());
                }
            } catch (Exception e3) {
                e2 = e3;
                com.xiaomi.onetrack.util.p.b(b, ijiami_1011.s.s.s.d(new byte[]{6, 4, SignedBytes.MAX_POWER_OF_TWO, 108, 69, 0, 2, 1, 47, 6, 17, 0, 19, 19, 91, 74, 13, 65}, "aa487a") + e2.toString());
            }
        } catch (Exception e4) {
            e2 = e4;
            str = "";
        }
        com.xiaomi.onetrack.util.p.a(b, ijiami_1011.s.s.s.d(new byte[]{67, 88, 84, 94, 2, 5, 4, 42, 7, 15, 84, 95}, "3975cb") + j + ijiami_1011.s.s.s.d(new byte[]{Ascii.DC2, 104, 92, 95, 83, 69, 76, 73, 75, 79, Ascii.FS, 72, 85, 82, 77, 101, 69, 4, 2, 1, 47, 6, 11}, "27917e") + str + ijiami_1011.s.s.s.d(new byte[]{65, Ascii.CAN, 104, Ascii.ETB, 8, 86, 91}, "a87ca2") + Process.myTid() + ijiami_1011.s.s.s.d(new byte[]{65, 81, 13, 82, 94, 102, 8, 9, 3, 88}, "a5d482") + (System.currentTimeMillis() - jCurrentTimeMillis));
        return str;
    }

    public boolean c() {
        return r.contains(com.xiaomi.onetrack.f.a.b().getPackageName());
    }
}
