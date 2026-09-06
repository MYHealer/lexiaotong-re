package com.adprof.sdk;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public final class v0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f1468a;
    public String b;

    public v0(String str, String str2) {
        this.f1468a = str;
        this.b = str2;
    }

    public /* synthetic */ v0(String str, String str2, int i) {
        this((i & 1) != 0 ? "" : null, (i & 2) == 0 ? null : "");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof v0)) {
            return false;
        }
        v0 v0Var = (v0) obj;
        return Intrinsics.areEqual(this.f1468a, v0Var.f1468a) && Intrinsics.areEqual(this.b, v0Var.b);
    }

    public int hashCode() {
        return (this.f1468a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "AdAppInventory(name=" + this.f1468a + ", pkgName=" + this.b + ')';
    }
}
