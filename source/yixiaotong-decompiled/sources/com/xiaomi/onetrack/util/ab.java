package com.xiaomi.onetrack.util;

import android.util.Log;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class ab {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f9507a = ijiami_1011.s.s.s.d(new byte[]{98, Ascii.ESC, Ascii.ETB, SignedBytes.MAX_POWER_OF_TWO, 0, 94, 49, Ascii.SYN, 9, Ascii.DC2, 84, Ascii.ETB, 69, 11, 1, 71}, "1bd4e3");

    public static long a(String str, Long l) {
        try {
            return ((Long) Class.forName(ijiami_1011.s.s.s.d(new byte[]{80, 87, 6, 70, 93, 89, 5, 74, 9, 17, Ascii.US, 54, 72, 74, Ascii.SYN, 81, 95, 96, 19, 11, Ascii.SYN, 7, 67, 17, 88, 92, 17}, "19b420")).getMethod(ijiami_1011.s.s.s.d(new byte[]{94, 84, 68, 127, 93, 94, 6}, "910320"), String.class, Long.TYPE).invoke(null, str, l)).longValue();
        } catch (Throwable th) {
            Log.e(p.a(f9507a), ijiami_1011.s.s.s.d(new byte[]{6, 0, 76, 122, 12, 93, 6, 68, 3}, "ae86c3") + th.getMessage());
            return l.longValue();
        }
    }

    public static String a(String str) {
        return a(str, "");
    }

    public static String a(String str, String str2) {
        try {
            return (String) Class.forName(ijiami_1011.s.s.s.d(new byte[]{89, 91, 81, 65, 93, 81, 5, 74, 9, 17, Ascii.US, 54, 65, 70, 65, 86, 95, 104, 19, 11, Ascii.SYN, 7, 67, 17, 81, 80, 70}, "855328")).getMethod(ijiami_1011.s.s.s.d(new byte[]{87, 1, 67}, "0d7825"), String.class, String.class).invoke(null, str, str2);
        } catch (Throwable th) {
            Log.e(p.a(f9507a), ijiami_1011.s.s.s.d(new byte[]{87, 0, 71, 16, 4}, "0e30aa") + th.getMessage());
            return str2;
        }
    }
}
