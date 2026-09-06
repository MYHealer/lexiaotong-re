package com.huawei.hms.scankit.p;

import android.hardware.Camera;

/* JADX INFO: compiled from: PreviewCallbackProxy.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class k5 implements Camera.PreviewCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private g0.e f4295a;

    public k5(g0.e eVar) {
        this.f4295a = eVar;
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        this.f4295a.a(bArr);
    }
}
