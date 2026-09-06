package com.alipay.sdk.data;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.util.j;
import com.cdo.oaps.ad.OapsKey;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f1633a = 3500;
    public static final String b = "https://h5.m.taobao.com/mlapp/olist.html";
    public static final int c = 10;
    public static final boolean d = true;
    public static final boolean e = true;
    public static final int f = 1000;
    public static final int g = 20000;
    public static final String h = "alipay_cashier_dynamic_config";
    public static final String i = "timeout";
    public static final String j = "st_sdk_config";
    public static final String k = "tbreturl";
    public static final String l = "launchAppSwitch";
    public static final String m = "configQueryInterval";
    public static final String n = "scheme_pay";
    public static final String o = "scheme_pay_2";
    public static final String p = "intercept_batch";
    private static a x;
    private int r = f1633a;
    private String s = b;
    private int t = 10;
    private boolean u = true;
    private boolean v = true;
    public boolean q = false;
    private List<C0082a> w = null;

    public void a(boolean z) {
        this.q = z;
    }

    public boolean b() {
        return this.u;
    }

    public boolean c() {
        return this.v;
    }

    public String d() {
        return this.s;
    }

    public int e() {
        return this.t;
    }

    public List<C0082a> f() {
        return this.w;
    }

    public int a() {
        int i2 = this.r;
        if (i2 < 1000 || i2 > 20000) {
            com.alipay.sdk.util.c.b("", "DynamicConfig::getJumpTimeout(default) >3500");
            return f1633a;
        }
        com.alipay.sdk.util.c.b("", "DynamicConfig::getJumpTimeout >" + this.r);
        return this.r;
    }

    public static a g() {
        if (x == null) {
            a aVar = new a();
            x = aVar;
            aVar.h();
        }
        return x;
    }

    private void h() {
        a(j.b(com.alipay.sdk.sys.b.a().b(), h, null));
    }

    private void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.r = jSONObject.optInt("timeout", f1633a);
            this.s = jSONObject.optString(k, b).trim();
            this.t = jSONObject.optInt(m, 10);
            this.w = C0082a.a(jSONObject.optJSONArray(l));
            this.u = jSONObject.optBoolean(o, true);
            this.v = jSONObject.optBoolean(p, true);
        } catch (Throwable th) {
            com.alipay.sdk.util.c.a(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("timeout", a());
            jSONObject.put(k, d());
            jSONObject.put(m, e());
            jSONObject.put(l, C0082a.a(f()));
            jSONObject.put(o, b());
            jSONObject.put(p, c());
            j.a(com.alipay.sdk.sys.b.a().b(), h, jSONObject.toString());
        } catch (Exception e2) {
            com.alipay.sdk.util.c.a(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObjectOptJSONObject = new JSONObject(str).optJSONObject(j);
            if (jSONObjectOptJSONObject != null) {
                this.r = jSONObjectOptJSONObject.optInt("timeout", f1633a);
                this.s = jSONObjectOptJSONObject.optString(k, b).trim();
                this.t = jSONObjectOptJSONObject.optInt(m, 10);
                this.w = C0082a.a(jSONObjectOptJSONObject.optJSONArray(l));
                this.u = jSONObjectOptJSONObject.optBoolean(o, true);
                this.v = jSONObjectOptJSONObject.optBoolean(p, true);
            } else {
                com.alipay.sdk.util.c.d("msp", "config is null");
            }
        } catch (Throwable th) {
            com.alipay.sdk.util.c.a(th);
        }
    }

    public void a(Context context) {
        new Thread(new b(this, context)).start();
    }

    /* JADX INFO: renamed from: com.alipay.sdk.data.a$a, reason: collision with other inner class name */
    public static final class C0082a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f1634a;
        public final int b;
        public final String c;

        public C0082a(String str, int i, String str2) {
            this.f1634a = str;
            this.b = i;
            this.c = str2;
        }

        public static C0082a a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            return new C0082a(jSONObject.optString("pn"), jSONObject.optInt("v", 0), jSONObject.optString(OapsKey.KEY_PAGEKEY));
        }

        public static List<C0082a> a(JSONArray jSONArray) {
            if (jSONArray == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                C0082a c0082aA = a(jSONArray.optJSONObject(i));
                if (c0082aA != null) {
                    arrayList.add(c0082aA);
                }
            }
            return arrayList;
        }

        public static JSONObject a(C0082a c0082a) {
            if (c0082a == null) {
                return null;
            }
            try {
                return new JSONObject().put("pn", c0082a.f1634a).put("v", c0082a.b).put(OapsKey.KEY_PAGEKEY, c0082a.c);
            } catch (JSONException e) {
                com.alipay.sdk.util.c.a(e);
                return null;
            }
        }

        public static JSONArray a(List<C0082a> list) {
            if (list == null) {
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            Iterator<C0082a> it = list.iterator();
            while (it.hasNext()) {
                jSONArray.put(a(it.next()));
            }
            return jSONArray;
        }

        public String toString() {
            return String.valueOf(a(this));
        }
    }
}
