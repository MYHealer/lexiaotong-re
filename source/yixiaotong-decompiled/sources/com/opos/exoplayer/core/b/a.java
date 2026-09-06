package com.opos.exoplayer.core.b;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f6271a;

    public void a() {
        this.f6271a = 0;
    }

    public final void a_(int i) {
        this.f6271a = i;
    }

    public final void b(int i) {
        this.f6271a = i | this.f6271a;
    }

    public final void c(int i) {
        this.f6271a = (~i) & this.f6271a;
    }

    public final boolean c() {
        return d(4);
    }

    public final boolean d() {
        return d(1);
    }

    protected final boolean d(int i) {
        return (this.f6271a & i) == i;
    }

    public final boolean d_() {
        return d(Integer.MIN_VALUE);
    }
}
