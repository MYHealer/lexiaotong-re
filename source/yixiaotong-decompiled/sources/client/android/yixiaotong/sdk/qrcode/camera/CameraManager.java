package client.android.yixiaotong.sdk.qrcode.camera;

import android.content.Context;
import android.graphics.Point;
import android.hardware.Camera;
import android.os.Handler;
import android.util.Log;
import android.view.SurfaceHolder;
import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class CameraManager {
    private static final String TAG = "CameraManager";
    private AutoFocusManager autoFocusManager;
    private Camera camera;
    private final CameraConfigurationManager configManager;
    private final Context context;
    private boolean initialized;
    private final PreviewCallback previewCallback;
    private boolean previewing;
    private int requestedCameraId = -1;

    public CameraManager(Context context) {
        this.context = context;
        CameraConfigurationManager cameraConfigurationManager = new CameraConfigurationManager(context);
        this.configManager = cameraConfigurationManager;
        this.previewCallback = new PreviewCallback(cameraConfigurationManager);
    }

    public synchronized void openDriver(SurfaceHolder surfaceHolder) throws IOException {
        Camera cameraOpen = this.camera;
        if (cameraOpen == null) {
            int i = this.requestedCameraId;
            if (i >= 0) {
                cameraOpen = OpenCameraInterface.open(i);
            } else {
                cameraOpen = OpenCameraInterface.open();
            }
            if (cameraOpen == null) {
                throw new IOException();
            }
            this.camera = cameraOpen;
        }
        cameraOpen.setPreviewDisplay(surfaceHolder);
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

    public synchronized void startPreview() {
        Camera camera = this.camera;
        if (camera != null && !this.previewing) {
            camera.startPreview();
            this.previewing = true;
            this.autoFocusManager = new AutoFocusManager(this.context, this.camera);
        }
    }

    public synchronized void stopPreview() {
        AutoFocusManager autoFocusManager = this.autoFocusManager;
        if (autoFocusManager != null) {
            autoFocusManager.stop();
            this.autoFocusManager = null;
        }
        Camera camera = this.camera;
        if (camera != null && this.previewing) {
            camera.stopPreview();
            this.previewCallback.setHandler(null, 0);
            this.previewing = false;
        }
    }

    public synchronized void requestPreviewFrame(Handler handler, int i) {
        Camera camera = this.camera;
        if (camera != null && this.previewing) {
            this.previewCallback.setHandler(handler, i);
            camera.setOneShotPreviewCallback(this.previewCallback);
        }
    }

    public synchronized void setManualCameraId(int i) {
        this.requestedCameraId = i;
    }

    public Point getCameraResolution() {
        return this.configManager.getCameraResolution();
    }

    public Camera.Size getPreviewSize() {
        Camera camera = this.camera;
        if (camera != null) {
            return camera.getParameters().getPreviewSize();
        }
        return null;
    }
}
