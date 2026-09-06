package com.adprof.sdk;

import android.os.Parcelable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public final class kj extends k3 {
    public static final di<kj> ADAPTER;
    public static final Parcelable.Creator<kj> CREATOR;
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f1268a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f427a;
    public final Integer b;

    static {
        jj jjVar = new jj();
        ADAPTER = jjVar;
        CREATOR = new j3(jjVar);
    }

    public kj(String str, Integer num, Integer num2, q6 q6Var) {
        super(ADAPTER, q6Var);
        this.f427a = str;
        this.f1268a = num;
        this.b = num2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof kj)) {
            return false;
        }
        kj kjVar = (kj) obj;
        return a().equals(kjVar.a()) && kc.a(this.f427a, kjVar.f427a) && kc.a(this.f1268a, kjVar.f1268a) && kc.a(this.b, kjVar.b);
    }

    public int hashCode() {
        int i = ((de) this).f1127a;
        if (i != 0) {
            return i;
        }
        int iHashCode = a().hashCode() * 37;
        String str = this.f427a;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 37;
        Integer num = this.f1268a;
        int iHashCode3 = (iHashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.b;
        int iHashCode4 = iHashCode3 + (num2 != null ? num2.hashCode() : 0);
        ((de) this).f1127a = iHashCode4;
        return iHashCode4;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.f427a != null) {
            sb.append(", url=").append(this.f427a);
        }
        if (this.f1268a != null) {
            sb.append(", width=").append(this.f1268a);
        }
        if (this.b != null) {
            sb.append(", height=").append(this.b);
        }
        return sb.replace(0, 2, "ResponseImg{").append('}').toString();
    }
}
