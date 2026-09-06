package com.adprof.sdk;

import android.os.Parcelable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public final class ui extends k3 {
    public static final di<ui> ADAPTER;
    public static final Parcelable.Creator<ui> CREATOR;
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Double f1461a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Integer f755a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f756a;
    public final Integer b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final String f757b;
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

    static {
        ti tiVar = new ti();
        ADAPTER = tiVar;
        CREATOR = new j3(tiVar);
    }

    public ui(String str, String str2, String str3, Integer num, Double d, Integer num2, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, q6 q6Var) {
        super(ADAPTER, q6Var);
        this.f756a = str;
        this.f757b = str2;
        this.c = str3;
        this.f755a = num;
        this.f1461a = d;
        this.b = num2;
        this.d = str4;
        this.e = str5;
        this.f = str6;
        this.g = str7;
        this.h = str8;
        this.i = str9;
        this.j = str10;
        this.k = str11;
        this.l = str12;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ui)) {
            return false;
        }
        ui uiVar = (ui) obj;
        return a().equals(uiVar.a()) && kc.a(this.f756a, uiVar.f756a) && kc.a(this.f757b, uiVar.f757b) && kc.a(this.c, uiVar.c) && kc.a(this.f755a, uiVar.f755a) && kc.a(this.f1461a, uiVar.f1461a) && kc.a(this.b, uiVar.b) && kc.a(this.d, uiVar.d) && kc.a(this.e, uiVar.e) && kc.a(this.f, uiVar.f) && kc.a(this.g, uiVar.g) && kc.a(this.h, uiVar.h) && kc.a(this.i, uiVar.i) && kc.a(this.j, uiVar.j) && kc.a(this.k, uiVar.k) && kc.a(this.l, uiVar.l);
    }

    public int hashCode() {
        int i = ((de) this).f1127a;
        if (i != 0) {
            return i;
        }
        int iHashCode = a().hashCode() * 37;
        String str = this.f756a;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.f757b;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.c;
        int iHashCode4 = (iHashCode3 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Integer num = this.f755a;
        int iHashCode5 = (iHashCode4 + (num != null ? num.hashCode() : 0)) * 37;
        Double d = this.f1461a;
        int iHashCode6 = (iHashCode5 + (d != null ? d.hashCode() : 0)) * 37;
        Integer num2 = this.b;
        int iHashCode7 = (iHashCode6 + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str4 = this.d;
        int iHashCode8 = (iHashCode7 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.e;
        int iHashCode9 = (iHashCode8 + (str5 != null ? str5.hashCode() : 0)) * 37;
        String str6 = this.f;
        int iHashCode10 = (iHashCode9 + (str6 != null ? str6.hashCode() : 0)) * 37;
        String str7 = this.g;
        int iHashCode11 = (iHashCode10 + (str7 != null ? str7.hashCode() : 0)) * 37;
        String str8 = this.h;
        int iHashCode12 = (iHashCode11 + (str8 != null ? str8.hashCode() : 0)) * 37;
        String str9 = this.i;
        int iHashCode13 = (iHashCode12 + (str9 != null ? str9.hashCode() : 0)) * 37;
        String str10 = this.j;
        int iHashCode14 = (iHashCode13 + (str10 != null ? str10.hashCode() : 0)) * 37;
        String str11 = this.k;
        int iHashCode15 = (iHashCode14 + (str11 != null ? str11.hashCode() : 0)) * 37;
        String str12 = this.l;
        int iHashCode16 = iHashCode15 + (str12 != null ? str12.hashCode() : 0);
        ((de) this).f1127a = iHashCode16;
        return iHashCode16;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.f756a != null) {
            sb.append(", app_name=").append(this.f756a);
        }
        if (this.f757b != null) {
            sb.append(", icon_url=").append(this.f757b);
        }
        if (this.c != null) {
            sb.append(", package_name=").append(this.c);
        }
        if (this.f755a != null) {
            sb.append(", comment_count=").append(this.f755a);
        }
        if (this.f1461a != null) {
            sb.append(", score=").append(this.f1461a);
        }
        if (this.b != null) {
            sb.append(", package_size=").append(this.b);
        }
        if (this.d != null) {
            sb.append(", package_md5=").append(this.d);
        }
        if (this.e != null) {
            sb.append(", app_version=").append(this.e);
        }
        if (this.f != null) {
            sb.append(", desc_url=").append(this.f);
        }
        if (this.g != null) {
            sb.append(", privacy_url=").append(this.g);
        }
        if (this.h != null) {
            sb.append(", permission_url=").append(this.h);
        }
        if (this.i != null) {
            sb.append(", developer=").append(this.i);
        }
        if (this.j != null) {
            sb.append(", download_url=").append(this.j);
        }
        if (this.k != null) {
            sb.append(", app_beian=").append(this.k);
        }
        if (this.l != null) {
            sb.append(", app_age=").append(this.l);
        }
        return sb.replace(0, 2, "ResponseAdApp{").append('}').toString();
    }
}
