package com.adprof.sdk;

import android.graphics.PathMeasure;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class lf implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ pf f1286a;

    public lf(pf pfVar) {
        this.f1286a = pfVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        PathMeasure pathMeasure = new PathMeasure(this.f1286a.f574a, false);
        double length = pathMeasure.getLength();
        double width = this.f1286a.getWidth();
        this.f1286a.getClass();
        if (length > width * 0.0d) {
            Math.round((pathMeasure.getLength() / this.f1286a.getWidth()) * 100.0f);
            this.f1286a.f574a.reset();
            this.f1286a.postInvalidate();
        } else {
            this.f1286a.performClick();
        }
        this.f1286a.f574a.reset();
        this.f1286a.postInvalidate();
    }
}
