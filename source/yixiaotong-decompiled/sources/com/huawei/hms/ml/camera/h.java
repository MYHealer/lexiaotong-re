package com.huawei.hms.ml.camera;

import android.hardware.Camera;
import android.os.Handler;
import android.os.Message;

/* JADX INFO: compiled from: PictureCallbackProxy.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class h implements Camera.PictureCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CameraManager.ImageCallback f4136a;
    public g b;

    public h(g gVar, CameraManager.ImageCallback imageCallback) {
        this.f4136a = imageCallback;
        this.b = gVar;
    }

    @Override // android.hardware.Camera.PictureCallback
    public void onPictureTaken(byte[] bArr, Camera camera) {
        Handler handler = this.b.b;
        if (handler == null) {
            this.f4136a.onImage(bArr);
            return;
        }
        Message.obtain(handler, R.id.mlkit_camera_picture_ha_begin, CameraManager.CAMERA_MODULE_NAME).sendToTarget();
        this.f4136a.onImage(bArr);
        Message.obtain(handler, R.id.mlkit_camera_picture_ha_end).sendToTarget();
    }
}
