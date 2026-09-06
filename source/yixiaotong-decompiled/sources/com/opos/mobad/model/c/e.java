package com.opos.mobad.model.c;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f7179a;
    private String b;
    private String c;

    public String a() {
        return this.f7179a;
    }

    public void a(String str) {
        this.f7179a = str;
    }

    public String b() {
        return this.b;
    }

    public void b(String str) {
        this.b = str;
    }

    public String c() {
        return this.c;
    }

    public void c(String str) {
        this.c = str;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return this.f7179a.equals(eVar.a()) && this.b.equals(eVar.b());
    }

    public int hashCode() {
        return this.f7179a.hashCode() * this.b.hashCode();
    }

    public String toString() {
        return "FetchMaterialEntity{url='" + this.f7179a + "', md5='" + this.b + "', savePath='" + this.c + "'}";
    }
}
