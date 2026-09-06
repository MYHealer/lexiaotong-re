package com.xiaomi.onetrack.api;

import com.google.common.base.Ascii;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class as {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f9419a = ijiami_1011.s.s.s.d(new byte[]{11, 83, 93, 4}, "e20a28");
    public static final String b = ijiami_1011.s.s.s.d(new byte[]{2, 92, 95, 86, 93, 75}, "e91289");
    public static final String c = ijiami_1011.s.s.s.d(new byte[]{81, 80, 65, 17, 89, 81, 0, Ascii.GS}, "393e15");
    public static final String d = ijiami_1011.s.s.s.d(new byte[]{72, 93, 11, 93, 87}, "85d328");
    public static final String e = ijiami_1011.s.s.s.d(new byte[]{89, 12, 85}, "3c762e");
    public static final String f = ijiami_1011.s.s.s.d(new byte[]{95, 89, 85, 6, 72}, "767d12");
    public static final String g = ijiami_1011.s.s.s.d(new byte[]{Ascii.ETB, 93, 87, 90, 94, 12}, "e8031b");
    public static final String h = ijiami_1011.s.s.s.d(new byte[]{Ascii.NAK, 74, 89, 79, 89, 15, 2, 1}, "e8690a");
    public static final String i = ijiami_1011.s.s.s.d(new byte[]{91, 94, 70, Ascii.GS}, "872dc2");
    private String j;
    private String k;
    private String l;
    private String m;
    private String n;
    private String o;
    private String p;
    private String q;
    private String r;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f9420a;
        private String b;
        private String c;
        private String d;
        private String e;
        private String f;
        private String g;
        private String h;
        private String i;

        public a a(String str) {
            this.f9420a = str;
            return this;
        }

        public as a() {
            as asVar = new as(null);
            asVar.o = this.f;
            asVar.n = this.e;
            asVar.r = this.i;
            asVar.m = this.d;
            asVar.q = this.h;
            asVar.l = this.c;
            asVar.j = this.f9420a;
            asVar.p = this.g;
            asVar.k = this.b;
            return asVar;
        }

        public a b(String str) {
            this.b = str;
            return this;
        }

        public a c(String str) {
            this.c = str;
            return this;
        }

        public a d(String str) {
            this.d = str;
            return this;
        }

        public a e(String str) {
            this.e = str;
            return this;
        }

        public a f(String str) {
            this.f = str;
            return this;
        }

        public a g(String str) {
            this.g = str;
            return this;
        }

        public a h(String str) {
            this.h = str;
            return this;
        }

        public a i(String str) {
            this.i = str;
            return this;
        }
    }

    private as() {
    }

    public /* synthetic */ as(at atVar) {
        this();
    }

    public String a() {
        return this.j;
    }

    public String b() {
        return this.k;
    }

    public String c() {
        return this.l;
    }

    public String d() {
        return this.m;
    }

    public String e() {
        return this.n;
    }

    public String f() {
        return this.o;
    }

    public String g() {
        return this.p;
    }

    public String h() {
        return this.q;
    }

    public String i() {
        return this.r;
    }

    public JSONObject j() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(f9419a, this.j);
            jSONObject.put(b, this.k);
            jSONObject.put(c, this.l);
            jSONObject.put(d, this.m);
            jSONObject.put(e, this.n);
            jSONObject.put(f, this.o);
            jSONObject.put(g, this.p);
            jSONObject.put(h, this.q);
            jSONObject.put(i, this.r);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public String toString() {
        return j().toString();
    }
}
