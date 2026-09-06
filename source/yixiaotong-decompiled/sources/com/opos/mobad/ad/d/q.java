package com.opos.mobad.ad.d;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6647a;
    public String b;

    public q(int i, String str) {
        this.f6647a = i;
        this.b = str;
    }

    public void a(int i) {
        this.f6647a = i;
    }

    public void a(String str) {
        this.b = str;
    }

    public String toString() {
        return "NativeAdError{code=" + this.f6647a + ", msg='" + this.b + "'}";
    }
}
