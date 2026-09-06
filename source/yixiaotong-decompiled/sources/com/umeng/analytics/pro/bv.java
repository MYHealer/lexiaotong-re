package com.umeng.analytics.pro;

/* JADX INFO: compiled from: TProtocolException.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class bv extends bb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f9133a = 0;
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 3;
    public static final int e = 4;
    public static final int f = 5;
    private static final long h = 1;
    protected int g;

    public int a() {
        return this.g;
    }

    public bv() {
        this.g = 0;
    }

    public bv(int i) {
        this.g = i;
    }

    public bv(int i, String str) {
        super(str);
        this.g = i;
    }

    public bv(String str) {
        super(str);
        this.g = 0;
    }

    public bv(int i, Throwable th) {
        super(th);
        this.g = i;
    }

    public bv(Throwable th) {
        super(th);
        this.g = 0;
    }

    public bv(String str, Throwable th) {
        super(str, th);
        this.g = 0;
    }

    public bv(int i, String str, Throwable th) {
        super(str, th);
        this.g = i;
    }
}
