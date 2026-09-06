package com.adprof.sdk;

import java.io.Serializable;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public final class ul implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f1463a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;
    public String o;
    public String p;
    public String q;
    public String r;
    public String s;
    public String t;
    public static final String u = i5.a("YnJvd2VyX21vZGU=");
    public static final String v = i5.a("ZHBfZmFpbA==");
    public static final String w = i5.a("bGFuZF9wYWdlX2Rw");
    public static final String x = i5.a("bmF0aXZlX2ltcF9wZXJjZW50");
    public static final String y = i5.a("cmV3YXJkX3Nob3dfc2tpcA==");
    public static final String z = i5.a("aW50ZXJfc2tpcF9zZWNvbmQ=");
    public static final String A = i5.a("Y2xvc2Vfc2l6ZQ==");
    public static final String B = i5.a("c2hha2VfY29vbF9pbnRlcnZhbA==");
    public static final String C = i5.a("c2hha2VfZGVzdHJveV9jb3VudA==");
    public static final String D = i5.a("bWM=");
    public static final String E = i5.a("YmFubmVyX3JlZnJlc2hfc2Vjb25kcw==");
    public static final String F = i5.a("ZmVlZGJhY2s=");
    public static final String G = i5.a("Y2xpY2tfcmV3YXJk");
    public static final String H = i5.a("ZG93bmxvYWRfY29uZmlybQ==");
    public static final String I = i5.a("ZHBfc3VjY19vcGVuX2xhbmQ=");
    public static final String J = i5.a("Y2FuX3Nob3dfY2hhbm5lbA==");
    public static final String K = i5.a("ZG93bmxvYWRfZmFpbF9kcA==");
    public static final String L = i5.a("ZnM=");
    public static final String M = i5.a("YXV0b19vcGVuX2FkX3NlY29uZHM=");
    public static final String N = i5.a("bmF0aXZlX2NoZWNrX2V4cG9zZQ==");
    public static final String O = i5.a("bGFuZF9wYWdlX2RkcA==");

    public ul(JSONObject jSONObject) {
        this.f1463a = "";
        this.b = "open";
        this.c = "";
        this.d = "50";
        this.e = "";
        this.f = "";
        this.g = "1";
        this.h = "10";
        this.i = "0";
        this.j = "0";
        this.k = "0";
        this.l = "0";
        this.m = "1";
        this.n = "0";
        this.o = "0";
        this.p = "0";
        this.q = "1";
        this.r = "0";
        this.s = "0";
        this.t = "1";
        this.f1463a = jSONObject.optString(u, "");
        this.b = jSONObject.optString(v, "open");
        this.c = jSONObject.optString(w);
        this.d = jSONObject.optString(x, "50");
        this.e = jSONObject.optString(y);
        this.f = jSONObject.optString(z);
        this.g = jSONObject.optString(A);
        this.h = jSONObject.optString(B, "10");
        this.i = jSONObject.optString(C, "0");
        this.j = jSONObject.optString(L, "0");
        this.k = jSONObject.optString(D, "0");
        this.l = jSONObject.optString(E, "0");
        this.m = jSONObject.optString(F, "1");
        this.n = jSONObject.optString(M, "0");
        this.o = jSONObject.optString(G, "0");
        this.p = jSONObject.optString(H, "0");
        this.q = jSONObject.optString(I, "1");
        this.r = jSONObject.optString(O, "0");
        this.s = jSONObject.optString(J, "0");
        this.t = jSONObject.optString(K, "1");
        jSONObject.optString(N, "1");
    }

    public final String a() {
        return this.d;
    }
}
