package com.hihonor.hianalytics.util;

import android.text.TextUtils;
import com.hihonor.hianalytics.hnha.j2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public final class l {
    public static JSONArray a(String str) {
        if (str == null || str.isEmpty()) {
            j2.g("JsonConverter", "getJsonArrayFromText json is empty");
            return new JSONArray();
        }
        try {
            return new JSONArray(str);
        } catch (JSONException e) {
            j2.g("JsonConverter", "getJsonArrayFromText failE=" + SystemUtils.getDesensitizedException(e));
            return new JSONArray();
        }
    }

    public static JSONObject a(Map<String, String> map) {
        return a(map, false);
    }

    public static JSONObject a(Map<String, String> map, boolean z) {
        JSONObject jSONObject = new JSONObject();
        if (map == null || map.isEmpty()) {
            if (z) {
                return null;
            }
            return jSONObject;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (!TextUtils.isEmpty(entry.getKey())) {
                try {
                    jSONObject.put(entry.getKey(), entry.getValue());
                } catch (JSONException e) {
                    j2.g("JsonConverter", "getJsonFromMap failE=" + SystemUtils.getDesensitizedException(e));
                }
            }
        }
        return jSONObject;
    }

    public static boolean a(String str, String str2, boolean z) {
        if (Objects.equals(str, str2)) {
            return true;
        }
        int length = str == null ? 0 : str.length();
        int length2 = str2 == null ? 0 : str2.length();
        if (length == 0 && length2 == 0 && z) {
            return true;
        }
        if (str != null && str2 != null) {
            try {
                return a(new JSONObject(str), new JSONObject(str2), z);
            } catch (Throwable th) {
                j2.g("JsonConverter", "isJsonObjSame failE=" + SystemUtils.getDesensitizedException(th));
            }
        }
        return false;
    }

    public static boolean a(JSONArray jSONArray, JSONArray jSONArray2, boolean z) {
        if (jSONArray == jSONArray2) {
            return true;
        }
        int length = jSONArray == null ? 0 : jSONArray.length();
        int length2 = jSONArray2 == null ? 0 : jSONArray2.length();
        if (length == 0 && length2 == 0 && z) {
            return true;
        }
        if (jSONArray == null || jSONArray2 == null || length != length2) {
            return false;
        }
        int length3 = jSONArray.length();
        for (int i = 0; i < length3; i++) {
            Object objOpt = jSONArray.opt(i);
            Object objOpt2 = jSONArray2.opt(i);
            if ((objOpt instanceof JSONObject) && (objOpt2 instanceof JSONObject)) {
                return a((JSONObject) objOpt, (JSONObject) objOpt2, z);
            }
            if ((objOpt instanceof JSONArray) && (objOpt2 instanceof JSONArray)) {
                return a((JSONArray) objOpt, (JSONArray) objOpt2, z);
            }
            if (!Objects.equals(objOpt, objOpt2)) {
                return false;
            }
        }
        return true;
    }

    public static boolean a(JSONObject jSONObject, JSONObject jSONObject2, boolean z) {
        if (jSONObject == jSONObject2) {
            return true;
        }
        int length = jSONObject == null ? 0 : jSONObject.length();
        int length2 = jSONObject2 == null ? 0 : jSONObject2.length();
        if (length == 0 && length2 == 0 && z) {
            return true;
        }
        if (jSONObject == null || jSONObject2 == null || length != length2) {
            return false;
        }
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (!jSONObject2.has(next)) {
                return false;
            }
            Object objOpt = jSONObject.opt(next);
            Object objOpt2 = jSONObject2.opt(next);
            if ((objOpt instanceof JSONObject) && (objOpt2 instanceof JSONObject)) {
                return a((JSONObject) objOpt, (JSONObject) objOpt2, z);
            }
            if ((objOpt instanceof JSONArray) && (objOpt2 instanceof JSONArray)) {
                return a((JSONArray) objOpt, (JSONArray) objOpt2, z);
            }
            if (!Objects.equals(objOpt, objOpt2)) {
                return false;
            }
        }
        return true;
    }

    public static List<String> b(String str) {
        ArrayList arrayList = new ArrayList();
        if (str == null || str.isEmpty()) {
            j2.g("JsonConverter", "getListFromJsonArray json is empty");
            return arrayList;
        }
        JSONArray jSONArrayA = a(str);
        if (jSONArrayA.length() == 0) {
            return arrayList;
        }
        int length = jSONArrayA.length();
        for (int i = 0; i < length; i++) {
            arrayList.add(jSONArrayA.optString(i));
        }
        return arrayList;
    }

    public static Map<String, String> c(String str) {
        HashMap map = new HashMap();
        if (str == null || str.isEmpty()) {
            j2.g("JsonConverter", "getListFromJsonArray json is empty");
            return map;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                map.put(next, jSONObject.optString(next, ""));
            }
        } catch (Exception e) {
            j2.b("JsonConverter", "getMapFromJsonObject Exception=" + SystemUtils.getDesensitizedException(e));
        }
        return map;
    }
}
