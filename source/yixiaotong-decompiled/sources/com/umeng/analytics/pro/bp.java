package com.umeng.analytics.pro;

import com.j256.ormlite.stmt.query.SimpleComparison;

/* JADX INFO: compiled from: TField.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class bp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f9128a;
    public final byte b;
    public final short c;

    public bp() {
        this("", (byte) 0, (short) 0);
    }

    public bp(String str, byte b, short s) {
        this.f9128a = str;
        this.b = b;
        this.c = s;
    }

    public String toString() {
        return "<TField name:'" + this.f9128a + "' type:" + ((int) this.b) + " field-id:" + ((int) this.c) + SimpleComparison.GREATER_THAN_OPERATION;
    }

    public boolean a(bp bpVar) {
        return this.b == bpVar.b && this.c == bpVar.c;
    }
}
