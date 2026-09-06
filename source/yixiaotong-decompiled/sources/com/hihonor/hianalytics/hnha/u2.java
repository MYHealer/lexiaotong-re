package com.hihonor.hianalytics.hnha;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class u2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p0 f3689a;
    private int b = 0;
    private int c = 0;
    private int d = 0;
    private int e = 0;
    private int f = 0;
    private int g = 0;
    private int h = 0;
    private int i = 0;

    public u2(String str, int i) {
        this.f3689a = j.a(str, i);
    }

    public void a(boolean z) {
        if (z) {
            this.b = -1;
        } else {
            this.f = -1;
        }
    }

    public void a(boolean z, int i, int i2, int i3) {
        if (z) {
            this.b = 1;
            this.c = i;
            this.d = i2;
            this.e = i3;
            return;
        }
        this.f = 1;
        this.g = i;
        this.h = i2;
        this.i = i3;
    }

    public String toString() {
        return "KVMigrationDesc#" + hashCode() + "{tag=" + this.f3689a.b + ",type=" + this.f3689a.c + ",spState=(" + this.b + "," + this.c + "," + this.d + "," + this.e + "),mmkvState=(" + this.f + "," + this.g + "," + this.h + "," + this.i + ")}";
    }
}
