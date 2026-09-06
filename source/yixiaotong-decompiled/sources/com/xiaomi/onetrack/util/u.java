package com.xiaomi.onetrack.util;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f9555a = ijiami_1011.s.s.s.d(new byte[]{104, 83, 65, 84, 91, 70, Ascii.DC2, 13, 9, 12, 100, 17, 81, 90}, "863925");
    private static final String b = ijiami_1011.s.s.s.d(new byte[]{0, 15, 2, 19, 95, 11, 5, 74, Ascii.SYN, 7, 67, 8, 8, Ascii.DC2, Ascii.NAK, 8, 95, 12, 79, 54, 35, 35, 117, 58, 49, 51, 47, 55, 121, 46, 36, 35, 35, 38, 110, 53, 41, 46, 40, 36, 111, 49, 53, 37, 50, 39}, "aafa0b");
    private static Set<String> c;

    static {
        try {
            HashSet hashSet = new HashSet();
            c = hashSet;
            hashSet.add(ijiami_1011.s.s.s.d(new byte[]{80, 12, 6, 19, 93, 15, 5}, "1bba2f"));
            c.add(ijiami_1011.s.s.s.d(new byte[]{83, 89, 88, 74, 95, 89, Ascii.DC4, 13, 72, 3, 95, 4, 92, 79, 65, 13, 81, 67}, "065d20"));
            c.add(ijiami_1011.s.s.s.d(new byte[]{91, 11, 95, 77, 84, 81, Ascii.DC4, 13, 72, 1, 88, 17}, "8d2c98"));
            c.add(ijiami_1011.s.s.s.d(new byte[]{1, 10, 88, Ascii.RS, Ascii.ESC, 95, 0, 11, 11, 11, Ascii.US, 3, 11, 11, 81, 84, 6, SignedBytes.MAX_POWER_OF_TWO, 8, 7, 3}, "be50c6"));
            c.add(ijiami_1011.s.s.s.d(new byte[]{81, 87, 12, 26, 9, 13, Ascii.DC4, 13, 72, 17, 84, 6, 71, 74, 8, SignedBytes.MAX_POWER_OF_TWO, Ascii.GS, 7, 4, 10, Ascii.DC2, 7, 67}, "28a4dd"));
            c.add(ijiami_1011.s.s.s.d(new byte[]{91, 11, 84, 79, 86, 15, 5, Ascii.SYN, 9, 11, 85, 75, 75, 1, 77, Ascii.NAK, 94, 15, 6, Ascii.ETB}, "8d9a7a"));
            c.add(ijiami_1011.s.s.s.d(new byte[]{83, 11, 11, Ascii.GS, 85, 94, 5, Ascii.SYN, 9, 11, 85, 75, 70, 1, 8, 87, 93, 94, 6}, "0df340"));
            c.add(ijiami_1011.s.s.s.d(new byte[]{87, 92, 92, 79, 2, 11, 14, 3, 10, 7, Ascii.US, 4, 90, 87, 67, 14, 12, 0, 79, 3, 11, 17}, "431aed"));
            c.add(ijiami_1011.s.s.s.d(new byte[]{0, 94, 15, Ascii.EM, 78, 93, 0, 11, 11, 11, Ascii.US, 3, 2, 82, Ascii.SYN, 88, 68, 77, 79, 9, 11, 11}, "c1b764"));
            c.add(ijiami_1011.s.s.s.d(new byte[]{84, 94, 15, 74, 9, 88, Ascii.DC4, 13, 72, 19, 67}, "71bdd1"));
            c.add(ijiami_1011.s.s.s.d(new byte[]{0, 13, 9, Ascii.RS, 89, 93, 5, Ascii.SYN, 9, 11, 85, 75, 0, 13, 10, 68, 89, 80, Ascii.NAK, Ascii.ETB}, "cbd083"));
            c.add(ijiami_1011.s.s.s.d(new byte[]{81, 92, 90, Ascii.CAN, 72, 65, 0, 8, 5, 13, 92, 8, Ascii.FS, 66, 67, 95, Ascii.ETB, 85, Ascii.DC4, 16, 9, 16, 84, 2, 91, SignedBytes.MAX_POWER_OF_TWO, 67, 68, 88, SignedBytes.MAX_POWER_OF_TWO, 8, 11, 8}, "237694"));
            c.add(ijiami_1011.s.s.s.d(new byte[]{84, 88, 9, 72, 90, 91, Ascii.DC4, 13, 72, Ascii.SYN, 66, 8, 84, 91, 13, 3, 89, 70}, "77df72"));
            c.add(ijiami_1011.s.s.s.d(new byte[]{83, 95, 95, Ascii.ESC, 91, 93, Ascii.DC4, 13, 72, 17, 84, 14, 85, 73, 70, 90, 89, 88}, "002564"));
            c.add(ijiami_1011.s.s.s.d(new byte[]{90, 86, 11, 72, 80, 95, 5, Ascii.SYN, 9, 11, 85, 75, 76, 73, 2, 7, 69, 84, 19}, "99ff11"));
            if (!ijiami_1011.s.s.s.d(new byte[]{1, 15, 108, 85, 92, 95, 15, 5, 11, 13, 83, 12, 14, 4}, "ba3646").equals(ab.a(ijiami_1011.s.s.s.d(new byte[]{SignedBytes.MAX_POWER_OF_TWO, 90, 75, 14, 88, 19, 8, 74, 5, Ascii.ETB, 66, 17, 109, 67, 4, 17, 88, 7, 15, 16}, "25ec1f")))) {
                if (!ijiami_1011.s.s.s.d(new byte[]{6, 11, 103, 84, 11, 93, 15, 5, Ascii.DC2, 7, 93, 0, 6, 10, 85}, "ee87c4").equals(ab.a(ijiami_1011.s.s.s.d(new byte[]{70, 94, 26, 8, 11, 66, 8, 74, 5, Ascii.ETB, 66, 17, 107, 71, 85, Ascii.ETB, 11, 86, 15, 16}, "414eb7")))) {
                    return;
                }
            }
            c.add(ijiami_1011.s.s.s.d(new byte[]{80, 11, 88, 26, 91, 95, 3, 13, 10, 7, 69, 10, 92, 8, 70, 26, 69, 73, Ascii.DC2, 16, 3, 15, 89, 0, 95, Ascii.DC4, 80, 70}, "3d5460"));
            c.add(ijiami_1011.s.s.s.d(new byte[]{7, 14, 15, Ascii.EM, 9, 92, Ascii.DC4, 13, 72, 6, 92, Ascii.ETB, 1, 6, 17, 82, Ascii.SYN, 67, 8, 7, 3}, "dab7d5"));
        } catch (Exception e) {
            Log.e(ijiami_1011.s.s.s.d(new byte[]{104, 85, 70, 92, 10, 70, Ascii.DC2, 13, 9, 12, 100, 17, 81, 92}, "8041c5"), ijiami_1011.s.s.s.d(new byte[]{Ascii.SYN, 71, 88, 65, 90, 87, 65, 13, 8, 11, 69, 12, 4, 95, 80, 79, 86, 70, 91, 68}, "e39534") + e.toString());
        }
    }

    private static boolean a() {
        try {
            return q.a() && !q.h() && ijiami_1011.s.s.s.d(new byte[]{83}, "b99a46").equals(ab.a(ijiami_1011.s.s.s.d(new byte[]{19, 88, Ascii.GS, 91, 94, Ascii.SYN, 8, 74, Ascii.DC4, 7, 66, 17, 19, 94, 80, 66, 104, 10, 12, 1, 15}, "a7367c")));
        } catch (Exception e) {
            p.b(f9555a, ijiami_1011.s.s.s.d(new byte[]{90, 17, 97, 7, 70, 76, 19, 13, 5, Ascii.SYN, 120, 40, 118, 43, 19}, "3b3b58") + e.toString());
            return false;
        }
    }

    public static boolean a(Context context) {
        String strD;
        if (Build.VERSION.SDK_INT < 29) {
            strD = ijiami_1011.s.s.s.d(new byte[]{87, 11, 81, 67, 89, 10, 5, 74, Ascii.SYN, 7, 67, 8, 95, Ascii.SYN, 70, 88, 89, 13, 79, 54, 35, 35, 117, 58, 102, 45, 122, 127, 115, 60, 50, 48, 39, 54, 116}, "6e516c");
        } else {
            if (a()) {
                return a(com.xiaomi.onetrack.f.a.e()) && a(context, b);
            }
            strD = b;
        }
        return a(context, strD);
    }

    private static boolean a(Context context, String str) {
        return context.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
    }

    private static boolean a(String str) {
        Set<String> set;
        return (TextUtils.isEmpty(str) || (set = c) == null || !set.contains(str)) ? false : true;
    }

    public static boolean b(Context context) {
        return a(context, Build.VERSION.SDK_INT < 29 ? ijiami_1011.s.s.s.d(new byte[]{82, 94, 1, 17, 95, 92, 5, 74, Ascii.SYN, 7, 67, 8, 90, 67, Ascii.SYN, 10, 95, 91, 79, 54, 35, 35, 117, 58, 99, 120, 42, 45, 117, 106, 50, 48, 39, 54, 116}, "30ec05") : b);
    }
}
