package com.adprof.sdk;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class rb extends fn.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Bitmap f1400a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ tb f703a;

    public rb(tb tbVar, Bitmap bitmap) {
        this.f703a = tbVar;
        this.f1400a = bitmap;
    }

    @Override // com.adprof.sdk.fn.a
    public void callback(Exception exc) {
        this.f703a.f1437a.a(this.f1400a);
    }
}
