package com.adprof.sdk;

import android.os.Parcelable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public final class x7 extends k3 {
    public static final di<x7> ADAPTER;
    public static final Parcelable.Creator<x7> CREATOR;
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1517a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
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

    static {
        w7 w7Var = new w7();
        ADAPTER = w7Var;
        CREATOR = new j3(w7Var);
    }

    public x7(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, q6 q6Var) {
        super(ADAPTER, q6Var);
        this.f1517a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = str6;
        this.g = str7;
        this.h = str8;
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
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof x7)) {
            return false;
        }
        x7 x7Var = (x7) obj;
        return a().equals(x7Var.a()) && kc.a(this.f1517a, x7Var.f1517a) && kc.a(this.b, x7Var.b) && kc.a(this.c, x7Var.c) && kc.a(this.d, x7Var.d) && kc.a(this.e, x7Var.e) && kc.a(this.f, x7Var.f) && kc.a(this.g, x7Var.g) && kc.a(this.h, x7Var.h) && kc.a(this.i, x7Var.i) && kc.a(this.j, x7Var.j) && kc.a(this.k, x7Var.k) && kc.a(this.l, x7Var.l) && kc.a(this.m, x7Var.m) && kc.a(this.n, x7Var.n) && kc.a(this.o, x7Var.o) && kc.a(this.p, x7Var.p) && kc.a(this.q, x7Var.q) && kc.a(this.r, x7Var.r);
    }

    public int hashCode() {
        int i = ((de) this).f1127a;
        if (i != 0) {
            return i;
        }
        int iHashCode = a().hashCode() * 37;
        String str = this.f1517a;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.b;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.c;
        int iHashCode4 = (iHashCode3 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.d;
        int iHashCode5 = (iHashCode4 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.e;
        int iHashCode6 = (iHashCode5 + (str5 != null ? str5.hashCode() : 0)) * 37;
        String str6 = this.f;
        int iHashCode7 = (iHashCode6 + (str6 != null ? str6.hashCode() : 0)) * 37;
        String str7 = this.g;
        int iHashCode8 = (iHashCode7 + (str7 != null ? str7.hashCode() : 0)) * 37;
        String str8 = this.h;
        int iHashCode9 = (iHashCode8 + (str8 != null ? str8.hashCode() : 0)) * 37;
        String str9 = this.i;
        int iHashCode10 = (iHashCode9 + (str9 != null ? str9.hashCode() : 0)) * 37;
        String str10 = this.j;
        int iHashCode11 = (iHashCode10 + (str10 != null ? str10.hashCode() : 0)) * 37;
        String str11 = this.k;
        int iHashCode12 = (iHashCode11 + (str11 != null ? str11.hashCode() : 0)) * 37;
        String str12 = this.l;
        int iHashCode13 = (iHashCode12 + (str12 != null ? str12.hashCode() : 0)) * 37;
        String str13 = this.m;
        int iHashCode14 = (iHashCode13 + (str13 != null ? str13.hashCode() : 0)) * 37;
        String str14 = this.n;
        int iHashCode15 = (iHashCode14 + (str14 != null ? str14.hashCode() : 0)) * 37;
        String str15 = this.o;
        int iHashCode16 = (iHashCode15 + (str15 != null ? str15.hashCode() : 0)) * 37;
        String str16 = this.p;
        int iHashCode17 = (iHashCode16 + (str16 != null ? str16.hashCode() : 0)) * 37;
        String str17 = this.q;
        int iHashCode18 = (iHashCode17 + (str17 != null ? str17.hashCode() : 0)) * 37;
        String str18 = this.r;
        int iHashCode19 = iHashCode18 + (str18 != null ? str18.hashCode() : 0);
        ((de) this).f1127a = iHashCode19;
        return iHashCode19;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.f1517a != null) {
            sb.append(", paid=").append(this.f1517a);
        }
        if (this.b != null) {
            sb.append(", startup_time=").append(this.b);
        }
        if (this.c != null) {
            sb.append(", update_time=").append(this.c);
        }
        if (this.d != null) {
            sb.append(", init_time=").append(this.d);
        }
        if (this.e != null) {
            sb.append(", total_mem=").append(this.e);
        }
        if (this.f != null) {
            sb.append(", total_disk=").append(this.f);
        }
        if (this.g != null) {
            sb.append(", pname=").append(this.g);
        }
        if (this.h != null) {
            sb.append(", hw_machine=").append(this.h);
        }
        if (this.i != null) {
            sb.append(", language=").append(this.i);
        }
        if (this.j != null) {
            sb.append(", country=").append(this.j);
        }
        if (this.k != null) {
            sb.append(", carrier_name=").append(this.k);
        }
        if (this.l != null) {
            sb.append(", compile_time=").append(this.l);
        }
        if (this.m != null) {
            sb.append(", ag_ver=").append(this.m);
        }
        if (this.n != null) {
            sb.append(", hms_ver=").append(this.n);
        }
        if (this.o != null) {
            sb.append(", app_install_time=").append(this.o);
        }
        if (this.p != null) {
            sb.append(", fmark1me=").append(this.p);
        }
        if (this.q != null) {
            sb.append(", fmark2me=").append(this.q);
        }
        if (this.r != null) {
            sb.append(", fmark3me=").append(this.r);
        }
        return sb.replace(0, 2, "DeviceDetail{").append('}').toString();
    }
}
