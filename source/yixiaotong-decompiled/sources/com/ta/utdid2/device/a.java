package com.ta.utdid2.device;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class a {
    private String d = "";
    private String e = "";
    private String f = "";
    private String g = "";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f8536a = 0;
    private long b = 0;

    long a() {
        return this.f8536a;
    }

    void a(long j) {
        this.b = j;
    }

    void b(long j) {
        this.f8536a = j;
    }

    void b(String str) {
        this.d = str;
    }

    void c(String str) {
        this.e = str;
    }

    void d(String str) {
        this.f = str;
    }

    public String e() {
        return this.d;
    }

    void e(String str) {
        this.g = str;
    }

    public String f() {
        return this.g;
    }

    public String getDeviceId() {
        return this.f;
    }

    public String getImsi() {
        return this.e;
    }
}
