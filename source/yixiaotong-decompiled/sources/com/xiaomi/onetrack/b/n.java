package com.xiaomi.onetrack.b;

import android.text.TextUtils;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.xiaomi.onetrack.util.p;
import com.xiaomi.onetrack.util.q;
import ijiami_1011.s.s.s;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f9461a = s.d(new byte[]{113, 11, 92, 81, 10, 6, 49, Ascii.SYN, 9, Ascii.DC4, 88, 1, 87, Ascii.SYN}, "2d27ca");
    private static volatile boolean b = false;
    private static volatile boolean c = true;

    public static int a(int i) {
        int iIntValue;
        if (p.b) {
            p.a(f9461a, s.d(new byte[]{86, 93, 7, SignedBytes.MAX_POWER_OF_TWO, 84, Ascii.SYN, Ascii.DC4, Ascii.DC4, 10, 13, 80, 1, Ascii.DC2, 85, 10, 81, 86, 26, 65, Ascii.ETB, 3, 12, 85, 69, 87, 78, 0, 91, 71, 69, 65, 13, 11, 15, 84, 1, 91, 89, 17, 80, 95, 79}, "28e536"));
            return 0;
        }
        try {
            iIntValue = e.c().get(Integer.valueOf(i + 1)).intValue();
        } catch (Exception unused) {
            iIntValue = 60000;
        }
        p.a(f9461a, s.d(new byte[]{82, 83, 70, 55, SignedBytes.MAX_POWER_OF_TWO, 88, 14, 5, 2, 43, 95, 17, 80, 68, 68, 3, 92, Ascii.DC4}, "562b04") + iIntValue);
        return iIntValue;
    }

    public static synchronized void a(boolean z) {
        b = z;
    }

    public static boolean a() {
        try {
            String[] strArrB = com.xiaomi.onetrack.d.f.a().b();
            return (!TextUtils.isEmpty(strArrB[0]) && !TextUtils.isEmpty(strArrB[1])) && !q.a(f9461a);
        } catch (Exception e) {
            p.a(f9461a, s.d(new byte[]{122, 12, 94, 85, 81, 2, 49, Ascii.SYN, 9, Ascii.DC4, 88, 1, 92, 17, Ascii.RS, 82, 78, 4, 8, 8, 7, 0, 93, 0}, "9c038e"), e);
            return false;
        }
    }

    public static void b(boolean z) {
        c = z;
    }

    public static synchronized boolean b() {
        return b;
    }

    public static boolean c() {
        return c;
    }
}
