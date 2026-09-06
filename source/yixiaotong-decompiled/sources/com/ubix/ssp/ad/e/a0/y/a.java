package com.ubix.ssp.ad.e.a0.y;

import java.io.Serializable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a implements Comparable<a>, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private double f8734a;
    private double b;
    private double c;
    private double d;

    public a(double d, double d2, double d3, double d4) {
        this.f8734a = d;
        this.b = d2;
        this.c = d3;
        this.d = d4;
    }

    public double a() {
        return this.c * this.d;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(a aVar) {
        return Double.compare(a(), aVar.a());
    }

    public double b() {
        return this.c;
    }

    public double c() {
        return this.d;
    }

    public double d() {
        return this.f8734a;
    }

    public double e() {
        return this.b;
    }
}
