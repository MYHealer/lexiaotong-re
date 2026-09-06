package com.gnete.upbc.cashier.g;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: JSONUtil.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f3301a = "a";

    public static C0391a b() {
        return new C0391a();
    }

    /* JADX INFO: renamed from: com.gnete.upbc.cashier.g.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: JSONUtil.java */
    public static class C0391a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        JSONObject f3302a;

        C0391a() {
            this.f3302a = new JSONObject();
        }

        public C0391a a(String str, Object obj) {
            try {
                this.f3302a.put(str, obj);
            } catch (JSONException e) {
                String unused = a.f3301a;
                e.getMessage();
            }
            return this;
        }

        public JSONObject a() {
            return this.f3302a;
        }

        public C0391a b(String str, String str2) {
            try {
                this.f3302a.put(str, str2);
            } catch (JSONException e) {
                String unused = a.f3301a;
                e.getMessage();
            }
            return this;
        }

        C0391a(String str) {
            try {
                this.f3302a = new JSONObject(str);
            } catch (JSONException e) {
                this.f3302a = new JSONObject();
                String unused = a.f3301a;
                e.getMessage();
            }
        }

        public String a(String str, String str2) {
            try {
                return this.f3302a.getString(str);
            } catch (JSONException e) {
                String unused = a.f3301a;
                e.getMessage();
                return str2;
            }
        }

        public C0391a b(String str) {
            return new C0391a(a(str, ""));
        }

        public int a(String str, int i) {
            try {
                return this.f3302a.getInt(str);
            } catch (JSONException e) {
                String unused = a.f3301a;
                e.getMessage();
                return i;
            }
        }

        public JSONArray a(String str) {
            try {
                return this.f3302a.getJSONArray(str);
            } catch (JSONException e) {
                String unused = a.f3301a;
                e.getMessage();
                return new JSONArray();
            }
        }
    }

    public static C0391a a(String str) {
        return new C0391a(str);
    }

    public static C0391a a(JSONArray jSONArray, int i) {
        C0391a c0391aB = b();
        if (jSONArray.isNull(i)) {
            return c0391aB;
        }
        try {
            return a(jSONArray.getString(i));
        } catch (JSONException e) {
            e.getMessage();
            return c0391aB;
        }
    }
}
