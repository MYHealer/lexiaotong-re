package com.hihonor.hianalytics.hnha;

import java.util.LinkedHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public class z1 {
    private static JSONObject a(long j, String str, String str2, LinkedHashMap<String, String> linkedHashMap) {
        JSONObject jSONObject = linkedHashMap == null ? new JSONObject() : com.hihonor.hianalytics.util.l.a(linkedHashMap);
        try {
            if ("OnPause".equals(str2)) {
                jSONObject.put("_event_duration", j);
            }
            jSONObject.put("_activity_name", str);
        } catch (JSONException unused) {
            j2.g("ThreadUtil", "getEventContent(): JSONException");
        }
        return jSONObject;
    }

    public static JSONObject a(String str, long j, LinkedHashMap<String, String> linkedHashMap, String str2) {
        return a(j, str, str2, linkedHashMap);
    }
}
