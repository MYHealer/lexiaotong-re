package com.byazt.aas;

import android.text.TextUtils;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 131, 126})
public class bx {
    public static Map<String, String> c(String str) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        URL urlVe = ve(str);
        if (urlVe == null) {
            return linkedHashMap;
        }
        try {
            String query = urlVe.getQuery();
            if (query == null) {
                return linkedHashMap;
            }
            if (query.contains("url=")) {
                int iIndexOf = query.indexOf("url=");
                linkedHashMap.put("url", URLDecoder.decode(query.substring(iIndexOf + 4), "UTF-8"));
                query = query.substring(0, iIndexOf);
            }
            if (query.length() > 0) {
                for (String str2 : query.split("&")) {
                    int iIndexOf2 = str2.indexOf("=");
                    if (iIndexOf2 > 0 && iIndexOf2 < str2.length() - 1) {
                        String strSubstring = str2.substring(0, iIndexOf2);
                        int i = iIndexOf2 + 1;
                        String strSubstring2 = str2.substring(i);
                        if ("live_short_touch_params".equals(strSubstring) || "extra_pangle_scheme_params".equals(strSubstring)) {
                            linkedHashMap.put(URLDecoder.decode(str2.substring(0, iIndexOf2), "UTF-8"), URLDecoder.decode(str2.substring(i), "UTF-8"));
                        } else {
                            linkedHashMap.put(strSubstring, strSubstring2);
                        }
                    }
                }
            }
        } catch (Exception e) {
            com.byazt.nr.m.c(e);
        }
        return linkedHashMap;
    }

    public static String c(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str) || map == null || map.size() <= 0) {
            return "";
        }
        StringBuilder sbAppend = new StringBuilder(tt(str)).append("?");
        try {
            Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, String> next = it.next();
                String key = next.getKey();
                String value = next.getValue();
                if (it.hasNext()) {
                    if ("live_short_touch_params".equals(key) || "extra_pangle_scheme_params".equals(key)) {
                        sbAppend.append(URLEncoder.encode(next.getKey(), "UTF-8") + "=" + URLEncoder.encode(next.getValue(), "UTF-8") + "&");
                    } else {
                        sbAppend.append(key + "=" + value + "&");
                    }
                } else if ("live_short_touch_params".equals(key) || "extra_pangle_scheme_params".equals(key)) {
                    sbAppend.append(URLEncoder.encode(next.getKey(), "UTF-8") + "=" + URLEncoder.encode(next.getValue(), "UTF-8"));
                } else {
                    sbAppend.append(key + "=" + value);
                }
            }
        } catch (Exception unused) {
        }
        return sbAppend.toString();
    }

    public static String tt(String str) {
        return str.contains("?") ? str.substring(0, str.indexOf("?")) : str;
    }

    private static URL ve(String str) {
        if (str != null && str.length() != 0 && str.contains("://")) {
            try {
                return new URL("http" + str.substring(str.indexOf("://")));
            } catch (Exception e) {
                com.byazt.nr.m.c(e);
            }
        }
        return null;
    }
}
