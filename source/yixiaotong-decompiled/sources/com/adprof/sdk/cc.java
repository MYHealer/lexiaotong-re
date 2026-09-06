package com.adprof.sdk;

import android.os.Parcelable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public final class cc extends k3 {
    public static final di<cc> ADAPTER;
    public static final Parcelable.Creator<cc> CREATOR;
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Boolean f1108a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Integer f173a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f174a;
    public final Integer b;
    public final Integer c;
    public final Integer d;
    public final Integer e;

    static {
        bc bcVar = new bc();
        ADAPTER = bcVar;
        CREATOR = new j3(bcVar);
    }

    public cc(String str, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Boolean bool, q6 q6Var) {
        super(ADAPTER, q6Var);
        this.f174a = str;
        this.f173a = num;
        this.b = num2;
        this.c = num3;
        this.d = num4;
        this.e = num5;
        this.f1108a = bool;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof cc)) {
            return false;
        }
        cc ccVar = (cc) obj;
        return a().equals(ccVar.a()) && kc.a(this.f174a, ccVar.f174a) && kc.a(this.f173a, ccVar.f173a) && kc.a(this.b, ccVar.b) && kc.a(this.c, ccVar.c) && kc.a(this.d, ccVar.d) && kc.a(this.e, ccVar.e) && kc.a(this.f1108a, ccVar.f1108a);
    }

    public int hashCode() {
        int i = ((de) this).f1127a;
        if (i != 0) {
            return i;
        }
        int iHashCode = a().hashCode() * 37;
        String str = this.f174a;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 37;
        Integer num = this.f173a;
        int iHashCode3 = (iHashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.b;
        int iHashCode4 = (iHashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.c;
        int iHashCode5 = (iHashCode4 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.d;
        int iHashCode6 = (iHashCode5 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.e;
        int iHashCode7 = (iHashCode6 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Boolean bool = this.f1108a;
        int iHashCode8 = iHashCode7 + (bool != null ? bool.hashCode() : 0);
        ((de) this).f1127a = iHashCode8;
        return iHashCode8;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.f174a != null) {
            sb.append(", id=").append(this.f174a);
        }
        if (this.f173a != null) {
            sb.append(", slot=").append(this.f173a);
        }
        if (this.b != null) {
            sb.append(", bid_floor=").append(this.b);
        }
        if (this.c != null) {
            sb.append(", secure=").append(this.c);
        }
        if (this.d != null) {
            sb.append(", block_dp=").append(this.d);
        }
        if (this.e != null) {
            sb.append(", block_hap=").append(this.e);
        }
        if (this.f1108a != null) {
            sb.append(", is_screen=").append(this.f1108a);
        }
        return sb.replace(0, 2, "Imp{").append('}').toString();
    }
}
