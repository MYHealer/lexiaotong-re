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
public class e1 extends g1 {
    public e1(Context context) {
    }

    public static Map<String, Map<String, List<g1>>> a(Context context, String str, boolean z) throws IllegalAccessException, InvocationTargetException {
        SharedPreferences sharedPreferencesC = com.hihonor.hianalytics.util.p.c("cached_v2_1");
        if (sharedPreferencesC == null || context == null) {
            return null;
        }
        HashMap map = new HashMap();
        if (z) {
            Map<String, String> mapB = com.hihonor.hianalytics.util.p.b(sharedPreferencesC);
            int size = mapB.size();
            if (size == 0) {
                j2.a("ActionData", "parseAppActionDate No data");
                return map;
            }
            if (size > 800) {
                j2.e("ActionData", "parseAppActionDate The number of data obtained is too muchWithSize=" + size);
                return map;
            }
            Iterator<Map.Entry<String, String>> it = mapB.entrySet().iterator();
            while (it.hasNext()) {
                a(it.next(), context, map);
            }
        } else {
            a(str, com.hihonor.hianalytics.util.p.a("cached_v2_1", str, ""), context, map);
        }
        return map;
    }

    private static void a(String str, String str2, Context context, Map<String, Map<String, List<g1>>> map) {
        try {
            if (TextUtils.isEmpty(str2)) {
                j2.a("ActionData", "No data from cache sp!");
                return;
            }
            HashMap map2 = new HashMap();
            JSONArray jSONArray = new JSONArray(str2);
            int length = jSONArray.length();
            j2.c("ActionData", "readDataToAppAction arrayLen=" + length);
            for (int i = 0; i < length; i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                e1 e1Var = new e1(context);
                e1Var.a(jSONObjectOptJSONObject);
                e1Var.b(com.hihonor.hianalytics.util.g.a(str, e1Var.e));
                g1.a(map2, e1Var, TextUtils.isEmpty(e1Var.h) ? "noExHashFlag" : e1Var.h);
            }
            map.put(str, map2);
            j2.c("ActionData", "readDataToAppAction usersDataSize=" + map.size());
        } catch (JSONException unused) {
            j2.e("ActionData", "readDataToAppAction events is not json format");
        }
    }

    private static void a(Map.Entry<String, String> entry, Context context, Map<String, Map<String, List<g1>>> map) {
        a(entry.getKey(), entry.getValue(), context, map);
    }

    public static Map<String, Map<String, List<g1>>> b(Context context, String str, boolean z) {
        MMKV mmkvB = com.hihonor.hianalytics.util.m.b("cached_v2_1");
        if (mmkvB == null || context == null) {
            return null;
        }
        HashMap map = new HashMap();
        if (z) {
            Map<String, String> mapB = com.hihonor.hianalytics.util.m.b(mmkvB);
            int size = mapB.size();
            if (size == 0) {
                j2.a("ActionData", "parseAppActionDateNew No data");
                return map;
            }
            if (size > 800) {
                j2.e("ActionData", "parseAppActionDateNew The number of data obtained is too muchWithSize=" + size);
                return map;
            }
            Iterator<Map.Entry<String, String>> it = mapB.entrySet().iterator();
            while (it.hasNext()) {
                a(it.next(), context, map);
            }
        } else {
            a(str, com.hihonor.hianalytics.util.m.a("cached_v2_1", str, ""), context, map);
        }
        return map;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f3639a = jSONObject.optString("eventtime", "");
        this.b = jSONObject.optString(NotificationCompat.CATEGORY_EVENT, "");
        this.d = jSONObject.optString("type", "");
        a((String) s1.a(jSONObject.optString("properties"), r1.c().b()).second);
        if (jSONObject.has("event_session_name")) {
            this.f = jSONObject.optString("event_session_name");
            this.g = jSONObject.optString("first_session_event");
        }
        this.h = jSONObject.optString("nc_common_flag");
    }

    public void b(String str) {
        String str2 = this.e;
        if ((str2 != null && !str2.isEmpty()) || str == null || str.isEmpty()) {
            return;
        }
        this.e = str;
    }
}
