package com.hihonor.hianalytics.hnha;

import android.text.TextUtils;
import android.util.Pair;
import com.hihonor.hianalytics.util.SystemUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f3688a;
    private static final Map<String, com.hihonor.hianalytics.util.a> b = new HashMap();

    static {
        try {
            Class.forName("com.tencent.mmkv.MMKV");
            f3688a = true;
        } catch (Throwable th) {
            j2.c("StoreKVUtils", "static init failE=" + SystemUtils.getDesensitizedException(th));
        }
    }

    public static float a(String str, float f) {
        String strD = k.a().d(str);
        return strD == null ? f : com.hihonor.hianalytics.util.b.a(strD, f);
    }

    public static float a(String str, boolean z, String str2, float f) {
        return a(str, z).a(str2, f);
    }

    public static int a(String str, int i) {
        String strD = k.a().d(str);
        return strD == null ? i : com.hihonor.hianalytics.util.b.a(strD, i);
    }

    public static int a(String str, boolean z, String str2, int i) {
        return a(str, z).b(str2, i);
    }

    public static long a(String str, long j) {
        String strD = k.a().d(str);
        return strD == null ? j : com.hihonor.hianalytics.util.b.a(strD, j);
    }

    public static long a(String str, boolean z, String str2, long j) {
        return a(str, z).a(str2, j);
    }

    public static Pair<Boolean, Map<String, String>> a(List<String> list) {
        return k.a().a("excludeReportAppIdData", list);
    }

    public static Pair<Boolean, Map<String, String>> a(Map<String, String> map) {
        return k.a().a("excludeReportAppIdData", map);
    }

    public static Pair<Boolean, Map<String, String>> a(Set<String> set) {
        return a(new ArrayList(set));
    }

    public static synchronized com.hihonor.hianalytics.util.a a() {
        return a("prefer_single", false);
    }

    public static synchronized com.hihonor.hianalytics.util.a a(String str, boolean z) {
        if (str == null) {
            str = "prefer_single";
        }
        if (z) {
            try {
                str = str + "_dbMode";
            } catch (Throwable th) {
                throw th;
            }
        }
        Map<String, com.hihonor.hianalytics.util.a> map = b;
        com.hihonor.hianalytics.util.a aVar = map.get(str);
        if (aVar != null) {
            return aVar;
        }
        String strA = com.hihonor.hianalytics.util.b.a(str);
        j2.a("StoreKVUtils", "checkSingleSpUtils spName=" + strA + ",isDirectBoot=" + z);
        com.hihonor.hianalytics.util.a aVarB = com.hihonor.hianalytics.util.a.b(strA, z);
        map.put(str, aVarB);
        return aVarB;
    }

    public static String a(String str) {
        StringBuilder sb = new StringBuilder("autoSessionData_");
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        return b(sb.append(str).toString(), (String) null);
    }

    public static String a(String str, String str2) {
        String strD = k.a().d(str);
        return strD == null ? str2 : strD;
    }

    public static String a(String str, String str2, boolean z, String str3) {
        return k.a().a(str, str2, z, str3);
    }

    public static String a(String str, boolean z, String str2, String str3) {
        return a(str, z).a(str2, str3);
    }

    public static boolean a(int i) {
        return a().c("lastReportAllTime", i);
    }

    public static boolean a(long j) {
        return k.a().a("NewPrivacyTime", String.valueOf(j));
    }

    public static boolean a(String str, int i, boolean z) {
        if (!z && !f3688a) {
            return true;
        }
        String str2 = str + "_" + i + "_" + (z ? "a" : com.kuaishou.weapon.p0.t.l) + "_migrateKVSign";
        return z ? com.hihonor.hianalytics.util.b.a(k.a().d(str2), false) : a().a(str2, false);
    }

    public static boolean a(String str, int i, boolean z, boolean z2) {
        String str2 = str + "_" + i + "_" + (z ? "a" : com.kuaishou.weapon.p0.t.l) + "_migrateKVSign";
        return z ? k.a().a(str2, String.valueOf(z2)) : a().c(str2, z2);
    }

    public static <T> boolean a(String str, T t) {
        return k.a().a(str, t == null ? null : t.toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> boolean a(String str, boolean z, String str2, T t) {
        com.hihonor.hianalytics.util.a aVarA = a(str, z);
        if (t == 0) {
            return aVarA.d(str2);
        }
        if (t instanceof Integer) {
            return aVarA.c(str2, ((Integer) t).intValue());
        }
        if (t instanceof Boolean) {
            return aVarA.c(str2, ((Boolean) t).booleanValue());
        }
        if (t instanceof Float) {
            return aVarA.b(str2, ((Float) t).floatValue());
        }
        if (t instanceof Long) {
            return aVarA.b(str2, ((Long) t).longValue());
        }
        return t instanceof String ? aVarA.b(str2, (String) t) : aVarA.b(str2, t.toString());
    }

    public static boolean a(String str, boolean z, String str2, boolean z2) {
        return a(str, z).a(str2, z2);
    }

    public static boolean a(boolean z) {
        return k.a().a("isEnableOwnDataReport", String.valueOf(z));
    }

    public static Pair<Boolean, Map<String, String>> b(List<String> list) {
        return k.a().a("excludeReportTagData", list);
    }

    public static Pair<Boolean, Map<String, String>> b(Map<String, String> map) {
        return k.a().a("excludeReportTagData", map);
    }

    public static Pair<Boolean, Map<String, String>> b(Set<String> set) {
        return b(new ArrayList(set));
    }

    public static String b() {
        return k.a().d("NewPrivacyData");
    }

    public static String b(String str, String str2) {
        return a((String) null, false, str, str2);
    }

    public static boolean b(String str) {
        return k.a().a("NewPrivacyData", str);
    }

    public static <T> boolean b(String str, T t) {
        return a((String) null, false, str, (Object) t);
    }

    public static boolean b(String str, boolean z) {
        String strD = k.a().d(str);
        return strD == null ? z : com.hihonor.hianalytics.util.b.a(strD, z);
    }

    public static boolean b(boolean z) {
        return k.a().a("isEnableReportData", String.valueOf(z));
    }

    public static Map<String, String> c() {
        return k.a().c("excludeReportAppIdData");
    }

    public static boolean c(String str, String str2) {
        StringBuilder sb = new StringBuilder("autoSessionData_");
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        return b(sb.append(str).toString(), str2);
    }

    public static boolean c(boolean z) {
        return k.a().a("isGlobalMigrateEnd", String.valueOf(z));
    }

    @Deprecated
    public static List<String> d() {
        return k.a().b("excludeReportAppId");
    }

    public static Map<String, String> e() {
        return k.a().c("excludeReportTagData");
    }

    public static int f() {
        return a().b("lastReportAllTime", 0);
    }

    public static boolean g() {
        return com.hihonor.hianalytics.util.b.a(k.a().d("isEnableOwnDataReport"), true);
    }

    public static boolean h() {
        return com.hihonor.hianalytics.util.b.a(k.a().d("isEnableReportData"), true);
    }

    public static boolean i() {
        return com.hihonor.hianalytics.util.b.a(k.a().d("isGlobalMigrateEnd"), false);
    }
}
