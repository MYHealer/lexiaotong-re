package com.huawei.hms.ml.camera;

import android.graphics.Rect;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class CameraMeteringData {
    public int maxNumMeteringAreas;
    public Rect meteringArea;

    public static class Area {
        public Rect rect;
        public int weight;

        public Area(Rect rect, int i) {
            this.rect = rect;
            this.weight = i;
        }
    }

    public CameraMeteringData(int i, Rect rect) {
        this.maxNumMeteringAreas = i;
        this.meteringArea = new Rect(rect);
    }

    public int getMaxNumMeteringAreas() {
        return this.maxNumMeteringAreas;
    }

    public Rect getMeteringArea() {
        return this.meteringArea;
    }
}
