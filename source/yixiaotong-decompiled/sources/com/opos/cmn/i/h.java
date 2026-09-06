package com.opos.cmn.i;

import android.text.TextUtils;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class h {
    public static String a(Map<String, String> map, String str) {
        if (map == null) {
            return "";
        }
        try {
            return map.containsKey(str) ? map.get(str) : "";
        } catch (Exception e) {
            com.opos.cmn.an.f.a.d("MapUtils", "safeGetValue() fail", e);
            return "";
        }
    }

    public static void a(Map<String, String> map, String str, String str2) {
        if (map != null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                map.put(str, str2);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.d("MapUtils", "safePutValue() fail", e);
            }
        }
    }
}
