package com.huawei.hms.ml.camera;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class CameraExposureData {
    public float compensationStep;
    public int currentValue;
    public int maxValue;
    public int minValue;

    public CameraExposureData(int i, int i2, int i3, float f) {
        this.maxValue = i;
        this.minValue = i2;
        this.currentValue = i3;
        this.compensationStep = f;
    }

    public float getCompensationStep() {
        return this.compensationStep;
    }

    public int getCurrentValue() {
        return this.currentValue;
    }

    public int getMaxValue() {
        return this.maxValue;
    }

    public int getMinValue() {
        return this.minValue;
    }
}
