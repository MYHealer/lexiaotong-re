package com.xiaomi.onetrack.util;

import android.content.Context;
import android.text.TextUtils;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.io.encoding.Base64;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class x {
    private Context B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f9558a = ijiami_1011.s.s.s.d(new byte[]{98, 3, 85, 90, 9, 91, 37, 11, 11, 3, 88, 11, 125, 7, 92, 82, 1, 80, 19}, "0f23f5");
    private static final String b = ijiami_1011.s.s.s.d(new byte[]{33, 122}, "b44ef4");
    private static final String c = ijiami_1011.s.s.s.d(new byte[]{45, 123, 102, 121}, "d5254e");
    private static final String d = ijiami_1011.s.s.s.d(new byte[]{122, 118}, "38369e");
    private static final String e = ijiami_1011.s.s.s.d(new byte[]{96, 108}, "298714");
    private static final String f = ijiami_1011.s.s.s.d(new byte[]{13, 71, Ascii.DC2, 19, 15, 76, 78}, "e3fc5c");
    private static final String g = ijiami_1011.s.s.s.d(new byte[]{81, 69, 71, 66, SignedBytes.MAX_POWER_OF_TWO, 88, 78, 75}, "91323b");
    private static String h = ijiami_1011.s.s.s.d(new byte[0], "2e8f00");
    private static String i = ijiami_1011.s.s.s.d(new byte[0], "a43851");
    private static String j = ijiami_1011.s.s.s.d(new byte[0], "d07127");
    private static String k = ijiami_1011.s.s.s.d(new byte[0], "9a58eb");
    private static String l = ijiami_1011.s.s.s.d(new byte[0], "f7cc85");
    private static String m = ijiami_1011.s.s.s.d(new byte[0], "fa6f14");
    private static String n = ijiami_1011.s.s.s.d(new byte[0], "dd82f5");
    private static String o = ijiami_1011.s.s.s.d(new byte[0], "78763a");
    private static final String x = ijiami_1011.s.s.s.d(new byte[]{Ascii.RS, 69, SignedBytes.MAX_POWER_OF_TWO, 84, 82, 15, 78, Ascii.DC2, 82}, "11251d");
    private static final String y = ijiami_1011.s.s.s.d(new byte[]{Ascii.SYN, 71, 71, 81, 80, 93, 78, 15, 3, Ascii.ESC, 110, 2, 92, 71}, "935036");
    private static final String z = ijiami_1011.s.s.s.d(new byte[]{76, 3, 17, 93, 78, 67, 85, 75, 2, 7, 69, 4, 10, 14, 78, 87, 14, 91, 7, 13, 1}, "cba4a5");
    private static final String A = ijiami_1011.s.s.s.d(new byte[]{77, 2, 70, 93, Ascii.SYN, 68, 85, 75, 2, 7, 69, 4, 11, 15, Ascii.EM, 87, 86, 92, 7, 13, 1, Base64.padSymbol, 82, 10, 15, 14, 89, 90}, "bc6492");
    private static final byte[] p = {116, 114, 97, 99, 107, 105, 110, 103, 46, 109, 105, 117, 105, 46, 99, 111, 109};
    private static final byte[] q = {116, 114, 97, 99, 107, 105, 110, 103, 46, 105, 110, 116, 108, 46, 109, 105, 117, 105, 46, 99, 111, 109};
    private static final byte[] r = {116, 114, 97, 99, 107, 105, 110, 103, 46, 114, 117, 115, 46, 109, 105, 117, 105, 46, 99, 111, 109};
    private static final byte[] s = {116, 114, 97, 99, 107, 105, 110, 103, 46, 105, 110, 100, 105, 97, 46, 109, 105, 117, 105, 46, 99, 111, 109};
    private static final byte[] t = {115, 100, 107, 99, 111, 110, 102, 105, 103, 46, 97, 100, 46, 120, 105, 97, 111, 109, 105, 46, 99, 111, 109};
    private static final byte[] u = {115, 100, 107, 99, 111, 110, 102, 105, 103, 46, 97, 100, 46, 105, 110, 116, 108, 46, 120, 105, 97, 111, 109, 105, 46, 99, 111, 109};
    private static final byte[] v = {115, 100, 107, 99, 111, 110, 102, 105, 103, 46, 97, 100, 46, 105, 110, 100, 105, 97, 46, 120, 105, 97, 111, 109, 105, 46, 99, 111, 109};
    private static final byte[] w = {115, 100, 107, 99, 111, 110, 102, 105, 103, 46, 97, 100, 46, 114, 117, 115, 46, 120, 105, 97, 111, 109, 105, 46, 99, 111, 109};
    private static ConcurrentHashMap<String, String> C = new ConcurrentHashMap<>();

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final x f9559a = new x(null);

        private a() {
        }
    }

    private x() {
        f();
        C.put(ijiami_1011.s.s.s.d(new byte[]{40, 47}, "aaa959"), k);
        C.put(ijiami_1011.s.s.s.d(new byte[]{98, 101}, "008117"), j);
        g();
    }

    public /* synthetic */ x(y yVar) {
        this();
    }

    public static x a() {
        return a.f9559a;
    }

    private String a(boolean z2, String str) {
        if (!z2) {
            return h;
        }
        String str2 = C.get(str);
        return TextUtils.isEmpty(str2) ? i : str2;
    }

    private String a(byte[] bArr) {
        String str;
        try {
            str = new String(bArr, ijiami_1011.s.s.s.d(new byte[]{102, 96, 35, Ascii.DC4, 89}, "34e9aa"));
            try {
                p.a(f9558a, ijiami_1011.s.s.s.d(new byte[]{66, 17, 2, 89, 70, 88, 8, 16, 50, 13, 98, 17, 68, 10, 13, 80, Ascii.NAK, 93, 14, Ascii.ETB, Ascii.DC2, 88}, "6cc755") + str);
            } catch (Exception e2) {
                e = e2;
                p.b(f9558a, e.getMessage());
            }
        } catch (Exception e3) {
            e = e3;
            str = "";
        }
        return str;
    }

    private void f() {
        h = a(p);
        i = a(q);
        j = a(r);
        k = a(s);
        l = a(t);
        m = a(u);
        n = a(v);
        o = a(w);
    }

    private void g() {
        try {
            String strH = aa.h();
            if (TextUtils.isEmpty(strH)) {
                return;
            }
            a(new JSONObject(strH));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    private String h() {
        return g;
    }

    private String i() {
        return a(q.h(), q.i());
    }

    private String j() {
        boolean zH = q.h();
        String strI = q.i();
        if (!zH) {
            return l;
        }
        if (TextUtils.equals(strI, d)) {
            return n;
        }
        return TextUtils.equals(strI, e) ? o : m;
    }

    public String a(String str, String str2, String str3) {
        return str + str2 + str3;
    }

    public synchronized void a(JSONObject jSONObject) {
        p.a(f9558a, ijiami_1011.s.s.s.d(new byte[]{65, Ascii.DC2, 7, 80, 65, 82, 41, 11, Ascii.NAK, Ascii.SYN, 124, 4, 68, 88}, "4bc157") + jSONObject.toString());
        try {
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                String strOptString = jSONObject.optString(next);
                if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(strOptString)) {
                    C.put(next, strOptString);
                }
            }
            aa.b(new JSONObject(C).toString());
        } catch (Exception e2) {
            p.a(f9558a, ijiami_1011.s.s.s.d(new byte[]{69, SignedBytes.MAX_POWER_OF_TWO, 85, 4, 68, 92, 41, 11, Ascii.NAK, Ascii.SYN, 124, 4, SignedBytes.MAX_POWER_OF_TWO, 10, 17}, "001e09") + e2.toString());
        }
        p.a(f9558a, ijiami_1011.s.s.s.d(new byte[]{9, 86, Ascii.SYN, 83, 1, Ascii.NAK, 2, 11, 8, 4, 88, 2, 94}, "d3d4d5") + new JSONObject(C).toString());
    }

    public String b() {
        try {
            if (TextUtils.isEmpty(aa.l())) {
                com.xiaomi.onetrack.b.e.b();
            }
        } catch (Exception e2) {
            p.a(f9558a, ijiami_1011.s.s.s.d(new byte[]{2, 1, 17, 54, 70, 83, 2, 15, 15, 12, 86, 48, Ascii.ETB, 8, 95, 66}, "edeb42") + e2.toString());
        }
        return a(h(), i(), x);
    }

    public String c() {
        return a(h(), j(), z);
    }

    public String d() {
        return a(h(), j(), A);
    }

    public String e() {
        return a(h(), i(), y);
    }
}
