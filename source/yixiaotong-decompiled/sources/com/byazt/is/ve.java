package com.byazt.is;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
@com.byazt.zqa.c(c = {0, 1, 984, 54})
public class ve {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2349a;
    public int c;
    public long i;
    public int n;
    public int sp;
    public String x;
    public long tt = 0;
    public long ve = 0;
    public long uj = 0;
    public final long da = 30;

    public int a() {
        return this.sp;
    }

    public int c() {
        return this.c;
    }

    public void c(int i) {
        this.c = i;
    }

    public void c(long j) {
        this.tt = j;
    }

    public void c(String str) {
        this.x = str;
    }

    public int da() {
        return this.n;
    }

    public long i() {
        return this.uj;
    }

    public long n() {
        return 28L;
    }

    public int sl() {
        return this.f2349a;
    }

    public long sp() {
        return this.tt;
    }

    public String t() {
        return this.x;
    }

    public long tt() {
        long j = this.ve;
        return j > 0 ? j : this.uj;
    }

    public void tt(int i) {
        this.sp = i;
    }

    public void tt(long j) {
        this.ve = j;
    }

    public long u() {
        return this.i;
    }

    public long uj() {
        return ((long) this.n) + 30 + ((long) this.sp);
    }

    public void uj(int i) {
        this.f2349a = i;
    }

    public void uj(long j) {
        this.i = j;
    }

    public void ve(int i) {
        this.n = i;
    }

    public void ve(long j) {
        this.uj = j;
    }

    public long x() {
        return this.ve;
    }

    public long ve() {
        return uj() + tt();
    }
}
