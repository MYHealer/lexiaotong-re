package com.xiaomi.onetrack;

import android.os.Bundle;
import com.google.common.base.Ascii;
import com.xiaomi.onetrack.util.p;
import com.xiaomi.onetrack.util.r;
import ijiami_1011.s.s.s;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class DataConverter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f9379a = s.d(new byte[]{34, 84, Ascii.DC2, 4, 37, 13, 15, Ascii.DC2, 3, 16, 69, 0, Ascii.DC4}, "f5fefb");

    private static List a(JSONArray jSONArray) throws JSONException {
        if (jSONArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            Object obj = jSONArray.get(i);
            if (r.b(obj)) {
                arrayList.add(obj);
            } else if (obj instanceof JSONObject) {
                JSONObject jSONObject = (JSONObject) obj;
                Iterator<String> itKeys = jSONObject.keys();
                HashMap map = new HashMap();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    Object obj2 = jSONObject.get(next);
                    if (r.b(obj2)) {
                        map.put(next, obj2);
                    }
                }
                if (map.size() > 0) {
                    arrayList.add(map);
                }
            }
        }
        return arrayList;
    }

    public static Map fromBundle(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        HashMap map = new HashMap();
        try {
            for (String str : bundle.keySet()) {
                Object obj = bundle.get(str);
                if (!r.b(obj)) {
                    if (obj.getClass().isArray()) {
                        int length = Array.getLength(obj);
                        ArrayList arrayList = new ArrayList();
                        for (int i = 0; i < length; i++) {
                            Object obj2 = Array.get(obj, i);
                            if (r.b(obj2)) {
                                arrayList.add(obj2);
                            }
                        }
                        if (arrayList.size() > 0) {
                            map.put(str, arrayList);
                        }
                    } else if (obj instanceof List) {
                        ArrayList arrayList2 = new ArrayList();
                        for (Object obj3 : (List) obj) {
                            if (r.b(obj3)) {
                                arrayList2.add(obj3);
                            }
                        }
                        if (arrayList2.size() > 0) {
                            obj = arrayList2;
                        }
                    } else if (p.f9551a) {
                        r.a(f9379a, str);
                    }
                }
                map.put(str, obj);
            }
        } catch (Exception e) {
            p.b(f9379a, s.d(new byte[]{81, 13, 93, Ascii.NAK, 84, 17, Ascii.NAK, 68, 4, Ascii.ETB, 95, 1, 94, 7, 19, 6, 67, 17, 14, Ascii.SYN, 92}, "2b3c1c") + e.toString());
        }
        return map;
    }

    public static Map fromJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        HashMap map = new HashMap();
        try {
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                Object objA = jSONObject.get(next);
                if (!r.b(objA)) {
                    if (objA instanceof JSONArray) {
                        objA = a((JSONArray) objA);
                    } else if (p.f9551a) {
                        r.a(f9379a, next);
                    }
                }
                map.put(next, objA);
            }
        } catch (Exception e) {
            p.b(f9379a, s.d(new byte[]{91, 88, 88, 19, 6, 16, Ascii.NAK, 68, 12, 17, 94, 11, Ascii.CAN, 67, 89, 69, 14, 3, 17, 68, 3, 16, 67, 10, 74, 13}, "876ecb") + e.toString());
        }
        return map;
    }
}
