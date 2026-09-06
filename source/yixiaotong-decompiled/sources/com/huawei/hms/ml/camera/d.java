package com.huawei.hms.ml.camera;

import android.hardware.Camera;
import android.os.AsyncTask;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: compiled from: CameraFocusManager.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class d implements Camera.AutoFocusCallback {
    public static final Set<String> g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f4130a;
    public Camera b;
    public AsyncTask<?, ?, ?> c;
    public boolean d = false;
    public boolean e = false;
    public int f = -1;

    /* JADX INFO: compiled from: CameraFocusManager.java */
    public static class a extends AsyncTask<Object, Object, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WeakReference<d> f4131a;

        public a(d dVar) {
            this.f4131a = new WeakReference<>(dVar);
        }

        @Override // android.os.AsyncTask
        public Object doInBackground(Object... objArr) {
            d dVar = this.f4131a.get();
            if (dVar == null) {
                return null;
            }
            dVar.d();
            try {
                Thread.sleep(dVar.c());
            } catch (InterruptedException unused) {
                Log.e(CameraManager.TAG, "CameraFocusManager::doInBackground InterruptedException");
            }
            return null;
        }
    }

    static {
        HashSet hashSet = new HashSet();
        g = hashSet;
        hashSet.add("auto");
        hashSet.add(CameraConfig.CAMERA_FOCUS_MACRO);
    }

    public d(Camera camera) {
        this.b = camera;
        boolean zContains = g.contains(camera.getParameters().getFocusMode());
        this.f4130a = zContains;
        Log.i(CameraManager.TAG, "CameraFocusManager useAutoFocus： " + zContains);
    }

    public synchronized void a(int i) {
        this.f = i;
    }

    public final synchronized int c() {
        return this.f;
    }

    public synchronized void d() {
        if (this.f4130a) {
            this.c = null;
            if (!this.d && !this.e) {
                try {
                    this.b.autoFocus(this);
                    this.e = true;
                } catch (RuntimeException e) {
                    Log.w(CameraManager.TAG, "Unexpected exception while focusing" + e.getMessage());
                    a();
                }
            }
        }
    }

    public final synchronized void b() {
        AsyncTask<?, ?, ?> asyncTask = this.c;
        if (asyncTask != null) {
            if (asyncTask.getStatus() != AsyncTask.Status.FINISHED) {
                this.c.cancel(true);
            }
            this.c = null;
        }
    }

    public synchronized void e() {
        this.d = true;
        if (this.f4130a) {
            b();
            try {
                this.b.cancelAutoFocus();
            } catch (RuntimeException e) {
                Log.w(CameraManager.TAG, "Unexpected exception while cancelling focusing" + e.getMessage());
            }
        }
    }

    @Override // android.hardware.Camera.AutoFocusCallback
    public synchronized void onAutoFocus(boolean z, Camera camera) {
        this.e = false;
        a();
    }

    public final synchronized void a() {
        if (!this.d && this.c == null) {
            a aVar = new a(this);
            try {
                aVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
                this.c = aVar;
            } catch (RejectedExecutionException e) {
                Log.w(CameraManager.TAG, "CameraFocusManager::autoFocusAgainLater RejectedExecutionException: " + e.getMessage());
            }
        }
    }
}
