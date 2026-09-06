package com.huawei.hms.scankit.p;

import android.hardware.Camera;
import android.util.Log;
import com.huawei.hms.ml.camera.CameraManager;

/* JADX INFO: compiled from: CameraExposureManager.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Camera f4243a;

    public synchronized void a(Camera camera) {
        this.f4243a = camera;
    }

    public synchronized e0 a() {
        return new e0(this.f4243a.getParameters().getMaxExposureCompensation(), this.f4243a.getParameters().getMinExposureCompensation(), this.f4243a.getParameters().getExposureCompensation(), this.f4243a.getParameters().getExposureCompensationStep());
    }

    public synchronized void a(int i) {
        Camera camera = this.f4243a;
        if (camera == null) {
            return;
        }
        try {
            Camera.Parameters parameters = camera.getParameters();
            parameters.setExposureCompensation(i);
            Log.i("WWYYEHG", "setExpuseModeA: " + parameters.getAutoExposureLock());
            this.f4243a.setParameters(parameters);
            Log.i("WWYYEHG", "setExpuseModeB: " + parameters.getAutoExposureLock());
        } catch (RuntimeException unused) {
            Log.w(CameraManager.TAG, "CameraExposureManager::setCompensation failed");
        }
    }
}
