package com.adprof.sdk;

import android.os.Parcelable;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public final class mi extends k3 {
    public static final di<mi> ADAPTER;
    public static final Parcelable.Creator<mi> CREATOR;
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Cdo f1309a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final m3 f471a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final o9 f472a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final t7 f473a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Boolean f474a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Integer f475a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Long f476a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f477a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final List f478a;
    public final Integer b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final String f479b;
    public final Integer c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final String f480c;

    static {
        ki kiVar = new ki();
        ADAPTER = kiVar;
        CREATOR = new j3(kiVar);
    }

    public mi(String str, Integer num, List list, t7 t7Var, m3 m3Var, o9 o9Var, Cdo cdo, String str2, Long l, Boolean bool, String str3, Integer num2, Integer num3, q6 q6Var) {
        super(ADAPTER, q6Var);
        this.f477a = str;
        this.f475a = num;
        this.f478a = kc.a("imp", list);
        this.f473a = t7Var;
        this.f471a = m3Var;
        this.f472a = o9Var;
        this.f1309a = cdo;
        this.f479b = str2;
        this.f476a = l;
        this.f474a = bool;
        this.f480c = str3;
        this.b = num2;
        this.c = num3;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof mi)) {
            return false;
        }
        mi miVar = (mi) obj;
        return a().equals(miVar.a()) && kc.a(this.f477a, miVar.f477a) && kc.a(this.f475a, miVar.f475a) && this.f478a.equals(miVar.f478a) && kc.a(this.f473a, miVar.f473a) && kc.a(this.f471a, miVar.f471a) && kc.a(this.f472a, miVar.f472a) && kc.a(this.f1309a, miVar.f1309a) && kc.a(this.f479b, miVar.f479b) && kc.a(this.f476a, miVar.f476a) && kc.a(this.f474a, miVar.f474a) && kc.a(this.f480c, miVar.f480c) && kc.a(this.b, miVar.b) && kc.a(this.c, miVar.c);
    }

    public int hashCode() {
        int i = ((de) this).f1127a;
        if (i != 0) {
            return i;
        }
        int iHashCode = a().hashCode() * 37;
        String str = this.f477a;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 37;
        Integer num = this.f475a;
        int iHashCode3 = (((iHashCode2 + (num != null ? num.hashCode() : 0)) * 37) + this.f478a.hashCode()) * 37;
        t7 t7Var = this.f473a;
        int iHashCode4 = (iHashCode3 + (t7Var != null ? t7Var.hashCode() : 0)) * 37;
        m3 m3Var = this.f471a;
        int iHashCode5 = (iHashCode4 + (m3Var != null ? m3Var.hashCode() : 0)) * 37;
        o9 o9Var = this.f472a;
        int iHashCode6 = (iHashCode5 + (o9Var != null ? o9Var.hashCode() : 0)) * 37;
        Cdo cdo = this.f1309a;
        int iHashCode7 = (iHashCode6 + (cdo != null ? cdo.hashCode() : 0)) * 37;
        String str2 = this.f479b;
        int iHashCode8 = (iHashCode7 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Long l = this.f476a;
        int iHashCode9 = (iHashCode8 + (l != null ? l.hashCode() : 0)) * 37;
        Boolean bool = this.f474a;
        int iHashCode10 = (iHashCode9 + (bool != null ? bool.hashCode() : 0)) * 37;
        String str3 = this.f480c;
        int iHashCode11 = (iHashCode10 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Integer num2 = this.b;
        int iHashCode12 = (iHashCode11 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.c;
        int iHashCode13 = iHashCode12 + (num3 != null ? num3.hashCode() : 0);
        ((de) this).f1127a = iHashCode13;
        return iHashCode13;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.f477a != null) {
            sb.append(", req_id=").append(this.f477a);
        }
        if (this.f475a != null) {
            sb.append(", mid=").append(this.f475a);
        }
        if (!this.f478a.isEmpty()) {
            sb.append(", imp=").append(this.f478a);
        }
        if (this.f473a != null) {
            sb.append(", device=").append(this.f473a);
        }
        if (this.f471a != null) {
            sb.append(", app=").append(this.f471a);
        }
        if (this.f472a != null) {
            sb.append(", geo=").append(this.f472a);
        }
        if (this.f1309a != null) {
            sb.append(", user=").append(this.f1309a);
        }
        if (this.f479b != null) {
            sb.append(", v=").append(this.f479b);
        }
        if (this.f476a != null) {
            sb.append(", ts=").append(this.f476a);
        }
        if (this.f474a != null) {
            sb.append(", is_test=").append(this.f474a);
        }
        if (this.f480c != null) {
            sb.append(", plgv=").append(this.f480c);
        }
        if (this.b != null) {
            sb.append(", req_count=").append(this.b);
        }
        if (this.c != null) {
            sb.append(", show_count=").append(this.c);
        }
        return sb.replace(0, 2, "Request{").append('}').toString();
    }
}
