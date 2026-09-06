package client.android.yixiaotong.sdk.qrcode;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import client.android.yixiaotong.sdk.R;
import client.android.yixiaotong.sdk.qrcode.camera.CameraManager;
import client.android.yixiaotong.sdk.qrcode.decode.DecodeThread;
import client.android.yixiaotong.sdk.qrcode.utils.IActivityHandler;
import client.android.yixiaotong.sdk.qrcode.utils.InactivityTimer;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.google.zxing.Result;
import com.stub.StubApp;
import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class CaptureActivity extends Activity implements SurfaceHolder.Callback, IActivityHandler {
    private static final String TAG = "CaptureActivity";
    private CaptureActivityHandler handler;
    private TranslateAnimation mAnimation;
    private CameraManager mCameraManager;
    private InactivityTimer mInactivityTimer;
    private RelativeLayout scanContainer;
    private RelativeLayout scanCropView;
    private ImageView scanLine;
    private SurfaceView scanPreview = null;
    private Rect mCropRect = null;
    private boolean isHasSurface = false;

    static {
        StubApp.interface11(AVMDLDataLoader.KeyIsMaxFileMemCacheSize);
    }

    @Override // client.android.yixiaotong.sdk.qrcode.utils.IActivityHandler
    public CameraManager getCameraManager() {
        return this.mCameraManager;
    }

    @Override // client.android.yixiaotong.sdk.qrcode.utils.IActivityHandler
    public Rect getCropRect() {
        return this.mCropRect;
    }

    @Override // client.android.yixiaotong.sdk.qrcode.utils.IActivityHandler
    public Handler getHandler() {
        return this.handler;
    }

    @Override // android.app.Activity
    protected native void onCreate(Bundle bundle);

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.isHasSurface = false;
    }

    public static void launch(Activity activity, int i) {
        if (activity != null) {
            activity.startActivityForResult(new Intent(activity, (Class<?>) CaptureActivity.class), i);
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mCameraManager = new CameraManager(getApplication());
        this.handler = null;
        if (this.isHasSurface) {
            initCamera(this.scanPreview.getHolder());
        } else {
            this.scanPreview.getHolder().addCallback(this);
        }
        this.mInactivityTimer.onResume();
    }

    @Override // android.app.Activity
    protected void onPause() {
        CaptureActivityHandler captureActivityHandler = this.handler;
        if (captureActivityHandler != null) {
            captureActivityHandler.quitSynchronously();
            this.handler = null;
        }
        this.mInactivityTimer.onPause();
        this.mCameraManager.closeDriver();
        if (!this.isHasSurface) {
            this.scanPreview.getHolder().removeCallback(this);
        }
        super.onPause();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        this.mInactivityTimer.shutdown();
        super.onDestroy();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        if (surfaceHolder == null) {
            Log.e(TAG, "*** WARNING *** surfaceCreated() gave us a null surface!");
        }
        if (this.isHasSurface) {
            return;
        }
        this.isHasSurface = true;
        initCamera(surfaceHolder);
    }

    @Override // client.android.yixiaotong.sdk.qrcode.utils.IActivityHandler
    public void handleDecode(Result result, Bundle bundle) {
        this.mInactivityTimer.onActivity();
        Intent intent = new Intent();
        intent.putExtra("data", result.getText());
        setResult(-1, intent);
        finish();
    }

    private void initCamera(SurfaceHolder surfaceHolder) {
        if (surfaceHolder == null) {
            throw new IllegalStateException("No SurfaceHolder provided");
        }
        if (this.mCameraManager.isOpen()) {
            Log.w(TAG, "initCamera() while already open -- late SurfaceView callback?");
            return;
        }
        try {
            this.mCameraManager.openDriver(surfaceHolder);
            if (this.handler == null) {
                this.handler = new CaptureActivityHandler(this, this.mCameraManager, DecodeThread.ALL_MODE);
            }
            initCrop();
        } catch (IOException e) {
            Log.w(TAG, e);
            displayFrameworkBugMessageAndExit();
        } catch (RuntimeException e2) {
            Log.w(TAG, "Unexpected error initializing camera", e2);
            displayFrameworkBugMessageAndExit();
        }
    }

    private void displayFrameworkBugMessageAndExit() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("提示");
        builder.setMessage("相机打开出错，请稍后重试");
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() { // from class: client.android.yixiaotong.sdk.qrcode.CaptureActivity.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        builder.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: client.android.yixiaotong.sdk.qrcode.CaptureActivity.2
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
            }
        });
        builder.show();
    }

    public void restartPreviewAfterDelay(long j) {
        CaptureActivityHandler captureActivityHandler = this.handler;
        if (captureActivityHandler != null) {
            captureActivityHandler.sendEmptyMessageDelayed(R.id.restart_preview, j);
        }
    }

    private void initCrop() {
        int i = this.mCameraManager.getCameraResolution().y;
        int i2 = this.mCameraManager.getCameraResolution().x;
        int[] iArr = new int[2];
        this.scanCropView.getLocationInWindow(iArr);
        int i3 = iArr[0];
        int statusBarHeight = iArr[1] - getStatusBarHeight();
        int width = this.scanCropView.getWidth();
        int height = this.scanCropView.getHeight();
        int width2 = this.scanContainer.getWidth();
        int height2 = this.scanContainer.getHeight();
        int i4 = (i3 * i) / width2;
        int i5 = (statusBarHeight * i2) / height2;
        this.mCropRect = new Rect(i4, i5, ((width * i) / width2) + i4, ((height * i2) / height2) + i5);
    }

    private int getStatusBarHeight() {
        try {
            Class<?> cls = Class.forName("com.android.internal.R$dimen");
            return getResources().getDimensionPixelSize(Integer.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString()));
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
