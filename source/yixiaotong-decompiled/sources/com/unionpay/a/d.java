package com.unionpay.a;

import java.net.URL;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class d {
    private String b;
    private String e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f9307a = 1;
    private HashMap c = null;
    private byte[] d = null;

    public d(String str) {
        this.b = str;
    }

    public final URL a() {
        try {
            return new URL(this.b);
        } catch (Exception unused) {
            return null;
        }
    }

    public final void a(String str) {
        if (str != null) {
            this.d = str.getBytes();
            this.e = str;
        }
    }

    public final String b() {
        return this.f9307a == 1 ? "POST" : "GET";
    }

    public final String c() {
        return this.e;
    }

    public final HashMap d() {
        return this.c;
    }
}
