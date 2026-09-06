package com.huawei.hms.scankit.p;

import android.hardware.Camera;
import android.util.Log;
import com.huawei.hms.ml.camera.CameraManager;

/* JADX INFO: compiled from: CameraZoomManager.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Camera f4289a;

    public synchronized void a(Camera camera) {
        this.f4289a = camera;
    }

    public synchronized boolean b() {
        Camera camera = this.f4289a;
        if (camera == null) {
            return false;
        }
        return camera.getParameters().isZoomSupported();
    }

    public synchronized j0 a() {
        return new j0(this.f4289a.getParameters().getMaxZoom(), this.f4289a.getParameters().getZoom(), this.f4289a.getParameters().getZoomRatios());
    }

    public synchronized void a(int i) {
        Camera camera = this.f4289a;
        if (camera == null) {
            return;
        }
        Camera.Parameters parameters = camera.getParameters();
        parameters.setZoom(i);
        try {
            this.f4289a.setParameters(parameters);
        } catch (RuntimeException e) {
            Log.e(CameraManager.TAG, "CameraZoomManager::setCameraZoomIndex failed: " + e.getMessage());
        }
    }
}
