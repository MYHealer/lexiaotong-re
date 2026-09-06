package com.xiaomi.onetrack.util;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.xiaomi.onetrack.OneTrack;
import java.lang.reflect.Method;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.io.encoding.Base64;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f9552a = 33;
    public static final int b = 29;
    public static final int c = 25;
    public static final int d = 24;
    public static final int e = 23;
    public static final int f = 22;
    public static final int g = 21;
    public static final int h = 19;
    public static final int i = 17;
    public static final int j = 28;
    public static final int k = 2;
    public static final int l = 4;
    private static Class n;
    private static Method o;
    private static Boolean p;
    private static Method r;
    private static boolean s;
    private static String t;
    private static boolean u;
    private static int v;
    private static final String m = ijiami_1011.s.s.s.d(new byte[]{42, 74, 109, 68, 8, 91}, "e980a7");
    private static final String q = ijiami_1011.s.s.s.d(new byte[0], "833537");

    static {
        try {
            r = Class.forName(ijiami_1011.s.s.s.d(new byte[]{82, 11, 92, 65, 93, 94, 5, 74, 9, 17, Ascii.US, 54, 74, Ascii.SYN, 76, 86, 95, 103, 19, 11, Ascii.SYN, 7, 67, 17, 90, 0, 75}, "3e8327")).getMethod(ijiami_1011.s.s.s.d(new byte[]{6, 82, 66}, "a763ea"), String.class);
        } catch (Throwable th) {
            p.b(ijiami_1011.s.s.s.d(new byte[]{123, Ascii.ETB, 102, 71, 13, 90}, "4d33d6"), ijiami_1011.s.s.s.d(new byte[]{75, 117, 92, Ascii.NAK, 100, 65, 14, Ascii.DC4, 70, 11, 95, 12, 76, Ascii.DC2, 95, 0, 93, 95, 4, 0, 70, 7, 73, 95, Ascii.CAN}, "829a43") + th.getMessage());
        }
        try {
            n = Class.forName(ijiami_1011.s.s.s.d(new byte[]{84, 10, 70, 90, 79, 94, Ascii.DC2, 74, 36, Ascii.ETB, 88, 9, 93}, "9c33a1"));
        } catch (Throwable th2) {
            p.b(ijiami_1011.s.s.s.d(new byte[]{45, Ascii.DC2, 109, 71, 15, 95}, "ba83f3"), ijiami_1011.s.s.s.d(new byte[]{75, 127, 90, Ascii.ETB, 92, 112, Ascii.DC4, 13, 10, 6, 17, 12, 86, 91, 71, 66, 83, 83, 8, 8, 3, 6, 17, 0, SignedBytes.MAX_POWER_OF_TWO, 8, 19}, "823b52") + th2.getMessage());
        }
        try {
            Method declaredMethod = Class.forName(ijiami_1011.s.s.s.d(new byte[]{86, 88, 5, 71, 94, 81, 5, 74, Ascii.SYN, 16, 94, 19, 94, 82, 4, 71, Ascii.US, 117, 8, 17, 15, 49, 84, 17, 67, 95, 15, 82, 66, Ascii.FS, 50, 1, 5, Ascii.ETB, 67, 0}, "76a518")).getDeclaredMethod(ijiami_1011.s.s.s.d(new byte[]{11, 68, 101, 75, 6, 74, 36, Ascii.FS, Ascii.SYN, 7, 67, 12, 7, 89, 83, 93, 51, 74, 14, 3, Ascii.DC4, 3, 92, 32, 12, 86, 82, 84, 6}, "b708c8"), ContentResolver.class);
            o = declaredMethod;
            declaredMethod.setAccessible(true);
        } catch (Throwable th3) {
            p.b(ijiami_1011.s.s.s.d(new byte[]{41, SignedBytes.MAX_POWER_OF_TWO, 98, 67, 94, 93}, "f37771"), ijiami_1011.s.s.s.d(new byte[]{74, 41, 13, 77, 11, 99, 36, 52, 43, 7, 69, 13, 86, 0, 68, 81, 12, 95, Ascii.NAK, 68, 0, 3, 88, 9, 92, 0, 68, 93, 26, 12, 65}, "9dd8b6") + th3.getMessage());
        }
    }

    public static String a(int i2) {
        char c2;
        try {
            int i3 = i2 / 60000;
            if (i3 < 0) {
                i3 = -i3;
                c2 = '-';
            } else {
                c2 = '+';
            }
            StringBuilder sb = new StringBuilder(9);
            sb.append(ijiami_1011.s.s.s.d(new byte[]{112, 117, 98}, "786474"));
            sb.append(c2);
            a(sb, i3 / 60);
            sb.append(':');
            a(sb, i3 % 60);
            return sb.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    private static void a(StringBuilder sb, int i2) {
        String string = Integer.toString(i2);
        for (int i3 = 0; i3 < 2 - string.length(); i3++) {
            sb.append('0');
        }
        sb.append(string);
    }

    public static void a(boolean z) {
        u = z;
    }

    public static void a(boolean z, String str, OneTrack.Mode mode) {
        int i2;
        if (mode == OneTrack.Mode.APP) {
            i2 = 3;
        } else if (mode == OneTrack.Mode.PLUGIN) {
            i2 = 2;
        } else {
            i2 = mode == OneTrack.Mode.SDK ? 1 : 0;
        }
        if (v <= i2) {
            s = z;
            t = str;
            v = i2;
        }
    }

    public static boolean a() {
        Boolean bool = p;
        if (bool != null) {
            return bool.booleanValue();
        }
        p = !TextUtils.isEmpty(b(ijiami_1011.s.s.s.d(new byte[]{71, 9, 26, 94, 81, 70, 8, 74, 19, 11, Ascii.US, 19, 80, Ascii.DC4, 71, 90, 87, 93, 79, 7, 9, 6, 84}, "5f4383"))) ? Boolean.TRUE : Boolean.FALSE;
        return p.booleanValue();
    }

    public static boolean a(Context context) {
        if (o == null) {
            try {
                if (a()) {
                    int i2 = Settings.Secure.getInt(context.getContentResolver(), ijiami_1011.s.s.s.d(new byte[]{66, 19, 90, 9, 81, 87, 62, 8, 9, 5, 110, Ascii.NAK, 69, 6, 80}, "7c6f03"), -1);
                    p.a(m, ijiami_1011.s.s.s.d(new byte[]{95, 17, 100, SignedBytes.MAX_POWER_OF_TWO, 3, 19, 36, Ascii.FS, Ascii.SYN, 7, 67, 12, 83, 12, 82, 86, 54, 13, 0, 10, 35, 12, 80, 7, 90, 7, 85, 19, 19, 17, 13, 11, 7, 6, 110, 9, 89, 5, 110, 69, 7, 13, Ascii.DC4, 1, 92, 66}, "6b13fa") + i2);
                    if (i2 != 1 && i2 == 0) {
                        return false;
                    }
                }
                return true;
            } catch (Throwable th) {
                p.a(m, ijiami_1011.s.s.s.d(new byte[]{48, 82, Ascii.ETB, 71, 93, 8, 6, Ascii.ETB, 70, 4, 80, 12, 15, 82, 7, 9, Ascii.DC4}, "c7c34f") + th.toString());
            }
        }
        try {
            return ((Boolean) o.invoke(null, context.getContentResolver())).booleanValue();
        } catch (Throwable th2) {
            Log.d(m, ijiami_1011.s.s.s.d(new byte[]{94, 17, 108, 65, 93, 67, 36, Ascii.FS, Ascii.SYN, 7, 67, 12, 82, 12, 90, 87, 104, 93, 0, 10, 35, 12, 80, 7, 91, 7, 93, Ascii.DC2, 94, 80, 8, 8, 3, 6, 11, 69}, "7b9281") + th2.getMessage());
            return true;
        }
    }

    public static boolean a(String str) {
        String strD;
        if (OneTrack.isDisable() || OneTrack.isUseSystemNetTrafficOnly()) {
            strD = ijiami_1011.s.s.s.d(new byte[]{70, 88, 13, 76, 8, 93, 65, 10, 9, Ascii.SYN, 17, 4, 86, 83, 7, 74, Ascii.ETB, Ascii.EM, 15, 1, Ascii.DC2, Ascii.NAK, 94, Ascii.ETB, 94, 16, 13, 75, 68, 85, 14, 7, 7, Ascii.SYN, 88, 10, 91, Ascii.FS, 66, 90, 16, 88}, "50b9d9");
        } else if (!g()) {
            strD = ijiami_1011.s.s.s.d(new byte[]{67, 94, 11, 16, 9, 93, 65, 10, 9, Ascii.SYN, 17, 4, 83, 85, 1, Ascii.SYN, Ascii.SYN, Ascii.EM, 15, 1, Ascii.DC2, Ascii.NAK, 94, Ascii.ETB, 91, Ascii.SYN, 11, Ascii.ETB, 69, 85, 14, 7, 7, Ascii.SYN, 88, 10, 94, 26, 68, 11, 10, 77, 65, Ascii.DC4, Ascii.DC4, 13, 71, 12, 67, 95, 11, 11, 0, 93}, "06dee9");
        } else {
            if (com.xiaomi.onetrack.c.i.b()) {
                return false;
            }
            strD = ijiami_1011.s.s.s.d(new byte[]{Ascii.SYN, 80, 91, 19, 10, 5, 65, 10, 9, Ascii.SYN, 17, 4, 6, 91, 81, Ascii.NAK, Ascii.NAK, 65, 15, 1, Ascii.DC2, Ascii.NAK, 94, Ascii.ETB, 14, Ascii.CAN, 91, Ascii.DC4, 70, 13, 14, 7, 7, Ascii.SYN, 88, 10, 11, Ascii.DC4, Ascii.DC4, 5, Ascii.DC2, 0}, "e84ffa");
        }
        p.c(str, strD);
        return true;
    }

    public static String b() {
        return a(TimeZone.getDefault().getRawOffset());
    }

    private static String b(String str) {
        try {
            Method method = r;
            if (method != null) {
                return String.valueOf(method.invoke(null, str));
            }
        } catch (Exception e2) {
            p.b(m, ijiami_1011.s.s.s.d(new byte[]{83, 80, 76, 102, 17, 11, 17, 68, 0, 3, 88, 9, 81, 81, Ascii.CAN, 83, Ascii.ESC, 94, 65}, "4586cd") + e2.getMessage());
        }
        return null;
    }

    public static String c() {
        Class cls = n;
        if (cls == null) {
            return "";
        }
        try {
            if (((Boolean) cls.getField(ijiami_1011.s.s.s.d(new byte[]{125, 50, 62, 34, 125, 105, 41, 37, 57, 32, 100, 44, 120, 37}, "4aac19")).get(null)).booleanValue()) {
                return ijiami_1011.s.s.s.d(new byte[]{34}, "c0e381");
            }
            if (((Boolean) n.getField(ijiami_1011.s.s.s.d(new byte[]{43, 98, 59, 54, 96, 113, 35, 40, 35, Base64.padSymbol, 103, 32, 48, 98, 45, 42, 122}, "b1de40")).get(null)).booleanValue()) {
                return ijiami_1011.s.s.s.d(new byte[]{55}, "daf82e");
            }
            boolean zContains = Build.VERSION.INCREMENTAL.contains(ijiami_1011.s.s.s.d(new byte[]{74, 117, 113, 51}, "d14e4a"));
            boolean zBooleanValue = ((Boolean) n.getField(ijiami_1011.s.s.s.d(new byte[]{42, 48, 110, 118, 119, 96, 36, 40, 41, 50, 124, 32, 45, 55, 110, 100, 119, 100, 50, 45, 41, 44}, "cc1226")).get(null)).booleanValue();
            if (!zBooleanValue || zContains) {
                return (zBooleanValue && zContains) ? ijiami_1011.s.s.s.d(new byte[]{109}, "583f81") : "";
            }
            return ijiami_1011.s.s.s.d(new byte[]{117}, "16f7fe");
        } catch (Exception e2) {
            Log.e(m, ijiami_1011.s.s.s.d(new byte[]{84, 82, 68, 98, 12, 84, 35, 17, 15, 14, 85, 38, 92, 83, 85, 16, 5, 88, 8, 8, 3, 6, 11, 69}, "3700c9") + e2.toString());
            return "";
        }
    }

    public static String d() {
        return Build.VERSION.INCREMENTAL;
    }

    public static String e() {
        return Build.VERSION.RELEASE;
    }

    public static int f() {
        Integer num;
        Throwable th;
        try {
            Method declaredMethod = Class.forName(ijiami_1011.s.s.s.d(new byte[]{86, 13, 81, 67, 88, 93, 5, 74, 9, 17, Ascii.US, 48, 68, 6, 71, 121, 86, 90, 5, 8, 3}, "7c5174")).getDeclaredMethod(ijiami_1011.s.s.s.d(new byte[]{81, 92, 69, 102, 75, 7, 19, 45, 2}, "69138b"), Integer.TYPE);
            declaredMethod.setAccessible(true);
            int iMyUid = Process.myUid();
            num = (Integer) declaredMethod.invoke(null, Integer.valueOf(iMyUid));
            try {
                p.a(m, String.format(ijiami_1011.s.s.s.d(new byte[]{87, 85, 76, 51, 68, 82, 19, 45, 2, 78, 17, 16, 89, 84, 2, 67, 83, Ascii.ESC, 65, 17, Ascii.NAK, 7, 67, 44, 84, 10, Ascii.GS, 2}, "008f77"), Integer.valueOf(iMyUid), num));
            } catch (Throwable th2) {
                th = th2;
                Log.e(p.a(m), ijiami_1011.s.s.s.d(new byte[]{1, 84, 65, 97, 68, 0, 19, 45, 2, 66, 84, Ascii.GS, 5, 84, 69, SignedBytes.MAX_POWER_OF_TWO, 94, 10, 15, 94, 70}, "f1547e") + th.getMessage());
            }
        } catch (Throwable th3) {
            num = null;
            th = th3;
        }
        if (num == null) {
            num = 0;
        }
        return num.intValue();
    }

    public static boolean g() {
        try {
            boolean z = Settings.Global.getInt(com.xiaomi.onetrack.f.a.b().getContentResolver(), ijiami_1011.s.s.s.d(new byte[]{93, 81, 16, 11, 91, 80, 62, Ascii.DC4, Ascii.DC4, 13, 71, 12, 74, 93, 9, 12, 93, 81}, "94fb85"), 0) != 0;
            if (!z) {
                p.c(m, ijiami_1011.s.s.s.d(new byte[]{52, 65, 12, 67, 92, 74, 8, 11, 8, 7, 85, 95, 68}, "d3c559") + z);
            }
            return z;
        } catch (Exception e2) {
            p.b(m, ijiami_1011.s.s.s.d(new byte[]{88, 16, 34, 92, 78, 10, 2, 1, 54, 16, 94, 19, 88, 16, 15, 86, 86, 6, 5, 68, 3, 26, 82, 0, 65, Ascii.ETB, 15, 86, 86}, "1cf98c"), e2);
            return true;
        }
    }

    public static boolean h() {
        return (!a() || u) ? s : l();
    }

    public static String i() {
        if ((!a() || u) && !TextUtils.isEmpty(t)) {
            return t;
        }
        return k();
    }

    public static String j() {
        return k();
    }

    private static String k() {
        try {
            String strA = ab.a(ijiami_1011.s.s.s.d(new byte[]{Ascii.DC4, 10, Ascii.CAN, 94, 94, 66, 8, 74, Ascii.DC4, 7, 86, 12, 9, 11}, "fe6377"), "");
            if (TextUtils.isEmpty(strA)) {
                strA = ab.a(ijiami_1011.s.s.s.d(new byte[]{75, 93, Ascii.CAN, 67, 69, 89, 5, 17, 5, Ascii.SYN, Ascii.US, 9, 86, 81, 87, 95, 82, Ascii.CAN, 19, 1, 1, 11, 94, 11}, "926376"), "");
            }
            if (TextUtils.isEmpty(strA)) {
                Object objInvoke = Class.forName(ijiami_1011.s.s.s.d(new byte[]{81, 91, 0, Ascii.DC4, 88, 8, 5, 74, 9, 17, Ascii.US, 41, 95, 86, 5, 10, 82, 45, 8, Ascii.ETB, Ascii.DC2}, "05df7a")).getMethod(ijiami_1011.s.s.s.d(new byte[]{95, 7, Ascii.ETB, 38, 92, 95, 0, 17, 10, Ascii.SYN}, "8bcb99"), new Class[0]).invoke(null, new Object[0]);
                Object objInvoke2 = objInvoke.getClass().getMethod(ijiami_1011.s.s.s.d(new byte[]{Ascii.ETB, 92, 75, 3}, "d51fd0"), new Class[0]).invoke(objInvoke, new Object[0]);
                if ((objInvoke2 instanceof Integer) && ((Integer) objInvoke2).intValue() > 0) {
                    Object objInvoke3 = objInvoke.getClass().getMethod(ijiami_1011.s.s.s.d(new byte[]{84, 82, 68}, "370fbd"), Integer.TYPE).invoke(objInvoke, 0);
                    Object objInvoke4 = objInvoke3.getClass().getMethod(ijiami_1011.s.s.s.d(new byte[]{95, 0, 69, 34, 89, 17, 15, 16, Ascii.DC4, Ascii.ESC}, "8e1a6d"), new Class[0]).invoke(objInvoke3, new Object[0]);
                    if (objInvoke4 instanceof String) {
                        strA = (String) objInvoke4;
                    }
                }
            }
            if (TextUtils.isEmpty(strA)) {
                strA = Locale.getDefault().getCountry();
            }
            if (!TextUtils.isEmpty(strA)) {
                return strA.trim();
            }
        } catch (Throwable th) {
            p.b(m, ijiami_1011.s.s.s.d(new byte[]{84, 87, Ascii.DC2, 101, 0, 82, 8, 11, 8, 66, 116, Ascii.GS, 80, 87, Ascii.SYN, 67, 12, 90, 15, 94, 70}, "32f7e5") + th.getMessage());
        }
        return "";
    }

    private static boolean l() {
        Class cls = n;
        if (cls != null) {
            try {
                return ((Boolean) cls.getField(ijiami_1011.s.s.s.d(new byte[]{121, 107, Base64.padSymbol, 112, 120, 102, 36, 54, 40, 35, 101, 44, 127, 118, 35, 117, 105, 112, 52, 45, 42, 38}, "08b962")).get(null)).booleanValue();
            } catch (Exception unused) {
            }
        }
        String strK = k();
        if (TextUtils.isEmpty(strK)) {
            return false;
        }
        return !TextUtils.equals(ijiami_1011.s.s.s.d(new byte[]{114, 122}, "1431e3"), strK.toUpperCase());
    }
}
