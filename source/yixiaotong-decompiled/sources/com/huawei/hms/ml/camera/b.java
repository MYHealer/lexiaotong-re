package com.huawei.hms.ml.camera;

import android.graphics.Point;
import android.hardware.Camera;
import android.util.Log;
import java.util.List;

/* JADX INFO: compiled from: CameraConfigImpl.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CameraConfig f4128a;
    public Point b;
    public Point c;

    public void a(Camera camera, CameraConfig cameraConfig) {
        String str;
        CameraConfig cameraConfig2;
        if (camera == null || cameraConfig == null) {
            throw new IllegalArgumentException("initCameraParameters param is invalid");
        }
        Camera.Parameters parameters = camera.getParameters();
        this.f4128a = cameraConfig;
        int i = 0;
        this.b = a(parameters, cameraConfig.getCameraExpectSize(), false);
        Log.d(CameraManager.TAG, "initCameraParameters previewCameraSize: " + this.b.toString());
        if (cameraConfig.getCameraMode() == 0) {
            this.c = a(parameters, cameraConfig.getCameraExpectSize(), true);
            Log.d(CameraManager.TAG, "initCameraParameters pictureCameraSize: " + this.c.toString());
        }
        Point point = this.b;
        Point point2 = this.c;
        if (this.f4128a == null) {
            return;
        }
        Camera.Parameters parameters2 = camera.getParameters();
        parameters2.setPreviewSize(point.x, point.y);
        if (this.f4128a.getCameraMode() == 0) {
            parameters2.setPictureSize(point2.x, point2.y);
        }
        if (this.f4128a.getCameraFacing() != 1 && (cameraConfig2 = this.f4128a) != null) {
            String torchMode = cameraConfig2.getTorchMode();
            if (!torchMode.equals("off") && !torchMode.equals(CameraConfig.CAMERA_TORCH_ON)) {
                torchMode = "off";
            }
            parameters2.setFlashMode(torchMode);
        }
        String[] strArr = {"continuous-picture", "continuous-video", "auto"};
        List<String> supportedFocusModes = parameters2.getSupportedFocusModes();
        if (supportedFocusModes == null) {
            Log.w(CameraManager.TAG, "setFocusMode failed, use default");
        } else {
            while (true) {
                if (i >= 3) {
                    str = null;
                    break;
                }
                str = strArr[i];
                if (supportedFocusModes.contains(str)) {
                    break;
                } else {
                    i++;
                }
            }
            if (str != null) {
                Log.i(CameraManager.TAG, "setFocusMode: " + str);
                parameters2.setFocusMode(str);
            }
        }
        if (parameters2.isZoomSupported()) {
            parameters2.setZoom(1);
        } else {
            Log.w(CameraManager.TAG, "initCameraParameters::setDefaultZoom not support zoom");
        }
        if (this.f4128a.getRecordingHint()) {
            parameters2.setRecordingHint(true);
        }
        camera.setParameters(parameters2);
    }

    public final Point a(Camera.Parameters parameters, Point point, boolean z) {
        List<Camera.Size> supportedPictureSizes;
        if (!z) {
            supportedPictureSizes = parameters.getSupportedPreviewSizes();
        } else {
            supportedPictureSizes = parameters.getSupportedPictureSizes();
        }
        int i = 0;
        if (supportedPictureSizes != null && !supportedPictureSizes.isEmpty()) {
            double d = ((double) point.x) / ((double) point.y);
            double dAbs = Double.MAX_VALUE;
            int i2 = 0;
            for (Camera.Size size : supportedPictureSizes) {
                int i3 = size.width;
                int i4 = size.height;
                if (i3 == point.x && i4 == point.y) {
                    return new Point(i3, i4);
                }
                if (i3 * i4 >= 153600.0d) {
                    double d2 = (((double) i3) / ((double) i4)) - d;
                    if (Math.abs(d2) < dAbs) {
                        dAbs = Math.abs(d2);
                        i2 = i4;
                        i = i3;
                    }
                }
            }
            return new Point(i, i2);
        }
        Log.e(CameraManager.TAG, "CameraConfigImpl::findCameraResolution camera not support");
        return new Point(0, 0);
    }
}
