package com.opos.exoplayer.core.f.f;

import android.text.Layout;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f6444a;
    private int b;
    private boolean c;
    private int d;
    private boolean e;
    private int f = -1;
    private int g = -1;
    private int h = -1;
    private int i = -1;
    private int j = -1;
    private float k;
    private String l;
    private b m;
    private Layout.Alignment n;

    private b a(b bVar, boolean z) {
        if (bVar != null) {
            if (!this.c && bVar.c) {
                a(bVar.b);
            }
            if (this.h == -1) {
                this.h = bVar.h;
            }
            if (this.i == -1) {
                this.i = bVar.i;
            }
            if (this.f6444a == null) {
                this.f6444a = bVar.f6444a;
            }
            if (this.f == -1) {
                this.f = bVar.f;
            }
            if (this.g == -1) {
                this.g = bVar.g;
            }
            if (this.n == null) {
                this.n = bVar.n;
            }
            if (this.j == -1) {
                this.j = bVar.j;
                this.k = bVar.k;
            }
            if (z && !this.e && bVar.e) {
                b(bVar.d);
            }
        }
        return this;
    }

    public int a() {
        int i = this.h;
        if (i == -1 && this.i == -1) {
            return -1;
        }
        return (i == 1 ? 1 : 0) | (this.i == 1 ? 2 : 0);
    }

    public b a(float f) {
        this.k = f;
        return this;
    }

    public b a(int i) {
        com.opos.exoplayer.core.i.a.b(this.m == null);
        this.b = i;
        this.c = true;
        return this;
    }

    public b a(Layout.Alignment alignment) {
        this.n = alignment;
        return this;
    }

    public b a(b bVar) {
        return a(bVar, true);
    }

    public b a(String str) {
        com.opos.exoplayer.core.i.a.b(this.m == null);
        this.f6444a = str;
        return this;
    }

    public b a(boolean z) {
        com.opos.exoplayer.core.i.a.b(this.m == null);
        this.f = z ? 1 : 0;
        return this;
    }

    public b b(int i) {
        this.d = i;
        this.e = true;
        return this;
    }

    public b b(String str) {
        this.l = str;
        return this;
    }

    public b b(boolean z) {
        com.opos.exoplayer.core.i.a.b(this.m == null);
        this.g = z ? 1 : 0;
        return this;
    }

    public boolean b() {
        return this.f == 1;
    }

    public b c(int i) {
        this.j = i;
        return this;
    }

    public b c(boolean z) {
        com.opos.exoplayer.core.i.a.b(this.m == null);
        this.h = z ? 1 : 0;
        return this;
    }

    public boolean c() {
        return this.g == 1;
    }

    public b d(boolean z) {
        com.opos.exoplayer.core.i.a.b(this.m == null);
        this.i = z ? 1 : 0;
        return this;
    }

    public String d() {
        return this.f6444a;
    }

    public int e() {
        if (this.c) {
            return this.b;
        }
        throw new IllegalStateException("Font color has not been defined.");
    }

    public boolean f() {
        return this.c;
    }

    public int g() {
        if (this.e) {
            return this.d;
        }
        throw new IllegalStateException("Background color has not been defined.");
    }

    public boolean h() {
        return this.e;
    }

    public String i() {
        return this.l;
    }

    public Layout.Alignment j() {
        return this.n;
    }

    public int k() {
        return this.j;
    }

    public float l() {
        return this.k;
    }
}
