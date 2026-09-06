package client.android.yixiaotong.zbar;

import android.content.Context;
import android.graphics.Point;
import android.hardware.Camera;
import android.util.Log;
import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public final class CameraManager {
    private static final String TAG = "CameraManager";
    private Camera camera;
    private final CameraConfigurationManager configManager;
    private boolean initialized;

    public Camera getCamera() {
        return this.camera;
    }

    public CameraManager(Context context) {
        this.configManager = new CameraConfigurationManager(context);
    }

    public synchronized void openDriver() throws IOException {
        Camera cameraOpen = this.camera;
        if (cameraOpen == null) {
            cameraOpen = Camera.open();
            if (cameraOpen == null) {
                throw new IOException();
            }
            this.camera = cameraOpen;
        }
        if (!this.initialized) {
            this.initialized = true;
            this.configManager.initFromCameraParameters(cameraOpen);
        }
        Camera.Parameters parameters = cameraOpen.getParameters();
        String strFlatten = parameters == null ? null : parameters.flatten();
        try {
            this.configManager.setDesiredCameraParameters(cameraOpen, false);
        } catch (RuntimeException unused) {
            String str = TAG;
            Log.w(str, "Camera rejected parameters. Setting only minimal safe-mode parameters");
            Log.i(str, "Resetting to saved camera params: " + strFlatten);
            if (strFlatten != null) {
                Camera.Parameters parameters2 = cameraOpen.getParameters();
                parameters2.unflatten(strFlatten);
                try {
                    cameraOpen.setParameters(parameters2);
                    this.configManager.setDesiredCameraParameters(cameraOpen, true);
                } catch (RuntimeException unused2) {
                    Log.w(TAG, "Camera rejected even safe-mode parameters! No configuration");
                }
            }
        }
    }

    public synchronized boolean isOpen() {
        return this.camera != null;
    }

    public synchronized void closeDriver() {
        Camera camera = this.camera;
        if (camera != null) {
            camera.release();
            this.camera = null;
        }
    }

    public Point getCameraResolution() {
        return this.configManager.getCameraResolution();
    }
}
