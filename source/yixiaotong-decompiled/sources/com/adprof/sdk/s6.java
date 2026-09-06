package com.adprof.sdk;

import android.os.Parcelable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public final class s6 extends k3 {
    public static final di<s6> ADAPTER;
    public static final Parcelable.Creator<s6> CREATOR;
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1414a;
    public final String b;

    static {
        r6 r6Var = new r6();
        ADAPTER = r6Var;
        CREATOR = new j3(r6Var);
    }

    public s6(String str, String str2, q6 q6Var) {
        super(ADAPTER, q6Var);
        this.f1414a = str;
        this.b = str2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof s6)) {
            return false;
        }
        s6 s6Var = (s6) obj;
        return a().equals(s6Var.a()) && kc.a(this.f1414a, s6Var.f1414a) && kc.a(this.b, s6Var.b);
    }

    public int hashCode() {
        int i = ((de) this).f1127a;
        if (i != 0) {
            return i;
        }
        int iHashCode = a().hashCode() * 37;
        String str = this.f1414a;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.b;
        int iHashCode3 = iHashCode2 + (str2 != null ? str2.hashCode() : 0);
        ((de) this).f1127a = iHashCode3;
        return iHashCode3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.f1414a != null) {
            sb.append(", v=").append(this.f1414a);
        }
        if (this.b != null) {
            sb.append(", m5r=").append(this.b);
        }
        return sb.replace(0, 2, "CaidInfo{").append('}').toString();
    }
}
