package com.huawei.hms.mlplugin.card.bcr;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.byazt.hv.TTDownloadField;
import com.huawei.hms.ml.camera.CameraManager;
import com.huawei.hms.ml.common.utils.SmartLog;
import com.huawei.hms.mlplugin.card.bcr.common.CustomInfo;
import com.huawei.hms.mlplugin.card.bcr.view.ViewfinderView;
import com.stub.StubApp;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class CaptureActivity extends Activity implements SurfaceHolder.Callback, CameraManager.CameraSizeListener {
    private static final String i = "CaptureActivity";
    private static final CountDownLatch j;
    private static Point k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private FrameLayout f4153a;
    private SurfaceView b;
    private ViewfinderView c;
    private CameraManager d;
    private com.huawei.hms.mlplugin.card.bcr.a e;
    private MLBcrCapture f;
    private boolean g = false;
    private c h;

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Point f4154a;

        a(Point point) {
            this.f4154a = point;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i;
            int i2;
            Point pointA = t.a(CaptureActivity.this);
            Point point = this.f4154a;
            int i3 = point.x;
            int i4 = point.y;
            SmartLog.d(CaptureActivity.i, "ScreenSize = " + pointA.x + " x " + pointA.y);
            SmartLog.d(CaptureActivity.i, "PreviewSize = " + i3 + " x " + i4);
            float f = (pointA.x * 1.0f) / pointA.y;
            float f2 = t.g(CaptureActivity.this) ? (i3 * 1.0f) / i4 : (i4 * 1.0f) / i3;
            if (f > f2) {
                i2 = pointA.x;
                i = (int) (i2 / f2);
            } else if (f < f2) {
                i = pointA.y;
                i2 = (int) (i * f2);
            } else {
                int i5 = pointA.x;
                i = pointA.y;
                i2 = i5;
            }
            SmartLog.d(CaptureActivity.i, "postPreviewSize fixWidth: " + i2);
            SmartLog.d(CaptureActivity.i, "postPreviewSize fixHeight: " + i);
            ViewGroup.LayoutParams layoutParams = CaptureActivity.this.f4153a.getLayoutParams();
            layoutParams.width = i2;
            layoutParams.height = i;
            CaptureActivity.this.f4153a.setLayoutParams(layoutParams);
            Point unused = CaptureActivity.k = new Point(i2, i);
            CaptureActivity.j.countDown();
            if (CaptureActivity.this.h == null) {
                CaptureActivity captureActivity = CaptureActivity.this;
                captureActivity.h = new c(captureActivity);
                CaptureActivity.this.h.start();
            }
        }
    }

    private static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        ViewfinderView f4155a;
        Point b;

        public b(ViewfinderView viewfinderView, Point point) {
            this.f4155a = viewfinderView;
            this.b = point;
        }

        @Override // java.lang.Runnable
        public void run() {
            SmartLog.w(CaptureActivity.i, "start to refresh view");
            this.f4155a.a(this.b);
            SmartLog.w(CaptureActivity.i, "refresh view end");
        }
    }

    private static final class c extends Thread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f4156a = true;
        private WeakReference<CaptureActivity> b;

        public c(CaptureActivity captureActivity) {
            this.b = new WeakReference<>(captureActivity);
        }

        private void b() {
            CaptureActivity captureActivity = this.b.get();
            if (captureActivity == null || captureActivity.isDestroyed()) {
                return;
            }
            ViewfinderView viewfinderView = captureActivity.c;
            Point pointB = t.b(captureActivity);
            int width = viewfinderView.getWidth();
            int height = viewfinderView.getHeight();
            if (width == pointB.x && height == pointB.y) {
                return;
            }
            captureActivity.runOnUiThread(new b(viewfinderView, pointB));
        }

        public void a() {
            this.f4156a = false;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (this.f4156a) {
                b();
                try {
                    Thread.sleep(50L);
                } catch (InterruptedException e) {
                    SmartLog.e("UIMonitorThread", "InterruptedException e = " + e.getMessage());
                }
            }
        }
    }

    public static Point d() {
        try {
            j.await();
            return k;
        } catch (InterruptedException unused) {
            SmartLog.i(i, "CaptureActivity::getAdapterSize InterruptedException occur");
            return null;
        }
    }

    private long e() {
        ActivityManager activityManager = (ActivityManager) getSystemService(TTDownloadField.TT_ACTIVITY);
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return (memoryInfo.totalMem / 1024) / 1024;
    }

    private void f() {
        this.f4153a = (FrameLayout) findViewById(R.id.fl_id);
        this.b = (SurfaceView) findViewById(R.id.IDpreview_view);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i3 != -1) {
            if (intent == null || intent.getIntExtra("com.huawei.hms.capture.ACTION", -1) != 32) {
                return;
            }
            this.f.a(-2);
            this.f.b();
            finish();
            return;
        }
        MLBcrCaptureResult mLBcrCaptureResult = new MLBcrCaptureResult();
        mLBcrCaptureResult.setNumber(intent.getStringExtra("number"));
        mLBcrCaptureResult.setExpire(intent.getStringExtra("expire"));
        mLBcrCaptureResult.a(intent.getStringExtra("owner"));
        mLBcrCaptureResult.setOriginalBitmap((Bitmap) intent.getParcelableExtra("originalBitmap"));
        mLBcrCaptureResult.setNumberBitmap((Bitmap) intent.getParcelableExtra("numberBitmap"));
        a(mLBcrCaptureResult);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.f.a(-2);
        this.f.b();
        super.onBackPressed();
    }

    @Override // android.app.Activity
    public native void onCreate(Bundle bundle);

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        this.d.onPause();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        SurfaceHolder holder = this.b.getHolder();
        if (this.g) {
            a(holder);
        } else {
            holder.addCallback(this);
        }
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        Point pointE = t.e(this);
        if (motionEvent.getAction() != 1 || !a(x, y, pointE)) {
            return false;
        }
        com.huawei.hms.mlplugin.card.bcr.a aVar = this.e;
        if (aVar != null) {
            aVar.c();
        }
        return true;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.g = false;
    }

    private void c() {
        ViewfinderView viewfinderView = new ViewfinderView(this, this.d);
        this.c = viewfinderView;
        viewfinderView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.f4153a.addView(this.c);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        com.huawei.hms.mlplugin.card.bcr.a aVar = this.e;
        if (aVar != null) {
            aVar.b();
            this.e = null;
        }
        this.f.a(false);
        this.d.onDestroy();
        this.d = null;
        super.onDestroy();
        c cVar = this.h;
        if (cVar != null) {
            cVar.a();
            this.h = null;
        }
    }

    static {
        StubApp.interface11(35011);
        j = new CountDownLatch(1);
    }

    public void b(MLBcrCaptureResult mLBcrCaptureResult) {
        this.f.a(-1);
        this.f.a(mLBcrCaptureResult);
        this.f.b();
        finish();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        if (this.g) {
            return;
        }
        this.g = true;
        a(surfaceHolder);
    }

    public void a(MLBcrCaptureResult mLBcrCaptureResult) {
        this.f.a(0);
        this.f.a(mLBcrCaptureResult);
        this.f.b();
        finish();
    }

    @Override // com.huawei.hms.ml.camera.CameraManager.CameraSizeListener
    public void postPreviewSize(Point point) {
        ViewfinderView viewfinderView = this.c;
        if (viewfinderView != null && this.f4153a != null) {
            viewfinderView.post(new a(point));
        } else {
            SmartLog.w(i, "postPreviewSize view not ready");
        }
    }

    private boolean a(float f, float f2, Point point) {
        return f <= ((float) (point.x * 8)) / 10.0f || f2 >= ((float) point.y) / 4.0f;
    }

    private void a(SurfaceHolder surfaceHolder) {
        try {
            this.d.initCamera(surfaceHolder);
            this.d.preSetCameraCallback();
            com.huawei.hms.mlplugin.card.bcr.a aVar = this.e;
            if (aVar == null) {
                com.huawei.hms.mlplugin.card.bcr.a aVar2 = new com.huawei.hms.mlplugin.card.bcr.a(this, this.d, null, new CustomInfo(false, null, 0, 1, 1), null);
                this.e = aVar2;
                aVar2.a();
            } else {
                aVar.d();
            }
            if (CameraManager.CameraState.PREVIEW_STARTED != this.d.getCameraState()) {
                SmartLog.e(i, "CAMERA Preview Failed");
                MLBcrCaptureResult mLBcrCaptureResult = new MLBcrCaptureResult();
                mLBcrCaptureResult.setErrorCode(MLBcrCaptureConfig.ERROR_CODE_INIT_CAMERA_FAILED);
                b(mLBcrCaptureResult);
            }
        } catch (IOException unused) {
            SmartLog.e(i, "initCamera occur IOException");
        } catch (Exception unused2) {
            SmartLog.e(i, "initCamera occur Exception");
        }
    }
}
