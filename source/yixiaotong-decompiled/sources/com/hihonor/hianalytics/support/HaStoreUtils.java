package com.hihonor.hianalytics.support;

import com.hihonor.hianalytics.HaConstants;
import com.hihonor.hianalytics.hnha.u;
import com.hihonor.hianalytics.util.o;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public final class HaStoreUtils {
    public static boolean clear(String str) {
        return clear(str, false);
    }

    public static boolean clear(String str, boolean z) {
        return u.a(str, z).a();
    }

    public static Map<String, ?> getAll(String str) {
        return getAll(str, false);
    }

    public static Map<String, ?> getAll(String str, boolean z) {
        return u.a(str, z).b();
    }

    public static boolean getBoolean(String str, String str2, boolean z) {
        return u.a(str, false, str2, z);
    }

    public static boolean getBoolean(String str, boolean z, String str2, boolean z2) {
        return u.a(str, z, str2, z2);
    }

    public static float getFloat(String str, String str2, float f) {
        return u.a(str, false, str2, f);
    }

    public static float getFloat(String str, boolean z, String str2, float f) {
        return u.a(str, z, str2, f);
    }

    public static int getInt(String str, String str2, int i) {
        return u.a(str, false, str2, i);
    }

    public static int getInt(String str, boolean z, String str2, int i) {
        return u.a(str, z, str2, i);
    }

    public static long getLong(String str, String str2, long j) {
        return u.a(str, false, str2, j);
    }

    public static long getLong(String str, boolean z, String str2, long j) {
        return u.a(str, z, str2, j);
    }

    public static boolean getMultiProcessBoolean(String str, boolean z) {
        return !o.a("booleanKey", str, HaConstants.REGULAR_MODE_KEY) ? z : u.b(str, z);
    }

    public static float getMultiProcessFloat(String str, float f) {
        return !o.a("floatKey", str, HaConstants.REGULAR_MODE_KEY) ? f : u.a(str, f);
    }

    public static int getMultiProcessInt(String str, int i) {
        return !o.a("intKey", str, HaConstants.REGULAR_MODE_KEY) ? i : u.a(str, i);
    }

    public static long getMultiProcessLong(String str, long j) {
        return !o.a("longKey", str, HaConstants.REGULAR_MODE_KEY) ? j : u.a(str, j);
    }

    public static String getMultiProcessString(String str, String str2) {
        return !o.a("stringKey", str, HaConstants.REGULAR_MODE_KEY) ? str2 : u.a(str, str2);
    }

    public static long getSpFileSize(String str) {
        return getSpFileSize(str, false);
    }

    public static long getSpFileSize(String str, boolean z) {
        return u.a(str, z).d();
    }

    public static String getString(String str, String str2, String str3) {
        return u.a(str, false, str2, str3);
    }

    public static String getString(String str, boolean z, String str2, String str3) {
        return u.a(str, z, str2, str3);
    }

    public static boolean removeValue(String str, String str2) {
        return removeValue(str, false, str2);
    }

    public static boolean removeValue(String str, boolean z, String str2) {
        return u.a(str, z).d(str2);
    }

    public static <T> boolean setMultiProcessValue(String str, T t) {
        if (o.a("setKey", str, HaConstants.REGULAR_MODE_KEY)) {
            return u.a(str, t);
        }
        return false;
    }

    public static <T> boolean setValue(String str, String str2, T t) {
        return u.a(str, false, str2, (Object) t);
    }

    public static <T> boolean setValue(String str, boolean z, String str2, T t) {
        return u.a(str, z, str2, t);
    }
}
