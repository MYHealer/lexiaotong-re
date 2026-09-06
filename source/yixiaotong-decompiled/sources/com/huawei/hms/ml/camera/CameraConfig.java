package com.huawei.hms.ml.camera;

import android.graphics.Point;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class CameraConfig {
    public static final int CAMERA_FACING_BACK = 0;
    public static final int CAMERA_FACING_FRONT = 1;
    public static final int CAMERA_FIRST_DEGREE = 0;
    public static final String CAMERA_FOCUS_AUTO = "auto";
    public static final String CAMERA_FOCUS_MACRO = "macro";
    public static final int CAMERA_FOURTH_DEGREE = 270;
    public static final int CAMERA_ID = 0;
    public static final int CAMERA_PICTURE_MODE = 0;
    public static final int CAMERA_PREVIEW_MULTI_SHOT = 2;
    public static final int CAMERA_PREVIEW_ONE_SHOT = 1;
    public static final int CAMERA_SECOND_DEGREE = 90;
    public static final int CAMERA_THIRD_DEGREE = 180;
    public static final String CAMERA_TORCH_OFF = "off";
    public static final String CAMERA_TORCH_ON = "torch";
    public Point cameraExpectSize;
    public int cameraFacing;
    public int cameraMode;
    public int cameraOrientation;
    public boolean isRecordingHint;
    public String torchMode;

    /* JADX INFO: renamed from: com.huawei.hms.ml.camera.CameraConfig$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class Factory {
        public Point screenSize;
        public int cameraFacing = 0;
        public int cameraMode = 1;
        public int cameraOrientation = 0;
        public String torchMode = "off";
        public boolean isRecordingHint = true;

        public CameraConfig create() {
            return new CameraConfig(this.cameraFacing, this.cameraMode, this.cameraOrientation, this.torchMode, this.screenSize, this.isRecordingHint, null);
        }

        public Factory setCameraExpectSize(Point point) {
            this.screenSize = point;
            return this;
        }

        public Factory setCameraFacing(int i) {
            this.cameraFacing = i;
            return this;
        }

        public Factory setCameraMode(int i) {
            this.cameraMode = i;
            return this;
        }

        public Factory setCameraOrientation(int i) {
            this.cameraOrientation = i;
            return this;
        }

        public Factory setRecordingHint(boolean z) {
            this.isRecordingHint = z;
            return this;
        }

        public Factory setTorchMode(String str) {
            this.torchMode = str;
            return this;
        }
    }

    public /* synthetic */ CameraConfig(int i, int i2, int i3, String str, Point point, boolean z, AnonymousClass1 anonymousClass1) {
        this(i, i2, i3, str, point, z);
    }

    public Point getCameraExpectSize() {
        return this.cameraExpectSize;
    }

    public int getCameraFacing() {
        return this.cameraFacing;
    }

    public int getCameraMode() {
        return this.cameraMode;
    }

    public int getCameraOrientation() {
        return this.cameraOrientation;
    }

    public boolean getRecordingHint() {
        return this.isRecordingHint;
    }

    public String getTorchMode() {
        return this.torchMode;
    }

    public void setCameraOrientation(int i) {
        this.cameraOrientation = i;
    }

    public CameraConfig(int i, int i2, int i3, String str, Point point, boolean z) {
        this.cameraFacing = i;
        this.cameraMode = i2;
        this.cameraOrientation = i3;
        this.torchMode = str;
        this.cameraExpectSize = point;
        this.isRecordingHint = z;
    }
}
