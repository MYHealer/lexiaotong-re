package com.hihonor.hianalytics.hnha;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.tencent.mmkv.MMKV;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class h1 extends g1 {
    public static Map<String, Map<String, List<g1>>> a(Context context, String str, boolean z) throws IllegalAccessException, InvocationTargetException {
        SharedPreferences sharedPreferencesC = com.hihonor.hianalytics.util.p.c("stat_v2_1");
        if (sharedPreferencesC == null || context == null) {
            j2.g("EventRecord", "readAllRecords illegal context=" + context + ",sp=" + sharedPreferencesC);
            return null;
        }
        HashMap map = new HashMap();
        if (z) {
            Map<String, String> mapB = com.hihonor.hianalytics.util.p.b(sharedPreferencesC);
            int size = mapB.size();
            if (size == 0) {
                j2.a("EventRecord", "readAllRecords No data");
                return map;
            }
            if (size > 800) {
                j2.e("EventRecord", "readAllRecords number of data obtained is too muchWithSize=" + size);
                return map;
            }
            j2.a("EventRecord", "readAllRecords eventSize=" + size);
            Iterator<Map.Entry<String, String>> it = mapB.entrySet().iterator();
            while (it.hasNext()) {
                a(it.next(), map);
            }
        } else {
            a(str, com.hihonor.hianalytics.util.p.a("stat_v2_1", str, ""), map);
        }
        return map;
    }

    private static void a(String str, String str2, Map<String, Map<String, List<g1>>> map) {
        JSONArray jSONArray;
        String str3;
        try {
            jSONArray = !TextUtils.isEmpty(str2) ? new JSONArray(str2) : null;
        } catch (JSONException unused) {
            j2.e("EventRecord", "readDataToRecord occurJsonException");
        }
        int length = jSONArray == null ? 0 : jSONArray.length();
        if (length == 0) {
            str3 = "readDataToRecord emptyEventJsonArray";
        } else {
            j2.a("EventRecord", "readDataToRecord eventJsonArrayLen=" + length + ",hakey=" + r1.c().b());
            HashMap map2 = new HashMap();
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    h1 h1Var = new h1();
                    if (jSONObject != null) {
                        String strOptString = jSONObject.optString("nc_common_flag");
                        h1Var.b = jSONObject.optString(NotificationCompat.CATEGORY_EVENT, "");
                        h1Var.f3639a = jSONObject.optString("eventtime");
                        h1Var.d = jSONObject.optString("type");
                        String str4 = (String) s1.a(jSONObject.optString("content"), r1.c().b()).second;
                        h1Var.c = str4;
                        if (TextUtils.isEmpty(str4)) {
                            j2.e("EventRecord", "cache content is empty withID=" + h1Var.b + ",hashCodeEx=" + strOptString + ",recordTime=" + h1Var.f3639a + ",eventDataType=" + h1Var.d + ",userKey=" + str);
                        } else {
                            h1Var.h = strOptString;
                            if (jSONObject.has("event_session_name")) {
                                h1Var.f = jSONObject.optString("event_session_name");
                                h1Var.g = jSONObject.optString("first_session_event");
                            }
                            if (TextUtils.isEmpty(strOptString)) {
                                g1.a(map2, h1Var, "noExHashFlag");
                            } else {
                                g1.a(map2, h1Var, strOptString);
                            }
                        }
                    }
                } catch (JSONException unused2) {
                    j2.e("EventRecord", "readDataToRecord events is not json format");
                }
            }
            map.put(str, map2);
            str3 = "readDataToRecord usersDataSize=" + map.size() + ",hakey=" + r1.c().b();
        }
        j2.a("EventRecord", str3);
    }

    private static void a(Map.Entry<String, String> entry, Map<String, Map<String, List<g1>>> map) {
        a(entry.getKey(), entry.getValue(), map);
    }

    public static Map<String, Map<String, List<g1>>> b(Context context, String str, boolean z) {
        MMKV mmkvB = com.hihonor.hianalytics.util.m.b("stat_v2_1");
        if (mmkvB == null || context == null) {
            j2.g("EventRecord", "readAllRecordsNew illegal context=" + context + ",mmkv=" + mmkvB);
            return null;
        }
        HashMap map = new HashMap();
        if (z) {
            Map<String, String> mapB = com.hihonor.hianalytics.util.m.b(mmkvB);
            int size = mapB.size();
            if (size == 0) {
                j2.a("EventRecord", "readAllRecordsNew No data");
                return map;
            }
            if (size > 800) {
                j2.e("EventRecord", "readAllRecordsNew number of data obtained is too muchWithSize=" + size);
                return map;
            }
            j2.a("EventRecord", "readAllRecordsNew eventSize=" + size);
            Iterator<Map.Entry<String, String>> it = mapB.entrySet().iterator();
            while (it.hasNext()) {
                a(it.next(), map);
            }
        } else {
            a(str, com.hihonor.hianalytics.util.m.a("stat_v2_1", str, ""), map);
        }
        return map;
    }
}
