package com.huawei.hms.scankit.p;

import android.graphics.Rect;
import android.hardware.Camera;
import android.util.Log;
import com.huawei.hms.ml.camera.CameraManager;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: CameraMeteringManager.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Camera f4272a;

    public synchronized void a(Camera camera) {
        this.f4272a = camera;
    }

    public synchronized h0 a() {
        int maxNumMeteringAreas;
        RuntimeException e;
        Rect rect;
        try {
            maxNumMeteringAreas = this.f4272a.getParameters().getMaxNumMeteringAreas();
            try {
                rect = this.f4272a.getParameters().getMeteringAreas().get(0).rect;
            } catch (RuntimeException e2) {
                e = e2;
                Log.w(CameraManager.TAG, "CameraMeteringManager::getCameraMeteringData failed: " + e.getMessage());
                rect = null;
            }
        } catch (RuntimeException e3) {
            maxNumMeteringAreas = 0;
            e = e3;
        }
        return new h0(maxNumMeteringAreas, rect);
    }

    public synchronized void a(List<h0.a> list) {
        Camera camera = this.f4272a;
        if (camera == null) {
            return;
        }
        Camera.Parameters parameters = camera.getParameters();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            arrayList.add(new Camera.Area(list.get(i).f4266a, list.get(i).b));
        }
        parameters.setMeteringAreas(arrayList);
        try {
            this.f4272a.setParameters(parameters);
        } catch (RuntimeException e) {
            Log.w(CameraManager.TAG, "CameraMeteringManager::setCameraMeteringArea failed: " + e.getMessage());
        }
    }
}
