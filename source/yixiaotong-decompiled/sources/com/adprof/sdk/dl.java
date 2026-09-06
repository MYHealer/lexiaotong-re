package com.adprof.sdk;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public final class dl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1133a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public dl f224a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f225a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final byte[] f226a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public dl f227b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f228b;

    public dl() {
        this.f226a = new byte[8192];
        this.f228b = true;
        this.f225a = false;
    }

    public dl(byte[] bArr, int i, int i2) {
        this.f226a = bArr;
        this.f1133a = i;
        this.b = i2;
        this.f228b = false;
        this.f225a = true;
    }

    public dl a() {
        dl dlVar = this.f224a;
        dl dlVar2 = dlVar != this ? dlVar : null;
        dl dlVar3 = this.f227b;
        dlVar3.f224a = dlVar;
        this.f224a.f227b = dlVar3;
        this.f224a = null;
        this.f227b = null;
        return dlVar2;
    }

    public dl a(dl dlVar) {
        dlVar.f227b = this;
        dlVar.f224a = this.f224a;
        this.f224a.f227b = dlVar;
        this.f224a = dlVar;
        return dlVar;
    }
}
