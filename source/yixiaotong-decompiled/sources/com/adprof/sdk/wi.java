package com.adprof.sdk;

import android.os.Parcelable;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public final class wi extends k3 {
    public static final di<wi> ADAPTER;
    public static final Parcelable.Creator<wi> CREATOR;
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final kj f1503a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final oj f803a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Integer f804a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final List f805a;
    public final oj b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final List f806b;

    static {
        vi viVar = new vi();
        ADAPTER = viVar;
        CREATOR = new j3(viVar);
    }

    public wi(Integer num, List list, kj kjVar, List list2, oj ojVar, oj ojVar2, q6 q6Var) {
        super(ADAPTER, q6Var);
        this.f804a = num;
        this.f805a = kc.a("imgs", list);
        this.f1503a = kjVar;
        this.f806b = kc.a("videos", list2);
        this.f803a = ojVar;
        this.b = ojVar2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof wi)) {
            return false;
        }
        wi wiVar = (wi) obj;
        return a().equals(wiVar.a()) && kc.a(this.f804a, wiVar.f804a) && this.f805a.equals(wiVar.f805a) && kc.a(this.f1503a, wiVar.f1503a) && this.f806b.equals(wiVar.f806b) && kc.a(this.f803a, wiVar.f803a) && kc.a(this.b, wiVar.b);
    }

    public int hashCode() {
        int i = ((de) this).f1127a;
        if (i != 0) {
            return i;
        }
        int iHashCode = a().hashCode() * 37;
        Integer num = this.f804a;
        int iHashCode2 = (((iHashCode + (num != null ? num.hashCode() : 0)) * 37) + this.f805a.hashCode()) * 37;
        kj kjVar = this.f1503a;
        int iHashCode3 = (((iHashCode2 + (kjVar != null ? kjVar.hashCode() : 0)) * 37) + this.f806b.hashCode()) * 37;
        oj ojVar = this.f803a;
        int iHashCode4 = (iHashCode3 + (ojVar != null ? ojVar.hashCode() : 0)) * 37;
        oj ojVar2 = this.b;
        int iHashCode5 = iHashCode4 + (ojVar2 != null ? ojVar2.hashCode() : 0);
        ((de) this).f1127a = iHashCode5;
        return iHashCode5;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.f804a != null) {
            sb.append(", template_type=").append(this.f804a);
        }
        if (!this.f805a.isEmpty()) {
            sb.append(", imgs=").append(this.f805a);
        }
        if (this.f1503a != null) {
            sb.append(", icon=").append(this.f1503a);
        }
        if (!this.f806b.isEmpty()) {
            sb.append(", videos=").append(this.f806b);
        }
        if (this.f803a != null) {
            sb.append(", title=").append(this.f803a);
        }
        if (this.b != null) {
            sb.append(", desc=").append(this.b);
        }
        return sb.replace(0, 2, "ResponseAdm{").append('}').toString();
    }
}
