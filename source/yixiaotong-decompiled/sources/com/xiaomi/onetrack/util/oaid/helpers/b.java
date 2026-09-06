package com.xiaomi.onetrack.util.oaid.helpers;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.google.common.base.Ascii;
import com.xiaomi.onetrack.util.ab;
import com.xiaomi.onetrack.util.n;
import com.xiaomi.onetrack.util.p;
import ijiami_1011.s.s.s;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f9537a = s.d(new byte[]{84}, "6449d1");

    public enum a {
        f9538a(s.d(new byte[]{36, 55, 98, 96}, "ed739a")),
        b(s.d(new byte[]{43, 103, 113, 96, 38, 43}, "c207cb")),
        c(s.d(new byte[]{124, 119, 42, 126, 111, 120}, "02d197")),
        d(s.d(new byte[]{40, 126, 98, 121, 42, 127, 51, 37}, "e166f0")),
        e(s.d(new byte[]{46, 119, 127, 57, 109}, "c26c87")),
        f(s.d(new byte[]{122, 54, 54, 42}, "5ffea0")),
        g(s.d(new byte[]{49, 117, 126, 101, 100, 123, 38}, "b43615")),
        h(s.d(new byte[]{126, 51, 114, 124, 32}, "0f05af")),
        i(s.d(new byte[]{97, 40, 52, 44}, "7abcd7")),
        j(s.d(new byte[]{59, 44, 119, 44, 117, 47}, "ce6c8f")),
        k(s.d(new byte[]{98, 33, 118, 43, 45}, "0d2fd1")),
        l(s.d(new byte[]{32, 42, 113, 39, 127, 49, 41, 37, 52, 41}, "bf0d4b")),
        m(s.d(new byte[]{123, 123, 39, 50, 47, 51, 50}, "45bbcf")),
        n(s.d(new byte[]{108, 55, 113}, "6c40e2")),
        o(s.d(new byte[]{112, 117, 97, 48, 47, 35, 46, 55}, "603bbf")),
        p(s.d(new byte[]{55, 53, 101, 112}, "df099b"));

        public final String q;

        a(String str) {
            this.q = str;
        }

        public static a b(String str) {
            for (a aVar : values()) {
                if (aVar.q.equals(str)) {
                    return aVar;
                }
            }
            return null;
        }
    }

    private static String c() {
        return Build.MANUFACTURER.toUpperCase();
    }

    public String a(Context context) {
        try {
            return a(context, c());
        } catch (Exception e) {
            p.a(f9537a, e.getMessage());
            return "";
        }
    }

    public String a(Context context, String str) throws Exception {
        a aVarB = a.b(str);
        if (a()) {
            aVarB = a.o;
        }
        if (b()) {
            aVarB = a.p;
        }
        if (aVarB == null) {
            throw new Exception(String.format(s.d(new byte[]{66, 87, 7, 87, 82, 90, 15, 1, 2, 66, 94, 4, 94, 93, 67, 95, 81, 71, 9, 11, 2, 66, 94, 3, Ascii.ETB, 84, 2, 92, 65, 85, 0, 7, Ascii.DC2, Ascii.ETB, 67, 0, 69, Ascii.EM, 70, 65}, "79c243"), str));
        }
        switch (c.f9539a[aVarB.ordinal()]) {
            case 1:
                return new com.xiaomi.onetrack.util.oaid.helpers.a().a(context);
            case 2:
                return new d().a(context);
            case 3:
            case 4:
                return new e().a(context);
            case 5:
                return new f().a(context);
            case 6:
                return new j().a(context);
            case 7:
                return new k().a(context);
            case 8:
                return new h().a(context);
            case 9:
                return new l().a(context);
            case 10:
            case 11:
            case 12:
                return n.b(context);
            case 13:
                return new i().a(context);
            case 14:
            case 15:
            case 16:
                return new m().a(context);
            default:
                return "";
        }
    }

    public boolean a() {
        String strA = ab.a(s.d(new byte[]{74, 14, 77, 85, 71, 10, 13, 0, 72, 4, 67, 0, 93, 12, 6, Ascii.EM, 94, 2, 3, 1, 10}, "8ac72c"));
        return !TextUtils.isEmpty(strA) && strA.equalsIgnoreCase(s.d(new byte[]{39, 97, 113, 32, 120, 124, 46, 55}, "a34e59"));
    }

    public boolean b() {
        String strA = ab.a(s.d(new byte[]{Ascii.ETB, 94, Ascii.RS, 16, Ascii.ETB, 16, 8, 74, Ascii.SYN, 16, 94, 1, 16, 82, 68}, "e10cde"));
        return (TextUtils.isEmpty(strA) || strA.equalsIgnoreCase(s.d(new byte[]{70, 92, 88, 90, 11, 78, 15}, "3234d9"))) ? false : true;
    }
}
