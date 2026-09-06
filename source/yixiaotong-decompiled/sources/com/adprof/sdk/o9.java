package com.adprof.sdk;

import android.os.Parcelable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public final class o9 extends k3 {
    public static final di<o9> ADAPTER;
    public static final Parcelable.Creator<o9> CREATOR;
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Double f1339a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Integer f535a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Long f536a;
    public final Double b;

    static {
        n9 n9Var = new n9();
        ADAPTER = n9Var;
        CREATOR = new j3(n9Var);
    }

    public o9(Double d, Double d2, Long l, Integer num, q6 q6Var) {
        super(ADAPTER, q6Var);
        this.f1339a = d;
        this.b = d2;
        this.f536a = l;
        this.f535a = num;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof o9)) {
            return false;
        }
        o9 o9Var = (o9) obj;
        return a().equals(o9Var.a()) && kc.a(this.f1339a, o9Var.f1339a) && kc.a(this.b, o9Var.b) && kc.a(this.f536a, o9Var.f536a) && kc.a(this.f535a, o9Var.f535a);
    }

    public int hashCode() {
        int i = ((de) this).f1127a;
        if (i != 0) {
            return i;
        }
        int iHashCode = a().hashCode() * 37;
        Double d = this.f1339a;
        int iHashCode2 = (iHashCode + (d != null ? d.hashCode() : 0)) * 37;
        Double d2 = this.b;
        int iHashCode3 = (iHashCode2 + (d2 != null ? d2.hashCode() : 0)) * 37;
        Long l = this.f536a;
        int iHashCode4 = (iHashCode3 + (l != null ? l.hashCode() : 0)) * 37;
        Integer num = this.f535a;
        int iHashCode5 = iHashCode4 + (num != null ? num.hashCode() : 0);
        ((de) this).f1127a = iHashCode5;
        return iHashCode5;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.f1339a != null) {
            sb.append(", lat=").append(this.f1339a);
        }
        if (this.b != null) {
            sb.append(", lon=").append(this.b);
        }
        if (this.f536a != null) {
            sb.append(", time=").append(this.f536a);
        }
        if (this.f535a != null) {
            sb.append(", type=").append(this.f535a);
        }
        return sb.replace(0, 2, "Geo{").append('}').toString();
    }
}
