package com.huawei.hms.scankit.p;

import java.nio.charset.StandardCharsets;

/* JADX INFO: compiled from: EncoderContext.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
final class o2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f4318a;
    private h6 b;
    private b2 c;
    private b2 d;
    private final StringBuilder e;
    int f;
    private int g;
    private g6 h;
    private int i;

    o2(String str) {
        byte[] bytes = str.getBytes(StandardCharsets.ISO_8859_1);
        StringBuilder sb = new StringBuilder(bytes.length);
        int length = bytes.length;
        for (int i = 0; i < length; i++) {
            char c = (char) (bytes[i] & 255);
            if (c == '?' && str.charAt(i) != '?') {
                throw new IllegalArgumentException("Message contains characters outside ISO-8859-1 encoding.");
            }
            sb.append(c);
        }
        this.f4318a = sb.toString();
        this.b = h6.FORCE_NONE;
        this.e = new StringBuilder(str.length());
        this.g = -1;
    }

    private int h() {
        return this.f4318a.length() - this.i;
    }

    public void a(int i) {
        this.i = i;
    }

    public void a(b2 b2Var, b2 b2Var2) {
        this.c = b2Var;
        this.d = b2Var2;
    }

    public void a(h6 h6Var) {
        this.b = h6Var;
    }

    public StringBuilder b() {
        return this.e;
    }

    public void b(int i) {
        this.g = i;
    }

    public char c() {
        return this.f4318a.charAt(this.f);
    }

    public String d() {
        return this.f4318a;
    }

    public int e() {
        return this.g;
    }

    public int f() {
        return h() - this.f;
    }

    public g6 g() {
        return this.h;
    }

    public boolean i() {
        return this.f < h();
    }

    public void j() {
        this.g = -1;
    }

    public void k() {
        this.h = null;
    }

    public void l() {
        c(a());
    }

    public void c(int i) {
        g6 g6Var = this.h;
        if (g6Var == null || i > g6Var.a()) {
            this.h = g6.a(i, this.b, this.c, this.d, true);
        }
    }

    public void a(String str) {
        this.e.append(str);
    }

    public void a(char c) {
        this.e.append(c);
    }

    public int a() {
        return this.e.length();
    }
}
