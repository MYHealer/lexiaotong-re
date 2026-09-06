package com.kwad.sdk.utils;

import com.huawei.hms.ml.camera.CountryCodeBean;
import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class bs {
    public static String get(String str) {
        Object objB = b("get", new Class[]{String.class}, str);
        if (objB instanceof String) {
            return (String) objB;
        }
        return ih(str);
    }

    public static String get(String str, String str2) {
        Object objB = b("get", new Class[]{String.class, String.class}, str, str2);
        if (objB instanceof String) {
            return (String) objB;
        }
        return (String) a(str, str2, new com.kwad.sdk.g.b<String, String>() { // from class: com.kwad.sdk.utils.bs.1
            private static String ii(String str3) {
                return str3;
            }

            @Override // com.kwad.sdk.g.b
            public final /* synthetic */ String apply(String str3) {
                return ii(str3);
            }
        });
    }

    public static int getInt(String str, int i) {
        Object objB = b("getInt", new Class[]{String.class, Integer.TYPE}, str, Integer.valueOf(i));
        if (objB instanceof Integer) {
            return ((Integer) objB).intValue();
        }
        return ((Integer) a(str, Integer.valueOf(i), new com.kwad.sdk.g.b<String, Integer>() { // from class: com.kwad.sdk.utils.bs.2
            @Override // com.kwad.sdk.g.b
            public final /* synthetic */ Integer apply(String str2) {
                return ij(str2);
            }

            private static Integer ij(String str2) {
                return Integer.valueOf(Integer.parseInt(str2));
            }
        })).intValue();
    }

    public static long getLong(String str, long j) {
        Object objB = b("getLong", new Class[]{String.class, Long.TYPE}, str, Long.valueOf(j));
        if (objB instanceof Long) {
            return ((Long) objB).longValue();
        }
        return ((Long) a(str, Long.valueOf(j), new com.kwad.sdk.g.b<String, Long>() { // from class: com.kwad.sdk.utils.bs.3
            @Override // com.kwad.sdk.g.b
            public final /* synthetic */ Long apply(String str2) {
                return ik(str2);
            }

            private static Long ik(String str2) {
                return Long.valueOf(Long.parseLong(str2));
            }
        })).longValue();
    }

    public static boolean getBoolean(String str, boolean z) {
        Object objB = b("getBoolean", new Class[]{String.class, Boolean.TYPE}, str, Boolean.valueOf(z));
        if (objB instanceof Boolean) {
            return ((Boolean) objB).booleanValue();
        }
        return ((Boolean) a(str, Boolean.valueOf(z), new com.kwad.sdk.g.b<String, Boolean>() { // from class: com.kwad.sdk.utils.bs.4
            @Override // com.kwad.sdk.g.b
            public final /* synthetic */ Boolean apply(String str2) {
                return il(str2);
            }

            private static Boolean il(String str2) {
                return Boolean.valueOf(Boolean.parseBoolean(str2));
            }
        })).booleanValue();
    }

    private static Object b(String str, Class[] clsArr, Object... objArr) {
        try {
            return ab.a(CountryCodeBean.ANDRIOD_SYSTEMPROP, str, clsArr, objArr);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTrace(th);
            return null;
        }
    }

    private static <T> T a(String str, T t, com.kwad.sdk.g.b<String, T> bVar) {
        String strIh = ih(str);
        if (strIh == null) {
            return t;
        }
        try {
            return bVar.apply(strIh);
        } catch (Throwable unused) {
            return t;
        }
    }

    private static String ih(String str) {
        try {
            return com.kwad.sdk.crash.utils.h.c(Runtime.getRuntime().exec("getprop " + str).getInputStream());
        } catch (IOException e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
            return null;
        }
    }
}
