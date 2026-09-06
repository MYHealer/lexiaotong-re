package com.huawei.hms.scankit.p;

import android.graphics.Point;
import android.hardware.Camera;
import android.os.Build;
import android.util.Log;
import com.huawei.hms.ml.camera.CameraConfig;
import com.huawei.hms.ml.camera.CameraManager;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/* JADX INFO: compiled from: CameraConfigImpl.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private c0 f4231a;
    private Point b;
    private Point c;

    private void b(Camera.Parameters parameters) {
        if (parameters.isZoomSupported()) {
            parameters.setZoom(1);
        } else {
            Log.w(CameraManager.TAG, "initCameraParameters::setDefaultZoom not support zoom");
        }
    }

    private void c(Camera.Parameters parameters) {
        String str;
        String[] strArr = {"continuous-picture", "continuous-video", "auto"};
        List<String> supportedFocusModes = parameters.getSupportedFocusModes();
        if (supportedFocusModes == null) {
            Log.w(CameraManager.TAG, "setFocusMode failed, use default");
            return;
        }
        int i = 0;
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
            parameters.setFocusMode(str);
        }
    }

    Point a() {
        return this.b;
    }

    void a(Camera camera, c0 c0Var) {
        if (camera == null || c0Var == null) {
            throw new IllegalArgumentException("initCameraParameters param is invalid");
        }
        Camera.Parameters parameters = camera.getParameters();
        this.f4231a = c0Var;
        this.b = a(parameters, c0Var.a(), false);
        Log.d(CameraManager.TAG, "initCameraParameters previewCameraSize: " + this.b.toString());
        if (c0Var.c() == 0) {
            this.c = a(parameters, c0Var.a(), true);
            Log.d(CameraManager.TAG, "initCameraParameters pictureCameraSize: " + this.c.toString());
        }
        a(camera, this.b, this.c);
    }

    private void a(Camera camera, Point point, Point point2) {
        if (this.f4231a == null) {
            return;
        }
        Camera.Parameters parameters = camera.getParameters();
        parameters.setPreviewSize(point.x, point.y);
        if (this.f4231a.c() == 0) {
            parameters.setPictureSize(point2.x, point2.y);
        }
        if (this.f4231a.b() != 1) {
            a(parameters);
        }
        c(parameters);
        b(parameters);
        if (this.f4231a.e()) {
            parameters.setRecordingHint(true);
        }
        if (Build.VERSION.SDK_INT >= 30) {
            a(parameters, true);
        }
        camera.setParameters(parameters);
    }

    public static void a(Camera.Parameters parameters, boolean z) {
        try {
            Method method = Camera.Parameters.class.getMethod("setScanOptEnable", Boolean.TYPE);
            if (method != null) {
                method.invoke(parameters, Boolean.valueOf(z));
                Log.i(CameraManager.TAG, "setScanOptEnable isOpt " + z);
            }
        } catch (IllegalAccessException unused) {
            Log.e(CameraManager.TAG, "setScanOptEnable reflection IllegalAccessException");
        } catch (NoSuchMethodException unused2) {
            Log.e(CameraManager.TAG, "setScanOptEnable reflection NoSuchMethodException");
        } catch (InvocationTargetException unused3) {
            Log.e(CameraManager.TAG, "setScanOptEnable reflection InvocationTargetException");
        } catch (Exception unused4) {
            Log.e(CameraManager.TAG, "setScanOptEnable reflection Exception");
        }
    }

    private Point a(Camera.Parameters parameters, Point point, boolean z) {
        List<Camera.Size> supportedPictureSizes;
        if (!z) {
            supportedPictureSizes = parameters.getSupportedPreviewSizes();
        } else {
            supportedPictureSizes = parameters.getSupportedPictureSizes();
        }
        if (supportedPictureSizes != null && !supportedPictureSizes.isEmpty()) {
            return a(supportedPictureSizes, point);
        }
        Log.e(CameraManager.TAG, "CameraConfigImpl::findCameraResolution camera not support");
        return new Point(0, 0);
    }

    private Point a(List<Camera.Size> list, Point point) {
        double d = ((double) point.x) / ((double) point.y);
        int i = 0;
        double dAbs = Double.MAX_VALUE;
        int i2 = 0;
        for (Camera.Size size : list) {
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

    private void a(Camera.Parameters parameters) {
        c0 c0Var = this.f4231a;
        if (c0Var == null) {
            return;
        }
        String strF = c0Var.f();
        if (!strF.equals("off") && !strF.equals(CameraConfig.CAMERA_TORCH_ON)) {
            strF = "off";
        }
        parameters.setFlashMode(strF);
    }
}
