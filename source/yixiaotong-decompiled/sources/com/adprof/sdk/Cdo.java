package com.adprof.sdk;

import android.os.Parcelable;

/* JADX INFO: renamed from: com.adprof.sdk.do, reason: invalid class name */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public final class Cdo extends k3 {
    public static final di<Cdo> ADAPTER;
    public static final Parcelable.Creator<Cdo> CREATOR;
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f1136a;
    public final Integer b;

    static {
        co coVar = new co();
        ADAPTER = coVar;
        CREATOR = new j3(coVar);
    }

    public Cdo(Integer num, Integer num2, q6 q6Var) {
        super(ADAPTER, q6Var);
        this.f1136a = num;
        this.b = num2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Cdo)) {
            return false;
        }
        Cdo cdo = (Cdo) obj;
        return a().equals(cdo.a()) && kc.a(this.f1136a, cdo.f1136a) && kc.a(this.b, cdo.b);
    }

    public int hashCode() {
        int i = ((de) this).f1127a;
        if (i != 0) {
            return i;
        }
        int iHashCode = a().hashCode() * 37;
        Integer num = this.f1136a;
        int iHashCode2 = (iHashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.b;
        int iHashCode3 = iHashCode2 + (num2 != null ? num2.hashCode() : 0);
        ((de) this).f1127a = iHashCode3;
        return iHashCode3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.f1136a != null) {
            sb.append(", age=").append(this.f1136a);
        }
        if (this.b != null) {
            sb.append(", gender=").append(this.b);
        }
        return sb.replace(0, 2, "User{").append('}').toString();
    }
}
