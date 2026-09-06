package com.xiaomi.onetrack.b;

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
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class e {
    private static final long g = 172800000;
    private static final String b = s.d(new byte[]{115, 94, 12, 92, 14, 8, 34, 11, 8, 4, 88, 2, 101, 65, 5, 80, Ascii.NAK, 3, 19}, "01a1af");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f9452a = s.d(new byte[]{91}, "794f60");
    private static final String c = s.d(new byte[]{65}, "512136");
    private static final String d = s.d(new byte[]{88, 87, Ascii.NAK, 85, 84, SignedBytes.MAX_POWER_OF_TWO}, "42c083");
    private static final String e = s.d(new byte[]{116, 92, 1, 17, 91, 81, 5}, "52ec48");
    private static ConcurrentHashMap<Integer, Integer> f = new ConcurrentHashMap<>();

    public static void a() {
        com.xiaomi.onetrack.util.i.a(new f());
    }

    private static void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt(s.d(new byte[]{91, 86, 87, 80}, "89354d")) == 0) {
                String strOptString = jSONObject.optString(s.d(new byte[]{95, 87, 65, 12}, "762d85"));
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(s.d(new byte[]{0, 0, 69, 89}, "da183e"));
                if (jSONObjectOptJSONObject != null) {
                    JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject(s.d(new byte[]{19, 86, 94, 13, 11, 91, 52, Ascii.SYN, 10}, "a39dd5"));
                    if (jSONObjectOptJSONObject2 != null) {
                        x.a().a(jSONObjectOptJSONObject2);
                    }
                    aa.d(jSONObjectOptJSONObject.toString());
                    aa.c(strOptString);
                }
                aa.j(System.currentTimeMillis() + 86400000 + ((long) new Random().nextInt(86400000)));
            }
        } catch (JSONException e2) {
            p.a(b, s.d(new byte[]{SignedBytes.MAX_POWER_OF_TWO, 7, 79, 84, 117, 9, 12, 9, 9, 12, 114, 9, 92, 19, 93, 117, 87, Ascii.DC2, 0, 94, 70}, "3f916f") + e2.toString());
        }
    }

    public static void b() {
        if (e()) {
            f();
        } else {
            p.a(b, s.d(new byte[]{38, 94, 92, 8, 88, 88, 34, 11, 8, 4, 88, 2, 48, 65, 85, 4, 67, 83, 19, 68, 34, 13, 84, Ascii.SYN, 69, 95, 94, 17, Ascii.ETB, 91, 4, 1, Ascii.DC2, 66, 65, Ascii.ETB, 0, 67, 84, Ascii.DC4, 66, 95, Ascii.DC2, 13, Ascii.DC2, 7, 66, 69, 3, 94, 67, 69, 69, 83, 16, 17, 3, 17, 69}, "e11e76"));
        }
    }

    public static Map<Integer, Integer> c() {
        try {
            if (!f.isEmpty()) {
                return f;
            }
            String strL = aa.l();
            if (!TextUtils.isEmpty(strL)) {
                JSONArray jSONArrayOptJSONArray = new JSONObject(strL).optJSONArray(d);
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    JSONObject jSONObject = jSONArrayOptJSONArray.getJSONObject(i);
                    int iOptInt = jSONObject.optInt(f9452a);
                    int iOptInt2 = jSONObject.optInt(c);
                    if (iOptInt > 0 && iOptInt2 > 0) {
                        f.put(Integer.valueOf(iOptInt), Integer.valueOf(iOptInt2));
                    }
                }
            }
            return f.isEmpty() ? g() : f;
        } catch (Exception e2) {
            p.a(b, s.d(new byte[]{80, 1, Ascii.SYN, 45, 84, Ascii.DC2, 4, 8, 47, 12, 69, 0, 69, Ascii.DC2, 3, 13, 114, 11, 15, 2, 15, 5, 11, 69}, "7dba1d") + e2.toString());
        }
    }

    private static boolean e() {
        if (!com.xiaomi.onetrack.g.c.a()) {
            p.b(b, s.d(new byte[]{92, 7, 17, Ascii.DC4, 94, 74, 65, 10, 9, Ascii.SYN, 17, 6, 93, 12, 11, 81, 84, 77, 4, 0, 71}, "2be479"));
            return false;
        }
        if (TextUtils.isEmpty(aa.l())) {
            return true;
        }
        long j = aa.j();
        return j < System.currentTimeMillis() || j - System.currentTimeMillis() > 172800000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void f() {
        String str = b;
        if (q.a(str)) {
            return;
        }
        HashMap map = new HashMap();
        try {
            String strA = com.xiaomi.onetrack.util.oaid.a.a().a(com.xiaomi.onetrack.f.a.b());
            if (z.b(strA)) {
                strA = com.xiaomi.onetrack.d.d.c(strA);
            }
            map.put(s.d(new byte[]{14, 85}, "a4e4ab"), strA);
            map.put(s.d(new byte[]{92, 66}, "346cea"), q.d());
            map.put(s.d(new byte[]{14, 3}, "aa8374"), q.c());
            map.put(s.d(new byte[]{10, 8}, "ca1315"), q.h() ? s.d(new byte[]{82}, "cf7f43") : s.d(new byte[]{1}, "14c365"));
            map.put(s.d(new byte[]{17, 19}, "bec988"), s.d(new byte[]{7, Ascii.FS, 1, Ascii.ESC, 3}, "52051d"));
            map.put(s.d(new byte[]{5, SignedBytes.MAX_POWER_OF_TWO, Ascii.DC4, 96, 1, 67}, "d0d6d1"), com.xiaomi.onetrack.f.a.c());
            map.put(s.d(new byte[]{84, SignedBytes.MAX_POWER_OF_TWO}, "565e76"), q.e());
            map.put(s.d(new byte[]{8, 95}, "e3cc2c"), DeviceUtil.b());
            map.put(s.d(new byte[]{SignedBytes.MAX_POWER_OF_TWO, 93}, "28abaf"), q.i());
            map.put(s.d(new byte[]{67, 93, 84, 69, 85, 93, 19, 9}, "315132"), e);
            String strD = x.a().d();
            String strB = com.xiaomi.onetrack.g.b.b(strD, map, true);
            p.a(str, s.d(new byte[]{77, 65, 14, 88}, "83bb70") + strD + s.d(new byte[]{Ascii.CAN, 68, 84, 68, Ascii.DC2, 90, 15, Ascii.ETB, 3, 88}, "8617b5") + strB);
            a(strB);
        } catch (IOException e2) {
            p.a(b, s.d(new byte[]{75, 4, Ascii.DC4, 70, 82, Ascii.SYN, Ascii.NAK, 39, 10, 13, 68, 1, 125, 0, 17, 82, 13, 69}, "9ae37e") + e2.toString());
        }
    }

    private static HashMap<Integer, Integer> g() {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1, 1000);
        map.put(2, 15000);
        map.put(3, 900000);
        return map;
    }
}
