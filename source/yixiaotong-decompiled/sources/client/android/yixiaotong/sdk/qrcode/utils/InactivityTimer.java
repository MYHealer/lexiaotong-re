package client.android.yixiaotong.sdk.qrcode.utils;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.util.Log;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class InactivityTimer {
    private static final long INACTIVITY_DELAY_MS = 300000;
    private static final String TAG = "InactivityTimer";
    private Activity activity;
    private AsyncTask<Object, Object, Object> inactivityTask;
    private BroadcastReceiver powerStatusReceiver = new PowerStatusReceiver(this, null);
    private boolean registered = false;

    /* JADX INFO: renamed from: client.android.yixiaotong.sdk.qrcode.utils.InactivityTimer$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public InactivityTimer(Activity activity) {
        this.activity = activity;
        onActivity();
    }

    public synchronized void onActivity() {
        cancel();
        this.inactivityTask = new InactivityAsyncTask(this, null);
        this.inactivityTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
    }

    public synchronized void onPause() {
        cancel();
        if (this.registered) {
            this.activity.unregisterReceiver(this.powerStatusReceiver);
            this.registered = false;
        } else {
            Log.w(TAG, "PowerStatusReceiver was never registered?");
        }
    }

    public synchronized void onResume() {
        if (this.registered) {
            Log.w(TAG, "PowerStatusReceiver was already registered?");
        } else {
            this.activity.registerReceiver(this.powerStatusReceiver, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            this.registered = true;
        }
        onActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void cancel() {
        AsyncTask<Object, Object, Object> asyncTask = this.inactivityTask;
        if (asyncTask != null) {
            asyncTask.cancel(true);
            this.inactivityTask = null;
        }
    }

    public void shutdown() {
        cancel();
    }

    private class PowerStatusReceiver extends BroadcastReceiver {
        private PowerStatusReceiver() {
        }

        /* synthetic */ PowerStatusReceiver(InactivityTimer inactivityTimer, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
                if (intent.getIntExtra("plugged", -1) > 0) {
                    InactivityTimer.this.cancel();
                } else {
                    InactivityTimer.this.onActivity();
                }
            }
        }
    }

    private class InactivityAsyncTask extends AsyncTask<Object, Object, Object> {
        private InactivityAsyncTask() {
        }

        /* synthetic */ InactivityAsyncTask(InactivityTimer inactivityTimer, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // android.os.AsyncTask
        protected Object doInBackground(Object... objArr) {
            try {
                Thread.sleep(300000L);
                Log.i(InactivityTimer.TAG, "Finishing activity due to inactivity");
                InactivityTimer.this.activity.finish();
                return null;
            } catch (InterruptedException unused) {
                return null;
            }
        }
    }
}
