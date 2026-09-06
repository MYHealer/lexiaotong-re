package com.huawei.hms.scankit.p;

/* JADX INFO: compiled from: Patch.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class h5 implements Comparable<h5> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public y1 f4270a;
    public int b;

    public h5(y1 y1Var, int i) {
        this.f4270a = y1Var;
        this.b = i;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(h5 h5Var) {
        return Float.compare((-h5Var.f4270a.g()) + h5Var.f4270a.h(), (-this.f4270a.g()) + this.f4270a.h());
    }
}
