package com.hihonor.adsdk.common.e.f.a;

import android.content.res.Resources;
import android.graphics.drawable.shapes.Shape;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class d {
    private Shape hnadsa;
    private int[] hnadsb;
    private float[] hnadsc;
    private int[] hnadsd;
    private int hnadse;
    private Resources hnadsf;

    public int hnadsa() {
        return this.hnadse;
    }

    public void hnadsa(int i) {
        this.hnadse = i;
    }

    public void hnadsa(Resources resources) {
        this.hnadsf = resources;
    }

    public void hnadsa(Shape shape) {
        this.hnadsa = shape;
    }

    public void hnadsa(float[] fArr) {
        this.hnadsc = fArr;
    }

    public void hnadsa(int[] iArr) {
        this.hnadsb = iArr;
    }

    public void hnadsb(int[] iArr) {
        this.hnadsd = iArr;
    }

    public int[] hnadsb() {
        return this.hnadsb;
    }

    public float[] hnadsc() {
        return this.hnadsc;
    }

    public int[] hnadsd() {
        return this.hnadsd;
    }

    public Resources hnadse() {
        return this.hnadsf;
    }

    public Shape hnadsf() {
        return this.hnadsa;
    }
}
