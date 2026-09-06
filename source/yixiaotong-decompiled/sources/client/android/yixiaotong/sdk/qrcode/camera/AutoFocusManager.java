package client.android.yixiaotong.sdk.qrcode.camera;

import android.content.Context;
import android.hardware.Camera;
import android.os.AsyncTask;
import android.util.Log;
import com.huawei.hms.ml.camera.CameraConfig;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class AutoFocusManager implements Camera.AutoFocusCallback {
    private static final long AUTO_FOCUS_INTERVAL_MS = 1000;
    private static final Collection<String> FOCUS_MODES_CALLING_AF;
    private static final String TAG = "AutoFocusManager";
    private final Camera camera;
    private boolean focusing;
    private AsyncTask<?, ?, ?> outstandingTask;
    private boolean stopped;
    private final boolean useAutoFocus;

    /* JADX INFO: renamed from: client.android.yixiaotong.sdk.qrcode.camera.AutoFocusManager$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    static {
        ArrayList arrayList = new ArrayList(2);
        FOCUS_MODES_CALLING_AF = arrayList;
        arrayList.add("auto");
        arrayList.add(CameraConfig.CAMERA_FOCUS_MACRO);
    }

    public AutoFocusManager(Context context, Camera camera) {
        this.camera = camera;
        Camera.Parameters parameters = camera.getParameters();
        parameters.setZoom(camera.getParameters().getMaxZoom() / 2);
        camera.setParameters(parameters);
        String focusMode = camera.getParameters().getFocusMode();
        boolean zContains = FOCUS_MODES_CALLING_AF.contains(focusMode);
        this.useAutoFocus = zContains;
        Log.i(TAG, "Current focus mode '" + focusMode + "'; use auto focus? " + zContains);
        start();
    }

    @Override // android.hardware.Camera.AutoFocusCallback
    public synchronized void onAutoFocus(boolean z, Camera camera) {
        this.focusing = false;
        autoFocusAgainLater();
    }

    private synchronized void autoFocusAgainLater() {
        if (!this.stopped && this.outstandingTask == null) {
            AutoFocusTask autoFocusTask = new AutoFocusTask(this, null);
            try {
                autoFocusTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
                this.outstandingTask = autoFocusTask;
            } catch (RejectedExecutionException e) {
                Log.w(TAG, "Could not request auto focus", e);
            }
        }
    }

    public synchronized void start() {
        if (this.useAutoFocus) {
            this.outstandingTask = null;
            if (!this.stopped && !this.focusing) {
                try {
                    this.camera.autoFocus(this);
                    this.focusing = true;
                } catch (RuntimeException e) {
                    Log.w(TAG, "Unexpected exception while focusing", e);
                    autoFocusAgainLater();
                }
            }
        }
    }

    private synchronized void cancelOutstandingTask() {
        AsyncTask<?, ?, ?> asyncTask = this.outstandingTask;
        if (asyncTask != null) {
            if (asyncTask.getStatus() != AsyncTask.Status.FINISHED) {
                this.outstandingTask.cancel(true);
            }
            this.outstandingTask = null;
        }
    }

    public synchronized void stop() {
        this.stopped = true;
        if (this.useAutoFocus) {
            cancelOutstandingTask();
            try {
                this.camera.cancelAutoFocus();
            } catch (RuntimeException e) {
                Log.w(TAG, "Unexpected exception while cancelling focusing", e);
            }
        }
    }

    private final class AutoFocusTask extends AsyncTask<Object, Object, Object> {
        private AutoFocusTask() {
        }

        /* synthetic */ AutoFocusTask(AutoFocusManager autoFocusManager, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // android.os.AsyncTask
        protected Object doInBackground(Object... objArr) {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException unused) {
            }
            AutoFocusManager.this.start();
            return null;
        }
    }
}
