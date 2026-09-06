package com.kwad.sdk.utils;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class bb {
    public static String appendUrl(String str, Map<String, String> map) {
        if (map == null || map.size() <= 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = map.keySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            String next = it.next();
            if (map.get(next) != null) {
                sb.append(next).append("=").append(map.get(next)).append("&");
            }
        }
        String string = sb.toString();
        return (str + (str.contains("?") ? "&" : "?")) + string.substring(0, string.length() - 1);
    }
}
