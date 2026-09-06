package com.huawei.hms.scankit.p;

import android.content.Context;
import android.graphics.Point;
import android.hardware.Camera;
import android.util.Log;
import android.view.TextureView;
import com.huawei.hms.ml.camera.CameraConfig;
import com.huawei.hms.ml.camera.CameraManager;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.List;

/* JADX INFO: compiled from: CameraManager.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private c0 f4250a;
    private d b;
    private b c;
    private Camera.PreviewCallback d;
    private WeakReference<Context> e;
    private f0 f;
    private k0 g;
    private i0 h;
    private Camera i;
    private d0 j;
    private String k;
    private c l = c.CAMERA_CLOSED;
    private int m = -1;

    /* JADX INFO: compiled from: CameraManager.java */
    static /* synthetic */ class a {
    }

    /* JADX INFO: compiled from: CameraManager.java */
    public interface b {
        void a(Point point);
    }

    /* JADX INFO: compiled from: CameraManager.java */
    public enum c {
        CAMERA_CLOSED(1),
        CAMERA_OPENED(2),
        CAMERA_INITIALED(3),
        PREVIEW_STARTED(4),
        PREVIEW_STOPPED(5);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f4251a;

        c(int i) {
            this.f4251a = i;
        }

        public int a() {
            return this.f4251a;
        }
    }

    /* JADX INFO: compiled from: CameraManager.java */
    public interface d {
        void a();

        void b();

        void c();
    }

    /* JADX INFO: compiled from: CameraManager.java */
    public interface e {
        void a(byte[] bArr);
    }

    /* JADX INFO: compiled from: CameraManager.java */
    private static class f implements Camera.PreviewCallback {
        private f() {
        }

        /* synthetic */ f(a aVar) {
            this();
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
        }
    }

    public g0(Context context, c0 c0Var) {
        if (context == null || c0Var == null) {
            throw new IllegalArgumentException("CameraManager constructor param invalid");
        }
        this.e = new WeakReference<>(context);
        this.f4250a = c0Var;
        this.k = c0Var.f();
        this.j = new d0();
        this.f = new f0();
        this.g = new k0();
        this.h = new i0();
    }

    public synchronized void a() {
    }

    public synchronized void a(e eVar) {
        try {
            if (eVar == null) {
                throw new IllegalArgumentException("CameraManager::setFrameCallback param invalid");
            }
            this.d = new k5(eVar);
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized e0 b() {
        if (this.i == null || this.l.a() == c.CAMERA_CLOSED.a()) {
            return null;
        }
        try {
            return this.f.a();
        } catch (Exception unused) {
            Log.e(CameraManager.TAG, "CameraManager::getCameraExposureData failed");
            return null;
        }
    }

    public synchronized void c(int i) {
        if (this.i != null && this.l.a() != c.CAMERA_CLOSED.a()) {
            this.f.a(i);
        }
    }

    public synchronized void d(int i) {
        if (this.i != null && this.l.a() != c.CAMERA_CLOSED.a()) {
            this.g.a(i);
        }
    }

    public synchronized Point e() {
        return this.j.a();
    }

    public synchronized c f() {
        return this.l;
    }

    public synchronized j0 g() {
        if (this.i != null && this.l.a() != c.CAMERA_CLOSED.a()) {
            return this.g.a();
        }
        return null;
    }

    public synchronized String h() {
        return this.k;
    }

    public synchronized boolean i() {
        return this.i != null && this.l.a() >= c.CAMERA_OPENED.a();
    }

    public synchronized boolean j() {
        return this.g.b();
    }

    public synchronized void k() {
        this.c = null;
    }

    public synchronized void l() {
        try {
            if (this.l.a() == c.PREVIEW_STARTED.a()) {
                a();
                q();
                this.l = c.PREVIEW_STOPPED;
            }
            if (h().equals(CameraConfig.CAMERA_TORCH_ON)) {
                a("off");
            }
            if (this.l.a() >= c.CAMERA_OPENED.a()) {
                this.l = c.CAMERA_CLOSED;
                Camera camera = this.i;
                if (camera != null) {
                    camera.setPreviewCallback(null);
                    this.i.stopPreview();
                    this.i.release();
                    this.i = null;
                }
                d dVar = this.b;
                if (dVar != null) {
                    dVar.c();
                }
            }
        } catch (RuntimeException unused) {
            Log.e(CameraManager.TAG, "CameraManager::onPause failed");
        }
    }

    public synchronized void m() {
        c cVar = this.l;
        if (cVar == c.CAMERA_CLOSED || cVar == c.PREVIEW_STOPPED) {
            int iA = a(this.f4250a.b());
            Log.i(CameraManager.TAG, "onResume: " + iA);
            try {
                this.i = Camera.open(iA);
            } catch (RuntimeException e2) {
                Log.e(CameraManager.TAG, "CameraManager::Camera open failed, " + e2.getMessage());
            }
            if (this.i == null) {
                Log.e(CameraManager.TAG, "CameraManager::initCamera failed");
                d dVar = this.b;
                if (dVar != null) {
                    dVar.b();
                }
            } else {
                d dVar2 = this.b;
                if (dVar2 != null) {
                    dVar2.a();
                }
                this.l = c.CAMERA_OPENED;
            }
        }
    }

    public synchronized void n() {
        Camera camera;
        if (this.l.a() < c.CAMERA_OPENED.a()) {
            return;
        }
        if (this.f4250a.c() != 0 && (camera = this.i) != null) {
            camera.setPreviewCallback(new f(null));
        }
    }

    public synchronized void o() {
        if (this.f4250a.c() == 1) {
            Log.d(CameraManager.TAG, "CameraManager::requestPreviewFrame PREVIEW_ONE_SHOT");
            if (this.l == c.PREVIEW_STOPPED) {
                return;
            }
            Camera camera = this.i;
            if (camera != null) {
                camera.setOneShotPreviewCallback(this.d);
            }
        } else if (this.f4250a.c() == 0) {
            Log.d(CameraManager.TAG, "CameraManager::requestPreviewFrame PICTURE_MODE");
            if (this.l == c.PREVIEW_STOPPED) {
                p();
            }
        } else if (this.f4250a.c() == 2) {
            Log.d(CameraManager.TAG, "CameraManager::requestPreviewFrame PREVIEW_MULTI_SHOT");
            if (this.l == c.PREVIEW_STOPPED) {
                return;
            }
            Camera camera2 = this.i;
            if (camera2 != null) {
                camera2.setPreviewCallback(this.d);
            }
        } else {
            Log.w(CameraManager.TAG, "CameraManager::requestPreviewFrame unknown mode");
        }
    }

    public synchronized void p() {
        try {
            if (this.l.a() < c.CAMERA_INITIALED.a()) {
                Log.w(CameraManager.TAG, "CameraManager::startPreview camera is not initialed yet");
                return;
            }
            Camera camera = this.i;
            if (camera != null) {
                camera.startPreview();
                this.l = c.PREVIEW_STARTED;
            }
        } catch (RuntimeException unused) {
            Log.w(CameraManager.TAG, "stopPreview error");
        }
    }

    public synchronized void q() {
        try {
            if (this.l.a() < c.PREVIEW_STARTED.a()) {
                Log.w(CameraManager.TAG, "CameraManager::startPreview camera is not startPreview yet");
                return;
            }
            Camera camera = this.i;
            if (camera != null) {
                camera.setPreviewCallback(null);
                this.i.stopPreview();
                this.l = c.PREVIEW_STOPPED;
            }
        } catch (RuntimeException unused) {
            Log.w(CameraManager.TAG, "stopPreview error");
        }
    }

    public synchronized void a(d dVar) {
        try {
            if (dVar == null) {
                throw new IllegalArgumentException("CameraManager::setCameraStatusListener param invalid");
            }
            this.b = dVar;
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void a(TextureView textureView) throws IOException {
        try {
            if (textureView != null) {
                if (this.l.a() != c.CAMERA_OPENED.a()) {
                    Log.w(CameraManager.TAG, "CameraManager::initCamera camera is not opened yet");
                    m();
                }
                this.f.a(this.i);
                this.g.a(this.i);
                this.h.a(this.i);
                Camera camera = this.i;
                if (camera != null) {
                    camera.setPreviewTexture(textureView.getSurfaceTexture());
                }
                this.j.a(this.i, this.f4250a);
                Camera camera2 = this.i;
                if (camera2 != null) {
                    camera2.setDisplayOrientation(this.f4250a.d());
                }
                b bVar = this.c;
                if (bVar != null) {
                    bVar.a(this.j.a());
                }
                this.l = c.CAMERA_INITIALED;
            } else {
                throw new IllegalArgumentException("CameraManager::initCamera SurfaceHolder is null");
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized h0 c() {
        if (this.i != null && this.l.a() != c.CAMERA_CLOSED.a()) {
            return this.h.a();
        }
        return null;
    }

    public synchronized int d() {
        return this.f4250a.d();
    }

    public synchronized void b(int i) {
        if (this.f4250a != null && this.i != null && this.l.a() >= c.CAMERA_OPENED.a()) {
            this.f4250a.a(i);
            try {
                try {
                    this.i.setDisplayOrientation(i);
                } catch (RuntimeException unused) {
                    Log.e(CameraManager.TAG, "setDisplayOrientation RuntimeException");
                }
            } catch (Exception unused2) {
                Log.e(CameraManager.TAG, "setDisplayOrientation Exception");
            }
        }
    }

    public synchronized void a(String str) {
        try {
            if (this.i != null && this.l.a() != c.CAMERA_CLOSED.a()) {
                if ("off".equals(str) || CameraConfig.CAMERA_TORCH_ON.equals(str)) {
                    Camera.Parameters parameters = this.i.getParameters();
                    parameters.setFlashMode(str);
                    this.i.setParameters(parameters);
                    this.k = str;
                }
            }
        } catch (RuntimeException unused) {
            Log.w(CameraManager.TAG, "CameraManager::setTorchStatus error");
        }
    }

    public synchronized void a(List<h0.a> list) {
        if (this.i != null && this.l.a() != c.CAMERA_CLOSED.a()) {
            this.h.a(list);
        }
    }

    private int a(int i) {
        if (i != 0 && i != 1) {
            return 0;
        }
        try {
            int numberOfCameras = Camera.getNumberOfCameras();
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            for (int i2 = 0; i2 < numberOfCameras; i2++) {
                Camera.getCameraInfo(i2, cameraInfo);
                if (cameraInfo.facing == i) {
                    Log.i(CameraManager.TAG, "findCameraId: " + i2);
                    return i2;
                }
            }
        } catch (RuntimeException unused) {
            Log.e(CameraManager.TAG, "getCameraInfo RuntimeException");
        } catch (Exception unused2) {
            Log.e(CameraManager.TAG, "getCameraInfo Exception");
        }
        return 0;
    }
}
