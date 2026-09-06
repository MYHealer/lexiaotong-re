package com.adprof.sdk;

import android.os.Parcelable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public final class ej extends k3 {
    public static final di<ej> ADAPTER;
    public static final Parcelable.Creator<ej> CREATOR;
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f1152a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f261a;

    static {
        dj djVar = new dj();
        ADAPTER = djVar;
        CREATOR = new j3(djVar);
    }

    public ej(Integer num, String str, q6 q6Var) {
        super(ADAPTER, q6Var);
        this.f1152a = num;
        this.f261a = str;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ej)) {
            return false;
        }
        ej ejVar = (ej) obj;
        return a().equals(ejVar.a()) && kc.a(this.f1152a, ejVar.f1152a) && kc.a(this.f261a, ejVar.f261a);
    }

    public int hashCode() {
        int i = ((de) this).f1127a;
        if (i != 0) {
            return i;
        }
        int iHashCode = a().hashCode() * 37;
        Integer num = this.f1152a;
        int iHashCode2 = (iHashCode + (num != null ? num.hashCode() : 0)) * 37;
        String str = this.f261a;
        int iHashCode3 = iHashCode2 + (str != null ? str.hashCode() : 0);
        ((de) this).f1127a = iHashCode3;
        return iHashCode3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.f1152a != null) {
            sb.append(", delay=").append(this.f1152a);
        }
        if (this.f261a != null) {
            sb.append(", url=").append(this.f261a);
        }
        return sb.replace(0, 2, "ResponseDelayUrl{").append('}').toString();
    }
}
