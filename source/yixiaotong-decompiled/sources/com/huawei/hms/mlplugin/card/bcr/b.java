package com.huawei.hms.mlplugin.card.bcr;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Point;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.ViewGroup;
import com.byazt.hv.TTDownloadField;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.huawei.hms.ml.camera.CameraConfig;
import com.huawei.hms.ml.camera.CameraManager;
import com.huawei.hms.ml.common.utils.SmartLog;
import com.huawei.hms.mlplugin.card.bcr.common.CustomInfo;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: compiled from: CaptureHelper.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class b implements CameraManager.CameraSizeListener {
    public static final String j = "b";
    private static final CountDownLatch k = new CountDownLatch(1);
    private static Point l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f4165a;
    private CustomView b;
    private CameraManager c;
    private SurfaceView d;
    private com.huawei.hms.mlplugin.card.bcr.a e;
    private SurfaceHolder.Callback f;
    private boolean g = false;
    private CustomInfo h;
    private CustomView.OnSnCheckRule i;

    /* JADX INFO: compiled from: CaptureHelper.java */
    class a implements SurfaceHolder.Callback {
        a() {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            if (b.this.g) {
                return;
            }
            b.this.g = true;
            if (b.this.a(surfaceHolder)) {
                return;
            }
            MLBcrCaptureResult mLBcrCaptureResult = new MLBcrCaptureResult();
            mLBcrCaptureResult.setErrorCode(MLBcrCaptureConfig.ERROR_CODE_INIT_CAMERA_FAILED);
            b.this.b.a(mLBcrCaptureResult);
            MLSnCaptureResult mLSnCaptureResult = new MLSnCaptureResult();
            mLSnCaptureResult.setErrorCode(MLBcrCaptureConfig.ERROR_CODE_INIT_CAMERA_FAILED);
            b.this.b.a(mLSnCaptureResult);
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            b.this.g = false;
        }
    }

    /* JADX INFO: renamed from: com.huawei.hms.mlplugin.card.bcr.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CaptureHelper.java */
    class RunnableC0527b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Point f4167a;

        RunnableC0527b(Point point) {
            this.f4167a = point;
        }

        @Override // java.lang.Runnable
        public void run() {
            Point pointA = t.a(b.this.f4165a);
            t.e(b.this.f4165a);
            Point point = this.f4167a;
            int i = point.x;
            int i2 = point.y;
            int width = b.this.b.getWidth();
            int height = b.this.b.getHeight();
            int i3 = pointA.y;
            if (height < i3) {
                height = i3;
            }
            int i4 = pointA.x;
            if (width < i4) {
                width = i4;
            }
            ViewGroup.LayoutParams layoutParams = b.this.b.getLayoutParams();
            float f = width;
            float f2 = height;
            float f3 = (f * 1.0f) / f2;
            float f4 = t.g(b.this.f4165a) ? (i * 1.0f) / i2 : (i2 * 1.0f) / i;
            SmartLog.d(b.j, "screenRate = " + f3 + " previewRate " + f4);
            if (f3 > f4) {
                height = (int) (f / f4);
            } else if (f3 < f4) {
                width = (int) (f2 * f4);
            }
            layoutParams.width = width;
            layoutParams.height = height;
            b.this.b.setLayoutParams(layoutParams);
            Point unused = b.l = new Point(width, height);
            b.k.countDown();
        }
    }

    public b(Context context, CustomView customView, SurfaceView surfaceView, CustomInfo customInfo, CustomView.OnSnCheckRule onSnCheckRule) {
        this.f4165a = context;
        this.b = customView;
        this.d = surfaceView;
        this.h = customInfo;
        this.i = onSnCheckRule;
    }

    public static Point h() {
        try {
            k.await();
            return l;
        } catch (InterruptedException unused) {
            SmartLog.i(j, "CaptureActivity::getAdapterSize InterruptedException occur");
            return null;
        }
    }

    private long i() {
        ActivityManager activityManager = (ActivityManager) this.f4165a.getSystemService(TTDownloadField.TT_ACTIVITY);
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return (memoryInfo.totalMem / 1024) / 1024;
    }

    public void e() {
        SurfaceHolder holder = this.d.getHolder();
        if (this.g) {
            a(holder);
        } else {
            holder.addCallback(this.f);
        }
    }

    @Override // com.huawei.hms.ml.camera.CameraManager.CameraSizeListener
    public void postPreviewSize(Point point) {
        this.b.post(new RunnableC0527b(point));
    }

    public void b() {
        if (i() < 1500) {
            this.c = new CameraManager(this.f4165a, b(this.f4165a));
        } else {
            this.c = new CameraManager(this.f4165a, a(this.f4165a));
        }
        this.c.setCameraSizeListener(this);
        this.f = new a();
    }

    public void d() {
        CameraManager cameraManager = this.c;
        if (cameraManager != null) {
            cameraManager.onPause();
        }
    }

    public void f() {
        CameraManager cameraManager = this.c;
        if (cameraManager != null) {
            if (cameraManager.getTorchStatus().equals(CameraConfig.CAMERA_TORCH_ON)) {
                this.c.setTorchStatus("off");
            } else {
                this.c.setTorchStatus(CameraConfig.CAMERA_TORCH_ON);
            }
        }
    }

    public void c() {
        com.huawei.hms.mlplugin.card.bcr.a aVar = this.e;
        if (aVar != null) {
            aVar.b();
            this.e = null;
        }
        this.c.onDestroy();
        this.c = null;
    }

    private CameraConfig a(Context context) {
        int rotation = ((Activity) context).getWindowManager().getDefaultDisplay().getRotation();
        Log.i(j, "initCameraConfig:false");
        if (rotation == 0) {
            return new CameraConfig.Factory().setCameraExpectSize(new Point(1920, 1080)).setCameraMode(1).setCameraOrientation(90).setRecordingHint(false).create();
        }
        if (rotation == 1) {
            return new CameraConfig.Factory().setCameraExpectSize(new Point(1920, 1080)).setCameraMode(1).setCameraOrientation(0).setRecordingHint(false).create();
        }
        if (rotation == 2) {
            return new CameraConfig.Factory().setCameraExpectSize(new Point(1920, 1080)).setCameraMode(1).setCameraOrientation(270).setRecordingHint(false).create();
        }
        if (rotation != 3) {
            return new CameraConfig.Factory().setCameraExpectSize(new Point(1920, 1080)).setCameraMode(1).setCameraOrientation(90).setRecordingHint(false).create();
        }
        return new CameraConfig.Factory().setCameraExpectSize(new Point(1920, 1080)).setCameraMode(1).setCameraOrientation(180).setRecordingHint(false).create();
    }

    private CameraConfig b(Context context) {
        int rotation = ((Activity) context).getWindowManager().getDefaultDisplay().getRotation();
        Log.i(j, "initCameraConfig:false");
        if (rotation == 0) {
            return new CameraConfig.Factory().setCameraExpectSize(new Point(960, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_HW_ERR_REASON)).setCameraMode(1).setCameraOrientation(90).setRecordingHint(false).create();
        }
        if (rotation == 1) {
            return new CameraConfig.Factory().setCameraExpectSize(new Point(960, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_HW_ERR_REASON)).setCameraMode(1).setCameraOrientation(0).setRecordingHint(false).create();
        }
        if (rotation == 2) {
            return new CameraConfig.Factory().setCameraExpectSize(new Point(960, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_HW_ERR_REASON)).setCameraMode(1).setCameraOrientation(270).setRecordingHint(false).create();
        }
        if (rotation != 3) {
            return new CameraConfig.Factory().setCameraExpectSize(new Point(960, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_HW_ERR_REASON)).setCameraMode(1).setCameraOrientation(90).setRecordingHint(false).create();
        }
        return new CameraConfig.Factory().setCameraExpectSize(new Point(960, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_HW_ERR_REASON)).setCameraMode(1).setCameraOrientation(180).setRecordingHint(false).create();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(SurfaceHolder surfaceHolder) {
        try {
            this.c.initCamera(surfaceHolder);
            this.c.preSetCameraCallback();
            com.huawei.hms.mlplugin.card.bcr.a aVar = this.e;
            if (aVar == null) {
                com.huawei.hms.mlplugin.card.bcr.a aVar2 = new com.huawei.hms.mlplugin.card.bcr.a(this.f4165a, this.c, this.b, this.h, this.i);
                this.e = aVar2;
                aVar2.a();
            } else {
                aVar.d();
            }
            if (CameraManager.CameraState.PREVIEW_STARTED == this.c.getCameraState()) {
                return true;
            }
            SmartLog.e(j, "CAMERA Preview Failed");
            return false;
        } catch (IOException unused) {
            SmartLog.e(j, "initCamera occur IOException");
            return false;
        } catch (Exception unused2) {
            SmartLog.e(j, "initCamera occur Exception");
            return false;
        }
    }

    public boolean a() {
        CameraManager cameraManager = this.c;
        if (cameraManager != null) {
            return cameraManager.getTorchStatus().equals(CameraConfig.CAMERA_TORCH_ON);
        }
        return false;
    }
}
