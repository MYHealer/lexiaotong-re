package com.umeng.analytics.pro;

import java.io.Serializable;

/* JADX INFO: compiled from: FieldValueMetaData.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class bi implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f9118a;
    public final byte b;
    private final String c;
    private final boolean d;

    public boolean a() {
        return this.f9118a;
    }

    public String b() {
        return this.c;
    }

    public boolean c() {
        return this.b == 12;
    }

    public boolean d() {
        byte b = this.b;
        return b == 15 || b == 13 || b == 14;
    }

    public boolean e() {
        return this.d;
    }

    public bi(byte b, boolean z) {
        this.b = b;
        this.f9118a = false;
        this.c = null;
        this.d = z;
    }

    public bi(byte b) {
        this(b, false);
    }

    public bi(byte b, String str) {
        this.b = b;
        this.f9118a = true;
        this.c = str;
        this.d = false;
    }
}
