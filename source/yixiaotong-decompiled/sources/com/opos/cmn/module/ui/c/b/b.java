package com.opos.cmn.module.ui.c.b;

import java.util.Arrays;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f6216a;
    private boolean b;
    private Object[] c;

    public b(String str, boolean z, Object[] objArr) {
        this.f6216a = str;
        this.b = z;
        this.c = objArr;
    }

    public String a() {
        return this.f6216a;
    }

    public boolean b() {
        return this.b;
    }

    public Object[] c() {
        return this.c;
    }

    public String toString() {
        return "ToastParams{pkgName='" + this.f6216a + "', gbClick=" + this.b + ", objects=" + Arrays.toString(this.c) + '}';
    }
}
