package com.adprof.sdk;

import android.os.Parcelable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public final class cj extends k3 {
    public static final di<cj> ADAPTER;
    public static final Parcelable.Creator<cj> CREATOR;
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final wi f1113a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Integer f175a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f176a;
    public final String b;
    public final String c;

    static {
        bj bjVar = new bj();
        ADAPTER = bjVar;
        CREATOR = new j3(bjVar);
    }

    public cj(String str, wi wiVar, String str2, String str3, Integer num, q6 q6Var) {
        super(ADAPTER, q6Var);
        this.f176a = str;
        this.f1113a = wiVar;
        this.b = str2;
        this.c = str3;
        this.f175a = num;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof cj)) {
            return false;
        }
        cj cjVar = (cj) obj;
        return a().equals(cjVar.a()) && kc.a(this.f176a, cjVar.f176a) && kc.a(this.f1113a, cjVar.f1113a) && kc.a(this.b, cjVar.b) && kc.a(this.c, cjVar.c) && kc.a(this.f175a, cjVar.f175a);
    }

    public int hashCode() {
        int i = ((de) this).f1127a;
        if (i != 0) {
            return i;
        }
        int iHashCode = a().hashCode() * 37;
        String str = this.f176a;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 37;
        wi wiVar = this.f1113a;
        int iHashCode3 = (iHashCode2 + (wiVar != null ? wiVar.hashCode() : 0)) * 37;
        String str2 = this.b;
        int iHashCode4 = (iHashCode3 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.c;
        int iHashCode5 = (iHashCode4 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Integer num = this.f175a;
        int iHashCode6 = iHashCode5 + (num != null ? num.hashCode() : 0);
        ((de) this).f1127a = iHashCode6;
        return iHashCode6;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.f176a != null) {
            sb.append(", cid=").append(this.f176a);
        }
        if (this.f1113a != null) {
            sb.append(", adm=").append(this.f1113a);
        }
        if (this.b != null) {
            sb.append(", land=").append(this.b);
        }
        if (this.c != null) {
            sb.append(", deeplink=").append(this.c);
        }
        if (this.f175a != null) {
            sb.append(", ddp=").append(this.f175a);
        }
        return sb.replace(0, 2, "ResponseCreative{").append('}').toString();
    }
}
