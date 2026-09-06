package com.xiaomi.onetrack.b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.xiaomi.onetrack.util.DeviceUtil;
import com.xiaomi.onetrack.util.aa;
import com.xiaomi.onetrack.util.p;
import com.xiaomi.onetrack.util.q;
import com.xiaomi.onetrack.util.x;
import com.xiaomi.onetrack.util.z;
import ijiami_1011.s.s.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class a {
    private static final long j = 172800000;
    private static final int s = 0;
    private static final int t = 1;
    private static final int u = 2;
    private static final int v = 100;
    private static final long x = 1800000;
    private static final int z = 0;
    private static final String i = s.d(new byte[]{36, 65, 66, 114, 11, 89, 7, 13, 1, 55, 65, 1, 4, 69, 87, 67}, "e121d7");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f9447a = s.d(new byte[]{93, 11, 65, 87, 82, 84, 4, 59, 10, 13, 86}, "9b2608");
    public static final String b = s.d(new byte[]{4, 68, 85, 94, 67}, "a20070");
    public static final String c = s.d(new byte[]{92, 79, 81, 93, Ascii.ETB, 16}, "9943cc");
    public static final String d = s.d(new byte[]{91, 3, 68, 83, 90}, "7f2662");
    public static final String e = s.d(new byte[]{67, 85, 84, Ascii.DC2, 88, 80}, "049b45");
    public static final String f = s.d(new byte[]{92, 4, 93, 1, 113, 7, Ascii.DC2}, "2a8e8c");
    public static final String g = s.d(new byte[]{87, 87, 94, 92, 3, 83, 49, 5, Ascii.DC4, 3, 92, Ascii.SYN}, "5602f7");
    private static final String k = s.d(new byte[]{10, 85, Ascii.NAK, 13}, "b4fe69");
    private static final String l = s.d(new byte[]{80, 19, 17, 43, 1}, "1cabe3");
    private static final String m = s.d(new byte[]{81, 67, 71, 75}, "03786f");
    public static final String h = s.d(new byte[]{71, 80, Ascii.SYN, SignedBytes.MAX_POWER_OF_TWO, 93, 89, 15}, "15d346");
    private static final String n = s.d(new byte[]{Ascii.SYN, 77, 67, 85}, "b4309d");
    private static final String o = s.d(new byte[]{65, SignedBytes.MAX_POWER_OF_TWO, 88, 67, Ascii.DC4, 71}, "2497a4");
    private static final String p = s.d(new byte[]{2, 80, 95, 3, Ascii.DC2, 86, 5}, "f53ff3");
    private static final String q = s.d(new byte[]{114, 94, 84, 75, 13, 13, 5}, "3009bd");
    private static AtomicBoolean r = new AtomicBoolean(false);
    private static ConcurrentHashMap<String, Long> w = new ConcurrentHashMap<>();
    private static b y = new b(Looper.getMainLooper(), null);
    private static ConcurrentHashMap<String, Boolean> A = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, Boolean> B = new ConcurrentHashMap<>();
    private static String C = "";

    /* JADX INFO: renamed from: com.xiaomi.onetrack.b.a$a, reason: collision with other inner class name */
    public static class C1161a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final a f9448a = new a(null);

        private C1161a() {
        }
    }

    public static class b extends Handler {
        private b(Looper looper) {
            super(looper);
        }

        public /* synthetic */ b(Looper looper, com.xiaomi.onetrack.b.b bVar) {
            this(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            p.a(s.d(new byte[]{120, 67, 70, 114, 12, 13, 7, 13, 1, 55, 65, 1, 88, 71, 83, 67}, "9361cc"), s.d(new byte[]{103, 86, 94, 84, 0, SignedBytes.MAX_POWER_OF_TWO, 13, 1, 37, 14, 94, 16, 80, 125, 87, 95, 0, 89, 4, Ascii.SYN, 72, 10, 80, 11, 80, 89, 83, 124, 1, 70, Ascii.DC2, 5, 1, 7, Ascii.GS, 69, 89, 70, 81, Ascii.US, 19, 93, 0, 16, 91}, "4561d5") + message.what);
            if (message.what == 0) {
                Object obj = message.obj;
                if (obj == null) {
                    p.a(s.d(new byte[]{120, 66, 68, 114, 12, 90, 7, 13, 1, 55, 65, 1, 88, 70, 81, 67}, "9241c4"), s.d(new byte[]{100, 2, 10, 93, 1, SignedBytes.MAX_POWER_OF_TWO, 13, 1, 37, 14, 94, 16, 83, 41, 3, 86, 1, 89, 4, Ascii.SYN, 72, 10, 80, 11, 83, 13, 7, 117, 0, 70, Ascii.DC2, 5, 1, 7, Ascii.GS, 69, 90, Ascii.DC2, 5, Ascii.SYN, 10, 87, 11, 68, 15, 17, 17, 11, 66, 13, 14}, "7ab8e5"));
                    return;
                }
                try {
                    String str = (String) obj;
                    p.a(s.d(new byte[]{117, 73, 69, 33, 95, 12, 7, 13, 1, 55, 65, 1, 85, 77, 80, 16}, "495b0b"), s.d(new byte[]{49, 80, 88, 7, 81, 76, 13, 1, 37, 14, 94, 16, 6, 123, 81, 12, 81, 85, 4, Ascii.SYN, 72, 10, 80, 11, 6, 95, 85, 47, 80, 74, Ascii.DC2, 5, 1, 7, Ascii.GS, 69, 3, 67, SignedBytes.MAX_POWER_OF_TWO, 43, 81, 3, 65}, "b30b59") + str);
                    com.xiaomi.onetrack.util.i.a(new d(this, str));
                } catch (Exception e) {
                    p.b(s.d(new byte[]{36, 67, 73, 37, 13, 88, 7, 13, 1, 55, 65, 1, 4, 71, 92, Ascii.DC4}, "e39fb6"), s.d(new byte[]{89, 84, 11, 5, 90, 92, 44, 1, Ascii.NAK, 17, 80, 2, 84, Ascii.NAK, 0, 19, 68, 86, 19, 94, 70}, "15ea69") + e.getMessage());
                }
            }
        }
    }

    private a() {
        String strC = aa.C();
        if (!TextUtils.isEmpty(strC)) {
            C = strC;
            return;
        }
        String strI = q.i();
        if (TextUtils.isEmpty(strI)) {
            return;
        }
        C = strI;
        aa.l(strI);
    }

    public /* synthetic */ a(com.xiaomi.onetrack.b.b bVar) {
        this();
    }

    public static a a() {
        return C1161a.f9448a;
    }

    private static JSONArray a(JSONArray jSONArray, JSONArray jSONArray2) {
        int i2 = 0;
        while (jSONArray2 != null) {
            try {
                if (i2 >= jSONArray2.length()) {
                    break;
                }
                JSONObject jSONObjectOptJSONObject = jSONArray2.optJSONObject(i2);
                String strOptString = jSONObjectOptJSONObject.optString(b);
                for (int i3 = 0; jSONArray != null && i3 < jSONArray.length(); i3++) {
                    if (TextUtils.equals(strOptString, jSONArray.optJSONObject(i3).optString(b))) {
                        jSONArray.remove(i3);
                        break;
                    }
                }
                String str = o;
                if (!jSONObjectOptJSONObject.has(str) || (jSONObjectOptJSONObject.has(str) && !TextUtils.equals(jSONObjectOptJSONObject.optString(str), p))) {
                    if (jSONArray == null) {
                        jSONArray = new JSONArray();
                    }
                    jSONArray.put(jSONObjectOptJSONObject);
                }
                i2++;
            } catch (Exception e2) {
                p.b(i, s.d(new byte[]{92, 85, 19, 86, 80, 33, Ascii.ETB, 1, 8, Ascii.SYN, 66, 32, 93, 85, 12, 84, 91, 16, 65, 1, Ascii.DC4, 16, 94, Ascii.ETB, 11}, "10a15d") + e2.toString());
            }
        }
        return jSONArray;
    }

    private static JSONObject a(String str, JSONObject jSONObject) {
        try {
            l lVarF = h.a().f(str);
            JSONArray jSONArrayOptJSONArray = lVarF != null ? lVarF.e.optJSONArray(c) : null;
            String str2 = c;
            jSONObject.put(str2, a(jSONArrayOptJSONArray, jSONObject.optJSONArray(str2)));
            return jSONObject;
        } catch (Exception e2) {
            p.b(i, s.d(new byte[]{93, 93, Ascii.SYN, 5, 83, 113, 14, 10, 0, 11, 86, 95, 16}, "08db62") + e2.toString());
            return null;
        }
    }

    public static void a(String str, List<String> list) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt(s.d(new byte[]{87, 94, 87, 85}, "413003")) == 0) {
                d(list);
                a(jSONObject.optJSONObject(s.d(new byte[]{84, 80, 77, 82}, "019359")).optJSONArray(m), list);
            }
        } catch (Exception e2) {
            p.a(i, s.d(new byte[]{66, 85, 69, 4, 39, Ascii.SYN, 17, 39, 10, 13, 68, 1, 117, 85, 71, 0, 92, 70}, "143aff") + e2.toString());
        }
    }

    private static void a(String str, JSONObject jSONObject, long j2) throws JSONException {
        int iOptInt = jSONObject == null ? 0 : jSONObject.optInt(h);
        int iE = h.a().e(str);
        String str2 = s.d(new byte[]{90, 86, 91, 82, 89, 67, Ascii.ETB, 1, Ascii.DC4, 17, 88, 10, 88, 3, Ascii.CAN}, "69835c") + iE + s.d(new byte[]{Ascii.NAK, 66, 71, 84, 19, 66, 4, Ascii.SYN, 70, Ascii.DC4, 84, Ascii.ETB, 74, 11, 91, 95, 91, Ascii.DC4}, "9b41a4") + iOptInt;
        String str3 = i;
        p.a(str3, str2);
        if (iE > 0 && iOptInt < iE && !f(str)) {
            a(jSONObject, j2);
            return;
        }
        int iOptInt2 = jSONObject != null ? jSONObject.optInt(n) : -1;
        p.a(str3, s.d(new byte[]{68, SignedBytes.MAX_POWER_OF_TWO, Ascii.NAK, 87, 94, 70}, "09e2df") + iOptInt2);
        if (iOptInt2 == 0 || iOptInt2 == 1 || f(str)) {
            a(jSONObject, j2, iOptInt);
        } else if (iOptInt2 == 2) {
            b(jSONObject, j2);
        } else {
            p.a(str3, s.d(new byte[]{9, 4, 86, 5, 13, 0, 37, 5, Ascii.DC2, 3, 17, 1, 14, 69, 86, 14, Ascii.NAK, 13, 8, 10, 1, 67}, "ae8aae"));
        }
    }

    private static void a(List<String> list, long j2) {
        try {
            ArrayList<l> arrayList = new ArrayList<>();
            for (int i2 = 0; i2 < list.size(); i2++) {
                l lVar = new l();
                lVar.f9459a = list.get(i2);
                lVar.b = 100L;
                lVar.c = j2;
                arrayList.add(lVar);
            }
            h.a().a(arrayList);
        } catch (Exception e2) {
            p.b(i, s.d(new byte[]{93, 88, 95, 84, 8, 1, 36, Ascii.SYN, Ascii.DC4, 13, 67}, "5910dd") + e2.toString());
        }
    }

    private static void a(List<String> list, long j2, List<String> list2) {
        try {
            if (list.size() != list2.size()) {
                list.removeAll(list2);
                a(list, j2);
            }
        } catch (Exception e2) {
            p.b(i, s.d(new byte[]{10, 84, 13, 1, 9, 1, 40, 10, 16, 3, 93, 12, 6, 116, 19, Ascii.NAK, 44, 0, Ascii.DC2, 68, 3, 16, 67, 10, 16, 15}, "b5ceed") + e2.toString());
        }
    }

    private static void a(JSONArray jSONArray, List<String> list) throws JSONException {
        p.a(i, s.d(new byte[]{69, 19, 84, 87, Ascii.DC2, 86, 37, 5, Ascii.DC2, 3, 101, 10, 116, 1, 16, 69, Ascii.DC2, 82, 19, 16}, "0c06f3"));
        long jCurrentTimeMillis = System.currentTimeMillis() + 86400000 + ((long) new Random().nextInt(86400000));
        if (jSONArray == null || jSONArray.length() <= 0) {
            a(list, jCurrentTimeMillis);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i2);
            String strOptString = jSONObjectOptJSONObject == null ? "" : jSONObjectOptJSONObject.optString(l);
            p.a(i, s.d(new byte[]{5, 71, Ascii.NAK, 112, 1, 2, 65}, "d7e9e8") + strOptString);
            if (!TextUtils.isEmpty(strOptString)) {
                arrayList.add(strOptString);
                a(strOptString, jSONObjectOptJSONObject, jCurrentTimeMillis);
            }
        }
        a(list, jCurrentTimeMillis, arrayList);
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            B.put(it.next(), Boolean.FALSE);
        }
    }

    private static void a(JSONObject jSONObject, long j2) {
        ArrayList<l> arrayList = new ArrayList<>();
        if (jSONObject != null) {
            l lVar = new l();
            lVar.f9459a = jSONObject.optString(l);
            lVar.c = j2;
            arrayList.add(lVar);
        }
        if (arrayList.isEmpty()) {
            p.a(i, s.d(new byte[]{66, Ascii.NAK, 6, 4, 70, 87, 44, 13, 8, 52, 84, Ascii.ETB, 68, 12, 13, 11, 118, 83, Ascii.NAK, 5, 70, 12, 94, 69, 67, 12, 15, 0, 65, 70, 0, 9, Ascii.SYN, 66, 82, 4, 89, 69, 0, 0, Ascii.DC2, 71, 17, 0, 7, Ascii.SYN, 84, 1, Ascii.SYN}, "7ebe22"));
        } else {
            h.a().a(arrayList);
        }
    }

    private static void a(JSONObject jSONObject, long j2, int i2) throws JSONException {
        l lVarF;
        JSONObject jSONObject2;
        ArrayList<l> arrayList = new ArrayList<>();
        if (jSONObject != null) {
            l lVar = new l();
            lVar.d = jSONObject.optString(k);
            lVar.f9459a = jSONObject.optString(l);
            lVar.b = b(jSONObject);
            lVar.c = j2;
            String str = c;
            if (!jSONObject.has(str) && (lVarF = h.a().f(lVar.f9459a)) != null && (jSONObject2 = lVarF.e) != null && jSONObject2.optJSONArray(str) != null) {
                jSONObject.put(str, lVarF.e.optJSONArray(str));
            }
            lVar.e = jSONObject;
            arrayList.add(lVar);
        }
        if (arrayList.isEmpty()) {
            p.a(i, s.d(new byte[]{89, 3, 91, 82, 88, 4, 39, 17, 10, 14, 126, Ascii.ETB, 127, 13, 123, 83, 67, 37, 0, 16, 7, 66, 95, 10, 17, 1, 90, 88, 82, 8, 6, 17, Ascii.DC4, 3, 69, 12, 94, 12, Ascii.NAK, 85, 85, 15, 65, 6, 3, 66, 68, Ascii.NAK, 85, 3, 65, 83, 80, SignedBytes.MAX_POWER_OF_TWO}, "1b564a"));
        } else {
            h.a().a(arrayList);
        }
    }

    private static int b(JSONObject jSONObject) {
        try {
            int iOptInt = jSONObject.optInt(e, 100);
            if (iOptInt < 0 || iOptInt > 100) {
                return 100;
            }
            return iOptInt;
        } catch (Exception e2) {
            p.a(i, s.d(new byte[]{85, 86, 71, 113, 87, 11, 12, 11, 8, 49, 80, 8, 66, 95, 86, Ascii.DC2, 125, Ascii.RS, 2, 1, Ascii.SYN, Ascii.SYN, 88, 10, 92, 9}, "23328f") + e2.getMessage());
            return 100;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(List<String> list) {
        String str = s.d(new byte[]{66, Ascii.ETB, 92, 10, 32, 85, 14, 17, 2, 38, 80, 17, 83, 66, 67, Ascii.DC2, 2, 75, Ascii.NAK, 72, 70, 3, 65, Ascii.NAK, 123, 6, 67, 92, 67}, "2b0fc9") + list.toString();
        String str2 = i;
        p.a(str2, str);
        if (q.a(str2)) {
            return;
        }
        if (r.compareAndSet(false, true)) {
            HashMap map = new HashMap();
            try {
                try {
                    String strI = q.i();
                    if (!TextUtils.isEmpty(strI)) {
                        C = strI;
                        aa.l(strI);
                    }
                    String strA = com.xiaomi.onetrack.util.oaid.a.a().a(com.xiaomi.onetrack.f.a.b());
                    if (z.b(strA)) {
                        strA = com.xiaomi.onetrack.d.d.c(strA);
                    }
                    map.put(s.d(new byte[]{87, 80}, "815d48"), strA);
                    map.put(s.d(new byte[]{87, 78}, "8883b3"), q.d());
                    map.put(s.d(new byte[]{13, 83}, "b1839c"), q.c());
                    map.put(s.d(new byte[]{11, 89}, "b09283"), q.h() ? s.d(new byte[]{3}, "2037e5") : s.d(new byte[]{84}, "dcf47b"));
                    map.put(s.d(new byte[]{69, 79}, "69dd30"), s.d(new byte[]{10, 74, 1, 72, 5}, "8d0f79"));
                    map.put(s.d(new byte[]{5, 17, 66, 103, 1, 75}, "da21d9"), com.xiaomi.onetrack.f.a.c());
                    map.put(s.d(new byte[]{81, 65}, "07a9b9"), q.e());
                    map.put(s.d(new byte[]{95, 94}, "227b18"), DeviceUtil.b());
                    map.put(s.d(new byte[]{75, 80}, "9515ec"), strI);
                    map.put(s.d(new byte[]{4, 95, 93}, "e61989"), c(list));
                    map.put(s.d(new byte[]{16, 83, 91, 86, 0, Ascii.DC4}, "c652ef"), com.xiaomi.onetrack.f.a.e());
                    map.put(s.d(new byte[]{71, 14, 7, Ascii.ETB, 95, 12, 19, 9}, "7bfc9c"), q);
                    map.put(s.d(new byte[]{SignedBytes.MAX_POWER_OF_TWO, 70, Ascii.DC2, 48, 93, 66}, "33bd42"), s.d(new byte[]{9}, "80e5c8"));
                    String strC = x.a().c();
                    p.a(str2, s.d(new byte[]{68, 66, 84, 91, 114, 88, Ascii.NAK, 5, 92}, "478769") + strC);
                    String strB = com.xiaomi.onetrack.g.b.b(strC, map, true);
                    p.a(str2, s.d(new byte[]{68, 6, Ascii.DC2, Ascii.SYN, 92, 93, Ascii.DC2, 1, 92}, "6caf33") + strB);
                    a(strB, list);
                } catch (Exception e2) {
                    p.b(i, s.d(new byte[]{70, 71, 13, 91, 38, 92, 14, 17, 2, 38, 80, 17, 87, Ascii.DC2, 4, 69, Ascii.ETB, 95, 19, 94, 70}, "62a7e0") + e2.getMessage());
                }
            } finally {
                r.set(false);
            }
        }
    }

    private static void b(JSONObject jSONObject, long j2) {
        ArrayList<l> arrayList = new ArrayList<>();
        if (jSONObject == null || !jSONObject.has(c)) {
            p.a(i, s.d(new byte[]{81, 83, 93, 83, 9, 6, 40, 10, 5, 16, 84, 8, 92, 92, 71, 86, 9, 54, 17, 0, 7, Ascii.SYN, 84, 69, 90, 93, 93, 81, 12, 4, 65, 13, Ascii.NAK, 66, 95, 10, 77, Ascii.DC2, 80, 95, 4, 13, 6, 1, 71}, "9237ec"));
        } else {
            l lVar = new l();
            lVar.d = jSONObject.optString(k);
            String strOptString = jSONObject.optString(l);
            lVar.f9459a = strOptString;
            lVar.b = b(jSONObject);
            lVar.c = j2;
            lVar.e = a(strOptString, jSONObject);
            arrayList.add(lVar);
        }
        if (arrayList.isEmpty()) {
            p.a(i, s.d(new byte[]{92, 0, 89, 2, 9, 80, 40, 10, 5, 16, 84, 8, 81, 15, 67, 7, 9, 96, 17, 0, 7, Ascii.SYN, 84, 69, 90, 14, Ascii.ETB, 5, 10, 91, 7, 13, 1, Ascii.ETB, 67, 4, SignedBytes.MAX_POWER_OF_TWO, 8, 88, 8, 69, 86, 0, 10, 70, 0, 84, 69, 65, 17, 83, 7, 17, 80, 5, 69}, "4a7fe5"));
        } else {
            h.a().a(arrayList);
        }
    }

    private static String c(List<String> list) {
        JSONArray jSONArray = new JSONArray();
        try {
            JSONObject jSONObject = new JSONObject();
            for (int i2 = 0; i2 < list.size(); i2++) {
                String str = list.get(i2);
                jSONObject.put(l, str);
                if (f(str)) {
                    jSONObject.put(k, "");
                } else {
                    jSONObject.put(k, h.a().d(str));
                }
                jSONArray.put(jSONObject);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return jSONArray.toString();
    }

    private static void d(List<String> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            w.put(list.get(i2), Long.valueOf(System.currentTimeMillis() + 1800000));
        }
    }

    private static boolean f(String str) {
        ConcurrentHashMap<String, Boolean> concurrentHashMap = B;
        return concurrentHashMap != null && concurrentHashMap.containsKey(str) && B.get(str).booleanValue();
    }

    private boolean g(String str) {
        if (!com.xiaomi.onetrack.g.c.a()) {
            p.a(i, s.d(new byte[]{93, 81, Ascii.ETB, Ascii.DC2, 94, Ascii.DC2, 65, 10, 9, Ascii.SYN, 17, 6, 92, 90, 13, 87, 84, Ascii.NAK, 4, 0, 71}, "34c27a"));
            return false;
        }
        l lVarF = h.a().f(str);
        if (lVarF == null) {
            return true;
        }
        long j2 = lVarF.c;
        return j2 < System.currentTimeMillis() || j2 - System.currentTimeMillis() > 172800000 || f(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean h(String str) {
        Long l2 = w.get(str);
        return l2 == null || l2.longValue() - System.currentTimeMillis() < 0 || l2.longValue() - System.currentTimeMillis() > 1800000;
    }

    public void a(String str) {
        B.put(str, Boolean.FALSE);
    }

    public void a(JSONObject jSONObject) {
        com.xiaomi.onetrack.util.i.a(new c(this, jSONObject));
    }

    public void b(String str) {
        com.xiaomi.onetrack.util.i.a(new com.xiaomi.onetrack.b.b(this, str));
    }

    public void c(String str) {
        if (!g(str)) {
            p.a(i, s.d(new byte[]{114, Ascii.NAK, 67, 116, 89, 8, 7, 13, 1, 55, 65, 1, 82, 17, 86, 69, Ascii.SYN, 34, 14, 1, Ascii.NAK, 66, 95, 10, 71, 69, 94, 82, 83, Ascii.DC2, 65, Ascii.DC4, Ascii.DC4, 7, 67, 0, 66, 16, 90, 68, 95, Ascii.DC2, 4, Ascii.ETB, 70, 4, 94, Ascii.ETB, 19, Ascii.ETB, 86, 70, 67, 3, Ascii.DC2, 16}, "3e376f"));
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        b(arrayList);
    }

    public void d(String str) {
        if (TextUtils.isEmpty(C) || TextUtils.isEmpty(str) || TextUtils.equals(C, str)) {
            return;
        }
        Iterator<Map.Entry<String, Boolean>> it = B.entrySet().iterator();
        while (it.hasNext()) {
            it.next().setValue(Boolean.TRUE);
        }
    }
}
