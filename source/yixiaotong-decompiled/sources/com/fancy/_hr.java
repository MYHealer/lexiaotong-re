package com.fancy;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _hr {
    public static String _a(_f _fVar) {
        return _fVar != null ? _fVar._w : "";
    }

    public static String _a(String str, HashMap map) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if (!str.contains("?")) {
            str = str + "?";
        }
        if (str.endsWith("&")) {
            str = str.substring(0, str.length() - 1);
        }
        StringBuilder sb = new StringBuilder(str);
        for (Map.Entry entry : map.entrySet()) {
            sb.append("&");
            sb.append((String) entry.getKey());
            sb.append("=");
            sb.append(com.fancy.adsdk.lib.utils._a._b((String) entry.getValue()));
        }
        return sb.toString();
    }
}
