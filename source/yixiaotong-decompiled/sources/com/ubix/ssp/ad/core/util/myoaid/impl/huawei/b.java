package com.ubix.ssp.ad.core.util.myoaid.impl.huawei;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class b implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ThreadPoolExecutor f8595a = new ThreadPoolExecutor(0, 3, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(2048), new ThreadPoolExecutor.DiscardPolicy());
    boolean b = false;
    private final LinkedBlockingQueue<IBinder> c = new LinkedBlockingQueue<>(1);

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ IBinder f8596a;

        a(IBinder iBinder) {
            this.f8596a = iBinder;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Log.d("PPSSerivceConnection", "onServiceConnected " + System.currentTimeMillis());
                b.this.c.offer(this.f8596a);
            } catch (Throwable th) {
                Log.w("PPSSerivceConnection", "onServiceConnected  " + th.getClass().getSimpleName());
            }
        }
    }

    public IBinder a() {
        if (this.b) {
            throw new IllegalStateException();
        }
        this.b = true;
        return this.c.take();
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Log.d("PPSSerivceConnection", "onServiceConnected");
        f8595a.execute(new a(iBinder));
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        Log.d("PPSSerivceConnection", "onServiceDisconnected " + System.currentTimeMillis());
    }
}
