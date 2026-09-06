package com.adprof.sdk;

import android.os.Parcelable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public final class qj extends k3 {
    public static final di<qj> ADAPTER;
    public static final Parcelable.Creator<qj> CREATOR;
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f1387a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f680a;
    public final Integer b;
    public final Integer c;

    static {
        pj pjVar = new pj();
        ADAPTER = pjVar;
        CREATOR = new j3(pjVar);
    }

    public qj(String str, Integer num, Integer num2, Integer num3, q6 q6Var) {
        super(ADAPTER, q6Var);
        this.f680a = str;
        this.f1387a = num;
        this.b = num2;
        this.c = num3;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof qj)) {
            return false;
        }
        qj qjVar = (qj) obj;
        return a().equals(qjVar.a()) && kc.a(this.f680a, qjVar.f680a) && kc.a(this.f1387a, qjVar.f1387a) && kc.a(this.b, qjVar.b) && kc.a(this.c, qjVar.c);
    }

    public int hashCode() {
        int i = ((de) this).f1127a;
        if (i != 0) {
            return i;
        }
        int iHashCode = a().hashCode() * 37;
        String str = this.f680a;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 37;
        Integer num = this.f1387a;
        int iHashCode3 = (iHashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.b;
        int iHashCode4 = (iHashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.c;
        int iHashCode5 = iHashCode4 + (num3 != null ? num3.hashCode() : 0);
        ((de) this).f1127a = iHashCode5;
        return iHashCode5;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.f680a != null) {
            sb.append(", url=").append(this.f680a);
        }
        if (this.f1387a != null) {
            sb.append(", width=").append(this.f1387a);
        }
        if (this.b != null) {
            sb.append(", height=").append(this.b);
        }
        if (this.c != null) {
            sb.append(", duration=").append(this.c);
        }
        return sb.replace(0, 2, "ResponseVideo{").append('}').toString();
    }
}
