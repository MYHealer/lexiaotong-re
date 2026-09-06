package com.adprof.sdk;

import android.os.Parcelable;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public final class si extends k3 {
    public static final di<si> ADAPTER;
    public static final Parcelable.Creator<si> CREATOR;
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f1423a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Long f723a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final List f724a;
    public final Long b;
    public final Long c;

    static {
        qi qiVar = new qi();
        ADAPTER = qiVar;
        CREATOR = new j3(qiVar);
    }

    public si(Integer num, List list, Long l, Long l2, Long l3, q6 q6Var) {
        super(ADAPTER, q6Var);
        this.f1423a = num;
        this.f724a = kc.a("ads", list);
        this.f723a = l;
        this.b = l2;
        this.c = l3;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof si)) {
            return false;
        }
        si siVar = (si) obj;
        return a().equals(siVar.a()) && kc.a(this.f1423a, siVar.f1423a) && this.f724a.equals(siVar.f724a) && kc.a(this.f723a, siVar.f723a) && kc.a(this.b, siVar.b) && kc.a(this.c, siVar.c);
    }

    public int hashCode() {
        int i = ((de) this).f1127a;
        if (i != 0) {
            return i;
        }
        int iHashCode = a().hashCode() * 37;
        Integer num = this.f1423a;
        int iHashCode2 = (((iHashCode + (num != null ? num.hashCode() : 0)) * 37) + this.f724a.hashCode()) * 37;
        Long l = this.f723a;
        int iHashCode3 = (iHashCode2 + (l != null ? l.hashCode() : 0)) * 37;
        Long l2 = this.b;
        int iHashCode4 = (iHashCode3 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.c;
        int iHashCode5 = iHashCode4 + (l3 != null ? l3.hashCode() : 0);
        ((de) this).f1127a = iHashCode5;
        return iHashCode5;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.f1423a != null) {
            sb.append(", code=").append(this.f1423a);
        }
        if (!this.f724a.isEmpty()) {
            sb.append(", ads=").append(this.f724a);
        }
        if (this.f723a != null) {
            sb.append(", pt=").append(this.f723a);
        }
        if (this.b != null) {
            sb.append(", ct=").append(this.b);
        }
        if (this.c != null) {
            sb.append(", cache_time=").append(this.c);
        }
        return sb.replace(0, 2, "Response{").append('}').toString();
    }
}
