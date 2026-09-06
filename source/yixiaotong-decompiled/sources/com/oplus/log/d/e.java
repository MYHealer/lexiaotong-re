package com.oplus.log.d;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f5819a = {"MemTotal:", "MemFree:", "Buffers:", "Cached:", "Active:", "Inactive:", "Dirty:"};
    public static final String[] b = {"VmLck:", "VmRSS:", "VmSize:", "VmExe:", "VmStk:", "VmLib", "Threads:"};

    public static Map<String, Long> a() {
        HashMap map = new HashMap();
        try {
            Method method = Class.forName("android.os.Process").getMethod("readProcLines", String.class, String[].class, long[].class);
            if (method != null) {
                String[] strArr = f5819a;
                int length = strArr.length;
                long[] jArr = new long[length];
                jArr[0] = 30;
                jArr[1] = -30;
                method.invoke(null, new String("/proc/meminfo"), strArr, jArr);
                for (int i = 0; i < length; i++) {
                    map.put(f5819a[i], Long.valueOf(jArr[i]));
                }
            }
            return map;
        } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | NoSuchMethodException | SecurityException | InvocationTargetException unused) {
            return null;
        }
    }
}
