package com.huawei.hms.mlplugin.card.bcr;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.huawei.hms.ml.common.utils.SmartLog;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: compiled from: DecodeThread.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class g extends Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CountDownLatch f4174a = new CountDownLatch(1);
    private final Handler b;
    private final Context c;
    private Handler d;
    private f e;

    public g(Context context, Handler handler) {
        this.b = handler;
        this.c = context;
    }

    public void a(f fVar) {
        this.e = fVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Looper.prepare();
        this.d = new e(this.c, this.b, this.e);
        this.f4174a.countDown();
        Looper.loop();
    }

    public Handler a() {
        try {
            this.f4174a.await();
        } catch (InterruptedException e) {
            SmartLog.e("DecodeThread", "InterruptedException e = " + e.getMessage());
        }
        return this.d;
    }
}
