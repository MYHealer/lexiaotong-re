package com.hihonor.adsdk.common.e.f.a;

import android.graphics.Outline;
import android.graphics.Rect;
import android.graphics.RectF;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public abstract class a implements i {
    protected static final float hnadse = 2.0f;
    protected static final int hnadsf = 50;
    private d hnadsa;
    private Outline hnadsb = new Outline();
    private RectF hnadsc = new RectF();
    private float hnadsd;

    public a(d dVar) {
        this.hnadsa = dVar;
        dVar.hnadsf().getOutline(this.hnadsb);
        this.hnadsd = this.hnadsb.getRadius();
        Rect rect = new Rect();
        this.hnadsb.getRect(rect);
        this.hnadsc.right = rect.width();
        this.hnadsc.bottom = rect.height();
    }

    @Override // com.hihonor.adsdk.common.e.f.a.i
    public void hnadsa(float f) {
        this.hnadsd = f;
    }

    @Override // com.hihonor.adsdk.common.e.f.a.i
    public void hnadsa(float f, float f2) {
        RectF rectF = this.hnadsc;
        rectF.right = f;
        rectF.bottom = f2;
    }

    public int[] hnadsb() {
        return this.hnadsa.hnadsb();
    }

    public float[] hnadsc() {
        return this.hnadsa.hnadsc();
    }

    public int[] hnadsd() {
        return this.hnadsa.hnadsd();
    }

    public float hnadse() {
        return this.hnadsd;
    }

    public RectF hnadsf() {
        return this.hnadsc;
    }

    public int hnadsa() {
        return this.hnadsa.hnadsa();
    }
}
