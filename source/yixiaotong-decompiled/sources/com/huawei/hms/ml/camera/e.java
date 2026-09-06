package com.huawei.hms.ml.camera;

import android.graphics.Rect;
import android.hardware.Camera;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: CameraMeteringManager.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Camera f4132a;

    public synchronized void a(Camera camera) {
        this.f4132a = camera;
    }

    public synchronized CameraMeteringData a() {
        Rect rect;
        int maxNumMeteringAreas;
        RuntimeException e;
        rect = null;
        try {
            maxNumMeteringAreas = this.f4132a.getParameters().getMaxNumMeteringAreas();
            try {
                if (this.f4132a.getParameters().getMeteringAreas() != null) {
                    rect = this.f4132a.getParameters().getMeteringAreas().get(0).rect;
                }
            } catch (RuntimeException e2) {
                e = e2;
                Log.w(CameraManager.TAG, "CameraMeteringManager::getCameraMeteringData failed: " + e.getMessage());
            }
        } catch (RuntimeException e3) {
            maxNumMeteringAreas = 0;
            e = e3;
        }
        return new CameraMeteringData(maxNumMeteringAreas, rect);
    }

    public synchronized void a(List<CameraMeteringData.Area> list) {
        Camera camera = this.f4132a;
        if (camera == null) {
            return;
        }
        Camera.Parameters parameters = camera.getParameters();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            arrayList.add(new Camera.Area(list.get(i).rect, list.get(i).weight));
        }
        parameters.setMeteringAreas(arrayList);
        try {
            this.f4132a.setParameters(parameters);
        } catch (RuntimeException e) {
            Log.w(CameraManager.TAG, "CameraMeteringManager::setCameraMeteringArea failed: " + e.getMessage());
        }
    }
}
