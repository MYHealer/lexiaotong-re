package com.hihonor.adsdk.common.f;

import java.lang.reflect.Array;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class c {
    private static final String hnadsa = "ArrayUtils";

    public static int hnadsa(Object obj) {
        if (obj == null) {
            com.hihonor.adsdk.common.b.b.hnadse(hnadsa, "getLength, array is null", new Object[0]);
            return 0;
        }
        try {
            return Array.getLength(obj);
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "getLength, Array getLength Exception: " + e.getMessage(), new Object[0]);
            return 0;
        }
    }

    public static boolean hnadsb(Object obj) {
        return hnadsa(obj) == 0;
    }

    public static boolean hnadsc(Object obj) {
        return !hnadsb(obj);
    }

    public static void hnadsb(Object obj, int i, Object obj2) {
        if (Objects.isNull(obj)) {
            com.hihonor.adsdk.common.b.b.hnadse(hnadsa, "set, array is null", new Object[0]);
            return;
        }
        try {
            Array.set(obj, i, obj2);
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "set, Array set Exception: " + e.getMessage(), new Object[0]);
        }
    }

    public static Object hnadsa(Object obj, int i, Object obj2) {
        if (Objects.isNull(obj)) {
            com.hihonor.adsdk.common.b.b.hnadse(hnadsa, "get, array is null", new Object[0]);
            return obj2;
        }
        try {
            return Array.get(obj, i);
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "get, Array get Exception: " + e.getMessage(), new Object[0]);
            return obj2;
        }
    }
}
