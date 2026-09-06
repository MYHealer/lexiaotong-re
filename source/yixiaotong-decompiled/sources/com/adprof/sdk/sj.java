package com.adprof.sdk;

import android.os.Parcelable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public final class sj extends k3 {
    public static final di<sj> ADAPTER;
    public static final Parcelable.Creator<sj> CREATOR;
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1424a;
    public final String b;
    public final String c;
    public final String d;

    static {
        rj rjVar = new rj();
        ADAPTER = rjVar;
        CREATOR = new j3(rjVar);
    }

    public sj(String str, String str2, String str3, String str4, q6 q6Var) {
        super(ADAPTER, q6Var);
        this.f1424a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof sj)) {
            return false;
        }
        sj sjVar = (sj) obj;
        return a().equals(sjVar.a()) && kc.a(this.f1424a, sjVar.f1424a) && kc.a(this.b, sjVar.b) && kc.a(this.c, sjVar.c) && kc.a(this.d, sjVar.d);
    }

    public int hashCode() {
        int i = ((de) this).f1127a;
        if (i != 0) {
            return i;
        }
        int iHashCode = a().hashCode() * 37;
        String str = this.f1424a;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.b;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.c;
        int iHashCode4 = (iHashCode3 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.d;
        int iHashCode5 = iHashCode4 + (str4 != null ? str4.hashCode() : 0);
        ((de) this).f1127a = iHashCode5;
        return iHashCode5;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.f1424a != null) {
            sb.append(", release_type=").append(this.f1424a);
        }
        if (this.b != null) {
            sb.append(", program_id=").append(this.b);
        }
        if (this.c != null) {
            sb.append(", program_path=").append(this.c);
        }
        if (this.d != null) {
            sb.append(", binded_app=").append(this.d);
        }
        return sb.replace(0, 2, "ResponseWxInfo{").append('}').toString();
    }
}
