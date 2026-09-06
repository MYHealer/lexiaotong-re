package com.adprof.sdk;

import android.os.Parcelable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public final class zi extends k3 {
    public static final di<zi> ADAPTER;
    public static final Parcelable.Creator<zi> CREATOR;
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final cj f1558a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ij f913a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final mj f914a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final sj f915a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ui f916a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Integer f917a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f918a;
    public final Integer b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final String f919b;
    public final Integer c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final String f920c;
    public final Integer d;
    public final Integer e;
    public final Integer f;
    public final Integer g;

    static {
        yi yiVar = new yi();
        ADAPTER = yiVar;
        CREATOR = new j3(yiVar);
    }

    public zi(String str, String str2, Integer num, Integer num2, Integer num3, ij ijVar, cj cjVar, ui uiVar, sj sjVar, String str3, Integer num4, mj mjVar, Integer num5, Integer num6, Integer num7, q6 q6Var) {
        super(ADAPTER, q6Var);
        this.f918a = str;
        this.f919b = str2;
        this.f917a = num;
        this.b = num2;
        this.c = num3;
        this.f913a = ijVar;
        this.f1558a = cjVar;
        this.f916a = uiVar;
        this.f915a = sjVar;
        this.f920c = str3;
        this.d = num4;
        this.f914a = mjVar;
        this.e = num5;
        this.f = num6;
        this.g = num7;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zi)) {
            return false;
        }
        zi ziVar = (zi) obj;
        return a().equals(ziVar.a()) && kc.a(this.f918a, ziVar.f918a) && kc.a(this.f919b, ziVar.f919b) && kc.a(this.f917a, ziVar.f917a) && kc.a(this.b, ziVar.b) && kc.a(this.c, ziVar.c) && kc.a(this.f913a, ziVar.f913a) && kc.a(this.f1558a, ziVar.f1558a) && kc.a(this.f916a, ziVar.f916a) && kc.a(this.f915a, ziVar.f915a) && kc.a(this.f920c, ziVar.f920c) && kc.a(this.d, ziVar.d) && kc.a(this.f914a, ziVar.f914a) && kc.a(this.e, ziVar.e) && kc.a(this.f, ziVar.f) && kc.a(this.g, ziVar.g);
    }

    public int hashCode() {
        int i = ((de) this).f1127a;
        if (i != 0) {
            return i;
        }
        int iHashCode = a().hashCode() * 37;
        String str = this.f918a;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.f919b;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num = this.f917a;
        int iHashCode4 = (iHashCode3 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.b;
        int iHashCode5 = (iHashCode4 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.c;
        int iHashCode6 = (iHashCode5 + (num3 != null ? num3.hashCode() : 0)) * 37;
        ij ijVar = this.f913a;
        int iHashCode7 = (iHashCode6 + (ijVar != null ? ijVar.hashCode() : 0)) * 37;
        cj cjVar = this.f1558a;
        int iHashCode8 = (iHashCode7 + (cjVar != null ? cjVar.hashCode() : 0)) * 37;
        ui uiVar = this.f916a;
        int iHashCode9 = (iHashCode8 + (uiVar != null ? uiVar.hashCode() : 0)) * 37;
        sj sjVar = this.f915a;
        int iHashCode10 = (iHashCode9 + (sjVar != null ? sjVar.hashCode() : 0)) * 37;
        String str3 = this.f920c;
        int iHashCode11 = (iHashCode10 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Integer num4 = this.d;
        int iHashCode12 = (iHashCode11 + (num4 != null ? num4.hashCode() : 0)) * 37;
        mj mjVar = this.f914a;
        int iHashCode13 = (iHashCode12 + (mjVar != null ? mjVar.hashCode() : 0)) * 37;
        Integer num5 = this.e;
        int iHashCode14 = (iHashCode13 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.f;
        int iHashCode15 = (iHashCode14 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Integer num7 = this.g;
        int iHashCode16 = iHashCode15 + (num7 != null ? num7.hashCode() : 0);
        ((de) this).f1127a = iHashCode16;
        return iHashCode16;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.f918a != null) {
            sb.append(", id=").append(this.f918a);
        }
        if (this.f919b != null) {
            sb.append(", ad_id=").append(this.f919b);
        }
        if (this.f917a != null) {
            sb.append(", bid_price=").append(this.f917a);
        }
        if (this.b != null) {
            sb.append(", bid_type=").append(this.b);
        }
        if (this.c != null) {
            sb.append(", action_type=").append(this.c);
        }
        if (this.f913a != null) {
            sb.append(", events=").append(this.f913a);
        }
        if (this.f1558a != null) {
            sb.append(", creative=").append(this.f1558a);
        }
        if (this.f916a != null) {
            sb.append(", ad_app=").append(this.f916a);
        }
        if (this.f915a != null) {
            sb.append(", wx_info=").append(this.f915a);
        }
        if (this.f920c != null) {
            sb.append(", ext=").append(this.f920c);
        }
        if (this.d != null) {
            sb.append(", click_type=").append(this.d);
        }
        if (this.f914a != null) {
            sb.append(", interaction=").append(this.f914a);
        }
        if (this.e != null) {
            sb.append(", block_custom=").append(this.e);
        }
        if (this.f != null) {
            sb.append(", ad_bc=").append(this.f);
        }
        if (this.g != null) {
            sb.append(", fdop=").append(this.g);
        }
        return sb.replace(0, 2, "ResponseAds{").append('}').toString();
    }
}
