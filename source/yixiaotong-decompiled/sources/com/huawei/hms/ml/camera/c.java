package com.huawei.hms.ml.camera;

import android.hardware.Camera;
import android.util.Log;

/* JADX INFO: compiled from: CameraExposureManager.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Camera f4129a;

    public synchronized void a(Camera camera) {
        this.f4129a = camera;
    }

    public synchronized CameraExposureData a() {
        return new CameraExposureData(this.f4129a.getParameters().getMaxExposureCompensation(), this.f4129a.getParameters().getMinExposureCompensation(), this.f4129a.getParameters().getExposureCompensation(), this.f4129a.getParameters().getExposureCompensationStep());
    }

    public synchronized void a(int i) {
        Camera camera = this.f4129a;
        if (camera == null) {
            return;
        }
        try {
            Camera.Parameters parameters = camera.getParameters();
            parameters.setExposureCompensation(i);
            this.f4129a.setParameters(parameters);
        } catch (RuntimeException unused) {
            Log.w(CameraManager.TAG, "CameraExposureManager::setCompensation failed");
        }
    }
}
