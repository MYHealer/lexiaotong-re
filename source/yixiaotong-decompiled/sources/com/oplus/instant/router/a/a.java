package com.oplus.instant.router.a;

import android.net.Uri;
import android.text.TextUtils;
import com.oplus.instant.router.g.d;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class a {
    private static String a(Object obj) {
        if (obj == null) {
            return "";
        }
        try {
            return URLEncoder.encode(obj.toString(), "utf-8");
        } catch (UnsupportedEncodingException e) {
            d.a("OapsParser", e);
            return obj.toString();
        }
    }

    public static String a(Map<String, Object> map) {
        HashMap map2 = new HashMap();
        map2.putAll(map);
        if (!map2.containsKey("scheme") || !map2.containsKey("host") || !map2.containsKey("path")) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(map2.remove("scheme")).append("://").append(map2.remove("host")).append(map2.remove("path"));
        if (map2.size() > 0) {
            sb.append("?");
            for (String str : map2.keySet()) {
                if (sb.charAt(sb.length() - 1) != '?') {
                    sb.append("&");
                }
                sb.append(str).append("=").append(a(map2.get(str)));
            }
        }
        return sb.toString();
    }

    public static Map<String, Object> a(String str) {
        Uri uri;
        HashMap map = new HashMap();
        if (!TextUtils.isEmpty(str) && (uri = Uri.parse(str)) != null && !TextUtils.isEmpty(uri.getScheme()) && !TextUtils.isEmpty(uri.getHost()) && !TextUtils.isEmpty(uri.getPath())) {
            map.put("scheme", uri.getScheme());
            map.put("host", uri.getHost());
            map.put("path", uri.getPath());
            Set<String> queryParameterNames = uri.getQueryParameterNames();
            if (queryParameterNames != null && !queryParameterNames.isEmpty()) {
                for (String str2 : queryParameterNames) {
                    if (!TextUtils.isEmpty(str2)) {
                        map.put(str2, uri.getQueryParameter(str2));
                    }
                }
            }
        }
        return map;
    }
}
