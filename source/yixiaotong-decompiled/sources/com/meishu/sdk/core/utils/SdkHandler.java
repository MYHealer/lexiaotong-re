package com.meishu.sdk.core.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class SdkHandler {
    private static final Handler MAIN_HANDLER = new Handler(Looper.getMainLooper());
    private static final String TAG = "SdkHandler";
    private Handler mHandler;

    public static /* synthetic */ class a {
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final SdkHandler f4875a = new SdkHandler(null);
    }

    public /* synthetic */ SdkHandler(a aVar) {
        this();
    }

    public static SdkHandler getInstance() {
        return b.f4875a;
    }

    public static void runOnMainThread(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
            return;
        }
        Message messageObtain = Message.obtain(MAIN_HANDLER, runnable);
        try {
            messageObtain.setAsynchronous(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        messageObtain.sendToTarget();
    }

    public void postDelay(Runnable runnable, long j) {
        this.mHandler.postDelayed(runnable, j);
    }

    public void runOnUiThread(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            this.mHandler.post(runnable);
        }
    }

    private SdkHandler() {
        this.mHandler = new Handler(Looper.getMainLooper());
    }
}
