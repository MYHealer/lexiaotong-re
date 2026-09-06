package com.opos.mobad.cmn.func.b.b;

import android.content.Context;
import android.text.TextUtils;
import com.opos.mobad.provider.record.SdKRecord;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static long f6808a = -1;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static b.a a(b.a aVar, String str, boolean z) {
        if (aVar == null) {
            aVar = new b.a();
        }
        aVar.a(aVar.a() + 1);
        if (z) {
            aVar.e(aVar.e() + 1);
        }
        str.hashCode();
        switch (str) {
            case "MOCK_TOUCH_EVENT":
                aVar.b(aVar.b() + 1);
                return aVar;
            case "MOCK_PERFORM_CLICK":
                aVar.d(aVar.d() + 1);
                return aVar;
            case "MOCK_CALL_CLICK":
                aVar.c(aVar.c() + 1);
                return aVar;
            default:
                return aVar;
        }
    }

    private static b.a a(String str, String str2, boolean z, Map<String, b.a> map) {
        b.a aVar = map.containsKey(str) ? map.get(str) : null;
        if (aVar == null) {
            aVar = new b.a();
        }
        return a(aVar, str2, z);
    }

    public static String a(int i) {
        String str;
        if (i == 1) {
            str = "MOCK_CALL_CLICK";
        } else if (i != 2) {
            str = i != 3 ? "INTERCEPT_UNKNOWN_EVENT" : "MOCK_TOUCH_EVENT";
        } else {
            str = "MOCK_PERFORM_CLICK";
        }
        com.opos.cmn.an.f.a.b("ViewMockEventUtils", "getMockEventKey=".concat(str));
        return str;
    }

    public static Map<String, Map<String, b.a>> a(Context context) {
        String[] strArrA = SdKRecord.a(context).a("INTERCEPT", true);
        Map<String, Map<String, b.a>> map = new HashMap<>();
        for (String str : strArrA) {
            map = a(str, map);
        }
        com.opos.cmn.an.f.a.b("ViewMockEventUtils", "getViewMockEventDataMap countMapMap:", map);
        return map;
    }

    private static Map<String, Map<String, b.a>> a(String str, Map<String, Map<String, b.a>> map) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String strOptString = jSONObject.optString("KEY_TEMPLATE_ID");
                String strOptString2 = jSONObject.optString("KEY_POS_ID");
                String strOptString3 = jSONObject.optString("KEY_MOCK_EVENT");
                boolean zOptBoolean = jSONObject.optBoolean("KEY_INTERCEPT_MOCK_FLAG");
                Map<String, b.a> map2 = new HashMap<>();
                if (map.containsKey(strOptString)) {
                    map2 = map.get(strOptString);
                }
                map2.put(strOptString2, a(strOptString2, strOptString3, zOptBoolean, map2));
                map.put(strOptString, map2);
            } catch (JSONException e) {
                com.opos.cmn.an.f.a.d("ViewMockEventUtils", "getViewMockEventDataMap", e);
            }
        }
        return map;
    }

    public static JSONObject a(b.a aVar) {
        if (aVar == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("mockCount", aVar.a());
            jSONObject.put("mockCallClickCount", aVar.c());
            jSONObject.put("mockPerformClickCount", aVar.d());
            jSONObject.put("mockTouchEventCount", aVar.b());
            jSONObject.put("interceptTimes", aVar.e());
            com.opos.cmn.an.f.a.b("ViewMockEventUtils", "getViewMockEventCountData:" + jSONObject.toString());
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void a(Context context, String str, String str2, String str3, boolean z) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("KEY_TEMPLATE_ID", str2);
            jSONObject.put("KEY_POS_ID", str);
            jSONObject.put("KEY_MOCK_EVENT", str3);
            jSONObject.put("KEY_INTERCEPT_MOCK_FLAG", z);
            SdKRecord.a(context).c("INTERCEPT" + System.currentTimeMillis(), jSONObject.toString());
        } catch (JSONException e) {
            com.opos.cmn.an.f.a.d("ViewMockEventUtils", "saveViewMockEventCount", e);
        }
    }

    public static void a(Context context, Map<String, Map<String, b.a>> map, a aVar) {
        try {
            for (String str : map.keySet()) {
                Map<String, b.a> map2 = map.get(str);
                if (map2 != null) {
                    for (String str2 : map2.keySet()) {
                        b.a aVar2 = map2.get(str2);
                        if (aVar2 != null) {
                            aVar.a(context, str2, str, aVar2.a(), a(aVar2));
                        }
                    }
                }
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.d("ViewMockEventUtils", "recordMockEventDataMap", e);
        }
    }

    public static boolean a() {
        return System.currentTimeMillis() - f6808a > 120000;
    }

    public static void b() {
        f6808a = System.currentTimeMillis();
    }
}
