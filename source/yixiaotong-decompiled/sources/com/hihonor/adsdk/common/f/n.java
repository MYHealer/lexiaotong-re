package com.hihonor.adsdk.common.f;

import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class n {
    private static final String hnadsa = "MapUtils";

    public static <K, V> boolean hnadsa(Map<K, V> map) {
        if (map != null) {
            return map.isEmpty();
        }
        com.hihonor.adsdk.common.b.b.hnadse(hnadsa, "isEmpty, map is null", new Object[0]);
        return true;
    }

    public static <K, V> boolean hnadsb(Map<K, V> map) {
        return !hnadsa(map);
    }

    public static <K, V> int hnadsc(Map<K, V> map) {
        if (map != null) {
            return map.size();
        }
        com.hihonor.adsdk.common.b.b.hnadse(hnadsa, "size, map is null", new Object[0]);
        return 0;
    }

    public static <K, V> String hnadsd(Map<K, V> map) {
        if (map != null) {
            return map.toString();
        }
        com.hihonor.adsdk.common.b.b.hnadse(hnadsa, "toString, map is null", new Object[0]);
        return "null";
    }
}
