package com.huawei.hms.ml.camera;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class CameraZoomData {
    public List<Integer> allZoomRations;
    public int currentZoom;
    public int maxZoom;

    public CameraZoomData(int i, int i2, List<Integer> list) {
        this.maxZoom = i;
        this.currentZoom = i2;
        this.allZoomRations = new ArrayList(list);
    }

    public List<Integer> getAllZoomRations() {
        return this.allZoomRations;
    }

    public int getCurrentZoomIndex() {
        return this.currentZoom;
    }

    public int getMaxZoomIndex() {
        return this.maxZoom;
    }
}
