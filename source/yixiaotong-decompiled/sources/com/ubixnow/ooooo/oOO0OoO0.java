package com.ubixnow.ooooo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class oOO0OoO0 implements Runnable {
    private static final int OooO00o = 1;
    private oOO0Oo00 OooO0O0;
    private ExecutorService OooO0OO;
    private boolean OooO0Oo = false;

    public class OooO00o implements ThreadFactory {
        public OooO00o() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, oOO0OOO.OooO0O0);
        }
    }

    public class OooO0O0 implements Runnable {
        public OooO0O0() {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public oOO0OoO0() {
        try {
            this.OooO0O0 = oOO0Oo00.OooO00o();
            this.OooO0OO = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new OooO00o());
        } catch (Exception e) {
            oOO0O0O.OooO00o(e);
        }
    }

    public boolean OooO0O0() {
        return this.OooO0Oo;
    }

    public void OooO0OO() {
        this.OooO0Oo = true;
        if (this.OooO0O0.OooO0O0()) {
            this.OooO0O0.OooO00o(new OooO0O0());
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        while (!this.OooO0Oo) {
            try {
                this.OooO0OO.execute(this.OooO0O0.OooO0Oo());
            } catch (Exception e) {
                oOO0O0O.OooO00o(e);
                return;
            }
        }
        while (true) {
            Runnable runnableOooO0OO = this.OooO0O0.OooO0OO();
            if (runnableOooO0OO == null) {
                this.OooO0OO.shutdown();
                return;
            }
            this.OooO0OO.execute(runnableOooO0OO);
        }
    }
}
