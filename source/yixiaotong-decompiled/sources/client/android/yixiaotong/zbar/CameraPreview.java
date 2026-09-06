package client.android.yixiaotong.zbar;

import android.content.Context;
import android.hardware.Camera;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class CameraPreview extends SurfaceView implements SurfaceHolder.Callback {
    private Camera.AutoFocusCallback autoFocusCallback;
    private Camera mCamera;
    private SurfaceHolder mHolder;
    private Camera.PreviewCallback previewCallback;

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
    }

    public CameraPreview(Context context, Camera camera, Camera.PreviewCallback previewCallback, Camera.AutoFocusCallback autoFocusCallback) {
        super(context);
        this.mCamera = camera;
        this.previewCallback = previewCallback;
        this.autoFocusCallback = autoFocusCallback;
        SurfaceHolder holder = getHolder();
        this.mHolder = holder;
        holder.addCallback(this);
        this.mHolder.setType(3);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        try {
            this.mCamera.setPreviewDisplay(surfaceHolder);
        } catch (IOException e) {
            Log.d("DBG", "Error setting camera preview: " + e.getMessage());
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (this.mHolder.getSurface() == null) {
            return;
        }
        try {
            this.mCamera.stopPreview();
        } catch (Exception unused) {
        }
        try {
            this.mCamera.setDisplayOrientation(90);
            this.mCamera.setPreviewDisplay(this.mHolder);
            this.mCamera.setPreviewCallback(this.previewCallback);
            this.mCamera.startPreview();
            this.mCamera.autoFocus(this.autoFocusCallback);
        } catch (Exception e) {
            Log.d("DBG", "Error starting camera preview: " + e.getMessage());
        }
    }
}
