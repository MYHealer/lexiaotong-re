package com.huawei.hms.ml.camera;

import android.hardware.Camera;
import android.util.Log;
import java.util.ArrayList;

/* JADX INFO: compiled from: CameraZoomManager.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Camera f4133a;

    public synchronized void a(Camera camera) {
        this.f4133a = camera;
    }

    public synchronized boolean b() {
        Camera camera = this.f4133a;
        if (camera == null) {
            return false;
        }
        return camera.getParameters().isZoomSupported();
    }

    public synchronized CameraZoomData a() {
        return new CameraZoomData(this.f4133a.getParameters().getMaxZoom(), this.f4133a.getParameters().getZoom(), this.f4133a.getParameters().getZoomRatios() != null ? this.f4133a.getParameters().getZoomRatios() : new ArrayList<>());
    }

    public synchronized void a(int i) {
        Camera camera = this.f4133a;
        if (camera == null) {
            return;
        }
        Camera.Parameters parameters = camera.getParameters();
        parameters.setZoom(i);
        try {
            this.f4133a.setParameters(parameters);
        } catch (RuntimeException e) {
            Log.e(CameraManager.TAG, "CameraZoomManager::setCameraZoomIndex failed: " + e.getMessage());
        }
    }
}
