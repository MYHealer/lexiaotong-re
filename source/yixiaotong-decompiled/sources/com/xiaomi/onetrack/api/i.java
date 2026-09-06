package com.xiaomi.onetrack.api;

import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f9429a = ijiami_1011.s.s.s.d(new byte[]{113, 84, 116, 86, 66, 83, 44, 11, 2, 7, 93}, "9a0762");
    private String b;
    private long c;
    private String d;
    private String e;
    private String f;
    private String g;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static String f9430a = ijiami_1011.s.s.s.d(new byte[]{86, 79, 86, 88, 76}, "39368f");
        public static String b = ijiami_1011.s.s.s.d(new byte[]{68, 0, Ascii.DC2, 69, 15, 86, 15, 59, 15, 6}, "7ea6f9");
        public static String c = ijiami_1011.s.s.s.d(new byte[]{92, 86, Ascii.DC2, 67, 0, 92, 2, 1, 57, 11, 85}, "58a7a2");
        public static String d = ijiami_1011.s.s.s.d(new byte[]{19, 92, 4, 71, 83, 12, 19, 9}, "c0e35c");
        public static String e = ijiami_1011.s.s.s.d(new byte[]{86, 110, 71, SignedBytes.MAX_POWER_OF_TWO}, "3133bc");
        public static String f = ijiami_1011.s.s.s.d(new byte[]{77, 73}, "937227");
        public static String g = ijiami_1011.s.s.s.d(new byte[]{67, 0, 10, 57, Ascii.NAK, 81, 19}, "0dafc4");
        public static String h = ijiami_1011.s.s.s.d(new byte[]{89, Ascii.SYN, Ascii.NAK, 103, 95, 85}, "8fe861");
        public static String i = ijiami_1011.s.s.s.d(new byte[]{6, 93, 87, 11, 15, 1, 13}, "e56ead");
        public static String j = ijiami_1011.s.s.s.d(new byte[]{17, 15, 2}, "dff409");
        public static String k = ijiami_1011.s.s.s.d(new byte[]{71, 89, 80, 105, Ascii.DC2, 78, 17, 1}, "2046f7");
    }

    public i(JSONObject jSONObject) {
        this.b = a(jSONObject, a.f9430a);
        try {
            this.c = Long.parseLong(a(jSONObject, a.e));
        } catch (Exception e) {
            com.xiaomi.onetrack.util.p.b(ijiami_1011.s.s.s.d(new byte[]{124, 3, 124, 4, 76, 84, 44, 11, 2, 7, 93}, "468e85"), ijiami_1011.s.s.s.d(new byte[]{4, 107, 76, Ascii.SYN, 16, 70, 0, Ascii.SYN, Ascii.NAK, 7, 17, 0, 19, 70, 87, Ascii.ETB, 10, Ascii.SYN}, "a48e06") + e.getMessage());
        }
        this.d = a(jSONObject, a.h);
        this.e = a(jSONObject, a.i);
        this.f = a(jSONObject, a.j);
        this.g = a(jSONObject, a.k);
    }

    private String a(JSONObject jSONObject, String str) {
        Object objOpt = jSONObject.opt(str);
        return objOpt == null ? "" : String.valueOf(objOpt);
    }

    public String a() {
        return this.b;
    }

    public long b() {
        return this.c;
    }

    public String c() {
        return this.d;
    }

    public String d() {
        return this.e;
    }

    public String e() {
        return this.f;
    }

    public String f() {
        return this.g;
    }

    public String toString() {
        return ijiami_1011.s.s.s.d(new byte[]{46, 13, 32, 7, Ascii.NAK, 84, 44, 11, 2, 7, 93, Ascii.RS, 3, 78, 1, 8, Ascii.NAK, 123, 0, 9, 3, 95, Ascii.SYN}, "f8dfa5") + this.b + '\'' + ijiami_1011.s.s.s.d(new byte[]{Ascii.EM, Ascii.ETB, 93, 102, 70, 71, 92}, "578924") + this.c + ijiami_1011.s.s.s.d(new byte[]{79, Ascii.DC2, 87, 70, Ascii.SYN, 47, 5, 89, 65}, "c266ff") + this.d + '\'' + ijiami_1011.s.s.s.d(new byte[]{Ascii.US, 67, 80, 88, 84, 90, 15, 1, 10, 95, Ascii.SYN}, "3c3054") + this.e + '\'' + ijiami_1011.s.s.s.d(new byte[]{Ascii.RS, Ascii.EM, 66, 12, 81, 95, 70}, "297e5b") + this.f + '\'' + ijiami_1011.s.s.s.d(new byte[]{79, Ascii.EM, 66, 88, 92, 48, Ascii.CAN, Ascii.DC4, 3, 95, Ascii.SYN}, "c9718d") + this.g + "'}";
    }
}
