package com.adprof.sdk;

import android.text.TextUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public final class w9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1495a;
    public final String b;

    public w9(String str, String str2) {
        this.f1495a = str;
        this.b = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || w9.class != obj.getClass()) {
            return false;
        }
        w9 w9Var = (w9) obj;
        return TextUtils.equals(this.f1495a, w9Var.f1495a) && TextUtils.equals(this.b, w9Var.b);
    }

    public int hashCode() {
        return (this.f1495a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "Header[name=" + this.f1495a + ",value=" + this.b + "]";
    }
}
