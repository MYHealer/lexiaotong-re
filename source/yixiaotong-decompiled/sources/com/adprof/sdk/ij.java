package com.adprof.sdk;

import android.os.Parcelable;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public final class ij extends k3 {
    public static final di<ij> ADAPTER;
    public static final Parcelable.Creator<ij> CREATOR;
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f1233a;
    public final List b;
    public final List c;
    public final List d;
    public final List e;
    public final List f;
    public final List g;
    public final List h;
    public final List i;
    public final List j;
    public final List k;

    static {
        hj hjVar = new hj();
        ADAPTER = hjVar;
        CREATOR = new j3(hjVar);
    }

    public ij(List list, List list2, List list3, List list4, List list5, List list6, List list7, List list8, List list9, List list10, List list11, q6 q6Var) {
        super(ADAPTER, q6Var);
        this.f1233a = kc.a("download_urls", list);
        this.b = kc.a("downloaded_urls", list2);
        this.c = kc.a("install_urls", list3);
        this.d = kc.a("installed_urls", list4);
        this.e = kc.a("dp_urls", list5);
        this.f = kc.a("dp_fail_urls", list6);
        this.g = kc.a("imp_urls", list7);
        this.h = kc.a("click_urls", list8);
        this.i = kc.a("lose_urls", list9);
        this.j = kc.a("win_urls", list10);
        this.k = kc.a("delay_urls", list11);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ij)) {
            return false;
        }
        ij ijVar = (ij) obj;
        return a().equals(ijVar.a()) && this.f1233a.equals(ijVar.f1233a) && this.b.equals(ijVar.b) && this.c.equals(ijVar.c) && this.d.equals(ijVar.d) && this.e.equals(ijVar.e) && this.f.equals(ijVar.f) && this.g.equals(ijVar.g) && this.h.equals(ijVar.h) && this.i.equals(ijVar.i) && this.j.equals(ijVar.j) && this.k.equals(ijVar.k);
    }

    public int hashCode() {
        int i = ((de) this).f1127a;
        if (i != 0) {
            return i;
        }
        int iHashCode = (((((((((((((((((((((a().hashCode() * 37) + this.f1233a.hashCode()) * 37) + this.b.hashCode()) * 37) + this.c.hashCode()) * 37) + this.d.hashCode()) * 37) + this.e.hashCode()) * 37) + this.f.hashCode()) * 37) + this.g.hashCode()) * 37) + this.h.hashCode()) * 37) + this.i.hashCode()) * 37) + this.j.hashCode()) * 37) + this.k.hashCode();
        ((de) this).f1127a = iHashCode;
        return iHashCode;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.f1233a.isEmpty()) {
            sb.append(", download_urls=").append(this.f1233a);
        }
        if (!this.b.isEmpty()) {
            sb.append(", downloaded_urls=").append(this.b);
        }
        if (!this.c.isEmpty()) {
            sb.append(", install_urls=").append(this.c);
        }
        if (!this.d.isEmpty()) {
            sb.append(", installed_urls=").append(this.d);
        }
        if (!this.e.isEmpty()) {
            sb.append(", dp_urls=").append(this.e);
        }
        if (!this.f.isEmpty()) {
            sb.append(", dp_fail_urls=").append(this.f);
        }
        if (!this.g.isEmpty()) {
            sb.append(", imp_urls=").append(this.g);
        }
        if (!this.h.isEmpty()) {
            sb.append(", click_urls=").append(this.h);
        }
        if (!this.i.isEmpty()) {
            sb.append(", lose_urls=").append(this.i);
        }
        if (!this.j.isEmpty()) {
            sb.append(", win_urls=").append(this.j);
        }
        if (!this.k.isEmpty()) {
            sb.append(", delay_urls=").append(this.k);
        }
        return sb.replace(0, 2, "ResponseEvent{").append('}').toString();
    }
}
