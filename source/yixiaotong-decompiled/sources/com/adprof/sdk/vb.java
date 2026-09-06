package com.adprof.sdk;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class vb extends fn.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Bitmap f1477a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ xb.a f764a;

    public vb(xb.a aVar, Bitmap bitmap) {
        this.f764a = aVar;
        this.f1477a = bitmap;
    }

    @Override // com.adprof.sdk.fn.a
    public void callback(Exception exc) {
        this.f764a.f1521a.setImageBitmap(this.f1477a);
    }
}
