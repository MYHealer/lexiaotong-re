package com.adprof.sdk;

import android.os.Parcelable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public final class oj extends k3 {
    public static final di<oj> ADAPTER;
    public static final Parcelable.Creator<oj> CREATOR;
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1347a;

    static {
        nj njVar = new nj();
        ADAPTER = njVar;
        CREATOR = new j3(njVar);
    }

    public oj(String str, q6 q6Var) {
        super(ADAPTER, q6Var);
        this.f1347a = str;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof oj)) {
            return false;
        }
        oj ojVar = (oj) obj;
        return a().equals(ojVar.a()) && kc.a(this.f1347a, ojVar.f1347a);
    }

    public int hashCode() {
        int i = ((de) this).f1127a;
        if (i != 0) {
            return i;
        }
        int iHashCode = a().hashCode() * 37;
        String str = this.f1347a;
        int iHashCode2 = iHashCode + (str != null ? str.hashCode() : 0);
        ((de) this).f1127a = iHashCode2;
        return iHashCode2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.f1347a != null) {
            sb.append(", text=").append(this.f1347a);
        }
        return sb.replace(0, 2, "ResponseText{").append('}').toString();
    }
}
