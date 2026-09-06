package com.huawei.hms.mlplugin.card.bcr;

import com.huawei.hms.ml.camera.CameraManager;

/* JADX INFO: compiled from: PreviewCallback.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class d implements CameraManager.FrameCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private g f4169a;

    public d(g gVar) {
        this.f4169a = gVar;
    }

    @Override // com.huawei.hms.ml.camera.CameraManager.FrameCallback
    public void onFrame(byte[] bArr) {
        this.f4169a.a().obtainMessage(R.id.mlkit_bcr_decode, bArr).sendToTarget();
    }
}
