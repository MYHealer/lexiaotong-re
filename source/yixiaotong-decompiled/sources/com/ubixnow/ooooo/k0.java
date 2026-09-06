package com.ubixnow.ooooo;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class k0 implements ServiceConnection {
    public static final ThreadPoolExecutor OooO00o = new ThreadPoolExecutor(0, 3, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(2048), new ThreadPoolExecutor.DiscardPolicy());
    public boolean OooO0O0 = false;
    private final LinkedBlockingQueue<IBinder> OooO0OO = new LinkedBlockingQueue<>(1);

    public class OooO00o implements Runnable {
        public final /* synthetic */ IBinder OooO00o;

        public OooO00o(IBinder iBinder) {
            this.OooO00o = iBinder;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Log.d("PPSSerivceConnection", "onServiceConnected " + System.currentTimeMillis());
                k0.this.OooO0OO.offer(this.OooO00o);
            } catch (Throwable th) {
                Log.w("PPSSerivceConnection", "onServiceConnected  " + th.getClass().getSimpleName());
            }
        }
    }

    public IBinder OooO00o() throws InterruptedException {
        if (this.OooO0O0) {
            throw new IllegalStateException();
        }
        this.OooO0O0 = true;
        return this.OooO0OO.take();
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Log.d("PPSSerivceConnection", "onServiceConnected");
        OooO00o.execute(new OooO00o(iBinder));
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        Log.d("PPSSerivceConnection", "onServiceDisconnected " + System.currentTimeMillis());
    }
}
