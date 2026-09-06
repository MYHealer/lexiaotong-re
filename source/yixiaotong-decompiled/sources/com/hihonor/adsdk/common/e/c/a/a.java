package com.hihonor.adsdk.common.e.c.a;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
abstract class a {
    protected int hnadsa;
    protected int hnadsb;
    protected float hnadsc;
    protected float hnadsd;
    protected int hnadse;
    protected int hnadsf;
    protected int hnadsg;
    protected int hnadsh;
    protected int hnadsi;
    protected float hnadsj;
    protected int hnadsk = -1;
    protected int hnadsl = 0;
    protected int hnadsm = 0;

    a() {
    }

    public abstract float hnadsa(int i);

    public abstract int hnadsa();

    public void hnadsa(int i, int i2, float f) {
        this.hnadsa = i;
        this.hnadsb = i2;
        this.hnadsc = f;
    }

    public void hnadsa(int i, int i2, int i3) {
        this.hnadsk = i;
        this.hnadsl = i2;
        this.hnadsm = i3;
    }

    public abstract int hnadsb();

    public void hnadsb(int i) {
        this.hnadsg = i;
    }

    public abstract int hnadsc();

    public abstract void hnadsd();

    public void hnadsa(int i, int i2, int i3, int i4, int i5) {
        this.hnadse = i;
        this.hnadsf = i2;
        this.hnadsg = i3;
        this.hnadsh = i4;
        this.hnadsi = i5;
        hnadsd();
    }
}
