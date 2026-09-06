package com.hihonor.adsdk.common.video;

import android.content.Context;
import android.util.ArrayMap;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class d {
    private static final Map<String, c> hnadsa = new ArrayMap();

    public static c hnadsa(String str) {
        if (hnadsb(str)) {
            return hnadsa.get(str);
        }
        return null;
    }

    public static boolean hnadsb(String str) {
        return hnadsa.containsKey(str);
    }

    public static void hnadsc(String str) {
        if (hnadsb(str)) {
            hnadsa.remove(str);
        }
    }

    public static c hnadsa(Context context, String str) {
        com.hihonor.adsdk.common.video.h.a aVar = new com.hihonor.adsdk.common.video.h.a(context);
        hnadsa.put(str, aVar);
        return aVar;
    }
}
