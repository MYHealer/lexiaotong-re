package com.huawei.hms.ml.camera;

import android.content.Context;
import android.graphics.Point;
import android.hardware.Camera;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.TextureView;
import com.huawei.hms.mlkit.common.ha.HianalyticsLogProvider;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class CameraManager {
    public static final String CAMERA_MODULE_NAME = "MLKitCamera";
    public static final String TAG = "CameraManager";
    public d autoFocusManager;
    public Camera camera;
    public CameraSizeListener cameraSizeListener;
    public CameraStatusListener cameraStatusListener;
    public b configImpl;
    public c exposureManager;
    public g hiAnalyticsThread;
    public e meteringManager;
    public Camera.PictureCallback pictureCallback;
    public Camera.PreviewCallback previewCallback;
    public CameraConfig setting;
    public String torchStatus;
    public WeakReference<Context> weakContext;
    public f zoomManager;
    public CameraState cameraState = CameraState.CAMERA_CLOSED;
    public boolean isHiAnalyticsThreadStarted = false;
    public int lastDelayTime = -1;

    /* JADX INFO: renamed from: com.huawei.hms.ml.camera.CameraManager$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public interface CameraSizeListener {
        void postPreviewSize(Point point);
    }

    public enum CameraState {
        CAMERA_CLOSED(1),
        CAMERA_OPENED(2),
        CAMERA_INITIALED(3),
        PREVIEW_STARTED(4),
        PREVIEW_STOPPED(5);

        public final int value;

        CameraState(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }
    }

    public interface CameraStatusListener {
        void onClosed();

        void onFailed();

        void onOpened();
    }

    public interface FrameCallback {
        void onFrame(byte[] bArr);
    }

    public interface ImageCallback {
        void onImage(byte[] bArr);
    }

    public static class NativePreviewCallback implements Camera.PreviewCallback {
        public NativePreviewCallback() {
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
        }

        public /* synthetic */ NativePreviewCallback(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public CameraManager(Context context, CameraConfig cameraConfig) {
        if (context == null || cameraConfig == null) {
            throw new IllegalArgumentException("CameraManager constructor param invalid");
        }
        this.weakContext = new WeakReference<>(context);
        this.setting = cameraConfig;
        this.torchStatus = cameraConfig.getTorchMode();
        this.configImpl = new b();
        this.exposureManager = new c();
        this.zoomManager = new f();
        this.meteringManager = new e();
        this.hiAnalyticsThread = new g(context);
        initialHaTimer();
    }

    private void closeHaTimer() {
        if (HianalyticsLogProvider.getInstance().sdkForbiddenHiLog(this.weakContext.get())) {
            Log.w(TAG, "CameraManager::closeHaTimer failed");
            return;
        }
        HianalyticsLogProvider.getInstance().reportAndCancelTimer(CAMERA_MODULE_NAME);
        if (this.isHiAnalyticsThreadStarted) {
            Handler handler = this.hiAnalyticsThread.b;
            if (handler != null) {
                Message.obtain(handler, R.id.mlkit_camera_ha_quit).sendToTarget();
            }
            this.isHiAnalyticsThreadStarted = false;
        }
    }

    private int findCameraId(int i) {
        if (i != 0 && i != 1) {
            return 0;
        }
        int numberOfCameras = Camera.getNumberOfCameras();
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        for (int i2 = 0; i2 < numberOfCameras; i2++) {
            Camera.getCameraInfo(i2, cameraInfo);
            if (cameraInfo.facing == i) {
                Log.i(TAG, "findCameraId: " + i2);
                return i2;
            }
        }
        return 0;
    }

    private void initialHaTimer() {
        if (HianalyticsLogProvider.getInstance().sdkForbiddenHiLog(this.weakContext.get())) {
            Log.w(TAG, "CameraManager::initialHaTimer failed");
            return;
        }
        HianalyticsLogProvider.getInstance().initTimer(CAMERA_MODULE_NAME);
        if (this.isHiAnalyticsThreadStarted) {
            return;
        }
        this.hiAnalyticsThread.start();
        this.isHiAnalyticsThreadStarted = true;
    }

    public synchronized void captureImage() {
        if (this.setting.getCameraMode() != 0) {
            Log.w(TAG, "CameraManager::captureImage camera mode is not CAMERA_PICTURE_MODE");
            return;
        }
        if (this.cameraState != CameraState.PREVIEW_STARTED) {
            Log.w(TAG, "CameraManager::captureImage camera is not start preview yet");
            return;
        }
        Camera camera = this.camera;
        if (camera != null) {
            camera.takePicture(null, null, this.pictureCallback);
        }
        this.cameraState = CameraState.PREVIEW_STOPPED;
    }

    public synchronized CameraExposureData getCameraExposureData() {
        if (this.camera == null || this.cameraState.getValue() == CameraState.CAMERA_CLOSED.getValue()) {
            return null;
        }
        try {
            return this.exposureManager.a();
        } catch (Exception unused) {
            Log.e(TAG, "CameraManager::getCameraExposureData failed");
            return null;
        }
    }

    public synchronized String getCameraFocusMode() {
        if (this.camera != null && this.cameraState.getValue() != CameraState.CAMERA_CLOSED.getValue()) {
            return this.camera.getParameters().getFocusMode();
        }
        return null;
    }

    public synchronized CameraMeteringData getCameraMeteringData() {
        if (this.camera != null && this.cameraState.getValue() != CameraState.CAMERA_CLOSED.getValue()) {
            return this.meteringManager.a();
        }
        return null;
    }

    public synchronized int getCameraOrientation() {
        return this.setting.getCameraOrientation();
    }

    public synchronized CameraState getCameraState() {
        return this.cameraState;
    }

    public synchronized CameraZoomData getCameraZoomData() {
        if (this.camera != null && this.cameraState.getValue() != CameraState.CAMERA_CLOSED.getValue()) {
            return this.zoomManager.a();
        }
        return null;
    }

    public synchronized String getTorchStatus() {
        return this.torchStatus;
    }

    public synchronized void initCamera(SurfaceHolder surfaceHolder) throws IOException {
        try {
            if (surfaceHolder == null) {
                throw new IllegalArgumentException("CameraManager::initCamera SurfaceHolder is null");
            }
            if (this.cameraState.getValue() != CameraState.CAMERA_OPENED.getValue()) {
                Log.w(TAG, "CameraManager::initCamera camera is not opened yet");
                onResume();
            }
            this.exposureManager.a(this.camera);
            this.zoomManager.a(this.camera);
            this.meteringManager.a(this.camera);
            Camera camera = this.camera;
            if (camera != null) {
                camera.setPreviewDisplay(surfaceHolder);
            }
            this.configImpl.a(this.camera, this.setting);
            Camera camera2 = this.camera;
            if (camera2 != null) {
                camera2.setDisplayOrientation(this.setting.getCameraOrientation());
                Log.i(TAG, "CameraManagerSetDisplayOrientation : " + this.setting.getCameraOrientation());
            }
            CameraSizeListener cameraSizeListener = this.cameraSizeListener;
            if (cameraSizeListener != null) {
                cameraSizeListener.postPreviewSize(this.configImpl.b);
            }
            this.cameraState = CameraState.CAMERA_INITIALED;
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void initScanCamera(SurfaceHolder surfaceHolder) throws IOException {
        initCamera(surfaceHolder);
    }

    public synchronized boolean isSupportZoom() {
        return this.zoomManager.b();
    }

    public synchronized void onDestroy() {
        closeHaTimer();
        this.cameraSizeListener = null;
    }

    public synchronized void onPause() {
        try {
            if (this.cameraState.getValue() == CameraState.PREVIEW_STARTED.getValue()) {
                cancelAutoFocus();
                stopPreview();
                this.cameraState = CameraState.PREVIEW_STOPPED;
            }
            if (getTorchStatus().equals(CameraConfig.CAMERA_TORCH_ON)) {
                setTorchStatus("off");
            }
            if (this.cameraState.getValue() >= CameraState.CAMERA_OPENED.getValue()) {
                this.cameraState = CameraState.CAMERA_CLOSED;
                Camera camera = this.camera;
                if (camera != null) {
                    camera.release();
                    this.camera = null;
                }
                CameraStatusListener cameraStatusListener = this.cameraStatusListener;
                if (cameraStatusListener != null) {
                    cameraStatusListener.onClosed();
                }
            }
        } catch (RuntimeException unused) {
            Log.e(TAG, "CameraManager::onPause failed");
        }
    }

    public synchronized void onResume() {
        CameraState cameraState = this.cameraState;
        if (cameraState == CameraState.CAMERA_CLOSED || cameraState == CameraState.PREVIEW_STOPPED) {
            try {
                this.camera = Camera.open(findCameraId(this.setting.getCameraFacing()));
            } catch (RuntimeException e) {
                Log.e(TAG, "CameraManager::Camera open failed, " + e.getMessage());
            }
            if (this.camera == null) {
                Log.e(TAG, "CameraManager::initCamera failed");
                CameraStatusListener cameraStatusListener = this.cameraStatusListener;
                if (cameraStatusListener != null) {
                    cameraStatusListener.onFailed();
                }
            } else {
                CameraStatusListener cameraStatusListener2 = this.cameraStatusListener;
                if (cameraStatusListener2 != null) {
                    cameraStatusListener2.onOpened();
                }
                this.cameraState = CameraState.CAMERA_OPENED;
            }
        }
    }

    public synchronized void preSetCameraCallback() {
        Camera camera;
        if (this.cameraState.getValue() < CameraState.CAMERA_OPENED.getValue()) {
            return;
        }
        if (this.setting.getCameraMode() != 0 && (camera = this.camera) != null) {
            camera.setPreviewCallback(new NativePreviewCallback(null));
        }
    }

    public synchronized void refreshCameraOrientation(int i) {
        if (this.setting != null && this.camera != null && this.cameraState.getValue() >= CameraState.CAMERA_OPENED.getValue()) {
            Log.i(TAG, "CameraManager  refreshCameraOrientation");
            this.setting.setCameraOrientation(i);
            this.camera.setDisplayOrientation(i);
        }
    }

    public synchronized void requestFocus(int i) {
        if (this.cameraState != CameraState.PREVIEW_STARTED) {
            Log.w(TAG, "CameraManager::requestFocus camera is not start preview yet");
            return;
        }
        if (i == this.lastDelayTime) {
            return;
        }
        this.lastDelayTime = i;
        d dVar = this.autoFocusManager;
        if (dVar == null) {
            d dVar2 = new d(this.camera);
            this.autoFocusManager = dVar2;
            dVar2.a(i);
            this.autoFocusManager.d();
        } else {
            dVar.a(i);
        }
    }

    public synchronized void requestPreviewFrame() {
        if (this.setting.getCameraMode() == 1) {
            Log.d(TAG, "CameraManager::requestPreviewFrame PREVIEW_ONE_SHOT");
            if (this.cameraState == CameraState.PREVIEW_STOPPED) {
                return;
            }
            Camera camera = this.camera;
            if (camera != null) {
                camera.setOneShotPreviewCallback(this.previewCallback);
            }
        } else if (this.setting.getCameraMode() == 0) {
            Log.d(TAG, "CameraManager::requestPreviewFrame PICTURE_MODE");
            if (this.cameraState == CameraState.PREVIEW_STOPPED) {
                startPreview();
            }
        } else if (this.setting.getCameraMode() == 2) {
            Log.d(TAG, "CameraManager::requestPreviewFrame PREVIEW_MULTI_SHOT");
            if (this.cameraState == CameraState.PREVIEW_STOPPED) {
                return;
            }
            Camera camera2 = this.camera;
            if (camera2 != null) {
                camera2.setPreviewCallback(this.previewCallback);
            }
        } else {
            Log.w(TAG, "CameraManager::requestPreviewFrame unknown mode");
        }
    }

    public synchronized void setCameraExposureValue(int i) {
        if (this.camera != null && this.cameraState.getValue() != CameraState.CAMERA_CLOSED.getValue()) {
            this.exposureManager.a(i);
        }
    }

    public synchronized void setCameraMeteringArea(List<CameraMeteringData.Area> list) {
        if (this.camera != null && this.cameraState.getValue() != CameraState.CAMERA_CLOSED.getValue()) {
            this.meteringManager.a(list);
        }
    }

    public synchronized void setCameraSizeListener(CameraSizeListener cameraSizeListener) {
        try {
            if (cameraSizeListener == null) {
                throw new IllegalArgumentException("CameraManager::setCameraSizeListener param invalid");
            }
            this.cameraSizeListener = cameraSizeListener;
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void setCameraStatusListener(CameraStatusListener cameraStatusListener) {
        try {
            if (cameraStatusListener == null) {
                throw new IllegalArgumentException("CameraManager::setCameraStatusListener param invalid");
            }
            this.cameraStatusListener = cameraStatusListener;
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void setCameraZoomValue(int i) {
        if (this.camera != null && this.cameraState.getValue() != CameraState.CAMERA_CLOSED.getValue()) {
            this.zoomManager.a(i);
        }
    }

    public synchronized void setFrameCallback(FrameCallback frameCallback) {
        try {
            if (frameCallback == null) {
                throw new IllegalArgumentException("CameraManager::setFrameCallback param invalid");
            }
            this.previewCallback = new i(this.hiAnalyticsThread, frameCallback);
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void setImageCallback(ImageCallback imageCallback) {
        try {
            if (imageCallback == null) {
                throw new IllegalArgumentException("CameraManager::setImageCallback param invalid");
            }
            this.pictureCallback = new h(this.hiAnalyticsThread, imageCallback);
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void setTorchStatus(String str) {
        try {
            if (this.camera != null && this.cameraState.getValue() != CameraState.CAMERA_CLOSED.getValue()) {
                if ("off".equals(str) || CameraConfig.CAMERA_TORCH_ON.equals(str)) {
                    Camera.Parameters parameters = this.camera.getParameters();
                    parameters.setFlashMode(str);
                    this.camera.setParameters(parameters);
                    this.torchStatus = str;
                }
            }
        } catch (RuntimeException unused) {
            Log.w(TAG, "CameraManager::setTorchStatus error");
        }
    }

    public synchronized void startPreview() {
        try {
            if (this.cameraState.getValue() < CameraState.CAMERA_INITIALED.getValue()) {
                Log.w(TAG, "CameraManager::startPreview camera is not initialed yet");
                return;
            }
            Camera camera = this.camera;
            if (camera != null) {
                camera.startPreview();
                this.cameraState = CameraState.PREVIEW_STARTED;
            }
        } catch (RuntimeException unused) {
            Log.w(TAG, "stopPreview error");
        }
    }

    public synchronized void stopPreview() {
        try {
            if (this.cameraState.getValue() < CameraState.PREVIEW_STARTED.getValue()) {
                Log.w(TAG, "CameraManager::startPreview camera is not startPreview yet");
                return;
            }
            Camera camera = this.camera;
            if (camera != null) {
                camera.setPreviewCallback(null);
                this.camera.stopPreview();
                this.cameraState = CameraState.PREVIEW_STOPPED;
            }
        } catch (RuntimeException unused) {
            Log.w(TAG, "stopPreview error");
        }
    }

    public synchronized void cancelAutoFocus() {
        d dVar = this.autoFocusManager;
        if (dVar != null) {
            dVar.e();
            this.autoFocusManager = null;
        }
    }

    public synchronized Point getCameraSize() {
        return this.configImpl.b;
    }

    public synchronized void initCamera(TextureView textureView) throws IOException {
        try {
            if (textureView != null) {
                if (this.cameraState.getValue() != CameraState.CAMERA_OPENED.getValue()) {
                    Log.w(TAG, "CameraManager::initCamera camera is not opened yet");
                    onResume();
                }
                this.exposureManager.a(this.camera);
                this.zoomManager.a(this.camera);
                this.meteringManager.a(this.camera);
                Camera camera = this.camera;
                if (camera != null) {
                    camera.setPreviewTexture(textureView.getSurfaceTexture());
                }
                this.configImpl.a(this.camera, this.setting);
                Camera camera2 = this.camera;
                if (camera2 != null) {
                    camera2.setDisplayOrientation(this.setting.getCameraOrientation());
                }
                CameraSizeListener cameraSizeListener = this.cameraSizeListener;
                if (cameraSizeListener != null) {
                    cameraSizeListener.postPreviewSize(this.configImpl.b);
                }
                this.cameraState = CameraState.CAMERA_INITIALED;
            } else {
                throw new IllegalArgumentException("CameraManager::initCamera SurfaceHolder is null");
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
