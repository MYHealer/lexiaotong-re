package com.ubix.ssp.ad.e.s.g;

import java.io.File;
import java.io.Serializable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f8855a;
    private File b;
    private int c;
    private b d;
    private com.ubix.ssp.ad.e.s.j.a e;
    private int f = 0;

    public a(String str, File file, String str2, int i) {
        this.f8855a = str;
        this.b = file;
        this.c = i;
        b bVar = new b();
        this.d = bVar;
        bVar.b(str2);
        this.d.d(f() + "");
        this.d.a(g());
        this.d.c(a().getAbsolutePath());
    }

    public File a() {
        return this.b;
    }

    public void a(int i) {
        this.f = i;
    }

    public void a(b bVar) {
        this.d = bVar;
    }

    public void a(com.ubix.ssp.ad.e.s.j.a aVar) {
        this.e = aVar;
    }

    public b b() {
        return this.d;
    }

    public com.ubix.ssp.ad.e.s.j.a c() {
        return this.e;
    }

    public int d() {
        return this.c;
    }

    public int e() {
        return this.f;
    }

    public int f() {
        return this.f8855a.hashCode();
    }

    public String g() {
        return this.f8855a;
    }

    public String toString() {
        return "DownloadInfo{url='" + this.f8855a + "', file=" + this.b + '}';
    }
}
