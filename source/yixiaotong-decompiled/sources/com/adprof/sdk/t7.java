package com.adprof.sdk;

import android.os.Parcelable;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public final class t7 extends k3 {
    public static final di<t7> ADAPTER;
    public static final Parcelable.Creator<t7> CREATOR;
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x7 f1435a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Integer f730a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f731a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final List f732a;
    public final Integer b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final String f733b;
    public final Integer c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final String f734c;
    public final Integer d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public final String f735d;
    public final Integer e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public final String f736e;
    public final Integer f;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public final String f737f;
    public final Integer g;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public final String f738g;
    public final Integer h;

    /* JADX INFO: renamed from: h, reason: collision with other field name */
    public final String f739h;
    public final String i;
    public final String j;
    public final String k;
    public final String l;
    public final String m;
    public final String n;
    public final String o;
    public final String p;
    public final String q;
    public final String r;
    public final String s;
    public final String t;
    public final String u;
    public final String v;

    static {
        s7 s7Var = new s7();
        ADAPTER = s7Var;
        CREATOR = new j3(s7Var);
    }

    public t7(String str, String str2, Integer num, String str3, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, Integer num8, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, x7 x7Var, List list, String str20, String str21, String str22, q6 q6Var) {
        super(ADAPTER, q6Var);
        this.f731a = str;
        this.f733b = str2;
        this.f730a = num;
        this.f734c = str3;
        this.b = num2;
        this.c = num3;
        this.d = num4;
        this.e = num5;
        this.f = num6;
        this.g = num7;
        this.h = num8;
        this.f735d = str4;
        this.f736e = str5;
        this.f737f = str6;
        this.f738g = str7;
        this.f739h = str8;
        this.i = str9;
        this.j = str10;
        this.k = str11;
        this.l = str12;
        this.m = str13;
        this.n = str14;
        this.o = str15;
        this.p = str16;
        this.q = str17;
        this.r = str18;
        this.s = str19;
        this.f1435a = x7Var;
        this.f732a = kc.a("m5rs", list);
        this.t = str20;
        this.u = str21;
        this.v = str22;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof t7)) {
            return false;
        }
        t7 t7Var = (t7) obj;
        return a().equals(t7Var.a()) && kc.a(this.f731a, t7Var.f731a) && kc.a(this.f733b, t7Var.f733b) && kc.a(this.f730a, t7Var.f730a) && kc.a(this.f734c, t7Var.f734c) && kc.a(this.b, t7Var.b) && kc.a(this.c, t7Var.c) && kc.a(this.d, t7Var.d) && kc.a(this.e, t7Var.e) && kc.a(this.f, t7Var.f) && kc.a(this.g, t7Var.g) && kc.a(this.h, t7Var.h) && kc.a(this.f735d, t7Var.f735d) && kc.a(this.f736e, t7Var.f736e) && kc.a(this.f737f, t7Var.f737f) && kc.a(this.f738g, t7Var.f738g) && kc.a(this.f739h, t7Var.f739h) && kc.a(this.i, t7Var.i) && kc.a(this.j, t7Var.j) && kc.a(this.k, t7Var.k) && kc.a(this.l, t7Var.l) && kc.a(this.m, t7Var.m) && kc.a(this.n, t7Var.n) && kc.a(this.o, t7Var.o) && kc.a(this.p, t7Var.p) && kc.a(this.q, t7Var.q) && kc.a(this.r, t7Var.r) && kc.a(this.s, t7Var.s) && kc.a(this.f1435a, t7Var.f1435a) && this.f732a.equals(t7Var.f732a) && kc.a(this.t, t7Var.t) && kc.a(this.u, t7Var.u) && kc.a(this.v, t7Var.v);
    }

    public int hashCode() {
        int i = ((de) this).f1127a;
        if (i != 0) {
            return i;
        }
        int iHashCode = a().hashCode() * 37;
        String str = this.f731a;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.f733b;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num = this.f730a;
        int iHashCode4 = (iHashCode3 + (num != null ? num.hashCode() : 0)) * 37;
        String str3 = this.f734c;
        int iHashCode5 = (iHashCode4 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Integer num2 = this.b;
        int iHashCode6 = (iHashCode5 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.c;
        int iHashCode7 = (iHashCode6 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.d;
        int iHashCode8 = (iHashCode7 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.e;
        int iHashCode9 = (iHashCode8 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.f;
        int iHashCode10 = (iHashCode9 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Integer num7 = this.g;
        int iHashCode11 = (iHashCode10 + (num7 != null ? num7.hashCode() : 0)) * 37;
        Integer num8 = this.h;
        int iHashCode12 = (iHashCode11 + (num8 != null ? num8.hashCode() : 0)) * 37;
        String str4 = this.f735d;
        int iHashCode13 = (iHashCode12 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.f736e;
        int iHashCode14 = (iHashCode13 + (str5 != null ? str5.hashCode() : 0)) * 37;
        String str6 = this.f737f;
        int iHashCode15 = (iHashCode14 + (str6 != null ? str6.hashCode() : 0)) * 37;
        String str7 = this.f738g;
        int iHashCode16 = (iHashCode15 + (str7 != null ? str7.hashCode() : 0)) * 37;
        String str8 = this.f739h;
        int iHashCode17 = (iHashCode16 + (str8 != null ? str8.hashCode() : 0)) * 37;
        String str9 = this.i;
        int iHashCode18 = (iHashCode17 + (str9 != null ? str9.hashCode() : 0)) * 37;
        String str10 = this.j;
        int iHashCode19 = (iHashCode18 + (str10 != null ? str10.hashCode() : 0)) * 37;
        String str11 = this.k;
        int iHashCode20 = (iHashCode19 + (str11 != null ? str11.hashCode() : 0)) * 37;
        String str12 = this.l;
        int iHashCode21 = (iHashCode20 + (str12 != null ? str12.hashCode() : 0)) * 37;
        String str13 = this.m;
        int iHashCode22 = (iHashCode21 + (str13 != null ? str13.hashCode() : 0)) * 37;
        String str14 = this.n;
        int iHashCode23 = (iHashCode22 + (str14 != null ? str14.hashCode() : 0)) * 37;
        String str15 = this.o;
        int iHashCode24 = (iHashCode23 + (str15 != null ? str15.hashCode() : 0)) * 37;
        String str16 = this.p;
        int iHashCode25 = (iHashCode24 + (str16 != null ? str16.hashCode() : 0)) * 37;
        String str17 = this.q;
        int iHashCode26 = (iHashCode25 + (str17 != null ? str17.hashCode() : 0)) * 37;
        String str18 = this.r;
        int iHashCode27 = (iHashCode26 + (str18 != null ? str18.hashCode() : 0)) * 37;
        String str19 = this.s;
        int iHashCode28 = (iHashCode27 + (str19 != null ? str19.hashCode() : 0)) * 37;
        x7 x7Var = this.f1435a;
        int iHashCode29 = (((iHashCode28 + (x7Var != null ? x7Var.hashCode() : 0)) * 37) + this.f732a.hashCode()) * 37;
        String str20 = this.t;
        int iHashCode30 = (iHashCode29 + (str20 != null ? str20.hashCode() : 0)) * 37;
        String str21 = this.u;
        int iHashCode31 = (iHashCode30 + (str21 != null ? str21.hashCode() : 0)) * 37;
        String str22 = this.v;
        int iHashCode32 = iHashCode31 + (str22 != null ? str22.hashCode() : 0);
        ((de) this).f1127a = iHashCode32;
        return iHashCode32;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.f731a != null) {
            sb.append(", ip=").append(this.f731a);
        }
        if (this.f733b != null) {
            sb.append(", ua=").append(this.f733b);
        }
        if (this.f730a != null) {
            sb.append(", os=").append(this.f730a);
        }
        if (this.f734c != null) {
            sb.append(", osv=").append(this.f734c);
        }
        if (this.b != null) {
            sb.append(", device_type=").append(this.b);
        }
        if (this.c != null) {
            sb.append(", sw=").append(this.c);
        }
        if (this.d != null) {
            sb.append(", sh=").append(this.d);
        }
        if (this.e != null) {
            sb.append(", dpi=").append(this.e);
        }
        if (this.f != null) {
            sb.append(", ppi=").append(this.f);
        }
        if (this.g != null) {
            sb.append(", conn_type=").append(this.g);
        }
        if (this.h != null) {
            sb.append(", carrier=").append(this.h);
        }
        if (this.f735d != null) {
            sb.append(", brand=").append(this.f735d);
        }
        if (this.f736e != null) {
            sb.append(", model=").append(this.f736e);
        }
        if (this.f737f != null) {
            sb.append(", m0r=").append(this.f737f);
        }
        if (this.f738g != null) {
            sb.append(", m0e=").append(this.f738g);
        }
        if (this.f739h != null) {
            sb.append(", m1r=").append(this.f739h);
        }
        if (this.i != null) {
            sb.append(", m1e=").append(this.i);
        }
        if (this.j != null) {
            sb.append(", m2r=").append(this.j);
        }
        if (this.k != null) {
            sb.append(", m2e=").append(this.k);
        }
        if (this.l != null) {
            sb.append(", m3r=").append(this.l);
        }
        if (this.m != null) {
            sb.append(", m3e=").append(this.m);
        }
        if (this.n != null) {
            sb.append(", m4r=").append(this.n);
        }
        if (this.o != null) {
            sb.append(", m4e=").append(this.o);
        }
        if (this.p != null) {
            sb.append(", m5r=").append(this.p);
        }
        if (this.q != null) {
            sb.append(", m6r=").append(this.q);
        }
        if (this.r != null) {
            sb.append(", boot_mark=").append(this.r);
        }
        if (this.s != null) {
            sb.append(", update_mark=").append(this.s);
        }
        if (this.f1435a != null) {
            sb.append(", detail=").append(this.f1435a);
        }
        if (!this.f732a.isEmpty()) {
            sb.append(", m5rs=").append(this.f732a);
        }
        if (this.t != null) {
            sb.append(", fmark2me=").append(this.t);
        }
        if (this.u != null) {
            sb.append(", fmark4me=").append(this.u);
        }
        if (this.v != null) {
            sb.append(", ipv6=").append(this.v);
        }
        return sb.replace(0, 2, "Device{").append('}').toString();
    }
}
