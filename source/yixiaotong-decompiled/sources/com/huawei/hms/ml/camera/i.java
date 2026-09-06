package com.huawei.hms.ml.camera;

import android.hardware.Camera;
import android.os.Handler;
import android.os.Message;

/* JADX INFO: compiled from: PreviewCallbackProxy.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class i implements Camera.PreviewCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CameraManager.FrameCallback f4137a;
    public g b;

    public i(g gVar, CameraManager.FrameCallback frameCallback) {
        this.f4137a = frameCallback;
        this.b = gVar;
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        Handler handler = this.b.b;
        if (handler == null) {
            this.f4137a.onFrame(bArr);
            return;
        }
        Message.obtain(handler, R.id.mlkit_camera_preview_ha_begin, CameraManager.CAMERA_MODULE_NAME).sendToTarget();
        this.f4137a.onFrame(bArr);
        Message.obtain(handler, R.id.mlkit_camera_preview_ha_end).sendToTarget();
    }
}
