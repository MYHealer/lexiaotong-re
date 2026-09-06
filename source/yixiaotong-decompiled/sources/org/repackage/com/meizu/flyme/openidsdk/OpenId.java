package org.repackage.com.meizu.flyme.openidsdk;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
class OpenId {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    long f9722a;
    String b;
    String c;
    int d;

    OpenId(String str) {
        this.c = str;
    }

    void a(int i) {
        this.d = i;
    }

    void a(long j) {
        this.f9722a = j;
    }

    void a(String str) {
        this.b = str;
    }

    boolean a() {
        return this.f9722a > System.currentTimeMillis();
    }

    void b() {
        this.f9722a = 0L;
    }
}
