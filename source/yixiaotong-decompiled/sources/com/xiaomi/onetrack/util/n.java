package com.xiaomi.onetrack.util;

import android.content.Context;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f9519a = ijiami_1011.s.s.s.d(new byte[]{127, 80, 82, 88, 65, 80, 7, 13, 3, 16, 124, 4, 88, 85, 80, 83, 71}, "647659");
    private static Object b;
    private static Class<?> c;
    private static Method d;
    private static Method e;
    private static Method f;
    private static Method g;

    static {
        try {
            Class<?> cls = Class.forName(ijiami_1011.s.s.s.d(new byte[]{80, 10, 91, 26, 81, 93, 5, Ascii.SYN, 9, 11, 85, 75, 90, 1, Ascii.CAN, 93, 93, 67, 13, 74, 47, 6, 97, Ascii.ETB, 92, 19, 95, 80, 85, 65, 40, 9, Ascii.SYN, 14}, "3e6403"));
            c = cls;
            b = cls.newInstance();
            d = c.getMethod(ijiami_1011.s.s.s.d(new byte[]{5, 92, 76, 108, 39, 126, 37}, "b989c7"), Context.class);
            e = c.getMethod(ijiami_1011.s.s.s.d(new byte[]{94, 3, 66, 46, 119, 44, 37}, "9f6a6e"), Context.class);
            f = c.getMethod(ijiami_1011.s.s.s.d(new byte[]{81, 80, 16, 100, 32, 124, 37}, "65d2a5"), Context.class);
            g = c.getMethod(ijiami_1011.s.s.s.d(new byte[]{87, 81, 68, 116, 120, 127, 37}, "040596"), Context.class);
        } catch (Exception e2) {
            p.a(ijiami_1011.s.s.s.d(new byte[]{113, 87, 0, 94, Ascii.DC2, 8, 7, 13, 3, 16, 124, 4, 86, 82, 2, 85, Ascii.DC4}, "83e0fa"), ijiami_1011.s.s.s.d(new byte[]{SignedBytes.MAX_POWER_OF_TWO, 82, 82, 95, 4, 87, Ascii.NAK, 68, 3, 26, 82, 0, 66, 67, 93, 92, 15, Ascii.NAK}, "2743a4"), e2);
        }
    }

    public static String a(Context context) {
        return a(context, d);
    }

    private static String a(Context context, Method method) {
        Object obj;
        if (context == null || (obj = b) == null || method == null) {
            return "";
        }
        try {
            Object objInvoke = method.invoke(obj, context);
            return objInvoke != null ? (String) objInvoke : "";
        } catch (Throwable th) {
            p.a(f9519a, ijiami_1011.s.s.s.d(new byte[]{9, 83, 89, 0, Ascii.SYN, 92, 15, Ascii.DC2, 9, 9, 84, 69, 3, 74, 83, 1, 70, 65, 8, 11, 8, 67}, "f20d65"), th);
            return "";
        }
    }

    public static boolean a() {
        return (c == null || b == null) ? false : true;
    }

    public static String b(Context context) {
        return a(context, e);
    }

    public static String c(Context context) {
        return a(context, f);
    }

    public static String d(Context context) {
        return a(context, g);
    }
}
