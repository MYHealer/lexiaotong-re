package client.android.yixiaotong.sdk.qrcode.camera;

import android.hardware.Camera;
import android.util.Log;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class OpenCameraInterface {
    private static final String TAG = "client.android.yixiaotong.sdk.qrcode.camera.OpenCameraInterface";

    public static Camera open(int i) {
        int numberOfCameras = Camera.getNumberOfCameras();
        if (numberOfCameras == 0) {
            Log.w(TAG, "No cameras!");
            return null;
        }
        boolean z = i >= 0;
        if (!z) {
            i = 0;
            while (i < numberOfCameras) {
                Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                Camera.getCameraInfo(i, cameraInfo);
                if (cameraInfo.facing == 0) {
                    break;
                }
                i++;
            }
        }
        if (i < numberOfCameras) {
            Log.i(TAG, "Opening camera #" + i);
            return Camera.open(i);
        }
        if (z) {
            Log.w(TAG, "Requested camera does not exist: " + i);
            return null;
        }
        Log.i(TAG, "No camera facing back; returning camera #0");
        return Camera.open(0);
    }

    public static Camera open() {
        return open(-1);
    }
}
