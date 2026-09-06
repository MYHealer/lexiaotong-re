package com.xiaomi.onetrack.util;

import android.text.TextUtils;
import com.google.common.base.Ascii;
import com.xiaomi.onetrack.Configuration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.io.encoding.Base64;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class r {
    private static final String c = ijiami_1011.s.s.s.d(new byte[]{51, 81, Ascii.ETB, 88, 93, 109, Ascii.NAK, 13, 10}, "c0e908");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f9553a = ijiami_1011.s.s.s.d(new byte[]{88, 92, 6, Ascii.ETB, Ascii.DC4, 82, 2, 15, 57}, "72ccf3");
    public static final String b = ijiami_1011.s.s.s.d(new byte[]{95, 77, 107}, "094a5c");

    public interface a {
        boolean a(Object obj);
    }

    public static String a(Configuration configuration) {
        StringBuilder sb = new StringBuilder();
        String appId = configuration.getAppId();
        String pluginId = configuration.getPluginId();
        if (!TextUtils.isEmpty(appId)) {
            sb.append(appId);
        }
        if (!TextUtils.isEmpty(pluginId)) {
            sb.append(pluginId);
        }
        return com.xiaomi.onetrack.d.d.h(sb.toString());
    }

    public static JSONArray a(List list) throws JSONException {
        if (list == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (Object obj : list) {
            if (!b(obj)) {
                if (obj instanceof Map) {
                    JSONObject jSONObject = new JSONObject();
                    boolean z = false;
                    for (Map.Entry entry : ((Map) obj).entrySet()) {
                        Object key = entry.getKey();
                        Object value = entry.getValue();
                        if ((key instanceof String) && b(value)) {
                            jSONObject.put((String) key, value);
                            z = true;
                        }
                    }
                    if (z) {
                        obj = jSONObject;
                    }
                }
            }
            jSONArray.put(obj);
        }
        return jSONArray;
    }

    public static JSONObject a(Map<String, Object> map) {
        return a(map, new t());
    }

    private static JSONObject a(Map<String, Object> map, a aVar) {
        JSONObject jSONObject = new JSONObject();
        if (map == null) {
            return jSONObject;
        }
        try {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if (aVar.a(value)) {
                    if (b(value)) {
                        jSONObject.put(key, value);
                    } else if (value instanceof List) {
                        jSONObject.put(key, a((List) value));
                    }
                } else if (p.f9551a) {
                    a(c, entry.getKey());
                }
            }
        } catch (Exception e) {
            p.b(c, ijiami_1011.s.s.s.d(new byte[]{80, 92, 3, 90, 94, 100, 0, Ascii.SYN, 7, 15, 17, 0, 65, 70, 9, 75, 15}, "34f954") + e.toString());
        }
        return jSONObject;
    }

    public static JSONObject a(Map<String, Object> map, boolean z) {
        return a(map, new s(z));
    }

    public static JSONObject a(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null && jSONObject2 == null) {
            return new JSONObject();
        }
        if (jSONObject == null && jSONObject2 != null) {
            return jSONObject2;
        }
        if (jSONObject != null && jSONObject2 == null) {
            return jSONObject;
        }
        try {
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                jSONObject2.put(next, jSONObject.opt(next));
            }
            return jSONObject2;
        } catch (Exception e) {
            p.b(c, ijiami_1011.s.s.s.d(new byte[]{95, 3, 67, 6, 82, 65, 4, Ascii.SYN, Ascii.DC4, 13, 67, -118, -114, -4}, "2f1a7a") + e.toString());
            return jSONObject;
        }
    }

    public static void a(String str, String str2) {
        p.b(str, ijiami_1011.s.s.s.d(new byte[]{93, 7, 73, Ascii.DC2, 10, Ascii.DC2, 65}, "6b02ca") + str2 + ijiami_1011.s.s.s.d(new byte[]{Ascii.CAN, 66, Ascii.SYN, 88, 87, 67, 17, 5, Ascii.DC4, 3, 92, 69, 66, 3, 14, 69, 87, 67, 8, Ascii.ETB, 70, 11, 95, 19, 85, 14, 11, 84, -35, -33, -19, Ascii.DC4, 10, 7, 80, Ascii.SYN, 81, 66, 1, 88, 83, 13, 6, 1, 70, Ascii.SYN, 89, 0, Ascii.DC4, Ascii.DC2, 3, 66, 83, 14, 4, 16, 3, 16, 17, 17, 77, Ascii.DC2, 7, 16, 70, 12, 65, Ascii.ETB, Ascii.DC2, 16, 88, 11, 83, 66, 78, 94, 71, 14, 4, Ascii.SYN, 15, 1, Ascii.GS, 69, 86, 13, 13, 92, 87, 2, 15, -117, -38, -29}, "4bb02c"));
    }

    public static boolean a(Object obj) {
        return b(obj) || (obj instanceof List);
    }

    public static boolean a(String str) {
        if (!c(str)) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        return (lowerCase.startsWith(f9553a) || lowerCase.startsWith(b)) ? false : true;
    }

    public static boolean b(Object obj) {
        return (obj instanceof Boolean) || (obj instanceof Number) || (obj instanceof String);
    }

    private static boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.matches(ijiami_1011.s.s.s.d(new byte[]{Ascii.US, 13, 62, 83, Ascii.ESC, Ascii.FS, Base64.padSymbol, 74, 58, 6, 26, 76, 13}, "22b704"));
    }

    private static boolean c(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char c2 = charArray[i];
            if (i == 0 && Character.isDigit(c2)) {
                return false;
            }
            if (c2 != '_' && !Character.isDigit(c2) && ((c2 < 'a' || c2 > 'z') && (c2 < 'A' || c2 > 'Z'))) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean d(Object obj) {
        return obj instanceof Number;
    }
}
