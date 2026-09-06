package com.oplus.log.f;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public abstract class b implements com.oplus.log.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f5828a = 1;
    private int b = 1;

    public int a() {
        return this.f5828a;
    }

    public void a(int i) {
        this.f5828a = i;
    }

    @Override // com.oplus.log.a
    public void a(String str, String str2) {
        a(str, str2, this.b != -1, (byte) 2);
    }

    @Override // com.oplus.log.a
    public void a(String str, String str2, boolean z) {
        a(str, str2, z, (byte) 2);
    }

    public abstract void a(String str, String str2, boolean z, byte b);

    public int b() {
        return this.b;
    }

    public void b(int i) {
        this.b = i;
    }

    @Override // com.oplus.log.a
    public void b(String str, String str2) {
        a(str, str2, this.b != -1, (byte) 4);
    }

    @Override // com.oplus.log.a
    public void b(String str, String str2, boolean z) {
        a(str, str2, z, (byte) 1);
    }

    public int c() {
        return 101;
    }

    @Override // com.oplus.log.a
    public void c(String str, String str2) {
        a(str, str2, this.b != -1, (byte) 5);
    }

    @Override // com.oplus.log.a
    public void c(String str, String str2, boolean z) {
        a(str, str2, z, (byte) 3);
    }

    @Override // com.oplus.log.a
    public void d(String str, String str2, boolean z) {
        a(str, str2, z, (byte) 4);
    }

    @Override // com.oplus.log.a
    public void e(String str, String str2, boolean z) {
        a(str, str2, z, (byte) 5);
    }
}
