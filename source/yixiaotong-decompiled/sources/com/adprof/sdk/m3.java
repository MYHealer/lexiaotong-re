package com.adprof.sdk;

import android.os.Parcelable;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public final class m3 extends k3 {
    public static final di<m3> ADAPTER;
    public static final Parcelable.Creator<m3> CREATOR;
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1299a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final List f459a;
    public final String b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final List f460b;
    public final String c;

    static {
        l3 l3Var = new l3();
        ADAPTER = l3Var;
        CREATOR = new j3(l3Var);
    }

    public m3(String str, String str2, String str3, List list, List list2, q6 q6Var) {
        super(ADAPTER, q6Var);
        this.f1299a = str;
        this.b = str2;
        this.c = str3;
        this.f459a = kc.a("installed", list);
        this.f460b = kc.a("installed_id", list2);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof m3)) {
            return false;
        }
        m3 m3Var = (m3) obj;
        return a().equals(m3Var.a()) && kc.a(this.f1299a, m3Var.f1299a) && kc.a(this.b, m3Var.b) && kc.a(this.c, m3Var.c) && this.f459a.equals(m3Var.f459a) && this.f460b.equals(m3Var.f460b);
    }

    public int hashCode() {
        int i = ((de) this).f1127a;
        if (i != 0) {
            return i;
        }
        int iHashCode = a().hashCode() * 37;
        String str = this.f1299a;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.b;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.c;
        int iHashCode4 = ((((iHashCode3 + (str3 != null ? str3.hashCode() : 0)) * 37) + this.f459a.hashCode()) * 37) + this.f460b.hashCode();
        ((de) this).f1127a = iHashCode4;
        return iHashCode4;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.f1299a != null) {
            sb.append(", bundle_id=").append(this.f1299a);
        }
        if (this.b != null) {
            sb.append(", app_name=").append(this.b);
        }
        if (this.c != null) {
            sb.append(", app_version=").append(this.c);
        }
        if (!this.f459a.isEmpty()) {
            sb.append(", installed=").append(this.f459a);
        }
        if (!this.f460b.isEmpty()) {
            sb.append(", installed_id=").append(this.f460b);
        }
        return sb.replace(0, 2, "App{").append('}').toString();
    }
}
