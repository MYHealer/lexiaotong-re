package com.xiaomi.onetrack.d;

import android.content.Context;
import android.text.TextUtils;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.xiaomi.onetrack.util.aa;
import com.xiaomi.onetrack.util.p;
import com.xiaomi.onetrack.util.q;
import com.xiaomi.onetrack.util.x;
import ijiami_1011.s.s.s;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class f {
    private Context f;
    private JSONObject g;
    private String[] h;
    private static final String b = s.d(new byte[]{106, 83, 1, 75, 92, 17, 42, 1, Ascii.US, 47, 80, 11, 88, 81, 7, 75}, "96b99e");
    private static final String c = s.d(new byte[]{Ascii.SYN, 81, 81, SignedBytes.MAX_POWER_OF_TWO, 3, 67, 42, 1, Ascii.US}, "e422f7");
    private static final String d = s.d(new byte[]{75, 13, 2}, "8dfbf7");
    private static final String e = s.d(new byte[]{8, 92, 79}, "c963d6");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final JSONObject f9487a = new JSONObject();

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final f f9488a = new f(null);

        private a() {
        }
    }

    private f() {
        this.g = null;
        this.h = new String[2];
        this.f = com.xiaomi.onetrack.f.a.a();
    }

    public /* synthetic */ f(g gVar) {
        this();
    }

    public static f a() {
        return a.f9488a;
    }

    private void d() {
        String str;
        String strD;
        if (p.f9551a) {
            if (TextUtils.isEmpty(this.h[0]) || TextUtils.isEmpty(this.h[1])) {
                str = b;
                strD = s.d(new byte[]{13, 81, Ascii.GS, 67, 12, 68, 65, Ascii.ETB, 15, 6, 17, 12, Ascii.NAK, Ascii.DC4, 13, 13, Ascii.NAK, 87, 13, 13, 2, 67}, "f4dcc6");
            } else {
                str = b;
                strD = s.d(new byte[]{15, 3, Ascii.GS, Ascii.DC2, 67, 7, 15, 0, 70, 17, 88, 1, 68, 15, Ascii.ETB, Ascii.DC2, Ascii.NAK, 7, 13, 13, 2, 67, 17}, "dfd2cf");
            }
            p.a(str, strD);
        }
    }

    private JSONObject e() {
        JSONObject jSONObjectF = this.g;
        if (jSONObjectF == null && (jSONObjectF = f()) != null) {
            this.g = jSONObjectF;
        }
        return jSONObjectF == null ? c() : jSONObjectF;
    }

    private JSONObject f() {
        try {
            String strG = aa.g();
            if (TextUtils.isEmpty(strG)) {
                return null;
            }
            return new JSONObject(b.b(this.f, strG));
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public synchronized String[] b() {
        JSONObject jSONObjectE = e();
        this.h[0] = jSONObjectE != null ? jSONObjectE.optString(e) : "";
        this.h[1] = jSONObjectE != null ? jSONObjectE.optString(d) : "";
        d();
        return this.h;
    }

    public JSONObject c() {
        try {
            if (q.a(b)) {
                return f9487a;
            }
            byte[] bArrA = com.xiaomi.onetrack.d.a.a();
            String strA = c.a(e.a(bArrA));
            HashMap map = new HashMap();
            map.put(c, strA);
            String strB = com.xiaomi.onetrack.g.b.b(x.a().e(), map, true);
            if (!TextUtils.isEmpty(strB)) {
                JSONObject jSONObject = new JSONObject(strB);
                int iOptInt = jSONObject.optInt(s.d(new byte[]{83, 89, 84, 0}, "060e60"));
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(s.d(new byte[]{85, 88, 69, 81}, "191011"));
                if (iOptInt == 0 && jSONObjectOptJSONObject != null) {
                    String str = e;
                    String strOptString = jSONObjectOptJSONObject.optString(str);
                    String str2 = d;
                    String strOptString2 = jSONObjectOptJSONObject.optString(str2);
                    if (!TextUtils.isEmpty(strOptString) && !TextUtils.isEmpty(strOptString2)) {
                        String strA2 = c.a(com.xiaomi.onetrack.d.a.b(c.a(strOptString), bArrA));
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put(str, strA2);
                        jSONObject2.put(str2, strOptString2);
                        this.g = jSONObject2;
                        aa.a(b.a(this.f, jSONObject2.toString()));
                        aa.i(System.currentTimeMillis());
                    }
                }
            }
            return this.g;
        } catch (Exception e2) {
            p.b(b, s.d(new byte[]{Ascii.DC4, 6, 69, 16, 80, 66, Ascii.NAK, 55, 3, 1, 67, 0, Ascii.DC2, 39, 85, 17, 84, 11, 65}, "fc4e51") + e2.toString());
        }
    }
}
